package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddContactController implements Initializable {
//    get id
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField Email;
    @FXML
    private TextField dob;
//
//    @FXML
//    private DatePicker dob;
    @FXML
    private ComboBox<String> cbGroup;

//    kiểu list
    private ObservableList<Contact> contactObservableList;

    @FXML
    void saveContact(ActionEvent event) {



        String fname = firstName.getText().trim();
        String lname = lastName.getText().trim();
        String tel = phone.getText().trim();
        String email = Email.getText().trim();
        String d = dob.getText().trim();
        String group = cbGroup.getSelectionModel().getSelectedItem();

        Contact data = new Contact(fname,lname,tel,email,d,group);
        contactObservableList.add(data);
//        for (Contact c : contactObservableList) {
//            System.out.println(c);
//        }
        close(event);
    }

    @FXML
    void closeDialog(ActionEvent e) {
        close(e);
    }




     // function nhân vào list data và gán nó bằng list mới tạo

    public  void setContactList( ObservableList<Contact> tvObservableList) {
        this.contactObservableList = tvObservableList;
    }
    // close dialong

    private void close( ActionEvent e ) {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resource) {
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
