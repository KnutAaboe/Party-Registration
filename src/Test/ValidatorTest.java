package Test;

import Klasser.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    private Validator v;

    @Before
    public final void setup() throws Exception {
        v = new Validator();
    }

    @Test
    public final void testFornavn() {
        assertTrue(v.isFornavnValid("Peter"));
        assertFalse(v.isFornavnValid("nyooom"));
        assertFalse(v.isFornavnValid("A"));
    }

    @Test
    public final void testEtternavn() {
        assertTrue(v.isEtternavnValid("Opstad"));
        assertTrue(v.isEtternavnValid("Knut-Anders"));
        assertFalse(v.isEtternavnValid("liten"));
        assertFalse(v.isEtternavnValid("B"));
    }

    @Test
    public final void testMobil() {
        assertTrue(v.isMobilValid("91939495"));
        assertTrue(v.isMobilValid("00939495"));
        assertFalse(v.isMobilValid("9193949"));
        assertFalse(v.isMobilValid("9193949A"));
        assertFalse(v.isMobilValid("9143649938"));
    }

    @Test
    public final void testKjonn() {
        assertTrue(v.isKjonnValid("mann"));
        assertFalse(v.isKjonnValid(null));
    }

    @Test
    public final void testPassord() {
        assertTrue(v.isPassordValid("passord", "passord"));
        assertFalse(v.isPassordValid("passord", "passord1"));
        assertFalse(v.isPassordValid("pas", "pas"));
    }

}