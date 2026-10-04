package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceSeekBar;", "Landroidx/appcompat/widget/SeslSeekBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "mPlayPoint", "", "", "mBgColor", "mIsDarkTheme", "", "setPlayPoint", "", "point", "", "setTheme", "bgColor", "isDarkTheme", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceSeekBar extends SeslSeekBar {
    private int mBgColor;
    private boolean mIsDarkTheme;

    @NotNull
    private final Paint mPaint;

    @NotNull
    private final List<Float> mPlayPoint;

    public VoiceSeekBar(@Nullable Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mPlayPoint = new ArrayList();
        this.mBgColor = -1;
    }

    @Override // androidx.appcompat.widget.SeslAbsSeekBar, androidx.appcompat.widget.SeslProgressBar, android.view.View
    public synchronized void onDraw(@NotNull Canvas canvas) {
        try {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int width = getWidth();
            int height = getHeight();
            if (width == 0 || height == 0) {
                measure(0, 0);
                width = getMeasuredWidth();
                height = getMeasuredHeight();
            }
            int max = getMax();
            this.mPaint.setColor(this.mIsDarkTheme ? ColorUtils.compositeColors(getResources().getColor(C9086R.color.composer_voice_seek_bar_dark_tick_and_background, null), this.mBgColor) : ColorUtils.compositeColors(getResources().getColor(C9086R.color.composer_voice_seek_bar_tick_and_background, null), this.mBgColor));
            if (!this.mPlayPoint.isEmpty()) {
                float fApplyDimension = TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
                float fApplyDimension2 = TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
                Iterator<Float> it = this.mPlayPoint.iterator();
                while (it.hasNext()) {
                    float fFloatValue = it.next().floatValue();
                    if (LocaleUtils.isRTLMode()) {
                        fFloatValue = max - fFloatValue;
                    }
                    float f = width;
                    float f4 = ((f - (2 * fApplyDimension)) * (fFloatValue / max)) + fApplyDimension;
                    float f5 = height / 2.0f;
                    if (f4 < f - fApplyDimension && f4 > fApplyDimension) {
                        canvas.drawCircle(f4, f5, fApplyDimension2, this.mPaint);
                    }
                }
            }
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setPlayPoint(@NotNull List<Float> point) {
        Intrinsics.checkNotNullParameter(point, "point");
        this.mPlayPoint.clear();
        List<Float> list = point;
        this.mPlayPoint.addAll(list);
        setMax(!list.isEmpty() ? (int) ((Number) AbstractC0000a.m10g(point, 1)).floatValue() : 0);
    }

    public final void setTheme(int bgColor, boolean isDarkTheme) {
        this.mBgColor = bgColor;
        this.mIsDarkTheme = isDarkTheme;
    }

    public VoiceSeekBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mPlayPoint = new ArrayList();
        this.mBgColor = -1;
    }

    public VoiceSeekBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mPlayPoint = new ArrayList();
        this.mBgColor = -1;
    }
}
