package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020)H\u0016J2\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bH\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\"H\u0002J \u00108\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020)H\u0002J \u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\"H\u0002J\b\u0010@\u001a\u00020)H\u0002J(\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0014J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020HH\u0014J\u0018\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001bH\u0002J\u0010\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020 2\u0006\u0010M\u001a\u00020NH\u0014J\u001a\u0010P\u001a\u00020)2\b\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010R\u001a\u00020\"H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorGradientView;", "Landroid/view/View;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewInterface;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "context", "Landroid/content/Context;", "cursorSizeId", "", "cursorStrokeSizeId", "<init>", "(Landroid/content/Context;II)V", "mCursorBorderPaint", "Landroid/graphics/Paint;", "mCursorColorPaint", "mGradientBorderPaint", "mGradientSize", "Landroid/graphics/RectF;", "mHoverCursorColorPaint", "mGradientPaint", "mCursorSize", "mCursorStrokeSize", "mGradientBorderWidth", "mGradientBorderColor", "mGradientRadius", "mShadowOffsetY", "mShadowRadius", "mCurX", "", "mCurY", "mCurHoverX", "mCurHoverY", "mIsHoverInsideGradient", "", "mHsv", "", "mHsvHover", "mPickerColor", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColor;", "mTouchUpListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "construct", "", "setPickerColor", "pickerColor", "release", Constants.ARG_UPDATE, "who", "", "color", "hue", "saturation", "value", "setTouchUpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setColor", "hsv", "initResource", "initCursor", "initHoverCursor", "updateCursorPosition", "updatePickedColor", "cursorX", "cursorY", "hvsColor", "updateGradient", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isCursorArea", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchHoverEvent", "updateCursorColor", "mCursorColor", "hsvColor", "isInitComplete", "()Z", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenColorGradientView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenColorGradientView.kt\ncom/samsung/android/sdk/pen/setting/colorpicker/SpenColorGradientView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
public final class SpenColorGradientView extends View implements SpenColorViewInterface, SpenPickerColorEventListener {

    @NotNull
    private static final String TAG = "SpenColorGradientView";
    private static final int TRANSPARENT_WHITE = 16777215;
    private float mCurHoverX;
    private float mCurHoverY;
    private float mCurX;
    private float mCurY;
    private Paint mCursorBorderPaint;
    private Paint mCursorColorPaint;
    private int mCursorSize;
    private int mCursorStrokeSize;
    private int mGradientBorderColor;
    private Paint mGradientBorderPaint;
    private int mGradientBorderWidth;

    @Nullable
    private Paint mGradientPaint;
    private int mGradientRadius;
    private RectF mGradientSize;

    @Nullable
    private Paint mHoverCursorColorPaint;

    @NotNull
    private final float[] mHsv;

    @NotNull
    private final float[] mHsvHover;
    private boolean mIsHoverInsideGradient;

    @Nullable
    private SpenPickerColor mPickerColor;
    private int mShadowOffsetY;
    private int mShadowRadius;

    @Nullable
    private SpenColorViewTouchUpListener mTouchUpListener;

    public SpenColorGradientView(@Nullable Context context, int i, int i2) {
        super(context);
        this.mHsv = new float[]{0.0f, 0.0f, 0.0f};
        this.mHsvHover = new float[]{0.0f, 0.0f, 0.0f};
        Intrinsics.checkNotNull(context);
        construct(context, i, i2);
    }

    private final void construct(Context context, int cursorSizeId, int cursorStrokeSizeId) {
        initResource(context, cursorSizeId, cursorStrokeSizeId);
        initCursor();
        setLayerType(1, null);
    }

    private final void initCursor() {
        Paint paint = new Paint();
        this.mCursorBorderPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.mCursorBorderPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorBorderPaint");
            paint2 = null;
        }
        paint2.setAntiAlias(true);
        Paint paint4 = this.mCursorBorderPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorBorderPaint");
            paint4 = null;
        }
        paint4.setStrokeWidth(this.mCursorStrokeSize);
        Paint paint5 = this.mCursorBorderPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorBorderPaint");
            paint5 = null;
        }
        paint5.setColor(-1);
        Paint paint6 = this.mCursorBorderPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorBorderPaint");
            paint6 = null;
        }
        paint6.setShadowLayer(this.mShadowRadius, 0.0f, this.mShadowOffsetY, 855638016);
        Paint paint7 = new Paint();
        this.mGradientBorderPaint = paint7;
        paint7.setAntiAlias(true);
        Paint paint8 = new Paint();
        this.mCursorColorPaint = paint8;
        paint8.setAntiAlias(true);
        Paint paint9 = this.mCursorColorPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorColorPaint");
        } else {
            paint3 = paint9;
        }
        paint3.setDither(true);
    }

    private final void initHoverCursor() {
        Paint paint = new Paint();
        this.mHoverCursorColorPaint = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setShadowLayer(this.mShadowRadius, 0.0f, this.mShadowOffsetY, 436207616);
        this.mIsHoverInsideGradient = false;
    }

    private final void initResource(Context context, int cursorSizeId, int cursorStrokeSizeId) {
        Resources resources = context.getResources();
        this.mGradientSize = new RectF();
        this.mCursorSize = resources.getDimensionPixelSize(cursorSizeId);
        this.mCursorStrokeSize = resources.getDimensionPixelSize(cursorStrokeSizeId);
        this.mGradientRadius = resources.getDimensionPixelSize(C7932R.dimen.setting_color_picker_layout_color_swatch_radius);
        this.mGradientBorderWidth = resources.getDimensionPixelSize(C7932R.dimen.setting_color_picker_layout_v2_gradient_border_width);
        this.mShadowRadius = resources.getDimensionPixelSize(C7932R.dimen.setting_color_picker_layout_v2_gradient_shadow_radius);
        this.mShadowOffsetY = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_picker_layout_color_swatch_shadow_offsetY);
        this.mGradientBorderColor = SpenSettingUtil.getColor(context, C7932R.color.setting_color_gradient_color_border);
    }

    private final boolean isCursorArea(float x, float y2) {
        double d = 2.0f;
        return ((float) this.mCursorSize) / 2.0f >= ((float) Math.sqrt((double) (((float) Math.pow((double) (this.mCurX - x), d)) + ((float) Math.pow((double) (this.mCurY - y2), d)))));
    }

    private final boolean isInitComplete() {
        RectF rectF = this.mGradientSize;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF = null;
        }
        return !rectF.isEmpty();
    }

    private final void setColor(float[] hsv) {
        float f = hsv[0];
        float f4 = hsv[1];
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("setColor HSV[", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA), hsv[2], "]", TAG);
        float[] fArr = this.mHsv;
        fArr[0] = hsv[0];
        fArr[1] = hsv[1];
        fArr[2] = hsv[2];
        Paint paint = this.mCursorColorPaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCursorColorPaint");
            paint = null;
        }
        updateCursorColor(paint, this.mHsv);
        updateCursorPosition();
        updateGradient();
        invalidate();
    }

    private final void updateCursorColor(Paint mCursorColor, float[] hsvColor) {
        if (mCursorColor != null) {
            mCursorColor.setColor(SpenSettingUtil.HSVToColor(new float[]{hsvColor[0], hsvColor[1], 1.0f}));
        }
    }

    private final void updateCursorPosition() {
        if (isInitComplete()) {
            RectF rectF = this.mGradientSize;
            RectF rectF2 = null;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF = null;
            }
            float f = rectF.left;
            RectF rectF3 = this.mGradientSize;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF3 = null;
            }
            this.mCurX = ((this.mHsv[0] / 359) * rectF3.width()) + f;
            RectF rectF4 = this.mGradientSize;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF4 = null;
            }
            float f4 = rectF4.top;
            RectF rectF5 = this.mGradientSize;
            if (rectF5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            } else {
                rectF2 = rectF5;
            }
            float fHeight = rectF2.height();
            float[] fArr = this.mHsv;
            float f5 = fArr[1];
            float f6 = (fHeight * f5) + f4;
            this.mCurY = f6;
            float f7 = fArr[0];
            float f8 = this.mCurX;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("updateCursorPosition() HSV[", f7, SQLKeyword.COMMA, f5, SQLKeyword.COMMA);
            AbstractC11014a.m12337v(sbM1176v, f5, "] mCurX=", f8, " mCurY=");
            AbstractC2821a.m2206A(sbM1176v, TAG, f6);
        }
    }

    private final void updateGradient() {
        if (isInitComplete()) {
            Paint paint = this.mGradientPaint;
            RectF rectF = null;
            if (paint == null) {
                Paint paint2 = new Paint();
                this.mGradientPaint = paint2;
                paint2.setAntiAlias(true);
            } else if (paint != null) {
                paint.setShader(null);
            }
            float[] fArr = {0.0f, 60.0f, 120.0f, 180.0f, 240.0f, 300.0f, 359.0f};
            int[] iArr = new int[7];
            for (int i = 0; i < 7; i++) {
                iArr[i] = SpenSettingUtil.HSVToColor(new float[]{fArr[i], 1.0f, 1.0f});
            }
            RectF rectF2 = this.mGradientSize;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF2 = null;
            }
            float f = rectF2.left;
            RectF rectF3 = this.mGradientSize;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF3 = null;
            }
            float f4 = rectF3.top;
            RectF rectF4 = this.mGradientSize;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF4 = null;
            }
            float f5 = rectF4.right;
            RectF rectF5 = this.mGradientSize;
            if (rectF5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF5 = null;
            }
            float f6 = rectF5.top;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            LinearGradient linearGradient = new LinearGradient(f, f4, f5, f6, iArr, (float[]) null, tileMode);
            RectF rectF6 = this.mGradientSize;
            if (rectF6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF6 = null;
            }
            float f7 = rectF6.left;
            RectF rectF7 = this.mGradientSize;
            if (rectF7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF7 = null;
            }
            float f8 = rectF7.top;
            RectF rectF8 = this.mGradientSize;
            if (rectF8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF8 = null;
            }
            float f9 = rectF8.left;
            RectF rectF9 = this.mGradientSize;
            if (rectF9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            } else {
                rectF = rectF9;
            }
            ComposeShader composeShader = new ComposeShader(linearGradient, new LinearGradient(f7, f8, f9, rectF.bottom, 16777215, -1, tileMode), PorterDuff.Mode.MULTIPLY);
            Paint paint3 = this.mGradientPaint;
            if (paint3 != null) {
                paint3.setShader(composeShader);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean updatePickedColor(float cursorX, float cursorY, float[] hvsColor) {
        boolean z;
        if (isInitComplete()) {
            RectF rectF = this.mGradientSize;
            RectF rectF2 = null;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF = null;
            }
            float f = cursorX - rectF.left;
            RectF rectF3 = this.mGradientSize;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF3 = null;
            }
            float fWidth = (f / rectF3.width()) * 359;
            RectF rectF4 = this.mGradientSize;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF4 = null;
            }
            float f4 = cursorY - rectF4.top;
            RectF rectF5 = this.mGradientSize;
            if (rectF5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            } else {
                rectF2 = rectF5;
            }
            float fHeight = f4 / rectF2.height();
            if (fWidth < 0.0f) {
                fWidth = 0.0f;
            }
            if (hvsColor[0] == fWidth && hvsColor[1] == fHeight) {
                z = false;
            } else {
                hvsColor[0] = fWidth;
                hvsColor[1] = fHeight;
                z = true;
            }
        }
        float[] fArr = this.mHsv;
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        StringBuilder sb = new StringBuilder("updatePickedColor() isChanged()=");
        sb.append(z);
        sb.append(" hsv[");
        sb.append(f5);
        sb.append(SQLKeyword.COMMA);
        Log.i(TAG, AbstractC1038a.m1216q(sb, f6, SQLKeyword.COMMA, f7, "]"));
        return z;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isInitComplete()) {
            return super.dispatchHoverEvent(event);
        }
        RectF rectF = this.mGradientSize;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF = null;
        }
        if (rectF.contains((int) event.getX(), (int) event.getY())) {
            if (this.mHoverCursorColorPaint == null) {
                initHoverCursor();
            }
            this.mCurHoverX = event.getX();
            this.mCurHoverY = event.getY();
            int action = event.getAction();
            if (action == 7 || action == 9) {
                this.mIsHoverInsideGradient = true;
                if (updatePickedColor(this.mCurHoverX, this.mCurHoverY, this.mHsvHover)) {
                    updateCursorColor(this.mHoverCursorColorPaint, this.mHsvHover);
                }
            } else if (action == 10) {
                this.mIsHoverInsideGradient = false;
            }
        } else {
            this.mIsHoverInsideGradient = false;
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (isInitComplete()) {
            Paint paint2 = this.mGradientBorderPaint;
            Paint paint3 = null;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint2 = null;
            }
            paint2.setStyle(Paint.Style.FILL);
            Paint paint4 = this.mGradientBorderPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint4 = null;
            }
            paint4.setColor(-1);
            RectF rectF = this.mGradientSize;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF = null;
            }
            int i = this.mGradientRadius;
            float f = i;
            float f4 = i;
            Paint paint5 = this.mGradientBorderPaint;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint5 = null;
            }
            canvas.drawRoundRect(rectF, f, f4, paint5);
            Paint paint6 = this.mGradientBorderPaint;
            if (paint6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint6 = null;
            }
            paint6.setStyle(Paint.Style.STROKE);
            Paint paint7 = this.mGradientBorderPaint;
            if (paint7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint7 = null;
            }
            paint7.setStrokeWidth(this.mGradientBorderWidth);
            Paint paint8 = this.mGradientBorderPaint;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint8 = null;
            }
            paint8.setColor(this.mGradientBorderColor);
            RectF rectF2 = this.mGradientSize;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF2 = null;
            }
            int i2 = this.mGradientRadius;
            float f5 = i2;
            float f6 = i2;
            Paint paint9 = this.mGradientBorderPaint;
            if (paint9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientBorderPaint");
                paint9 = null;
            }
            canvas.drawRoundRect(rectF2, f5, f6, paint9);
            Paint paint10 = this.mGradientPaint;
            if (paint10 != null) {
                RectF rectF3 = this.mGradientSize;
                if (rectF3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                    rectF3 = null;
                }
                int i4 = this.mGradientRadius;
                canvas.drawRoundRect(rectF3, i4, i4, paint10);
            }
            if (this.mIsHoverInsideGradient && (paint = this.mHoverCursorColorPaint) != null) {
                canvas.drawCircle(this.mCurHoverX, this.mCurHoverY, (this.mCursorSize + this.mCursorStrokeSize) / 2.0f, paint);
            }
            float f7 = this.mCurX;
            float f8 = this.mCurY;
            float f9 = this.mCursorSize / 2.0f;
            Paint paint11 = this.mCursorBorderPaint;
            if (paint11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCursorBorderPaint");
                paint11 = null;
            }
            canvas.drawCircle(f7, f8, f9, paint11);
            float f10 = this.mCurX;
            float f11 = this.mCurY;
            float f12 = (this.mCursorSize - this.mCursorStrokeSize) / 2.0f;
            Paint paint12 = this.mCursorColorPaint;
            if (paint12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCursorColorPaint");
            } else {
                paint3 = paint12;
            }
            canvas.drawCircle(f10, f11, f12, paint3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int i = ((this.mCursorSize + this.mCursorStrokeSize) + this.mShadowRadius) / 2;
        RectF rectF = this.mGradientSize;
        RectF rectF2 = null;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF = null;
        }
        float f = i;
        rectF.set(f, f, w - i, h - i);
        RectF rectF3 = this.mGradientSize;
        if (rectF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF3 = null;
        }
        RectF rectF4 = this.mGradientSize;
        if (rectF4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
        } else {
            rectF2 = rectF4;
        }
        float fWidth = rectF2.width();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(w, h, "onSizeChanged() [", SQLKeyword.COMMA, "] gradientRect");
        sbM1173s.append(rectF3);
        sbM1173s.append(" GradientSize=");
        sbM1173s.append(fWidth);
        Log.i(TAG, sbM1173s.toString());
        setColor(this.mHsv);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        SpenColorViewTouchUpListener spenColorViewTouchUpListener;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isInitComplete()) {
            return false;
        }
        RectF rectF = this.mGradientSize;
        Paint paint = null;
        if (rectF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF = null;
        }
        boolean zContains = rectF.contains((int) event.getX(), (int) event.getY());
        float x = event.getX();
        float y2 = event.getY();
        RectF rectF2 = this.mGradientSize;
        if (rectF2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
            rectF2 = null;
        }
        StringBuilder sbM1176v = AbstractC0622a.m1176v("onTouchEvent() x=", x, " y=", y2, " mGradientSize=");
        sbM1176v.append(rectF2);
        sbM1176v.append(" isInsideGradient=");
        sbM1176v.append(zContains);
        Log.i(TAG, sbM1176v.toString());
        if (event.getAction() == 0 && !zContains && !isCursorArea(event.getX(), event.getY())) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        this.mCurX = event.getX();
        this.mCurY = event.getY();
        if (!zContains) {
            float f = this.mCurX;
            RectF rectF3 = this.mGradientSize;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF3 = null;
            }
            if (f < rectF3.left) {
                RectF rectF4 = this.mGradientSize;
                if (rectF4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                    rectF4 = null;
                }
                this.mCurX = rectF4.left;
            } else {
                float f4 = this.mCurX;
                RectF rectF5 = this.mGradientSize;
                if (rectF5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                    rectF5 = null;
                }
                if (f4 > rectF5.right) {
                    RectF rectF6 = this.mGradientSize;
                    if (rectF6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                        rectF6 = null;
                    }
                    this.mCurX = rectF6.right;
                }
            }
            float f5 = this.mCurY;
            RectF rectF7 = this.mGradientSize;
            if (rectF7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                rectF7 = null;
            }
            if (f5 < rectF7.top) {
                RectF rectF8 = this.mGradientSize;
                if (rectF8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                    rectF8 = null;
                }
                this.mCurY = rectF8.top;
            } else {
                float f6 = this.mCurY;
                RectF rectF9 = this.mGradientSize;
                if (rectF9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                    rectF9 = null;
                }
                if (f6 > rectF9.bottom) {
                    RectF rectF10 = this.mGradientSize;
                    if (rectF10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGradientSize");
                        rectF10 = null;
                    }
                    this.mCurY = rectF10.bottom;
                }
            }
        }
        if (event.getAction() == 0 && getParent() != null) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).playSoundEffect(0);
        }
        if (updatePickedColor(this.mCurX, this.mCurY, this.mHsv)) {
            Paint paint2 = this.mCursorColorPaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCursorColorPaint");
            } else {
                paint = paint2;
            }
            updateCursorColor(paint, this.mHsv);
            SpenPickerColor spenPickerColor = this.mPickerColor;
            if (spenPickerColor != null) {
                float[] fArr = this.mHsv;
                spenPickerColor.setColor(TAG, 255, fArr[0], fArr[1], fArr[2]);
            }
        }
        if (event.getAction() == 1 && (spenColorViewTouchUpListener = this.mTouchUpListener) != null) {
            spenColorViewTouchUpListener.onTouchUp();
        }
        invalidate();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void release() {
        this.mHoverCursorColorPaint = null;
        this.mIsHoverInsideGradient = false;
        Paint paint = this.mGradientPaint;
        if (paint != null) {
            paint.setShader(null);
        }
        this.mGradientPaint = null;
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.removeEventListener(this);
        }
        this.mPickerColor = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setPickerColor(@NotNull SpenPickerColor pickerColor) {
        Intrinsics.checkNotNullParameter(pickerColor, "pickerColor");
        this.mPickerColor = pickerColor;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        if (pickerColor != null) {
            pickerColor.getColor(fArr);
        }
        setColor(fArr);
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.addEventListener(this);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setTouchUpListener(@Nullable SpenColorViewTouchUpListener listener) {
        this.mTouchUpListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenPickerColorEventListener
    public void update(@Nullable String who, int color, float hue, float saturation, float value) {
        if (Intrinsics.areEqual(who, TAG)) {
            return;
        }
        float[] fArr = this.mHsv;
        if (fArr[0] == hue && fArr[1] == saturation && fArr[2] == value) {
            return;
        }
        setColor(new float[]{hue, saturation, value});
    }
}
