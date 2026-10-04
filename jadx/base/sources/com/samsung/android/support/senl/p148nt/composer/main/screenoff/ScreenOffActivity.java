package com.samsung.android.support.senl.p148nt.composer.main.screenoff;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.app.StatusBarManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.AODCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.AODNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.IAODCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultApply;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.DeleteNoteByRemovePinOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenAttach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenDetach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.StartNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin.PinData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadednote.LoadedNote;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IStateSetter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateClosing;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateCreated;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateShowing;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateStarting;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.StaticalModelInitializer;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.PowerManagerHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.KeepScreenOnFlagFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.SkipPreInitializeFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.ScreenOffFragment;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.displaystate.DisplayStateListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.displaystate.IDisplayStateListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.interrupt.IInterruptListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.interrupt.InterruptListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically.ISystemKeyReceiver;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically.SystemKeyReceiver;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002IJB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\u0012\u0010,\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u0018H\u0014J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0018H\u0014J\u0010\u00104\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0014J\b\u00105\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\b\u00107\u001a\u00020\u0018H\u0014J\b\u00108\u001a\u00020\u0018H\u0014J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020)H\u0016J\b\u0010;\u001a\u00020\u0018H\u0014J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0018H\u0002J\b\u0010D\u001a\u00020\u0018H\u0002J\b\u0010E\u001a\u00020\u0018H\u0002J\b\u0010F\u001a\u00020\u0018H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00060HR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/displaystate/IDisplayStateListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/interrupt/IInterruptListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/ISystemKeyReceiver;", "<init>", "()V", "mState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "mLoadedNote", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote;", "mDisplayStateListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/displaystate/DisplayStateListener;", "mInterruptListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/interrupt/InterruptListener;", "mSystemKeyReceiver", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/SystemKeyReceiver;", "getClassName", "", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "onSetState", "", "state", "onInitialized", "onStarted", "onFinish", "requestRestart", "onDisplayStateChanged", "displayState", "", "onInterrupted", "onSystemKeyReceived", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "initWindowAttributes", "setRequestedOrientation", "requestSystemKeyEvent", "request", "", "acquireWakeLock", "releaseWakeLock", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "disableSystemBarInsets", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initialize", "onNewIntent", "loadPinnedNote", "loadCachedNote", "addFragment", "onResume", "onWindowFocusChanged", "hasFocus", "onPause", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onHomeKeyPressed", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onDestroy", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffActivity$MessageHandler;", "MessageHandler", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffActivity extends BaseComposerActivity implements IStateSetter, Navigator, IDisplayStateListener, IInterruptListener, ISystemKeyReceiver {
    private static final int CALL_RESUME_AFTER_NEW_INTENT_DELAY = 500;
    private static final int MESSAGE_CALL_RESUME_AFTER_NEW_INTENT = 2;
    private static final int MESSAGE_RELEASE_WAKE_LOCK = 1;
    private static final int RELEASE_WAKE_LOCK_DELAY = 5000;

    @Nullable
    private DisplayStateListener mDisplayStateListener;

    @NotNull
    private final MessageHandler mHandler;

    @Nullable
    private InterruptListener mInterruptListener;

    @Nullable
    private LoadedNote mLoadedNote;

    @Nullable
    private IState mState;

    @Nullable
    private SystemKeyReceiver mSystemKeyReceiver;

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffActivity");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffActivity$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffActivity;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MessageHandler extends Handler {
        final /* synthetic */ ScreenOffActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull ScreenOffActivity screenOffActivity, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = screenOffActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AbstractC8014b.m7206h("handleMessage# ", msg.what, SOLogger.INSTANCE, ScreenOffActivity.TAG);
            int i = msg.what;
            if (i == 1) {
                this.this$0.releaseWakeLock();
            } else if (i == 2) {
                this.this$0.onResume();
            }
        }
    }

    public ScreenOffActivity() {
        NavigationBarUtil.enrollExcludedListToHideNavigationBar(ScreenOffActivity.class);
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        Intrinsics.checkNotNull(looperMyLooper);
        this.mHandler = new MessageHandler(this, looperMyLooper);
    }

    private final void acquireWakeLock() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "acquireWakeLock#");
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.getInstance(applicationContext).acquireWakeLock(getClassName(), AiSTTListView.USER_SCROLL_INTERVAL);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000L);
    }

    private final void initWindowAttributes() {
        Window window;
        SOLogger.INSTANCE.SOLoggerD(TAG, "initWindowAttributes#");
        if (StartCommandFactory.INSTANCE.getInstance().getMStartCommand() instanceof DeleteNoteByRemovePinOnAOD) {
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(131075);
        }
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        companion.getInstance().setTurnScreenOn(this, true, false);
        companion.getInstance().setShowWhenLocked(this, true, false);
        companion.getInstance().setForceHideFloatingMultiWindow(this);
        WindowManagerCompat companion2 = companion.getInstance();
        Window window3 = getWindow();
        companion2.setExtensionFlagMultiWindowHandlerHidden(window3 != null ? window3.getAttributes() : null);
        if (KeepScreenOnFlagFeature.INSTANCE.needToAddKeepScreenOnFlag() && (window = getWindow()) != null) {
            window.addFlags(128);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.clearFlags(2);
        }
        WindowInsetsCompat.INSTANCE.getInstance().setFitInsetsTypesNavigationBar(getWindow());
        setRequestedOrientation();
    }

    private final void loadCachedNote() {
        LoadedNote loadedNote;
        SaveModel saveModel = new SaveModel();
        String strLoadCachedNoteUuid = saveModel.loadCachedNoteUuid();
        String strLoadCacheNotePath = saveModel.loadCacheNotePath();
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("loadCachedNote# uuid/notePath", strLoadCachedNoteUuid, "/", Logger.getEncode(strLoadCacheNotePath)));
        if (strLoadCachedNoteUuid == null || strLoadCachedNoteUuid.length() <= 0) {
            return;
        }
        getIntent().putExtra("sdoc_uuid", strLoadCachedNoteUuid);
        getIntent().putExtra("doc_path", strLoadCacheNotePath);
        saveModel.removeCachedNoteUuid();
        saveModel.removeCachedNotePath();
        LoadedNote loadedNote2 = this.mLoadedNote;
        if (loadedNote2 != null) {
            loadedNote2.setLoadedNoteType(LoadedNote.Type.LOADED_BY_CACHE);
        }
        LoadedNote loadedNote3 = this.mLoadedNote;
        if (loadedNote3 != null) {
            loadedNote3.setUuid(strLoadCachedNoteUuid);
        }
        if (strLoadCacheNotePath == null || (loadedNote = this.mLoadedNote) == null) {
            return;
        }
        loadedNote.setNotePath(strLoadCacheNotePath);
    }

    private final void loadPinnedNote() {
        IStartCommand mStartCommand = StartCommandFactory.INSTANCE.getInstance().getMStartCommand();
        String mUri = mStartCommand != null ? mStartCommand.getMUri() : null;
        if (mUri == null || mUri.length() == 0) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "loadPinnedNote# invalid uri!");
            return;
        }
        String strLoadPinnedNoteUuidByUri = new PinData().loadPinnedNoteUuidByUri(mUri);
        String strLoadPinnedNotePathByUri = new PinData().loadPinnedNotePathByUri(mUri);
        float fLoadPinnedNoteScrollPanY = new PinData().loadPinnedNoteScrollPanY();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPinnedNote# uuid/notePath/scrollPanY ", strLoadPinnedNoteUuidByUri, "/", Logger.getEncode(strLoadPinnedNotePathByUri), "/");
        sbM16m.append(fLoadPinnedNoteScrollPanY);
        sOLogger.SOLoggerD(str, sbM16m.toString());
        getIntent().putExtra("sdoc_uuid", strLoadPinnedNoteUuidByUri);
        getIntent().putExtra("doc_path", strLoadPinnedNotePathByUri);
        getIntent().putExtra(ComposerConstants.ARG_SDOC_SCROLL_PAN_Y, fLoadPinnedNoteScrollPanY);
        LoadedNote loadedNote = this.mLoadedNote;
        if (loadedNote != null) {
            loadedNote.setLoadedNoteType(LoadedNote.Type.LOADED_BY_PIN);
        }
        LoadedNote loadedNote2 = this.mLoadedNote;
        if (loadedNote2 != null) {
            loadedNote2.setUuid(strLoadPinnedNoteUuidByUri);
        }
        LoadedNote loadedNote3 = this.mLoadedNote;
        if (loadedNote3 != null) {
            loadedNote3.setNotePath(strLoadPinnedNotePathByUri);
        }
    }

    private final void onDispatchActionDownEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionDownEvent#");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenOffFragment screenOffFragment = (ScreenOffFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
        if (screenOffFragment != null) {
            screenOffFragment.onDispatchActionDownEvent();
        }
    }

    private final void onDispatchActionUpEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionUpEvent#");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenOffFragment screenOffFragment = (ScreenOffFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
        if (screenOffFragment != null) {
            screenOffFragment.onDispatchActionUpEvent();
        }
    }

    private final void onHomeKeyPressed() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onHomeKeyPressed#");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenOffFragment screenOffFragment = (ScreenOffFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
        if (screenOffFragment != null) {
            screenOffFragment.onHomeKeyPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseWakeLock() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "releaseWakeLock#");
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.getInstance(applicationContext).releaseWakeLock();
        this.mHandler.removeMessages(1);
    }

    private final void requestSystemKeyEvent(boolean request) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "requestSystemKeyEvent# " + request);
        if (ConfigurationModel.hasSWNavigation()) {
            WindowManagerCompat.INSTANCE.getInstance().requestSystemKeyEvent(3, getComponentName(), request);
            return;
        }
        if (request) {
            SystemKeyReceiver systemKeyReceiver = new SystemKeyReceiver();
            this.mSystemKeyReceiver = systemKeyReceiver;
            systemKeyReceiver.registerReceivers(this, this);
        } else {
            SystemKeyReceiver systemKeyReceiver2 = this.mSystemKeyReceiver;
            if (systemKeyReceiver2 != null) {
                systemKeyReceiver2.unregisterReceivers(this);
            }
            this.mSystemKeyReceiver = null;
        }
    }

    private final void setRequestedOrientation() {
        setRequestedOrientation(ConfigurationModel.INSTANCE.isSupportRotation() ? 4 : 1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    public void addFragment() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "addFragment#");
        Bundle bundle = new Bundle();
        IState iState = this.mState;
        if (iState instanceof StateStarting) {
            bundle.putParcelable("state", (StateStarting) iState);
        } else if (iState instanceof StateShowing) {
            bundle.putParcelable("state", (StateShowing) iState);
        } else {
            sOLogger.SOLoggerD(str, "addFragment# exceptional case!");
        }
        bundle.putParcelable(Constants.DeliveryParcelableKey.LOADED_NOTE_TYPE, this.mLoadedNote);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (supportFragmentManager.findFragmentByTag(getFragmentTag()) == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            BaseComposerFragment baseComposerFragmentCreateFragment = createFragment();
            baseComposerFragmentCreateFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.add(C9086R.id.composer_fragment_container, baseComposerFragmentCreateFragment, getFragmentTag()).commitAllowingStateLoss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void blockUserInput(boolean z) {
        Navigator.DefaultImpls.blockUserInput(this, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public BaseComposerFragment createFragment() {
        return new ScreenOffFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    public void disableSystemBarInsets() {
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsetsNoDisplayCutout(findViewById(C9086R.id.composer_fragment_container));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            onDispatchActionDownEvent();
        } else if (action == 1) {
            onDispatchActionUpEvent();
        } else if (action != 211) {
            if (action == 212) {
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public String getClassName() {
        String name = ScreenOffAnimatorActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean hasCachedNote() {
        return Navigator.DefaultImpls.hasCachedNote(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    public void initialize() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "initialize#");
        ConfigurationModel configurationModel = ConfigurationModel.INSTANCE;
        if (configurationModel.isPenAttached()) {
            StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
            if ((companion.getInstance().makeStartCommand(getIntent()) instanceof PenDetach) || ((companion.getInstance().makeStartCommand(getIntent()) instanceof PenButtonHoverTap) && !configurationModel.isUseMultiplePens())) {
                sOLogger.SOLoggerD(str, "initialize# pen startCommand but pen is attached !");
                StateCreated stateCreated = new StateCreated(this);
                this.mState = stateCreated;
                IStateSetter stateSetter = stateCreated.getStateSetter();
                if (stateSetter != null) {
                    IState iState = this.mState;
                    stateSetter.onSetState(new StateClosing(iState != null ? iState.getStateSetter() : null));
                }
                finish();
                return;
            }
        }
        IState iState2 = this.mState;
        if (iState2 != null) {
            iState2.onInitialize(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean isEditedNote() {
        return Navigator.DefaultImpls.isEditedNote(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean isEmptyNote() {
        return Navigator.DefaultImpls.isEmptyNote(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onClosingAnimationPenAttach() {
        Navigator.DefaultImpls.onClosingAnimationPenAttach(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onConfigurationChanged#");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DisplayUtils.onConfigurationChanged(applicationContext, newConfig);
        StaticalModelInitializer staticalModelInitializer = StaticalModelInitializer.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        staticalModelInitializer.initialize(applicationContext2);
        super.onConfigurationChanged(newConfig);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onCreate#");
        overridePendingTransition(0, 0);
        acquireWakeLock();
        DisplayStateListener displayStateListener = new DisplayStateListener();
        this.mDisplayStateListener = displayStateListener;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        displayStateListener.registerListener(applicationContext, this);
        InterruptListener interruptListener = new InterruptListener();
        this.mInterruptListener = interruptListener;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        interruptListener.registerListener(applicationContext2, this);
        StateCreated stateCreated = new StateCreated(this);
        this.mState = stateCreated;
        stateCreated.onNotifyExecution(this, Constants.IntentExtraValue.SHOW, true);
        this.mLoadedNote = new LoadedNote();
        Window window = getWindow();
        if (window != null) {
            window.setTitle(getClassName());
        }
        initWindowAttributes();
        SkipPreInitializeFeature skipPreInitializeFeature = SkipPreInitializeFeature.INSTANCE;
        if (skipPreInitializeFeature.needToSkipPreInitialize()) {
            skipPreInitializeFeature.setScreenOffActivityState(SkipPreInitializeFeature.STATE_CREATED);
        }
        super.onCreate(savedInstanceState);
        ComposerSA.insertStatusLog("9985", "Screen off Memo");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        IState iState = this.mState;
        if (iState != null) {
            iState.onNotifyExecution(this, "close", true);
        }
        StaticalModelInitializer.INSTANCE.release();
        PowerManagerHandler.INSTANCE.release();
        StartCommandFactory.INSTANCE.getInstance().release();
        releaseWakeLock();
        requestSystemKeyEvent(false);
        DisplayStateListener displayStateListener = this.mDisplayStateListener;
        if (displayStateListener != null) {
            displayStateListener.unregisterListener();
        }
        InterruptListener interruptListener = this.mInterruptListener;
        if (interruptListener != null) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            interruptListener.unregisterListener(applicationContext);
        }
        this.mHandler.removeMessages(1);
        SkipPreInitializeFeature skipPreInitializeFeature = SkipPreInitializeFeature.INSTANCE;
        if (skipPreInitializeFeature.needToSkipPreInitialize()) {
            skipPreInitializeFeature.setScreenOffActivityState(SkipPreInitializeFeature.STATE_DESTROYED);
        }
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.displaystate.IDisplayStateListener
    public void onDisplayStateChanged(int displayState) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenOffFragment screenOffFragment = (ScreenOffFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
        if (screenOffFragment != null) {
            screenOffFragment.onDisplayStateChanged(displayState);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onFinish() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFinish#");
        finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onInitialized() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInitialized#");
        StaticalModelInitializer staticalModelInitializer = StaticalModelInitializer.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        staticalModelInitializer.initialize(applicationContext);
        ConfigurationModel.INSTANCE.registerObservers();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.interrupt.IInterruptListener
    public void onInterrupted() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenOffFragment screenOffFragment = (ScreenOffFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
        if (screenOffFragment != null) {
            screenOffFragment.onInterrupted();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractC8014b.m7206h("onKeyDown# keyCode ", keyCode, SOLogger.INSTANCE, TAG);
        if (keyCode == 3) {
            onHomeKeyPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        IState iState;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        IStartCommand mStartCommand = companion.getInstance().getMStartCommand();
        IAODCommand iAODCommandMakeAODCommand = AODCommandFactory.INSTANCE.getInstance().makeAODCommand(intent);
        boolean booleanExtra = intent.getBooleanExtra(Constants.StringExtraKey.DO_NOT_UPDATE_WINDOW_FLAG, false);
        boolean zIsFinishing = isFinishing();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("onNewIntent# startCommand/aodCommand/doNotUpdateWindowFlag/isFinishing ", mStartCommand != null ? mStartCommand.getClass().getSimpleName() : "null", "/", iAODCommandMakeAODCommand.getClass().getSimpleName(), "/");
        sbM16m.append(booleanExtra);
        sbM16m.append("/");
        sbM16m.append(zIsFinishing);
        sOLogger.SOLoggerD(str, sbM16m.toString());
        if (!(mStartCommand instanceof StartNone) && !(mStartCommand instanceof PenAttach) && (iState = this.mState) != null) {
            iState.onNotifyExecution(this, Constants.IntentExtraValue.SHOW, true);
        }
        if ((iAODCommandMakeAODCommand instanceof AODNone) && !(mStartCommand instanceof PenAttach) && !zIsFinishing && !booleanExtra) {
            WindowManagerCompat.INSTANCE.getInstance().setTurnScreenOn(this, true, true);
        }
        acquireWakeLock();
        setRequestedOrientation();
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        String stringExtra2 = intent.getStringExtra("doc_path");
        float floatExtra = intent.getFloatExtra(ComposerConstants.ARG_SDOC_SCROLL_PAN_Y, 0.0f);
        StringBuilder sbM16m2 = AbstractC0000a.m16m("onNewIntent# uuid/notePath/scrollPanY ", stringExtra, "  / ", Logger.getEncode(stringExtra2), " / ");
        sbM16m2.append(floatExtra);
        sOLogger.SOLoggerD(str, sbM16m2.toString());
        if (companion.getInstance().getPrimitiveStartCommand() instanceof LoadNoteByDoubleTapOnAOD) {
            String primitiveStartCommandUri = companion.getInstance().getPrimitiveStartCommandUri();
            stringExtra = new PinData().loadPinnedNoteUuidByUri(primitiveStartCommandUri);
            stringExtra2 = new PinData().loadPinnedNotePathByUri(primitiveStartCommandUri);
        }
        intent.putExtra("sdoc_uuid", stringExtra);
        intent.putExtra("doc_path", stringExtra2);
        intent.putExtra(ComposerConstants.ARG_SDOC_SCROLL_PAN_Y, floatExtra);
        setIntent(intent);
        if (iAODCommandMakeAODCommand instanceof ResultApply) {
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPause#");
        StatusBarManagerCompat.Companion companion = StatusBarManagerCompat.INSTANCE;
        companion.getInstance().disable(getApplicationContext(), companion.getInstance().getDisableNone());
        super.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onPreHide() {
        Navigator.DefaultImpls.onPreHide(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onPreShow() {
        Navigator.DefaultImpls.onPreShow(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onResume#");
        this.mHandler.removeMessages(2);
        StatusBarManagerCompat.Companion companion = StatusBarManagerCompat.INSTANCE;
        companion.getInstance().disable(getApplicationContext(), companion.getInstance().getDisableExpand());
        StartCommandFactory.INSTANCE.getInstance().makeStartCommand(getIntent()).executeOnResume(this, this.mState);
        StaticalModelInitializer staticalModelInitializer = StaticalModelInitializer.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        staticalModelInitializer.initialize(applicationContext);
        if (WindowManagerCompat.INSTANCE.getInstance().isMultiWindowMode(this)) {
            String string = getString(C9086R.string.string_screen_off_memo);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(C9086R.string.screenoff_can_not_create_in_dex_mode, string);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            sOLogger.SOLoggerD(str, "onResume# " + string2);
            ToastHandler.showDirectly(BaseUtils.getApplicationContext(), string2, 1);
        }
        super.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSave() {
        Navigator.DefaultImpls.onSave(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSaveNoteCache() {
        Navigator.DefaultImpls.onSaveNoteCache(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSavePinCache(@Nullable String str) {
        Navigator.DefaultImpls.onSavePinCache(this, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IStateSetter
    public void onSetState(@Nullable IState state) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        IState iState = this.mState;
        sOLogger.SOLoggerD(str, AbstractC0541b.m775q("onSetState# before/after ", iState != null ? iState.getClass().getSimpleName() : "null", " / ", state != null ? state.getClass().getSimpleName() : null, " }"));
        this.mState = state;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onShowingAnimation() {
        Navigator.DefaultImpls.onShowingAnimation(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onStarted() {
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onStarted#");
        requestSystemKeyEvent(true);
        if (StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand() instanceof LoadNoteByDoubleTapOnAOD) {
            loadPinnedNote();
        }
        loadCachedNote();
        addFragment();
        IState iState = this.mState;
        if (iState == null || (stateSetter = iState.getStateSetter()) == null) {
            return;
        }
        stateSetter.onSetState(new StateNone(this));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically.ISystemKeyReceiver
    public void onSystemKeyReceived(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSystemKeyReceived# intent/reason " + intent + "/" + intent.getStringExtra("reason"));
        if (Intrinsics.areEqual("android.intent.action.CLOSE_SYSTEM_DIALOGS", intent.getAction()) && Intrinsics.areEqual(Constants.StringExtra.HOME_KEY, intent.getStringExtra("reason"))) {
            onHomeKeyPressed();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        AbstractC8014b.m7211m("onWindowFocusChanged# hasFocus ", hasFocus, SOLogger.INSTANCE, TAG);
        if (hasFocus) {
            WindowManagerCompat.INSTANCE.getInstance().setTurnScreenOn(this, false, true);
            releaseWakeLock();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestReadyToShow(boolean z) {
        Navigator.DefaultImpls.requestReadyToShow(this, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestResetZoomScaleToDefault() {
        Navigator.DefaultImpls.requestResetZoomScaleToDefault(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestRestart() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "requestRestart#");
        ExecutorFactory.INSTANCE.createExecutor(getIntent()).execute(getApplicationContext(), getIntent());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowPinNoteDialog(@NotNull Uri uri) {
        Navigator.DefaultImpls.requestShowPinNoteDialog(this, uri);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowSaveNoteDialog() {
        Navigator.DefaultImpls.requestShowSaveNoteDialog(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowSelectNoteDialog() {
        Navigator.DefaultImpls.requestShowSelectNoteDialog(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void reserveRestart() {
        Navigator.DefaultImpls.reserveRestart(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void resetIntent() {
        Navigator.DefaultImpls.resetIntent(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setCloseReason(int i) {
        Navigator.DefaultImpls.setCloseReason(this, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setLoadedPinNotePath(@Nullable String str) {
        Navigator.DefaultImpls.setLoadedPinNotePath(this, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setLoadedPinUuid(@NotNull String str) {
        Navigator.DefaultImpls.setLoadedPinUuid(this, str);
    }
}
