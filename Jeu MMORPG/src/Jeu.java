import java.util.*;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("11b7784b-fc14-4c3c-a1c5-bd7778f092e7")
public class Jeu {
    //@objid ("b3ea6050-e1e6-4e0c-a896-8d7b063c14ed")
    private Plateau plateau;

    //@objid ("dfcf4c3f-8a2c-4172-b746-1a002a31aa96")
    private PJ personnage;

    //@objid ("0546f356-cbbc-45e1-b30d-8076fd383d3b")
    public Jeu() {
        plateau = new Plateau();
        personnage = null;
    }

    //@objid ("3ea4f3e6-ee7f-409a-9263-57734048b013")
    public void init() {
        System.out.println("Initialisation de la partie...\n");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Creer ou Charger un plateau ? (creer,charger) :");
        String input = scan.next();
        while ( !input.equals("creer") && !input.equals("charger") ) {
            System.out.println("Entree invalide ! Veuillez choisir entre (creer,charger) :");
            input = scan.next();
        }
        
        if (input.equals("charger")) {
            chargerPlateau();
            
            //Montrer la liste des plateau envisageable
        }
        else {
            creerPlateau();
            
            //Plateau a taille modifiable envisageable
        }
        menu();
    }

    //@objid ("9eb1089a-1131-4a0e-bde8-df883439d2b5")
    public void menu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Creer/Charger/Sauvegarder un plateau ou choisir/creer un nouveau personnage ou jouer ? (creer,charger,sauvegarder,choisir,nouveau,jouer) :");
        String input = scan.next();
        while ( !input.equals("creer") && !input.equals("charger") && !input.equals("sauvegarder") && !input.equals("choisir") && !input.equals("nouveau") && !input.equals("jouer")) {
            System.out.println("Entree invalide ! Veuillez choisir entre (creer,charger,choisir,nouveau,jouer) :");
            input = scan.next();
        }
        
        if (input.equals("charger")) 
            chargerPlateau();
        else if (input.equals("creer")) 
            creerPlateau();
        else if (input.equals("sauvegarder"))
        	plateau.sauvegarder("monde1.ser");
        else if (input.equals("nouveau")) {
            creerPersonnage();
        }
        else if (input.equals("choisir")) {
            System.out.println("Veuillez taper le nom du personnage");
            input = scan.next();
            chargerPersonnage(input);
        }
        else {
            if (personnage == null)
                System.out.println("Vous n'avez pas de personnage choisi !");
            else {
                System.out.println("Debut de la partie...");
                jouer();
            }
        }
        menu();
    }

    //@objid ("df77928e-2e33-4f8b-ba97-0aeeecf574a9")
    public void jouer() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nSe deplacer, attaquer, ramasser ? (deplacer,attaquer,use,desequiper,ramasser,sac,equipement,carte,menu)");
        
        System.out.println("Vous avez " + personnage.getPA() + " PA");
        
        String input = scan.next();
        
        while ( !input.equals("deplacer") && !input.equals("attaquer") && !input.equals("use") && !input.equals("desequiper") && !input.equals("ramasser") && !input.equals("sac") && !input.equals("equipement") && !input.equals("carte") && !input.equals("menu") ) {
            System.out.println("Entree invalide ! Veuillez choisir entre (deplacer,attaquer,use,desequiper,ramasser,sac,equipement,carte,menu) :");
            input = scan.next();
        }
        if (input.equals("deplacer")) {
            System.out.println("A quel emplacement ?");
            System.out.print("abscisse : ");
            int abs = scan.nextInt();
            System.out.print("ordonnee : ");
            int ord = scan.nextInt();
            deplacerPersonnage(abs,ord);
        }
        else if (input.equals("attaquer"))
            attaquer();
        else if (input.equals("use"))
        	personnage.utiliserObjet();
        else if (input.equals("desequiper"))
        	personnage.desequiper();
        else if (input.equals("ramasser"))
            ramasser();
        else if (input.equals("sac"))
            personnage.ouvrirSac();
        else if (input.equals("equipement"))
            personnage.voirEquipement();
        else if (input.equals("carte"))
            plateau.afficherPerso(personnage);
        else if (input.equals("menu"))
        	menu();
        jouer();
    }

    //@objid ("0adbc41c-0158-4ca9-bb1c-986a6bf5dd5e")
    public void chargerPersonnage(String nom) {
        for ( Cellule c : plateau.getCellules()) {
            if ( c.getPersonnage() != null && c.getPersonnage().getNom().equals(nom)) {
                personnage = (PJ) c.getPersonnage();
                System.out.println("Personnage charge !");
                return;
            }
        }
        System.out.println("Ce personnage n'existe pas dans ce monde.");
    }

    //@objid ("927047f8-6c80-45dd-90e3-47776db269e5")
    public void creerPlateau() {
        plateau = new Plateau();
        plateau.genererMonstre();
        plateau.genererObjet();
        System.out.println("Plateau creer !");
        plateau.afficher();
    }

    //@objid ("0cd2aa6e-b246-4c5e-93cf-d1026876e640")
    public void chargerPlateau() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quel est le nom du fichier contenant le plateau ? (sans l'extension) :");
        String input = scan.next();
        plateau.charger(input += ".ser");
    }

    //@objid ("f9cf8a2e-2a65-4cba-8714-edb8205185ea")
    public void creerPersonnage() {
        personnage = new PJ();
        personnage.creerPerso();
        List<Integer> celluleLibre = new ArrayList<Integer>();
        for (int i = 0; i < plateau.getCellules().size(); i++) {
            if (plateau.getCellules().get(i).estVide()) {
                celluleLibre.add(i);
            }
        }
        int nbCelluleLibre = celluleLibre.size();
        int celluleSpawn = (int)(Math.random() * nbCelluleLibre);
        Cellule spawn = plateau.getCellules().get(celluleSpawn);
        spawn.setPersonnage(personnage);;
        personnage.setCellule(spawn);
        personnage.etatPerso();
        plateau.afficher();
    }

    //@objid ("3b83f9b2-920f-493a-8486-75e487b8cdd7")
    public void deplacerPersonnage(int abscisse, int ordonnee) {
    	if( personnage.getPA() < (Math.abs(abscisse) + Math.abs(ordonnee)) * 2 ) {
    		System.out.println("Vous n'avez pas assez de points d'action !");
    	}
    	else {
    		personnage.setPA(personnage.getPA() - (Math.abs(abscisse) + Math.abs(ordonnee)) * 2);
    		int abs = personnage.getCellule().getAbscisse() + abscisse;
	        int ord = personnage.getCellule().getOrdonnee() - ordonnee;
	        Cellule oldEmplacement = personnage.getCellule();
	        if (plateau.celluleValide(new Cellule(abs,ord))) {
	            Cellule newEmplacement = plateau.getCellules().get(abs + ord * plateau.getTaille()[0]);
	            if (newEmplacement.estVide()) {
	                oldEmplacement.setPersonnage(null);
	                newEmplacement.setPersonnage(personnage);
	                personnage.setCellule(newEmplacement);
	                plateau.afficher();
	            }
	            else
	                System.out.println("Cette emplacement est deja occupe !");
	        }
	        else
	            System.out.println("Emplacement invalide !\n");
    	}
        
    }

    //@objid ("f905e53e-e536-4518-99b3-f48998e5fb9c")
    public void attaquer() {
        Scanner scan = new Scanner(System.in);
        
        List<Object[]> celluleEnnemie = ennemieAutour();
        if (!celluleEnnemie.isEmpty()) {
            String string = "Attaquer l'ennemie a quel emplacement ? (annuler,";
            List<String> emplacement = new ArrayList<String>();
            for (Object[] obj : celluleEnnemie) {
                emplacement.add( (String)obj[0] );
                string += (String)obj[0] + ",";
            }
            string = string.substring(0, string.length() - 1) + ")";
            System.out.println(string);
            String input = scan.next();
            while (!emplacement.contains(input) && !input.equals("annuler")) {
                System.out.println("Emplacement invalide !");
                input = scan.next();
            }
            if (input.equals("annuler")) {
                System.out.println("Attaquer annulee...");
                return;
            }
                
            for (Object[] obj : celluleEnnemie) {
                if (input.equals( ((String)(obj[0])) )) {
                    personnage.attaquer( ((Cellule)(obj[1])).getPersonnage() );
                }
            }
            
        }
        else
            System.out.println("Il n'y a pas d'ennemies autour !");
    }

    //@objid ("13e2f1e2-90f1-4a62-a8bb-36179ce9f8f5")
    public void ramasser() {
        Scanner scan = new Scanner(System.in);
        
        List<Object[]> celluleObjet = objetAutour();
        if (!celluleObjet.isEmpty()) {
            String string = "Ramasser l'objet a quel emplacement ? (annuler,";
            List<String> emplacement = new ArrayList<String>();
            for (Object[] obj : celluleObjet) {
                emplacement.add( (String)obj[0] );
                string += (String)obj[0] + ",";
            }
            string = string.substring(0, string.length() - 1) + ")";
            System.out.println(string);
            String input = scan.next();
            while (!emplacement.contains(input) && !input.equals("annuler")) {
                System.out.println("Emplacement invalide !");
                input = scan.next();
            }
            if (input.equals("annuler")) {
                System.out.println("Ramassage annulee...");
                return;
            }
            for (Object[] obj : celluleObjet) {
                if (input.equals( ((String)(obj[0])) )) {
                    personnage.ramasser( ((Cellule)(obj[1])) );
                }
            }
            
        }
        else
            System.out.println("Il n'y a pas d'objets autour !");
    }

    //@objid ("8b4383d6-187d-4ba6-833c-9c1a3b71bbc0")
    public List<Object[]> ennemieAutour() {
        int abs = personnage.getCellule().getAbscisse();
        int ord = personnage.getCellule().getOrdonnee();
        List<Object[]> porteeAttaque = new ArrayList<Object[]>();
        Object[] haut   = {"haut"  ,new Cellule(abs,ord - 1)};
        Object[] bas    = {"bas"   ,new Cellule(abs,ord + 1)};
        Object[] gauche = {"gauche",new Cellule(abs - 1,ord)};
        Object[] droite = {"droite",new Cellule(abs + 1,ord)};
        porteeAttaque.add(haut);
        porteeAttaque.add(bas);
        porteeAttaque.add(gauche);
        porteeAttaque.add(droite);
        List<Object[]> celluleEnnemie = new ArrayList<Object[]>();
        for (Object[] obj : porteeAttaque) {
            if (plateau.celluleValide( ((Cellule)(obj[1])) )) {
                obj[1] = plateau.getCellules().get(((Cellule)(obj[1])).getAbscisse() + ((Cellule)(obj[1])).getOrdonnee() * (plateau.getTaille()[0]));
                if (((Cellule)obj[1]).possedePerso())
                    celluleEnnemie.add(obj);
            }
                
        }
        return celluleEnnemie;
    }

    //@objid ("dee817c1-156f-4b09-b1dc-99fd8fc2df7a")
    public List<Object[]> objetAutour() {
        int abs = personnage.getCellule().getAbscisse();
        int ord = personnage.getCellule().getOrdonnee();
        List<Object[]> porteeRamasse = new ArrayList<Object[]>();
        Object[] haut   = {"haut"  ,new Cellule(abs,ord - 1)};
        Object[] bas    = {"bas"   ,new Cellule(abs,ord + 1)};
        Object[] gauche = {"gauche",new Cellule(abs - 1,ord)};
        Object[] droite = {"droite",new Cellule(abs + 1,ord)};
        porteeRamasse.add(haut);
        porteeRamasse.add(bas);
        porteeRamasse.add(gauche);
        porteeRamasse.add(droite);
        List<Object[]> celluleObjet = new ArrayList<Object[]>();
        for (Object[] obj : porteeRamasse) {
            if (plateau.celluleValide( ((Cellule)(obj[1])) )) {
                obj[1] = plateau.getCellules().get(((Cellule)(obj[1])).getAbscisse() + ((Cellule)(obj[1])).getOrdonnee() * (plateau.getTaille()[0]));
                if (((Cellule)obj[1]).possedeObjet())
                    celluleObjet.add(obj);
            }
                
        }
        return celluleObjet;
    }

}
