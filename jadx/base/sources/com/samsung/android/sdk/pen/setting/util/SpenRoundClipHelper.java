package com.samsung.android.sdk.pen.setting.util;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u001a\u001a\u00020\nH\u0002R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "", "<init>", "()V", "mRadii", "", "mHasRoundCorner", "", "hasRoundCorner", "setCorner", "", "radius", "", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "applyRoundClip", "canvas", "Landroid/graphics/Canvas;", "radii", "cornerRadii", "getCornerRadii", "()[F", "setCornerRadii", "([F)V", "updateRoundCorner", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRoundClipHelper {

    @NotNull
    private static final String TAG = "SpenRoundClipHelper";

    @JvmField
    public boolean mHasRoundCorner;

    @JvmField
    @NotNull
    public float[] mRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    private final void updateRoundCorner() {
        this.mHasRoundCorner = Collections.frequency(CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(this.mRadii[0]), Float.valueOf(this.mRadii[1]), Float.valueOf(this.mRadii[2]), Float.valueOf(this.mRadii[3]), Float.valueOf(this.mRadii[4]), Float.valueOf(this.mRadii[5]), Float.valueOf(this.mRadii[6]), Float.valueOf(this.mRadii[7])}), 0) < this.mRadii.length;
    }

    public final void applyRoundClip(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mHasRoundCorner) {
            Path path = new Path();
            path.addRoundRect(new RectF(canvas.getClipBounds()), this.mRadii, Path.Direction.CW);
            canvas.clipPath(path);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getCornerRadii, reason: from getter */
    public final float[] getMRadii() {
        return this.mRadii;
    }

    /* JADX INFO: renamed from: hasRoundCorner, reason: from getter */
    public final boolean getMHasRoundCorner() {
        return this.mHasRoundCorner;
    }

    public final void setCorner(float leftTopRadius, float rightTopRadius, float rightBottomRadius, float leftBottomRadius) {
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC0622a.m1176v("setCorner() [", leftTopRadius, SQLKeyword.COMMA, rightTopRadius, SQLKeyword.COMMA), rightBottomRadius, SQLKeyword.COMMA, leftBottomRadius, "]"));
        float[] fArr = this.mRadii;
        fArr[0] = leftTopRadius;
        fArr[1] = leftTopRadius;
        fArr[2] = rightTopRadius;
        fArr[3] = rightTopRadius;
        fArr[4] = rightBottomRadius;
        fArr[5] = rightBottomRadius;
        fArr[6] = leftBottomRadius;
        fArr[7] = leftBottomRadius;
        updateRoundCorner();
    }

    public final void setCornerRadii(@NotNull float[] radii) {
        Intrinsics.checkNotNullParameter(radii, "radii");
        int length = radii.length;
        float[] fArr = this.mRadii;
        if (length != fArr.length || Arrays.equals(radii, fArr)) {
            return;
        }
        float[] fArr2 = this.mRadii;
        System.arraycopy(radii, 0, fArr2, 0, fArr2.length);
        updateRoundCorner();
    }

    public final void setCorner(float radius) {
        setCorner(radius, radius, radius, radius);
    }
}
