package io.netty.handler.codec.spdy;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdySessionStatus implements Comparable<SpdySessionStatus> {
    private final int code;
    private final String statusPhrase;

    /* JADX INFO: renamed from: OK */
    public static final SpdySessionStatus f8935OK = new SpdySessionStatus(0, CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK);
    public static final SpdySessionStatus PROTOCOL_ERROR = new SpdySessionStatus(1, "PROTOCOL_ERROR");
    public static final SpdySessionStatus INTERNAL_ERROR = new SpdySessionStatus(2, "INTERNAL_ERROR");

    public SpdySessionStatus(int i, String str) {
        this.statusPhrase = (String) ObjectUtil.checkNotNull(str, "statusPhrase");
        this.code = i;
    }

    public static SpdySessionStatus valueOf(int i) {
        return i != 0 ? i != 1 ? i != 2 ? new SpdySessionStatus(i, AbstractC0622a.m1167m("UNKNOWN (", i, PropertyUtils.MAPPED_DELIM2)) : INTERNAL_ERROR : PROTOCOL_ERROR : f8935OK;
    }

    public int code() {
        return this.code;
    }

    public boolean equals(Object obj) {
        return (obj instanceof SpdySessionStatus) && code() == ((SpdySessionStatus) obj).code();
    }

    public int hashCode() {
        return code();
    }

    public String statusPhrase() {
        return this.statusPhrase;
    }

    public String toString() {
        return statusPhrase();
    }

    @Override // java.lang.Comparable
    public int compareTo(SpdySessionStatus spdySessionStatus) {
        return code() - spdySessionStatus.code();
    }
}
