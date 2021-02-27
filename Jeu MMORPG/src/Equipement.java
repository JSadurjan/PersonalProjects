import java.io.Serializable;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("f7a0f4bf-bca4-40c8-a821-39a5ec274c2e")
public class Equipement implements Serializable {
    //@objid ("a46c315f-6442-4ed7-80ba-d1056ef2fa51")
    private Armure tete;

    //@objid ("29d08346-10ab-40e1-84ce-ff4258e9fc59")
    private Armure haut;

    //@objid ("42103b0c-43fa-48d2-8028-5c35df41ea71")
    private Armure bas;

    //@objid ("4233eb22-f1a7-446d-bd8d-d2fd5cefc35c")
    private Arme mainGauche;

    //@objid ("675e68c5-f1cc-4e80-9250-16ff1292d51b")
    private Arme mainDroite;

    //@objid ("86068e41-9920-4a53-9fa7-dc3060490499")
    public Equipement() {
        tete = null;
        haut = null;
        bas  = null;
        mainGauche = null;
        mainDroite = null;
    }

    //@objid ("209c962a-3e4c-498e-8162-427b68bab88d")
    public Des calculEncombrement() {
        Des encombrement = new Des();
        encombrement.ajout(tete.getEncombrement() );
        encombrement.ajout(haut.getEncombrement() );
        encombrement.ajout(bas.getEncombrement() );
        return encombrement;
    }

    //@objid ("82728367-c6c4-4fe3-a888-fb7487eafc15")
    public Des calculSolidite() {
        Des solidite = new Des();
        solidite.ajout(tete.getSolidite() );
        solidite.ajout(haut.getSolidite() );
        solidite.ajout(bas.getSolidite() );
        return solidite;
    }

    //@objid ("3da02638-3816-42bf-adaa-2dea1ce42ae6")
    public Des calculManiabilite() {
        Des maniabilite = new Des();
        maniabilite.ajout(mainGauche.getManiabilite() );
        maniabilite.ajout(mainDroite.getManiabilite() );
        return maniabilite;
    }

    //@objid ("660c3430-60d8-4971-8c7a-2280f63d80e7")
    public synchronized Des calculImpact() {
        Des impact = new Des();
        impact.ajout(mainGauche.getImpact() );
        impact.ajout(mainDroite.getImpact() );
        return impact;
    }

    //@objid ("6f28a4b3-2964-4237-af07-60831c843978")
    Arme getMainDroite() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mainDroite;
    }

    //@objid ("22947b85-7da9-488f-bb54-a208ad9b0687")
    Arme getMainGauche() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.mainGauche;
    }

    //@objid ("60f2e878-b9f9-4141-b3b0-bfd437fe91e7")
    Armure getTete() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tete;
    }

    //@objid ("2ebd5edd-27f5-4c90-b714-711408a67331")
    Armure getHaut() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.haut;
    }

    //@objid ("45cce8f6-4a89-433e-8fff-78123873e7ae")
    Armure getBas() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.bas;
    }

    //@objid ("03455767-1dc4-4824-a082-46a731628402")
    void setMainDroite(Arme value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.mainDroite = value;
    }

    //@objid ("2ac0d97f-9bec-43b9-8233-308b504c69f0")
    void setMainGauche(Arme value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.mainGauche = value;
    }

    //@objid ("32885533-8452-4aa4-a13b-9ad2e2dd27b8")
    void setTete(Armure value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tete = value;
    }

    //@objid ("833d60ee-25e6-41dc-a6d3-92a342d29127")
    void setHaut(Armure value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.haut = value;
    }

    //@objid ("223b395c-ccdf-4467-b764-98d50d31bee4")
    void setBas(Armure value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.bas = value;
    }

}
