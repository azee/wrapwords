package ru.greatbit.wrapwords;

import org.junit.Test;
import ru.greatbit.wrapwords.beans.TokenData;
import ru.greatbit.wrapwords.beans.TokenPlaceholder;
import ru.greatbit.wrapwords.beans.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 28.08.17.
 */
public class SplitterTest {

    private final static String POST = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";

    @Test
    public void notOrderedPlaceholders(){
        List<TokenPlaceholder> placeholders = Arrays.asList(
                new TokenPlaceholder(14, 22, TokenType.ENTITY),
                new TokenPlaceholder(0, 5, TokenType.ENTITY),
                new TokenPlaceholder(55, 67, TokenType.USERNAME),
                new TokenPlaceholder(37, 54, TokenType.LINK)
        );

        List<TokenData> tokenData = Splitter.split(POST, placeholders);
        assertThat(tokenData.size(), is(6));

        validateTokenData(tokenData.get(0), TokenType.ENTITY, "Obama");
        validateTokenData(tokenData.get(1), TokenType.BLANK, "visited");
        validateTokenData(tokenData.get(2), TokenType.ENTITY, "Facebook");
        validateTokenData(tokenData.get(3), TokenType.BLANK, "headquarters:");
        validateTokenData(tokenData.get(4), TokenType.LINK, "http://bit.ly/xyz");
        validateTokenData(tokenData.get(5), TokenType.USERNAME, "@elversatile");
    }

    @Test
    public void middleEntityTest(){
        List<TokenPlaceholder> placeholders = Arrays.asList(
                new TokenPlaceholder(6, 13, TokenType.ENTITY)
        );
        List<TokenData> tokenData = Splitter.split(POST, placeholders);
        assertThat(tokenData.size(), is(3));

        assertThat(tokenData.get(0).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(0).getValue(), is("Obama"));

        assertThat(tokenData.get(1).getTokenType(), is(TokenType.ENTITY));
        assertThat(tokenData.get(1).getValue(), is("visited"));

        assertThat(tokenData.get(2).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(2).getValue(), is("Facebook headquarters: http://bit.ly/xyz @elversatile"));
    }

    @Test
    public void lastCharacterToken(){
        String post = "Some data";
        List<TokenPlaceholder> placeholders = Arrays.asList(
                new TokenPlaceholder(5, 9, TokenType.ENTITY)
        );
        List<TokenData> tokenData = Splitter.split(post, placeholders);
        assertThat(tokenData.size(), is(2));

        assertThat(tokenData.get(0).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(0).getValue(), is("Some"));

        assertThat(tokenData.get(1).getTokenType(), is(TokenType.ENTITY));
        assertThat(tokenData.get(1).getValue(), is("data"));
    }

    @Test
    public void firstCharacterToken(){
        List<TokenPlaceholder> placeholders = Arrays.asList(
                new TokenPlaceholder(0, 5, TokenType.ENTITY)
        );
        List<TokenData> tokenData = Splitter.split(POST, placeholders);
        assertThat(tokenData.size(), is(2));

        assertThat(tokenData.get(0).getTokenType(), is(TokenType.ENTITY));
        assertThat(tokenData.get(0).getValue(), is("Obama"));

        assertThat(tokenData.get(1).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(1).getValue(), is("visited Facebook headquarters: http://bit.ly/xyz @elversatile"));
    }


    @Test
    public void blankPlaceholdersTest(){
        List<TokenData> tokenData = Splitter.split(POST, null);
        assertThat(tokenData.size(), is(1));
        assertThat(tokenData.get(0).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(0).getValue(), is(POST));

        tokenData = Splitter.split(POST, new ArrayList<>());
        assertThat(tokenData.size(), is(1));
        assertThat(tokenData.get(0).getTokenType(), is(TokenType.BLANK));
        assertThat(tokenData.get(0).getValue(), is(POST));
    }

    private void validateTokenData(TokenData data, TokenType type, String value){
        assertNotNull(data);
        assertThat(data.getTokenType(), is(type));
        assertThat(data.getValue(), is(value));
    }

}
