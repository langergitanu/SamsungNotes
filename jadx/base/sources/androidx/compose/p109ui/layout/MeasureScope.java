package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LookaheadCapablePlaceable;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@MeasureScopeMarker
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMeasureScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeasureScope.kt\nandroidx/compose/ui/layout/MeasureScope\n+ 2 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadDelegateKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,134:1\n341#2:135\n342#2:141\n345#2:143\n42#3,5:136\n48#3:142\n*S KotlinDebug\n*F\n+ 1 MeasureScope.kt\nandroidx/compose/ui/layout/MeasureScope\n*L\n79#1:135\n79#1:141\n79#1:143\n79#1:136,5\n79#1:142\n*E\n"})
public interface MeasureScope extends IntrinsicMeasureScope {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isLookingAhead(@NotNull MeasureScope measureScope) {
            return MeasureScope.super.isLookingAhead();
        }

        @Deprecated
        @NotNull
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
            return MeasureScope.super.layout(i, i2, map, function1);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m19897roundToPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return MeasureScope.super.mo15539roundToPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m19898roundToPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return MeasureScope.super.mo15540roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m19899toDpGaN1DYA(@NotNull MeasureScope measureScope, long j) {
            return MeasureScope.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19900toDpu2uoSUM(@NotNull MeasureScope measureScope, float f) {
            return MeasureScope.super.mo15542toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m19902toDpSizekrfVVM(@NotNull MeasureScope measureScope, long j) {
            return MeasureScope.super.mo15544toDpSizekrfVVM(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m19903toPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return MeasureScope.super.mo15545toPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m19904toPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return MeasureScope.super.mo15546toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull MeasureScope measureScope, @NotNull DpRect dpRect) {
            return MeasureScope.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m19905toSizeXkaWNTQ(@NotNull MeasureScope measureScope, long j) {
            return MeasureScope.super.mo15547toSizeXkaWNTQ(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m19906toSp0xMU5do(@NotNull MeasureScope measureScope, float f) {
            return MeasureScope.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19907toSpkPz2Gy4(@NotNull MeasureScope measureScope, float f) {
            return MeasureScope.super.mo15549toSpkPz2Gy4(f);
        }

        @Deprecated
        @NotNull
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @Nullable Function1<? super RulerScope, Unit> function1, @NotNull Function1<? super Placeable.PlacementScope, Unit> function12) {
            return MeasureScope.super.layout(i, i2, map, function1, function12);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19901toDpu2uoSUM(@NotNull MeasureScope measureScope, int i) {
            return MeasureScope.super.mo15543toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19908toSpkPz2Gy4(@NotNull MeasureScope measureScope, int i) {
            return MeasureScope.super.mo15550toSpkPz2Gy4(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i4 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return measureScope.layout(i, i2, map, function1);
    }

    @NotNull
    default MeasureResult layout(int width, int height, @NotNull Map<AlignmentLine, Integer> alignmentLines, @NotNull Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return layout(width, height, alignmentLines, null, placementBlock);
    }

    @NotNull
    default MeasureResult layout(int width, int height, @NotNull Map<AlignmentLine, Integer> alignmentLines, @Nullable Function1<? super RulerScope, Unit> rulers, @NotNull Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(width, height, alignmentLines, rulers, this, placementBlock) { // from class: androidx.compose.ui.layout.MeasureScope.layout.1
            final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
            final /* synthetic */ int $width;

            @NotNull
            private final Map<AlignmentLine, Integer> alignmentLines;
            private final int height;

            @Nullable
            private final Function1<RulerScope, Unit> rulers;
            final /* synthetic */ MeasureScope this$0;
            private final int width;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$width = width;
                this.this$0 = this;
                this.$placementBlock = placementBlock;
                this.width = width;
                this.height = height;
                this.alignmentLines = alignmentLines;
                this.rulers = rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @Nullable
            public Function1<RulerScope, Unit> getRulers() {
                return this.rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public void placeChildren() {
                MeasureScope measureScope = this.this$0;
                if (measureScope instanceof LookaheadCapablePlaceable) {
                    this.$placementBlock.invoke(((LookaheadCapablePlaceable) measureScope).getPlacementScope());
                } else {
                    this.$placementBlock.invoke(new SimplePlacementScope(this.$width, this.this$0.getLayoutDirection()));
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, Function1 function12, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i4 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i4 & 8) != 0) {
            function1 = null;
        }
        return measureScope.layout(i, i2, map2, function1, function12);
    }
}
