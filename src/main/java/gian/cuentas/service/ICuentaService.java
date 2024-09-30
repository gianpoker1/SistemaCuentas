package gian.cuentas.service;

import gian.cuentas.model.Cuenta;

import java.util.List;

public interface ICuentaService {
    public List<Cuenta> listarCuentas();
    public Cuenta findByIdCuenta(Integer idCuenta);
    public void saveCuenta(Cuenta cuenta);
    public void deleteByIdCuenta(Integer idCuenta);
}
