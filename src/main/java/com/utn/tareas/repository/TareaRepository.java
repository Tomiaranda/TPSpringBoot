package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas =new ArrayList<>();  //almacenamiento temporal
    private final AtomicLong contador=new AtomicLong(1); //genera id automáticos
   //tareas de ejemplo
    public TareaRepository(){
        tareas.add(new Tarea(contador.getAndIncrement(),"Tarea 1",false, Prioridad.ALTA));
        tareas.add(new Tarea(contador.getAndIncrement(),"Tarea 2",true, Prioridad.BAJA));
        tareas.add(new Tarea(contador.getAndIncrement(),"Tarea 3",false, Prioridad.MEDIA));

    }
    public Tarea guardar(Tarea tarea){
        tarea.setId(contador.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }
    //devuelve todas las tareas existentes
    public List<Tarea> obtenerTodas(){
        return new ArrayList<>(tareas);
    }
    //Buscar tarea por id
    public Optional<Tarea> buscarPorId(long id){
        return tareas.stream()
                .filter(tarea -> tarea.getId()==id)
                .findFirst();
    }
    //eliminar una terea por ID (si existe)
    public boolean eliminarPorId(long id){
        return tareas.removeIf(t ->t.getId().equals(id)); //elimina si el id coincide
    }
}



