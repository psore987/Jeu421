import java.util.Scanner;
public class Main {
    int[][] tab;

    public static void main(String[] args) {
        Main main = new Main(); // Crée une instance de la classe Main
        main.initTab(); //initialisation de la matrice tab
        main.afficheTab(); //affichage de la matrice
        System.out.println("Début du jeu");
        // Créer un objet Scanner pour lire l'entrée
        Scanner console = new Scanner(System.in);

        main.lancer3Des();
        main.afficheTab();

        boolean fini = main.verifier();
        int numDe = 0;
        De de = new De(0, 0); // Crée une instance de la classe De

        while (!fini){
            System.out.print("Quel dé voulez-vous relancer ? ");
            numDe = console.nextInt();
            System.out.println(numDe);
            main.tab[numDe][1] = de.lancer(); // on relance le de et on remplace sa valeur
            main.afficheTab();
            fini = main.verifier();
        }
        System.out.println("Bravo! Vous avez gagné !");
    }

    void initTab() {
        this.tab = new int[3][2]; // 3 des et 2 attributs "no" et "valeur"
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                tab[i][j] = 0;
            }
        }
    }

    void afficheTab() {
        int i, j;
        for (i = 0; i < 3; i++) {
            System.out.println();
            for (j = 0; j < 2; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    void lancer3Des() {
        //lancer les 3 des
        int i;
        for (i = 0; i < 3; i++) {
            tab[i][0] = i; // numero du de
            De de = new De(0, 0); // nouvelle instance
            tab[i][1] = de.lancer(); // valeur du de i
        }
    }
        boolean verifier () { //renvoie vrai si les 3 des sont 4 2 et 1, faux sinon
            // les 3 valeurs sont non trouvees par defaut
            boolean un = false;
            boolean deux = false;
            boolean quatre = false;
            int i;
            for (i = 0; i < 3; i++) {
                switch (tab[i][1]) {
                    case 1:
                        un = true;
                        break;
                    case 2:
                        deux = true;
                        break;
                    case 4:
                        quatre = true;
                        break;
                }
            }
            if (un && deux && quatre) {
                return true;
            } else {
                return false;
            }
        }

}
class De{

    int valeur; //valeur affichee
    int num; // numero du de
    //constructeur
    De(int num, int valeur) {
        // pour nouvelle instanciation
        this.num = num;
        this.valeur = valeur;
    }

    int lancer() {
        // simule un lancer de de
        valeur = (int) (Math.random() * 6 + 1); // les des ont 6 faces
        return valeur;
    }


}
