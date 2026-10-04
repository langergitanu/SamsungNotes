package androidx.compose.foundation.text.input.internal.selection;

import android.annotation.SuppressLint;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¨\u0006\n"}, m13886d2 = {"textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidTextFieldMagnifier_androidKt {
    @SuppressLint({"ModifierFactoryExtensionFunction", "ModifierFactoryReturnType"})
    @NotNull
    public static final TextFieldMagnifierNode textFieldMagnifierNode(@NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextFieldSelectionState textFieldSelectionState, @NotNull TextLayoutState textLayoutState, boolean z) {
        return Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) ? new TextFieldMagnifierNodeImpl28(transformedTextFieldState, textFieldSelectionState, textLayoutState, z) : new TextFieldMagnifierNode() { // from class: androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode.1
            @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
            public void update(@NotNull TransformedTextFieldState textFieldState, @NotNull TextFieldSelectionState textFieldSelectionState2, @NotNull TextLayoutState textLayoutState2, boolean visible) {
            }
        };
    }
}
