package com.utn.tareas.model;

import lombok.*;

@Data //genera setters,getters,equals,to string y hashcode
@AllArgsConstructor //genera constructor con todos los campos
@NoArgsConstructor //genera constructor vacio (necesario para frameworks)

public class Tarea {
    private  Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

}
