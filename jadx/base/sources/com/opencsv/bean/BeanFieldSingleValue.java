package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.exceptions.CsvBadConverterException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BeanFieldSingleValue<T, I> extends AbstractBeanField<T, I> {
    protected final Pattern capture;
    protected final String writeFormat;

    public BeanFieldSingleValue(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter, String str, String str2) {
        super(cls, field, z, locale, csvConverter);
        this.capture = OpencsvUtils.compilePatternAtLeastOneGroup(str, 0, BeanFieldSingleValue.class, this.errorLocale);
        this.writeFormat = str2;
        OpencsvUtils.verifyFormatString(str2, BeanFieldSingleValue.class, this.errorLocale);
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public Object convert(String str) {
        Pattern pattern = this.capture;
        if (pattern != null && str != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
        }
        CsvConverter csvConverter = this.converter;
        if (csvConverter != null) {
            return csvConverter.convertToRead(str);
        }
        throw new CsvBadConverterException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("no.converter.specified"));
    }

    @Override // com.opencsv.bean.AbstractBeanField
    public String convertToWrite(Object obj) {
        CsvConverter csvConverter = this.converter;
        if (csvConverter == null) {
            throw new CsvBadConverterException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("no.converter.specified"));
        }
        String strConvertToWrite = csvConverter.convertToWrite(obj);
        return (StringUtils.isNotEmpty(this.writeFormat) && StringUtils.isNotEmpty(strConvertToWrite)) ? String.format(this.writeFormat, strConvertToWrite) : strConvertToWrite;
    }
}
