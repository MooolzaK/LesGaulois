package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois" + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees2 = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophees2 != null && i < trophees2.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees2[i];
		}
	}

	

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		//TODO
	}
	
	
	
}
