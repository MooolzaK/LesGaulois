package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois;
	private Gaulois[] villageois;
	private int nbVillageoisMaximum;
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.villageois =  new Gaulois[nbVillageoisMaximum];
		this.nbVillageoisMaximum = nbVillageoisMaximum;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		if (this.nbVillageois < this.nbVillageoisMaximum) {
			this.villageois[nbVillageois] = habitant;
			this.nbVillageois ++;
		}
	}
	
	public String afficherVillageois() {
		String phrase = "Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :\n";
		int i;
		for (i=0; i < this.nbVillageois; i++) {phrase += "-" + this.trouverHabitant(i+1).getNom() +"\n";}
		return phrase;
		}

	
	public Gaulois trouverHabitant(int num) {
		return this.villageois[num-1];
	}
	
	public static void main(String args[]) {
		Village vilir = new Village("Village des Irréductibles",30);
		// Gaulois gaulois = vilir.trouverHabitant(30);
		// Marche pas parceque 30 est le nombre max d'habitants donc le dernier habitant est le 29 et il n'y a aucun habitants pour l'instant
		Chef chef = new Chef("Abraracourcix",6,vilir);
		vilir.setChef(chef);
		Gaulois gaulois = new Gaulois("Asterix", 8);
		vilir.ajouterHabitant(gaulois);
		//Gaulois gg = vilir.trouverHabitant(1);
		//System.out.println(gg);
		System.out.println(vilir.afficherVillageois());
	}
}
