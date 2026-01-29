package dao;

import db.DataBaseConnection;
import model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    // metodo para marcar uma consulta
    public void marcarConsulta(int idPaciente, int idMedico, String dataConsulta, String horaConsulta, String observacoes){
        String sql = "INSERT INTO consulta (id_paciente, id_medico, data_consulta, hora_consulta, observacoes)";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idPaciente);
            stmt.setInt(2, idMedico);
            stmt.setString(3, dataConsulta);
            stmt.setString(4, horaConsulta);
            stmt.setString(5, observacoes);

            stmt.executeUpdate();

            System.out.println("Consulta marcada com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro");
        }
    }

    public void cancelarConsulta(int id){
        String sql = "DELETE FROM consulta WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Consulta cancelado com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
    }

    // metpodp para listar todas as consultas
    public List<Consulta> listarConsultas(){
        String sql = "SELECT * FROM consulta";
        List<Consulta> consultas = new ArrayList<>();

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Consulta novaConsulta = new Consulta(
                        rs.getInt("id"),
                        rs.getInt("paciente_id"),
                        rs.getInt("medico_id"),
                        rs.getString("data_consulta"),
                        rs.getString("hora_consulta"),
                        rs.getString("observacoes")
                );
                consultas.add(novaConsulta);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro");
        }

        return consultas;
    }

    // metodo para listar consultas de um paciente
    public List<Consulta> listarConsultasPaciente(int pacienteId){
        String sql = "SELECT * FROM Consulta WHERE paciente_id=?";
        List<Consulta> consultas = new ArrayList<>();

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){

            stmt.setInt(1, pacienteId);

            stmt.executeQuery();

            while(rs.next()){
                Consulta consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getInt("paciente_id"),
                        rs.getInt("medico_id"),
                        rs.getString("data_consulta"),
                        rs.getString("hora_consulta"),
                        rs.getString("observacoes")
                );
                consultas.add(consulta);
            }
        }catch (SQLException e){
            System.out.println("Erro!");
        }
        return consultas;
    }
}
