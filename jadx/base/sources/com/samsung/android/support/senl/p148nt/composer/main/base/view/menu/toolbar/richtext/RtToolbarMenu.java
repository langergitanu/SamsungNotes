package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.CellStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExternalKeyboardManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.ToggleDockingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAi;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAlignPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuBold;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuBullet;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuDirectWrite;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFavoriteStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuIndent;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItalic;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuMoveOnlyMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuNumbering;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuOutdent;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuRedo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuStrikethrough;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTable;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextBgColor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextColor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTextStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuTodo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUnderline;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtToolbarMenu extends AbsAsyncInflater implements RtToolbarContract.IView, RtMenuItem.IRtToolbarMenu, SoftInputManager.OnSipListener, ExternalKeyboardManager.OnExternalKeyboardConnectedListener {
    private static final String KEY_TR_TOOLBAR_ENABLED = "key_rt_toolbar_enabled";
    private static final String TAG = Logger.createTag("RtToolbarMenu");
    private final Activity mActivity;
    private final ComponentFactory mComponentFactory;
    private boolean mEnabled;
    private final AbsToolbarContainerLayout mFloatingContainer;
    private View mInputBlocker;
    private boolean mIsShowAnimation;
    private ViewGroup mMenuContainer;
    private HashMap<Integer, RtMenuItem> mMenuItemMap;
    private ViewGroup mMenuItems;
    private final int mMenuPaddingEnd;
    private final RtToolbarPresenter mPresenter;
    private View mRtMenuView;
    private View mScrollView;
    private AlphaAnimation mShowHideAnimation;
    private View mToggleBtn;
    private ToggleDockingAnimation mToggleDockingAnimation;
    private final IToolbarManager mToolbarManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        @NonNull
        Class<? extends RtMenuAi> getRichTextAiMenu();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemCreator {
        Constructor mConstructor;
        Object[] mInitArgs;

        public /* synthetic */ ItemCreator(Constructor constructor, int i) {
            this(constructor);
        }

        public RtMenuItem create(View view) {
            try {
                Object[] objArr = this.mInitArgs;
                return (objArr == null || objArr.length != 2) ? (objArr == null || objArr.length != 1) ? (RtMenuItem) this.mConstructor.newInstance(view) : (RtMenuItem) this.mConstructor.newInstance(objArr[0], view) : (RtMenuItem) this.mConstructor.newInstance(objArr[0], objArr[1], view);
            } catch (IllegalAccessException e) {
                e = e;
                Logger.m11000e(RtToolbarMenu.TAG, e.getMessage());
                return null;
            } catch (InstantiationException e2) {
                e = e2;
                Logger.m11000e(RtToolbarMenu.TAG, e.getMessage());
                return null;
            } catch (InvocationTargetException e3) {
                e = e3;
                Logger.m11000e(RtToolbarMenu.TAG, e.getMessage());
                return null;
            }
        }

        public /* synthetic */ ItemCreator(Constructor constructor, Object[] objArr, int i) {
            this(constructor, objArr);
        }

        private ItemCreator(Constructor constructor) {
            this.mConstructor = constructor;
        }

        private ItemCreator(Constructor constructor, Object... objArr) {
            this.mConstructor = constructor;
            this.mInitArgs = objArr;
        }
    }

    public RtToolbarMenu(Activity activity, ViewGroup viewGroup, IToolbarManager iToolbarManager, RtToolbarPresenter rtToolbarPresenter, @NonNull ComponentFactory componentFactory) {
        ViewGroup viewGroup2;
        super(viewGroup.getContext());
        this.mEnabled = true;
        this.mActivity = activity;
        this.mPresenter = rtToolbarPresenter;
        AbsToolbarContainerLayout floatingLayout = getFloatingLayout(viewGroup);
        this.mFloatingContainer = floatingLayout;
        this.mMenuContainer = floatingLayout;
        if (!DeviceInfo.isVSTModel() && (viewGroup2 = (ViewGroup) viewGroup.findViewById(C9086R.id.bottom_fixed_docker)) != null) {
            this.mMenuContainer = viewGroup2;
        }
        this.mMenuPaddingEnd = (int) this.mMenuContainer.getResources().getDimension(C9086R.dimen.comp_rt_floating_menu_docking_margin_end_padding);
        if (DeviceInfo.isVSTModel()) {
            asyncInflate(C9086R.layout.vst_comp_rt_fixed_menu, this.mMenuContainer);
        } else {
            asyncInflate(C9086R.layout.comp_rt_floating_menu_integrated, this.mMenuContainer);
        }
        this.mToolbarManager = iToolbarManager;
        rtToolbarPresenter.setView(this);
        iToolbarManager.setSpenColorThemeUtil(rtToolbarPresenter.getColorTheme());
        this.mComponentFactory = componentFactory;
    }

    private void applyTintColor(ViewGroup viewGroup, int i) {
        int color = ContextCompat.getColor(viewGroup.getContext(), i);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ImageView) {
                ((ImageView) childAt).setImageTintList(ColorStateList.valueOf(color));
            }
        }
    }

    private AbsToolbarContainerLayout getFloatingLayout(ViewGroup viewGroup) {
        return DeviceInfo.isVSTModel() ? (AbsToolbarContainerLayout) viewGroup.findViewById(C9086R.id.vst_floating_layout) : (AbsToolbarContainerLayout) viewGroup.findViewById(C9086R.id.floating_layout);
    }

    private void hideButton(@IdRes int... iArr) {
        for (int i : iArr) {
            View viewFindViewById = this.mRtMenuView.findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        }
    }

    private void initButton(int i, View view, ItemCreator itemCreator) {
        if (view == null) {
            Logger.m11000e(TAG, "initButton# menuView is null");
            return;
        }
        RtMenuItem rtMenuItemCreate = itemCreator.create(view);
        if (rtMenuItemCreate == null) {
            Logger.m11000e(TAG, "initButton# rtMenuItem is null");
            return;
        }
        this.mMenuItemMap.put(Integer.valueOf(i), rtMenuItemCreate);
        rtMenuItemCreate.init(this.mPresenter, this);
        ToolbarUtil.setBgRippleToolbar(rtMenuItemCreate.getView());
        rtMenuItemCreate.getView().setAccessibilityDelegate(new VoiceAssistAsButton());
        if (rtMenuItemCreate instanceof RtMenuTextBgColor) {
            ((RtMenuTextBgColor) rtMenuItemCreate).setButtonBgColor(this.mPresenter.getBackgroundColor());
        }
        ViewGroup viewGroup = (ViewGroup) view;
        applyTintColor(viewGroup, C9086R.color.rich_text_toolbar_image);
        if (i == 64) {
            setScaleToMenuImageView(viewGroup, 0.97f);
        } else if (i == 16384) {
            setScaleToMenuImageView(viewGroup, 0.95f);
        } else if (i == 32) {
            setScaleToMenuImageView(viewGroup, 1.1f);
        }
    }

    private void internalHide() {
        if (this.mRtMenuView == null) {
            return;
        }
        if (DeviceInfo.isVSTModel()) {
            runAlphaAnimation(1.0f, 0.0f);
        } else {
            this.mRtMenuView.setVisibility(8);
        }
    }

    private void internalShow() {
        if (DeviceInfo.isVSTModel()) {
            runAlphaAnimation(0.0f, 1.0f);
        } else {
            this.mRtMenuView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$enableToolbar$5(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButtons$0(View view) {
        onClickToggleButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initButtons$1(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2() {
        View view = this.mScrollView;
        if (view instanceof HorizontalScrollView) {
            ((HorizontalScrollView) view).fullScroll(LocaleUtils.isRTLMode() ? 17 : 66);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndAlphaAnimation() {
        View view = this.mRtMenuView;
        if (view != null) {
            if (this.mIsShowAnimation) {
                view.setVisibility(0);
                showAiMenuAnimation();
            } else {
                view.setVisibility(8);
            }
        }
        ViewGroup viewGroup = this.mMenuItems;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f);
            this.mMenuItems.clearAnimation();
        }
        View view2 = this.mToggleBtn;
        if (view2 != null) {
            view2.setEnabled(true);
            ViewCompat.getInstance().setTooltipText(this.mToggleBtn);
        }
        Logger.m10999d(TAG, "run alpha : end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reReflectWidthByResourceQualifier() {
        View view;
        if (DeviceInfo.isVSTModel() || (view = this.mScrollView) == null) {
            return;
        }
        try {
            ((ConstraintLayout.LayoutParams) view.getLayoutParams()).matchConstraintMaxWidth = (int) this.mMenuContainer.getResources().getDimension(C9086R.dimen.comp_rt_toolbar_menu_tablet_layout_width);
            this.mScrollView.requestLayout();
        } catch (ClassCastException e) {
            Logger.m11000e(TAG, "ClassCastException# " + e.getMessage());
        }
    }

    private void runAlphaAnimation(float f, float f4) {
        if (this.mRtMenuView == null || this.mMenuItems == null) {
            return;
        }
        this.mIsShowAnimation = f4 == 1.0f;
        AlphaAnimation alphaAnimation = this.mShowHideAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        this.mMenuItems.clearAnimation();
        if (!this.mIsShowAnimation && this.mRtMenuView.getVisibility() != 0) {
            Logger.m10999d(TAG, "run alpha : already hided");
            if (this.mRtMenuView.getVisibility() == 4) {
                this.mRtMenuView.setVisibility(8);
                return;
            }
            return;
        }
        Logger.m10999d(TAG, "run alpha : " + f + " -> " + f4);
        Activity activity = this.mActivity;
        if (activity != null && !activity.hasWindowFocus()) {
            onEndAlphaAnimation();
            return;
        }
        this.mRtMenuView.setVisibility(0);
        if (this.mIsShowAnimation) {
            this.mRtMenuView.bringToFront();
        }
        View view = this.mToggleBtn;
        if (view != null) {
            view.setEnabled(false);
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(f, f4);
        this.mShowHideAnimation = alphaAnimation2;
        alphaAnimation2.setDuration(150L);
        this.mShowHideAnimation.setInterpolator(new SineInOut33());
        this.mShowHideAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RtToolbarMenu.this.onEndAlphaAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.mMenuItems.startAnimation(this.mShowHideAnimation);
    }

    private void setColorTheme(int i, boolean z, boolean z2) {
        Logger.m11003i(TAG, "setColorTheme# not supported");
    }

    private void setMenuEndPadding(int i) {
        View view = this.mRtMenuView;
        if (view != null) {
            view.setPaddingRelative(0, 0, i, 0);
        }
    }

    private void setScaleToMenuImageView(ViewGroup viewGroup, float f) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setScaleX(f);
            childAt.setScaleY(f);
        }
    }

    private void showAction() {
        internalShow();
        ToggleDockingAnimation toggleDockingAnimation = this.mToggleDockingAnimation;
        if (toggleDockingAnimation != null) {
            toggleDockingAnimation.resetView(this.mPresenter.isDockingMode());
        }
        Logger.m10999d(TAG, "show done");
    }

    private void showAiMenuAnimation() {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(262144);
        if (rtMenuItem instanceof RtMenuAi) {
            ((RtMenuAi) rtMenuItem).playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenuItems() {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map != null) {
            Iterator<RtMenuItem> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().onUpdate();
            }
        }
    }

    private void updateRedoUndoMenu() {
        boolean z = !this.mPresenter.isCoeditNote();
        updateVisible(z, C9086R.id.richtext_undo);
        updateVisible(z, C9086R.id.richtext_redo);
    }

    private void updateRichTextState() {
        this.mPresenter.updateRichTextState();
    }

    private void updateSupportedDirectWriteMenu() {
        boolean z = this.mToolbarManager.isSupportDirectWrite(this.mActivity) && !this.mPresenter.isCoeditNote();
        if (!z && isDirectWriteUsing()) {
            updateDirectWrite(false);
            setDirectWrite(false);
            hideDirectWrite();
        }
        updateVisible(z, C9086R.id.toolbar_direct_write);
    }

    private void updateToggleBtn(boolean z) {
        if (this.mToggleDockingAnimation == null || !isShowing()) {
            return;
        }
        this.mToggleDockingAnimation.update(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVisible(final boolean z, final int... iArr) {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.3
                @Override // java.lang.Runnable
                public void run() {
                    RtToolbarMenu.this.updateVisible(z, iArr);
                }
            });
            return;
        }
        for (int i : iArr) {
            View viewFindViewById = this.mMenuItems.findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void clearSelectedButtonsToolbarItem() {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return;
        }
        Iterator<RtMenuItem> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().setSelected(false);
        }
    }

    public void close() {
        clearSelectedButtonsToolbarItem();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public void doActionAfterDismissKeyguard(@NonNull Runnable runnable) {
        this.mPresenter.getKeyguardPresenter().dismissKeyguard(this.mActivity, runnable);
    }

    public void enableDockingMode(boolean z) {
        this.mPresenter.enableDockingMode(z);
        updateToggleBtn(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void enableMenus(boolean z, List<Integer> list) {
        for (Integer num : list) {
            int iIntValue = num.intValue();
            RtMenuItem rtMenuItem = this.mMenuItemMap.get(num);
            if (rtMenuItem != null) {
                if (iIntValue == 8192 && !z && rtMenuItem.getView().isSelected()) {
                    rtMenuItem.setSelected(false);
                }
                rtMenuItem.setEnable(z);
            }
        }
    }

    public void enablePaddingMode(boolean z) {
        if (z) {
            setMenuEndPadding(this.mMenuPaddingEnd);
        } else {
            setMenuEndPadding(0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void enableToolbar(boolean z) {
        this.mEnabled = z;
        if (this.mInputBlocker == null) {
            View viewFindViewById = this.mFloatingContainer.findViewById(C9086R.id.hw_toolbar_input_blocker);
            this.mInputBlocker = viewFindViewById;
            if (viewFindViewById == null) {
                return;
            } else {
                viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC7005f(16));
            }
        }
        this.mInputBlocker.setVisibility(z ? 8 : 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void executeAiAssist() {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(262144);
        if (rtMenuItem instanceof RtMenuAi) {
            ((RtMenuAi) rtMenuItem).onClicked();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void executeTextStyle() {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(2048);
        if (rtMenuItem instanceof RtMenuTextStyle) {
            ((RtMenuTextStyle) rtMenuItem).showPopup();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public int getColorTheme(int i) {
        return this.mToolbarManager.getColorTheme(i);
    }

    public int getDeltaToAvoidOverlap(int i, int i2) {
        int i4;
        Iterator<RtMenuItem> it = this.mMenuItemMap.values().iterator();
        while (it.hasNext()) {
            int[] horizonOnScreen = it.next().getHorizonOnScreen(i2);
            int i5 = horizonOnScreen[0];
            if (i5 < i && i < (i4 = horizonOnScreen[2])) {
                return horizonOnScreen[1] > i ? i5 - i : i4 - i;
            }
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public RtSettingPresenter getRtSettingPresenter() {
        return this.mPresenter.getRtSettingPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public View getView() {
        return this.mRtMenuView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void hide() {
        if (!isInflated()) {
            addPendingActionAfterInflate(new RunnableC10788a(this, 0));
            return;
        }
        internalHide();
        if (this.mToggleBtn != null) {
            ViewCompat.getInstance().setTooltipText(this.mToggleBtn, "");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void hideAll() {
        hideAllPopup();
        hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public boolean hideAllPopup() {
        Logger.m11003i(TAG, "hideAllPopup");
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return false;
        }
        Iterator<RtMenuItem> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().hidePopup()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public void hideDirectWrite() {
        this.mToolbarManager.hideDirectWrite();
    }

    @SuppressLint({"UseSparseArrays"})
    public void initButtons() {
        boolean zIsDynamicTemplateUuid = UUIDUtils.isDynamicTemplateUuid(this.mPresenter.getComposerViewPresenter().getComposerModel().getDocInfo().getUuid());
        this.mMenuItemMap = new HashMap<>();
        int i = 0;
        initButton(1, this.mRtMenuView.findViewById(C9086R.id.richtext_todoBtn), new ItemCreator(RtMenuTodo.class.getConstructor(View.class), i));
        initButton(2, this.mRtMenuView.findViewById(C9086R.id.richtext_numberBtn), new ItemCreator(RtMenuNumbering.class.getConstructor(View.class), i));
        initButton(4, this.mRtMenuView.findViewById(C9086R.id.richtext_bulletBtn), new ItemCreator(RtMenuBullet.class.getConstructor(View.class), i));
        initButton(8, this.mRtMenuView.findViewById(C9086R.id.richtext_font_size), new ItemCreator(RtMenuFontSize.class.getConstructor(Activity.class, View.class, View.class), new Object[]{this.mActivity, this.mMenuContainer}, i));
        initButton(16, this.mRtMenuView.findViewById(C9086R.id.richtext_align), new ItemCreator(RtMenuAlign.class.getConstructor(View.class), i));
        initButton(32, this.mRtMenuView.findViewById(C9086R.id.richtext_textColorBtn), new ItemCreator(RtMenuTextColor.class.getConstructor(Activity.class, View.class, View.class), new Object[]{this.mActivity, this.mMenuContainer}, i));
        initButton(4096, this.mRtMenuView.findViewById(C9086R.id.richtext_textBgColorBtn), new ItemCreator(RtMenuTextBgColor.class.getConstructor(Activity.class, View.class, View.class), new Object[]{this.mActivity, this.mMenuContainer}, i));
        if (!(FeatureInfo.isAiFeatureEnabled() && this.mPresenter.isPDFReader()) && this.mPresenter.isSupportedAutoFormat()) {
            initButton(262144, this.mRtMenuView.findViewById(C9086R.id.toolbar_ai_menu), new ItemCreator(this.mComponentFactory.getRichTextAiMenu().getConstructor(View.class), i));
        } else {
            hideButton(C9086R.id.toolbar_ai_menu);
        }
        initButton(512, this.mRtMenuView.findViewById(C9086R.id.richtext_undo), new ItemCreator(RtMenuUndo.class.getConstructor(View.class), i));
        initButton(1024, this.mRtMenuView.findViewById(C9086R.id.richtext_redo), new ItemCreator(RtMenuRedo.class.getConstructor(View.class), i));
        if (zIsDynamicTemplateUuid) {
            hideButton(C9086R.id.toolbar_direct_write);
        } else {
            initButton(8192, this.mRtMenuView.findViewById(C9086R.id.toolbar_direct_write), new ItemCreator(RtMenuDirectWrite.class.getConstructor(View.class), i));
        }
        initButton(64, this.mRtMenuView.findViewById(C9086R.id.richtext_boldBtn), new ItemCreator(RtMenuBold.class.getConstructor(View.class), i));
        initButton(128, this.mRtMenuView.findViewById(C9086R.id.richtext_italicBtn), new ItemCreator(RtMenuItalic.class.getConstructor(View.class), i));
        initButton(256, this.mRtMenuView.findViewById(C9086R.id.richtext_underlineBtn), new ItemCreator(RtMenuUnderline.class.getConstructor(View.class), i));
        initButton(16384, this.mRtMenuView.findViewById(C9086R.id.richtext_strikethroughBtn), new ItemCreator(RtMenuStrikethrough.class.getConstructor(View.class), i));
        initButton(65536, this.mRtMenuView.findViewById(C9086R.id.richtext_indent), new ItemCreator(RtMenuIndent.class.getConstructor(View.class), i));
        initButton(131072, this.mRtMenuView.findViewById(C9086R.id.richtext_outdent), new ItemCreator(RtMenuOutdent.class.getConstructor(View.class), i));
        initButton(32768, this.mRtMenuView.findViewById(C9086R.id.richtext_align), new ItemCreator(RtMenuAlignPopup.class.getConstructor(View.class, View.class), new Object[]{this.mMenuContainer}, i));
        if (DeviceInfo.isVSTModel()) {
            initButton(2048, this.mRtMenuView.findViewById(C9086R.id.richtext_textStyleBtn), new ItemCreator(RtMenuTextStyle.class.getConstructor(View.class, View.class), new Object[]{this.mMenuContainer}, i));
        }
        if (zIsDynamicTemplateUuid) {
            hideButton(C9086R.id.richtext_textbox);
        } else {
            initButton(524288, this.mRtMenuView.findViewById(C9086R.id.richtext_textbox), new ItemCreator(RtMenuTextBox.class.getConstructor(View.class), i));
        }
        if (DeviceInfo.isVSTModel()) {
            initButton(2097152, this.mRtMenuView.findViewById(C9086R.id.richtext_move_only_mode), new ItemCreator(RtMenuMoveOnlyMode.class.getConstructor(View.class), i));
        }
        initButton(8388608, this.mRtMenuView.findViewById(C9086R.id.richtext_table_StyleBtn), new ItemCreator(RtMenuTable.class.getConstructor(View.class, View.class), new Object[]{this.mMenuContainer}, i));
        initButton(4194304, this.mRtMenuView.findViewById(C9086R.id.richtext_table_cell_StyleBtn), new ItemCreator(RtMenuTable.Cell.class.getConstructor(View.class, View.class), new Object[]{this.mMenuContainer}, i));
        hideButton(C9086R.id.richtext_table_StyleBtn, C9086R.id.richtext_table_cell_StyleBtn);
        if (this.mPresenter.isMde()) {
            this.mRtMenuView.findViewById(C9086R.id.richtext_text_format).setVisibility(8);
        } else {
            initButton(16777216, this.mRtMenuView.findViewById(C9086R.id.richtext_text_format), new ItemCreator(RtMenuTextFormat.class.getConstructor(Activity.class, View.class, View.class), new Object[]{this.mActivity, this.mMenuContainer}, i));
        }
        View viewFindViewById = this.mRtMenuView.findViewById(C9086R.id.richtext_toggleBtn);
        this.mToggleBtn = viewFindViewById;
        if (viewFindViewById != null) {
            ViewCompat.getInstance().setShadowAlpha(this.mToggleBtn, 0.5f);
            this.mToggleDockingAnimation = new ToggleDockingAnimation(this.mToggleBtn);
            this.mToggleBtn.setAccessibilityDelegate(new VoiceAssistAsButton());
            ViewCompat.getInstance().setTooltipText(this.mToggleBtn);
            this.mToggleBtn.setOnClickListener(new ViewOnClickListenerC8556a(this, 23));
            this.mToggleBtn.setOnLongClickListener(new ViewOnLongClickListenerC10789b());
            if (DeviceInfo.isVSTModel()) {
                ToolbarUtil.setBgRippleToolbar(this.mToggleBtn);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public boolean isDirectWriteRecognizing() {
        return this.mToolbarManager.isDirectWriteRecognizing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public boolean isDirectWriteUsing() {
        return this.mToolbarManager.isDirectWriteUsing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public boolean isShowing() {
        View view = this.mRtMenuView;
        return view != null && view.getVisibility() == 0;
    }

    public boolean onBackPressed() {
        return hideAllPopup();
    }

    public void onClickToggleButton() {
        if (this.mToolbarManager.canNotChangeMode()) {
            Logger.m11003i(TAG, "toggle button is clicked but blocked");
            return;
        }
        if (isDirectWriteUsing()) {
            setDirectWrite(false);
        }
        this.mPresenter.releaseAiDrawingPopup();
        clearSelectedButtonsToolbarItem();
        this.mPresenter.changeWritingMode();
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_PEN);
        } else {
            ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_PEN);
        }
    }

    public void onConfigurationChanged() {
        this.mMenuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RtToolbarMenu.this.mMenuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RtToolbarMenu.this.updateMenuItems();
                RtToolbarMenu.this.reReflectWidthByResourceQualifier();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void onDetach() {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return;
        }
        Iterator<RtMenuItem> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ExternalKeyboardManager.OnExternalKeyboardConnectedListener
    public void onExternalKeyboardConnected() {
        show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ExternalKeyboardManager.OnExternalKeyboardConnectedListener
    public void onExternalKeyboardDisconnected() {
        if (this.mToolbarManager.isSIPShowing()) {
            return;
        }
        hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
        if (this.mPresenter.shouldAlwaysShowInTextMode()) {
            return;
        }
        hide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void onInflated(View view) {
        this.mRtMenuView = view.findViewById(C9086R.id.rt_toolbar_menu_container);
        if (DeviceInfo.isVSTModel()) {
            this.mRtMenuView.setVisibility(4);
        } else {
            this.mRtMenuView.setVisibility(8);
        }
        this.mScrollView = view.findViewById(C9086R.id.rt_toolbar_scroll_view);
        this.mMenuItems = (ViewGroup) view.findViewById(C9086R.id.rt_toolbar_menu_item_container);
        try {
            initButtons();
        } catch (NoSuchMethodException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
        updateSupportedDirectWriteMenu();
        updateRedoUndoMenu();
        updateFontBgColor();
        updateRichTextState();
        setColorTheme(this.mToolbarManager.getBackgroundColor(), this.mToolbarManager.isBackgroundColorInverted(), this.mToolbarManager.hasBackgroundImage());
        this.mToolbarManager.addOnSipListener(this);
        this.mToolbarManager.addOnExternalKeyboardConnectedListener(this);
        if (DeviceInfo.isVSTModel()) {
            ToolbarUtil.adjustToolbarItemLayoutForVST(this.mRtMenuView.findViewById(C9086R.id.rt_toolbar_container), this.mMenuItems);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
    public void onObjectChanged() {
        Logger.m10999d(TAG, "onObjectChanged");
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(512);
        if (rtMenuItem != null) {
            ((RtMenuUndoRedo) rtMenuItem).onObjectChanged();
        }
        RtMenuItem rtMenuItem2 = this.mMenuItemMap.get(1024);
        if (rtMenuItem2 != null) {
            ((RtMenuUndoRedo) rtMenuItem2).onObjectChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void onPaletteListChanged(List<Integer> list) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(32);
        if (rtMenuItem == null) {
            return;
        }
        ((RtMenuTextColor) rtMenuItem).onPaletteListChanged(list);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
    public void onRedoable(boolean z) {
        String str = TAG;
        AbstractC8014b.m7220v("updateRedoMenu : ", str, z);
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(1024);
        if (rtMenuItem == null) {
            return;
        }
        if (z && !this.mPresenter.isEnableUndoRedoMenu()) {
            Logger.m10999d(str, "updateUndoMenu onRedoable isEnableUndoRedoMenu: false");
            z = false;
        }
        ((RtMenuRedo) rtMenuItem).updateUndoRedoMenu(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return;
        }
        Iterator<RtMenuItem> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
        bundle.putBoolean(KEY_TR_TOOLBAR_ENABLED, this.mEnabled);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        if (this.mPresenter.shouldAlwaysShowInTextMode()) {
            return;
        }
        show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
    public void onUndoable(boolean z) {
        String str = TAG;
        AbstractC8014b.m7220v("updateUndoMenu : ", str, z);
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(512);
        if (rtMenuItem == null) {
            return;
        }
        if (z && !this.mPresenter.isEnableUndoRedoMenu()) {
            Logger.m10999d(str, "updateUndoMenu isEnableUndoRedoMenu: false");
            z = false;
        }
        ((RtMenuUndo) rtMenuItem).updateUndoRedoMenu(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void onUpdateTask(int i) {
        for (int i2 : i != 4 ? i != 8 ? new int[]{4, 2} : new int[]{1, 2} : new int[]{4, 1}) {
            RtMenuItem rtMenuItem = this.mMenuItemMap.get(Integer.valueOf(i2));
            if (rtMenuItem != null) {
                rtMenuItem.getView().setSelected(false);
            }
        }
    }

    public void onWindowFocusChanged() {
        updateSupportedDirectWriteMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void release() {
        super.release();
        Logger.m11003i(TAG, "release");
        RtToolbarPresenter rtToolbarPresenter = this.mPresenter;
        if (rtToolbarPresenter != null) {
            rtToolbarPresenter.setView(null);
            this.mPresenter.releaseHistoryEventListener();
        }
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map != null) {
            Iterator<RtMenuItem> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.mToolbarManager.removeOnSipListener(this);
        this.mToolbarManager.removeOnExternalKeyboardConnectedListener(this);
    }

    public void reloadToolbarMenu() {
        updateRedoUndoMenu();
        updateSupportedDirectWriteMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    /* JADX INFO: renamed from: restore, reason: merged with bridge method [inline-methods] */
    public void lambda$restore$4(Bundle bundle) {
        if (!isInflated()) {
            addPendingActionAfterInflate(new RunnableC9844c(this, bundle, 25));
            return;
        }
        Iterator<RtMenuItem> it = this.mMenuItemMap.values().iterator();
        while (it.hasNext()) {
            it.next().restore(bundle);
        }
        enableToolbar(bundle.getBoolean(KEY_TR_TOOLBAR_ENABLED, true));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public void setDirectWrite(boolean z) {
        this.mToolbarManager.setDirectWrite(z);
    }

    public void setEnableToolTip(boolean z) {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return;
        }
        Iterator<RtMenuItem> it = map.values().iterator();
        while (true) {
            CharSequence contentDescription = "";
            if (!it.hasNext()) {
                break;
            }
            RtMenuItem next = it.next();
            ViewCompat viewCompat = ViewCompat.getInstance();
            View view = next.getView();
            if (z) {
                contentDescription = next.getView().getContentDescription();
            }
            viewCompat.setTooltipText(view, contentDescription);
        }
        if (this.mToggleBtn != null) {
            if (z) {
                ViewCompat.getInstance().setTooltipText(this.mToggleBtn);
            } else {
                ViewCompat.getInstance().setTooltipText(this.mToggleBtn, "");
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void show() {
        if (this.mPresenter.isTextMode()) {
            if (!isInflated()) {
                addPendingActionAfterInflate(new RunnableC10788a(this, 1));
                return;
            }
            updateAiMenu(this.mPresenter.isShowingAiMenu());
            showAction();
            boolean zIsDirectWriteUsing = isDirectWriteUsing();
            updateDirectWrite(zIsDirectWriteUsing);
            if (this.mToggleBtn != null) {
                ViewCompat.getInstance().setTooltipText(this.mToggleBtn, "");
            }
            if (DeviceInfo.isVSTModel()) {
                this.mPresenter.registerHistoryEventListener();
            }
            if (zIsDirectWriteUsing) {
                this.mScrollView.post(new RunnableC10788a(this, 2));
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showAlignPopup(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(32768);
        if (rtMenuItem instanceof RtMenuAlignPopup) {
            ((RtMenuAlignPopup) rtMenuItem).showPopupAsDropDown(view, onClickValueListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public void showDirectWrite() {
        this.mToolbarManager.showDirectWrite();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showFontColorSetting(final View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(32);
        if (rtMenuItem instanceof RtMenuTextColor) {
            ((RtMenuTextColor) rtMenuItem).showPopupWithListener(new RtColorPopup.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.Contract
                public Point getAnchorPosition() {
                    return new Point(0, 0);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.setting.RtColorPopup.Contract
                @Nullable
                public View getSpecifiedAnchorView() {
                    return view;
                }
            }, onClickValueListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showFontSize(View view, RtToolbarContract.OnClickValueListener onClickValueListener) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(8);
        if (rtMenuItem instanceof RtMenuFontSize) {
            ((RtMenuFontSize) rtMenuItem).showPopupAsDropDown(view, onClickValueListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showTableCellSetting(CellStyle cellStyle) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(4194304);
        if (rtMenuItem instanceof RtMenuTable.Cell) {
            ((RtMenuTable.Cell) rtMenuItem).showPopup(cellStyle);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showTableSetting(TableStyle tableStyle) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(8388608);
        if (rtMenuItem instanceof RtMenuTable) {
            ((RtMenuTable) rtMenuItem).showPopup(tableStyle);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void showTextColor(boolean z) {
        if (z) {
            RtMenuItem rtMenuItem = this.mMenuItemMap.get(4096);
            if (rtMenuItem instanceof RtMenuTextBgColor) {
                ((RtMenuTextBgColor) rtMenuItem).showPopup();
                return;
            }
            return;
        }
        RtMenuItem rtMenuItem2 = this.mMenuItemMap.get(32);
        if (rtMenuItem2 instanceof RtMenuTextColor) {
            ((RtMenuTextColor) rtMenuItem2).showPopup();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    /* JADX INFO: renamed from: update, reason: merged with bridge method [inline-methods] */
    public void lambda$update$3(SpanStates spanStates) {
        if (!isInflated()) {
            addPendingActionAfterInflate(new RunnableC9844c(this, spanStates, 26));
            return;
        }
        Logger.m11003i(TAG, "update# by rtState");
        Iterator<RtMenuItem> it = this.mMenuItemMap.values().iterator();
        while (it.hasNext()) {
            it.next().updateState(spanStates);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateAiMenu(boolean z) {
        RtMenuItem rtMenuItem = this.mMenuItemMap.get(262144);
        if (rtMenuItem != null) {
            if (this.mPresenter.isSupportedAutoFormat()) {
                rtMenuItem.setSelected(z);
            } else {
                hideButton(C9086R.id.toolbar_ai_menu);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateBackgroundColor(int i, boolean z, boolean z2) {
        setColorTheme(i, z, z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem.IRtToolbarMenu
    public void updateDirectWrite(boolean z) {
        RtMenuItem rtMenuItem;
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null || (rtMenuItem = map.get(8192)) == null) {
            return;
        }
        rtMenuItem.setSelected(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateEnableUndoRedoMenu(boolean z) {
        boolean z2 = false;
        onUndoable(z && this.mPresenter.getComposerViewPresenter().getUndoRedoPresenter().isUndoable());
        if (z && this.mPresenter.getComposerViewPresenter().getUndoRedoPresenter().isRedoable()) {
            z2 = true;
        }
        onRedoable(z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateFontBgColor(int i) {
        this.mToolbarManager.setSpenColorThemeUtil(i);
        updateFontBgColor();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateFontSize() {
        RtMenuItem rtMenuItem;
        if (this.mMenuItemMap == null || !this.mPresenter.needToUpdateFontSize() || (rtMenuItem = this.mMenuItemMap.get(8)) == null) {
            return;
        }
        rtMenuItem.updateState(this.mPresenter.getLastRtState());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateTextStyles() {
        updateTextStylesButtons(true);
    }

    public void updateTextStylesButtons(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mRtMenuView.findViewById(C9086R.id.richtext_favorite_container);
        int i = 0;
        viewGroup.setVisibility(0);
        viewGroup.removeAllViewsInLayout();
        int styleCount = this.mPresenter.getRtTextStylePresenter().getStyleCount();
        int i2 = 0;
        while (i2 < styleCount) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_btn_favorite_textstyle, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(C9086R.id.richtext_favorite_textStyle_text);
            StringBuilder sb = new StringBuilder("T");
            int i4 = i2 + 1;
            sb.append(i4);
            textView.setText(sb.toString());
            viewGroup.addView(viewGroup2);
            try {
                initButton(1048576 + i2, viewGroup2, new ItemCreator(RtMenuFavoriteStyle.class.getConstructor(View.class, Integer.class, View.class), new Object[]{this.mMenuContainer, Integer.valueOf(i2)}, i));
                i2 = i4;
            } catch (NoSuchMethodException e) {
                Logger.m11000e(TAG, "updateTextStylesButtons# e = " + e);
                return;
            }
        }
        if (z) {
            viewGroup.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.IView
    public void updateUndoRedo(boolean z, boolean z2) {
        onRedoable(z);
        onUndoable(z2);
    }

    private void updateFontBgColor() {
        HashMap<Integer, RtMenuItem> map = this.mMenuItemMap;
        if (map == null) {
            return;
        }
        RtMenuItem rtMenuItem = map.get(4096);
        if (rtMenuItem != null) {
            ((RtMenuTextBgColor) rtMenuItem).updateFontBgColor();
        }
        RtMenuItem rtMenuItem2 = this.mMenuItemMap.get(32);
        if (rtMenuItem2 != null) {
            ((RtMenuTextColor) rtMenuItem2).updateFontColor();
        }
    }
}
