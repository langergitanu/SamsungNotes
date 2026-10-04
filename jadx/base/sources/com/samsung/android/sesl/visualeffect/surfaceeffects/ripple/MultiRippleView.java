package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maskPath", "Landroid/graphics/Path;", "getMaskPath", "()Landroid/graphics/Path;", "setMaskPath", "(Landroid/graphics/Path;)V", "ripples", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "Lkotlin/collections/ArrayList;", "getRipples$annotations", "()V", "getRipples", "()Ljava/util/ArrayList;", "ripplePaint", "Landroid/graphics/Paint;", "runningAnimationCount", "", "animationCountChangeListener", "Ljava/util/function/Consumer;", "getAnimationCountChangeListener", "()Ljava/util/function/Consumer;", "setAnimationCountChangeListener", "(Ljava/util/function/Consumer;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiRippleView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiRippleView.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1863#2,2:72\n*S KotlinDebug\n*F\n+ 1 MultiRippleView.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView\n*L\n58#1:72,2\n*E\n"})
public final class MultiRippleView extends View {

    @Nullable
    private Consumer<Integer> animationCountChangeListener;

    @Nullable
    private Path maskPath;

    @NotNull
    private final Paint ripplePaint;

    @NotNull
    private final ArrayList<RippleAnimation> ripples;
    private int runningAnimationCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRippleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.ripples = new ArrayList<>();
        this.ripplePaint = new Paint();
    }

    @VisibleForTesting(otherwise = 3)
    public static /* synthetic */ void getRipples$annotations() {
    }

    @Nullable
    public final Consumer<Integer> getAnimationCountChangeListener() {
        return this.animationCountChangeListener;
    }

    @Nullable
    public final Path getMaskPath() {
        return this.maskPath;
    }

    @NotNull
    public final ArrayList<RippleAnimation> getRipples() {
        return this.ripples;
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void onDraw(@NotNull Canvas canvas) {
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvas.isHardwareAccelerated()) {
            if (this.runningAnimationCount != this.ripples.size()) {
                int size = this.ripples.size();
                this.runningAnimationCount = size;
                Consumer<Integer> consumer = this.animationCountChangeListener;
                if (consumer != null) {
                    consumer.accept(Integer.valueOf(size));
                }
            }
            loop0: while (true) {
                for (RippleAnimation rippleAnimation : this.ripples) {
                    this.ripplePaint.setShader(rippleAnimation.getRippleShader());
                    Path path = this.maskPath;
                    if (path != null) {
                        canvas.clipPath(path);
                    }
                    canvas.drawPaint(this.ripplePaint);
                    z = z || rippleAnimation.isPlaying();
                }
            }
            if (z) {
                invalidate();
            }
        }
    }

    public final void setAnimationCountChangeListener(@Nullable Consumer<Integer> consumer) {
        this.animationCountChangeListener = consumer;
    }

    public final void setMaskPath(@Nullable Path path) {
        this.maskPath = path;
    }
}
