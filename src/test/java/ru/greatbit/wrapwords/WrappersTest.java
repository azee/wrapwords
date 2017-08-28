package ru.greatbit.wrapwords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.greatbit.wrapwords.wrappers.Wrapper;
import ru.greatbit.wrapwords.wrappers.impl.BlankWrapper;
import ru.greatbit.wrapwords.wrappers.impl.EntityWrapper;
import ru.greatbit.wrapwords.wrappers.impl.LinkWrapper;
import ru.greatbit.wrapwords.wrappers.impl.UsernameWrapper;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by azee on 28.08.17.
 */
@RunWith(Parameterized.class)
public class WrappersTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new BlankWrapper(), "test", "test" },
                { new BlankWrapper(), "double test", "double test" },
                { new BlankWrapper(), null, "" },
                { new BlankWrapper(), "", "" },
                { new EntityWrapper(), "some data", "<strong>some data</strong>" },
                { new EntityWrapper(), null, "" },
                { new EntityWrapper(), "", "" },
                { new LinkWrapper(), "some data", "<a href='some data'>some data</a>" },
                { new LinkWrapper(), null, "" },
                { new LinkWrapper(), "", "" },
                { new UsernameWrapper(), "@username", " @ <a href='http://twitter.com/username'>username</a>" },
                { new UsernameWrapper(), null, "" },
                { new UsernameWrapper(), "", "" },

        });
    }

    private Wrapper wrapper;
    private String input;
    private String expected;

    public WrappersTest(Wrapper wrapper, String input, String expected) {
        this.wrapper = wrapper;
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testOutput(){
        assertThat(wrapper.wrap(input), is(expected));
    }
}
