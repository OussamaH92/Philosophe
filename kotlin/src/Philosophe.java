public class Philosophe extends Thread{

    private Fourchette fDroite;
    private Fourchette fGauche;
    private GestionFamine gestionFamine;
    private String nom;

    public Philosophe(Fourchette fDroite, Fourchette fGauche, GestionFamine gestionFamine) {
        this.fDroite = fDroite;
        gestionFamine.ajouterFourchetteDroite();
        this.fGauche = fGauche;
        gestionFamine.ajouterFourchetteGauche();
        this.gestionFamine = gestionFamine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void run(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fDroite.prendreFourchette();
        fGauche.prendreFourchette();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
