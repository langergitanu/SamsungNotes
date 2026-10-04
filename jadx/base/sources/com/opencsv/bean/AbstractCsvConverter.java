package com.opencsv.bean;

import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCsvConverter implements CsvConverter {
    protected Locale errorLocale;
    protected Locale locale;
    protected Class<?> type;
    protected Locale writeLocale;

    public AbstractCsvConverter() {
        this.type = null;
        this.locale = null;
        this.writeLocale = null;
        this.errorLocale = Locale.getDefault();
    }

    @Override // com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) {
        return Objects.toString(obj, "");
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setLocale(String str) {
        this.locale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setType(Class<?> cls) {
        this.type = cls;
    }

    @Override // com.opencsv.bean.CsvConverter
    public void setWriteLocale(String str) {
        this.writeLocale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
    }

    public AbstractCsvConverter(Class<?> cls, String str, String str2, Locale locale) {
        this.type = cls;
        this.locale = StringUtils.isNotEmpty(str) ? Locale.forLanguageTag(str) : null;
        this.writeLocale = StringUtils.isNotEmpty(str2) ? Locale.forLanguageTag(str2) : null;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }
}
