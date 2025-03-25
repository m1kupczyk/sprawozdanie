// Przykładowa klasa implementująca Comparable
class Student implements Comparable<Student> {
    private String imie;
    private int wiek;

    public Student(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Student inny) {
        return Integer.compare(this.wiek, inny.wiek);
    }

    @Override
    public String toString() {
        return imie + " (" + wiek + ")";
    }
}

