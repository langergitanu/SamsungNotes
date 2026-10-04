package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ColorProtection extends Protection {

    @ColorInt
    private int mColor;
    private final ColorDrawable mDrawable;
    private boolean mHasColor;

    public ColorProtection(int i) {
        super(i);
        this.mDrawable = new ColorDrawable();
        this.mColor = 0;
    }

    private void setColorInner(@ColorInt int i) {
        if (this.mColor != i) {
            this.mColor = i;
            this.mDrawable.setColor(i);
            setDrawable(this.mDrawable);
        }
    }

    @Override // androidx.core.view.insets.Protection
    public void dispatchColorHint(@ColorInt int i) {
        if (this.mHasColor) {
            return;
        }
        setColorInner(i);
    }

    @ColorInt
    public int getColor() {
        return this.mColor;
    }

    @Override // androidx.core.view.insets.Protection
    public boolean occupiesCorners() {
        return true;
    }

    public void setColor(@ColorInt int i) {
        this.mHasColor = true;
        setColorInner(i);
    }

    public ColorProtection(int i, @ColorInt int i2) {
        this(i);
        setColor(i2);
    }
}
