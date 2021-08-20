package B树;

import java.util.List;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/07/29
 */
public class ChianOperatorImpl implements ChianOperator {
    @Override
    public BTreeNode<Integer> insert() {

        return null;
    }

    @Override
    public void preorder(BTreeNode<Integer> bTreeNode) {
        List<BTreeNode<Integer>> children = bTreeNode.getChildren();
        if (children != null) {
            for (BTreeNode child : children) {
                preorder(child);
            }
        } else {
            System.out.println(bTreeNode.getData().toString());

        }
    }
}
