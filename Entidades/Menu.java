package Pokedex.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Pokedex.DAO.*;

public class Menu {
    public static void gerenciarTreinador() {
        Scanner scanner = new Scanner(System.in);
        BatalhaDao daoBatalha = new BatalhaDao();
        PokemonDao daoPokemon = new PokemonDao();
        TreinadorDao daoTreinador = new TreinadorDao();
        Treinador treinador1 = new Treinador();
        Treinador treinador2 = new Treinador();
        ArrayList<Pokemon> pokemonsT1 = new ArrayList<>();
        ArrayList<Pokemon> pokemonsT2 = new ArrayList<>();
        int op = 1;
        int opcao = 1;
        do {

            System.out.println("MENU POKEDEX");
            System.out.println("1. Treinadores");
            System.out.println("2. Pokemons");
            System.out.println("3. Batalhar");
            System.out.println("0. Sair");
            opcao = 1;
            op = scanner.nextInt();

                switch (op) {
                    case 1:
                    while(opcao != 0){
                        System.out.println("Opções de gerenciamento de Treinador:");
                        System.out.println("1. Criar Treinador");
                        System.out.println("2. Editar nome do Treinador");
                        System.out.println("3. Atribuir Pokémon ao Treinador");
                        System.out.println("4. Pokémons do treinador");
                        System.out.println("5. Excluir um treinador");
                        System.out.println("6. Lista de treinadores");
                        System.out.println("0. Voltar");

                        opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                daoTreinador.cadastrarTreinador();
                                break;
                            case 2:
                                daoTreinador.editarTreinador();
                                break;
                            case 3:
                                daoTreinador.atribuirPokemon();
                                break;
                            case 4:
                                daoTreinador.verPokemons();
                                break;
                            case 5:
                            daoTreinador.deletarTreinador();
                            break;
                            case 6:
                            daoTreinador.listarTreinadores();
                            break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } 
                    
                    break;
                        
                    case 2:
                    while(opcao != 0){
                        System.out.println("Opções de gerenciamento de Pokémon:");
                        System.out.println("1. Cadastrar Pokémon");
                        System.out.println("2. Editar Pokémon");
                        System.out.println("3. Excluir Pokémon");
                        System.out.println("4. Ver Pokémons");
                        System.out.println("0. Voltar");

                        opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                daoPokemon.cadastrarPokemon();
                                break;
                            case 2:
                                daoPokemon.editarPokemon();
                                break;
                            case 3:
                                daoPokemon.deletarPokemon();
                                break;
                            case 4:
                                daoPokemon.listarPokemons();
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                        
                        break;
                    case 3:
                        while (opcao != 0) {
                        System.out.println("Batalha");
                        System.out.println("1. Seleciona treinadores para a batalha");
                        System.out.println("2. Selecionar pokemons para a batalha");
                        System.out.println("0. Voltar");
                        opcao = scanner.nextInt();
                        
                            switch (opcao) {
                                case 1:
                                    daoBatalha.selecionarTreinadoresParaBatalha(treinador1, treinador2, pokemonsT1,
                                            pokemonsT2);
                                    break;
                                case 2:
                                    daoBatalha.selecionaPokemonsParaBatalha(treinador1, treinador2, pokemonsT1,
                                            pokemonsT2);
                                    break;
                            }
                        }
                       
                        break;
                }
            

        }while(op != 0);
    }

}
