import com.sun.xml.internal.ws.util.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import utils.FileUtil;
import utils.StringUtil;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author M.T.
 */
public class Controller implements Initializable {
    @FXML
    TreeView<String> file_tree;

    @FXML
    Label label_status;

    @FXML
    TextArea textArea;

    @FXML
    Tab tab1;

    /**
     * open a file chooser and choose a file
     */
    public void openFile(){
        FileChooser fc = new FileChooser();
        // create a file type filter
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files","*"),
                new FileChooser.ExtensionFilter("Text Files","*.txt", "*.doc", "*.docx"));
        File selectedFile = fc.showOpenDialog(null);

        // open file in textarea
        if (selectedFile != null){
            FileUtil.getFileType(selectedFile);
            tab1.setText(selectedFile.getName());
            textArea.setText(FileUtil.txt2String(selectedFile));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // create treeItem when fxml file loaded
        TreeItem<String> root = new TreeItem<>("root");
        root.setExpanded(true);

        TreeItem<String> firstNode = new TreeItem<>("First Node");
        buildTreeNode(firstNode, "Frist subNode");
        buildTreeNode(firstNode, "Second subNode");
        buildTreeNode(firstNode, "Third subNode");
        buildTreeNode(firstNode, "Forth subNode");

        TreeItem<String> secondNode = new TreeItem<>("Second Node");
        buildTreeNode(secondNode, "Frist subNode");
        buildTreeNode(secondNode, "Second subNode");
        buildTreeNode(secondNode, "Third subNode");
        buildTreeNode(secondNode, "Forth subNode");

        root.getChildren().addAll(firstNode,secondNode);
        file_tree.setRoot(root);
        file_tree.setShowRoot(false);
    }

    /**
     * add tree node linked to their parent
     * @param parent
     * @param treeNodeStr
     * @return
     */
    private TreeItem<String> buildTreeNode(TreeItem<String> parent, String treeNodeStr) {
        TreeItem<String> treeNode = new TreeItem<>(treeNodeStr);
        treeNode.setExpanded(true);
        parent.getChildren().add(treeNode);
        return treeNode;
    }
}
