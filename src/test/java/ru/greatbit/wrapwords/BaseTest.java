package ru.greatbit.wrapwords;

import ru.greatbit.wrapwords.beans.TokenPlaceholder;
import ru.greatbit.wrapwords.beans.TokenType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by azee on 28.08.17.
 */
public class BaseTest {
    protected final static String POST = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
    protected List<TokenPlaceholder> placeholders = Arrays.asList(
            new TokenPlaceholder(14, 22, TokenType.ENTITY),
            new TokenPlaceholder(0, 5, TokenType.ENTITY),
            new TokenPlaceholder(55, 67, TokenType.USERNAME),
            new TokenPlaceholder(37, 54, TokenType.LINK)
    );

}
