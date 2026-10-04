package com.opencsv.exceptions;

import com.opencsv.ICSVParser;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvBeanIntrospectionException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final transient Object bean;
    private final transient Field field;

    public CsvBeanIntrospectionException() {
        this.bean = null;
        this.field = null;
    }

    private String getMessageFromLocale(Locale locale) {
        String message = super.getMessage();
        return (message != null || getBean() == null || getField() == null) ? message : String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("error.introspecting.field"), getField().getName(), getBean().getClass().getCanonicalName());
    }

    public Object getBean() {
        return this.bean;
    }

    public Field getField() {
        return this.field;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getMessageFromLocale(Locale.getDefault());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getMessageFromLocale(Locale.US);
    }

    public CsvBeanIntrospectionException(String str) {
        super(str);
        this.bean = null;
        this.field = null;
    }

    public CsvBeanIntrospectionException(Object obj, Field field) {
        this.bean = obj;
        this.field = field;
    }

    public CsvBeanIntrospectionException(Object obj, Field field, String str) {
        super(str);
        this.bean = obj;
        this.field = field;
    }
}
