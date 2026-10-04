package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;
    private final Map<String, Object> parameters = new ConcurrentHashMap();

    public void clear() {
        this.parameters.clear();
    }

    public Object clone() {
        BasicHttpParams basicHttpParams = (BasicHttpParams) super.clone();
        copyParams(basicHttpParams);
        return basicHttpParams;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams copy() {
        try {
            return (HttpParams) clone();
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("Cloning not supported");
        }
    }

    public void copyParams(HttpParams httpParams) {
        for (Map.Entry<String, Object> entry : this.parameters.entrySet()) {
            httpParams.setParameter(entry.getKey(), entry.getValue());
        }
    }

    @Override // cz.msebera.android.httpclient.params.AbstractHttpParams, cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        return new HashSet(this.parameters.keySet());
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public Object getParameter(String str) {
        return this.parameters.get(str);
    }

    public boolean isParameterSet(String str) {
        return getParameter(str) != null;
    }

    public boolean isParameterSetLocally(String str) {
        return this.parameters.get(str) != null;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean removeParameter(String str) {
        if (!this.parameters.containsKey(str)) {
            return false;
        }
        this.parameters.remove(str);
        return true;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setParameter(String str, Object obj) {
        if (str == null) {
            return this;
        }
        if (obj != null) {
            this.parameters.put(str, obj);
            return this;
        }
        this.parameters.remove(str);
        return this;
    }

    public void setParameters(String[] strArr, Object obj) {
        for (String str : strArr) {
            setParameter(str, obj);
        }
    }

    public String toString() {
        return "[parameters=" + this.parameters + "]";
    }
}
