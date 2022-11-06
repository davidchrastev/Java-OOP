package telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : numbers) {
            if (validationNumber(number)) {
                stringBuilder.append(call()).append(number).append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            if (validationURL(url)) {
                stringBuilder.append(browse()).append(url).append("!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    public boolean validationURL(String urlToCheck) {
        char[] validation = urlToCheck.toCharArray();

        for (char symbol : validation) {
            if (Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    public boolean validationNumber(String numberToCheck) {
        char[] validation = numberToCheck.toCharArray();

        for (char symbol : validation) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

}
