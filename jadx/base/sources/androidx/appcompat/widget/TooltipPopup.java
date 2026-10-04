package androidx.appcompat.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipPopup {
    private static final String TAG = "SESL_TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private int mNavigationBarHeight;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    public TooltipPopup(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams = layoutParams;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mNavigationBarHeight = 0;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.popupTheme, typedValue, false);
        if (typedValue.data != 0) {
            this.mContext = new ContextThemeWrapper(context, typedValue.data);
        } else {
            this.mContext = context;
        }
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C0419R.layout.sesl_tooltip, (ViewGroup) null);
        this.mContentView = viewInflate;
        this.mMessageView = (TextView) viewInflate.findViewById(C0419R.id.message);
        viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.appcompat.widget.TooltipPopup.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    TooltipPopup.this.hide();
                    return true;
                }
                if (action != 4) {
                    return false;
                }
                TooltipPopup.this.hide();
                return false;
            }
        });
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = this.mContext.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0419R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 262152;
    }

    private int adjustTooltipPosition(int i, int i2, int i4) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (checkNaviBarForLandscape()) {
            if (rotation == 1) {
                int iWidth = (((this.mTmpDisplayFrame.width() - i2) - getNavigationBarHeight()) / 2) - i4;
                if (i > iWidth) {
                    return iWidth - i4;
                }
            } else if (rotation == 3) {
                if (i <= 0) {
                    int iWidth2 = ((i2 - this.mTmpDisplayFrame.width()) / 2) + i4;
                    if (i <= iWidth2) {
                        return iWidth2 + i4;
                    }
                } else {
                    int iWidth3 = ((this.mTmpDisplayFrame.width() - i2) / 2) + i4;
                    if (i > iWidth3) {
                        return iWidth3 - i4;
                    }
                }
            }
        } else if (rotation == 1 || rotation == 3) {
            if (i <= 0) {
                int iWidth4 = ((i2 - this.mTmpDisplayFrame.width()) / 2) + i4;
                if (i < iWidth4) {
                    return iWidth4 + i4;
                }
            } else {
                int iWidth5 = ((this.mTmpDisplayFrame.width() - i2) / 2) + i4;
                if (i > iWidth5) {
                    return iWidth5 - i4;
                }
            }
        }
        return i;
    }

    private boolean checkNaviBarForLandscape() {
        int i;
        Context context = this.mContext;
        Resources resources = context.getResources();
        Rect rect = this.mTmpDisplayFrame;
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getRealSize(point);
        int rotation = defaultDisplay.getRotation();
        int dimension = (int) resources.getDimension(C0419R.dimen.sesl_navigation_bar_height);
        if (rotation == 1) {
            int i2 = rect.right;
            int i4 = i2 + dimension;
            int i5 = point.x;
            if (i4 >= i5) {
                setNavigationBarHeight(i5 - i2);
                return true;
            }
        }
        if (rotation != 3 || (i = rect.left) > dimension) {
            return false;
        }
        setNavigationBarHeight(i);
        return true;
    }

    private void computePosition(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams, boolean z2, boolean z3) {
        layoutParams.token = view.getApplicationWindowToken();
        int width = view.getWidth() / 2;
        layoutParams.gravity = 49;
        View appRootView = getAppRootView(view);
        if (appRootView == null) {
            Log.e(TAG, "Cannot find app view");
            return;
        }
        appRootView.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect rect = this.mTmpDisplayFrame;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.mContext.getResources();
            int identifier = resources.getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int[] iArr = new int[2];
        appRootView.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        Rect rect2 = new Rect(i4, iArr[1], appRootView.getWidth() + i4, appRootView.getHeight() + iArr[1]);
        Rect rect3 = this.mTmpDisplayFrame;
        rect3.left = rect2.left;
        rect3.right = rect2.right;
        appRootView.getLocationOnScreen(this.mTmpAppPos);
        view.getLocationOnScreen(this.mTmpAnchorPos);
        Log.i(TAG, "computePosition - displayFrame left : " + this.mTmpDisplayFrame.left);
        Log.i(TAG, "computePosition - displayFrame right : " + this.mTmpDisplayFrame.right);
        Log.i(TAG, "computePosition - displayFrame top : " + this.mTmpDisplayFrame.top);
        Log.i(TAG, "computePosition - displayFrame bottom : " + this.mTmpDisplayFrame.bottom);
        Log.i(TAG, "computePosition - anchorView locationOnScreen x: " + this.mTmpAnchorPos[0]);
        Log.i(TAG, "computePosition - anchorView locationOnScreen y : " + this.mTmpAnchorPos[1]);
        Log.i(TAG, "computePosition - appView locationOnScreen x : " + this.mTmpAppPos[0]);
        AbstractC0000a.m26w(new StringBuilder("computePosition - appView locationOnScreen y : "), TAG, this.mTmpAppPos[1]);
        int[] iArr2 = this.mTmpAnchorPos;
        int i5 = iArr2[0];
        int[] iArr3 = this.mTmpAppPos;
        int i6 = i5 - iArr3[0];
        iArr2[0] = i6;
        iArr2[1] = iArr2[1] - iArr3[1];
        layoutParams.x = (i6 + width) - (this.mTmpDisplayFrame.width() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.mContentView.getMeasuredHeight();
        int measuredWidth = this.mContentView.getMeasuredWidth();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(C0419R.dimen.sesl_hover_tooltip_popup_right_margin);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(C0419R.dimen.sesl_hover_tooltip_popup_area_margin);
        int i7 = this.mTmpAnchorPos[1];
        int i8 = i7 - measuredHeight;
        int height = view.getHeight() + i7;
        if (z) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                int i9 = measuredWidth / 2;
                int width2 = (((view.getWidth() + this.mTmpAnchorPos[0]) - (this.mTmpDisplayFrame.width() / 2)) - i9) - dimensionPixelOffset;
                layoutParams.x = width2;
                if (width2 < ((-this.mTmpDisplayFrame.width()) / 2) + i9) {
                    layoutParams.x = ((-this.mTmpDisplayFrame.width()) / 2) + i9 + dimensionPixelOffset;
                }
                layoutParams.x = adjustTooltipPosition(layoutParams.x, measuredWidth, dimensionPixelOffset);
            } else {
                int iWidth = (measuredWidth / 2) + ((this.mTmpAnchorPos[0] + width) - (this.mTmpDisplayFrame.width() / 2)) + dimensionPixelOffset;
                layoutParams.x = iWidth;
                layoutParams.x = adjustTooltipPosition(iWidth, measuredWidth, dimensionPixelOffset);
            }
            if (height + measuredHeight > this.mTmpDisplayFrame.height()) {
                layoutParams.y = i8;
            } else {
                layoutParams.y = height;
            }
        } else {
            int iWidth2 = (this.mTmpAnchorPos[0] + width) - (this.mTmpDisplayFrame.width() / 2);
            layoutParams.x = iWidth2;
            int i10 = measuredWidth / 2;
            if (iWidth2 < ((-this.mTmpDisplayFrame.width()) / 2) + i10) {
                layoutParams.x = ((-this.mTmpDisplayFrame.width()) / 2) + i10 + dimensionPixelOffset2;
            }
            layoutParams.x = adjustTooltipPosition(layoutParams.x, measuredWidth, dimensionPixelOffset);
            layoutParams.y = i8 >= 0 ? i8 : height;
        }
        if (z2) {
            layoutParams.y = view.getHeight() + this.mTmpAnchorPos[1];
        }
        if (z3) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                int i11 = measuredWidth / 2;
                int width3 = (((view.getWidth() + this.mTmpAnchorPos[0]) - (this.mTmpDisplayFrame.width() / 2)) - i11) - dimensionPixelOffset;
                layoutParams.x = width3;
                if (width3 < ((-this.mTmpDisplayFrame.width()) / 2) + i11) {
                    layoutParams.x = ((-this.mTmpDisplayFrame.width()) / 2) + i11 + dimensionPixelOffset2;
                }
                layoutParams.x = adjustTooltipPosition(layoutParams.x, measuredWidth, dimensionPixelOffset);
            } else {
                int iWidth3 = ((measuredWidth / 2) + ((this.mTmpAnchorPos[0] + width) - (this.mTmpDisplayFrame.width() / 2))) - dimensionPixelOffset;
                layoutParams.x = iWidth3;
                layoutParams.x = adjustTooltipPosition(iWidth3, measuredWidth, dimensionPixelOffset);
            }
            if (measuredHeight + height <= this.mTmpDisplayFrame.height()) {
                i8 = height;
            }
            layoutParams.y = i8;
        }
    }

    private static View getAppRootView(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 2) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return ((Activity) context).getWindow().getDecorView();
                }
            }
        }
        return rootView;
    }

    private int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }

    private void setNavigationBarHeight(int i) {
        this.mNavigationBarHeight = i;
    }

    public void hide() {
        if (isShowing()) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
        }
    }

    public boolean isShowing() {
        return this.mContentView.getParent() != null;
    }

    public void show(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view, i, i2, z, this.mLayoutParams, false, false);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void showActionItemTooltip(int i, int i2, int i4, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.x = i;
        layoutParams.y = i2;
        if (i4 == 0) {
            layoutParams.gravity = 8388661;
        } else {
            layoutParams.gravity = 8388659;
        }
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }

    public void show(View view, int i, int i2, boolean z, CharSequence charSequence, boolean z2, boolean z3) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view, i, i2, z, this.mLayoutParams, z2, z3);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
