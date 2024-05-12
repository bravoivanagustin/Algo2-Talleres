package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo primero;
    private Nodo ultimo;

	
    private class Nodo {
        
        T valor;
        Nodo sig;
        Nodo ant;

        Nodo(T v) {
            this.valor = v;
            this.sig = null;
            this.ant = null;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    public int longitud() {
        Nodo nuevo = this.primero;
        int i = 0;
        while(nuevo != null) {i++; nuevo = nuevo.sig;}
        return i;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (this.ultimo == null) {this.primero = nuevo; this.ultimo = nuevo;}
        else {nuevo.ant = this.ultimo; this.ultimo.sig = nuevo; this.ultimo = nuevo;}
        
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (this.primero == null) {this.primero = nuevo; this.ultimo = nuevo;}
        else {nuevo.sig = this.primero; this.primero.ant = nuevo; this.primero = nuevo;}
    }


    public T obtener(int i) {
        Nodo nuevo = this.primero;
        for(int j = 0; j < i; j++){
            nuevo = nuevo.sig;
        }
        return nuevo.valor;
    }

    public void eliminar(int i) {
        Nodo nuevo = this.primero;
        for(int j = 0; j < i - 1; j++) {
            nuevo = nuevo.sig;
        }
        if (i == 0) {this.primero = nuevo.sig;} else {nuevo.sig = nuevo.sig.sig;}
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevo = this.primero;
        for(int j = 0; j < indice; j++) {
            nuevo = nuevo.sig;
        }
        if (indice == 0) {this.primero.valor = elem;} else {nuevo.valor = elem;} 
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> res = new ListaEnlazada<>();
        for(int j = 0; j < this.longitud(); j++) {
            T valor = this.obtener(j);
            res.agregarAtras(valor);
        }
        return res;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        for(int j = 0; j < lista.longitud(); j++) {
            T valor = lista.obtener(j);
            this.agregarAtras(valor);
        };
    }
    
    @Override
    public String toString() {
        String res = "[" + this.primero.valor;
        for(int j = 1; j < this.longitud(); j++) {res += ", " + this.obtener(j);}
        res += "]";
        return res;
    }

    private class ListaIterador implements Iterador<T> {

        private int pos;

        public boolean haySiguiente() {
	        return pos != longitud();
        }
        
        public boolean hayAnterior() {
	        return pos != 0;
        }

        public T siguiente() {
	        T i = obtener(pos);
            pos ++;
            return i;
        }

        public T anterior() {
	        T i = obtener(pos-1);
            pos --;
            return i;
        }

    }

    public Iterador<T> iterador() {
        Iterador<T> res = new ListaIterador();
        return res;
    }

}
