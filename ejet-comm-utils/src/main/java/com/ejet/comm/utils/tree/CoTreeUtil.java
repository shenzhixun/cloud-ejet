package com.ejet.comm.utils.tree;

import java.util.List;

import com.ejet.comm.utils.reflect.ReflectUtils;
/**
 * 树转换接口
 *
 * @author ShenYijie
 */
public class CoTreeUtil {

	/**
	 * 转换成树节点信息
	 *
	 * @param all
	 * @param rootNode
	 * @return
	 */
	public static <T> TreeVO<T> getTree(List<T> all, T rootNode,
				String fieldNameOfId, String fieldNameOfPid, String[] ignoreFileds) {
		TreeVO<T> treeNode = new TreeVO<T>(rootNode);
		boolean allAppend = false;
		for(T item : all) {
			TreeVO<T> node = new TreeVO<T>(item);
			if(ignoreFileds!=null) {
				for(String fieldName : ignoreFileds) { //设置为空
					ReflectUtils.invokeSetMethodValue(item, fieldName, null);
				}
			}
			boolean temp = appendChild(treeNode, node, fieldNameOfId, fieldNameOfPid);
			allAppend = temp && allAppend;
		}
		return treeNode;
	}

	/**
	 * 转换成树节点信息
	 *
	 * @param all
	 * @param rootNode
	 * @return
	 */
	public static <T> TreeVO<T> getTree(List<T> all, T rootNode,
				String fieldNameOfId, String fieldNameOfPid) {
		TreeVO<T> treeNode = new TreeVO<T>(rootNode);
		boolean allAppend = false;
		for(T item : all) {
			TreeVO<T> node = new TreeVO<T>(item);
			boolean temp = appendChild(treeNode, node, fieldNameOfId, fieldNameOfPid);
			allAppend = temp && allAppend;
		}
		return treeNode;
	}

	/**
	 * 递归增加子节点数据
	 *
	 * @param treeNode
	 * @param currentNode
	 * @param fieldNameOfId
	 * @param fieldNameOfPid
	 * @return
	 */
	public static <T> boolean appendChild(TreeVO<T> treeNode, TreeVO<T> currentNode, String fieldNameOfId, String fieldNameOfPid) {
		boolean appended = false;
		Object value = ReflectUtils.getFieldValue(treeNode.getNode(), fieldNameOfId);
		Object pidValue = ReflectUtils.getFieldValue(currentNode.getNode(), fieldNameOfPid);
		if( Integer.valueOf(String.valueOf(value)).intValue() ==
				Integer.valueOf(String.valueOf(pidValue)).intValue() ) { //
			treeNode.addChild(currentNode);
			return true;
		} else if( treeNode.getChild()!=null ) {
			for(TreeVO<T> item : treeNode.getChild()) {
				if( appendChild(item, currentNode, fieldNameOfId, fieldNameOfPid) ) {
					appended = true;
					break;
				}
			}
		}
		return appended;
	}


	/**
	 * 查找节点父节点
	 *
	 * @return
	 */
	public static <T> TreeVO<T> getFather(TreeVO<T> tree, TreeVO<T> currentNode, String fieldNameOfId, String fieldNameOfPid) {
		TreeVO<T> node = null;
        Object value = ReflectUtils.getFieldValue(tree.getNode(), fieldNameOfId);
        Object pidValue = ReflectUtils.getFieldValue(currentNode.getNode(), fieldNameOfPid);
		if( Integer.valueOf(String.valueOf(value)).intValue() ==
				Integer.valueOf(String.valueOf(pidValue)).intValue() ) { //tree节点的id，刚好等于需要查找的currentNode
			node = currentNode;
			return node;
		}else if( tree.getChild()!=null ) {
			for(TreeVO<T> item : tree.getChild()) {
				if( getFather(item, currentNode, fieldNameOfId, fieldNameOfPid)!=null ) {
					break;
				}
			}
		}
		return node;
	}

	/**
	 * 查找所有子节点
	 *
	 * @return
	 */
	public static <T> TreeVO<T> getChild(TreeVO<T> tree, TreeVO<T> currentNode, TreeVO<T> resultNode, String fieldNameOfId, String fieldNameOfPid) {
		TreeVO<T> node = null;
        Object value = ReflectUtils.getFieldValue(tree.getNode(), fieldNameOfId);
        Object pidValue = ReflectUtils.getFieldValue(currentNode.getNode(), fieldNameOfId);
		if( Integer.valueOf(String.valueOf(value)).intValue() ==
				Integer.valueOf(String.valueOf(pidValue)).intValue() ) { //tree节点的id，刚好等于需要查找的currentNode
			resultNode = new TreeVO<T>(tree.getNode());
			resultNode.setChild(tree.getChild());
			node = resultNode;
			return resultNode;
		}else if( tree.getChild()!=null ) {
			for(TreeVO<T> item : tree.getChild()) {
				if( getChild(item, currentNode, resultNode, fieldNameOfId, fieldNameOfPid)!=null ) {
					break;
				}
			}
		}
		return node;
	}




}
