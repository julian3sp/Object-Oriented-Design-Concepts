public class MinHeapStrategy extends AbsBTStrategy implements BTStrategy{
    @Override
    public NodeBT addInt(int i, IBinTree b) {
        if(b.isEmpty()){
            return new NodeBT(i, new EmptyBT(), new EmptyBT());
        }
        else{
            if(i < b.getRoot()){
                return new NodeBT(b.getRoot(), b.getLeft(), this.addInt(i, b.getRight()));
            }
            else{
                return new NodeBT(i, this.addInt(b.getRoot(),b.getLeft()), b.getRight());
            }
        }
    }

}
