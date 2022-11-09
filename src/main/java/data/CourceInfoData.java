package data;

public enum CourceInfoData {

    TITLE("Java QA Engineer. Basic"),
    DISCRIPTION("Автоматизация тестирования на Java с нуля"),
    DURATIONOFTRANING("4 месяца"),
    FORMAT("Online"),
    STARTLESSON("декабря");




    private String name;
    CourceInfoData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
