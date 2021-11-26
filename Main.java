import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coubien il y a t'il de joureu?");
        int joueur= scanner.nextInt();

        if (joueur==2){

            // Carte 2 couleur
            for (int i=0;i<5;i++){
                int n = (int)(Math.random() * 4);
                System.out.println(n);

                Carte myCarte = new Carte();
            }
        }

    }

}