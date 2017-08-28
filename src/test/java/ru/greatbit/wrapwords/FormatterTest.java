package ru.greatbit.wrapwords;

import org.junit.Test;
import ru.greatbit.wrapwords.beans.TokenData;
import ru.greatbit.wrapwords.beans.TokenType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 28.08.17.
 */
public class FormatterTest extends BaseTest{

    @Test
    public void byPlaceholdersTest(){
        assertThat(Formatter.format(POST, placeholders), is("<strong>Obama</strong> visited <strong>Facebook</strong> " +
                "headquarters: <a href='http://bit.ly/xyz'>http://bit.ly/xyz</a> @ <a href='http://twitter.com/elversatile'>elversatile</a>"));
    }

    @Test
    public void multitokensTest(){
        assertThat(Formatter.format(Arrays.asList(
                    new TokenData("Entity", TokenType.ENTITY),
                    new TokenData("blank", TokenType.BLANK),
                    new TokenData("link", TokenType.LINK),
                    new TokenData("blank2", TokenType.BLANK),
                    new TokenData("user", TokenType.USERNAME)
                )),
                is("<strong>Entity</strong>blank<a href='link'>link</a>blank2 @ <a href='http://twitter.com/ser'>ser</a>"));
    }

    @Test
    public void blankDataTest(){
        assertThat(Formatter.format(null), is(""));
        assertThat(Formatter.format(new ArrayList()), is(""));
    }
}
