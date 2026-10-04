package androidx.glance.appwidget;

import android.content.ComponentName;
import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u0016\u001a\u00020\u0000J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0016\u0010=\u001a\u00020\u0013HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u00107J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010C\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u001dHÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\rHÆ\u0003J\t\u0010M\u001a\u00020\u000fHÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003JÍ\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0013\u0010R\u001a\u00020\u00072\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0005J\u0016\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0005J\u0018\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u00052\b\b\u0002\u0010\\\u001a\u00020\u0005J\u0006\u0010]\u001a\u00020\u0000J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`J \u0010a\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\bb\u0010cJ\t\u0010d\u001a\u00020\u0005HÖ\u0001J\u0006\u0010e\u001a\u00020\u0005J\u0010\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\\\u001a\u00020\u0005J\t\u0010g\u001a\u00020hHÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010.R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010'R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010'R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m13886d2 = {"Landroidx/glance/appwidget/TranslationContext;", "", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "isRtl", "", "layoutConfiguration", "Landroidx/glance/appwidget/LayoutConfiguration;", "itemPosition", "isLazyCollectionDescendant", "lastViewId", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentContext", "Landroidx/glance/appwidget/InsertedViewInfo;", "isBackgroundSpecified", "Ljava/util/concurrent/atomic/AtomicBoolean;", "layoutSize", "Landroidx/compose/ui/unit/DpSize;", "layoutCollectionViewId", "layoutCollectionItemId", "canUseSelectableGroup", "actionTargetId", "actionBroadcastReceiver", "Landroid/content/ComponentName;", "isListView", "skipInteraction", "density", "", "(Landroid/content/Context;IZLandroidx/glance/appwidget/LayoutConfiguration;IZLjava/util/concurrent/atomic/AtomicInteger;Landroidx/glance/appwidget/InsertedViewInfo;Ljava/util/concurrent/atomic/AtomicBoolean;JIIZLjava/lang/Integer;Landroid/content/ComponentName;ZZFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionBroadcastReceiver", "()Landroid/content/ComponentName;", "getActionTargetId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppWidgetId", "()I", "getCanUseSelectableGroup", "()Z", "getContext", "()Landroid/content/Context;", "getDensity", "()F", "setDensity", "(F)V", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getItemPosition", "getLastViewId", "()Ljava/util/concurrent/atomic/AtomicInteger;", "getLayoutCollectionItemId", "getLayoutCollectionViewId", "getLayoutConfiguration", "()Landroidx/glance/appwidget/LayoutConfiguration;", "getLayoutSize-MYxV2XQ", "()J", "J", "getParentContext", "()Landroidx/glance/appwidget/InsertedViewInfo;", "getSkipInteraction", "component1", "component10", "component10-MYxV2XQ", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-iRFG6Wk", "(Landroid/content/Context;IZLandroidx/glance/appwidget/LayoutConfiguration;IZLjava/util/concurrent/atomic/AtomicInteger;Landroidx/glance/appwidget/InsertedViewInfo;Ljava/util/concurrent/atomic/AtomicBoolean;JIIZLjava/lang/Integer;Landroid/content/ComponentName;ZZF)Landroidx/glance/appwidget/TranslationContext;", "equals", "other", "forActionTargetId", "viewId", "forChild", "parent", "pos", "forLazyCollection", "forLazyViewItem", "itemId", "newViewId", "forListView", "forRoot", "root", "Landroidx/glance/appwidget/RemoteViewsInfo;", "forRootAndSize", "forRootAndSize-6HolHcs", "(Landroidx/glance/appwidget/RemoteViewsInfo;J)Landroidx/glance/appwidget/TranslationContext;", "hashCode", "nextViewId", "resetViewId", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class TranslationContext {
    public static final int $stable = 8;

    @Nullable
    private final ComponentName actionBroadcastReceiver;

    @Nullable
    private final Integer actionTargetId;
    private final int appWidgetId;
    private final boolean canUseSelectableGroup;

    @NotNull
    private final Context context;
    private float density;

    @NotNull
    private final AtomicBoolean isBackgroundSpecified;
    private final boolean isLazyCollectionDescendant;
    private final boolean isListView;
    private final boolean isRtl;
    private final int itemPosition;

    @NotNull
    private final AtomicInteger lastViewId;
    private final int layoutCollectionItemId;
    private final int layoutCollectionViewId;

    @Nullable
    private final LayoutConfiguration layoutConfiguration;
    private final long layoutSize;

    @NotNull
    private final InsertedViewInfo parentContext;
    private final boolean skipInteraction;

    public /* synthetic */ TranslationContext(Context context, int i, boolean z, LayoutConfiguration layoutConfiguration, int i2, boolean z2, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j, int i4, int i5, boolean z3, Integer num, ComponentName componentName, boolean z4, boolean z5, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, z, layoutConfiguration, i2, z2, atomicInteger, insertedViewInfo, atomicBoolean, j, i4, i5, z3, num, componentName, z4, z5, f);
    }

    /* JADX INFO: renamed from: copy-iRFG6Wk$default, reason: not valid java name */
    public static /* synthetic */ TranslationContext m21322copyiRFG6Wk$default(TranslationContext translationContext, Context context, int i, boolean z, LayoutConfiguration layoutConfiguration, int i2, boolean z2, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j, int i4, int i5, boolean z3, Integer num, ComponentName componentName, boolean z4, boolean z5, float f, int i6, Object obj) {
        float f4;
        boolean z6;
        Context context2 = (i6 & 1) != 0 ? translationContext.context : context;
        int i7 = (i6 & 2) != 0 ? translationContext.appWidgetId : i;
        boolean z7 = (i6 & 4) != 0 ? translationContext.isRtl : z;
        LayoutConfiguration layoutConfiguration2 = (i6 & 8) != 0 ? translationContext.layoutConfiguration : layoutConfiguration;
        int i8 = (i6 & 16) != 0 ? translationContext.itemPosition : i2;
        boolean z8 = (i6 & 32) != 0 ? translationContext.isLazyCollectionDescendant : z2;
        AtomicInteger atomicInteger2 = (i6 & 64) != 0 ? translationContext.lastViewId : atomicInteger;
        InsertedViewInfo insertedViewInfo2 = (i6 & 128) != 0 ? translationContext.parentContext : insertedViewInfo;
        AtomicBoolean atomicBoolean2 = (i6 & 256) != 0 ? translationContext.isBackgroundSpecified : atomicBoolean;
        long j2 = (i6 & 512) != 0 ? translationContext.layoutSize : j;
        int i9 = (i6 & 1024) != 0 ? translationContext.layoutCollectionViewId : i4;
        int i10 = (i6 & 2048) != 0 ? translationContext.layoutCollectionItemId : i5;
        boolean z9 = (i6 & 4096) != 0 ? translationContext.canUseSelectableGroup : z3;
        Context context3 = context2;
        Integer num2 = (i6 & 8192) != 0 ? translationContext.actionTargetId : num;
        ComponentName componentName2 = (i6 & 16384) != 0 ? translationContext.actionBroadcastReceiver : componentName;
        boolean z10 = (i6 & 32768) != 0 ? translationContext.isListView : z4;
        boolean z11 = (i6 & 65536) != 0 ? translationContext.skipInteraction : z5;
        if ((i6 & 131072) != 0) {
            z6 = z11;
            f4 = translationContext.density;
        } else {
            f4 = f;
            z6 = z11;
        }
        return translationContext.m21324copyiRFG6Wk(context3, i7, z7, layoutConfiguration2, i8, z8, atomicInteger2, insertedViewInfo2, atomicBoolean2, j2, i9, i10, z9, num2, componentName2, z10, z6, f4);
    }

    public static /* synthetic */ TranslationContext forLazyViewItem$default(TranslationContext translationContext, int i, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        return translationContext.forLazyViewItem(i, i2);
    }

    public static /* synthetic */ TranslationContext resetViewId$default(TranslationContext translationContext, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return translationContext.resetViewId(i);
    }

    @NotNull
    public final TranslationContext canUseSelectableGroup() {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, false, null, null, null, 0L, 0, 0, true, null, null, false, false, 0.0f, 258047, null);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component10-MYxV2XQ, reason: not valid java name and from getter */
    public final long getLayoutSize() {
        return this.layoutSize;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getLayoutCollectionViewId() {
        return this.layoutCollectionViewId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getLayoutCollectionItemId() {
        return this.layoutCollectionItemId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getCanUseSelectableGroup() {
        return this.canUseSelectableGroup;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getActionTargetId() {
        return this.actionTargetId;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ComponentName getActionBroadcastReceiver() {
        return this.actionBroadcastReceiver;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsListView() {
        return this.isListView;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getSkipInteraction() {
        return this.skipInteraction;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAppWidgetId() {
        return this.appWidgetId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRtl() {
        return this.isRtl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final LayoutConfiguration getLayoutConfiguration() {
        return this.layoutConfiguration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getItemPosition() {
        return this.itemPosition;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLazyCollectionDescendant() {
        return this.isLazyCollectionDescendant;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AtomicInteger getLastViewId() {
        return this.lastViewId;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final InsertedViewInfo getParentContext() {
        return this.parentContext;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final AtomicBoolean getIsBackgroundSpecified() {
        return this.isBackgroundSpecified;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-iRFG6Wk, reason: not valid java name */
    public final TranslationContext m21324copyiRFG6Wk(@NotNull Context context, int appWidgetId, boolean isRtl, @Nullable LayoutConfiguration layoutConfiguration, int itemPosition, boolean isLazyCollectionDescendant, @NotNull AtomicInteger lastViewId, @NotNull InsertedViewInfo parentContext, @NotNull AtomicBoolean isBackgroundSpecified, long layoutSize, int layoutCollectionViewId, int layoutCollectionItemId, boolean canUseSelectableGroup, @Nullable Integer actionTargetId, @Nullable ComponentName actionBroadcastReceiver, boolean isListView, boolean skipInteraction, float density) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lastViewId, "lastViewId");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(isBackgroundSpecified, "isBackgroundSpecified");
        return new TranslationContext(context, appWidgetId, isRtl, layoutConfiguration, itemPosition, isLazyCollectionDescendant, lastViewId, parentContext, isBackgroundSpecified, layoutSize, layoutCollectionViewId, layoutCollectionItemId, canUseSelectableGroup, actionTargetId, actionBroadcastReceiver, isListView, skipInteraction, density, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationContext)) {
            return false;
        }
        TranslationContext translationContext = (TranslationContext) other;
        return Intrinsics.areEqual(this.context, translationContext.context) && this.appWidgetId == translationContext.appWidgetId && this.isRtl == translationContext.isRtl && Intrinsics.areEqual(this.layoutConfiguration, translationContext.layoutConfiguration) && this.itemPosition == translationContext.itemPosition && this.isLazyCollectionDescendant == translationContext.isLazyCollectionDescendant && Intrinsics.areEqual(this.lastViewId, translationContext.lastViewId) && Intrinsics.areEqual(this.parentContext, translationContext.parentContext) && Intrinsics.areEqual(this.isBackgroundSpecified, translationContext.isBackgroundSpecified) && DpSize.m21063equalsimpl0(this.layoutSize, translationContext.layoutSize) && this.layoutCollectionViewId == translationContext.layoutCollectionViewId && this.layoutCollectionItemId == translationContext.layoutCollectionItemId && this.canUseSelectableGroup == translationContext.canUseSelectableGroup && Intrinsics.areEqual(this.actionTargetId, translationContext.actionTargetId) && Intrinsics.areEqual(this.actionBroadcastReceiver, translationContext.actionBroadcastReceiver) && this.isListView == translationContext.isListView && this.skipInteraction == translationContext.skipInteraction && Float.compare(this.density, translationContext.density) == 0;
    }

    @NotNull
    public final TranslationContext forActionTargetId(int viewId) {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, false, null, null, null, 0L, 0, 0, false, Integer.valueOf(viewId), null, false, false, 0.0f, 253951, null);
    }

    @NotNull
    public final TranslationContext forChild(@NotNull InsertedViewInfo parent, int pos) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, pos, false, null, parent, null, 0L, 0, 0, false, null, null, false, false, 0.0f, 261999, null);
    }

    @NotNull
    public final TranslationContext forLazyCollection(int viewId) {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, true, null, null, null, 0L, viewId, 0, false, null, null, false, false, 0.0f, 261087, null);
    }

    @NotNull
    public final TranslationContext forLazyViewItem(int itemId, int newViewId) {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, false, new AtomicInteger(newViewId), null, null, 0L, itemId, 0, false, null, null, false, false, 0.0f, 261055, null);
    }

    @NotNull
    public final TranslationContext forListView() {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, false, null, null, null, 0L, 0, 0, false, null, null, true, false, 0.0f, 229375, null);
    }

    @NotNull
    public final TranslationContext forRoot(@NotNull RemoteViewsInfo root) {
        Intrinsics.checkNotNullParameter(root, "root");
        return m21322copyiRFG6Wk$default(forChild(root.getView(), 0), null, 0, false, null, 0, false, new AtomicInteger(1), null, new AtomicBoolean(false), 0L, 0, 0, false, null, null, false, false, 0.0f, 261823, null);
    }

    @NotNull
    /* JADX INFO: renamed from: forRootAndSize-6HolHcs, reason: not valid java name */
    public final TranslationContext m21325forRootAndSize6HolHcs(@NotNull RemoteViewsInfo root, long layoutSize) {
        Intrinsics.checkNotNullParameter(root, "root");
        return m21322copyiRFG6Wk$default(forChild(root.getView(), 0), null, 0, false, null, 0, false, new AtomicInteger(1), null, new AtomicBoolean(false), layoutSize, 0, 0, false, null, null, false, false, 0.0f, 261311, null);
    }

    @Nullable
    public final ComponentName getActionBroadcastReceiver() {
        return this.actionBroadcastReceiver;
    }

    @Nullable
    public final Integer getActionTargetId() {
        return this.actionTargetId;
    }

    public final int getAppWidgetId() {
        return this.appWidgetId;
    }

    public final boolean getCanUseSelectableGroup() {
        return this.canUseSelectableGroup;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final float getDensity() {
        return this.density;
    }

    public final int getItemPosition() {
        return this.itemPosition;
    }

    @NotNull
    public final AtomicInteger getLastViewId() {
        return this.lastViewId;
    }

    public final int getLayoutCollectionItemId() {
        return this.layoutCollectionItemId;
    }

    public final int getLayoutCollectionViewId() {
        return this.layoutCollectionViewId;
    }

    @Nullable
    public final LayoutConfiguration getLayoutConfiguration() {
        return this.layoutConfiguration;
    }

    /* JADX INFO: renamed from: getLayoutSize-MYxV2XQ, reason: not valid java name */
    public final long m21326getLayoutSizeMYxV2XQ() {
        return this.layoutSize;
    }

    @NotNull
    public final InsertedViewInfo getParentContext() {
        return this.parentContext;
    }

    public final boolean getSkipInteraction() {
        return this.skipInteraction;
    }

    public int hashCode() {
        int iM1160f = AbstractC0622a.m1160f(this.isRtl, AbstractC0622a.m1157c(this.appWidgetId, this.context.hashCode() * 31, 31), 31);
        LayoutConfiguration layoutConfiguration = this.layoutConfiguration;
        int iM1160f2 = AbstractC0622a.m1160f(this.canUseSelectableGroup, AbstractC0622a.m1157c(this.layoutCollectionItemId, AbstractC0622a.m1157c(this.layoutCollectionViewId, (DpSize.m21068hashCodeimpl(this.layoutSize) + ((this.isBackgroundSpecified.hashCode() + ((this.parentContext.hashCode() + ((this.lastViewId.hashCode() + AbstractC0622a.m1160f(this.isLazyCollectionDescendant, AbstractC0622a.m1157c(this.itemPosition, (iM1160f + (layoutConfiguration == null ? 0 : layoutConfiguration.hashCode())) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31, 31), 31), 31);
        Integer num = this.actionTargetId;
        int iHashCode = (iM1160f2 + (num == null ? 0 : num.hashCode())) * 31;
        ComponentName componentName = this.actionBroadcastReceiver;
        return Float.hashCode(this.density) + AbstractC0622a.m1160f(this.skipInteraction, AbstractC0622a.m1160f(this.isListView, (iHashCode + (componentName != null ? componentName.hashCode() : 0)) * 31, 31), 31);
    }

    @NotNull
    public final AtomicBoolean isBackgroundSpecified() {
        return this.isBackgroundSpecified;
    }

    public final boolean isLazyCollectionDescendant() {
        return this.isLazyCollectionDescendant;
    }

    public final boolean isListView() {
        return this.isListView;
    }

    public final boolean isRtl() {
        return this.isRtl;
    }

    public final int nextViewId() {
        int iIncrementAndGet = this.lastViewId.incrementAndGet();
        RemoteViewsTranslatorKt.setLastUsedViewId(this.lastViewId.get());
        return iIncrementAndGet;
    }

    @NotNull
    public final TranslationContext resetViewId(int newViewId) {
        return m21322copyiRFG6Wk$default(this, null, 0, false, null, 0, false, new AtomicInteger(newViewId), null, null, 0L, 0, 0, false, null, null, false, false, 0.0f, 262079, null);
    }

    public final void setDensity(float f) {
        this.density = f;
    }

    @NotNull
    public String toString() {
        Context context = this.context;
        int i = this.appWidgetId;
        boolean z = this.isRtl;
        LayoutConfiguration layoutConfiguration = this.layoutConfiguration;
        int i2 = this.itemPosition;
        boolean z2 = this.isLazyCollectionDescendant;
        AtomicInteger atomicInteger = this.lastViewId;
        InsertedViewInfo insertedViewInfo = this.parentContext;
        AtomicBoolean atomicBoolean = this.isBackgroundSpecified;
        String strM21073toStringimpl = DpSize.m21073toStringimpl(this.layoutSize);
        int i4 = this.layoutCollectionViewId;
        int i5 = this.layoutCollectionItemId;
        boolean z3 = this.canUseSelectableGroup;
        Integer num = this.actionTargetId;
        ComponentName componentName = this.actionBroadcastReceiver;
        boolean z4 = this.isListView;
        boolean z5 = this.skipInteraction;
        float f = this.density;
        StringBuilder sb = new StringBuilder("TranslationContext(context=");
        sb.append(context);
        sb.append(", appWidgetId=");
        sb.append(i);
        sb.append(", isRtl=");
        sb.append(z);
        sb.append(", layoutConfiguration=");
        sb.append(layoutConfiguration);
        sb.append(", itemPosition=");
        sb.append(i2);
        sb.append(", isLazyCollectionDescendant=");
        sb.append(z2);
        sb.append(", lastViewId=");
        sb.append(atomicInteger);
        sb.append(", parentContext=");
        sb.append(insertedViewInfo);
        sb.append(", isBackgroundSpecified=");
        sb.append(atomicBoolean);
        sb.append(", layoutSize=");
        sb.append(strM21073toStringimpl);
        sb.append(", layoutCollectionViewId=");
        AbstractC2821a.m2235z(sb, i4, i5, ", layoutCollectionItemId=", ", canUseSelectableGroup=");
        sb.append(z3);
        sb.append(", actionTargetId=");
        sb.append(num);
        sb.append(", actionBroadcastReceiver=");
        sb.append(componentName);
        sb.append(", isListView=");
        sb.append(z4);
        sb.append(", skipInteraction=");
        sb.append(z5);
        sb.append(", density=");
        sb.append(f);
        sb.append(")");
        return sb.toString();
    }

    private TranslationContext(Context context, int i, boolean z, LayoutConfiguration layoutConfiguration, int i2, boolean z2, AtomicInteger lastViewId, InsertedViewInfo parentContext, AtomicBoolean isBackgroundSpecified, long j, int i4, int i5, boolean z3, Integer num, ComponentName componentName, boolean z4, boolean z5, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lastViewId, "lastViewId");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(isBackgroundSpecified, "isBackgroundSpecified");
        this.context = context;
        this.appWidgetId = i;
        this.isRtl = z;
        this.layoutConfiguration = layoutConfiguration;
        this.itemPosition = i2;
        this.isLazyCollectionDescendant = z2;
        this.lastViewId = lastViewId;
        this.parentContext = parentContext;
        this.isBackgroundSpecified = isBackgroundSpecified;
        this.layoutSize = j;
        this.layoutCollectionViewId = i4;
        this.layoutCollectionItemId = i5;
        this.canUseSelectableGroup = z3;
        this.actionTargetId = num;
        this.actionBroadcastReceiver = componentName;
        this.isListView = z4;
        this.skipInteraction = z5;
        this.density = f;
    }

    public /* synthetic */ TranslationContext(Context context, int i, boolean z, LayoutConfiguration layoutConfiguration, int i2, boolean z2, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j, int i4, int i5, boolean z3, Integer num, ComponentName componentName, boolean z4, boolean z5, float f, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, z, layoutConfiguration, i2, (i6 & 32) != 0 ? false : z2, (i6 & 64) != 0 ? new AtomicInteger(1) : atomicInteger, (i6 & 128) != 0 ? new InsertedViewInfo(0, 0, null, 7, null) : insertedViewInfo, (i6 & 256) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i6 & 512) != 0 ? DpSize.INSTANCE.m21076getZeroMYxV2XQ() : j, (i6 & 1024) != 0 ? -1 : i4, (i6 & 2048) != 0 ? -1 : i5, (i6 & 4096) != 0 ? false : z3, (i6 & 8192) != 0 ? null : num, (i6 & 16384) != 0 ? null : componentName, (32768 & i6) != 0 ? false : z4, (65536 & i6) != 0 ? false : z5, (i6 & 131072) != 0 ? -1.0f : f, null);
    }
}
