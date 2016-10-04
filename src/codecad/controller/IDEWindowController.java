/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.controller;

import codecad.parser.*;
import codecad.view.IDEWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augustop
 */
public class IDEWindowController {
    private IDEWindow mainWindow;
    private Lexico lexico = new Lexico();
    private Sintatico sintatico = new Sintatico();
    private Semantico semantico = new Semantico();
    
    public IDEWindowController(IDEWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.mainWindow.setLocationRelativeTo(null);
    }

    public void iniciarLeituraCódigo(){
        this.lexico.setInput(this.mainWindow.getAreaInputCodigo().getText());
        try {
            this.sintatico.parse(lexico, semantico);
            System.out.println("Entendeu");
        } catch (LexicalError | SyntaticError | SemanticError ex) {
            Logger.getLogger(IDEWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
