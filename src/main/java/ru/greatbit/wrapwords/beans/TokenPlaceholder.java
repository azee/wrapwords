package ru.greatbit.wrapwords.beans;

/**
 * Created by azee on 24.08.17.
 *
 * An input class - type and positions
 *
 */
public class TokenPlaceholder {
    private int left;
    private int right;

    private TokenType tokenType;

    public TokenPlaceholder() {
    }

    public TokenPlaceholder(int left, int right, TokenType tokenType) {
        this.left = left;
        this.right = right;
        this.tokenType = tokenType;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }


    public TokenPlaceholder withLeft(int left){
        setLeft(left);
        return this;
    }

    public TokenPlaceholder withRight(int right){
        setRight(right);
        return this;
    }

    public TokenPlaceholder withTokenType(TokenType tokenType){
        setTokenType(tokenType);
        return this;
    }
}
