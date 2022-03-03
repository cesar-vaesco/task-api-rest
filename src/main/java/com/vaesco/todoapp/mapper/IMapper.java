package com.vaesco.todoapp.mapper;

// <I = dato de entrada, O = dato de salida>
public interface IMapper <I, O>{
// Esta interfaz va a permitir mapear los datos que entran a la salida
    public O map(I in);
}
