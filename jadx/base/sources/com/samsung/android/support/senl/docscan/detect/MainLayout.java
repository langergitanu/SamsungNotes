package com.samsung.android.support.senl.docscan.detect;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0014J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/MainLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOrientationEventListener", "Lcom/samsung/android/support/senl/docscan/detect/MainLayout$OrientationEventListener;", "mRotation", "setOrientationEventListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshLayoutRotation", "isPortrait", "", "OrientationEventListener", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MainLayout extends FrameLayout {

    @Nullable
    private OrientationEventListener mOrientationEventListener;
    private int mRotation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/MainLayout$OrientationEventListener;", "", "onOrientationChanged", "", "orientation", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OrientationEventListener {
        void onOrientationChanged(int orientation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
    }

    private final boolean isPortrait(int widthMeasureSpec, int heightMeasureSpec) {
        return View.MeasureSpec.getSize(widthMeasureSpec) < View.MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        boolean z2;
        int i;
        if (getDisplay() == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int rotation = getDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation == 2) {
                    this.mRotation = 180;
                    isPortrait(widthMeasureSpec, heightMeasureSpec);
                } else if (rotation == 3) {
                    this.mRotation = 90;
                    isPortrait(widthMeasureSpec, heightMeasureSpec);
                }
                z2 = false;
                z = false;
            } else {
                this.mRotation = -90;
                isPortrait(widthMeasureSpec, heightMeasureSpec);
            }
            z2 = true;
            z = false;
        } else {
            this.mRotation = 0;
            DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
            if (!companion.getInstance().isDexDualModeOnScreen(getContext()) || !companion.getInstance().isDexDualModeConnected(getContext())) {
                isPortrait(widthMeasureSpec, heightMeasureSpec);
                z2 = false;
                z = false;
            } else if (isPortrait(widthMeasureSpec, heightMeasureSpec)) {
                z2 = true;
                z = false;
            } else {
                z = true;
                z2 = false;
            }
        }
        if (z2) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            int i4 = (size - size2) / 2;
            int i5 = (size2 - size) / 2;
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                i4 *= -1;
            }
            heightMeasureSpec = widthMeasureSpec;
            widthMeasureSpec = heightMeasureSpec;
            i = i5;
            i2 = i4;
        } else {
            i = 0;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setTranslationX(i2);
        setTranslationY(i);
        int rotation2 = (int) getRotation();
        int i6 = this.mRotation;
        if (i6 == rotation2 || z) {
            return;
        }
        setRotation(i6);
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            int i7 = this.mRotation;
            if (i7 == -90 || i7 == 90) {
                Intrinsics.checkNotNull(orientationEventListener);
                orientationEventListener.onOrientationChanged(this.mRotation * (-1));
            } else {
                Intrinsics.checkNotNull(orientationEventListener);
                orientationEventListener.onOrientationChanged(this.mRotation);
            }
        }
    }

    public final void refreshLayoutRotation() {
        if (this.mRotation != ((int) getRotation())) {
            requestLayout();
        }
    }

    public final void setOrientationEventListener(@Nullable OrientationEventListener listener) {
        this.mOrientationEventListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
    }
}
