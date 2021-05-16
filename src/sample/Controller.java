package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Controller {
    @FXML
    private Label equationLabel;
    private String equationString = "";

    @FXML
    private Label result;
    private String resultString = "";

    double results;

    ArrayList<String> operationList = new ArrayList<String>();
    ArrayList<String> numberList = new ArrayList<String>();

    public void addOne() {
        equationLabel.setText(equationString += "1");
    }

    public void addTwo() {
        equationLabel.setText(equationString += "2");
    }

    public void addThree() {
        equationLabel.setText(equationString += "3");
    }

    public void addFour() {
        equationLabel.setText(equationString += "4");
    }

    public void addFive() {
        equationLabel.setText(equationString += "5");
    }

    public void addSix() {
        equationLabel.setText(equationString += "6");
    }

    public void addSeven() {
        equationLabel.setText(equationString += "7");
    }

    public void addEight() {
        equationLabel.setText(equationString += "8");
    }

    public void addNine() {
        equationLabel.setText(equationString += "9");
    }

    public void addZero() {
        equationLabel.setText(equationString += "0");
    }

    public void addDivide() {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "÷");
    }

    public void addTimes() {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "*");
    }

    public void addMinus() {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "−");
    }

    public void addPlus() {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "+");
    }

    public void addDot() {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += ".");
    }

    public void ac() {
        equationLabel.setText("");
        result.setText("");
        equationString = "";
        results = 0;
    }

    public void bs() {
        if (equationString.length() != 0) {
            removeLast();
            equationLabel.setText(equationString);
            results = 0;
        }
    }

    public void ce() {

        while (equationString.length() != 0 && !lastChar().equals("÷") && !lastChar().equals("*") && !lastChar().equals("−") && !lastChar().equals("+") && !lastChar().equals(".")) {
            if (equationString.length() != 0) {
                removeLast();
            }
        }
        equationLabel.setText(equationString);
    }

    public void equal() {
        dataProcess();
        if (numberList.size() <= 0) {
            return;
        }

        for (int i = 0; i < operationList.size(); i++) {
            if (operationList.get(i).equals("*")) {
                operationList.remove(i);
                numberList.set(i, Double.toString(Double.parseDouble(numberList.get(i)) * Double.parseDouble(numberList.get(i + 1))));
                numberList.remove(i + 1);
                i -= 1;
            } else if (operationList.get(i).equals("÷")) {
                if (Double.parseDouble(numberList.get(i + 1)) == 0) {
                    resultString = "Error";
                    result.setText(resultString);
                    resultString = "";
                    operationList.clear();
                    numberList.clear();
                    return;
                } else {
                    operationList.remove(i);
                    numberList.set(i, Double.toString(Double.parseDouble(numberList.get(i)) / Double.parseDouble(numberList.get(i + 1))));
                    numberList.remove(i + 1);
                    i -= 1;
                }
            }
        }

        results += Double.parseDouble(numberList.get(0));

        if (operationList.size() != 0) {
            for (int i = 0; i < operationList.size(); i++) {
                if (operationList.get(i).equals("+")) {
                    results += Double.parseDouble(numberList.get(i + 1));
                } else if (operationList.get(i).equals("−")) {
                    results -= Double.parseDouble(numberList.get(i + 1));
                }
            }
        }

        results = (double) Math.round(results * 10) / 10;
        resultString = Double.toString(results);
        result.setText(resultString);

        operationList.clear();
        numberList.clear();
        results = 0;
    }

    public void addOne(MouseEvent e) {
        equationLabel.setText(equationString += "1");
    }

    public void addTwo(MouseEvent e) {
        equationLabel.setText(equationString += "2");
    }

    public void addThree(MouseEvent e) {
        equationLabel.setText(equationString += "3");
    }

    public void addFour(MouseEvent e) {
        equationLabel.setText(equationString += "4");
    }

    public void addFive(MouseEvent e) {
        equationLabel.setText(equationString += "5");
    }

    public void addSix(MouseEvent e) {
        equationLabel.setText(equationString += "6");
    }

    public void addSeven(MouseEvent e) {
        equationLabel.setText(equationString += "7");
    }

    public void addEight(MouseEvent e) {
        equationLabel.setText(equationString += "8");
    }

    public void addNine(MouseEvent e) {
        equationLabel.setText(equationString += "9");
    }

    public void addZero(MouseEvent e) {
        equationLabel.setText(equationString += "0");
    }

    public void addDivide(MouseEvent e) {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "÷");
    }

    public void addTimes(MouseEvent e) {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "*");
    }

    public void addMinus(MouseEvent e) {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "−");
    }

    public void addPlus(MouseEvent e) {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += "+");
    }

    public void addDot(MouseEvent e) {
        if(equationString.length() == 0) {
            return;
        }
        else if (isOp()) {
            removeLast();
        }
        equationLabel.setText(equationString += ".");
    }

    public void ac(MouseEvent e) {
        equationLabel.setText("");
        result.setText("");
        equationString = "";
        results = 0;
    }

    public void bs(MouseEvent e) {
        if (equationString.length() != 0) {
            removeLast();
            equationLabel.setText(equationString);
            results = 0;
        }
    }

    public void ce(MouseEvent e) {

        while (equationString.length() != 0 && !lastChar().equals("÷") && !lastChar().equals("*") && !lastChar().equals("−") && !lastChar().equals("+") && !lastChar().equals(".")) {
            if (equationString.length() != 0) {
                removeLast();
            }
        }
        equationLabel.setText(equationString);
    }

    public void equal(MouseEvent e) {
        dataProcess();
        if (numberList.size() <= 0 || isOp()) {
            operationList.clear();
            numberList.clear();
            results = 0;
            return;
        }

        for (int i = 0; i < operationList.size(); i++) {
            if (operationList.get(i).equals("*")) {
                operationList.remove(i);
                numberList.set(i, Double.toString(Double.parseDouble(numberList.get(i)) * Double.parseDouble(numberList.get(i + 1))));
                numberList.remove(i + 1);
                i -= 1;
            } else if (operationList.get(i).equals("÷")) {
                if (Double.parseDouble(numberList.get(i + 1)) == 0) {
                    resultString = "Error";
                    result.setText(resultString);
                    resultString = "";
                    operationList.clear();
                    numberList.clear();
                    return;
                } else {
                    operationList.remove(i);
                    numberList.set(i, Double.toString(Double.parseDouble(numberList.get(i)) / Double.parseDouble(numberList.get(i + 1))));
                    numberList.remove(i + 1);
                    i -= 1;
                }
            }
        }

        results += Double.parseDouble(numberList.get(0));

        if (operationList.size() != 0) {
            for (int i = 0; i < operationList.size(); i++) {
                if (operationList.get(i).equals("+")) {
                    results += Double.parseDouble(numberList.get(i + 1));
                } else if (operationList.get(i).equals("−")) {
                    results -= Double.parseDouble(numberList.get(i + 1));
                }
            }
        }

        results = (double) Math.round(results * 10) / 10;
        resultString = Double.toString(results);
        result.setText(resultString);

        operationList.clear();
        numberList.clear();
        results = 0;
    }

    private String lastChar() {
        return equationString.substring(equationString.length() - 1);
    }

    private String checkChar(int i) {
        return equationString.substring(i, i + 1);
    }

    private boolean isOp() {
        return lastChar().equals("÷") || lastChar().equals("*") || lastChar().equals("−") || lastChar().equals("+") || lastChar().equals(".");
    }

    private void removeLast() {
        equationString = equationString.substring(0, equationString.length() - 1);
    }

    private void dataProcess() {
        int mark = 0;
        for (int i = 0; i < equationString.length(); i++) {
            if (checkChar(i).equals("÷") || checkChar(i).equals("*") || checkChar(i).equals("−") || checkChar(i).equals("+")) {
                operationList.add(checkChar(i));
                numberList.add(equationString.substring(mark, i));
                mark = i + 1;

            } else if (i == equationString.length() - 1) {
                numberList.add(equationString.substring(mark, i + 1));
            }
        }
    }
}


