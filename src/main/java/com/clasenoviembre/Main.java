package com.clasenoviembre;

import java.util.*;

import com.clasenoviembre.shapes.*;

/*
 * import shapes.Square;
import shapes.Rectangle; 
import shapes.Triangle;
import shapes.Circle;       
 */

public class Main {

    /*
     * 
     * crear una variable para almacenar el area total de la casa
     * 
     * Escribir en pantalla:Cuantas habitaciones tiene la casa?
     * 
     * Leer el numero de habitaciones
     * 
     * Para i = 1 hasta el numero de habitaciones hacer
     * Escribir en pantalla: Ingrese la forma de la habitacion (c)uadrado,
     * (r)ectangulo, (t)riangulo, (c)irculo:
     * Leer la forma de la habitacion
     * 
     * Si la forma es cuadrado
     * Crear un objeto de tipo cuadrado
     * Calcular el area del cuadrado
     * Mostrar el area del cuadrado
     * sumar el area del cuadrado al area total de la casa
     * 
     * Sino Si la forma es rectangulo
     * Crear un objeto de tipo rectangulo
     * Calcular el area del rectangulo
     * Mostrar el area del rectangulo
     * sumar el area del rectangulo al area total de la casa
     * 
     * Sino Si la forma es triangulo
     * Crear un objeto de tipo triangulo
     * Calcular el area del triangulo
     * Mostrar el area del triangulo
     * sumar el area del triangulo al area total de la casa
     * 
     * Sino Si la forma es circulo
     * Crear un objeto de tipo circulo
     * Calcular el area del circulo
     * Mostrar el area del circulo
     * sumar el area del circulo al area total de la casa
     * Fin Si
     * Fin Para
     * 
     * Escribir en pantalla: El area total de la casa es: + area total de la casa
     * 
     * 
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double totalArea = 0;

        System.out.println("Cuantas habitaciones tiene la casa?");
        int numRooms = scanner.nextInt();

        // while (numRooms <= 0) { (bloque de instrucciones) numRooms--;}

        for (int i = 1; i <= numRooms; i++) {
            System.out.println("Ingrese la forma de la habitacion (c)uadrado, (r)ectangulo, (t)riangulo, (o)irculo:");
            String shape = scanner.next();
            char shapeType = shape.charAt(0);
            if (shapeType == 'c') {
                System.out.println("Ingrese el lado del cuadrado:");
                double lado = scanner.nextDouble();
                Square cuadrado = new Square(lado);
                double areaCuadrado = cuadrado.calcularArea();
                System.out.println("El area del cuadrado es: " + areaCuadrado);
                // totalArea = totalArea + areaCuadrado;
                totalArea += areaCuadrado;
            } else if (shapeType == 'r') {
                System.out.println("Ingrese el largo del rectangulo:");
                double length = scanner.nextDouble();
                System.out.println("Ingrese el ancho del rectangulo:");
                double width = scanner.nextDouble();
                Rectangle rectangulo = new Rectangle(length, width);
                double areaRectangulo = rectangulo.calcularArea();
                System.out.println("El area del rectangulo es: " + areaRectangulo);
                totalArea += areaRectangulo;
            } else if (shapeType == 't') {
                System.out.println("Ingrese la base del triangulo:");
                double base = scanner.nextDouble();
                System.out.println("Ingrese la altura del triangulo:");
                double height = scanner.nextDouble();
                Triangle triangulo = new Triangle(base, height);
                double areaTriangulo = triangulo.calcularArea();
                System.out.println("El area del triangulo es: " + areaTriangulo);
                totalArea += areaTriangulo;
            } else if (shapeType == 'o') {
                System.out.println("Ingrese el radio del circulo:");
                double radius = scanner.nextDouble();
                Circle circulo = new Circle(radius);
                double areaCirculo = circulo.calcularArea();
                System.out.println("El area del circulo es: " + areaCirculo);
                totalArea += areaCirculo;
            } else {
                System.out.println("Forma no valida. Intente de nuevo.");
                i--; // Decrementar i para repetir esta iteracion
            }

        }

        System.out.println("El area total de la casa es: " + totalArea);
        scanner.close();

    }

}
