import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private VBox mainVBox;
    @FXML
    private Label resultLabel;

    public void addDataValueWeightToMainVBox() {
        HBox hBox = new HBox();
        TextField textFieldDataValue = new TextField();
        TextField textFieldWeight = new TextField();

        hBox.setPrefWidth(500);
        hBox.setPrefHeight(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        textFieldDataValue.setPrefWidth(200);
        textFieldDataValue.setPromptText("Data Value");
        textFieldWeight.setPrefWidth(100);
        textFieldWeight.setPromptText("Weight");

        hBox.getChildren().add(textFieldDataValue);
        hBox.getChildren().add(textFieldWeight);
        mainVBox.getChildren().add(hBox);

        DataValueWeightFXML.getDataValueWeightFXMLList().add(new DataValueWeightFXML(hBox, textFieldDataValue,
                textFieldWeight));
    }

    public void removeDataValueWeightFromMainVBox() {
        if (DataValueWeightFXML.getDataValueWeightFXMLList().size() > 0) {
            DataValueWeightFXML dataValueWeightFXML = DataValueWeightFXML.getDataValueWeightFXMLList()
                    .get(DataValueWeightFXML.getDataValueWeightFXMLList().size() - 1);

            mainVBox.getChildren().remove(dataValueWeightFXML.getHBox());

            DataValueWeightFXML.getDataValueWeightFXMLList().remove(dataValueWeightFXML);
        }
    }

    public void resetDataValueWeightInMainVBox() {
        while (DataValueWeightFXML.getDataValueWeightFXMLList().size() > 0) {
            DataValueWeightFXML dataValueWeightFXML = DataValueWeightFXML.getDataValueWeightFXMLList()
                    .get(DataValueWeightFXML.getDataValueWeightFXMLList().size() - 1);

            mainVBox.getChildren().remove(dataValueWeightFXML.getHBox());

            DataValueWeightFXML.getDataValueWeightFXMLList().remove(dataValueWeightFXML);
        }
    }

    public void okDataValueWeightInMainVBox() {
//        Empty
        if (DataValueWeightFXML.getDataValueWeightFXMLList().size() == 0) {
            resultLabel.setText("Page is empty!");
            return;
        }

//        Validation
        boolean stringValidationDataValue = true;
        boolean stringValidationWeight = true;
        for (DataValueWeightFXML dataValueWeightFXML : DataValueWeightFXML.getDataValueWeightFXMLList()) {
            stringValidationDataValue = ValidateStringNumber.validateNumber(dataValueWeightFXML.getTextFieldDataValue().getText());
            stringValidationWeight = ValidateStringNumber.validateNumber(dataValueWeightFXML.getTextFieldWeight().getText());
            if (!stringValidationDataValue || !stringValidationWeight)
                break;
        }
        if (stringValidationDataValue && stringValidationWeight)
            resultLabel.setText("");
        else {
            resultLabel.setText("Error!");
            return;
        }

//        Calculate Average
        List<String> dataValueList = new ArrayList<>();
        List<String> weightList = new ArrayList<>();
        for (DataValueWeightFXML dataValueWeightFXML : DataValueWeightFXML.getDataValueWeightFXMLList()) {
            dataValueList.add(dataValueWeightFXML.getTextFieldDataValue().getText());
            weightList.add(dataValueWeightFXML.getTextFieldWeight().getText());
        }
        resultLabel.setText(CalculateAverage.calculateAverageString(dataValueList, weightList));
    }
}
