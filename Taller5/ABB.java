package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    
    private Nodo padre;
    private int longitud;

    private class Nodo {
        Nodo izq;
        Nodo der;
        T valor;

        Nodo(T elem){this.valor = elem; this.izq = null; this.der = null;}
    }

    public ABB() {
        this.padre = null;
        this.longitud = 0;
    }

    public int cardinal() {
        return this.longitud;
    }

    public T minimo(){
        Nodo nuevo = this.padre;
        if (nuevo == null) {
            return null;
        }
        while (nuevo.izq != null) {
            nuevo = nuevo.izq;
        }
        return nuevo.valor;
    }

    public T maximo(){
        Nodo nuevo = this.padre;
        if (nuevo == null) {
            return null;
        }
        while (nuevo.der != null) {
            nuevo = nuevo.der;
        }
        return nuevo.valor;
    }

    public void insertar(T elem){
        Nodo actual = this.padre;
        Nodo nuevo = new Nodo(elem);
        
        while (actual != null) {
            if (nuevo.valor.compareTo(actual.valor) > 0) {actual = actual.der;}
            else {actual = actual.izq;}
        }

        
    }

    public boolean pertenece(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
