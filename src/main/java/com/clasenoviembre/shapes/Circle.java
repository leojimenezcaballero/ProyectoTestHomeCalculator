package com.clasenoviembre.shapes;
import com.clasenoviembre.CalcularArea.Area;
public class Circle implements Area {
    //atributos
    private double radius;

    //constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    //metodos
    //getter and setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //metodo para calcular el area del circulo
    public double calcularArea() {

      //  double area =  Math.PI * Math.pow(radius,2);
       // return area;
     return Math.PI * Math.pow(radius, 2);

    }

}