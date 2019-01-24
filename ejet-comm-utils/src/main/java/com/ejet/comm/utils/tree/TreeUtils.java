package com.ejet.comm.utils.tree;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejet.comm.utils.reflect.ReflectUtils;


public class TreeUtils {

    private static Logger logger = LoggerFactory.getLogger(TreeUtils.class);

    /**
     *
     * @param list 需要转换的数组
     * @param clazz 转换对象的类
     * @param keyId 主键.(父节点关联的属性)
     * @param parent 父节点
     * @return
     */
    public static <T> List<Tree<T>> tree(List<T> list, Class<T> clazz, String keyId, String parent) {

        /**
         * format
         *
         * [{"item":{t} , "children":[ {"item":{}, "children":[]} ] } ]
         *
         */
        List<Tree<T>> result = new ArrayList<>();

        Tree<T> tree = null;
        for (T t : list) {
            tree = new Tree<>();
            tree.setItem(t);
            Object value = ReflectUtils.getFieldValue(t, parent);
            if (value == null || (value instanceof String && "".equals(value)) ) {
                result.add(tree);
            } /*else if (value instanceof String) {
                String valStr = (String) value;
                if ("".equals(valStr)) {
                    result.add(tree);
                }
            } */else {
                boolean flag = searchAndAddTreeChildren(result, tree, keyId, parent);
                if (!flag) {
                    logger.info(
                            "this key id : " + ReflectUtils.getFieldValue(t, keyId) + " cannot find parent , and continue");
                }
            }

        }

        return result;
    }


    private static <T> boolean searchAndAddTreeChildren(List<Tree<T>> result, Tree<T> tree, String keyId,
            String parent) {

        for (Tree<T> t : result) {
            T obj = t.getItem();
            Object value = ReflectUtils.getFieldValue(obj, keyId);
            Object childrenValue = ReflectUtils.getFieldValue(tree.getItem(), parent);

            if (value.equals(childrenValue)) {
                List<Tree<T>> list = t.getChildren();
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(tree);
                t.setChildren(list);
                return true;
            }

            while (t.getChildren() != null) {
                searchAndAddTreeChildren(t.getChildren(), tree, keyId, parent);
            }
        }

        return false;
    }

}
