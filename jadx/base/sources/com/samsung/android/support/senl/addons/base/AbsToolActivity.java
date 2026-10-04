package com.samsung.android.support.senl.addons.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.ocr.BuildConfig;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.IEventListener;
import com.samsung.android.support.senl.addons.base.model.bleremote.IBLECommand;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.IBaseActivity;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.popupwindow.IPopupWindowProperties;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.popupwindow.PopupWindowController;
import com.samsung.android.support.senl.p145cm.base.common.method.CloseableActivity;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.GridBagConstraints;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p031G2.C0109b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001RB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H$J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H$J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H$J\b\u0010\u0019\u001a\u00020\nH\u0014J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u001a\u0010 \u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\nH\u0002J\"\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0014J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010'\u001a\u00020\u001bH\u0002J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u001bH\u0014J\u0012\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\u0012\u00102\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u00010\bH\u0014J\u0018\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u000207H\u0016J \u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u001bH\u0014J\b\u0010A\u001a\u00020\u001bH\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\nH\u0014J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u0010H\u0014J\n\u0010I\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020LH\u0014J\u001a\u0010M\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001a\u00020\u001b2\b\u0010N\u001a\u0004\u0018\u00010OH\u0003J\u0012\u0010Q\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/AbsToolActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/IBaseActivity;", "Lcom/samsung/android/support/senl/addons/base/model/bleremote/IBLECommand;", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/popupwindow/IPopupWindowProperties;", "<init>", "()V", "mEventListener", "Lcom/samsung/android/support/senl/addons/base/model/IEventListener;", "mIsInvalidCreateCase", "", "getMIsInvalidCreateCase", "()Z", "setMIsInvalidCreateCase", "(Z)V", "mPopupWindowFlag", "", "mPopupWindowController", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/popupwindow/PopupWindowController;", "getConcreteClass", "Ljava/lang/Class;", "createView", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView;", "getViewTag", "", "checkInvalidCreateCase", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", OptionMenuBackPresenter.Caller.BACK_KEY, "setPopupWindowProperties", "addView", "storeModel", "changeView", "fragment", "tag", "setExtraArgumentToView", "view", "printDisplayInfo", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onWindowFocusChanged", "hasFocus", "initialize", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyDown", "getBLEEventId", "keycode", "withCtrl", "withShift", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "controlIndicatorBar", "bringToFront", "mIsEnableFullMode", "setFullMode", "enable", "hideSystemUI", "showSystemUI", "addPopupWindowFlags", "flags", "getOpenUUID", "onNewIntent", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "close", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/common/method/CloseableActivity$Callback;", "callCloseCallback", "isCallForceClosed", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsToolActivity extends AppCompatActivity implements IBaseActivity, IBLECommand, IPopupWindowProperties {

    @NotNull
    private static final String TAG = Logger.createTag("AbsToolActivity");

    @Nullable
    private IEventListener mEventListener;
    private boolean mIsEnableFullMode;
    private boolean mIsInvalidCreateCase;

    @Nullable
    private PopupWindowController mPopupWindowController;
    private int mPopupWindowFlag;

    private final void addView(Bundle savedInstanceState, boolean storeModel) {
        String viewTag = getViewTag();
        BaseFragmentView baseFragmentViewChangeView = (BaseFragmentView) getSupportFragmentManager().findFragmentByTag(viewTag);
        if (savedInstanceState == null) {
            Intrinsics.checkNotNull(viewTag);
            baseFragmentViewChangeView = changeView(baseFragmentViewChangeView, viewTag, storeModel);
        }
        Intrinsics.checkNotNull(baseFragmentViewChangeView);
        setEventListener(baseFragmentViewChangeView);
        controlIndicatorBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void backPressed() {
        IEventListener iEventListener = this.mEventListener;
        if (iEventListener != null) {
            Intrinsics.checkNotNull(iEventListener);
            AbstractC6670b.m4764y("onBackPressed : ", TAG, iEventListener.onBack());
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    private final void callCloseCallback(CloseableActivity.Callback callback) {
        if (callback == null) {
            return;
        }
        Intent intent = null;
        try {
            try {
                Field declaredField = Activity.class.getDeclaredField("mResultCode");
                declaredField.setAccessible(true);
                if (declaredField.getInt(this) == -1) {
                    Field declaredField2 = Activity.class.getDeclaredField("mResultData");
                    declaredField2.setAccessible(true);
                    intent = (Intent) declaredField2.get(this);
                }
            } catch (IllegalAccessException e) {
                Logger.m7100d(TAG, "callCloseCallback# " + e.getMessage());
            } catch (NoSuchFieldException e2) {
                Logger.m7100d(TAG, "callCloseCallback# " + e2.getMessage());
            } catch (InvocationTargetException e3) {
                Logger.m7100d(TAG, "callCloseCallback# " + e3.getMessage());
            }
        } finally {
            callback.onClosed(null);
        }
    }

    private final BaseFragmentView changeView(BaseFragmentView fragment, String tag, boolean storeModel) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        Bundle extras = getIntent().getExtras();
        if (fragment != null) {
            boolean z = fragment.getLifecycle().getState() == Lifecycle.State.CREATED;
            boolean zIsAdded = fragment.isAdded();
            Logger.m7100d(TAG, "changeView isCreated/isAdded : " + z + " / " + zIsAdded);
            if (z || zIsAdded) {
                if (storeModel) {
                    BaseFragmentView.INSTANCE.storeInstanceModel(fragment);
                }
                setEventListener(null);
                fragmentTransactionBeginTransaction.hide(fragment);
                fragmentTransactionBeginTransaction.commitNow();
                fragmentTransactionBeginTransaction.remove(fragment);
            }
        }
        BaseFragmentView baseFragmentViewCreateView = createView();
        Intrinsics.checkNotNull(baseFragmentViewCreateView);
        baseFragmentViewCreateView.setArguments(extras);
        setExtraArgumentToView(fragment);
        fragmentTransactionBeginTransaction.add(C7944R.id.fragment_container, baseFragmentViewCreateView, tag).commit();
        return baseFragmentViewCreateView;
    }

    private final int getBLEEventId(int keycode, boolean withCtrl, boolean withShift) {
        if (!withCtrl || !withShift) {
            return -1;
        }
        if (keycode == 29) {
            return 1;
        }
        if (keycode != 32) {
            return keycode != 47 ? -1 : 0;
        }
        return 100;
    }

    private final void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(7942);
    }

    private final boolean isCallForceClosed(Intent intent) {
        if (intent == null) {
            Logger.m7105w(TAG, "isCallForceClosed : null intent ");
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra("tool_force_finish", false);
        Logger.m7100d(TAG, "isCallForceClosed : " + booleanExtra + " / " + intent);
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AbsToolActivity absToolActivity) {
        Logger.m7100d(TAG, "onBackInvokedDispatcher");
        absToolActivity.backPressed();
    }

    private final void printDisplayInfo() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        String str = TAG;
        Logger.m7100d(str, "density = " + displayMetrics.density);
        AbstractC6670b.m4761v(displayMetrics.densityDpi, "DPI = ", str);
        Logger.m7100d(str, "screen = " + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
    }

    private final void setPopupWindowProperties() {
        if (this.mPopupWindowFlag != 0) {
            this.mPopupWindowController = new PopupWindowController(this, this.mPopupWindowFlag);
        }
    }

    private final void showSystemUI() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(GridBagConstraints.BELOW_BASELINE);
    }

    public void addPopupWindowFlags(int flags) {
        this.mPopupWindowFlag = flags | this.mPopupWindowFlag;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.IBaseActivity
    public void bringToFront() {
        if (isDestroyed()) {
            Logger.m7105w(TAG, "bring to front : activity is destroyed");
            return;
        }
        Logger.m7100d(TAG, "bring to front");
        Intent intent = new Intent(this, getConcreteClass());
        intent.setFlags(131072);
        startActivity(intent);
    }

    public boolean checkInvalidCreateCase() {
        try {
            if (((Class) getIntent().getSerializableExtra("data_handler_class")) == null) {
                Logger.m7101e(TAG, "checkInvalidCreateCase : cannot create data handler");
                return true;
            }
            if (getIntent().getExtras() != null) {
                return false;
            }
            Logger.m7101e(TAG, "checkInvalidCreateCase : empty argument");
            return true;
        } catch (Exception e) {
            Logger.m7101e(TAG, "checkInvalidCreateCase : " + e.getMessage());
            return true;
        }
    }

    public void close(@NotNull Intent intent, @Nullable CloseableActivity.Callback callback) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (isCallForceClosed(intent)) {
            boolean booleanExtra = intent.getBooleanExtra("tool_force_finish_with_save", true);
            IEventListener iEventListener = this.mEventListener;
            Intrinsics.checkNotNull(iEventListener);
            iEventListener.onFinishDocumentByUser(booleanExtra);
            callCloseCallback(callback);
        }
    }

    public void controlIndicatorBar() {
        WindowManagerCompat.setHideIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation != 2, false, 4, null);
    }

    @Nullable
    public abstract BaseFragmentView createView();

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        boolean zDispatchTouchEvent;
        PopupWindowController popupWindowController = this.mPopupWindowController;
        if (popupWindowController == null || ev == null) {
            zDispatchTouchEvent = false;
        } else {
            Intrinsics.checkNotNull(popupWindowController);
            zDispatchTouchEvent = popupWindowController.dispatchTouchEvent(ev);
        }
        if (!zDispatchTouchEvent) {
            return super.dispatchTouchEvent(ev);
        }
        BaseFragmentView baseFragmentView = (BaseFragmentView) getSupportFragmentManager().findFragmentByTag(getViewTag());
        Intrinsics.checkNotNull(baseFragmentView);
        baseFragmentView.onDispatchEvent(1);
        return true;
    }

    @Nullable
    public abstract Class<?> getConcreteClass();

    public final boolean getMIsInvalidCreateCase() {
        return this.mIsInvalidCreateCase;
    }

    @Nullable
    public String getOpenUUID() {
        Intent intent = getIntent();
        return intent != null ? intent.getStringExtra("sdoc_uuid") : "";
    }

    @Nullable
    public abstract String getViewTag();

    public void initialize() {
        UtilManager.INSTANCE.onCreate(this);
        getWindow().setSoftInputMode(2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        controlIndicatorBar();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (isCallForceClosed(getIntent())) {
            Logger.m7105w(TAG, "Force close is enabled, but brush is just created!!. Ignored close command");
        }
        super.onCreate(savedInstanceState);
        boolean zCheckInvalidCreateCase = checkInvalidCreateCase();
        this.mIsInvalidCreateCase = zCheckInvalidCreateCase;
        if (zCheckInvalidCreateCase) {
            finish();
            return;
        }
        initialize();
        printDisplayInfo();
        setContentView(C7944R.layout.base_activity_layout);
        addView(savedInstanceState, false);
        setPopupWindowProperties();
        if (Build.VERSION.SDK_INT >= 36) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(-2, new C0109b(this, 3));
        } else {
            getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.addons.base.AbsToolActivity.onCreate.2
                {
                    super(true);
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    AbsToolActivity.this.backPressed();
                }
            });
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        UtilManager.INSTANCE.onDestroy();
        PopupWindowController popupWindowController = this.mPopupWindowController;
        if (popupWindowController != null) {
            Intrinsics.checkNotNull(popupWindowController);
            popupWindowController.close();
            this.mPopupWindowController = null;
        }
        this.mEventListener = null;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        IEventListener iEventListener;
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode != 4 && (iEventListener = this.mEventListener) != null) {
            Intrinsics.checkNotNull(iEventListener);
            iEventListener.onKeyDown(keyCode, event.isCtrlPressed(), event.isShiftPressed());
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractC6670b.m4761v(keyCode, "onKeyUp keyCode ", TAG);
        if (keyCode != 4) {
            int bLEEventId = getBLEEventId(keyCode, event.isCtrlPressed(), event.isShiftPressed());
            if (bLEEventId != -1) {
                IEventListener iEventListener = this.mEventListener;
                if (iEventListener != null) {
                    iEventListener.onBLEEvent(bLEEventId);
                }
            } else {
                IEventListener iEventListener2 = this.mEventListener;
                if (iEventListener2 != null) {
                    iEventListener2.onKeyUp(keyCode, event.isCtrlPressed(), event.isShiftPressed());
                }
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.m7100d(TAG, "onNewIntent");
        super.onNewIntent(intent);
        close(intent, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AbstractC6670b.m4763x("onResume : ", PackageManagerCompat.INSTANCE.getInstance().getVersionInfo(this), TAG);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Logger.m7100d(TAG, "onWindowFocusChanged() - forceHideSoftInput");
            InputMethodCompat.INSTANCE.getInstance().forceHideSoftInput(this);
        }
        if (this.mIsEnableFullMode) {
            hideSystemUI();
        }
    }

    public void setEventListener(@Nullable IEventListener listener) {
        this.mEventListener = listener;
    }

    public void setExtraArgumentToView(@Nullable BaseFragmentView view) {
    }

    public void setFullMode(boolean enable) {
        if (this.mIsEnableFullMode != enable) {
            this.mIsEnableFullMode = enable;
            Logger.m7100d(TAG, "change mode : ".concat(enable ? BuildConfig.FLAVOR : "show system UI"));
            if (this.mIsEnableFullMode) {
                hideSystemUI();
            } else {
                showSystemUI();
            }
        }
    }

    public final void setMIsInvalidCreateCase(boolean z) {
        this.mIsInvalidCreateCase = z;
    }

    public void changeView() {
        addView(null, true);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initialize();
    }
}
