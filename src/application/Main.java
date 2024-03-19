package application;

import application.model.conexao.ConexaoBD;

public class Main {

    public static void main(String[] args) {

        System.out.println("TESTE");

        // Cria tabelas de teste do banco de dados
        new ConexaoBD().criarTabelaTeste();
    }
}