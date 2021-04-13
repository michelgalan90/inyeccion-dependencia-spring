package com.galan.springbootinyeccion.app.controllers;

import com.galan.springbootinyeccion.app.models.service.IServicio;
import com.galan.springbootinyeccion.app.models.service.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*La anotacion Primary se usa cuando hay varias implementaciones de una interfaz o clase abstracta y todas ellas son
 * componentes de spring o beans...en ese caso en la clase concreta en este caso IndexController no sabra cual de las
 * componentes usar, si queremos que sin especificar el @Qualifier escoja una en concreto usamos la anotacion
 * @Primary, solo uno de los componentes debe tener el @Primary - de esta forma se encargara de escoger esa cuando lo inyecte
 * en la clase IndexController.*/

@Controller
public class IndexController {

    /*Tambien puedo usar el @Autowired aca en el campo, y no establecer un constructor, pero el IDE
    * me recomienda que sea usando el constructor y yo estoy de acuerdo con que es mas poderoso de esa forma*/
//    @Autowired
    private IServicio servicio;

    /*Usando el Bean de la clase ConfigurationBean, esa clase me devuelve un componente de tipo String*/
    @Autowired
    @Qualifier("pollitobean")
    private String claseBean;

    @Autowired
    /*Cuando se inyecta en un constructor se puede omitir el uso de @Autowired y el solo lo inyectara de forma implicita
    * si detecta un componente del tipo, pero es mejor siempre ponerlo explicitamente*/
    public IndexController(@Qualifier("miServicio") IServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping({"/index", "/", ""})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        model.addAttribute("pollitobean", claseBean);
        return "index";
    }

//    @Autowired
    /*Usando el Autowired en un setter..., se puede usar aca en un setter en un constructor o incluso en un campo o field*/
    public void setServicio(IServicio servicio) {
        this.servicio = servicio;
    }
}
