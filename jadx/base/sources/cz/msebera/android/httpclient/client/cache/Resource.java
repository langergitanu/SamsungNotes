package cz.msebera.android.httpclient.client.cache;

import java.io.InputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Resource extends Serializable {
    void dispose();

    InputStream getInputStream();

    long length();
}
