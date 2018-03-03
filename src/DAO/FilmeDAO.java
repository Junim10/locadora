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
public class FilmeDAO extends ExecuteSQL{
    public FilmeDAO(Connection con){
        super(con);
    } 
    public List<Filme> CapturarFilmeId(int cod){
        
        String sql = "SELECT * FROM filme WHERE idfilme = "+cod;
        
        List<Filme> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    
                    Filme f = new Filme();
                    
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCod_categoria(rs.getInt(5));
                    f.setCod_classificao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    
                    lista.add(f);
                }
                
                return lista;
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }
    }
    
    public List<Filme> Pesquisar_Cod_Filme(int cod){
        String sql = "SELECT * FROM filme WHERE idfilme = '" + cod + "'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
                    lista.add(a);
                 
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public String Inserir_Filme(Filme a){
        
            String sql = "INSERT INTO filme VALUES (0,?,?,?,?,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificao());
            ps.setString(6, a.getCapa());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
   public List<Filme> ConsultaCodigoFilme(String titulo){
        String sql = "SELECT idfilme FROM filme WHERE titulo = '" + titulo + "'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
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
    public String Excluir_Filme(Filme f){
        String sql = "DELETE FROM filme WHERE idfilme = ? AND titulo = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCodigo());
            ps.setString(2, f.getTitulo());
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
                
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<Filme> ListarComboFilme(){
        String sql = "SELECT titulo FROM filme ORDER BY titulo";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Filme f = new Filme();
                    f.setTitulo(rs.getString(1));
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    } 
//    public List<Filme> ConsultaCodigoCategoria(String categoria){
//        String sql = "SELECT idcategoria FROM filme WHERE idcategoria = '" + categoria + "'";
//        List<Filme> lista = new ArrayList<>();
//        try{
//            PreparedStatement ps = getCon().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs != null){
//                while (rs.next()){
//                    Filme f = new Filme();
//                    f.setCodigo(rs.getInt(1));
//                    lista.add(f);
//                }
//                return lista;
//            }else{
//                return null;
//            }
//        }catch(Exception e){
//            return null;
//        }
//    
//    }
//    public List<Categoria> ConsultaCodigoClassificacao(String classificacao){
//        String sql = "SELECT idclassificacao FROM categoria WHERE idclassificacao = '" + classificacao + "'";
//        List<Categoria> lista = new ArrayList<>();
//        try{
//            PreparedStatement ps = getCon().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs != null){
//                while (rs.next()){
//                    Categoria f = new Categoria();
//                    f.setCodigo(rs.getInt(1));
//                    lista.add(f);
//                }
//                return lista;
//            }else{
//                return null;
//            }
//        }catch(Exception e){
//            return null;
//        }
//    
//    }
//    public List<Categoria> ConsultaCategoria(){
//        String sql = "SELECT categoria FROM categoria ORDER BY idcategoria";
//        List<Categoria> lista = new ArrayList<>();
//        try {
//            PreparedStatement ps = getCon().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs != null){
//                while (rs.next()){
//                    Categoria f = new Categoria();
//                    f.setNome(rs.getString(1));
//                    lista.add(f);
//                }return lista;
//            }else{
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    public List<Classificacao> ConsultaClassificacao(){
//        String sql = "SELECT nome FROM classificacao ORDER BY nome";
//        List<Classificacao> lista = new ArrayList<>();
//        try {
//            PreparedStatement ps = getCon().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs != null){
//                while (rs.next()){
//                    Classificacao f = new Classificacao();
//                    f.setNome(rs.getString(1));
//                    lista.add(f);
//                }return lista;
//            }else{
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
//    }
       public String Alterar_Filme(Filme f){
        String sql = "UPDATE filme SET titulo = ?, ano = ?, duracao = ? WHERE idtitulo = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, f.getTitulo());
            ps.setInt(2, f.getAno());
            ps.setString(3, f.getDuracao());
            ps.setInt(4, f.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
       public List<Filme> CapturarFilme(int cod){
        String sql = "SELECT * FROM filme WHERE idfilme ="+ cod +" ";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
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
       public boolean Testar_Filme(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM filme WHERE idfilme = "+ cod +"";
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
       public List<Filme> ListarFilme(){
        String sql = "SELECT * FROM filme";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificao(rs.getInt(6));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
       public List<Filme> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM filme WHERE idfilme = '"+ cod +"'"; 
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificao(rs.getInt(6));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Filme> AtualizarNome(String titulo){
       String sql = "SELECT * FROM filme WHERE nome LIKE '"+ titulo +"%'"; 
       List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificao(rs.getInt(6));
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
