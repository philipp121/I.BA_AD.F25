package ch.hslu.ad.A5_EX_Graphen;

public enum City {
    ARTH_GOLDAU(0, "Arth-Goldau"),
    AARAU(1, "Aarau"),
    BRUGG(2, "Brugg"),
    DIETIKON(3, "Dietikon"),
    LENZBURG(4, "Lenzburg"),
    LUZERN(5, "Luzern"),
    PFAEFFIKON(6, "Pfäffikon"),
    ROTKREUZ(7, "Rotkreuz"),
    OLTEN(8, "Olten"),
    WOHLEN(9, "Wohlen"),
    ZOFINGEN(10, "Zofingen"),
    ZUERICH(11, "Zürich"),
    ZUG(12, "Zug");

    private final int index;
    private final String name;

    City(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static City fromName(String name) {
        return switch (name.toLowerCase()) {
            case "arth-goldau" -> ARTH_GOLDAU;
            case "aarau" -> AARAU;
            case "brugg" -> BRUGG;
            case "dietikon" -> DIETIKON;
            case "lenzburg" -> LENZBURG;
            case "luzern" -> LUZERN;
            case "pfäffikon" -> PFAEFFIKON;
            case "rotkreuz" -> ROTKREUZ;
            case "olten" -> OLTEN;
            case "wohlen" -> WOHLEN;
            case "zofingen" -> ZOFINGEN;
            case "zürich", "zuerich" -> ZUERICH;
            case "zug" -> ZUG;
            default -> throw new IllegalArgumentException("Unknown city: " + name);
        };
    }

    public static City fromIndex(int index) {
        return switch (index) {
            case 0 -> ARTH_GOLDAU;
            case 1 -> AARAU;
            case 2 -> BRUGG;
            case 3 -> DIETIKON;
            case 4 -> LENZBURG;
            case 5 -> LUZERN;
            case 6 -> PFAEFFIKON;
            case 7 -> ROTKREUZ;
            case 8 -> OLTEN;
            case 9 -> WOHLEN;
            case 10 -> ZOFINGEN;
            case 11 -> ZUERICH;
            case 12 -> ZUG;
            default -> throw new IllegalArgumentException("Unknown city with index: " + index);
        };
    }

    public static String formatCityName(City city) {
        return switch (city) {
            case ARTH_GOLDAU -> "Arth-Goldau";
            case AARAU -> "Aarau";
            case BRUGG -> "Brugg";
            case DIETIKON -> "Dietikon";
            case LENZBURG -> "Lenzburg";
            case LUZERN -> "Luzern";
            case PFAEFFIKON -> "Pfäffikon";
            case ROTKREUZ -> "Rotkreuz";
            case OLTEN -> "Olten";
            case WOHLEN -> "Wohlen";
            case ZOFINGEN -> "Zofingen";
            case ZUERICH -> "Zürich";
            case ZUG -> "Zug";
        };
    }
}

