package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, m13886d2 = {"charCount", "", "codePoint", "codePointAt", "", "index", "codePointBefore", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CodepointHelpers_jvmKt {
    public static final int charCount(int i) {
        return Character.charCount(i);
    }

    public static final int codePointAt(@NotNull CharSequence charSequence, int i) {
        return Character.codePointAt(charSequence, i);
    }

    public static final int codePointBefore(@NotNull CharSequence charSequence, int i) {
        return Character.codePointBefore(charSequence, i);
    }
}
