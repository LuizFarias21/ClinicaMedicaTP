package servicos;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import repositorios.PessoaRepositorio;
import java.util.regex.Pattern;

public abstract class PessoaServico<TipoPessoa extends Pessoa> extends GenericoServico<TipoPessoa> {

    private final PessoaRepositorio<TipoPessoa> pessoaRepositorio;

    public PessoaServico(PessoaRepositorio<TipoPessoa> pessoaRepositorio) {
        super(pessoaRepositorio);
        this.pessoaRepositorio = pessoaRepositorio;
    }

@Override
public void cadastrar(TipoPessoa pessoa) throws DadoInvalidoException {
    if (validarCpf(pessoa.getCpf())) throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
    if (validarCpfDuplicado(pessoa.getCpf())) throw new DadoInvalidoException("Já existe um registro com o CPF: " + pessoa.getCpf());
    pessoaRepositorio.cadastrar(pessoa);
}

    @Override
    public TipoPessoa buscar(String cpf) throws DadoInvalidoException {

        if (validarCpf(cpf)) {
            throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
        }

        TipoPessoa pessoa = pessoaRepositorio.buscar(cpf);

        if (pessoa == null) {
            throw new DadoInvalidoException("Nenhum registro encontrado para o CPF: " + cpf);
        }

        return pessoa;
    }

    @Override
    public void atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) throws DadoInvalidoException {
        if (validarCpf(pessoa.getCpf()) || validarCpf(novaPessoa.getCpf())) throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
        if (novaPessoa.getCpf() != null && !novaPessoa.getCpf().equals(pessoa.getCpf()) && validarCpfDuplicado(novaPessoa.getCpf())) {
            throw new DadoInvalidoException("Já existe um registro com o CPF: " + novaPessoa.getCpf());
        }
        pessoaRepositorio.atualizar(pessoa, novaPessoa);
    }

    public boolean validarCpf(String cpf) {

        if (cpf.trim().isEmpty()) return true;

        // Segue o formato XXX.XXX.XXX-XX?
        final Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        return !cpfPattern.matcher(cpf).matches();
    }

    public boolean validarCpfDuplicado(String cpf) {
        for (Pessoa pessoa : pessoaRepositorio.getListaPessoas()) {
            if (pessoa.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}