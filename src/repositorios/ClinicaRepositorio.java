package repositorios;

public class ClinicaRepositorio<T> extends GenericoRepositorio<T> {

    @Override
    public T buscar(String identificador) {
        int id = Integer.parseInt(identificador);
        return listar().get(id);
    }

//    @Override
//    public void atualizar(T t, T novaT) {
//
//    }
}
