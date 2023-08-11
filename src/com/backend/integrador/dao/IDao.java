package com.backend.integrador.dao;

import java.util.List;

public interface IDao<T> {
 T guardarOdontologo(T t);
 List<T> listarOdontologos();
//recuerden que deberia ser generico el nombre para poder usar con todas las entidades, si bien aca tenemos solo una, siempre en la interfaz general va generico, ej: guardar(), listarTodos()...
}

//Acá irá todos los métodos que nos pide el enunciado.