/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.model;

/**
 *
 * @author Augustop
 */
public class ImageVariable {
    private String nome;
    private String caminho;

    public ImageVariable(String nome, String caminho) {
        this.nome = nome;
        this.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
