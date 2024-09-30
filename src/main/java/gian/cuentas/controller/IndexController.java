package gian.cuentas.controller;

import gian.cuentas.model.Cuenta;
import gian.cuentas.service.CuentaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    private CuentaService cuentaService;
    private List<Cuenta> cuentas;

    private static final Logger logger= LoggerFactory.getLogger(IndexController.class);

    //se ejecuta despues de la creacion del objeto
    @PostConstruct
    public void init(){
        cargarData();
    }

    public void cargarData(){
        this.cuentas = cuentaService.listarCuentas();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }



}
