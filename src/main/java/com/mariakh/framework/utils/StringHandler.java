package com.mariakh.framework.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class StringHandler {

    public static String getFormattedString(String value) {
        BigDecimal v = new BigDecimal(value);
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(v.longValue());
    }

    public static String cleanString(String string) {
        return string.replaceAll("[^\\d,]","");
    }
}
