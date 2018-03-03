package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO extends ExecuteSQL{
    public ClienteDAO(Connection con){
        super(con);
    }
    public String Inserir_Cliente(Cliente a){
        
            String sql = "INSERT INTO cliente VALUES (0,?,?,?,?,?,?,?,?,?,?)";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNascimento());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getCPF());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getTelefone());
            ps.setString(7, a.getBairro());
            ps.setString(8, a.getRua());
            ps.setInt(9, a.getNumero());
            ps.setString(10, a.getCEP());
            
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso...";
            }else{
                return "Erro ao inserir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
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
    public String Excluir_Cliente(Cliente a){
        String sql = "DELETE FROM cliente WHERE idcliente = ? AND nome = ? ";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            }else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public List<Cliente> Listar_Cliente(){
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
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
        }   return null;
    }
        
    public boolean Testar_Cliente(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM cliente WHERE idcliente = "+ cod +"";
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
    public String Alterar_Cliente(Cliente a){
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, bairro = ?, rua = ?, numero = ?, cep = ? WHERE idcliente = ?";
        
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getTelefone());
            ps.setString(4, a.getBairro());
            ps.setString(5, a.getRua());
            ps.setInt(6, a.getNumero());
            ps.setString(7, a.getCEP());
            ps.setInt(8, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso...";
            }else{
                return "Erro ao alterar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<Cliente> CapturarCliente(int cod){
        String sql = "SELECT * FROM cliente WHERE idcliente ="+ cod +" ";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setNascimento(rs.getString(3));
                    a.setRG(rs.getString(4));
                    a.setCPF(rs.getString(5));
                    a.setEmail(rs.getString(6));
                    a.setTelefone(rs.getString(7));
                    a.setBairro(rs.getString(8));
                    a.setRua(rs.getString(9));
                    a.setNumero(rs.getInt(10));
                    a.setCEP(rs.getString(11));
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
    public List<Cliente> ListarCliente(){
        String sql = "SELECT * FROM cliente";
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
    public List<Cliente> AtualizarCodigo(int cod){
        String sql = "SELECT * FROM cliente WHERE idcliente = '"+ cod +"'"; 
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
    public List<Cliente> ConsultaNomeCliente(int cod){
        String sql = "SELECT idcliente, nome FROM cliente WHERE idcliente = '" + cod + "'";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
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
}
