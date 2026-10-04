package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableCheckable;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/appwidget/EmittableSwitch;", "Landroidx/glance/EmittableCheckable;", "colors", "Landroidx/glance/appwidget/SwitchColors;", "(Landroidx/glance/appwidget/SwitchColors;)V", "getColors", "()Landroidx/glance/appwidget/SwitchColors;", "setColors", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EmittableSwitch extends EmittableCheckable {
    public static final int $stable = 8;

    @NotNull
    private SwitchColors colors;

    @NotNull
    private GlanceModifier modifier;

    public EmittableSwitch(@NotNull SwitchColors colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.modifier = GlanceModifier.INSTANCE;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableSwitch emittableSwitch = new EmittableSwitch(this.colors);
        emittableSwitch.setModifier(getModifier());
        emittableSwitch.setChecked(getChecked());
        emittableSwitch.setText(getText());
        emittableSwitch.setStyle(getStyle());
        emittableSwitch.setMaxLines(getMaxLines());
        return emittableSwitch;
    }

    @NotNull
    public final SwitchColors getColors() {
        return this.colors;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    public final void setColors(@NotNull SwitchColors switchColors) {
        Intrinsics.checkNotNullParameter(switchColors, "<set-?>");
        this.colors = switchColors;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    @NotNull
    public String toString() {
        return "EmittableSwitch(" + getText() + ", modifier=" + getModifier() + ", checked=" + getChecked() + ", style=" + getStyle() + ", colors=" + this.colors + ", maxLines=" + getMaxLines() + ")";
    }
}
