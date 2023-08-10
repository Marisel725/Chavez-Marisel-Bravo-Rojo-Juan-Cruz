package com.backend.integrador.dao;

import java.util.List;

public interface IDao<T> {
 T guardarOdontologo(T t);
 List<T> listarOdontologos();

}

//Acá irá todos los métodos que nos pide el enunciado.