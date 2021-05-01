package main.java.Tree.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserialize {
    // Encodes a tree to a single string.


    public String serialize(TreeNode root) {
        return dfs_serialize(root, "");
    }

    private String dfs_serialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = dfs_serialize(root.left, str);
            str = dfs_serialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return dfs_deserialize(list);

    }

    private TreeNode dfs_deserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode deserializedNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        deserializedNode.left = dfs_deserialize(list);
        deserializedNode.right = dfs_deserialize(list);
        return deserializedNode;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeDeserialize sd = new SerializeDeserialize();
        String result = sd.serialize(root);
        System.out.println(result);
    }
}
