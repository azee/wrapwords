package ru.greatbit.wrapwords.wrappers;

import ru.greatbit.wrapwords.beans.TokenType;
import ru.greatbit.wrapwords.wrappers.impl.BlankWrapper;
import ru.greatbit.wrapwords.wrappers.impl.EntityWrapper;
import ru.greatbit.wrapwords.wrappers.impl.LinkWrapper;
import ru.greatbit.wrapwords.wrappers.impl.UsernameWrapper;

/**
 * Created by azee on 28.08.17.
 */
public class WrappersFactory {
    public static Wrapper getWrapper(TokenType type){
        switch (type){
            case ENTITY: return new EntityWrapper();
            case USERNAME: return new UsernameWrapper();
            case LINK: return new LinkWrapper();
        }
        return new BlankWrapper();
    }
}
