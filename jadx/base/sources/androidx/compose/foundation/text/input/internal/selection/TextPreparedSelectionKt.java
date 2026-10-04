package androidx.compose.foundation.text.input.internal.selection;

import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.p109ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, m13886d2 = {"calculateAdjacentCursorPosition", "", "transformedText", "", "cursor", "forward", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextPreparedSelection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/input/internal/selection/TextPreparedSelectionKt\n+ 2 TransformedTextFieldState.kt\nandroidx/compose/foundation/text/input/internal/TransformedTextFieldStateKt\n*L\n1#1,545:1\n653#2,24:546\n*S KotlinDebug\n*F\n+ 1 TextPreparedSelection.kt\nandroidx/compose/foundation/text/input/internal/selection/TextPreparedSelectionKt\n*L\n498#1:546,24\n*E\n"})
public final class TextPreparedSelectionKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @VisibleForTesting
    public static final int calculateAdjacentCursorPosition(@NotNull String str, int i, boolean z, @NotNull TransformedTextFieldState transformedTextFieldState) {
        int iFindFollowingBreak = z ? StringHelpers_androidKt.findFollowingBreak(str, i) : StringHelpers_androidKt.findPrecedingBreak(str, i);
        if (iFindFollowingBreak == -1) {
            return i;
        }
        long jM16397mapFromTransformedjx7JFs = transformedTextFieldState.m16397mapFromTransformedjx7JFs(iFindFollowingBreak);
        long jM16400mapToTransformedGEjPoXI = transformedTextFieldState.m16400mapToTransformedGEjPoXI(jM16397mapFromTransformedjx7JFs);
        int i2 = WhenMappings.$EnumSwitchMapping$0[((TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) && TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? (!TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement).ordinal()];
        if (i2 == 1 || i2 == 2) {
            return iFindFollowingBreak;
        }
        if (i2 == 3) {
            return z ? TextRange.m20451getEndimpl(jM16400mapToTransformedGEjPoXI) : TextRange.m20456getStartimpl(jM16400mapToTransformedGEjPoXI);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            if (iFindFollowingBreak == TextRange.m20456getStartimpl(jM16400mapToTransformedGEjPoXI)) {
                transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
                return iFindFollowingBreak;
            }
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return i;
        }
        if (iFindFollowingBreak == TextRange.m20451getEndimpl(jM16400mapToTransformedGEjPoXI)) {
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return iFindFollowingBreak;
        }
        transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
        return i;
    }
}
