package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    //Inyectamos las propiedades definidas en application.properties
    @Value("${app.nombre}")
    private String nombreAplicacion;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    //Inyección de dependencias por constructor
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }



    //Agrega una nueva tarea validando el máximo permitido
    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        List<Tarea> todas = tareaRepository.obtenerTodas();

        // Validamos el límite configurado
        if (todas.size() >= maxTareas) {
            throw new IllegalStateException(
                    "❌ No se pueden agregar más tareas. Límite máximo: " + maxTareas);
        }

        Tarea nueva = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.guardar(nueva);
    }

    //Lista todas las tareas
    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    //Lista solo las tareas pendientes
    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    // Lista solo las tareas completadas
    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    //Muestra las estadísticas si están habilitadas
    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "⚠️ Las estadísticas están deshabilitadas por configuración.";
        }

        List<Tarea> todas = tareaRepository.obtenerTodas();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = todas.size() - completadas;

        return String.format("""
                📊 ESTADÍSTICAS:
                Total de tareas: %d
                Completadas: %d
                Pendientes: %d
                """, todas.size(), completadas, pendientes);
    }
    // Marca una tarea como completada según su ID
    public boolean marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(t -> {
                    t.setCompletada(true);
                    return true;
                })
                .orElse(false);
    }


    // Muestra la configuración actual en consola
    public void mostrarConfiguracion() {
        System.out.println(" CONFIGURACIÓN ACTUAL:");
        System.out.println("Nombre de la aplicación: " + nombreAplicacion);
        System.out.println("Máximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
        System.out.println("--------------------------------------");
    }
}
