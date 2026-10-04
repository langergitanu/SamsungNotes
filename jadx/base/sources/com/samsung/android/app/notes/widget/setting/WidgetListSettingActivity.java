package com.samsung.android.app.notes.widget.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.list.setting.model.WidgetListGlanceSettingModel;
import com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetListSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/WidgetListSettingActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/BaseWidgetSettingActivity;", "<init>", "()V", "isWidgetListGlanceEmpty", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "registerReceiver", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "createPresenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "widgetSettingReceiver", "Landroid/content/BroadcastReceiver;", "onDestroy", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListSettingActivity extends BaseWidgetSettingActivity {

    @NotNull
    private static final String TAG = "WidgetListSettingActivity";
    private boolean isWidgetListGlanceEmpty;

    @NotNull
    private final BroadcastReceiver widgetSettingReceiver = new BroadcastReceiver() { // from class: com.samsung.android.app.notes.widget.setting.WidgetListSettingActivity$widgetSettingReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST);
            WidgetLogger.m5154d("WidgetListSettingActivity", "onReceive action " + intent.getAction());
            if (this.this$0.getMPresenter() instanceof WidgetListSettingPresenter) {
                if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_UPDATE, action) && stringExtra != null) {
                    BaseWidgetSettingPresenter mPresenter = this.this$0.getMPresenter();
                    Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetListSettingPresenter");
                    if (((WidgetListSettingPresenter) mPresenter).getMModel().getNoteList().contains(stringExtra)) {
                        BaseWidgetSettingPresenter mPresenter2 = this.this$0.getMPresenter();
                        BaseWidgetSettingContract view = mPresenter2 != null ? mPresenter2.getView() : null;
                        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView");
                        ((WidgetListSettingView) view).updateNoteListPreview();
                        return;
                    }
                }
                if (!Intrinsics.areEqual(BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_DELETE, action) || stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    return;
                }
                BaseWidgetSettingPresenter mPresenter3 = this.this$0.getMPresenter();
                Intrinsics.checkNotNull(mPresenter3, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetListSettingPresenter");
                ((WidgetListSettingPresenter) mPresenter3).deleteUUIDNoteList(stringArrayListExtra);
            }
        }
    };
    public static final int $stable = 8;

    private final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_UPDATE);
        intentFilter.addAction(BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_DELETE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.widgetSettingReceiver, intentFilter);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity
    @NotNull
    public BaseWidgetSettingPresenter createPresenter(@Nullable Bundle savedInstanceState) {
        return BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? new WidgetListGlanceSettingPresenter(savedInstanceState, this) : new WidgetListSettingPresenter(savedInstanceState, this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        BaseWidgetSettingPresenter mPresenter;
        super.onActivityResult(requestCode, resultCode, data);
        BaseWidgetSettingPresenter mPresenter2 = getMPresenter();
        if (mPresenter2 != null) {
            mPresenter2.onActivityResult(requestCode, resultCode, data);
        }
        if (!this.isWidgetListGlanceEmpty || (mPresenter = getMPresenter()) == null) {
            return;
        }
        mPresenter.saveAndFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws Exception {
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter;
        WidgetListGlanceSettingModel mModel;
        super.onCreate(savedInstanceState);
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            List<String> originalNoteList = null;
            if (getMPresenter() instanceof WidgetListGlanceSettingPresenter) {
                BaseWidgetSettingPresenter mPresenter = getMPresenter();
                Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingPresenter");
                widgetListGlanceSettingPresenter = (WidgetListGlanceSettingPresenter) mPresenter;
            } else {
                widgetListGlanceSettingPresenter = null;
            }
            if (widgetListGlanceSettingPresenter != null && (mModel = widgetListGlanceSettingPresenter.getMModel()) != null) {
                originalNoteList = mModel.getOriginalNoteList();
            }
            List<String> list = originalNoteList;
            boolean z = list == null || list.isEmpty();
            this.isWidgetListGlanceEmpty = z;
            if (!z) {
                WidgetListGlanceSettingView widgetListGlanceSettingView = new WidgetListGlanceSettingView(findViewById(C11391R.id.widget_setting_layout));
                BaseWidgetSettingPresenter mPresenter2 = getMPresenter();
                if (mPresenter2 != null) {
                    mPresenter2.setView(widgetListGlanceSettingView);
                }
                widgetListGlanceSettingView.init();
            } else if (widgetListGlanceSettingPresenter != null) {
                widgetListGlanceSettingPresenter.onNotePickerClickedGlance();
            }
        } else {
            WidgetListSettingView widgetListSettingView = new WidgetListSettingView(findViewById(C11391R.id.widget_setting_layout));
            BaseWidgetSettingPresenter mPresenter3 = getMPresenter();
            if (mPresenter3 != null) {
                mPresenter3.setView(widgetListSettingView);
            }
            widgetListSettingView.init();
        }
        registerReceiver();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.widgetSettingReceiver);
    }
}
