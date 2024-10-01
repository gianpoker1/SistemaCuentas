package gian.cuentas.controller;

import gian.cuentas.model.Cuenta;
import gian.cuentas.service.CuentaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
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
    private Cuenta cuentaSeleccionada;

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

    public void agregarCuenta(){
        this.cuentaSeleccionada = new Cuenta();

    }

    public void guardarCuenta(){
        logger.info("Cuenta a guardar: " + this.cuentaSeleccionada);
        //Guardar
        if(this.cuentaSeleccionada.getIdCuenta() == null){
            this.cuentaService.saveCuenta(this.cuentaSeleccionada);
            //agregar la cuenta a la lista de cuentas (tabla)
            this.cuentas.add(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Cuenta agregada con exito"));
        }//editar
        else {
            this.cuentaService.saveCuenta(cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Cuenta actualizada con exito"));

        }
        //cerramos la ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
        //actualizamos la tabla
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes",
                "forma-cuentas:cuentas-tabla");
        // volver el objeto a null
        this.cuentaSeleccionada = null;
    }

    public void eliminarCuenta(){
        logger.info("Cuenta a eliminar: " +this.cuentaSeleccionada);
        this.cuentaService.deleteByIdCuenta(this.cuentaSeleccionada.getIdCuenta());
        //eliminar el registro de la lista de cuentas
        this.cuentas.remove(this.cuentaSeleccionada);
        // volver el objeto a null
        this.cuentaSeleccionada = null;
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Cuenta eliminada con exito"));
        //actualizamos la tabla
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes",
                "forma-cuentas:cuentas-tabla");
    }



}
