package cz.msebera.android.httpclient.params;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean getBooleanParameter(String str, boolean z) {
        Object parameter = getParameter(str);
        return parameter == null ? z : ((Boolean) parameter).booleanValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public double getDoubleParameter(String str, double d) {
        Object parameter = getParameter(str);
        return parameter == null ? d : ((Double) parameter).doubleValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public int getIntParameter(String str, int i) {
        Object parameter = getParameter(str);
        return parameter == null ? i : ((Integer) parameter).intValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public long getLongParameter(String str, long j) {
        Object parameter = getParameter(str);
        return parameter == null ? j : ((Long) parameter).longValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setBooleanParameter(String str, boolean z) {
        setParameter(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setDoubleParameter(String str, double d) {
        setParameter(str, Double.valueOf(d));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setIntParameter(String str, int i) {
        setParameter(str, Integer.valueOf(i));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setLongParameter(String str, long j) {
        setParameter(str, Long.valueOf(j));
        return this;
    }
}
