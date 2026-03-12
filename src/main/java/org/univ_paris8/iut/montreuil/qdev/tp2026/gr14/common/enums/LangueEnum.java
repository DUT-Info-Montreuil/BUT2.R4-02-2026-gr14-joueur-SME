package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums;

public enum LangueEnum{
    FR(1, "Français"),
    EN(2, "English"),
    DE(3, "Deutsch"),
    ES(4, "Espana"),
    IT(5, "Italia");

    private final int code;
    private final String label;

    LangueEnum(int id, String label) {
        this.code = id;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}