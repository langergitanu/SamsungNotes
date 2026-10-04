package com.opencsv;

import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
import org.apache.commons.text.TextStringBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultSetHelperService implements ResultSetHelper {
    protected static final int CLOBBUFFERSIZE = 2048;
    static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";
    static final String DEFAULT_TIMESTAMP_FORMAT = "dd-MMM-yyyy HH:mm:ss";
    private static final String NULL_DEFAULT_VALUE = "";
    protected NumberFormat floatingPointFormat;
    protected NumberFormat integerFormat;
    protected String dateFormat = DEFAULT_DATE_FORMAT;
    protected String dateTimeFormat = DEFAULT_TIMESTAMP_FORMAT;
    protected String nullDefault = "";

    private String applyFormatter(NumberFormat numberFormat, Number number) {
        return (numberFormat == null || number == null) ? Objects.toString(number, this.nullDefault) : numberFormat.format(number);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getColumnValue(ResultSet resultSet, int i, int i2, boolean z, String str, String str2) throws SQLException {
        String strHandleNVarChar;
        if (i == -16 || i == -15 || i == -9) {
            strHandleNVarChar = handleNVarChar(resultSet, i2, z);
        } else if (i == -1 || i == 12) {
            strHandleNVarChar = handleVarChar(resultSet, i2, z);
        } else if (i == 16) {
            strHandleNVarChar = Objects.toString(Boolean.valueOf(resultSet.getBoolean(i2)));
        } else if (i == 2005) {
            strHandleNVarChar = handleClob(resultSet, i2);
        } else if (i == 2011) {
            strHandleNVarChar = handleNClob(resultSet, i2);
        } else if (i == -6) {
            strHandleNVarChar = applyFormatter(this.integerFormat, Integer.valueOf(resultSet.getInt(i2)));
        } else if (i != -5) {
            switch (i) {
                case 1:
                    break;
                case 2:
                case 3:
                case 7:
                    strHandleNVarChar = applyFormatter(this.floatingPointFormat, resultSet.getBigDecimal(i2));
                    break;
                case 4:
                case 5:
                    break;
                case 6:
                    strHandleNVarChar = applyFormatter(this.floatingPointFormat, Float.valueOf(resultSet.getFloat(i2)));
                    break;
                case 8:
                    strHandleNVarChar = applyFormatter(this.floatingPointFormat, Double.valueOf(resultSet.getDouble(i2)));
                    break;
                default:
                    switch (i) {
                        case 91:
                            strHandleNVarChar = handleDate(resultSet, i2, str);
                            break;
                        case 92:
                            strHandleNVarChar = Objects.toString(resultSet.getTime(i2), this.nullDefault);
                            break;
                        case 93:
                            strHandleNVarChar = handleTimestamp(resultSet.getTimestamp(i2), str2);
                            break;
                        default:
                            strHandleNVarChar = Objects.toString(resultSet.getObject(i2), this.nullDefault);
                            break;
                    }
                    break;
            }
        } else {
            strHandleNVarChar = applyFormatter(this.integerFormat, resultSet.getBigDecimal(i2));
        }
        return (resultSet.wasNull() || strHandleNVarChar == null) ? this.nullDefault : strHandleNVarChar;
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnNames(ResultSet resultSet) {
        ResultSetMetaData metaData = resultSet.getMetaData();
        String[] strArr = new String[metaData.getColumnCount()];
        int i = 0;
        while (i < metaData.getColumnCount()) {
            int i2 = i + 1;
            strArr[i] = metaData.getColumnLabel(i2);
            i = i2;
        }
        return strArr;
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet) {
        return getColumnValues(resultSet, false, this.dateFormat, this.dateTimeFormat);
    }

    public String handleClob(ResultSet resultSet, int i) throws SQLException {
        String str = this.nullDefault;
        Clob clob = resultSet.getClob(i);
        if (clob == null) {
            return str;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder();
        textStringBuilder.readFrom(clob.getCharacterStream());
        return textStringBuilder.toString();
    }

    public String handleDate(ResultSet resultSet, int i, String str) throws SQLException {
        String str2 = this.nullDefault;
        Date date = resultSet.getDate(i);
        return date != null ? new SimpleDateFormat(str).format((java.util.Date) date) : str2;
    }

    public String handleNClob(ResultSet resultSet, int i) throws SQLException {
        String str = this.nullDefault;
        NClob nClob = resultSet.getNClob(i);
        if (nClob == null) {
            return str;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder();
        textStringBuilder.readFrom(nClob.getCharacterStream());
        return textStringBuilder.toString();
    }

    public String handleNVarChar(ResultSet resultSet, int i, boolean z) throws SQLException {
        String nString = resultSet.getNString(i);
        return (!z || nString == null) ? nString : nString.trim();
    }

    public String handleTimestamp(Timestamp timestamp, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (timestamp == null) {
            return null;
        }
        return simpleDateFormat.format((java.util.Date) timestamp);
    }

    public String handleVarChar(ResultSet resultSet, int i, boolean z) throws SQLException {
        String string = resultSet.getString(i);
        return (!z || string == null) ? string : string.trim();
    }

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setDateTimeFormat(String str) {
        this.dateTimeFormat = str;
    }

    public void setFloatingPointFormat(NumberFormat numberFormat) {
        this.floatingPointFormat = numberFormat;
    }

    public void setIntegerFormat(NumberFormat numberFormat) {
        this.integerFormat = numberFormat;
    }

    public void setNullDefault(String str) {
        this.nullDefault = str;
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z) {
        return getColumnValues(resultSet, z, this.dateFormat, this.dateTimeFormat);
    }

    @Override // com.opencsv.ResultSetHelper
    public String[] getColumnValues(ResultSet resultSet, boolean z, String str, String str2) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        String[] strArr = new String[metaData.getColumnCount()];
        int i = 1;
        while (i <= metaData.getColumnCount()) {
            ResultSet resultSet2 = resultSet;
            strArr[i - 1] = getColumnValue(resultSet2, metaData.getColumnType(i), i, z, str, str2);
            i++;
            resultSet = resultSet2;
        }
        return strArr;
    }
}
