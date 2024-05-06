package aed;

public class Horario {

    private int minutos;
    private int hora;

    public Horario(int hora, int minutos) {
        int hora2 = new Integer(hora);
        int minutos2 = new Integer(minutos);
        this.hora = hora2;
        this.minutos = minutos2;
    }

    public Horario(Horario horario) {
        int hora2 = new Integer(horario.hora);
        int minutos2 = new Integer(horario.minutos);
        this.hora = hora2;
        this.minutos = minutos2;
    }

    public int hora() {
        int res = new Integer(this.hora);
        return res;
    }

    public int minutos() {
        int res = new Integer(this.minutos);
        return res;
    }

    @Override
    public String toString() {
        return this.hora + ":" + this.minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()){
            return false;
        }
        Horario otroHorario = (Horario) otro;
        return (this.hora == otroHorario.hora && this.minutos == otroHorario.minutos);
    }
}
