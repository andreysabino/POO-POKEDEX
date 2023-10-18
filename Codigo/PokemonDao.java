import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PokemonDao {
    private String sql;

    public void cadastrarPokemon(){
        Scanner scanner = new Scanner(System.in);
       Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "INSERT INTO pokemon (nome,ataque, hp, tipo, nivel) VALUES (?,?,?,?,?)";
        System.out.println("Cadastrar um novo Pokémon:");
            System.out.println("Digite o nome do Pokémon:");
            String nomePokemon = scanner.nextLine();
            System.out.println("Digite o tipo do Pokémon:");
            String tipoPokemon = scanner.nextLine();
            System.out.println("Digite o ataque do Pokémon:");
            int ataquePokemon = scanner.nextInt();
            System.out.println("Digite o HP do Pokémon:");
            int hpPokemon = scanner.nextInt();
            System.out.println("Digite o nível do Pokémon:");
            int nivelPokemon = scanner.nextInt();

            Pokemon pokemon = new Pokemon(nomePokemon, tipoPokemon, ataquePokemon, hpPokemon, nivelPokemon);
        try { 
            PreparedStatement instrucao = conector.prepareStatement(sql);
            instrucao.setString(1, pokemon.getNome());
            instrucao.setInt(2,pokemon.getHP());
            instrucao.setInt(3,pokemon.getAtaque());
            instrucao.setString(4, pokemon.getTipo());
            instrucao.setInt(5, pokemon.getNivel());
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

  
        
    }

      public void listarPokemons(){
          Connection conector = ConexaoPSQL.getInstanciador().getConector();
          sql = "SELECT * FROM pokemon";
         try {
            PreparedStatement instrucao = conector.prepareStatement(sql);
            ResultSet consulta = instrucao.executeQuery();
            while(consulta.next()){
                int idPokemon = consulta.getInt("id");
                String nomeDoPokemon = consulta.getString("nome");
                String tipo = consulta.getString("tipo");
                int nivel = consulta.getInt("nivel");
                System.out.println("ID do pokemon: "+idPokemon);
                System.out.println("Nome do pokemon: "+nomeDoPokemon);
                System.out.println("Tipo do pokemon: "+tipo);
                System.out.println("Nivel do pokemon: "+nivel);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   

        }
        public void editarPokemon(){
        Scanner entradas = new Scanner(System.in);
        String nome = null;
        String tipo = null;
        String nivel = null;
        Connection conector = ConexaoPSQL.getInstanciador().getConector();
        sql = "UPDATE pokemon SET nome = COALESCE (?, nome), tipo = COALESCE (?, tipo), nivel = COALESCE(?,nivel) WHERE id = ?";
        System.out.println("Insira o ID do pokemon a ser editado: ");
        int idPokemon = entradas.nextInt();
        try {
            
            PreparedStatement instrucao = conector.prepareStatement(sql);
            System.out.println("Insira um nome para o pokemon ou pressione enter se deseja manter o mesmo: ");
            nome = entradas.nextLine();
            if(nome == ""){
                nome = null;
            }
            System.out.println("Insira um novo tipo para o pokemon ou pressione enter se deseja manter o tipo atual: ");
            tipo = entradas.nextLine();
            if(tipo == ""){
                tipo = null;
            }
            System.out.println("Insira um novo nivel para o pokemon ou pressione enter se deseja manter o nivel atual: ");
            nivel = entradas.nextLine();
            if(nivel == ""){
                nivel = null;
            }
            instrucao.setString(1, nome);
            instrucao.setString(2, tipo);
            if(nivel != null){
                instrucao.setInt(3,Integer.parseInt(nivel));
            } else {
                instrucao.setNull(3,java.sql.Types.INTEGER);
            }
            
            instrucao.setInt(4, idPokemon);
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
            
            
    }
    public void deletarPokemon(){
        Scanner entradas = new Scanner(System.in);
         Connection conector = ConexaoPSQL.getInstanciador().getConector();
         sql = "DELETE FROM pokemon WHERE id = ?";
         System.out.println("Insira o ID do pokemon a ser editado: ");
        int idPokemon = entradas.nextInt();
         try {
            PreparedStatement instrucao = conector.prepareStatement(sql);
            instrucao.setInt(1, idPokemon);
            instrucao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
