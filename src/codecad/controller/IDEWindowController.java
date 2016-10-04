/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

import codecad.parser.*;
import codecad.view.CommandListWindow;
import codecad.view.IDEWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augustop
 */
public class IDEWindowController {
    private IDEWindow mainWindow;
    private CommandListWindow listWindow;
    private ImageController ImageController = new ImageController(this.mainWindow.getPainelImagem());
    private Lexico lexico = new Lexico();
    private Sintatico sintatico = new Sintatico();
    private Semantico semantico = new Semantico(this, this.ImageController);
    
    public IDEWindowController(IDEWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.mainWindow.setLocationRelativeTo(null);
    }

    public void iniciarLeituraCódigo(){
        this.lexico.setInput(this.mainWindow.getAreaInputCodigo().getText());
        this.mainWindow.getLabelErro().setText("");
        try {
            this.sintatico.parse(lexico, semantico);
            System.out.println("Entendeu");
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            this.mainWindow.getLabelErro().setText("Erro no código!");
        }
    }
    
    public void setTamanhoTela(){
        this.mainWindow.setSize(this.ImageController.getParemetros().get(0), this.ImageController.getParemetros().get(1));
        this.ImageController.limparParametros();
    }
    
    public void iniciarJanelaListarComandos(){
        if(this.listWindow != null){
            this.listWindow.dispose();
        }
        this.listWindow = new CommandListWindow();
        this.listWindow.setLocationRelativeTo(this.mainWindow);
        this.listWindow.setVisible(true);
    }

}
