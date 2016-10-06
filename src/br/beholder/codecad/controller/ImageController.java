/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.controller;

import br.beholder.codecad.model.ImageVariable;
import com.alee.extended.image.DisplayType;
import com.alee.extended.image.WebImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
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
    private int alfa = 255;
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
    
    public void setTamanhoTela(){
        imagem = new BufferedImage(parametros.get(0), parametros.get(1), BufferedImage.TYPE_INT_ARGB);
        parametros.clear();
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
        this.prepararDesenho();
        this.stroke = new BasicStroke(1);
        this.g.setColor(new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.alfa));
        this.g.fillRect(0,0,imagem.getWidth(), imagem.getHeight());
        this.finalizarDesenho();
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
        this.corLinha = new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.alfa);
        this.parametros.clear();
    }
    
    public void setFill(){
        this.corFill = new Color(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.alfa);
        this.parametros.clear();
    }
    
    public void setOpacidade(){
        this.alfa = this.parametros.get(0);
        this.corLinha = new Color(this.corLinha.getRed(), this.corLinha.getGreen(), this.corLinha.getBlue(), this.alfa);
        this.corFill = new Color(this.corFill.getRed(), this.corFill.getGreen(), this.corFill.getBlue(), this.alfa);
        this.parametros.clear();
    }
    
    private void prepararDesenho(){
        if(imagem == null){
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
    }
    
    public void desenharPonto(){
        this.prepararDesenho();
        this.g.drawLine(this.parametros.get(0), this.parametros.get(1), this.parametros.get(0), this.parametros.get(1));
        this.finalizarDesenho();
    }
    
    public void desenharLinha(){
        this.prepararDesenho();
        this.g.drawLine(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.finalizarDesenho();
    }
    
    public void desenharRetangulo(){
        this.prepararDesenho();
        this.g.setColor(this.corFill);
        this.g.fillRect(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.g.setColor(this.corLinha);
        this.g.drawRect(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.finalizarDesenho();
    }
    public void desenharTriangulo(){
        this.prepararDesenho();
        this.g.setColor(this.corFill);
        int [] x = new int[3];
        x[0]=this.parametros.get(0);
        x[1]=this.parametros.get(2);
        x[2]=this.parametros.get(4);
        int [] y = new int[3];
        y[0]=this.parametros.get(1);
        y[1]=this.parametros.get(3);
        y[2]=this.parametros.get(5);
        Polygon p = new Polygon(x,y,3);
        this.g.fillPolygon(p);
        this.g.setColor(this.corLinha);
        this.g.drawPolygon(p);
        this.finalizarDesenho();
    }
    public void desenharRetanguloArredondado(){
        this.prepararDesenho();
        this.g.setColor(this.corFill);
        g.fillRoundRect(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3),this.parametros.get(4),this.parametros.get(4));
        this.g.setColor(this.corLinha);
        g.drawRoundRect(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3),this.parametros.get(4),this.parametros.get(4));
        this.finalizarDesenho();
    }
    
    public void desenharElipse(){
        this.prepararDesenho();
        this.g.setColor(this.corFill);
        this.g.fillOval(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.g.setColor(this.corLinha);
        this.g.drawOval(this.parametros.get(0), this.parametros.get(1), this.parametros.get(2), this.parametros.get(3));
        this.finalizarDesenho();
    }

    public BufferedImage getImagem() {
        return imagem;
    }
}
