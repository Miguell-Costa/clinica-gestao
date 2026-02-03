package controller;

import dao.PacienteDAO;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteController extends BaseController{
    private PacienteDAO pacienteDAO;

    public PacienteController(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    // adicionar paciente
    public void adicionarPaciente(String nome, String email, String telemovel, String dataNascimento){
        if(verificarParametros(email, telemovel, dataNascimento)){
            return;
        }

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
    public boolean verificarParametros(String email, String telemovel, String dataNascimento){
        if(!validarEmail(email)){
            System.out.println("Email Inválido!");
            return true;
        }

        if(!validarTelemovel(telemovel)){
            System.out.println("Numero de Telemovel Inválido!");
            return true;
        }

        if (!validarData(dataNascimento)){
            System.out.println("Data Inválida! Uso o formato AAAA/MM/DD");
            return true;
        }
        return false;
    }

}
