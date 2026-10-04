package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a>\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a*\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a>\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m13886d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,484:1\n149#2:485\n149#2:486\n149#2:487\n149#2:488\n149#2:489\n149#2:490\n149#2:491\n149#2:492\n149#2:493\n149#2:494\n149#2:495\n149#2:496\n149#2:497\n149#2:498\n149#2:499\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/compose/foundation/layout/PaddingKt\n*L\n51#1:485\n52#1:486\n53#1:487\n54#1:488\n84#1:489\n85#1:490\n157#1:491\n158#1:492\n159#1:493\n160#1:494\n284#1:495\n294#1:496\n295#1:497\n296#1:498\n297#1:499\n*E\n"})
public final class PaddingKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m15847PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m15848PaddingValuesYgX7TsA(float f, float f4) {
        return new PaddingValuesImpl(f, f4, f, f4, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m15849PaddingValuesYgX7TsA$default(float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        return m15848PaddingValuesYgX7TsA(f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m15850PaddingValuesa9UjIt4(float f, float f4, float f5, float f6) {
        return new PaddingValuesImpl(f, f4, f5, f6, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m15851PaddingValuesa9UjIt4$default(float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return m15850PaddingValuesa9UjIt4(f, f4, f5, f6);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m15852absolutePaddingqDBjuR0(@NotNull Modifier modifier, final float f, final float f4, final float f5, final float f6) {
        return modifier.then(new PaddingElement(f, f4, f5, f6, false, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$absolutePadding$1
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
                inspectorInfo.setName("absolutePadding");
                AbstractC0622a.m1162h(f5, AbstractC0622a.m1162h(f4, AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "left", inspectorInfo), "top", inspectorInfo), "right", inspectorInfo).set("bottom", C2256Dp.m20966boximpl(f6));
            }
        }, null));
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15853absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return m15852absolutePaddingqDBjuR0(modifier, f, f4, f5, f6);
    }

    @Stable
    public static final float calculateEndPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo15806calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo15805calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    public static final float calculateStartPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo15805calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo15806calculateRightPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    @NotNull
    public static final Modifier padding(@NotNull Modifier modifier, @NotNull final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.4
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
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("paddingValues", paddingValues);
            }
        }));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m15854padding3ABfNKs(@NotNull Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.3
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
                inspectorInfo.setName("padding");
                inspectorInfo.setValue(C2256Dp.m20966boximpl(f));
            }
        }, null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m15855paddingVpY3zN4(@NotNull Modifier modifier, final float f, final float f4) {
        return modifier.then(new PaddingElement(f, f4, f, f4, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.2
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
                inspectorInfo.setName("padding");
                AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "horizontal", inspectorInfo).set("vertical", C2256Dp.m20966boximpl(f4));
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15856paddingVpY3zN4$default(Modifier modifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        return m15855paddingVpY3zN4(modifier, f, f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m15857paddingqDBjuR0(@NotNull Modifier modifier, final float f, final float f4, final float f5, final float f6) {
        return modifier.then(new PaddingElement(f, f4, f5, f6, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.1
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
                inspectorInfo.setName("padding");
                AbstractC0622a.m1162h(f5, AbstractC0622a.m1162h(f4, AbstractC0622a.m1162h(f, inspectorInfo.getProperties(), "start", inspectorInfo), "top", inspectorInfo), "end", inspectorInfo).set("bottom", C2256Dp.m20966boximpl(f6));
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15858paddingqDBjuR0$default(Modifier modifier, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f5 = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f6 = C2256Dp.m20968constructorimpl(0);
        }
        return m15857paddingqDBjuR0(modifier, f, f4, f5, f6);
    }
}
