package com.ejemplo.calculadora.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/")
    public String mostrarCalculadora() {
	System.out.println("mostrando calculadora");
        return "calculadora";
    }

    @GetMapping("/sumar")
    public double sumar(@RequestParam double a, @RequestParam double b) {
	System.out.println("sumando " + a + " + " + b);

        return a + b;
    }

    @GetMapping("/restar")
    public double restar(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new IllegalArgumentException("No se puede dividir por cero");
        return a / b;
    }
}
