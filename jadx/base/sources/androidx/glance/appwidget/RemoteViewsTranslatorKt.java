package androidx.glance.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.annotation.LayoutRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGrid;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem;
import androidx.glance.appwidget.translators.ArcProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.CheckBoxTranslatorKt;
import androidx.glance.appwidget.translators.CircularProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.ImageButtonTranslatorKt;
import androidx.glance.appwidget.translators.ImageTranslatorKt;
import androidx.glance.appwidget.translators.LazyListTranslatorKt;
import androidx.glance.appwidget.translators.LazyVerticalGridTranslatorKt;
import androidx.glance.appwidget.translators.LinearProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.RadioButtonTranslatorKt;
import androidx.glance.appwidget.translators.StackedProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.SwitchTranslatorKt;
import androidx.glance.appwidget.translators.TextTranslatorKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.EmittableColumn;
import androidx.glance.layout.EmittableRow;
import androidx.glance.layout.EmittableSpacer;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.text.EmittableText;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002\u001a\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010 \u001a\u00020\u0001H\u0000\u001aZ\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a&\u0010!\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010(\u001a\u00020\u0001H\u0000\u001a$\u00100\u001a\u00020\u0016*\u00020\u001b2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0001H\u0000\u001a\f\u00104\u001a\u00020\u001b*\u00020\u001bH\u0002\u001a*\u00105\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000\u001a\f\u00108\u001a\u00020\u0001*\u000209H\u0000\u001a\u0016\u00108\u001a\u00020\u0001*\u00020:H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0016\u00108\u001a\u00020\u0001*\u00020=H\u0000ø\u0001\u0000¢\u0006\u0004\b>\u0010<\u001a\u0016\u0010?\u001a\u00020\u0003*\u00020*H\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010B\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0019H\u0000\u001a\u001c\u0010C\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020DH\u0002\u001a\u001c\u0010E\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020FH\u0002\u001a\u001c\u0010G\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020HH\u0002\u001a\u001c\u0010I\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020JH\u0002\u001a\u001c\u0010K\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020LH\u0002\u001a\u001c\u0010M\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020NH\u0000\u001a\u001c\u0010O\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020PH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u001a\u0010\r\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0012\u001a\u00020\u0005*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, m13886d2 = {"LAST_INVALID_VIEW_ID", "", SearchConstants.TargetContents.TAG, "", "forceRtl", "", "getForceRtl$annotations", "()V", "getForceRtl", "()Ljava/lang/Boolean;", "setForceRtl", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lastUsedViewId", "getLastUsedViewId", "()I", "setLastUsedViewId", "(I)V", "isRtl", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "checkSelectableGroupChildren", "", "children", "", "Landroidx/glance/Emittable;", "combineLandscapeAndPortrait", "Landroid/widget/RemoteViews;", "views", "remoteViews", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "layoutId", "translateComposition", "context", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "element", "Landroidx/glance/appwidget/RemoteViewsRoot;", "layoutConfiguration", "Landroidx/glance/appwidget/LayoutConfiguration;", "rootViewIndex", "layoutSize", "Landroidx/compose/ui/unit/DpSize;", "actionBroadcastReceiver", "Landroid/content/ComponentName;", "skipInteraction", "translateComposition-_rDzMTw", "(Landroid/content/Context;ILandroidx/glance/appwidget/RemoteViewsRoot;Landroidx/glance/appwidget/LayoutConfiguration;IJLandroid/content/ComponentName;Z)Landroid/widget/RemoteViews;", "addChildView", "viewId", "childView", "stableId", "copy", "setChildren", "parentDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "toGravity", "Landroidx/glance/layout/Alignment;", "Landroidx/glance/layout/Alignment$Horizontal;", "toGravity-uMT2-20", "(I)I", "Landroidx/glance/layout/Alignment$Vertical;", "toGravity-Je2gTW8", "toSizeString", "toSizeString-EaSLcWc", "(J)Ljava/lang/String;", "translateChild", "translateEmittableAndroidRemoteViews", "Landroidx/glance/appwidget/EmittableAndroidRemoteViews;", "translateEmittableBox", "Landroidx/glance/layout/EmittableBox;", "translateEmittableButton", "Landroidx/glance/EmittableButton;", "translateEmittableColumn", "Landroidx/glance/layout/EmittableColumn;", "translateEmittableRow", "Landroidx/glance/layout/EmittableRow;", "translateEmittableSizeBox", "Landroidx/glance/appwidget/EmittableSizeBox;", "translateEmittableSpacer", "Landroidx/glance/layout/EmittableSpacer;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRemoteViewsTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteViewsTranslator.kt\nandroidx/glance/appwidget/RemoteViewsTranslatorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Utils.kt\nandroidx/glance/UtilsKt\n*L\n1#1,575:1\n1726#2,3:576\n1549#2:579\n1620#2,3:580\n1549#2:583\n1620#2,3:584\n1549#2:588\n1620#2,3:589\n1855#2,2:593\n1774#2,4:595\n1864#2,3:599\n1864#2,3:611\n1#3:587\n473#4:592\n154#4:602\n154#4:610\n22#5,7:603\n*S KotlinDebug\n*F\n+ 1 RemoteViewsTranslator.kt\nandroidx/glance/appwidget/RemoteViewsTranslatorKt\n*L\n114#1:576,3\n120#1:579\n120#1:580,3\n153#1:583\n153#1:584,3\n159#1:588\n159#1:589,3\n372#1:593,2\n457#1:595,4\n475#1:599,3\n531#1:611,3\n251#1:592\n509#1:602\n511#1:610\n510#1:603,7\n*E\n"})
public final class RemoteViewsTranslatorKt {
    private static final int LAST_INVALID_VIEW_ID = 1;

    @NotNull
    private static final String TAG = "GWT:Translator";

    @Nullable
    private static Boolean forceRtl;
    private static int lastUsedViewId;

    public static final void addChildView(@NotNull RemoteViews remoteViews, int i, @NotNull RemoteViews childView, int i2) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (Build.VERSION.SDK_INT >= 31) {
            RemoteViewsTranslatorApi31Impl.INSTANCE.addChildView(remoteViews, i, childView, i2);
        } else {
            remoteViews.addView(i, childView);
        }
    }

    private static final void checkSelectableGroupChildren(List<? extends Emittable> list) {
        int i;
        List<? extends Emittable> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (Emittable emittable : list2) {
                if ((emittable instanceof EmittableRadioButton) && ((EmittableRadioButton) emittable).getChecked() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!(i <= 1)) {
            throw new IllegalStateException("When using GlanceModifier.selectableGroup(), no more than one RadioButton may be checked at a time.");
        }
    }

    private static final RemoteViews combineLandscapeAndPortrait(List<? extends RemoteViews> list) {
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        }
        if (size == 2) {
            return new RemoteViews(list.get(0), list.get(1));
        }
        throw new IllegalArgumentException("There must be between 1 and 2 views.");
    }

    private static final RemoteViews copy(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 28) {
            return RemoteViewsTranslatorApi28Impl.INSTANCE.copyRemoteViews(remoteViews);
        }
        RemoteViews remoteViewsClone = remoteViews.clone();
        Intrinsics.checkNotNull(remoteViewsClone);
        return remoteViewsClone;
    }

    @Nullable
    public static final Boolean getForceRtl() {
        return forceRtl;
    }

    public static final int getLastUsedViewId() {
        return lastUsedViewId;
    }

    private static final boolean isRtl(Context context) {
        Boolean bool = forceRtl;
        return bool != null ? bool.booleanValue() : AbstractC0541b.m759a(context) == 1;
    }

    @NotNull
    public static final RemoteViews remoteViews(@NotNull TranslationContext translationContext, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        return new RemoteViews(translationContext.getContext().getPackageName(), i);
    }

    public static final void setChildren(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull InsertedViewInfo parentDef, @NotNull List<? extends Emittable> children) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(parentDef, "parentDef");
        Intrinsics.checkNotNullParameter(children, "children");
        int i = 0;
        for (Object obj : CollectionsKt.take(children, 10)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            translateChild(remoteViews, translationContext.forChild(parentDef, i), (Emittable) obj);
            i = i2;
        }
    }

    public static final void setForceRtl(@Nullable Boolean bool) {
        forceRtl = bool;
    }

    public static final void setLastUsedViewId(int i) {
        lastUsedViewId = i;
    }

    public static final int toGravity(@NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<this>");
        return m21313toGravityJe2gTW8(alignment.getVertical()) | m21314toGravityuMT220(alignment.getHorizontal());
    }

    /* JADX INFO: renamed from: toGravity-Je2gTW8, reason: not valid java name */
    public static final int m21313toGravityJe2gTW8(int i) {
        Alignment.Vertical.Companion companion = Alignment.Vertical.INSTANCE;
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21454getTopmnfRV0w())) {
            return 48;
        }
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21452getBottommnfRV0w())) {
            return 80;
        }
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21453getCenterVerticallymnfRV0w())) {
            return 16;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unknown vertical alignment: " + Alignment.Vertical.m21450toStringimpl(i));
        return 48;
    }

    /* JADX INFO: renamed from: toGravity-uMT2-20, reason: not valid java name */
    public static final int m21314toGravityuMT220(int i) {
        Alignment.Horizontal.Companion companion = Alignment.Horizontal.INSTANCE;
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21444getStartPGIyAqw())) {
            return 8388611;
        }
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21443getEndPGIyAqw())) {
            return 8388613;
        }
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21442getCenterHorizontallyPGIyAqw())) {
            return 1;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unknown horizontal alignment: " + Alignment.Horizontal.m21440toStringimpl(i));
        return 8388611;
    }

    @NotNull
    /* JADX INFO: renamed from: toSizeString-EaSLcWc, reason: not valid java name */
    public static final String m21315toSizeStringEaSLcWc(long j) {
        return j != DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ() ? AbstractC0541b.m757C(C2256Dp.m20979toStringimpl(DpSize.m21066getWidthD9Ej5fM(j)), "x", C2256Dp.m20979toStringimpl(DpSize.m21064getHeightD9Ej5fM(j))) : "Unspecified";
    }

    public static final void translateChild(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull Emittable element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element instanceof EmittableBox) {
            translateEmittableBox(remoteViews, translationContext, (EmittableBox) element);
            return;
        }
        if (element instanceof EmittableButton) {
            translateEmittableButton(remoteViews, translationContext, (EmittableButton) element);
            return;
        }
        if (element instanceof EmittableRow) {
            translateEmittableRow(remoteViews, translationContext, (EmittableRow) element);
            return;
        }
        if (element instanceof EmittableColumn) {
            translateEmittableColumn(remoteViews, translationContext, (EmittableColumn) element);
            return;
        }
        if (element instanceof EmittableText) {
            TextTranslatorKt.translateEmittableText(remoteViews, translationContext, (EmittableText) element);
            return;
        }
        if (element instanceof EmittableLazyListItem) {
            LazyListTranslatorKt.translateEmittableLazyListItem(remoteViews, translationContext, (EmittableLazyListItem) element);
            return;
        }
        if (element instanceof EmittableLazyColumn) {
            LazyListTranslatorKt.translateEmittableLazyColumn(remoteViews, translationContext, (EmittableLazyColumn) element);
            return;
        }
        if (element instanceof EmittableAndroidRemoteViews) {
            translateEmittableAndroidRemoteViews(remoteViews, translationContext, (EmittableAndroidRemoteViews) element);
            return;
        }
        if (element instanceof EmittableCheckBox) {
            CheckBoxTranslatorKt.translateEmittableCheckBox(remoteViews, translationContext, (EmittableCheckBox) element);
            return;
        }
        if (element instanceof EmittableSpacer) {
            translateEmittableSpacer(remoteViews, translationContext, (EmittableSpacer) element);
            return;
        }
        if (element instanceof EmittableSwitch) {
            SwitchTranslatorKt.translateEmittableSwitch(remoteViews, translationContext, (EmittableSwitch) element);
            return;
        }
        if (element instanceof EmittableImage) {
            if (element instanceof EmittableImageButton) {
                ImageButtonTranslatorKt.translateEmittableImageButton(remoteViews, translationContext, (EmittableImageButton) element);
                return;
            } else {
                ImageTranslatorKt.translateEmittableImage(remoteViews, translationContext, (EmittableImage) element);
                return;
            }
        }
        if (element instanceof EmittableLinearProgressIndicator) {
            LinearProgressIndicatorTranslatorKt.translateEmittableLinearProgressIndicator(remoteViews, translationContext, (EmittableLinearProgressIndicator) element);
            return;
        }
        if (element instanceof EmittableCircularProgressIndicator) {
            CircularProgressIndicatorTranslatorKt.translateEmittableCircularProgressIndicator(remoteViews, translationContext, (EmittableCircularProgressIndicator) element);
            return;
        }
        if (element instanceof EmittableLazyVerticalGrid) {
            LazyVerticalGridTranslatorKt.translateEmittableLazyVerticalGrid(remoteViews, translationContext, (EmittableLazyVerticalGrid) element);
            return;
        }
        if (element instanceof EmittableLazyVerticalGridListItem) {
            LazyVerticalGridTranslatorKt.translateEmittableLazyVerticalGridListItem(remoteViews, translationContext, (EmittableLazyVerticalGridListItem) element);
            return;
        }
        if (element instanceof EmittableRadioButton) {
            RadioButtonTranslatorKt.translateEmittableRadioButton(remoteViews, translationContext, (EmittableRadioButton) element);
            return;
        }
        if (element instanceof EmittableSizeBox) {
            translateEmittableSizeBox(remoteViews, translationContext, (EmittableSizeBox) element);
        } else if (element instanceof EmittableArcProgressIndicator) {
            ArcProgressIndicatorTranslatorKt.translateEmittableArcProgressIndicator(remoteViews, translationContext, (EmittableArcProgressIndicator) element);
        } else {
            if (!(element instanceof EmittableStackedProgressIndicator)) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown element type ", element.getClass().getCanonicalName()));
            }
            StackedProgressIndicatorTranslatorKt.translateEmittableStackedProgressIndicator(remoteViews, translationContext, (EmittableStackedProgressIndicator) element);
        }
    }

    @NotNull
    public static final RemoteViews translateComposition(@NotNull TranslationContext translationContext, @NotNull List<? extends Emittable> children, int i) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(children, "children");
        List<? extends Emittable> list = children;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!(((Emittable) it.next()) instanceof EmittableSizeBox)) {
                    Emittable emittable = (Emittable) CollectionsKt.single((List) children);
                    RemoteViewsInfo remoteViewsInfoCreateRootView = LayoutSelectionKt.createRootView(translationContext, emittable.getModifier(), i);
                    RemoteViews remoteViews = remoteViewsInfoCreateRootView.getRemoteViews();
                    translateChild(remoteViews, translationContext.forRoot(remoteViewsInfoCreateRootView), emittable);
                    return remoteViews;
                }
            }
        }
        Object objFirst = CollectionsKt.first((List<? extends Object>) children);
        Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
        SizeMode sizeMode = ((EmittableSizeBox) objFirst).getSizeMode();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Emittable emittable2 = (Emittable) it2.next();
            Intrinsics.checkNotNull(emittable2, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
            long jM21287getSizeMYxV2XQ = ((EmittableSizeBox) emittable2).getSize();
            RemoteViewsInfo remoteViewsInfoCreateRootView2 = LayoutSelectionKt.createRootView(translationContext, emittable2.getModifier(), i);
            RemoteViews remoteViews2 = remoteViewsInfoCreateRootView2.getRemoteViews();
            lastUsedViewId = 0;
            translateChild(remoteViews2, translationContext.m21325forRootAndSize6HolHcs(remoteViewsInfoCreateRootView2, jM21287getSizeMYxV2XQ), emittable2);
            arrayList.add(TuplesKt.m13893to(AppWidgetUtilsKt.m21267toSizeFEaSLcWc(jM21287getSizeMYxV2XQ), remoteViews2));
        }
        if (sizeMode instanceof SizeMode.Single) {
            return (RemoteViews) ((Pair) CollectionsKt.single((List) arrayList)).getSecond();
        }
        if (!(sizeMode instanceof SizeMode.Responsive ? true : Intrinsics.areEqual(sizeMode, SizeMode.Exact.INSTANCE))) {
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT < 31) {
            if (!(arrayList.size() == 1 || arrayList.size() == 2)) {
                throw new IllegalArgumentException("unsupported views size");
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList2.add((RemoteViews) ((Pair) it3.next()).getSecond());
            }
            return combineLandscapeAndPortrait(arrayList2);
        }
        if (!Intrinsics.areEqual(sizeMode, SizeMode.Exact.INSTANCE) || arrayList.size() != 2) {
            return Api31Impl.INSTANCE.createRemoteViews(MapsKt.toMap(arrayList));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.glance.appwidget.RemoteViewsTranslatorKt$translateComposition$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((SizeF) ((Pair) t).getFirst()).getHeight()), Float.valueOf(((SizeF) ((Pair) t2).getFirst()).getHeight()));
            }
        });
        ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(listSortedWith));
        Iterator it4 = listSortedWith.iterator();
        while (it4.hasNext()) {
            arrayList3.add((RemoteViews) ((Pair) it4.next()).getSecond());
        }
        return combineLandscapeAndPortrait(arrayList3);
    }

    @NotNull
    /* JADX INFO: renamed from: translateComposition-_rDzMTw, reason: not valid java name */
    public static final RemoteViews m21316translateComposition_rDzMTw(@NotNull Context context, int i, @NotNull RemoteViewsRoot element, @Nullable LayoutConfiguration layoutConfiguration, int i2, long j, @Nullable ComponentName componentName, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(element, "element");
        return translateComposition(new TranslationContext(context, i, isRtl(context), layoutConfiguration, -1, false, null, null, null, j, 0, 0, false, null, componentName, false, z, 0.0f, 179680, null), element.getChildren(), i2);
    }

    private static final void translateEmittableAndroidRemoteViews(RemoteViews remoteViews, TranslationContext translationContext, EmittableAndroidRemoteViews emittableAndroidRemoteViews) {
        RemoteViews remoteViewsCopy;
        if (emittableAndroidRemoteViews.getChildren().isEmpty()) {
            remoteViewsCopy = emittableAndroidRemoteViews.getRemoteViews();
        } else {
            if (emittableAndroidRemoteViews.getContainerViewId() == -1) {
                throw new IllegalStateException("To add children to an `AndroidRemoteViews`, its `containerViewId` must be set.");
            }
            remoteViewsCopy = copy(emittableAndroidRemoteViews.getRemoteViews());
            remoteViewsCopy.removeAllViews(emittableAndroidRemoteViews.getContainerViewId());
            int i = 0;
            for (Object obj : emittableAndroidRemoteViews.getChildren()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Emittable emittable = (Emittable) obj;
                RemoteViewsInfo remoteViewsInfoCreateRootView = LayoutSelectionKt.createRootView(translationContext, emittable.getModifier(), i);
                RemoteViews remoteViews2 = remoteViewsInfoCreateRootView.getRemoteViews();
                translateChild(remoteViews2, translationContext.forRoot(remoteViewsInfoCreateRootView), emittable);
                addChildView(remoteViewsCopy, emittableAndroidRemoteViews.getContainerViewId(), remoteViews2, i);
                i = i2;
            }
        }
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, LayoutType.Frame, emittableAndroidRemoteViews.getModifier());
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableAndroidRemoteViews.getModifier(), insertedViewInfoInsertView, null, 16, null);
        remoteViews.removeAllViews(insertedViewInfoInsertView.getMainViewId());
        addChildView(remoteViews, insertedViewInfoInsertView.getMainViewId(), remoteViewsCopy, 0);
    }

    private static final void translateEmittableBox(RemoteViews remoteViews, TranslationContext translationContext, EmittableBox emittableBox) {
        InsertedViewInfo insertedViewInfoM21299insertContainerViewnVsUan0 = LayoutSelectionKt.m21299insertContainerViewnVsUan0(remoteViews, translationContext, LayoutType.Box, emittableBox.getChildren().size(), emittableBox.getModifier(), Alignment.Horizontal.m21435boximpl(emittableBox.getContentAlignment().getHorizontal()), Alignment.Vertical.m21445boximpl(emittableBox.getContentAlignment().getVertical()));
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableBox.getModifier(), insertedViewInfoM21299insertContainerViewnVsUan0, null, 16, null);
        for (Emittable emittable : emittableBox.getChildren()) {
            emittable.setModifier(emittable.getModifier().then(new AlignmentModifier(emittableBox.getContentAlignment())));
        }
        setChildren(remoteViews, translationContext, insertedViewInfoM21299insertContainerViewnVsUan0, emittableBox.getChildren());
    }

    private static final void translateEmittableButton(RemoteViews remoteViews, TranslationContext translationContext, EmittableButton emittableButton) {
        if (Build.VERSION.SDK_INT < 31) {
            throw new IllegalStateException("Buttons in Android R and below are emulated using a EmittableBox containing the text.");
        }
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, LayoutType.Button, emittableButton.getModifier());
        TextTranslatorKt.setText$default(remoteViews, translationContext, insertedViewInfoInsertView.getMainViewId(), emittableButton.getText(), emittableButton.getStyle(), emittableButton.getMaxLines(), 16, 0.0f, 0, 192, null);
        float f = 16;
        emittableButton.setModifier(CornerRadiusKt.m21286cornerRadius3ABfNKs(AppWidgetModifiersKt.enabled(emittableButton.getModifier(), emittableButton.getEnabled()), C2256Dp.m20968constructorimpl(f)));
        if (emittableButton.getModifier().foldIn(null, new Function2<PaddingModifier, GlanceModifier.Element, PaddingModifier>() { // from class: androidx.glance.appwidget.RemoteViewsTranslatorKt$translateEmittableButton$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final PaddingModifier invoke(@Nullable PaddingModifier paddingModifier, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof PaddingModifier ? cur : paddingModifier;
            }
        }) == null) {
            emittableButton.setModifier(PaddingKt.m21497paddingVpY3zN4(emittableButton.getModifier(), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(8)));
        }
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableButton.getModifier(), insertedViewInfoInsertView, null, 16, null);
    }

    private static final void translateEmittableColumn(RemoteViews remoteViews, TranslationContext translationContext, EmittableColumn emittableColumn) {
        InsertedViewInfo insertedViewInfoM21299insertContainerViewnVsUan0 = LayoutSelectionKt.m21299insertContainerViewnVsUan0(remoteViews, translationContext, (Build.VERSION.SDK_INT < 31 || !RadioButtonKt.isSelectableGroup(emittableColumn.getModifier())) ? LayoutType.Column : LayoutType.RadioColumn, emittableColumn.getChildren().size(), emittableColumn.getModifier(), Alignment.Horizontal.m21435boximpl(emittableColumn.getHorizontalAlignment()), null);
        RemoteViewsCompat.setLinearLayoutGravity(remoteViews, insertedViewInfoM21299insertContainerViewnVsUan0.getMainViewId(), toGravity(new Alignment(emittableColumn.getHorizontalAlignment(), emittableColumn.getVerticalAlignment(), null)));
        ApplyModifiersKt.applyModifiers$default(translationContext.canUseSelectableGroup(), remoteViews, emittableColumn.getModifier(), insertedViewInfoM21299insertContainerViewnVsUan0, null, 16, null);
        setChildren(remoteViews, translationContext, insertedViewInfoM21299insertContainerViewnVsUan0, emittableColumn.getChildren());
        if (RadioButtonKt.isSelectableGroup(emittableColumn.getModifier())) {
            checkSelectableGroupChildren(emittableColumn.getChildren());
        }
    }

    private static final void translateEmittableRow(RemoteViews remoteViews, TranslationContext translationContext, EmittableRow emittableRow) {
        InsertedViewInfo insertedViewInfoM21299insertContainerViewnVsUan0 = LayoutSelectionKt.m21299insertContainerViewnVsUan0(remoteViews, translationContext, (Build.VERSION.SDK_INT < 31 || !RadioButtonKt.isSelectableGroup(emittableRow.getModifier())) ? LayoutType.Row : LayoutType.RadioRow, emittableRow.getChildren().size(), emittableRow.getModifier(), null, Alignment.Vertical.m21445boximpl(emittableRow.getVerticalAlignment()));
        RemoteViewsCompat.setLinearLayoutGravity(remoteViews, insertedViewInfoM21299insertContainerViewnVsUan0.getMainViewId(), toGravity(new Alignment(emittableRow.getHorizontalAlignment(), emittableRow.getVerticalAlignment(), null)));
        ApplyModifiersKt.applyModifiers$default(translationContext.canUseSelectableGroup(), remoteViews, emittableRow.getModifier(), insertedViewInfoM21299insertContainerViewnVsUan0, null, 16, null);
        setChildren(remoteViews, translationContext, insertedViewInfoM21299insertContainerViewnVsUan0, emittableRow.getChildren());
        if (RadioButtonKt.isSelectableGroup(emittableRow.getModifier())) {
            checkSelectableGroupChildren(emittableRow.getChildren());
        }
    }

    public static final void translateEmittableSizeBox(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableSizeBox element) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        if (element.getChildren().size() > 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(element.getChildren().size(), "Size boxes can only have at most one child ", ". The normalization of the composition tree failed.").toString());
        }
        Emittable emittable = (Emittable) CollectionsKt.firstOrNull((List) element.getChildren());
        if (emittable != null) {
            if (element.getDensity() != -1.0f) {
                translationContext.setDensity(element.getDensity());
            }
            translateChild(remoteViews, translationContext, emittable);
        }
    }

    private static final void translateEmittableSpacer(RemoteViews remoteViews, TranslationContext translationContext, EmittableSpacer emittableSpacer) {
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, emittableSpacer.getModifier(), LayoutSelectionKt.insertView(remoteViews, translationContext, LayoutType.Frame, emittableSpacer.getModifier()), null, 16, null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getForceRtl$annotations() {
    }
}
