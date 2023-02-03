import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Ksiazka {
    private String title;
    private String type;
    private Double price;
    private Autor autor;

    @Override
    public String toString() {
        return "Ksiazka{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", autor=" + autor +
                '}';
    }

    public Ksiazka(String title, String type, Double price , Autor autor) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.autor = autor;
    }

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Ksiazka> allKsiazki = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return Objects.equals(title, ksiazka.title) && Objects.equals(type, ksiazka.type) && Objects.equals(price, ksiazka.price) && Objects.equals(autor, ksiazka.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, price, autor);
    }



    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Autor getAutor() {
        return autor;
    }


    public static void create(){
        allKsiazki.add(new Ksiazka("Kot w butach" , "miłosna" , 20.0 , new Autor("Adam" , "Karczewski")));
        allKsiazki.add(new Ksiazka("Kot w butach 2" , "cos" , 26.0 , new Autor("Artur" , "Wierciński")));
        allKsiazki.add(new Ksiazka("Tomek sojer" , "TEST" , 56.0 , new Autor("Kacper" , "Markowski")));
    }

    public static void add(){
        System.out.print("Tytuł: ");
        String title = "";
        while (title.isEmpty()) {
            title = scanner.nextLine();
        }

        System.out.print("Kategoria: ");
        String type = "";
        while (type.isEmpty()){
            type=scanner.nextLine();
        }

        System.out.print("Cena: ");
        double price = scanner.nextDouble();

        System.out.print("Imię autora: ");
        String imie = scanner.next();

        System.out.print("Nazwisko autora: ");
        String nazwisko = scanner.next();

        for(Ksiazka x: allKsiazki){
            if(x.getTitle().toUpperCase(Locale.ROOT).equals(title.toUpperCase())){
                System.out.println("Istnieje już taka książka");
                break;
            }else{
                allKsiazki.add(new Ksiazka(title , type , price , new Autor( imie , nazwisko )));
                break;
            }
        }

    }

    public static void del(){
        System.out.print("Tytuł: ");
        String title = "";
        while (title.isEmpty()) {
            title = scanner.nextLine();
        }

        System.out.print("Imię autora: ");
        String imie = scanner.next();

        int i=0 , ifDel = 0;
        for(Ksiazka k: allKsiazki){
            if(k.getTitle().toUpperCase(Locale.ROOT).equals(title.toUpperCase())){
                if(k.getAutor().getImie().equals(imie)){
                    allKsiazki.remove(i);
                    break;
                }
            }
            i++;
            ifDel++;
        }


        if(ifDel == 0) {
            System.out.println("Nie ma takiej książki lub imię niggera zostało błędnie wpisane");
        }

    }

    public static void findTitle(){
        System.out.print("Podaj tytuł ksiązki: ");
        String title = "";
        while (title.isEmpty()){
            title = scanner.nextLine();
        }

        int ifFind = 0;
        for(Ksiazka find: allKsiazki){
            if(find.getTitle().toUpperCase().equals(title.toUpperCase())){
                System.out.println("=========================================");
                System.out.println("Tytuł: " + find.getTitle());
                System.out.println("Gatunek: " + find.getType());
                System.out.println("Autor: " + find.autor.getImie() + " " + find.autor.getNazwisko());
                ifFind++;
            }
        }

        if(ifFind == 0){
            System.out.println("Nie posiadamy takiej ksiazki w naszej bibliotece");
        }
    }

    public static void findAutor(){
        System.out.print("Podaj imię autora: ");
        String name = "";
        while (name.isEmpty()){
            name = scanner.nextLine();
        }

        System.out.print("Podaj nazwisko autora: ");
        String nazwisko = "";
        while (nazwisko.isEmpty()){
            nazwisko = scanner.nextLine();
        }


        int blad = 0;

        for(Ksiazka find: allKsiazki){
            if (find.getAutor().getImie().equalsIgnoreCase(name) && find.autor.getNazwisko().equalsIgnoreCase(nazwisko)){
                System.out.println("=========================================");
                System.out.println("Tytuł: " + find.getTitle());
                System.out.println("Gatunek: " + find.getType());
                System.out.println("Autor: " + find.autor.getImie() + " " + find.autor.getNazwisko());
                blad++;
            }
        }

        if(blad == 0){
            System.out.println("Nie ma takiego autora");
        }

    }

    public static void wys(){
        System.out.println();
        System.out.println("--------------");
        for(Ksiazka x: allKsiazki){
            System.out.println(x.toString());
        }
    }
}
