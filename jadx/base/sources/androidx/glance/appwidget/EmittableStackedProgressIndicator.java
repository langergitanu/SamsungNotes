package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, m13886d2 = {"Landroidx/glance/appwidget/EmittableStackedProgressIndicator;", "Landroidx/glance/Emittable;", "()V", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "getBackgroundColor", "()Landroidx/glance/unit/ColorProvider;", "setBackgroundColor", "(Landroidx/glance/unit/ColorProvider;)V", "color", "getColor", "setColor", "indeterminate", "", "getIndeterminate", "()Z", "setIndeterminate", "(Z)V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "progress", "", "getProgress", "()F", "setProgress", "(F)V", "copy", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EmittableStackedProgressIndicator implements Emittable {
    public static final int $stable = 8;

    @NotNull
    private ColorProvider backgroundColor;

    @NotNull
    private ColorProvider color;
    private boolean indeterminate;

    @NotNull
    private GlanceModifier modifier = GlanceModifier.INSTANCE;
    private float progress;

    public EmittableStackedProgressIndicator() {
        ProgressIndicatorDefaults progressIndicatorDefaults = ProgressIndicatorDefaults.INSTANCE;
        this.color = progressIndicatorDefaults.getIndicatorColorProvider();
        this.backgroundColor = progressIndicatorDefaults.getBackgroundColorProvider();
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableStackedProgressIndicator emittableStackedProgressIndicator = new EmittableStackedProgressIndicator();
        emittableStackedProgressIndicator.setModifier(getModifier());
        emittableStackedProgressIndicator.progress = this.progress;
        emittableStackedProgressIndicator.indeterminate = this.indeterminate;
        emittableStackedProgressIndicator.color = this.color;
        emittableStackedProgressIndicator.backgroundColor = this.backgroundColor;
        return emittableStackedProgressIndicator;
    }

    @NotNull
    public final ColorProvider getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final ColorProvider getColor() {
        return this.color;
    }

    public final boolean getIndeterminate() {
        return this.indeterminate;
    }

    @Override // androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setBackgroundColor(@NotNull ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(colorProvider, "<set-?>");
        this.backgroundColor = colorProvider;
    }

    public final void setColor(@NotNull ColorProvider colorProvider) {
        Intrinsics.checkNotNullParameter(colorProvider, "<set-?>");
        this.color = colorProvider;
    }

    public final void setIndeterminate(boolean z) {
        this.indeterminate = z;
    }

    @Override // androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    public final void setProgress(float f) {
        this.progress = f;
    }

    @NotNull
    public String toString() {
        return "EmittableStackedProgressIndicator(modifier=" + getModifier() + ", progress=" + this.progress + ", indeterminate=" + this.indeterminate + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ")";
    }
}
