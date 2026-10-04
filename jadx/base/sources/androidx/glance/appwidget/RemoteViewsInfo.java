package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteViewsInfo;", "", "remoteViews", "Landroid/widget/RemoteViews;", "view", "Landroidx/glance/appwidget/InsertedViewInfo;", "(Landroid/widget/RemoteViews;Landroidx/glance/appwidget/InsertedViewInfo;)V", "getRemoteViews", "()Landroid/widget/RemoteViews;", "getView", "()Landroidx/glance/appwidget/InsertedViewInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class RemoteViewsInfo {
    public static final int $stable = 8;

    @NotNull
    private final RemoteViews remoteViews;

    @NotNull
    private final InsertedViewInfo view;

    public RemoteViewsInfo(@NotNull RemoteViews remoteViews, @NotNull InsertedViewInfo view) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(view, "view");
        this.remoteViews = remoteViews;
        this.view = view;
    }

    public static /* synthetic */ RemoteViewsInfo copy$default(RemoteViewsInfo remoteViewsInfo, RemoteViews remoteViews, InsertedViewInfo insertedViewInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteViews = remoteViewsInfo.remoteViews;
        }
        if ((i & 2) != 0) {
            insertedViewInfo = remoteViewsInfo.view;
        }
        return remoteViewsInfo.copy(remoteViews, insertedViewInfo);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RemoteViews getRemoteViews() {
        return this.remoteViews;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InsertedViewInfo getView() {
        return this.view;
    }

    @NotNull
    public final RemoteViewsInfo copy(@NotNull RemoteViews remoteViews, @NotNull InsertedViewInfo view) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(view, "view");
        return new RemoteViewsInfo(remoteViews, view);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteViewsInfo)) {
            return false;
        }
        RemoteViewsInfo remoteViewsInfo = (RemoteViewsInfo) other;
        return Intrinsics.areEqual(this.remoteViews, remoteViewsInfo.remoteViews) && Intrinsics.areEqual(this.view, remoteViewsInfo.view);
    }

    @NotNull
    public final RemoteViews getRemoteViews() {
        return this.remoteViews;
    }

    @NotNull
    public final InsertedViewInfo getView() {
        return this.view;
    }

    public int hashCode() {
        return this.view.hashCode() + (this.remoteViews.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "RemoteViewsInfo(remoteViews=" + this.remoteViews + ", view=" + this.view + ")";
    }
}
