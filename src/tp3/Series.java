package tp3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Series implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String titre;
	private ArrayList<Saison> listeSaisons;
	
	public Series(int id, String titre) {
		
		ArrayList<Saison> listeSaisons = new ArrayList<Saison>();
		this.listeSaisons = listeSaisons;
		this.id = id;
		this.titre = titre;
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
	
public Series() {
		ArrayList<Saison> listeSaisons = new ArrayList<Saison>();
		this.listeSaisons = listeSaisons;
	}
public void addSaison(Saison saison) {
	
		listeSaisons.add(saison);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDureeTotale() {
		
	int dureeTotale = 0;
		
		for(int i=0; i<listeSaisons.size(); i++) {
			dureeTotale += listeSaisons.get(i).getDureeTotale();
		}
		
		return dureeTotale;
	}
	
	
	public int getNbEpisodes() {
		
		int nbEpisodes = 0;
		
		for (int i=0; i<listeSaisons.size(); i++) {
			
			nbEpisodes += listeSaisons.get(i).getNbEpisodes();
		}
		
		return nbEpisodes;
	}
	
	public int getNbSaisons() {
		
		int nbSaisons = listeSaisons.size();
		
		return nbSaisons;
	}

	@Override
	public String toString() {
		
		String serie = "";
		
		serie += "Id : " + this.id + "\n";
		serie += "Titre : " + this.titre + "\n";
		serie += "Duree : " + this.getDureeTotale() + "\n";
		serie += "Nb Saisons : " + this.getNbSaisons() + "\n";
		serie += "Nb Episodes : " + this.getNbEpisodes() + "\n";
		
		for(int i=0; i<listeSaisons.size(); i++) {
			
			serie += listeSaisons.get(i).toString() + "\n";
			
		}
		
		return serie;
	}
	
	
	
}
