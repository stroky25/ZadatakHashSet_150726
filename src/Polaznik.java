import java.util.Objects;

public class Polaznik implements Comparable<Polaznik> {
    private String Ime;
    private String Prezime;
    private String Email;

    public Polaznik(String ime, String prezime, String email) {
        Prezime = prezime;
        Ime = ime;
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    @Override
    public String toString() {
        return "Ime: " + getIme() + ", Prezime: " + getPrezime() + ", E-mail: " + getEmail();

    }

    public int hashCode(){
        return Objects.hash(getEmail().toLowerCase());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polaznik drugi = (Polaznik) o;
        return Email.equalsIgnoreCase(drugi.Email);
    }

    public int compareTo(Polaznik o) {
        int rezultat = this.Prezime.compareToIgnoreCase(o.Prezime);
        if (rezultat == 0) {
            rezultat = this.Ime.compareToIgnoreCase(o.Ime);
        }
        if (rezultat == 0) {
            rezultat = this.Email.compareToIgnoreCase(o.Email);
        }
            return rezultat;
    }
}
