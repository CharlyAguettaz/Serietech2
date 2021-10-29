package tp3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Episode implements Serializable {
	
	private static final long serialVersionUID = 6L;
	private int numero;
	private int numeroSaison;
	private int duree;
	private String titre;
	
	
	public Episode( int numeroSaison, int numero, String titre, int duree) {
		this.numero = numero;
		this.numeroSaison = numeroSaison;
		this.duree = duree;
		this.titre = titre;
	}

	

	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	@Override
	public String toString() {
		return "S" + this.numeroSaison + "E" + this.numero + " : " + this.titre;
	}
	
	
	

}
