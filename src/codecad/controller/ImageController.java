/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

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

    public void verificarNomeVariavel(String nomeNovaVariavel) {
        this.nomeNovaVariavel = nomeNovaVariavel;
    }
    
    public void setCaminhoNovaVariavel(String caminho){
        this.caminhoNovaVariavel = caminho;
    }
    
    public void setNovaVariavel(){
        
    }
    
    public void setBackgroundColor(){
        
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
