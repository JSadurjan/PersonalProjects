import java.io.Serializable;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("24f64517-f4df-48e7-b084-15d41a079062")
public class Capacite implements Serializable {
    //@objid ("46a4a65a-c1a0-415b-b17e-9d7f4b8fce89")
    private Des initiative;

    //@objid ("91a2cb22-6ab7-4e3d-b1de-cc8c192ec6fe")
    private Des attaque;

    //@objid ("de321bd7-03bf-44d3-aed0-6c2b55b8b7fe")
    private Des esquive;

    //@objid ("1543f39e-c631-423b-b105-db1b74a2ec0d")
    private Des defense;

    //@objid ("1cccf1da-8e41-43bf-8da1-683d0cbb8237")
    private Des degats;

    //@objid ("dd518fc0-1d81-41c5-ad00-1e18334887c3")
    public Capacite(PJ perso) {
        Caracteristiques car = perso.getCar();
        initiative  = new Des( car.getAdresse() );;
        attaque     = new Des( car.getAdresse() );
        esquive     = new Des( car.getAdresse() );
        defense     = new Des( car.getResistance() );
        degats      = new Des( car.getForce() );
    }

    //@objid ("858f138a-3f6c-47a5-a361-f01ff1b77426")
    public Capacite(int ini, int att, int esq, int def, int deg) {
        initiative = new Des(new Degre(ini));
        attaque    = new Des(new Degre(att));
        esquive    = new Des(new Degre(esq));
        defense    = new Des(new Degre(def));
        degats     = new Des(new Degre(deg));
    }

    //@objid ("c56ebfb1-bcad-4ab7-9cd4-1b43a2409788")
    public void calculCapacite(PJ perso) {
        Caracteristiques car = perso.getCar();
        Equipement equip = perso.getEquipement();
        
        initiative     = new Des( car.getAdresse() );;
        initiative.suppr( equip.calculEncombrement() );
        
        attaque     = new Des( car.getAdresse() );
        
        esquive     = new Des( car.getAdresse() );
        esquive.suppr( equip.calculEncombrement() );
        
        defense     = new Des( car.getResistance() );
        defense.ajout( equip.calculSolidite() );
        
        degats         = new Des( car.getForce() );
    }

    //@objid ("51adaaf7-8e6f-43d2-ad91-46880295380b")
    Des getDegats() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.degats;
    }

    //@objid ("8eccd1fb-d113-4cfe-8bff-7e4a2120da5e")
    Des getEsquive() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.esquive;
    }

    //@objid ("d1fd72ea-3890-4cab-acf1-e7ce8a0b106a")
    Des getDefense() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.defense;
    }

    //@objid ("5b2488e3-b085-4152-b476-4e39c84b37fa")
    Des getInitiative() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.initiative;
    }

    //@objid ("98f70725-cbe3-4bb6-a42c-d91a50404ea6")
    Des getAttaque() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.attaque;
    }

    //@objid ("cb9ee0c6-4fca-45ce-97e7-b102d4eb32df")
    public String toString() {
        String string = "";
        string += "+ initiative : " + initiative.toString() + "\n";
        string += "+ attaque    : " + attaque.toString() + "\n";
        string += "+ esquive    : " + esquive.toString() + "\n";
        string += "+ defense    : " + defense.toString() + "\n";
        string += "+ degats     : " + degats.toString() + "\n";
        return string;
    }

}
