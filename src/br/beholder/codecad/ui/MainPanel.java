/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.ui;

import br.beholder.codecad.controller.IDEWindowController;
import br.beholder.codecad.ui.swing.webLaf.WeblafUtils;
import br.beholder.codecad.ui.utils.ColorController;
import javax.swing.JButton;
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
"	background 245, 234, 214\n" +
"	fill 245, 234, 214\n" +
"	color 234,81,45\n" +
"	stroke 10\n" +
"	elipse 300,200,200,200\n" +
"	fill 234,81,45\n" +
"	rect 500,290,50,20\n" +
"	elipse 540,290,20,20\n" +
"	fill 68,36,11\n" +
"	color 68,36,11\n" +
"	elipse 325,225,150,150\n" +
"}");
        jSplitPane1.setDividerLocation(500);
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
        WeblafUtils.instalaWeblaf();
        WeblafUtils.configurarBotao(webButton1);
        WeblafUtils.configurarBotao(webButton2);
        WeblafUtils.configuraWeblaf(codePanel);
        WeblafUtils.configuraWeblaf(buttonsPane);
        WeblafUtils.configuraWeblaf(imagePane);
        codePanel.setBackground(ColorController.COR_PRINCIPAL);
        buttonsPane.setBackground(ColorController.COR_PRINCIPAL);
        imagePane.setBackground(ColorController.COR_PRINCIPAL);
        this.setBackground(ColorController.COR_PRINCIPAL);
        codeArea.setBackground(ColorController.COR_DESTAQUE);
        codeArea.setForeground(ColorController.COR_LETRA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        imagePane = new javax.swing.JPanel();
        buttonsPane = new javax.swing.JPanel();
        webButton1 = new com.alee.laf.button.WebButton();
        webButton2 = new com.alee.laf.button.WebButton();
        codePanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.8);

        jPanel1.setLayout(new java.awt.BorderLayout());

        imagePane.setMinimumSize(new java.awt.Dimension(200, 400));
        imagePane.setName(""); // NOI18N
        imagePane.setPreferredSize(new java.awt.Dimension(400, 400));
        imagePane.setLayout(new java.awt.BorderLayout());
        jPanel1.add(imagePane, java.awt.BorderLayout.CENTER);

        buttonsPane.setPreferredSize(new java.awt.Dimension(75, 100));

        webButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/beholder/codecad/ui/resources/icon32.png"))); // NOI18N
        webButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton1ActionPerformed(evt);
            }
        });
        buttonsPane.add(webButton1);

        webButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/beholder/codecad/ui/resources/icon32.png"))); // NOI18N
        buttonsPane.add(webButton2);

        jPanel1.add(buttonsPane, java.awt.BorderLayout.EAST);

        jSplitPane1.setTopComponent(jPanel1);

        codePanel.setAutoscrolls(true);
        codePanel.setMaximumSize(new java.awt.Dimension(150, 150));
        codePanel.setMinimumSize(new java.awt.Dimension(100, 100));
        codePanel.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setBottomComponent(codePanel);
        codePanel.getAccessibleContext().setAccessibleName("");

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void webButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton1ActionPerformed
        this.controller.iniciarLeituraCódigo();
    }//GEN-LAST:event_webButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPane;
    private javax.swing.JPanel codePanel;
    private javax.swing.JPanel imagePane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private com.alee.laf.button.WebButton webButton1;
    private com.alee.laf.button.WebButton webButton2;
    // End of variables declaration//GEN-END:variables
}
