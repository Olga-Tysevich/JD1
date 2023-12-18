package org.example.lesson8generics_enum.seaons;
public enum Seasons {
    WINTER("Зима", 90),
    SPRING("Весна", 92),
    SUMMER("Лето", 92),
    AUTUMN("Осень", 91);

    private String description;
    private int countOfDays;

    Seasons(String description, int countOfDays) {
        this.description = description;
        this.countOfDays = countOfDays;
    }

    public static void printNextSeason(Seasons season) {
        String next = season.ordinal() != Seasons.values().length - 1 ?
                Seasons.values()[season.ordinal() + 1].getDescription() : Seasons.values()[0].getDescription();
        System.out.println(next);
    }

    public static void printCountOfDays(Seasons season) {
        System.out.println(Seasons.values()[season.ordinal()].getCountOfDays());
    }

    public String getDescription() {
        return description;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

}
