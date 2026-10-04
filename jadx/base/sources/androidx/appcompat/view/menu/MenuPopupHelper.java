package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper implements MenuHelper {
    private static final int SESL_INVALID_HEIGHT = -1;
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private boolean mAllowScrollingAnchorParent;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private boolean mForceShowUpper;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private boolean mOverflowOnly;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mSeslPopupHeight;

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, C0419R.attr.popupMenuStyle, 0);
    }

    @NonNull
    private MenuPopup createPopup() {
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Math.min(point.x, point.y);
        this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.abc_cascading_menus_min_smallest_width);
        StandardMenuPopup standardMenuPopup = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        if (this.mOverlapAnchorSet) {
            standardMenuPopup.seslSetOverlapAnchor(this.mOverlapAnchor);
            standardMenuPopup.seslForceShowUpper(this.mForceShowUpper);
        }
        int i = this.mSeslPopupHeight;
        if (i != -1) {
            standardMenuPopup.seslSetHeight(i);
        }
        standardMenuPopup.seslForceShowUpper(this.mForceShowUpper);
        if (!this.mAllowScrollingAnchorParent) {
            standardMenuPopup.seslSetAllowScrollingAnchorParent(false);
        }
        standardMenuPopup.addMenu(this.mMenu);
        standardMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
        standardMenuPopup.setAnchorView(this.mAnchorView);
        standardMenuPopup.setCallback(this.mPresenterCallback);
        standardMenuPopup.setForceShowIcon(this.mForceShowIcon);
        standardMenuPopup.setGravity(this.mDropDownGravity);
        return standardMenuPopup;
    }

    private void showPopup(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            boolean z3 = ViewCompat.getLayoutDirection(this.mAnchorView) == 1;
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(C0419R.dimen.sesl_menu_popup_offset_horizontal);
            if (z3) {
                popup.setHorizontalOffset(dimensionPixelOffset + i);
            } else {
                popup.setHorizontalOffset(i - dimensionPixelOffset);
            }
            popup.setVerticalOffset(i2);
            int i4 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i - i4, i2 - i4, i + i4, i2 + i4));
        }
        popup.show();
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MenuPopup getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void seslForceShowUpper(boolean z) {
        this.mForceShowUpper = z;
    }

    @Nullable
    public View seslGetBackgroundView() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup instanceof StandardMenuPopup) {
            return ((StandardMenuPopup) menuPopup).seslGetBackgroundView();
        }
        return null;
    }

    @Nullable
    public PopupWindow seslGetPopupWindow() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup instanceof StandardMenuPopup) {
            return ((StandardMenuPopup) menuPopup).seslGetPopupWindow();
        }
        return null;
    }

    public void seslSetAllowScrollingAnchorParent(boolean z) {
        this.mAllowScrollingAnchorParent = z;
    }

    public void seslSetHeight(int i) {
        this.mSeslPopupHeight = i;
    }

    public void seslSetOverflowOnly(boolean z) {
        this.mOverflowOnly = z;
    }

    public void seslSetOverlapAnchor(boolean z) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z;
    }

    public void seslUpdate() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup instanceof StandardMenuPopup) {
            ((StandardMenuPopup) menuPopup).seslUpdate();
        }
    }

    public void setAnchorView(@NonNull View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, C0419R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i, @StyleRes int i2) {
        this.mDropDownGravity = 8388611;
        this.mForceShowUpper = false;
        this.mAllowScrollingAnchorParent = true;
        this.mSeslPopupHeight = -1;
        this.mInternalOnDismissListener = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i, i2, true, true);
        return true;
    }
}
