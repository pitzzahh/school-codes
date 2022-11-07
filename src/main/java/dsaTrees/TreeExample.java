package dsaTrees;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.*;
import java.awt.event.WindowEvent;

public class TreeExample extends JFrame {

    public TreeExample() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("html");

        DefaultMutableTreeNode head = new DefaultMutableTreeNode("head");
        DefaultMutableTreeNode body = new DefaultMutableTreeNode("body");

        DefaultMutableTreeNode meta = new DefaultMutableTreeNode("meta");
        DefaultMutableTreeNode title = new DefaultMutableTreeNode("title");

        DefaultMutableTreeNode unOrderedList = new DefaultMutableTreeNode("ul");
        DefaultMutableTreeNode headerOne = new DefaultMutableTreeNode("h1");
        DefaultMutableTreeNode headerTwo = new DefaultMutableTreeNode("h2");

        DefaultMutableTreeNode listOne = new DefaultMutableTreeNode("li");
        DefaultMutableTreeNode listTwo = new DefaultMutableTreeNode("li");

        DefaultMutableTreeNode hyperlink = new DefaultMutableTreeNode("a");

        root.add(head);
        root.add(body);

        head.add(meta);
        head.add(title);
        
        body.add(unOrderedList);
        body.add(headerOne);
        body.add(headerTwo);

        unOrderedList.add(listOne);
        unOrderedList.add(listTwo);

        headerTwo.add(hyperlink);

        JTree tree = new JTree(root);
        add(tree);
        setTitle("JTree Example By Peter John Arao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(450, 350);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TreeExample();
    }
}
