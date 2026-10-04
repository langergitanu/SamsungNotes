package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterCurrency extends AbstractCsvConverter {
    public ConverterCurrency(Locale locale) {
        super(Currency.class, null, null, locale);
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        try {
            return Currency.getInstance(str);
        } catch (IllegalArgumentException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.currency.value"), str, this.type.getName()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) {
        if (obj != null) {
            return ((Currency) obj).getCurrencyCode();
        }
        return null;
    }
}
