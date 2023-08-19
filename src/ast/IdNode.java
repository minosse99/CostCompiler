package ast;

public class IdNode implements Node{
    String id;

    public IdNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toPrint(String indent) {
        return indent + "Id: " + id + "\n";
    }
}