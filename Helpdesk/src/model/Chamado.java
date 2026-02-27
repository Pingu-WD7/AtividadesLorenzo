package model;

import java.time.LocalDate;

public class Chamado {
    private Integer numero;
    private String titulo;
    private LocalDate data;
    private String descricao;
    private PrioridadeChamado prioridade;
    private StatusChamado status;
    private Cliente cliente;

    public Chamado() {}

    public Chamado(Integer numero, String titulo, LocalDate data, String descricao, PrioridadeChamado prioridade, StatusChamado status, Cliente cliente) {
        this.numero = numero;
        this.titulo = titulo;
        this.data = LocalDate.now();
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = StatusChamado.ABERTO;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public PrioridadeChamado getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeChamado prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", cliente=" + cliente +
                '}';
    }
}
