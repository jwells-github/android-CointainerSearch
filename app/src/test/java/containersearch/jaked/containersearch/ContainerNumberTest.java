package containersearch.jaked.containersearch;

import org.junit.Test;

import static org.junit.Assert.*;



public class ContainerNumberTest {

    @Test
    public void testValidContainerNumber(){
        String validNumber = "CSQU3054383";
        ContainerNumber validContainerNumber = new ContainerNumber(validNumber);
        assertTrue(validContainerNumber.isValid());
    }
    @Test
    public void testMissingCheckSum(){
        String validNumber = "CSQU305438";
        ContainerNumber validContainerNumber = new ContainerNumber(validNumber);
        assertEquals(validContainerNumber.isValid(), true);
        assertEquals(validContainerNumber.getContainerNumber().length() > validNumber.length(),
                       true);
    }
    @Test
    public void testInvalidCheckSum(){
        String invalidNumber = "CSQU3054388";
        ContainerNumber invalidContainerNumber = new ContainerNumber(invalidNumber);
        assertFalse(invalidContainerNumber.isValid());
    }
    @Test
    public void testInvalidContainerFormat(){
        String invalidNumber = "22223!5X383";
        ContainerNumber invalidContainerNumber = new ContainerNumber(invalidNumber);
        assertFalse(invalidContainerNumber.isValid());
    }
    @Test
    public void testShortContainerNumber(){
        String invalidNumber = "CSQU3054";
        ContainerNumber invalidContainerNumber = new ContainerNumber(invalidNumber);
        assertFalse(invalidContainerNumber.isValid());
    }


}