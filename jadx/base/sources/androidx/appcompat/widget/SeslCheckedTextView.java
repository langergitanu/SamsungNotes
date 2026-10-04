package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SeslCheckedTextView extends TextView implements Checkable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private int mBasePadding;
    private Drawable mCheckMarkDrawable;
    private int mCheckMarkGravity;
    private int mCheckMarkPadding;
    private int mCheckMarkResource;
    private ColorStateList mCheckMarkTintList;
    private PorterDuff.Mode mCheckMarkTintMode;
    private int mCheckMarkWidth;
    private boolean mChecked;
    private int mDrawablePadding;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mNeedRequestlayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.SeslCheckedTextView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean checked;

        public String toString() {
            StringBuilder sb = new StringBuilder("SeslCheckedTextView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" checked=");
            return AbstractC0000a.m14k(sb, this.checked, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.checked));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checked = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public SeslCheckedTextView(Context context) {
        this(context, null);
    }

    private void applyCheckMarkTint() {
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null) {
            if (this.mHasCheckMarkTint || this.mHasCheckMarkTintMode) {
                Drawable drawableMutate = drawable.mutate();
                this.mCheckMarkDrawable = drawableMutate;
                if (this.mHasCheckMarkTint) {
                    drawableMutate.setTintList(this.mCheckMarkTintList);
                }
                if (this.mHasCheckMarkTintMode) {
                    this.mCheckMarkDrawable.setTintMode(this.mCheckMarkTintMode);
                }
                if (this.mCheckMarkDrawable.isStateful()) {
                    this.mCheckMarkDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private boolean isCheckMarkAtStart() {
        return (Gravity.getAbsoluteGravity(this.mCheckMarkGravity, ViewCompat.getLayoutDirection(this)) & 7) == 3;
    }

    private void setBasePadding(boolean z) {
        if (z) {
            this.mBasePadding = getPaddingLeft();
        } else {
            this.mBasePadding = getPaddingRight();
        }
    }

    private void setCheckMarkDrawableInternal(@Nullable Drawable drawable, @DrawableRes int i) {
        Drawable drawable2 = this.mCheckMarkDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mCheckMarkDrawable);
        }
        this.mNeedRequestlayout = drawable != this.mCheckMarkDrawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(getVisibility() == 0, false);
            drawable.setState(CHECKED_STATE_SET);
            setMinHeight(drawable.getIntrinsicHeight());
            this.mCheckMarkWidth = drawable.getIntrinsicWidth();
            drawable.setState(getDrawableState());
        } else {
            this.mCheckMarkWidth = 0;
        }
        this.mCheckMarkDrawable = drawable;
        this.mCheckMarkResource = i;
        applyCheckMarkTint();
        SeslViewReflector.resolvePadding(this);
        setBasePadding(isCheckMarkAtStart());
    }

    private void updatePadding() {
        SeslViewReflector.resetPaddingToInitialValues(this);
        int i = this.mCheckMarkDrawable != null ? this.mCheckMarkWidth + this.mBasePadding + this.mCheckMarkPadding + this.mDrawablePadding : this.mBasePadding;
        if (isCheckMarkAtStart()) {
            this.mNeedRequestlayout |= SeslViewReflector.getField_mPaddingLeft(this) != i;
            SeslViewReflector.setField_mPaddingLeft(this, i);
        } else {
            this.mNeedRequestlayout |= SeslViewReflector.getField_mPaddingRight(this) != i;
            SeslViewReflector.setField_mPaddingRight(this, i);
        }
        if (this.mNeedRequestlayout) {
            requestLayout();
            this.mNeedRequestlayout = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f4) {
        super.drawableHotspotChanged(f, f4);
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return CheckedTextView.class.getName();
    }

    public Drawable getCheckMarkDrawable() {
        return this.mCheckMarkDrawable;
    }

    @Nullable
    public ColorStateList getCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    @Nullable
    public PorterDuff.Mode getCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            if (ViewUtils.isLayoutRtl(this) && SeslTextViewReflector.getField_mSingleLine(this)) {
                invalidate(bounds.left, bounds.top, bounds.right, bounds.bottom);
            }
        }
    }

    @Override // android.widget.Checkable
    @ViewDebug.ExportedProperty
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int height = gravity != 16 ? gravity != 80 ? 0 : getHeight() - intrinsicHeight : (getHeight() - intrinsicHeight) / 2;
            boolean zIsCheckMarkAtStart = isCheckMarkAtStart();
            int width = getWidth();
            int i4 = intrinsicHeight + height;
            if (zIsCheckMarkAtStart) {
                i2 = this.mBasePadding;
                i = this.mCheckMarkWidth + i2;
            } else {
                i = width - this.mBasePadding;
                i2 = i - this.mCheckMarkWidth;
            }
            int scrollX = getScrollX();
            if (ViewUtils.isLayoutRtl(this)) {
                drawable.setBounds(scrollX + i2, height, scrollX + i, i4);
            } else {
                drawable.setBounds(i2, height, i, i4);
            }
            drawable.draw(canvas);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i2 + scrollX, height, scrollX + i, i4);
            }
        }
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.mChecked);
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.mChecked);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        updatePadding();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = isChecked();
        return savedState;
    }

    public void setCheckMarkDrawable(@DrawableRes int i) {
        if (i == 0 || i != this.mCheckMarkResource) {
            setCheckMarkDrawableInternal(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null, i);
        }
    }

    public void setCheckMarkTintList(@Nullable ColorStateList colorStateList) {
        this.mCheckMarkTintList = colorStateList;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    public void setCheckMarkTintMode(@Nullable PorterDuff.Mode mode) {
        this.mCheckMarkTintMode = mode;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            refreshDrawableState();
            SeslViewReflector.notifyViewAccessibilityStateChangedIfNeeded(this, 0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        Drawable drawable = this.mCheckMarkDrawable;
        if (drawable != null) {
            drawable.setVisible(i == 0, false);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return drawable == this.mCheckMarkDrawable || super.verifyDrawable(drawable);
    }

    public SeslCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0419R.attr.checkedTextViewStyle);
    }

    public SeslCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslCheckedTextView(Context context, AttributeSet attributeSet, int i, int i2) throws Throwable {
        SeslCheckedTextView seslCheckedTextView;
        Context context2;
        super(context, attributeSet, i, i2);
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mCheckMarkGravity = 8388611;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.CheckedTextView, i, i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                seslCheckedTextView = this;
                context2 = context;
                try {
                    seslCheckedTextView.saveAttributeDataForStyleable(context2, C0419R.styleable.CheckedTextView, attributeSet, typedArrayObtainStyledAttributes, i, i2);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    typedArrayObtainStyledAttributes.recycle();
                    throw th2;
                }
            } else {
                seslCheckedTextView = this;
                context2 = context;
            }
            seslCheckedTextView.mCheckMarkPadding = context2.getResources().getDimensionPixelSize(C0419R.dimen.sesl_checked_spinner_padding_end);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.CheckedTextView_android_checkMark);
            if (drawable != null) {
                setCheckMarkDrawable(drawable);
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.CheckedTextView_android_checkMarkTintMode)) {
                seslCheckedTextView.mCheckMarkTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.CheckedTextView_android_checkMarkTintMode, -1), seslCheckedTextView.mCheckMarkTintMode);
                seslCheckedTextView.mHasCheckMarkTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.CheckedTextView_android_checkMarkTint)) {
                seslCheckedTextView.mCheckMarkTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.CheckedTextView_android_checkMarkTint);
                seslCheckedTextView.mHasCheckMarkTint = true;
            }
            seslCheckedTextView.mCheckMarkGravity = typedArrayObtainStyledAttributes.getInt(C0419R.styleable.CheckedTextView_checkMarkGravity, 8388611);
            setChecked(typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.CheckedTextView_android_checked, false));
            typedArrayObtainStyledAttributes.recycle();
            seslCheckedTextView.mDrawablePadding = context2.getResources().getDimensionPixelSize(C0419R.dimen.sesl_checked_text_padding);
            applyCheckMarkTint();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void setCheckMarkDrawable(@Nullable Drawable drawable) {
        setCheckMarkDrawableInternal(drawable, 0);
    }
}
