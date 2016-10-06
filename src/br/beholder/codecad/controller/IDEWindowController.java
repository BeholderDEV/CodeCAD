/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.controller;

import br.beholder.codecad.model.parser.Semantico;
import br.beholder.codecad.model.parser.SyntaticError;
import br.beholder.codecad.model.parser.SemanticError;
import br.beholder.codecad.model.parser.Sintatico;
import br.beholder.codecad.model.parser.LexicalError;
import br.beholder.codecad.model.parser.Lexico;
import br.beholder.codecad.ui.MainPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augustop
 */
public class IDEWindowController {
    private MainPanel mainWindow;
    private ImageController imageController;
    private Lexico lexico = new Lexico();
    private Sintatico sintatico;
    private Semantico semantico;
    
    public IDEWindowController(MainPanel mainWindow) {
        this.mainWindow = mainWindow;
        this.imageController = new ImageController(this.mainWindow.getPainelImagem());
        this.semantico = new Semantico(this, this.imageController);
        this.sintatico = new Sintatico();
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
    
    public void iniciarSalvamentoImagem(){
        try {
            ExternalIOController.salvarImagem(this.imageController.getImagem());
        } catch (IOException ex) {
            Logger.getLogger(IDEWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
