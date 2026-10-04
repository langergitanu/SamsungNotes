package androidx.glance.appwidget.translators;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
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
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyList;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
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
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a$\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"LazyListItemStartingViewId", "", "translateEmittableLazyColumn", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "Landroidx/glance/appwidget/lazy/EmittableLazyColumn;", "translateEmittableLazyList", "Landroidx/glance/appwidget/lazy/EmittableLazyList;", "viewDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "translateEmittableLazyListItem", "Landroidx/glance/appwidget/lazy/EmittableLazyListItem;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyListTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyListTranslator.kt\nandroidx/glance/appwidget/translators/LazyListTranslatorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1804#2,4:127\n1#3:131\n*S KotlinDebug\n*F\n+ 1 LazyListTranslator.kt\nandroidx/glance/appwidget/translators/LazyListTranslatorKt\n*L\n80#1:127,4\n*E\n"})
public final class LazyListTranslatorKt {
    private static final int LazyListItemStartingViewId = 1048576;

    public static final void translateEmittableLazyColumn(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableLazyColumn element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        translateEmittableLazyList(remoteViews, translationContext.forListView(), element, LayoutSelectionKt.insertView(remoteViews, translationContext, LayoutType.List, element.getModifier()));
    }

    private static final void translateEmittableLazyList(RemoteViews remoteViews, TranslationContext translationContext, EmittableLazyList emittableLazyList, InsertedViewInfo insertedViewInfo) {
        if (translationContext.isLazyCollectionDescendant()) {
            throw new IllegalStateException("Glance does not support nested list views.");
        }
        remoteViews.setPendingIntentTemplate(insertedViewInfo.getMainViewId(), PendingIntent.getActivity(translationContext.getContext(), 0, new Intent(), 184549384, emittableLazyList.getActivityOptions()));
        RemoteCollectionItems.Builder builder = new RemoteCollectionItems.Builder();
        TranslationContext translationContextForLazyCollection = translationContext.forLazyCollection(insertedViewInfo.getMainViewId());
        boolean z = false;
        int i = 0;
        for (Object obj : emittableLazyList.getChildren()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittable = (Emittable) obj;
            Intrinsics.checkNotNull(emittable, "null cannot be cast to non-null type androidx.glance.appwidget.lazy.EmittableLazyListItem");
            long itemId = ((EmittableLazyListItem) emittable).getItemId();
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
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableLazyList.getModifier(), insertedViewInfo, null, 16, null);
    }

    public static final void translateEmittableLazyListItem(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableLazyListItem element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.getChildren().size() != 1 || !Intrinsics.areEqual(element.getAlignment(), Alignment.INSTANCE.getCenterStart())) {
            throw new IllegalArgumentException("Lazy list items can only have a single child align at the center start of the view. The normalization of the composition tree failed.");
        }
        RemoteViewsTranslatorKt.translateChild(remoteViews, translationContext, (Emittable) CollectionsKt.first((List) element.getChildren()));
    }
}
