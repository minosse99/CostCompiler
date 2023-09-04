package ast;

import typeNode.TypeNode;

public class ReturnTypeNode implements Node{
    TypeNode type;
    IdNode id;
    public ReturnTypeNode(TypeNode type) {
        this.type = type;
        id = null;
    }

    public ReturnTypeNode(IdNode id) {
        this.id = id;
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
        return null;
    }
}
