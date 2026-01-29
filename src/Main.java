import dao.MedicoDAO;
import dao.PacienteDAO;
import model.Medico;
import model.Paciente;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();





        pacienteDAO.delete(1);
        medicoDAO.delete(1);


    }
}