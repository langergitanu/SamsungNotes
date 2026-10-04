package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/appwidget/SwitchColorsImpl;", "Landroidx/glance/appwidget/SwitchColors;", "thumb", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "track", "(Landroidx/glance/appwidget/unit/CheckableColorProvider;Landroidx/glance/appwidget/unit/CheckableColorProvider;)V", "getThumb$glance_appwidget_release", "()Landroidx/glance/appwidget/unit/CheckableColorProvider;", "getTrack$glance_appwidget_release", "component1", "component1$glance_appwidget_release", "component2", "component2$glance_appwidget_release", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class SwitchColorsImpl extends SwitchColors {
    public static final int $stable = 0;

    @NotNull
    private final CheckableColorProvider thumb;

    @NotNull
    private final CheckableColorProvider track;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchColorsImpl(@NotNull CheckableColorProvider thumb, @NotNull CheckableColorProvider track) {
        super(null);
        Intrinsics.checkNotNullParameter(thumb, "thumb");
        Intrinsics.checkNotNullParameter(track, "track");
        this.thumb = thumb;
        this.track = track;
    }

    public static /* synthetic */ SwitchColorsImpl copy$default(SwitchColorsImpl switchColorsImpl, CheckableColorProvider checkableColorProvider, CheckableColorProvider checkableColorProvider2, int i, Object obj) {
        if ((i & 1) != 0) {
            checkableColorProvider = switchColorsImpl.thumb;
        }
        if ((i & 2) != 0) {
            checkableColorProvider2 = switchColorsImpl.track;
        }
        return switchColorsImpl.copy(checkableColorProvider, checkableColorProvider2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1$glance_appwidget_release, reason: from getter */
    public final CheckableColorProvider getThumb() {
        return this.thumb;
    }

    @NotNull
    /* JADX INFO: renamed from: component2$glance_appwidget_release, reason: from getter */
    public final CheckableColorProvider getTrack() {
        return this.track;
    }

    @NotNull
    public final SwitchColorsImpl copy(@NotNull CheckableColorProvider thumb, @NotNull CheckableColorProvider track) {
        Intrinsics.checkNotNullParameter(thumb, "thumb");
        Intrinsics.checkNotNullParameter(track, "track");
        return new SwitchColorsImpl(thumb, track);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchColorsImpl)) {
            return false;
        }
        SwitchColorsImpl switchColorsImpl = (SwitchColorsImpl) other;
        return Intrinsics.areEqual(this.thumb, switchColorsImpl.thumb) && Intrinsics.areEqual(this.track, switchColorsImpl.track);
    }

    @Override // androidx.glance.appwidget.SwitchColors
    @NotNull
    public CheckableColorProvider getThumb$glance_appwidget_release() {
        return this.thumb;
    }

    @Override // androidx.glance.appwidget.SwitchColors
    @NotNull
    public CheckableColorProvider getTrack$glance_appwidget_release() {
        return this.track;
    }

    public int hashCode() {
        return this.track.hashCode() + (this.thumb.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "SwitchColorsImpl(thumb=" + this.thumb + ", track=" + this.track + ")";
    }
}
