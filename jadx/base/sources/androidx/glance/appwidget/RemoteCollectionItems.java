package androidx.glance.appwidget;

import android.annotation.SuppressLint;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteCollectionItems;", "", DialogConstant.BUNDLE_IDS, "", "views", "", "Landroid/widget/RemoteViews;", "hasStableIds", "", "_viewTypeCount", "", "([J[Landroid/widget/RemoteViews;ZI)V", "itemCount", "getItemCount", "()I", "viewTypeCount", "getViewTypeCount", "[Landroid/widget/RemoteViews;", "getItemId", "", "position", "getItemView", "Builder", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRemoteCollectionItems.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteCollectionItems.kt\nandroidx/glance/appwidget/RemoteCollectionItems\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,154:1\n1#2:155\n11065#3:156\n11400#3,3:157\n26#4:160\n*S KotlinDebug\n*F\n+ 1 RemoteCollectionItems.kt\nandroidx/glance/appwidget/RemoteCollectionItems\n*L\n34#1:156\n34#1:157,3\n148#1:160\n*E\n"})
public final class RemoteCollectionItems {
    private final int _viewTypeCount;
    private final boolean hasStableIds;

    @NotNull
    private final long[] ids;

    @NotNull
    private final RemoteViews[] views;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final RemoteCollectionItems Empty = new RemoteCollectionItems(new long[0], new RemoteViews[0], false, 1);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteCollectionItems$Builder;", "", "()V", "hasStableIds", "", DialogConstant.BUNDLE_IDS, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "viewTypeCount", "", "views", "Landroid/widget/RemoteViews;", "addItem", "id", "view", "build", "Landroidx/glance/appwidget/RemoteCollectionItems;", "setHasStableIds", "setViewTypeCount", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteCollectionItems.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteCollectionItems.kt\nandroidx/glance/appwidget/RemoteCollectionItems$Builder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,154:1\n1549#2:155\n1620#2,3:156\n37#3,2:159\n*S KotlinDebug\n*F\n+ 1 RemoteCollectionItems.kt\nandroidx/glance/appwidget/RemoteCollectionItems$Builder\n*L\n134#1:155\n134#1:156,3\n138#1:159,2\n*E\n"})
    public static final class Builder {
        public static final int $stable = 8;
        private boolean hasStableIds;
        private int viewTypeCount;

        @NotNull
        private final ArrayList<Long> ids = new ArrayList<>();

        @NotNull
        private final ArrayList<RemoteViews> views = new ArrayList<>();

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NotNull
        public final Builder addItem(long id, @NotNull RemoteViews view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.ids.add(Long.valueOf(id));
            this.views.add(view);
            return this;
        }

        @NotNull
        public final RemoteCollectionItems build() {
            if (this.viewTypeCount < 1) {
                ArrayList<RemoteViews> arrayList = this.views;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Integer.valueOf(((RemoteViews) it.next()).getLayoutId()));
                }
                this.viewTypeCount = CollectionsKt.distinct(arrayList2).size();
            }
            return new RemoteCollectionItems(CollectionsKt.toLongArray(this.ids), (RemoteViews[]) this.views.toArray(new RemoteViews[0]), this.hasStableIds, Math.max(this.viewTypeCount, 1), null);
        }

        @NotNull
        public final Builder setHasStableIds(boolean hasStableIds) {
            this.hasStableIds = hasStableIds;
            return this;
        }

        @NotNull
        public final Builder setViewTypeCount(int viewTypeCount) {
            this.viewTypeCount = viewTypeCount;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/RemoteCollectionItems$Companion;", "", "()V", "Empty", "Landroidx/glance/appwidget/RemoteCollectionItems;", "getEmpty", "()Landroidx/glance/appwidget/RemoteCollectionItems;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RemoteCollectionItems getEmpty() {
            return RemoteCollectionItems.Empty;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RemoteCollectionItems(long[] jArr, RemoteViews[] remoteViewsArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr, remoteViewsArr, z, i);
    }

    public final int getItemCount() {
        return this.ids.length;
    }

    public final long getItemId(int position) {
        return this.ids[position];
    }

    @NotNull
    public final RemoteViews getItemView(int position) {
        return this.views[position];
    }

    /* JADX INFO: renamed from: getViewTypeCount, reason: from getter */
    public final int get_viewTypeCount() {
        return this._viewTypeCount;
    }

    /* JADX INFO: renamed from: hasStableIds, reason: from getter */
    public final boolean getHasStableIds() {
        return this.hasStableIds;
    }

    private RemoteCollectionItems(long[] jArr, RemoteViews[] remoteViewsArr, boolean z, int i) {
        this.ids = jArr;
        this.views = remoteViewsArr;
        this.hasStableIds = z;
        this._viewTypeCount = i;
        if (jArr.length != remoteViewsArr.length) {
            throw new IllegalArgumentException("RemoteCollectionItems has different number of ids and views");
        }
        if (i < 1) {
            throw new IllegalArgumentException("View type count must be >= 1");
        }
        ArrayList arrayList = new ArrayList(remoteViewsArr.length);
        for (RemoteViews remoteViews : remoteViewsArr) {
            arrayList.add(Integer.valueOf(remoteViews.getLayoutId()));
        }
        int size = CollectionsKt.distinct(arrayList).size();
        int i2 = this._viewTypeCount;
        if (size > i2) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i2, size, "View type count is set to ", ", but the collection contains ", " different layout ids").toString());
        }
    }
}
