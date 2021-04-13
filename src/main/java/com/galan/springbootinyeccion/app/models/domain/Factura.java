package com.galan.springbootinyeccion.app.models.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope
public class Factura implements Serializable {


    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
//    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    /*Cuando yo hago un request para probar el tema de Cliente siendo de tipo RequestScope
    * este metodo no se vuelve a ejecutar porque el componente Factura ya esta en memoria porque es de SessionScope
    * por lo tanto ya se construyo no ejecuta nuevamente el PostConstruct, si ponemos el Factura con
    * RequestScope cada vez que  yo haga un request a factura/ver entonces devolvera un objeto de factura diferente
    * otro diferente al anterior.*/
    @PostConstruct
    public void inicializar(){
        /*Se ejecuta justo despues de que se crea el objeto y se inyecta las dependencias...*/
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }
    /*La anotacion @PostConstruct y @PreDestroy tambien se puede implementar usando interfaces
    * implementando la interfaz InitializingBean y DisposableBean... pero con las anotaciones creo que queda
    * mas limpio el codigo...*/

    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
