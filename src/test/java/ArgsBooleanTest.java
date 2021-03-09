import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsBooleanTest {

    @Test
    public void testCreateWithNoSchemaOrArguments() throws Exception {
        ArgsBoolean argsBoolean = new ArgsBoolean("", new String[0]);
        assertEquals(0, argsBoolean.cardinality());
    }

    @Test
    public void testCreateWithNoSchemaButOneArgument() throws Exception {
        ArgsBoolean argsBoolean = new ArgsBoolean("", new String[]{"-x"});
        assertFalse(argsBoolean.isValid());
    }

    @Test
    public void testCreateWithNoSchemaButMultipleArgument() throws Exception {
        ArgsBoolean argsBoolean = new ArgsBoolean("", new String[]{"-x", "-y"});
        assertFalse(argsBoolean.isValid());
    }

    @Test
    public void testSimpleBooleanPresent() throws Exception {
        ArgsBoolean argsBoolean = new ArgsBoolean("x", new String[]{"-x"});
        assertEquals(1, argsBoolean.cardinality());
        assertTrue(argsBoolean.getBoolean('x'));
    }
}
