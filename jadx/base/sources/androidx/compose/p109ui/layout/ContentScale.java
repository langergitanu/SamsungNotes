package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Size;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/layout/ContentScale;", "", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "Companion", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ContentScale {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/layout/ContentScale$Companion;", "", "()V", "Crop", "Landroidx/compose/ui/layout/ContentScale;", "getCrop$annotations", "getCrop", "()Landroidx/compose/ui/layout/ContentScale;", "FillBounds", "getFillBounds$annotations", "getFillBounds", "FillHeight", "getFillHeight$annotations", "getFillHeight", "FillWidth", "getFillWidth$annotations", "getFillWidth", "Fit", "getFit$annotations", "getFit", "Inside", "getInside$annotations", "getInside", "None", "Landroidx/compose/ui/layout/FixedScale;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/layout/FixedScale;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                float fM19852computeFillMaxDimensioniLBOSCw = ContentScaleKt.m19852computeFillMaxDimensioniLBOSCw(srcSize, dstSize);
                return ScaleFactorKt.ScaleFactor(fM19852computeFillMaxDimensioniLBOSCw, fM19852computeFillMaxDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                float fM19853computeFillMinDimensioniLBOSCw = ContentScaleKt.m19853computeFillMinDimensioniLBOSCw(srcSize, dstSize);
                return ScaleFactorKt.ScaleFactor(fM19853computeFillMinDimensioniLBOSCw, fM19853computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                float fM19851computeFillHeightiLBOSCw = ContentScaleKt.m19851computeFillHeightiLBOSCw(srcSize, dstSize);
                return ScaleFactorKt.ScaleFactor(fM19851computeFillHeightiLBOSCw, fM19851computeFillHeightiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                float fM19854computeFillWidthiLBOSCw = ContentScaleKt.m19854computeFillWidthiLBOSCw(srcSize, dstSize);
                return ScaleFactorKt.ScaleFactor(fM19854computeFillWidthiLBOSCw, fM19854computeFillWidthiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                if (Size.m18353getWidthimpl(srcSize) <= Size.m18353getWidthimpl(dstSize) && Size.m18350getHeightimpl(srcSize) <= Size.m18350getHeightimpl(dstSize)) {
                    return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                }
                float fM19853computeFillMinDimensioniLBOSCw = ContentScaleKt.m19853computeFillMinDimensioniLBOSCw(srcSize, dstSize);
                return ScaleFactorKt.ScaleFactor(fM19853computeFillMinDimensioniLBOSCw, fM19853computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final FixedScale None = new FixedScale(1.0f);

        @NotNull
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.p109ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo19846computeScaleFactorH7hwNQA(long srcSize, long dstSize) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m19854computeFillWidthiLBOSCw(srcSize, dstSize), ContentScaleKt.m19851computeFillHeightiLBOSCw(srcSize, dstSize));
            }
        };

        private Companion() {
        }

        @NotNull
        public final ContentScale getCrop() {
            return Crop;
        }

        @NotNull
        public final ContentScale getFillBounds() {
            return FillBounds;
        }

        @NotNull
        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        @NotNull
        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        @NotNull
        public final ContentScale getFit() {
            return Fit;
        }

        @NotNull
        public final ContentScale getInside() {
            return Inside;
        }

        @NotNull
        public final FixedScale getNone() {
            return None;
        }

        @Stable
        public static /* synthetic */ void getCrop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillBounds$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillHeight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillWidth$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFit$annotations() {
        }

        @Stable
        public static /* synthetic */ void getInside$annotations() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }
    }
}
