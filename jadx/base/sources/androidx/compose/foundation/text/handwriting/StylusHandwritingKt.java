package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003¨\u0006\r"}, m13886d2 = {"HandwritingBoundsHorizontalOffset", "Landroidx/compose/ui/unit/Dp;", "getHandwritingBoundsHorizontalOffset", "()F", TokenizerME.NO_SPLIT, "HandwritingBoundsVerticalOffset", "getHandwritingBoundsVerticalOffset", "stylusHandwriting", "Landroidx/compose/ui/Modifier;", "enabled", "", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStylusHandwriting.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StylusHandwriting.kt\nandroidx/compose/foundation/text/handwriting/StylusHandwritingKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,223:1\n149#2:224\n149#2:225\n*S KotlinDebug\n*F\n+ 1 StylusHandwriting.kt\nandroidx/compose/foundation/text/handwriting/StylusHandwritingKt\n*L\n221#1:224\n222#1:225\n*E\n"})
public final class StylusHandwritingKt {
    private static final float HandwritingBoundsVerticalOffset = C2256Dp.m20968constructorimpl(40);
    private static final float HandwritingBoundsHorizontalOffset = C2256Dp.m20968constructorimpl(10);

    public static final float getHandwritingBoundsHorizontalOffset() {
        return HandwritingBoundsHorizontalOffset;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return HandwritingBoundsVerticalOffset;
    }

    @NotNull
    public static final Modifier stylusHandwriting(@NotNull Modifier modifier, boolean z, @NotNull Function0<Boolean> function0) {
        return (z && StylusHandwriting_androidKt.isStylusHandwritingSupported()) ? PaddingKt.m15855paddingVpY3zN4(modifier.then(new StylusHandwritingElementWithNegativePadding(function0)), HandwritingBoundsHorizontalOffset, HandwritingBoundsVerticalOffset) : modifier;
    }
}
