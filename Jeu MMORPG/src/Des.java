import java.io.Serializable;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("a369ebd1-fa4c-48ed-8bbf-117f163fa725")
public class Des implements Serializable {
    //@objid ("a120904e-6caa-4fbe-8d9d-695ffdb14805")
    private int tirage;

    //@objid ("e53909f2-5c7b-4239-af7d-0d11f98495c8")
    private int bonus;

    //@objid ("4d630b0c-374e-40de-9407-95750963c4c4")
    public Des(Degre deg) {
        tirage    = deg.getDegre() / 3; 
        bonus     = deg.getDegre() % 3;
    }

    //@objid ("95dce27e-1c6d-4d8f-b848-aaa12ee95d68")
    public Des() {
        tirage = 0;
        bonus = 0;
    }

    //@objid ("acc1e49a-04c2-4dd9-8ff2-8848bb94a727")
    public void ajout(Des deg) {
        tirage    += deg.tirage;
        bonus     += deg.bonus;
    }

    //@objid ("611965b5-a89f-43b0-b8d5-6caf41b1ddf3")
    public void suppr(Des deg) {
        tirage    -= deg.tirage;
        bonus     -= deg.bonus;
        if (tirage < 0 && bonus < 0) {
            tirage = 0;
            bonus = 0;
        }
        else if (tirage < 0)
            tirage = 0;
    }

    //@objid ("b6c2f19e-607a-48d9-91fc-b9f6340fb345")
    public Des somme(Des des) {
    	Des somme = this;
    	somme.ajout(des);
    	return somme;
    }

    //@objid ("75c078e5-58b2-4eab-b073-a6d176d3d763")
    public Des difference(Des des) {
    	Des difference = this;
    	difference.suppr(des);
    	return difference;
    }

    //@objid ("38d50f13-a1c4-4e97-902f-3fddd985a494")
    public int comparerJet(Des jet2) {
        int totalJet1 = bonus;
        int totalJet2 = jet2.bonus;
        for (int i = 0; i < tirage; i++)
            totalJet1 += Math.random() * 6 + 1;
        for (int i = 0; i < jet2.tirage; i++)
            totalJet2 += Math.random() * 6 + 1;
        int difference = totalJet1 - totalJet2;
        return difference;
    }

    //@objid ("bd32da77-d186-4d0b-9c3a-24b20dd3cb5a")
    public int lancerDes() {
        int score = bonus;
        for (int i = 0; i < tirage; i++)
            score += Math.random() * 6 + 1;
        return score;
    }

    //@objid ("78c61db7-25de-4ea0-8b06-798b7e6d238d")
    int getTirage() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tirage;
    }

    //@objid ("70e71237-372f-4bef-9e68-9a2b1ea31bee")
    int getBonus() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.bonus;
    }

    //@objid ("f99e9949-135e-456f-9d08-aa8ddbd2240f")
    public String toString() {
        if (bonus == 0)
            return tirage + "D";
        else
            return tirage + "D+" + bonus;
    }

}
