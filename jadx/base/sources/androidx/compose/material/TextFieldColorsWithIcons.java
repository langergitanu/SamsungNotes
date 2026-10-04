package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m13886d2 = {"Landroidx/compose/material/TextFieldColorsWithIcons;", "Landroidx/compose/material/TextFieldColors;", "leadingIconColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trailingIconColor", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ExperimentalMaterialApi
public interface TextFieldColorsWithIcons extends TextFieldColors {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        @Composable
        @NotNull
        public static State<Color> leadingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
            if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, 1279189910)) {
                ComposerKt.traceEventStart(1279189910, i, -1, "androidx.compose.material.TextFieldColorsWithIcons.leadingIconColor (TextFieldDefaults.kt:159)");
            }
            State<Color> stateLeadingIconColor = textFieldColorsWithIcons.leadingIconColor(z, z2, composer, (i & 126) | ((i >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return stateLeadingIconColor;
        }

        @Composable
        @NotNull
        public static State<Color> trailingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
            if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, -712140408)) {
                ComposerKt.traceEventStart(-712140408, i, -1, "androidx.compose.material.TextFieldColorsWithIcons.trailingIconColor (TextFieldDefaults.kt:176)");
            }
            State<Color> stateTrailingIconColor = textFieldColorsWithIcons.trailingIconColor(z, z2, composer, (i & 126) | ((i >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return stateTrailingIconColor;
        }
    }

    @Composable
    @NotNull
    State<Color> leadingIconColor(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> trailingIconColor(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i);
}
