import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("c105a056-7122-482d-89d9-1c48a046c43e")
public abstract class Equipable extends Objet {
    //@objid ("e85b0747-9f00-47fb-86f2-62bfb368e8a5")
    public String toString() {
        return "haha";
    }

    //@objid ("a283c1b6-6c93-47a6-bbf2-94c5dffdbbc6")
    public abstract void utiliser(Equipement equip, Equipable obj, List<Objet> inventaire);

}
