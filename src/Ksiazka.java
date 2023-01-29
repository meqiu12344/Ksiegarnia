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
        allKsiazki.add(new Ksiazka("Kot w butach2" , "cos" , 26.0 , new Autor("Artur" , "Wierciński")));
        allKsiazki.add(new Ksiazka("Tomek sojer" , "TEST" , 56.0 , new Autor("Kacper" , "CHUJ")));
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

        int i=0;
        for(Ksiazka k: allKsiazki){
            if(k.getTitle().toUpperCase(Locale.ROOT).equals(title.toUpperCase())){
                if(k.getAutor().getImie().equals(imie)){
                    allKsiazki.remove(i);
                    break;
                }
            }
            i++;
        }

        System.out.println("Nie ma takiej książki lub imię autora zostało błędnie wpisane");

    }

    public static void wys(){
        for(Ksiazka x: allKsiazki){
            System.out.println(x.toString());
        }
    }
}
