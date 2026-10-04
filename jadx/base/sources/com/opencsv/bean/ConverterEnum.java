package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterEnum extends AbstractCsvConverter {
    public ConverterEnum(Class<?> cls, String str, String str2, Locale locale) {
        super(cls, str, str2, locale);
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        Enum enumIgnoreCase = EnumUtils.getEnumIgnoreCase(this.type, str);
        if (enumIgnoreCase != null) {
            return enumIgnoreCase;
        }
        throw new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("illegal.enum.value"), str, this.type.getName()));
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) {
        return obj != null ? ((Enum) obj).name() : "";
    }
}
