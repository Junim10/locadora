
package DAO;

import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Cliente;
import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL{
    public DVDDAO(Connection con){
        super(con);
    }
    public String AtualizarSituacaoDVD(DVD f){
        String sql = "UPDATE dvd SET situacao = 'Indisponivel' WHERE iddvd = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, f.getCodigo());
            
            if (ps.executeUpdate() >0) {
                return "Atualizado com sucesso";
            }else{
                return "Erro ao inserir";
            }
            
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public String Inserir_DVD(DVD d){
        
            String sql = "INSERT INTO dvd VALUES (0,?,?,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, d.getCod_filme());
            ps.setDouble(2, d.getPreco());
            ps.setString(3, d.getData_compra());
            ps.setString(4, d.getSituacao());
            
            if(ps.executeUpdate() > 0){
                return "Inseridos com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public boolean Testar_DVD(int cod){
        boolean teste = false;
        try {
            String sql = "SELECT iddvd FROM dvd WHERE iddvd =" + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    teste = true;
                }
            }
        } catch (Exception e) {
        }return teste;
    }
    public List<DVD> ListarCodFilme(int cod){
        String sql = "SELECT idfilme FROM dvd WHERE iddvd = " + cod + " ";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    DVD a = new DVD();
                    a.setCod_filme(rs.getInt(1));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public boolean Testar_Situacao(int cod){
        boolean teste = false;
        try {
            String sql = "SELECT iddvd FROM dvd WHERE iddvd =" + cod + "" + " AND situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    teste = true;
                }
            }
        } catch (Exception e) {
        }return teste;
    }
    public List<DVD> ConsultaCodigoDVD(String situacao){
        String sql = "SELECT iddvd FROM dvd WHERE situacao = '" + situacao + "'";
        List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    DVD d = new DVD();
                    d.setCodigo(rs.getInt(1));
                    lista.add(d);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    
    }
    public String Excluir_DVD(DVD d){
        String sql = "DELETE FROM dvd WHERE iddvd = ? AND situacao = 'Disponivel' ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, d.getCodigo());
            ps.setString(2, d.getSituacao());
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
                
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<DVD> ListarComboDVD(){
        String sql = "SELECT situacao FROM dvd ORDER BY iddvd";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    DVD d = new DVD();
                    d.setSituacao(rs.getString(1));
                    lista.add(d);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public String Alterar_DVD(DVD d){
        String sql = "UPDATE dvd SET preco_compra = ?, data_compra = ?, situacao = ? WHERE iddvd = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setDouble(1, d.getPreco());
            ps.setString(2, d.getData_compra());
            ps.setString(3, d.getSituacao());
            ps.setInt(4, d.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public String AlterarDVDLocacao(DVD d){
        String sql = "UPDATE dvd SET situacao = ? WHERE iddvd = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, d.getSituacao());
            ps.setInt(2, d.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<DVD> CapturarDVD(int cod){
        String sql = "SELECT * FROM dvd WHERE iddvd ="+ cod +" ";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<DVD> ListarDVD(){
        String sql = "SELECT * FROM dvd";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<DVD> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM dvd WHERE iddvd = '"+ cod +"'"; 
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<DVD> AtualizarNome(String situacao){
       String sql = "SELECT * FROM dvd WHERE situacao LIKE '"+ situacao +"%'"; 
       List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
