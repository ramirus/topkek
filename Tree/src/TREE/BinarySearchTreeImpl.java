package TREE;


public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    public class TreeNode {
        private T value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T value) {
            this.value = value;
        }

        public boolean contains(T element) {
            if (element.compareTo(value) == 0) {
                System.out.println("нашееел");
                return true;
            }
            if (left != null) left.contains(element);
            if (right != null) right.contains(element);
            return false;
        }
    }

    private TreeNode root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    @Override
    public void insert(T element) {
        this.root = insert(root, element);
    }

    private TreeNode insert(TreeNode root, T element) {
        if (root == null) {
            root = new TreeNode(element);
        } else if (root.value.compareTo(element) >= 0) {
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }
        return root;
    }


    public int levels(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(levels(root.left),
                    levels(root.right));
        }
    }

    @Override
    public boolean contains(T element) {
        if (root == null) {
            System.out.println("пусто");
            return false;
        }
        return root.contains(element);
    }

    @Override
    public void printByLevels() {
        int level = levels(root) + 1;
        for (int i = 1; i < level; i++) {
            printByLevels(root, i);
            System.out.println(" ");
        }
    }


    private void printByLevels(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(" " + root.value + " ");
        } else if (level > 1) {
            printByLevels(root.left, level - 1);
            printByLevels(root.right, level - 1);
        }
    }

    @Override
    public boolean remove(T k) {
        if (root == null) {
            return false;
        } else {
            deleteNode(root, k);
        }
        return false;
    }

    public TreeNode deleteNode(TreeNode root, T k) {
        if (root.value.compareTo(k) > 0) {
            root.left = deleteNode(root.left, k);
        } else if (root.value.compareTo(k) < 0) {
            root.right = deleteNode(root.right, k);

        } else if (root.left != null && root.right != null) {
                TreeNode temp = root;
                TreeNode minNodeForRight = minimum(temp.right);
                root.value = minNodeForRight.value;
                deleteNode(root.right, minNodeForRight.value);
        } else if (root.left != null) {
            root = root.left;
        } else if (root.right != null) {
            root = root.right;
        } else {
            root = null;
        }
        return root;
    }

    public TreeNode minimum(TreeNode root) {
        if (root.left == null)
            return root;
        else {
            return minimum(root.left);
        }
    }

    @Override
    public void print() {
        print(this.root);
    }


    private void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

}