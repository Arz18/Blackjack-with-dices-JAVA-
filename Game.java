import java.util.Scanner;

// Clase principal que controla el flujo del juego.
public class Game {
    private Player player; // Objeto que representa al jugador.
    private House house; // Objeto que representa a la casa.
    private Dice dice; // Objeto que simula el dado.
    private Scanner scanner; // Objeto para leer la entrada del usuario.

      private void printHeader() {
        System.out.println("==================================================");
        System.out.println("            ¡Bienvenido a Blackjack con Dados!    ");
        System.out.println("==================================================");
    }
    // Constructor que inicializa los objetos del juego.
    public Game() {
        player = new Player(100); // El jugador comienza con $100.
        house = new House();
        dice = new Dice();
        scanner = new Scanner(System.in);
    }

    // Método que inicia el juego y gestiona las rondas.
    public void start() {
        printHeader();
        while (player.getBalance() > 0) { // Mientras el jugador tenga saldo.
            System.out.println("\nSaldo actual: $" + player.getBalance());
            System.out.print("Ingresa tu apuesta: ");
            int bet = scanner.nextInt();

            if (!player.placeBet(bet)) { // Valida la apuesta.
                System.out.println("Apuesta inválida. Inténtalo de nuevo.");
                continue;
            }

            playRound(); // Ejecuta una ronda.
            System.out.println("\n¿Deseas jugar otra ronda? (s/n)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("s")) { // Verifica si el jugador quiere continuar.
                break;
            }
        }
        System.out.println("¡Gracias por jugar! Saldo final: $" + player.getBalance());
    }

    // Método que gestiona una ronda del juego.
    private void playRound() {
        player.resetTotal();
        house.resetTotal();

        player.addToTotal(dice.roll()); // Primer lanzamiento del jugador.
        player.addToTotal(dice.roll()); // Segundo lanzamiento del jugador.
        house.addToTotal(dice.roll()); // Lanzamiento inicial de la casa.

        System.out.println("Total del jugador: " + player.getTotal());
        System.out.println("Total de la casa: " + house.getTotal());

        if (player.isBust()) { // Si el jugador se pasa de 21.
            System.out.println("¡Te pasaste de 21! Pierdes la apuesta.");
            player.updateBalance(false);
            return;
        }

        playerTurn(); // Turno del jugador.
        if (player.isBust()) {
            System.out.println("¡Te pasaste de 21! Pierdes la apuesta.");
            player.updateBalance(false);
            return;
        }

        houseTurn(); // Turno de la casa.
        evaluateWinner(); // Evalúa quién gana.
    }

    // Método para gestionar las decisiones del jugador.
    private void playerTurn() {
        while (true) {
            System.out.println("\n¿Deseas 'hit' (1) o 'stand' (2)?");
            int choice = scanner.nextInt();
            if (choice == 1) { // Si el jugador pide un dado.
                int roll = dice.roll();
                player.addToTotal(roll);
                System.out.println("Rolaste un " + roll + ". Total actual: " + player.getTotal());
                if (player.isBust()) { // Si el jugador se pasa de 21, termina el turno.
                    return;
                }
            } else if (choice == 2) { // Si el jugador decide quedarse.
                break;
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    // Método para gestionar las decisiones de la casa.
    private void houseTurn() {
        while (house.mustHit()) { // Mientras la casa deba pedir.
            int roll = dice.roll();
            house.addToTotal(roll);
            System.out.println("La casa roló un " + roll + ". Total de la casa: " + house.getTotal());
        }
    }

    // Método para evaluar el ganador de la ronda.
    private void evaluateWinner() {
        if (house.isBust() || player.getTotal() > house.getTotal()) {
            System.out.println("¡Ganaste la apuesta!");
            player.updateBalance(true);
        } else if (player.getTotal() < house.getTotal()) {
            System.out.println("La casa gana. Pierdes la apuesta.");
            player.updateBalance(false);
        } else {
            System.out.println("Es un empate. Recuperas tu apuesta.");
        }
    }
}
