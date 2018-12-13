package ourPackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void direction(){


        System.out.println("Direction North");
        assertEquals(0, Direction.N.getDirection());
        System.out.println("Correct");
        System.out.println("Direction North");
        assertEquals(90, Direction.E.getDirection());
        System.out.println("Correct");
        System.out.println("Direction North");
        assertEquals(180, Direction.S.getDirection());
        System.out.println("Correct");
        System.out.println("Direction North");
        assertEquals(270, Direction.W.getDirection());
        System.out.println("Correct");

    }

}