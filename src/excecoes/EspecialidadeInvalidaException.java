package excecoes;

import entidades.Medico;

public final class EspecialidadeInvalidaException extends Exception {
    public EspecialidadeInvalidaException(Medico medicoResponsavel) {
        super("Dr. " +  medicoResponsavel.getNome() + " nao tem a especialidade requerida para esta consulta.");
    }
}
