import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Curso {
    
    int idCurso;
    String nomeCurso;
    int carga_horaria;
    int idProfessor;

    Professor professor;

    public Curso(int idCurso, String nomeCurso, int carga_horaria, Professor professor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.carga_horaria = carga_horaria;
        this.professor = professor;
    }

    public Curso(int idCurso, String nomeCurso, int carga_horaria, int idProfessor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.carga_horaria = carga_horaria;
        this.idProfessor = idProfessor;

    }

    static Curso buscaCurso(int idCurso) {
        final String url = "jdbc:mysql://localhost:3306/sistemaescola";
        final String user = "root";
        final String password = ""; 
        Curso curso = null;
        
    }

//     static int contarAlunosPorCurso(int idCurso) {
//         int cont = 0;
//         for (Aluno aluno : Aluno.alunos) {
//             if (aluno.idCurso == idCurso) {
//                 cont++;
//             }
//         }
//         return cont;
//     }
// }
