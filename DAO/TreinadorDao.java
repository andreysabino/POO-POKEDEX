package Pokedex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TreinadorDao {
    private String sql;


    public void cadastrarTreinador(){
        Scanner entradas = new Scanner(System.in);
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "INSERT INTO Treinador (nome, nivel) VALUES (?,?)";
        System.out.println("Insira o nome do treinador: ");
        String nomeTreinador = entradas.nextLine();
        System.out.println("Insira o nivel do treinador: ");
        Integer nivel = entradas.nextInt();
        try {
            PreparedStatement instrucao = conector.prepareStatement(sql);
            instrucao.setString(1, nomeTreinador);
            instrucao.setInt(2, nivel);
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarTreinadores(){
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "SELECT Treinador.*, Pokemon.nome AS nomeP,Pokemon.ataque AS ataque, Pokemon.hp AS hp, Pokemon.tipo AS tipo, Pokemon.nivel AS nivelP, Pokemon.treinador_id AS treinador_id FROM Treinador LEFT JOIN Pokemon ON Treinador.id = Pokemon.treinador_id";
        
        try {
            int idTreinador = 0;
            int idTreinadorAnterior = -1;
            PreparedStatement instrucao = conector.prepareStatement(sql);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
                idTreinador = consulta.getInt("id");
                if(idTreinador != idTreinadorAnterior){
                Integer id = consulta.getInt("id");
                String nomeTreinador = consulta.getString("nome");
                Integer nivelTreinador = consulta.getInt("nivel");
                    
                System.out.println("DADOS DO TREINADOR: ");
                System.out.println("ID do treinador: "+id);
                System.out.println("Nome: "+nomeTreinador);
                System.out.println("Nivel do treinador: "+nivelTreinador);
                System.out.println("\nPOKEMONS DO TREINADOR: ");
                System.out.println();
                }
                String nomePokemon = consulta.getString("nomeP");
                Integer ataquePokemon = consulta.getInt("ataque");
                Integer hpPokemon = consulta.getInt("hp");
                String tipo = consulta.getString("tipo");
                Integer nivelPokemon = consulta.getInt("nivelP");
                Integer idTreinadorPokemon = consulta.getInt("treinador_id");
                if(idTreinadorPokemon != 0){
                System.out.println("Nome do pokemon: "+nomePokemon);
                System.out.println("Ataque do pokemon: "+ataquePokemon);
                System.out.println("HP do pokemon: "+ hpPokemon);
                System.out.println("Tipo do pokemon: "+tipo);
                System.out.println("Nivel do pokemon: "+nivelPokemon);
                System.out.println("ID do treinador do pokemon: "+idTreinadorPokemon);
                System.out.println();
                }
                
                idTreinadorAnterior = idTreinador;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        
    }

    public void editarTreinador(){
        Scanner entradas = new Scanner(System.in);
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "UPDATE Treinador SET nome = COALESCE(?, nome), nivel = COALESCE (?,nivel) WHERE id = ?";
        System.out.println("Insira o ID do treinador para edita-lo: ");
        int idTreinador = entradas.nextInt();
        try {
            PreparedStatement instrucao = conector.prepareStatement(sql);
            System.out.println("Insira um novo nome para o treinador ou pressione enter para manter o nome atual: ");
            String nome = entradas.nextLine();
            if(nome.equals("")){
                nome = null;
            }
            System.out.println("Insira um novo nivel para o treinador ou pressione enter para manter o nivel atual: ");
            String nivel = entradas.nextLine();
            if(nivel.equals("")){
                nivel = null;
            }
            instrucao.setString(1, nome);
            if(nivel != null){
                instrucao.setInt(2, Integer.parseInt(nivel));
            } else {
                instrucao.setNull(2,java.sql.Types.INTEGER);
            }
            instrucao.setInt(4, idTreinador);
            instrucao.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void verPokemons(){
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "SELECT Treinador.*, Pokemon.nome AS nomeP,Pokemon.ataque AS ataque, Pokemon.hp AS hp, Pokemon.tipo AS tipo, Pokemon.nivel AS nivelP, Pokemon.treinador_id AS treinador_id FROM Treinador LEFT JOIN Pokemon ON Treinador.id = Pokemon.treinador_id WHERE treinador.id = ?";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do treinador para ver seus pokemons: ");
        int idTreinador = scanner.nextInt();
        try {
            
            PreparedStatement instrucao = conector.prepareStatement(sql);
            instrucao.setInt(1, idTreinador);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
        
                String nomePokemon = consulta.getString("nomeP");
                Integer ataquePokemon = consulta.getInt("ataque");
                Integer hpPokemon = consulta.getInt("hp");
                String tipo = consulta.getString("tipo");
                Integer nivelPokemon = consulta.getInt("nivelP");
                Integer idTreinadorPokemon = consulta.getInt("treinador_id");

                System.out.println("ID do treinador do Pokemon: "+ idTreinadorPokemon);
                System.out.println("Nome do pokemon: "+nomePokemon);
                System.out.println("Ataque do pokemon: "+ataquePokemon);
                System.out.println("HP do pokemon: "+ hpPokemon);
                System.out.println("Tipo do pokemon: "+tipo);
                System.out.println("Nivel do pokemon: "+nivelPokemon);

                System.out.println();
                

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        
    }


    public void deletarTreinador() {
        Scanner scanner = new Scanner(System.in);
       Connection conector = ConexaoPSQL.getInstanciador().getConector();
       sql = "DELETE FROM Treinador WHERE id = ?";
       System.out.println("Insira o ID do treinador para deleta-lo: ");
        int idTreinador = scanner.nextInt();
       try {
        PreparedStatement instrucao = conector.prepareStatement(sql);
        instrucao.setInt(1, idTreinador);
        instrucao.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public void atribuirPokemon(){
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        Scanner entrada = new Scanner(System.in);
         sql = "UPDATE Pokemon SET treinador_id = ? WHERE id = ?";
         try {
            PreparedStatement instrucao = conector.prepareStatement(sql);
            System.out.println("Insira o id do treinador a qual quer atribuir o pokemon: ");
            Integer id_treinador = entrada.nextInt();
            System.out.println("Insira o ID do pokemon a ser atribuido: ");
            Integer id_pokemon = entrada.nextInt();
            instrucao.setInt(1, id_treinador);
            instrucao.setInt(2, id_pokemon);
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
