package com.clasenoviembre;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses({AppTest.class})   // Se puede usar SelectClasses para definir clases de test específicas
@SelectPackages("com.clasenoviembre")  // Se puede usar SelectPackages para definir un paquete completo de test
@IncludeTags("integration")
@ExcludeTags("area")
public class AllSuite {
    //NO SE DEFINEN NI ATRIBUTOS NI METODOS
}
