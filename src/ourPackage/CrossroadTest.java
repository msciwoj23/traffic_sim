package ourPackage;

import org.junit.Test;

import static org.junit.Assert.*;





public class CrossroadTest extends Roads {


    @Test
    public void crossroadConstructor(){
        int posX = 10;
        int posY = 10;
        int roadsize = 100;
        Crossroad crossroad=new Crossroad(posX,posY,roadsize);
        System.out.println("Class of object");
        assertEquals(Crossroad.class, crossroad.getClass());
        System.out.println("Correct");
        System.out.println("Position X");
        assertEquals(posX, crossroad.getPositionX());
        System.out.println("Correct");
        System.out.println("Position Y");
        assertEquals(posY, crossroad.getPositionY());
        System.out.println("Correct");
        System.out.println("Size of object");
        assertEquals(roadsize, crossroad.getWidth());
        assertEquals(roadsize, crossroad.getHeight());

    }


}