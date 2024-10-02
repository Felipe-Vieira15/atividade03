import java.util.ArrayList;

public class Curso {
    
    int idCurso;
    String nomeCurso;
    int carga_horaria;
    int idProfessor;

    Professor professor;

    static ArrayList<Curso> cursos = new ArrayList<>();

    public Curso(int idCurso, String nomeCurso, int carga_horaria, Professor professor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.carga_horaria = carga_horaria;
        this.professor = professor;

        cursos.add(this);
    }

    public Curso(int idCurso, String nomeCurso, int carga_horaria, int idProfessor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.carga_horaria = carga_horaria;
        this.idProfessor = idProfessor;

        cursos.add(this);
    }

    static void verificaid(int idCurso) throws Exception {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    static Curso buscaCurso(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return curso;
            }
        }
        return null;
    }

    static int contarAlunosPorCurso(int idCurso) {
        int cont = 0;
        for (Aluno aluno : Aluno.alunos) {
            if (aluno.idCurso == idCurso) {
                cont++;
            }
        }
        return cont;
    }
}
