import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BatalhaDao {   
    private String sql;

    public void selecionarTreinadoresParaBatalha(Treinador treinador1, Treinador treinador2,ArrayList <Pokemon> pokemonsT1, ArrayList <Pokemon> pokemonsT2 ){
        Pokemon auxPoke = new Pokemon();
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        Scanner entrada = new Scanner(System.in);
        int idTreinador1 = 0;
        int idTreinador2 = 0;
        System.out.println("Insira o id do treinador 1: ");
        idTreinador1 = entrada.nextInt();
        System.out.println("Insira o id do treinador 2: ");
        idTreinador2 = entrada.nextInt();
        sql = "SELECT Treinador.*, Pokemon.nome AS nomeP,Pokemon.ataque AS ataque, Pokemon.hp AS hp, Pokemon.tipo AS tipo, Pokemon.nivel AS nivelP, Pokemon.treinador_id AS treinador_id FROM Treinador LEFT JOIN Pokemon ON Treinador.id = Pokemon.treinador_id WHERE Treinador.id = ?";
        
        try {
           
            PreparedStatement instrucao = conector.prepareStatement(sql);
            instrucao.setInt(1, idTreinador1);
            ResultSet consulta = instrucao.executeQuery();
            boolean t = true;
            while(consulta.next()){
            
            if(t){
            String nomeTreinador = consulta.getString("nome");
            Integer nivelTreinador = consulta.getInt("nivel");
           
            System.out.println("DADOS DO TREINADOR 1: ");
            System.out.println("Nome: "+nomeTreinador);
            System.out.println("Nivel do treinador: "+nivelTreinador);
            System.out.println("\nPOKEMONS DO TREINADOR 1: ");
            System.out.println();
            treinador1.setNome(nomeTreinador);
            treinador1.setNivel(nivelTreinador);
            t = false;
            }
            String nomePokemon = consulta.getString("nomeP");
            Integer ataquePokemon = consulta.getInt("ataque");
            Integer hpPokemon = consulta.getInt("hp");
            String tipo = consulta.getString("tipo");
            Integer nivelPokemon = consulta.getInt("nivelP");
           
            System.out.println("Nome do pokemon: "+nomePokemon);
            System.out.println("Ataque do pokemon: "+ataquePokemon);
            System.out.println("HP do pokemon: "+ hpPokemon);
            System.out.println("Tipo do pokemon: "+tipo);
            System.out.println("Nivel do pokemon: "+nivelPokemon);
            System.out.println();
            auxPoke = new Pokemon(nomePokemon, tipo, ataquePokemon, hpPokemon, nivelPokemon);
            pokemonsT1.add(auxPoke);
            }

            instrucao.setInt(1, idTreinador2);
            consulta = instrucao.executeQuery();
            t = true;
            while(consulta.next()){
            
            if(t){
            String nomeTreinador = consulta.getString("nome");
            Integer nivelTreinador = consulta.getInt("nivel");
           
            System.out.println("DADOS DO TREINADOR 2: ");
            System.out.println("Nome: "+nomeTreinador);
            System.out.println("Nivel do treinador: "+nivelTreinador);
            System.out.println("\nPOKEMONS DO TREINADOR 2: ");
            System.out.println();
            treinador2.setNome(nomeTreinador);
            treinador2.setNivel(nivelTreinador);
            t = false;
            }
            String nomePokemon = consulta.getString("nomeP");
            Integer ataquePokemon = consulta.getInt("ataque");
            Integer hpPokemon = consulta.getInt("hp");
            String tipo = consulta.getString("tipo");
            Integer nivelPokemon = consulta.getInt("nivelP");
           
            System.out.println("Nome do pokemon: "+nomePokemon);
            System.out.println("Ataque do pokemon: "+ataquePokemon);
            System.out.println("HP do pokemon: "+ hpPokemon);
            System.out.println("Tipo do pokemon: "+tipo);
            System.out.println("Nivel do pokemon: "+nivelPokemon);
            System.out.println();
            auxPoke = new Pokemon(nomePokemon, tipo, ataquePokemon, hpPokemon, nivelPokemon);
            pokemonsT2.add(auxPoke);
            }

           
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

     public void selecionaPokemonsParaBatalha(Treinador treinador1, Treinador treinador2,ArrayList <Pokemon> pokemonsT1, ArrayList <Pokemon> pokemonsT2)
    {
        Batalha batalha = new Batalha();
        Pokemon poke1;
        Pokemon poke2;
     Scanner entrada = new Scanner(System.in);
     System.out.println("Selecione um pokemon do treinador 1: ");
     for (int i = 0; i < pokemonsT1.size(); i++) {
            
            System.out.println("POKEMON "+i);
            System.out.println("Nome do pokemon: "+pokemonsT1.get(i).getNome());
            System.out.println("Ataque do pokemon: "+pokemonsT1.get(i).getAtaque());
            System.out.println("HP do pokemon: "+pokemonsT1.get(i).getHP());
            System.out.println("Tipo do pokemon: "+pokemonsT1.get(i).getTipo());
            System.out.println("Nivel do pokemon: "+pokemonsT1.get(i).getNivel());
            
            System.out.println();
     }
     System.out.println("Digite o numero do pokemon que quer escolher do treinador 1: ");
     System.out.println();
     int poke = entrada.nextInt();
     poke1 = pokemonsT1.get(poke);

    System.out.println("Selecione um pokemon do treinador 2: ");
     for (int i = 0; i < pokemonsT2.size(); i++) {
            System.out.println("POKEMON "+i);
            System.out.println("Nome do pokemon: "+pokemonsT2.get(i).getNome());
            System.out.println("Ataque do pokemon: "+pokemonsT2.get(i).getAtaque());
            System.out.println("HP do pokemon: "+pokemonsT2.get(i).getHP());
            System.out.println("Tipo do pokemon: "+pokemonsT2.get(i).getTipo());
            System.out.println("Nivel do pokemon: "+pokemonsT2.get(i).getNivel());
            
            System.out.println();
     } 
     System.out.println("Digite o numero do pokemon que quer escolher do treinador 2: ");
     poke = entrada.nextInt();
     poke2 = pokemonsT2.get(poke);
     batalha.iniciarBatalha(treinador1, treinador2, poke1, poke2);

    }
            
}
