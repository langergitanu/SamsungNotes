package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/appwidget/ClipToOutlineModifier;", "Landroidx/glance/GlanceModifier$Element;", "clip", "", "(Z)V", "getClip", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ClipToOutlineModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final boolean clip;

    public ClipToOutlineModifier(boolean z) {
        this.clip = z;
    }

    public static /* synthetic */ ClipToOutlineModifier copy$default(ClipToOutlineModifier clipToOutlineModifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = clipToOutlineModifier.clip;
        }
        return clipToOutlineModifier.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final ClipToOutlineModifier copy(boolean clip) {
        return new ClipToOutlineModifier(clip);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClipToOutlineModifier) && this.clip == ((ClipToOutlineModifier) other).clip;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public int hashCode() {
        return Boolean.hashCode(this.clip);
    }

    @NotNull
    public String toString() {
        return "ClipToOutlineModifier(clip=" + this.clip + ")";
    }
}
