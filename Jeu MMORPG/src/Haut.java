import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.util.List;

//@objid ("bf2d5b89-9adb-4d65-925d-3c1c31d8cdbd")
public class Haut extends Armure {
    //@objid ("1d49b7d3-e29f-4200-816d-6abdbe3434d2")
    public Haut() {
    	setEncombrement(new Des());
    	setSolidite(new Des());
    	setNom("plastron");
    }

    //@objid ("47f0f2ef-c1c1-452a-b32b-79a7018e984a")
    public void utiliser(Equipement equip, Equipable obj, List<Objet> inventaire) {
    	if(equip.getHaut() != null)
            inventaire.add(equip.getHaut());
        equip.setHaut((Haut)obj);
    }
}
