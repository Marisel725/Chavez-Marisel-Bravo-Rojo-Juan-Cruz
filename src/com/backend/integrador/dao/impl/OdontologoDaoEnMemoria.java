package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria  implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologosRepositorio;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosRepositorio) {
        this.odontologosRepositorio = odontologosRepositorio;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologosRepositorio.add(odontologo);
        LOGGER.info("Odontólogo guardado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listado de los odontólogos : " + odontologosRepositorio);
        return odontologosRepositorio;
    }
}

