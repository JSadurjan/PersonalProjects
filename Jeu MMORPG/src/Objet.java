import java.io.Serializable;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("00c4250f-6e2f-4aee-b09c-5a1145550212")
public abstract class Objet implements Serializable {
    //@objid ("ba8da489-8b80-49cf-aa8d-4c11c74486d4")
    private int id;

    //@objid ("c5f92700-49fc-4e15-acf2-4006c4b29640")
    private String nom;

    //@objid ("e4cc58e4-1f87-42b2-bc96-c5328148130d")
    private InfoCase infocase;

    //@objid ("7d21c066-b91b-4ac6-8503-6d7cd7998de7")
    public Objet() {
        id = 0;
        nom = "o";
        infocase = null;
    }

    //@objid ("9577da89-def2-48c3-9816-2caafc958b2a")
    public Objet(String Nom) {
        id = 0;
        nom = Nom;
        infocase = null;
    }

    //@objid ("814aba10-8f0e-4365-937c-6124c07a9e40")
    String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    //@objid ("4e77535b-077a-45a9-b6d8-892f1b46b162")
    InfoCase getInfoCase() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.infocase;
    }

    //@objid ("08a09b6b-c1bd-4aae-a06b-aa4365d1e750")
    void setInfoCase(InfoCase value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.infocase = value;
    }

    //@objid ("0a77fc19-ceac-44a1-ad45-0904875b23c8")
    public abstract String toString();

    //@objid ("7ac8e944-3d3f-488e-80c5-9513c8551475")
    void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }

}
