package jp.ac.aiit.apbl6.javafxprototypes.sample;

import jp.ac.aiit.apbl6.javafxprototypes.model.Entity;

public class SampleEntry extends Entity
{
    private String textField;
    private String radioButton;
    private String checkBoxA;
    private String checkBoxB;
    private String choiceBox;

    public SampleEntry() {}

    public String getTextField() { return textField; }

    public void setTextField(String textField) { this.textField = textField; }

    public String getRadioButton() { return radioButton; }

    public void setRadioButton(String radioButton) { this.radioButton = radioButton; }

    public String getCheckBoxA() { return checkBoxA; }

    public void setCheckBoxA(String checkBoxA) { this.checkBoxA = checkBoxA; }

    public String getCheckBoxB() { return checkBoxB; }

    public void setCheckBoxB(String checkBoxB) { this.checkBoxB = checkBoxB; }

    public String getChoiceBox() { return choiceBox; }

    public void setChoiceBox(String choiceBox) { this.choiceBox = choiceBox; }
}
