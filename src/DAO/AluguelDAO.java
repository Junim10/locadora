/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import Modelo.Classificacao;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Josimar Jr
 */
public class AluguelDAO extends ExecuteSQL{
    public AluguelDAO(Connection con){
        super(con);
    }
    public String ExcluirAluguel(Aluguel a){
        String sql = "DELETE FROM aluguel WHERE idaluguel = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            
            
            if(ps.executeUpdate() > 0){
                return "Excluido com sucesso";
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<Aluguel> CapturarAluguel(int cod){
        
        String sql = "SELECT * FROM aluguel WHERE idaluguel = "+cod;
        
        List<Aluguel> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    
                    Aluguel f = new Aluguel();
                    
                    f.setCod(rs.getInt(1));
                    f.setCoddvd(rs.getInt(2));
                    f.setCodcliente(rs.getInt(3));
                    f.setHorario(rs.getString(4));
                    f.setData_aluguel(rs.getString(5));
                    f.setData_devolucao(rs.getString(6));
                    
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
    public List<Aluguel> PesquisarAluguel(String codcli){
        String sql = "SELECT * FROM aluguel WHERE idcliente = '"+ codcli +"'";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
    public String Inserir_Aluguel(Aluguel a){
        
            String sql = "INSERT INTO aluguel VALUES (0,?,?,?,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if(ps.executeUpdate() > 0){
                return "Inseridos com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<Cliente> AtualizarNome(String nome){
       String sql = "SELECT * FROM cliente WHERE nome LIKE '"+ nome +"%'"; 
       List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
     public List<Cliente> ConsultaCodigoCliente(String nome){
        String sql = "SELECT idcliente FROM cliente WHERE nome = '" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    
    }
     public List<Aluguel> ListarAluguel(){
        String sql = "SELECT * FROM aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
     public List<Cliente> ListarComboCliente(){
        String sql = "SELECT nome FROM cliente ORDER BY nome";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }   
     public List<Aluguel> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM aluguel WHERE idaluguel = '"+ cod +"'"; 
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }return lista;
            }else{
                return null;
              
            }
        } catch (Exception e) {
            return null;
        }
    }
     public boolean Testar_Aluguel(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM aluguel WHERE idaluguel = "+ cod +"";
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
     public boolean Testar_Aluguel1(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM aluguel WHERE idcliente = "+ cod +"";
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
     public boolean Atualizar_Situacao(int cod){
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
     public List<Aluguel> CapturarAluguel1(int cod){
        String sql = "SELECT * FROM aluguel WHERE idaluguel ="+ cod +" ";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
     public List<Aluguel> CapturarAluguel3(int cod){
        String sql = "SELECT * FROM aluguel WHERE iddvd ="+ cod +" ";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
     public List<Aluguel> CapturarAluguel2(int cod){
        String sql = "SELECT * FROM aluguel WHERE idcliente ="+ cod +" ";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
     public List<Aluguel> Pesquisar_Cod_Aluguel(int cod){
        String sql = "SELECT * FROM aluguel WHERE idaluguel = '" + cod + "'";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
