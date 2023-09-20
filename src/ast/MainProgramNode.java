package ast;

import ast.typeNode.VoidType;
import utilities.EnvVar;
import utilities.Environment;

import java.util.ArrayList;

public class MainProgramNode implements Node {
    ArrayList<Node> complexType;
    ArrayList<Node> decServices;
    ArrayList<Node> funDec;
    public MainProgramNode(ArrayList<Node> complexType, ArrayList<Node> decServices, ArrayList<Node> funDec) {
        this.complexType = complexType;
        this.decServices = decServices;
        this.funDec = funDec;
    }

    @Override
    public EnvVar checkVarEQ(EnvVar e) {
        e.add(this,"main");


        if(decServices != null)
            for(Node n : decServices){
                n.checkVarEQ(e);
            }
        if(complexType != null)
            for(Node n : complexType){
                n.checkVarEQ(e);
            }
        return e;
    }

    @Override
    public Node typeCheck(Environment e) {
        e.openScope();
        Node lastType = new VoidType();
        if(complexType != null)
            for(Node n : complexType){
                n.typeCheck(e);
            }
        if(decServices != null){
            for(Node n : decServices){
                n.typeCheck(e);
            }
        }
        if(funDec != null){
            for(Node n : funDec){
                lastType = n.typeCheck(e);
            }
        }
        e.closeScope();
        return lastType;
    }

    @Override
    public ArrayList<String> checkSemantics(Environment env) {
        env.openScope();
        ArrayList<String> errors = new ArrayList<>();
        if(complexType != null) {
            for (Node n : complexType) {
                errors.addAll(n.checkSemantics(env));
            }
        }
        if(decServices != null) {
            for (Node n : decServices) {
                errors.addAll(n.checkSemantics(env));
            }
        }
        if(funDec != null) {
            for (Node n : funDec) {
                errors.addAll(n.checkSemantics(env));
            }
        }
        env.closeScope();
        return errors;
    }

    public String toEquation(EnvVar e){

        String equ = "";
        for(Node n : funDec){
            equ += n.toEquation(e);
        }
        return equ;




    }
}
