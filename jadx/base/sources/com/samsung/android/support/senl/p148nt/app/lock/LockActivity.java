package com.samsung.android.support.senl.p148nt.app.lock;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.C2458a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.lock.model.scenario.LockScenario;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockBackupUtil;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.ViewStateListener;
import com.samsung.android.support.senl.p148nt.app.lock.view.create.CreatePasswordView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyBackupPasswordView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyFingerprintView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyFingerprintViewUnderP;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyIrisView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyIrisViewUnderQ;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyMultiBioView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyPasswordView;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bH\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/LockActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mViewScenario", "Lcom/samsung/android/support/senl/nt/app/lock/model/scenario/LockScenario;", "mCurrentView", "Lcom/samsung/android/support/senl/nt/app/lock/view/base/AbsBaseView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateControlIndicatorBar", "status", "", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onRestoreInstanceState", "onWindowFocusChanged", "hasFocus", "", "registerOnApplyWindowInsetsListener", "unregisterOnApplyWindowInsetsListener", "startScenario", "scenarioCode", "showNextView", "additionalInfo", "createReturnIntent", "Landroid/content/Intent;", "finishSuccess", "finishCancel", "mLockViewListener", "Lcom/samsung/android/support/senl/nt/app/lock/view/base/ViewStateListener;", "isFingerprintSupportedForMigration", "()Z", "hasFingerprintChanged", "isIrisSupportedForMigration", "hasIrisChanged", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockActivity extends AppCompatActivity {

    @NotNull
    public static final String INTENT_EXTRA_KEY_LOCK_SCENARIO_TYPE = "key_lock_scenario_type";

    @NotNull
    private static final String STATE_BUNDLE_KEY_QUEUE = "state_bundle_key_queue";

    @Nullable
    private AbsBaseView mCurrentView;

    @NotNull
    private final ViewStateListener mLockViewListener = new ViewStateListener() { // from class: com.samsung.android.support.senl.nt.app.lock.LockActivity$mLockViewListener$1
        @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.ViewStateListener
        public void onFinishCancel() {
            LockLogger.m7356d(LockActivity.TAG, "onFinishCancel");
            this.this$0.finishCancel();
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.ViewStateListener
        public void onFinishSuccess() {
            LockLogger.m7356d(LockActivity.TAG, "onFinishSuccess");
            LockScenario lockScenario = this.this$0.mViewScenario;
            if (lockScenario == null || !lockScenario.hasNext()) {
                this.this$0.finishSuccess();
            } else {
                this.this$0.showNextView(1);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.ViewStateListener
        public void onScenarioChange(int scenarioCode) {
            this.this$0.startScenario(scenarioCode);
        }

        @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.ViewStateListener
        public void onViewChange(int viewType, int additionalInfo) {
            LockLogger.m7356d(LockActivity.TAG, "onViewChange viewType/additionalInfo : " + viewType + "/" + additionalInfo);
            if (this.this$0.isFinishing()) {
                return;
            }
            LockScenario lockScenario = this.this$0.mViewScenario;
            if (lockScenario != null) {
                lockScenario.insertFront(viewType);
            }
            this.this$0.showNextView(additionalInfo);
        }
    };

    @Nullable
    private LockScenario mViewScenario;

    @NotNull
    private static final String TAG = LockLogger.createTag("LockActivity");

    private final Intent createReturnIntent() {
        Intent intent = new Intent();
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_lock_scenario_type", 0);
            Intent intent2 = getIntent();
            intent.putExtra(LockManagerStrategy.EXTRA_KEY_UUID, intent2 != null ? intent2.getStringArrayExtra(LockManagerStrategy.EXTRA_KEY_UUID) : null);
            intent.putExtra("key_lock_scenario_type", intExtra);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishCancel() {
        setResult(0, createReturnIntent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishSuccess() {
        setResult(-1, createReturnIntent());
        finish();
    }

    private final boolean hasFingerprintChanged() {
        Set<String> set;
        if (Build.VERSION.SDK_INT >= 28) {
            return LockPrefUtils.getPrefFingerprintUniqueTime(this) != LockBackupUtil.getPrefFingerprintUniqueTimeBackup(this);
        }
        Set<String> prefFingerprintUniqueIdBackup = LockBackupUtil.getPrefFingerprintUniqueIdBackup(this);
        return prefFingerprintUniqueIdBackup == null || (set = LockPrefUtils.getPrefFingerprintUniqueId(this)) == null || set.isEmpty() || !prefFingerprintUniqueIdBackup.containsAll(set);
    }

    private final boolean hasIrisChanged() {
        if (Build.VERSION.SDK_INT >= 28) {
            return LockPrefUtils.getPrefIrisUniqueTime(this) != LockBackupUtil.getPrefIrisUniqueTimeBackup(this);
        }
        String prefIrisUniqueIdBackup = LockBackupUtil.getPrefIrisUniqueIdBackup(this);
        String prefIrisUniqueId = LockPrefUtils.getPrefIrisUniqueId(this);
        return TextUtils.isEmpty(prefIrisUniqueIdBackup) || TextUtils.isEmpty(prefIrisUniqueId) || !Intrinsics.areEqual(prefIrisUniqueIdBackup, prefIrisUniqueId);
    }

    private final boolean isFingerprintSupportedForMigration() {
        return LockPrefUtils.getPrefAvailableFingerprint(this) && LockPrefUtils.getPrefUseFingerprint(this) && !hasFingerprintChanged();
    }

    private final boolean isIrisSupportedForMigration() {
        return LockPrefUtils.getPrefAvailableIris(this) && LockPrefUtils.getPrefUseIris(this) && !hasIrisChanged();
    }

    private final void registerOnApplyWindowInsetsListener() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (!CommonUtil.isAvailableActivity(this)) {
                LockLogger.m7356d(TAG, "registerOnApplyWindowInsetsListener not availableActivity");
                return;
            }
            View viewFindViewById = findViewById(C8003R.id.lock_main_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new C2458a(viewFindViewById));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat registerOnApplyWindowInsetsListener$lambda$0(View view, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        String str = TAG;
        int i2 = insets2.top;
        int i4 = insets2.left;
        int i5 = insets2.right;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "registerOnApplyWindowInsetsListener apply paddingBottom = ", ", systemInsetsTop = ", ", systemInsetsLeft = ");
        sbM1173s.append(i4);
        sbM1173s.append(", systemInsetsRight = ");
        sbM1173s.append(i5);
        LockLogger.m7356d(str, sbM1173s.toString());
        view.setPadding(insets2.left, insets2.top, insets2.right, i);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNextView(int additionalInfo) {
        LockScenario lockScenario = this.mViewScenario;
        if (lockScenario == null || !lockScenario.hasNext()) {
            return;
        }
        LockScenario lockScenario2 = this.mViewScenario;
        Intrinsics.checkNotNull(lockScenario2);
        int nextViewType = lockScenario2.getNextViewType();
        String str = TAG;
        LockLogger.m7356d(str, "showNextView : " + nextViewType);
        if (nextViewType == 11) {
            this.mCurrentView = new CreatePasswordView(false);
        } else if (nextViewType == 21) {
            this.mCurrentView = new VerifyPasswordView(false, additionalInfo);
        } else if (nextViewType == 31) {
            this.mCurrentView = new VerifyFingerprintViewUnderP();
        } else if (nextViewType != 41) {
            switch (nextViewType) {
                case 1:
                    this.mCurrentView = new CreatePasswordView(true);
                    break;
                case 2:
                    this.mCurrentView = new VerifyPasswordView(true, additionalInfo);
                    break;
                case 3:
                    this.mCurrentView = new VerifyFingerprintView();
                    break;
                case 4:
                    this.mCurrentView = new VerifyIrisView();
                    break;
                case 5:
                    this.mCurrentView = new VerifyMultiBioView();
                    break;
                case 6:
                    this.mCurrentView = new CreatePasswordView(true, CreatePasswordView.Mode.CHANGE);
                    break;
                case 7:
                    this.mCurrentView = (isFingerprintSupportedForMigration() && isIrisSupportedForMigration()) ? new VerifyMultiBioView(AbsBaseBiometricView.PASSWORDTYPE.OLD) : isFingerprintSupportedForMigration() ? new VerifyFingerprintView(AbsBaseBiometricView.PASSWORDTYPE.OLD) : isIrisSupportedForMigration() ? new VerifyIrisView(AbsBaseBiometricView.PASSWORDTYPE.OLD) : new VerifyBackupPasswordView();
                    break;
                case 8:
                    this.mCurrentView = new VerifyBackupPasswordView();
                    break;
                default:
                    LockLogger.m7356d(str, "invalid view type");
                    this.mCurrentView = null;
                    break;
            }
        } else {
            this.mCurrentView = new VerifyIrisViewUnderQ();
        }
        AbsBaseView absBaseView = this.mCurrentView;
        if (absBaseView == null) {
            finishCancel();
            return;
        }
        Intrinsics.checkNotNull(absBaseView);
        absBaseView.setOnFinishCallback(this.mLockViewListener);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i = C8003R.id.lock_fragment_container;
        AbsBaseView absBaseView2 = this.mCurrentView;
        Intrinsics.checkNotNull(absBaseView2);
        fragmentTransactionBeginTransaction.replace(i, absBaseView2).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startScenario(int scenarioCode) {
        String str = TAG;
        LockLogger.m7356d(str, "startScenario : " + scenarioCode);
        boolean prefUseFingerprint = LockPrefUtils.getPrefUseFingerprint(this);
        boolean prefUseIris = LockPrefUtils.getPrefUseIris(this);
        if (LockUtils.isBiometricDisabledMode(this)) {
            prefUseFingerprint = false;
            prefUseIris = false;
        }
        LockScenario lockScenario = new LockScenario(scenarioCode, prefUseFingerprint, prefUseIris);
        this.mViewScenario = lockScenario;
        if (lockScenario.hasNext()) {
            showNextView(1);
        } else {
            LockLogger.m7356d(str, "Wrong scenario parameter.");
            finishCancel();
        }
    }

    private final void unregisterOnApplyWindowInsetsListener() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (!CommonUtil.isAvailableActivity(this)) {
                LockLogger.m7356d(TAG, "unregisterOnApplyWindowInsetsListener not availableActivity");
            }
            View viewFindViewById = findViewById(C8003R.id.lock_main_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            viewFindViewById.setOnApplyWindowInsetsListener(null);
        }
    }

    private final void updateControlIndicatorBar(int status) {
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, status, false, 4, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateControlIndicatorBar(newConfig.orientation);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!DesktopModeCompat.INSTANCE.getInstance().isDexMode(this)) {
            getWindow().addFlags(8192);
        }
        setContentView(C8003R.layout.lock_main_activity);
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C8003R.id.lock_main_container));
        if (savedInstanceState == null) {
            startScenario(getIntent().getIntExtra("key_lock_scenario_type", 0));
            registerOnApplyWindowInsetsListener();
            updateControlIndicatorBar(getResources().getConfiguration().orientation);
            return;
        }
        Fragment fragment = getSupportFragmentManager().getFragments().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.lock.view.base.AbsBaseView");
        AbsBaseView absBaseView = (AbsBaseView) fragment;
        this.mCurrentView = absBaseView;
        if (absBaseView != null) {
            absBaseView.setOnFinishCallback(this.mLockViewListener);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterOnApplyWindowInsetsListener();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Integer> integerArrayList = savedInstanceState.getIntegerArrayList(STATE_BUNDLE_KEY_QUEUE);
        if (integerArrayList == null) {
            return;
        }
        this.mViewScenario = new LockScenario(integerArrayList);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        LockScenario lockScenario = this.mViewScenario;
        outState.putIntegerArrayList(STATE_BUNDLE_KEY_QUEUE, lockScenario != null ? lockScenario.getViewQueue() : null);
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AbsBaseView absBaseView = this.mCurrentView;
        if (absBaseView != null) {
            absBaseView.onWindowFocusChanged(hasFocus);
        }
    }
}
