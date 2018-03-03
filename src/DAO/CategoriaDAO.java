/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Josimar Jr
 */
public class CategoriaDAO extends ExecuteSQL{
    public CategoriaDAO(Connection con){
        super(con);
    }
    public boolean Testar_Categoria(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM categoria WHERE idcategoria = "+ cod +"";
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
    public String Inserir_Categoria(Categoria c){
        
            String sql = "INSERT INTO categoria VALUES (0,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, c.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Categoria> ConsultaCodigoCategoria(String nome){
        String sql = "SELECT idcategoria FROM categoria WHERE nome = '" + nome + "'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    
    }
    public String Excluir_Categoria(Categoria c){
        String sql = "DELETE FROM categoria WHERE idcategoria = ? AND nome = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<Categoria> ListarComboCategoria(){
        String sql = "SELECT nome FROM categoria ORDER BY nome";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Categoria c = new Categoria();
                    c.setNome(rs.getString(1));
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    } 
    
    public List<Categoria> CapturarCategoria(int cod){
        String sql = "SELECT * FROM categoria WHERE idcategoria ="+ cod +" ";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    lista.add(c);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
        public String Alterar_Categoria(Categoria a){
        String sql = "UPDATE categoria SET nome = ? WHERE idcategoria = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
     public List<Categoria> ListarCategoria(){
        String sql = "SELECT * FROM categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));

                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Categoria> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM categoria WHERE idcategoria = '"+ cod +"'"; 
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Categoria> AtualizarNome(String nome){
       String sql = "SELECT * FROM categoria WHERE nome LIKE '"+ nome +"%'"; 
       List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));

                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Categoria> ConsultaCategoria(){
        String sql = "SELECT categoria FROM categoria ORDER BY idcategoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Categoria f = new Categoria();
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
}
