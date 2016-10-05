/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.ui;

import br.beholder.codecad.controller.IDEWindowController;
import javax.swing.JPanel;
import org.syntax.jedit.JEditTextArea;
import org.syntax.jedit.KeywordMap;
import org.syntax.jedit.tokenmarker.CodeCadTokenMarker;
import org.syntax.jedit.tokenmarker.Token;

/**
 *
 * @author lite
 */
public class MainPanel extends javax.swing.JPanel {
    private IDEWindowController controller;
    private JEditTextArea  codeArea;
    int pX, pY;
    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        codeArea = new JEditTextArea();
        KeywordMap map = new KeywordMap(true);
        map.add("draw", Token.KEYWORD1);
        map.add("rect", Token.KEYWORD3);
        map.add("elipse", Token.KEYWORD3);
        map.add("line", Token.KEYWORD3);
        map.add("point", Token.KEYWORD3);
        map.add("fill", Token.KEYWORD2);
        map.add("stroke", Token.KEYWORD2);
        map.add("color", Token.KEYWORD2);
        map.add("opacity", Token.KEYWORD2);
        map.add("background", Token.KEYWORD2);
        map.add("display", Token.KEYWORD2);
        codeArea.setTokenMarker(new CodeCadTokenMarker(map));
        codeArea.setText("display 800,600\n" +
"draw{\n" +
"	background 30,30,30\n" +
"	fill 255,255,255\n" +
"	rect 0,0,40,40\n" +
"}");
        codePanel.add(codeArea);
        this.controller = new IDEWindowController(this);
        setIcon();
        configureTheme();
    }
    
    public JPanel getPainelImagem(){
        return imagePane;
    }
    
    public JEditTextArea getAreaInputCodigo(){
        return codeArea;
    }
    
    private void setIcon(){
        
    }
    
    private void configureTheme(){
             
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        imagePane = new javax.swing.JPanel();
        buttonsPane = new javax.swing.JPanel();
        webButton1 = new com.alee.laf.button.WebButton();
        codePanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout());

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setResizeWeight(0.75);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.8);
        jSplitPane1.setLeftComponent(imagePane);

        webButton1.setText("Aplicar Codigo");
        webButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton1ActionPerformed(evt);
            }
        });
        buttonsPane.add(webButton1);

        jSplitPane1.setRightComponent(buttonsPane);

        jSplitPane2.setLeftComponent(jSplitPane1);

        codePanel.setLayout(new java.awt.BorderLayout());
        jSplitPane2.setRightComponent(codePanel);

        add(jSplitPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void webButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton1ActionPerformed
        this.controller.iniciarLeituraCódigo();
    }//GEN-LAST:event_webButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPane;
    private javax.swing.JPanel codePanel;
    private javax.swing.JPanel imagePane;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private com.alee.laf.button.WebButton webButton1;
    // End of variables declaration//GEN-END:variables
}
