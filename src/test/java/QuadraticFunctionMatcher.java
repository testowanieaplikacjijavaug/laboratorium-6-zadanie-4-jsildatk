import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class QuadraticFunctionMatcher {
    
    public static Matcher<QuadraticFunction> hasA(final double a) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getA() == a;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected a to be: ")
                        .appendValue(a);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasB(final double b) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getB() == b;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected b to be: ")
                        .appendValue(b);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasC(final double c) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getC() == c;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected c to be: ")
                        .appendValue(c);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasX1(final double x1) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getX1() == x1;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected x1 to be: ")
                        .appendValue(x1);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasX2(final double x2) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getX2() == x2;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected x2 to be: ")
                        .appendValue(x2);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasSameSolutions(final double x1) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                return quadraticFunction.getX1() == x1 && quadraticFunction.getX2() == x1;
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected x1 and x2 to be: ")
                        .appendValue(x1);
            }
        };
    }
    
    public static Matcher<QuadraticFunction> hasOppositeSolutions(final double x1) {
        return new TypeSafeMatcher<QuadraticFunction>() {
            @Override
            protected boolean matchesSafely(QuadraticFunction quadraticFunction) {
                if ( quadraticFunction.getX1() > quadraticFunction.getX2() ) {
                    return x1 == quadraticFunction.getX1() && x1 == (-1) * quadraticFunction.getX2();
                } else {
                    return x1 == (-1) * quadraticFunction.getX1() && x1 == quadraticFunction.getX2();
                }
            }
            
            @Override
            public void describeTo(Description description) {
                description.appendText("Expected x1 and x2 to have opposite values: ")
                        .appendValue(x1);
            }
        };
    }
    
}