package tp3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Collection implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Series> listeSeries;
	
	public Collection() {
		
		this.listeSeries = new ArrayList<Series>();
		
	}
	
	public static void serialiser(Collection collection) {
		
		 File fichier =  new File("Collection.ser") ;
	        try {

	            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier));
	            oos.writeObject(collection);
	            oos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	public void addSerie(Series serie) {
		
		listeSeries.add(serie);
		
	}
	
	public int getDureeTotale() {
		
		int dureeTotale = 0;
		
		for (int i = 0; i< listeSeries.size(); i++) {
			
			dureeTotale += listeSeries.get(i).getDureeTotale();
			
		}
		
		return dureeTotale;
		
	}
	
	public int getNbEpisodes() {
		
		int nbEpisodes = 0;
		
		for (int i = 0; i< listeSeries.size(); i++) {
			
			nbEpisodes += listeSeries.get(i).getNbEpisodes();
			
		}
		
		return nbEpisodes;
	}
	
	public int getNbSeries() {
	
		int nbSeries = listeSeries.size();
		
		return nbSeries;
	}
	
	
	public Series getSerie(int id){
		
		Series serie = new Series();
		
		
		for (int i = 0; i<listeSeries.size(); i++) {
			
			if (listeSeries.get(i).getId() == id) {
				
				serie = listeSeries.get(i);
			}
		}

		
		return serie;
		
	}
	
public Series getSerieByName(String name) {
		
		Series serie = new Series();
		
		for (int i = 0; i<listeSeries.size(); i++) {
			
			if (listeSeries.get(i).getTitre() == name) {
				serie = listeSeries.get(i);
			}
		}
		
		return serie;
		
	}
	
	public ArrayList<Series> getSeries(){
		
		return this.listeSeries;
		
	}

	@Override
	public String toString() {
		
		String collection = "Statistiques : \n";
			
			collection += "Nombre de Séries : " + this.getNbSeries() + "\n";
			collection += "Nombre de Saisons : " + this.getNbEpisodes() + "\n";
			collection += "Durée Totale  : " + this.getDureeTotale() + "\n";
		
		
		return collection;
	}
	
	
	
	
	
}
