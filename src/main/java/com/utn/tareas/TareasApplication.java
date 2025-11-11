package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TareasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    // Bean que se ejecutará automáticamente al iniciar la app
    @Bean
    public CommandLineRunner ejecutar(TareaService tareaService, MensajeService mensajeService) {
        return args -> {

            //Mensaje de bienvenida (depende del profile activo)
            mensajeService.mostrarBienvenida();

            //Mostrar configuración actual
            tareaService.mostrarConfiguracion();

            //Listar todas las tareas iniciales
            System.out.println(" TAREAS INICIALES:");
            tareaService.listarTodas().forEach(System.out::println);

            //Agregar una nueva tarea
            System.out.println("\n Agregando una nueva tarea...");
            tareaService.agregarTarea("Preparar informe de entrega", Prioridad.ALTA);

            //Listar solo las tareas pendientes
            System.out.println("\n TAREAS PENDIENTES:");
            tareaService.listarPendientes().forEach(System.out::println);

            //Marcar una tarea como completada
            System.out.println("\n Marcando la tarea con ID 1 como completada...");
            tareaService.marcarComoCompletada(1L);

            //Mostrar estadísticas
            System.out.println("\n" + tareaService.obtenerEstadisticas());

            //Listar solo las completadas
            System.out.println("TAREAS COMPLETADAS:");
            tareaService.listarCompletadas().forEach(System.out::println);

            //Mensaje de despedida (depende del profile activo)
            mensajeService.mostrarDespedida();
        };
    }
}
