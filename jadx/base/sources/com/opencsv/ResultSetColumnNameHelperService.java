package com.opencsv;

import com.microsoft.identity.common.java.storage.C6438a;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultSetColumnNameHelperService extends ResultSetHelperService implements ResultSetHelper {
    private String[] columnHeaders;
    private String[] columnNames;
    private final Map<String, Integer> columnNamePositionMap = new HashMap();
    private Locale errorLocale = Locale.getDefault();

    private String[] getColumnValueSubset(String[] strArr) {
        return (String[]) ((List) Stream.of((Object[]) this.columnNames).map(new C6438a(this, strArr, 1)).collect(Collectors.toList())).toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    private boolean hasInvalidValue(String[] strArr) {
        return Stream.of((Object[]) strArr).anyMatch(new C0233e(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getColumnValueSubset$1(String[] strArr, String str) {
        return strArr[this.columnNamePositionMap.get(str).intValue()];
    }

    private void populateColumnData(ResultSet resultSet) {
        String[] columnNames = super.getColumnNames(resultSet);
        if (this.columnNames == null) {
            this.columnNames = (String[]) Arrays.copyOf(columnNames, columnNames.length);
            this.columnHeaders = (String[]) Arrays.copyOf(columnNames, columnNames.length);
        }
        for (String str : this.columnNames) {
            int iIndexOf = ArrayUtils.indexOf(columnNames, str);
            if (iIndexOf == -1) {
                throw new UnsupportedOperationException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("column.nonexistant"), str));
            }
            this.columnNamePositionMap.put(str, Integer.valueOf(iIndexOf));
        }
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnNames(ResultSet resultSet) {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        String[] strArr = this.columnHeaders;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet) {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, false, this.dateFormat, this.dateTimeFormat));
    }

    public void setColumnNames(String[] strArr, String[] strArr2) {
        if (strArr2.length != strArr.length) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("column.count.mismatch"));
        }
        if (hasInvalidValue(strArr)) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("column.name.bogus"));
        }
        if (hasInvalidValue(strArr2)) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.name.bogus"));
        }
        this.columnNames = (String[]) Arrays.copyOf(strArr, strArr.length);
        this.columnHeaders = (String[]) Arrays.copyOf(strArr2, strArr2.length);
    }

    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z) {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, z, this.dateFormat, this.dateTimeFormat));
    }

    @Override // com.opencsv.ResultSetHelperService, com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z, String str, String str2) {
        if (this.columnNamePositionMap.isEmpty()) {
            populateColumnData(resultSet);
        }
        return getColumnValueSubset(super.getColumnValues(resultSet, z, str, str2));
    }
}
