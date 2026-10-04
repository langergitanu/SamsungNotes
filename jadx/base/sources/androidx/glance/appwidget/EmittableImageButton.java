package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.Emittable;
import androidx.glance.EmittableImage;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/EmittableImageButton;", "Landroidx/glance/EmittableImage;", "()V", "modifier", "Landroidx/glance/GlanceModifier;", "getModifier", "()Landroidx/glance/GlanceModifier;", "setModifier", "(Landroidx/glance/GlanceModifier;)V", "copy", "Landroidx/glance/Emittable;", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class EmittableImageButton extends EmittableImage {
    public static final int $stable = 8;

    @NotNull
    private GlanceModifier modifier = GlanceModifier.INSTANCE;

    @Override // androidx.glance.EmittableImage, androidx.glance.Emittable
    @NotNull
    public Emittable copy() {
        EmittableImageButton emittableImageButton = new EmittableImageButton();
        emittableImageButton.setModifier(getModifier());
        emittableImageButton.setProvider(getProvider());
        emittableImageButton.setColorFilterParams(getColorFilterParams());
        emittableImageButton.m21258setContentScaleHwT0Evw(getContentScale());
        return emittableImageButton;
    }

    @Override // androidx.glance.EmittableImage, androidx.glance.Emittable
    @NotNull
    public GlanceModifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.glance.EmittableImage, androidx.glance.Emittable
    public void setModifier(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<set-?>");
        this.modifier = glanceModifier;
    }

    @Override // androidx.glance.EmittableImage
    @NotNull
    public String toString() {
        return "EmittableImageButton(modifier=" + getModifier() + ", provider=" + getProvider() + ", colorFilterParams=" + getColorFilterParams() + ", contentScale=" + androidx.glance.layout.ContentScale.m21463toStringimpl(getContentScale()) + ")";
    }
}
