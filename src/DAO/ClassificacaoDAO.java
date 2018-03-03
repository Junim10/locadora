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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josimar Jr
 */
public class ClassificacaoDAO extends ExecuteSQL{
    public ClassificacaoDAO(Connection con){
        super(con);
    } 
    public String Inserir_Classificacao(Classificacao c){
        
            String sql = "INSERT INTO classificacao VALUES (0,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, c.getNome());
            ps.setInt(2, (int) c.getPreco());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Classificacao> ListarPrecoClassificacao(int id){
       String sql = "SELECT preco FROM classificacao WHERE idclassificacao = '"+ id +"'"; 
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Classificacao c = new Classificacao();
//        c.setNome(rs.getString(2));           
                    c.setPreco(rs.getDouble(1));
//        c.setCodigo(rs.getInt(2));
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
    public List<Classificacao> ConsultaCodigoClassificacao(String nome){
        String sql = "SELECT idclassificacao FROM classificacao WHERE nome = '" + nome + "'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Classificacao c = new Classificacao();
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
    public String Excluir_Classificacao(Classificacao c){
        String sql = "DELETE FROM classificacao WHERE idclassificacao = ? AND nome = ? ";
        
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
    public List<Classificacao> ListarComboClassificacao(){
        String sql = "SELECT nome FROM classificacao ORDER BY nome";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Classificacao d = new Classificacao();
                    d.setNome(rs.getString(1));
                    lista.add(d);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    } 
    public boolean Testar_Classificacao(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM classificacao WHERE idclassificacao = "+ cod +"";
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
    public String Alterar_Classificacao(Classificacao c){
        String sql = "UPDATE classificacao SET nome = ?, preco = ? WHERE idclassificacao = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, c.getNome());
            ps.setDouble(2, c.getPreco());
            ps.setInt(3, c.getCodigo());
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<Classificacao> CapturarClassificacao(int cod){
        String sql = "SELECT * FROM classificacao WHERE idclassificacao ="+ cod +" ";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getDouble(3));
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
    public List<Classificacao> ListarClassificacao(){
        String sql = "SELECT * FROM classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Classificacao> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM classificacao WHERE idclassificacao = '"+ cod +"'"; 
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Classificacao> AtualizarNome(String nome){
       String sql = "SELECT * FROM classificacao WHERE nome LIKE '"+ nome +"%'"; 
       List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Classificacao> ConsultaClassif(){
        String sql = "SELECT nome FROM classificacao ORDER BY nome";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Classificacao f = new Classificacao();
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
