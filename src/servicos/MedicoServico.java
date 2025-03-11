package servicos;

import entidades.Consulta;
import entidades.Medico;
import repositorios.MedicoRepositorio;

public final class MedicoServico extends PessoaServico<Medico> {

    public MedicoServico(MedicoRepositorio medicoRepositorio) {
        super(medicoRepositorio);
    }

    public static void registrarHistorico(Consulta consulta) {
        consulta.getMedicoResponsavel().getHistoricoMedico().add(consulta);
    }
}