package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ImageView iv1 = new ImageView();
    ImageView iv2 = new ImageView();
    ImageView iv3 = new ImageView();

    @FXML
    ComboBox<String> comboBox;
    @FXML
    TextField creditTextFiled;
    @FXML
    TextField moneyTextField;
    @FXML
    Text text;
    @FXML
    ImageView imageView1;
    @FXML
    ImageView imageView2;
    @FXML
    ImageView imageView3;
    @FXML
    TextField textField;
    @FXML
    Button button;
    Thread t1;
    public boolean flag = false;
    ObservableList<String> creditList = FXCollections.observableArrayList("100", "200", "500", "1000");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().setAll(creditList);
        comboBox.setDisable(false);
        textField.setText("0");
        if (creditTextFiled.getText().equals("0")) {
            button.setDisable(true);
            text.setText("Please add credit");
        }
    }

    public void getRandomImage(ImageView imageView) {
        for (int i = 0; i < 20; i++) {
            imageView.setImage(new Image(ImagesPath.getPaths().get(new Random().nextInt(ImagesPath.getPaths().size() - 1))));
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 19) {
                flag = true;
            }
        }
        if (imageView.hashCode() == imageView1.hashCode())
            iv1 = imageView;
        if (imageView.hashCode() == imageView2.hashCode())
            iv2 = imageView;
        if (imageView.hashCode() == imageView3.hashCode())
            iv3 = imageView;

    }

    public void spin(ActionEvent event) throws InterruptedException {
        button.setDisable(false);
        imageView1.setImage(null);
        imageView2.setImage(null);
        imageView3.setImage(null);
        text.setText(null);
        button.setDisable(true);
        if (!creditTextFiled.getText().equals("0")) {
            creditTextFiled.setText(String.valueOf(Integer.parseInt(creditTextFiled.getText()) - 100));
        } else

        {
            text.setText("You have not any credit");
            return;
        }
        if (moneyTextField.getText().contains("-")) {
            text.setText("You have not money");
            return;
        }

        t1 = new Thread(() -> {

            while (true) {
                getRandomImage(imageView1);
                getRandomImage(imageView2);
                getRandomImage(imageView3);

                if (flag == true) {
                    button.setDisable(false);
                    getScore();
                    comboBox.setDisable(false);
                    break;
                }
            }
        });

        t1.start();

    }

    public void addCredit(ActionEvent event) {
        if (moneyTextField.getText().equals("0") || moneyTextField.getText().contains("-")) {
            text.setText("You have not money");
            return;
        }
        moneyTextField.setText(String.valueOf(Integer.parseInt(moneyTextField.getText()) - Integer.parseInt(comboBox.getSelectionModel().getSelectedItem())));
        button.setDisable(false);
        creditTextFiled.setText(String.valueOf(Integer.parseInt(creditTextFiled.getText()) + Integer.parseInt(comboBox.getSelectionModel().getSelectedItem())));
        comboBox.setDisable(true);
    }

    public void getScore() {

        String lastResult;
        int result = 0;
        String lastMoneyResult;
        int moneyResult = 0;

        if (textField.getText() != null) {
            lastResult = textField.getText();
            result = Integer.parseInt(lastResult);
        }

        if (moneyTextField.getText() != null) {
            lastMoneyResult = moneyTextField.getText();
            moneyResult = Integer.parseInt(lastMoneyResult);
        }

        ObservableList<ImageView> list = FXCollections.observableArrayList(iv1, iv2, iv3);
        int k = 0;
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i).getImage().getUrl().equals(list.get(j).getImage().getUrl())))
                    k++;
            }
        }

        if (k == 0) {
            text.setText("No luck,try Again!");
            result += k;
            textField.setText(String.valueOf(result));
        }

        if (k == 1) {
            text.setText("Lucky!!! You got 50");
            result += k * 50;
            moneyResult += k * 50;
            moneyTextField.setText(String.valueOf(moneyResult));
            textField.setText(String.valueOf(result));
        }

        if (k == 2) {
            text.setText("Awesome!!! You got 100");
            result += k * 50;
            moneyResult += k * 50;
            moneyTextField.setText(String.valueOf(moneyResult));
            textField.setText(String.valueOf(result));
        }


    }


}


