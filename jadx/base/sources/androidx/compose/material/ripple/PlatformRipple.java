package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    @Composable
    private final ViewGroup findNearestViewGroup(Composer composer, int i) {
        composer.startReplaceableGroup(-1737891121);
        Object objConsume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        while (!(objConsume instanceof ViewGroup)) {
            ViewParent parent = ((View) objConsume).getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(AbstractC0622a.m1165k(objConsume, "Couldn't find a valid parent for ", ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            objConsume = parent;
        }
        ViewGroup viewGroup = (ViewGroup) objConsume;
        composer.endReplaceableGroup();
        return viewGroup;
    }

    @Override // androidx.compose.material.ripple.Ripple
    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberUpdatedRippleInstance-942rkJo */
    public RippleIndicationInstance mo16968rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z, float f, @NotNull State<Color> color, @NotNull State<RippleAlpha> rippleAlpha, @Nullable Composer composer, int i) {
        View rippleContainer;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        composer.startReplaceableGroup(331259447);
        ViewGroup viewGroupFindNearestViewGroup = findNearestViewGroup(composer, (i >> 15) & 14);
        composer.startReplaceableGroup(1643267286);
        if (viewGroupFindNearestViewGroup.isInEditMode()) {
            composer.startReplaceableGroup(-3686552);
            boolean zChanged = composer.changed(interactionSource) | composer.changed(this);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CommonRippleIndicationInstance commonRippleIndicationInstance = new CommonRippleIndicationInstance(z, f, color, rippleAlpha, null);
                composer.updateRememberedValue(commonRippleIndicationInstance);
                objRememberedValue = commonRippleIndicationInstance;
            }
            composer.endReplaceableGroup();
            CommonRippleIndicationInstance commonRippleIndicationInstance2 = (CommonRippleIndicationInstance) objRememberedValue;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return commonRippleIndicationInstance2;
        }
        composer.endReplaceableGroup();
        int childCount = viewGroupFindNearestViewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                rippleContainer = null;
                break;
            }
            rippleContainer = viewGroupFindNearestViewGroup.getChildAt(i2);
            if (rippleContainer instanceof RippleContainer) {
                break;
            }
            i2++;
        }
        if (rippleContainer == null) {
            Context context = viewGroupFindNearestViewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            rippleContainer = new RippleContainer(context);
            viewGroupFindNearestViewGroup.addView(rippleContainer);
        }
        composer.startReplaceableGroup(-3686095);
        boolean zChanged2 = composer.changed(interactionSource) | composer.changed(this) | composer.changed(rippleContainer);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            AndroidRippleIndicationInstance androidRippleIndicationInstance = new AndroidRippleIndicationInstance(z, f, color, rippleAlpha, (RippleContainer) rippleContainer, null);
            composer.updateRememberedValue(androidRippleIndicationInstance);
            objRememberedValue2 = androidRippleIndicationInstance;
        }
        composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance2 = (AndroidRippleIndicationInstance) objRememberedValue2;
        composer.endReplaceableGroup();
        return androidRippleIndicationInstance2;
    }

    private PlatformRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, null);
    }
}
