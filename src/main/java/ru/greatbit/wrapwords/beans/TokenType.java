package ru.greatbit.wrapwords.beans;

/**
 * Created by azee on 24.08.17.
 */
public enum TokenType {
    ENTITY,
    USERNAME,
    LINK,
    BLANK;

    public String value() {
        return name();
    }

    public static TokenType fromValue(String v) {
        return valueOf(v);
    }
}
