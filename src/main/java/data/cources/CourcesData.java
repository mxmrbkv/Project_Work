package data.cources;

public enum CourcesData implements ICourcesData {
    Testing("Тестирование"),
    EventsCalendar("Календарь мероприятий");
    private String name;
    CourcesData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
