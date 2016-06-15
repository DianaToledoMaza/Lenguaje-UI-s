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

    //<UI's> -> app : <word>
    public void ui(){
        if(tokensA.get(contArray)== Token.RESERVADA_APP){
            contArray++;
            if (tokensA.get(contArray) == Token.OPENKEY){
                contArray++;
                inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }
        //VACIO

    }

    // <inicial> -> section <propiedad> : <rest_inicial> | ..... | E
    private void inicial() {
        if(tokensA.get(contArray)== Token.RESERVADA_SECTION){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }else if(tokensA.get(contArray)== Token.RESERVADA_IMG){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }else if(tokensA.get(contArray)== Token.RESERVADA_TXT){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }else if(tokensA.get(contArray)== Token.RESERVADA_INPUT){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }else if(tokensA.get(contArray)== Token.RESERVADA_BUTTON){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }else if(tokensA.get(contArray)== Token.RESERVADA_RECTANGLE){
            contArray++;
            propiedad();
            if(tokensA.get(contArray)== Token.OPENKEY){
                contArray++;
                rest_inicial();
            }else {
                System.out.println("Se esperaba un ':'");
            }
        }
        //VACIO
    }

    //<propiedad> -> ( <prop> = ' <atributo> ' <rest_prop> ) | E
    private void propiedad() {
        if (tokensA.get(contArray)== Token.OPEN_PROPERTY){
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
                        if (tokensA.get(contArray)== Token.CLOSE_PROPERTY){
                            contArray++;
                        }else {
                            System.out.println("Se esperaba un ')' ");
                        }
                    }else {
                        System.out.println("Se esperaba un ' ");
                    }
                }else {
                    System.out.println("Se esperaba un ' ");
                }
            }else {
                System.out.println("Se esperaba un '='");
            }
        }
        //VACIO
    }

    //prop ->  widht | height | ...
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
        }
    }

    // atributo -> int|float|texto
    private void atributo() {
        if (tokensA.get(contArray)== Token.VALOR_ENTERO){
            contArray++;
        }else if (tokensA.get(contArray) == Token.VALOR_FLOTANTE){
            contArray++;
        }else if (tokensA.get(contArray)== Token.TEXTO){
            contArray++;
        }else{
            System.out.println("Se esperaba un Atributo (valor) ");
        }
    }

    // rest_prop -> ; <prop> = ' <atributo> ' <rest_prop>  | E
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
                    }else {
                        System.out.println("Se esperaba un ' ");
                    }
                }else {
                    System.out.println("Se esperaba un ' ");
                }
            }else {
                System.out.println("Se esperaba un '=' ");
            }
        }
        //VACIO
    }

    // <rest_inicial> ->  texto <inicial> | int <inicial> | flotante <incial> | inicial | E
    private void rest_inicial() {
        inicial();
        if (tokensA.get(contArray)== Token.TEXTO){
            contArray++;
            inicial();
        }else if (tokensA.get(contArray)== Token.VALOR_ENTERO){
            contArray++;
            inicial();
        }else if (tokensA.get(contArray)== Token.VALOR_FLOTANTE){
            contArray++;
            inicial();
        }
        //VACIO

    }




}
