import java.io.Serializable;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("50e6325d-1725-4557-b1bf-23f7c25cf6b0")
public class AffichageTexte implements Affichage, Serializable {
    //@objid ("c8d93549-624c-41fd-8100-983966f0ff33")
    public void afficherPlateau(Plateau plateau) {
        String affichage = "";
        for (int i = 0; i < plateau.getTaille()[0] + 2; i++)
            affichage += "*";
        affichage += "\n";
        for (int i = 0; i < plateau.getTaille()[1]; i++) {
            affichage += "*";
            for (int j = 0; j < plateau.getTaille()[0] ; j++) {
                if ( plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getPersonnage() != null)
                    affichage += plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getPersonnage().getNom().charAt(0);
                else if (plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getInfoCase() != null)
                    affichage += plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getInfoCase().getObjet().getNom().charAt(0);
                else
                    affichage += " ";
            }
            affichage += "*\n";
        }    
        for (int i = 0; i < plateau.getTaille()[0] + 2; i++)
            affichage += "*";
        System.out.println(affichage);
    }

    //@objid ("e1efdf25-5019-4555-a536-7844835f2be6")
    public void afficherDynamique(Plateau plateau, PJ perso) {
    	StringBuilder affichage = new StringBuilder("");
        for (int i = 0; i < plateau.getTaille()[0] + 2; i++)
            affichage.append("*");
        affichage.append("\n");
        for (int i = 0; i < plateau.getTaille()[1]; i++) {
            affichage.append("*");
            for (int j = 0; j < plateau.getTaille()[0] ; j++) {
                if ( plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getPersonnage() != null)
                    affichage.append(plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getPersonnage().getNom().charAt(0)) ;
                else if (plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getInfoCase() != null)
                    affichage.append(plateau.getCellules().get( i * (plateau.getTaille()[0]) + j ).getInfoCase().getObjet().getNom().charAt(0));
                else
                    affichage.append(" ");
            }
            affichage.append("*\n");
        }    
        for (int i = 0; i < plateau.getTaille()[0] + 2; i++) {
            affichage.append("*");
        }
        System.out.println(affichage);
    }

}
