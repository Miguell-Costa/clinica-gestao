package controller;

import dao.ConsultaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import db.DataBaseConnection;
import model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaController extends BaseController{
    private ConsultaDAO consultaDAO;
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;

    public ConsultaController(ConsultaDAO consultaDAO, PacienteDAO pacienteDAO, MedicoDAO medicoDAO) {
        this.consultaDAO = consultaDAO;
        this.pacienteDAO = pacienteDAO;
        this.medicoDAO = medicoDAO;
    }

    // metodo para marcar uma consulta
    public void marcarConsulta(int idPaciente, int idMedico, String dataConsulta, String horaConsulta, String observacoes){
        if (!pacienteDAO.existePaciente(idPaciente)){
            System.out.println("Não existe nenhum paciente com esse id!");
            return;
        }
        if (!medicoDAO.existeMedico(idMedico)){
            System.out.println("Não existe nenhum medico com esse id!");
            return;
        }
        if ((!validarData(dataConsulta))){
            System.out.println("Data Inválida! Use o formato AAAA/MM/DD");
            return;
        }
        if (!validarHora(horaConsulta)){
            System.out.println("Hora Inválida! Use o formato HH:hh");
            return;
        }
        if (!dataHoraFutura(dataConsulta, horaConsulta)){
            System.out.println("Horário Inválido! Insira um horário futuro");
            return;
        }
        if(!consultaDAO.verificarDisponiblidade(idMedico, dataConsulta, horaConsulta)){
            System.out.println("O medico não está disponivel neste horário");
            return;
        }

        Consulta consulta = new Consulta(idPaciente, idMedico, dataConsulta, horaConsulta, horaConsulta, observacoes);

        consultaDAO.marcarConsulta(idPaciente, idMedico, dataConsulta, horaConsulta, observacoes);
    }

    // metodo para desmarcar uma consulta
    public void desmarcarConsulta(int id){
        String sql = "DELETE FROM consulta WHERE id=?";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // metodo para listar todas as consultas
    public void listarConsultas(){
        List<Consulta> consultas = new ArrayList<>();

        consultas = consultaDAO.listarConsultas();

        for (Consulta c: consultas){
            System.out.println(c);
        }
    }

    // metodo para listar todas as consultas de uma paciente
    public void listarConsultasPaciente(int id){
        List<Consulta> consultas = new ArrayList<>();

        consultas = consultaDAO.listarConsultasPaciente(id);

        for (Consulta c: consultas){
            System.out.println(c);
        }
    }

    // metodo para listar todas as consultas de um medico
    public void listarConsultasMedico(int id){
        List<Consulta> consultas = new ArrayList<>();

        consultas = consultaDAO.listarConsultasMedico(id);

        for (Consulta c: consultas){
            System.out.println(c);
        }
    }
}
