package model;

// classe que representa um medico

public class Medico {
    private int id;
    private String nome;
    private String especialidade;
    private String email;

    // construtor com id
    public Medico(int id, String nome, String especialidade, String email){
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
    }

    // construtor sem id
    public Medico(String nome, String especialidade, String email){
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
