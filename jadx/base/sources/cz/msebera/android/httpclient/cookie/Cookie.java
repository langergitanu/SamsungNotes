package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.annotation.Obsolete;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Cookie {
    @Obsolete
    String getComment();

    @Obsolete
    String getCommentURL();

    String getDomain();

    Date getExpiryDate();

    String getName();

    String getPath();

    @Obsolete
    int[] getPorts();

    String getValue();

    @Obsolete
    int getVersion();

    boolean isExpired(Date date);

    boolean isPersistent();

    boolean isSecure();
}
