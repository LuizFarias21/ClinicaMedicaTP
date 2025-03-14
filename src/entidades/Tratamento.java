package entidades;

public abstract class Tratamento {
    private int contador = 0;
    private final String id;

    public Tratamento() {
        this.id = Integer.toString(++contador);
    }

    public String getId() {
        return id;
    }
}
