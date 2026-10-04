package androidx.glance.appwidget;

import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001a\u00020\t2\b\b\u0003\u0010\u0004\u001a\u00020\t2\b\b\u0003\u0010\u0005\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a(\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a<\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\b\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\t\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u000e\u001a\u00020\t2\b\b\u0003\u0010\u000f\u001a\u00020\t\u001a2\u0010\n\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0012\u001a\u00020\t2\b\b\u0003\u0010\u0004\u001a\u00020\t2\b\b\u0003\u0010\u0013\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\t\u001a\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m13886d2 = {"absoluteMargin", "Landroidx/glance/GlanceModifier;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "absoluteMargin-qDBjuR0", "(Landroidx/glance/GlanceModifier;FFFF)Landroidx/glance/GlanceModifier;", "", "margin", "all", "margin-3ABfNKs", "(Landroidx/glance/GlanceModifier;F)Landroidx/glance/GlanceModifier;", "horizontal", "vertical", "margin-VpY3zN4", "(Landroidx/glance/GlanceModifier;FF)Landroidx/glance/GlanceModifier;", "start", "end", "margin-qDBjuR0", "padding", "Landroidx/compose/ui/unit/DpRect;", "toMargin", "Landroidx/glance/appwidget/MarginDimension;", "toMargin-0680j_4", "(F)Landroidx/glance/appwidget/MarginDimension;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMargin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Margin.kt\nandroidx/glance/appwidget/MarginKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,190:1\n154#2:191\n154#2:192\n154#2:193\n154#2:194\n154#2:195\n154#2:196\n154#2:197\n154#2:198\n154#2:199\n154#2:200\n*S KotlinDebug\n*F\n+ 1 Margin.kt\nandroidx/glance/appwidget/MarginKt\n*L\n20#1:191\n21#1:192\n22#1:193\n23#1:194\n74#1:195\n75#1:196\n139#1:197\n140#1:198\n141#1:199\n142#1:200\n*E\n"})
public final class MarginKt {
    @NotNull
    public static final GlanceModifier absoluteMargin(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2, @DimenRes int i4, @DimenRes int i5) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new MarginModifier(toMargin(i), null, toMargin(i2), toMargin(i4), null, toMargin(i5), 18, null));
    }

    public static /* synthetic */ GlanceModifier absoluteMargin$default(GlanceModifier glanceModifier, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return absoluteMargin(glanceModifier, i, i2, i4, i5);
    }

    @NotNull
    /* JADX INFO: renamed from: absoluteMargin-qDBjuR0, reason: not valid java name */
    public static final GlanceModifier m21304absoluteMarginqDBjuR0(@NotNull GlanceModifier absoluteMargin, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(absoluteMargin, "$this$absoluteMargin");
        return absoluteMargin.then(new MarginModifier(m21311toMargin0680j_4(f), null, m21311toMargin0680j_4(f4), m21311toMargin0680j_4(f5), null, m21311toMargin0680j_4(f6), 18, null));
    }

    /* JADX INFO: renamed from: absoluteMargin-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21305absoluteMarginqDBjuR0$default(GlanceModifier glanceModifier, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return m21304absoluteMarginqDBjuR0(glanceModifier, f, f4, f5, f6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @NotNull DpRect padding) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return m21309marginqDBjuR0(glanceModifier, padding.m21051getLeftD9Ej5fM(), padding.m21053getTopD9Ej5fM(), padding.m21052getRightD9Ej5fM(), padding.m21050getBottomD9Ej5fM());
    }

    public static /* synthetic */ GlanceModifier margin$default(GlanceModifier glanceModifier, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return margin(glanceModifier, i, i2, i4, i5);
    }

    @NotNull
    /* JADX INFO: renamed from: margin-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21306margin3ABfNKs(@NotNull GlanceModifier margin, float f) {
        Intrinsics.checkNotNullParameter(margin, "$this$margin");
        MarginDimension marginDimensionM21311toMargin0680j_4 = m21311toMargin0680j_4(f);
        return margin.then(new MarginModifier(null, marginDimensionM21311toMargin0680j_4, marginDimensionM21311toMargin0680j_4, null, marginDimensionM21311toMargin0680j_4, marginDimensionM21311toMargin0680j_4, 9, null));
    }

    @NotNull
    /* JADX INFO: renamed from: margin-VpY3zN4, reason: not valid java name */
    public static final GlanceModifier m21307marginVpY3zN4(@NotNull GlanceModifier margin, float f, float f4) {
        Intrinsics.checkNotNullParameter(margin, "$this$margin");
        return margin.then(new MarginModifier(null, m21311toMargin0680j_4(f), m21311toMargin0680j_4(f4), null, m21311toMargin0680j_4(f), m21311toMargin0680j_4(f4), 9, null));
    }

    /* JADX INFO: renamed from: margin-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21308marginVpY3zN4$default(GlanceModifier glanceModifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        return m21307marginVpY3zN4(glanceModifier, f, f4);
    }

    @NotNull
    /* JADX INFO: renamed from: margin-qDBjuR0, reason: not valid java name */
    public static final GlanceModifier m21309marginqDBjuR0(@NotNull GlanceModifier margin, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(margin, "$this$margin");
        return margin.then(new MarginModifier(null, m21311toMargin0680j_4(f), m21311toMargin0680j_4(f4), null, m21311toMargin0680j_4(f5), m21311toMargin0680j_4(f6), 9, null));
    }

    /* JADX INFO: renamed from: margin-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21310marginqDBjuR0$default(GlanceModifier glanceModifier, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return m21309marginqDBjuR0(glanceModifier, f, f4, f5, f6);
    }

    private static final MarginDimension toMargin(int i) {
        return i == 0 ? new MarginDimension(0.0f, 0, 3, null) : new MarginDimension(i);
    }

    /* JADX INFO: renamed from: toMargin-0680j_4, reason: not valid java name */
    private static final MarginDimension m21311toMargin0680j_4(float f) {
        return new MarginDimension(f, 0, 2, null);
    }

    public static /* synthetic */ GlanceModifier margin$default(GlanceModifier glanceModifier, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        return margin(glanceModifier, i, i2);
    }

    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2, @DimenRes int i4, @DimenRes int i5) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new MarginModifier(null, toMargin(i), toMargin(i2), null, toMargin(i4), toMargin(i5), 9, null));
    }

    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new MarginModifier(null, toMargin(i), toMargin(i2), null, toMargin(i), toMargin(i2), 9, null));
    }

    @NotNull
    public static final GlanceModifier margin(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        MarginDimension margin = toMargin(i);
        return glanceModifier.then(new MarginModifier(null, margin, margin, null, margin, margin, 9, null));
    }
}
