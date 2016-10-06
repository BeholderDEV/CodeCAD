package br.beholder.codecad.model.parser;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_COMANDO_DESENHA = 2;
    int t_ABRE_CHAVE = 3;
    int t_FECHA_CHAVE = 4;
    int t_VIRGULA = 5;
    int t_ASPA = 6;
    int t_COMANDO_SET_DISPLAY = 7;
    int t_IGUAL = 8;
    int t_COMANDO_BG = 9;
    int t_COMANDO_DRAW_IMAGE = 10;
    int t_COMANDO_STROKE = 11;
    int t_COMANDO_COLOR = 12;
    int t_COMANDO_FILL = 13;
    int t_COMANDO_OPACIDADE = 14;
    int t_COMANDO_PONTO = 15;
    int t_COMANDO_LINHA = 16;
    int t_COMANDO_RECT = 17;
    int t_COMANDO_ELIPSE = 18;
    int t_COMANDO_TRIANG = 19;
    int t_COMANDO_ROUNDRECT = 20;
    int t_INTEIRO = 21;
    int t_STRING = 22;

}
