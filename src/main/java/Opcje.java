public enum Opcje {
    DODAJ_PRZYCHOD (1,"Dodanie nowego przychodu"),
    DODAJ_WYDATEK (2,"Dodanie nowego wydatku"),
    POKAZ_PRZYCHODY (3,"Wyświetlenie wszystkich przychodów"),
    POKAZ_WYDATKI (4,"Wyświetlenie wszystkich wydatków"),
    KONIEC (5, "Koniec programu");

    private final String name;
    private final int nr;

    Opcje(int i, String name) {
        this.name = name;
        this.nr=i;
    }

    public String getName() {
        return name;
    }

    public int getNr() {
        return nr;
    }
}
