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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;



//Refactorizamos codigo utilizando anotaciones de ParametizeredTest
/*CsvSource - ValueSource */

//Refactorizamos por segunda vez el codigo utilizando anotaciones de TestMethodOrder
/*@TestMethodOrder */

@TestMethodOrder(OrderAnnotation.class)
public class AppTest {

    private Square sqr;
    private Rectangle rct;
    private Circle cr;
    private Triangle tr;

 
       // Este método se ejecuta antes de cada test y sirve para inicializar o reiniciar los objetos
    @BeforeEach           // para asegurarnos de que cada test empiece con un estado limpio.
     void setUp() {
        sqr = null;
        rct = null;
        cr = null;
        tr = null;
 
        System.out.println("Limpiando datos antes del test.");
    }
 
   
    @AfterEach  // Este método se ejecuta después de cada test y se usa para limpiar los datos, liberar memoria o
                // evitar que queden valores viejos entre un test y otro.
    void cleanUp() {
        sqr = null;
        rct = null;
        cr = null;
        tr = null;
 
        System.out.println("✔ Objetos limpiados después del test.");
    }
    
    
    @Order(5)
    @Tag("area")
    @ParameterizedTest
    @ValueSource(doubles = { 12.5, 24.3, 3.14, 8.3 })
    @DisplayName("Calculo de area de Square usando ValueSource y assertEquals verificando\n" + //
                "la construccion del Square y el metodo CalcularArea")
    void AreaSquareTest(double side) {
       sqr = new Square(side);
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

    @Order(4)
    @Tag("area")
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
        rct = new Rectangle(length, width);
        double arearectangle = rct.calcularArea();

        assertEquals(length * width, arearectangle);
    }

    @Order(3)
    @Tag("area")
    @ParameterizedTest
    @ValueSource(doubles = { 6.4, 10.5, 13.1, 50 })
    @DisplayName("Calculo de area de Circle usando ValueSource y assertEquals verificando\n" + //
                "la construccion del Circle y el metodo calcularArea")
    void AreaCircleTest(double radius) {
        cr = new Circle(radius);
        double areacircle = cr.calcularArea();

        assertEquals(Math.pow(radius, 2) * Math.PI, areacircle);
    }

    @Order(1)
    @Tag("area")
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
        tr = new Triangle(base, height);
        double areatrian = tr.calcularArea();

        assertEquals((base * height) / 2, areatrian);
    }

    @Order(2)
    @Tag("area")
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

        tr = new Triangle(base, height);
        cr = new Circle(radius);
        rct = new Rectangle(length, width);
        sqr = new Square(side);

        double areatotal = tr.calcularArea() + cr.calcularArea() + 
        rct.calcularArea() + sqr.calcularArea();

        assertEquals((base * height / 2) + (Math.pow(radius, 2) * Math.PI) +
                (length * width) + Math.pow(side, 2), areatotal);
    }

    @Order(8)
    @Tag("integration")
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
        cr = new Circle(radius);
        cr.setRadius(radiusSet);
        // assertEquals(10, c1.getRadius());

        assertTrue(radiusSet == cr.getRadius());

    }

    @Order(6)
    @Tag("integration")
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
        rct = new Rectangle(length, width);
        rct.setLength(lengthSet);
        rct.setWidth(widthSet);
        // assertEquals(10, r1.getLength()); //evaluando largo
        // assertEquals(4, r1.getWidth()); // evaluando ancho

        assertTrue(lengthSet == rct.getLength() && widthSet == rct.getWidth());
    }

    @Order(7)
    @Tag("integration")
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
        tr = new Triangle(base, height);
        tr.setBase(baseSet);
        tr.setHeight(heightSet);
        assertTrue(tr.getBase() == baseSet && tr.getHeight() == heightSet);
    }
}
