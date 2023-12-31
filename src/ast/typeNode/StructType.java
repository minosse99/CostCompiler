package ast.typeNode;

import ast.IdNode;
import ast.Node;
import org.antlr.v4.runtime.misc.Pair;
import utilities.Environment;

import java.util.ArrayList;

public class StructType extends AnyType{
    String id;
    ArrayList<Pair<IdNode,TypeNode>> params;

    public StructType(String id, ArrayList<Pair<IdNode, TypeNode>> params) {
        this.id = id;
        this.params = params;
    }

    public ArrayList<Pair<IdNode, TypeNode>> getParams() {
        return params;
    }

    public TypeNode getType(IdNode id){
        for(Pair<IdNode,TypeNode> p : params){
            if(p.a.getId().equals(id.getId())){
                return p.b;
            }
        }
        return null;
    }
    @Override
    public Node typeCheck(Environment e) {
        return this;
    }


}
