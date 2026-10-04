package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.AbsShortCutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.keyshortcut.KeyboardShortcutManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.keyshortcut.NotEditKeyboardShortcutManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShortCutManager implements ListenerImplContract.IShortCutManager {
    private static final int SKIP_BLE_CLICK_EVENT_TIME = 400;
    private static final String TAG = Logger.createTag("ShortCutManager");
    private final boolean mEnabled;
    private long mKeyCopy;
    private long mKeyCut;
    private long mKeyPaste;
    private long mKeySelectAll;
    protected ModeManager mModeManager;
    private OnUnhandledKeyEventListenerImpl mOnUnhandledKeyEventListener;
    protected ProgressController mProgressController;
    private WritingToolManager mWritingToolManager;
    protected Map<Long, AbsShortCutAction> mShortCutMap = new HashMap();
    protected Map<Long, AbsShortCutAction> mBLEShortCutMap = new HashMap();
    protected Map<Long, AbsShortCutAction> mGlobalShortCutMap = new HashMap();
    private long mLastTouchWithBtnTime = 0;
    private int mCurrentTouchAction = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(api = 28)
    public static class OnUnhandledKeyEventListenerImpl implements View$OnUnhandledKeyEventListener {
        ShortCutManager mShortCutManager;

        public /* synthetic */ OnUnhandledKeyEventListenerImpl(int i) {
            this();
        }

        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ShortCutManager shortCutManager = this.mShortCutManager;
            return shortCutManager != null && shortCutManager.onUnhandledKeyEvent(keyEvent);
        }

        public void release() {
            this.mShortCutManager = null;
        }

        public void setShortCutManager(ShortCutManager shortCutManager) {
            this.mShortCutManager = shortCutManager;
        }

        private OnUnhandledKeyEventListenerImpl() {
        }
    }

    public ShortCutManager(boolean z) {
        this.mEnabled = z;
    }

    private boolean doAction(KeyEvent keyEvent, Map<Long, AbsShortCutAction> map) {
        ModeManager modeManager;
        long jConvertKey = AbsShortCutAction.convertKey(keyEvent);
        AbsShortCutAction absShortCutAction = map.get(Long.valueOf(jConvertKey));
        if (absShortCutAction == null) {
            return false;
        }
        String str = TAG;
        Logger.m11003i(str, "doAction# " + jConvertKey + " action" + absShortCutAction);
        if (absShortCutAction.isEditType() && (modeManager = this.mModeManager) != null && !modeManager.isEditMode()) {
            return false;
        }
        if (!this.mWritingToolManager.isFloatingViewShown()) {
            return absShortCutAction.doAction(keyEvent);
        }
        Logger.m11003i(str, "doAction# skip action. clearControl is true.");
        return false;
    }

    private boolean isTouchAction() {
        int i = this.mCurrentTouchAction;
        return i == 0 || i == 211 || i == 2 || i == 213;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl.ISipContextMenu
    public boolean copy() {
        AbsShortCutAction absShortCutAction = this.mShortCutMap.get(Long.valueOf(this.mKeyCopy));
        return absShortCutAction != null && absShortCutAction.doAction();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl.ISipContextMenu
    public boolean cut() {
        AbsShortCutAction absShortCutAction = this.mShortCutMap.get(Long.valueOf(this.mKeyCut));
        return absShortCutAction != null && absShortCutAction.doAction();
    }

    public KeyboardShortcutGroup getKeyboardShortcutGroup(Activity activity, ComposerModel composerModel) {
        return ((composerModel.isEditable() && composerModel.getMdeInfo().hasWritePermission()) ? new KeyboardShortcutManager() : new NotEditKeyboardShortcutManager()).getKeyboardShortcutGroup(activity, composerModel.isSingleMode(), composerModel.getModeManager().getMode());
    }

    @RequiresApi(api = 28)
    public View$OnUnhandledKeyEventListener getOnUnhandledKeyEventListener(boolean z) {
        if (this.mOnUnhandledKeyEventListener == null) {
            this.mOnUnhandledKeyEventListener = new OnUnhandledKeyEventListenerImpl(0);
        }
        if (z) {
            this.mOnUnhandledKeyEventListener.release();
        } else {
            this.mOnUnhandledKeyEventListener.setShortCutManager(this);
        }
        return this.mOnUnhandledKeyEventListener;
    }

    @SuppressLint({"UseSparseArrays"})
    public void init(ContextMenuManager contextMenuManager, ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter, RtToolbarPresenter rtToolbarPresenter, CompListPresenter compListPresenter, OptionMenuPresenter optionMenuPresenter, ActionManager actionManager) {
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mWritingToolManager = composerViewPresenter.getWritingToolManager();
        this.mProgressController = controllerManager.getProgressController();
        if (this.mEnabled) {
            ShortCutGenerator shortCutGeneratorGenerate = new ShortCutGenerator(controllerManager, composerViewPresenter, hwToolbarPresenter, rtToolbarPresenter, optionMenuPresenter, actionManager).generateBLE(this.mBLEShortCutMap).generateContextMenu(this.mShortCutMap, this.mGlobalShortCutMap, contextMenuManager, compListPresenter).generate(this.mShortCutMap);
            this.mKeyCopy = shortCutGeneratorGenerate.getKeyCopy();
            this.mKeyCut = shortCutGeneratorGenerate.getKeyCut();
            this.mKeyPaste = shortCutGeneratorGenerate.getKeyPaste();
            this.mKeySelectAll = shortCutGeneratorGenerate.getKeySelectAll();
        }
    }

    public boolean onBLEShortcutFromActivity(KeyEvent keyEvent) {
        if (isTouchAction()) {
            AbstractC8014b.m7195A(new StringBuilder("skip BLE key event because it has been touching the screen "), TAG, this.mCurrentTouchAction);
            return false;
        }
        if (keyEvent.getEventTime() - this.mLastTouchWithBtnTime > 400) {
            return doAction(keyEvent, this.mBLEShortCutMap);
        }
        Logger.m11003i(TAG, "skip BLE key event " + (keyEvent.getEventTime() - this.mLastTouchWithBtnTime));
        return false;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (!this.mProgressController.isLockedScreen()) {
            return onKey(keyEvent);
        }
        Logger.m11003i(TAG, "ShortCut# Progress is running. return");
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mCurrentTouchAction = motionEvent.getAction();
        if (motionEvent.getButtonState() != 32) {
            return false;
        }
        if (motionEvent.getAction() == 212 || motionEvent.getAction() == 213) {
            this.mLastTouchWithBtnTime = motionEvent.getEventTime();
        }
        return false;
    }

    public boolean onUnhandledKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (!this.mProgressController.isLockedScreen()) {
            return doAction(keyEvent, this.mGlobalShortCutMap);
        }
        Logger.m11003i(TAG, "onUnhandledKeyEvent# Progress is running. return");
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl.ISipContextMenu
    public boolean paste() {
        AbsShortCutAction absShortCutAction = this.mShortCutMap.get(Long.valueOf(this.mKeyPaste));
        return absShortCutAction != null && absShortCutAction.doAction();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl.ISipContextMenu
    public boolean selectAll() {
        AbsShortCutAction absShortCutAction = this.mShortCutMap.get(Long.valueOf(this.mKeySelectAll));
        return absShortCutAction != null && absShortCutAction.doAction();
    }

    private boolean onKey(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && (keyEvent.getFlags() & 33554432) == 0) {
            return doAction(keyEvent, this.mShortCutMap);
        }
        return false;
    }
}
