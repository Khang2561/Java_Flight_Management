package CustomUI;

import javax.swing.table.DefaultTableCellRenderer;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private final NumberFormat currencyFormat;

    public CurrencyTableCellRenderer() {
        super();
        // Set the currency format for Vietnamese Dong
        currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        setHorizontalAlignment(CENTER); // Center align the content
    }

    @Override
    protected void setValue(Object value) {
        if (value instanceof Number) {
            value = currencyFormat.format(value);
        }
        super.setValue(value);
    }
}
