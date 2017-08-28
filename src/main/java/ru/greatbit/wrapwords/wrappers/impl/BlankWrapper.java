package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.Wrapper;

/**
 * Created by azee on 28.08.17.
 */
public class BlankWrapper implements Wrapper {

    @Override
    public String wrap(String source) {
        return source;
    }
}
