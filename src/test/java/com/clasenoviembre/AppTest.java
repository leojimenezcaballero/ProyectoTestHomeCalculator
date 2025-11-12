package com.clasenoviembre;

import org.junit.jupiter.api.Test;

import com.clasenoviembre.shapes.Circle;
import com.clasenoviembre.shapes.Rectangle;
import com.clasenoviembre.shapes.Square;
import com.clasenoviembre.shapes.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void AreaSquareTest() {
        Square sqr = new Square(42.2);
        double areasquare = sqr.calcularArea();

        assertEquals(Math.pow(42.2, 2), areasquare);
    }

    @Test
    void AreaSquareTestNot() {
        Square sqr = new Square(42.2);
        double areasquare = sqr.calcularArea();

        assertNotEquals(Math.pow(42.2, 5), areasquare);
    }

    @Test
    void AreaRectangleTest() {
        Rectangle rect = new Rectangle(10, 15);
        double arearectangle = rect.calcularArea();

        assertEquals(150, arearectangle);
    }

    @Test
    void AreaCircleTest() {
        Circle circ = new Circle(2);
        double areacircle = circ.calcularArea();

        assertEquals(4 * Math.PI, areacircle);
    }

    @Test
    void AreaTriangleTest() {
        Triangle trian = new Triangle(4, 8);
        double areatrian = trian.calcularArea();

        assertEquals(16, areatrian);
    }

    @Test
    void AreaTotalTest() {
        Triangle trian = new Triangle(4, 8);
        Circle circ = new Circle(2);
        Rectangle rect = new Rectangle(10, 15);
        Square sqr = new Square(42.2);

        double areatotal = trian.calcularArea() + circ.calcularArea() + rect.calcularArea()+ sqr.calcularArea();
    
        assertEquals(16+4 * Math.PI+150+Math.pow(42.2, 2), areatotal);
    }

    @Test
    void GetSetRadiusTest(){
        Circle c1 = new Circle(5);
        c1.setRadius(15);
        //assertEquals(10, c1.getRadius());

        assertTrue(15==c1.getRadius());      
    
    }

    @Test
    void GetSetRect(){
        Rectangle r1 = new Rectangle(5, 3);
        r1.setLength(10);
        r1.setWidth(4);
       // assertEquals(10, r1.getLength());  //evaluando largo
      //  assertEquals(4, r1.getWidth());  // evaluando ancho

        assertTrue(10==r1.getLength()&&4==r1.getWidth() );
    }
}
