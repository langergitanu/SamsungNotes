package androidx.glance.layout;

import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.glance.GlanceModifier;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001a\u00020\t2\b\b\u0003\u0010\u0004\u001a\u00020\t2\b\b\u0003\u0010\u0005\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0001H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a<\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\b\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\t\u001a\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\u0015\u001a\u00020\t\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0018\u001a\u00020\t2\b\b\u0003\u0010\u0004\u001a\u00020\t2\b\b\u0003\u0010\u0019\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\t\u001a\u001f\u0010\u001b\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\t0\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001d\u001a\u0016\u0010\u001e\u001a\u00020\u001f*\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m13886d2 = {"absolutePadding", "Landroidx/glance/GlanceModifier;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "absolutePadding-qDBjuR0", "(Landroidx/glance/GlanceModifier;FFFF)Landroidx/glance/GlanceModifier;", "", "collectPadding", "Landroidx/glance/layout/PaddingModifier;", "collectPaddingInDp", "Landroidx/glance/layout/PaddingInDp;", "resources", "Landroid/content/res/Resources;", "padding", "all", "padding-3ABfNKs", "(Landroidx/glance/GlanceModifier;F)Landroidx/glance/GlanceModifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/glance/GlanceModifier;FF)Landroidx/glance/GlanceModifier;", "start", "end", "padding-qDBjuR0", "toDp", "", "(Ljava/util/List;Landroid/content/res/Resources;)F", "toPadding", "Landroidx/glance/layout/PaddingDimension;", "toPadding-0680j_4", "(F)Landroidx/glance/layout/PaddingDimension;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,276:1\n154#2:277\n154#2:278\n154#2:279\n154#2:280\n154#2:281\n154#2:282\n154#2:283\n154#2:284\n154#2:285\n154#2:286\n154#2:287\n174#2:290\n1789#3,2:288\n1791#3:292\n51#4:291\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/glance/layout/PaddingKt\n*L\n35#1:277\n36#1:278\n37#1:279\n38#1:280\n79#1:281\n80#1:282\n144#1:283\n145#1:284\n146#1:285\n147#1:286\n196#1:287\n197#1:290\n196#1:288,2\n196#1:292\n197#1:291\n*E\n"})
public final class PaddingKt {
    @NotNull
    public static final GlanceModifier absolutePadding(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2, @DimenRes int i4, @DimenRes int i5) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new PaddingModifier(toPadding(i), null, toPadding(i2), toPadding(i4), null, toPadding(i5), 18, null));
    }

    public static /* synthetic */ GlanceModifier absolutePadding$default(GlanceModifier glanceModifier, int i, int i2, int i4, int i5, int i6, Object obj) {
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
        return absolutePadding(glanceModifier, i, i2, i4, i5);
    }

    @NotNull
    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final GlanceModifier m21494absolutePaddingqDBjuR0(@NotNull GlanceModifier absolutePadding, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(absolutePadding, "$this$absolutePadding");
        return absolutePadding.then(new PaddingModifier(m21501toPadding0680j_4(f), null, m21501toPadding0680j_4(f4), m21501toPadding0680j_4(f5), null, m21501toPadding0680j_4(f6), 18, null));
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21495absolutePaddingqDBjuR0$default(GlanceModifier glanceModifier, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return m21494absolutePaddingqDBjuR0(glanceModifier, f, f4, f5, f6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final PaddingModifier collectPadding(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return (PaddingModifier) glanceModifier.foldIn(null, new Function2<PaddingModifier, GlanceModifier.Element, PaddingModifier>() { // from class: androidx.glance.layout.PaddingKt.collectPadding.1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final PaddingModifier invoke(@Nullable PaddingModifier paddingModifier, @NotNull GlanceModifier.Element modifier) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                if (!(modifier instanceof PaddingModifier)) {
                    return paddingModifier;
                }
                if (paddingModifier == null) {
                    paddingModifier = new PaddingModifier(null, null, null, null, null, null, 63, null);
                }
                return paddingModifier.plus((PaddingModifier) modifier);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final PaddingInDp collectPaddingInDp(@NotNull GlanceModifier glanceModifier, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        PaddingModifier paddingModifierCollectPadding = collectPadding(glanceModifier);
        if (paddingModifierCollectPadding != null) {
            return paddingModifierCollectPadding.toDp(resources);
        }
        return null;
    }

    @NotNull
    public static final GlanceModifier padding(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2, @DimenRes int i4, @DimenRes int i5) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new PaddingModifier(null, toPadding(i), toPadding(i2), null, toPadding(i4), toPadding(i5), 9, null));
    }

    public static /* synthetic */ GlanceModifier padding$default(GlanceModifier glanceModifier, int i, int i2, int i4, int i5, int i6, Object obj) {
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
        return padding(glanceModifier, i, i2, i4, i5);
    }

    @NotNull
    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final GlanceModifier m21496padding3ABfNKs(@NotNull GlanceModifier padding, float f) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        PaddingDimension paddingDimensionM21501toPadding0680j_4 = m21501toPadding0680j_4(f);
        return padding.then(new PaddingModifier(null, paddingDimensionM21501toPadding0680j_4, paddingDimensionM21501toPadding0680j_4, null, paddingDimensionM21501toPadding0680j_4, paddingDimensionM21501toPadding0680j_4, 9, null));
    }

    @NotNull
    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final GlanceModifier m21497paddingVpY3zN4(@NotNull GlanceModifier padding, float f, float f4) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingModifier(null, m21501toPadding0680j_4(f), m21501toPadding0680j_4(f4), null, m21501toPadding0680j_4(f), m21501toPadding0680j_4(f4), 9, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21498paddingVpY3zN4$default(GlanceModifier glanceModifier, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C2256Dp.m20968constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f4 = C2256Dp.m20968constructorimpl(0);
        }
        return m21497paddingVpY3zN4(glanceModifier, f, f4);
    }

    @NotNull
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final GlanceModifier m21499paddingqDBjuR0(@NotNull GlanceModifier padding, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingModifier(null, m21501toPadding0680j_4(f), m21501toPadding0680j_4(f4), null, m21501toPadding0680j_4(f5), m21501toPadding0680j_4(f6), 9, null));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ GlanceModifier m21500paddingqDBjuR0$default(GlanceModifier glanceModifier, float f, float f4, float f5, float f6, int i, Object obj) {
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
        return m21499paddingqDBjuR0(glanceModifier, f, f4, f5, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toDp(List<Integer> list, Resources resources) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(resources.getDimension(((Number) it.next()).intValue()) / resources.getDisplayMetrics().density) + fM20968constructorimpl);
        }
        return fM20968constructorimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final PaddingDimension toPadding(int i) {
        if (i != 0) {
            return new PaddingDimension(i);
        }
        return new PaddingDimension(0.0f, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toPadding-0680j_4, reason: not valid java name */
    private static final PaddingDimension m21501toPadding0680j_4(float f) {
        return new PaddingDimension(f, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GlanceModifier padding$default(GlanceModifier glanceModifier, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        return padding(glanceModifier, i, i2);
    }

    @NotNull
    public static final GlanceModifier padding(@NotNull GlanceModifier glanceModifier, @DimenRes int i, @DimenRes int i2) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new PaddingModifier(null, toPadding(i), toPadding(i2), null, toPadding(i), toPadding(i2), 9, null));
    }

    @NotNull
    public static final GlanceModifier padding(@NotNull GlanceModifier glanceModifier, @DimenRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        PaddingDimension padding = toPadding(i);
        return glanceModifier.then(new PaddingModifier(null, padding, padding, null, padding, padding, 9, null));
    }
}
