package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuBackspace;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuEmoji;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuEnter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuKeyboard;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuSetting;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuSpace;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteMenu extends AbsAsyncInflater implements DwToolbarContract.IView {
    private static final String DW_TOOLBAR_SHOWN = "DW_Toolbar_Shown";
    private static final String TAG = Logger.createTag("DirectWriteMenu");
    private final Activity mActivity;
    private boolean mDirectWriteToolbarShown;
    private DirectWriteContainerLayout mDwContainerLayout;
    private final FloaterContainer mFloatingArea;
    private HashMap<Integer, DwMenuItem> mMenuItemMap;
    private final DwToolbarPresenter mPresenter;
    private final IToolbarManager mToolbarManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemCreator {
        Constructor constructor;
        Object[] initArgs;

        public /* synthetic */ ItemCreator(Constructor constructor, int i) {
            this(constructor);
        }

        public DwMenuItem create(View view) {
            try {
                Object[] objArr = this.initArgs;
                return objArr == null ? (DwMenuItem) this.constructor.newInstance(view) : objArr.length == 1 ? (DwMenuItem) this.constructor.newInstance(objArr[0], view) : (DwMenuItem) this.constructor.newInstance(objArr[0], objArr[1], view);
            } catch (IllegalAccessException e) {
                e = e;
                Logger.m11000e(DirectWriteMenu.TAG, e.getMessage());
                return null;
            } catch (InstantiationException e2) {
                e = e2;
                Logger.m11000e(DirectWriteMenu.TAG, e.getMessage());
                return null;
            } catch (InvocationTargetException e3) {
                e = e3;
                Logger.m11000e(DirectWriteMenu.TAG, e.getMessage());
                return null;
            }
        }

        private ItemCreator(Constructor constructor) {
            this.constructor = constructor;
        }

        private ItemCreator(Constructor constructor, Object... objArr) {
            this.constructor = constructor;
            this.initArgs = objArr;
        }
    }

    public DirectWriteMenu(Activity activity, ViewGroup viewGroup, IToolbarManager iToolbarManager, DwToolbarPresenter dwToolbarPresenter) {
        super(viewGroup.getContext());
        this.mDirectWriteToolbarShown = false;
        this.mActivity = activity;
        this.mPresenter = dwToolbarPresenter;
        this.mToolbarManager = iToolbarManager;
        dwToolbarPresenter.setView(this);
        FloaterContainer floaterContainer = (FloaterContainer) viewGroup.findViewById(C9086R.id.floating_layout_container);
        this.mFloatingArea = floaterContainer;
        asyncInflate(C9086R.layout.comp_direct_write_floating_toolbar_menu, floaterContainer);
    }

    private void initButton(int i, View view, ItemCreator itemCreator) {
        if (view == null) {
            Logger.m11000e(TAG, "initButton# menuView is null");
            return;
        }
        DwMenuItem dwMenuItemCreate = itemCreator.create(view);
        if (dwMenuItemCreate == null) {
            Logger.m11000e(TAG, "initButton# dwMenuItem is null");
            return;
        }
        this.mMenuItemMap.put(Integer.valueOf(i), dwMenuItemCreate);
        dwMenuItemCreate.init(this.mPresenter);
        ToolbarUtil.setBgRippleToolbar(dwMenuItemCreate.getView());
        dwMenuItemCreate.getView().setAccessibilityDelegate(new VoiceAssistAsButton());
    }

    @SuppressLint({"UseSparseArrays"})
    private void initButtons() {
        this.mMenuItemMap = new HashMap<>();
        int i = 0;
        initButton(1, this.mDwContainerLayout.findViewById(C9086R.id.dw_setting), new ItemCreator(DwMenuSetting.class.getConstructor(View.class), i));
        initButton(32, this.mDwContainerLayout.findViewById(C9086R.id.dw_emoji), new ItemCreator(DwMenuEmoji.class.getConstructor(View.class), i));
        initButton(2, this.mDwContainerLayout.findViewById(C9086R.id.dw_space), new ItemCreator(DwMenuSpace.class.getConstructor(View.class), i));
        initButton(4, this.mDwContainerLayout.findViewById(C9086R.id.dw_backspace), new ItemCreator(DwMenuBackspace.class.getConstructor(View.class), i));
        initButton(8, this.mDwContainerLayout.findViewById(C9086R.id.dw_keyboard), new ItemCreator(DwMenuKeyboard.class.getConstructor(View.class), i));
        initButton(16, this.mDwContainerLayout.findViewById(C9086R.id.dw_enter), new ItemCreator(DwMenuEnter.class.getConstructor(View.class), i));
        this.mDwContainerLayout.setMenuItemMap(this.mMenuItemMap);
    }

    private void setItemEnable(boolean z, int[] iArr) {
        if (this.mMenuItemMap == null) {
            return;
        }
        for (int i : iArr) {
            DwMenuItem dwMenuItem = this.mMenuItemMap.get(Integer.valueOf(i));
            if (dwMenuItem != null) {
                dwMenuItem.setEnable(z);
            }
        }
    }

    private void updateEmojiValidation() {
        DwMenuItem dwMenuItem = this.mMenuItemMap.get(32);
        if (dwMenuItem != null) {
            dwMenuItem.getView().setVisibility(this.mPresenter.isSupportEmoji() ? 0 : 8);
        }
    }

    public void close() {
        hide();
        this.mPresenter.setDirectWriteState(false);
        this.mDirectWriteToolbarShown = false;
    }

    public void directShow() {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteMenu.2
                @Override // java.lang.Runnable
                public void run() {
                    DirectWriteMenu.this.directShow();
                }
            });
            return;
        }
        if (!this.mDwContainerLayout.isShowing()) {
            this.mDwContainerLayout.show();
            this.mPresenter.addPreTouchListener(this.mDwContainerLayout.getPreTouchListener());
        }
        this.mPresenter.setDirectWritingEnable(true);
        updateEmojiValidation();
        updateKeyboardSupport();
        this.mDirectWriteToolbarShown = true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public Rect getVisibleRect() {
        int[] iArr = new int[2];
        this.mDwContainerLayout.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], this.mDwContainerLayout.getWidth(), this.mDwContainerLayout.getHeight());
    }

    public void hide() {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteMenu.3
                @Override // java.lang.Runnable
                public void run() {
                    DirectWriteMenu.this.hide();
                }
            });
            return;
        }
        this.mPresenter.blockSoftInput(false);
        this.mDwContainerLayout.hide();
        this.mPresenter.removePreTouchListener(this.mDwContainerLayout.getPreTouchListener());
        this.mPresenter.setDirectWritingEnable(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public boolean isDirectWriteRecognizing() {
        return this.mPresenter.isDirectWriteRecognizing();
    }

    public boolean isLastShowing() {
        return this.mPresenter.isDirectWriteEnable() && this.mDirectWriteToolbarShown;
    }

    public boolean isUsing() {
        return this.mPresenter.isDirectWriteEnable();
    }

    public void onConfigurationChanged() {
        updateKeyboardSupport();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void onInflated(View view) {
        DirectWriteContainerLayout directWriteContainerLayout = (DirectWriteContainerLayout) view.findViewById(C9086R.id.dw_toolbar_menu_container);
        this.mDwContainerLayout = directWriteContainerLayout;
        this.mFloatingArea.addFloater(directWriteContainerLayout);
        this.mFloatingArea.setClipChildren(false);
        try {
            initButtons();
        } catch (NoSuchMethodException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putBoolean(DW_TOOLBAR_SHOWN, this.mDirectWriteToolbarShown);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public void onSpenToTextResultInserted() {
        directShow();
    }

    public void onWindowFocusChanged() {
        updateKeyboardSupport();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public void restore(final Bundle bundle) {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteMenu.1
                @Override // java.lang.Runnable
                public void run() {
                    DirectWriteMenu.this.restore(bundle);
                }
            });
            return;
        }
        if (!this.mToolbarManager.isSupportDirectWrite(this.mActivity) && isUsing()) {
            this.mPresenter.setDirectWriteState(false);
            return;
        }
        boolean z = bundle.getBoolean(DW_TOOLBAR_SHOWN, false);
        this.mDirectWriteToolbarShown = z;
        if (z && isUsing() && !this.mDwContainerLayout.isShowing()) {
            directShow();
        }
    }

    public void setDirectWrite(boolean z) {
        if (z) {
            this.mPresenter.setDirectWriteState(this.mToolbarManager.isSupportDirectWrite(this.mActivity));
        } else {
            close();
        }
    }

    public void setDirectWriteColor(int i, int i2) {
        this.mPresenter.setDirectWritingTextColor(i, i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarContract.IView
    public void setKeyboardFunctionKeyEnable(boolean z) {
        setItemEnable(z, DwMenuConstants.KEYBOARD_FUNCTION_BUTTONS);
    }

    public void show() {
    }

    public void updateKeyboardSupport() {
        setItemEnable(this.mPresenter.isSupportSoftKeyboard(), DwMenuConstants.KEYBOARD_BUTTONS);
    }
}
