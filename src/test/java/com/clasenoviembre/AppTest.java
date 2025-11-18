package com.clasenoviembre;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.clasenoviembre.shapes.Circle;
import com.clasenoviembre.shapes.Rectangle;
import com.clasenoviembre.shapes.Square;
import com.clasenoviembre.shapes.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

//Refactorizamos codigo utilizando anotaciones de ParametizeredTest
/*CsvSource - ValueSource */

public class AppTest {

    private Square sqr;
    private Rectangle rct;
    private Circle cr;
    private Triangle tr;

    
    @ParameterizedTest
    @ValueSource(doubles = { 12.5, 24.3, 3.14, 8.3 })
    @DisplayName("Calculo de area de Square usando ValueSource y assertEquals verificando\n" + //
                "la construccion del Square y el metodo CalcularArea")
    void AreaSquareTest(double side) {
        Square sqr = new Square(side);
        double areasquare = sqr.calcularArea();

        assertEquals(Math.pow(side, 2), areasquare);
    }

    /*
     * @Test
     * void AreaSquareTestNot() {
     * Square sqr = new Square(42.2);
     * double areasquare = sqr.calcularArea();
     * 
     * assertNotEquals(Math.pow(42.2, 5), areasquare);
     * }
     */

    
    @ParameterizedTest
    @CsvSource({
            /* length , width */
            "7   ,   4",
            "10  ,   5",
            "15  ,   7",
            "25   ,   2"
    })
    @DisplayName("Calculo de area de Rectangle usando CsvSource y assertEquals verificando\n" + //
                "la construccion del Rectangle y el metodo CalcularArea")
    void AreaRectangleTest(double length, double width) {
        System.out.println(length + " " + width);
        Rectangle rect = new Rectangle(length, width);
        double arearectangle = rect.calcularArea();

        assertEquals(length * width, arearectangle);
    }

    
    @ParameterizedTest
    @ValueSource(doubles = { 6.4, 10.5, 13.1, 50 })
    @DisplayName("Calculo de area de Circle usando ValueSource y assertEquals verificando\n" + //
                "la construccion del Circle y el metodo calcularArea")
    void AreaCircleTest(double radius) {
        Circle circ = new Circle(radius);
        double areacircle = circ.calcularArea();

        assertEquals(Math.pow(radius, 2) * Math.PI, areacircle);
    }

   
    @ParameterizedTest
    @CsvSource({
            /* base , height */
            "2   ,   5",
            "8   ,   4",
            "6   ,   12",
            "18   ,  10",
            "20   ,  30"
    })
    @DisplayName("Calculo de area de Triangle usando CsvSource y assertEquals verificando\n" + //
                "la construccion del Triangle y el metodo CalcularArea")
    void AreaTriangleTest(double base, double height) {
        Triangle trian = new Triangle(base, height);
        double areatrian = trian.calcularArea();

        assertEquals((base * height) / 2, areatrian);
    }

    @ParameterizedTest
    @CsvSource({
        /* base , height , radius , length , width , side */
            "2   ,   5    ,  10    ,  8    ,   4   ,  7  ",
            "10  ,   105  ,  200   ,  48   ,   78  ,  53  ",
            "12  ,   23   ,  20    ,  60   ,   65  ,  78  ",
            "45  ,  54    ,  5     ,  2    ,   7   ,  15  ",
            "53  ,  60    ,  90    ,  100  ,  47   ,  1  "
    })
    @DisplayName("Calculo del area Total usando CsvSource y assertEquals verificando\n" + //
                "la construccion de cada figura y el metodo CalcularArea")
    void AreaTotalTest(double base, double height,
            double radius, double length, double width, double side) {

        Triangle trian = new Triangle(base, height);
        Circle circ = new Circle(radius);
        Rectangle rect = new Rectangle(length, width);
        Square sqr = new Square(side);

        double areatotal = trian.calcularArea() + circ.calcularArea() + 
        rect.calcularArea() + sqr.calcularArea();

        assertEquals((base * height / 2) + (Math.pow(radius, 2) * Math.PI) +
                (length * width) + Math.pow(side, 2), areatotal);
    }

    
    @ParameterizedTest  
    @CsvSource({
            /* radius , radiusSet */
               "2    ,    5",
               "8    ,    4",
               "6    ,    12",
               "18   ,    10",
               "20   ,    30"
    })
    @DisplayName("Seteo de radius usando CsvSource y assertTrue verificando\n" + //
                "la construccion del circle y el metodo getRadius")
    void GetSetRadiusTest(double radius, double radiusSet) {
        Circle c1 = new Circle(radius);
        c1.setRadius(radiusSet);
        // assertEquals(10, c1.getRadius());

        assertTrue(radiusSet == c1.getRadius());

    }

    
    @ParameterizedTest
    @CsvSource({
        /* length , width , lengthSet , widthSet  */
            "2   ,   5    ,   10    ,    8   ",
            "10  ,   105  ,   200   ,    48  ",
            "12  ,   23   ,   20    ,    60  ",
            "45  ,  54    ,   5     ,    2   ",
            "53  ,  60    ,   90    ,    100  "
    })
    @DisplayName("Seteo de length y width usando CsvSource y assertTrue verificando\n" + //
                "la construccion del rectangle y el metodo getLenght y getWidth")
    void GetSetRect(double length, double width, double lengthSet, double widthSet) {
        Rectangle r1 = new Rectangle(length, width);
        r1.setLength(lengthSet);
        r1.setWidth(widthSet);
        // assertEquals(10, r1.getLength()); //evaluando largo
        // assertEquals(4, r1.getWidth()); // evaluando ancho

        assertTrue(lengthSet == r1.getLength() && widthSet == r1.getWidth());
    }

    
    @ParameterizedTest   
    @CsvSource({
        /* base , height , baseSet , heightSet  */
            "2   ,   5    ,   10    ,    8   ",
            "10  ,   105  ,   200   ,    48  ",
            "12  ,   23   ,   20    ,    60  ",
            "45  ,  54    ,   5     ,    2   ",
            "53  ,  60    ,   90    ,    100  "
    })
    @DisplayName("Seteo de base y height usando CsvSource y assertTrue verificando\n" + //
                "la construccion del triangle y el metodo getBase y getHeight")
    void GetSetTriangle(double base , double height , double baseSet , double heightSet) {
        Triangle t1 = new Triangle(base, height);
        t1.setBase(baseSet);
        t1.setHeight(heightSet);
        assertTrue(t1.getBase() == baseSet && t1.getHeight() == heightSet);
    }
}
