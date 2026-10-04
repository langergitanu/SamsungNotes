package com.samsung.android.sdk.composer.view.floatingview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/floatingview/SpenFloatingImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "nativeHolder", "", "<init>", "(Landroid/content/Context;J)V", "mListener", "Lcom/samsung/android/sdk/composer/view/floatingview/SpenImageFloatingViewListener;", "mNativeHolder", "getMNativeHolder", "()J", "setMNativeHolder", "(J)V", "close", "", "setVisibility", "visibility", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setListener", "l", "setHolder", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFloatingImageView extends AppCompatImageView {

    @NotNull
    private static final String TAG = "SpenFloatingImageView";

    @Nullable
    private SpenImageFloatingViewListener mListener;
    private long mNativeHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFloatingImageView(@NotNull Context context, long j) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNativeHolder = j;
    }

    public final void close() {
        Log.d(TAG, "close()");
        this.mListener = null;
        this.mNativeHolder = 0L;
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        Drawable drawable = getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        setImageBitmap(null);
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public final long getMNativeHolder() {
        return this.mNativeHolder;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mListener == null || this.mNativeHolder == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        SpenImageFloatingViewListener spenImageFloatingViewListener = this.mListener;
        Intrinsics.checkNotNull(spenImageFloatingViewListener);
        boolean zIsInScreen = spenImageFloatingViewListener.isInScreen(this.mNativeHolder, ((RelativeLayout.LayoutParams) layoutParams).topMargin);
        StringBuilder sbM2226q = AbstractC2821a.m2226q("onDraw :", getVisibility(), SQLKeyword.COMMA, zIsInScreen, ",");
        sbM2226q.append(this);
        Log.d(TAG, sbM2226q.toString());
        if (zIsInScreen) {
            super.onDraw(canvas);
        } else {
            setVisibility(8);
        }
    }

    public final void setHolder(long nativeHolder) {
        this.mNativeHolder = nativeHolder;
    }

    public final void setListener(@Nullable SpenImageFloatingViewListener l) {
        this.mListener = l;
    }

    public final void setMNativeHolder(long j) {
        this.mNativeHolder = j;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int visibility) {
        Log.d(TAG, "setVisibility :" + visibility + SQLKeyword.COMMA + this);
        if (visibility == 8) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(MarketingConstants.PopupConst.DEFAULT_COLOR_BACKGROUND);
        }
        super.setVisibility(visibility);
    }
}
