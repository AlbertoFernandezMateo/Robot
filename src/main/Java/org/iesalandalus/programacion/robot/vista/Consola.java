package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

public class Consola {
    private static void Consola() {

    }

    public void mostrarMenuPrincipal() {
        System.out.println("1. controlar un robot por defecto");
        System.out.println("2. controlar un robot indicando su zona");
        System.out.println("3. controlar un robot indicando su zona y orientación ");
        System.out.println("4. controlar un robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5. ejecutar comando");
        System.out.println("6. salir ");
    }

    public static int elegirOpcion() {
        System.out.println("¿Que opción quieres elegir?");
        int numeroEntrada;
        do {
            numeroEntrada = Entrada.entero();
        } while (numeroEntrada < 1 || numeroEntrada > 6);
        return numeroEntrada;
    }

    public static Zona elegirZona() {
        int alto;
        int ancho;

        do {
            System.out.println("Dime el alto");
            alto = Entrada.entero();
        } while (alto < 10 || alto > 100);
        do {
            System.out.println("Dime el ancho");
            ancho = Entrada.entero();
        } while (ancho < 10 || ancho > 100);
        return new Zona(alto, ancho);
    }
    public void mostrarMenuOrientacion(){
        System.out.println("1. NORTE");
        System.out.println("2. NORESTE");
        System.out.println("3. ESTE");
        System.out.println("4. SURESTE");
        System.out.println("5. SUR");
        System.out.println("6. SUROESTE");
        System.out.println("7. OESTE");
        System.out.println("8. NOROESTE");
    }
    public static Orientacion elegirOrientacion() {
        int numOrientacion;
        Orientacion nuevaOrientacion = null;

        do{
            System.out.println("Dime hacia donde quieres ir.");
            numOrientacion = Entrada.entero();
        } while (numOrientacion < 1 || numOrientacion > 8);
         switch (numOrientacion){
            case 1 -> nuevaOrientacion = Orientacion.NORTE;
            case 2 -> nuevaOrientacion = Orientacion.NORESTE;
            case 3 -> nuevaOrientacion = Orientacion.ESTE;
            case 4 -> nuevaOrientacion = Orientacion.SURESTE;
            case 5 -> nuevaOrientacion = Orientacion.SUR;
            case 6 -> nuevaOrientacion = Orientacion.SUROESTE;
            case 7 -> nuevaOrientacion = Orientacion.OESTE;
            case 8 -> nuevaOrientacion = Orientacion.NOROESTE;
            default -> throw new RobotExcepcion("Comando desconocido.");
        }
        return nuevaOrientacion;
    }
    public static Coordenada elegirCoordenada(){
        int x;
        int y;
        do{
            System.out.println("Dime el valor 'x' de la coordenada.");
            x = Entrada.entero();
        } while (x < 10 || x > 100);
        do{
            System.out.println("Dime el valor 'y' de la coordenada.");
            y = Entrada.entero();
        } while (y < 10 || y > 100);
        return new Coordenada(x,y);
    }
    public static char elegirComando(){
        char comando;
        System.out.println("Elige que comando quieres elegir: Avanzar (A,a), Girar a la derecha ( D,d ) o Girar a la izquierda (I,i)");
        comando = Entrada.caracter();
        return comando;
    }
    public static void mostrarRobot(ControladorRobot controladorRobot){
        Objects.requireNonNull(controladorRobot, "No puede ser nulo.");
        System.out.println(controladorRobot.getRobot());
    }
    public static void despedirse(){
        System.out.println("Gracias, nos vemos.");
    }
}
