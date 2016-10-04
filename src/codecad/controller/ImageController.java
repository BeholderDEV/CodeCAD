/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

import codecad.model.ImageVariable;
import com.alee.extended.image.DisplayType;
import com.alee.extended.image.WebImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
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
    private Stroke stroke = new BasicStroke(1);
    private Color corLinha = Color.BLACK;
    private Color corFill = Color.BLACK;
    private Graphics2D g;
    BufferedImage imagem;
    
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
        this.stroke = new BasicStroke(this.parametros.get(0));
        this.parametros.clear();
    }
    
    public void setColor(){
        this.corLinha = new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2));
        this.parametros.clear();
    }
    
    public void setFill(){
        this.corFill = new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2));
        this.parametros.clear();
    }
    
    public void setOpacidade(){
        
        this.parametros.clear();
    }
    
    private void prepararDesenho(){
        if(this.painelImagem.getComponentCount() == 0){
            this.imagem = new BufferedImage(this.painelImagem.getWidth(), this.painelImagem.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        }
        this.painelImagem.removeAll();
        this.g = (Graphics2D) this.imagem.getGraphics();
        this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.g.setStroke(this.stroke);
        this.g.setColor(this.corLinha);
    }
    
    private void finalizarDesenho(){
        WebImage wi = new WebImage(this.imagem);
        wi.setDisplayType(DisplayType.fitComponent);
        this.painelImagem.add(wi);
        this.painelImagem.revalidate();
        this.parametros.clear();
        this.painelImagem.revalidate();
    }
    
    public void desenharPonto(){
        this.prepararDesenho();
        
        this.finalizarDesenho();
    }
    
    public void desenharLinha(){
        this.prepararDesenho();
        this.g.drawLine(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.finalizarDesenho();
    }
    
    public void desenharRetangulo(){
        this.prepararDesenho();
        
        this.finalizarDesenho();
    }
    
    public void desenharElipse(){
        this.prepararDesenho();
        
        this.finalizarDesenho();
    }
}
