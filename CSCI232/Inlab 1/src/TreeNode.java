
/**
 *
 * @author Gavin Goroski
 * @date 1/24/2014
 */
public class TreeNode {

    private Data data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    protected int column;
    protected int row;
    protected int center;

    public TreeNode(Data d) {
        this.data = d;
        parent = null;
        left = null;
        right = null;
    }

    public Data getData() {
        return data;
    }

    public void setParent(TreeNode n) {
        parent = n;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setLeft(TreeNode n) {
        left = n;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setRight(TreeNode n) {
        right = n;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode searchFrom(Data value) {
        if (data.getYear() == value.getYear()){
            if (data.getName().equals(value.getName())){
                    return this;
                }
            }
//            if(!data.getName().equals(value.getName()))
//                {
//                    return left.searchFrom(value);
//                }
            
      
        
            if (value.getYear() < data.getYear()) {
                if (left == null) {
                        return null;
                    }
                return left.searchFrom(value);
                } 
            else {
                if (right == null){ 
                return null;
            }   
            
        
        return right.searchFrom(value);
            }
        }
    
    

    public boolean searchForNode(TreeNode searchNode) {
        if (this == searchNode) {
            return true;
        }
        if (left != null && left.searchForNode(searchNode)) {
            return true;
        }
        if (right != null && right.searchForNode(searchNode)) {
            return true;
        }
        return false;
    }

    public int findMaxDepth() {
        int lmax = 0;
        int rmax = 0;
        if (left != null) {
            lmax = left.findMaxDepth();
        }
        if (right != null) {
            rmax = right.findMaxDepth();
        }
        return 1 + Math.max(lmax, rmax);
    }

    public String toString() {
        return data.getYear() + " " + data.getName();
    }
}
