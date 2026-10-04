package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.input.OffsetMapping;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b)\b \u0018\u0000 a*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001aB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u00101\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\r\u00103\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020&J\r\u00105\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\u0006\u00106\u001a\u00020&J\r\u00107\u001a\u0004\u0018\u00010&¢\u0006\u0002\u00102J\b\u00108\u001a\u000209H\u0002J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010;\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010=\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\r\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010A\u001a\u00028\u0000¢\u0006\u0002\u00100J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010J\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010N\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020&H\u0004J\b\u0010R\u001a\u00020&H\u0002J\b\u0010S\u001a\u00020&H\u0002J\b\u0010T\u001a\u00020&H\u0002J;\u0010U\u001a\u00028\u0000\"\u0004\b\u0001\u0010V*\u0002HV2\b\b\u0002\u0010W\u001a\u0002092\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0084\b¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0002J\u0016\u0010\\\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0002J\u0017\u0010]\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0082\u0010J\u0017\u0010^\u001a\u00020&*\u00020\b2\b\b\u0002\u0010[\u001a\u00020&H\u0082\u0010J\u0014\u0010_\u001a\u00020&*\u00020\b2\u0006\u0010`\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u00020\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", TypedValues.Cycle.S_WAVE_OFFSET, "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deselect", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "()Ljava/lang/Integer;", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextPreparedSelection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/selection/BaseTextPreparedSelection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n73#1,8:438\n73#1,8:446\n73#1,8:454\n73#1,8:462\n73#1,8:470\n73#1,8:478\n73#1,8:486\n73#1,8:494\n73#1,8:502\n73#1,8:510\n73#1,8:518\n73#1,8:526\n73#1,6:534\n80#1:541\n73#1,8:542\n73#1,8:550\n73#1,8:558\n74#1,7:566\n74#1,7:573\n73#1,8:580\n73#1,8:588\n73#1,8:596\n73#1,8:604\n74#1,7:612\n1#2:540\n*S KotlinDebug\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/selection/BaseTextPreparedSelection\n*L\n91#1:438,8\n95#1:446,8\n99#1:454,8\n107#1:462,8\n118#1:470,8\n134#1:478,8\n158#1:486,8\n163#1:494,8\n168#1:502,8\n172#1:510,8\n176#1:518,8\n184#1:526,8\n194#1:534,6\n194#1:541\n200#1:542,8\n204#1:550,8\n212#1:558,8\n220#1:566,7\n224#1:573,7\n230#1:580,8\n236#1:588,8\n240#1:596,8\n248#1:604,8\n257#1:612,7\n*E\n"})
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int NoCharacterFound = -1;

    @NotNull
    private AnnotatedString annotatedString;

    @Nullable
    private final TextLayoutResult layoutResult;

    @NotNull
    private final OffsetMapping offsetMapping;
    private final long originalSelection;

    @NotNull
    private final AnnotatedString originalText;
    private long selection;

    @NotNull
    private final TextPreparedSelectionState state;
    public static final int $stable = 8;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection baseTextPreparedSelection, Object obj, boolean z, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            baseTextPreparedSelection.getState().resetCachedX();
        }
        if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
            function1.invoke(obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) obj;
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, getText$foundation_release().length() - 1);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true));
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMaxOffset();
        }
        return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i)));
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMinOffset();
        }
        return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.originalText.length()) {
            long jM20430getWordBoundaryjx7JFs = textLayoutResult.m20430getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m20451getEndimpl(jM20430getWordBoundaryjx7JFs) > i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m20451getEndimpl(jM20430getWordBoundaryjx7JFs));
            }
            i++;
        }
        return this.originalText.length();
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long jM20430getWordBoundaryjx7JFs = textLayoutResult.m20430getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m20456getStartimpl(jM20430getWordBoundaryjx7JFs) < i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m20456getStartimpl(jM20430getWordBoundaryjx7JFs));
            }
            i--;
        }
        return 0;
    }

    public static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i2 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null) != ResolvedTextDirection.Rtl;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int iTransformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(iTransformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(iTransformedEndOffset) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        float fFloatValue = cachedX.floatValue();
        if ((isLtr() && fFloatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && fFloatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m20428getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX.floatValue(), lineBottom)));
    }

    private final T moveCursorNext() {
        int nextCharacterIndex;
        if (AbstractC1038a.m1204e(this) > 0 && (nextCharacterIndex = getNextCharacterIndex()) != -1) {
            setCursor(nextCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorNextByWord() {
        Integer nextWordOffset;
        if (AbstractC1038a.m1204e(this) > 0 && (nextWordOffset = getNextWordOffset()) != null) {
            setCursor(nextWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrev() {
        int precedingCharacterIndex;
        if (AbstractC1038a.m1204e(this) > 0 && (precedingCharacterIndex = getPrecedingCharacterIndex()) != -1) {
            setCursor(precedingCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrevByWord() {
        Integer previousWordOffset;
        if (AbstractC1038a.m1204e(this) > 0 && (previousWordOffset = getPreviousWordOffset()) != null) {
            setCursor(previousWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m20451getEndimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m20453getMaximpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m20454getMinimpl(this.selection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <U> T apply(U u, boolean z, @NotNull Function1<? super U, Unit> function1) {
        if (z) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            function1.invoke(u);
        }
        Intrinsics.checkNotNull(u, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (T) u;
    }

    @NotNull
    public final T collapseLeftOr(@NotNull Function1<? super T, Unit> or) {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (TextRange.m20450getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m20454getMinimpl(this.selection));
            } else {
                setCursor(TextRange.m20453getMaximpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T collapseRightOr(@NotNull Function1<? super T, Unit> or) {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (TextRange.m20450getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m20453getMaximpl(this.selection));
            } else {
                setCursor(TextRange.m20454getMinimpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T deselect() {
        if (AbstractC1038a.m1204e(this) > 0) {
            setCursor(TextRange.m20451getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Nullable
    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    @Nullable
    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    @Nullable
    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m20451getEndimpl(this.selection));
    }

    @Nullable
    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* JADX INFO: renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getOriginalSelection() {
        return this.originalSelection;
    }

    @NotNull
    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m20451getEndimpl(this.selection));
    }

    @Nullable
    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    @NotNull
    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    @NotNull
    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    @NotNull
    public final T moveCursorDownByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, 1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorLeft() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorLeftByWord() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorNextByParagraph() {
        if (AbstractC1038a.m1204e(this) > 0) {
            int iFindParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m20453getMaximpl(this.selection));
            if (iFindParagraphEnd == TextRange.m20453getMaximpl(this.selection) && iFindParagraphEnd != getText$foundation_release().length()) {
                iFindParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), iFindParagraphEnd + 1);
            }
            setCursor(iFindParagraphEnd);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorPrevByParagraph() {
        if (AbstractC1038a.m1204e(this) > 0) {
            int iFindParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m20454getMinimpl(this.selection));
            if (iFindParagraphStart == TextRange.m20454getMinimpl(this.selection) && iFindParagraphStart != 0) {
                iFindParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), iFindParagraphStart - 1);
            }
            setCursor(iFindParagraphStart);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorRight() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorRightByWord() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToEnd() {
        if (AbstractC1038a.m1204e(this) > 0) {
            setCursor(getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToHome() {
        if (AbstractC1038a.m1204e(this) > 0) {
            setCursor(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineEnd() {
        Integer lineEndByOffset;
        if (AbstractC1038a.m1204e(this) > 0 && (lineEndByOffset = getLineEndByOffset()) != null) {
            setCursor(lineEndByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineLeftSide() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineRightSide() {
        if (AbstractC1038a.m1204e(this) > 0) {
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineStart() {
        Integer lineStartByOffset;
        if (AbstractC1038a.m1204e(this) > 0 && (lineStartByOffset = getLineStartByOffset()) != null) {
            setCursor(lineStartByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorUpByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, -1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T selectAll() {
        if (AbstractC1038a.m1204e(this) > 0) {
            setSelection(0, getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m20456getStartimpl(this.originalSelection), TextRange.m20451getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final void setAnnotatedString(@NotNull AnnotatedString annotatedString) {
        this.annotatedString = annotatedString;
    }

    public final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    public final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m16495setSelection5zctL8(long j) {
        this.selection = j;
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString;
        this.originalSelection = j;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping;
        this.state = textPreparedSelectionState;
        this.selection = j;
        this.annotatedString = annotatedString;
    }
}
