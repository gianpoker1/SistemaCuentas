package gian.cuentas.service;

import gian.cuentas.model.Cuenta;
import gian.cuentas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    private CuentaRepository repository;

    @Override
    public List<Cuenta> listarCuentas() {
        return repository.findAll();
    }

    @Override
    public Cuenta findByIdCuenta(Integer idCuenta) {
        return repository.findById(idCuenta).orElse(null);
    }

    @Override
    public void saveCuenta(Cuenta cuenta) {
        repository.save(cuenta);
    }

    @Override
    public void deleteByIdCuenta(Integer idCuenta) {
        repository.deleteById(idCuenta);
    }
}
