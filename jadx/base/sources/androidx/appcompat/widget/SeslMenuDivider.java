package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SeslMenuDivider extends ImageView {
    private static final float CIRCLE_INTERVAL = 3.0f;
    private static final float DIAMETER_SIZE = 1.5f;
    private final int mDiameter;
    private final int mInterval;
    private Paint mPaint;

    public SeslMenuDivider(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int height = getHeight();
        int i4 = this.mDiameter;
        int i5 = (width - i4) / (this.mInterval + i4);
        int i6 = i5 + 1;
        int paddingStart = getPaddingStart() + ((int) ((i4 / 2.0f) + 0.5f));
        int i7 = this.mDiameter;
        int i8 = (width - i7) - ((this.mInterval + i7) * i5);
        if (i7 % 2 != 0) {
            i8--;
        }
        if (i5 > 0) {
            i2 = i8 / i5;
            i = i8 % i5;
        } else {
            i = 0;
            i2 = 0;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            canvas.drawCircle(paddingStart + i9, height / 2.0f, this.mDiameter / 2.0f, this.mPaint);
            int i11 = this.mDiameter + this.mInterval + i2 + i9;
            if (i10 < i) {
                i11++;
            }
            i9 = i11;
        }
    }

    public SeslMenuDivider(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeslMenuDivider(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDiameter = (int) TypedValue.applyDimension(1, 1.5f, displayMetrics);
        this.mInterval = (int) TypedValue.applyDimension(1, 3.0f, displayMetrics);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFlags(1);
        this.mPaint.setColor(ResourcesCompat.getColor(context.getResources(), SeslMisc.isLightTheme(context) ? C0419R.color.sesl_popup_menu_divider_color_light : C0419R.color.sesl_popup_menu_divider_color_dark, null));
    }
}
