import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class DataValueWeightFXML {
    private HBox hbox;
    private TextField textFieldDataValue;
    private TextField textFieldWeight;
    private static List<DataValueWeightFXML> dataValueWeightFXMLList = new ArrayList<>();

    public DataValueWeightFXML(HBox hbox, TextField textFieldDataValue, TextField textFieldWeight) {
        this.hbox = hbox;
        this.textFieldDataValue = textFieldDataValue;
        this.textFieldWeight = textFieldWeight;
    }

    public HBox getHBox() {
        return hbox;
    }

    public TextField getTextFieldDataValue() {
        return textFieldDataValue;
    }

    public TextField getTextFieldWeight() {
        return textFieldWeight;
    }

    public static List<DataValueWeightFXML> getDataValueWeightFXMLList() {
        return dataValueWeightFXMLList;
    }
}
