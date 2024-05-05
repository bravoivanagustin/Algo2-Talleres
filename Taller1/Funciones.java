package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x*x+y*y);
    }

    boolean divideA(int d, int n) {
        boolean res;
        res = ((double)n/d == Math.ceil((double)n/d));
        return res;
    }

    boolean esPar(int n) {
        return divideA(2, n);
    }

    boolean esBisiesto(int n) {
        return (divideA(4, n) && !(divideA(100, n)) || divideA(400, n));
    }

    int factorialIterativo(int n) {
        int res = 1;
        while (n > 1) {
            res *= n;
            n --;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n > 1) {
            res *= (n * factorialRecursivo(n-1));
        }
        return res;
    }

    boolean esPrimo(int n) {
        int d = 1;
        for (int f = n; f > 1; f--) {
            if (n % f == 0){
                d += 1;
            }
        }
        return d == 2;
    }

    int sumatoria(int[] numeros) {
        int res = 0; 
        for (int i = 0; i < numeros.length; i++) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int pos = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                pos = i;
            }
        }
        return pos;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false; 
        for (int n : numeros) {
            if (esPrimo(n)) {
                res = true;
            } 
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int n: numeros) {
            if (!divideA(2, n)){
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()){
            res = false;
        }
        else {
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)) {
                    res = false;
                }
            }
        }
        return res;
    }

    String reverso(String s) {
        String d = new String();
        for (int i = 0; i < s.length(); i++) {
            d += s.charAt(s.length()-1-i);
        }
        return d;
    }

    boolean esSufijo(String s1, String s2) {
        return(esPrefijo(reverso(s1), reverso(s2)));
    }
}