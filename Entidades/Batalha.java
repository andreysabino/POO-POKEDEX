package Pokedex.Entidades;
import java.util.*;
public class Batalha {
    private int rounds;
    private Treinador treinador1;
    private Treinador treinador2;
    private Random random;

    // Construtor para iniciar uma Batalha entre dois Treinadores
    public Batalha() {
    }

    // Método para iniciar a batalha
    public void iniciarBatalha(Treinador treinador1, Treinador treinador2,Pokemon pokemon1, Pokemon pokemon2) {
        random = new Random();
        int vez = random.nextInt(2); // 0 ou 1
        while (pokemon1.getHP() > 0 && pokemon2.getHP() > 0) {
            rounds++;     
            if (vez == 0) {
                realizarAtaque(pokemon1, pokemon2);
                vez = 1;
            } else {
                realizarAtaque(pokemon2, pokemon1);
                vez = 0;
            }
        }
        declararVencedor( treinador1, treinador2, pokemon1, pokemon2);
    }

    private int escolherAtaque(Pokemon pokemon){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha que ataque " + pokemon.getNome()+ " deve usar:");
        System.out.println("1 - Ataque Normal");
        System.out.println("2 - Ataque E special");
        int op = entrada.nextInt();
        return op;
    }

    private void hpPokemons(Pokemon pokemon1, Pokemon pokemon2, int dano){
        System.out.println(pokemon1.getNome()+ " causou "+dano+" de dano a "+pokemon2.getNome() + "\n");
        System.out.println("HP de "+pokemon1.getNome()+": "+pokemon1.getHP());
         System.out.println("HP de "+pokemon2.getNome()+": "+pokemon2.getHP() + "\n");
    }

    // Método privado para realizar um ataque entre Pokémon
    private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
        int dano = 0;
        int ataque = escolherAtaque(atacante);
        if(ataque == 1){
             dano = atacante.getAtaque() * atacante.getNivel();
             System.out.println(atacante.getNome()+" utilizou ataque normal!\n");
        } else if(ataque == 2) {
            dano = (atacante.getAtaque() * atacante.getNivel()) * 2;
            System.out.println(atacante.getNome()+" utilizou ataque especial!\n");
        }
        
        if (dano > 0) {
            int novoHP = defensor.getHP() - dano;
            defensor.setHP(novoHP);
            hpPokemons(atacante, defensor, dano);
        }
    }

    // Método privado para declarar o vencedor da batalha
    private void declararVencedor(Treinador treinador1, Treinador treinador2,Pokemon pokemon1,Pokemon pokemon2) {
        if (pokemon1.getHP() <= 0 && pokemon2.getHP() <= 0) {
            System.out.println("A batalha terminou em empate!");
        } else if (pokemon1.getHP() <= 0) {
            System.out.println(treinador2.getNome() + " venceu a batalha!");
        } else {
            System.out.println(treinador1.getNome() + " venceu a batalha!");
        }
    }
}
