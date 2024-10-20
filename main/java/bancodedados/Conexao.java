package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    public String porta = "3306";
    public String nomServidor = "localhost";
    public String db = "produtos";
    public String user = "root";
    public String pass = ""; //
    Connection conn = null;

    public Connection conectar() {
        try {
            String url = "jdbc:mysql://" + nomServidor + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Conectado ao Banco de Dados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            return conn;
        }
    }

    public void desconectar() {
        conn = null;
        System.out.println("Desconexão... Pronto!!!");
    }
}
