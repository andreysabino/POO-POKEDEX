package Pokedex.Entidades;


public class Pokemon {
    private String nome;
    private String tipo;
    private int ataque;
    private int hp;
    private int nivel;

    // Construtor para criar um Pokémon
    public Pokemon(String nome, String tipo, int ataque, int hp, int nivel) {
        this.nome = nome;
        this.tipo = tipo;
        this.ataque = ataque;
        this.hp = hp;
        this.nivel = nivel;
    }

    
    public Pokemon() {
    }


    // Getters para acessar os atributos do Pokémon
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getHP() {
        return hp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
