package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class JDBCDynaClass implements DynaClass, Serializable {
    private static final long serialVersionUID = 1;
    private Map<String, String> columnNameXref;
    protected DynaProperty[] properties;
    private boolean useColumnLabel;
    protected boolean lowerCase = true;
    protected Map<String, DynaProperty> propertiesMap = new HashMap();

    public DynaProperty createDynaProperty(ResultSetMetaData resultSetMetaData, int i) throws SQLException {
        String columnClassName = null;
        String columnLabel = this.useColumnLabel ? resultSetMetaData.getColumnLabel(i) : null;
        if (columnLabel == null || columnLabel.trim().length() == 0) {
            columnLabel = resultSetMetaData.getColumnName(i);
        }
        String lowerCase = this.lowerCase ? columnLabel.toLowerCase() : columnLabel;
        if (!lowerCase.equals(columnLabel)) {
            if (this.columnNameXref == null) {
                this.columnNameXref = new HashMap();
            }
            this.columnNameXref.put(lowerCase, columnLabel);
        }
        try {
            switch (resultSetMetaData.getColumnType(i)) {
                case 91:
                    return new DynaProperty(lowerCase, Date.class);
                case 92:
                    return new DynaProperty(lowerCase, Time.class);
                case 93:
                    return new DynaProperty(lowerCase, Timestamp.class);
                default:
                    columnClassName = resultSetMetaData.getColumnClassName(i);
                    break;
            }
        } catch (SQLException unused) {
        }
        return new DynaProperty(lowerCase, columnClassName != null ? loadClass(columnClassName) : Object.class);
    }

    public String getColumnName(String str) {
        Map<String, String> map = this.columnNameXref;
        return (map == null || !map.containsKey(str)) ? str : this.columnNameXref.get(str);
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaProperty getDynaProperty(String str) {
        if (str != null) {
            return this.propertiesMap.get(str);
        }
        throw new IllegalArgumentException("No property name specified");
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public String getName() {
        return getClass().getName();
    }

    public Object getObject(ResultSet resultSet, String str) {
        DynaProperty dynaProperty = getDynaProperty(str);
        if (dynaProperty == null) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Invalid name '", str, "'"));
        }
        String columnName = getColumnName(str);
        Class<?> type = dynaProperty.getType();
        return type.equals(Date.class) ? resultSet.getDate(columnName) : type.equals(Timestamp.class) ? resultSet.getTimestamp(columnName) : type.equals(Time.class) ? resultSet.getTime(columnName) : resultSet.getObject(columnName);
    }

    public void introspect(ResultSet resultSet) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            DynaProperty dynaPropertyCreateDynaProperty = createDynaProperty(metaData, i);
            if (dynaPropertyCreateDynaProperty != null) {
                arrayList.add(dynaPropertyCreateDynaProperty);
            }
        }
        DynaProperty[] dynaPropertyArr = (DynaProperty[]) arrayList.toArray(new DynaProperty[arrayList.size()]);
        this.properties = dynaPropertyArr;
        for (DynaProperty dynaProperty : dynaPropertyArr) {
            this.propertiesMap.put(dynaProperty.getName(), dynaProperty);
        }
    }

    public Class<?> loadClass(String str) throws SQLException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return Class.forName(str, false, contextClassLoader);
        } catch (Exception e) {
            throw new SQLException("Cannot load column class '" + str + "': " + e);
        }
    }

    @Override // org.apache.commons.beanutils.DynaClass
    public DynaBean newInstance() {
        throw new UnsupportedOperationException("newInstance() not supported");
    }

    public void setUseColumnLabel(boolean z) {
        this.useColumnLabel = z;
    }
}
