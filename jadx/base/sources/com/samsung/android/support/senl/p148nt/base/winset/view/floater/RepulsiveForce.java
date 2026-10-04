package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.parser.AbstractBottomUpParser;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J&\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ&\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce;", "", "<init>", "()V", "mDebugPaint", "Landroid/graphics/Paint;", "mDebugVerticalInfo", "", "mDebugHorizontalInfo", "isIntersect", "", "dir", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "source", "Landroid/graphics/Rect;", "target", "getDestination", "Landroid/graphics/Point;", "container", "updateVerticalBorderCalibration", "", "getVerticalDestination", "", "getHorizontalDestination", "debugDrawDestinationLine", "canvas", "Landroid/graphics/Canvas;", "debugDrawDestinationRect", "debugInfo", "debugIntersectRegion", "debugDrawFloaterOutBounds", "sourceRect", "targetRect", "BorderRegion", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RepulsiveForce {
    private static final int DEBUG_ALPHA_MAX = 255;
    private static final float DEFAULT_HORIZONTAL_MIDDLE_RATIO = 0.5f;
    private static final float DEFAULT_VERTICAL_LEFT_RATIO = 0.15f;
    private static final float DEFAULT_VERTICAL_RIGHT_RATIO = 0.85f;
    private static final boolean PRIORITY_VERTICAL_CONCEPT = false;

    @NotNull
    private final Paint mDebugPaint = new Paint();

    @NotNull
    private String mDebugVerticalInfo = "";

    @NotNull
    private String mDebugHorizontalInfo = "";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "", "left", "", "top", "right", "bottom", "<init>", "(Ljava/lang/String;IFFFF)V", "LEFT", "RIGHT", AbstractBottomUpParser.TOP_NODE, "BOTTOM", "ALL", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "setMinLeft", "", "setMaxRight", "getRegion", "rect", "isIntersect", "", "getIntersect", "sourceRect", "targetRect", "getIntersectSize", "getIntersectRatio", "getScaledRegion", WiggleAnimationConfig.KEY_SCALE, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BorderRegion {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BorderRegion[] $VALUES;
        private final float bottom;
        private float left;
        private float right;
        private final float top;
        public static final BorderRegion LEFT = new LEFT("LEFT", 0);
        public static final BorderRegion RIGHT = new RIGHT("RIGHT", 1);
        public static final BorderRegion TOP = new TOP(AbstractBottomUpParser.TOP_NODE, 2);
        public static final BorderRegion BOTTOM = new BOTTOM("BOTTOM", 3);
        public static final BorderRegion ALL = new ALL("ALL", 4);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce.BorderRegion.ALL", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ALL extends BorderRegion {
            public ALL(String str, int i) {
                super(str, i, 0.0f, 0.0f, 1.0f, 1.0f, null);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.RepulsiveForce.BorderRegion
            public int getDifference(@NotNull Rect source, @NotNull Rect target) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(target, "target");
                return (int) (Math.max(0.0d, source.bottom - target.bottom) + Math.max(0.0d, source.right - target.right) + Math.max(0.0d, target.left - source.left) + Math.max(0.0d, target.top - source.top));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce.BorderRegion.BOTTOM", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class BOTTOM extends BorderRegion {
            public BOTTOM(String str, int i) {
                super(str, i, 0.15f, 0.5f, RepulsiveForce.DEFAULT_VERTICAL_RIGHT_RATIO, 1.0f, null);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.RepulsiveForce.BorderRegion
            public int getDifference(@NotNull Rect source, @NotNull Rect target) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(target, "target");
                return (int) (Math.max(0.0d, target.bottom - source.bottom) + Math.max(0.0d, target.top - source.top));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce.BorderRegion.LEFT", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class LEFT extends BorderRegion {
            public LEFT(String str, int i) {
                super(str, i, 0.0f, 0.0f, 0.15f, 1.0f, null);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.RepulsiveForce.BorderRegion
            public int getDifference(@NotNull Rect source, @NotNull Rect target) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(target, "target");
                return (int) (Math.max(0.0d, source.left - target.left) + Math.max(0.0d, source.right - target.right));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce.BorderRegion.RIGHT", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class RIGHT extends BorderRegion {
            public RIGHT(String str, int i) {
                super(str, i, RepulsiveForce.DEFAULT_VERTICAL_RIGHT_RATIO, 0.0f, 1.0f, 1.0f, null);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.RepulsiveForce.BorderRegion
            public int getDifference(@NotNull Rect source, @NotNull Rect target) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(target, "target");
                return (int) (Math.max(0.0d, target.right - source.right) + Math.max(0.0d, target.left - source.left));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce.BorderRegion.TOP", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/RepulsiveForce$BorderRegion;", "getDifference", "", "source", "Landroid/graphics/Rect;", "target", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class TOP extends BorderRegion {
            public TOP(String str, int i) {
                super(str, i, 0.15f, 0.0f, RepulsiveForce.DEFAULT_VERTICAL_RIGHT_RATIO, 0.5f, null);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.RepulsiveForce.BorderRegion
            public int getDifference(@NotNull Rect source, @NotNull Rect target) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(target, "target");
                return (int) (Math.max(0.0d, source.top - target.top) + Math.max(0.0d, source.bottom - target.bottom));
            }
        }

        private static final /* synthetic */ BorderRegion[] $values() {
            return new BorderRegion[]{LEFT, RIGHT, TOP, BOTTOM, ALL};
        }

        static {
            BorderRegion[] borderRegionArr$values = $values();
            $VALUES = borderRegionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(borderRegionArr$values);
        }

        public /* synthetic */ BorderRegion(String str, int i, float f, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, f, f4, f5, f6);
        }

        @NotNull
        public static EnumEntries<BorderRegion> getEntries() {
            return $ENTRIES;
        }

        private final float getIntersectSize(Rect sourceRect, Rect targetRect) {
            Rect intersect = getIntersect(sourceRect, targetRect);
            return intersect.height() * intersect.width();
        }

        public static BorderRegion valueOf(String str) {
            return (BorderRegion) Enum.valueOf(BorderRegion.class, str);
        }

        public static BorderRegion[] values() {
            return (BorderRegion[]) $VALUES.clone();
        }

        public abstract int getDifference(@NotNull Rect source, @NotNull Rect target);

        @NotNull
        public final Rect getIntersect(@NotNull Rect sourceRect, @NotNull Rect targetRect) {
            Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            Rect region = getRegion(targetRect);
            return new Rect((int) Math.max(sourceRect.left, region.left), (int) Math.max(sourceRect.top, region.top), (int) Math.min(sourceRect.right, region.right), (int) Math.min(sourceRect.bottom, region.bottom));
        }

        public final float getIntersectRatio(@NotNull Rect sourceRect, @NotNull Rect targetRect) {
            Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            return getIntersectSize(sourceRect, targetRect) / (sourceRect.height() * sourceRect.width());
        }

        @NotNull
        public final Rect getRegion(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return new Rect((int) ((rect.width() * this.left) + rect.left), (int) ((rect.height() * this.top) + rect.top), (int) ((rect.width() * this.right) + rect.left), (int) ((rect.height() * this.bottom) + rect.top));
        }

        @NotNull
        public final Rect getScaledRegion(@NotNull Rect rect, float scale) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Rect region = getRegion(rect);
            int iWidth = (int) (region.width() * scale);
            int iHeight = (int) (region.height() * scale);
            region.left -= iWidth;
            region.right += iWidth;
            region.top -= iHeight;
            region.bottom += iHeight;
            return region;
        }

        public final boolean isIntersect(@NotNull Rect source, @NotNull Rect target) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(target, "target");
            if (source.isEmpty() || target.isEmpty()) {
                return false;
            }
            return getRegion(target).intersect(source);
        }

        public final void setMaxRight(float right) {
            this.right = (float) Math.max(right, 0.8500000238418579d);
        }

        public final void setMinLeft(float left) {
            this.left = (float) Math.min(left, 0.15000000596046448d);
        }

        private BorderRegion(String str, int i, float f, float f4, float f5, float f6) {
            this.left = f;
            this.top = f4;
            this.right = f5;
            this.bottom = f6;
        }
    }

    private final Point getDestination(Rect source, Rect target, Rect container) {
        updateVerticalBorderCalibration(target, container);
        return new Point(getHorizontalDestination(source, target, container), getVerticalDestination(source, target, container));
    }

    private final int getHorizontalDestination(Rect source, Rect target, Rect container) {
        if (container.width() <= target.width() || target.left <= container.left || target.right >= container.right) {
            return 0;
        }
        if (BorderRegion.LEFT.isIntersect(source, target) == BorderRegion.RIGHT.isIntersect(source, target)) {
            return 0;
        }
        int iMax = (int) Math.max(0.0d, r0.getIntersect(source, target).width());
        int iMax2 = (int) Math.max(0.0d, r3.getIntersect(source, target).width());
        String strM1214o = AbstractC1038a.m1214o(iMax, iMax2, "Horizontal / left ", "  right ");
        this.mDebugHorizontalInfo = strM1214o;
        if (iMax <= iMax2) {
            int i = -(iMax + iMax2);
            this.mDebugHorizontalInfo = AbstractC2821a.m2218i(i, strM1214o, " / LEFT ");
            return i + ((int) Math.max(0.0d, container.left - (target.left + i)));
        }
        this.mDebugHorizontalInfo = strM1214o + " / RIGHT " + iMax + iMax2;
        return (iMax + iMax2) - ((int) Math.max(0.0d, (target.right + r0) - container.right));
    }

    private final int getVerticalDestination(Rect source, Rect target, Rect container) {
        if (container.height() <= target.height()) {
            return 0;
        }
        BorderRegion borderRegion = BorderRegion.TOP;
        if (!borderRegion.isIntersect(source, target) && !BorderRegion.BOTTOM.isIntersect(source, target)) {
            return 0;
        }
        int iMax = (int) Math.max(0.0d, borderRegion.getIntersect(source, target).height());
        BorderRegion borderRegion2 = BorderRegion.BOTTOM;
        int iMax2 = (int) Math.max(0.0d, borderRegion2.getIntersect(source, target).height());
        int difference = borderRegion.getDifference(source, target);
        int difference2 = borderRegion2.getDifference(source, target);
        this.mDebugVerticalInfo = AbstractC1038a.m1214o(iMax, iMax2, "Vertical / top ", "  bottom ");
        int i = iMax + iMax2;
        int i2 = -(i + difference2);
        int i4 = i + difference;
        int iMax3 = (int) Math.max(0.0d, container.top - (target.top + i2));
        int iMax4 = (int) Math.max(0.0d, (target.bottom + i4) - container.bottom);
        String str = this.mDebugVerticalInfo + " (topOutDelta " + iMax3 + ", bottomOutDelta " + iMax4 + ")";
        this.mDebugVerticalInfo = str;
        if (iMax / (difference + 1) <= iMax2 / (difference2 + 1)) {
            this.mDebugVerticalInfo = AbstractC2821a.m2218i(-i, str, " / UP ");
            return (iMax3 == 0 || iMax4 != 0) ? i2 + iMax3 : i4;
        }
        this.mDebugVerticalInfo = str + " / DOWN " + iMax + iMax2;
        return (iMax3 != 0 || iMax4 == 0) ? i4 - iMax4 : i2;
    }

    private final void updateVerticalBorderCalibration(Rect target, Rect container) {
        float fMax = ((float) Math.max(0.0d, container.right - target.right)) / target.width();
        BorderRegion borderRegion = BorderRegion.TOP;
        borderRegion.setMinLeft(fMax);
        BorderRegion borderRegion2 = BorderRegion.BOTTOM;
        borderRegion2.setMinLeft(fMax);
        float fWidth = 1.0f - ((target.left - container.left) / target.width());
        borderRegion.setMaxRight(fWidth);
        borderRegion2.setMaxRight(fWidth);
    }

    public final void debugDrawDestinationLine(@NotNull Canvas canvas, @NotNull Rect source, @NotNull Rect target, @NotNull Rect container) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(container, "container");
        Point destination = getDestination(source, target, container);
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        this.mDebugPaint.setStrokeWidth(5.0f);
        this.mDebugPaint.setColor(-65536);
        canvas.drawLine(target.centerX(), target.centerY(), target.centerX() + destination.x, target.centerY() + destination.y, this.mDebugPaint);
        this.mDebugPaint.setStyle(Paint.Style.FILL);
        this.mDebugPaint.setStrokeWidth(1.0f);
    }

    public final void debugDrawDestinationRect(@NotNull Canvas canvas, @NotNull Rect source, @NotNull Rect target, @NotNull Rect container) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(container, "container");
        Point destination = getDestination(source, target, container);
        this.mDebugPaint.setColor(-65536);
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        float f = target.left + destination.x;
        int i = target.top;
        int i2 = destination.y;
        canvas.drawRect(f, i + i2, target.right + r3, target.bottom + i2, this.mDebugPaint);
        float f4 = target.left + destination.x;
        int i4 = target.top;
        int i5 = destination.y;
        canvas.drawLine(f4, i4 + i5, target.right + r3, target.bottom + i5, this.mDebugPaint);
        float f5 = target.right + destination.x;
        int i6 = target.top;
        int i7 = destination.y;
        canvas.drawLine(f5, i6 + i7, target.left + r3, target.bottom + i7, this.mDebugPaint);
        int i8 = target.left;
        canvas.drawLine(destination.x + i8, destination.y + r3, i8, target.top, this.mDebugPaint);
        int i9 = target.right;
        canvas.drawLine(destination.x + i9, destination.y + r3, i9, target.top, this.mDebugPaint);
        int i10 = target.left;
        canvas.drawLine(destination.x + i10, destination.y + r3, i10, target.bottom, this.mDebugPaint);
        int i11 = target.right;
        canvas.drawLine(destination.x + i11, destination.y + r1, i11, target.bottom, this.mDebugPaint);
    }

    public final void debugDrawFloaterOutBounds(@NotNull Canvas canvas, @NotNull Rect sourceRect, @NotNull Rect targetRect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(sourceRect, "sourceRect");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        if (BorderRegion.ALL.isIntersect(sourceRect, targetRect)) {
            this.mDebugPaint.setColor(-16776961);
        } else {
            this.mDebugPaint.setColor(VUtilString.GREEN);
        }
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(targetRect, this.mDebugPaint);
    }

    public final void debugInfo(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mDebugPaint.setColor(VUtilString.MAGENTA);
        this.mDebugPaint.setTextSize(30.0f);
        this.mDebugPaint.setStyle(Paint.Style.FILL);
        this.mDebugPaint.setStrokeWidth(1.0f);
        canvas.drawText(this.mDebugVerticalInfo, 10.0f, 30.0f, this.mDebugPaint);
        canvas.drawText(this.mDebugHorizontalInfo, 10.0f, 70.0f, this.mDebugPaint);
    }

    public final void debugIntersectRegion(@NotNull Canvas canvas, @NotNull Rect source, @NotNull Rect target) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mDebugPaint.setColor(VUtilString.CYAN);
        this.mDebugPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        BorderRegion borderRegion = BorderRegion.LEFT;
        if (borderRegion.isIntersect(source, target)) {
            float intersectRatio = borderRegion.getIntersectRatio(source, target);
            this.mDebugPaint.setAlpha((int) (255 * intersectRatio));
            canvas.drawRect(borderRegion.getScaledRegion(target, intersectRatio), this.mDebugPaint);
            canvas.drawRect(borderRegion.getRegion(target), this.mDebugPaint);
        }
        BorderRegion borderRegion2 = BorderRegion.RIGHT;
        if (borderRegion2.isIntersect(source, target)) {
            float intersectRatio2 = borderRegion2.getIntersectRatio(source, target);
            this.mDebugPaint.setAlpha((int) (255 * intersectRatio2));
            canvas.drawRect(borderRegion2.getScaledRegion(target, intersectRatio2), this.mDebugPaint);
            canvas.drawRect(borderRegion2.getRegion(target), this.mDebugPaint);
        }
        BorderRegion borderRegion3 = BorderRegion.TOP;
        if (borderRegion3.isIntersect(source, target)) {
            float intersectRatio3 = borderRegion3.getIntersectRatio(source, target);
            this.mDebugPaint.setAlpha((int) (255 * intersectRatio3));
            canvas.drawRect(borderRegion3.getScaledRegion(target, intersectRatio3), this.mDebugPaint);
            canvas.drawRect(borderRegion3.getRegion(target), this.mDebugPaint);
        }
        BorderRegion borderRegion4 = BorderRegion.BOTTOM;
        if (borderRegion4.isIntersect(source, target)) {
            float intersectRatio4 = borderRegion4.getIntersectRatio(source, target);
            this.mDebugPaint.setAlpha((int) (255 * intersectRatio4));
            canvas.drawRect(borderRegion4.getScaledRegion(target, intersectRatio4), this.mDebugPaint);
            canvas.drawRect(borderRegion4.getRegion(target), this.mDebugPaint);
        }
    }

    public final boolean isIntersect(@NotNull BorderRegion dir, @NotNull Rect source, @NotNull Rect target) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        return dir.isIntersect(source, target);
    }
}
