package ast;

import org.antlr.v4.runtime.misc.Pair;
import typeNode.TypeNode;

import java.util.ArrayList;

public class FormalParams implements Node {
    ArrayList<Pair<String, TypeNode>> formalParams;

    public FormalParams(ArrayList<Pair<String, TypeNode>> formalParams) {
        this.formalParams= new ArrayList<Pair<String, TypeNode>>(formalParams);
    }

    @Override
    public String toPrint(String indent) {
        return null;
    }

    @Override
    public Environment checkSemantics(Environment e) {
        return null;
    }

    @Override
    public String toEquation(Environment e) {
        return "";
    }

}
