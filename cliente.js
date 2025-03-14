

document.addEventListener("DOMContentLoaded", function () {
    carregarClientes();
});

function carregarClientes() {
    fetch("ClienteServlet")
        .then(response => response.json())
        .then(clientes => {
            let tabela = document.getElementById("tabela-clientes");
            tabela.innerHTML = "";
            clientes.forEach(cliente => {
                let row = tabela.insertRow();
                row.innerHTML = `
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.telefone}</td>
                    <td>
                        <button onclick="editarCliente(${cliente.id}, '${cliente.nome}', '${cliente.email}', '${cliente.telefone}')">Editar</button>
                        <button onclick="deletarCliente(${cliente.id})">Excluir</button>
                    </td>
                `;
            });
        });
}

function cadastrarCliente() {
    let nome = document.getElementById("nome").value;
    let email = document.getElementById("email").value;
    let telefone = document.getElementById("telefone").value;
    
    let cliente = { nome, email, telefone };
    
    fetch("ClienteServlet", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    }).then(() => carregarClientes());
}

function editarCliente(id, nome, email, telefone) {
    document.getElementById("cliente-id").value = id;
    document.getElementById("nome").value = nome;
    document.getElementById("email").value = email;
    document.getElementById("telefone").value = telefone;
    document.getElementById("btnSalvar").setAttribute("onclick", "atualizarCliente()");
}

function atualizarCliente() {
    let id = document.getElementById("cliente-id").value;
    let nome = document.getElementById("nome").value;
    let email = document.getElementById("email").value;
    let telefone = document.getElementById("telefone").value;
    
    let cliente = { id, nome, email, telefone };
    
    fetch(`ClienteServlet?id=${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    }).then(() => carregarClientes());
}

function deletarCliente(id) {
    fetch(`ClienteServlet?id=${id}`, {
        method: "DELETE"
    }).then(() => carregarClientes());
}

