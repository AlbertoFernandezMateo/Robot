package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;

//una zona por defecto (la zona mínima permitida), el robot posicionado en el centro y orientado al norte.
    public Robot() {
        orientacion = Orientacion.NORTE;
        zona = new Zona();
        coordenada = zona.getCentro();
    }
//    Se situaría el robot en el centro de dicha zona y orientado al norte.
    public Robot(Zona zona){
        setZona(zona);
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }
//    Se situaría el robot en el centro de dicha zona y con la orientación indicada.
    public Robot(Zona zona, Orientacion orientacion){
        setZona(zona);
        setOrientacion(orientacion);
        coordenada = zona.getCentro();
    }
//    Se situaría el robot en la coordenada indicada y con la orientación indicada.
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
       setZona(zona);
       setOrientacion(orientacion);
       setCoordenada(coordenada);
    }
//    Copiará la zona, orientación y la coordenada del robot.
    public Robot(Robot robot){
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        orientacion = robot.orientacion;
        coordenada = robot.coordenada;
        zona = robot.zona;
    }

    public Orientacion getOrientacion() { return orientacion;}

    public Coordenada getCoordenada() { return coordenada;}

    public Zona getZona() { return zona;}

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)){
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    private void setOrientacion(Orientacion orientacion) {  Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");this.orientacion = orientacion;}

    private void setZona(Zona zona) { Objects.requireNonNull(zona, "La zona no puede ser nula."); this.zona = zona;}

    public void avanzar(  ) throws RobotExcepcion {
        try {
            switch (orientacion){
                case NORTE -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() + 1));
                case NOROESTE -> setCoordenada(new Coordenada(coordenada.x() -1, coordenada.y() + 1));
                case NORESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() +1 ));
                case SUR -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() - 1));
                case SURESTE -> setCoordenada(new Coordenada(coordenada.x() +1, coordenada.y() -1));
                case SUROESTE -> setCoordenada(new Coordenada(coordenada.x() -1, coordenada.y() - 1));
                case ESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() ));
                case OESTE -> setCoordenada(new Coordenada(coordenada.x() -1, coordenada.y()));
            }
        } catch (IllegalArgumentException e){
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }

    }
    public void girarALaDerecha() throws RobotExcepcion {
            try {
                switch (orientacion){
                    case NORTE -> orientacion = Orientacion.NORESTE;
                    case NORESTE -> orientacion = Orientacion.ESTE;
                    case ESTE -> orientacion = Orientacion.SURESTE;
                    case SURESTE -> orientacion = Orientacion.SUR;
                    case SUR -> orientacion = Orientacion.SUROESTE;
                    case SUROESTE -> orientacion = Orientacion.OESTE;
                    case OESTE -> orientacion = Orientacion.NOROESTE;
                    case NOROESTE -> orientacion = Orientacion.NORTE;

                }
                } catch (IllegalArgumentException e) {
                    throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
            }
    }
    public void girarALaIzquierda() throws RobotExcepcion {
        try {
            switch (orientacion) {
                case NORTE -> orientacion = Orientacion.NOROESTE;
                case NOROESTE -> orientacion = Orientacion.OESTE;
                case OESTE -> orientacion = Orientacion.SUROESTE;
                case SUROESTE -> orientacion = Orientacion.SUR;
                case SUR -> orientacion = Orientacion.SURESTE;
                case SURESTE -> orientacion = Orientacion.ESTE;
                case ESTE -> orientacion = Orientacion.NORESTE;
                case NORESTE -> orientacion = Orientacion.NORTE;
            }
        } catch (IllegalArgumentException e) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    @Override
    public String toString() {
        return "[" +
                "coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                ", zona=" + zona +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, orientacion, zona);
    }
}
