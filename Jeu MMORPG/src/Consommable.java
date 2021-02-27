//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("684aaa3d-352f-4431-aff3-a8632c15b47d")
public abstract class Consommable extends Objet {
    //@objid ("c2dc94be-446b-4957-bfab-922774d9cbeb")
    private int PArequis;

    //@objid ("362cfab9-7ed1-40f2-8004-f92ec3aead09")
    int getPArequis() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.PArequis;
    }

    //@objid ("a2e96470-61ff-4248-ab95-7c37334d29fc")
    void setPArequis(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.PArequis = value;
    }

    //@objid ("f1515aa8-6df0-4f33-80d8-e7204635336d")
    public String toString() {
        return null;
    }

    //@objid ("d4d14015-21b4-45b9-a9ba-c199217fa012")
    public abstract void utiliser(PJ perso);

}
