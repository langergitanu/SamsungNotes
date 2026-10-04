package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105J\"\u00106\u001a\u0002072\u0006\u00108\u001a\u0002022\b\b\u0002\u00109\u001a\u00020:ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020:2\u0006\u00103\u001a\u000202ø\u0001\u0000¢\u0006\u0004\b>\u0010?J0\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bH\u0010IJ&\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020:R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR/\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R;\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170&\u0012\u0004\u0012\u00020'\u0018\u00010$¢\u0006\u0002\b(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "()V", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coreNodeCoordinates", "getCoreNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCoreNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "coreNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "setTextLayoutNodeCoordinates", "textLayoutNodeCoordinates$delegate", "coercedInVisibleBoundsOfInputText", "Landroidx/compose/ui/geometry/Offset;", TypedValues.Cycle.S_WAVE_OFFSET, "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release", "(J)J", "getOffsetForPosition", "", "position", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "isPositionOnText-k-4lQ0M", "(J)Z", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "softWrap", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextLayoutState.kt\nandroidx/compose/foundation/text/input/internal/TextLayoutState\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,252:1\n149#2:253\n81#3:254\n81#3:255\n107#3,2:256\n81#3:258\n107#3,2:259\n81#3:261\n107#3,2:262\n81#3:264\n107#3,2:265\n*S KotlinDebug\n*F\n+ 1 TextLayoutState.kt\nandroidx/compose/foundation/text/input/internal/TextLayoutState\n*L\n80#1:253\n46#1:254\n73#1:255\n73#1:256,2\n74#1:258\n74#1:259,2\n75#1:261\n75#1:262,2\n80#1:264\n80#1:265,2\n*E\n"})
public final class TextLayoutState {
    public static final int $stable = 8;

    @NotNull
    private final BringIntoViewRequester bringIntoViewRequester;

    /* JADX INFO: renamed from: coreNodeCoordinates$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState coreNodeCoordinates;

    /* JADX INFO: renamed from: decoratorNodeCoordinates$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState decoratorNodeCoordinates;

    @NotNull
    private TextFieldLayoutStateCache layoutCache;

    /* JADX INFO: renamed from: layoutResult$delegate, reason: from kotlin metadata */
    @NotNull
    private final TextFieldLayoutStateCache layoutResult;

    /* JADX INFO: renamed from: minHeightForSingleLineField$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState minHeightForSingleLineField;

    @Nullable
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;

    /* JADX INFO: renamed from: textLayoutNodeCoordinates$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState textLayoutNodeCoordinates;

    public TextLayoutState() {
        TextFieldLayoutStateCache textFieldLayoutStateCache = new TextFieldLayoutStateCache();
        this.layoutCache = textFieldLayoutStateCache;
        this.layoutResult = textFieldLayoutStateCache;
        this.textLayoutNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.coreNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.decoratorNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.minHeightForSingleLineField = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(0)), null, 2, null);
        this.bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m16382getOffsetForPosition3MmeM6k$default(TextLayoutState textLayoutState, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutState.m16385getOffsetForPosition3MmeM6k(j, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long m16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(long offset) {
        Rect zero;
        LayoutCoordinates textLayoutNodeCoordinates = getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null) {
            zero = Rect.INSTANCE.getZero();
        } else {
            if (textLayoutNodeCoordinates.isAttached()) {
                LayoutCoordinates decoratorNodeCoordinates = getDecoratorNodeCoordinates();
                zero = null;
                if (decoratorNodeCoordinates != null) {
                    zero = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, null);
                }
            } else {
                zero = Rect.INSTANCE.getZero();
            }
            if (zero == null) {
            }
        }
        return TextLayoutStateKt.m16389coerceIn3MmeM6k(offset, zero);
    }

    @NotNull
    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    @Nullable
    public final LayoutCoordinates getCoreNodeCoordinates() {
        return (LayoutCoordinates) this.coreNodeCoordinates.getValue();
    }

    @Nullable
    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        return (LayoutCoordinates) this.decoratorNodeCoordinates.getValue();
    }

    @Nullable
    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m16384getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((C2256Dp) this.minHeightForSingleLineField.getValue()).m20982unboximpl();
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m16385getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return -1;
        }
        if (coerceInVisibleBounds) {
            position = m16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(position);
        }
        return layoutResult.m20428getOffsetForPositionk4lQ0M(TextLayoutStateKt.m16390fromDecorationToTextLayoutUv8p0NA(this, position));
    }

    @Nullable
    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    @Nullable
    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        return (LayoutCoordinates) this.textLayoutNodeCoordinates.getValue();
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m16386isPositionOnTextk4lQ0M(long offset) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        long jM16390fromDecorationToTextLayoutUv8p0NA = TextLayoutStateKt.m16390fromDecorationToTextLayoutUv8p0NA(this, m16383coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(offset));
        int lineForVerticalPosition = layoutResult.getLineForVerticalPosition(Offset.m18285getYimpl(jM16390fromDecorationToTextLayoutUv8p0NA));
        return Offset.m18284getXimpl(jM16390fromDecorationToTextLayoutUv8p0NA) >= layoutResult.getLineLeft(lineForVerticalPosition) && Offset.m18284getXimpl(jM16390fromDecorationToTextLayoutUv8p0NA) <= layoutResult.getLineRight(lineForVerticalPosition);
    }

    @NotNull
    /* JADX INFO: renamed from: layoutWithNewMeasureInputs--hBUhpc, reason: not valid java name */
    public final TextLayoutResult m16387layoutWithNewMeasureInputshBUhpc(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull FontFamily.Resolver fontFamilyResolver, long constraints) {
        TextLayoutResult textLayoutResultM16376layoutWithNewMeasureInputshBUhpc = this.layoutCache.m16376layoutWithNewMeasureInputshBUhpc(density, layoutDirection, fontFamilyResolver, constraints);
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2 = this.onTextLayout;
        if (function2 != null) {
            function2.invoke(density, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.input.internal.TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final TextLayoutResult invoke() {
                    return this.this$0.layoutCache.getValue();
                }
            });
        }
        return textLayoutResultM16376layoutWithNewMeasureInputshBUhpc;
    }

    public final void setCoreNodeCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.coreNodeCoordinates.setValue(layoutCoordinates);
    }

    public final void setDecoratorNodeCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.decoratorNodeCoordinates.setValue(layoutCoordinates);
    }

    /* JADX INFO: renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m16388setMinHeightForSingleLineField0680j_4(float f) {
        this.minHeightForSingleLineField.setValue(C2256Dp.m20966boximpl(f));
    }

    public final void setOnTextLayout(@Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.onTextLayout = function2;
    }

    public final void setTextLayoutNodeCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.textLayoutNodeCoordinates.setValue(layoutCoordinates);
    }

    public final void updateNonMeasureInputs(@NotNull TransformedTextFieldState textFieldState, @NotNull TextStyle textStyle, boolean singleLine, boolean softWrap) {
        this.layoutCache.updateNonMeasureInputs(textFieldState, textStyle, singleLine, softWrap);
    }
}
