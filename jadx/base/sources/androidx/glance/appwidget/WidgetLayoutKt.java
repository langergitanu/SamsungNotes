package androidx.glance.appwidget;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.action.ActionModifier;
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyList;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGrid;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.EmittableColumn;
import androidx.glance.layout.EmittableRow;
import androidx.glance.layout.EmittableSpacer;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.text.EmittableText;
import androidx.glance.unit.Dimension;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u000eH\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\r\u001a\u00020\u0017H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\r\u001a\u00020\u0019H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\r\u001a\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\r\u001a\u00020\u001dH\u0002\u001a\u0014\u0010\u001e\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\r\u001a\u00020\u001fH\u0002\u001a\u0016\u0010 \u001a\u00020!*\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0016\u0010 \u001a\u00020%*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010 \u001a\u00020)*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "heightModifier", "Landroidx/glance/unit/Dimension;", "Landroidx/glance/GlanceModifier;", "getHeightModifier", "(Landroidx/glance/GlanceModifier;)Landroidx/glance/unit/Dimension;", "widthModifier", "getWidthModifier", "createNode", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutNode;", "context", "Landroid/content/Context;", "element", "Landroidx/glance/Emittable;", "layoutDatastoreKey", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "getLayoutType", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutType;", "setBoxNode", "", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutNode$Builder;", "Landroidx/glance/layout/EmittableBox;", "setColumnNode", "Landroidx/glance/layout/EmittableColumn;", "setImageNode", "Landroidx/glance/EmittableImage;", "setLazyListColumn", "Landroidx/glance/appwidget/lazy/EmittableLazyColumn;", "setRowNode", "Landroidx/glance/layout/EmittableRow;", "toProto", "Landroidx/glance/appwidget/proto/LayoutProto$HorizontalAlignment;", "Landroidx/glance/layout/Alignment$Horizontal;", "toProto-uMT2-20", "(I)Landroidx/glance/appwidget/proto/LayoutProto$HorizontalAlignment;", "Landroidx/glance/appwidget/proto/LayoutProto$VerticalAlignment;", "Landroidx/glance/layout/Alignment$Vertical;", "toProto-Je2gTW8", "(I)Landroidx/glance/appwidget/proto/LayoutProto$VerticalAlignment;", "Landroidx/glance/appwidget/proto/LayoutProto$DimensionType;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/WidgetLayoutKt\n+ 2 Utils.kt\nandroidx/glance/UtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n22#2,7:436\n22#2,7:443\n22#2,7:454\n22#2,7:461\n1549#3:450\n1620#3,3:451\n*S KotlinDebug\n*F\n+ 1 WidgetLayout.kt\nandroidx/glance/appwidget/WidgetLayoutKt\n*L\n275#1:436,7\n276#1:443,7\n320#1:454,7\n323#1:461,7\n287#1:450\n287#1:451,3\n*E\n"})
public final class WidgetLayoutKt {

    @NotNull
    private static final String TAG = "GWT:WidgetLayout";

    @NotNull
    public static final LayoutProto.LayoutNode createNode(@NotNull Context context, @NotNull Emittable element) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(element, "element");
        LayoutProto.LayoutNode.Builder builderNewBuilder = LayoutProto.LayoutNode.newBuilder();
        builderNewBuilder.setType(getLayoutType(element));
        builderNewBuilder.setWidth(toProto(getWidthModifier(element.getModifier()), context));
        builderNewBuilder.setHeight(toProto(getHeightModifier(element.getModifier()), context));
        builderNewBuilder.setHasAction(element.getModifier().foldIn(null, new Function2<ActionModifier, GlanceModifier.Element, ActionModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$createNode$lambda$1$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final ActionModifier invoke(@Nullable ActionModifier actionModifier, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof ActionModifier ? cur : actionModifier;
            }
        }) != null);
        if (element.getModifier().foldIn(null, new Function2<AppWidgetBackgroundModifier, GlanceModifier.Element, AppWidgetBackgroundModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$createNode$lambda$1$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final AppWidgetBackgroundModifier invoke(@Nullable AppWidgetBackgroundModifier appWidgetBackgroundModifier, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof AppWidgetBackgroundModifier ? cur : appWidgetBackgroundModifier;
            }
        }) != null) {
            builderNewBuilder.setIdentity(LayoutProto.NodeIdentity.BACKGROUND_NODE);
        }
        if (element instanceof EmittableImage) {
            Intrinsics.checkNotNull(builderNewBuilder);
            setImageNode(builderNewBuilder, (EmittableImage) element);
        } else if (element instanceof EmittableColumn) {
            Intrinsics.checkNotNull(builderNewBuilder);
            setColumnNode(builderNewBuilder, (EmittableColumn) element);
        } else if (element instanceof EmittableRow) {
            Intrinsics.checkNotNull(builderNewBuilder);
            setRowNode(builderNewBuilder, (EmittableRow) element);
        } else if (element instanceof EmittableBox) {
            Intrinsics.checkNotNull(builderNewBuilder);
            setBoxNode(builderNewBuilder, (EmittableBox) element);
        } else if (element instanceof EmittableLazyColumn) {
            Intrinsics.checkNotNull(builderNewBuilder);
            setLazyListColumn(builderNewBuilder, (EmittableLazyColumn) element);
        }
        if ((element instanceof EmittableWithChildren) && !(element instanceof EmittableLazyList)) {
            List<Emittable> children = ((EmittableWithChildren) element).getChildren();
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(children));
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                arrayList.add(createNode(context, (Emittable) it.next()));
            }
            builderNewBuilder.addAllChildren(arrayList);
        }
        GeneratedMessageLite generatedMessageLiteBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild, "build(...)");
        return (LayoutProto.LayoutNode) generatedMessageLiteBuild;
    }

    private static final Dimension getHeightModifier(GlanceModifier glanceModifier) {
        Dimension height;
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$special$$inlined$findModifier$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof HeightModifier ? cur : heightModifier2;
            }
        });
        return (heightModifier == null || (height = heightModifier.getHeight()) == null) ? Dimension.Wrap.INSTANCE : height;
    }

    private static final LayoutProto.LayoutType getLayoutType(Emittable emittable) {
        if (emittable instanceof EmittableBox) {
            return LayoutProto.LayoutType.BOX;
        }
        if (emittable instanceof EmittableButton) {
            return LayoutProto.LayoutType.BUTTON;
        }
        if (emittable instanceof EmittableRow) {
            return RadioButtonKt.isSelectableGroup(emittable.getModifier()) ? LayoutProto.LayoutType.RADIO_ROW : LayoutProto.LayoutType.ROW;
        }
        if (emittable instanceof EmittableColumn) {
            return RadioButtonKt.isSelectableGroup(emittable.getModifier()) ? LayoutProto.LayoutType.RADIO_COLUMN : LayoutProto.LayoutType.COLUMN;
        }
        if (emittable instanceof EmittableText) {
            return LayoutProto.LayoutType.TEXT;
        }
        if (emittable instanceof EmittableLazyListItem) {
            return LayoutProto.LayoutType.LIST_ITEM;
        }
        if (emittable instanceof EmittableLazyColumn) {
            return LayoutProto.LayoutType.LAZY_COLUMN;
        }
        if (emittable instanceof EmittableAndroidRemoteViews) {
            return LayoutProto.LayoutType.ANDROID_REMOTE_VIEWS;
        }
        if (emittable instanceof EmittableCheckBox) {
            return LayoutProto.LayoutType.CHECK_BOX;
        }
        if (emittable instanceof EmittableSpacer) {
            return LayoutProto.LayoutType.SPACER;
        }
        if (emittable instanceof EmittableSwitch) {
            return LayoutProto.LayoutType.SWITCH;
        }
        if (emittable instanceof EmittableImage) {
            return emittable instanceof EmittableImageButton ? LayoutProto.LayoutType.IMAGE_BUTTON : LayoutProto.LayoutType.IMAGE;
        }
        if (emittable instanceof EmittableLinearProgressIndicator) {
            return LayoutProto.LayoutType.LINEAR_PROGRESS_INDICATOR;
        }
        if (emittable instanceof EmittableCircularProgressIndicator) {
            return LayoutProto.LayoutType.CIRCULAR_PROGRESS_INDICATOR;
        }
        if (emittable instanceof EmittableLazyVerticalGrid) {
            return LayoutProto.LayoutType.LAZY_VERTICAL_GRID;
        }
        if (emittable instanceof EmittableLazyVerticalGridListItem) {
            return LayoutProto.LayoutType.LIST_ITEM;
        }
        if (emittable instanceof RemoteViewsRoot) {
            return LayoutProto.LayoutType.REMOTE_VIEWS_ROOT;
        }
        if (emittable instanceof EmittableRadioButton) {
            return LayoutProto.LayoutType.RADIO_BUTTON;
        }
        if (emittable instanceof EmittableSizeBox) {
            return LayoutProto.LayoutType.SIZE_BOX;
        }
        if (emittable instanceof EmittableArcProgressIndicator) {
            return LayoutProto.LayoutType.ARC_PROGRESS_INDICATOR;
        }
        if (emittable instanceof EmittableStackedProgressIndicator) {
            return LayoutProto.LayoutType.STACKED_PROGRESS_INDICATOR;
        }
        throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown element type ", emittable.getClass().getCanonicalName()));
    }

    private static final Dimension getWidthModifier(GlanceModifier glanceModifier) {
        Dimension width;
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$special$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof WidthModifier ? cur : widthModifier2;
            }
        });
        return (widthModifier == null || (width = widthModifier.getWidth()) == null) ? Dimension.Wrap.INSTANCE : width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String layoutDatastoreKey(int i) {
        return AbstractC0000a.m11h(i, "appWidgetLayout-");
    }

    private static final void setBoxNode(LayoutProto.LayoutNode.Builder builder, EmittableBox emittableBox) {
        builder.setHorizontalAlignment(m21330toProtouMT220(emittableBox.getContentAlignment().getHorizontal()));
        builder.setVerticalAlignment(m21329toProtoJe2gTW8(emittableBox.getContentAlignment().getVertical()));
    }

    private static final void setColumnNode(LayoutProto.LayoutNode.Builder builder, EmittableColumn emittableColumn) {
        builder.setHorizontalAlignment(m21330toProtouMT220(emittableColumn.getHorizontalAlignment()));
    }

    private static final void setImageNode(LayoutProto.LayoutNode.Builder builder, EmittableImage emittableImage) {
        LayoutProto.ContentScale contentScale;
        int contentScale2 = emittableImage.getContentScale();
        ContentScale.Companion companion = androidx.glance.layout.ContentScale.INSTANCE;
        if (androidx.glance.layout.ContentScale.m21461equalsimpl0(contentScale2, companion.m21467getFitAe3V0ko())) {
            contentScale = LayoutProto.ContentScale.FIT;
        } else if (androidx.glance.layout.ContentScale.m21461equalsimpl0(contentScale2, companion.m21465getCropAe3V0ko())) {
            contentScale = LayoutProto.ContentScale.CROP;
        } else {
            if (!androidx.glance.layout.ContentScale.m21461equalsimpl0(contentScale2, companion.m21466getFillBoundsAe3V0ko())) {
                throw new IllegalStateException(("Unknown content scale " + androidx.glance.layout.ContentScale.m21463toStringimpl(emittableImage.getContentScale())).toString());
            }
            contentScale = LayoutProto.ContentScale.FILL_BOUNDS;
        }
        builder.setImageScale(contentScale);
        builder.setHasImageDescription(!ImageKt.isDecorative(emittableImage));
        builder.setHasImageColorFilter(emittableImage.getColorFilterParams() != null);
    }

    private static final void setLazyListColumn(LayoutProto.LayoutNode.Builder builder, EmittableLazyColumn emittableLazyColumn) {
        builder.setHorizontalAlignment(m21330toProtouMT220(emittableLazyColumn.getHorizontalAlignment()));
    }

    private static final void setRowNode(LayoutProto.LayoutNode.Builder builder, EmittableRow emittableRow) {
        builder.setVerticalAlignment(m21329toProtoJe2gTW8(emittableRow.getVerticalAlignment()));
    }

    private static final LayoutProto.DimensionType toProto(Dimension dimension, Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return WidgetLayoutImpl31.INSTANCE.toProto(dimension);
        }
        Dimension dimensionResolveDimension = LayoutSelectionKt.resolveDimension(dimension, context);
        if (dimensionResolveDimension instanceof Dimension.C3532Dp) {
            return LayoutProto.DimensionType.EXACT;
        }
        if (dimensionResolveDimension instanceof Dimension.Wrap) {
            return LayoutProto.DimensionType.WRAP;
        }
        if (dimensionResolveDimension instanceof Dimension.Fill) {
            return LayoutProto.DimensionType.FILL;
        }
        if (dimensionResolveDimension instanceof Dimension.Expand) {
            return LayoutProto.DimensionType.EXPAND;
        }
        throw new IllegalStateException("After resolution, no other type should be present");
    }

    /* JADX INFO: renamed from: toProto-Je2gTW8, reason: not valid java name */
    private static final LayoutProto.VerticalAlignment m21329toProtoJe2gTW8(int i) {
        Alignment.Vertical.Companion companion = Alignment.Vertical.INSTANCE;
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21454getTopmnfRV0w())) {
            return LayoutProto.VerticalAlignment.TOP;
        }
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21453getCenterVerticallymnfRV0w())) {
            return LayoutProto.VerticalAlignment.CENTER_VERTICALLY;
        }
        if (Alignment.Vertical.m21448equalsimpl0(i, companion.m21452getBottommnfRV0w())) {
            return LayoutProto.VerticalAlignment.BOTTOM;
        }
        throw new IllegalStateException(("unknown vertical alignment " + Alignment.Vertical.m21450toStringimpl(i)).toString());
    }

    /* JADX INFO: renamed from: toProto-uMT2-20, reason: not valid java name */
    private static final LayoutProto.HorizontalAlignment m21330toProtouMT220(int i) {
        Alignment.Horizontal.Companion companion = Alignment.Horizontal.INSTANCE;
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21444getStartPGIyAqw())) {
            return LayoutProto.HorizontalAlignment.START;
        }
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21442getCenterHorizontallyPGIyAqw())) {
            return LayoutProto.HorizontalAlignment.CENTER_HORIZONTALLY;
        }
        if (Alignment.Horizontal.m21438equalsimpl0(i, companion.m21443getEndPGIyAqw())) {
            return LayoutProto.HorizontalAlignment.END;
        }
        throw new IllegalStateException(("unknown horizontal alignment " + Alignment.Horizontal.m21440toStringimpl(i)).toString());
    }
}
