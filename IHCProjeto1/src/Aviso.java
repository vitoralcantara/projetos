

   
    


/**
 *	Classe que armazena os dados de uma mensagem.
 *
 * @author Vitor
 */
class Aviso {
    private String assunto;
    private String autor;
    private String mensagem;
    private String dataInicio;
    private String dataTermino;
    private String local;

    /**
     * Retorna o assunto da mensagem.
     * @return o assunto da mensagem.
     */
    public String getAssunto() {
        return assunto;
    }
    
    /**
     * Define o assunto da mensagem
     * @param assunto
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    /**
     * Retorna o autor da mensagem.	
     * @return o autor da mensagem.
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * Define o autor da mensagem.
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Retorna a data de término da mensagem
     * @return
     */
    public String getDataFim() {
        return dataTermino;
    }

    /**
     * Define a data final da mensagem.
     * @param dataFim
     */
    public void setDataTermino(String dataFim) {
        this.dataTermino = dataFim;
    }

    /**
     * Obtém a data inicial da mensagem.
     * 
     * @return
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * Define a data inicial da mensagem.
     * @param dataInicio
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Retorna o local especificado pela mensagem.
     * @return
     */
    public String getLocal() {
        return local;
    }

    /**
     * Define o local especificado pela mensagem.
     * @param local
     */
    public void setLocal(String local) {
        this.local = local;
    }
    
    /**
     * Retorna a mensagem.
     * @return a mensagem.
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Define a mensagem
     * @param mensagem
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

