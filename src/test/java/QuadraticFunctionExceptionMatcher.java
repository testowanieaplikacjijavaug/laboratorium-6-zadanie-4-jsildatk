import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.concurrent.Callable;

public class QuadraticFunctionExceptionMatcher {
    
    public static Matcher<Callable<?>> throwsException(Class<?> clazz) {
        return new TypeSafeMatcher<Callable<?>>() {
            @Override
            protected boolean matchesSafely(Callable<?> callable) {
                try {
                    callable.call();
                    return false;
                } catch ( Throwable t ) {
                    return t.getClass()
                            .equals(clazz);
                }
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected exception but nothing was thrown");
            }
        };
    }
    
}
