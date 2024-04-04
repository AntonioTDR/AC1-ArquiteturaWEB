package main.java.model;

public class Student {
    private Long id;
    private String Nome;
    private String setSegundoNome;
    private String Endereco;
    private String cpf;

    public Student(Long id, String Nome, String setSegundoNome, String Endereco, String cpf) {
        this.id = id;
        this.Nome = Nome;
        this.setSegundoNome = setSegundoNome;
        this.Endereco = Endereco;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getsetSegundoNome() {
        return setSegundoNome;
    }

    public void setsetSegundoNome(String setSegundoNome) {
        this.setSegundoNome = setSegundoNome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}