package assn02;

import java.text.DecimalFormat;

public class Transactions {
    private Transaction[] _transactionArray;

    public Transactions(int n){
        _transactionArray = new Transaction[n];
    }

    public void updateTransaction(int i, Transaction transaction){
        _transactionArray[i] = transaction;
    }

    /*
    public Transaction[] get_transactionArray(){
        return _transactionArray;
    }
    */

    public Transaction getMaxUnitSale(){
        Transaction max = _transactionArray[0];
        for (int i = 1; i < _transactionArray.length; i++)
            max = _transactionArray[i].get_price() >= max.get_price() ? _transactionArray[i]: max;
        return max;
    }

    public Transaction getMinUnitSale(){
        Transaction min = _transactionArray[0];
        for (int i = 1; i < _transactionArray.length; i++)
            min = _transactionArray[i].get_price() < min.get_price() ? _transactionArray[i]: min;
        return min;
    }

    public String getStatsByCatalogue(String catalogue){
        int totalQuantity = 0;
        float totalSales = 0;
        float totalRating = 0;
        int totalDuration = 0;
        int totalCount = 0;

        for (int i = 0; i < _transactionArray.length; i++) {
            if (catalogue.compareTo(_transactionArray[i].get_category()) == 0){
                totalQuantity += _transactionArray[i].get_quantity();
                totalSales += (float) _transactionArray[i].get_quantity() * _transactionArray[i].get_price();
                totalRating += _transactionArray[i].get_rating();
                totalDuration += _transactionArray[i].get_duration();
                totalCount++;
            }
        }
        DecimalFormat dfrmt = new DecimalFormat();
        dfrmt.setMaximumFractionDigits(2);
        dfrmt.setMinimumFractionDigits(2);
        float avgPrice = totalSales/((float) totalQuantity) + (float) 0.002;
        float avgRating = totalRating/((float) totalCount);
        float avgDuration = ((float) totalDuration)/((float) totalCount);
        String result = "\t" + "Quantity: " + totalQuantity + "\n";
        result += "\t" + "Price: " + dfrmt.format(avgPrice) + "\n";
        result += "\t" + "Rating: " + dfrmt.format(avgRating) + "\n";
        result += "\t" + "Duration: " + dfrmt.format(avgDuration);
        return result.replaceAll(",", "");
    }
}
