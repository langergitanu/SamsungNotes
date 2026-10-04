package com.samsung.android.support.senl.p148nt.composer.main.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ComposerStartManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.UpdatedServerNoteList;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0017J\"\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0015J+\u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000fH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010,\u001a\u00020\u000bH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J\b\u0010/\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\"H\u0014J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u001aH\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0014H\u0004J(\u00106\u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u000208072\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u001aH\u0016R\u0014\u0010\u0015\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/cm/base/common/method/ScreenLockable;", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ComposerEditable;", "<init>", "()V", "getConcreteClass", "Ljava/lang/Class;", "getClassName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "canStartComposer", "", "disableSystemBarInsets", "initialize", "addFragment", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "fragmentTag", "getFragmentTag", "()Ljava/lang/String;", "onKeyUp", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onBackPressed", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onWindowFocusChanged", "hasFocus", "getOpenUUID", "verifyScreenLock", "isLockVerified", "resetLockVerified", "onDetachedFromWindow", "onAttachedToWindow", "onNewIntent", MarketingConstants.LINK_TYPE_INTENT, "onTrimMemory", "level", "getBaseComposerFragment", "onProvideKeyboardShortcuts", "", "Landroid/view/KeyboardShortcutGroup;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "deviceId", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BaseComposerActivity extends AppCompatActivity implements ScreenLockable, ActivityLifecycleTracker.ComposerEditable {
    private static final String TAG = Logger.createTag("BaseComposerActivity");

    private final boolean canStartComposer() {
        String openUUID = getOpenUUID();
        boolean zCanStartComposer = ComposerStartManager.INSTANCE.getInstance().canStartComposer(openUUID);
        if (zCanStartComposer) {
            boolean zIsServerNoteUpdated = UpdatedServerNoteList.isServerNoteUpdated(openUUID);
            boolean z = !zIsServerNoteUpdated;
            if (zIsServerNoteUpdated) {
                Logger.m11002f(TAG, "UpdatedServerNoteList.isServerNoteUpdated is true with uuid : " + openUUID);
            }
            zCanStartComposer = z;
        }
        if (zCanStartComposer) {
            return true;
        }
        ToastHandler.show(getApplicationContext(), C9086R.string.updating_note_try_again_later, 1);
        finish();
        return false;
    }

    public void addFragment() {
        Logger.m10999d(TAG, "addFragment");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (supportFragmentManager.findFragmentByTag(getFragmentTag()) == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.add(C9086R.id.composer_fragment_container, createFragment(), getFragmentTag()).commitAllowingStateLoss();
        }
    }

    @NotNull
    public BaseComposerFragment createFragment() {
        return new BaseComposerFragment();
    }

    public void disableSystemBarInsets() {
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C9086R.id.composer_fragment_container));
    }

    @Nullable
    public final BaseComposerFragment getBaseComposerFragment() {
        return (BaseComposerFragment) getSupportFragmentManager().findFragmentByTag(getFragmentTag());
    }

    @Nullable
    public String getClassName() {
        return BaseComposerActivity.class.getName();
    }

    @Nullable
    public Class<?> getConcreteClass() {
        return BaseComposerActivity.class;
    }

    @NotNull
    public final String getFragmentTag() {
        return "Composer";
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    @Nullable
    public String getOpenUUID() {
        return getIntent().getStringExtra("sdoc_uuid");
    }

    public void initialize() {
        Logger.m10999d(TAG, "initialize");
        addFragment();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public boolean isLockVerified() {
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        return baseComposerFragment != null && baseComposerFragment.isLockVerified();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WindowManagerCompat.INSTANCE.getInstance().setSensitivePalmRecognitionEnabled(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment == null || !baseComposerFragment.onBackPressed(true)) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = TAG;
        Logger.m10999d(str, "onCreate");
        if (!CommonUtil.initSpenSdk(this)) {
            ToastHandler.show(getApplicationContext(), C9086R.string.change_template_preview_load_failed, 1);
            finish();
            Logger.m11000e(str, "onCreate# initSpenSdk error ");
        } else if (canStartComposer()) {
            try {
                setContentView(C9086R.layout.activity_composer_base);
                disableSystemBarInsets();
                initialize();
                Logger.printMemory(str, "onCreate");
            } catch (Exception e) {
                Logger.m11000e(TAG, "onCreate setContentView: fail" + e.getMessage());
                finish();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
            Logger.m11004w(TAG, "onDetachedFromWindow# clearFlags ex " + e);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event.getFlags() & 33554432) != 0) {
            Logger.m11003i(TAG, "onKeyUp " + keyCode + Constant.WHITE_SPACE_FOR_LINK_ICON + event);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            BaseComposerFragment baseComposerFragment = (BaseComposerFragment) supportFragmentManager.findFragmentByTag(getFragmentTag());
            if (baseComposerFragment != null && baseComposerFragment.onBLEShortcut(event)) {
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Logger.m10999d(TAG, "onNewIntent");
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(@NotNull List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onProvideKeyboardShortcuts(data);
        }
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onTrimMemory(level);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onWindowFocusChanged(hasFocus);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public void resetLockVerified() {
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.resetLockVerified();
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public void verifyScreenLock() {
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null ? baseComposerFragment.verifyScreenLock() : false) {
            return;
        }
        Logger.m11004w(TAG, "verifyScreenLock# fail");
        getIntent().putExtra(ComposerConstants.ARG_REQUEST_TO_VERIFY_SCREENLOCK, true);
    }
}
