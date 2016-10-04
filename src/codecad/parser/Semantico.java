package codecad.parser;

import codecad.controller.IDEWindowController;
import codecad.controller.ImageController;

public class Semantico implements Constants
{
    private IDEWindowController iDEWindowController;
    private ImageController imageController;
    
    public Semantico(IDEWindowController iDEWindowController, ImageController imageController) {
        this.iDEWindowController = iDEWindowController;
        this.imageController = imageController;
    }
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        switch(action){
            case 1:
                this.imageController.addParemetro(Integer.parseInt(token.getLexeme()));
            break;
            case 2:
                this.imageController.verificarNomeVariavel(token.getLexeme());
            break;
            case 3:
                this.imageController.setCaminhoNovaVariavel(token.getLexeme());
            break;
            case 4:
                this.iDEWindowController.setTamanhoTela();
            break;
            case 5:
                this.imageController.setNovaVariavel();
            break;
            case 6:
                this.imageController.setBackgroundColor();
            break;
            case 7:
                this.imageController.desenharVariavel();
            break;
            case 8:
                this.imageController.setStroke();
            break;
            case 9:
                this.imageController.setColor();
            break;
            case 10:
                this.imageController.setFill();
            break;
            case 11:
                this.imageController.setOpacidade();
            break;
            case 12:
                this.imageController.desenharPonto();
            break;
            case 13:
                this.imageController.desenharLinha();
            break;
            case 14:
                this.imageController.desenharRetangulo();
            break;
            case 15:
                this.imageController.desenharElipse();
            break;
        }
    }	
}
