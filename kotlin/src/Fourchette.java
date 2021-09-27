public class Fourchette {

    private boolean onUse = false;
    private GestionFamine gestionFamine;
    private String nom;

    public Fourchette(String nom, GestionFamine gestionFamine) {
        this.nom = nom;
        this.gestionFamine = gestionFamine;
    }

    public synchronized void prendreFourchette(){
        while(!onUse){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void poserFourchette(){
        this.onUse = false;
        notifyAll();
    }

}
