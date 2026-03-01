public class CadenasManager {

    private String[][] matriz;
    private int fila;
    private int columna;

    public CadenasManager(int filas, int columnas) {
        matriz = new String[filas][columnas];
        fila = 0;
        columna = 0;
    }

    public void agregarCadena(String texto) {
        if (fila < matriz.length) {
            matriz[fila][columna] = texto;
            columna++;
            
            if (columna == matriz[0].length) {
                columna = 0;
                fila++;
            }
        }
    }

    public String mostrarCadenas() {
        String resultado = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null) {
                    resultado += matriz[i][j] + " ";
                }
            }
            resultado += "\n";
        }
        return resultado;
    }
}