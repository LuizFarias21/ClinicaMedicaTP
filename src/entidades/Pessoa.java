package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private ArrayList<Consulta> historicoConsultas;
    private ArrayList<Exame> historicoExames;

    Pessoa(String nome, String CPF, LocalDate dataNascimento, ArrayList<Consulta> historicoConsultas, ArrayList<Exame> historicoExames) {
        /*
        if (setCpf(cpf) != ResultadoCPF.SUCESSO){
            throw new RuntimeException("CPF inválido.");
        } else {
            this.cpf = cpf;
        }
         */
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.historicoConsultas = historicoConsultas;
        this.historicoExames = historicoExames;
    }

    public void adicionarConsulta(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    public void adicionarExame(Exame exame){
        historicoExames.add(exame);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /*
    public static enum ResultadoCPF
    {
        PADRAO_INVALIDO,
        SUCESSO,
        DV1_INVALIDO,
        DV2_INVALIDO
    }
*/

    /*
    public ResultadoCPF setCpf(String CPF) {
        // Passo 1: Segue o formato XXX.XXX.XXX-XX?
        Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher cpfMatcher = cpfPattern.matcher(CPF);
        if (!cpfMatcher.matches()) return ResultadoCPF.PADRAO_INVALIDO;
        // Passo 2: Os dígitos verificadores são válidos?
        String digitos = CPF.replaceAll("[^\\d]", "");

        // D.V. 1
        int dv = 0;
        for (int i = 0; i < 9; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (10 - i);
        int mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(9))) return ResultadoCPF.DV1_INVALIDO;

        // D.V. 2
        dv = 0;
        for (int i = 0; i < 10; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (11 - i);
        mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(10))) return ResultadoCPF.DV2_INVALIDO;

        cpf = CPF;
        return ResultadoCPF.SUCESSO;
    }
 */

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void setHistoricoConsultas(ArrayList<Consulta> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public ArrayList<Exame> getHistoricoExames() {
        return historicoExames;
    }

    public void setHistoricoExames(ArrayList<Exame> historicoExames) {
        this.historicoExames = historicoExames;
    }
}
