package androidx.compose.foundation.layout;

import androidx.annotation.FloatRange;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a*\u0010\u001a\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a\u001e\u0010\u001e\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a*\u0010 \u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0019\u001a&\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a>\u0010*\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001e\u0010/\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a*\u00101\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0019\u001a&\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010)\u001a>\u00106\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010.\u001a\u001e\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a*\u00109\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0011\u001a \u0010;\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010@\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020A2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010B\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020?H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, m13886d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fraction", "", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "wrapContentWidth", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSize.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Size.kt\nandroidx/compose/foundation/layout/SizeKt\n+ 2 InspectableValue.kt\nandroidx/compose/ui/platform/InspectableValueKt\n*L\n1#1,1112:1\n135#2:1113\n135#2:1114\n135#2:1115\n135#2:1116\n135#2:1117\n135#2:1118\n135#2:1119\n135#2:1120\n135#2:1121\n135#2:1122\n135#2:1123\n135#2:1124\n135#2:1125\n135#2:1126\n*S KotlinDebug\n*F\n+ 1 Size.kt\nandroidx/compose/foundation/layout/SizeKt\n*L\n61#1:1113\n85#1:1114\n111#1:1115\n138#1:1116\n176#1:1117\n199#1:1118\n226#1:1119\n257#1:1120\n285#1:1121\n315#1:1122\n342#1:1123\n381#1:1124\n405#1:1125\n434#1:1126\n*E\n"})
public final class SizeKt {

    @NotNull
    private static final FillElement FillWholeMaxHeight;

    @NotNull
    private static final FillElement FillWholeMaxSize;

    @NotNull
    private static final FillElement FillWholeMaxWidth;

    @NotNull
    private static final WrapContentElement WrapContentHeightCenter;

    @NotNull
    private static final WrapContentElement WrapContentHeightTop;

    @NotNull
    private static final WrapContentElement WrapContentSizeCenter;

    @NotNull
    private static final WrapContentElement WrapContentSizeTopStart;

    @NotNull
    private static final WrapContentElement WrapContentWidthCenter;

    @NotNull
    private static final WrapContentElement WrapContentWidthStart;

    static {
        FillElement.Companion companion = FillElement.INSTANCE;
        FillWholeMaxWidth = companion.width(1.0f);
        FillWholeMaxHeight = companion.height(1.0f);
        FillWholeMaxSize = companion.size(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.INSTANCE;
        Alignment.Companion companion3 = Alignment.INSTANCE;
        WrapContentWidthCenter = companion2.width(companion3.getCenterHorizontally(), false);
        WrapContentWidthStart = companion2.width(companion3.getStart(), false);
        WrapContentHeightCenter = companion2.height(companion3.getCenterVertically(), false);
        WrapContentHeightTop = companion2.height(companion3.getTop(), false);
        WrapContentSizeCenter = companion2.size(companion3.getCenter(), false);
        WrapContentSizeTopStart = companion2.size(companion3.getTopStart(), false);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m15883defaultMinSizeVpY3zN4(@NotNull Modifier modifier, float f, float f4) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f4, null));
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15884defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15883defaultMinSizeVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxHeight(@NotNull Modifier modifier, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxHeight : FillElement.INSTANCE.height(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxSize(@NotNull Modifier modifier, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxSize : FillElement.INSTANCE.size(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxWidth(@NotNull Modifier modifier, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : FillElement.INSTANCE.width(f));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m15885height3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("height");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m15886heightInVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("heightIn");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), VElementFormulasCmd.FMIN, inspectorInfo).set(VElementFormulasCmd.FMAX, C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15887heightInVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15886heightInVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m15888requiredHeight3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredHeight");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m15889requiredHeightInVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredHeightIn");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), VElementFormulasCmd.FMIN, inspectorInfo).set(VElementFormulasCmd.FMAX, C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15890requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15889requiredHeightInVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m15891requiredSize3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSize");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m15892requiredSize6HolHcs(@NotNull Modifier modifier, long j) {
        return m15893requiredSizeVpY3zN4(modifier, DpSize.m21066getWidthD9Ej5fM(j), DpSize.m21064getHeightD9Ej5fM(j));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m15893requiredSizeVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(f, f4, f, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSize");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "width", inspectorInfo).set("height", C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m15894requiredSizeInqDBjuR0(@NotNull Modifier modifier, final float f, final float f4, final float f5, final float f6) {
        return modifier.then(new SizeElement(f, f4, f5, f6, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredSizeIn");
                AbstractC0622a.m1162h(f5, AbstractC0622a.m1162h(f4, AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "minWidth", inspectorInfo), "minHeight", inspectorInfo), "maxWidth", inspectorInfo).set("maxHeight", C2256Dp.m20966boximpl(f6));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15895requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15894requiredSizeInqDBjuR0(modifier, f, f4, f5, f6);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m15896requiredWidth3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredWidth");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m15897requiredWidthInVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(f, 0.0f, f4, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("requiredWidthIn");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), VElementFormulasCmd.FMIN, inspectorInfo).set(VElementFormulasCmd.FMAX, C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15898requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15897requiredWidthInVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m15899size3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("size");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m15900size6HolHcs(@NotNull Modifier modifier, long j) {
        return m15901sizeVpY3zN4(modifier, DpSize.m21066getWidthD9Ej5fM(j), DpSize.m21064getHeightD9Ej5fM(j));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m15901sizeVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(f, f4, f, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("size");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "width", inspectorInfo).set("height", C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m15902sizeInqDBjuR0(@NotNull Modifier modifier, final float f, final float f4, final float f5, final float f6) {
        return modifier.then(new SizeElement(f, f4, f5, f6, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("sizeIn");
                AbstractC0622a.m1162h(f5, AbstractC0622a.m1162h(f4, AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "minWidth", inspectorInfo), "minHeight", inspectorInfo), "maxWidth", inspectorInfo).set("maxHeight", C2256Dp.m20966boximpl(f6));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15903sizeInqDBjuR0$default(Modifier modifier, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15902sizeInqDBjuR0(modifier, f, f4, f5, f6);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m15904width3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("width");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m15905widthInVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new SizeElement(f, 0.0f, f4, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("widthIn");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), VElementFormulasCmd.FMIN, inspectorInfo).set(VElementFormulasCmd.FMAX, C2256Dp.m20966boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15906widthInVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.INSTANCE.m20988getUnspecifiedD9Ej5fM();
        }
        return m15905widthInVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentHeight(@NotNull Modifier modifier, @NotNull Alignment.Vertical vertical, boolean z) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!Intrinsics.areEqual(vertical, companion.getCenterVertically()) || z) ? (!Intrinsics.areEqual(vertical, companion.getTop()) || z) ? WrapContentElement.INSTANCE.height(vertical, z) : WrapContentHeightTop : WrapContentHeightCenter);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.INSTANCE.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentSize(@NotNull Modifier modifier, @NotNull Alignment alignment, boolean z) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!Intrinsics.areEqual(alignment, companion.getCenter()) || z) ? (!Intrinsics.areEqual(alignment, companion.getTopStart()) || z) ? WrapContentElement.INSTANCE.size(alignment, z) : WrapContentSizeTopStart : WrapContentSizeCenter);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentWidth(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal, boolean z) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!Intrinsics.areEqual(horizontal, companion.getCenterHorizontally()) || z) ? (!Intrinsics.areEqual(horizontal, companion.getStart()) || z) ? WrapContentElement.INSTANCE.width(horizontal, z) : WrapContentWidthStart : WrapContentWidthCenter);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.INSTANCE.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }
}
