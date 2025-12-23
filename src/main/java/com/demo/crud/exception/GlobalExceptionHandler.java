package com.demo.crud.exception;

// Importa HttpStatus: enum que representa códigos HTTP (200, 400, 404, 500, etc.).
// Aquí se usa para devolver un 400 BAD_REQUEST cuando hay errores de validación.
import org.springframework.http.HttpStatus;

// Importa ResponseEntity: clase que permite construir respuestas HTTP completas
// (cuerpo + código de estado + headers).
// Se usa cuando quieres controlar exactamente qué devuelve tu API.
import org.springframework.http.ResponseEntity;

// Excepción lanzada por Spring cuando fallan validaciones hechas con @Valid
// y anotaciones como @NotNull, @NotBlank, @Size, etc.
import org.springframework.web.bind.MethodArgumentNotValidException;

// Permite capturar excepciones específicas con métodos anotados.
// Spring llama automáticamente a estos métodos cuando ocurre la excepción indicada.
import org.springframework.web.bind.annotation.ExceptionHandler;

// Indica que esta clase manejará excepciones de TODOS los controladores REST.
// Es como un "try-catch global" para la aplicación.
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Importa HashMap: implementación concreta de Map.
// Se usa para almacenar pares clave-valor (campo -> mensaje de error).
import java.util.HashMap;

// Importa Map: interfaz que define estructuras clave-valor.
// Se usa para devolver los errores de forma estructurada en JSON.
import java.util.Map;

// Anotación clave 🔥
// Indica que esta clase es un manejador global de excepciones para controladores REST.
// Combina @ControllerAdvice + @ResponseBody.
@RestControllerAdvice(basePackages = "com.demo.crud.controller")
public class GlobalExceptionHandler {

    // Este método manejará específicamente la excepción:
    // MethodArgumentNotValidException
    // Es decir: cuando un @RequestBody con @Valid falla.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(

            // Recibe la excepción lanzada por Spring
            // Contiene toda la información sobre qué validaciones fallaron.
            MethodArgumentNotValidException ex
    ) {

        // Creamos un Map donde:
        // clave   -> nombre del campo que falló
        // valor   -> mensaje de error asociado a ese campo
        // Esto se convertirá automáticamente a JSON.
        Map<String, String> errores = new HashMap<>();

        // getBindingResult() obtiene el resultado de la validación
        // getFieldErrors() devuelve la lista de errores por campo
        // forEach recorre cada error encontrado
        ex.getBindingResult().getFieldErrors().forEach(error ->

                // error.getField()        -> nombre del atributo (ej: "email")
                // error.getDefaultMessage() -> mensaje definido en la anotación
                // Ej: @NotBlank(message = "El email es obligatorio")
                errores.put(error.getField(), error.getDefaultMessage())
        );

        // Se devuelve:
        // - El mapa de errores como cuerpo (JSON)
        // - Código HTTP 400 BAD_REQUEST
        // Esto es lo correcto semánticamente cuando el cliente envía datos inválidos.
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
