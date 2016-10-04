/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.view;

import codecad.controller.IDEWindowController;
import codecad.model.parser.LexicalError;
import codecad.model.parser.Lexico;
import codecad.model.parser.SemanticError;
import codecad.model.parser.Semantico;
import codecad.model.parser.Sintatico;
import codecad.model.parser.SyntaticError;
import com.alee.laf.WebLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author 5663296
 */
public class IDEWindow extends javax.swing.JFrame {
    private IDEWindowController controller;
    
    /**
     * Creates new form IDE
     */
    public IDEWindow() {
        initComponents();
        try {
            javax.swing.UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
        }
        this.controller = new IDEWindowController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollInputCodigo = new javax.swing.JScrollPane();
        areaInputCodigo = new javax.swing.JTextArea();
        botaoAplicar = new com.alee.laf.button.WebButton();
        painelImagem = new javax.swing.JPanel();
        labelErro = new javax.swing.JLabel();
        botaoListar = new com.alee.laf.button.WebButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CodeCAD");
        setPreferredSize(new java.awt.Dimension(650, 650));
        setResizable(false);

        areaInputCodigo.setColumns(20);
        areaInputCodigo.setRows(5);
        scrollInputCodigo.setViewportView(areaInputCodigo);

        botaoAplicar.setText("Aplicar Código");
        botaoAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAplicarActionPerformed(evt);
            }
        });

        painelImagem.setBackground(new java.awt.Color(255, 255, 255));
        painelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelImagem.setLayout(new java.awt.BorderLayout());

        labelErro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelErro.setForeground(new java.awt.Color(255, 51, 0));
        labelErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        botaoListar.setText("Listar Comandos");
        botaoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollInputCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoListar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelImagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelErro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollInputCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoListar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAplicarActionPerformed
        this.controller.iniciarLeituraCódigo();
    }//GEN-LAST:event_botaoAplicarActionPerformed

    private void botaoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarActionPerformed
        this.controller.iniciarJanelaListarComandos();
    }//GEN-LAST:event_botaoListarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IDEWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInputCodigo;
    private com.alee.laf.button.WebButton botaoAplicar;
    private com.alee.laf.button.WebButton botaoListar;
    private javax.swing.JLabel labelErro;
    private javax.swing.JPanel painelImagem;
    private javax.swing.JScrollPane scrollInputCodigo;
    // End of variables declaration//GEN-END:variables

    public JPanel getPainelImagem() {
        return painelImagem;
    }

    public JTextArea getAreaInputCodigo() {
        return areaInputCodigo;
    }

    public JLabel getLabelErro() {
        return labelErro;
    }

}
