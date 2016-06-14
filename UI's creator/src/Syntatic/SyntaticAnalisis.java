package Syntatic;

import sample.Token;

import java.util.ArrayList;

/**
 * Created by bexan on 13/06/2016.
 */
public class SyntaticAnalisis {

    private ArrayList tokensA;
    private int contArray;

    public SyntaticAnalisis(ArrayList tokensA){
        this.tokensA= tokensA;
        this.contArray= 0;

    }

    //<UI's> -> app <word>
    public void ui(){
        if(tokensA.get(contArray)== Token.RESERVADA_APP){
            contArray++;
            word();
        }else{
            System.out.println("Se esperaba la palabra reservada app");
            System.exit(0);
        }

    }

    //<word> -> : <reservada> <propiedades> | : texto <word>| E
    public void word(){
        if(tokensA.get(contArray) == Token.OPENKEY){
            contArray++;
            reservada();
            propiedades();
        }else if (tokensA.get(contArray) == Token.TEXTO){
            contArray++;
            word();
        }
        //VACIO
    }

    //<reservada> -> img|txt|input|section|...
    private void reservada() {
        if (tokensA.get(contArray) == Token.RESERVADA_IMG){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_TXT){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_SECTION){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_INPUT){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_BUTTON){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_RECTANGLE){
            contArray++;
        }else{
            System.out.println("Se esperaba palabra reservada");
            System.exit(0);
        }
    }

    //<propiedades> -> (<prop> = '<atributo>' <rest_prop>) <cont> | E
    private void propiedades() {
        if (tokensA.get(contArray) == Token.OPEN_PROPERTY){
            contArray++;
            prop();
            if (tokensA.get(contArray)== Token.ASSIGN){
                contArray++;
                if (tokensA.get(contArray) == Token.COMILLA){
                    contArray++;
                    atributo();
                    if (tokensA.get(contArray)== Token.COMILLA){
                        contArray++;
                        rest_prop();
                        if (tokensA.get(contArray)== Token.CLOSE_PROPERTY){
                            contArray++;
                            cont();
                        }else{
                            System.out.println("Se esperaba un )");
                            System.exit(0);
                        }
                    }else{
                        System.out.println("Se esperaba un ' ");
                        System.exit(0);
                    }
                }else{
                    System.out.println("Se esperaba un ' ");
                    System.exit(0);
                }
            }else{
                System.out.println("Se esperaba un =");
                System.exit(0);
            }
        }
        //VACIO
    }

    //<prop> -> widht | height | ...
    private void prop() {
        if (tokensA.get(contArray)== Token.RESERVADA_WIDTH){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_HEIGHT){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_FONT){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_TEXT_COLOR){
            contArray++;
        }else if (tokensA.get(contArray) == Token.RESERVADA_FONT_SIZE){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_FILE){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_FILL){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_STROKE){
            contArray++;
        }else if (tokensA.get(contArray)== Token.RESERVADA_ID){
            contArray++;
        }else if (tokensA.get(contArray) == Token.RESERVADA_CLASS){
            contArray++;
        }else{
            System.out.println("Se esperaba una Propiedad");
            System.exit(0);
        }
    }

    //<atributo> -> int | float | texto
    private void atributo() {
        if (tokensA.get(contArray)== Token.VALOR_ENTERO){
            contArray++;
        }else if (tokensA.get(contArray) == Token.VALOR_FLOTANTE){
            contArray++;
        }else if (tokensA.get(contArray)== Token.TEXTO){
            contArray++;
        }else{
            System.out.println("Se esperaba un Atributo (valor) ");
            System.exit(0);
        }
    }

   // <cont> -> <word> | : texto | E
    private void cont() {
        word();
        if (tokensA.get(contArray)== Token.OPENKEY){
            contArray++;
            if (tokensA.get(contArray) == Token.TEXTO){
                contArray++;
            }
        }
        //VACIO
    }

    // <rest_prop> -> ; <prop> = '<atributo>' <rest_prop> | E
    private void rest_prop() {
        if (tokensA.get(contArray)== Token.COMA){
            contArray++;
            prop();
            if (tokensA.get(contArray)== Token.ASSIGN){
                contArray++;
                if (tokensA.get(contArray)== Token.COMILLA){
                    contArray++;
                    atributo();
                    if (tokensA.get(contArray)== Token.COMILLA){
                        contArray++;
                        rest_prop();
                    }
                }
            }
        }
        //VACIO
    }





}
