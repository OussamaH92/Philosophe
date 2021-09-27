public class GestionFamine {

    private int nbrGauche = 0;
    private int nbrDroit = 0;
    private int maxGauche;
    private int maxDroit;

    public void ajouterFourchetteDroite(){
        maxDroit++;
    }

    public void ajouterFourchetteGauche(){
        maxGauche++;
    }

    public synchronized void checkFamine(){

        while((nbrGauche == (maxGauche-1)) || (nbrDroit == (maxDroit-1))){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void fourchetteDroite(){
        nbrDroit++;
    }

    public synchronized void fourchetteGauche(){
        nbrGauche++;
    }

    public synchronized void poserFourchetteDroite(){
        nbrDroit--;
        notifyAll();
    }

    public synchronized void poserFourchetteGauche(){
        nbrGauche--;
        notifyAll();
    }


}
