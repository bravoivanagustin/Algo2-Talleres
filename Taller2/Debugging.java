package aed;

class Debugging {

    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b); // es necesario el parentesis para a||b
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if (xs.length != ys.length) { 
            res = false;
        }

        else{
            for (int i = 0; i < xs.length; i++) {  // me puedo ahorrar el problema de las distintas longitudes separando en dos casos
                if (xs[i] != ys[i]) {
                    res = false;
                }
            }
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {   // el codigo me decia solamente si el ultimo elemento era positivo o negativo, ademas habia codigo no necesario
            if (x <= 0) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];    // res = 0 no vale si son negativos los valores de la lista
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > res) {  
                res = xs[i]; // no estaban cerradas las llaves y res estaba obteniendo la posicion donde estaba el maximo valor
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length - 1; i++) { // si i < xs.length, cuando llegue a i = xs.length - 1, entonces i + 1 = length, por lo tanto se genera un error por evaluar xs[i+1]
            if (xs[i] > xs[i+1]) {
                res = false;
            }
        }
        return res;
    }
}
