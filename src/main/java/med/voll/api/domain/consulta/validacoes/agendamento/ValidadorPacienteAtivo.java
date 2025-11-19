package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) throws ValidacaoException {
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!repository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("ID do paciente não existe.");
        }

        if (!pacienteAtivo) {
            throw new ValidacaoException("O paciente selecionado está inativo.");
        }
    }
}
