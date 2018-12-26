package DOMAWKA;

import gig.ArrayList;
import gig.List;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import org.junit.Before;
import org.junit.Test;
import static org.testng.AssertJUnit.assertEquals;

public class CompilerTest {
    public static class Variable {
        private String st;
        private Number in;
        public Variable(String st, Number in){
            this.st=st;
            this.in=in;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public Number getIn() {
            return in;
        }

        public void setIn(Number in) {
            this.in = in;
        }
    }
    private Compiler compiler;

    @Before
    public void setUp() {
        compiler = new Compiler();
    }

    @Test(expected = SyntaxException.class)
    public void testBad() {
        String input = "A=5";
        compiler.analyse(input);
    }

    @Test
    public void testGood() {
        String input = "x2:=5;";
        compiler.analyse(input);
    }

    @Test
    public void testProcess() {
        String input = "x1:=123;x2:=5;";
        List<Variable> excpeted = new ArrayList<>();
        excpeted.add(new Variable("x1", 123));
        excpeted.add(new Variable("x2", 5));
        excpeted.add(new Variable("x3", 128));

        List<Variable> actual = compiler.process(input);
        assertEquals(excpeted, actual);
    }

}
