package com.samsung.android.sdk.pen.setting.pencommon;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilImage;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0014J(\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0014J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020\u001cH\u0016J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0011J\u000e\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u000fJ\b\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010/\"\u0004\b3\u00101¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreview;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBitmap", "Landroid/graphics/Bitmap;", "mManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewManager;", "mStrokeSize", "", "mRect", "Landroid/graphics/RectF;", "mBitmapPaint", "Landroid/graphics/Paint;", "mPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreview;", "mIsFixedWidth", "", "mIsFixedOpacity", "onLayout", "", "changed", "left", "top", "right", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "close", "setStrokeSize", "size", "fixedWidth", "isFixedWidth", "()Z", "setFixedWidth", "(Z)V", "isFixedOpacity", "setFixedOpacity", "setPreviewManager", "manager", "construct", "drawPen", "getPreview", "penName", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPenPreview extends View {

    @NotNull
    private static final String TAG = "SpenPenPreview1";

    @Nullable
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private boolean mIsFixedOpacity;
    private boolean mIsFixedWidth;

    @Nullable
    private SpenPreviewManager mManager;

    @Nullable
    private SpenPreview mPreview;
    private RectF mRect;
    private float mStrokeSize;

    public SpenPenPreview(@Nullable Context context) {
        super(context);
        construct();
    }

    private final void construct() {
        this.mRect = new RectF();
        this.mBitmapPaint = new Paint(4);
        this.mStrokeSize = 0.0f;
        this.mBitmap = null;
        this.mIsFixedWidth = false;
        setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        if (SpenSettingUtil.needRecoilVI()) {
            setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
        }
    }

    private final void drawPen() {
        SpenPreviewManager spenPreviewManager = this.mManager;
        SpenPreview spenPreview = this.mPreview;
        Bitmap bitmap = this.mBitmap;
        if (spenPreviewManager == null || spenPreview == null || bitmap == null) {
            return;
        }
        float max = spenPreviewManager.getMax();
        float height = getHeight() * 0.95f;
        if (height == 0.0f) {
            return;
        }
        float f = max > height ? height / max : 1.0f;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("drawPen() stroke scale : ", f, SQLKeyword.COMMA, this.mStrokeSize, SQLKeyword.COMMA);
        sbM1176v.append(max);
        sbM1176v.append(SQLKeyword.COMMA);
        sbM1176v.append(height);
        Log.i(TAG, sbM1176v.toString());
        bitmap.eraseColor(0);
        float f4 = this.mStrokeSize * f;
        if (f4 <= 0.0f) {
            Log.i(TAG, " drawPen() strokeSize <= 0");
            return;
        }
        int overlappingBgResource = spenPreviewManager.getMOverlappingResourceId();
        if (overlappingBgResource != 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable drawable = SpenSettingUtilImage.getDrawable(context, overlappingBgResource, bitmap.getWidth(), bitmap.getHeight(), 0);
            if (drawable != null) {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
        }
        int i = spenPreview.readyToDraw(this, f4, this.mIsFixedWidth, this.mIsFixedOpacity);
        spenPreviewManager.startDraw(f4, bitmap, this.mIsFixedWidth, this.mIsFixedOpacity);
        MotionEvent drawStartEvent = spenPreview.getDrawStartEvent();
        RectF rectF = null;
        if (drawStartEvent != null) {
            RectF rectF2 = this.mRect;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRect");
                rectF2 = null;
            }
            spenPreviewManager.updateDraw(drawStartEvent, rectF2);
            drawStartEvent.recycle();
        }
        int i2 = i - 1;
        for (int i4 = 1; i4 < i2; i4++) {
            MotionEvent drawNextEvent = spenPreview.getDrawNextEvent();
            if (drawNextEvent != null) {
                RectF rectF3 = this.mRect;
                if (rectF3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRect");
                    rectF3 = null;
                }
                spenPreviewManager.updateDraw(drawNextEvent, rectF3);
                drawNextEvent.recycle();
            }
        }
        MotionEvent drawEndEvent = spenPreview.getDrawEndEvent();
        if (drawEndEvent != null) {
            RectF rectF4 = this.mRect;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRect");
            } else {
                rectF = rectF4;
            }
            spenPreviewManager.updateDraw(drawEndEvent, rectF);
            drawEndEvent.recycle();
        }
        spenPreviewManager.endDraw();
    }

    private final SpenPreview getPreview(String penName) {
        return StringsKt.m14167w(penName, "FountainPen") ? new SpenPreview(getContext(), 5.0f) : StringsKt.m14167w(penName, "BrushPen") ? new SpenBrushPenPreview(getContext()) : StringsKt.m14167w(penName, PerfConstants.CodeMarkerParameters.MARKER) ? new SpenMarkerPreview(getContext()) : StringsKt.m14162r(penName, "WaterColorBrush") ? new SpenWaterColorBrushPreview(getContext()) : StringsKt.m14162r(penName, "ObliquePen") ? new SpenObliquePreview(getContext()) : StringsKt.m14162r(penName, "AirBrushPen") ? new SpenPreview(getContext(), 2.5f) : StringsKt.m14162r(penName, "Beautify2") ? new SpenBeautify2Preview(getContext()) : StringsKt.m14162r(penName, "ColoredPencil") ? new SpenColoredPencilPreview(getContext()) : StringsKt.m14162r(penName, "InkPen") ? new SpenInkPreview(getContext()) : new SpenPreview(getContext());
    }

    public void close() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        SpenPreview spenPreview = this.mPreview;
        if (spenPreview != null) {
            spenPreview.close();
        }
        this.mPreview = null;
        this.mManager = null;
    }

    /* JADX INFO: renamed from: isFixedOpacity, reason: from getter */
    public final boolean getMIsFixedOpacity() {
        return this.mIsFixedOpacity;
    }

    /* JADX INFO: renamed from: isFixedWidth, reason: from getter */
    public final boolean getMIsFixedWidth() {
        return this.mIsFixedWidth;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawPen();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            Paint paint = this.mBitmapPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBitmapPaint");
                paint = null;
            }
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w <= 0 || h <= 0) {
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        this.mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    }

    public final void setFixedOpacity(boolean z) {
        AbstractC4539a.m3208r("setFixedOpacity=", TAG, z);
        this.mIsFixedOpacity = z;
    }

    public final void setFixedWidth(boolean z) {
        AbstractC4539a.m3208r("setFixedWidth=", TAG, z);
        this.mIsFixedWidth = z;
    }

    public final void setPreviewManager(@NotNull SpenPreviewManager manager) {
        SpenPreview spenPreview;
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.mManager = manager;
        SpenPreview spenPreview2 = this.mPreview;
        if (spenPreview2 != null) {
            spenPreview2.close();
        }
        this.mPreview = getPreview(manager.getPenName());
        if (getTag() == null || (spenPreview = this.mPreview) == null) {
            return;
        }
        spenPreview.setSizeLevel(Integer.parseInt(getTag().toString()));
    }

    public final void setStrokeSize(float size) {
        this.mStrokeSize = size;
    }

    public SpenPenPreview(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        construct();
    }

    public SpenPenPreview(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        construct();
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }
}
