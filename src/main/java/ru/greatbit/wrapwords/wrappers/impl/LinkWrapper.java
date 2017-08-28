package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.Wrapper;

import static java.lang.String.format;

/**
 * Created by azee on 28.08.17.
 */
public class LinkWrapper implements Wrapper{

    @Override
    public String wrap(String source) {
        return format("<a href='%s'>%s</a>", source, source);
    }
}
