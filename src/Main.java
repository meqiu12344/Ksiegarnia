import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Dodaj książkę");
        System.out.println("2. Usuń książkę");
        System.out.println("3. Szukaj po Autorze");
        System.out.println("4. Szukaj po tytule");
        System.out.print("Wpisz cyferkę: ");
        int wyb = scanner.nextInt();

        Ksiazka ksiazka = new Ksiazka("Tomek sojer" , "horror" , 20.0 ,new Autor("Adam" , "Karczewski"));

        ksiazka.create();

        if(wyb == 1){
            ksiazka.add();
        }

        if(wyb == 2){
            ksiazka.del();
        }

        if(wyb == 3){
            System.out.println("DZIAL 3");
        }

        ksiazka.wys();
    }
}