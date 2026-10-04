package androidx.compose.foundation.text.handwriting;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0000\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"isStylusHandwritingSupported", "", "()Z", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StylusHandwriting_androidKt {
    private static final boolean isStylusHandwritingSupported;

    static {
        isStylusHandwritingSupported = Build.VERSION.SDK_INT >= 34;
    }

    public static final boolean isStylusHandwritingSupported() {
        return isStylusHandwritingSupported;
    }
}
