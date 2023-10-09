package Pokedex.Entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Treinador {
    private String nome;
    private int nivel;
    private List<Pokemon> pokemons;

    // Construtor para criar um Treinador
    public Treinador(String nome) {
        this.nome = nome;
        this.pokemons = new ArrayList<>();
    }

    

    public Treinador() {
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    // codigo de cadastro de pokemon
    public void atribuirPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        System.out.println("Pokemon " + pokemon.getNome() + " cadastrado com sucesso para o treinador " + nome);
    }

    // Getter para acessar o nome do Treinador
    public String getNome() {
        return nome;
    }

    // Getter para acessar a lista de Pokémon do Treinador
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    // Método para cadastrar um Pokémon na lista do Treinador
    public void cadastrarPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    // Método para remover um Pokémon da lista do Treinador
    public void removerPokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }

    // Outros métodos, como editar Treinador e listar Pokémon, podem ser adicionados
    // aqui
    public void editarNome(String novoNome) {
        this.nome = novoNome;
    }
}
