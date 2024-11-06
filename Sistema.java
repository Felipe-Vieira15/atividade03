import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/sistemaescola";
        final String user = "root";
        final String password = ""; 
        System.out.println("Sistema Escolar");
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        do {
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;
            }

            switch (opt) {
                case 1:
                    try {
                        System.out.println("Cadastrar Professor");
                        System.out.println("Digite o nome do professor: ");
                        String nomeProfessor = scanner.next();
                        System.out.println("Digite o departamento do professor: ");
                        String departamento = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO professor "
                        + "(nomeProfessor, departamento) VALUES "
                        + "(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nomeProfessor);
                        stm.setString(2, departamento);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                int idProfessor = rs.getInt(1);
                                new Professor(idProfessor, nomeProfessor, departamento);
                            }
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                    case 2:
                        try {
                            System.out.println("Cadastrar Curso");
                            System.out.println("Digite o nome do curso: ");
                            String nomeCurso = scanner.next();
                            System.out.println("Digite a carga horária do curso: ");
                            int carga_horaria = scanner.nextInt();
                            System.out.println("Digite o id do professor: ");
                            int idProfessor = scanner.nextInt();
                            Professor professor = Professor.buscaProfessor(idProfessor);

                            Connection con = DriverManager.getConnection(url, user, password);
                            PreparedStatement stm = con.prepareStatement("INSERT INTO curso "
                            + "(nomeCurso, carga_horaria, idProfessor) VALUES "
                            + "(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                            stm.setString(1, nomeCurso);
                            stm.setInt(2, carga_horaria);
                            stm.setInt(3, idProfessor);
                            if (stm.executeUpdate() > 0) {
                                ResultSet rs = stm.getGeneratedKeys();

                                if (rs.next()) {
                                    int idCurso = rs.getInt(1);
                                    new Curso(idCurso, nomeCurso, carga_horaria, professor);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;


                    case 3:
                    try {
                        System.out.println("Cadastrar Aluno");
                        System.out.println("Digite o nome do aluno: ");
                        String nomeAluno = scanner.next();
                        System.out.println("Digite a data de nascimento do aluno: ");
                        String dt_nasc = scanner.next();
                        System.out.println("Digite o CPF do aluno: ");
                        String CPF = scanner.next();
                        System.out.println("Digite o id do curso: ");
                        int idCurso = scanner.nextInt();
                        Curso.verificaid(idCurso);
                        Curso curso = Curso.buscaCurso(idCurso);

                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO aluno "
                        + "(nomeAluno, dt_nasc, CPF, idCurso) VALUES "
                        + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nomeAluno);
                        stm.setString(2, dt_nasc);
                        stm.setString(3, CPF);
                        stm.setInt(4, idCurso);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                int idAluno = rs.getInt(1);
                                new Aluno(idAluno, nomeAluno, dt_nasc, CPF, curso);
                            }
                        }

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                break;


                case 4:
                try {
                    System.out.println("Listar Professores");
                    Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM professor");
                        while (rs.next()) {
                            Professor professor = new Professor (
                                rs.getInt("idProfessor"),
                                rs.getString("nomeProfessor"),
                                rs.getString("departamento")
                            );
                            System.out.println(professor);
                        }
                        con.close(); 
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;


                case 5:
                try {
                    System.out.println("Listar Cursos");
                    Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM curso");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("idCurso"));
                            System.out.println("Nome: " + rs.getString("nomeCurso"));
                            System.out.println("Carga Horária: " + rs.getInt("carga_horaria"));
                            System.out.println("Professor: " + Professor.buscaProfessor(rs.getInt("idProfessor")).nomeProfessor);
                            System.out.println("===================================");
                        }
                        con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;


                case 6:
                try {
                    System.out.println("Listar Alunos");
                    Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM aluno");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("idAluno"));
                            System.out.println("Nome: " + rs.getString("nomeAluno"));
                            System.out.println("Data de Nascimento: " + rs.getString("dt_nasc"));
                            System.out.println("CPF: " + rs.getString("CPF"));
                            System.out.println("Curso: " + Curso.buscaCurso(rs.getInt("idCurso")).nomeCurso);
                            System.out.println("===================================");
                        }
                        con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;


                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opt != 7); 

        scanner.close();
    }
}