package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.p109ui.graphics.RectHelper_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextGranularity;
import androidx.compose.p109ui.text.TextInclusionStrategy;
import androidx.compose.p109ui.text.TextLayoutInput;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.input.CommitTextCommand;
import androidx.compose.p109ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.p109ui.text.input.EditCommand;
import androidx.compose.p109ui.text.input.SetSelectionCommand;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b2J+\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\b2J2\u00104\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002052\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00104\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002052\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J2\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010>\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010>\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010?\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010?\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J-\u0010@\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020A2\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ+\u0010@\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020A2\u0006\u0010&\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ\u001e\u0010E\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010E\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010F\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010F\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u0019\u0010G\u001a\u00020H*\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "()V", "fallbackOnLegacyTextField", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "", "performDeletionOnLegacyTextField", Bixby2Constants.BIXBY_PARAM_RANGE, "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", "", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", TypedValues.Cycle.S_WAVE_OFFSET, "", "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(34)
@SourceDebugExtension({"SMAP\nHandwritingGesture.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandwritingGesture.android.kt\nandroidx/compose/foundation/text/input/internal/HandwritingGestureApi34\n+ 2 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldState\n+ 3 TextFieldState.kt\nandroidx/compose/foundation/text/input/TextFieldState\n*L\n1#1,1133:1\n314#2,6:1134\n323#2:1155\n314#2,6:1156\n323#2:1177\n314#2,6:1178\n323#2:1199\n261#3,15:1140\n261#3,15:1162\n261#3,15:1184\n*S KotlinDebug\n*F\n+ 1 HandwritingGesture.android.kt\nandroidx/compose/foundation/text/input/internal/HandwritingGestureApi34\n*L\n366#1:1134,6\n366#1:1155\n385#1:1156,6\n385#1:1177\n98#1:1178,6\n98#1:1199\n366#1:1140,15\n385#1:1162,15\n98#1:1184,15\n*E\n"})
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;

    @NotNull
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    @DoNotInline
    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, null, 4, null);
        return 5;
    }

    @DoNotInline
    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* JADX INFO: renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m16317highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (!TextRange.m20450getCollapsedimpl(j)) {
            transformedTextFieldState.m16396highlightCharsIn7RAjNK8(i, j);
            return;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    @DoNotInline
    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int iM16321toTextGranularityNUwxegE = m16321toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM16339getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m16339getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM16321toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16339getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, AbstractC1347e.m1285q(deleteGesture));
        }
        m16318performDeletionSbBc2M(transformedTextFieldState, jM16339getRangeForScreenRectOH9lIzo, TextGranularity.m20416equalsimpl0(iM16321toTextGranularityNUwxegE, TextGranularity.INSTANCE.m20421getWordDRrd7Zo()));
        return 1;
    }

    @DoNotInline
    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int iM16321toTextGranularityNUwxegE = m16321toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM16341getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m16341getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM16321toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16341getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, AbstractC1347e.m1285q(deleteRangeGesture));
        }
        m16318performDeletionSbBc2M(transformedTextFieldState, jM16341getRangeForScreenRectsO048IG0, TextGranularity.m20416equalsimpl0(iM16321toTextGranularityNUwxegE, TextGranularity.INSTANCE.m20421getWordDRrd7Zo()));
        return 1;
    }

    @DoNotInline
    /* JADX INFO: renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m16318performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            j = HandwritingGesture_androidKt.m16330adjustHandwritingDeleteGestureRange72CqOWE(j, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState.m16395replaceTextM8tDOmk$default(transformedTextFieldState, "", j, null, false, 12, null);
    }

    @DoNotInline
    /* JADX INFO: renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m16319performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m16330adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m20451getEndimpl(range), TextRange.m20451getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m20452getLengthimpl(range), 0)));
    }

    @DoNotInline
    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int iM16334getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m16334getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iM16334getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, AbstractC1347e.m1285q(insertGesture));
        }
        TransformedTextFieldState.m16395replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(iM16334getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    @DoNotInline
    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1)));
    }

    @DoNotInline
    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        TextLayoutResult layoutResult;
        if (transformedTextFieldState.getOutputText() != transformedTextFieldState.getUntransformedText()) {
            return 3;
        }
        int iM16334getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m16334getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (iM16334getOffsetForHandwritingGestured4ec7I == -1 || ((layoutResult = textLayoutState.getLayoutResult()) != null && HandwritingGesture_androidKt.isBiDiBoundary(layoutResult, iM16334getOffsetForHandwritingGestured4ec7I))) {
            return fallback(transformedTextFieldState, AbstractC1347e.m1285q(joinOrSplitGesture));
        }
        long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(transformedTextFieldState.getVisualText(), iM16334getOffsetForHandwritingGestured4ec7I);
        if (TextRange.m20450getCollapsedimpl(jRangeOfWhitespaces)) {
            TransformedTextFieldState.m16395replaceTextM8tDOmk$default(transformedTextFieldState, " ", jRangeOfWhitespaces, null, false, 12, null);
            return 1;
        }
        m16318performDeletionSbBc2M(transformedTextFieldState, jRangeOfWhitespaces, false);
        return 1;
    }

    @DoNotInline
    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long jM16336getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m16336getRangeForRemoveSpaceGesture5iVPX68(textLayoutState.getLayoutResult(), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m20450getCollapsedimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallback(transformedTextFieldState, AbstractC1347e.m1285q(removeSpaceGesture));
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String strReplace = new Regex("\\s+").replace(TextRangeKt.m20463substringFDrldGo(transformedTextFieldState.getVisualText(), jM16336getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull MatchResult matchResult) {
                Ref.IntRef intRef3 = intRef;
                if (intRef3.element == -1) {
                    intRef3.element = matchResult.getRange().getFirst();
                }
                intRef2.element = matchResult.getRange().getLast() + 1;
                return "";
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallback(transformedTextFieldState, AbstractC1347e.m1285q(removeSpaceGesture));
        }
        long jTextRange = TextRangeKt.TextRange(TextRange.m20456getStartimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) + intRef.element, TextRange.m20456getStartimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element);
        String strSubstring = strReplace.substring(intRef.element, strReplace.length() - (TextRange.m20452getLengthimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        TransformedTextFieldState.m16395replaceTextM8tDOmk$default(transformedTextFieldState, strSubstring, jTextRange, null, false, 12, null);
        return 1;
    }

    @DoNotInline
    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        long jM16339getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m16339getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m16321toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16339getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, AbstractC1347e.m1285q(selectGesture));
        }
        transformedTextFieldState.m16402selectCharsIn5zctL8(jM16339getRangeForScreenRectOH9lIzo);
        return 1;
    }

    @DoNotInline
    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        long jM16341getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m16341getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m16321toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16341getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, AbstractC1347e.m1285q(selectRangeGesture));
        }
        transformedTextFieldState.m16402selectCharsIn5zctL8(jM16341getRangeForScreenRectsO048IG0);
        return 1;
    }

    @DoNotInline
    /* JADX INFO: renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m16320performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m20456getStartimpl(range), TextRange.m20451getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    @DoNotInline
    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        m16317highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m16339getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m16321toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m16293getHandwritingDeletePreviewsxJuwY());
    }

    @DoNotInline
    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        m16317highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m16341getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m16321toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m16293getHandwritingDeletePreviewsxJuwY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    @DoNotInline
    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        m16317highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m16339getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m16321toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m16294getHandwritingSelectPreviewsxJuwY());
    }

    @DoNotInline
    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        m16317highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m16341getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m16321toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m16294getHandwritingSelectPreviewsxJuwY());
    }

    @DoNotInline
    /* JADX INFO: renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m16321toTextGranularityNUwxegE(int i) {
        return i != 1 ? i != 2 ? TextGranularity.INSTANCE.m20420getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m20420getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m20421getWordDRrd7Zo();
    }

    @DoNotInline
    public final int performHandwritingGesture$foundation_release(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull HandwritingGesture handwritingGesture, @NotNull TextLayoutState textLayoutState, @Nullable ViewConfiguration viewConfiguration) {
        if (AbstractC1347e.m1265A(handwritingGesture)) {
            return performSelectGesture(transformedTextFieldState, AbstractC1347e.m1286r(handwritingGesture), textLayoutState);
        }
        if (AbstractC1346d.m1256r(handwritingGesture)) {
            return performDeleteGesture(transformedTextFieldState, AbstractC1346d.m1246h(handwritingGesture), textLayoutState);
        }
        if (AbstractC1346d.m1259u(handwritingGesture)) {
            return performSelectRangeGesture(transformedTextFieldState, AbstractC1346d.m1251m(handwritingGesture), textLayoutState);
        }
        if (AbstractC1346d.m1261w(handwritingGesture)) {
            return performDeleteRangeGesture(transformedTextFieldState, AbstractC1346d.m1247i(handwritingGesture), textLayoutState);
        }
        if (AbstractC1346d.m1237C(handwritingGesture)) {
            return performJoinOrSplitGesture(transformedTextFieldState, AbstractC1346d.m1249k(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (AbstractC1346d.m1263y(handwritingGesture)) {
            return performInsertGesture(transformedTextFieldState, AbstractC1346d.m1248j(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (AbstractC1346d.m1235A(handwritingGesture)) {
            return performRemoveSpaceGesture(transformedTextFieldState, AbstractC1346d.m1250l(handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }

    @DoNotInline
    public final boolean previewHandwritingGesture$foundation_release(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull PreviewableHandwritingGesture previewableHandwritingGesture, @NotNull TextLayoutState textLayoutState, @Nullable CancellationSignal cancellationSignal) {
        if (AbstractC1347e.m1265A(previewableHandwritingGesture)) {
            previewSelectGesture(transformedTextFieldState, AbstractC1347e.m1286r(previewableHandwritingGesture), textLayoutState);
        } else if (AbstractC1346d.m1256r(previewableHandwritingGesture)) {
            previewDeleteGesture(transformedTextFieldState, AbstractC1346d.m1246h(previewableHandwritingGesture), textLayoutState);
        } else if (AbstractC1346d.m1259u(previewableHandwritingGesture)) {
            previewSelectRangeGesture(transformedTextFieldState, AbstractC1346d.m1251m(previewableHandwritingGesture), textLayoutState);
        } else {
            if (!AbstractC1346d.m1261w(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, AbstractC1346d.m1247i(previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new C1348f(transformedTextFieldState, 1));
        return true;
    }

    @DoNotInline
    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM16333getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m16333getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
            if (iM16333getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM16333getOffsetForHandwritingGestured4ec7I))) {
                performInsertionOnLegacyTextField(iM16333getOffsetForHandwritingGestured4ec7I, insertGesture.getTextToInsert(), function1);
                return 1;
            }
            return fallbackOnLegacyTextField(AbstractC1347e.m1285q(insertGesture), function1);
        }
        return fallbackOnLegacyTextField(AbstractC1347e.m1285q(insertGesture), function1);
    }

    @DoNotInline
    public final boolean previewHandwritingGesture$foundation_release(@NotNull LegacyTextFieldState legacyTextFieldState, @NotNull PreviewableHandwritingGesture previewableHandwritingGesture, @Nullable TextFieldSelectionManager textFieldSelectionManager, @Nullable CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (AbstractC1347e.m1265A(previewableHandwritingGesture)) {
            previewSelectGesture(legacyTextFieldState, AbstractC1347e.m1286r(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (AbstractC1346d.m1256r(previewableHandwritingGesture)) {
            previewDeleteGesture(legacyTextFieldState, AbstractC1346d.m1246h(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (AbstractC1346d.m1259u(previewableHandwritingGesture)) {
            previewSelectRangeGesture(legacyTextFieldState, AbstractC1346d.m1251m(previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!AbstractC1346d.m1261w(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, AbstractC1346d.m1247i(previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new C1348f(textFieldSelectionManager, 0));
        return true;
    }

    @DoNotInline
    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM16338getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m16321toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16338getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(AbstractC1347e.m1285q(selectGesture), function1);
        }
        m16320performSelectionOnLegacyTextField8ffj60Q(jM16338getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    @DoNotInline
    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m16571setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m16321toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m16572setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m16321toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM16321toTextGranularityNUwxegE = m16321toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM16338getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM16321toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16338getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(AbstractC1347e.m1285q(deleteGesture), function1);
        }
        m16319performDeletionOnLegacyTextFieldvJH6DeI(jM16338getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m20416equalsimpl0(iM16321toTextGranularityNUwxegE, TextGranularity.INSTANCE.m20421getWordDRrd7Zo()), function1);
        return 1;
    }

    @DoNotInline
    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM16340getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m16340getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m16321toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16340getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(AbstractC1347e.m1285q(selectRangeGesture), function1);
        }
        m16320performSelectionOnLegacyTextField8ffj60Q(jM16340getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    @DoNotInline
    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m16571setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m16340getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m16321toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m16572setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m16340getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m16321toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM16321toTextGranularityNUwxegE = m16321toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM16340getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m16340getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM16321toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m20450getCollapsedimpl(jM16340getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(AbstractC1347e.m1285q(deleteRangeGesture), function1);
        }
        m16319performDeletionOnLegacyTextFieldvJH6DeI(jM16340getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m20416equalsimpl0(iM16321toTextGranularityNUwxegE, TextGranularity.INSTANCE.m20421getWordDRrd7Zo()), function1);
        return 1;
    }

    @DoNotInline
    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM16333getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m16333getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
            if (iM16333getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM16333getOffsetForHandwritingGestured4ec7I))) {
                long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, iM16333getOffsetForHandwritingGestured4ec7I);
                if (TextRange.m20450getCollapsedimpl(jRangeOfWhitespaces)) {
                    performInsertionOnLegacyTextField(TextRange.m20456getStartimpl(jRangeOfWhitespaces), " ", function1);
                    return 1;
                }
                m16319performDeletionOnLegacyTextFieldvJH6DeI(jRangeOfWhitespaces, annotatedString, false, function1);
                return 1;
            }
            return fallbackOnLegacyTextField(AbstractC1347e.m1285q(joinOrSplitGesture), function1);
        }
        return fallbackOnLegacyTextField(AbstractC1347e.m1285q(joinOrSplitGesture), function1);
    }

    @DoNotInline
    public final int performHandwritingGesture$foundation_release(@NotNull LegacyTextFieldState legacyTextFieldState, @NotNull HandwritingGesture handwritingGesture, @Nullable TextFieldSelectionManager textFieldSelectionManager, @Nullable ViewConfiguration viewConfiguration, @NotNull Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (AbstractC1347e.m1265A(handwritingGesture)) {
            return performSelectGesture(legacyTextFieldState, AbstractC1347e.m1286r(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (AbstractC1346d.m1256r(handwritingGesture)) {
            return performDeleteGesture(legacyTextFieldState, AbstractC1346d.m1246h(handwritingGesture), untransformedText, function1);
        }
        if (AbstractC1346d.m1259u(handwritingGesture)) {
            return performSelectRangeGesture(legacyTextFieldState, AbstractC1346d.m1251m(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (AbstractC1346d.m1261w(handwritingGesture)) {
            return performDeleteRangeGesture(legacyTextFieldState, AbstractC1346d.m1247i(handwritingGesture), untransformedText, function1);
        }
        if (AbstractC1346d.m1237C(handwritingGesture)) {
            return performJoinOrSplitGesture(legacyTextFieldState, AbstractC1346d.m1249k(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        if (AbstractC1346d.m1263y(handwritingGesture)) {
            return performInsertGesture(legacyTextFieldState, AbstractC1346d.m1248j(handwritingGesture), viewConfiguration, function1);
        }
        if (AbstractC1346d.m1235A(handwritingGesture)) {
            return performRemoveSpaceGesture(legacyTextFieldState, AbstractC1346d.m1250l(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        return 2;
    }

    @DoNotInline
    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        long jM16336getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m16336getRangeForRemoveSpaceGesture5iVPX68(layoutResult != null ? layoutResult.getValue() : null, HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m20450getCollapsedimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(AbstractC1347e.m1285q(removeSpaceGesture), function1);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String strReplace = new Regex("\\s+").replace(TextRangeKt.m20463substringFDrldGo(annotatedString, jM16336getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull MatchResult matchResult) {
                Ref.IntRef intRef3 = intRef;
                if (intRef3.element == -1) {
                    intRef3.element = matchResult.getRange().getFirst();
                }
                intRef2.element = matchResult.getRange().getLast() + 1;
                return "";
            }
        });
        if (intRef.element != -1 && intRef2.element != -1) {
            int iM20456getStartimpl = TextRange.m20456getStartimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) + intRef.element;
            int iM20456getStartimpl2 = TextRange.m20456getStartimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element;
            String strSubstring = strReplace.substring(intRef.element, strReplace.length() - (TextRange.m20452getLengthimpl(jM16336getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(iM20456getStartimpl, iM20456getStartimpl2), new CommitTextCommand(strSubstring, 1)));
            return 1;
        }
        return fallbackOnLegacyTextField(AbstractC1347e.m1285q(removeSpaceGesture), function1);
    }
}
