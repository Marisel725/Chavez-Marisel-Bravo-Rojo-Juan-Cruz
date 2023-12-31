package com.backend.integrador.test;

import com.backend.integrador.dao.impl.OdontologoDaoH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

     OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

     @Test
     public void deberíaListarTodosLosOdontologos(){
          List<Odontologo> odontologosTest = odontologoService.listarTodos();
          assertFalse(odontologosTest.isEmpty());
     }

     @Test

     public void ListarOdontologosConNuevoRegistro(){
          Odontologo odontologo1 = new Odontologo(34562,"Gala","Chavez");
          Odontologo agregarOdontologo = odontologoService.guardar(odontologo1);

          assertNotNull(agregarOdontologo);
          assertEquals(34562, agregarOdontologo.getMatricula());

     }

}
