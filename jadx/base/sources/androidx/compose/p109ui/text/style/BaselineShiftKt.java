package androidx.compose.p109ui.text.style;

import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, m13886d2 = {"lerp", "Landroidx/compose/ui/text/style/BaselineShift;", "start", "stop", "fraction", "", "lerp-jWV1Mfo", "(FFF)F", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BaselineShiftKt {
    @Stable
    /* JADX INFO: renamed from: lerp-jWV1Mfo, reason: not valid java name */
    public static final float m20754lerpjWV1Mfo(float f, float f4, float f5) {
        return BaselineShift.m20742constructorimpl(MathHelpersKt.lerp(f, f4, f5));
    }
}
