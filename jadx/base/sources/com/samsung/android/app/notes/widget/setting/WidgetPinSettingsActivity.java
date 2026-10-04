package com.samsung.android.app.notes.widget.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.single.setting.model.WidgetSingleGlanceSettingModel;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.WidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0015J\b\u0010\n\u001a\u00020\u0007H\u0014J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/WidgetPinSettingsActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity;", "<init>", "()V", "isWidgetSingleGlanceEmpty", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "createPresenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "registerReceiver", "widgetSettingReceiver", "Landroid/content/BroadcastReceiver;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class WidgetPinSettingsActivity extends BaseWidgetSettingActivity {

    @NotNull
    private static final String TAG = "WidgetPinSettingsActivity";
    private boolean isWidgetSingleGlanceEmpty;

    @NotNull
    private final BroadcastReceiver widgetSettingReceiver = new BroadcastReceiver() { // from class: com.samsung.android.app.notes.widget.setting.WidgetPinSettingsActivity$widgetSettingReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            WidgetLogger.m5154d("WidgetPinSettingsActivity", "onReceive action " + intent.getAction());
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            if (this.this$0.getMPresenter() instanceof WidgetSettingPresenter) {
                BaseWidgetSettingPresenter mPresenter = this.this$0.getMPresenter();
                Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                if (!Intrinsics.areEqual(((WidgetSettingPresenter) mPresenter).getUuid(), stringExtra)) {
                    WidgetLogger.INSTANCE.m5157e("WidgetPinSettingsActivity", "onReceive# difference uuid ");
                    return;
                }
                if (Intrinsics.areEqual(WidgetConstant.ACTION_WIDGET_SETTING_CREATE_CACHE, action)) {
                    BaseWidgetSettingPresenter mPresenter2 = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter2, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                    ((WidgetSettingPresenter) mPresenter2).showLoadingView();
                    BaseWidgetSettingPresenter mPresenter3 = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter3, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                    ((WidgetSettingPresenter) mPresenter3).updateNoteTitle();
                    BaseWidgetSettingPresenter mPresenter4 = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter4, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                    ((WidgetSettingPresenter) mPresenter4).updatePreviewTitle();
                    return;
                }
                if (Intrinsics.areEqual(WidgetConstant.ACTION_WIDGET_SETTING_DONE_CACHE, action)) {
                    BaseWidgetSettingPresenter mPresenter5 = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter5, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                    ((WidgetSettingPresenter) mPresenter5).updatePreviewAndSetting();
                } else if (Intrinsics.areEqual(WidgetConstant.ACTION_WIDGET_SETTING_CANCEL_CACHE, action)) {
                    BaseWidgetSettingPresenter mPresenter6 = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter6, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                    ((WidgetSettingPresenter) mPresenter6).hideLoadingView();
                }
            }
        }
    };
    public static final int $stable = 8;

    private final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WidgetConstant.ACTION_WIDGET_SETTING_CREATE_CACHE);
        intentFilter.addAction(WidgetConstant.ACTION_WIDGET_SETTING_DONE_CACHE);
        intentFilter.addAction(WidgetConstant.ACTION_WIDGET_SETTING_CANCEL_CACHE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.widgetSettingReceiver, intentFilter);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity
    @NotNull
    public BaseWidgetSettingPresenter createPresenter(@Nullable Bundle savedInstanceState) {
        return BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? new WidgetSingleGlanceSettingPresenter(savedInstanceState, this) : new WidgetSettingPresenter(savedInstanceState, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        BaseWidgetSettingPresenter mPresenter;
        super.onActivityResult(requestCode, resultCode, data);
        BaseWidgetSettingPresenter mPresenter2 = getMPresenter();
        if (mPresenter2 != null) {
            mPresenter2.onActivityResult(requestCode, resultCode, data);
        }
        if (this.isWidgetSingleGlanceEmpty && (getMPresenter() instanceof WidgetSingleGlanceSettingPresenter) && (mPresenter = getMPresenter()) != null) {
            mPresenter.saveAndFinish();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresPermission(anyOf = {"android.permission.READ_WALLPAPER_INTERNAL", "android.permission.MANAGE_EXTERNAL_STORAGE"})
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter;
        WidgetSingleGlanceSettingModel mModel;
        super.onCreate(savedInstanceState);
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            String uuid = null;
            if (getMPresenter() instanceof WidgetSingleGlanceSettingPresenter) {
                BaseWidgetSettingPresenter mPresenter = getMPresenter();
                Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter");
                widgetSingleGlanceSettingPresenter = (WidgetSingleGlanceSettingPresenter) mPresenter;
            } else {
                widgetSingleGlanceSettingPresenter = null;
            }
            if (widgetSingleGlanceSettingPresenter != null && (mModel = widgetSingleGlanceSettingPresenter.getMModel()) != null) {
                uuid = mModel.getUUID();
            }
            boolean z = uuid == null || uuid.length() == 0 || Intrinsics.areEqual(widgetSingleGlanceSettingPresenter.getMModel().getUUID(), BaseWidgetConstant.NONE);
            this.isWidgetSingleGlanceEmpty = z;
            if (!z) {
                WidgetSingleGlanceSettingView widgetSingleGlanceSettingView = new WidgetSingleGlanceSettingView(findViewById(C11391R.id.widget_setting_layout));
                BaseWidgetSettingPresenter mPresenter2 = getMPresenter();
                if (mPresenter2 != null) {
                    mPresenter2.setView(widgetSingleGlanceSettingView);
                }
                widgetSingleGlanceSettingView.init();
                if (widgetSingleGlanceSettingPresenter != null) {
                    widgetSingleGlanceSettingPresenter.createCacheInfo();
                }
            } else if (widgetSingleGlanceSettingPresenter != null) {
                widgetSingleGlanceSettingPresenter.onChangeClicked();
            }
        } else {
            WidgetSettingView widgetSettingView = new WidgetSettingView(findViewById(C11391R.id.widget_setting_layout));
            BaseWidgetSettingPresenter mPresenter3 = getMPresenter();
            if (mPresenter3 != null) {
                mPresenter3.setView(widgetSettingView);
            }
            widgetSettingView.init();
            if (getMPresenter() instanceof WidgetSettingPresenter) {
                BaseWidgetSettingPresenter mPresenter4 = getMPresenter();
                Intrinsics.checkNotNull(mPresenter4, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
                ((WidgetSettingPresenter) mPresenter4).createCacheInfo();
            }
        }
        registerReceiver();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.widgetSettingReceiver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getMPresenter() instanceof WidgetSettingPresenter) {
            BaseWidgetSettingPresenter mPresenter = getMPresenter();
            Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter");
            ((WidgetSettingPresenter) mPresenter).updateEmptyPreview();
        }
    }
}
