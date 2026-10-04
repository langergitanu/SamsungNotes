package cz.msebera.android.httpclient.params;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class HttpConnectionParamBean extends HttpAbstractParamBean {
    public HttpConnectionParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setConnectionTimeout(int i) {
        HttpConnectionParams.setConnectionTimeout(this.params, i);
    }

    public void setLinger(int i) {
        HttpConnectionParams.setLinger(this.params, i);
    }

    public void setSoTimeout(int i) {
        HttpConnectionParams.setSoTimeout(this.params, i);
    }

    public void setSocketBufferSize(int i) {
        HttpConnectionParams.setSocketBufferSize(this.params, i);
    }

    public void setStaleCheckingEnabled(boolean z) {
        HttpConnectionParams.setStaleCheckingEnabled(this.params, z);
    }

    public void setTcpNoDelay(boolean z) {
        HttpConnectionParams.setTcpNoDelay(this.params, z);
    }
}
