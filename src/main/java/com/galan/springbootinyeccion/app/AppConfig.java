package com.galan.springbootinyeccion.app;

import com.galan.springbootinyeccion.app.models.domain.ItemFactura;
import com.galan.springbootinyeccion.app.models.domain.Producto;
import com.galan.springbootinyeccion.app.models.service.IServicio;
import com.galan.springbootinyeccion.app.models.service.MiServicio;
import com.galan.springbootinyeccion.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
//    @Primary
    public IServicio miServicio(){
        return new MiServicio();
    }

    @Bean
    @Primary
    public IServicio miServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Aro 26", 200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1, linea2);

    }
    @Bean("itemsFacturaOficina")
    @Primary
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor LG LCD 24", 250);
        Producto producto2 = new Producto("Notebook Asuuus", 500);
        Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
        Producto producto4 = new Producto("Escritorio Oficina", 300);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 1);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 1);

        return Arrays.asList(linea1, linea2, linea3, linea4);

    }
}
