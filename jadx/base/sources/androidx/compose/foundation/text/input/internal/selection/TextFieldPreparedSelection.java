package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.style.ResolvedTextDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\b\u0000\u0018\u0000 P2\u00020\u0001:\u0001PB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ,\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\u0082\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001f\u0010#\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fJ\u001f\u0010%\u001a\u00020\u00002\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fJ\u0019\u0010&\u001a\u00020\u001e2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120'H\u0086\bJ\u0006\u0010(\u001a\u00020\u0000J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020!J\b\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020!H\u0002J\u0006\u00102\u001a\u00020\u0000J\u0006\u00103\u001a\u00020\u0000J\u0006\u00104\u001a\u00020\u0000J\u0006\u00105\u001a\u00020\u0000J\b\u00106\u001a\u00020\u0000H\u0002J\u0006\u00107\u001a\u00020\u0000J\b\u00108\u001a\u00020\u0000H\u0002J\b\u00109\u001a\u00020\u0000H\u0002J\u0006\u0010:\u001a\u00020\u0000J\b\u0010;\u001a\u00020\u0000H\u0002J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002J\u0016\u0010I\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0002J\u0016\u0010K\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0002J\u0017\u0010L\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0082\u0010J\u0017\u0010M\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010J\u001a\u00020!H\u0082\u0010J\u0014\u0010N\u001a\u00020!*\u00020\u00052\u0006\u0010O\u001a\u00020!H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u00020\u0012X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "charOffset", "", TypedValues.Cycle.S_WAVE_OFFSET, "collapseLeftOr", "or", "collapseRightOr", "deleteIfSelectedOr", "Lkotlin/Function0;", "deselect", "getLineEndByOffset", "getLineStartByOffset", "getNextCharacterIndex", "getNextWordOffset", "getPrecedingCharacterIndex", "getPreviousWordOffset", "isLtr", "jumpByPagesOffset", "pagesAmount", "moveCursorDownByLine", "moveCursorDownByPage", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "moveCursorUpByPage", "selectAll", "selectMovement", "setCursor", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffsetForLayout", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextPreparedSelection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n*L\n1#1,545:1\n181#1,7:554\n181#1,7:561\n177#1,11:568\n177#1,11:579\n177#1,11:590\n177#1,11:601\n177#1,11:612\n177#1,11:623\n177#1,11:634\n177#1,11:645\n177#1,11:656\n177#1,11:667\n177#1,11:678\n177#1,11:689\n177#1,11:700\n177#1,11:711\n177#1,11:722\n177#1,11:733\n181#1,7:744\n181#1,7:751\n177#1,11:758\n177#1,11:769\n177#1,11:780\n177#1,11:791\n181#1,7:802\n602#2,8:546\n*S KotlinDebug\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection\n*L\n135#1:554,7\n142#1:561,7\n197#1:568,11\n201#1:579,11\n205#1:590,11\n213#1:601,11\n224#1:612,11\n239#1:623,11\n262#1:634,11\n270#1:645,11\n278#1:656,11\n282#1:667,11\n286#1:678,11\n294#1:689,11\n305#1:700,11\n311#1:711,11\n315#1:722,11\n323#1:733,11\n333#1:744,7\n340#1:751,7\n347#1:758,11\n354#1:769,11\n358#1:780,11\n366#1:791,11\n375#1:802,7\n98#1:546,8\n*E\n"})
public final class TextFieldPreparedSelection {
    public static final int NoCharacterFound = -1;

    @NotNull
    private final TextFieldCharSequence initialValue;
    private final boolean isFromSoftKeyboard;
    private long selection;

    @NotNull
    private final TransformedTextFieldState state;

    @NotNull
    private final String text;

    @Nullable
    private final TextLayoutResult textLayoutResult;

    @NotNull
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    public static final int $stable = 8;

    public TextFieldPreparedSelection(@NotNull TransformedTextFieldState transformedTextFieldState, @Nullable TextLayoutResult textLayoutResult, boolean z, float f, @NotNull TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.state = transformedTextFieldState;
        this.textLayoutResult = textLayoutResult;
        this.isFromSoftKeyboard = z;
        this.visibleTextLayoutHeight = f;
        this.textPreparedSelectionState = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextFieldCharSequence visualText = transformedTextFieldState.getVisualText();
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.initialValue = visualText;
            this.selection = visualText.getSelection();
            this.text = visualText.toString();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    private final TextFieldPreparedSelection applyIfNotEmpty(boolean resetCachedX, Function1<? super TextFieldPreparedSelection, Unit> block) {
        if (resetCachedX) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            block.invoke(this);
        }
        return this;
    }

    public static /* synthetic */ TextFieldPreparedSelection applyIfNotEmpty$default(TextFieldPreparedSelection textFieldPreparedSelection, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        }
        if (textFieldPreparedSelection.text.length() > 0) {
            function1.invoke(textFieldPreparedSelection);
        }
        return textFieldPreparedSelection;
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, this.text.length() - 1);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true);
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m20453getMaximpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i));
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m20454getMinimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.initialValue.length()) {
            long jM20430getWordBoundaryjx7JFs = textLayoutResult.m20430getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m20451getEndimpl(jM20430getWordBoundaryjx7JFs) > i) {
                return TextRange.m20451getEndimpl(jM20430getWordBoundaryjx7JFs);
            }
            i++;
        }
        return this.initialValue.length();
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m20451getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long jM20430getWordBoundaryjx7JFs = textLayoutResult.m20430getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m20456getStartimpl(jM20430getWordBoundaryjx7JFs) < i) {
                return TextRange.m20456getStartimpl(jM20430getWordBoundaryjx7JFs);
            }
            i--;
        }
        return 0;
    }

    public static /* synthetic */ int getPrevWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m20451getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getPrevWordOffsetForLayout(textLayoutResult, i);
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult == null || (paragraphDirection = textLayoutResult.getParagraphDirection(TextRange.m20451getEndimpl(this.selection))) == null || paragraphDirection == ResolvedTextDirection.Ltr;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int iM20451getEndimpl = TextRange.m20451getEndimpl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(textLayoutResult.getCursorRect(iM20451getEndimpl).getLeft());
        }
        int lineForOffset = textLayoutResult.getLineForOffset(iM20451getEndimpl) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return this.text.length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        float cachedX = this.textPreparedSelectionState.getCachedX();
        return ((!isLtr() || cachedX < textLayoutResult.getLineRight(lineForOffset)) && (isLtr() || cachedX > textLayoutResult.getLineLeft(lineForOffset))) ? textLayoutResult.m20428getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX, lineBottom)) : textLayoutResult.getLineEnd(lineForOffset, true);
    }

    private final int jumpByPagesOffset(int pagesAmount) {
        int iM20451getEndimpl = TextRange.m20451getEndimpl(this.initialValue.getSelection());
        if (this.textLayoutResult == null || Float.isNaN(this.visibleTextLayoutHeight)) {
            return iM20451getEndimpl;
        }
        Rect rectTranslate = this.textLayoutResult.getCursorRect(iM20451getEndimpl).translate(0.0f, this.visibleTextLayoutHeight * pagesAmount);
        float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(rectTranslate.getTop()));
        return Math.abs(rectTranslate.getTop() - lineBottom) > Math.abs(rectTranslate.getBottom() - lineBottom) ? this.textLayoutResult.m20428getOffsetForPositionk4lQ0M(rectTranslate.m18319getTopLeftF1C5BW0()) : this.textLayoutResult.m20428getOffsetForPositionk4lQ0M(rectTranslate.m18312getBottomLeftF1C5BW0());
    }

    private final TextFieldPreparedSelection moveCursorNext() {
        int iM20451getEndimpl;
        int iCalculateAdjacentCursorPosition;
        if (AbstractC1038a.m1203d(this, this) > 0 && (iCalculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, (iM20451getEndimpl = TextRange.m20451getEndimpl(this.selection)), true, this.state)) != iM20451getEndimpl) {
            setCursor(iCalculateAdjacentCursorPosition);
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorNextByWord() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(getNextWordOffset());
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrev() {
        int iM20451getEndimpl;
        int iCalculateAdjacentCursorPosition;
        if (AbstractC1038a.m1203d(this, this) > 0 && (iCalculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, (iM20451getEndimpl = TextRange.m20451getEndimpl(this.selection)), false, this.state)) != iM20451getEndimpl) {
            setCursor(iCalculateAdjacentCursorPosition);
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrevByWord() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(getPreviousWordOffset());
        }
        return this;
    }

    private final void setCursor(int offset) {
        this.selection = TextRangeKt.TextRange(offset, offset);
    }

    @NotNull
    public final TextFieldPreparedSelection collapseLeftOr(@NotNull Function1<? super TextFieldPreparedSelection, Unit> or) {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (TextRange.m20450getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            if (isLtr()) {
                setCursor(TextRange.m20454getMinimpl(this.selection));
                return this;
            }
            setCursor(TextRange.m20453getMaximpl(this.selection));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection collapseRightOr(@NotNull Function1<? super TextFieldPreparedSelection, Unit> or) {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (TextRange.m20450getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            if (isLtr()) {
                setCursor(TextRange.m20453getMaximpl(this.selection));
                return this;
            }
            setCursor(TextRange.m20454getMinimpl(this.selection));
        }
        return this;
    }

    public final void deleteIfSelectedOr(@NotNull Function0<TextRange> block) {
        if (!TextRange.m20450getCollapsedimpl(getSelection())) {
            TransformedTextFieldState.m16395replaceTextM8tDOmk$default(this.state, "", getSelection(), null, !this.isFromSoftKeyboard, 4, null);
            return;
        }
        TextRange textRangeInvoke = block.invoke();
        if (textRangeInvoke != null) {
            TransformedTextFieldState.m16395replaceTextM8tDOmk$default(this.state, "", textRangeInvoke.getPackedValue(), null, !this.isFromSoftKeyboard, 4, null);
        }
    }

    @NotNull
    public final TextFieldPreparedSelection deselect() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(TextRange.m20451getEndimpl(this.selection));
        }
        return this;
    }

    @NotNull
    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final int getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult != null ? getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length();
    }

    public final int getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null);
        }
        return 0;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m20451getEndimpl(this.selection));
    }

    public final int getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult != null ? getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length();
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m20451getEndimpl(this.selection));
    }

    public final int getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return getPrevWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null);
        }
        return 0;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorDownByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult);
            setCursor(jumpByLinesOffset(textLayoutResult, 1));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorDownByPage() {
        if (this.text.length() > 0) {
            setCursor(jumpByPagesOffset(1));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorLeft() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorPrev();
                return this;
            }
            moveCursorNext();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorLeftByWord() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorPrevByWord();
                return this;
            }
            moveCursorNextByWord();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorNextByParagraph() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            int iFindParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, TextRange.m20453getMaximpl(this.selection));
            if (iFindParagraphEnd == TextRange.m20453getMaximpl(this.selection) && iFindParagraphEnd != this.text.length()) {
                iFindParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, iFindParagraphEnd + 1);
            }
            setCursor(iFindParagraphEnd);
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorPrevByParagraph() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            int iFindParagraphStart = StringHelpersKt.findParagraphStart(this.text, TextRange.m20454getMinimpl(this.selection));
            if (iFindParagraphStart == TextRange.m20454getMinimpl(this.selection) && iFindParagraphStart != 0) {
                iFindParagraphStart = StringHelpersKt.findParagraphStart(this.text, iFindParagraphStart - 1);
            }
            setCursor(iFindParagraphStart);
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorRight() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorNext();
                return this;
            }
            moveCursorPrev();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorRightByWord() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorNextByWord();
                return this;
            }
            moveCursorPrevByWord();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToEnd() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(this.text.length());
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToHome() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(0);
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToLineEnd() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(getLineEndByOffset());
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToLineLeftSide() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorToLineStart();
                return this;
            }
            moveCursorToLineEnd();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToLineRightSide() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            if (isLtr()) {
                moveCursorToLineEnd();
                return this;
            }
            moveCursorToLineStart();
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorToLineStart() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            setCursor(getLineStartByOffset());
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorUpByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            Intrinsics.checkNotNull(textLayoutResult);
            setCursor(jumpByLinesOffset(textLayoutResult, -1));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection moveCursorUpByPage() {
        if (this.text.length() > 0) {
            setCursor(jumpByPagesOffset(-1));
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection selectAll() {
        if (AbstractC1038a.m1203d(this, this) > 0) {
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }
        return this;
    }

    @NotNull
    public final TextFieldPreparedSelection selectMovement() {
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m20456getStartimpl(this.initialValue.getSelection()), TextRange.m20451getEndimpl(this.selection));
        }
        return this;
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m16424setSelection5zctL8(long j) {
        this.selection = j;
    }
}
