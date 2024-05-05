package aed;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        Fecha res = new Fecha(fechaActual);
        this.fechaActual = res;
    }

    public Fecha fechaActual() {
        Fecha res = new Fecha(this.fechaActual);
        return res;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res = new String(this.fechaActual.toString()+"\n=====");
        for (int i = 0; i < this.recordatorios.longitud(); i++){
            if (this.recordatorios.obtener(i).fecha().equals(this.fechaActual)) 
                {res = res + "\n" + this.recordatorios.obtener(i).toString();}
        }
        return res;
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }
}
