package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslSwipeListAnimator {
    private static final int DEFAULT_ANIMATION_CANCEL_DURATION = 250;
    private static final int DEFAULT_ANIMATION_DURATION = 100;
    private static final int DEFAULT_DRAWABLE_PADDING = 10;
    private static final int DEFAULT_TEXT_SIZE = 17;
    private static final int DIRECTION_LTR = 0;
    private static final int DIRECTION_RTL = 1;
    private static final String TAG = "SeslSwipeListAnimator";
    private Context mContext;
    private RecyclerView mRecyclerView;
    private SwipeConfiguration mSwipeConfiguration;
    private final int DEFAULT_LEFT_COLOR = Color.parseColor("#6ebd52");
    private final int DEFAULT_RIGHT_COLOR = Color.parseColor("#56c0e5");
    private final int DEFAULT_TEXT_COLOR = Color.parseColor("#fafafa");
    private Paint mBgLeftToRight = null;
    private Paint mBgRightToLeft = null;
    private TextPaint mTextPaint = null;
    private Rect mSwipeRect = null;
    private Bitmap mSwipeBitmap = null;
    private BitmapDrawable mDrawSwipeBitmapDrawable = null;
    private float mLastRectAlpha = 0.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SwipeConfiguration {
        public Drawable drawableLeftToRight;
        public Drawable drawableRightToLeft;
        public String textLeftToRight;
        public String textRightToLeft;
        public int UNSET_VALUE = -1;
        public int colorLeftToRight = -1;
        public int colorRightToLeft = -1;
        public int drawablePadding = -1;
        public int textSize = -1;
        public int textColor = -1;
    }

    public SeslSwipeListAnimator(RecyclerView recyclerView, Context context) {
        this.mContext = context;
        this.mRecyclerView = recyclerView;
    }

    private int calculateTopOfList(View view) {
        int top = view.getTop();
        View view2 = (View) view.getParent();
        return (view2 == null || (view2 instanceof RecyclerView)) ? top : top + calculateTopOfList(view2);
    }

    private int convertDipToPixels(Context context, int i) {
        return Math.round(context.getResources().getDisplayMetrics().density * i);
    }

    private void drawRectInto(Canvas canvas, Rect rect, Rect rect2, Drawable drawable, Paint paint, int i, String str, float f, int i2) {
        canvas.save();
        paint.setAlpha(i);
        this.mTextPaint.setAlpha(i);
        canvas.clipRect(rect);
        canvas.drawRect(rect, paint);
        if (drawable != null) {
            drawable.setAlpha(i);
            drawable.setBounds(rect2);
            drawable.draw(canvas);
        }
        drawSwipeText(canvas, this.mTextPaint, str, i2, rect2);
        canvas.restore();
    }

    private Canvas drawRectToBitmapCanvas(View view, float f, float f4) {
        Rect rect;
        Rect rect2;
        int[] iArr = new int[2];
        this.mRecyclerView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view.setTranslationX(0.0f);
        view.getLocationInWindow(iArr2);
        iArr2[0] = iArr2[0] - iArr[0];
        int iCalculateTopOfList = calculateTopOfList(view);
        int width = view.getWidth();
        int height = view.getHeight();
        this.mSwipeRect = new Rect(view.getPaddingLeft() + iArr2[0], iCalculateTopOfList, (view.getWidth() + iArr2[0]) - view.getPaddingRight(), iCalculateTopOfList + height);
        if (this.mSwipeBitmap == null) {
            this.mSwipeBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.mSwipeBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        float width2 = view.getWidth() / 2.0f;
        float fAbs = Math.abs(f);
        float fMin = (Math.min(fAbs, width2) / width2) * 255.0f;
        float f5 = this.mLastRectAlpha;
        if (f5 != 255.0f && fMin == 255.0f) {
            view.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(108));
        } else if (f5 == 255.0f && fMin != 255.0f) {
            view.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(109));
        }
        this.mLastRectAlpha = fMin;
        if (f4 > 0.0f) {
            Drawable drawable = this.mSwipeConfiguration.drawableLeftToRight;
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                int iWidth = bounds.width();
                int iHeight = bounds.height();
                Log.i(TAG, "#1 draw LtoR, d = " + drawable + ", d.getBounds()=" + drawable.getBounds());
                int i = this.mSwipeConfiguration.drawablePadding;
                rect2 = new Rect(i, 0, iWidth + i, iHeight);
                rect2.offset(0, (height - iHeight) / 2);
            } else {
                Log.i(TAG, "#2 draw LtoR, d = null");
                rect2 = new Rect(0, 0, 0, 0);
            }
            int i2 = (int) f;
            Rect rect3 = rect2;
            drawRectInto(canvas, new Rect(0, 0, i2, height), rect3, drawable, this.mBgLeftToRight, 255, this.mSwipeConfiguration.textLeftToRight, r6.textSize, 0);
            drawRectInto(canvas, new Rect(i2, 0, width, height), rect3, drawable, this.mBgLeftToRight, (int) fMin, this.mSwipeConfiguration.textLeftToRight, r7.textSize, 0);
            return canvas;
        }
        if (f4 < 0.0f) {
            Drawable drawable2 = this.mSwipeConfiguration.drawableRightToLeft;
            if (drawable2 != null) {
                Rect bounds2 = drawable2.getBounds();
                int iWidth2 = bounds2.width();
                int iHeight2 = bounds2.height();
                int i4 = width - this.mSwipeConfiguration.drawablePadding;
                Log.i(TAG, "#3 draw RtoL, d = " + drawable2 + ", d.getBounds()=" + drawable2.getBounds());
                rect = new Rect(i4 - iWidth2, 0, i4, iHeight2);
                rect.offset(0, (height - iHeight2) / 2);
            } else {
                Log.i(TAG, "#4 draw RtoL, d = null");
                rect = new Rect(width, 0, width, 0);
            }
            int i5 = width - ((int) fAbs);
            Rect rect4 = rect;
            drawRectInto(canvas, new Rect(i5, 0, width, height), rect4, drawable2, this.mBgRightToLeft, 255, this.mSwipeConfiguration.textRightToLeft, r6.textSize, 1);
            drawRectInto(canvas, new Rect(0, 0, i5, height), rect4, drawable2, this.mBgRightToLeft, (int) fMin, this.mSwipeConfiguration.textRightToLeft, r7.textSize, 1);
        }
        return canvas;
    }

    private void drawSwipeText(Canvas canvas, Paint paint, String str, int i, Rect rect) {
        int width;
        int i2;
        Rect rect2 = new Rect();
        paint.setTextAlign(Paint.Align.LEFT);
        if (i == 0) {
            width = canvas.getWidth() - rect.right;
            i2 = this.mSwipeConfiguration.drawablePadding;
        } else {
            width = rect.left;
            i2 = this.mSwipeConfiguration.drawablePadding;
        }
        String string = TextUtils.ellipsize(str, this.mTextPaint, width - i2, TextUtils.TruncateAt.END).toString();
        paint.getTextBounds(string, 0, string.length(), rect2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(string, i == 0 ? rect.right + this.mSwipeConfiguration.drawablePadding : (rect.left - this.mSwipeConfiguration.drawablePadding) - rect2.right, ((Math.abs(fontMetrics.top - fontMetrics.bottom) / 2.0f) + (canvas.getHeight() / 2.0f)) - fontMetrics.bottom, paint);
    }

    private void drawTextToCenter(Canvas canvas, Paint paint, String str) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        Rect rect = new Rect();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
    }

    private BitmapDrawable getBitmapDrawableToSwipeBitmap() {
        if (this.mSwipeBitmap == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mRecyclerView.getResources(), this.mSwipeBitmap);
        bitmapDrawable.setBounds(this.mSwipeRect);
        return bitmapDrawable;
    }

    private TextPaint initPaintWithAlphaAntiAliasing(int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(i);
        textPaint.setAntiAlias(true);
        return textPaint;
    }

    public void clearSwipeAnimation(View view) {
        this.mLastRectAlpha = 0.0f;
        Log.i(TAG, "clearSwipeAnimation: view = " + view + " mDrawSwipeBitmapDrawable = " + this.mDrawSwipeBitmapDrawable);
        BitmapDrawable bitmapDrawable = this.mDrawSwipeBitmapDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.getBitmap().recycle();
            this.mDrawSwipeBitmapDrawable = null;
            this.mSwipeBitmap = null;
        }
        if (view != null) {
            Log.i(TAG, "clearSwipeAnimation: view.getTranslationX() = " + view.getTranslationX());
            if (view.getTranslationX() != 0.0f) {
                Log.i(TAG, "clearSwipeAnimation: **** set view.setTranslationX(0f) ****");
                view.setTranslationX(0.0f);
            }
        }
    }

    public void doMoveAction(Canvas canvas, View view, float f, boolean z) {
        StringBuilder sb = new StringBuilder("doMoveAction: viewForeground = ");
        sb.append(view);
        sb.append(" deltaX = ");
        sb.append(f);
        sb.append(", isCurrentlyActive = ");
        AbstractC0000a.m27x(sb, z, TAG);
        if (f == 0.0f && !z) {
            Log.i(TAG, "doMoveAction: #2 reutrn");
            clearSwipeAnimation(view);
            return;
        }
        Log.i(TAG, "doMoveAction: #1 drawRectToBitmapCanvas");
        drawRectToBitmapCanvas(view, f, f / view.getWidth());
        view.setTranslationX(f);
        float width = view.getWidth() / 2.0f;
        view.setAlpha(Math.min(1.0f - (Math.min(Math.abs(f), width) / width), 1.0f));
        BitmapDrawable bitmapDrawableToSwipeBitmap = getBitmapDrawableToSwipeBitmap();
        this.mDrawSwipeBitmapDrawable = bitmapDrawableToSwipeBitmap;
        if (bitmapDrawableToSwipeBitmap != null) {
            this.mRecyclerView.invalidate(bitmapDrawableToSwipeBitmap.getBounds());
            Log.i(TAG, "doMoveAction: draw");
            this.mDrawSwipeBitmapDrawable.draw(canvas);
        }
    }

    public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f4) {
        return i == 4 ? 250L : 100L;
    }

    public void onSwiped(View view) {
        Log.i(TAG, "onSwiped");
        clearSwipeAnimation(view);
        view.setTranslationX(0.0f);
        view.setAlpha(1.0f);
    }

    public void setSwipeConfiguration(SwipeConfiguration swipeConfiguration) {
        this.mSwipeConfiguration = swipeConfiguration;
        if (swipeConfiguration.textLeftToRight == null) {
            swipeConfiguration.textLeftToRight = " ";
        }
        if (swipeConfiguration.textRightToLeft == null) {
            swipeConfiguration.textRightToLeft = " ";
        }
        int i = swipeConfiguration.colorLeftToRight;
        int i2 = swipeConfiguration.UNSET_VALUE;
        if (i == i2) {
            swipeConfiguration.colorLeftToRight = this.DEFAULT_LEFT_COLOR;
        }
        if (swipeConfiguration.colorRightToLeft == i2) {
            swipeConfiguration.colorRightToLeft = this.DEFAULT_RIGHT_COLOR;
        }
        if (swipeConfiguration.textColor == i2) {
            swipeConfiguration.textColor = this.DEFAULT_TEXT_COLOR;
        }
        if (swipeConfiguration.textSize == i2) {
            swipeConfiguration.textSize = 17;
        }
        if (swipeConfiguration.drawablePadding == i2) {
            swipeConfiguration.drawablePadding = 10;
        }
        this.mBgLeftToRight = initPaintWithAlphaAntiAliasing(swipeConfiguration.colorLeftToRight);
        this.mBgRightToLeft = initPaintWithAlphaAntiAliasing(this.mSwipeConfiguration.colorRightToLeft);
        TextPaint textPaintInitPaintWithAlphaAntiAliasing = initPaintWithAlphaAntiAliasing(this.mSwipeConfiguration.textColor);
        this.mTextPaint = textPaintInitPaintWithAlphaAntiAliasing;
        textPaintInitPaintWithAlphaAntiAliasing.setTextSize(convertDipToPixels(this.mContext, this.mSwipeConfiguration.textSize));
        if (Build.VERSION.SDK_INT < 34) {
            this.mTextPaint.setTypeface(Typeface.create(this.mContext.getString(C0419R.string.sesl_font_family_regular), 0));
        } else {
            this.mTextPaint.setTypeface(Typeface.create(Typeface.create("sec", 0), 400, false));
        }
    }
}
