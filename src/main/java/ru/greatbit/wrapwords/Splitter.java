package ru.greatbit.wrapwords;

import ru.greatbit.wrapwords.beans.TokenData;
import ru.greatbit.wrapwords.beans.TokenPlaceholder;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ru.greatbit.wrapwords.beans.TokenType.BLANK;

/**
 * Created by azee on 25.08.17.
 */
public class Splitter {
    public static List<TokenData> split(String source, Collection<TokenPlaceholder> placeholders){
        if (placeholders == null || placeholders.size() == 0){
            return Collections.singletonList(new TokenData(source, BLANK));
        }

        List<TokenData> result = new LinkedList<>();
        List<TokenPlaceholder> sortedPlaceholders = placeholders.stream().sorted((v1, v2) -> new Integer(v1.getLeft()).compareTo(v2.getLeft())).collect(toList());
        if (sortedPlaceholders.get(0).getLeft() != 0){
            result.add(new TokenData(source.substring(0, sortedPlaceholders.get(0).getLeft() -1), BLANK));
        }

        for (int i = 0; i < sortedPlaceholders.size(); i++){
            result.add(new TokenData(source.substring(sortedPlaceholders.get(i).getLeft(), sortedPlaceholders.get(i).getRight()), sortedPlaceholders.get(i).getTokenType()));

            //Tokens are not following one by one - there is a blank token in between
            if (i != sortedPlaceholders.size() -1){
                if (sortedPlaceholders.get(i).getRight() + 1 != sortedPlaceholders.get(i + 1).getLeft()){
                    result.add(new TokenData(source.substring(sortedPlaceholders.get(i).getRight() , sortedPlaceholders.get(i + 1).getLeft()), BLANK));
                }
            }
        }

        if (sortedPlaceholders.get(sortedPlaceholders.size() - 1).getRight() != source.length()){
            result.add(new TokenData(source.substring(sortedPlaceholders.get(sortedPlaceholders.size() - 1).getRight(), source.length()), BLANK));
        }

        return result;
    }
}
