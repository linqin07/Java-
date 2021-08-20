package B树;

/**
 * Description:
 * author: 林钦
 * date: 2021/07/29
 */
public interface ChianOperator {
    BTreeNode<Integer> insert();

    void preorder(BTreeNode<Integer> bTreeNode);
}
