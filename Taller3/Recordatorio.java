package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario; 

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        String mensaje2 = new String(mensaje);
        Fecha fecha2 = new Fecha(fecha);
        Horario horario2 = new Horario(horario);
        this.mensaje = mensaje2;
        this.horario = horario2;
        this.fecha = fecha2;
    }

    public Recordatorio(Recordatorio recordatorio) {
        String mensaje2 = new String(recordatorio.mensaje);
        Fecha fecha2 = new Fecha(recordatorio.fecha);
        Horario horario2 = new Horario(recordatorio.horario);
        this.mensaje = mensaje2;
        this.horario = horario2;
        this.fecha = fecha2;
    }

    public Horario horario() {
        Horario res = new Horario(this.horario);
        return res;
    }

    public Fecha fecha() {
        Fecha res = new Fecha(this.fecha);
        return res;
    }

    public String mensaje() {
        String res = new String(this.mensaje);
        return res;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + this.fecha.toString() + " " + this.horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()){
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return (this.fecha.equals(otroRecordatorio.fecha) && this.horario.equals(otroRecordatorio.horario) && this.mensaje.equals(otroRecordatorio.mensaje));
    }
}
