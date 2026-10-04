package androidx.appcompat.oneui.common.internal.util;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Landroidx/appcompat/oneui/common/internal/util/MaxFontScaleRatio;", "", "ratio", "", "(Ljava/lang/String;IF)V", "getRatio", "()F", "SMALL", "MEDIUM", "LARGE", "EXTRA_LARGE", "HUGE", "EXTRA_HUGE", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum MaxFontScaleRatio {
    SMALL(1.0f),
    MEDIUM(1.15f),
    LARGE(1.3f),
    EXTRA_LARGE(1.5f),
    HUGE(1.7f),
    EXTRA_HUGE(2.0f);

    private final float ratio;

    MaxFontScaleRatio(float f) {
        this.ratio = f;
    }

    public final float getRatio() {
        return this.ratio;
    }
}
