package com.samsung.android.support.senl.p148nt.app.settings.about;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.labs.LabsController;
import com.samsung.android.support.senl.p148nt.app.settings.about.AboutActivity;
import com.samsung.android.support.senl.p148nt.app.settings.about.AboutPresenter;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.MarketConnectorFactory;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.AppInfoUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;
import p066P2.RunnableC0201c;
import p077S2.RunnableC0278b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020 H\u0014J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001eH\u0014J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u00020\u001eH\u0016J\b\u00107\u001a\u00020\u001eH\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u00020\u001eH\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\b\u0010?\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u0011R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/about/AboutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter$Contract;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mUpdateNotice", "Landroid/widget/TextView;", "getMUpdateNotice", "()Landroid/widget/TextView;", "mUpdateNotice$delegate", "Lkotlin/Lazy;", "mUpdate", "Landroid/widget/Button;", "getMUpdate", "()Landroid/widget/Button;", "mUpdate$delegate", "mProgressBar", "Landroidx/appcompat/widget/SeslProgressBar;", "getMProgressBar", "()Landroidx/appcompat/widget/SeslProgressBar;", "mProgressBar$delegate", "mOpenSource", "getMOpenSource", "mOpenSource$delegate", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/about/AboutPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initToolBar", "initLayout", "setBackgroundResources", "rootView", "Landroid/view/View;", "onCreateOptionsMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "initAppInfoIcon", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResume", "onDestroy", "updateLayout", "startProgress", "stopProgress", "stateChanged", "newState", "", "onClick", "view", "initLabs", "releaseLabs", "applyOpenSourceLayout", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AboutActivity extends AppCompatActivity implements View.OnClickListener, AboutPresenter.Contract {

    @NotNull
    private static final String KEY_STATE = "key_mode";

    /* JADX INFO: renamed from: mOpenSource$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mOpenSource;

    /* JADX INFO: renamed from: mProgressBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mProgressBar;

    /* JADX INFO: renamed from: mUpdate$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mUpdate;

    /* JADX INFO: renamed from: mUpdateNotice$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mUpdateNotice;

    @NotNull
    private final String TAG = "ST$AboutActivity";

    @NotNull
    private final AboutPresenter mPresenter = new AboutPresenter(this);

    public AboutActivity() {
        final int i = 0;
        this.mUpdateNotice = LazyKt.lazy(new Function0(this) { // from class: S2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AboutActivity f728b;

            {
                this.f728b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i) {
                    case 0:
                        return AboutActivity.mUpdateNotice_delegate$lambda$0(this.f728b);
                    case 1:
                        return AboutActivity.mUpdate_delegate$lambda$1(this.f728b);
                    case 2:
                        return AboutActivity.mProgressBar_delegate$lambda$2(this.f728b);
                    default:
                        return AboutActivity.mOpenSource_delegate$lambda$3(this.f728b);
                }
            }
        });
        final int i2 = 1;
        this.mUpdate = LazyKt.lazy(new Function0(this) { // from class: S2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AboutActivity f728b;

            {
                this.f728b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return AboutActivity.mUpdateNotice_delegate$lambda$0(this.f728b);
                    case 1:
                        return AboutActivity.mUpdate_delegate$lambda$1(this.f728b);
                    case 2:
                        return AboutActivity.mProgressBar_delegate$lambda$2(this.f728b);
                    default:
                        return AboutActivity.mOpenSource_delegate$lambda$3(this.f728b);
                }
            }
        });
        final int i4 = 2;
        this.mProgressBar = LazyKt.lazy(new Function0(this) { // from class: S2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AboutActivity f728b;

            {
                this.f728b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        return AboutActivity.mUpdateNotice_delegate$lambda$0(this.f728b);
                    case 1:
                        return AboutActivity.mUpdate_delegate$lambda$1(this.f728b);
                    case 2:
                        return AboutActivity.mProgressBar_delegate$lambda$2(this.f728b);
                    default:
                        return AboutActivity.mOpenSource_delegate$lambda$3(this.f728b);
                }
            }
        });
        final int i5 = 3;
        this.mOpenSource = LazyKt.lazy(new Function0(this) { // from class: S2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AboutActivity f728b;

            {
                this.f728b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i5) {
                    case 0:
                        return AboutActivity.mUpdateNotice_delegate$lambda$0(this.f728b);
                    case 1:
                        return AboutActivity.mUpdate_delegate$lambda$1(this.f728b);
                    case 2:
                        return AboutActivity.mProgressBar_delegate$lambda$2(this.f728b);
                    default:
                        return AboutActivity.mOpenSource_delegate$lambda$3(this.f728b);
                }
            }
        });
    }

    private final void applyOpenSourceLayout() {
        View viewFindViewById = findViewById(C8003R.id.button_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(C8003R.id.open_source);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById.post(new RunnableC0201c(this, 2, viewFindViewById, viewFindViewById2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyOpenSourceLayout$lambda$12(AboutActivity aboutActivity, View view, View view2) {
        Intrinsics.checkNotNullExpressionValue(aboutActivity.getResources().getConfiguration(), "getConfiguration(...)");
        int iHeight = (int) (DisplayUtils.getWindowSize(aboutActivity, r0).height() * 0.05f);
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), 0);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = iHeight;
        marginLayoutParams.bottomMargin = iHeight;
        view2.requestLayout();
    }

    private final Button getMOpenSource() {
        Object value = this.mOpenSource.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    private final SeslProgressBar getMProgressBar() {
        Object value = this.mProgressBar.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SeslProgressBar) value;
    }

    private final Button getMUpdate() {
        Object value = this.mUpdate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    private final TextView getMUpdateNotice() {
        Object value = this.mUpdateNotice.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final void initAppInfoIcon(Menu menu) {
        Drawable icon = menu.findItem(C8003R.id.action_app_info).getIcon();
        if (icon != null) {
            icon.mutate();
            icon.setColorFilter(new PorterDuffColorFilter(getResources().getColor(C8003R.color.about_notes_app_info_icon_color, null), PorterDuff.Mode.SRC_ATOP));
        }
    }

    private final void initLabs() {
        View viewFindViewById = findViewById(C8003R.id.version);
        if (viewFindViewById == null) {
            MainLogger.m7255e(this.TAG, "init Labs, failed version view is null");
        } else {
            LabsController.getInstance().setController(viewFindViewById);
            MainLogger.m7258i(this.TAG, "init Labs");
        }
    }

    private final void initLayout() {
        MainLogger.m7258i(this.TAG, "initLayout# ");
        TextView textView = (TextView) findViewById(C8003R.id.app_name_text_view);
        TextView textView2 = (TextView) findViewById(C8003R.id.version);
        textView.setText(this.mPresenter.getAppName());
        AboutPresenter aboutPresenter = this.mPresenter;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        textView2.setText(aboutPresenter.getVersionText(applicationContext));
        if (AiViewUtils.isAtLeastOneUI85()) {
            textView.setTextAppearance(C8003R.style.RobotoMediumStyle);
        }
        getMUpdate().setOnClickListener(this);
        getMOpenSource().setOnClickListener(this);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), textView, 34.0f);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), textView2, 14.0f);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), getMUpdateNotice(), 14.0f);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), getMUpdate(), 17.0f);
        CharUtils.applyTextSizeUntilLargeSize(getApplicationContext(), getMOpenSource(), 17.0f);
    }

    private final void initToolBar() {
        MainLogger.m7258i(this.TAG, "initToolBar# ");
        Toolbar toolbar = (Toolbar) findViewById(C8003R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button mOpenSource_delegate$lambda$3(AboutActivity aboutActivity) {
        return (Button) aboutActivity.findViewById(C8003R.id.open_source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeslProgressBar mProgressBar_delegate$lambda$2(AboutActivity aboutActivity) {
        return (SeslProgressBar) aboutActivity.findViewById(C8003R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mUpdateNotice_delegate$lambda$0(AboutActivity aboutActivity) {
        return (TextView) aboutActivity.findViewById(C8003R.id.update_notice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button mUpdate_delegate$lambda$1(AboutActivity aboutActivity) {
        return (Button) aboutActivity.findViewById(C8003R.id.update);
    }

    private final void releaseLabs() {
        LabsController.getInstance().removeController(findViewById(C8003R.id.version));
    }

    private final void setBackgroundResources(View rootView) {
        if (DeviceInfo.isVSTModel()) {
            rootView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), C8003R.color.about_notes_background_color_for_vst));
            rootView.findViewById(C8003R.id.toolbar).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), C8003R.color.about_notes_background_color_for_vst));
            rootView.findViewById(C8003R.id.collapsing_toolbar).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), C8003R.color.about_notes_background_color_for_vst));
            getMOpenSource().setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), C8003R.color.contained_button_default_bg_for_vst)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startProgress$lambda$8(AboutActivity aboutActivity) {
        aboutActivity.getMProgressBar().setVisibility(0);
        aboutActivity.getMUpdate().setVisibility(8);
        aboutActivity.getMUpdateNotice().setText((CharSequence) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stateChanged$lambda$10(AboutActivity aboutActivity) {
        int updateText = aboutActivity.mPresenter.getUpdateText();
        if (updateText == 0) {
            aboutActivity.getMUpdate().setVisibility(8);
            aboutActivity.getMUpdate().setText((CharSequence) null);
        } else {
            aboutActivity.getMUpdate().setVisibility(0);
            aboutActivity.getMUpdate().setText(updateText);
        }
        int updateNoticeText = aboutActivity.mPresenter.getUpdateNoticeText();
        if (updateNoticeText == 0) {
            aboutActivity.getMUpdateNotice().setVisibility(8);
            aboutActivity.getMUpdateNotice().setText((CharSequence) null);
        } else {
            aboutActivity.getMUpdateNotice().setVisibility(0);
            aboutActivity.getMUpdateNotice().setText(updateNoticeText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopProgress$lambda$9(AboutActivity aboutActivity) {
        aboutActivity.getMProgressBar().setVisibility(8);
    }

    private final void updateLayout() {
        MainLogger.m7258i(this.TAG, "updateLayout#");
        if (getResources().getConfiguration().orientation == 1) {
            DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.button_layout_container));
            View viewFindViewById = findViewById(C8003R.id.update_button_bottom_space);
            if (viewFindViewById != null) {
                Configuration configuration = getResources().getConfiguration();
                Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
                viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (((double) DisplayUtils.getWindowSize(this, configuration).height()) * 0.07d)));
            }
            applyOpenSourceLayout();
        } else {
            DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.activity_layout));
        }
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (UserInputSkipper.isValidEvent(UserInputSkipper.Tag.Default)) {
            UserInputSkipper.INSTANCE.setHoldingEventTime();
            int id = view.getId();
            if (id == C8003R.id.open_source) {
                if (LabsController.getInstance().runLabs(this)) {
                    return;
                }
                startActivity(new Intent(this, (Class<?>) OpenSourceLicenseActivity.class));
                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_ABOUT_SAMSUNG_NOTES, SettingsSAConstants.EVENT_ABOUT_SAMSUNG_NOTES_OPEN_SOURCE_LICENSE);
                return;
            }
            if (id == C8003R.id.update) {
                if (this.mPresenter.isUpdateState()) {
                    this.mPresenter.moveToMarket();
                    CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_ABOUT_SAMSUNG_NOTES, SettingsSAConstants.EVENT_ABOUT_SAMSUNG_NOTES_UPDATE);
                } else if (this.mPresenter.isRetryState()) {
                    if (!C0145c.m334s(getApplicationContext())) {
                        ToastHandler.show(getApplicationContext(), C8003R.string.network_error, 1);
                    } else {
                        this.mPresenter.checkNewVersion();
                        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_ABOUT_SAMSUNG_NOTES, SettingsSAConstants.EVENT_ABOUT_SAMSUNG_NOTES_UPDATE_RETRY);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateLayout();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainLogger.m7258i(this.TAG, "onCreate()");
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
        setContentView(C8003R.layout.aboutnote_activity);
        initToolBar();
        initLayout();
        this.mPresenter.setMarketConnector(MarketConnectorFactory.createMarketConnector());
        this.mPresenter.checkNewVersion();
        if (savedInstanceState != null) {
            stopProgress();
            this.mPresenter.setState(savedInstanceState.getInt(KEY_STATE, 0));
        }
        ContextUtils.setTaskDescription(this, C8003R.color.task_description_title_color);
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(findViewById(C8003R.id.activity_container));
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        SystemUi.setNavigationBarTheme(window, !ContextUtils.isNightMode(getApplicationContext()));
        initLabs();
        View viewFindViewById = findViewById(C8003R.id.activity_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setBackgroundResources(viewFindViewById);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(C8003R.menu.about_notes, menu);
        initAppInfoIcon(menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MainLogger.m7258i(this.TAG, "onDestroy#");
        this.mPresenter.releaseMarketConnector();
        releaseLabs();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (item.getItemId() != C8003R.id.action_app_info) {
            return super.onOptionsItemSelected(item);
        }
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        AppInfoUtil.showDetailsSettings(this, packageName, true);
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_ABOUT_SAMSUNG_NOTES, SettingsSAConstants.EVENT_ABOUT_SAMSUNG_NOTES_APP_INFO);
        ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new RunnableC0278b(this, 1));
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MainLogger.m7258i(this.TAG, "onResume#");
        updateLayout();
        UpdateManager.getInstance().setHasBadge(false);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(KEY_STATE, this.mPresenter.getMState());
        super.onSaveInstanceState(outState);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.about.AboutPresenter.Contract
    public void startProgress() {
        runOnUiThread(new RunnableC0278b(this, 0));
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.about.AboutPresenter.Contract
    public void stateChanged(int newState) {
        runOnUiThread(new RunnableC0278b(this, 2));
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.about.AboutPresenter.Contract
    public void stopProgress() {
        runOnUiThread(new RunnableC0278b(this, 3));
    }
}
