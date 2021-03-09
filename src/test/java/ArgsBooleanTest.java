import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsBooleanTest {

    @Test
    public void testCreateWithNoSchemaOrArguments() throws Exception {
        ArgsInitial argsBoolean = new ArgsInitial("", new String[0]);
        assertEquals(0, argsBoolean.cardinality());
    }

    @Test
    public void testCreateWithNoSchemaButOneArgument() throws Exception {
        ArgsInitial argsBoolean = new ArgsInitial("", new String[]{"-x"});
        assertFalse(argsBoolean.isValid());
    }

    @Test
    public void testCreateWithNoSchemaButMultipleArgument() throws Exception {
        ArgsInitial argsBoolean = new ArgsInitial("", new String[]{"-x", "-y"});
        assertFalse(argsBoolean.isValid());
    }

    @Test
    public void testSimpleBooleanPresent() throws Exception {
        ArgsInitial argsBoolean = new ArgsInitial("x", new String[]{"-x"});
        assertEquals(1, argsBoolean.cardinality());
        assertTrue(argsBoolean.getBoolean('x'));
    }
}
