package controller;

import dao.PacienteDAO;
import model.Paciente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PacienteController {
    private PacienteDAO pacienteDAO;

    public PacienteController(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    // adicionar paciente
    public void adicionarPaciente(String nome, String email, String telemovel, String dataNascimento){
        verificarParametros(email, telemovel, dataNascimento);

        Paciente paciente = new Paciente(nome, email, telemovel, dataNascimento);

        pacienteDAO.create(paciente);

    }

    // metodo para eliminar paciente
    public void eliminarPaciente(int id){
        if (!pacienteDAO.existePaciente(id)){
            System.out.println("Não existe nenhum paciente com esse id!");
            return;
        }

        pacienteDAO.delete(id);
    }

    // metodo para atualizar um paciente
    public void atualizarPaciente(int id, String nome, String email, String telemovel, String dataNascimento){
        if (!pacienteDAO.existePaciente(id)){
            System.out.println("Não existe nenhum paciente com esse id!");
            return;
        }

        verificarParametros(email, telemovel, dataNascimento);

        Paciente paciente = new Paciente(nome, email, telemovel, dataNascimento);

        pacienteDAO.update(id, paciente);
    }

    // metodo para lisar pacientes
    public void listarPacientes(){
        List<Paciente> pacientes = new ArrayList<>();

        pacientes = pacienteDAO.read();

        for(Paciente p: pacientes){
            System.out.println(p);
        }
    }

    // metodo para verificar os parametros
    public void verificarParametros(String email, String telemovel, String dataNascimento){
        if(!validarEmail(email)){
            System.out.println("Email Inválido!");
            return;
        }

        if(!validarTelemovel(telemovel)){
            System.out.println("Numero de Telemovel Inválido!");
            return;
        }

        if (!validarData(dataNascimento)){
            System.out.println("Data Inválida! Uso o formato AAAA/MM/DD");
            return;
        }
    }

    // metodo para verificar um email
    public boolean validarEmail(String email){
        String regex = "^[\\w.-]+@([a-zA-Z-]+\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Metodo para verificar telemovel
    public boolean validarTelemovel(String telemovel){
        String regex = "^9\\d{8}$";
        return Pattern.matches(regex, telemovel);
    }

    // Metodo para verificar a data
    public boolean validarData(String data) {

        // Verificar formato YYYY/MM/DD
        String regex = "^\\d{4}/\\d{2}/\\d{2}$";
        if (!Pattern.matches(regex, data)) {
            return false;
        }

        // Verificar se a data existe
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
