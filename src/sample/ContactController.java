package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ContactController implements Initializable {
    // get id table and colum
    @FXML
    private TableView<Contact> tblContact;
    @FXML
    private TableColumn colFName;
    @FXML
    private TableColumn colLName;
    @FXML
    private TableColumn colPhone;
    @FXML
    private TableColumn colDOB;
    @FXML
    private TableColumn colEmail;
    @FXML
    private TableColumn colGroup;
//    list combobox
    @FXML
    private ComboBox cbGroup;
//  arraylist
    private ObservableList<Contact> tvObservableList = FXCollections.observableArrayList();

    // list Combo Box
    private ObservableList<String> cbList = FXCollections.observableArrayList("1","2","3");
//    String cbURL = "data/group.txt";

//    private void listComboBox() throws IOException {
//        try {
//            ArrayList<String> tmp = new ArrayList<String>();
//            InputStream ips = new FileInputStream("data/group.txt");
//            InputStreamReader ipsr = new InputStreamReader(ips);
//            BufferedReader br = new BufferedReader(ipsr);
//            String line;
//            while ((line=br.readLine()) != null) {
//                cbGroup.getItems().add(line);
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    //    search
    @FXML
    void searchContact(){
        System.out.println("search");
    }
//   add
    @FXML
    void addContact( ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addContact.fxml"));
        Parent parent = fxmlLoader.load();
        AddContactController dialogController = fxmlLoader.<AddContactController>getController();
        dialogController.setContactList(tvObservableList);


        Scene scene = new Scene(parent, 300,353);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
//    update
    @FXML
    void updateContact(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("updateContact.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent, 543,353);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
//    del
    @FXML
    void delContact(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delContact.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent, 300,144);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
//   group
    @FXML
    void  groupContact() {
        System.out.println("group contact");
    }
//   filter
    @FXML
    void  filterContact() {
        System.out.println("filter contact");
    }


    @Override
    public void initialize(URL location, ResourceBundle resource) {
//        table view
        colFName.setCellValueFactory( new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory( new PropertyValueFactory<>("lastName"));
        colPhone.setCellValueFactory( new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory( new PropertyValueFactory<>("email"));
        colDOB.setCellValueFactory( new PropertyValueFactory<>("dob"));
        colGroup.setCellValueFactory( new PropertyValueFactory<>("group"));
        tblContact.setItems(tvObservableList);

//        combobox  input value
        try {
            ArrayList<String> tmp = new ArrayList<String>();
            InputStream ips = new FileInputStream("data/group.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line=br.readLine()) != null) {
                cbGroup.getItems().add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        Table view input value


    }
}
