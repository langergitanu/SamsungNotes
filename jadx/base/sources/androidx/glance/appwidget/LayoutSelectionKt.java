package androidx.glance.appwidget;

import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WeightModifier;
import androidx.glance.layout.WeightValue;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.unit.Dimension;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001d\u001aH\u0010\u001e\u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0000ø\u0001\u0000¢\u0006\u0002\b%\u001a$\u0010&\u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a&\u0010'\u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010(\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020*2\u0006\u0010+\u001a\u00020,H\u0000\u001a,\u0010-\u001a\u00020\u0002*\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0003\u001a\f\u0010/\u001a\u00020\u0019*\u00020*H\u0002\u001a\f\u00100\u001a\u00020\u0019*\u00020\u0019H\u0002\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\u0002X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, m13886d2 = {"FrameWeightLayoutTypeMap", "", "", "Landroidx/glance/appwidget/LayoutType;", "LayoutMap", "RootAliasTypeCount", SearchConstants.TargetContents.TAG, "", "TopLevelLayoutsCount", "getTopLevelLayoutsCount", "()I", "isSimple", "", "Landroidx/glance/appwidget/InsertedViewInfo;", "(Landroidx/glance/appwidget/InsertedViewInfo;)Z", "createRootView", "Landroidx/glance/appwidget/RemoteViewsInfo;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "modifier", "Landroidx/glance/GlanceModifier;", "aliasIndex", "makeViewStubSelector", "Landroidx/glance/appwidget/SizeSelector;", "width", "Landroidx/glance/appwidget/LayoutSize;", "height", "selectLayout33", "type", "(Landroidx/glance/appwidget/LayoutType;Landroidx/glance/GlanceModifier;)Ljava/lang/Integer;", "insertContainerView", "Landroid/widget/RemoteViews;", "numChildren", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "insertContainerView-nVsUan0", "insertView", "insertViewInternal", "childLayout", "resolveDimension", "Landroidx/glance/unit/Dimension;", "context", "Landroid/content/Context;", "selectChild", "pos", "toSpecSize", "toViewStubSize", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutSelection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutSelection.kt\nandroidx/glance/appwidget/LayoutSelectionKt\n+ 2 Utils.kt\nandroidx/glance/UtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,507:1\n22#2,7:508\n22#2,7:515\n22#2,7:522\n22#2,7:529\n22#2,7:536\n22#2,7:543\n22#2,7:551\n22#2,7:558\n22#2,7:565\n22#2,7:572\n1#3:550\n766#4:579\n857#4,2:580\n1855#4,2:582\n174#5:584\n*S KotlinDebug\n*F\n+ 1 LayoutSelection.kt\nandroidx/glance/appwidget/LayoutSelectionKt\n*L\n277#1:508,7\n280#1:515,7\n302#1:522,7\n304#1:529,7\n323#1:536,7\n325#1:543,7\n327#1:551,7\n329#1:558,7\n379#1:565,7\n380#1:572,7\n440#1:579\n440#1:580,2\n441#1:582,2\n493#1:584\n*E\n"})
public final class LayoutSelectionKt {

    @NotNull
    private static final Map<Integer, LayoutType> FrameWeightLayoutTypeMap;

    @NotNull
    private static final Map<LayoutType, Integer> LayoutMap = MapsKt.mapOf(TuplesKt.m13893to(LayoutType.Text, Integer.valueOf(C2902R.layout.glance_text)), TuplesKt.m13893to(LayoutType.List, Integer.valueOf(C2902R.layout.glance_list)), TuplesKt.m13893to(LayoutType.CheckBox, Integer.valueOf(C2902R.layout.glance_check_box)), TuplesKt.m13893to(LayoutType.CheckBoxBackport, Integer.valueOf(C2902R.layout.glance_check_box_backport)), TuplesKt.m13893to(LayoutType.Button, Integer.valueOf(C2902R.layout.glance_button)), TuplesKt.m13893to(LayoutType.Swtch, Integer.valueOf(C2902R.layout.glance_swtch)), TuplesKt.m13893to(LayoutType.SwtchBackport, Integer.valueOf(C2902R.layout.glance_swtch_backport)), TuplesKt.m13893to(LayoutType.Frame, Integer.valueOf(C2902R.layout.glance_frame)), TuplesKt.m13893to(LayoutType.ImageCrop, Integer.valueOf(C2902R.layout.glance_image_crop)), TuplesKt.m13893to(LayoutType.ImageCropDecorative, Integer.valueOf(C2902R.layout.glance_image_crop_decorative)), TuplesKt.m13893to(LayoutType.ImageFit, Integer.valueOf(C2902R.layout.glance_image_fit)), TuplesKt.m13893to(LayoutType.ImageFitDecorative, Integer.valueOf(C2902R.layout.glance_image_fit_decorative)), TuplesKt.m13893to(LayoutType.ImageFillBounds, Integer.valueOf(C2902R.layout.glance_image_fill_bounds)), TuplesKt.m13893to(LayoutType.ImageFillBoundsDecorative, Integer.valueOf(C2902R.layout.glance_image_fill_bounds_decorative)), TuplesKt.m13893to(LayoutType.LinearProgressIndicator, Integer.valueOf(C2902R.layout.glance_linear_progress_indicator)), TuplesKt.m13893to(LayoutType.CircularProgressIndicator, Integer.valueOf(C2902R.layout.glance_circular_progress_indicator)), TuplesKt.m13893to(LayoutType.VerticalGridOneColumn, Integer.valueOf(C2902R.layout.glance_vertical_grid_one_column)), TuplesKt.m13893to(LayoutType.VerticalGridTwoColumns, Integer.valueOf(C2902R.layout.glance_vertical_grid_two_columns)), TuplesKt.m13893to(LayoutType.VerticalGridThreeColumns, Integer.valueOf(C2902R.layout.glance_vertical_grid_three_columns)), TuplesKt.m13893to(LayoutType.VerticalGridFourColumns, Integer.valueOf(C2902R.layout.glance_vertical_grid_four_columns)), TuplesKt.m13893to(LayoutType.VerticalGridFiveColumns, Integer.valueOf(C2902R.layout.glance_vertical_grid_five_columns)), TuplesKt.m13893to(LayoutType.VerticalGridAutoFit, Integer.valueOf(C2902R.layout.glance_vertical_grid_auto_fit)), TuplesKt.m13893to(LayoutType.RadioButton, Integer.valueOf(C2902R.layout.glance_radio_button)), TuplesKt.m13893to(LayoutType.RadioButtonBackport, Integer.valueOf(C2902R.layout.glance_radio_button_backport)), TuplesKt.m13893to(LayoutType.ArcProgressIndicatorLarge, Integer.valueOf(C2902R.layout.glance_arc_progress_indicator_small)), TuplesKt.m13893to(LayoutType.ArcProgressIndicatorMedium, Integer.valueOf(C2902R.layout.glance_arc_progress_indicator_small)), TuplesKt.m13893to(LayoutType.ArcProgressIndicatorSmall, Integer.valueOf(C2902R.layout.glance_arc_progress_indicator_small)), TuplesKt.m13893to(LayoutType.CircularProgressIndicatorLarge, Integer.valueOf(C2902R.layout.glance_circular_progress_indicator_large)), TuplesKt.m13893to(LayoutType.CircularProgressIndicatorMedium, Integer.valueOf(C2902R.layout.glance_circular_progress_indicator_medium)), TuplesKt.m13893to(LayoutType.CircularProgressIndicatorSmall, Integer.valueOf(C2902R.layout.glance_circular_progress_indicator_small)), TuplesKt.m13893to(LayoutType.ImageButtonCrop, Integer.valueOf(C2902R.layout.glance_image_button_crop)), TuplesKt.m13893to(LayoutType.ImageButtonCropDecorative, Integer.valueOf(C2902R.layout.glance_image_button_crop_decorative)), TuplesKt.m13893to(LayoutType.ImageButtonFit, Integer.valueOf(C2902R.layout.glance_image_button_fit)), TuplesKt.m13893to(LayoutType.ImageButtonFitDecorative, Integer.valueOf(C2902R.layout.glance_image_button_fit_decorative)), TuplesKt.m13893to(LayoutType.ImageButtonFillBounds, Integer.valueOf(C2902R.layout.glance_image_button_fill_bounds)), TuplesKt.m13893to(LayoutType.ImageButtonFillBoundsDecorative, Integer.valueOf(C2902R.layout.glance_image_button_fill_bounds_decorative)), TuplesKt.m13893to(LayoutType.LinearProgressIndicatorDeterminate, Integer.valueOf(C2902R.layout.glance_linear_progress_indicator_determinate)), TuplesKt.m13893to(LayoutType.StackedProgressIndicator, Integer.valueOf(C2902R.layout.glance_stacked_progress_indicator)), TuplesKt.m13893to(LayoutType.TextFirstStrong, Integer.valueOf(C2902R.layout.glance_text_first_strong)), TuplesKt.m13893to(LayoutType.TextAutoSize, Integer.valueOf(C2902R.layout.glance_text_auto_size)), TuplesKt.m13893to(LayoutType.TextDisplay, Integer.valueOf(C2902R.layout.glance_text_display)), TuplesKt.m13893to(LayoutType.TextTitle, Integer.valueOf(C2902R.layout.glance_text_title)), TuplesKt.m13893to(LayoutType.TextBody, Integer.valueOf(C2902R.layout.glance_text_body)), TuplesKt.m13893to(LayoutType.TextDescription, Integer.valueOf(C2902R.layout.glance_text_description)), TuplesKt.m13893to(LayoutType.TextLabel, Integer.valueOf(C2902R.layout.glance_text_label)));
    private static final int RootAliasTypeCount;

    @NotNull
    private static final String TAG = "GWT:LayoutSelection";
    private static final int TopLevelLayoutsCount;

    static {
        int size = GeneratedLayoutsKt.getGeneratedRootLayoutShifts().size();
        RootAliasTypeCount = size;
        TopLevelLayoutsCount = Build.VERSION.SDK_INT >= 31 ? GeneratedLayoutsKt.getRootAliasCount() : GeneratedLayoutsKt.getRootAliasCount() / size;
        FrameWeightLayoutTypeMap = MapsKt.mapOf(TuplesKt.m13893to(1, LayoutType.FrameWeight1), TuplesKt.m13893to(2, LayoutType.FrameWeight2), TuplesKt.m13893to(3, LayoutType.FrameWeight3), TuplesKt.m13893to(4, LayoutType.FrameWeight4), TuplesKt.m13893to(5, LayoutType.FrameWeight5), TuplesKt.m13893to(45, LayoutType.FrameWeight45), TuplesKt.m13893to(55, LayoutType.FrameWeight55));
    }

    @NotNull
    public static final RemoteViewsInfo createRootView(@NotNull TranslationContext translationContext, @NotNull GlanceModifier modifier, int i) {
        Object objResolveDimension;
        Object objResolveDimension2;
        Dimension height;
        Dimension width;
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Context context = translationContext.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            if (i >= GeneratedLayoutsKt.getRootAliasCount()) {
                throw new IllegalArgumentException(AbstractC1038a.m1214o(GeneratedLayoutsKt.getRootAliasCount(), i, "Index of the root view cannot be more than ", ", currently ").toString());
            }
            LayoutSize layoutSize = LayoutSize.Wrap;
            SizeSelector sizeSelector = new SizeSelector(layoutSize, layoutSize);
            RemoteViews remoteViews = RemoteViewsTranslatorKt.remoteViews(translationContext, GeneratedLayoutsKt.getFirstRootAlias() + i);
            WidthModifier widthModifier = (WidthModifier) modifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$lambda$3$$inlined$findModifier$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof WidthModifier ? cur : widthModifier2;
                }
            });
            if (widthModifier != null) {
                ApplyModifiersKt.applySimpleWidthModifier(context, remoteViews, widthModifier, C2902R.id.rootView);
            }
            HeightModifier heightModifier = (HeightModifier) modifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$lambda$3$$inlined$findModifier$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof HeightModifier ? cur : heightModifier2;
                }
            });
            if (heightModifier != null) {
                ApplyModifiersKt.applySimpleHeightModifier(context, remoteViews, heightModifier, C2902R.id.rootView);
            }
            if (i2 >= 33) {
                remoteViews.removeAllViews(C2902R.id.rootView);
            }
            return new RemoteViewsInfo(remoteViews, new InsertedViewInfo(C2902R.id.rootView, 0, i2 >= 33 ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.m13893to(0, MapsKt.mapOf(TuplesKt.m13893to(sizeSelector, Integer.valueOf(C2902R.id.rootStubId))))), 2, null));
        }
        int i4 = RootAliasTypeCount;
        if (i4 * i >= GeneratedLayoutsKt.getRootAliasCount()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(GeneratedLayoutsKt.getRootAliasCount() / 4, i, "Index of the root view cannot be more than ", ", currently ").toString());
        }
        WidthModifier widthModifier2 = (WidthModifier) modifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WidthModifier invoke(@Nullable WidthModifier widthModifier3, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WidthModifier ? cur : widthModifier3;
            }
        });
        if (widthModifier2 == null || (width = widthModifier2.getWidth()) == null || (objResolveDimension = resolveDimension(width, context)) == null) {
            objResolveDimension = Dimension.Wrap.INSTANCE;
        }
        HeightModifier heightModifier2 = (HeightModifier) modifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier3, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier3;
            }
        });
        if (heightModifier2 == null || (height = heightModifier2.getHeight()) == null || (objResolveDimension2 = resolveDimension(height, context)) == null) {
            objResolveDimension2 = Dimension.Wrap.INSTANCE;
        }
        Dimension.Fill fill = Dimension.Fill.INSTANCE;
        LayoutSize layoutSize2 = Intrinsics.areEqual(objResolveDimension, fill) ? LayoutSize.MatchParent : LayoutSize.Wrap;
        LayoutSize layoutSize3 = Intrinsics.areEqual(objResolveDimension2, fill) ? LayoutSize.MatchParent : LayoutSize.Wrap;
        SizeSelector sizeSelectorMakeViewStubSelector = makeViewStubSelector(layoutSize2, layoutSize3);
        Integer num = GeneratedLayoutsKt.getGeneratedRootLayoutShifts().get(sizeSelectorMakeViewStubSelector);
        if (num != null) {
            return new RemoteViewsInfo(RemoteViewsTranslatorKt.remoteViews(translationContext, AbstractC1974b.m1310c(i4, i, GeneratedLayoutsKt.getFirstRootAlias(), num.intValue())), new InsertedViewInfo(0, 0, MapsKt.mapOf(TuplesKt.m13893to(0, MapsKt.mapOf(TuplesKt.m13893to(sizeSelectorMakeViewStubSelector, Integer.valueOf(C2902R.id.rootStubId))))), 3, null));
        }
        throw new IllegalStateException("Cannot find root element for size [" + layoutSize2 + SQLKeyword.COMMA + layoutSize3 + "]");
    }

    public static final int getTopLevelLayoutsCount() {
        return TopLevelLayoutsCount;
    }

    @NotNull
    /* JADX INFO: renamed from: insertContainerView-nVsUan0, reason: not valid java name */
    public static final InsertedViewInfo m21299insertContainerViewnVsUan0(@NotNull RemoteViews insertContainerView, @NotNull TranslationContext translationContext, @NotNull LayoutType type, int i, @NotNull GlanceModifier modifier, @Nullable Alignment.Horizontal horizontal, @Nullable Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(insertContainerView, "$this$insertContainerView");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (i > 10) {
            GlanceLog.INSTANCE.m2300e(TAG, "Truncated " + type + " container from " + i + " to 10 elements", new IllegalArgumentException(type + " container cannot have more than 10 elements"));
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(i, 10);
        Integer numSelectLayout33 = selectLayout33(type, modifier);
        if (numSelectLayout33 == null) {
            ContainerInfo containerInfo = GeneratedLayoutsKt.getGeneratedContainers().get(new ContainerSelector(type, iCoerceAtMost, horizontal, vertical, null));
            numSelectLayout33 = containerInfo != null ? Integer.valueOf(containerInfo.getLayoutId()) : null;
            if (numSelectLayout33 == null) {
                throw new IllegalArgumentException("Cannot find container " + type + " with " + i + " children");
            }
        }
        int iIntValue = numSelectLayout33.intValue();
        Map<Integer, Map<SizeSelector, Integer>> map = GeneratedLayoutsKt.getGeneratedChildren().get(type);
        if (map == null) {
            throw new IllegalArgumentException("Cannot find generated children for " + type);
        }
        InsertedViewInfo insertedViewInfoCopy$default = InsertedViewInfo.copy$default(insertViewInternal(insertContainerView, translationContext, iIntValue, modifier), 0, 0, map, 3, null);
        if (Build.VERSION.SDK_INT >= 33) {
            insertContainerView.removeAllViews(insertedViewInfoCopy$default.getMainViewId());
        }
        return insertedViewInfoCopy$default;
    }

    @NotNull
    public static final InsertedViewInfo insertView(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull LayoutType type, @NotNull GlanceModifier modifier) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Integer numSelectLayout33 = selectLayout33(type, modifier);
        if (numSelectLayout33 != null || (numSelectLayout33 = LayoutMap.get(type)) != null) {
            return insertViewInternal(remoteViews, translationContext, numSelectLayout33.intValue(), modifier);
        }
        throw new IllegalArgumentException("Cannot use `insertView` with a container like " + type);
    }

    private static final InsertedViewInfo insertViewInternal(RemoteViews remoteViews, TranslationContext translationContext, @LayoutRes int i, GlanceModifier glanceModifier) {
        Dimension width;
        Dimension height;
        int itemPosition = translationContext.getItemPosition();
        Integer numValueOf = null;
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WidthModifier ? cur : widthModifier2;
            }
        });
        if (widthModifier == null || (width = widthModifier.getWidth()) == null) {
            width = Dimension.Wrap.INSTANCE;
        }
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier2;
            }
        });
        if (heightModifier == null || (height = heightModifier.getHeight()) == null) {
            height = Dimension.Wrap.INSTANCE;
        }
        if (!glanceModifier.all(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$specifiedViewId$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!(it instanceof AppWidgetBackgroundModifier));
            }
        })) {
            if (translationContext.isBackgroundSpecified().getAndSet(true)) {
                throw new IllegalStateException("At most one view can be set as AppWidgetBackground.");
            }
            numValueOf = Integer.valueOf(android.R.id.background);
        }
        Integer num = numValueOf;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            int iIntValue = num != null ? num.intValue() : translationContext.nextViewId();
            LayoutSelectionApi31Impl layoutSelectionApi31Impl = LayoutSelectionApi31Impl.INSTANCE;
            String packageName = translationContext.getContext().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            RemoteViewsTranslatorKt.addChildView(remoteViews, translationContext.getParentContext().getMainViewId(), layoutSelectionApi31Impl.remoteViews(packageName, i, iIntValue), itemPosition);
            return new InsertedViewInfo(iIntValue, 0, null, 6, null);
        }
        if (i2 >= 31) {
            Dimension.Expand expand = Dimension.Expand.INSTANCE;
            return new InsertedViewInfo(UtilsKt.inflateViewStub(remoteViews, translationContext, selectChild(remoteViews, translationContext, itemPosition, Intrinsics.areEqual(width, expand) ? LayoutSize.Expand : LayoutSize.Wrap, Intrinsics.areEqual(height, expand) ? LayoutSize.Expand : LayoutSize.Wrap), i, num), 0, null, 6, null);
        }
        Context context = translationContext.getContext();
        LayoutSize specSize = toSpecSize(resolveDimension(width, context));
        LayoutSize specSize2 = toSpecSize(resolveDimension(height, context));
        int iSelectChild = selectChild(remoteViews, translationContext, itemPosition, specSize, specSize2);
        LayoutSize layoutSize = LayoutSize.Fixed;
        if (specSize != layoutSize && specSize2 != layoutSize) {
            return new InsertedViewInfo(UtilsKt.inflateViewStub(remoteViews, translationContext, iSelectChild, i, num), 0, null, 6, null);
        }
        LayoutInfo layoutInfo = GeneratedLayoutsKt.getGeneratedComplexLayouts().get(new SizeSelector(specSize, specSize2));
        if (layoutInfo != null) {
            return new InsertedViewInfo(UtilsKt.inflateViewStub(remoteViews, translationContext, C2902R.id.glanceViewStub, i, num), UtilsKt.inflateViewStub$default(remoteViews, translationContext, iSelectChild, layoutInfo.getLayoutId(), null, 8, null), null, 4, null);
        }
        throw new IllegalArgumentException("Could not find complex layout for width=" + specSize + ", height=" + specSize2);
    }

    public static final boolean isSimple(@NotNull InsertedViewInfo insertedViewInfo) {
        Intrinsics.checkNotNullParameter(insertedViewInfo, "<this>");
        return insertedViewInfo.getComplexViewId() == -1;
    }

    private static final SizeSelector makeViewStubSelector(LayoutSize layoutSize, LayoutSize layoutSize2) {
        return new SizeSelector(toViewStubSize(layoutSize), toViewStubSize(layoutSize2));
    }

    @NotNull
    public static final Dimension resolveDimension(@NotNull Dimension dimension, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(dimension, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(dimension instanceof Dimension.Resource)) {
            return dimension;
        }
        float dimension2 = context.getResources().getDimension(((Dimension.Resource) dimension).getRes());
        int i = (int) dimension2;
        return i != -2 ? i != -1 ? new Dimension.C3532Dp(C2256Dp.m20968constructorimpl(dimension2 / context.getResources().getDisplayMetrics().density), null) : Dimension.Fill.INSTANCE : Dimension.Wrap.INSTANCE;
    }

    @IdRes
    private static final int selectChild(RemoteViews remoteViews, TranslationContext translationContext, int i, LayoutSize layoutSize, LayoutSize layoutSize2) {
        SizeSelector sizeSelectorMakeViewStubSelector = makeViewStubSelector(layoutSize, layoutSize2);
        Map<SizeSelector, Integer> map = translationContext.getParentContext().getChildren().get(Integer.valueOf(i));
        if (map == null) {
            throw new IllegalStateException(AbstractC0000a.m11h(i, "Parent doesn't have child position "));
        }
        Integer num = map.get(sizeSelectorMakeViewStubSelector);
        if (num == null) {
            throw new IllegalStateException("No child for position " + i + " and size " + layoutSize + " x " + layoutSize2);
        }
        int iIntValue = num.intValue();
        Collection<Integer> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Number) obj).intValue() != iIntValue) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UtilsKt.inflateViewStub(remoteViews, translationContext, ((Number) it.next()).intValue(), C2902R.layout.glance_deleted_view, Integer.valueOf(C2902R.id.deletedViewId));
        }
        return iIntValue;
    }

    @IdRes
    private static final Integer selectLayout33(LayoutType layoutType, GlanceModifier glanceModifier) {
        WeightValue weight;
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        AlignmentModifier alignmentModifier = (AlignmentModifier) glanceModifier.foldIn(null, new Function2<AlignmentModifier, GlanceModifier.Element, AlignmentModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final AlignmentModifier invoke(@Nullable AlignmentModifier alignmentModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof AlignmentModifier ? cur : alignmentModifier2;
            }
        });
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WidthModifier ? cur : widthModifier2;
            }
        });
        boolean z = false;
        boolean z2 = widthModifier != null && Intrinsics.areEqual(widthModifier.getWidth(), Dimension.Expand.INSTANCE);
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier2;
            }
        });
        if (heightModifier != null && Intrinsics.areEqual(heightModifier.getHeight(), Dimension.Expand.INSTANCE)) {
            z = true;
        }
        WeightModifier weightModifier = (WeightModifier) glanceModifier.foldIn(null, new Function2<WeightModifier, GlanceModifier.Element, WeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WeightModifier invoke(@Nullable WeightModifier weightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WeightModifier ? cur : weightModifier2;
            }
        });
        int value = (weightModifier == null || (weight = weightModifier.getWeight()) == null) ? -1 : weight.getValue();
        if (alignmentModifier != null) {
            LayoutInfo layoutInfo = GeneratedLayoutsKt.getGeneratedBoxChildren().get(new BoxChildSelector(layoutType, alignmentModifier.getAlignment().getHorizontal(), alignmentModifier.getAlignment().getVertical(), null));
            if (layoutInfo != null) {
                return Integer.valueOf(layoutInfo.getLayoutId());
            }
            throw new IllegalArgumentException("Cannot find " + layoutType + " with alignment " + alignmentModifier.getAlignment());
        }
        if (!z2 && !z && value <= 0) {
            return null;
        }
        Map<RowColumnChildSelector, LayoutInfo> generatedRowColumnChildren = GeneratedLayoutsKt.getGeneratedRowColumnChildren();
        LayoutType layoutType2 = FrameWeightLayoutTypeMap.get(Integer.valueOf(value));
        if (layoutType2 == null) {
            layoutType2 = layoutType;
        }
        LayoutInfo layoutInfo2 = generatedRowColumnChildren.get(new RowColumnChildSelector(layoutType2, z2, z));
        if (layoutInfo2 != null) {
            return Integer.valueOf(layoutInfo2.getLayoutId());
        }
        throw new IllegalArgumentException("Cannot find " + layoutType + " with defaultWeight set");
    }

    private static final LayoutSize toSpecSize(Dimension dimension) {
        if (dimension instanceof Dimension.Wrap) {
            return LayoutSize.Wrap;
        }
        if (dimension instanceof Dimension.Expand) {
            return LayoutSize.Expand;
        }
        if (dimension instanceof Dimension.Fill) {
            return LayoutSize.MatchParent;
        }
        if (dimension instanceof Dimension.C3532Dp ? true : dimension instanceof Dimension.Resource) {
            return LayoutSize.Fixed;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final LayoutSize toViewStubSize(LayoutSize layoutSize) {
        return layoutSize == LayoutSize.Fixed ? LayoutSize.Wrap : layoutSize;
    }
}
