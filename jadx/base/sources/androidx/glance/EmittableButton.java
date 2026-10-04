package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/EmittableButton;", "Landroidx/glance/EmittableWithText;", "()V", "colors", "Landroidx/glance/ButtonColors;", "getColors", "()Landroidx/glance/ButtonColors;", "setColors", "(Landroidx/glance/ButtonColors;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EmittableButton extends EmittableWithText {
    public static final int $stable = 8;

    @Nullable
    private ButtonColors colors;

    @NotNull
    private GlanceModifier modifier = GlanceModifier.INSTANCE;
    private boolean enabled = true;

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableButton emittableButton = new EmittableButton();
        emittableButton.setModifier(getModifier());
        emittableButton.setText(getText());
        emittableButton.setStyle(getStyle());
        emittableButton.colors = this.colors;
        emittableButton.enabled = this.enabled;
        emittableButton.setMaxLines(getMaxLines());
        return emittableButton;
    }

    @Nullable
    public final ButtonColors getColors() {
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

    public final void setColors(@Nullable ButtonColors buttonColors) {
        this.colors = buttonColors;
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
        boolean z = this.enabled;
        TextStyle style = getStyle();
        ButtonColors buttonColors = this.colors;
        GlanceModifier modifier = getModifier();
        int maxLines = getMaxLines();
        StringBuilder sbM2229t = AbstractC2821a.m2229t("EmittableButton('", text, "', enabled=", z, ", style=");
        sbM2229t.append(style);
        sbM2229t.append(", colors=");
        sbM2229t.append(buttonColors);
        sbM2229t.append(" modifier=");
        sbM2229t.append(modifier);
        sbM2229t.append(", maxLines=");
        sbM2229t.append(maxLines);
        sbM2229t.append(")");
        return sbM2229t.toString();
    }
}
