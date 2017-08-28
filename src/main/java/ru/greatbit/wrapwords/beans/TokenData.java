package ru.greatbit.wrapwords.beans;

/**
 * Created by azee on 24.08.17.
 */
public class TokenData {
    private String value;

    private TokenType tokenType;

    public TokenData() {
    }

    public TokenData(String value, TokenType tokenType) {
        this.value = value;
        this.tokenType = tokenType;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TokenData withTokenType(TokenType tokenType){
        setTokenType(tokenType);
        return this;
    }

    public TokenData withValue(String value){
        setValue(value);
        return this;
    }

}
