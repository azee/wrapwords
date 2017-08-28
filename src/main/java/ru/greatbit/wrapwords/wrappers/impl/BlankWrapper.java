package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.BaseWrapper;
import ru.greatbit.wrapwords.wrappers.Wrapper;

/**
 * Created by azee on 28.08.17.
 */
public class BlankWrapper extends BaseWrapper {

    @Override
    public String convert(String source) {
        return source;
    }
}
