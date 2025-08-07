// Salvar dados
function salvarDados(nome, telefone, data, hora, servico) {
  let cadastros = JSON.parse(localStorage.getItem("cadastros")) || [];
  let agendamentos = JSON.parse(localStorage.getItem("agendamentos")) || [];

  const idCliente = cadastros.length + 1;

  const cliente = { id: idCliente, nome, telefone };
  cadastros.push(cliente);
  localStorage.setItem("cadastros", JSON.stringify(cadastros));

  const agendamento = { id: agendamentos.length + 1, clienteId: idCliente, nomeCliente: nome, data, hora, servico };
  agendamentos.push(agendamento);
  localStorage.setItem("agendamentos", JSON.stringify(agendamentos));

  console.log("Cliente e agendamento salvos com sucesso!");
}

// Listar agendamentos
function listarAgendamentosLocal() {
  const agendamentos = JSON.parse(localStorage.getItem("agendamentos")) || [];
  agendamentos.forEach(ag => {
    console.log(`${ag.nomeCliente} - ${ag.data} às ${ag.hora} (${ag.servico})`);
  });
}

salvarDados("Carlos Mendes", "1191111-2222", "2025-08-12", "16:00", "Corte + Barba");
listarAgendamentosLocal();
