package sample;
import static sample.Token.*;
%%
%class Lexer
%type Token
L = [a-z]
A = [A-Z]
D = [0-9]
white=[ ,\n,\t,\b,\r,\a]
%{
    public String lexeme;
%}
%%

<YYINITIAL> img {return RESERVADA_IMG;}
<YYINITIAL> txt {return RESERVADA_TXT;}
<YYINITIAL> app {return RESERVADA_APP;}
<YYINITIAL> section {return RESERVADA_SECTION;}
<YYINITIAL> input {return RESERVADA_INPUT;}
<YYINITIAL> button {return RESERVADA_BUTTON;}
<YYINITIAL> rectangle {return RESERVADA_RECTANGLE;}
<YYINITIAL> width {return RESERVADA_WIDTH;}
<YYINITIAL> height {return RESERVADA_HEIGHT;}
<YYINITIAL> font {return RESERVADA_FONT;}
<YYINITIAL> text-color {return RESERVADA_TEXT_COLOR;}
<YYINITIAL> font-size {return RESERVADA_FONT_SIZE;}
<YYINITIAL> file {return RESERVADA_FILE;}
<YYINITIAL> fill {return RESERVADA_FILL;}
<YYINITIAL> stroke {return RESERVADA_STROKE;}
<YYINITIAL> id {return RESERVADA_ID;}
<YYINITIAL> class {return RESERVADA_CLASS;}

{white} {/*Ignore*/}
"//".* { /* Ignore */}
"(" {return OPEN_PROPERTY;}
")" {return CLOSE_PROPERTY;}
"'" {return COMILLA;}
";" {return COMA;}
"=" {return ASSIGN;}
[+-]?{D}+ {lexeme=yytext(); return VALOR_ENTERO;}
[+-]?{D}+[.]{D}+ {lexeme=yytext(); return VALOR_FLOTANTE;}
({L}|{A}|_)({L}|{D}|{A}|_)* {lexeme=yytext(); return TEXTO;}
":" {return OPENKEY;}
">" {return CLOSEKEY;}
. {return ERROR;}
