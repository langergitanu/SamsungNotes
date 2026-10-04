package androidx.glance.action;

import androidx.annotation.DrawableRes;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/action/ActionModifier;", "Landroidx/glance/GlanceModifier$Element;", "action", "Landroidx/glance/action/Action;", "rippleOverride", "", "enabled", "", "removeRipple", "(Landroidx/glance/action/Action;IZZ)V", "getAction", "()Landroidx/glance/action/Action;", "getEnabled", "()Z", "getRemoveRipple", "getRippleOverride", "()I", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ActionModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @NotNull
    private final Action action;
    private final boolean enabled;
    private final boolean removeRipple;
    private final int rippleOverride;

    public ActionModifier(@NotNull Action action, @DrawableRes int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.rippleOverride = i;
        this.enabled = z;
        this.removeRipple = z2;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getRemoveRipple() {
        return this.removeRipple;
    }

    public final int getRippleOverride() {
        return this.rippleOverride;
    }

    @NotNull
    public String toString() {
        return "ActionModifier(action=" + this.action + ", rippleOverride=" + this.rippleOverride + ")";
    }

    public /* synthetic */ ActionModifier(Action action, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(action, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? false : z2);
    }
}
