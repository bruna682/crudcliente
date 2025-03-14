
package com.mycompany.testecrud6;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (cli_nome, cli_email, cli_senha, cli_genero, cli_data_nascimento, cpf, cli_telefone_tipo, cli_telefone_ddd, cli_telefone_numero, cli_status, cli_ranking) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCliNome());
            stmt.setString(2, cliente.getCliEmail());
            stmt.setString(3, cliente.getCliSenha());
            stmt.setString(4, cliente.getCliGenero());
            stmt.setString(5, cliente.getCliDataNascimento());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getCliTelefoneTipo());
            stmt.setString(8, cliente.getCliTelefoneDdd());
            stmt.setString(9, cliente.getCliTelefoneNumero());
            stmt.setString(10, cliente.getCliStatus());
            stmt.setInt(11, cliente.getCliRanking());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("cli_id"),
                    rs.getString("cli_nome"),
                    rs.getString("cli_email"),
                    rs.getString("cli_senha"),
                    rs.getString("cli_genero"),
                    rs.getString("cli_data_nascimento"),
                    rs.getString("cpf"),
                    rs.getString("cli_telefone_tipo"),
                    rs.getString("cli_telefone_ddd"),
                    rs.getString("cli_telefone_numero"),
                    rs.getString("cli_status"),
                    rs.getInt("cli_ranking")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET cli_nome=?, cli_email=?, cli_telefone_tipo=?, cli_telefone_ddd=?, cli_telefone_numero=?, cli_status=?, cli_ranking=? WHERE cli_id=?";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCliNome());
            stmt.setString(2, cliente.getCliEmail());
            stmt.setString(3, cliente.getCliTelefoneTipo());
            stmt.setString(4, cliente.getCliTelefoneDdd());
            stmt.setString(5, cliente.getCliTelefoneNumero());
            stmt.setString(6, cliente.getCliStatus());
            stmt.setInt(7, cliente.getCliRanking());
            stmt.setInt(8, cliente.getCliId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE cli_id=?";

        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
