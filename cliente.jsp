<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gerenciamento de Clientes</title>
        <script src="js/cliente.js"></script>
    </head>
    <body>
        <h1>Gerenciamento de Clientes</h1>

        <form id="form-cliente">
            <input type="hidden" id="cliente-id">
            <label>Nome:</label> <input type="text" id="nome" required><br>
            <label>Email:</label> <input type="email" id="email" required><br>
            <label>Telefone:</label> <input type="text" id="telefone" required><br>
            <button type="button" id="btnSalvar" onclick="cadastrarCliente()">Salvar</button>
        </form>

        <h2>Lista de Clientes</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody id="tabela-clientes"></tbody>
        </table>
    </body>
</html>
