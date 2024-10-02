import java.util.ArrayList;

public class Professor {
    
    int idProfessor;
    String nomeProfessor;
    String departamento;


    static ArrayList<Professor> professores = new ArrayList<>();

    public Professor(int idProfessor, String nomeProfessor, String departamento) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.departamento = departamento;

        professores.add(this);
    }
    
    static void verificaId(int idProfessor) throws Exception {
        for (Professor professor : professores) {
            if (professor.idProfessor == idProfessor) {
                return;
            }
        }
        throw new Exception("Professor não encontrado");
    }

    static Professor buscaProfessor(int idProfessor) {
        for (Professor professor : professores) {
            if (professor.idProfessor == idProfessor) {
                return professor;
            }
        }
        return null;
    }

    static String cursosLecionados(int idProfessor) {
        String cursos = "";
        for (Curso curso : Curso.cursos) {
            if (curso.idProfessor == idProfessor) {
                cursos += curso.nomeCurso + "\n";
            }
        }
        return cursos;
    }
}