package dao;

import db.DataBaseConnection;
import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // Metodo para adicionar um paciente na base de dados
    public void create(Paciente paciente){
        String sql = "INSERT INTO paciente (nome, email, telemovel, data_nascimento) VALUES(?,?,?,?)";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getTelemovel());
            stmt.setString(4, paciente.getDataNascimento());

            stmt.executeUpdate();

            System.out.println("Paciente adicionado com sucesso!");
        }catch (SQLException e){
            System.out.println("Erro ao adicionar paciente");
        }
    }

    // metodo read para obter todos os registos de pacientes na base de dados
    public List<Paciente> read(){
        String sql = "SELECT * FROM paciente";
        List<Paciente> pacientes = new ArrayList<>();

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                Paciente novoPaciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telemovel"),
                        rs.getString("data_nascimento")
                );
                pacientes.add(novoPaciente);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
        return pacientes;
    }

    // metodo update para alterar um registo da base de dados atravez do id
    public void update(int id, Paciente paciente){
        String sql = "UPDATE paciente SET nome=?, email=?, telemovel=?, data_Nascimento=? WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getTelemovel());
            stmt.setString(4, paciente.getDataNascimento());
            stmt.setInt(5, id);

            stmt.executeUpdate();

            System.out.println("Paciente alterado com sucesso!");
        }catch (SQLException e){
            System.out.println("Erro ao alterar Paciente");
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM paciente WHERE id=?";

        try(Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Paciente eleminado com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro!");
        }
    }

    // metodo para verificar se um paciente existe atraves do id
    public boolean existePaciente(int id){
        String sql = "Select 1 FROM paciente WHERE id=?";

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
