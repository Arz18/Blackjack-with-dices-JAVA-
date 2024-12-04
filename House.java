// Clase que gestiona las propiedades y reglas de la casa.
public class House {
    private int total; // Puntuación total de la casa.

    // Constructor que inicializa la puntuación de la casa.
    public House() {
        this.total = 0;
    }

    // Método para sumar un valor a la puntuación total de la casa.
    public void addToTotal(int value) {
        this.total += value;
    }

    // Método que verifica si la casa se pasó de 21.
    public boolean isBust() {
        return total > 21;
    }

    // Método que verifica si la casa debe pedir más dados.
    public boolean mustHit() {
        return total < 17;
    }

    // Método que devuelve la puntuación total de la casa.
    public int getTotal() {
        return total;
    }

    // Método para reiniciar la puntuación de la casa al comienzo de una nueva ronda.
    public void resetTotal() {
        this.total = 0;
    }
}
