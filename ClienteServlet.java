
package com.mycompany.testecrud6;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(reader, Cliente.class);

        if (cliente.getCliDataNascimento() != null && !cliente.getCliDataNascimento().isEmpty()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = format.parse(cliente.getCliDataNascimento());
            Date sqlDate = new Date(parsedDate.getTime()); 
            cliente.setCliDataNascimento(sqlDate.toString()); 
        }

        clienteDAO.cadastrarCliente(cliente);

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().write("{\"message\": \"Cliente cadastrado com sucesso\"}");
    } catch (ParseException e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"error\": \"Formato de data inválido. Use o formato YYYY-MM-DD.\"}");
    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
    }
}

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = clienteDAO.listarClientes();
        String json = gson.toJson(clientes);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clienteDAO.deletarCliente(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Cliente cliente = new Gson().fromJson(reader, Cliente.class);
        clienteDAO.atualizarCliente(cliente);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}