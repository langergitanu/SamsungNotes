package androidx.compose.foundation.text.input.internal;

import androidx.compose.p109ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00010\u0006H\u0080\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"getIndexTransformationType", "R", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "transformedQueryIndex", "", "onResult", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "Landroidx/compose/ui/text/TextRange;", "Lkotlin/ParameterName;", "name", "untransformed", "retransformed", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;ILkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TransformedTextFieldStateKt {
    public static final <R> R getIndexTransformationType(@NotNull TransformedTextFieldState transformedTextFieldState, int i, @NotNull Function3<? super IndexTransformationType, ? super TextRange, ? super TextRange, ? extends R> function3) {
        long jM16397mapFromTransformedjx7JFs = transformedTextFieldState.m16397mapFromTransformedjx7JFs(i);
        long jM16400mapToTransformedGEjPoXI = transformedTextFieldState.m16400mapToTransformedGEjPoXI(jM16397mapFromTransformedjx7JFs);
        return function3.invoke((TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) && TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? (!TextRange.m20450getCollapsedimpl(jM16397mapFromTransformedjx7JFs) || TextRange.m20450getCollapsedimpl(jM16400mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement, TextRange.m20444boximpl(jM16397mapFromTransformedjx7JFs), TextRange.m20444boximpl(jM16400mapToTransformedGEjPoXI));
    }
}
