package org.apache.commons.beanutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ResultSetDynaClass extends JDBCDynaClass {
    private static final long serialVersionUID = 1;
    protected ResultSet resultSet;

    public ResultSetDynaClass(ResultSet resultSet) {
        this(resultSet, true);
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaProperty[] getDynaProperties() {
        return super.getDynaProperties();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaProperty getDynaProperty(String str) {
        return super.getDynaProperty(str);
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public Object getObjectFromResultSet(String str) {
        return getObject(getResultSet(), str);
    }

    public ResultSet getResultSet() {
        return this.resultSet;
    }

    public Iterator<DynaBean> iterator() {
        return new ResultSetIterator(this);
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass
    public Class<?> loadClass(String str) throws SQLException {
        try {
            return getClass().getClassLoader().loadClass(str);
        } catch (Exception e) {
            throw new SQLException("Cannot load column class '" + str + "': " + e);
        }
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaBean newInstance() {
        return super.newInstance();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass
    public /* bridge */ /* synthetic */ void setUseColumnLabel(boolean z) {
        super.setUseColumnLabel(z);
    }

    public ResultSetDynaClass(ResultSet resultSet, boolean z) {
        this(resultSet, z, false);
    }

    public ResultSetDynaClass(ResultSet resultSet, boolean z, boolean z2) throws SQLException {
        Objects.requireNonNull(resultSet, "resultSet");
        this.resultSet = resultSet;
        this.lowerCase = z;
        setUseColumnLabel(z2);
        introspect(resultSet);
    }
}
