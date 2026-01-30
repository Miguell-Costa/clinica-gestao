import controller.ConsultaController;
import controller.MedicoController;
import controller.PacienteController;
import dao.ConsultaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        PacienteController pacienteController = new PacienteController(pacienteDAO);
        MedicoDAO medicoDAO = new MedicoDAO();
        MedicoController medicoController = new MedicoController(medicoDAO);
        ConsultaDAO consultaDAO = new ConsultaDAO();
        ConsultaController consultaController = new ConsultaController(consultaDAO, pacienteDAO, medicoDAO);

        Scanner ler = new Scanner(System.in);
        int op, op1, op2, op3;

        do {
            System.out.println("1 - Gerir Pacientes");
            System.out.println("2 - Gerir Medicos");
            System.out.println("3 - Gerir Consultas");
            System.out.println("0 - Sair");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    do {
                        System.out.println("1 - Inserir Paciente");
                        System.out.println("2 - Eliminar Paciente");
                        System.out.println("3 - Atualizar Paciente");
                        System.out.println("4 - Listar Pacientes");
                        System.out.println("0 - Voltar");
                        op1 = ler.nextInt();
                        ler.nextLine();

                        switch (op1) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Insira o nome do paciente");
                                String nome = ler.nextLine();
                                System.out.println("Insira o email do paciente");
                                String email = ler.nextLine();
                                System.out.println("Insira o telemovel do paciente");
                                String telemovel = ler.nextLine();
                                System.out.println("Insira a data de nascimento do paciente");
                                String dataNascimento = ler.nextLine();

                                pacienteController.adicionarPaciente(nome, email, telemovel, dataNascimento);
                                break;
                            case 2:
                                System.out.println("Insira o id do paciente para eliminar");
                                int idEliminar = ler.nextInt();
                                ler.nextLine();

                                pacienteController.eliminarPaciente(idEliminar);
                                break;
                            case 3:
                                System.out.println("Insira o id do paciente para atualizar");
                                int idUpdate = ler.nextInt();
                                ler.nextLine();
                                System.out.println("Insira o novo nome do paciente");
                                String nomeUpdate = ler.nextLine();
                                System.out.println("Insira o novo email do paciente");
                                String emailUpdate = ler.nextLine();
                                System.out.println("Insira o novo telemovel do paciente");
                                String telemovelUpdate = ler.nextLine();
                                System.out.println("Insira a nova data de nascimento do paciente");
                                String dataNascimentoUpdate = ler.nextLine();

                                pacienteController.atualizarPaciente(idUpdate, nomeUpdate, emailUpdate, telemovelUpdate, dataNascimentoUpdate);
                                break;
                            case 4:
                                System.out.println("LISTA PACIENTES");
                                pacienteController.listarPacientes();
                                break;
                        }
                    } while (op1 != 0);

                    break;
                case 2:
                    do {
                        System.out.println("1 - Inserir Medico");
                        System.out.println("2 - Eliminar Medico");
                        System.out.println("3 - Atualizar Medico");
                        System.out.println("4 - Listar Medicos");
                        System.out.println("0 - Voltar");
                        op2 = ler.nextInt();
                        ler.nextLine();

                        switch (op2) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Insira o nome do medico");
                                String nome = ler.nextLine();
                                System.out.println("Insira a especialidade do medico");
                                String especialidade = ler.nextLine();
                                System.out.println("Insira o email do medico");
                                String email = ler.nextLine();

                                medicoController.inserirMedico(nome, especialidade, email);
                                break;
                            case 2:
                                System.out.println("Insira o id do medico para eliminar");
                                int idEliminar = ler.nextInt();
                                ler.nextLine();

                                medicoController.eliminarMedico(idEliminar);
                                break;
                            case 3:
                                System.out.println("Insira o id do medico para atualizar");
                                int idUpdate = ler.nextInt();
                                ler.nextLine();
                                System.out.println("Insira o nome do medico");
                                String nomeUpdate = ler.nextLine();
                                System.out.println("Insira a especialidade do medico");
                                String especialidadeUpdate = ler.nextLine();
                                System.out.println("Insira o email do medico");
                                String emailUpdate = ler.nextLine();

                                medicoController.atualizarMedico(idUpdate, nomeUpdate, especialidadeUpdate, emailUpdate);
                                break;
                            case 4:
                                System.out.println("LISTAR MEDICOS");
                                medicoController.listarMedicos();
                                break;
                        }
                    } while (op2 != 0);

                    break;
                case 3:
                    System.out.println("1 - Marcar Consulta");
                    System.out.println("2 - Desmarcar Consulta");
                    System.out.println("3 - Listar Consultas");
                    System.out.println("4 - Listar Consultas de um Paciente");
                    System.out.println("5 - Listar Consultas de um Medico");
                    System.out.println("0 - Voltar");
                    op3 = ler.nextInt();

                    switch (op3) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Introduza o id do paciente");
                            int idPaciente = ler.nextInt();
                            ler.nextLine();
                            System.out.println("Introduza o id do medico");
                            int idMedico = ler.nextInt();
                            ler.nextLine();
                            System.out.println("Introduza a data da consulta (AAAA/MM/DD)");
                            String data = ler.nextLine();
                            System.out.println("Introduza a hora da consulta (HH/hh)");
                            String hora = ler.nextLine();
                            System.out.println("Introduza obervações caso necessário");
                            String observacoes = ler.nextLine();

                            consultaController.marcarConsulta(idPaciente, idMedico, data, hora, observacoes);
                            break;
                        case 2:
                            System.out.println("Introduza o id da consulta para desmarcar");
                            int id = ler.nextInt();
                            ler.nextLine();
                            consultaController.desmarcarConsulta(id);
                            break;
                        case 3:
                            consultaController.listarConsultas();
                            break;
                        case 4:
                            System.out.println("Introduza o id do paicente para ver as suas concultas");
                            int idPcienteListar = ler.nextInt();
                            ler.nextLine();
                            consultaController.listarConsultasPaciente(idPcienteListar);
                            break;
                        case 5:
                            System.out.println("Introduza o id do medico para ver as suas concultas");
                            int idMedicoListar = ler.nextInt();
                            ler.nextLine();
                            consultaController.listarConsultasPaciente(idMedicoListar);
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                    }
                    break;
            }
        } while (op != 0);


    }
}