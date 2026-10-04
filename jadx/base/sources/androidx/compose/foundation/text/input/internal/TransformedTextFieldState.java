package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 ]2\u00020\u0001:\u0002]^B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020!J,\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/H\u0086\bJ\u0013\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020!2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001b\u0010;\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bC\u0010>J\u001b\u0010B\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010AJ\u000e\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u000203J\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JJ\"\u0010K\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010L\u001a\u00020+2\b\b\u0002\u0010M\u001a\u00020NJ4\u0010O\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\u0006\u0010<\u001a\u0002082\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010*\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0006\u0010R\u001a\u00020!J\u0018\u0010S\u001a\u00020!2\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u0018\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bX\u0010UJ\b\u0010Y\u001a\u00020ZH\u0016J\u0006\u0010[\u001a\u00020!J\u0010\u0010\\\u001a\u00020!2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "codepointTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "outputText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOutputText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformedText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "untransformedText", "getUntransformedText", "visualText", "getVisualText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "restartImeIfContentChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "highlightCharsIn-7RAjNK8", "(IJ)V", "mapFromTransformed", Bixby2Constants.BIXBY_PARAM_RANGE, "mapFromTransformed-GEjPoXI", "(J)J", TypedValues.Cycle.S_WAVE_OFFSET, "mapFromTransformed--jx7JFs", "(I)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "selectAll", "selectCharsIn", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", Constants.ARG_UPDATE, "Companion", "TransformedText", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransformedTextFieldState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldState\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 TextFieldState.kt\nandroidx/compose/foundation/text/input/TextFieldState\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,678:1\n81#2:679\n107#2,2:680\n261#3,15:682\n261#3,15:697\n261#3,15:712\n261#3,15:727\n261#3,15:742\n267#3,9:757\n261#3,15:766\n261#3,15:781\n261#3,15:796\n261#3,15:811\n1#4:826\n314#5,11:827\n*S KotlinDebug\n*F\n+ 1 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldState\n*L\n174#1:679\n174#1:680,2\n198#1:682,15\n205#1:697,15\n211#1:712,15\n218#1:727,15\n224#1:742,15\n244#1:757,9\n265#1:766,15\n283#1:781,15\n290#1:796,15\n318#1:811,15\n419#1:827,11\n*E\n"})
public final class TransformedTextFieldState {
    public static final int $stable = 0;

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Nullable
    private final CodepointTransformation codepointTransformation;

    @Nullable
    private final State<TransformedText> codepointTransformedText;

    @Nullable
    private InputTransformation inputTransformation;

    @Nullable
    private final OutputTransformation outputTransformation;

    @Nullable
    private final State<TransformedText> outputTransformedText;

    /* JADX INFO: renamed from: selectionWedgeAffinity$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState selectionWedgeAffinity;

    @NotNull
    private final TextFieldState textFieldState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", Bixby2Constants.BIXBY_PARAM_RANGE, "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTransformedTextFieldState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,678:1\n1#2:679\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[WedgeAffinity.values().length];
                try {
                    iArr[WedgeAffinity.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WedgeAffinity.End.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, OutputTransformation outputTransformation, SelectionWedgeAffinity wedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(untransformedValue, null, null, offsetMappingCalculator, 6, null);
            outputTransformation.transformOutput(textFieldBuffer);
            TextRange textRangeM20444boximpl = null;
            if (textFieldBuffer.getChanges().getChangeCount() == 0) {
                return null;
            }
            long jM16407mapToTransformedXGyztTk = m16407mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange textRangeM16280getCompositionMzsxiRA = untransformedValue.getComposition();
            if (textRangeM16280getCompositionMzsxiRA != null) {
                textRangeM20444boximpl = TextRange.m20444boximpl(TransformedTextFieldState.Companion.m16407mapToTransformedXGyztTk(textRangeM16280getCompositionMzsxiRA.getPackedValue(), offsetMappingCalculator, wedgeAffinity));
            }
            return new TransformedText(textFieldBuffer.m16277toTextFieldCharSequenceudt6zUU$foundation_release(jM16407mapToTransformedXGyztTk, textRangeM20444boximpl), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        public final long m16406mapFromTransformedxdX6G0(long range, OffsetMappingCalculator mapping) {
            long jM16348mapFromDestjx7JFs = mapping.m16348mapFromDestjx7JFs(TextRange.m20456getStartimpl(range));
            long jM16348mapFromDestjx7JFs2 = TextRange.m20450getCollapsedimpl(range) ? jM16348mapFromDestjx7JFs : mapping.m16348mapFromDestjx7JFs(TextRange.m20451getEndimpl(range));
            int iMin = Math.min(TextRange.m20454getMinimpl(jM16348mapFromDestjx7JFs), TextRange.m20454getMinimpl(jM16348mapFromDestjx7JFs2));
            int iMax = Math.max(TextRange.m20453getMaximpl(jM16348mapFromDestjx7JFs), TextRange.m20453getMaximpl(jM16348mapFromDestjx7JFs2));
            return TextRange.m20455getReversedimpl(range) ? TextRangeKt.TextRange(iMax, iMin) : TextRangeKt.TextRange(iMin, iMax);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
        public final long m16407mapToTransformedXGyztTk(long range, OffsetMappingCalculator mapping, SelectionWedgeAffinity wedgeAffinity) {
            long jM16349mapFromSourcejx7JFs = mapping.m16349mapFromSourcejx7JFs(TextRange.m20456getStartimpl(range));
            long jM16349mapFromSourcejx7JFs2 = TextRange.m20450getCollapsedimpl(range) ? jM16349mapFromSourcejx7JFs : mapping.m16349mapFromSourcejx7JFs(TextRange.m20451getEndimpl(range));
            int iMin = Math.min(TextRange.m20454getMinimpl(jM16349mapFromSourcejx7JFs), TextRange.m20454getMinimpl(jM16349mapFromSourcejx7JFs2));
            int iMax = Math.max(TextRange.m20453getMaximpl(jM16349mapFromSourcejx7JFs), TextRange.m20453getMaximpl(jM16349mapFromSourcejx7JFs2));
            long jTextRange = TextRange.m20455getReversedimpl(range) ? TextRangeKt.TextRange(iMax, iMin) : TextRangeKt.TextRange(iMin, iMax);
            if (TextRange.m20450getCollapsedimpl(range) && !TextRange.m20450getCollapsedimpl(jTextRange)) {
                WedgeAffinity startAffinity = wedgeAffinity != null ? wedgeAffinity.getStartAffinity() : null;
                int i = startAffinity == null ? -1 : WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()];
                if (i != -1) {
                    if (i == 1) {
                        return TextRangeKt.TextRange(TextRange.m20456getStartimpl(jTextRange));
                    }
                    if (i == 2) {
                        return TextRangeKt.TextRange(TextRange.m20451getEndimpl(jTextRange));
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return jTextRange;
        }

        /* JADX INFO: renamed from: mapToTransformed-XGyztTk$default, reason: not valid java name */
        public static /* synthetic */ long m16408mapToTransformedXGyztTk$default(Companion companion, long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i, Object obj) {
            if ((i & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.m16407mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, CodepointTransformation codepointTransformation, SelectionWedgeAffinity wedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(untransformedValue, codepointTransformation, offsetMappingCalculator);
            TextRange textRangeM20444boximpl = null;
            if (visualText == untransformedValue) {
                return null;
            }
            long jM16407mapToTransformedXGyztTk = m16407mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange textRangeM16280getCompositionMzsxiRA = untransformedValue.getComposition();
            if (textRangeM16280getCompositionMzsxiRA != null) {
                textRangeM20444boximpl = TextRange.m20444boximpl(TransformedTextFieldState.Companion.m16407mapToTransformedXGyztTk(textRangeM16280getCompositionMzsxiRA.getPackedValue(), offsetMappingCalculator, wedgeAffinity));
            }
            return new TransformedText(new TextFieldCharSequence(visualText, jM16407mapToTransformedXGyztTk, textRangeM20444boximpl, null, 8, null), offsetMappingCalculator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class TransformedText {

        @NotNull
        private final OffsetMappingCalculator offsetMapping;

        @NotNull
        private final TextFieldCharSequence text;

        public TransformedText(@NotNull TextFieldCharSequence textFieldCharSequence, @NotNull OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextFieldCharSequence getText() {
            return this.text;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        @NotNull
        public final TransformedText copy(@NotNull TextFieldCharSequence text, @NotNull OffsetMappingCalculator offsetMapping) {
            return new TransformedText(text, offsetMapping);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) other;
            return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
        }

        @NotNull
        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        @NotNull
        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public int hashCode() {
            return this.offsetMapping.hashCode() + (this.text.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.TransformedTextFieldState", m14021f = "TransformedTextFieldState.kt", m14022i = {0, 0}, m14023l = {679}, m14024m = "collectImeNotifications", m14025n = {"this", "notifyImeListener"}, m14026s = {"L$0", "L$1"})
    public static final class C13421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13421(Continuation<? super C13421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformedTextFieldState.this.collectImeNotifications(null, this);
        }
    }

    public TransformedTextFieldState(@NotNull TextFieldState textFieldState, @Nullable InputTransformation inputTransformation, @Nullable final CodepointTransformation codepointTransformation, @Nullable final OutputTransformation outputTransformation) {
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.outputTransformation = outputTransformation;
        this.outputTransformedText = outputTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$outputTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TransformedTextFieldState.TransformedText invoke() {
                return TransformedTextFieldState.Companion.calculateTransformedText(this.this$0.textFieldState.getValue$foundation_release(), outputTransformation, this.this$0.getSelectionWedgeAffinity());
            }
        }) : null;
        this.codepointTransformedText = codepointTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$codepointTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TransformedTextFieldState.TransformedText invoke() {
                TextFieldCharSequence value$foundation_release;
                TransformedTextFieldState.TransformedText transformedText;
                TransformedTextFieldState.Companion companion = TransformedTextFieldState.Companion;
                State state = this.this$0.outputTransformedText;
                if (state == null || (transformedText = (TransformedTextFieldState.TransformedText) state.getValue()) == null || (value$foundation_release = transformedText.getText()) == null) {
                    value$foundation_release = this.this$0.textFieldState.getValue$foundation_release();
                }
                return companion.calculateTransformedText(value$foundation_release, codepointTransformation, this.this$0.getSelectionWedgeAffinity());
            }
        }) : null;
        this.selectionWedgeAffinity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, outputTransformation, selectionWedgeAffinity);
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        function1.invoke(textFieldState.getMainBuffer());
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m16393mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m16406mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
    private static final long m16394mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.m16407mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk$default, reason: not valid java name */
    public static /* synthetic */ void m16395replaceTextM8tDOmk$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = textFieldEditUndoBehavior;
        if ((i & 8) != 0) {
            z = true;
        }
        transformedTextFieldState.m16401replaceTextM8tDOmk(charSequence, j, textFieldEditUndoBehavior2, z);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(TextRange.m20451getEndimpl(mainBuffer.m16312getSelectiond9O1mEE()), TextRange.m20451getEndimpl(mainBuffer.m16312getSelectiond9O1mEE()));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(TextRange.m20453getMaximpl(mainBuffer.m16312getSelectiond9O1mEE()), TextRange.m20453getMaximpl(mainBuffer.m16312getSelectiond9O1mEE()));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImeNotifications(@NotNull final TextFieldState.NotifyImeListener notifyImeListener, @NotNull Continuation<?> continuation) {
        C13421 c13421;
        if (continuation instanceof C13421) {
            c13421 = (C13421) continuation;
            int i = c13421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13421.label = i - Integer.MIN_VALUE;
            } else {
                c13421 = new C13421(continuation);
            }
        }
        Object obj = c13421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13421.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c13421.L$0 = this;
            c13421.L$1 = notifyImeListener;
            c13421.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c13421), 1);
            cancellableContinuationImpl.initCancellability();
            this.textFieldState.addNotifyImeListener$foundation_release(notifyImeListener);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    this.this$0.textFieldState.removeNotifyImeListener$foundation_release(notifyImeListener);
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c13421);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.delete(TextRange.m20454getMinimpl(mainBuffer.m16312getSelectiond9O1mEE()), TextRange.m20453getMaximpl(mainBuffer.m16312getSelectiond9O1mEE()));
        mainBuffer.setSelection(TextRange.m20454getMinimpl(mainBuffer.m16312getSelectiond9O1mEE()), TextRange.m20454getMinimpl(mainBuffer.m16312getSelectiond9O1mEE()));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void editUntransformedTextAsUser(boolean restartImeIfContentChanges, @NotNull Function1<? super EditingBuffer, Unit> block) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(textFieldState.getMainBuffer());
        textFieldState.commitEditAsUser(inputTransformation, restartImeIfContentChanges, textFieldEditUndoBehavior);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) other;
        if (Intrinsics.areEqual(this.textFieldState, transformedTextFieldState.textFieldState) && Intrinsics.areEqual(this.codepointTransformation, transformedTextFieldState.codepointTransformation)) {
            return Intrinsics.areEqual(this.outputTransformation, transformedTextFieldState.outputTransformation);
        }
        return false;
    }

    @NotNull
    public final TextFieldCharSequence getOutputText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.outputTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getUntransformedText() : text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity.getValue();
    }

    @NotNull
    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    @NotNull
    public final TextFieldCharSequence getVisualText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.codepointTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getOutputText() : text;
    }

    public int hashCode() {
        int iHashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation = this.codepointTransformation;
        int iHashCode2 = (iHashCode + (codepointTransformation != null ? codepointTransformation.hashCode() : 0)) * 31;
        OutputTransformation outputTransformation = this.outputTransformation;
        return iHashCode2 + (outputTransformation != null ? outputTransformation.hashCode() : 0);
    }

    /* JADX INFO: renamed from: highlightCharsIn-7RAjNK8, reason: not valid java name */
    public final void m16396highlightCharsIn7RAjNK8(int type, long transformedRange) {
        long jM16398mapFromTransformedGEjPoXI = m16398mapFromTransformedGEjPoXI(transformedRange);
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().m16313setHighlightK7f2yys(type, TextRange.m20456getStartimpl(jM16398mapFromTransformedGEjPoXI), TextRange.m20451getEndimpl(jM16398mapFromTransformedGEjPoXI));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX INFO: renamed from: mapFromTransformed--jx7JFs, reason: not valid java name */
    public final long m16397mapFromTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        long jM16348mapFromDestjx7JFs = offsetMapping != null ? offsetMapping.m16348mapFromDestjx7JFs(offset) : TextRangeKt.TextRange(offset);
        return offsetMapping2 != null ? Companion.m16406mapFromTransformedxdX6G0(jM16348mapFromDestjx7JFs, offsetMapping2) : jM16348mapFromDestjx7JFs;
    }

    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m16398mapFromTransformedGEjPoXI(long range) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        if (offsetMapping != null) {
            range = Companion.m16406mapFromTransformedxdX6G0(range, offsetMapping);
        }
        return offsetMapping2 != null ? Companion.m16406mapFromTransformedxdX6G0(range, offsetMapping2) : range;
    }

    /* JADX INFO: renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m16399mapToTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        long jM16349mapFromSourcejx7JFs = offsetMapping2 != null ? offsetMapping2.m16349mapFromSourcejx7JFs(offset) : TextRangeKt.TextRange(offset);
        return offsetMapping != null ? Companion.m16407mapToTransformedXGyztTk(jM16349mapFromSourcejx7JFs, offsetMapping, getSelectionWedgeAffinity()) : jM16349mapFromSourcejx7JFs;
    }

    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m16400mapToTransformedGEjPoXI(long range) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        if (offsetMapping2 != null) {
            range = Companion.m16408mapToTransformedXGyztTk$default(Companion, range, offsetMapping2, null, 4, null);
        }
        return offsetMapping != null ? Companion.m16407mapToTransformedXGyztTk(range, offsetMapping, getSelectionWedgeAffinity()) : range;
    }

    public final void placeCursorBeforeCharAt(int transformedOffset) {
        m16402selectCharsIn5zctL8(TextRangeKt.TextRange(transformedOffset));
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public final void replaceAll(@NotNull CharSequence newText) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        EditCommandKt.deleteAll(mainBuffer);
        EditCommandKt.commitText(mainBuffer, newText.toString(), 1);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void replaceSelectedText(@NotNull CharSequence newText, boolean clearComposition, @NotNull TextFieldEditUndoBehavior undoBehavior) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        if (clearComposition) {
            mainBuffer.commitComposition();
        }
        long jM16312getSelectiond9O1mEE = mainBuffer.m16312getSelectiond9O1mEE();
        mainBuffer.replace(TextRange.m20454getMinimpl(jM16312getSelectiond9O1mEE), TextRange.m20453getMaximpl(jM16312getSelectiond9O1mEE), newText);
        int length = newText.length() + TextRange.m20454getMinimpl(jM16312getSelectiond9O1mEE);
        mainBuffer.setSelection(length, length);
        textFieldState.commitEditAsUser(inputTransformation, true, undoBehavior);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk, reason: not valid java name */
    public final void m16401replaceTextM8tDOmk(@NotNull CharSequence newText, long range, @NotNull TextFieldEditUndoBehavior undoBehavior, boolean restartImeIfContentChanges) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        long jM16398mapFromTransformedGEjPoXI = m16398mapFromTransformedGEjPoXI(range);
        mainBuffer.replace(TextRange.m20454getMinimpl(jM16398mapFromTransformedGEjPoXI), TextRange.m20453getMaximpl(jM16398mapFromTransformedGEjPoXI), newText);
        int length = newText.length() + TextRange.m20454getMinimpl(jM16398mapFromTransformedGEjPoXI);
        mainBuffer.setSelection(length, length);
        textFieldState.commitEditAsUser(inputTransformation, restartImeIfContentChanges, undoBehavior);
    }

    public final void selectAll() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(0, mainBuffer.getLength());
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX INFO: renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m16402selectCharsIn5zctL8(long transformedRange) {
        m16403selectUntransformedCharsIn5zctL8(m16398mapFromTransformedGEjPoXI(transformedRange));
    }

    /* JADX INFO: renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m16403selectUntransformedCharsIn5zctL8(long untransformedRange) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().setSelection(TextRange.m20456getStartimpl(untransformedRange), TextRange.m20451getEndimpl(untransformedRange));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void setSelectionWedgeAffinity(@NotNull SelectionWedgeAffinity selectionWedgeAffinity) {
        this.selectionWedgeAffinity.setValue(selectionWedgeAffinity);
    }

    @NotNull
    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + ((Object) getOutputText()) + "\", visualText=\"" + ((Object) getVisualText()) + "\")";
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void update(@Nullable InputTransformation inputTransformation) {
        this.inputTransformation = inputTransformation;
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation, selectionWedgeAffinity);
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, (i & 2) != 0 ? null : inputTransformation, (i & 4) != 0 ? null : codepointTransformation, (i & 8) != 0 ? null : outputTransformation);
    }
}
