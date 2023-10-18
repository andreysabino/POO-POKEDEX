import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPSQL {
    private static ConexaoPSQL instanciador;
    private Connection conector;
    private final String url = "jdbc:postgresql://isabelle.db.elephantsql.com:5432/mpehmhjh";
    private final String usuario = "mpehmhjh";
    private final String senha = "cIHMrms2EV6h-UqyyWgE0pgpaj7PCwF0";

    private ConexaoPSQL(){
        try {
            this.conector = DriverManager.getConnection(url, usuario,senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConexaoPSQL getInstanciador(){
        if(instanciador == null){
            instanciador = new ConexaoPSQL();
        }

        return instanciador;
    }

    public Connection getConector(){
        return conector;
    }

    public void fecharConector(){
        if(conector != null){
            try {
                conector.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
