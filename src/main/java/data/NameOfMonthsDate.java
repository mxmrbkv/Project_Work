package data;

public enum NameOfMonthsDate {

    JANUARY ("января", 1),
    FEBRUARY ("февраля", 2),
    MARCH("марта", 3),
    APRIL("апреля", 4),
    MAY("мая", 5),
    JUNE("июня", 6),
    JULY("июля", 7),
    AUGUST("августа", 8),
    SEPTEMBER("сентября", 9),
    OCTOBER("октября", 10),
    NOVEMBER("ноября", 11),
    DECEMBER("декабря", 12);

    private String name;
    private int num;

    NameOfMonthsDate(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }


}


