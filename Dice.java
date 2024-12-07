import java.util.Random;

// Clase que simula un dado de 14 caras utilizado en el juego.
public class Dice {
    private Random random; // Objeto para generar números aleatorios.

    // Constructor que inicializa el generador de números aleatorios.
    public Dice() {
        random = new Random();

    // Método que simula el lanzamiento del dado y devuelve un valor entre 1 y 14.
    public int roll() {
        return random.nextInt(14) + 1; // Devuelve un valor entre 1 y 14 
    }
}

