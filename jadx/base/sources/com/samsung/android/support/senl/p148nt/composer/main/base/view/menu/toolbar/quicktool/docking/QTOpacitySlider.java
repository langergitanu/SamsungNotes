package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTOpacitySlider;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/handwriting/PenOpacityLayoutInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColor", "", "mDataChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/handwriting/PenOpacityLayoutInterface$OnDataChangedListener;", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTOpacitySlider$OnAnimationListener;", "close", "", "setColor", "color", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener", "startAnimation", "isShow", "", "updateColor", "setCurrentAlpha", "alpha", "Companion", "OnAnimationListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTOpacitySlider extends CurvedSlider implements PenOpacityLayoutInterface {

    @NotNull
    private static final String TAG = "QTOpacitySlider";

    @Nullable
    private OnAnimationListener mAnimationListener;
    private int mColor;

    @Nullable
    private PenOpacityLayoutInterface.OnDataChangedListener mDataChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTOpacitySlider$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTOpacitySlider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setSupportCheckBg(true);
        setOnChangedListener(new CurvedSlider.OnChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTOpacitySlider.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser, boolean notify) {
                StringBuilder sbM2226q = AbstractC2821a.m2226q("onChanged() value=", value, " fromUser=", fromUser, " notify=");
                sbM2226q.append(notify);
                Logger.m11003i(QTOpacitySlider.TAG, sbM2226q.toString());
                int percentToAlpha = SpenSettingUtilOpacity.getPercentToAlpha(value);
                QTOpacitySlider qTOpacitySlider = QTOpacitySlider.this;
                qTOpacitySlider.updateColor(qTOpacitySlider.setCurrentAlpha(qTOpacitySlider.mColor, percentToAlpha));
                PenOpacityLayoutInterface.OnDataChangedListener onDataChangedListener = QTOpacitySlider.this.mDataChangedListener;
                if (onDataChangedListener != null) {
                    onDataChangedListener.onAlphaChanged(percentToAlpha, notify);
                }
            }
        });
        setOnAnimationListener(new CurvedSlider.OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTOpacitySlider.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                OnAnimationListener onAnimationListener = QTOpacitySlider.this.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd(isShowAnimation);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int setCurrentAlpha(int color, int alpha) {
        return (color & 16777215) | ((alpha << 24) & (-16777216));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColor(int color) {
        setProgressColor(new int[]{16777215 & color, (-16777216) | color});
        this.mColor = color;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface
    public void close() {
        super.close();
        this.mDataChangedListener = null;
        this.mAnimationListener = null;
    }

    public final void setAnimationListener(@NotNull OnAnimationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mAnimationListener = listener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface
    public void setColor(int color) {
        int alphaToPercent = SpenSettingUtilOpacity.getAlphaToPercent(Color.alpha(color));
        AbstractC14516b.m15114b(color, alphaToPercent, "setColor() color=", " value=", TAG);
        setValue(alphaToPercent);
        updateColor(color);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface
    public void setDataChangedListener(@Nullable PenOpacityLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void startAnimation(boolean isShow) {
        float f = isShow ? 1.0f : 0.0f;
        View mThumbView = getMThumbView();
        if (mThumbView != null) {
            float f4 = isShow ? 0.0f : 1.0f;
            mThumbView.setScaleX(f4);
            mThumbView.setScaleY(f4);
            mThumbView.animate().scaleX(f).scaleY(f).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setDuration(isShow ? 400L : 350L).start();
        }
        startCurvedAnimation(isShow);
    }
}
