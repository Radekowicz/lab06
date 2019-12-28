import com.sun.tools.javac.util.Name;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GUI extends Application{

    private static ShopInterface shop;

    private Stage window;
    private static double windowWidth = 800;
    private double windowHeight = 500;
    private BorderPane borderPane;
    private TableView<TableItem> tableItemTableView;




    @Override
    public void start(Stage primaryStage) {


        window = primaryStage;
        window.setTitle("Shop");
        window.setMaxWidth(windowWidth);
        window.setMaxHeight(windowHeight);


        tableView();


        borderPane = new BorderPane();
        borderPane.setCenter(tableItemTableView);

        Scene scene = new Scene(borderPane, windowWidth, windowHeight);

        window.setScene(scene);
        window.show();
    }


    public static void setShop(ShopInterface shop) {
        GUI.shop = shop;
    }



    public static List<TableItem> getTableItemList(List<Item> itemList) {
        List<TableItem> tableItemList = new ArrayList<>();
        for (Item item : itemList) {
            tableItemList.add(new TableItem(item));
        }
        return tableItemList;
    }




    public static ObservableList<TableItem> getTableItemObservableList(List<Item> itemList) {

        List<TableItem> tableItemList = getTableItemList(itemList);

        ObservableList<TableItem> observableTableItemList = FXCollections.observableArrayList(tableItemList);
        return observableTableItemList;
    }



    public void tableView() {
        // code
        TableColumn<TableItem, Integer> codeColumn = new TableColumn<>("Code");
        codeColumn.setMinWidth(windowWidth/4);
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));

        //name
        TableColumn<TableItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(windowWidth/4);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //price
        TableColumn<TableItem, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(windowWidth/4);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //quantity
        TableColumn<TableItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(windowWidth/4);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

//        //isPresent CheckBox
//        TableColumn<TableItem, Boolean> isPresentColumn = new TableColumn<>("Present");
//        isPresentColumn.setMinWidth(windowWidth/4);
//        isPresentColumn.setCellValueFactory((new PropertyValueFactory<>("isPresent")));

        tableItemTableView = new TableView<>();
        ObservableList<TableItem> observableTableItemList = getTableItemObservableList(shop.getAllItemList());
        tableItemTableView.setItems(observableTableItemList);
        tableItemTableView.getColumns().addAll(codeColumn, nameColumn, priceColumn, quantityColumn);
    }
}