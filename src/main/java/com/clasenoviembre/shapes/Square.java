package com.clasenoviembre.shapes;

import com.clasenoviembre.CalcularArea.Area;
public class Square implements Area {

    //atributos
    private double side;

    //constructor
    public Square(double side) {
        this.side = side;
    }

    //metodos
    //getter and setter
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    //metodo para calcular el area del cuadrado
    public double calcularArea() {

       // double area = side * side;
       // return area;

       return Math.pow(side, 2);
    }
    
}
