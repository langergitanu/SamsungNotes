package com.samsung.android.sdk.pen.recoguifeature.math;

import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenGraphInfo;", "", "<init>", "()V", "_isVisible", "", "_color", "", "_bitmap", "Landroid/graphics/Bitmap;", "(ZILandroid/graphics/Bitmap;)V", "visibility", "getVisibility", "()Z", "setVisibility", "(Z)V", "color", "getColor", "()I", "setColor", "(I)V", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenGraphInfo {

    @NotNull
    private static final String TAG = "SpenGraphInfo";

    @Nullable
    private Bitmap bitmap;
    private int color;
    private boolean visibility;

    public SpenGraphInfo() {
        Log.d(TAG, "SpenGraphInfo::SpenGraphInfo()");
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getVisibility() {
        return this.visibility;
    }

    public final void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setVisibility(boolean z) {
        this.visibility = z;
    }

    public SpenGraphInfo(boolean z, int i, @Nullable Bitmap bitmap) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{String.valueOf(z), Integer.valueOf(i), bitmap == null ? "null" : "bitmap"}, 3, "SpenGraphInfo::SpenGraphInfo() isVisible[%s], color[%x], bitmap[%s]", "format(format, *args)", TAG);
        this.visibility = z;
        this.color = i;
        this.bitmap = bitmap;
    }
}
