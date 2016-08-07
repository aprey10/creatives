package com.graywolf.creatives.persistance;

import lombok.Getter;

/**
 * Created by graywolf on 8/7/16.
 */
public enum Country {
    AUSTRALIA(1, "Australia", "AU"),
    AUSTRIA(2, "Austria", "AT"),
    BRAZIL(3, "Brazil", "BR"),
    CROATIA(4, "Croatia", "HR"),
    CUBA(5, "Cuba", "CU"),
    CYPRUS(6, "Cyprus", "CY"),
    CZECH_REPUBLIC(7, "Czech Republic", "CZ"),
    FRANCE(8, "France", "FR"),
    FRANCE_METROPOLITAN(9, "France Metropolitan", "FX"),
    GERMANY(10, "Germany", "DE"),
    GHANA(11, "Ghana", "GH"),
    GIBRALTAR(12, "Gibraltar", "GI"),
    GREECE(13, "Greece", "GR"),
    GREENLAND(14, "Greenland", "GL"),
    GRENADA(15, "Grenada", "GD"),
    GUADELOUPE(16, "Guadeloupe", "GP"),
    KYRGYZSTAN(17, "Kyrgyzstan", "KG"),
    LATVIA(18, "Latvia", "LV"),
    LEBANON(19, "Lebanon", "LB"),
    LESOTHO(20, "Lesotho", "LS"),
    NETHERLANDS_ANTILLES(21, "Netherlands Antilles", "AN"),
    NEW_CALEDONIA(22, "New Caledonia", "NC"),
    SAINT_VINCENT_AND_THE_GRENADINES(23, "Saint Vincent and the Grenadines", "VC"),
    SAMOA(24, "Samoa", "WS"),
    SAN_MARINO(25, "San Marino", "SM"),
    SAO_TOME_AND_PRINCIPE(26, "Sao Tome and Principe", "ST"),
    SWITZERLAND(27, "Switzerland", "CH"),
    SYRIAN_ARAB_REPUBLIC(28, "Syrian Arab Republic", "SY"),
    TAIWAN_PROVINCE_OF_CHINA(29, "Taiwan, Province of China", "TW"),
    UKRAINE(30, "Ukraine", "UA"),
    UNITED_ARAB_EMIRATES(31, "United Arab Emirates", "AE"),
    UNITED_KINGDOM(32, "United Kingdome", "GB"),
    UNITED_STATES(33, "Unites States", "US");

    @Getter
    private int id;
    private String name;
    private String code;

    Country(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public static Country findByName(String name) {
        for (Country country : values()) {
            if (country.name.equals(name)) {
                return country;
            }
        }
        return null;
    }

    public static Country findByCode(String code) {
        for (Country country : values()) {
            if (country.code.equals(code)) {
                return country;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return name;
    }

}
