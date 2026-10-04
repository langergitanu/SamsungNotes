package androidx.glance.appwidget.translators;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.Emittable;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.GlanceRemoteViewsServiceKt;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutConfiguration;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.RemoteCollectionItems;
import androidx.glance.appwidget.RemoteViewsTranslatorKt;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGrid;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem;
import androidx.glance.appwidget.lazy.GridCells;
import androidx.glance.appwidget.lazy.LazyListKt;
import androidx.glance.layout.Alignment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"LazyVerticalGridItemStartingViewId", "", "toLayout", "Landroidx/glance/appwidget/LayoutType;", "Landroidx/glance/appwidget/lazy/GridCells;", "translateEmittableLazyVerticalGrid", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/lazy/EmittableLazyVerticalGrid;", "viewDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "translateEmittableLazyVerticalGridListItem", "Landroidx/glance/appwidget/lazy/EmittableLazyVerticalGridListItem;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyVerticalGridTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGridTranslator.kt\nandroidx/glance/appwidget/translators/LazyVerticalGridTranslatorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1804#2,4:151\n1#3:155\n*S KotlinDebug\n*F\n+ 1 LazyVerticalGridTranslator.kt\nandroidx/glance/appwidget/translators/LazyVerticalGridTranslatorKt\n*L\n91#1:151,4\n*E\n"})
public final class LazyVerticalGridTranslatorKt {
    private static final int LazyVerticalGridItemStartingViewId = 1048576;

    private static final LayoutType toLayout(GridCells gridCells) {
        return Intrinsics.areEqual(gridCells, new GridCells.Fixed(1)) ? LayoutType.VerticalGridOneColumn : Intrinsics.areEqual(gridCells, new GridCells.Fixed(2)) ? LayoutType.VerticalGridTwoColumns : Intrinsics.areEqual(gridCells, new GridCells.Fixed(3)) ? LayoutType.VerticalGridThreeColumns : Intrinsics.areEqual(gridCells, new GridCells.Fixed(4)) ? LayoutType.VerticalGridFourColumns : Intrinsics.areEqual(gridCells, new GridCells.Fixed(5)) ? LayoutType.VerticalGridFiveColumns : LayoutType.VerticalGridAutoFit;
    }

    public static final void translateEmittableLazyVerticalGrid(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableLazyVerticalGrid element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        translateEmittableLazyVerticalGrid(remoteViews, translationContext, element, LayoutSelectionKt.insertView(remoteViews, translationContext, toLayout(element.getGridCells()), element.getModifier()));
    }

    public static final void translateEmittableLazyVerticalGridListItem(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableLazyVerticalGridListItem element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.getChildren().size() != 1 || !Intrinsics.areEqual(element.getAlignment(), Alignment.INSTANCE.getCenterStart())) {
            throw new IllegalArgumentException("Lazy vertical grid items can only have a single child align at the center start of the view. The normalization of the composition tree failed.");
        }
        RemoteViewsTranslatorKt.translateChild(remoteViews, translationContext, (Emittable) CollectionsKt.first((List) element.getChildren()));
    }

    private static final void translateEmittableLazyVerticalGrid(RemoteViews remoteViews, TranslationContext translationContext, EmittableLazyVerticalGrid emittableLazyVerticalGrid, InsertedViewInfo insertedViewInfo) {
        int count;
        if (!translationContext.isLazyCollectionDescendant()) {
            GridCells gridCells = emittableLazyVerticalGrid.getGridCells();
            if ((gridCells instanceof GridCells.Fixed) && (1 > (count = ((GridCells.Fixed) gridCells).getCount()) || count >= 6)) {
                throw new IllegalArgumentException("Only counts from 1 to 5 are supported.");
            }
            remoteViews.setPendingIntentTemplate(insertedViewInfo.getMainViewId(), PendingIntent.getActivity(translationContext.getContext(), 0, new Intent(), 184549384, emittableLazyVerticalGrid.getActivityOptions()));
            RemoteCollectionItems.Builder builder = new RemoteCollectionItems.Builder();
            TranslationContext translationContextForLazyCollection = translationContext.forLazyCollection(insertedViewInfo.getMainViewId());
            boolean z = false;
            int i = 0;
            for (Object obj : emittableLazyVerticalGrid.getChildren()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Emittable emittable = (Emittable) obj;
                Intrinsics.checkNotNull(emittable, "null cannot be cast to non-null type androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem");
                long itemId = ((EmittableLazyVerticalGridListItem) emittable).getItemId();
                TranslationContext translationContextForLazyViewItem = translationContextForLazyCollection.forLazyViewItem(i, 1048576);
                List listListOf = CollectionsKt.listOf(emittable);
                LayoutConfiguration layoutConfiguration = translationContext.getLayoutConfiguration();
                builder.addItem(itemId, RemoteViewsTranslatorKt.translateComposition(translationContextForLazyViewItem, listListOf, layoutConfiguration != null ? layoutConfiguration.addLayout(emittable) : -1));
                z = z || itemId > LazyListKt.ReservedItemIdRangeEnd;
                i = i2;
            }
            builder.setHasStableIds(z);
            builder.setViewTypeCount(LayoutSelectionKt.getTopLevelLayoutsCount());
            GlanceRemoteViewsServiceKt.setRemoteAdapter(remoteViews, translationContext.getContext(), translationContext.getAppWidgetId(), insertedViewInfo.getMainViewId(), RemoteViewsTranslatorKt.m21315toSizeStringEaSLcWc(translationContext.m21326getLayoutSizeMYxV2XQ()), builder.build());
            if (Build.VERSION.SDK_INT >= 31 && (gridCells instanceof GridCells.Adaptive)) {
                RemoteViewsCompat.setGridViewColumnWidth(remoteViews, insertedViewInfo.getMainViewId(), ((GridCells.Adaptive) gridCells).getMinSize(), 1);
            }
            ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableLazyVerticalGrid.getModifier(), insertedViewInfo, null, 16, null);
            return;
        }
        throw new IllegalStateException("Glance does not support nested list views.");
    }
}
