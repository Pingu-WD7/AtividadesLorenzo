package service;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Helpdesk {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Chamado> chamados = new ArrayList<>();

    //Operações do Cliente
    public void cadastrarCliente(String nome, String email){

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEmail(email);
        clientes.add(c);
    }

    public Cliente buscarCliente(String email){
        for (Cliente c : clientes){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c;
            }
        }
        return null;
    }

    //Operações do Chamado
    public void abrirChamado(Integer numero, String titulo, String descricao, PrioridadeChamado prioridade, Cliente cliente){
        if (numero == null) return;

        //Cliente cli = buscarCliente(email);

        Chamado ch = new Chamado();
        ch.setNumero(numero);
        ch.setTitulo(titulo);
        ch.setData(LocalDate.now());
        ch.setDescricao(descricao);
        ch.setPrioridade(prioridade);
        ch.setStatus(StatusChamado.ABERTO);
        ch.setCliente(cliente);

        chamados.add(ch);

    }
    public void alterarStatus(Integer numero, StatusChamado novoStatus){
        Chamado ch = buscarChamado(numero);
        if(ch != null){
            ch.setStatus(novoStatus);
        }
    }
    public Chamado buscarChamado(Integer numero){
        for (Chamado c : chamados){
            if(c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }
}
