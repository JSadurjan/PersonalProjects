import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

//@objid ("73aec0df-0e26-4432-8f14-7513f3ba19c8")
public class Plateau implements Serializable {
    //@objid ("608aabe2-852c-438d-8390-fd1c02b2410c")
    private int[] taille = new int[2];

    //@objid ("125947f8-7bf0-488a-9254-aff2fe268644")
    private List<Cellule> cellules = new ArrayList<Cellule>();

    //@objid ("89e36559-6c59-4b4a-a6cc-1b4e3e160d5f")
    private Affichage affichage = new AffichageTexte();

    //@objid ("4251a320-34ba-456a-b21a-18d29d891310")
    public Plateau() {
        taille = new int[] {20,20};
        for (int i = 0 ; i < taille[0]*taille[1]; i++) {
            Cellule cellule = new Cellule(i % 20,i / 20);
            cellules.add(cellule);
        }
    }

    //@objid ("da6720a3-cf3b-4093-82ff-935750c9a010")
    public Plateau(int longueur, int largeur) {
        taille = new int[] {longueur,largeur};
        for (int i = 0 ; i < taille[0]*taille[1]; i++) {
            Cellule cellule = new Cellule(i % longueur,i / largeur);
            cellules.add(cellule);
        }
    }

    //@objid ("d497bc70-1b6a-4ee6-b562-092ebb5696ef")
    public void afficher() {
        affichage.afficherPlateau(this);
    }

    //@objid ("64d3c78e-0c61-4a6f-898f-a24cdebb77ec")
    public void sauvegarder(String nomfichier) {
        try {
            FileOutputStream fos = new FileOutputStream( nomfichier );
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            
            oos.writeObject(this);
            System.out.println("Plateau sauvegarde !");
            
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //@objid ("e250b6e4-5b5a-4749-afa0-e027096b9035")
    public void charger(String nomFichier) {
        try {
            FileInputStream fis = new FileInputStream( nomFichier );
            ObjectInputStream ois = new ObjectInputStream( fis );
            
            Object plat = ois.readObject();
            Plateau plateau = (Plateau) plat;
            
            taille = plateau.taille;
            cellules = plateau.cellules;
            affichage = plateau.affichage;
            
            System.out.println("Plateau chargee !");
            afficher();
            
            ois.close();
        } catch (FileNotFoundException e){
            System.out.println("Ce fichier n'existe pas !\n");
        }
        catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Cette sauvegarde possede des elements d'ancienne version !\n");
        }
    }

    //@objid ("c2ccaaa9-999c-4a35-ab43-ca30f72bd84a")
    public void genererMonstre() {
        List<Integer> celluleLibre = celluleLibre();
        for (int i = 0; i < 5; i++) {
            int nbCelluleLibre = celluleLibre.size();
            int celluleSpawn = (int)(Math.random() * nbCelluleLibre);
            PNJ monstre = new PNJ();
            cellules.get(celluleSpawn).setPersonnage(monstre);;
            monstre.setCellule(cellules.get(celluleSpawn));
            celluleLibre.remove(celluleSpawn);
        }
    }

    //@objid ("6ec9bf9f-95a0-4424-b548-27654d8dc6f4")
    public void genererObjet() {
        List<Integer> celluleLibre = celluleLibre();
        for (int i = 0; i < 5; i++) {
            int nbCelluleLibre = celluleLibre.size();
            int indiceSpawn = (int)(Math.random() * nbCelluleLibre);
            Cellule celluleSpawn = cellules.get(indiceSpawn);
            InfoCase objet = new InfoCase(celluleSpawn);
            celluleSpawn.setInfoCase(objet);
            celluleLibre.remove(indiceSpawn);
        }
    }

    //@objid ("4f2fbfad-1cae-41cb-b1ac-20e7a7085cf8")
    public boolean celluleValide(Cellule cellule) {
        int abs = cellule.getAbscisse();
        int ord = cellule.getOrdonnee();
        int lig = this.getTaille()[1];
        int col = this.getTaille()[0];
        if (abs < 0 || abs >= col || ord < 0 || ord >= lig )
            return false;
        else
            return true;
    }

    //@objid ("86cd68e0-1bbb-4470-9c1a-8b3c074cef33")
    List<Cellule> getCellules() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.cellules;
    }

    //@objid ("adcb48b9-2e92-4af6-b877-ba36713bc5e7")
    int[] getTaille() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.taille;
    }

    //@objid ("1f7e1066-ac10-4f8a-a208-1df778e02350")
    public List<Integer> celluleLibre() {
        List<Integer> celluleLibre = new ArrayList<Integer>();
        for (int i = 0; i < cellules.size(); i++) {
            if (cellules.get(i).getPersonnage() == null && cellules.get(i).getInfoCase() == null) {
                celluleLibre.add(i);
            }
        }
        return celluleLibre;
    }

    //@objid ("a74387ea-82e9-4ce5-9ad8-c4b7a85d0b88")
    public void afficherPerso(PJ perso) {
        affichage.afficherDynamique(this,perso);
    }

}
