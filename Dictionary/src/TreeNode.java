/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavin Goroski & Aaron Mead
 */
public class TreeNode {

    Words data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    protected int column;
    protected int row;
    protected int center;

    public TreeNode(Words data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
    }

    public Words getData() {
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

    public TreeNode searchFrom(String value) {
        if (data.getWord().equals(value)) {
            return this;
        }
        if (value.compareTo(data.getWord()) < 0) {
            if (left == null) {
                return null;
            }
            return left.searchFrom(value);
        } else {
            if (right == null) {
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
        return "(" + data + ")";
    }
}
