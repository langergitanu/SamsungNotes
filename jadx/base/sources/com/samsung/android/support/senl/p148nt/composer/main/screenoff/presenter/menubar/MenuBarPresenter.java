package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar;

import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.RotationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p072Q3.C0221a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u0006\u0010 \u001a\u00020\u001cJ\u0010\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0005J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0015J\u0016\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u001cJ\u0006\u0010+\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020%J\b\u0010-\u001a\u00020\u001cH\u0002J\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u001cJ\b\u00107\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0013H\u0002J\u0010\u0010:\u001a\u00020\u001c2\b\u0010;\u001a\u0004\u0018\u00010\u0011J\u0010\u0010<\u001a\u00020\u001c2\b\u0010;\u001a\u0004\u0018\u00010\u0011J\u0006\u0010=\u001a\u00020\u001cJ\u0006\u0010>\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u00100\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarContract$IView;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mRotationModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/RotationModel;", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mMenuBarNavigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter$IMenuBarNavigator;", "mZoomListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenZoomListenerImpl$ZoomListener;", "mPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "mObjectEventListener", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$ObjectEventListener;", "value", "", "objectChanged", "getObjectChanged", "()Z", "scrollChanged", "getScrollChanged", "init", "", "composerViewPresenter", "rotationModel", "menuBarNavigator", "onAttachView", "setView", "view", "initView", "visibility", "", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "halfWheelRotation", "onReadyToShow", "onFocused", "getPinVisibility", "updatePinVisibility", "onDestroy", "onDetachView", Key.ROTATION, "getRotation", "()I", "writingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "getWritingToolManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "makeZoomListener", "makePreTouchListener", "makeObjectEventListener", "addPreTouchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removePreTouchListener", "onDeleteAllObject", "onPin", "onSave", "IMenuBarNavigator", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuBarPresenter {

    @NotNull
    private static final String TAG = SOLogger.createTag("MenuBarPresenter");

    @Nullable
    private ComposerViewPresenter mComposerViewPresenter;

    @Nullable
    private IMenuBarNavigator mMenuBarNavigator;

    @Nullable
    private SpenWNote.ObjectEventListener mObjectEventListener;

    @Nullable
    private ObjectManager mObjectManager;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;

    @Nullable
    private RotationModel mRotationModel;

    @Nullable
    private MenuBarContract.IView mView;

    @Nullable
    private SpenZoomListenerImpl.ZoomListener mZoomListener;
    private boolean objectChanged;
    private boolean scrollChanged;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter$IMenuBarNavigator;", "", "onSetCloseReason", "", "closeReason", "", "onStartAnimationClosing", "onPin", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IMenuBarNavigator {
        void onPin();

        void onSetCloseReason(int closeReason);

        void onStartAnimationClosing();
    }

    private final SpenWNote.ObjectEventListener makeObjectEventListener() {
        if (this.mObjectEventListener == null) {
            this.mObjectEventListener = new SpenWNote.ObjectEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter.makeObjectEventListener.1
                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectAdded(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
                    Intrinsics.checkNotNullParameter(arrayList, "arrayList");
                    if (!MenuBarPresenter.this.getObjectChanged()) {
                        MenuBarPresenter.this.objectChanged = true;
                        MenuBarPresenter.this.updatePinVisibility();
                    }
                    MenuBarPresenter.this.getWritingToolManager().setLastPenInfo(PenInfoModel.INSTANCE.getSpenSettingPenInfo());
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectChanged(SpenWPage spenWPage, SpenObjectChangedInfo spenObjectChangedInfo, int i) {
                    Intrinsics.checkNotNullParameter(spenObjectChangedInfo, "spenObjectChangedInfo");
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectRemoved(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
                    Intrinsics.checkNotNullParameter(arrayList, "arrayList");
                    if (MenuBarPresenter.this.getObjectChanged()) {
                        return;
                    }
                    MenuBarPresenter.this.objectChanged = true;
                    MenuBarPresenter.this.updatePinVisibility();
                }
            };
        }
        SpenWNote.ObjectEventListener objectEventListener = this.mObjectEventListener;
        Intrinsics.checkNotNull(objectEventListener);
        return objectEventListener;
    }

    private final SpenPreTouchListenerImpl.PreTouchListener makePreTouchListener() {
        if (this.mPreTouchListener == null) {
            this.mPreTouchListener = new C0221a(this, 3);
        }
        SpenPreTouchListenerImpl.PreTouchListener preTouchListener = this.mPreTouchListener;
        Intrinsics.checkNotNull(preTouchListener);
        return preTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makePreTouchListener$lambda$1(MenuBarPresenter menuBarPresenter, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || menuBarPresenter.scrollChanged) {
            return false;
        }
        menuBarPresenter.scrollChanged = true;
        menuBarPresenter.updatePinVisibility();
        return false;
    }

    private final SpenZoomListenerImpl.ZoomListener makeZoomListener() {
        if (this.mZoomListener == null) {
            this.mZoomListener = new C10996a(this, 0);
        }
        SpenZoomListenerImpl.ZoomListener zoomListener = this.mZoomListener;
        Intrinsics.checkNotNull(zoomListener);
        return zoomListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeZoomListener$lambda$0(MenuBarPresenter menuBarPresenter, float f, float f4, float f5, float f6, float f7) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onZoom# " + f4);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            menuBarPresenter.updatePinVisibility();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePinVisibility() {
        MenuBarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(16, getPinVisibility());
        }
    }

    public final void addPreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        ListenerManager listenerManager;
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || (listenerManager = composerViewPresenter.getListenerManager()) == null) {
            return;
        }
        listenerManager.addPreTouchListener(listener);
    }

    public final boolean getObjectChanged() {
        return this.objectChanged;
    }

    public final int getPinVisibility() {
        ConfigurationModel configurationModel = ConfigurationModel.INSTANCE;
        if (configurationModel.isAODEnabled() && configurationModel.hasAODServiceMetaData() && !configurationModel.isMirrorDisplayExisted()) {
            EmergencyManagerCompat companion = EmergencyManagerCompat.INSTANCE.getInstance();
            ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
            if (!companion.isEmergencyMode(composerViewPresenter != null ? composerViewPresenter.getActivity() : null)) {
                return (!(StartCommandFactory.INSTANCE.getInstance().getMStartCommand() instanceof LoadNoteByDoubleTapOnAOD) || this.objectChanged || this.scrollChanged) ? 0 : 4;
            }
        }
        return 4;
    }

    public final int getRotation() {
        RotationModel rotationModel = this.mRotationModel;
        if (rotationModel != null) {
            return rotationModel.getRotation();
        }
        return 0;
    }

    public final boolean getScrollChanged() {
        return this.scrollChanged;
    }

    @NotNull
    public final WritingToolManager getWritingToolManager() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        WritingToolManager writingToolManager = composerViewPresenter != null ? composerViewPresenter.getWritingToolManager() : null;
        Intrinsics.checkNotNull(writingToolManager);
        return writingToolManager;
    }

    public final void init(@Nullable ComposerViewPresenter composerViewPresenter, @Nullable RotationModel rotationModel, @Nullable IMenuBarNavigator menuBarNavigator) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mComposerViewPresenter = composerViewPresenter;
        this.mRotationModel = rotationModel;
        this.mObjectManager = composerViewPresenter != null ? composerViewPresenter.getObjectManager() : null;
        this.mMenuBarNavigator = menuBarNavigator;
    }

    public final void initView(int visibility) {
        AbstractC8014b.m7206h("initView# ", visibility, SOLogger.INSTANCE, TAG);
        MenuBarContract.IView iView = this.mView;
        if (iView != null) {
            iView.init(visibility, false);
        }
    }

    public final void onAttachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
    }

    public final void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        MenuBarContract.IView iView;
        AbstractC8014b.m7206h("onConfigurationChanged# ", visibility, SOLogger.INSTANCE, TAG);
        if (this.mView == null || ConfigurationModel.INSTANCE.isSupportNavigationRotation() || (iView = this.mView) == null) {
            return;
        }
        iView.onConfigurationChanged(visibility, halfWheelRotation);
    }

    public final void onDeleteAllObject() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDeleteAllObject#");
        ObjectManager objectManager = this.mObjectManager;
        if (objectManager != null) {
            objectManager.deleteAllObject();
        }
    }

    public final void onDestroy() {
        ListenerManager listenerManager;
        ListenerManager listenerManager2;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        removePreTouchListener(this.mPreTouchListener);
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && (listenerManager2 = composerViewPresenter.getListenerManager()) != null) {
            listenerManager2.removeSpenObjectEventListener(this.mObjectEventListener);
        }
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 != null && (listenerManager = composerViewPresenter2.getListenerManager()) != null) {
            listenerManager.removeZoomListener(this.mZoomListener);
        }
        this.mPreTouchListener = null;
        this.mObjectEventListener = null;
        this.mZoomListener = null;
        MenuBarContract.IView iView = this.mView;
        if (iView != null) {
            iView.onDestroy();
        }
    }

    public final void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
        onDestroy();
        this.mView = null;
    }

    public final void onFocused() {
        ListenerManager listenerManager;
        ListenerManager listenerManager2;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFocused#");
        MenuBarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(1, 0);
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && (listenerManager2 = composerViewPresenter.getListenerManager()) != null) {
            listenerManager2.addZoomListener(makeZoomListener());
        }
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 != null && (listenerManager = composerViewPresenter2.getListenerManager()) != null) {
            listenerManager.addSpenObjectEventListener(makeObjectEventListener());
        }
        addPreTouchListener(makePreTouchListener());
    }

    public final void onPin() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPin#");
        IMenuBarNavigator iMenuBarNavigator = this.mMenuBarNavigator;
        if (iMenuBarNavigator != null) {
            iMenuBarNavigator.onPin();
        }
    }

    public final void onReadyToShow() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onReadyToShow#");
        MenuBarContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(1, 0);
        }
        MenuBarContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.updateVisibility(16, getPinVisibility());
        }
        MenuBarContract.IView iView3 = this.mView;
        if (iView3 != null) {
            iView3.invalidate();
        }
    }

    public final void onSave() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSave#");
        IMenuBarNavigator iMenuBarNavigator = this.mMenuBarNavigator;
        if (iMenuBarNavigator != null) {
            iMenuBarNavigator.onSetCloseReason(4);
        }
        IMenuBarNavigator iMenuBarNavigator2 = this.mMenuBarNavigator;
        if (iMenuBarNavigator2 != null) {
            iMenuBarNavigator2.onStartAnimationClosing();
        }
    }

    public final void onWindowFocusChanged(boolean hasFocus) {
        AbstractC8014b.m7211m("onWindowFocusChanged# ", hasFocus, SOLogger.INSTANCE, TAG);
        MenuBarContract.IView iView = this.mView;
        if (iView == null || iView == null) {
            return;
        }
        iView.onWindowFocusChanged(hasFocus);
    }

    public final void removePreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        ListenerManager listenerManager;
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || (listenerManager = composerViewPresenter.getListenerManager()) == null) {
            return;
        }
        listenerManager.removePreTouchListener(listener);
    }

    public final void setView(@Nullable MenuBarContract.IView view) {
        this.mView = view;
    }
}
