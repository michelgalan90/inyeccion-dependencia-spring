package com.galan.springbootinyeccion.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioSimple")
//@Primary
/*La anotacion Primary se usa cuando hay varias implementaciones de una interfaz o clase abstracta y todas ellas son
 * componentes de spring o beans...en ese caso en la clase concreta en este caso IndexController no sabra cual de las
 * componenetes usar, si queremos que sin especificar el @Qualifier escoja una en concreto usamos la anotacion
 * @Primary, solo uno de los componentes debe tener el @Primary - de esta forma se encargara de escoger esa cuando lo inyecte
 * en la clase IndexController.*/
public class MiServicio implements IServicio{

    @Override
    public String operacion(){
        return "ejecutando algun proceso importante simple...";
    }
}
