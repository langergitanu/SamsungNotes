package cz.msebera.android.httpclient.message;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NameValuePair) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
            if (this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb = new StringBuilder(this.value.length() + this.name.length() + 1);
        sb.append(this.name);
        sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        sb.append(this.value);
        return sb.toString();
    }
}
