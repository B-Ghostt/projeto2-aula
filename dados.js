const agendamentos = []; // Memória temporária (será substituído por banco depois)

document.getElementById("agendamento-form").addEventListener("submit", function (e) {
  e.preventDefault();

  const nome = document.getElementById("nome").value;
  const data = document.getElementById("data").value;
  const hora = document.getElementById("hora").value;
  const barbeiro = document.getElementById("barbeiro").value;

  // Verifica conflitos
  const conflito = agendamentos.find(
    (a) => a.data === data && a.hora === hora && a.barbeiro === barbeiro
  );

  if (conflito) {
    document.getElementById("confirmacao").innerText =
      "Horário já reservado para esse barbeiro. Escolha outro horário.";
    return;
  }

  // Salva agendamento
  const novoAgendamento = { nome, data, hora, barbeiro };
  agendamentos.push(novoAgendamento);

  // Mostra confirmação
  document.getElementById("confirmacao").innerText =
    `Agendamento confirmado para ${nome} com ${barbeiro} no dia ${data} às ${hora}.`;

  // Limpa formulário
  document.getElementById("agendamento-form").reset();
});
