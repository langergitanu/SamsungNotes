package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class HeaderNameBaseMappingStrategy<T> extends AbstractMappingStrategy<String, String, ComplexFieldMapEntry<String, String, T>, T> {
    protected FieldMapByName<T> fieldMap;
    protected final boolean forceCorrectRecordLength;
    protected Comparator<String> writeOrder;

    public HeaderNameBaseMappingStrategy() {
        this.fieldMap = null;
        this.writeOrder = null;
        this.forceCorrectRecordLength = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadUnadornedFieldMap$0(Map.Entry entry) {
        return (Serializable.class.isAssignableFrom((Class) entry.getKey()) && "serialVersionUID".equals(((Field) entry.getValue()).getName())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadUnadornedFieldMap$1(Map.Entry entry) {
        return !((Field) entry.getValue()).isAnnotationPresent(CsvRecurse.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUnadornedFieldMap$2(Map.Entry entry) {
        this.fieldMap.put(((Field) entry.getValue()).getName().toUpperCase(), new BeanFieldSingleValue((Class) entry.getKey(), (Field) entry.getValue(), false, this.errorLocale, determineConverter((Field) entry.getValue(), ((Field) entry.getValue()).getType(), null, null, null), null, null));
    }

    @Override // com.opencsv.bean.MappingStrategy
    public void captureHeader(CSVReader cSVReader) throws CsvRequiredFieldEmptyException {
        if (this.type == null) {
            throw new IllegalStateException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("type.unset"));
        }
        String[] strArrNullToEmpty = ArrayUtils.nullToEmpty(cSVReader.readNextSilently());
        for (int i = 0; i < strArrNullToEmpty.length; i++) {
            if (strArrNullToEmpty[i] == null) {
                strArrNullToEmpty[i] = "";
            }
        }
        this.headerIndex.initializeHeaderIndex(strArrNullToEmpty);
        List<FieldMapByNameEntry<T>> listDetermineMissingRequiredHeaders = this.fieldMap.determineMissingRequiredHeaders(strArrNullToEmpty);
        if (listDetermineMissingRequiredHeaders.isEmpty()) {
            return;
        }
        String[] strArr = new String[listDetermineMissingRequiredHeaders.size()];
        ArrayList arrayList = new ArrayList(listDetermineMissingRequiredHeaders.size());
        for (int i2 = 0; i2 < listDetermineMissingRequiredHeaders.size(); i2++) {
            FieldMapByNameEntry<T> fieldMapByNameEntry = listDetermineMissingRequiredHeaders.get(i2);
            if (fieldMapByNameEntry.isRegexPattern()) {
                strArr[i2] = String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("matching"), fieldMapByNameEntry.getName());
            } else {
                strArr[i2] = fieldMapByNameEntry.getName();
            }
            arrayList.add(fieldMapByNameEntry.getField().getField());
        }
        CsvRequiredFieldEmptyException csvRequiredFieldEmptyException = new CsvRequiredFieldEmptyException(this.type, arrayList, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.required.field.absent"), String.join(SQLKeyword.COMMA, strArr), String.join(",", strArrNullToEmpty)));
        csvRequiredFieldEmptyException.setLine(strArrNullToEmpty);
        throw csvRequiredFieldEmptyException;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public BeanField<T, String> findField(int i) {
        String columnName = getColumnName(i);
        if (columnName == null) {
            return null;
        }
        String strTrim = columnName.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return this.fieldMap.get(strTrim.toUpperCase());
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String findHeader(int i) {
        return this.headerIndex.getByPosition(i);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public FieldMap<String, String, ? extends ComplexFieldMapEntry<String, String, T>, T> getFieldMap() {
        return this.fieldMap;
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void initializeFieldMap() {
        FieldMapByName<T> fieldMapByName = new FieldMapByName<>(this.errorLocale);
        this.fieldMap = fieldMapByName;
        fieldMapByName.setColumnOrderOnWrite(this.writeOrder);
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void loadUnadornedFieldMap(ListValuedMap<Class<?>, Field> listValuedMap) {
        listValuedMap.entries().stream().filter(new C6621d(4)).filter(new C6621d(5)).forEach(new C6616a(this, 3));
    }

    public void setColumnOrderOnWrite(Comparator<String> comparator) {
        this.writeOrder = comparator;
        FieldMapByName<T> fieldMapByName = this.fieldMap;
        if (fieldMapByName != null) {
            fieldMapByName.setColumnOrderOnWrite(comparator);
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public void verifyLineLength(int i) throws CsvRequiredFieldEmptyException {
        if (!this.headerIndex.isEmpty() && i != this.headerIndex.getHeaderIndexLength() && !this.forceCorrectRecordLength) {
            throw new CsvRequiredFieldEmptyException(this.type, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch"));
        }
    }

    @Override // com.opencsv.bean.AbstractMappingStrategy
    public String chooseMultivaluedFieldIndexFromHeaderIndex(int i) {
        String[] headerIndex = this.headerIndex.getHeaderIndex();
        if (i >= headerIndex.length) {
            return null;
        }
        return headerIndex[i];
    }

    public HeaderNameBaseMappingStrategy(boolean z) {
        this.fieldMap = null;
        this.writeOrder = null;
        this.forceCorrectRecordLength = z;
    }
}
