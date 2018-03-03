package Modelo;
public class Filme {
    
    private int codigo;
    private int ano;
    private int cod_categoria;
    private int cod_classificao;
    private String titulo;
    private String duracao;
    private String capa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_classificao() {
        return cod_classificao;
    }

    public void setCod_classificao(int cod_classificao) {
        this.cod_classificao = cod_classificao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    
    
}
