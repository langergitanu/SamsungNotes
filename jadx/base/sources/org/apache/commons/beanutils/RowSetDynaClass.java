package org.apache.commons.beanutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RowSetDynaClass extends JDBCDynaClass {
    private static final long serialVersionUID = 1;
    protected int limit;
    protected List<DynaBean> rows;

    public RowSetDynaClass(ResultSet resultSet) {
        this(resultSet, true, -1);
    }

    public void copy(ResultSet resultSet) {
        int i = 0;
        while (resultSet.next()) {
            int i2 = this.limit;
            if (i2 >= 0) {
                int i4 = i + 1;
                if (i >= i2) {
                    return;
                } else {
                    i = i4;
                }
            }
            DynaBean dynaBeanCreateDynaBean = createDynaBean();
            for (DynaProperty dynaProperty : this.properties) {
                String name = dynaProperty.getName();
                dynaBeanCreateDynaBean.set(name, getObject(resultSet, name));
            }
            this.rows.add(dynaBeanCreateDynaBean);
        }
    }

    public DynaBean createDynaBean() {
        return new BasicDynaBean(this);
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

    public List<DynaBean> getRows() {
        return this.rows;
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass, org.apache.commons.beanutils.DynaClass
    public /* bridge */ /* synthetic */ DynaBean newInstance() {
        return super.newInstance();
    }

    @Override // org.apache.commons.beanutils.JDBCDynaClass
    public /* bridge */ /* synthetic */ void setUseColumnLabel(boolean z) {
        super.setUseColumnLabel(z);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z) {
        this(resultSet, z, -1);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, boolean z2) {
        this(resultSet, z, -1, z2);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, int i) {
        this(resultSet, z, i, false);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z, int i, boolean z2) throws SQLException {
        this.limit = -1;
        this.rows = new ArrayList();
        Objects.requireNonNull(resultSet, "resultSet");
        this.lowerCase = z;
        this.limit = i;
        setUseColumnLabel(z2);
        introspect(resultSet);
        copy(resultSet);
    }

    public RowSetDynaClass(ResultSet resultSet, int i) {
        this(resultSet, true, i);
    }
}
