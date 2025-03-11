package excecoes;

import entidades.Consulta;

public final class HorarioIndisponivelException extends Exception {

//    public HorarioIndisponivelException(Consulta consulta) {
//		super(String.format(
//			"O horário da consulta já está ocupado: De %s a %s; Duração total: %s",
//				consulta.getHorario(),
//				consulta.getHorarioFinal(),
//				consulta.getDuracao()
//		));
//    }

	public HorarioIndisponivelException(String mensagem) {
		super(mensagem);
	}

}
