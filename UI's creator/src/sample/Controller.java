package sample;

import Semantic.SemanticAnalisis;
import Syntatic.SyntaticAnalisis;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private FileChooser fileChooser;
    private File textFile;
    private Stage stage;
    private String data;
    private FileReader fr;
    private BufferedReader br;
    private String line;
    @FXML private TextArea textArea;
    private ArrayList <Token> tokensArray;
    private SyntaticAnalisis analisis;
    private SemanticAnalisis semanticAnalisis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String filePath = null;
       tokensArray= new ArrayList <Token>();

        filePath = "D:/Mis documentos/GitHub/Lenguaje-UI-s/UI's creator/src/sample//lexer.flex";
        //filePath = "C:/Users/bexan/Desktop/UI's creator/src/sample//lexer.flex";

        lexerGenerater(filePath);
    }

    private void lexerGenerater(String filePath) {
        File file = new File(filePath);
        jflex.Main.generate(file);
    }


    @FXML
    private void openFile() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("txt", "*.txt")
        );
        textFile = fileChooser.showOpenDialog(stage);
        if (textFile != null) {
            ReadFile(textFile);
        }
    }

    private void ReadFile(File textFile) {
        data = "";
        try {
            fr = new FileReader(textFile);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                data += line + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML private void readLexerFile(){

        File file = new File("core.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print(data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader reader = null;
        Lexer lexer = null;
        String result = null;
        Token token = null;
        Token lastToken = null;
        try {
            reader = new BufferedReader(new FileReader("core.txt"));
            lexer = new Lexer(reader);
            result = "";
            token = lexer.yylex();
            lastToken = token;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tokensArray.add(token);
        while (token!=null){
            switch (token){
                case ERROR:
                    result = result + "Error, el simbolo no coincide \n";
                    break;
                case VALOR_ENTERO:
                    result = result+"Token: " + token + " " + lexer.lexeme + "\n";
                    break;
                default:
                    result = result + "Token: " + token + "\n";
            }
            lastToken = token;
            try {
                token = lexer.yylex();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tokensArray.add(token);

        }
        result = result + "FIN";
        textArea.setEditable(false);
        textArea.setText("");
        textArea.appendText(result);
        analisis = new SyntaticAnalisis(tokensArray);
        analisis.ui();
        semanticAnalisis = new SemanticAnalisis(tokensArray);
        String resultA = null;
        try {
            resultA = semanticAnalisis.analizar();
            textArea.appendText("\n" + resultA);
        } catch (ExportException e) {
            textArea.appendText("\n Errores semanticos:::::" + "\n" + e.getMessage());
        }

    }

}
