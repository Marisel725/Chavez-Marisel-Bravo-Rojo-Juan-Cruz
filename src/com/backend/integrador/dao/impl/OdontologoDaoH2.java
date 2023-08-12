package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.H2Connection;
import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologo1 = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA , NOMBRE, APELLIDO) VALUES (? , ?, ?) ",  Statement.RETURN_GENERATED_KEYS);
     ps.setInt(1, odontologo.getMatricula());
     ps.setString(2, odontologo.getNombre());
     ps.setString(3,odontologo.getApellido());
     ps.execute();

     connection.commit();

      odontologo1 = new Odontologo(odontologo.getMatricula(),odontologo.getNombre(),odontologo.getApellido());

            ResultSet key = ps.getGeneratedKeys();
            while (key.next()){
                odontologo1.setId(key.getInt(1));
            }

        LOGGER.info("Odontólogo registrado con éxito : " + odontologo1);

    } catch(Exception e){
        LOGGER.error(e.getMessage());
        e.printStackTrace();

        if(connection != null){
            try {
                connection.rollback();
                System.out.println("Tuvimos un problema");
                e.printStackTrace();
            } catch (SQLException exception) {
                LOGGER.error(exception.getMessage());
                exception.printStackTrace();
            }
        }
    } finally {
            try {
                connection.close();//Cierre de la conexión a la base de datos.
            } catch (Exception ex) {
                LOGGER.error("Ocurrió un problema al intentar cerrar la base de datos H2. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return odontologo1;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet key = ps.executeQuery();

            while (key.next()){

                odontologos.add(crearObjetoOdontologo(key));
            }

            LOGGER.info("Listado de los odontólogos :" + odontologos);

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception exception) {
                LOGGER.error("Ocurrió un problema al intentar cerrar la base de datos. " + exception.getMessage());
                exception.printStackTrace();
            }
        }

        return odontologos ;
    }


    private Odontologo crearObjetoOdontologo (ResultSet key) throws SQLException{
        int id = key.getInt(1);
        int matricula = key.getInt(2);
        String nombre = key.getString("nombre");
        String apellido = key.getString("apellido");
        return new Odontologo(id, matricula, nombre, apellido);
    }

}
