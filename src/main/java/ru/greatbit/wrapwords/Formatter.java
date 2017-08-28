package ru.greatbit.wrapwords;

import ru.greatbit.wrapwords.beans.TokenData;
import ru.greatbit.wrapwords.beans.TokenPlaceholder;
import ru.greatbit.wrapwords.wrappers.WrappersFactory;

import java.util.List;

/**
 * Created by azee on 24.08.17.
 */
public class Formatter {
    public static String format(List<TokenData> tokenPlaceholders){
        StringBuffer sb = new StringBuffer();
        tokenPlaceholders.forEach(val -> sb.append(WrappersFactory.getWrapper(val.getTokenType()).wrap(val.getValue())));
        return sb.toString();
    }

}
