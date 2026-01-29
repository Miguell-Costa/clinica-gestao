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
