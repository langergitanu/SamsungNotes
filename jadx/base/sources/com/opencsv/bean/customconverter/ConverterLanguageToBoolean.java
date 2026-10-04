package com.opencsv.bean.customconverter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.ResourceBundle;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ConverterLanguageToBoolean<T, I> extends AbstractBeanField<T, I> {
    @Override // com.opencsv.bean.AbstractBeanField
    public Object convert(String str) throws CsvDataTypeMismatchException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new BooleanConverter(getAllLocalizedTrueValues(), getAllLocalizedFalseValues()).convert(Boolean.class, str.trim());
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.field.getType(), ResourceBundle.getBundle("convertLanguageToBoolean", this.errorLocale).getString("input.not.boolean"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        if (obj == null) {
            return "";
        }
        try {
            return ((Boolean) obj).booleanValue() ? getLocalizedTrue() : getLocalizedFalse();
        } catch (ClassCastException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(ResourceBundle.getBundle("convertLanguageToBoolean", this.errorLocale).getString("field.not.boolean"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    public abstract String[] getAllLocalizedFalseValues();

    public abstract String[] getAllLocalizedTrueValues();

    public abstract String getLocalizedFalse();

    public abstract String getLocalizedTrue();
}
