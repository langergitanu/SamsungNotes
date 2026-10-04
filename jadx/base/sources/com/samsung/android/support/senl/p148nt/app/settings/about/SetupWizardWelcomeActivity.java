package com.samsung.android.support.senl.p148nt.app.settings.about;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.about.SetupWizardWelcomeActivity;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/about/SetupWizardWelcomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setDisplayHomeAsUpEnabled", "enabled", "", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateOnboardingPageWidthByScreenSize", "onSupportNavigateUp", "onBackPressed", "finishWithOk", "finishWithCancel", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SetupWizardWelcomeActivity extends AppCompatActivity {
    private static final long DELAY_TO_WAIT_POPUP_NOTE = 500;

    @NotNull
    private static final String TAG = "SetupWizardWelcomeActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithCancel() {
        setResult(0, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithOk() {
        setResult(-1, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SetupWizardWelcomeActivity setupWizardWelcomeActivity, View view) {
        PermissionHelper.setDoNotShowAppPermissionNotice();
        setupWizardWelcomeActivity.setResult(-1, new Intent());
        if (!KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(setupWizardWelcomeActivity)) {
            setupWizardWelcomeActivity.finishWithOk();
            return;
        }
        PopupNoteService.Companion companion = PopupNoteService.INSTANCE;
        Context applicationContext = setupWizardWelcomeActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.startPopupNoteService(applicationContext, true, TAG);
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0015b(setupWizardWelcomeActivity, 14), 500L);
    }

    private final void setDisplayHomeAsUpEnabled(boolean enabled) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setDisplayHomeAsUpEnabled(enabled);
    }

    private final void updateOnboardingPageWidthByScreenSize() {
        if (DeviceInfo.isVSTModel()) {
            DisplayUtils.updateOnboardingPageWidthByScreenSizeForVst(this, findViewById(C8003R.id.activity_container));
        } else {
            DisplayUtils.updateOnboardingPageWidthByScreenSize(this, findViewById(C8003R.id.activity_content));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        MainLogger.m7254d(TAG, "onBackPressed");
        setResult(0, new Intent());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateOnboardingPageWidthByScreenSize();
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(getApplicationContext())) {
            WindowManagerCompat.INSTANCE.getInstance().setShowWhenLocked(this, true, false);
        }
        setContentView(C8003R.layout.app_permission_activity);
        String string = getString(C8003R.string.permissions_header);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toolbar toolbar = (Toolbar) findViewById(C8003R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(string);
            setSupportActionBar(toolbar);
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            findViewById(C8003R.id.contacts_layout).setVisibility(0);
        }
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(C8003R.id.collapsing_app_bar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(string);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            findViewById(C8003R.id.storage_layout).setVisibility(8);
            findViewById(C8003R.id.notifications_layout).setVisibility(0);
            if (i < 34) {
                findViewById(C8003R.id.photos_and_videos_layout).setVisibility(0);
                findViewById(C8003R.id.music_and_audio_layout).setVisibility(0);
            }
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            findViewById(C8003R.id.special_sensitive_required_permissions_category).setVisibility(0);
            findViewById(C8003R.id.special_sensitive_required_permissions_layout).setVisibility(0);
            findViewById(C8003R.id.optional_permission_detail_description).setVisibility(8);
        }
        if (getIntent().getBooleanExtra(Constants.PERMISSION_NOTICE_BUTTON, false)) {
            setDisplayHomeAsUpEnabled(false);
            findViewById(C8003R.id.button_container).setVisibility(0);
            final int i2 = 0;
            findViewById(C8003R.id.button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: S2.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SetupWizardWelcomeActivity f732b;

                {
                    this.f732b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f732b.finishWithCancel();
                            break;
                        default:
                            SetupWizardWelcomeActivity.onCreate$lambda$3(this.f732b, view);
                            break;
                    }
                }
            });
            final int i4 = 1;
            findViewById(C8003R.id.button_continue).setOnClickListener(new View.OnClickListener(this) { // from class: S2.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SetupWizardWelcomeActivity f732b;

                {
                    this.f732b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            this.f732b.finishWithCancel();
                            break;
                        default:
                            SetupWizardWelcomeActivity.onCreate$lambda$3(this.f732b, view);
                            break;
                    }
                }
            });
        } else {
            setDisplayHomeAsUpEnabled(true);
        }
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        companion.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        WindowManagerCompat.controllIndicatorBar$default(companion.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateOnboardingPageWidthByScreenSize();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
