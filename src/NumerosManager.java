public class NumerosManager {

    private double[] numeros;
    private int indice;

    public NumerosManager(int tamaño) {
        numeros = new double[tamaño];
        indice = 0;
    }

    public void agregarNumero(double numero) {
        if (indice < numeros.length) {
            numeros[indice] = numero;
            indice++;
        }
    }

    public String mostrarNumeros() {
        String resultado = "";
        for (int i = 0; i < indice; i++) {
            resultado += numeros[i] + "\n";
        }
        return resultado;
    }
}