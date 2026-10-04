package androidx.compose.foundation.text.input.internal;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextFieldCoreModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextFieldCoreModifier.kt\nandroidx/compose/foundation/text/input/internal/TextFieldCoreModifierKt\n+ 2 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,627:1\n702#2:628\n149#3:629\n*S KotlinDebug\n*F\n+ 1 TextFieldCoreModifier.kt\nandroidx/compose/foundation/text/input/internal/TextFieldCoreModifierKt\n*L\n587#1:628\n581#1:629\n*E\n"})
public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness = C2256Dp.m20968constructorimpl(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, Rect rect, boolean z, int i) {
        return Rect.copy$default(rect, z ? i - rect.getRight() : rect.getLeft(), 0.0f, (z ? i - rect.getRight() : rect.getLeft()) + density.mo15540roundToPx0680j_4(DefaultCursorThickness), 0.0f, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSpecified(Brush brush) {
        return ((brush instanceof SolidColor) && ((SolidColor) brush).getValue() == 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToNext(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        return (float) (f > 0.0f ? Math.ceil(f) : Math.floor(f));
    }
}
