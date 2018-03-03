package DAO;

import Modelo.Cliente;
import Modelo.Filme;
import java.sql.*;
import Modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con){
        super (con);
    }
    public String Inserir_Funcionario(Funcionario f){
        
            String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Inseridos com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        try {
            String consulta = "SELECT * FROM funcionario WHERE login = '"+ login +"' AND senha = '"+ senha +"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return finalResult;
    }
    public List<Funcionario> ConsultaCodigoFuncionario(String nome){
        String sql = "SELECT idfuncionario FROM funcionario WHERE nome = '" + nome + "'";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    lista.add(f);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    
    }
    public String Excluir_Funcionario(Funcionario f){
        String sql = "DELETE FROM funcionario WHERE idfuncionario = ? AND nome = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCod());
            ps.setString(2, f.getNome());
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
                
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<Funcionario> ListarComboFuncionario(){
        String sql = "SELECT nome FROM funcionario ORDER BY nome";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Funcionario f = new Funcionario();
                    f.setNome(rs.getString(1));
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public String Alterar_Funcionario(Funcionario f){
        String sql = "UPDATE funcionario SET nome = ?, login = ?, senha = ? WHERE idfuncionario = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getLogin());
            ps.setString(3, f.getSenha());
            ps.setInt(4, f.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
       public List<Funcionario> CapturarFuncionario(int cod){
        String sql = "SELECT * FROM funcionario WHERE idfuncionario ="+ cod +" ";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    lista.add(f);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
       public boolean Testar_Funcionario(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM funcionario WHERE idfuncionario = "+ cod +"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    Resultado = true;
                }
            }
        }catch(SQLException ex){
            ex.getMessage();
        }return Resultado;
    }
       public List<Funcionario> ListarFuncionario(){
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
       public List<Funcionario> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM funcionario WHERE idfuncionario = '"+ cod +"'"; 
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Funcionario> AtualizarNome(String login){
       String sql = "SELECT * FROM funcionario WHERE login LIKE '"+ login +"%'"; 
       List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
}
