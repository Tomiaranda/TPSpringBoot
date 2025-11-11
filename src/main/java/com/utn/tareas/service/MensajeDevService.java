package com.utn.tareas.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {
    @Override
    public void mostrarBienvenida() {
        System.out.println("[DEV] Bienvenido al sistema de tareas en modo DESARROLLO!");
        System.out.println("Puedes probar libremente, los cambios no son permanentes.");
    }
    @Override
    public void mostrarDespedida() {
        System.out.println("[DEV] Fin de la ejecución. ¡Sigue programando con Spring Boot!");
    }
}
