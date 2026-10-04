package com.samsung.android.support.senl.document.memoconverter.core.Html;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ReplacementSpan;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.WindowManager;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.support.senl.document.C7991R;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.Html.ClickableSpanType;
import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlImageSpan extends ReplacementSpan implements ClickableSpanType {
    public static float ALPHA_CHECKBOX = 0.0f;
    public static final float ALPHA_CHECKED = 0.3f;
    public static final float ALPHA_NONE = 1.0f;
    private static int EXTRA_BOTTOM_MARGIN = 0;
    private static int EXTRA_TOP_MARGIN = 0;
    public static final int IMAGE_BOUND_PADDING_OFFSET = 1;
    private static int IMAGE_MARGIN = 0;
    public static final int MAX_IMAGE_ALPHA_VALUE = 255;
    public static int MAX_WIDTH = 0;
    public static int MAX_WIDTH_WITH_BIGGER_HEIGHT = 0;
    public static float SCALE_CHECKBOX = 0.0f;
    public static final float SCALE_CHECKED = 0.3f;
    public static final float SCALE_NONE = 1.0f;
    private static final String TAG = "HtmlImageSpan";
    private static final int mCacheSize;
    private static Drawable mImageNotFoundDrawable;
    private static final int mMaxMemory;
    private static LruCache<Uri, Bitmap> mMemoryCache;
    static int width;
    private String mAltText;
    private Uri mContentUri;
    private Context mContext;
    private float mImageAlpha;
    private float mImageScale;
    private boolean mIsLoaded;
    private int mLeftBound;
    private ClickableSpanType.OnClickListener mListener;
    private int mOrientation;
    private int mSpanEnd;
    private int mSpanStart;

    static {
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        mMaxMemory = iMaxMemory;
        int i = iMaxMemory / 4;
        mCacheSize = i;
        width = 0;
        mMemoryCache = new LruCache<Uri, Bitmap>(i) { // from class: com.samsung.android.support.senl.document.memoconverter.core.Html.HtmlImageSpan.1
            @Override // android.util.LruCache
            public void entryRemoved(boolean z, Uri uri, Bitmap bitmap, Bitmap bitmap2) {
                super.entryRemoved(z, uri, bitmap, bitmap2);
                if (z) {
                    bitmap.recycle();
                }
            }

            @Override // android.util.LruCache
            public int sizeOf(Uri uri, Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
    }

    public HtmlImageSpan(Context context, Uri uri, int i, String str) {
        this.mImageScale = 1.0f;
        this.mImageAlpha = 1.0f;
        this.mListener = null;
        DocumentLogger.m7178d(TAG, "HtmlImageSpan()");
        this.mContext = context;
        this.mContentUri = uri;
        this.mOrientation = i;
        this.mAltText = Uri.decode(str);
        DocumentLogger.m7178d(TAG, "MAX_WIDTH=" + MAX_WIDTH);
        int i2 = this.mOrientation;
        if (i2 != 0 && i2 != 90 && i2 != 180 && i2 != 270) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "unable to proceed given orientaion: "));
        }
    }

    public static void addBitMapToCache(Context context, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            if (ImageUtil.isDrawingMemo(context, uri)) {
                bitmap = addBoundary(bitmap);
            }
            LruCache<Uri, Bitmap> lruCache = mMemoryCache;
            if (lruCache != null) {
                lruCache.put(uri, bitmap);
            }
        }
    }

    private static Bitmap addBoundary(Bitmap bitmap) {
        float f = 2;
        RectF rectF = new RectF(f, f, bitmap.getWidth() + 2, bitmap.getHeight() + 2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() + 4, bitmap.getHeight() + 4, bitmap.getConfig());
        if (bitmapCreateBitmap != null) {
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(Color.parseColor("#d4d4d4"));
            canvas.drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        return bitmapCreateBitmap;
    }

    public static void flushCache() {
        LruCache<Uri, Bitmap> lruCache = mMemoryCache;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public static Bitmap getBitMapFromCache(Uri uri) {
        LruCache<Uri, Bitmap> lruCache = mMemoryCache;
        if (lruCache != null) {
            return lruCache.get(uri);
        }
        return null;
    }

    private Drawable getDrawable() throws Throwable {
        LruCache<Uri, Bitmap> lruCache;
        this.mIsLoaded = false;
        Uri uri = this.mContentUri;
        BitmapDrawable bitmapDrawable = null;
        if (uri != null) {
            LruCache<Uri, Bitmap> lruCache2 = mMemoryCache;
            Bitmap drawableFromLocalUri = lruCache2 != null ? lruCache2.get(uri) : null;
            if (drawableFromLocalUri != null && !drawableFromLocalUri.isRecycled()) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.mContext.getResources(), drawableFromLocalUri);
                bitmapDrawable2.setFilterBitmap(true);
                width = ((int) (bitmapDrawable2.getIntrinsicWidth() * this.mImageScale)) - 1;
                bitmapDrawable2.setBounds(0, 0, ((int) (bitmapDrawable2.getIntrinsicWidth() * this.mImageScale)) - 1, ((int) (bitmapDrawable2.getIntrinsicHeight() * this.mImageScale)) - 1);
                bitmapDrawable2.setAlpha((int) (this.mImageAlpha * 255.0f));
                return bitmapDrawable2;
            }
            String scheme = this.mContentUri.getScheme();
            if ("content".equals(scheme) || "file".equals(scheme)) {
                drawableFromLocalUri = getDrawableFromLocalUri();
                bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), drawableFromLocalUri);
                bitmapDrawable.setFilterBitmap(true);
                bitmapDrawable.setBounds(0, 0, (int) (bitmapDrawable.getIntrinsicWidth() * this.mImageScale), (int) (bitmapDrawable.getIntrinsicHeight() * this.mImageScale));
                width = ((int) (bitmapDrawable.getIntrinsicWidth() * this.mImageScale)) - 1;
                bitmapDrawable.setAlpha((int) (this.mImageAlpha * 255.0f));
            } else if ("http".equals(scheme) || AuthenticationConstants.HTTPS_PROTOCOL_STRING.equals(scheme)) {
                drawableFromLocalUri = getDrawableFromRemoteUri();
            }
            boolean z = bitmapDrawable != null;
            this.mIsLoaded = z;
            if (z && drawableFromLocalUri != null && (lruCache = mMemoryCache) != null) {
                lruCache.put(this.mContentUri, drawableFromLocalUri);
            }
        }
        return this.mIsLoaded ? bitmapDrawable : mImageNotFoundDrawable;
    }

    private Bitmap getDrawableFromLocalUri() throws Throwable {
        DocumentLogger.m7178d(TAG, "getDrawableFromLocalUri() uri: " + this.mContentUri);
        try {
            int actualImageWidth = ImageUtil.getActualImageWidth(this.mContext, this.mContentUri, this.mOrientation);
            Bitmap bitmapDecodeImageScaledIf = ImageUtil.decodeImageScaledIf(this.mContext, this.mContentUri, actualImageWidth, this.mOrientation, actualImageWidth >= ImageUtil.getActualImageHeight(this.mContext, this.mContentUri, this.mOrientation) ? MAX_WIDTH : MAX_WIDTH_WITH_BIGGER_HEIGHT);
            return ImageUtil.isDrawingMemo(this.mContext, this.mContentUri) ? addBoundary(bitmapDecodeImageScaledIf) : bitmapDecodeImageScaledIf;
        } catch (IOException e) {
            DocumentLogger.m7180e(TAG, "Failed to loaded content " + this.mContentUri, e);
            return null;
        }
    }

    private Bitmap getDrawableFromRemoteUri() {
        return null;
    }

    public static int getMaxWidth() {
        DocumentLogger.m7178d(TAG, "getMaxWidth()" + width);
        return width;
    }

    public static void init(Context context) {
        Drawable drawable = Spr.getDrawable(context.getResources(), C7991R.drawable.composer_image_not_found, null);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mImageNotFoundDrawable = drawable;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        MAX_WIDTH_WITH_BIGGER_HEIGHT = i;
        MAX_WIDTH = i;
        width = i;
        SCALE_CHECKBOX = 0.0f;
        ALPHA_CHECKBOX = 0.0f;
        IMAGE_MARGIN = 0;
        EXTRA_TOP_MARGIN = 0;
        EXTRA_BOTTOM_MARGIN = 0;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        int i2 = displayMetrics2.widthPixels;
        MAX_WIDTH_WITH_BIGGER_HEIGHT = i2;
        MAX_WIDTH = i2;
        width = i2;
        SCALE_CHECKBOX = 0.0f;
        ALPHA_CHECKBOX = 0.0f;
        IMAGE_MARGIN = 0;
        EXTRA_TOP_MARGIN = 0;
        EXTRA_BOTTOM_MARGIN = 0;
    }

    public static void removeBitmapFromCache(Uri uri) {
        LruCache<Uri, Bitmap> lruCache = mMemoryCache;
        if (lruCache != null) {
            lruCache.remove(uri);
        }
    }

    public static void trimMemory() {
        LruCache<Uri, Bitmap> lruCache = mMemoryCache;
        if (lruCache != null) {
            lruCache.trimToSize(mCacheSize / 2);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i4, int i5, int i6, Paint paint) throws Throwable {
        Drawable drawable = getDrawable();
        canvas.save();
        this.mSpanStart = i;
        this.mSpanEnd = i2;
        int i7 = ((i5 - drawable.getBounds().bottom) - EXTRA_TOP_MARGIN) + EXTRA_BOTTOM_MARGIN;
        int i8 = (int) (f + IMAGE_MARGIN);
        this.mLeftBound = i8;
        canvas.translate(i8, i7);
        drawable.draw(canvas);
        canvas.restore();
    }

    public Uri getContentUri() {
        return this.mContentUri;
    }

    public int getLeftBound() {
        return this.mLeftBound;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mContext == null) {
            return 0;
        }
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            int i4 = (-bounds.bottom) - EXTRA_TOP_MARGIN;
            fontMetricsInt.ascent = i4;
            int i5 = EXTRA_BOTTOM_MARGIN;
            fontMetricsInt.descent = i5;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = i5;
        }
        return (IMAGE_MARGIN * 2) + bounds.right;
    }

    public int getSpanEnd() {
        return this.mSpanEnd;
    }

    public int getSpanStart() {
        return this.mSpanStart;
    }

    public boolean isLoaded() throws Throwable {
        getDrawable();
        return this.mIsLoaded;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.Html.ClickableSpanType
    public void onClick(ClickableSpanType clickableSpanType) {
        ClickableSpanType.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(clickableSpanType);
        }
    }

    public void setAnimationValues(float f, float f4) {
        this.mImageScale = f;
        this.mImageAlpha = f4;
    }

    public void setImageAlpha(float f) {
        DocumentLogger.m7178d(TAG, "mImageAlpha" + f);
        this.mImageAlpha = f;
    }

    public void setOnClickListener(ClickableSpanType.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public String toHtml() {
        return "<img src=\"" + this.mContentUri + "\" orientation=\"" + this.mOrientation + "\" altText=\"" + Uri.encode(this.mAltText) + "\"/>";
    }

    public String toHtmlForCopy() {
        return "<img src=\"" + this.mContentUri + "\" orientation=\"" + this.mOrientation + "\" altText=\"" + Uri.encode(this.mAltText) + "\"   width=\"" + MAX_WIDTH + "\" />";
    }

    public String toString() {
        return toHtml();
    }

    public HtmlImageSpan(Context context, Uri uri, int i, String str, float f) {
        this.mImageScale = 1.0f;
        this.mImageAlpha = 1.0f;
        this.mListener = null;
        DocumentLogger.m7178d(TAG, "HtmlImageSpan ()");
        this.mContext = context;
        this.mContentUri = uri;
        this.mOrientation = i;
        this.mAltText = Uri.decode(str);
        this.mImageScale = f;
        DocumentLogger.m7178d(TAG, "mImageScale=" + this.mImageScale + "  MAX_WIDTH=" + MAX_WIDTH);
        int i2 = this.mOrientation;
        if (i2 != 0 && i2 != 90 && i2 != 180 && i2 != 270) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "unable to proceed given orientaion: "));
        }
    }
}
