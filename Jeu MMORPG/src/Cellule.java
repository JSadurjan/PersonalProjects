import java.io.Serializable;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("61988975-e387-4d34-9f92-827d6d8a0d15")
public class Cellule implements Serializable {
    //@objid ("aa4eefbb-b6fb-45f0-8dbd-52dbffd858d0")
    private int abscisse;

    //@objid ("b8b3e570-5eaf-43d2-bba0-3ce976e6129c")
    private int ordonnee;

    //@objid ("5e23d72e-a47a-48ff-bb64-94208083407b")
    private Personnage personnage;

    //@objid ("067ed119-80e0-46d6-9df0-6a21fb505710")
    private InfoCase infoCase;

    //@objid ("e7925234-cda7-426e-b7be-b07a27cd322b")
    public Cellule(int x, int y) {
        abscisse = x;
        ordonnee = y;
        personnage = null;
        infoCase = null;
    }

    //@objid ("a4089249-c71a-435c-9cc6-f4d312b5f288")
    int getAbscisse() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.abscisse;
    }

    //@objid ("217702ad-28df-4b5a-9c66-d51173962092")
    int getOrdonnee() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.ordonnee;
    }

    //@objid ("6b3c8fe8-38cf-4d41-bedc-376dc8f18251")
    void setPersonnage(Personnage value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.personnage = value;
    }

    //@objid ("40be2ed6-ea7c-41c7-acc6-4b04137ccbc1")
    Personnage getPersonnage() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.personnage;
    }

    //@objid ("8c59cd86-343e-48fe-9a36-edab9912b1f6")
    public String toString() {
        return "x = " + abscisse + ", y = " + ordonnee + ",infoCase = " + infoCase + ",personnage = " + personnage;
    }

    //@objid ("62d2c206-02c8-46aa-ab22-746755d96a5e")
    InfoCase getInfoCase() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.infoCase;
    }

    //@objid ("a67563a2-5638-4713-8b78-30045db5e8d6")
    void setInfoCase(InfoCase value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.infoCase = value;
    }

    //@objid ("1ae19c30-55b3-45bb-bb68-0248acaf08bb")
    public boolean equals(Cellule cel) {
        return abscisse == cel.abscisse && ordonnee == cel.ordonnee;
    }

    //@objid ("2e157f3a-4e6d-4ef6-a3e4-0624541f0ba2")
    public boolean estVide() {
        return !(personnage != null || infoCase != null);
    }

    //@objid ("3dbd0611-1c2e-4bab-8a71-2b0f8abbf26b")
    public boolean possedePerso() {
        return personnage != null;
    }

    //@objid ("2688dd65-c685-4b26-ac7d-c20ebe983599")
    public boolean possedeObjet() {
    	return infoCase != null;
    }

}
