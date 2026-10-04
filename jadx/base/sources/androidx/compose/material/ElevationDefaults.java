package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p109ui.unit.C2256Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m13886d2 = {"Landroidx/compose/material/ElevationDefaults;", "", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class ElevationDefaults {

    @NotNull
    public static final ElevationDefaults INSTANCE = new ElevationDefaults();

    private ElevationDefaults() {
    }

    @Nullable
    public final AnimationSpec<C2256Dp> incomingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if ((interaction instanceof PressInteraction.Press) || (interaction instanceof DragInteraction.Start) || (interaction instanceof HoverInteraction.Enter) || (interaction instanceof FocusInteraction.Focus)) {
            return ElevationKt.DefaultIncomingSpec;
        }
        return null;
    }

    @Nullable
    public final AnimationSpec<C2256Dp> outgoingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        if (!(interaction instanceof PressInteraction.Press) && !(interaction instanceof DragInteraction.Start)) {
            if (interaction instanceof HoverInteraction.Enter) {
                return ElevationKt.HoveredOutgoingSpec;
            }
            if (interaction instanceof FocusInteraction.Focus) {
                return ElevationKt.DefaultOutgoingSpec;
            }
            return null;
        }
        return ElevationKt.DefaultOutgoingSpec;
    }
}
