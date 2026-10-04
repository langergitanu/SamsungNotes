package com.samsung.android.app.notes.widget.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.glance.setting.presenter.WidgetCreatorSettingPresenter;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetToolbarSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.WidgetToolbarSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/WidgetToolbarSettingActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createPresenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetToolbarSettingActivity extends BaseWidgetSettingActivity {
    public static final int $stable = 8;

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity
    @NotNull
    public BaseWidgetSettingPresenter createPresenter(@Nullable Bundle savedInstanceState) {
        return BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? new WidgetCreatorSettingPresenter(savedInstanceState, this) : new WidgetToolbarSettingPresenter(savedInstanceState, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onActivityResult(requestCode, resultCode, data);
            BaseWidgetSettingPresenter mPresenter = getMPresenter();
            if (mPresenter != null) {
                mPresenter.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        super.onCreate(savedInstanceState);
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            WidgetCreatorSettingView widgetCreatorSettingView = new WidgetCreatorSettingView(findViewById(C6635R.id.widget_setting_layout));
            BaseWidgetSettingPresenter mPresenter = getMPresenter();
            if (mPresenter != null) {
                mPresenter.setView(widgetCreatorSettingView);
            }
            widgetCreatorSettingView.init();
            return;
        }
        WidgetToolbarSettingView widgetToolbarSettingView = new WidgetToolbarSettingView(findViewById(C6635R.id.widget_setting_layout));
        BaseWidgetSettingPresenter mPresenter2 = getMPresenter();
        if (mPresenter2 != null) {
            mPresenter2.setView(widgetToolbarSettingView);
        }
        widgetToolbarSettingView.init();
    }
}
