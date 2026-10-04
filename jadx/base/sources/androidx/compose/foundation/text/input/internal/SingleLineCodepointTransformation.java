package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/SingleLineCodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "()V", "CARRIAGE_RETURN", "", "LINE_FEED", "WHITESPACE", "ZERO_WIDTH_SPACE", "toString", "", "transform", "codepointIndex", "codepoint", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SingleLineCodepointTransformation implements CodepointTransformation {
    public static final int $stable = 0;
    private static final int CARRIAGE_RETURN = 13;

    @NotNull
    public static final SingleLineCodepointTransformation INSTANCE = new SingleLineCodepointTransformation();
    private static final int LINE_FEED = 10;
    private static final int WHITESPACE = 32;
    private static final int ZERO_WIDTH_SPACE = 65279;

    private SingleLineCodepointTransformation() {
    }

    @NotNull
    public String toString() {
        return "SingleLineCodepointTransformation";
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public int transform(int codepointIndex, int codepoint) {
        if (codepoint == 10) {
            return 32;
        }
        return codepoint == 13 ? ZERO_WIDTH_SPACE : codepoint;
    }
}
