package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {
       var dataConsulta = dados.data();
       var agora = LocalDateTime.now();
       var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

       if (diferencaEmMinutos < 30) {
           try {
               throw new ValidacaoException("Consulta deve ser agendada com antecedência minima de 30 mínutos");
           } catch (ValidacaoException e) {
               throw new RuntimeException(e);
           }
       }
    }
}
