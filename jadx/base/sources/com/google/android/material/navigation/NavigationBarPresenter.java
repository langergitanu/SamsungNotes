package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.C4548R;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter extends BaseMenuPresenter {
    private static final int ANIM_UPDATE_DELAY = 180;
    private static final int ANIM_UPDATE_DURATION = 400;
    private static final int MSG_UPDATE_ANIMATION = 100;

    /* JADX INFO: renamed from: id */
    private int f2313id;
    private Handler mAnimationHandler;
    private Context mContext;
    private OverflowPopup mOverflowPopup;
    private final PopupPresenterCallback mPopupPresenterCallback;
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mSetAnim;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        @Override // java.lang.Runnable
        public void run() {
            if (NavigationBarPresenter.this.menu != null) {
                NavigationBarPresenter.this.menu.changeMenuMode();
            }
            if (NavigationBarPresenter.this.menuView != null) {
                int dimensionPixelSize = NavigationBarPresenter.this.mContext.getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_floating_overflow_menu_top_margin);
                boolean z = ViewCompat.getLayoutDirection(NavigationBarPresenter.this.menuView.mOverflowButton) == 1;
                int dimensionPixelSize2 = NavigationBarPresenter.this.menuView.mIsFloatingStyle ? NavigationBarPresenter.this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_menu_popup_offset_horizontal) : 0;
                if (NavigationBarPresenter.this.menuView.getWindowToken() != null) {
                    OverflowPopup overflowPopup = this.mPopup;
                    if (z) {
                        dimensionPixelSize2 = -dimensionPixelSize2;
                    }
                    if (overflowPopup.tryShow(dimensionPixelSize2, -dimensionPixelSize)) {
                        NavigationBarPresenter.this.mOverflowPopup = this.mPopup;
                    }
                }
            }
            NavigationBarPresenter.this.mPostedOpenRunnable = null;
        }

        private OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OverflowPopup extends MenuPopupHelper {
        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (NavigationBarPresenter.this.menu != null) {
                NavigationBarPresenter.this.menu.close();
            }
            NavigationBarPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }

        private OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0419R.attr.actionOverflowBottomMenuStyle);
            setGravity(8388613);
            setPresenterCallback(NavigationBarPresenter.this.mPopupPresenterCallback);
            setAnchorView(view);
            seslSetOverlapAnchor(false);
            seslForceShowUpper(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = NavigationBarPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            MenuPresenter.Callback callback;
            return (menuBuilder == null || (callback = NavigationBarPresenter.this.getCallback()) == null || !callback.onOpenSubMenu(menuBuilder)) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        @Nullable
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public NavigationBarPresenter(Context context) {
        super(context, C0419R.layout.sesl_action_menu_layout, C0419R.layout.sesl_action_menu_item_layout);
        this.updateSuspended = false;
        this.mSetAnim = false;
        this.mAnimationHandler = new Handler(Looper.getMainLooper()) { // from class: com.google.android.material.navigation.NavigationBarPresenter.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 100) {
                    NavigationBarPresenter.this.updateMenuViewWithAnimate();
                }
            }
        };
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenuViewWithAnimate() {
        if (this.menuView == null) {
            return;
        }
        final PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.menuView, "y", r1.getHeight());
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        objectAnimatorOfFloat.start();
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.navigation.NavigationBarPresenter.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NavigationBarPresenter.this.menuView.buildMenuView();
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(NavigationBarPresenter.this.menuView, "y", 0.0f);
                objectAnimatorOfFloat2.setDuration(400L);
                objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
                objectAnimatorOfFloat2.start();
                super.onAnimationEnd(animator);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f2313id;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup viewGroup) {
        return this.menuView;
    }

    public boolean hideOverflowMenu() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
        this.mContext = context;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.restoreBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setAnimationEnable(boolean z) {
        this.mSetAnim = z;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void setId(int i) {
        this.f2313id = i;
    }

    public void setMenuView(@NonNull NavigationBarMenuView navigationBarMenuView) {
        this.menuView = navigationBarMenuView;
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    public boolean showOverflowMenu(MenuBuilder menuBuilder) {
        if (isOverflowMenuShowing() || menuBuilder == null || this.menuView == null || this.mPostedOpenRunnable != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        OverflowPopup overflowPopup = new OverflowPopup(this.mContext, menuBuilder, this.menuView.mOverflowButton, true);
        this.mOverflowPopup = overflowPopup;
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(overflowPopup);
        this.mPostedOpenRunnable = openOverflowRunnable;
        this.menuView.post(openOverflowRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.updateSuspended) {
            return;
        }
        if (!this.mSetAnim) {
            if (z) {
                this.menuView.buildMenuView();
                return;
            } else {
                this.menuView.updateMenuView();
                return;
            }
        }
        if (!z) {
            this.menuView.postDelayed(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    NavigationBarPresenter.this.menuView.updateMenuView();
                }
            }, 180L);
            return;
        }
        if (this.mAnimationHandler.hasMessages(100)) {
            this.mAnimationHandler.removeMessages(100);
        }
        this.mAnimationHandler.sendEmptyMessage(100);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder menuBuilder, boolean z) {
    }
}
