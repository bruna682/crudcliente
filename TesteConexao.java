
package com.mycompany.testecrud6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = ConexaoMySQL.conectar();
        if (conn != null) {
            System.out.println(" Conexão bem-sucedida!");
        } else {
            System.out.println("  Falha na conexão!");
        }
    }
}



