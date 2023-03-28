package personnages;

public class Romain {
	private String nom;
	private int force;
	private int force1;
	private int force2;
	private Equipement[] equipements;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(this.force>=0):"Invalider user force";
		this.nbEquipement = 0;
		this.equipements = new Equipement[2];
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	public void sEquiper(Equipement stuff) {
		switch (this.nbEquipement) {
			case 2 : 
				System.out.println("Le soldat " + this.nom + "est déjà bien protégé !");
				break;
			case 1 :
				if (stuff == this.equipements[0]) {
					System.out.println("Le soldat " + this.nom + " possède déjà un " + stuff.toString());
					break;}
			default :
				this.equipements[nbEquipement] = stuff;
				this.nbEquipement ++;
				System.out.println("Le soldat " + this.nom + " s'équipe avec un " +  stuff.toString() + " !");
				break;
				
			}
		}

	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(this.force>0):"invalide force entry";
		force1 = force;
		force -= forceCoup;
		force2 = force;
		assert(force1>force2):"post-condition";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Je suis Minus !");
		minus.recevoirCoup(9);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		
		
		}

}
