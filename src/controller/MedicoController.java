package controller;

import dao.MedicoDAO;
import model.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MedicoController extends BaseController{
    private MedicoDAO medicoDAO;

    public MedicoController(MedicoDAO medicoDAO) {
        this.medicoDAO = medicoDAO;
    }

    // metodo para criar medico
    public void inserirMedico(String nome, String especialidade, String email){
        if(!validarEmail(email)){
            System.out.println("Email Inválido");
            return;
        }

        Medico medico = new Medico(nome, especialidade, email);
        medicoDAO.create(medico);
    }

    // metodo para eliminar medico
    public void eliminarMedico(int id){
        if (!medicoDAO.existeMedico(id)){
            System.out.println("Não existe nenhum paciente com esse id!");
            return;
        }

        medicoDAO.delete(id);
    }

    // metodo para atualizar medico
    public void atualizarMedico(int id, String nome, String especialidade, String email){
        if (!medicoDAO.existeMedico(id)){
            System.out.println("Não existe nenhum paciente com esse id!");
            return;
        }
        if(!validarEmail(email)){
            System.out.println("Email Inválido");
            return;
        }

        Medico medico = new Medico(nome, especialidade, email);
        medicoDAO.update(id, medico);
    }

    // metodo para listar medicos
    public void listarMedicos(){
        List<Medico> medicos = new ArrayList<>();
        medicos = medicoDAO.read();

        for (Medico m: medicos){
            System.out.println(m);
        }
    }
}
