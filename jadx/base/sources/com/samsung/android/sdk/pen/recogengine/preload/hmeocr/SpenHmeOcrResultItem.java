package com.samsung.android.sdk.pen.recogengine.preload.hmeocr;

import android.graphics.Point;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResultItem;", "", "latexValue", "", "scoreValue", "", "<init>", "(Ljava/lang/String;F)V", "getLatexValue", "()Ljava/lang/String;", "setLatexValue", "(Ljava/lang/String;)V", "getScoreValue", "()F", "setScoreValue", "(F)V", "mRect", "", "Landroid/graphics/Point;", "[Landroid/graphics/Point;", WiggleAnimationConfig.KEY_SCALE, "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHmeOcrResultItem {

    @NotNull
    private String latexValue;

    @NotNull
    private final Point[] mRect;
    private float scoreValue;

    public SpenHmeOcrResultItem(@NotNull String latexValue, float f) {
        Intrinsics.checkNotNullParameter(latexValue, "latexValue");
        this.latexValue = latexValue;
        this.scoreValue = f;
        this.mRect = new Point[]{new Point()};
    }

    @NotNull
    public final String getLatexValue() {
        return this.latexValue;
    }

    public final float getScoreValue() {
        return this.scoreValue;
    }

    public final boolean scale(float scale) {
        for (Point point : this.mRect) {
            point.x = (int) (point.x * scale);
            point.y = (int) (point.y * scale);
        }
        return true;
    }

    public final void setLatexValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latexValue = str;
    }

    public final void setScoreValue(float f) {
        this.scoreValue = f;
    }
}
