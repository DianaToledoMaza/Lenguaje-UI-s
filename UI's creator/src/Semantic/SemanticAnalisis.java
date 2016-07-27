package Semantic;

import sample.Token;

import java.rmi.server.ExportException;
import java.util.ArrayList;

/**
 * Created by carli on 26/07/2016.
 */
public class SemanticAnalisis {

    private ArrayList<Token> tokensS;
    private int count;

    public SemanticAnalisis(ArrayList<Token> tokensArray) {
        this.tokensS = tokensArray;
        this.count = 0;
    }

    public String analizar() throws ExportException {
        for (int i = 0; i < tokensS.size() ; i++) {
            if (tokensS.get(i) == Token.RESERVADA_WIDTH){
                i+=3;
                if (tokensS.get(i) != Token.VALOR_ENTERO && tokensS.get(i) != Token.VALOR_FLOTANTE ){
                    throw new ExportException("No se pudo exportar el valor asignado a Width, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_HEIGHT){
                i+=3;
                if (tokensS.get(i) != Token.VALOR_ENTERO && tokensS.get(i) != Token.VALOR_FLOTANTE ){
                    throw new ExportException("No se pudo exportar el valor asignado a Height, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_FONT){
                i+=3;
                if (tokensS.get(i) != Token.TEXTO ){
                    throw new ExportException("No se pudo exportar el valor asignado a font, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_TEXT_COLOR) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_FONT_SIZE) {
                i += 3;
                if (tokensS.get(i) != Token.VALOR_ENTERO && tokensS.get(i) != Token.VALOR_FLOTANTE ) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-size, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_FILE) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_FILL) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_STROKE) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_STROKE) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_ID) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }else if (tokensS.get(i) == Token.RESERVADA_CLASS) {
                i += 3;
                if (tokensS.get(i) != Token.TEXTO) {
                    throw new ExportException("No se pudo exportar el valor asignado a font-color, valor incompatible");
                }
            }
        }
        return "Awesome!";
    }



}
