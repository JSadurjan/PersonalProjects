import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("3f09617d-f155-4bb1-a012-f21716e2214c")
public class PNJ extends Personnage {
    //@objid ("78fe9d47-816e-48bf-a808-a81aef287437")
    public PNJ() {
        super();
        setNom("Monstre");
        setCap(new Capacite(3,3,3,3,3));
        setPX(50);
    }

    //@objid ("7990e850-4b62-4ebf-9bc0-9279168ecafb")
    public void attaquer(Personnage perso) {
    }

    //@objid ("a9f9f2ff-b102-438c-98db-aba94dfaf2da")
    public void blesser(Personnage perso) {
    }

}
