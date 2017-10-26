package com.corax.transformations.autoadjust;

import java.awt.image.WritableRaster;

import com.corax.transformations.TransformationUtils;

class AutoAdjust implements IAutoAdjust {

	@Override
	public WritableRaster autoAdjust(WritableRaster source, float percent) {
		
		if (source == null || percent < 0.0f) {
			throw new IllegalArgumentException();
		}
		
		WritableRaster target = source.createCompatibleWritableRaster();
		
		int rgb[] = new int[3];
		int histo[] = new int[256];
		
		// Automatsko podesavanje u programima za obradu slike obicno
		// podrazumijeva neku vrstu heuristike za "rastezanje" kontrasta
		// prema histogramu. Ako je slika previse tamna, to ce se vidjeti
		// na njenom histogramu (vecina piksela ce biti u nizim nivoima),
		// sto cemo onda detektovati i znati da sliku treba posvijetliti
		// i za koliko.
		
		// Nasa heuristika ce raditi tako sto cemo se odluciti koliko smo
		// piksela spremni da "zrtvujemo" u tamnim i u svijetlim dijelovima,
		// jer ce nakon ove operacije takvi izaci iz opsega i postati ili 0
		// ili 255. Za ovaj primjer, uzimamo 0.005 ili 0.5%.
		double cutOff = percent/100.0f;
		
		// Izracunavamo histogram slike, kao u prethodnom primjeru
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				source.getPixel(x, y, rgb);
				int i = (int)(rgb[0] * 0.30 + rgb[1] * 0.59 + rgb[2] * 0.11);		
				histo[i]++;
			}
		}
		
		// Na osnovu dimenzija slike i procenta - koliko je to tacno piksela?
		int cap = (int)((source.getWidth() * source.getHeight()) * cutOff);
		
		// Ogranicenja, koji dio histograma cemo da "odrezemo", pocinjemo sa
		// 0 i 255, sto znaci da uzimamo citav opseg, tj. nista se ne mijenja.
		int leftBound = 0, rightBound = 255;
		
		int sum = histo[0];
		
		// Krecemo se korak po korak kroz histogram, polazeci od najtamnijeg
		for(int i = 1; i < 255; i++)
		{
			// Dodajemo piksele iz tog slota histograma na sumu
			sum += histo[i];
			
			// I pratimo kada smo prekoracili dozvoljeni broj piksela za odbacivanje
			if(sum >= cap)
			{
				// To nam odredjuje granicu sa lijeve/tamne strane
				leftBound = i - 1;
				break;
			}
		}
		
		// Istu proceduru ponavljamo sa desne/svijetle strane, ponovo idemo
		// korak po korak, od najsvjetlije nijanse prema tamnijim i pratimo
		// kada ce to eliminisati vise od dozvoljenog broja piksela.
		sum = histo[255];
		
		for(int i = 254; i >= 0; i--)
		{
			sum += histo[i];
			if(sum >= cap)
			{
				rightBound = i + 1;
				break;
			}
		}
		
		// Radi kontrole, ispisujemo za koji smo se opseg odlucili. Sada taj
		// smanjeni opseg svjetlina treba "rastegnuti" na puni 0-255 opseg.
//		System.out.println("Range: " + leftBound + " -> " + rightBound);
	
		// Pronaci cemo faktor kojim trebamo pomnoziti vrijednosti iz smanjenog
		// opsega da bi one dostigla punu 0-255 velicinu.
		double scale = 255.0 / (rightBound - leftBound);
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				source.getPixel(x, y, rgb);
				
				// Vrijednosti svakog piksela prvo pomijeramo lijevo (zamisljajuci
				// histogram) za leftBound, kako bi najmanja vrijednost iz
				// pronadjenog opsega sada postala nula, a zatim to jos skaliramo
				// izracunatim faktorom, kako bi ona najveca mogla da postane 255.
				rgb[0] = TransformationUtils.saturate((int)((rgb[0] - leftBound) * scale));
				rgb[1] = TransformationUtils.saturate((int)((rgb[1] - leftBound) * scale));	
				rgb[2] = TransformationUtils.saturate((int)((rgb[2] - leftBound) * scale));	
				target.setPixel(x, y, rgb);
				
				//   0  bound       bound     255
				//   |----L===========R--------|
				//       /              \
				//      /                 \    
				//     /                    \
				//    / (X - lBound) * scale  \
				//   |=========================|
				//   0                        255
			}
		}
		return target;
		
	}
	
	
	
}
