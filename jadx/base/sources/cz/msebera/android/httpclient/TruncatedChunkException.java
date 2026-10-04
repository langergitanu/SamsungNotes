package cz.msebera.android.httpclient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = -23506263930279460L;

    public TruncatedChunkException(String str) {
        super(str);
    }

    public TruncatedChunkException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }
}
