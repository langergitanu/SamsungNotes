package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.core.widget.PopupWindowCompat;
import androidx.reflect.p112os.SeslBuildReflector;
import androidx.reflect.view.SeslSemWindowManagerReflector;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.view.SeslViewRuneReflector;
import androidx.reflect.widget.SeslPopupWindowReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private static final boolean ONEUI_5_1_1;
    private static final int[] ONEUI_BLUR_POPUP_BACKGROUND_RES;
    private Context mContext;
    private boolean mHasNavigationBar;
    private boolean mIsReplacedPoupBackground;
    private int mNavigationBarHeight;
    private boolean mOverlapAnchor;
    private final Rect mTempRect;

    static {
        ONEUI_5_1_1 = SeslBuildReflector.SeslVersionReflector.getField_SEM_PLATFORM_INT() >= 140500;
        ONEUI_BLUR_POPUP_BACKGROUND_RES = new int[]{C0419R.drawable.sesl_menu_popup_background, C0419R.drawable.sesl_menu_popup_background_dark};
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        init(context, attributeSet, i, 0);
    }

    private Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private Transition getTransition(int i) {
        Transition transitionInflateTransition;
        if (i == 0 || i == 17760256 || (transitionInflateTransition = TransitionInflater.from(this.mContext).inflateTransition(i)) == null) {
            return null;
        }
        if ((transitionInflateTransition instanceof TransitionSet) && ((TransitionSet) transitionInflateTransition).getTransitionCount() == 0) {
            return null;
        }
        return transitionInflateTransition;
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.PopupWindow, i, i2);
        if (tintTypedArrayObtainStyledAttributes.hasValue(C0419R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.PopupWindow_overlapAnchor, false));
        }
        this.mContext = context;
        Transition transition = getTransition(tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.PopupWindow_popupEnterTransition, 0));
        Transition transition2 = getTransition(tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.PopupWindow_popupExitTransition, 0));
        setEnterTransition(transition);
        setExitTransition(transition2);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.PopupWindow_android_popupBackground, -1);
        boolean z = false;
        for (int i4 : ONEUI_BLUR_POPUP_BACKGROUND_RES) {
            if (i4 == resourceId) {
                z = true;
            }
        }
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.PopupWindow_android_popupBackground));
        this.mIsReplacedPoupBackground = !z;
        tintTypedArrayObtainStyledAttributes.recycle();
        this.mHasNavigationBar = ActionBarPolicy.get(context).hasNavigationBar();
        this.mNavigationBarHeight = this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_navigation_bar_height);
    }

    private void setSupportOverlapAnchor(boolean z) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(@NonNull View view, int i, boolean z) {
        Rect rect = new Rect();
        if (z) {
            SeslViewReflector.getWindowDisplayFrame(view, rect);
            if (this.mHasNavigationBar && this.mContext.getResources().getConfiguration().orientation != 2) {
                rect.bottom -= this.mNavigationBarHeight;
            }
        } else {
            view.getWindowVisibleDisplayFrame(rect);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int iSeslGetCenterPointForFoldable = seslGetCenterPointForFoldable();
        int height = (((iSeslGetCenterPointForFoldable == 0 || iArr[1] >= iSeslGetCenterPointForFoldable) ? rect.bottom : iSeslGetCenterPointForFoldable) - (getSupportOverlapAnchor() ? iArr[1] : view.getHeight() + iArr[1])) - i;
        int i2 = iArr[1];
        if (iSeslGetCenterPointForFoldable == 0 || i2 < iSeslGetCenterPointForFoldable) {
            iSeslGetCenterPointForFoldable = rect.top;
        }
        int iMax = Math.max(height, (i2 - iSeslGetCenterPointForFoldable) + i);
        if (getBackground() == null) {
            return iMax;
        }
        getBackground().getPadding(this.mTempRect);
        Rect rect2 = this.mTempRect;
        return iMax - (rect2.top + rect2.bottom);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean getSupportOverlapAnchor() {
        return PopupWindowCompat.getOverlapAnchor(this);
    }

    @Nullable
    public View seslGetBackgroundView() {
        Object backgroundView = SeslPopupWindowReflector.getBackgroundView(this);
        if (backgroundView instanceof View) {
            return (View) backgroundView;
        }
        return null;
    }

    public int seslGetCenterPointForFoldable() {
        Context context;
        DisplayManager displayManager;
        Display display;
        if (!ONEUI_5_1_1 || (context = this.mContext) == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null || (display = displayManager.getDisplay(0)) == null || !SeslSemWindowManagerReflector.isTableMode()) {
            return 0;
        }
        Activity activity = getActivity(this.mContext);
        if (activity != null && activity.isInMultiWindowMode()) {
            return 0;
        }
        Point point = new Point();
        display.getRealSize(point);
        if (SeslViewRuneReflector.supportFoldableDualDisplay()) {
            if (this.mContext.getResources().getConfiguration().orientation != 2) {
                return 0;
            }
            int i = point.y;
            int i2 = point.x;
            return i > i2 ? i2 / 2 : i / 2;
        }
        if (!SeslViewRuneReflector.supportFoldableNoSubDisplay() || this.mContext.getResources().getConfiguration().orientation != 1) {
            return 0;
        }
        int i4 = point.y;
        int i5 = point.x;
        return i4 > i5 ? i4 / 2 : i5 / 2;
    }

    public boolean seslIsAvailableBlurBackground() {
        return !this.mIsReplacedPoupBackground;
    }

    public void seslSetAllowScrollingAnchorParent(boolean z) {
        SeslPopupWindowReflector.setAllowScrollingAnchorParent(this, z);
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(Drawable drawable) {
        this.mIsReplacedPoupBackground = true;
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i4, int i5) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i4, i5);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        this.mTempRect = new Rect();
        init(context, attributeSet, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i4) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i4);
    }
}
