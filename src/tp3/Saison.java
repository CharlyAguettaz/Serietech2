package tp3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Saison implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Episode> listeEpisodes;

	public Saison() {
		
		 ArrayList<Episode> listeEpisodes = new ArrayList<Episode>();
	     this.listeEpisodes = listeEpisodes;
	
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
	
	public void addEpisode(Episode episode) {
		
		listeEpisodes.add(episode);
		
	}
	
	public int getDureeTotale() {
		
		int dureeTotale = 0;
		
		for(int i=0; i<listeEpisodes.size(); i++) {
			dureeTotale += listeEpisodes.get(i).getDuree();
		}
		
		return dureeTotale;
	}
	
	public int getNbEpisodes() {
		
			int nbEpisodes = listeEpisodes.size();	
		
		return nbEpisodes;
	}

	@Override
	public String toString() {
		
		String saison="Episodes : \n";
		
		for(int i=0; i<listeEpisodes.size(); i++) {
			saison += listeEpisodes.get(i).toString() + "\n";
		}
		
		return saison;
	}
	
	
	
	

}
