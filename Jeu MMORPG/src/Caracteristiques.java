import java.io.Serializable;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("9d53c91e-950b-4883-86d7-3b0e2c63abb6")
public class Caracteristiques implements Serializable {
    //@objid ("fd34baca-9346-4f73-b58e-b7b0d7585d55")
    private int PXrequisFor;

    //@objid ("ce7aae1f-5d23-4a39-939e-a65a98cf20d4")
    private int PXrequisAdr;

    //@objid ("b8cc5f82-44c9-4420-b9aa-19d80819173f")
    private int PXrequisRes;

    //@objid ("3e90e606-5a05-4781-ab6d-42f32cff5327")
    private Degre force;

    //@objid ("ca30475d-44f7-4c6b-a89e-956d0a6f73f2")
    private Degre resistance;

    //@objid ("4ba15b89-c654-4727-b822-69671bc9bc98")
    private Degre adresse;

    //@objid ("688261fb-1138-4df1-8fd1-f344282a1c8b")
    public Caracteristiques(int str, int res, int adr) {
        force       = new Degre(str);
        resistance  = new Degre(res);
        adresse     = new Degre(adr);
        PXrequisFor = force.getDegre()      * 10;
        PXrequisRes = resistance.getDegre() * 10;
        PXrequisAdr = adresse.getDegre()    * 10;
    }

    //@objid ("cae859a3-1d00-4256-8732-9be88a98d037")
    Degre getResistance() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.resistance;
    }

    //@objid ("f3fe35c9-adf2-4bb0-aa3d-c2ab16c82af3")
    void setResistance(Degre value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.resistance = value;
    }

    //@objid ("2a568647-f72f-4596-b4b0-2172fdd48352")
    Degre getAdresse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.adresse;
    }

    //@objid ("92d8b5fd-657f-4690-99a1-31edf5902789")
    void setAdresse(Degre value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.adresse = value;
    }

    //@objid ("ada034c5-a497-44b7-a301-e9e1e676a418")
    Degre getForce() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.force;
    }

    //@objid ("3f2d91ea-2644-4a91-92b2-d8d488bbedf6")
    void setForce(Degre value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.force = value;
    }

    //@objid ("8100c050-59f5-4433-8af4-d8b5780319bc")
    public String toString() {
        String string = "";
        string += "- force      : " + force.toString() + "\n";
        string += "- adresse    : " + adresse.toString() + "\n";
        string += "- resistance : " + resistance.toString();
        return string;
    }

}
