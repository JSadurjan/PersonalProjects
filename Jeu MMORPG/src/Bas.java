//import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.util.List;

//@objid ("8bd4ff9a-cb01-4b8d-83a2-e5059e3bf214")
public class Bas extends Armure {
    //@objid ("9d843e4f-86bd-469f-bd8a-23ff817c801f")
    public Bas() {
    	setEncombrement(new Des());
    	setSolidite(new Des());
    	setNom("bas");
    }

    //@objid ("62dcee2b-e7c0-421e-8ee2-a2bebd0d04cc")
    public void utiliser(Equipement equip, Equipable obj, List<Objet> inventaire) {
    	if(equip.getBas() != null)
            inventaire.add(equip.getBas());
        equip.setBas((Bas)obj);
    }
}
