package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controllers.SampleController;

public class AlunosDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	List<Alunos> lista = new ArrayList<>();
    
	
	
	
    public boolean registerAlunos(Alunos alunos){
        String insertFields = "INSERT INTO sis_alunos_db.alunos (Matricula, Nome, Nascimento, CPF, Curso, Email) VALUES (' ";
        String insertValues = alunos.getMatricula()+ "','" + alunos.getNome() + "','" + alunos.getNascimento() 
        + "','" + alunos.getCpf() + "','" + alunos.getCurso() + "','" + alunos.getEmail() + "')";
        String insertToRegister = insertFields + insertValues;

        conn = new ConnectionUtil().getConnection();
        SampleController sampleController = new SampleController();
        try {
        	pstm = conn.prepareStatement(insertToRegister);
        	sampleController.showAsDialog("confimerd-view");
        	
        	pstm.execute();
        	pstm.close();
        	return true;
        	
        	

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
            return false;
        }
    }

    public List<Alunos> listarAlunos(){
    	String insertFields = "SELECT * FROM sis_alunos_db.alunos";
    	conn = new ConnectionUtil().getConnection();
    	try {
    		pstm = conn.prepareStatement(insertFields);
			rs = pstm.executeQuery();
			
			while(rs.next() ) {
				Alunos alunos = new Alunos();
				alunos.setMatricula(rs.getString("Matricula"));
				alunos.setNome(rs.getString("Nome"));
				alunos.setNascimento(rs.getString("Nascimento"));
				alunos.setCpf(rs.getString("CPF"));
				alunos.setCurso(rs.getString("Curso"));
				alunos.setEmail(rs.getString("Email"));
				
				lista.add(alunos);
			}
		} catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            
		}
    	
    	return lista;
    }
   
   public boolean alterarAlunos(Alunos alunos) {
	   String insertFields = "UPDATE sis_alunos_db.alunos SET Nome = ?, Nascimento = ?, CPF = ?, Curso = ?, Email = ? WHERE Matricula = ?";
	   conn = new ConnectionUtil().getConnection();
	   try {
		   pstm = conn.prepareStatement(insertFields);
		   pstm.setString(1, alunos.getNome());
		   pstm.setString(2, alunos.getNascimento());
		   pstm.setString(3, alunos.getCpf());
		   pstm.setString(4, alunos.getCurso());
		   pstm.setString(5, alunos.getEmail());
		   pstm.setString(6, alunos.getMatricula());
		   pstm.execute();
		   pstm.close();   
		   return true;
	} catch (Exception e) {
		e.printStackTrace();
        e.getCause();
        return false;
	}
   }
   
   public boolean excluirAlunos(Alunos alunos) {
	   String sql = "DELETE FROM sis_alunos_db.alunos where Matricula = ?";
	   conn = new ConnectionUtil().getConnection();
	   
	   
	   
	   try {
		   
		   pstm = conn.prepareStatement(sql);
		   pstm.setString(1, alunos.getMatricula());
		   
		   pstm.execute();
		   pstm.close();
		   return true;
	} catch (Exception e) {
		e.printStackTrace();
        e.getCause();
        return false;
	}
	   
   }
   
   public Alunos buscar(Alunos alunos) {
       String sql = "SELECT * FROM sis_alunos_db.alunos WHERE Matricula = ?";
       Alunos lista = new Alunos();
       try {
           pstm = conn.prepareStatement(sql);
           pstm.setString(1, alunos.getMatricula());
           rs = pstm.executeQuery();
           if (rs.next()) {
				alunos.setNome(rs.getString("Nome"));
				alunos.setNascimento(rs.getString("Nascimento"));
				alunos.setCpf(rs.getString("CPF"));
				alunos.setCurso(rs.getString("Curso"));
				alunos.setEmail(rs.getString("Email"));
				
                lista = alunos;
           }
       } catch (Exception e) {
    	   e.printStackTrace();
           e.getCause();
           
       }
       return lista;
   }


}
	
