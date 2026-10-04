package com.samsung.android.sdk.pen.setting.common;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.provider.Settings;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0014J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u001dJ\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0013H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00132\u0006\u00102\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00064"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SearchConstants.TargetContents.TAG, "", "mButtonShapePaint", "Landroid/graphics/Paint;", "mButtonShapeRect", "Landroid/graphics/RectF;", "mButtonShapeSettingEnabled", "", "mButtonShapeStrokeTop", "mButtonShapeStrokeBottom", "mButtonShapeStrokeHorizontal", "mButtonShapeStrokeRadius", "mButtonShapeTextColor", "mButtonShapeBgColor", "mIsButtonShapeTarget", "mIsSetTextForButtonShape", "setTextColor", "", "color", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setButtonShapeEnabled", "enabled", "getVerticalOffset", "forceNormal", "setButtonShapeAssistantAsButton", "init", "getBoxHeight", "l", "Landroid/text/Layout;", "isButtonShapeSettingEnable", "()Z", "setButtonShapeSetting", "showButtonShape", "textColor", "getColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenShowButtonShapeText extends AppCompatTextView {

    @NotNull
    private final String TAG;
    private int mButtonShapeBgColor;
    private Paint mButtonShapePaint;
    private RectF mButtonShapeRect;
    private boolean mButtonShapeSettingEnabled;
    private int mButtonShapeStrokeBottom;
    private int mButtonShapeStrokeHorizontal;
    private int mButtonShapeStrokeRadius;
    private int mButtonShapeStrokeTop;
    private int mButtonShapeTextColor;
    private boolean mIsButtonShapeTarget;
    private boolean mIsSetTextForButtonShape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenShowButtonShapeText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenShowButtonShapeText";
        init(context);
    }

    private final int getBoxHeight(Layout l) {
        return getMeasuredHeight() - (getExtendedPaddingBottom() + getExtendedPaddingTop());
    }

    private final String getColor(int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC2322a.m1624n(" #%08X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)");
    }

    private final void init(Context context) {
        Resources resources = context.getResources();
        this.mButtonShapeStrokeTop = resources.getDimensionPixelSize(C7932R.dimen.setting_show_button_top);
        this.mButtonShapeStrokeBottom = resources.getDimensionPixelSize(C7932R.dimen.setting_show_button_bottom);
        this.mButtonShapeStrokeHorizontal = resources.getDimensionPixelSize(C7932R.dimen.setting_show_button_left_right);
        this.mButtonShapeStrokeRadius = resources.getDimensionPixelSize(C7932R.dimen.setting_show_button_radius);
        Paint paint = new Paint();
        this.mButtonShapePaint = paint;
        paint.setAntiAlias(true);
        this.mButtonShapeRect = new RectF();
        boolean zIsButtonShapeSettingEnable = isButtonShapeSettingEnable();
        this.mButtonShapeSettingEnabled = zIsButtonShapeSettingEnable;
        Log.i(this.TAG, "init(), mButtonShapeSettingEnabled=" + zIsButtonShapeSettingEnable);
        if (SpenSettingUtil.needRecoilVI()) {
            setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, C7932R.animator.spen_recoil_button_selector));
        }
    }

    private final boolean isButtonShapeSettingEnable() {
        return Settings.System.getInt(getContext().getContentResolver(), "show_button_background", 0) == 1;
    }

    private final void setButtonShapeSetting(boolean showButtonShape) {
        this.mIsSetTextForButtonShape = true;
        if (showButtonShape) {
            setTextColor(this.mButtonShapeTextColor);
        } else {
            setTextColor(this.mButtonShapeBgColor);
        }
        this.mIsSetTextForButtonShape = false;
    }

    public final int getVerticalOffset(boolean forceNormal) {
        int gravity = getGravity() & 112;
        Layout layout = getLayout();
        if (gravity == 48) {
            return 0;
        }
        Intrinsics.checkNotNull(layout);
        int boxHeight = getBoxHeight(layout);
        int height = layout.getHeight();
        if (height < boxHeight) {
            return gravity == 80 ? boxHeight - height : (boxHeight - height) >> 1;
        }
        return 0;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AbstractC4539a.m3208r("onConfigurationChanged() mButtonShapeSettingEnabled=", "SpenShowButtonShape", this.mButtonShapeSettingEnabled);
        boolean zIsButtonShapeSettingEnable = isButtonShapeSettingEnable();
        if (zIsButtonShapeSettingEnable != this.mButtonShapeSettingEnabled) {
            setButtonShapeSetting(zIsButtonShapeSettingEnable);
            this.mButtonShapeSettingEnabled = zIsButtonShapeSettingEnable;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        CharSequence text = getText();
        Log.i("SpenShowButtonShape", "onDraw() + text=" + ((Object) text) + "(" + getText().length() + ")");
        if (this.mButtonShapeSettingEnabled && this.mIsButtonShapeTarget && !TextUtils.isEmpty(getText())) {
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int extendedPaddingTop = getExtendedPaddingTop();
            if ((getGravity() & 112) != 48) {
                extendedPaddingTop += getVerticalOffset(false);
            }
            Layout layout = getLayout();
            int lineForOffset = layout.getLineForOffset(0);
            int lineForOffset2 = layout.getLineForOffset(getText().length());
            float lineLeft = layout.getLineLeft(lineForOffset);
            float lineRight = layout.getLineRight(lineForOffset);
            if (lineForOffset <= lineForOffset2) {
                int i = lineForOffset;
                while (true) {
                    if (lineLeft > layout.getLineLeft(i)) {
                        lineLeft = layout.getLineLeft(i);
                    }
                    if (lineRight < layout.getLineRight(i)) {
                        lineRight = layout.getLineRight(i);
                    }
                    if (i == lineForOffset2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            RectF rectF = this.mButtonShapeRect;
            Paint paint = null;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButtonShapeRect");
                rectF = null;
            }
            float f = extendedPaddingTop;
            rectF.top = (layout.getLineTop(lineForOffset) + f) - this.mButtonShapeStrokeTop;
            rectF.bottom = layout.getLineBottom(lineForOffset2) + f + this.mButtonShapeStrokeBottom;
            float f4 = compoundPaddingLeft;
            rectF.left = (((float) Math.floor(lineLeft)) + f4) - this.mButtonShapeStrokeHorizontal;
            rectF.right = ((float) Math.ceil(lineRight)) + f4 + this.mButtonShapeStrokeHorizontal;
            RectF rectF2 = this.mButtonShapeRect;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButtonShapeRect");
                rectF2 = null;
            }
            int i2 = this.mButtonShapeStrokeRadius;
            float f5 = i2;
            float f6 = i2;
            Paint paint2 = this.mButtonShapePaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButtonShapePaint");
            } else {
                paint = paint2;
            }
            canvas.drawRoundRect(rectF2, f5, f6, paint);
        }
        super.onDraw(canvas);
    }

    public final void setButtonShapeAssistantAsButton() {
        setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
    }

    public final void setButtonShapeEnabled(boolean enabled) {
        setButtonShapeEnabled(enabled, enabled ? SpenSettingUtil.getColor(getContext(), C7932R.color.setting_bg_color) : 0);
    }

    @Override // android.widget.TextView
    public void setTextColor(@ColorInt int color) {
        super.setTextColor(color);
        AbstractC6670b.m4756q("++++++++++++++ setTextColor() color=", getColor(color), this.TAG);
        if (this.mIsSetTextForButtonShape) {
            return;
        }
        this.mButtonShapeBgColor = color;
        Paint paint = this.mButtonShapePaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButtonShapePaint");
            paint = null;
        }
        paint.setColor(color);
    }

    private final void setButtonShapeEnabled(boolean enabled, int textColor) {
        Log.i(this.TAG, "setButtonShapeEnabled() enabled=" + enabled + " textColor=" + getColor(textColor));
        this.mIsButtonShapeTarget = enabled;
        this.mButtonShapeTextColor = textColor;
        this.mButtonShapeBgColor = getCurrentTextColor();
        Paint paint = this.mButtonShapePaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButtonShapePaint");
            paint = null;
        }
        paint.setColor(this.mButtonShapeBgColor);
        setButtonShapeSetting(this.mButtonShapeSettingEnabled);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenShowButtonShapeText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenShowButtonShapeText";
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenShowButtonShapeText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenShowButtonShapeText";
        init(context);
    }
}
