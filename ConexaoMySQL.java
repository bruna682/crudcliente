
package com.mycompany.testecrud6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class ConexaoMySQL {
    
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce2?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "1234"; 
    
    public static Connection conectar() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC do MySQL não encontrado!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }
}
