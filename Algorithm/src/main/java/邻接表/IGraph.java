package 邻接表;

/**
 * @Description: 邻接表接口|邻接矩阵
 * @author: LinQin
 * @date: 2021/07/29
 */
public interface IGraph<E> {
    /**
     * 获取顶点的个数
     * @return
     */
    public int getNumOfVertex();

    /**
     * 插入顶点
     * @return
     */
    boolean insertVex(E v);

    /**
     * 删除顶点
     * @return
     */
    boolean deleteVex(E v);

    /**
     * 定位顶点的位置
     * @return
     */
    int indexOfVex(E v);

    /**
     * 定位指定位置的顶点
     * @return
     */
    E valueOfVex(int v);

    /**
     * 插入边
     * @return
     */
    boolean insertEdge(int v1, int v2, int weight);

    /**
     * 删除边
     * @return
     */
    boolean deleteEdge(int v1, int v2);

    /**
     * 查找边
     * @return
     */
    int getEdge(int v1, int v2);

    /**
     * 深度优先搜索遍历
     * @return
     */
    String depthFirstSearch(int v);

    /**
     * 广度优先搜索遍历
     * @return
     */
    String breadFirstSearch(int v);

    /**
     * 查找源点到其它顶点的路径
     * @return
     */
    public int[] dijkstra(int v);
}