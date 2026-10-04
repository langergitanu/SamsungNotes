package org.apache.commons.beanutils;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ResultSetIterator implements DynaBean, Iterator<DynaBean> {
    protected boolean current;
    protected ResultSetDynaClass dynaClass;
    protected boolean eof;

    public ResultSetIterator(ResultSetDynaClass resultSetDynaClass) {
        this.dynaClass = resultSetDynaClass;
    }

    public void advance() {
        if (this.current || this.eof) {
            return;
        }
        if (this.dynaClass.getResultSet().next()) {
            this.current = true;
            this.eof = false;
        } else {
            this.current = false;
            this.eof = true;
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        if (this.dynaClass.getDynaProperty(str) == null) {
            throw new IllegalArgumentException(str);
        }
        try {
            return this.dynaClass.getObjectFromResultSet(str);
        } catch (SQLException e) {
            throw new IllegalArgumentException("get(" + str + "): SQLException: " + e, e);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            advance();
            return !this.eof;
        } catch (SQLException e) {
            throw new IllegalStateException("hasNext():  SQLException:  " + e, e);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove()");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, int i, Object obj) {
        throw new UnsupportedOperationException("FIXME - indexed properties not currently supported");
    }

    @Override // java.util.Iterator
    public DynaBean next() {
        try {
            advance();
            if (this.eof) {
                throw new NoSuchElementException();
            }
            this.current = false;
            return this;
        } catch (SQLException e) {
            throw new IllegalStateException("next():  SQLException:  " + e, e);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped operations not currently supported");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        if (this.dynaClass.getDynaProperty(str) == null) {
            throw new IllegalArgumentException(str);
        }
        try {
            this.dynaClass.getResultSet().updateObject(str, obj);
        } catch (SQLException e) {
            throw new IllegalArgumentException("set(" + str + "): SQLException: " + e, e);
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, int i) {
        throw new UnsupportedOperationException("FIXME - indexed properties not currently supported");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }
}
