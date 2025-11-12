package com.clasenoviembre.shapes;

import com.clasenoviembre.CalcularArea.Area;

public class Triangle implements Area {
   //atributos
private double base;
private double height;



   
    //constructor

//metodo de acceso - Nombre de clase - (Parametros)
   public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }


   //metodos
//metodo de acceso - tipo de dato que retorna - Nombre de metodo - (Parametros)

//getter and setter

public double getBase() {
        return base;
    }

public void setBase(double base) {
        this.base = base;
    }
 
public double getHeight() {
        return height;
    }

public void setHeight(double height) {
        this.height = height;
    }

//metodo para calcular el area del triangulo
public double calcularArea() {

       //double area = (base * height) / 2;
       //return area;

       return (base * height) / 2;
    }


    
    
}