import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) {
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
                        System.out.println("Digite o id do professor: ");
                        int idProfessor = scanner.nextInt();
                        System.out.println("Digite o nome do professor: ");
                        String nomeProfessor = scanner.next();
                        System.out.println("Digite o departamento do professor: ");
                        String departamento = scanner.next();
                        new Professor(idProfessor, nomeProfessor, departamento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Professor");
                    }
                    break;
                    case 2:
                        try {
                            System.out.println("Cadastrar Curso");
                            System.out.println("Digite o id do curso: ");
                            int idCurso = scanner.nextInt();
                                System.out.println("Digite o nome do curso: ");
                                String nomeCurso = scanner.next();
                                System.out.println("Digite a carga horária do curso: ");
                                int carga_horaria = scanner.nextInt();
                                System.out.println("Digite o id do professor: ");
                                int idProfessor = scanner.nextInt();
                                Professor.verificaId(idProfessor);
                                Professor professor = Professor.buscaProfessor(idProfessor);
                                new Curso(idCurso, nomeCurso, carga_horaria, idProfessor);
                            } catch (Exception e) {
                                System.out.println("Erro ao cadastrar o Curso");
                            }
                    break;
                    case 3:
                    try {
                        System.out.println("Cadastrar Aluno");
                        System.out.println("Digite o id do aluno: ");
                        int idAluno = scanner.nextInt();
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
                        new Aluno(idAluno, nomeAluno, dt_nasc, CPF, idCurso);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Aluno");
                    }
                break;
                case 4:
                    System.out.println("Listar Professores");
                    for (Professor professor : Professor.professores) {
                        System.out.println("ID: " + professor.idProfessor);
                        System.out.println("Nome: " + professor.nomeProfessor);
                        System.out.println("Departamento: " + professor.departamento);
                        System.out.println("Cursos Lecionados: " + Professor.cursosLecionados(professor.idProfessor) + "/nAlunos: " + Curso.contarAlunosPorCurso(professor.idProfessor));
                        System.out.println("===================================");
                    }
                break;
                case 5:
                    System.out.println("Listar Cursos");
                    for (Curso curso : Curso.cursos) {
                        System.out.println("ID: " + curso.idCurso);
                        System.out.println("Nome: " + curso.nomeCurso);
                        System.out.println("Carga Horária: " + curso.carga_horaria);
                        System.out.println("Professor: " + Professor.buscaProfessor(curso.professor.idProfessor).nomeProfessor);
                        System.out.println("===================================");
                    }
                break;
                case 6:
                    System.out.println("Listar Alunos");
                    for (Aluno aluno : Aluno.alunos) {
                        System.out.println("ID: " + aluno.idAluno);
                        System.out.println("Nome: " + aluno.nomeAluno);
                        System.out.println("Data de Nascimento: " + aluno.dt_nasc);
                        System.out.println("CPF: " + aluno.CPF);
                        System.out.println("Curso: " + Curso.buscaCurso(aluno.curso.idCurso).nomeCurso);
                        System.out.println("===================================");
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