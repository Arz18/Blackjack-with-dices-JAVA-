// Clase que gestiona las propiedades y acciones del jugador.
public class Player {
    private int balance; // Saldo actual del jugador.
    private int currentBet; // Apuesta actual.
    private int total; // Puntuación total del jugador en la ronda.
    

    // Constructor que inicializa el saldo inicial y la puntuación.
    public Player(int initialBalance) {
        this.balance = initialBalance;
        this.total = 0;
    }

    // Método que permite al jugador realizar una apuesta si es válida.
    public boolean placeBet(int bet) {
        if (bet > 0 && bet <= balance) { // Verifica que la apuesta sea positiva y no supere el saldo.
            this.currentBet = bet;
            return true;
        }
        return false;
    }

    // Método para actualizar el saldo después de una ronda, según si ganó o perdió.
    public void updateBalance(boolean won) {
        if (won) {
            balance += currentBet; // Suma la apuesta al saldo si ganó.
        } else {
            balance -= currentBet; // Resta la apuesta al saldo si perdió.
        }
    }

    // Método para sumar un valor a la puntuación total del jugador.
    public void addToTotal(int value) {
        this.total += value;
    
    }


    // Método que verifica si el jugador se pasó de 21.
    public boolean isBust() {
        return total > 21;
    }

    // Método que devuelve la puntuación total del jugador.
    public int getTotal() {
        return total;
    }

    // Método que devuelve el saldo actual del jugador.
    public int getBalance() {
        return balance;
    }

    // Método para reiniciar la puntuación del jugador al comienzo de una nueva ronda.
    public void resetTotal() {
        this.total = 0;
        

    }
    public void showStatus() {
        System.out.println("Tu saldo actual: $" + balance);
        System.out.println("Total actual: " + total);
    }
    public boolean canPlaceBet() {
        return balance > 0; 
}
}
