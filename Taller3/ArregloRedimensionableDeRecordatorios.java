package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        Recordatorio[] res = new Recordatorio[0];
        this.recordatorios = res;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] res = new Recordatorio[vector.recordatorios.length];
        for (int i = 0; i < vector.recordatorios.length; i++) {res[i] = vector.recordatorios[i];}
        this.recordatorios = res;
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] res = new Recordatorio[this.recordatorios.length+1];
        for (int j = 0; j < this.recordatorios.length; j++) {res[j] = this.recordatorios[j];}
        res[res.length-1] = i;
        this.recordatorios = res;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] res = new Recordatorio[this.recordatorios.length-1];
        for (int j = 0; j < res.length; j++) {res[j] = this.recordatorios[j];}
        this.recordatorios = res;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios res = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < this.recordatorios.length; i++) {res.recordatorios[i] = this.recordatorios[i];}
        return res;
    }
}
