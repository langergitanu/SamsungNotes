package androidx.glance.action;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\t\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\r\u001a\u00020\u0001\u001a)\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u000e\u001a5\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\r\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"NoRippleOverride", "", "clickable", "Landroidx/glance/GlanceModifier;", "block", "Lkotlin/Function0;", "", "(Landroidx/glance/GlanceModifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/glance/GlanceModifier;", "onClick", "Landroidx/glance/action/Action;", "enabled", "", "removeRipple", "rippleOverride", "(Landroidx/glance/GlanceModifier;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "key", "", "(Landroidx/glance/GlanceModifier;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/glance/GlanceModifier;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ActionKt {

    @DrawableRes
    public static final int NoRippleOverride = 0;

    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @NotNull Action onClick) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return glanceModifier.then(new ActionModifier(onClick, 0, false, false, 14, null));
    }

    public static /* synthetic */ GlanceModifier clickable$default(GlanceModifier glanceModifier, Action action, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return clickable(glanceModifier, action, i);
    }

    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @NotNull Action onClick, boolean z) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return glanceModifier.then(new ActionModifier(onClick, 0, z, false, 10, null));
    }

    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @NotNull Action onClick, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return glanceModifier.then(new ActionModifier(onClick, 0, z, z2, 2, null));
    }

    @Composable
    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @NotNull Function0<Unit> block, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-752811653);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-752811653, i, -1, "androidx.glance.action.clickable (Action.kt:66)");
        }
        GlanceModifier glanceModifierThen = glanceModifier.then(new ActionModifier(LambdaActionKt.action(null, block, composer, i & 112, 1), 0, false, false, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @Composable
    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @DrawableRes int i, @NotNull Function0<Unit> block, @Nullable Composer composer, int i2, int i4) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(64479992);
        if ((i4 & 1) != 0) {
            i = 0;
        }
        int i5 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(64479992, i2, -1, "androidx.glance.action.clickable (Action.kt:80)");
        }
        GlanceModifier glanceModifierThen = glanceModifier.then(new ActionModifier(LambdaActionKt.action(null, block, composer, (i2 >> 3) & 112, 1), i5, false, false, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }

    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @NotNull Action onClick, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return glanceModifier.then(new ActionModifier(onClick, i, false, false, 12, null));
    }

    @Composable
    @ExperimentalGlanceApi
    @NotNull
    public static final GlanceModifier clickable(@NotNull GlanceModifier glanceModifier, @Nullable String str, @DrawableRes int i, @NotNull Function0<Unit> block, @Nullable Composer composer, int i2, int i4) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-1255556739);
        if ((i4 & 1) != 0) {
            str = null;
        }
        int i5 = (i4 & 2) != 0 ? 0 : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1255556739, i2, -1, "androidx.glance.action.clickable (Action.kt:113)");
        }
        GlanceModifier glanceModifierThen = glanceModifier.then(new ActionModifier(LambdaActionKt.action(str, block, composer, ((i2 >> 3) & 14) | ((i2 >> 6) & 112), 0), i5, false, false, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glanceModifierThen;
    }
}
