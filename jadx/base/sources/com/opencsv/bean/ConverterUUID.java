package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterUUID extends AbstractCsvConverter {
    private static final String UUID_REGEX_PATTERN = "\\b[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-\\b[0-9a-fA-F]{12}\\b";

    public ConverterUUID(Locale locale) {
        super(UUID.class, null, null, locale);
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (Pattern.matches(UUID_REGEX_PATTERN, strTrim)) {
            return UUID.fromString(strTrim);
        }
        throw new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME).getString("invalid.uuid.value"), str, this.type.getName()));
    }
}
