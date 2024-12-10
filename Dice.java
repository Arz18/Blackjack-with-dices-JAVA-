import java.util.Random;

// Clase que simula un dado de 14 caras utilizado en el juego.
public class Dice {
    private Random random; // Objeto para generar números aleatorios.
    
    // Constructor que inicializa el generador de números aleatorios.
    public Dice() {
        random = new Random();
    }
    // Método que simula el lanzamiento del dado y devuelve un valor entre 1 y 14.
    public int roll() {
       int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; //Valores de las instrucciones.
        return values[random.nextInt(values.length)]; // Selecciona un valor aleatorio del arreglo.
    }
}
