package ds.trees;

/*
 * Problem: Binary Tree Operations
 * Implements various binary tree traversals and operations.
 *
 * Operations Included:
 * - Left View: First node at each level
 * - Right View: Last node at each level
 * - Pre-Order Traversal: Root → Left → Right
 * - In-Order Traversal: Left → Root → Right
 * - Post-Order Traversal: Left → Right → Root
 * - Level-Order Traversal: BFS level by level
 * - Height of Tree: Maximum depth
 * - Diameter of Tree: Longest path between any two nodes
 * - Mirror of Tree: Swap left and right children
 *
 * Memory Tricks:
 *   Traversals (DLR pattern - where D = data, L = left, R = right):
 *   - Pre-order: DLR (Data first, then children)
 *   - In-order: LDR (Left, Data, Right) → Sorted for BST!
 *   - Post-order: LRD (Children first, Data last)
 *
 *   Views (BFS with level tracking):
 *   - Left view: i == 0 (first of each level)
 *   - Right view: i == n-1 (last of each level)
 *
 *   Height: max(leftHeight, rightHeight) + 1
 *   Diameter: max(lh + rh + 1, max(leftDia, rightDia))
 *   Mirror: Swap left and right recursively
 *
 * Time Complexity: O(n) for all traversals
 * Space Complexity: O(h) for recursive, O(n) for level-order
 */
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    static void printLeftView(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            System.out.println("n::" + n);
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) System.out.println(temp.data + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    static void printRightView(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (i == n - 1) System.out.println(temp.data + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data + " ");

    }

    private static int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        else {
            int lheight = heightOfTree(root.left);
            int rheight = heightOfTree(root.right);
            if (lheight > rheight) return lheight + 1;
            else return rheight + 1;
        }

    }


    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        int h = heightOfTree(root);
        for (int i = 1; i <= h; i++) {
            printCurrentOrder(root, i);
        }
    }

    private static void reverseLevelOrderTraversal(TreeNode root) {
        if (root == null) return;
        int h = heightOfTree(root);
        for (int i = h ; i >= 1; i--) {
            printCurrentOrder(root, i);
        }
    }

    private static void printCurrentOrder(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) System.out.println(root.data + " ");
        else if (level > 1) {
            printCurrentOrder(root.left, level - 1);
            printCurrentOrder(root.right, level - 1);
        }
    }

    private static int diameterOfTree(TreeNode root) {
        if (root == null) return 0;
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);

        int ldiameter = diameterOfTree(root.left);
        int rdiameter = diameterOfTree(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    private static TreeNode mirrorOfTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorOfTree(root.left);
        TreeNode right = mirrorOfTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(7);

        System.out.println("Left view of binary tree::");
        printLeftView(tree.root);

        System.out.println("Right view of binary tree::");
        printRightView(tree.root);

        System.out.println("Pre-Order Traversal of binary tree::");
        preOrderTraversal(tree.root);

        System.out.println("In-Order Traversal of binary tree::");
        inOrderTraversal(tree.root);

        System.out.println("Post-Order Traversal of binary tree::");
        postOrderTraversal(tree.root);

        System.out.println("Level-Order Traversal of binary tree::");
        levelOrderTraversal(tree.root);

        System.out.println("Level-Order Traversal of binary tree::");
        reverseLevelOrderTraversal(tree.root);

        System.out.println("Height of binary tree::");
        int height = heightOfTree(tree.root);
        System.out.println(height);

        System.out.println("Diameter of binary tree::");
        int diameter = diameterOfTree(tree.root);
        System.out.println(diameter);

        System.out.println("Mirror tree of binary tree::");
        TreeNode mirror = mirrorOfTree(tree.root);
        System.out.print("\nInorder of mirror tree: \n");
        inOrderTraversal(tree.root);


    }
}
