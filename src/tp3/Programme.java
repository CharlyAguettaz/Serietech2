package tp3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Programme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection maCollection;
	
	public static void serialiser(Collection collection) {
		
		 File fichier =  new File("Liste.ser") ;
	        try {

	            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier));
	            oos.writeObject(collection);
	            oos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****************** \n");
		System.out.println("* Ma Serietheque * \n");
		System.out.println("****************** \n s : Statistiques \n l : Liste des séries \n d : Detail d'une série \n r : Rechercher \n a : Ajouter une série \n q : Quitter l'application \n Choisir une option :" );
		
			
			Collection maCollection = new Collection();
		
			Series x = new Series(87739, "Le Jeu de la dame");
			
			Saison s = new Saison();
			
			s.addEpisode(new Episode(1, 1, "Ouvertures", 60));
			s.addEpisode(new Episode(1, 2, "Échanges", 60));
			s.addEpisode(new Episode(1, 3, "Pions doublés", 60));
			s.addEpisode(new Episode(1, 4, "Milieu de jeu", 60));
			s.addEpisode(new Episode(1, 5, "Fourchette", 60));
			s.addEpisode(new Episode(1, 6, "Ajournement", 60));
			s.addEpisode(new Episode(1, 7, "Finale", 60));
			
			x.addSaison(s);
			maCollection.addSerie(x);
			
			// ------ Deuxième série
			x = new Series(76479, "The Boys");
			s = new Saison();
			s.addEpisode(new Episode(1, 1, "La Règle du jeu", 60));
			s.addEpisode(new Episode(1, 2, "Cerise", 60));
			s.addEpisode(new Episode(1, 3, "Prends ça", 60));
			s.addEpisode(new Episode(1, 4, "La Fille", 60));
			s.addEpisode(new Episode(1, 5, "Des bleus à l'âme", 60));
			s.addEpisode(new Episode(1, 6, "Les Innocents", 60));
			s.addEpisode(new Episode(1, 7, "Question de survie", 60));
			s.addEpisode(new Episode(1, 8, "On ne prend plus de gants", 60));
			x.addSaison(s);
			
			s = new Saison();
			s.addEpisode(new Episode(1, 1, "Comme à la fête foraine", 60));
			s.addEpisode(new Episode(1, 2, "Préparation propre et planification", 60));
			s.addEpisode(new Episode(1, 3, "La Charge de la brigade légère", 60));
			s.addEpisode(new Episode(1, 4, "Rien de tel dans le monde entier", 60));
			s.addEpisode(new Episode(1, 5, "Quand faut y aller, faut y aller", 60));
			s.addEpisode(new Episode(1, 6, "On ne prend plus de gants", 60));
			s.addEpisode(new Episode(1, 7, "Le Fils du boulanger", 60));
			s.addEpisode(new Episode(1, 8, "Les Innocents", 60));
			x.addSaison(s);
			
			maCollection.addSerie(x);
			
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			
			while (option.equals("s") || option.equals("l") || option.equals("d") || option.equals("a") || option.equals("r")) {
				switch (option) {
				
				case "s" :
					System.out.println(maCollection.toString());
					break;
				case "l" :
					for (int i = 0; i< maCollection.getNbSeries(); i++) {
						System.out.println(maCollection.getSeries().get(i).getId() + " : " + maCollection.getSeries().get(i).getTitre());
					}
					break;
				case "d" :
					
					 try {
						 System.out.println("Quel est l'Id de la série ?");
							Scanner scanner2 = new Scanner(System.in);
							int id = scanner2.nextInt();
							System.out.println(maCollection.getSerie(id).toString());
				        } catch (IllegalArgumentException e) {
				            e.printStackTrace();
				        }
					
					break;
					
					
				case "r" :
					System.out.println("Quel est le nom de la série ?");
					Scanner scanner3 = new Scanner(System.in);
					String nom = scanner3.nextLine();
					System.out.println(maCollection.getSerieByName(nom).toString());
					break;
				case "a" :
					System.out.println("Quel est le nom de la série à ajouter?");
					Scanner scanner4 = new Scanner(System.in);
					String titre = scanner4.nextLine();
					System.out.println("Quel est l'id de la série à ajouter?");
					Scanner scanner5 = new Scanner(System.in);
					int id2 = scanner5.nextInt();
					x = new Series(id2,titre);
					maCollection.addSerie(x);
					break;
				}
				option = scanner.nextLine();
				
			//quitter l'application
		}
		
		System.out.println("Bye");
		serialiser(maCollection);
	}
	
}


