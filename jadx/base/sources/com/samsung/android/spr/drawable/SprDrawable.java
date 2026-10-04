package com.samsung.android.spr.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import com.microsoft.identity.common.java.WarningType;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.spr.drawable.animation.SprDrawableAnimation;
import com.samsung.android.spr.drawable.animation.SprDrawableAnimationFrame;
import com.samsung.android.spr.drawable.animation.SprDrawableAnimationValue;
import com.samsung.android.spr.drawable.cache.SprCacheManager;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeFill;
import com.samsung.android.spr.drawable.document.attribute.impl.SprLinearGradient;
import com.samsung.android.spr.drawable.document.debug.SprDebug;
import com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeNinePatch;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeRectangle;
import com.samsung.android.spr.engine.R;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprDrawable extends Drawable implements Animatable {
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String NA_NAME = "n/a";
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;
    private static final Method mCanApplyTheme;
    private static final Method mExtractThemeAttrs;
    private static final Method mGetLayoutDirection;
    private static final Method mParseTintMode;
    private static final Method mResolveAttributes;
    private static final Method mUpdateTintFilter;
    private static final int mVersion = 151023;
    private Bitmap mAnimationBitmap;
    private Bitmap mCacheBitmap;
    private int mCacheDensityDpi;
    protected SprDocument mDocument;
    private Rect mDstRect;
    private Matrix mIdentityMatrix;
    private Matrix mMirrorMatrix;
    private boolean mMutated;
    private SprDrawableAnimation mSprAnimation;
    private SprState mState;
    private PorterDuffColorFilter mTintFilter;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SprState extends Drawable.ConstantState {
        private boolean mAutoMirrored;
        private final Paint mBitmapPaint;
        private SprCacheManager mCacheManager;
        private int mChangingConfigurations;
        private int mDensityDpi;
        private SprDocument mDocument;
        private int mGravity;
        private SprFileAttributeNinePatch mMultiNinePatch;
        private boolean mNinePatch;
        private Bitmap mNinePatchBitmap;
        private NinePatch mNinePatchRenderer;
        private boolean mRebuildShader;
        private int[] mThemeAttrs;
        private Shader.TileMode mTileModeX;
        private Shader.TileMode mTileModeY;
        private ColorStateList mTint;
        private PorterDuff.Mode mTintMode;

        public SprState(SprDocument sprDocument) {
            this.mDocument = null;
            this.mThemeAttrs = null;
            this.mNinePatch = false;
            this.mMultiNinePatch = null;
            this.mDensityDpi = 0;
            this.mCacheManager = null;
            this.mNinePatchRenderer = null;
            this.mNinePatchBitmap = null;
            this.mTint = null;
            this.mTintMode = PorterDuff.Mode.SRC_IN;
            this.mAutoMirrored = false;
            this.mGravity = 119;
            this.mRebuildShader = false;
            this.mTileModeX = null;
            this.mTileModeY = null;
            setDocument(sprDocument);
            Paint paint = new Paint();
            this.mBitmapPaint = paint;
            paint.setFilterBitmap(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createNinePatchRenderer() {
            if (this.mNinePatchRenderer != null || this.mDocument == null) {
                return;
            }
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            synchronized (this.mDocument) {
                try {
                    if (!this.mDocument.isPredraw()) {
                        this.mDocument.preDraw(0);
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                    this.mNinePatchBitmap = bitmapCreateBitmap;
                    if (bitmapCreateBitmap != null) {
                        this.mDocument.draw(new Canvas(this.mNinePatchBitmap), intrinsicWidth, intrinsicHeight, 0, this.mDensityDpi);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!this.mNinePatch || this.mMultiNinePatch != null) {
                this.mNinePatchRenderer = new NinePatch(this.mNinePatchBitmap, getNinePatchChunk(this.mMultiNinePatch).array());
                return;
            }
            float densityScale = getDensityScale();
            int iRound = Math.round(this.mDocument.mNinePatchLeft * densityScale);
            int iRound2 = Math.round(this.mDocument.mNinePatchTop * densityScale);
            int iRound3 = intrinsicWidth - Math.round(this.mDocument.mNinePatchRight * densityScale);
            int iRound4 = intrinsicHeight - Math.round(this.mDocument.mNinePatchBottom * densityScale);
            if (iRound3 <= iRound) {
                iRound3 = iRound + 1;
            }
            if (iRound4 <= iRound2) {
                iRound4 = iRound2 + 1;
            }
            this.mNinePatchRenderer = new NinePatch(this.mNinePatchBitmap, getNinePatchChunk(iRound, iRound2, iRound3, iRound4).array());
        }

        private ByteBuffer getNinePatchChunk(int i, int i2, int i4, int i5) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
            byteBufferOrder.put((byte) 1);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 9);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(i);
            byteBufferOrder.putInt(i4);
            byteBufferOrder.putInt(i2);
            byteBufferOrder.putInt(i5);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            return byteBufferOrder;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            boolean zBooleanValue;
            try {
                zBooleanValue = ((Boolean) SprDrawable.mCanApplyTheme.invoke(this.mTint, null)).booleanValue();
            } catch (Exception unused) {
                zBooleanValue = false;
            }
            return this.mThemeAttrs != null || (this.mTint != null && zBooleanValue);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.mChangingConfigurations;
            ColorStateList colorStateList = this.mTint;
            return i | (colorStateList != null ? colorStateList.getChangingConfigurations() : 0);
        }

        public float getDensityScale() {
            SprDocument sprDocument = this.mDocument;
            return sprDocument == null ? (this.mDensityDpi / 160.0f) / 3.0f : (this.mDensityDpi / 160.0f) / sprDocument.mDensity;
        }

        public int getIntrinsicHeight() {
            float densityScale = getDensityScale();
            SprDocument sprDocument = this.mDocument;
            if (sprDocument != null) {
                return Math.round(sprDocument.mBottom * densityScale) - Math.round(this.mDocument.mTop * densityScale);
            }
            return 0;
        }

        public int getIntrinsicWidth() {
            float densityScale = getDensityScale();
            SprDocument sprDocument = this.mDocument;
            if (sprDocument != null) {
                return Math.round(sprDocument.mRight * densityScale) - Math.round(this.mDocument.mLeft * densityScale);
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new SprDrawable(this, null);
        }

        public void setDocument(SprDocument sprDocument) {
            String str;
            if (sprDocument == null) {
                return;
            }
            SprDocument sprDocument2 = this.mDocument;
            if (sprDocument2 == null || !((str = sprDocument2.mName) == null || str.equals(sprDocument.mName))) {
                this.mDocument = sprDocument;
                int i = 0;
                this.mNinePatch = (sprDocument.mNinePatchLeft == 0.0f && sprDocument.mNinePatchTop == 0.0f && sprDocument.mNinePatchRight == 0.0f && sprDocument.mNinePatchBottom == 0.0f) ? false : true;
                while (true) {
                    if (i < this.mDocument.getFileAttributeSize()) {
                        SprFileAttributeNinePatch sprFileAttributeNinePatch = (SprFileAttributeNinePatch) this.mDocument.getFileAttribute(i);
                        if (sprFileAttributeNinePatch != null && sprFileAttributeNinePatch.mType == 1) {
                            this.mNinePatch = true;
                            this.mMultiNinePatch = sprFileAttributeNinePatch;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                this.mDensityDpi = SprDrawable.getDeviceDensityDpi(null);
                SprCacheManager sprCacheManager = this.mCacheManager;
                if (sprCacheManager != null) {
                    if (SprDebug.IsDebug) {
                        sprCacheManager.printDebug();
                        new Exception().printStackTrace();
                    }
                    this.mCacheManager = null;
                }
                SprDocument sprDocument3 = this.mDocument;
                this.mCacheManager = new SprCacheManager(sprDocument3.mName, sprDocument3.hashCode());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new SprDrawable(this, resources);
        }

        public SprState(SprState sprState) {
            this.mDocument = null;
            this.mThemeAttrs = null;
            this.mNinePatch = false;
            this.mMultiNinePatch = null;
            this.mDensityDpi = 0;
            this.mCacheManager = null;
            this.mNinePatchRenderer = null;
            this.mNinePatchBitmap = null;
            this.mTint = null;
            this.mTintMode = PorterDuff.Mode.SRC_IN;
            this.mAutoMirrored = false;
            this.mGravity = 119;
            this.mRebuildShader = false;
            this.mTileModeX = null;
            this.mTileModeY = null;
            this.mDocument = sprState.mDocument;
            this.mThemeAttrs = sprState.mThemeAttrs;
            this.mNinePatch = sprState.mNinePatch;
            this.mBitmapPaint = new Paint(sprState.mBitmapPaint);
            if (sprState.mNinePatch && sprState.mNinePatchRenderer == null) {
                sprState.createNinePatchRenderer();
            }
            this.mCacheManager = sprState.mCacheManager;
            this.mNinePatchBitmap = sprState.mNinePatchBitmap;
            this.mNinePatchRenderer = sprState.mNinePatchRenderer;
            this.mMultiNinePatch = sprState.mMultiNinePatch;
            this.mTint = sprState.mTint;
            this.mTintMode = sprState.mTintMode;
            this.mAutoMirrored = sprState.mAutoMirrored;
            this.mGravity = sprState.mGravity;
            this.mChangingConfigurations = sprState.mChangingConfigurations;
            this.mRebuildShader = sprState.mRebuildShader;
            this.mTileModeX = sprState.mTileModeX;
            this.mTileModeY = sprState.mTileModeY;
            this.mDensityDpi = sprState.mDensityDpi;
        }

        private ByteBuffer getNinePatchChunk(SprFileAttributeNinePatch sprFileAttributeNinePatch) {
            float densityScale = getDensityScale();
            int i = sprFileAttributeNinePatch.xSize;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int i2 = sprFileAttributeNinePatch.ySize;
            int[] iArr3 = new int[i2];
            int[] iArr4 = new int[i2];
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            int i7 = -1;
            while (i5 < sprFileAttributeNinePatch.xSize) {
                int iRound = Math.round(sprFileAttributeNinePatch.xStart[i5] * densityScale);
                int iRound2 = Math.round(sprFileAttributeNinePatch.xEnd[i5] * densityScale);
                if (iRound2 <= iRound) {
                    iRound2 = iRound + 1;
                }
                if (iRound <= i7) {
                    iArr2[i6 - 1] = iRound2;
                } else {
                    iArr[i6] = iRound;
                    iArr2[i6] = iRound2;
                    i6++;
                }
                i5++;
                i7 = iRound2;
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < sprFileAttributeNinePatch.ySize) {
                int iRound3 = Math.round(sprFileAttributeNinePatch.yStart[i8] * densityScale);
                int iRound4 = Math.round(sprFileAttributeNinePatch.yEnd[i8] * densityScale);
                if (iRound4 <= iRound3) {
                    iRound4 = iRound3 + 1;
                }
                if (iRound3 <= i4) {
                    iArr4[i9 - 1] = iRound4;
                } else {
                    iArr3[i9] = iRound3;
                    iArr4[i9] = iRound4;
                    i9++;
                }
                i8++;
                i4 = iRound4;
            }
            int i10 = ((i9 * 2) + 1) * ((i6 * 2) + 1);
            ByteBuffer byteBufferOrder = ByteBuffer.allocate((i10 * 4) + (i9 * 8) + (i6 * 8) + 42).order(ByteOrder.nativeOrder());
            byteBufferOrder.put((byte) 1);
            byteBufferOrder.put((byte) (sprFileAttributeNinePatch.xSize * 2));
            byteBufferOrder.put((byte) (sprFileAttributeNinePatch.ySize * 2));
            byteBufferOrder.put((byte) i10);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            for (int i11 = 0; i11 < i6; i11++) {
                byteBufferOrder.putInt(iArr[i11]);
                byteBufferOrder.putInt(iArr2[i11]);
            }
            for (int i12 = 0; i12 < i9; i12++) {
                byteBufferOrder.putInt(iArr3[i12]);
                byteBufferOrder.putInt(iArr4[i12]);
            }
            for (int i13 = 0; i13 < i10; i13++) {
                byteBufferOrder.putInt(1);
            }
            return byteBufferOrder;
        }
    }

    static {
        Method declaredMethod;
        try {
            declaredMethod = Drawable.class.getDeclaredMethod("updateTintFilter", PorterDuffColorFilter.class, ColorStateList.class, PorterDuff.Mode.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        mUpdateTintFilter = declaredMethod;
        try {
            declaredMethod = Drawable.class.getMethod("parseTintMode", Integer.TYPE, PorterDuff.Mode.class);
        } catch (Exception unused2) {
        }
        mParseTintMode = declaredMethod;
        try {
            declaredMethod = Drawable.class.getMethod("getLayoutDirection", null);
        } catch (Exception unused3) {
        }
        mGetLayoutDirection = declaredMethod;
        try {
            declaredMethod = TypedArray.class.getDeclaredMethod("extractThemeAttrs", null);
        } catch (Exception unused4) {
        }
        mExtractThemeAttrs = declaredMethod;
        try {
            declaredMethod = Resources.Theme.class.getDeclaredMethod("resolveAttributes", int[].class, int[].class);
        } catch (Exception unused5) {
        }
        mResolveAttributes = declaredMethod;
        try {
            declaredMethod = ColorStateList.class.getDeclaredMethod("canApplyTheme", null);
        } catch (Exception unused6) {
        }
        mCanApplyTheme = declaredMethod;
    }

    public SprDrawable() {
        this.mState = null;
        this.mMutated = false;
        this.mCacheBitmap = null;
        this.mCacheDensityDpi = 0;
        this.mDocument = null;
        this.mTintFilter = null;
        this.mSprAnimation = null;
        this.mAnimationBitmap = null;
        this.mDstRect = new Rect();
        this.mMirrorMatrix = null;
        this.mIdentityMatrix = null;
        this.mTmpMatrix = new Matrix();
        this.mTmpFloats = new float[9];
        this.mState = new SprState(this.mDocument);
    }

    public static SprDrawable createFromPathName(String str) {
        FileInputStream fileInputStream;
        Exception e;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e2) {
            fileInputStream = null;
            e = e2;
        }
        try {
            SprDocument sprDocumentCreateFromStreamInternal = createFromStreamInternal(str, fileInputStream);
            fileInputStream.close();
            return new SprDrawable(sprDocumentCreateFromStreamInternal);
        } catch (Exception e3) {
            e = e3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            e.printStackTrace();
            return getErrorDrawable(str);
        }
    }

    public static SprDrawable createFromResourceStream(Resources resources, int i) {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
        } catch (Exception e) {
            e = e;
            inputStreamOpenRawResource = null;
        }
        try {
            SprDocument sprDocumentCreateFromStreamInternal = createFromStreamInternal(resources.getString(i), inputStreamOpenRawResource);
            inputStreamOpenRawResource.close();
            SprDrawable sprDrawable = new SprDrawable(sprDocumentCreateFromStreamInternal);
            sprDrawable.updateLocalState(resources);
            return sprDrawable;
        } catch (Exception e2) {
            e = e2;
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            e.printStackTrace();
            return getErrorDrawable(resources.getString(i));
        }
    }

    @Deprecated
    public static SprDrawable createFromStream(InputStream inputStream) {
        return createFromStream(NA_NAME, inputStream);
    }

    private static SprDocument createFromStreamInternal(String str, InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = new byte[3];
        if (str == null) {
            str = NA_NAME;
        }
        bufferedInputStream.mark(3);
        if (bufferedInputStream.read(bArr) < 3) {
            bufferedInputStream.close();
            throw new IOException("file is too short");
        }
        bufferedInputStream.reset();
        byte b = bArr[0];
        if ((b == 83 && bArr[1] == 86 && bArr[2] == 70) || (b == 83 && bArr[1] == 80 && bArr[2] == 82)) {
            return new SprDocument(str, bufferedInputStream);
        }
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(bufferedInputStream, null);
            return new SprDocument(str, xmlPullParserNewPullParser);
        } catch (XmlPullParserException e) {
            throw new IOException(e.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDeviceDensityDpi(Resources resources) {
        return resources == null ? Resources.getSystem().getDisplayMetrics().densityDpi : resources.getDisplayMetrics().densityDpi;
    }

    private static SprDrawable getErrorDrawable(String str) {
        float f = 350;
        float f4 = 275;
        SprDocument sprDocument = new SprDocument(str, 0.0f, 0.0f, f, f4);
        float f5 = 50;
        float f6 = 200;
        SprObjectShapeRectangle sprObjectShapeRectangle = new SprObjectShapeRectangle(0.0f, 0.0f, f5, f6);
        sprObjectShapeRectangle.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 200, 200, 200)));
        sprDocument.appendObject(sprObjectShapeRectangle);
        float f7 = 100;
        SprObjectShapeRectangle sprObjectShapeRectangle2 = new SprObjectShapeRectangle(f5, 0.0f, f7, f6);
        sprObjectShapeRectangle2.appendAttribute(new SprAttributeFill((byte) 1, -256));
        sprDocument.appendObject(sprObjectShapeRectangle2);
        float f8 = 150;
        SprObjectShapeRectangle sprObjectShapeRectangle3 = new SprObjectShapeRectangle(f7, 0.0f, f8, f6);
        sprObjectShapeRectangle3.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 255, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle3);
        SprObjectShapeRectangle sprObjectShapeRectangle4 = new SprObjectShapeRectangle(f8, 0.0f, f6, f6);
        sprObjectShapeRectangle4.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 255, 0)));
        sprDocument.appendObject(sprObjectShapeRectangle4);
        float f9 = 250;
        SprObjectShapeRectangle sprObjectShapeRectangle5 = new SprObjectShapeRectangle(f6, 0.0f, f9, f6);
        sprObjectShapeRectangle5.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 255, 0, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle5);
        float f10 = 300;
        SprObjectShapeRectangle sprObjectShapeRectangle6 = new SprObjectShapeRectangle(f9, 0.0f, f10, f6);
        sprObjectShapeRectangle6.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 255, 0, 0)));
        sprDocument.appendObject(sprObjectShapeRectangle6);
        SprObjectShapeRectangle sprObjectShapeRectangle7 = new SprObjectShapeRectangle(f10, 0.0f, f, f6);
        sprObjectShapeRectangle7.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 0, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle7);
        float f11 = JPEG.APP1;
        SprObjectShapeRectangle sprObjectShapeRectangle8 = new SprObjectShapeRectangle(0.0f, f6, f5, f11);
        sprObjectShapeRectangle8.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 0, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle8);
        SprObjectShapeRectangle sprObjectShapeRectangle9 = new SprObjectShapeRectangle(f5, f6, f7, f11);
        sprObjectShapeRectangle9.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 0, 0)));
        sprDocument.appendObject(sprObjectShapeRectangle9);
        SprObjectShapeRectangle sprObjectShapeRectangle10 = new SprObjectShapeRectangle(f7, f6, f8, f11);
        sprObjectShapeRectangle10.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 255, 0, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle10);
        SprObjectShapeRectangle sprObjectShapeRectangle11 = new SprObjectShapeRectangle(f8, f6, f6, f11);
        sprObjectShapeRectangle11.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 0, 0)));
        sprDocument.appendObject(sprObjectShapeRectangle11);
        SprObjectShapeRectangle sprObjectShapeRectangle12 = new SprObjectShapeRectangle(f6, f6, f9, f11);
        sprObjectShapeRectangle12.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 255, 255)));
        sprDocument.appendObject(sprObjectShapeRectangle12);
        SprObjectShapeRectangle sprObjectShapeRectangle13 = new SprObjectShapeRectangle(f9, f6, f10, f11);
        sprObjectShapeRectangle13.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 0, 0, 0)));
        sprDocument.appendObject(sprObjectShapeRectangle13);
        SprObjectShapeRectangle sprObjectShapeRectangle14 = new SprObjectShapeRectangle(f10, f6, f, f11);
        sprObjectShapeRectangle14.appendAttribute(new SprAttributeFill((byte) 1, Color.argb(255, 200, 200, 200)));
        sprDocument.appendObject(sprObjectShapeRectangle14);
        SprObjectShapeRectangle sprObjectShapeRectangle15 = new SprObjectShapeRectangle(0.0f, f11, f, f4);
        SprLinearGradient sprLinearGradient = new SprLinearGradient();
        sprLinearGradient.spreadMode = (byte) 1;
        sprLinearGradient.f5442x1 = 0.0f;
        sprLinearGradient.f5444y1 = f11;
        sprLinearGradient.f5443x2 = f;
        sprLinearGradient.f5445y2 = f11;
        sprLinearGradient.colors = new int[]{-1, -16777216};
        sprLinearGradient.positions = new float[]{0.0f, 1.0f};
        sprLinearGradient.updateGradient();
        sprObjectShapeRectangle15.appendAttribute(new SprAttributeFill((byte) 3, sprLinearGradient));
        sprDocument.appendObject(sprObjectShapeRectangle15);
        return new SprDrawable(sprDocument) { // from class: com.samsung.android.spr.drawable.SprDrawable.1
            @Override // com.samsung.android.spr.drawable.SprDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                super.draw(canvas);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextSize(20.0f);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(-16777216);
                paint.setStrokeWidth(4.0f);
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setTextSize(20.0f);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(-1);
                canvas.drawText(this.mDocument.mName, 5.0f, 40.0f, paint);
                canvas.drawText(this.mDocument.mName, 5.0f, 40.0f, paint2);
            }
        };
    }

    public static int getVersion() {
        return mVersion;
    }

    private boolean needMirroring() {
        return isAutoMirrored() && ((Integer) mGetLayoutDirection.invoke(this, null)).intValue() == 1;
    }

    private static Shader.TileMode parseTileMode(int i) {
        if (i == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    public static TypedArray sprObtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private void updateCachedBitmap(int i, int i2, int i4) {
        Bitmap bitmap = this.mCacheBitmap;
        if ((bitmap != null && bitmap.getWidth() == i && this.mCacheBitmap.getHeight() == i2 && this.mCacheDensityDpi == i4) || this.mDocument == null) {
            return;
        }
        if (this.mCacheBitmap != null) {
            this.mState.mCacheManager.unlock(this.mCacheBitmap);
            this.mCacheBitmap = null;
            this.mCacheDensityDpi = 0;
        }
        Bitmap cache = this.mState.mCacheManager.getCache(i, i2, i4);
        this.mCacheBitmap = cache;
        this.mCacheDensityDpi = i4;
        if (cache == null) {
            synchronized (this.mDocument) {
                try {
                    if (!this.mDocument.isPredraw()) {
                        this.mDocument.preDraw(0);
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    this.mCacheBitmap = bitmapCreateBitmap;
                    if (bitmapCreateBitmap != null) {
                        this.mDocument.draw(new Canvas(this.mCacheBitmap), i, i2, 0, this.mState.mDensityDpi);
                        this.mState.mCacheManager.addCache(this.mCacheBitmap, this.mCacheDensityDpi);
                    }
                } finally {
                }
            }
        }
        this.mState.mCacheManager.lock(this.mCacheBitmap);
    }

    private void updateDensity(Resources resources) {
        int deviceDensityDpi = getDeviceDensityDpi(resources);
        if (this.mState.mDensityDpi != deviceDensityDpi) {
            this.mState.mDensityDpi = deviceDensityDpi;
            if (this.mCacheBitmap != null) {
                this.mState.mCacheManager.unlock(this.mCacheBitmap);
                this.mCacheBitmap = null;
                this.mCacheDensityDpi = 0;
            }
            this.mState.mNinePatchRenderer = null;
            this.mState.mNinePatchBitmap = null;
        }
    }

    private void updateDstRectAndInsetsIfDirty() {
        if (this.mState.mTileModeX != null || this.mState.mTileModeY != null) {
            copyBounds(this.mDstRect);
            return;
        }
        try {
            Gravity.apply(this.mState.mGravity, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.mDstRect, ((Integer) mGetLayoutDirection.invoke(this, null)).intValue());
        } catch (Exception unused) {
        }
    }

    private void updateLocalState(Resources resources) {
        setTintList(this.mState.mTint);
        updateDensity(resources);
        if (this.mDocument != null) {
            float densityScale = this.mState.getDensityScale();
            super.setBounds(Math.round(this.mDocument.mLeft * densityScale), Math.round(this.mDocument.mTop * densityScale), Math.round(this.mDocument.mRight * densityScale), Math.round(this.mDocument.mBottom * densityScale));
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws IOException {
        InputStream inputStreamOpenRawResource;
        Resources resources = typedArray.getResources();
        SprState sprState = this.mState;
        sprState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        InputStream inputStream = null;
        try {
            sprState.mThemeAttrs = (int[]) mExtractThemeAttrs.invoke(typedArray, null);
        } catch (Exception unused) {
            sprState.mThemeAttrs = null;
        }
        int resourceId = typedArray.getResourceId(R.styleable.SprDrawable_src, 0);
        if (resourceId != 0) {
            try {
                inputStreamOpenRawResource = resources.openRawResource(resourceId);
            } catch (Exception e) {
                e = e;
            }
            try {
                this.mState.setDocument(createFromStreamInternal(resources.getString(resourceId), inputStreamOpenRawResource));
                this.mDocument = this.mState.mDocument;
                inputStreamOpenRawResource.close();
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStreamOpenRawResource;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw new IOException(e);
            }
        }
        int i = typedArray.getInt(R.styleable.SprDrawable_tintMode, -1);
        if (i != -1) {
            try {
                this.mState.mTintMode = (PorterDuff.Mode) mParseTintMode.invoke(null, Integer.valueOf(i), PorterDuff.Mode.SRC_IN);
            } catch (Exception unused2) {
                this.mState.mTintMode = PorterDuff.Mode.SRC_IN;
            }
        }
        ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.SprDrawable_tint);
        if (colorStateList != null) {
            this.mState.mTint = colorStateList;
        }
        this.mState.mGravity = typedArray.getInt(R.styleable.SprDrawable_gravity, 119);
        this.mState.mAutoMirrored = typedArray.getBoolean(R.styleable.SprDrawable_autoMirrored, this.mState.mAutoMirrored);
        this.mState.mBitmapPaint.setAlpha((int) (typedArray.getFloat(R.styleable.SprDrawable_alpha, 1.0f) * 255.0f));
        int i2 = typedArray.getInt(R.styleable.SprDrawable_tileMode, -2);
        if (i2 != -2) {
            Shader.TileMode tileMode = parseTileMode(i2);
            setTileModeXY(tileMode, tileMode);
        }
        int i4 = typedArray.getInt(R.styleable.SprDrawable_tileModeX, -2);
        if (i4 != -2) {
            setTileModeX(parseTileMode(i4));
        }
        int i5 = typedArray.getInt(R.styleable.SprDrawable_tileModeY, -2);
        if (i5 != -2) {
            setTileModeY(parseTileMode(i5));
        }
        updateDensity(resources);
    }

    private PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) throws Throwable {
        TypedArray typedArray;
        super.applyTheme(theme);
        SprState sprState = this.mState;
        if (sprState == null) {
            return;
        }
        if (sprState.mThemeAttrs != null) {
            TypedArray typedArray2 = null;
            try {
                try {
                    typedArray = (TypedArray) mResolveAttributes.invoke(theme, sprState.mThemeAttrs, R.styleable.SprDrawable);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    updateStateFromTypedArray(typedArray);
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                } catch (XmlPullParserException e) {
                    e = e;
                    throw new RuntimeException(e);
                } catch (Exception unused) {
                    typedArray2 = typedArray;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray2 = typedArray;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
            } catch (XmlPullParserException e2) {
                e = e2;
            } catch (Exception unused2) {
            }
        }
        updateLocalState(theme.getResources());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        SprState sprState = this.mState;
        return sprState != null && sprState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int intrinsicWidth;
        int intrinsicHeight;
        Canvas canvas2;
        if (this.mDstRect.width() <= 0 || this.mDstRect.height() <= 0 || this.mDocument == null) {
            return;
        }
        boolean z = true;
        if (this.mState.mTileModeX == null && this.mState.mTileModeY == null) {
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float fAbs = Math.abs(this.mTmpFloats[0]);
            float fAbs2 = Math.abs(this.mTmpFloats[4]);
            float[] fArr = this.mTmpFloats;
            if (fArr[1] == 0.0f && fArr[3] == 0.0f) {
                intrinsicWidth = Math.min(2048, (int) (this.mDstRect.width() * fAbs));
                intrinsicHeight = Math.min(2048, (int) (this.mDstRect.height() * fAbs2));
            } else {
                Bitmap bitmap = this.mCacheBitmap;
                if (bitmap != null) {
                    intrinsicWidth = bitmap.getWidth();
                    intrinsicHeight = this.mCacheBitmap.getHeight();
                } else {
                    intrinsicWidth = this.mDstRect.width();
                    intrinsicHeight = this.mDstRect.height();
                }
            }
        } else {
            intrinsicWidth = getIntrinsicWidth();
            intrinsicHeight = getIntrinsicHeight();
        }
        int i = intrinsicWidth;
        int i2 = intrinsicHeight;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        boolean zIsRunning = isRunning();
        Paint paint = this.mState.mBitmapPaint;
        synchronized (this.mState) {
            try {
                if (this.mState.mNinePatch) {
                    if (this.mState.mNinePatchRenderer == null) {
                        this.mState.createNinePatchRenderer();
                    }
                } else if (zIsRunning) {
                    int animationIndex = this.mSprAnimation.getAnimationIndex();
                    synchronized (this.mDocument) {
                        try {
                            this.mDocument.preDraw(animationIndex);
                            Bitmap bitmap2 = this.mAnimationBitmap;
                            if (bitmap2 != null && bitmap2.getWidth() == i && this.mAnimationBitmap.getHeight() == i2) {
                                canvas2 = new Canvas(this.mAnimationBitmap);
                                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                            } else {
                                this.mAnimationBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                                canvas2 = new Canvas(this.mAnimationBitmap);
                            }
                            this.mDocument.draw(canvas2, i, i2, animationIndex, this.mState.mDensityDpi);
                        } finally {
                        }
                    }
                } else {
                    updateCachedBitmap(i, i2, this.mState.mDensityDpi);
                }
                if (this.mState.mRebuildShader || zIsRunning) {
                    if (this.mState.mTileModeX == null && this.mState.mTileModeY == null) {
                        paint.setShader(null);
                    } else {
                        Shader.TileMode tileMode = this.mState.mTileModeX;
                        Shader.TileMode tileMode2 = this.mState.mTileModeY;
                        Bitmap bitmap3 = this.mAnimationBitmap;
                        if (bitmap3 == null) {
                            bitmap3 = this.mCacheBitmap;
                        }
                        if (tileMode == null) {
                            tileMode = Shader.TileMode.CLAMP;
                        }
                        if (tileMode2 == null) {
                            tileMode2 = Shader.TileMode.CLAMP;
                        }
                        paint.setShader(new BitmapShader(bitmap3, tileMode, tileMode2));
                    }
                    this.mState.mRebuildShader = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.mTintFilter == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.mTintFilter);
        }
        Shader shader = paint.getShader();
        boolean zNeedMirroring = needMirroring();
        if (shader != null) {
            if (zNeedMirroring) {
                if (this.mMirrorMatrix == null) {
                    this.mMirrorMatrix = new Matrix();
                }
                Matrix matrix = this.mMirrorMatrix;
                Rect rect = this.mDstRect;
                matrix.setTranslate(rect.right - rect.left, 0.0f);
                this.mMirrorMatrix.preScale(-1.0f, 1.0f);
                shader.setLocalMatrix(this.mMirrorMatrix);
                paint.setShader(shader);
            } else if (this.mMirrorMatrix != null) {
                this.mMirrorMatrix = null;
                if (this.mIdentityMatrix == null) {
                    this.mIdentityMatrix = new Matrix();
                }
                shader.setLocalMatrix(this.mIdentityMatrix);
                paint.setShader(shader);
            }
            canvas.drawRect(this.mDstRect, paint);
        } else if (!this.mState.mNinePatch) {
            if (zNeedMirroring) {
                canvas.save();
                Rect rect2 = this.mDstRect;
                canvas.translate(rect2.right - rect2.left, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            Bitmap bitmap4 = this.mAnimationBitmap;
            if (bitmap4 == null) {
                bitmap4 = this.mCacheBitmap;
            }
            canvas.drawBitmap(bitmap4, (Rect) null, this.mDstRect, paint);
            if (zIsRunning) {
                this.mSprAnimation.update();
            }
            if (zNeedMirroring) {
                canvas.restore();
            }
        } else if (this.mState.mNinePatchRenderer != null) {
            this.mState.mNinePatchRenderer.draw(canvas, this.mDstRect, paint);
        }
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        stop();
        if (this.mCacheBitmap != null) {
            this.mState.mCacheManager.unlock(this.mCacheBitmap);
            this.mCacheBitmap = null;
            this.mCacheDensityDpi = 0;
        }
        this.mState = null;
        this.mDocument = null;
        this.mTintFilter = null;
        this.mSprAnimation = null;
        this.mAnimationBitmap = null;
        this.mDstRect = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mState.mBitmapPaint.getAlpha();
    }

    public Bitmap getBitmap() {
        updateCachedBitmap(getIntrinsicWidth(), getIntrinsicHeight(), this.mState.mDensityDpi);
        return this.mCacheBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mState.mBitmapPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mState.mChangingConfigurations |= getChangingConfigurations();
        return this.mState;
    }

    public SprDocument getDocument() {
        return this.mDocument;
    }

    public int getGravity() {
        return this.mState.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mState.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mState.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.mState.mGravity == 119 && (bitmap = this.mCacheBitmap) != null && !bitmap.hasAlpha() && this.mState.mBitmapPaint.getAlpha() >= 255) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.mDocument == null) {
            rect.set(0, 0, 0, 0);
            return false;
        }
        float densityScale = this.mState.getDensityScale();
        rect.set(Math.round(this.mDocument.mPaddingLeft * densityScale), Math.round(this.mDocument.mPaddingTop * densityScale), Math.round(this.mDocument.mPaddingRight * densityScale), Math.round(this.mDocument.mPaddingBottom * densityScale));
        SprDocument sprDocument = this.mDocument;
        return (sprDocument.mPaddingLeft == 0.0f || sprDocument.mPaddingTop == 0.0f || sprDocument.mPaddingRight == 0.0f || sprDocument.mPaddingBottom == 0.0f) ? false : true;
    }

    public Shader.TileMode getTileModeX() {
        return this.mState.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        return this.mState.mTileModeY;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        SprDrawableAnimation sprDrawableAnimation = this.mSprAnimation;
        return sprDrawableAnimation != null && sprDrawableAnimation.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        SprState sprState = this.mState;
        return (sprState == null || sprState.mTint == null || !this.mState.mTint.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState = new SprState(this.mState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateDstRectAndInsetsIfDirty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        SprState sprState = this.mState;
        if (sprState.mTint == null || sprState.mTintMode == null) {
            return false;
        }
        this.mTintFilter = updateTintFilterInternal(this.mTintFilter, sprState.mTint, sprState.mTintMode);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mState.mBitmapPaint.getAlpha()) {
            this.mState.mBitmapPaint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.mState.mAutoMirrored != z) {
            this.mState.mAutoMirrored = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mState.mBitmapPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.mState.mGravity != i) {
            this.mState.mGravity = i;
            updateDstRectAndInsetsIfDirty();
            invalidateSelf();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        setTileModeXY(tileMode, this.mState.mTileModeY);
    }

    public void setTileModeXY(Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        SprState sprState = this.mState;
        if (sprState.mTileModeX == tileMode && sprState.mTileModeY == tileMode2) {
            return;
        }
        sprState.mTileModeX = tileMode;
        sprState.mTileModeY = tileMode2;
        sprState.mRebuildShader = true;
        updateDstRectAndInsetsIfDirty();
        invalidateSelf();
    }

    public final void setTileModeY(Shader.TileMode tileMode) {
        setTileModeXY(this.mState.mTileModeX, tileMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        SprState sprState = this.mState;
        sprState.mTint = colorStateList;
        this.mTintFilter = updateTintFilterInternal(this.mTintFilter, sprState.mTint, sprState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        SprState sprState = this.mState;
        sprState.mTintMode = mode;
        this.mTintFilter = updateTintFilterInternal(this.mTintFilter, sprState.mTint, sprState.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        stop();
        SprDocument sprDocument = this.mDocument;
        if (sprDocument == null) {
            return;
        }
        if (sprDocument.getFrameAnimationCount() > 1) {
            this.mSprAnimation = new SprDrawableAnimationFrame(this, this.mDocument);
        } else if (this.mDocument.getValueAnimationObjects().size() > 0) {
            if (this.mDocument.isIntrinsic()) {
                try {
                    this.mDocument = this.mDocument.m22165clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.mSprAnimation = new SprDrawableAnimationValue(this, this.mDocument);
        }
        SprDrawableAnimation sprDrawableAnimation = this.mSprAnimation;
        if (sprDrawableAnimation != null) {
            sprDrawableAnimation.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        SprDrawableAnimation sprDrawableAnimation = this.mSprAnimation;
        if (sprDrawableAnimation != null) {
            sprDrawableAnimation.stop();
            this.mSprAnimation = null;
        }
    }

    public void toSPR(OutputStream outputStream) throws IOException {
        SprDocument sprDocument = this.mDocument;
        if (sprDocument != null) {
            sprDocument.toSPR(outputStream);
        }
    }

    public String toString() {
        if (this.mDocument == null) {
            return "SprDocument is null";
        }
        return this.mDocument.mLeft + "," + this.mDocument.mTop + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.mDocument.mRight + "," + this.mDocument.mBottom + "\nLoading:" + this.mDocument.getLoadingTime() + "ms\nElement:" + this.mDocument.getTotalElementCount() + "\nSegment:" + this.mDocument.getTotalSegmentCount() + "\nAttribute:" + this.mDocument.getTotalAttributeCount();
    }

    public PorterDuffColorFilter updateTintFilterInternal(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter2;
        Method method = mUpdateTintFilter;
        if (method == null) {
            return updateTintFilter(porterDuffColorFilter, colorStateList, mode);
        }
        method.setAccessible(true);
        try {
            porterDuffColorFilter2 = (PorterDuffColorFilter) method.invoke(this, porterDuffColorFilter, colorStateList, mode);
        } catch (Exception unused) {
            porterDuffColorFilter2 = null;
        }
        mUpdateTintFilter.setAccessible(false);
        return porterDuffColorFilter2;
    }

    public static SprDrawable createFromStream(String str, InputStream inputStream) {
        return createFromStream(str, inputStream, null);
    }

    @Override // android.graphics.drawable.Drawable
    @SuppressLint({WarningType.NewApi})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArraySprObtainAttributes = sprObtainAttributes(resources, theme, attributeSet, R.styleable.SprDrawable);
        updateStateFromTypedArray(typedArraySprObtainAttributes);
        typedArraySprObtainAttributes.recycle();
        updateLocalState(resources);
    }

    public static SprDrawable createFromStream(String str, InputStream inputStream, Resources resources) {
        try {
            SprDrawable sprDrawable = new SprDrawable(createFromStreamInternal(str, inputStream));
            if (resources == null) {
                return sprDrawable;
            }
            sprDrawable.updateLocalState(resources);
            return sprDrawable;
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorDrawable(str);
        }
    }

    public SprDrawable(SprDocument sprDocument) {
        this.mState = null;
        this.mMutated = false;
        this.mCacheBitmap = null;
        this.mCacheDensityDpi = 0;
        this.mDocument = null;
        this.mTintFilter = null;
        this.mSprAnimation = null;
        this.mAnimationBitmap = null;
        this.mDstRect = new Rect();
        this.mMirrorMatrix = null;
        this.mIdentityMatrix = null;
        this.mTmpMatrix = new Matrix();
        this.mTmpFloats = new float[9];
        SprState sprState = new SprState(sprDocument);
        this.mState = sprState;
        SprDocument sprDocument2 = sprState.mDocument;
        this.mDocument = sprDocument2;
        if (sprDocument2 != null) {
            float densityScale = this.mState.getDensityScale();
            super.setBounds(Math.round(this.mDocument.mLeft * densityScale), Math.round(this.mDocument.mTop * densityScale), Math.round(this.mDocument.mRight * densityScale), Math.round(this.mDocument.mBottom * densityScale));
        }
    }

    public SprDrawable(SprState sprState, Resources resources) {
        this.mState = null;
        this.mMutated = false;
        this.mCacheBitmap = null;
        this.mCacheDensityDpi = 0;
        this.mDocument = null;
        this.mTintFilter = null;
        this.mSprAnimation = null;
        this.mAnimationBitmap = null;
        this.mDstRect = new Rect();
        this.mMirrorMatrix = null;
        this.mIdentityMatrix = null;
        this.mTmpMatrix = new Matrix();
        this.mTmpFloats = new float[9];
        this.mState = sprState;
        SprDocument sprDocument = sprState.mDocument;
        this.mDocument = sprDocument;
        if (sprDocument != null) {
            float densityScale = this.mState.getDensityScale();
            super.setBounds(Math.round(this.mDocument.mLeft * densityScale), Math.round(this.mDocument.mTop * densityScale), Math.round(this.mDocument.mRight * densityScale), Math.round(this.mDocument.mBottom * densityScale));
            this.mTintFilter = updateTintFilterInternal(this.mTintFilter, sprState.mTint, sprState.mTintMode);
        }
        if (resources != null) {
            updateLocalState(resources);
        }
    }
}
