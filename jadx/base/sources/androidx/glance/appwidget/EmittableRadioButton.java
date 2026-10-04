package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.Emittable;
import androidx.glance.EmittableCheckable;
import androidx.glance.GlanceModifier;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/appwidget/EmittableRadioButton;", "Landroidx/glance/EmittableCheckable;", "colors", "Landroidx/glance/appwidget/RadioButtonColors;", "(Landroidx/glance/appwidget/RadioButtonColors;)V", "getColors", "()Landroidx/glance/appwidget/RadioButtonColors;", "setColors", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EmittableRadioButton extends EmittableCheckable {
    public static final int $stable = 8;

    @NotNull
    private RadioButtonColors colors;
    private boolean enabled;

    @NotNull
    private GlanceModifier modifier;

    public EmittableRadioButton(@NotNull RadioButtonColors colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.modifier = GlanceModifier.INSTANCE;
        this.enabled = true;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableRadioButton emittableRadioButton = new EmittableRadioButton(this.colors);
        emittableRadioButton.setModifier(getModifier());
        emittableRadioButton.setChecked(getChecked());
        emittableRadioButton.enabled = this.enabled;
        emittableRadioButton.setText(getText());
        emittableRadioButton.setStyle(getStyle());
        emittableRadioButton.setMaxLines(getMaxLines());
        return emittableRadioButton;
    }

    @NotNull
    public final RadioButtonColors getColors() {
        return this.colors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    public final void setColors(@NotNull RadioButtonColors radioButtonColors) {
        Intrinsics.checkNotNullParameter(radioButtonColors, "<set-?>");
        this.colors = radioButtonColors;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    @NotNull
    public String toString() {
        String text = getText();
        GlanceModifier modifier = getModifier();
        boolean checked = getChecked();
        boolean z = this.enabled;
        String text2 = getText();
        TextStyle style = getStyle();
        RadioButtonColors radioButtonColors = this.colors;
        int maxLines = getMaxLines();
        StringBuilder sb = new StringBuilder("EmittableRadioButton(");
        sb.append(text);
        sb.append(", modifier=");
        sb.append(modifier);
        sb.append(", checked=");
        AbstractC2821a.m2208C(sb, checked, ", enabled=", z, ", text=");
        sb.append(text2);
        sb.append(", style=");
        sb.append(style);
        sb.append(", colors=");
        sb.append(radioButtonColors);
        sb.append(", maxLines=");
        sb.append(maxLines);
        sb.append(", )");
        return sb.toString();
    }
}
