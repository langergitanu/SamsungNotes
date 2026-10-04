package com.samsung.android.sdk.pen.setting.pencommon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPreviewPenUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilImage;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 J2\u00020\u0001:\u0001JB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0014J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0014J\u0006\u0010'\u001a\u00020\u001fJ\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000eJ\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0010J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0010J\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\tJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\tJ\b\u0010=\u001a\u00020\u001fH\u0002J\u0018\u0010A\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0010H\u0002J\b\u0010D\u001a\u00020\u0010H\u0002J\b\u0010E\u001a\u00020\tH\u0002J\b\u0010F\u001a\u00020\tH\u0002J\b\u0010G\u001a\u00020\tH\u0002J\b\u0010H\u001a\u00020\tH\u0002J\u001a\u0010I\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010>\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPenColor", "", "mPenName", "", "mSizeLevel", "mParticleSize", "", "mIsFixedWidth", "", "mIsFixedOpacity", "mBitmap", "Landroid/graphics/Bitmap;", "mBitmapPaint", "Landroid/graphics/Paint;", "mContext", "mOverlapBgResId", "mUseResource", "mIsRTL", "mEnlargedValue", "mNeedToMakeBitmap", "mPenProgress", "mPreviewType", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "close", "setInfo", "penName", "sizeLevel", "setPenColor", "color", "setPenSizeLevel", "setParticleSize", "particleSize", "setFixedWidth", "isFixedWidth", "setFixedOpacity", "isFixedOpacity", "setOverlapBgResource", "resId", "setUserResource", "value", "penProgress", "getPenProgress", "()F", "setPenProgress", "(F)V", "construct", "drawBitmap", "getDrawBitmap", "()Landroid/graphics/Bitmap;", "initBitmap", "setNeedToMakeBitmap", "need", "needToMakeBitmap", "drawPaddingStart", "drawPaddingEnd", "drawPaddingTop", "drawPaddingBottom", "setAttributes", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenPreviewV2 extends View {
    private static final float DEFAULT_ENLARGED_VALUE = 2.0f;
    public static final int PREVIEW_TYPE_FREE_CURVE = 1;
    public static final int PREVIEW_TYPE_LINE = 0;

    @NotNull
    private static final String TAG = "SpenPenPreviewV2";

    @Nullable
    private Bitmap mBitmap;
    private Paint mBitmapPaint;

    @NotNull
    private Context mContext;
    private float mEnlargedValue;
    private boolean mIsFixedOpacity;
    private boolean mIsFixedWidth;
    private boolean mIsRTL;
    private boolean mNeedToMakeBitmap;
    private int mOverlapBgResId;
    private float mParticleSize;
    private int mPenColor;

    @Nullable
    private String mPenName;
    private float mPenProgress;
    private int mPreviewType;
    private int mSizeLevel;
    private boolean mUseResource;

    @JvmField
    @SuppressLint({WarningType.NewApi})
    @NotNull
    public static final Property<SpenPenPreviewV2, Float> PEN_PROGRESS = new FloatProperty<SpenPenPreviewV2>() { // from class: com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2$Companion$PEN_PROGRESS$1
        @Override // android.util.Property
        public Float get(SpenPenPreviewV2 penPreview) {
            Intrinsics.checkNotNullParameter(penPreview, "penPreview");
            return Float.valueOf(penPreview.getMPenProgress());
        }

        @Override // android.util.FloatProperty
        public void setValue(SpenPenPreviewV2 penPreview, float value) {
            Intrinsics.checkNotNullParameter(penPreview, "penPreview");
            penPreview.setPenProgress(value);
        }
    };

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenPenPreviewV2(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void construct() {
        this.mPenColor = 0;
        this.mBitmap = null;
        this.mBitmapPaint = new Paint(4);
        this.mOverlapBgResId = 0;
        this.mUseResource = false;
        this.mPenName = null;
        this.mParticleSize = 0.0f;
        this.mIsFixedWidth = false;
        this.mIsFixedOpacity = false;
        this.mIsRTL = AbstractC0541b.m759a(this.mContext) == 1;
        this.mNeedToMakeBitmap = false;
        this.mPenProgress = 1.0f;
    }

    private final int drawPaddingBottom() {
        if (this.mPreviewType == 0) {
            return 0;
        }
        return getPaddingBottom();
    }

    private final int drawPaddingEnd() {
        if (this.mPreviewType == 0) {
            return 0;
        }
        return getPaddingEnd();
    }

    private final int drawPaddingStart() {
        if (this.mPreviewType == 0) {
            return 0;
        }
        return getPaddingStart();
    }

    private final int drawPaddingTop() {
        if (this.mPreviewType == 0) {
            return 0;
        }
        return getPaddingTop();
    }

    private final Bitmap getDrawBitmap() throws Throwable {
        Paint paint = null;
        if (this.mPenName != null) {
            if (!getMNeedToMakeBitmap()) {
                return this.mBitmap;
            }
            if (initBitmap(getWidth(), getHeight())) {
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    bitmap.eraseColor(0);
                    if (this.mOverlapBgResId != 0) {
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        Drawable drawable = SpenSettingUtilImage.getDrawable(context, this.mOverlapBgResId, bitmap.getWidth(), bitmap.getHeight(), 0);
                        if (drawable != null) {
                            Canvas canvas = new Canvas(bitmap);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                        }
                    }
                    if (this.mUseResource) {
                        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(this.mPenColor, PorterDuff.Mode.SRC_IN);
                        Paint paint2 = this.mBitmapPaint;
                        if (paint2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBitmapPaint");
                        } else {
                            paint = paint2;
                        }
                        paint.setColorFilter(porterDuffColorFilter);
                    } else {
                        SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
                        String str = this.mPenName;
                        if (str != null) {
                            spenSettingPenInfo.name = str;
                        }
                        spenSettingPenInfo.sizeLevel = this.mSizeLevel;
                        spenSettingPenInfo.color = this.mPenColor;
                        spenSettingPenInfo.particleSize = this.mParticleSize;
                        spenSettingPenInfo.isFixedWidth = this.mIsFixedWidth;
                        spenSettingPenInfo.isFixedOpacity = this.mIsFixedOpacity;
                        SpenPreviewPenUtil.PreviewType previewType = this.mPreviewType == 0 ? SpenPreviewPenUtil.PreviewType.STRAIGHT_LINE : SpenPreviewPenUtil.PreviewType.FREE_CURVE;
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        SpenPreviewPenUtil spenPreviewPenUtil = new SpenPreviewPenUtil(context2, previewType);
                        spenPreviewPenUtil.setPenProgress(this.mPenProgress);
                        spenPreviewPenUtil.drawPenPreview(spenSettingPenInfo, bitmap, this);
                    }
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) ((1.0f / this.mEnlargedValue) * bitmap.getWidth()), (int) ((1.0f / this.mEnlargedValue) * bitmap.getHeight()), true);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                    bitmap.recycle();
                    this.mBitmap = bitmapCreateScaledBitmap;
                    setNeedToMakeBitmap(false);
                }
                return this.mBitmap;
            }
        }
        return null;
    }

    private final boolean initBitmap(int w, int h) {
        if (w > 0 && h > 0) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            int iDrawPaddingStart = (w - drawPaddingStart()) - drawPaddingEnd();
            int iDrawPaddingTop = (h - drawPaddingTop()) - drawPaddingBottom();
            float f = this.mEnlargedValue;
            int i = (int) (iDrawPaddingStart * f);
            int i2 = (int) (f * iDrawPaddingTop);
            if (i > 0 && i2 > 0) {
                this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                return true;
            }
            this.mBitmap = null;
        }
        return false;
    }

    /* JADX INFO: renamed from: needToMakeBitmap, reason: from getter */
    private final boolean getMNeedToMakeBitmap() {
        return this.mNeedToMakeBitmap;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            this.mEnlargedValue = 2.0f;
            this.mPreviewType = 1;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenPenPreviewV2, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mEnlargedValue = typedArrayObtainStyledAttributes.getFloat(C7932R.styleable.SpenPenPreviewV2_enlargedValue, 2.0f);
        this.mPreviewType = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenPenPreviewV2_previewType, 1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void setNeedToMakeBitmap(boolean need) {
        this.mNeedToMakeBitmap = need;
    }

    public final void close() {
        String str = this.mPenName;
        if (str == null) {
            str = "Unknown PenName";
        }
        AbstractC6670b.m4756q("close()", str, TAG);
        this.mPenName = null;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        this.mNeedToMakeBitmap = false;
    }

    /* JADX INFO: renamed from: getPenProgress, reason: from getter */
    public final float getMPenProgress() {
        return this.mPenProgress;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) throws Throwable {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap drawBitmap = getDrawBitmap();
        if (drawBitmap != null) {
            float fDrawPaddingStart = drawPaddingStart();
            float fDrawPaddingTop = drawPaddingTop();
            Paint paint = this.mBitmapPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBitmapPaint");
                paint = null;
            }
            canvas.drawBitmap(drawBitmap, fDrawPaddingStart, fDrawPaddingTop, paint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w <= 0 || h <= 0 || this.mPenName == null || this.mBitmap == null) {
            return;
        }
        setNeedToMakeBitmap(true);
    }

    public final void setFixedOpacity(boolean isFixedOpacity) {
        if (this.mIsFixedOpacity == isFixedOpacity) {
            return;
        }
        this.mIsFixedOpacity = isFixedOpacity;
        setNeedToMakeBitmap(true);
    }

    public final void setFixedWidth(boolean isFixedWidth) {
        if (this.mIsFixedWidth == isFixedWidth) {
            return;
        }
        this.mIsFixedWidth = isFixedWidth;
        setNeedToMakeBitmap(true);
    }

    public final void setInfo(@NotNull String penName, int sizeLevel) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        String str = this.mPenName;
        if (str != null && str.compareTo(penName) == 0 && this.mSizeLevel == sizeLevel) {
            return;
        }
        this.mPenName = penName;
        this.mSizeLevel = sizeLevel;
        setNeedToMakeBitmap(true);
    }

    public final void setOverlapBgResource(int resId) {
        if (this.mOverlapBgResId == resId) {
            return;
        }
        this.mOverlapBgResId = resId;
        setNeedToMakeBitmap(true);
    }

    public final void setParticleSize(float particleSize) {
        if (Float.compare(this.mParticleSize, particleSize) == 0) {
            return;
        }
        this.mParticleSize = particleSize;
        setNeedToMakeBitmap(true);
    }

    public final void setPenColor(int color) {
        if (this.mPenColor == color) {
            return;
        }
        this.mPenColor = color;
        setNeedToMakeBitmap(true);
    }

    public final void setPenProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.mPenProgress == f) {
            return;
        }
        this.mPenProgress = f;
        setNeedToMakeBitmap(true);
        invalidate();
    }

    public final void setPenSizeLevel(int sizeLevel) {
        if (this.mSizeLevel == sizeLevel) {
            return;
        }
        this.mSizeLevel = sizeLevel;
        setNeedToMakeBitmap(true);
    }

    public final void setUserResource(int resId) {
        setOverlapBgResource(resId);
        this.mUseResource = resId != 0;
    }

    public /* synthetic */ SpenPenPreviewV2(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenPenPreviewV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPreviewType = 1;
        this.mContext = context;
        setAttributes(context, attributeSet);
        construct();
    }
}
