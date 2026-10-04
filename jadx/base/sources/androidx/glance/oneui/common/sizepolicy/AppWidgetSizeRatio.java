package androidx.glance.oneui.common.sizepolicy;

import android.util.Size;
import android.util.SizeF;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001b"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/AppWidgetSizeRatio;", "", "fromRatio", "Landroid/util/SizeF;", "toRatio", "(Landroid/util/SizeF;Landroid/util/SizeF;)V", "getFromRatio", "()Landroid/util/SizeF;", "getToRatio", "checkFitInSizeRange", "", "width", "", "height", "screenSize", "Landroid/util/Size;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toDp", "Lkotlin/Pair;", "toString", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class AppWidgetSizeRatio {

    @NotNull
    private final SizeF fromRatio;

    @NotNull
    private final SizeF toRatio;

    public AppWidgetSizeRatio(@NotNull SizeF fromRatio, @NotNull SizeF toRatio) {
        Intrinsics.checkNotNullParameter(fromRatio, "fromRatio");
        Intrinsics.checkNotNullParameter(toRatio, "toRatio");
        this.fromRatio = fromRatio;
        this.toRatio = toRatio;
    }

    public static /* synthetic */ AppWidgetSizeRatio copy$default(AppWidgetSizeRatio appWidgetSizeRatio, SizeF sizeF, SizeF sizeF2, int i, Object obj) {
        if ((i & 1) != 0) {
            sizeF = appWidgetSizeRatio.fromRatio;
        }
        if ((i & 2) != 0) {
            sizeF2 = appWidgetSizeRatio.toRatio;
        }
        return appWidgetSizeRatio.copy(sizeF, sizeF2);
    }

    public final boolean checkFitInSizeRange(float width, float height, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        int width2 = screenSize.getWidth();
        int height2 = screenSize.getHeight();
        GlanceLog.INSTANCE.m2301i("GWT:SizePolicy", "checkFitInSizeRange at " + screenSize + " / " + this.fromRatio + SQLKeyword.COMMA + this.toRatio);
        float f = (float) width2;
        if (width < this.fromRatio.getWidth() * f || width > this.toRatio.getWidth() * f) {
            return false;
        }
        float f4 = height2;
        return height >= this.fromRatio.getHeight() * f4 && height <= this.toRatio.getHeight() * f4;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SizeF getFromRatio() {
        return this.fromRatio;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SizeF getToRatio() {
        return this.toRatio;
    }

    @NotNull
    public final AppWidgetSizeRatio copy(@NotNull SizeF fromRatio, @NotNull SizeF toRatio) {
        Intrinsics.checkNotNullParameter(fromRatio, "fromRatio");
        Intrinsics.checkNotNullParameter(toRatio, "toRatio");
        return new AppWidgetSizeRatio(fromRatio, toRatio);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppWidgetSizeRatio)) {
            return false;
        }
        AppWidgetSizeRatio appWidgetSizeRatio = (AppWidgetSizeRatio) other;
        return Intrinsics.areEqual(this.fromRatio, appWidgetSizeRatio.fromRatio) && Intrinsics.areEqual(this.toRatio, appWidgetSizeRatio.toRatio);
    }

    @NotNull
    public final SizeF getFromRatio() {
        return this.fromRatio;
    }

    @NotNull
    public final SizeF getToRatio() {
        return this.toRatio;
    }

    public int hashCode() {
        return this.toRatio.hashCode() + (this.fromRatio.hashCode() * 31);
    }

    @NotNull
    public final Pair<SizeF, SizeF> toDp(@NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        int width = screenSize.getWidth();
        int height = screenSize.getHeight();
        GlanceLog.INSTANCE.m2301i("GWT:SizePolicy", "toDp / " + screenSize + " " + this.fromRatio + " " + this.toRatio);
        float f = (float) width;
        float f4 = (float) height;
        return new Pair<>(new SizeF(this.fromRatio.getWidth() * f, this.fromRatio.getHeight() * f4), new SizeF(this.toRatio.getWidth() * f, this.toRatio.getHeight() * f4));
    }

    @NotNull
    public String toString() {
        return "AppWidgetSizeRatio(fromRatio=" + this.fromRatio + ", toRatio=" + this.toRatio + ")";
    }
}
