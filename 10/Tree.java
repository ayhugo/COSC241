package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 * 
 * @author Michael Albert
 * @param <T> The type of values stored in the tree.
 */
public class Tree<T> {
    /** the root of the tree. */
    private T rootValue;
    /**list of the children of the tree. */
    private List<Tree<T>> children;
    /** number of nodes in a given tree. */
    private int count = 1;

    /**
     * constructor for the tree.
     * @param rootValue parent tree.
     * @param children subtree of parent.
     */
    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }
    
    /**
     * constructor that creates a new tree.
     * @param rootValue parent tree.
     */
    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    /**
     * size of the tree.
     * @return int size of the tree.
     */
    public int size() {
        for (Tree<T> child : children) {
            if (children != null) {
                count+= child.size();
            }
        }
        return count;
    }
    /**
     * max number of children.
     * @return an int of the max number of children.
     */
    public int maxDegree() {
        int maxChild= children.size();
        for(Tree<T> child : children) {
            if(child.maxDegree() > maxChild) {
                maxChild = child.maxDegree();
            }
            child.maxDegree();
        }
        return maxChild;
    }

    /**
     * adds a new subtree.
     * @param child child to be added.
     */
    public void add(Tree<T> child) {
        children.add(child);
    }

    /**
     * finds a child in a tree.
     * @param value of the child to find.
     * @return where child is.
     */
    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }
    /**
     * displays in reverse order.
     * @return an Arraylist of tree in reverse order.
     */
    public List<T> postOrder() {
        ArrayList<T> order = new ArrayList<T>();
        for (Tree<T> child : children) {
            order.addAll(child.postOrder());
        }
        order.add(rootValue);
        return order;
    }

    /**
     * names of the nodes.
     * @return a string of nodes in the tree.
     */
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }
    /**
     * represent the contents of a tree as a string using an indented list.
     * @return tree as a string.
     */
    public String toIndentedString() {
        String parent ="";
        parent += rootValue + "\n";
        for (Tree<T> child : children) {
            parent += child.toIndentedString("  ");
        }
        return parent;
    }

    /**
     *put indents into the lists.
     *@param indent string for indents to be added.
     *@return tree as a string of indented lists.
     */
    public String toIndentedString(String indent) {
        String parent ="";
        parent += indent + rootValue + "\n";
        for (Tree<T> child : children) {
            parent += child.toIndentedString("  " + indent);
        }
        return parent;
    }



    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
