package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.window.layout.FoldingFeature;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IDock;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExternalKeyboardManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.HwToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.VstHwToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini.HwSettingPenMiniMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.TableAndCellMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.translation.TranslationLanguageMenu;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToolbarManager implements IToolbarManager, ToolbarContract.IView, AbsToolbarContainerLayout.OnAnimationListener, NavigationBarUtil.OnChangedListener {
    private static final String TAG = "ToolbarManager";
    private final ComponentFactory mComponentFactory;
    private int mCountMoveEvent;
    private DirectWriteMenu mDirectWriteMenu;
    private FloaterContainer mFloatingArea;
    private AbsToolbarContainerLayout mFloatingContainer;
    private HwSettingPenMiniMenu mHwSettingPenMiniMenu;
    private HwToolbarMenu mHwToolbarMenu;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private ToolbarPresenter mPresenter;
    private QuickTool mQuickTool;
    private RtToolbarMenu mRtMenu;
    private View.OnTouchListener mSettingAreaTouchListener;
    private SpenColorThemeUtil mSpenColorThemeUtil;
    private TableAndCellMenu mTableAndCellMenu;
    private TranslationLanguageMenu mTranslationLanguageMenu;
    private boolean mConsumeTouchOutside = false;
    private boolean mIsReadySingleTapUp = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends RtToolbarMenu.ComponentFactory, HwToolbarOrderManager.ComponentFactory {
    }

    public ToolbarManager(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
    }

    private void addPreTouchListeners() {
        this.mPresenter.addPreTouchListener(this.mPreTouchListener);
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            this.mPresenter.addPreTouchListener(absToolbarContainerLayout.getPreTouchListener());
        }
    }

    private HwToolbarMenu createHwToolbarMenu(Activity activity, ViewGroup viewGroup, HwToolbarPresenter hwToolbarPresenter) {
        return DeviceInfo.isVSTModel() ? new VstHwToolbarMenu(activity, viewGroup, this, hwToolbarPresenter, this.mComponentFactory) : new HwToolbarMenu(activity, viewGroup, this, hwToolbarPresenter, this.mComponentFactory);
    }

    private void makePreTouchListener(Context context) {
        final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.5
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                Logger.m11003i(ToolbarManager.TAG, "onSingleTapUp after touch outside is consumed " + ToolbarManager.this.mConsumeTouchOutside + " / " + ToolbarManager.this.mCountMoveEvent);
                if (!ToolbarManager.this.mConsumeTouchOutside || ToolbarManager.this.mCountMoveEvent >= 10) {
                    return false;
                }
                ToolbarManager.this.mPresenter.requestCancelTouch();
                ToolbarManager.this.mConsumeTouchOutside = false;
                ToolbarManager.this.mIsReadySingleTapUp = false;
                return true;
            }
        });
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.6
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 211) && ToolbarManager.this.mIsReadySingleTapUp) {
                    ToolbarManager.this.mIsReadySingleTapUp = false;
                    ToolbarManager.this.mConsumeTouchOutside = false;
                }
                if (ToolbarManager.this.mConsumeTouchOutside) {
                    gestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1 || motionEvent.getAction() == 212) {
                        if (ToolbarManager.this.mConsumeTouchOutside) {
                            ToolbarManager.this.mIsReadySingleTapUp = true;
                        }
                    } else if (motionEvent.getAction() == 2 || motionEvent.getAction() == 213) {
                        ToolbarManager.this.mCountMoveEvent++;
                        return false;
                    }
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDockingMode(boolean z) {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.enableDockingMode(z);
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.enableDockingMode(z);
            if (this.mPresenter.isTabletLayout()) {
                this.mRtMenu.enablePaddingMode(z);
            }
        }
    }

    private void releasePreTouchListeners() {
        AbsToolbarContainerLayout absToolbarContainerLayout;
        SpenPreTouchListenerImpl.PreTouchListener preTouchListener;
        ToolbarPresenter toolbarPresenter = this.mPresenter;
        if (toolbarPresenter != null && (preTouchListener = this.mPreTouchListener) != null) {
            toolbarPresenter.removePreTouchListener(preTouchListener);
        }
        ToolbarPresenter toolbarPresenter2 = this.mPresenter;
        if (toolbarPresenter2 == null || (absToolbarContainerLayout = this.mFloatingContainer) == null) {
            return;
        }
        toolbarPresenter2.removePreTouchListener(absToolbarContainerLayout.getPreTouchListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSAStatusLog(int i, int i2) {
        if (i2 == 0) {
            if (i == 1 || i == 0) {
                ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "b");
                return;
            } else {
                ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "f");
                return;
            }
        }
        if (i == 1) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "c");
            return;
        }
        if (i == 0) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "a");
        } else if (i == 2) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "d");
        } else if (i == 3) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_HW_TOOLBAR_POSITION, "e");
        }
    }

    private void setTouchListener(boolean z) {
        this.mFloatingArea.setOnTouchListener(!z ? this.mSettingAreaTouchListener : null);
    }

    private void setVerticalHalfOpened(boolean z) {
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            absToolbarContainerLayout.setVerticalHalfOpened(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void addOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        this.mPresenter.addOnExternalKeyboardConnectedListener(onExternalKeyboardConnectedListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void addOnSipListener(SoftInputManager.OnSipListener onSipListener) {
        this.mPresenter.addOnSipListener(onSipListener);
    }

    public void attachDirectWriteMenu(Activity activity, DwToolbarPresenter dwToolbarPresenter) {
        if (this.mDirectWriteMenu == null) {
            this.mDirectWriteMenu = new DirectWriteMenu(activity, (ViewGroup) activity.getWindow().getDecorView(), this, dwToolbarPresenter);
        }
    }

    public void attachHwToolbarMenu(Activity activity, HwToolbarPresenter hwToolbarPresenter, boolean z) {
        initSpenColorThemeUtil(activity);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu == null) {
            this.mHwToolbarMenu = createHwToolbarMenu(activity, viewGroup, hwToolbarPresenter);
        } else if (z) {
            hwToolbarMenu.reloadToolbarMenu();
        }
        if (this.mHwSettingPenMiniMenu == null && hwToolbarPresenter.isTabletLayout()) {
            this.mHwSettingPenMiniMenu = new HwSettingPenMiniMenu(viewGroup, hwToolbarPresenter);
        }
    }

    public void attachQuickTool(QuickToolPresenter quickToolPresenter, ViewGroup viewGroup, SpenComposer spenComposer, View view) {
        QuickTool quickTool = this.mQuickTool;
        if (quickTool == null) {
            this.mQuickTool = new QuickTool(quickToolPresenter, viewGroup, spenComposer, view);
        } else {
            quickTool.reloadQuickTool(viewGroup, spenComposer, view);
        }
    }

    public void attachRichTextMenu(Activity activity, RtToolbarPresenter rtToolbarPresenter, boolean z) {
        initSpenColorThemeUtil(activity);
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu == null) {
            this.mRtMenu = new RtToolbarMenu(activity, (ViewGroup) activity.getWindow().getDecorView(), this, rtToolbarPresenter, this.mComponentFactory);
        } else if (z) {
            rtToolbarMenu.reloadToolbarMenu();
        }
    }

    public void attachTableAndCellMenu(Activity activity, TableAndCellPresenter tableAndCellPresenter) {
        if (this.mTableAndCellMenu == null) {
            this.mTableAndCellMenu = new TableAndCellMenu((ViewGroup) activity.getWindow().getDecorView(), tableAndCellPresenter);
        }
    }

    public void attachToolbar(Activity activity, ToolbarPresenter toolbarPresenter) {
        if (this.mFloatingContainer != null) {
            return;
        }
        this.mPresenter = toolbarPresenter;
        toolbarPresenter.setView(this);
        View decorView = activity.getWindow().getDecorView();
        this.mFloatingArea = (FloaterContainer) decorView.findViewById(C9086R.id.floating_layout_container);
        if (DeviceInfo.isVSTModel()) {
            this.mFloatingContainer = (AbsToolbarContainerLayout) this.mFloatingArea.findViewById(C9086R.id.vst_floating_layout);
        } else {
            this.mFloatingContainer = (AbsToolbarContainerLayout) this.mFloatingArea.findViewById(C9086R.id.floating_layout);
        }
        this.mFloatingArea.addFloater(this.mFloatingContainer);
        this.mFloatingContainer.setOnAnimationListener(this);
        this.mFloatingContainer.setMultiWindowMode(WindowManagerCompat.getInstance().isMultiWindowMode(activity));
        this.mFloatingContainer.addDock(0, (IDock) decorView.findViewById(C9086R.id.top_docker));
        this.mFloatingContainer.addDock(1, (IDock) decorView.findViewById(C9086R.id.bottom_docker));
        if (this.mPresenter.isTabletLayout() || DeviceInfo.isVSTModel()) {
            this.mFloatingContainer.addDock(2, (IDock) decorView.findViewById(C9086R.id.start_docker));
            this.mFloatingContainer.addDock(3, (IDock) decorView.findViewById(C9086R.id.end_docker));
        }
        NavigationBarUtil.addNavigationHideModeChangeListener(this);
        this.mFloatingContainer.setToolbar(decorView.findViewById(C9086R.id.toolbar));
        this.mFloatingContainer.setOnToolbarPositionListener(new AbsToolbarContainerLayout.OnToolbarPositionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout.OnToolbarPositionListener
            public boolean onSetToolbarPosition(Rect rect, boolean z) {
                if (ToolbarManager.this.mHwToolbarMenu == null) {
                    return false;
                }
                ToolbarManager.this.mHwToolbarMenu.onSetToolbarPosition(rect, z);
                return false;
            }
        });
        this.mFloatingContainer.addModeChangeListener(new IFloater.ModeChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.2
            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.ModeChangeListener
            public void onModeChanged(int i) {
                if (i == 2) {
                    ToolbarManager.this.onDockingMode(true);
                } else if (i == 0) {
                    ToolbarManager.this.onDockingMode(false);
                }
                if (ToolbarManager.this.mFloatingContainer != null) {
                    ToolbarManager toolbarManager = ToolbarManager.this;
                    toolbarManager.sendSAStatusLog(toolbarManager.mFloatingContainer.getDockingType(), ToolbarManager.this.mFloatingContainer.getState());
                }
            }
        });
        this.mFloatingContainer.setContract(new IFloater.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.3
            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.IContract
            public int getSnappingDelta(int i, int i2) {
                if (ToolbarManager.this.mHwToolbarMenu != null && !ToolbarManager.this.mHwToolbarMenu.isTextMode() && ToolbarManager.this.mHwToolbarMenu.isShowing()) {
                    return ToolbarManager.this.mHwToolbarMenu.getDeltaToAvoidOverlap(i, i2);
                }
                if (ToolbarManager.this.mRtMenu == null || !ToolbarManager.this.mRtMenu.isShowing()) {
                    return 0;
                }
                return ToolbarManager.this.mRtMenu.getDeltaToAvoidOverlap(i, i2);
            }
        });
        this.mSettingAreaTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.ToolbarManager.4
            /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 211) {
                    if (ToolbarManager.this.mHwToolbarMenu != null && ToolbarManager.this.mHwToolbarMenu.onTouchOutside()) {
                        ToolbarManager.this.mConsumeTouchOutside = true;
                        ToolbarManager.this.mCountMoveEvent = 0;
                        if (!ToolbarManager.this.mQuickTool.isShowing() || !ToolbarManager.this.mQuickTool.isFloating()) {
                        }
                    } else if (ToolbarManager.this.mHwSettingPenMiniMenu != null && ToolbarManager.this.mHwSettingPenMiniMenu.onTouchOutside()) {
                        return true;
                    }
                }
                return false;
            }
        };
        makePreTouchListener(decorView.getContext());
        this.mPresenter.showCanNotUseSpenDialog();
    }

    public void attachTranslationLanguageMenu(Activity activity, TlToolbarPresenter tlToolbarPresenter) {
        if (this.mTranslationLanguageMenu == null) {
            this.mTranslationLanguageMenu = new TranslationLanguageMenu(activity, (ViewGroup) activity.getWindow().getDecorView(), this, tlToolbarPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean canNotChangeMode() {
        return this.mPresenter.canNotChangeMode();
    }

    public void changeDeviceState(Activity activity, FoldingFeature foldingFeature) {
        if (activity == null || this.mHwToolbarMenu == null || !FoldStateCompat.getInstance().isFoldableDevice()) {
            return;
        }
        int foldDirection = FoldStateCompat.getInstance().getFoldDirection(activity);
        if (foldingFeature.getState() == FoldingFeature.State.HALF_OPENED) {
            if (foldDirection == 8) {
                setVerticalHalfOpened(true);
            }
        } else if (foldingFeature.getState() == FoldingFeature.State.FLAT) {
            setVerticalHalfOpened(false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void clearSelectedButtonsOfHandWritingToolbarItem() {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.clearSelectedButtonsToolbarItem();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void close() {
        if (this.mFloatingContainer == null) {
            return;
        }
        if (this.mFloatingArea != null && !this.mTranslationLanguageMenu.isShown()) {
            this.mFloatingArea.setVisibility(8);
        }
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.close();
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.close();
        }
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.close();
        }
        Logger.m10999d(TAG, "close Toolbar");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public int getBackgroundColor() {
        return this.mPresenter.getBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public int getColorTheme(int i) {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil != null) {
            return spenColorThemeUtil.getColor(i);
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public SpenPreTouchListenerImpl.PreTouchListener getPreTouchListener() {
        return this.mPreTouchListener;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public View getToolbarView() {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null && hwToolbarMenu.isShowing()) {
            return this.mHwToolbarMenu.getView();
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            return rtToolbarMenu.getView();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean hasBackgroundImage() {
        return this.mPresenter.hasBackgroundImage();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void hide(boolean z) {
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            if (z) {
                absToolbarContainerLayout.startHideAnimation();
            } else {
                absToolbarContainerLayout.hideWithDocker();
            }
            HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
            if (hwToolbarMenu != null) {
                hwToolbarMenu.hidePopupsWithSpoid();
                this.mHwToolbarMenu.offEasyWritingPad();
            }
            setTouchListener(true);
            hideSettingPenMini();
            Logger.m10999d(TAG, "hide Toolbar");
        }
        releasePreTouchListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void hideDirectWrite() {
        Logger.m11003i(TAG, "hideDirectWrite");
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void hideSettingPenMini() {
        HwSettingPenMiniMenu hwSettingPenMiniMenu = this.mHwSettingPenMiniMenu;
        if (hwSettingPenMiniMenu != null) {
            hwSettingPenMiniMenu.hide();
        }
    }

    public void initSpenColorThemeUtil(Activity activity) {
        if (this.mSpenColorThemeUtil == null) {
            this.mSpenColorThemeUtil = new SpenColorThemeUtil(activity);
        }
    }

    public boolean isAttachedToolbar() {
        return this.mPresenter != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isBackgroundColorInverted() {
        return this.mPresenter.isBackgroundColorInverted();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isDirectWriteRecognizing() {
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu == null) {
            return false;
        }
        return directWriteMenu.isDirectWriteRecognizing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isDirectWriteUsing() {
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            return directWriteMenu.isUsing();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isSIPShowing() {
        return this.mPresenter.isSIPShowing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isSupportDirectWrite(Activity activity) {
        return ComposerSpenUtils.canUseSpen(activity) && RecognitionUtil.isSupported(activity) && !this.mPresenter.isPDFReader();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public boolean isToolbarShowing() {
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout == null) {
            return false;
        }
        return absToolbarContainerLayout.isShowing();
    }

    public void noticeChangeLayout() {
        QuickTool quickTool = this.mQuickTool;
        if (quickTool != null) {
            quickTool.noticeChangeLayout();
        }
    }

    public boolean onBackPressed(boolean z) {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null && hwToolbarMenu.onBackPressed(z)) {
            return true;
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        return rtToolbarMenu != null && rtToolbarMenu.onBackPressed();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void onClickHwToggleFab() {
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.onClickToggleButton();
        }
    }

    public void onConfigurationChanged(Activity activity, Configuration configuration) {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.onConfigurationChanged(configuration);
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.onConfigurationChanged();
        }
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.onConfigurationChanged();
        }
        TableAndCellMenu tableAndCellMenu = this.mTableAndCellMenu;
        if (tableAndCellMenu != null) {
            tableAndCellMenu.onConfigurationChanged();
        }
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            absToolbarContainerLayout.setMultiWindowMode(WindowManagerCompat.getInstance().isMultiWindowMode(activity));
        }
        ToolbarPresenter toolbarPresenter = this.mPresenter;
        if (toolbarPresenter != null) {
            toolbarPresenter.showCanNotUseSpenDialog();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout.OnAnimationListener
    public void onEnd() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.util.NavigationBarUtil.OnChangedListener
    public void onHidedNavigation(boolean z) {
    }

    public void onOrientationChanged() {
        HwSettingPenMiniMenu hwSettingPenMiniMenu = this.mHwSettingPenMiniMenu;
        if (hwSettingPenMiniMenu != null) {
            hwSettingPenMiniMenu.onTouchOutside();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout.OnAnimationListener
    public void onStart() {
        AbsToolbarContainerLayout absToolbarContainerLayout;
        if (this.mHwToolbarMenu == null || (absToolbarContainerLayout = this.mFloatingContainer) == null || !absToolbarContainerLayout.getMIsMoving()) {
            return;
        }
        this.mHwToolbarMenu.hidePopups();
    }

    public void onWindowFocusChanged() {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.onWindowFocusChanged();
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.onWindowFocusChanged();
        }
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.onWindowFocusChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void reboundSettingPenMiniVI() {
        HwSettingPenMiniMenu hwSettingPenMiniMenu = this.mHwSettingPenMiniMenu;
        if (hwSettingPenMiniMenu != null) {
            hwSettingPenMiniMenu.runReboundVI();
        }
    }

    public void release() {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil != null) {
            spenColorThemeUtil.close();
            this.mSpenColorThemeUtil = null;
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.release();
            this.mRtMenu = null;
        }
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            if (hwToolbarMenu.getView() != null) {
                this.mHwToolbarMenu.getView().clearAnimation();
            }
            this.mHwToolbarMenu.release();
            this.mHwToolbarMenu = null;
        }
        TableAndCellMenu tableAndCellMenu = this.mTableAndCellMenu;
        if (tableAndCellMenu != null) {
            tableAndCellMenu.release();
            this.mTableAndCellMenu = null;
        }
        QuickTool quickTool = this.mQuickTool;
        if (quickTool != null) {
            quickTool.close();
            this.mQuickTool = null;
        }
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            removeOnSipListener(absToolbarContainerLayout);
            this.mFloatingContainer.release();
            this.mFloatingContainer = null;
        }
        NavigationBarUtil.removeNavigationHideModeChangeListener(this);
        releasePreTouchListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void removeOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener) {
        this.mPresenter.removeOnExternalKeyboardConnectedListener(onExternalKeyboardConnectedListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void removeOnSipListener(SoftInputManager.OnSipListener onSipListener) {
        this.mPresenter.removeOnSipListener(onSipListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setDirectWrite(boolean z) {
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.setDirectWrite(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setDirectWriteColor(int i, int i2) {
        Logger.m11003i(TAG, "setDirectWriteColor " + Integer.toHexString(i) + " " + Integer.toHexString(i2));
        DirectWriteMenu directWriteMenu = this.mDirectWriteMenu;
        if (directWriteMenu != null) {
            directWriteMenu.setDirectWriteColor(i, i2);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void setEnableToolTip(boolean z) {
        HwToolbarMenu hwToolbarMenu = this.mHwToolbarMenu;
        if (hwToolbarMenu != null) {
            hwToolbarMenu.setEnableToolTip(z);
        }
        RtToolbarMenu rtToolbarMenu = this.mRtMenu;
        if (rtToolbarMenu != null) {
            rtToolbarMenu.setEnableToolTip(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setSpenColorThemeUtil(int i) {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil != null) {
            spenColorThemeUtil.setColorTheme(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.ToolbarContract.IView
    public void show(boolean z) {
        if (!isAttachedToolbar()) {
            Logger.m10999d(TAG, "can't show cause toolbarContainer is not attached yet");
            return;
        }
        if (this.mFloatingArea.getVisibility() == 8) {
            this.mFloatingArea.setVisibility(0);
        }
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout != null) {
            if (z) {
                absToolbarContainerLayout.startShowAnimation();
            } else {
                absToolbarContainerLayout.showWithDocker();
            }
            setTouchListener(false);
            showSettingPenMini();
            this.mFloatingContainer.updateRelayoutPosition();
            addOnSipListener(this.mFloatingContainer);
            Logger.m10999d(TAG, "show Toolbar");
        }
        addPreTouchListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void showDirectWrite() {
        Logger.m11003i(TAG, "showDirectWrite");
        this.mDirectWriteMenu.show();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void showSettingPenMini() {
        HwSettingPenMiniMenu hwSettingPenMiniMenu = this.mHwSettingPenMiniMenu;
        if (hwSettingPenMiniMenu == null || !hwSettingPenMiniMenu.isPenMiniMode() || this.mHwToolbarMenu.isTextMode()) {
            return;
        }
        this.mQuickTool.hideQt();
        this.mHwSettingPenMiniMenu.show();
    }
}
