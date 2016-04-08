package dunn;
import java_cup.runtime.Symbol;
%%
%cupsym Simbolo
%class Lexer
%cup
%public
%ignorecase
L = [a-zA-Z_-]
D = [0-9]+
extra= ["!"|"#"|"$"|"%"|"*"|"+"|"-"|"/"|":"|";"|"<"|"="|">"|"?"|"@"|"_"|"."|","|"~"|"¡"|"¿"|"&"|"°"|"´"|" "|"("|")"|"{"|"}"|"["|"]"|"|"]
WHITE=[ \t\r\n]
salto=[\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}
"?" { return new Symbol(Simbolo.interrogacion,yychar,yyline);}
"." { return new Symbol(Simbolo.punto,yychar,yyline);}
"," { return new Symbol(Simbolo.coma,yychar,yyline);}
"{" { return new Symbol(Simbolo.abrep,yychar,yyline);}
"}" { return new Symbol(Simbolo.cierrap,yychar,yyline);}
"'" { return new Symbol(Simbolo.comilla,yychar,yyline);}
\" { return new Symbol(Simbolo.comilla_doble,yychar,yyline);}
"numeric" {return new Symbol(Simbolo.numeric,yychar,yyline);}
"integer" {return new Symbol(Simbolo.p_integer,yychar,yyline);}
"real" {return new Symbol(Simbolo.p_real,yychar,yyline);}
"date" {return new Symbol(Simbolo.p_date,yychar,yyline);}
"string" {return new Symbol(Simbolo.p_string,yychar,yyline);}
"@data" {return new Symbol(Simbolo.p_data,yychar,yyline);}
"@relation" {return new Symbol(Simbolo.p_relation,yychar,yyline);}
"@attribute" {return new Symbol(Simbolo.p_attribute,yychar,yyline);}
("+"|"-")?{D}"."{D}|("+"|"-")?{D} {return new Symbol(Simbolo.numero,yychar,yyline,new String(yytext()));}
{L}({L}|{D})* {return new Symbol(Simbolo.palabra,yychar,yyline,new String(yytext()));}
"'"({L}|{D}|{extra})*"'"|\"({L}|{D}|{extra})*\" {return new Symbol(Simbolo.cadena,yychar,yyline,new String(yytext()));}
"%"[^\n]* {/*Ignore*/}
. {System.out.println("error lexico:"+yytext());}