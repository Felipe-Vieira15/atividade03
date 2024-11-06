import java.util.ArrayList;

public class Aluno {

    int idAluno;
    String nomeAluno;
    String dt_nasc;
    String CPF;
    int idCurso;

    Curso curso;

    public Aluno(int idAluno, String nomeAluno, String dt_nasc, String CPF, Curso curso) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.dt_nasc = dt_nasc;
        this.CPF = CPF;
        this.curso = curso;

        alunos.add(this);
    }

    public Aluno(int idAluno, String nomeAluno, String dt_nasc, String CPF, int idCurso) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.dt_nasc = dt_nasc;
        this.CPF = CPF;
        this.idCurso = idCurso;

        alunos.add(this);
    }

    static void verificaid(int idAluno) throws Exception {
        for (Aluno aluno : alunos) {
            if (aluno.idAluno == idAluno) {
                return;
            }
        }
        throw new Exception("Aluno não encontrado");
    }

    static Aluno buscaAluno(int idAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.idAluno == idAluno) {
                return aluno;
            }
        }
        return null;
    }
}
