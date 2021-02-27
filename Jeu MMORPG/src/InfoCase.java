import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.io.Serializable;

//@objid ("e2b57863-1071-4641-ac94-201c50a56929")
public class InfoCase implements Serializable{
    //@objid ("97d8ef17-56e2-4f11-998b-826296b548bf")
    private int quantite;

    //@objid ("e8aa49b3-a8db-4534-ad5b-abe901b0af8e")
    private Objet objet;

    //@objid ("b278d6f5-0ae9-412f-91e2-18bac21f563c")
    private Cellule cellule;

    //@objid ("70770c05-4d14-428f-9011-03297f9f08c6")
    public InfoCase(Cellule cel) {
        quantite = 1;
        objet = new Epee();
        cellule = cel;
    }

    //@objid ("97e633bf-6978-49f6-ae5a-9c41d5c4712a")
    Objet getObjet() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.objet;
    }

    //@objid ("eacf033c-250a-47e2-aeaa-a215d54e7c03")
    void setObjet(Objet value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.objet = value;
    }

    //@objid ("843cd519-3f11-4cf2-8db9-72f0f3c08b46")
    int getQuantite() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.quantite;
    }

    //@objid ("37a1534f-be88-44f3-ba04-e2a3a7de545d")
    void setCellule(Cellule value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.cellule = value;
    }

}
