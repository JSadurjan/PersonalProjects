import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("c1c08229-dc78-481b-9ca7-313cdef70063")
public abstract class Personnage implements Serializable {
    //@objid ("c860784a-72ff-4e18-a191-22c70c597cf8")
    private int etat;

    //@objid ("b25246b3-a1e0-4812-96fa-19c634bd7f56")
    private int PX;

    //@objid ("3cb7c65c-25ce-408a-86bf-a954c5965111")
    private String nom;

    //@objid ("a435d5e9-7f36-4800-a1c9-1a953eb1c4f0")
    private Capacite cap;

    //@objid ("b4582968-b9eb-4fe5-8922-2b9d36c00788")
    private Cellule cellule;

    //@objid ("7764032b-c328-45ed-9fc0-ded8b32a9908")
    private List<Objet> inventaire = new ArrayList<Objet> ();

    //@objid ("911c7729-90de-4ed4-94c8-871b17e26962")
    public Personnage() {
        etat     = 6;
        PX       = 0; 
        nom      = null;
        cap      = null;
        cellule  = null;
    }

    //@objid ("7b61a928-ee94-4eb6-a10f-f60e23a446ed")
    public abstract void attaquer(Personnage perso);

    //@objid ("c2985298-a5a5-484f-9052-7c8da66e39e1")
    public void checketat() {
        if (etat == 6)
            System.out.println("Le niveau de blessure de " + nom + " est : Normal");
        else if (etat == 5)
            System.out.println("Le niveau de blessure de " + nom + " est : Blessures superficielles");
        else if (etat == 4)
            System.out.println("Le niveau de blessure de " + nom + " est : Legerement blesse");
        else if (etat == 3)
            System.out.println("Le niveau de blessure de " + nom + " est : Blesse");
        else if (etat == 2)
            System.out.println("Le niveau de blessure de " + nom + " est : Gravement blesse");
        else if (etat == 1)
            System.out.println("Le niveau de blessure de " + nom + " est : Inconscient");
        else {
            System.out.println("Le niveau de blessure de " + nom + " est : Mort");
            mort();
        }
    }

    //@objid ("b3e740f6-afb6-469b-b2b2-52aa1223ca96")
    public void mort() {
        cellule.setPersonnage(null);
        cellule = null;
        System.out.println("Le Personnage " + nom + " est mort.");
    }

    //@objid ("619b149e-e4d4-4aa2-9f24-d4c52518a396")
    Cellule getCellule() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.cellule;
    }

    //@objid ("2fc41e3e-701b-46b4-b249-8ca85ead0373")
    void setCellule(Cellule value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.cellule = value;
    }

    //@objid ("06df6182-aab0-4cb2-9f6f-0a91dd7b97c0")
    String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    //@objid ("62b6d023-bc55-4a93-a9dc-2210045d5b05")
    void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }

    //@objid ("e7d96df9-27dc-45c7-88aa-a3221abd6aff")
    void setCap(Capacite value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.cap = value;
    }

    //@objid ("a7eb5f1d-86dc-4895-8d13-0840b0221e58")
    void setPX(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.PX = value;
    }

    //@objid ("88f891e5-cbb6-46f2-a2eb-1257a3c32564")
    void setEtat(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.etat = value;
    }

    //@objid ("4cfef2e9-4835-46ba-9f79-4d26a11748cf")
    Capacite getCap() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.cap;
    }

    //@objid ("62785bc5-a982-4c9c-9670-f9c3a6634309")
    List<Objet> getInventaire() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.inventaire;
    }

    //@objid ("2821fd4c-dcca-42df-be75-14f53a31d973")
    void setInventaire(List<Objet> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.inventaire = value;
    }

    //@objid ("9a337ae7-8dd2-4da2-aad9-bbfb6bd8ddc9")
    int getEtat() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.etat;
    }

    //@objid ("c218f30c-6319-4ed9-bc6a-3011580b4a2c")
    int getPX() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.PX;
    }

}
