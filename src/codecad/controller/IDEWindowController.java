/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

import codecad.model.parser.Semantico;
import codecad.model.parser.SyntaticError;
import codecad.model.parser.SemanticError;
import codecad.model.parser.Sintatico;
import codecad.model.parser.LexicalError;
import codecad.model.parser.Lexico;
import codecad.view.CommandListWindow;
import codecad.view.IDEWindow;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Augustop
 */
public class IDEWindowController {
    private IDEWindow mainWindow;
    private CommandListWindow listWindow;
    private ImageController imageController;
    private Lexico lexico = new Lexico();
    private Sintatico sintatico;
    private Semantico semantico;
    
    public IDEWindowController(IDEWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.imageController = new ImageController(this.mainWindow.getPainelImagem());
        this.semantico = new Semantico(this, this.imageController);
        this.sintatico = new Sintatico();
        this.mainWindow.setLocationRelativeTo(null);
    }

    public void iniciarLeituraCódigo(){
        this.lexico.setInput(this.mainWindow.getAreaInputCodigo().getText());
        try {
            this.sintatico.parse(lexico, semantico);
        } catch (LexicalError | SyntaticError | SemanticError ex) {
        }
    }
    
    public void setTamanhoTela(){
        this.mainWindow.setSize(this.imageController.getParemetros().get(0), this.imageController.getParemetros().get(1));
        this.imageController.limparParametros();
    }
    
    public void iniciarJanelaListarComandos(){
        if(this.listWindow != null){
            this.listWindow.dispose();
        }
        this.listWindow = new CommandListWindow();
        this.listWindow.setLocationRelativeTo(this.mainWindow);
        this.listWindow.setVisible(true);
    }

    public void iniciarSalvamentoImagem(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            try {
                ExternalIOController.salvarImagem(this.imageController.getImagem(), fileChooser.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(IDEWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return;
        }
    }
    
}
