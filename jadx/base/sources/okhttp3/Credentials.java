package okhttp3;

import androidx.appcompat.widget.AbstractC0541b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, StandardCharsets.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        return AbstractC0541b.m772n("Basic ", ByteString.encodeString(str + ":" + str2, charset).base64());
    }
}
