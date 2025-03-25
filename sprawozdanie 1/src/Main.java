// Klasa testująca
class Main {
    public static void main(String[] args) {
        try {

            Set<Student> studenci = new Set<>(5);
            studenci.dodajElement(new Student("Ania", 21));
            studenci.dodajElement(new Student("Bartek", 23));
            studenci.dodajElement(new Student("Kasia", 22));

            System.out.println("Studenci: " + studenci);

            Set<Student> nowiStudenci = new Set<>(5);
            nowiStudenci.dodajElement(new Student("Kasia", 22));
            nowiStudenci.dodajElement(new Student("Paweł", 24));

            Set<Student> suma = studenci.dodajElementy(nowiStudenci);
            Set<Student> roznica = studenci.odejmijElementy(nowiStudenci);
            Set<Student> wspolne = studenci.przeciecie(nowiStudenci);

            System.out.println("Suma zbiorów: " + suma);
            System.out.println("Różnica zbiorów: " + roznica);
            System.out.println("Przecięcie zbiorów: " + wspolne);

            System.out.println("\n==== Testowanie Produkt ====");
            Set<Produkt> produkty = new Set<>(5);
            produkty.dodajElement(new Produkt("Mleko", 3.50));
            produkty.dodajElement(new Produkt("Chleb", 2.80));
            produkty.dodajElement(new Produkt("Masło", 6.40));

            System.out.println("Produkty: " + produkty);

            Set<Produkt> noweProdukty = new Set<>(5);
            noweProdukty.dodajElement(new Produkt("Masło", 6.40));
            noweProdukty.dodajElement(new Produkt("Ser", 8.20));

            Set<Produkt> sumaProdukty = produkty.dodajElementy(noweProdukty);
            Set<Produkt> roznicaProdukty = produkty.odejmijElementy(noweProdukty);
            Set<Produkt> wspolneProdukty = produkty.przeciecie(noweProdukty);

            System.out.println("Suma zbiorów: " + sumaProdukty);
            System.out.println("Różnica zbiorów: " + roznicaProdukty);
            System.out.println("Przecięcie zbiorów: " + wspolneProdukty);

        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}