package aed;

public class Fecha {

    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        int dia2 = new Integer(dia);
        int mes2 = new Integer(mes);
        this.dia = dia2;
        this.mes = mes2;
    }

    public Fecha(Fecha fecha) {
        int dia2 = new Integer(fecha.dia);
        int mes2 = new Integer(fecha.mes);
        this.dia = dia2;
        this.mes = mes2;
    }

    public Integer dia() {
        int res = new Integer(this.dia);
        return res;
    }

    public Integer mes() {
        int res = new Integer(this.mes);
        return res;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes;
    }

    public void incrementarDia() {
        if (this.dia != diasEnMes(this.mes)) {
            this.dia += 1;
        }
        else {
            this.dia = 1;
            if (this.mes == 12){this.mes = 1;}else{this.mes += 1;}
            }
        }

    @Override
    public boolean equals(Object otra) {
        if (otra == null || otra.getClass() != this.getClass()){
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        return (this.dia == otraFecha.dia && this.mes == otraFecha.mes);
        }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes-1];
    }
}