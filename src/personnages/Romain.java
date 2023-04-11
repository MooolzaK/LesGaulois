package personnages;

public class Romain {
	private String nom;
	private int force;
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
		String ls = "Le soldat ";
		switch (this.nbEquipement) {
			case 2 :
				System.out.println(ls + this.nom + "est déjà bien protégé !");
				break;
			case 1 :
				if (stuff == this.equipements[0]) {
					System.out.println(ls + this.nom + " possède déjà un " + stuff.toString());
					}
				break;
			default :
				this.equipements[nbEquipement] = stuff;
				this.nbEquipement ++;
				System.out.println(ls + this.nom + " s'équipe avec un " +  stuff.toString() + " !");
				break;
                
			}
		}

	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	/* public void recevoirCoup(int forceCoup) {
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
	*/
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
					for (int i = 0; i < nbEquipement;) {
						if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
							resistanceEquipement += 8;
						} else {
							System.out.println("Equipement casque");
							resistanceEquipement += 5;
						}
						i++;
					}
			texte += resistanceEquipement + "!";
			}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
		return equipementEjecte;
		}

		
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
	//  précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
	//  if (force > 0) {
	//  	parler("Aïe");
	//  } else {
	//  	parler("J'abandonne...");
	//  }
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
	//  post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
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
