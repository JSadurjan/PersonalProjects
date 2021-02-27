//import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

//@objid ("f728eb6b-dc3d-4bdb-b507-9ea03199f42f")
public abstract class Arme extends Equipable implements Serializable {
    //@objid ("6319937c-3eac-4817-8426-f01b13cbdbc9")
    private Des maniabilite;

    //@objid ("b3e769dd-80ce-4fb8-a595-f1dd41c5acc7")
    private Des impact;

    //@objid ("c1669278-8496-4247-a7bf-781bf7a84a56")
    Des getManiabilite() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.maniabilite;
    }

    //@objid ("a5410e1a-ae45-4cde-95eb-d8322f63ef88")
    Des getImpact() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.impact;
    }

    //@objid ("9f019c4a-37a9-46ce-8972-8c793a31edfe")
    public String toString() {
        return ("- " + getNom() + " ( m: +" + maniabilite.toString() + " i: +" + impact.toString() + " )");
    }

    //@objid ("e158ee51-4cd1-42a9-a443-942d7721985e")
    void setImpact(Des value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.impact = value;
    }

    //@objid ("1c46db15-0d06-4e25-8f2a-df0a6ca9cfbb")
    void setManiabilite(Des value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.maniabilite = value;
    }

    //@objid ("0547abd9-51e8-459e-ab06-ecf2f791ccb6")
    public void utiliser(Equipement equip, Equipable obj, List<Objet> inventaire) {
    	Arme arme = (Arme) obj;
    	Scanner scan = new Scanner(System.in);
        System.out.println("Sur quel main ? (g,d)");
        String emplacement = scan.next();
        
        while (!emplacement.equals("g") && !emplacement.equals("d")) {
            System.out.println("Entree invalide ! (g,d)");
            emplacement = scan.next();
        }
        
        switch (emplacement) {
		case "g":
			if (equip.getMainGauche() != null)
                inventaire.add(equip.getMainGauche());
            equip.setMainGauche(arme);
			break;
		default:
			if(equip.getMainDroite() != null)
                inventaire.add(equip.getMainDroite());
            equip.setMainDroite(arme);
			break;
		}
    }

}
