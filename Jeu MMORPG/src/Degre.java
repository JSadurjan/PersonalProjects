import java.io.Serializable;
import java.util.List;
//import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("caa12007-5a99-44e6-89e6-67155d9c032f")
public class Degre implements Serializable {
    //@objid ("67a2cdbb-9425-4f14-ab75-d1bda97f37ca")
    private int degre;

    //@objid ("2d8ca093-88ae-4863-b817-0d3eeef8038b")
    public Degre() {
        degre = 0;
    }

    //@objid ("1ad1a82a-c163-4c5b-ab2e-615a682f23c9")
    public Degre(int deg) {
        degre = deg;
    }

    //@objid ("8d4950a4-86a6-4606-ab3c-1bcb4012fb8f")
    int getDegre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.degre;
    }

    //@objid ("75b9203f-1c22-4872-9f21-98c95be9d377")
    public void plus(Degre deg) {
        this.degre += deg.degre;
    }

    //@objid ("8b8cc94a-f95a-4b7b-a8b7-fd94c538be9d")
    public void moins(Degre deg) {
        this.degre -= deg.degre;
    }

    //@objid ("6ba1003e-fa53-4f44-a9a6-7162a7709efe")
    public Degre somme(List<Degre> deg) {
        Degre total = new Degre();
        for ( Degre d : deg) {
            total.degre += d.degre; 
        }
        return total;
    }

    //@objid ("1b6ca1e2-f8ec-442a-b04e-b8762d4d9d4b")
    public Degre difference(List<Degre> deg) {
        Degre total = new Degre();
        for ( Degre d : deg) {
            total.degre -= d.degre; 
        }
        return total;
    }

    //@objid ("1456a2ec-229b-496a-aa36-f152fa0fcd5c")
    public String toString() {
        return new Des(this).toString();
    }

}
