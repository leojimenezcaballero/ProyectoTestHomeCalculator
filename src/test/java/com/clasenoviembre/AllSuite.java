package com.clasenoviembre;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({AppTest.class})
@IncludeTags("area")
@ExcludeTags("integration")
public class AllSuite {
    //NO SE DEFINEN NI ATRIBUTOS NI METODOS
}
