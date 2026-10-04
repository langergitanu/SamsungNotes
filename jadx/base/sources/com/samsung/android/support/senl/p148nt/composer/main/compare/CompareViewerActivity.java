package com.samsung.android.support.senl.p148nt.composer.main.compare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0014J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/CompareViewerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ComposerEditable;", "Lcom/samsung/android/support/senl/cm/base/common/method/ScreenLockable;", "<init>", "()V", "mIsLockNote", "", "mActionBroadcastReceiver", "Landroid/content/BroadcastReceiver;", SyncConflictConfirmDialogPresenter.IS_LOCK_NOTE, "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "addFragment", "onDestroy", "finishWithResult", "resultId", "", "getOpenUUID", "", "verifyScreenLock", "isLockVerified", "resetLockVerified", "ActionBroadcastReceiver", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CompareViewerActivity extends AppCompatActivity implements ActivityLifecycleTracker.ComposerEditable, ScreenLockable {

    @NotNull
    private static final String FRAGMENT_TAG = "compare";

    @NotNull
    private final BroadcastReceiver mActionBroadcastReceiver = new ActionBroadcastReceiver();
    private boolean mIsLockNote;
    private static final String TAG = Logger.createTag("CompareViewerActivity", SimpleComposerConstant.TAG_PREFIX);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/CompareViewerActivity$ActionBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/CompareViewerActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ActionBroadcastReceiver extends BroadcastReceiver {
        public ActionBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), SyncConflictConfirmDialogPresenter.ACTION_DELETED_FROM_SERVER)) {
                CompareViewerActivity.this.finishWithResult(11);
            } else if (CompareViewerActivity.this.mIsLockNote) {
                CompareViewerActivity.this.finishWithResult(10);
            }
        }
    }

    private final void addFragment() {
        Logger.m10999d(TAG, "addFragment");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_TAG) == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.add(C9086R.id.composer_fragment_container, new CompareMainFragment(), FRAGMENT_TAG).commitAllowingStateLoss();
        }
    }

    public final void finishWithResult(int resultId) {
        Logger.m10999d(TAG, "finishWithResult");
        Intent intent = new Intent();
        intent.putExtra(ComposerConstants.RESULT_COMPARE, resultId);
        setResult(-1, intent);
        finish();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    @Nullable
    public String getOpenUUID() {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(NoteInfoArgument.KEY_BUNDLE);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
            return null;
        }
        return ((NoteInfoArgument) parcelableArrayListExtra.get(0)).getUuid();
    }

    /* JADX INFO: renamed from: isLockNote, reason: from getter */
    public final boolean getMIsLockNote() {
        return this.mIsLockNote;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public boolean isLockVerified() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = TAG;
        Logger.m10999d(str, "onCreate");
        if (WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(this) != 0 || getIntent().getStringExtra(SyncConflictConfirmDialogPresenter.DEVICE_NAME_SYNC_CONFLICT) == null) {
            Restriction.showToastNotSupportMultiWindowCompareSyncConflict(this);
            Logger.m11000e(str, "InvalidCreateCase");
            finish();
            return;
        }
        this.mIsLockNote = getIntent().getBooleanExtra(SyncConflictConfirmDialogPresenter.IS_LOCK_NOTE, false);
        IntentFilter intentFilter = new IntentFilter();
        if (this.mIsLockNote) {
            getWindow().setFlags(8192, 8192);
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
        }
        intentFilter.addAction(SyncConflictConfirmDialogPresenter.ACTION_DELETED_FROM_SERVER);
        ContextCompat.registerReceiver(this, this.mActionBroadcastReceiver, intentFilter, 2);
        setContentView(C9086R.layout.compare_comp_activity);
        addFragment();
        Logger.printMemory(str, "onCreate");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.onBackPressed();
        try {
            unregisterReceiver(this.mActionBroadcastReceiver);
        } catch (Exception e) {
            AbstractC8014b.m7207i("unregisterReceiverError# ", e, TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public void resetLockVerified() {
    }

    @Override // com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable
    public void verifyScreenLock() {
    }
}
