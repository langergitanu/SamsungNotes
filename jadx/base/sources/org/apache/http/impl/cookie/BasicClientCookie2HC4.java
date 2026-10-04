package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.SetCookie2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class BasicClientCookie2HC4 extends BasicClientCookieHC4 implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private boolean discard;
    private int[] ports;

    public BasicClientCookie2HC4(String str, String str2) {
        super(str, str2);
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookieHC4
    public Object clone() {
        BasicClientCookie2HC4 basicClientCookie2HC4 = (BasicClientCookie2HC4) super.clone();
        int[] iArr = this.ports;
        if (iArr != null) {
            basicClientCookie2HC4.ports = (int[]) iArr.clone();
        }
        return basicClientCookie2HC4;
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public String getCommentURL() {
        return this.commentURL;
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public int[] getPorts() {
        return this.ports;
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public boolean isExpired(Date date) {
        return this.discard || super.isExpired(date);
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean z) {
        this.discard = z;
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setPorts(int[] iArr) {
        this.ports = iArr;
    }
}
