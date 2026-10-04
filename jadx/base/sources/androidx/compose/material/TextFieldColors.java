package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0007J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH'ø\u0001\u0000¢\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH'ø\u0001\u0000¢\u0006\u0002\u0010\rJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0007J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/material/TextFieldColors;", "", "backgroundColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "cursorColor", "isError", "indicatorColor", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "leadingIconColor", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "placeholderColor", "textColor", "trailingIconColor", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface TextFieldColors {
    @Composable
    @NotNull
    State<Color> backgroundColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> cursorColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> indicatorColor(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> labelColor(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> leadingIconColor(boolean z, boolean z2, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> placeholderColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> textColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> trailingIconColor(boolean z, boolean z2, @Nullable Composer composer, int i);
}
