package model;

// classe que representa um paciente

public class paciente {
    private int id;
    private String nome;
    private String email;
    private int telemovel;
    private String dataNascimento;

    // Construtor com id
    public paciente(int id, String nome, String email, int telemovel, String dataNascimento){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
    }

    // Construtor sem id
    public paciente( String nome, String email, int telemovel, String dataNascimento){
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telemovel=" + telemovel +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
