import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("a9001e21-d26b-4262-a430-23f582d82010")
public class PotionVie extends Consommable {
    //@objid ("b3b89c6d-08a0-4409-b16a-b9a6675a80e9")
    public PotionVie() {
    	setNom("potion de vie");
    	setPArequis(2);
    }

    //@objid ("25c95e00-af57-4319-b8c6-85f0b29cbef6")
    public void utiliser(PJ perso) {
        int etat = perso.getEtat();
        etat += 1;
        if (etat > 6)
            etat = 6;
        perso.setEtat(etat);
        perso.setPA( perso.getPA() - this.getPArequis());
        perso.checketat();
    }

}
