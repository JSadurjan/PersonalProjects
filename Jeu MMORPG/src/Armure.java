import java.io.Serializable;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("97c97298-5cde-4242-a138-67fba771cebb")
public abstract class Armure extends Equipable implements Serializable {
    //@objid ("9fe11e91-492d-438c-97f8-fc41f2ee50ec")
    private Des encombrement;

    //@objid ("3d9f80dd-0cea-40c4-939f-189c6e1cac72")
    private Des solidite;

    //@objid ("8c7bacea-8449-4ec4-8471-b00c175359f5")
    Des getSolidite() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.solidite;
    }

    //@objid ("0d336e17-eb83-488e-a543-2e3f1f733632")
    Des getEncombrement() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.encombrement;
    }

    //@objid ("1fdd1d45-3412-4c21-b02c-51eea109072d")
    public String toString() {
        return "- " + getNom() + " ( e: -" + encombrement.toString() + " i: +" + solidite.toString() + " )";
    }

    //@objid ("521c7712-6562-4bfb-a00c-e11528b0e27f")
    void setEncombrement(Des value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.encombrement = value;
    }

    //@objid ("30b0b705-1dea-4e73-8a89-2797d4be0a07")
    void setSolidite(Des value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.solidite = value;
    }

}
