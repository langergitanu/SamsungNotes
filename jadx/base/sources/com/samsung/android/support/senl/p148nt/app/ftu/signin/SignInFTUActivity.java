package com.samsung.android.support.senl.p148nt.app.ftu.signin;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/ftu/signin/SignInFTUActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mButtonVisibility", "", "mIsSigned", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkedIsSigned", "initLayout", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateAppNameSize", "updateAppNameMargin", "updateOnboardingPageWidthByScreenSize", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SignInFTUActivity extends AppCompatActivity {

    @NotNull
    private static final String KEY_BUTTON_VISIBILITY = "key_button_visibility";

    @NotNull
    private static final String KEY_IS_ALREADY_SIGNED = "key_already_signed";
    private static final int NOT_CHECKED = -1;
    private static final int NOT_SIGNED = 0;
    private static final int SIGNED = 1;

    @NotNull
    private static final String TAG = "SignInFTUActivity";
    private int mButtonVisibility = 4;
    private int mIsSigned = -1;

    private final void checkedIsSigned() {
        if (this.mIsSigned > -1) {
            return;
        }
        boolean zM14285a = ((C13540g) C13541h.m14287e().f9588a).m14285a();
        this.mIsSigned = zM14285a ? 1 : 0;
        AbstractC6670b.m4736A(zM14285a ? 1 : 0, "checkedIsSigned# IsSigned : ", TAG);
        this.mButtonVisibility = 0;
    }

    private final void initLayout() {
        updateAppNameSize();
        updateAppNameMargin();
        Button button = (Button) findViewById(C8003R.id.sign_in_button);
        button.setVisibility(this.mButtonVisibility);
        button.setText(this.mIsSigned == 1 ? C8003R.string.ftu_get_start : C8003R.string.ftu_sign_in);
        button.setOnClickListener(new ViewOnClickListenerC0157a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$0(SignInFTUActivity signInFTUActivity, View view) {
        AbstractC6670b.m4736A(signInFTUActivity.mIsSigned, "onClick# ", TAG);
        if (signInFTUActivity.mIsSigned == 0) {
            signInFTUActivity.setResult(-1);
        }
        signInFTUActivity.finish();
    }

    private final void updateAppNameMargin() {
        double d;
        double dimensionPixelSize;
        double dConvertDpToPixel;
        boolean z = getResources().getConfiguration().orientation == 2;
        float heightPx = DisplayUtils.getHeightPx(this);
        float widthDp = DisplayUtils.getWidthDp(this);
        if (DeviceInfo.isVSTModel()) {
            dConvertDpToPixel = ResourceUtils.convertDpToPixel(getBaseContext(), 48.0f);
            dimensionPixelSize = ResourceUtils.convertDpToPixel(getBaseContext(), 32.0f);
        } else if (widthDp >= 751.0f) {
            double d2 = heightPx;
            double d3 = (z ? 0.135d : 0.21d) * d2;
            dimensionPixelSize = d2 * (z ? 0.065d : 0.095d);
            dConvertDpToPixel = d3;
        } else {
            if (widthDp >= 600.0f) {
                double d4 = heightPx;
                d = 0.14d * d4;
                dimensionPixelSize = d4 * 0.08d;
            } else {
                double d5 = heightPx;
                d = (z ? 0.1d : 0.14d) * d5;
                dimensionPixelSize = z ? getResources().getDimensionPixelSize(C8003R.dimen.ftu_sign_in_app_name_margin_bottom) : d5 * 0.08d;
            }
            dConvertDpToPixel = d;
        }
        View viewFindViewById = findViewById(C8003R.id.sign_in_app_name);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = (int) dConvertDpToPixel;
        marginLayoutParams.bottomMargin = (int) dimensionPixelSize;
        viewFindViewById.setLayoutParams(marginLayoutParams);
    }

    private final void updateAppNameSize() {
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), (TextView) findViewById(C8003R.id.sign_in_app_name), DeviceInfo.isVSTModel() ? 32.0f : com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils.isTabletLayout(this) ? 34.0f : 30.0f);
    }

    private final void updateOnboardingPageWidthByScreenSize() {
        if (DeviceInfo.isVSTModel()) {
            DisplayUtils.updateOnboardingPageWidthByScreenSizeForVst(this, findViewById(C8003R.id.activity_container));
        } else {
            DisplayUtils.updateOnboardingPageWidthByScreenSize(this, findViewById(C8003R.id.activity_container));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateAppNameSize();
        updateAppNameMargin();
        updateOnboardingPageWidthByScreenSize();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C8003R.layout.sign_in_ftu_activity);
        if (savedInstanceState != null) {
            this.mButtonVisibility = savedInstanceState.getInt(KEY_BUTTON_VISIBILITY, 4);
            this.mIsSigned = savedInstanceState.getInt(KEY_IS_ALREADY_SIGNED, -1);
        }
        checkedIsSigned();
        initLayout();
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        updateOnboardingPageWidthByScreenSize();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTON_VISIBILITY, this.mButtonVisibility);
        outState.putInt(KEY_IS_ALREADY_SIGNED, this.mIsSigned);
    }
}
