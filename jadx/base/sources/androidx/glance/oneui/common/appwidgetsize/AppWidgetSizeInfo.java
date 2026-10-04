package androidx.glance.oneui.common.appwidgetsize;

import android.util.SizeF;
import androidx.collection.AbstractC0622a;
import androidx.glance.oneui.common.AppWidgetSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0016\u0010\u0014\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\nJ1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\"\u0010\u0006\u001a\u00020\u0007X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, m13886d2 = {"Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "", "dpSize", "Landroid/util/SizeF;", "spanSize", "Landroidx/glance/oneui/common/appwidgetsize/SpanSize;", "appWidgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "(Landroid/util/SizeF;Landroidx/glance/oneui/common/appwidgetsize/SpanSize;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAppWidgetSize-rx25Pp4", "()I", "setAppWidgetSize-L2j3NV4", "(I)V", "I", "getDpSize", "()Landroid/util/SizeF;", "getSpanSize", "()Landroidx/glance/oneui/common/appwidgetsize/SpanSize;", "component1", "component2", "component3", "component3-rx25Pp4", "copy", "copy-nwm-oUQ", "(Landroid/util/SizeF;Landroidx/glance/oneui/common/appwidgetsize/SpanSize;I)Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "equals", "", "other", "hashCode", "", "toString", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class AppWidgetSizeInfo {
    private int appWidgetSize;

    @NotNull
    private final SizeF dpSize;

    @NotNull
    private final SpanSize spanSize;

    public /* synthetic */ AppWidgetSizeInfo(SizeF sizeF, SpanSize spanSize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sizeF, spanSize, i);
    }

    /* JADX INFO: renamed from: copy-nwm-oUQ$default, reason: not valid java name */
    public static /* synthetic */ AppWidgetSizeInfo m21615copynwmoUQ$default(AppWidgetSizeInfo appWidgetSizeInfo, SizeF sizeF, SpanSize spanSize, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sizeF = appWidgetSizeInfo.dpSize;
        }
        if ((i2 & 2) != 0) {
            spanSize = appWidgetSizeInfo.spanSize;
        }
        if ((i2 & 4) != 0) {
            i = appWidgetSizeInfo.appWidgetSize;
        }
        return appWidgetSizeInfo.m21617copynwmoUQ(sizeF, spanSize, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SizeF getDpSize() {
        return this.dpSize;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SpanSize getSpanSize() {
        return this.spanSize;
    }

    /* JADX INFO: renamed from: component3-rx25Pp4, reason: not valid java name and from getter */
    public final int getAppWidgetSize() {
        return this.appWidgetSize;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-nwm-oUQ, reason: not valid java name */
    public final AppWidgetSizeInfo m21617copynwmoUQ(@NotNull SizeF dpSize, @NotNull SpanSize spanSize, int appWidgetSize) {
        Intrinsics.checkNotNullParameter(dpSize, "dpSize");
        Intrinsics.checkNotNullParameter(spanSize, "spanSize");
        return new AppWidgetSizeInfo(dpSize, spanSize, appWidgetSize, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppWidgetSizeInfo)) {
            return false;
        }
        AppWidgetSizeInfo appWidgetSizeInfo = (AppWidgetSizeInfo) other;
        return Intrinsics.areEqual(this.dpSize, appWidgetSizeInfo.dpSize) && Intrinsics.areEqual(this.spanSize, appWidgetSizeInfo.spanSize) && AppWidgetSize.m21550equalsimpl0(this.appWidgetSize, appWidgetSizeInfo.appWidgetSize);
    }

    /* JADX INFO: renamed from: getAppWidgetSize-rx25Pp4, reason: not valid java name */
    public final int m21618getAppWidgetSizerx25Pp4() {
        return this.appWidgetSize;
    }

    @NotNull
    public final SizeF getDpSize() {
        return this.dpSize;
    }

    @NotNull
    public final SpanSize getSpanSize() {
        return this.spanSize;
    }

    public int hashCode() {
        return AppWidgetSize.m21551hashCodeimpl(this.appWidgetSize) + ((this.spanSize.hashCode() + (this.dpSize.hashCode() * 31)) * 31);
    }

    /* JADX INFO: renamed from: setAppWidgetSize-L2j3NV4, reason: not valid java name */
    public final void m21619setAppWidgetSizeL2j3NV4(int i) {
        this.appWidgetSize = i;
    }

    @NotNull
    public String toString() {
        SizeF sizeF = this.dpSize;
        SpanSize spanSize = this.spanSize;
        String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(this.appWidgetSize);
        StringBuilder sb = new StringBuilder("AppWidgetSizeInfo(dpSize=");
        sb.append(sizeF);
        sb.append(", spanSize=");
        sb.append(spanSize);
        sb.append(", appWidgetSize=");
        return AbstractC0622a.m1170p(strM21559toStringimpl, ")", sb);
    }

    private AppWidgetSizeInfo(SizeF dpSize, SpanSize spanSize, int i) {
        Intrinsics.checkNotNullParameter(dpSize, "dpSize");
        Intrinsics.checkNotNullParameter(spanSize, "spanSize");
        this.dpSize = dpSize;
        this.spanSize = spanSize;
        this.appWidgetSize = i;
    }

    public /* synthetic */ AppWidgetSizeInfo(SizeF sizeF, SpanSize spanSize, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new SizeF(0.0f, 0.0f) : sizeF, (i2 & 2) != 0 ? new SpanSize(0, 0) : spanSize, (i2 & 4) != 0 ? AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4() : i, null);
    }
}
