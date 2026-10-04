package com.samsung.android.sdk.pen.engine.pointericon;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.engine.util.SpenEngineUtil;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b+\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010P\u001a\u00020QJB\u0010R\u001a\u0004\u0018\u00010 2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u000207J:\u0010\\\u001a\u0004\u0018\u00010 2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010W\u001a\u00020V2\u0006\u0010]\u001a\u0002052\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u0002052\u0006\u0010`\u001a\u00020VJ0\u0010a\u001a\u0004\u0018\u00010 2\u0006\u0010S\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u0010b\u001a\u0002052\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u000205J@\u0010c\u001a\u0004\u0018\u00010 2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u0002052\u0006\u0010d\u001a\u000207J@\u0010e\u001a\u0004\u0018\u00010 2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u000207J\u0018\u0010f\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u00010T2\u0006\u0010`\u001a\u00020VJ2\u0010h\u001a\u0004\u0018\u00010 2\b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010W\u001a\u00020V2\u0006\u0010]\u001a\u0002052\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u000205J(\u0010i\u001a\u0004\u0018\u00010 2\u0006\u0010j\u001a\u00020T2\u0006\u0010]\u001a\u0002052\u0006\u0010k\u001a\u0002052\u0006\u0010l\u001a\u00020VJ\u0010\u0010m\u001a\u0004\u0018\u00010 2\u0006\u0010]\u001a\u000205J\u0018\u0010n\u001a\u0004\u0018\u00010 2\u0006\u0010o\u001a\u0002052\u0006\u0010W\u001a\u00020VJ(\u0010p\u001a\u0004\u0018\u00010\u000e2\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020V2\u0006\u0010]\u001a\u00020V2\u0006\u0010W\u001a\u00020VJ\u0010\u0010s\u001a\u0004\u0018\u00010 2\u0006\u0010W\u001a\u00020VJ\u0010\u0010t\u001a\u0004\u0018\u00010 2\u0006\u0010u\u001a\u00020VJ \u0010v\u001a\u0004\u0018\u00010 2\u0006\u0010j\u001a\u00020T2\u0006\u0010w\u001a\u0002052\u0006\u0010x\u001a\u00020@J\u0012\u0010y\u001a\u0004\u0018\u00010 2\u0006\u0010j\u001a\u00020TH\u0002J*\u0010z\u001a\u0004\u0018\u00010 2\u0006\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020V2\u0006\u0010}\u001a\u00020V2\u0006\u0010~\u001a\u00020VH\u0002J2\u0010z\u001a\u0004\u0018\u00010 2\b\u0010j\u001a\u0004\u0018\u00010T2\u0006\u0010}\u001a\u00020V2\u0006\u0010~\u001a\u00020V2\u0006\u0010w\u001a\u0002052\u0006\u0010x\u001a\u00020@J\u0016\u0010\u007f\u001a\u00020\u000e2\u0006\u0010q\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020VR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R\u0011\u0010;\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b;\u00108R\u0013\u0010<\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0013\u0010C\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0016\u0010E\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bI\u0010>R\u0011\u0010J\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bK\u0010BR\u0013\u0010L\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bM\u0010>R\u0013\u0010N\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bO\u0010>¨\u0006\u0081\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/SpenToolTip;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenManager", "Lcom/samsung/android/sdk/pen/pen/SpenPenManager;", "mPenList", "", "Lcom/samsung/android/sdk/pen/pen/SpenPenInfo;", "mSdkResources", "Landroid/content/res/Resources;", "mPenBitmap", "Landroid/graphics/Bitmap;", "mPenBitmapRef", "mLaserPenBitmap", "mLaserPenBitmapRef", "mEmptyBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "mConfiguration", "Landroid/content/res/Configuration;", "mContext", "mPenIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/PenIcon;", "mEraserPenIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/EraserPenIcon;", "mEraserRemoverIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/EraserRemoverIcon;", "mCutterRemoverIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/CutterRemoverIcon;", "mSpoidIcon", "Landroid/graphics/drawable/Drawable;", "mSelectionIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/SelectionIcon;", "mShapeIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/ShapeIcon;", "mChangeStyleIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/ChangeStyleIcon;", "mFillColorIcon", "mControlIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/ControlIcon;", "mLaserIcon", "Lcom/samsung/android/sdk/pen/engine/pointericon/LaserIcon;", "mPoints", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "mPressures", "", "mPenPaint", "Landroid/graphics/Paint;", "mDensity", "", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isDarkMode", "emptyDrawableImage", "getEmptyDrawableImage", "()Landroid/graphics/drawable/Drawable;", "hoveringIconDefaultPoint", "Landroid/graphics/Point;", "getHoveringIconDefaultPoint", "()Landroid/graphics/Point;", "drawableShapeImage", "getDrawableShapeImage", "drawableWithResize", "getDrawableWithResize", "()Landroid/graphics/Bitmap;", "drawableRemoverImage", "getDrawableRemoverImage", "hoveringIconSpoidPoint", "getHoveringIconSpoidPoint", "drawableSpoidImage", "getDrawableSpoidImage", "drawableFillColorImage", "getDrawableFillColorImage", "close", "", "getDrawableLaserPenImage", "name", "", "type", "", "color", "blurSize", "strokeSize", "insideRatio", "isRainbowEnabled", "getDrawablePenImage", "size", "isFixedWidth", "particleSize", "style", "getDrawablePenImageStyleLine", "_size", "getDrawableLaserPen", "isRainbowEffectEnabled", "getDrawableLaserPenStyleCurve", "getHoveringPenIconPoint", "penName", "getDrawablePenImageStyleCurver", "getDrawableVectorImageWithResize", "drawableName", "alpha", "tintColor", "getDrawableEraserImage", "getDrawableCutterImage", "radius", "getDrawableShadowImage", "bitmap", "shadowSize", "getDrawableChangeStyleImage", "getDrawableSelectionImage", "selectionType", "getDrawableControlImage", "fRotationDegree", "hotSpot", "getDrawable", "resizeImage", "resources", "resId", "iconWidth", "iconHeight", "getTintImage", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenToolTip {
    private static final int CONTROL_BITMAP_SIZE_DP = 25;
    private static final int DEFAULT_BITMAP_SIZE = 100;
    private static final int LASER_TYPE_POINT = 0;
    private static final int MAX_PEN_SIZE = 100;
    private static final int NO_TINT_COLOR = -1;
    private static final int PEN_BITMAP_PADDING_DP = 4;
    private static final int PEN_BITMAP_SIZE_DP = 42;
    private static final int PEN_POINTER_SIZE = 300;
    private static final float SPOID_BITMAP_PADDING_RATIO = 0.123f;
    private static final int SPOID_BITMAP_SIZE_DP = 24;
    private static final int SPOID_SHADOW_SIZE = 2;

    @NotNull
    private static final String TAG = "SpenToolTip";
    private static final int TIMESTAMP_GAP = 100;
    private boolean isEnabled;

    @NotNull
    private final ChangeStyleIcon mChangeStyleIcon;

    @NotNull
    private final Configuration mConfiguration;

    @Nullable
    private Context mContext;

    @NotNull
    private final ControlIcon mControlIcon;

    @NotNull
    private final CutterRemoverIcon mCutterRemoverIcon;
    private final float mDensity;

    @Nullable
    private BitmapDrawable mEmptyBitmapDrawable;

    @NotNull
    private final EraserPenIcon mEraserPenIcon;

    @NotNull
    private final EraserRemoverIcon mEraserRemoverIcon;

    @Nullable
    private Drawable mFillColorIcon;

    @NotNull
    private final LaserIcon mLaserIcon;

    @Nullable
    private Bitmap mLaserPenBitmap;

    @Nullable
    private Bitmap mLaserPenBitmapRef;

    @Nullable
    private Bitmap mPenBitmap;

    @Nullable
    private Bitmap mPenBitmapRef;

    @NotNull
    private final PenIcon mPenIcon;

    @Nullable
    private List<SpenPenInfo> mPenList;

    @Nullable
    private SpenPenManager mPenManager;

    @Nullable
    private Paint mPenPaint;

    @Nullable
    private PointF[] mPoints;

    @Nullable
    private float[] mPressures;

    @Nullable
    private Resources mSdkResources;

    @NotNull
    private final SelectionIcon mSelectionIcon;

    @NotNull
    private final ShapeIcon mShapeIcon;

    @Nullable
    private Drawable mSpoidIcon;

    public SpenToolTip(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.isEnabled = true;
        try {
            this.mSdkResources = context.getPackageManager().getResourcesForApplication(Spen.INSTANCE.getSpenPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.mContext = context;
        this.mConfiguration = context.getResources().getConfiguration();
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mPenManager = new SpenPenManager(context);
        this.mPoints = new PointF[3];
        this.mPressures = new float[3];
        Paint paint = new Paint();
        this.mPenPaint = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        PointF[] pointFArr = this.mPoints;
        if (pointFArr != null) {
            pointFArr[0] = new PointF(50.0f, 100.0f);
            pointFArr[1] = new PointF(100.0f, 100.0f);
            pointFArr[2] = new PointF(150.0f, 100.0f);
        }
        float[] fArr = this.mPressures;
        if (fArr != null) {
            fArr[0] = 0.8f;
            fArr[1] = 0.6f;
            fArr[2] = 0.4f;
        }
        this.mPenIcon = new PenIcon();
        this.mEraserPenIcon = new EraserPenIcon();
        this.mSelectionIcon = new SelectionIcon();
        this.mChangeStyleIcon = new ChangeStyleIcon();
        this.mEraserRemoverIcon = new EraserRemoverIcon();
        this.mCutterRemoverIcon = new CutterRemoverIcon();
        this.mShapeIcon = new ShapeIcon();
        this.mControlIcon = new ControlIcon();
        this.mLaserIcon = new LaserIcon();
    }

    private final Drawable getDrawable(String drawableName) {
        int identifier;
        Resources resources = this.mSdkResources;
        if (resources == null || (identifier = resources.getIdentifier(drawableName, "drawable", Spen.INSTANCE.getSpenPackageName())) == 0) {
            return null;
        }
        return SpenScreenCodecDecoder.getDrawable(resources, identifier);
    }

    private final Bitmap getDrawableWithResize() {
        int identifier;
        Resources resources = this.mSdkResources;
        if (resources == null || (identifier = resources.getIdentifier("change_style_arrow", "drawable", Spen.INSTANCE.getSpenPackageName())) == 0) {
            return null;
        }
        int i = (int) (this.mDensity * 23);
        if (i > 70) {
            i = 70;
        }
        Drawable drawableResizeImage = resizeImage(resources, identifier, 70, 70);
        if (drawableResizeImage == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        float f = this.mDensity;
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.save();
        float f4 = (100 - i) / 2.0f;
        canvas.translate(((int) ((-1) * f)) + f4, f4 + ((int) (f * 1)));
        drawableResizeImage.setBounds(0, 0, i, i);
        drawableResizeImage.draw(canvas);
        canvas.restore();
        return bitmapCreateBitmap;
    }

    private final Drawable resizeImage(Resources resources, int resId, int iconWidth, int iconHeight) {
        if (this.mSdkResources == null) {
            return null;
        }
        InputStream inputStreamOpenRawResource = resources.openRawResource(resId);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        Bitmap bitmapDecodeStream = SpenScreenCodecDecoder.decodeStream(inputStreamOpenRawResource);
        if (bitmapDecodeStream == null) {
            return null;
        }
        int width = bitmapDecodeStream.getWidth();
        int height = bitmapDecodeStream.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(iconWidth / width, iconHeight / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return new BitmapDrawable(resources, bitmapCreateBitmap);
    }

    public final void close() {
        this.mPenList = null;
        Bitmap bitmap = this.mPenBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mPenBitmap = null;
        Bitmap bitmap2 = this.mPenBitmapRef;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.mPenBitmapRef = null;
        Bitmap bitmap3 = this.mLaserPenBitmap;
        if (bitmap3 != null) {
            bitmap3.recycle();
        }
        this.mLaserPenBitmap = null;
        Bitmap bitmap4 = this.mLaserPenBitmapRef;
        if (bitmap4 != null) {
            bitmap4.recycle();
        }
        this.mLaserPenBitmapRef = null;
        SpenPenManager spenPenManager = this.mPenManager;
        if (spenPenManager != null) {
            spenPenManager.close();
        }
        this.mPenManager = null;
        Resources resources = this.mSdkResources;
        if (resources != null) {
            resources.flushLayoutCache();
        }
        this.mSdkResources = null;
        PointF[] pointFArr = this.mPoints;
        if (pointFArr != null) {
            pointFArr[0] = null;
            pointFArr[1] = null;
            pointFArr[2] = null;
            this.mPoints = null;
        }
        this.mPressures = null;
        this.mPenPaint = null;
        this.mContext = null;
    }

    @Nullable
    public final Drawable getDrawableChangeStyleImage(int color) {
        if (this.mSdkResources == null) {
            return null;
        }
        if (this.mChangeStyleIcon.getDrawable() != null && this.mChangeStyleIcon.equals(color)) {
            return this.mChangeStyleIcon.getDrawable();
        }
        this.mChangeStyleIcon.setColor(color);
        Bitmap drawableWithResize = getDrawableWithResize();
        if (drawableWithResize == null) {
            return null;
        }
        this.mChangeStyleIcon.setDrawable(new BitmapDrawable(this.mSdkResources, getTintImage(drawableWithResize, this.mChangeStyleIcon.getColor())));
        return this.mChangeStyleIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableControlImage(@NotNull String drawableName, float fRotationDegree, @NotNull Point hotSpot) {
        SpenToolTip spenToolTip;
        Intrinsics.checkNotNullParameter(drawableName, "drawableName");
        Intrinsics.checkNotNullParameter(hotSpot, "hotSpot");
        if (this.mControlIcon.getDrawable() == null || !this.mControlIcon.equals(drawableName, fRotationDegree)) {
            this.mControlIcon.setDrawableName(drawableName);
            this.mControlIcon.setRotationDegree(fRotationDegree);
            ControlIcon controlIcon = this.mControlIcon;
            spenToolTip = this;
            controlIcon.setDrawable(spenToolTip.resizeImage(drawableName, 25, 25, fRotationDegree, controlIcon.getHotSpot()));
        } else {
            spenToolTip = this;
        }
        hotSpot.set(spenToolTip.mControlIcon.getHotSpot().x, spenToolTip.mControlIcon.getHotSpot().y);
        return spenToolTip.mControlIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableCutterImage(float radius, int color) {
        if (!this.mCutterRemoverIcon.equals(radius, color)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            SpenEngineUtil.drawRemoverPreview(bitmapCreateBitmap, this.mDensity, 1.0f, radius, -6842473, color);
            this.mCutterRemoverIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap));
            this.mCutterRemoverIcon.setColor(color);
            this.mCutterRemoverIcon.setRadius(radius);
        }
        return this.mCutterRemoverIcon.getDrawable();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[PHI: r5
      0x0048: PHI (r5v3 float) = (r5v0 float), (r5v1 float) binds: [B:21:0x0046, B:24:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable getDrawableEraserImage(float size) {
        Bitmap bitmap;
        if (this.mSdkResources == null) {
            return null;
        }
        if (this.mEraserPenIcon.getDrawable() != null && this.mEraserPenIcon.equals(size)) {
            return this.mEraserPenIcon.getDrawable();
        }
        Drawable drawable = getDrawable("airview_pointer_eraser_50");
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null) {
                return null;
            }
        } else {
            bitmap = null;
        }
        float f = 100.0f;
        if (size > 100.0f) {
            size = f;
        } else {
            f = 10.0f;
            if (size < 10.0f) {
            }
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Rect rect = new Rect();
        int i = (int) size;
        rect.set(0, 0, i, i);
        if (drawable instanceof GradientDrawable) {
            canvas.save();
            float f4 = (100 - size) / 2;
            canvas.translate(f4, f4);
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setBounds(rect);
            gradientDrawable.draw(canvas);
            canvas.restore();
        } else if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
        }
        this.mEraserPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap));
        return this.mEraserPenIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableFillColorImage() {
        if (this.mSdkResources == null) {
            return null;
        }
        if (this.mFillColorIcon == null) {
            float f = 24 * this.mDensity;
            Drawable drawable = getDrawable("hover_fill_color");
            if (drawable == null) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
            Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
            canvasM4740a.drawColor(0, PorterDuff.Mode.CLEAR);
            canvasM4740a.save();
            if (f > 100.0f) {
                f = 100.0f;
            }
            int i = (int) f;
            drawable.setBounds(0, 0, i, i);
            float f4 = (100 - f) / 2.0f;
            canvasM4740a.translate(f4, f4);
            drawable.setAlpha(204);
            drawable.draw(canvasM4740a);
            canvasM4740a.restore();
            this.mFillColorIcon = new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap);
        }
        return this.mFillColorIcon;
    }

    @Nullable
    public final Drawable getDrawableLaserPen(@NotNull String name, int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEffectEnabled) throws Throwable {
        float f;
        MotionEvent motionEventObtain;
        MotionEvent motionEventObtain2;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        Intrinsics.checkNotNullParameter(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = true;
        String strM1624n = AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(16777215 & color)}, 1, "format(format, *args)");
        StringBuilder sbM780v = AbstractC0541b.m780v("getDrawableLaserPenImage: ", type, name, " type= ", " color= ");
        sbM780v.append(strM1624n);
        sbM780v.append(" blurSize= ");
        sbM780v.append(blurSize);
        sbM780v.append(" strokeSize= ");
        sbM780v.append(strokeSize);
        sbM780v.append(" insideRatio= ");
        sbM780v.append(insideRatio);
        Log.i(TAG, sbM780v.toString());
        SpenPenManager spenPenManager = this.mPenManager;
        MotionEvent motionEvent = null;
        if (spenPenManager == null) {
            return null;
        }
        if (this.mPenList == null) {
            List<SpenPenInfo> penInfoList = spenPenManager.getPenInfoList();
            this.mPenList = penInfoList;
            if (penInfoList == null) {
                return null;
            }
        }
        Log.d(TAG, "getDrawablePenImage return new bitmap drawble");
        this.mLaserIcon.setType(type);
        this.mLaserIcon.setColor(color);
        this.mLaserIcon.setBlurSize(blurSize);
        this.mLaserIcon.setStrokeSize(strokeSize);
        this.mLaserIcon.setInsideRatio(insideRatio);
        this.mLaserIcon.setRainbowEnabled(isRainbowEffectEnabled);
        Bitmap bitmap = this.mLaserPenBitmapRef;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mLaserPenBitmapRef = this.mLaserPenBitmap;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        this.mLaserPenBitmap = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null) {
            return null;
        }
        new Canvas(bitmapCreateBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
        try {
            try {
                SpenPen spenPenCreatePreviewPen = spenPenManager.createPreviewPen(SpenPenManager.SPEN_LASER_PEN);
                spenPenCreatePreviewPen.setColor(color);
                if (type != 0) {
                    z = false;
                }
                spenPenCreatePreviewPen.setTypePointerEnabled(z);
                spenPenCreatePreviewPen.setBlurSize(blurSize);
                spenPenCreatePreviewPen.setInsideRatio(insideRatio);
                spenPenCreatePreviewPen.setRainbowEffectEnabled(isRainbowEffectEnabled);
                float f4 = 100.0f;
                if (strokeSize <= 100.0f) {
                    f4 = strokeSize;
                }
                spenPenCreatePreviewPen.setSize(f4);
                spenPenCreatePreviewPen.setFixedWidth(f4);
                spenPenCreatePreviewPen.setBitmap(bitmapCreateBitmap);
                RectF rectF = new RectF();
                long jCurrentTimeMillis = System.currentTimeMillis();
                PointF[] pointFArr = this.mPoints;
                if (pointFArr == null || (fArr3 = this.mPressures) == null) {
                    f = f4;
                    motionEventObtain = null;
                } else {
                    PointF pointF = pointFArr[0];
                    f = f4;
                    motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, pointF != null ? pointF.x : 0.0f, pointF != null ? pointF.y : 0.0f, fArr3[0], f, 0, 0.0f, 0.0f, 0, 0);
                }
                if (motionEventObtain != null) {
                    try {
                        spenPenCreatePreviewPen.draw(motionEventObtain, rectF);
                        motionEventObtain.recycle();
                    } catch (Exception e) {
                        e = e;
                        motionEvent = motionEventObtain;
                        e.printStackTrace();
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        motionEvent = motionEventObtain;
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                        throw th;
                    }
                }
                PointF[] pointFArr2 = this.mPoints;
                if (pointFArr2 == null || (fArr2 = this.mPressures) == null) {
                    motionEventObtain2 = null;
                } else {
                    PointF pointF2 = pointFArr2[0];
                    motionEventObtain2 = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, pointF2 != null ? pointF2.x : 0.0f, pointF2 != null ? pointF2.y : 0.0f, fArr2[0], f, 0, 0.0f, 0.0f, 0, 0);
                }
                if (motionEventObtain2 != null) {
                    spenPenCreatePreviewPen.draw(motionEventObtain2, rectF);
                    motionEventObtain2.recycle();
                }
                long j = jCurrentTimeMillis + ((long) 700);
                PointF[] pointFArr3 = this.mPoints;
                if (pointFArr3 == null || (fArr = this.mPressures) == null) {
                    motionEventObtain = null;
                } else {
                    PointF pointF3 = pointFArr3[0];
                    motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, j, 1, pointF3 != null ? pointF3.x : 0.0f, pointF3 != null ? pointF3.y : 0.0f, fArr[0], f, 0, 0.0f, 0.0f, 0, 0);
                }
                if (motionEventObtain != null) {
                    spenPenCreatePreviewPen.draw(motionEventObtain, rectF);
                    motionEventObtain.recycle();
                }
                spenPenCreatePreviewPen.setBitmap(null);
                spenPenManager.destroyPreviewPen(spenPenCreatePreviewPen);
            } catch (Exception e2) {
                e = e2;
            }
            this.mLaserIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap));
            return this.mLaserIcon.getDrawable();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    public final Drawable getDrawableLaserPenImage(@Nullable String name, int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEnabled) {
        int i;
        int i2;
        float f;
        float f4;
        float f5;
        boolean z;
        if (this.mSdkResources == null || name == null) {
            return null;
        }
        if (this.mLaserIcon.getDrawable() != null) {
            i = type;
            i2 = color;
            f = blurSize;
            f4 = strokeSize;
            f5 = insideRatio;
            z = isRainbowEnabled;
            if (this.mLaserIcon.equals(i, i2, f, f4, f5, z)) {
                Log.d(TAG, "getDrawableLaserPenImage return cache laser bitmap drawable");
                return this.mLaserIcon.getDrawable();
            }
        } else {
            i = type;
            i2 = color;
            f = blurSize;
            f4 = strokeSize;
            f5 = insideRatio;
            z = isRainbowEnabled;
        }
        return i == 0 ? getDrawableLaserPen(name, i, i2, f, f4, f5, z) : getDrawableLaserPenStyleCurve(name, i, i2, f, f4, f5, z);
    }

    @Nullable
    public final Drawable getDrawableLaserPenStyleCurve(@NotNull String name, int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEnabled) throws Throwable {
        SpenPenManager spenPenManager;
        Context context;
        Intrinsics.checkNotNullParameter(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strM1624n = AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(16777215 & color)}, 1, "format(format, *args)");
        StringBuilder sbM780v = AbstractC0541b.m780v("getDrawableLaserPenCurve: ", type, name, " type= ", " color= ");
        sbM780v.append(strM1624n);
        sbM780v.append(" blurSize= ");
        sbM780v.append(blurSize);
        sbM780v.append(" strokeSize= ");
        AbstractC11014a.m12337v(sbM780v, strokeSize, " insideRatio= ", insideRatio, " enable rainbow= ");
        AbstractC0000a.m27x(sbM780v, isRainbowEnabled, TAG);
        Resources resources = this.mSdkResources;
        if (resources == null || (spenPenManager = this.mPenManager) == null || (context = this.mContext) == null) {
            return null;
        }
        if (this.mPenList == null) {
            List<SpenPenInfo> penInfoList = spenPenManager.getPenInfoList();
            this.mPenList = penInfoList;
            if (penInfoList == null) {
                return null;
            }
        }
        Log.d(TAG, "getDrawableLaserPenCurve return new bitmap drawble");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.mLaserIcon.setType(type);
        this.mLaserIcon.setColor(color);
        this.mLaserIcon.setBlurSize(blurSize);
        this.mLaserIcon.setStrokeSize(strokeSize);
        this.mLaserIcon.setInsideRatio(insideRatio);
        this.mLaserIcon.setRainbowEnabled(isRainbowEnabled);
        Bitmap bitmap = this.mLaserPenBitmapRef;
        if (bitmap != null) {
            bitmap.recycle();
        }
        int i = displayMetrics.densityDpi;
        int i2 = (((i * 42) / 160) * 2) - (((i * 4) / 160) * 4);
        int i4 = (int) (i2 * 1.2f);
        this.mLaserPenBitmapRef = this.mLaserPenBitmap;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        this.mLaserPenBitmap = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null) {
            return null;
        }
        bitmapCreateBitmap.eraseColor(0);
        try {
            SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
            spenSettingPenInfo.name = SpenPenManager.SPEN_LASER_PEN;
            spenSettingPenInfo.color = color;
            spenSettingPenInfo.size = strokeSize;
            SpenPenUtil.drawLaserPenPreview(context, bitmapCreateBitmap, i4, i2, spenSettingPenInfo, blurSize, insideRatio, isRainbowEnabled);
            this.mLaserIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mLaserIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawablePenImage(@Nullable String name, int color, float size, boolean isFixedWidth, float particleSize, int style) {
        String str;
        int i;
        float f;
        boolean z;
        float f4;
        int i2;
        if (this.mSdkResources == null || name == null) {
            return null;
        }
        if (Intrinsics.areEqual(name, SpenPenManager.SPEN_ERASER)) {
            return getDrawableEraserImage(size);
        }
        if (this.mPenIcon.getDrawable() != null) {
            i2 = style;
            str = name;
            i = color;
            f = size;
            z = isFixedWidth;
            f4 = particleSize;
            if (this.mPenIcon.equals(name, color, size, isFixedWidth, particleSize, i2)) {
                Log.d(TAG, "getDrawablePenImage return cache bitmap drawble");
                return this.mPenIcon.getDrawable();
            }
        } else {
            str = name;
            i = color;
            f = size;
            z = isFixedWidth;
            f4 = particleSize;
            i2 = style;
        }
        return i2 == 1211 ? getDrawablePenImageStyleCurver(str, i, f, z, f4) : getDrawablePenImageStyleLine(str, i, f, z, f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable getDrawablePenImageStyleCurver(@Nullable String name, int color, float size, boolean isFixedWidth, float particleSize) throws Throwable {
        SpenPenManager spenPenManager;
        Context context;
        int i;
        Resources resources = this.mSdkResources;
        if (resources == null || (spenPenManager = this.mPenManager) == null || (context = this.mContext) == null || name == null) {
            return null;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        try {
            SpenPen spenPenCreatePreviewPen = spenPenManager.createPreviewPen(name);
            int i2 = displayMetrics.densityDpi;
            int i4 = (i2 * 42) / 160;
            int i5 = (i2 * 4) / 160;
            int i6 = (i4 * 2) - (i5 * 4);
            int i7 = (int) (i6 * 1.2f);
            Bitmap bitmap = this.mPenBitmapRef;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mPenBitmapRef = this.mPenBitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i6, Bitmap.Config.ARGB_8888);
            this.mPenBitmap = bitmapCreateBitmap;
            if (bitmapCreateBitmap == null) {
                return null;
            }
            bitmapCreateBitmap.eraseColor(0);
            this.mPenIcon.setName(name);
            this.mPenIcon.setColor(color);
            this.mPenIcon.setSize(size);
            this.mPenIcon.setFixedWidth(isFixedWidth);
            this.mPenIcon.setParticleSize(particleSize);
            this.mPenIcon.setStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_CURVER);
            float f = (160.0f / displayMetrics.densityDpi) * size;
            float minSettingValue = spenPenCreatePreviewPen.getMinSettingValue();
            float maxSettingValue = spenPenCreatePreviewPen.getMaxSettingValue();
            if (f <= minSettingValue) {
                i = 1;
                boolean z = context.getResources().getConfiguration().getLayoutDirection() != 1;
                SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
                spenSettingPenInfo.name = name;
                spenSettingPenInfo.color = color;
                spenSettingPenInfo.sizeLevel = i;
                spenSettingPenInfo.particleSize = particleSize;
                spenSettingPenInfo.isFixedWidth = isFixedWidth;
                SpenPenUtil.drawPenPreview$default(context, bitmapCreateBitmap, spenSettingPenInfo, z, true, 0.0f, 32, null);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (bitmapCreateBitmap.getWidth() * 0.5f), (int) (bitmapCreateBitmap.getHeight() * 0.5f), true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                bitmapCreateBitmap.eraseColor(0);
                float f4 = i5;
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateScaledBitmap, f4, f4, new Paint());
                bitmapCreateScaledBitmap.recycle();
                this.mPenIcon.setDrawable(new BitmapDrawable(resources, bitmapCreateBitmap));
            } else {
                i = 100;
                if (f < maxSettingValue) {
                    int iRound = Math.round(((f - minSettingValue) * 100) / (maxSettingValue - minSettingValue));
                    if (iRound < 1) {
                        i = 1;
                    } else if (iRound <= 100) {
                        i = iRound;
                    }
                }
                if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
                }
                SpenSettingPenInfo spenSettingPenInfo2 = new SpenSettingPenInfo();
                spenSettingPenInfo2.name = name;
                spenSettingPenInfo2.color = color;
                spenSettingPenInfo2.sizeLevel = i;
                spenSettingPenInfo2.particleSize = particleSize;
                spenSettingPenInfo2.isFixedWidth = isFixedWidth;
                SpenPenUtil.drawPenPreview$default(context, bitmapCreateBitmap, spenSettingPenInfo2, z, true, 0.0f, 32, null);
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (bitmapCreateBitmap.getWidth() * 0.5f), (int) (bitmapCreateBitmap.getHeight() * 0.5f), true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap2, "createScaledBitmap(...)");
                bitmapCreateBitmap.eraseColor(0);
                float f42 = i5;
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateScaledBitmap2, f42, f42, new Paint());
                bitmapCreateScaledBitmap2.recycle();
                this.mPenIcon.setDrawable(new BitmapDrawable(resources, bitmapCreateBitmap));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mPenIcon.getDrawable();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:24|(4:187|25|26|192)|(9:28|(1:30)(1:35)|36|(1:38)|(1:40)|41|(1:43)|44|45)(10:46|(1:48)(1:49)|50|51|(2:60|61)(1:58)|62|(3:64|(4:66|(1:68)(1:69)|(1:71)(1:72)|73)(1:75)|76)(1:77)|(4:193|79|85|(9:188|87|(11:89|(1:91)(1:93)|94|(2:96|97)(1:98)|99|(1:101)(1:102)|(1:104)(1:106)|107|108|109|(10:110|190|111|(1:113)(1:118)|119|(1:121)(1:122)|123|(2:197|125)|131|(1:133)(1:206)))(1:136)|137|201|138|(3:140|(4:142|(1:144)(1:145)|(1:147)(1:148)|149)(1:151)|152)(1:153)|(2:195|155)|161)(0))(2:85|(0)(0))|179|180)|199|162|179|180) */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0273, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0276, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.samsung.android.sdk.pen.pen.SpenPen] */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.MotionEvent] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.graphics.Rect, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19, types: [com.samsung.android.sdk.pen.pen.SpenPenManager] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.MotionEvent] */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.view.MotionEvent] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.graphics.Canvas] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable getDrawablePenImageStyleLine(@NotNull String name, int color, float _size, boolean isFixedWidth, float particleSize) throws Throwable {
        Bitmap bitmap;
        ?? r7;
        ?? r72;
        ?? CreatePreviewPen;
        float f;
        ?? r4;
        PointF[] pointFArr;
        char c;
        float f4;
        SpenPenManager spenPenManager;
        long j;
        ?? r6;
        MotionEvent motionEvent;
        MotionEvent motionEventObtain;
        ?? Obtain;
        Intrinsics.checkNotNullParameter(name, "name");
        SpenPenManager spenPenManager2 = this.mPenManager;
        ?? r73 = 0;
        if (spenPenManager2 == null) {
            return null;
        }
        if (this.mPenList == null) {
            this.mPenList = spenPenManager2.getPenInfoList();
        }
        List<SpenPenInfo> list = this.mPenList;
        if (list == null) {
            return null;
        }
        Log.d(TAG, "getDrawablePenImage return new bitmap drawble");
        this.mPenIcon.setName(name);
        this.mPenIcon.setColor(color);
        this.mPenIcon.setSize(_size);
        this.mPenIcon.setFixedWidth(isFixedWidth);
        this.mPenIcon.setParticleSize(particleSize);
        this.mPenIcon.setStyle(SpenHoverPointerIcon.HOVER_POINTER_PEN_ICON_STYLE_LINE);
        int size = list.size();
        int i = 0;
        while (i < size) {
            SpenPenInfo spenPenInfo = list.get(i);
            String str = spenPenInfo.className;
            if (str != null && name.compareTo(str) == 0) {
                Bitmap bitmap2 = this.mPenBitmapRef;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.mPenBitmapRef = this.mPenBitmap;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
                this.mPenBitmap = bitmapCreateBitmap;
                if (bitmapCreateBitmap == null) {
                    return r73;
                }
                Rect rect = new Rect();
                ?? canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                try {
                    try {
                        CreatePreviewPen = spenPenManager2.createPreviewPen(spenPenInfo);
                        try {
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r7 = r73;
                    }
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    r7 = r73;
                }
                if (str.compareTo(SpenPenManager.SPEN_MAGIC_PEN) != 0) {
                    CreatePreviewPen.setBitmap(bitmapCreateBitmap);
                    CreatePreviewPen.setColor(color);
                    CreatePreviewPen.setFixedWidthEnabled(isFixedWidth);
                    CreatePreviewPen.setParticleSize(particleSize);
                    float f5 = 100.0f;
                    if (_size <= 100.0f) {
                        f5 = _size;
                    }
                    if (str.compareTo(SpenPenManager.SPEN_MARKER) == 0 || str.compareTo(SpenPenManager.SPEN_BRUSH_PEN) == 0 || str.compareTo(SpenPenManager.SPEN_OBLIQUE_PEN) == 0) {
                        float f6 = f5 / 2;
                        CreatePreviewPen.setSize(f6);
                        CreatePreviewPen.setFixedWidth(f6);
                    } else {
                        CreatePreviewPen.setSize(f5);
                        CreatePreviewPen.setFixedWidth(f5);
                    }
                    RectF rectF = new RectF();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    PointF[] pointFArr2 = this.mPoints;
                    if (pointFArr2 != null) {
                        float[] fArr = this.mPressures;
                        if (fArr != null) {
                            PointF pointF = pointFArr2[0];
                            f = f5;
                            Obtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, pointF != null ? pointF.x : 0.0f, pointF != null ? pointF.y : 0.0f, fArr[0], f, 0, 0.0f, 0.0f, 0, 0);
                        } else {
                            f = f5;
                            Obtain = r73;
                        }
                        r4 = Obtain;
                    } else {
                        f = f5;
                        r4 = r73;
                    }
                    if (r4 != 0) {
                        try {
                            CreatePreviewPen.draw(r4, rectF);
                            r4.recycle();
                            pointFArr = this.mPoints;
                            if (pointFArr == null) {
                                try {
                                    try {
                                        float[] fArr2 = this.mPressures;
                                        if (fArr2 != null) {
                                            PointF pointF2 = pointFArr[2];
                                            float f7 = pointF2 != null ? pointF2.x : 0.0f;
                                            PointF pointF3 = pointFArr[0];
                                            if (pointF3 != null) {
                                                c = 2;
                                                f4 = pointF3.x;
                                            } else {
                                                c = 2;
                                                f4 = 0.0f;
                                            }
                                            float f8 = f7 - f4;
                                            float f9 = 11;
                                            float f10 = f8 / f9;
                                            float f11 = ((pointF2 != null ? pointF2.y : 0.0f) - (pointF3 != null ? pointF3.y : 0.0f)) / f9;
                                            float f12 = fArr2[c];
                                            float f13 = (f12 - f12) / f9;
                                            spenPenManager = spenPenManager2;
                                            long j2 = ((long) 100) + jCurrentTimeMillis;
                                            int i2 = 1;
                                            while (true) {
                                                bitmap = bitmapCreateBitmap;
                                                long j3 = j2 + ((long) 5);
                                                try {
                                                    PointF pointF4 = pointFArr[0];
                                                    float f14 = i2;
                                                    MotionEvent motionEventObtain2 = MotionEvent.obtain(jCurrentTimeMillis, j3, 2, (f10 * f14) + (pointF4 != null ? pointF4.x : 0.0f), (f11 * f14) + (pointF4 != null ? pointF4.y : 0.0f), (f14 * f13) + fArr2[0], f, 0, 0.0f, 0.0f, 0, 0);
                                                    if (motionEventObtain2 != null) {
                                                        try {
                                                            CreatePreviewPen.draw(motionEventObtain2, rectF);
                                                            motionEventObtain2.recycle();
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            r72 = motionEventObtain2;
                                                            e.printStackTrace();
                                                            if (r72 != 0) {
                                                            }
                                                            this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                                                            return this.mPenIcon.getDrawable();
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            r7 = motionEventObtain2;
                                                            if (r7 != 0) {
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    if (i2 == 10) {
                                                        break;
                                                    }
                                                    i2++;
                                                    j2 = j3;
                                                    bitmapCreateBitmap = bitmap;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    r72 = 0;
                                                    e.printStackTrace();
                                                    if (r72 != 0) {
                                                    }
                                                    this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                                                    return this.mPenIcon.getDrawable();
                                                }
                                            }
                                        } else {
                                            c = 2;
                                            spenPenManager = spenPenManager2;
                                            bitmap = bitmapCreateBitmap;
                                        }
                                        j = jCurrentTimeMillis + ((long) 700);
                                    } catch (Exception e6) {
                                        e = e6;
                                        bitmap = bitmapCreateBitmap;
                                        r72 = 0;
                                        e.printStackTrace();
                                        if (r72 != 0) {
                                            r72.recycle();
                                        }
                                        this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                                        return this.mPenIcon.getDrawable();
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    r7 = 0;
                                }
                                try {
                                    PointF[] pointFArr3 = this.mPoints;
                                    if (pointFArr3 != null) {
                                        float[] fArr3 = this.mPressures;
                                        if (fArr3 != null) {
                                            PointF pointF5 = pointFArr3[c];
                                            motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, j, 1, pointF5 != null ? pointF5.x : 0.0f, pointF5 != null ? pointF5.y : 0.0f, fArr3[c], f, 0, 0.0f, 0.0f, 0, 0);
                                        } else {
                                            motionEventObtain = null;
                                        }
                                        motionEvent = motionEventObtain;
                                    } else {
                                        motionEvent = null;
                                    }
                                    if (motionEvent != null) {
                                        try {
                                            CreatePreviewPen.draw(motionEvent, rectF);
                                            motionEvent.recycle();
                                        } catch (Exception e7) {
                                            e = e7;
                                            r72 = motionEvent;
                                            e.printStackTrace();
                                            if (r72 != 0) {
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            r7 = motionEvent;
                                            if (r7 != 0) {
                                            }
                                            throw th;
                                        }
                                    }
                                    r6 = 0;
                                } catch (Exception e8) {
                                    e = e8;
                                    r6 = 0;
                                    r72 = r6;
                                    e.printStackTrace();
                                    if (r72 != 0) {
                                    }
                                    this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                                    return this.mPenIcon.getDrawable();
                                } catch (Throwable th6) {
                                    th = th6;
                                    r6 = 0;
                                    r7 = r6;
                                    if (r7 != 0) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            r73 = r4;
                            bitmap = bitmapCreateBitmap;
                            r72 = r73;
                            e.printStackTrace();
                            if (r72 != 0) {
                            }
                            this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                            return this.mPenIcon.getDrawable();
                        } catch (Throwable th7) {
                            th = th7;
                            r7 = r4;
                            if (r7 != 0) {
                                r7.recycle();
                            }
                            throw th;
                        }
                    } else {
                        pointFArr = this.mPoints;
                        if (pointFArr == null) {
                        }
                    }
                    this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                    return this.mPenIcon.getDrawable();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable("snote_popup_pensetting_preview_alpha");
                if (this.mDensity == 1.0f) {
                    rect.set(0, 190, 60, (int) (190 + _size));
                } else {
                    rect.set(0, 190, 100, (int) (190 + _size));
                }
                Paint paint = this.mPenPaint;
                if (paint != null) {
                    paint.setAlpha((color >> 24) & 255);
                }
                if (bitmapDrawable != null) {
                    canvas.drawBitmap(bitmapDrawable.getBitmap(), r73, rect, this.mPenPaint);
                }
                Paint paint2 = this.mPenPaint;
                if (paint2 != null) {
                    paint2.setAlpha(255);
                }
                CreatePreviewPen.setBitmap(bitmapCreateBitmap);
                spenPenManager = spenPenManager2;
                r6 = r73;
                bitmap = bitmapCreateBitmap;
                CreatePreviewPen.setBitmap(r6);
                spenPenManager.destroyPreviewPen(CreatePreviewPen);
                this.mPenIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmap));
                return this.mPenIcon.getDrawable();
            }
            i++;
            r73 = r73;
            spenPenManager2 = spenPenManager2;
        }
        return this.mPenIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableRemoverImage() {
        Drawable drawable;
        boolean zIsDarkMode = isDarkMode();
        if (this.mEraserRemoverIcon.getDrawable() == null || !this.mEraserRemoverIcon.equals(zIsDarkMode)) {
            if (this.mSdkResources == null) {
                return null;
            }
            float f = 24 * this.mDensity;
            int i = zIsDarkMode ? -197380 : -1;
            Drawable drawable2 = getDrawable("hover_eraser");
            if (drawable2 == null || (drawable = getDrawable("hover_eraser_color")) == null) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
            Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
            canvasM4740a.drawColor(0, PorterDuff.Mode.CLEAR);
            canvasM4740a.save();
            if (f > 100.0f) {
                f = 100.0f;
            }
            int i2 = (int) f;
            drawable2.setBounds(0, 0, i2, i2);
            drawable.setBounds(0, 0, i2, i2);
            float f4 = (100 - f) / 2.0f;
            canvasM4740a.translate(f4, f4);
            drawable.draw(canvasM4740a);
            if (i != -1) {
                drawable2.setTintMode(PorterDuff.Mode.SRC_ATOP);
                drawable2.setTint(i);
            } else {
                drawable2.setTintList(null);
            }
            drawable2.setAlpha(204);
            drawable2.draw(canvasM4740a);
            canvasM4740a.restore();
            this.mEraserRemoverIcon.setDrawable(new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap));
            this.mEraserRemoverIcon.setDarkMode(zIsDarkMode);
        }
        return this.mEraserRemoverIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableSelectionImage(int selectionType) {
        boolean zIsDarkMode = isDarkMode();
        if (this.mSelectionIcon.getDrawable() == null || !this.mSelectionIcon.equals(zIsDarkMode, selectionType)) {
            this.mSelectionIcon.setType(selectionType);
            this.mSelectionIcon.setDarkMode(zIsDarkMode);
            int i = zIsDarkMode ? -197380 : -1;
            if (selectionType == 0) {
                this.mSelectionIcon.setDrawable(getDrawableVectorImageWithResize("hover_selection_lasso", 24 * this.mDensity, 0.8f, i));
            } else if (selectionType == 1) {
                this.mSelectionIcon.setDrawable(getDrawableVectorImageWithResize("hover_selection_rectangle", 24 * this.mDensity, 0.8f, i));
            } else if (selectionType == 2) {
                this.mSelectionIcon.setDrawable(getDrawableVectorImageWithResize("hover_selection_circle", 24 * this.mDensity, 0.8f, i));
            }
        }
        return this.mSelectionIcon.getDrawable();
    }

    @Nullable
    public final Bitmap getDrawableShadowImage(@NotNull Bitmap bitmap, int shadowSize, int size, int color) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (shadowSize <= 0) {
            AbstractC0541b.m758D(shadowSize, "Cannot create shadow image. shadowSize is ", TAG);
            return null;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(shadowSize, BlurMaskFilter.Blur.NORMAL);
        Paint paint = new Paint(3);
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha(paint, null);
        Intrinsics.checkNotNullExpressionValue(bitmapExtractAlpha, "extractAlpha(...)");
        paint.setMaskFilter(blurMaskFilter);
        paint.setColor(color);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap).drawBitmap(bitmapExtractAlpha, 0.0f, this.mDensity, paint);
        return bitmapCreateBitmap;
    }

    @Nullable
    public final Drawable getDrawableShapeImage() {
        boolean zIsDarkMode = isDarkMode();
        if (this.mShapeIcon.getDrawable() == null || !this.mShapeIcon.equals(zIsDarkMode)) {
            this.mShapeIcon.setDrawable(getDrawableVectorImageWithResize("hover_shape", 24 * this.mDensity, 0.8f, zIsDarkMode ? -197380 : -1));
            this.mShapeIcon.setDarkMode(zIsDarkMode);
        }
        return this.mShapeIcon.getDrawable();
    }

    @Nullable
    public final Drawable getDrawableSpoidImage() {
        if (this.mSdkResources == null) {
            return null;
        }
        if (this.mSpoidIcon == null) {
            Drawable drawable = getDrawable("ic_spoid");
            if (drawable == null) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
            Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
            canvasM4740a.drawColor(0, PorterDuff.Mode.CLEAR);
            int i = (int) (this.mDensity * 24);
            int i2 = i <= 100 ? i : 100;
            drawable.setBounds(0, 0, i2, i2);
            drawable.draw(canvasM4740a);
            Bitmap drawableShadowImage = getDrawableShadowImage(bitmapCreateBitmap, (int) (2 * this.mDensity), i2, -16777216);
            if (drawableShadowImage != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                canvasM4740a.drawBitmap(drawableShadowImage, 0.0f, 0.0f, paint);
            }
            this.mSpoidIcon = new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap);
        }
        return this.mSpoidIcon;
    }

    @Nullable
    public final Drawable getDrawableVectorImageWithResize(@NotNull String drawableName, float size, float alpha, int tintColor) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(drawableName, "drawableName");
        if (this.mSdkResources == null || (drawable = getDrawable(drawableName)) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        canvasM4740a.drawColor(0, PorterDuff.Mode.CLEAR);
        canvasM4740a.save();
        if (size > 100.0f) {
            size = 100.0f;
        }
        int i = (int) size;
        drawable.setBounds(0, 0, i, i);
        float f = (100 - size) / 2.0f;
        canvasM4740a.translate(f, f);
        if (tintColor != -1) {
            drawable.setTintMode(PorterDuff.Mode.SRC_ATOP);
            drawable.setTint(tintColor);
        } else {
            drawable.setTintList(null);
        }
        drawable.setAlpha((int) (255 * alpha));
        drawable.draw(canvasM4740a);
        canvasM4740a.restore();
        return new BitmapDrawable(this.mSdkResources, bitmapCreateBitmap);
    }

    @Nullable
    public final Drawable getEmptyDrawableImage() {
        if (this.mEmptyBitmapDrawable == null) {
            this.mEmptyBitmapDrawable = new BitmapDrawable(this.mSdkResources, Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888));
        }
        return this.mEmptyBitmapDrawable;
    }

    @NotNull
    public final Point getHoveringIconDefaultPoint() {
        return new Point(50, 50);
    }

    @NotNull
    public final Point getHoveringIconSpoidPoint() {
        float f = this.mDensity * 24;
        if (f > 100.0f) {
            f = 100.0f;
        }
        int i = (int) (SPOID_BITMAP_PADDING_RATIO * f);
        return new Point(i, ((int) f) - i);
    }

    @NotNull
    public final Point getHoveringPenIconPoint(@Nullable String penName, int style) {
        DisplayMetrics displayMetrics;
        Point point = new Point();
        if (penName == null || penName.compareTo(SpenPenManager.SPEN_ERASER) == 0) {
            point.set(50, 50);
            return point;
        }
        if (penName.compareTo(SpenPenManager.SPEN_LASER_PEN) == 0) {
            point.set(50, 100);
            return point;
        }
        if (style != 1211) {
            point.set(50, 100);
            return point;
        }
        Resources resources = this.mSdkResources;
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            int i = displayMetrics.densityDpi;
            int i2 = (i * 42) / 160;
            int i4 = (i * 4) / 160;
            point.set(i4, (((i2 * 2) - (i4 * 4)) / 2) - i4);
        }
        return point;
    }

    @NotNull
    public final Bitmap getTintImage(@NotNull Bitmap bitmap, int color) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public final boolean isDarkMode() {
        return 32 == (this.mConfiguration.uiMode & 48);
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    @Nullable
    public final Drawable resizeImage(@Nullable String drawableName, int iconWidth, int iconHeight, float fRotationDegree, @NotNull Point hotSpot) {
        Bitmap bitmapDecodeResource;
        Intrinsics.checkNotNullParameter(hotSpot, "hotSpot");
        Resources resources = this.mSdkResources;
        if (resources == null || drawableName == null || iconWidth < 0 || iconHeight < 0) {
            SpenError.ThrowUncheckedException(7);
            return null;
        }
        if (resources == null) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier(drawableName, "drawable", Spen.INSTANCE.getSpenPackageName());
            if (identifier == 0 || (bitmapDecodeResource = BitmapFactory.decodeResource(this.mSdkResources, identifier)) == null) {
                return null;
            }
            int width = bitmapDecodeResource.getWidth();
            int height = bitmapDecodeResource.getHeight();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            float f = iconWidth;
            int iApplyDimension = (int) TypedValue.applyDimension(1, f, displayMetrics);
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, iconHeight, displayMetrics);
            int iApplyDimension3 = (int) TypedValue.applyDimension(1, f, displayMetrics);
            hotSpot.set(iApplyDimension3 / 2, iApplyDimension3 / 2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iApplyDimension, iApplyDimension2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.rotate(fRotationDegree, iApplyDimension / 2.0f, iApplyDimension2 / 2.0f);
            canvas.drawBitmap(bitmapDecodeResource, new Rect(0, 0, width, height), new Rect(0, 0, iApplyDimension, iApplyDimension2), paint);
            return new BitmapDrawable(resources, bitmapCreateBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
