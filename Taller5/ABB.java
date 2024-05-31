package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    
    private Nodo raiz;
    private int longitud;

    private class Nodo {
        Nodo papi;
        Nodo izq;
        Nodo der;
        T valor;

        Nodo(T elem){this.valor = elem;}
    }

    public ABB() {
        this.raiz = null;
        this.longitud = 0;
    }

    public int cardinal() {
        return this.longitud;
    }

    public T minimo(){
        Nodo actual = this.raiz;
        while (actual.izq != null) {actual = actual.izq;}
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = this.raiz;
        while (actual.der != null) {actual = actual.der;}
        return actual.valor;
    }

    public void insertar(T elem){

        if (!this.pertenece(elem)){

        Nodo actual = this.raiz;
        Nodo insertar = new Nodo(elem);
        
        if (this.raiz == null) {this.raiz = insertar;} 

        else{
        while ((insertar.valor.compareTo(actual.valor) > 0 && actual.der != null) || (insertar.valor.compareTo(actual.valor) < 0 && actual.izq != null) ){
            if (insertar.valor.compareTo(actual.valor) > 0) {actual = actual.der;}
            else {actual = actual.izq;}
        }
        if (insertar.valor.compareTo(actual.valor) > 0) {actual.der = insertar; insertar.papi = actual;}
        else {actual.izq = insertar;  insertar.papi = actual;}
        }
        longitud ++;
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = this.raiz;
        while (actual != null && !actual.valor.equals(elem)) {
            if (elem.compareTo(actual.valor) > 0) {actual = actual.der;}
            else {actual = actual.izq;}
        }
        return actual != null;
    }

    private Nodo sucesor(Nodo nashe){
        Nodo suc = nashe.der;
        while (suc.izq != null) {suc = suc.izq;}
        return suc;
    }

    public void eliminar(T elem){
        if (this.pertenece(elem)){
        
        Nodo actual = this.raiz;

        while (!actual.valor.equals(elem)){
            if (elem.compareTo(actual.valor) > 0) {actual = actual.der;}
            else {actual = actual.izq;}
            }
        
        if (actual.der == actual.izq) {actual = null;}

        else if (actual.der == null || actual.izq == null) {
            if (actual.der != null) {actual.der.papi = actual.papi;}
            else {actual.izq.papi = actual.papi;}
        }

        else if (actual.der != null && actual.izq != null) {
            Nodo suc = sucesor(actual);
            suc.papi = actual.papi;
        }

        longitud --;

        }
    }

    public String toString(){
        String res = "";
        return res;
        }

    private String toString(Nodo n){
        String res = "";
        //if ()
        return res;
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
