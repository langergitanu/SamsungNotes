package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NoHttpResponseException extends IOException {
    private static final long serialVersionUID = -7658940387386078766L;

    public NoHttpResponseException(String str) {
        super(HttpException.clean(str));
    }
}
