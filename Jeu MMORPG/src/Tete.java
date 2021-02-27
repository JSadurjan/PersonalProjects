import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.util.List;

//@objid ("7e04a079-3d39-486b-8c0e-7e1ba43d8ace")
public class Tete extends Armure {
    //@objid ("65248e49-a11a-405f-929b-0449b1a9612a")
    public Tete() {
    	setEncombrement(new Des());
    	setSolidite(new Des());
    	setNom("casque");
    }
    
    //@objid ("d68627c1-93f1-4a54-be5b-c8d5ffb1324b")
    public void utiliser(Equipement equip, Equipable obj, List<Objet> inventaire) {
    	if(equip.getTete() != null)
            inventaire.add(equip.getTete());
        equip.setTete((Tete)obj);
    }

}
