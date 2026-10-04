package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(api = 23)
class SlidingPaneRoundedCorner {
    private static final int RADIUS = 22;
    static final String TAG = "SeslPaneRoundedCorner";
    private Context mContext;
    private Drawable mEndBottomDrawable;
    private Drawable mEndTopDrawable;
    private Resources mRes;
    private int mRoundedCornerMode;
    private Drawable mStartBottomDrawable;

    @ColorInt
    private int mStartBottomDrawableColor;
    private Drawable mStartTopDrawable;

    @ColorInt
    private int mStartTopDrawableColor;
    private int mRoundRadius = -1;
    private Rect mRoundedCornerBounds = new Rect();
    private int mMarginTop = 0;
    private int mMarginBottom = 0;
    private final Rect mTmpRect = new Rect();

    public SlidingPaneRoundedCorner(Context context) {
        this.mContext = context;
        this.mRes = context.getResources();
        initRoundedCorner();
    }

    private void drawRoundedCornerInternal(Canvas canvas) {
        Rect rect = this.mRoundedCornerBounds;
        int i = rect.left;
        int i2 = rect.right;
        int i4 = rect.top;
        int i5 = rect.bottom;
        if (this.mRoundedCornerMode == 0) {
            Drawable drawable = this.mStartTopDrawable;
            int i6 = this.mRoundRadius;
            drawable.setBounds(i - i6, i4, i, i6 + i4);
            this.mStartTopDrawable.draw(canvas);
            Drawable drawable2 = this.mStartBottomDrawable;
            int i7 = this.mRoundRadius;
            drawable2.setBounds(i - i7, i5 - i7, i, i5);
            this.mStartBottomDrawable.draw(canvas);
            return;
        }
        Drawable drawable3 = this.mEndTopDrawable;
        int i8 = this.mRoundRadius;
        drawable3.setBounds(i2 - i8, i4, i2, i8 + i4);
        this.mEndTopDrawable.draw(canvas);
        Drawable drawable4 = this.mEndBottomDrawable;
        int i9 = this.mRoundRadius;
        drawable4.setBounds(i2 - i9, i5 - i9, i2, i5);
        this.mEndBottomDrawable.draw(canvas);
    }

    @RequiresApi(api = 23)
    private void initRoundedCorner() {
        this.mRoundRadius = (int) TypedValue.applyDimension(1, 22.0f, this.mRes.getDisplayMetrics());
        boolean zIsLightTheme = SeslMisc.isLightTheme(this.mContext);
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(C0419R.attr.roundedCornerColor, typedValue, true);
        int color = (typedValue.resourceId <= 0 || !isColorType(typedValue.type)) ? (typedValue.data <= 0 || !isColorType(typedValue.type)) ? !zIsLightTheme ? this.mRes.getColor(C0419R.color.sesl_round_and_bgcolor_dark) : this.mRes.getColor(C0419R.color.sesl_round_and_bgcolor_light) : typedValue.data : this.mRes.getColor(typedValue.resourceId);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        this.mStartTopDrawable = new SeslRoundedCorner.SeslRoundedChunkingDrawable(this.mRoundRadius, paint, 90.0f);
        this.mStartBottomDrawable = new SeslRoundedCorner.SeslRoundedChunkingDrawable(this.mRoundRadius, paint, 180.0f);
        this.mEndTopDrawable = new SeslRoundedCorner.SeslRoundedChunkingDrawable(this.mRoundRadius, paint, 0.0f);
        this.mEndBottomDrawable = new SeslRoundedCorner.SeslRoundedChunkingDrawable(this.mRoundRadius, paint, 270.0f);
        if (zIsLightTheme) {
            int color2 = this.mRes.getColor(C0419R.color.sesl_round_and_bgcolor_light, null);
            this.mStartBottomDrawableColor = color2;
            this.mStartTopDrawableColor = color2;
        } else {
            int color3 = this.mRes.getColor(C0419R.color.sesl_round_and_bgcolor_dark, null);
            this.mStartBottomDrawableColor = color3;
            this.mStartTopDrawableColor = color3;
        }
    }

    private boolean isColorType(int i) {
        return i >= 28 && i <= 31;
    }

    private boolean isLayoutRtlSupport(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    private void removeRoundedCorner(int i) {
        if (i == 0) {
            this.mStartTopDrawable = null;
            this.mStartBottomDrawable = null;
        } else {
            this.mEndTopDrawable = null;
            this.mEndBottomDrawable = null;
        }
    }

    public void drawRoundedCorner(Canvas canvas) {
        canvas.getClipBounds(this.mRoundedCornerBounds);
        drawRoundedCornerInternal(canvas);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getRoundedCornerRadius() {
        return this.mRoundRadius;
    }

    public int getRoundedCorners() {
        return this.mRoundedCornerMode;
    }

    public void setMarginBottom(int i) {
        this.mMarginBottom = i;
    }

    public void setMarginTop(int i) {
        this.mMarginTop = i;
    }

    public void setRoundedCornerColor(int i, @ColorInt int i2) {
        if (this.mStartTopDrawable == null || this.mStartBottomDrawable == null || this.mEndTopDrawable == null || this.mEndBottomDrawable == null) {
            initRoundedCorner();
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN);
        this.mStartTopDrawableColor = i2;
        this.mStartTopDrawable.setColorFilter(porterDuffColorFilter);
        this.mEndTopDrawable.setColorFilter(porterDuffColorFilter);
        this.mEndBottomDrawable.setColorFilter(porterDuffColorFilter);
        this.mStartBottomDrawableColor = i2;
        this.mStartBottomDrawable.setColorFilter(porterDuffColorFilter);
    }

    public void setRoundedCorners(int i) {
        this.mRoundedCornerMode = i;
        if (this.mStartTopDrawable == null || this.mStartBottomDrawable == null || this.mEndTopDrawable == null || this.mEndBottomDrawable == null) {
            initRoundedCorner();
        }
    }

    public void drawRoundedCorner(View view, Canvas canvas) {
        int left;
        int top;
        if (isLayoutRtlSupport(view)) {
            this.mRoundedCornerMode = 1;
        } else {
            this.mRoundedCornerMode = 0;
        }
        if (view.getTranslationY() != 0.0f) {
            left = Math.round(view.getX());
            top = Math.round(view.getY());
        } else {
            left = view.getLeft();
            top = view.getTop();
        }
        int i = this.mMarginTop + top;
        int width = view.getWidth() + left + this.mRoundRadius;
        int height = (view.getHeight() + top) - this.mMarginBottom;
        canvas.getClipBounds(this.mTmpRect);
        Rect rect = this.mTmpRect;
        rect.right = Math.max(rect.left, view.getRight() + this.mRoundRadius);
        canvas.clipRect(this.mTmpRect);
        this.mRoundedCornerBounds.set(left, i, width, height);
        drawRoundedCornerInternal(canvas);
    }
}
