package B树;

/**
 * @Description: B树（B-树）
 * @author: LinQin
 * @date: 2021/07/29
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * B树中的节点。
 */
public class BTreeNode<T> {
    /**
     * 节点的项，按键非降序存放
     */
    private T data;
    /**
     * 内节点的子节点
     */
    private List<BTreeNode<T>> children;
    /**,
     * 是否为叶子节点
     */
    private boolean leaf;
    /**
     * 键的比较函数对象
     */
    private Comparator<T> kComparator;

    private BTreeNode() {
        children = new ArrayList<>();
        leaf = false;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<BTreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<BTreeNode<T>> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Comparator<T> getkComparator() {
        return kComparator;
    }

    public void setkComparator(Comparator<T> kComparator) {
        this.kComparator = kComparator;
    }
}
