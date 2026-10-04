package androidx.core.widget;

import androidx.core.util.SizeFCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/core/widget/LandscapePortraitSizes;", "", "landscape", "Landroidx/core/util/SizeFCompat;", "portrait", "(Landroidx/core/util/SizeFCompat;Landroidx/core/util/SizeFCompat;)V", "getLandscape", "()Landroidx/core/util/SizeFCompat;", "getPortrait", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class LandscapePortraitSizes {

    @NotNull
    private final SizeFCompat landscape;

    @NotNull
    private final SizeFCompat portrait;

    public LandscapePortraitSizes(@NotNull SizeFCompat landscape, @NotNull SizeFCompat portrait) {
        Intrinsics.checkNotNullParameter(landscape, "landscape");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        this.landscape = landscape;
        this.portrait = portrait;
    }

    public static /* synthetic */ LandscapePortraitSizes copy$default(LandscapePortraitSizes landscapePortraitSizes, SizeFCompat sizeFCompat, SizeFCompat sizeFCompat2, int i, Object obj) {
        if ((i & 1) != 0) {
            sizeFCompat = landscapePortraitSizes.landscape;
        }
        if ((i & 2) != 0) {
            sizeFCompat2 = landscapePortraitSizes.portrait;
        }
        return landscapePortraitSizes.copy(sizeFCompat, sizeFCompat2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SizeFCompat getLandscape() {
        return this.landscape;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SizeFCompat getPortrait() {
        return this.portrait;
    }

    @NotNull
    public final LandscapePortraitSizes copy(@NotNull SizeFCompat landscape, @NotNull SizeFCompat portrait) {
        Intrinsics.checkNotNullParameter(landscape, "landscape");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        return new LandscapePortraitSizes(landscape, portrait);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LandscapePortraitSizes)) {
            return false;
        }
        LandscapePortraitSizes landscapePortraitSizes = (LandscapePortraitSizes) other;
        return Intrinsics.areEqual(this.landscape, landscapePortraitSizes.landscape) && Intrinsics.areEqual(this.portrait, landscapePortraitSizes.portrait);
    }

    @NotNull
    public final SizeFCompat getLandscape() {
        return this.landscape;
    }

    @NotNull
    public final SizeFCompat getPortrait() {
        return this.portrait;
    }

    public int hashCode() {
        return this.portrait.hashCode() + (this.landscape.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "LandscapePortraitSizes(landscape=" + this.landscape + ", portrait=" + this.portrait + PropertyUtils.MAPPED_DELIM2;
    }
}
