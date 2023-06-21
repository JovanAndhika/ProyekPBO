package com.example.proyek2pbo;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SceneKomplainController {
    @FXML
    private Button submitKomplain;
    @FXML
    private TextField deskripsi;
    @FXML
    private TableView<NotaProperty> table;
    @FXML
    private TableColumn<NotaProperty,Integer>column_id;
    @FXML
    private TableColumn<NotaProperty, String>column_tanggalPengambilan;

    ObservableList<NotaProperty> listdata =  FXCollections.observableArrayList();



    /**
    @FXML
    public void searchPesanan() {
        try {
            Connection con = HelloApplication.createDatabaseConnection();
            String query = "SELECT n.id AS Nomer_Nota, n.tanggal_pengambilan " +
                    "FROM nota n " +
                    "INNER JOIN detail_pesanan dp ON n.id = dp.nota_id " +
                    "WHERE n.id = 2 " +
                    "GROUP BY n.id, n.tanggal_pengambilan " +
                    "HAVING COUNT(CASE WHEN dp.status = 0 THEN 1 END) = 0;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int column_count = rs.getMetaData().getColumnCount();
            if(column_count > 0) // ada data
            {
                while (rs.next())
                {
                    int id_nota = rs.getInt(1);
                    String tgl_pengambilan = rs.getString(2);

                    listdata.add(new NotaProperty(id_nota,tgl_pengambilan));
                }
            }
            con.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        table.setItems(listdata);
        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id_nota"));
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("tgl_pengambilan"));
    }
    **/

    @FXML
    protected void insertKomplain(){
        try {
            Connection con = HelloApplication.createDatabaseConnection();
            String query = "INSERT INTO komplain (nota_id, deskripsi) VALUES (?, ?)";
            int nota_id = 2;
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(nota_id));
            preparedStatement.setString(2, deskripsi.getText());


            preparedStatement.executeUpdate();
            con.close();

            Window owner = submitKomplain.getScene().getWindow();
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Masukkan telah diterima",
                    "Terima kasih atas masukkan Anda");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAlert(Alert.AlertType _alertType, Window _owner,
                                 String _title, String _message){
        Alert alert = new Alert(_alertType);
        alert.setTitle(_title);
        alert.setHeaderText(null);
        alert.setContentText(_message);
        alert.initOwner(_owner);
        alert.show();
    }
}



