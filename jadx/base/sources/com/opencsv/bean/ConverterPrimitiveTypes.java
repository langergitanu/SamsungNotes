package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.locale.LocaleConvertUtilsBean;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterPrimitiveTypes extends AbstractCsvConverter {
    protected final ConvertUtilsBean readConverter;
    protected final LocaleConvertUtilsBean readLocaleConverter;
    protected final ConvertUtilsBean writeConverter;
    protected final LocaleConvertUtilsBean writeLocaleConverter;

    public ConverterPrimitiveTypes(Class<?> cls, String str, String str2, Locale locale) {
        super(cls, str, str2, locale);
        if (this.locale == null) {
            ConvertUtilsBean convertUtils = BeanUtilsBean.getInstance().getConvertUtils();
            this.readConverter = convertUtils;
            convertUtils.register(true, false, 0);
            this.readLocaleConverter = null;
        } else {
            LocaleConvertUtilsBean localeConvertUtilsBean = new LocaleConvertUtilsBean();
            this.readLocaleConverter = localeConvertUtilsBean;
            localeConvertUtilsBean.setDefaultLocale(this.locale);
            this.readConverter = null;
        }
        if (this.writeLocale == null) {
            ConvertUtilsBean convertUtils2 = BeanUtilsBean.getInstance().getConvertUtils();
            this.writeConverter = convertUtils2;
            convertUtils2.register(true, false, 0);
            this.writeLocaleConverter = null;
            return;
        }
        LocaleConvertUtilsBean localeConvertUtilsBean2 = new LocaleConvertUtilsBean();
        this.writeLocaleConverter = localeConvertUtilsBean2;
        localeConvertUtilsBean2.setDefaultLocale(this.writeLocale);
        this.writeConverter = null;
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Object objConvert;
        Object objConvert2;
        if (!StringUtils.isNotBlank(str) && (str == null || !this.type.equals(String.class))) {
            return null;
        }
        try {
            ConvertUtilsBean convertUtilsBean = this.readConverter;
            if (convertUtilsBean != null) {
                synchronized (convertUtilsBean) {
                    objConvert2 = this.readConverter.convert(str, this.type);
                }
                return objConvert2;
            }
            synchronized (this.readLocaleConverter) {
                objConvert = this.readLocaleConverter.convert(str, this.type);
            }
            return objConvert;
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("conversion.impossible"), str, this.type.getCanonicalName()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
        CsvDataTypeMismatchException csvDataTypeMismatchException2 = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("conversion.impossible"), str, this.type.getCanonicalName()));
        csvDataTypeMismatchException2.initCause(e);
        throw csvDataTypeMismatchException2;
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) throws CsvDataTypeMismatchException {
        String strConvert;
        String strConvert2;
        if (obj == null) {
            return null;
        }
        try {
            ConvertUtilsBean convertUtilsBean = this.writeConverter;
            if (convertUtilsBean != null) {
                synchronized (convertUtilsBean) {
                    strConvert2 = this.writeConverter.convert(obj);
                }
                return strConvert2;
            }
            synchronized (this.writeLocaleConverter) {
                strConvert = this.writeLocaleConverter.convert(obj);
            }
            return strConvert;
        } catch (ConversionException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("field.not.primitive"));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
        CsvDataTypeMismatchException csvDataTypeMismatchException2 = new CsvDataTypeMismatchException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("field.not.primitive"));
        csvDataTypeMismatchException2.initCause(e);
        throw csvDataTypeMismatchException2;
    }
}
