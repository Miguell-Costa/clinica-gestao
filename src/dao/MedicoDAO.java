package dao;

import db.DataBaseConnection;
import model.Medico;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void create(Medico medico){
        String sql = "INSERT INTO medico (nome, especialidade, email) VALUES(?,?,?)";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getEmail());

            stmt.executeUpdate();

            System.out.println("Medico adicionado com sucesso!");

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
    }

    public List<Medico> read(){
        String sql = "SELECT * FROM medico";
        List<Medico> medicos = new ArrayList<>();

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                Medico novoMedico = new Medico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getString("email")
                );
                medicos.add(novoMedico);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }

        return medicos;
    }

    public void update(int id, Medico medico){
        String sql = "UPDATE medico SET nome=?, especialidade=?, email=? WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getEmail());
            stmt.setInt(4, id);

            stmt.executeUpdate();

            System.out.println("Medico altualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM medico WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Paciente elmindado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
    }

    // metodo para verificar se um medico existe atraves do id
    public boolean existeMedico(int id){
        String sql = "Select 1 FROM medico WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
