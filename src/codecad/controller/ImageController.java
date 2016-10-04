/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

import codecad.model.ImageVariable;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Augustop
 */
public class ImageController {
    private List<Integer> parametros = new ArrayList<>();
    private String nomeNovaVariavel;
    private String caminhoNovaVariavel;
    private JPanel painelImagem;
    private List<ImageVariable> variaveis = new ArrayList<>();
    
    public ImageController(JPanel painelImagem) {
        this.painelImagem = painelImagem;
    }
    
    public void addParemetro(int paremetro){
        this.parametros.add(paremetro);
    }
    
    public List<Integer> getParemetros(){
        return this.parametros;
    }
    
    public void limparParametros(){
        this.parametros.clear();
    }

    public void setNomeNovaVariavel(String nomeNovaVariavel) {
        this.nomeNovaVariavel = nomeNovaVariavel;
    }
    
    public void setCaminhoNovaVariavel(String caminho){
        this.caminhoNovaVariavel = caminho;
    }
    
    public void setNovaVariavel(){
        for (ImageVariable nomeVariavel: variaveis) {
            if(nomeVariavel.getNome().equals(this.nomeNovaVariavel)){
                this.variaveis.remove(nomeVariavel);
            }
        }
        ImageVariable novaVariavel = new ImageVariable(this.nomeNovaVariavel, this.caminhoNovaVariavel);
        this.variaveis.add(novaVariavel);
    }
    
    public void setBackgroundColor(){
        this.painelImagem.setBackground(new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2)));
        this.parametros.clear();
    }
    
    public void desenharVariavel(){
        
        this.parametros.clear();
    }
    
    public void setStroke(){
        
        this.parametros.clear();
    }
    
    public void setColor(){
        
        this.parametros.clear();
    }
    
    public void setFill(){
        
        this.parametros.clear();
    }
    
    public void setOpacidade(){
        
        this.parametros.clear();
    }
    
    public void desenharPonto(){
        
        this.parametros.clear();
    }
    
    public void desenharLinha(){
        
        this.parametros.clear();
    }
    
    public void desenharRetangulo(){
        
        this.parametros.clear();
    }
    
    public void desenharElipse(){
        
        this.parametros.clear();
    }
}
