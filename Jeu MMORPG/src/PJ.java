import java.util.*;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("cda14d46-3301-43ad-919f-6cdc775fe9f6")
public class PJ extends Personnage {
    //@objid ("e28f7d7f-a116-41d5-9225-9daa4a65642e")
    private int PA;

    //@objid ("97293656-c3be-451c-8088-47735e01abd8")
    private Caracteristiques car;

    //@objid ("2a795191-5c42-4cd5-8641-93c88a1af3d7")
    private Equipement equipement;

    //@objid ("40059568-642b-4065-b7e6-4242d1bdf19c")
    public PJ() {
        super();
        setPX(100);
        equipement = new Equipement();
        PA = 100;
    }

    //@objid ("279095ac-312c-46d9-bc3b-3788e2496757")
    public void creerPerso() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creation du Personnage...\n");
        
        System.out.println("Quelle est le nom du personnage ? :");
        String input = scan.next();
        while (input.length() > 20) {
            System.out.println("Le nom de votre personnage est trop long !");
            input = scan.next();
        }
        setNom(input);
        
        System.out.println("Vous avez 18 pts de degres a attribuer dans les 3 caracteristiques suivantes : force,adresse,resistance.");
        System.out.println("Force :");
        int force = attributionValide();
        System.out.println("Adresse :");
        int adresse = attributionValide();
        System.out.println("Resistance :");
        int resistance = attributionValide();
        int total = force + adresse + resistance;
        
        while (total != 18) {
            System.out.println("Le total de pts attribue n'est pas egal a 18\nVeuillez ressaisir les pts a attribuer.");
            System.out.println("Force :");
            force = attributionValide();
            System.out.println("Adrrese :");
            adresse = attributionValide();
            System.out.println("Resistance :");
            resistance = attributionValide();
            total = force + adresse + resistance;
        }
        
        car = new Caracteristiques(force, adresse, resistance);
        setCap(new Capacite(this));
    }

    //@objid ("593d88cc-ec35-42e1-8219-25f7cdeb8731")
    public void etatPerso() {
        System.out.println("Caracteristiques de votre personnage :");
        System.out.println(car.toString());
        System.out.println(getCap().toString());
        checketat();
    }

    //@objid ("e9d2cc74-4d81-4caa-b465-54521b3e805f")
    public int attributionValide() {
        Scanner scan = new Scanner(System.in);
        int entier = scan.nextInt();
        while (entier < 0 || entier > 18) {
            System.out.println("Veuillez entrer un entier valide (0 a 18)");
            entier = scan.nextInt();
        }
        return entier;
    }

    //@objid ("4b473caa-a71a-4c8a-9e8a-ffe5da72439a")
    public void attribuerCar() {
    }

    //@objid ("6e9a432e-9707-46c8-84ac-00f325bc6573")
    public void gagnePX(Personnage perso) {
        float PX1 = getPX();
        float PX2 = perso.getPX();
        int PXgagne = (int)((PX2 / PX1) * ((0.25) * PX2));
        setPX(getPX() + PXgagne); 
        System.out.println("Vous avez recu " + PXgagne + " PX !");
    }

    //@objid ("b35348bf-4b23-4d6d-9245-4ad47ce0b22a")
    public void ramasser(Cellule cel) {
        PA -= 2;
        InfoCase infocase = cel.getInfoCase();
        Objet obj = infocase.getObjet();
        for(int i = 0; i < infocase.getQuantite(); i++) {
            getInventaire().add(obj);
        }
        infocase.setCellule(null);
        cel.setInfoCase(null);
        obj.setInfoCase(null);
        System.out.println("Vous avez ramasse " + infocase.getQuantite() + " "+ obj.getNom());
    }

    //@objid ("a1b6cd01-20a2-42f2-bd75-636f84355d15")
    public void utiliserObjet() {
        List<Objet> inventaire = getInventaire();
        Scanner scan = new Scanner(System.in);
        
        ouvrirSac();
        int num = scan.nextInt();
        while (num < 0 || num >= inventaire.size()) {
            System.out.println("Entrer un numero valide !");
            num = scan.nextInt();
        }
        
        Objet obj = inventaire.get(num);
        
        if (obj instanceof Equipable) {
        	Equipable equip = (Equipable) obj;
            equip.utiliser(equipement, equip, inventaire);
            PA -= 2;
        }
        else {
            Consommable cons = (Consommable) obj;
            cons.utiliser(this);
            return;
        }
        inventaire.remove(num);
        System.out.println("Objet Utilise !");
    }

    //@objid ("4b9306ea-6f97-4071-a471-bb19f93ba267")
    public void deposerObjet() {
    }

    //@objid ("c110a1c9-7aab-4386-a4d6-cbf701592403")
    public void desequiper() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Desequiper quel partie du corps ? (tete,haut,bas,gauche,droite)");
    	String input = scan.next();
    	List<Objet> inventaire = getInventaire();
    	while (!input.equals("tete") && !input.equals("haut") && !input.equals("bas") && !input.equals("gauche") && !input.equals("droite")) {
    		System.out.println("Entree invalide ! (tete,haut,bas,gauche,droite)");
    		input = scan.next();
    	}
    	
    	if (input.equals("tete")) {
    		if (equipement.getTete() == null) {
    			System.out.println("Vous ne pouvez pas desequiper rien du tout !");
    			return;
    		}
    		else {
    			inventaire.add(equipement.getTete());
    			equipement.setTete(null);
    		}	
    	}
    	else if (input.equals("haut")) {
    		if (equipement.getHaut() == null) {
    			System.out.println("Vous ne pouvez pas desequiper rien du tout !");
    			return;
    		}
    		else {
    			inventaire.add(equipement.getHaut());
    			equipement.setHaut(null);
    		}	
    	}
    	else if (input.equals("bas")) {
    		if (equipement.getBas() == null) {
    			System.out.println("Vous ne pouvez pas desequiper rien du tout !");
    			return;
    		}
    		else {
    			inventaire.add(equipement.getBas());
    			equipement.setBas(null);
    		}	
    	}
    	else if (input.equals("gauche")) {
    		if (equipement.getMainGauche() == null) {
    			System.out.println("Vous ne pouvez pas desequiper rien du tout !");
    			return;
    		}
    		else {
    			inventaire.add(equipement.getMainGauche());
    			equipement.setMainGauche(null);
    		}	
    	}
    	else {
    		if (equipement.getMainDroite() == null) {
    			System.out.println("Vous ne pouvez pas desequiper rien du tout !");
    			return;
    		}
    		else {
    			inventaire.add(equipement.getMainDroite());
    			equipement.setMainDroite(null);
    		}	
    	}
    	PA -= 2;
    	System.out.println("Equipement desequipe !");
    	
    }

    //@objid ("2c557523-54de-41cd-aa88-ceb6972e5e55")
    public void sauvegarder() {
    }

    //@objid ("74ea412b-d756-416a-ac19-f90ef91608ba")
    public void charger() {
    }

    //@objid ("14413067-802f-4740-b7a7-0c045d2ad8bc")
    public void ouvrirSac() {
        System.out.println("Inventaire :");
        String inv = "";
        for (Objet obj : getInventaire()) {
            inv += obj.toString() + "\n";
        }
        if (inv.equals(""))
            System.out.println("Vide !");
        else
            System.out.print(inv);
    }

    //@objid ("cd36178f-9974-4781-ab9a-0b999b60d300")
    public void voirEquipement() {
        System.out.println("Equipement :");
        String listeEquip = "";
        Equipement equip = equipement;
        List<Armure> armure = new ArrayList<Armure>(Arrays.asList(equip.getTete(),equip.getHaut(),equip.getBas()));
        for (Armure def : armure) {
            if (def != null) {
                listeEquip += def.toString() + "\n";
            }
        }
        List<Arme> arme = new ArrayList<Arme>(Arrays.asList(equip.getMainGauche(),equip.getMainDroite()));
        for (Arme att : arme) {
            if (att != null) {
                listeEquip += att.toString() + "\n";
            }
        }
        if (listeEquip.equals(""))
            System.out.println("Aucun equipement");
        else
            System.out.print(listeEquip);
    }

    //@objid ("172e6363-5548-4206-9b8b-48a97d23d0a5")
    public void attaquer(Personnage perso) {
        if (PA < 3) {
            System.out.println("Vous n'avez pas assez de points d'action !");
        }
        else {
            PA -= 3;
            Arme choixArme = choixMain();
            int scoreAttaque1 = 0;
            int scoreEsquive2 = perso.getCap().getEsquive().lancerDes();
            if (choixArme == null) 
                scoreAttaque1 += getCap().getAttaque().lancerDes();
            else 
                scoreAttaque1 += getCap().getAttaque().somme(choixArme.getManiabilite()).lancerDes();
            System.out.println("Attaque : " + scoreAttaque1);
            System.out.println("Esquive : " + scoreEsquive2);
            if ( scoreAttaque1 > scoreEsquive2 ) {
                System.out.println("Attaque reussi !");
                setPX(getPX() + 1);
                blesser(perso,choixArme);
            }
            else {
                System.out.println("Echoue");
            }
        }
    }

    //@objid ("bbbd95dd-f80d-468a-8922-f072514ed7d0")
    public void blesser(Personnage perso, Arme choixarme) {
        int scoreDegats1  = 0;
        int scoreDefense2 = perso.getCap().getDefense().lancerDes();
        if (choixarme == null) 
            scoreDegats1 += getCap().getDegats().lancerDes();
        else 
            scoreDegats1 += getCap().getDegats().somme(choixarme.getImpact()).lancerDes();
        System.out.println("Degats : " + scoreDegats1);
        System.out.println("Defense : " + scoreDefense2);
        if ( scoreDegats1 > scoreDefense2 ) {
            perso.setEtat( perso.getEtat() - ( scoreDegats1 - scoreDefense2) / 3);
            perso.checketat();
            if (perso.getEtat() == 0) 
                gagnePX(perso);
        }
        else {
            System.out.println("Echoue");
        }
    }

    //@objid ("57dfd35d-5d1e-46c0-b50d-b88ca6f555a4")
    public Arme choixMain() {
        Arme mainG = getEquipement().getMainGauche();
        Arme mainD = getEquipement().getMainDroite();
        if (mainG != null && mainD != null) {
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            
            while (!input.equals("gauche") && !input.equals("droite")) {
                System.out.println("Entree invalide ! (droite,gauche)");
                input = scan.next();
            }
            if (input.equals("droite")) {
                return mainD;
            }
            else
                return mainG;
        }
        else if (mainG != null && mainD == null)
            return mainG;
        else if (mainG == null && mainD != null)
            return mainD;
        else {
            return null;
        }
    }

    //@objid ("b3701eb0-3ce6-4c4f-84f9-f24a64232e5e")
    public void checketat() {
        int etat = getEtat();
        if (etat == 6)
            System.out.println("Votre niveau de blessure est : Normal");
        else if (etat == 5)
            System.out.println("Votre niveau de blessure est : Blessures superficielles");
        else if (etat == 4)
            System.out.println("Votre niveau de blessure est : Legerement blesse");
        else if (etat == 3)
            System.out.println("Votre niveau de blessure est : Blesse");
        else if (etat == 2)
            System.out.println("Votre niveau de blessure est : Gravement blesse");
        else if (etat == 1)
            System.out.println("Votre niveau de blessure est : Inconscient");
        else
            System.out.println("Votre niveau de blessure est : Mort");
    }

    //@objid ("84b59bd0-15e1-49fe-8e4f-5dac00ebb5f3")
    public void consulterLog() {
    }

    //@objid ("e80ea6dc-2f17-45b0-a765-d754932ce515")
    public void envoyerMsg() {
    }

    //@objid ("00ab2e18-8be0-4ddb-8bf5-61a4408dfc96")
    Equipement getEquipement() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.equipement;
    }

    //@objid ("a7cf3d81-44b9-4bcc-b4ec-8b0c08cf928d")
    void setEquipement(Equipement value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.equipement = value;
    }

    //@objid ("a19c9364-12da-40b9-bac4-9b2ec8f9973e")
    Caracteristiques getCar() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.car;
    }

    //@objid ("837813d1-24d1-4ea6-9d24-2c8ce7771a2a")
    void setCar(Caracteristiques value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.car = value;
    }

    //@objid ("225a40ef-3137-484c-8bac-9438c4169676")
    int getPA() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.PA;
    }

    //@objid ("6dc3dd36-871c-4397-a126-a5df27479133")
    void setPA(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.PA = value;
    }

}
