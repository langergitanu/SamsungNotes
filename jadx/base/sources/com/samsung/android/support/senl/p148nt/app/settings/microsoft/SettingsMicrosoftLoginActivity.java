package com.samsung.android.support.senl.p148nt.app.settings.microsoft;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoftLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mProgressFragment", "Landroidx/fragment/app/DialogFragment;", "mSignInButton", "Landroid/widget/Button;", "mCancelButton", "mSettingsMicrosoft", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateLayout", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onBackPressed", "MsCallback", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMicrosoftLoginActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG = "ST$SettingsMicrosoftLoginActivity";

    @Nullable
    private Button mCancelButton;
    private DialogFragment mProgressFragment;
    private SettingsMicrosoft mSettingsMicrosoft;

    @Nullable
    private Button mSignInButton;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoftLoginActivity$MsCallback;", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft$MicrosoftCallback;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoftLoginActivity;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoftLoginActivity;)V", "mActivity", "Ljava/lang/ref/WeakReference;", "onUpdate", "", "isSignIn", "", "info", "", "onEnable", "enable", "startSyncToMsAccountActivity", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MsCallback implements SettingsMicrosoft.MicrosoftCallback {

        @NotNull
        private final WeakReference<SettingsMicrosoftLoginActivity> mActivity;

        public MsCallback(@NotNull SettingsMicrosoftLoginActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.mActivity = new WeakReference<>(activity);
        }

        private final void startSyncToMsAccountActivity() {
            SettingsMicrosoftLoginActivity settingsMicrosoftLoginActivity = this.mActivity.get();
            if (settingsMicrosoftLoginActivity == null) {
                return;
            }
            Intent intent = new Intent(settingsMicrosoftLoginActivity, NoteListAccessHandler.getSettingsActivity());
            intent.setAction(NotesConstants.ACTION_MICROSOFT_LOGIN);
            intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 2);
            intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_SETTINGS);
            settingsMicrosoftLoginActivity.startActivity(intent);
        }

        @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
        public void onEnable(boolean enable) {
            SettingsMicrosoftLoginActivity settingsMicrosoftLoginActivity = this.mActivity.get();
            if (settingsMicrosoftLoginActivity == null || enable) {
                return;
            }
            settingsMicrosoftLoginActivity.finish();
        }

        @Override // com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft.MicrosoftCallback
        public void onUpdate(boolean isSignIn, @Nullable String info) {
            SettingsMicrosoftLoginActivity settingsMicrosoftLoginActivity = this.mActivity.get();
            if (settingsMicrosoftLoginActivity == null) {
                return;
            }
            DialogFragment dialogFragment = settingsMicrosoftLoginActivity.mProgressFragment;
            if (dialogFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressFragment");
                dialogFragment = null;
            }
            dialogFragment.dismissAllowingStateLoss();
            if (isSignIn) {
                startSyncToMsAccountActivity();
                settingsMicrosoftLoginActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(SettingsMicrosoftLoginActivity settingsMicrosoftLoginActivity, View view) {
        if (C0158a.m407a().m416i()) {
            Context applicationContext = settingsMicrosoftLoginActivity.getApplicationContext();
            if (!C0145c.m334s(applicationContext)) {
                ToastHandler.show(applicationContext, applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_connection_error_msg), 0, false);
                return;
            }
            SettingsMicrosoft settingsMicrosoft = settingsMicrosoftLoginActivity.mSettingsMicrosoft;
            DialogFragment dialogFragment = null;
            if (settingsMicrosoft == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingsMicrosoft");
                settingsMicrosoft = null;
            }
            if (!settingsMicrosoft.isAuthInitCompleted()) {
                ToastHandler.show(applicationContext, AbstractC0541b.m757C(applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_init_error_msg_first), " ", applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_init_error_msg_second)), 0, false);
                return;
            }
            SettingsMicrosoft settingsMicrosoft2 = settingsMicrosoftLoginActivity.mSettingsMicrosoft;
            if (settingsMicrosoft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingsMicrosoft");
                settingsMicrosoft2 = null;
            }
            if (!settingsMicrosoft2.signIn()) {
                ToastHandler.show(applicationContext, AbstractC0541b.m757C(applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_init_error_msg_first), " ", applicationContext.getResources().getString(C8003R.string.settings_sync_to_ms_network_init_error_msg_second)), 0, false);
                return;
            }
            DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
            settingsMicrosoftLoginActivity.mProgressFragment = dialogFragmentCreateProgressDialogFragment;
            if (dialogFragmentCreateProgressDialogFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressFragment");
                dialogFragmentCreateProgressDialogFragment = null;
            }
            dialogFragmentCreateProgressDialogFragment.setCancelable(false);
            DialogFragment dialogFragment2 = settingsMicrosoftLoginActivity.mProgressFragment;
            if (dialogFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressFragment");
            } else {
                dialogFragment = dialogFragment2;
            }
            ((DialogUtils.ProgressDialogFragment) dialogFragment).showAllowingStateLoss(settingsMicrosoftLoginActivity.getSupportFragmentManager(), TAG);
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_LOGIN, SettingsSAConstants.EVENT_SETTINGS_MS_SYNC_GET_STARTED);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ButtonShapeUtil.INSTANCE.updateContainedButtonLayout(this, findViewById(C8003R.id.layout_container), this.mSignInButton, this.mCancelButton);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
        updateLayout();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MSLogger.m8635i(TAG, "onCreate()");
        setContentView(C8003R.layout.settings_microsoft_login_activity);
        this.mSettingsMicrosoft = new SettingsMicrosoft(new WeakReference(this), new MsCallback(this));
        Button button = (Button) findViewById(C8003R.id.sign_in_button);
        this.mSignInButton = button;
        if (button != null) {
            final int i = 0;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SettingsMicrosoftLoginActivity f6333b;

                {
                    this.f6333b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            SettingsMicrosoftLoginActivity.onCreate$lambda$0(this.f6333b, view);
                            break;
                        default:
                            super/*androidx.fragment.app.FragmentActivity*/.onBackPressed();
                            break;
                    }
                }
            });
        }
        Button button2 = (Button) findViewById(C8003R.id.cancel_button);
        this.mCancelButton = button2;
        if (button2 != null) {
            final int i2 = 1;
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SettingsMicrosoftLoginActivity f6333b;

                {
                    this.f6333b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            SettingsMicrosoftLoginActivity.onCreate$lambda$0(this.f6333b, view);
                            break;
                        default:
                            super/*androidx.fragment.app.FragmentActivity*/.onBackPressed();
                            break;
                    }
                }
            });
        }
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), this.mSignInButton, 17.0f);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), this.mCancelButton, 17.0f);
        updateLayout();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
        if (settingsMicrosoft == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingsMicrosoft");
            settingsMicrosoft = null;
        }
        settingsMicrosoft.release();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ButtonShapeUtil.INSTANCE.updateContainedButtonLayout(this, findViewById(C8003R.id.layout_container), this.mSignInButton, this.mCancelButton);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_MS_LOGIN);
        SystemUi.setNavigationBarTheme(this, getColor(C8003R.color.settings_microsoft_login_background_color), !ContextUtils.isNightMode(this));
        SystemUi.setStatusBarColor(this, getColor(C8003R.color.settings_microsoft_login_background_color));
        updateLayout();
    }

    public final void updateLayout() {
        if (WidgetInsetUtils.getCanUseWindowInsets()) {
            WidgetInsetUtils.applyWindowInsetsForMs(getWindow(), findViewById(C8003R.id.activity_container));
        } else {
            WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        }
    }
}
