package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.BaseWrapper;
import ru.greatbit.wrapwords.wrappers.Wrapper;

import static java.lang.String.format;

/**
 * Created by azee on 28.08.17.
 */
public class UsernameWrapper extends BaseWrapper {

    @Override
    public String convert(String source) {
        source = source.substring(1, source.length());
        return format(" @ <a href='http://twitter.com/%s'>%s</a>", source, source);
    }
}
