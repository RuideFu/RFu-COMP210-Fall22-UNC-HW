package assn02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDateTime _dateTime; // date and time
    private final String _category; // category of the products
    private final float _price;  // unit price
    private final int _quantity; // quantity of units
    private final float _rating; // user rating: 0.0 - 5.0
    private final int _duration; // duration of days for shipping

    // constructor, string format: MM/DD/YY, HH:MM, Category, Price, Quantity, Rating, Duration
    public Transaction(String inputString) {
        String[] inputs = inputString.split(" ");
        if (inputs.length != 7) {
            throw new IllegalArgumentException("Wrong format of transaction input!");
        }
        DateTimeFormatter inputPattern = DateTimeFormatter.ofPattern("M/d/yy,H:mm");
        _dateTime = LocalDateTime.parse(inputs[0] + ","+inputs[1], inputPattern);
        _category = inputs[2];
        _price = Float.parseFloat(inputs[3]);
        _quantity = Integer.parseInt(inputs[4]);
        _rating = Float.parseFloat(inputs[5]);
        _duration = Integer.parseInt(inputs[6]);
        if (_rating < 0 || _rating > 5) {
            throw new IllegalArgumentException("Rating has to be between 0.0 to 5.0!");
        }
    }

    public String get_date(){
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("M/d/yy");
        return _dateTime.format(datePattern);
    }

    public String get_time(){
        DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("HH:mm");
        return _dateTime.format(timePattern);
    }

    public String get_dateTime(){
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("M/d/yy HH:mm");
        return _dateTime.format(dateTimePattern);
    }

    public String get_category() {
        return _category;
    }

    public float get_price() {
        return _price;
    }

    public int get_quantity() {
        return _quantity;
    }

    public float get_rating() {
        return _rating;
    }

    public int get_duration() {
        return _duration;
    }

    public String toString(){
        String result = "";
        result += "Date: " + get_date() + "\n";
        result += "Time: " + get_time() + "\n";
        result += "When: " + get_dateTime() + "\n";
        result += "Category: " + get_category() + "\n";
        result += "Price: " + get_price() + "\n";
        result += "Quantity: " + get_quantity() + "\n";
        result += "Rating: " + get_rating() + "\n";
        result += "Duration: " + get_duration();
        return result;
    }
}
