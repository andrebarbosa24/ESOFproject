package EngSoftProjeto.builder;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;

public class ClienteBuilder {

    private Cliente cliente;



    public ClienteBuilder setNome(String nome){
        this.cliente.setNome(nome);
        return this;
    }



    public ClienteBuilder setEmail(String email){
        this.cliente.setEmail(email);
        return this;
    }
    public ClienteBuilder addProjeto(Projeto p){
        this.cliente.addProjeto(p);
        return this;
    }


    public Cliente build(){
        return this.cliente;

    }

    // nao percebi muito bem o sentido desta funcao
    public static void main(String[] args){

        Cliente cliente= new ClienteBuilder().setEmail("aaaa@aaa.com").setNome("joao").addProjeto(new Projeto()).build();
    }
}
