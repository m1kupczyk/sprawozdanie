import java.util.Arrays;

// Klasa Set<T>
public class Set<T extends Comparable<T>> {
    private T[] set;
    private int pojemnosc;
    private int rozmiar;



    public Set(int pojemnosc) {
        this.pojemnosc = pojemnosc;
        this.rozmiar = 0;
        this.set = (T[]) new Comparable[pojemnosc];
    }

    public void dodajElement(T element) throws Exception {
        if (rozmiar >= pojemnosc) {
            throw new Exception("Zbiór jest pełny.");
        }
        if (szukaj(element) != -1) return;

        int i = 0;
        while (i < rozmiar && set[i].compareTo(element) < 0) {
            i++;
        }
        for (int j = rozmiar; j > i; j--) {
            set[j] = set[j - 1];
        }
        set[i] = element;
        rozmiar++;
    }

    public int szukaj(T element) {
        for (int i = 0; i < rozmiar; i++) {
            if (set[i].compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void usunElement(T element) {
        int idx = szukaj(element);
        if (idx == -1) return;

        for (int i = idx; i < rozmiar - 1; i++) {
            set[i] = set[i + 1];
        }
        set[--rozmiar] = null;
    }

    public Set<T> dodajElementy(Set<T> inny) throws Exception {
        Set<T> nowy = new Set<>(this.pojemnosc + inny.pojemnosc);
        for (int i = 0; i < this.rozmiar; i++) {
            nowy.dodajElement(this.set[i]);
        }
        for (int i = 0; i < inny.rozmiar; i++) {
            nowy.dodajElement(inny.set[i]);
        }
        return nowy;
    }

    public Set<T> odejmijElementy(Set<T> inny) throws Exception {
        Set<T> nowy = new Set<>(this.pojemnosc);
        for (int i = 0; i < this.rozmiar; i++) {
            if (inny.szukaj(this.set[i]) == -1) {
                nowy.dodajElement(this.set[i]);
            }
        }
        return nowy;
    }

    public Set<T> przeciecie(Set<T> inny) throws Exception {
        Set<T> nowy = new Set<>(Math.min(this.pojemnosc, inny.pojemnosc));
        for (int i = 0; i < this.rozmiar; i++) {
            if (inny.szukaj(this.set[i]) != -1) {
                nowy.dodajElement(this.set[i]);
            }
        }
        return nowy;
    }

    @Override
    public String toString() {
        return "Rozmiar: " + rozmiar + ", Pojemność: " + pojemnosc + ", Elementy: " + Arrays.toString(Arrays.copyOf(set, rozmiar));
    }
}