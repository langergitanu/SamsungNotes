package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¨\u0006\t"}, m13886d2 = {"toCharArray", "", "", RtspHeaders.Values.DESTINATION, "", "destinationOffset", "", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ToCharArray_androidKt {
    public static final void toCharArray(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, int i2, int i4) {
        if (charSequence instanceof TextFieldCharSequence) {
            ((TextFieldCharSequence) charSequence).toCharArray(cArr, i, i2, i4);
            return;
        }
        while (i2 < i4) {
            cArr[i] = charSequence.charAt(i2);
            i2++;
            i++;
        }
    }
}
