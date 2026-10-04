package com.samsung.android.app.notes.widget.glance.list.setting.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.list.setting.model.WidgetListGlanceSettingModel;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingPresenter;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mModel", "Lcom/samsung/android/app/notes/widget/glance/list/setting/model/WidgetListGlanceSettingModel;", "mContract", "Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingContract;", "model", "getModel", "()Lcom/samsung/android/app/notes/widget/glance/list/setting/model/WidgetListGlanceSettingModel;", "value", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "view", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "saveAndFinish", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onNotePickerClickedGlance", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceSettingPresenter extends BaseWidgetSettingPresenter {

    @NotNull
    private static final String TAG = "WidgetListGlanceSettingPresenter";

    @Nullable
    private WidgetListGlanceSettingContract mContract;

    @NotNull
    private final WidgetListGlanceSettingModel mModel;
    public static final int $stable = 8;

    public WidgetListGlanceSettingPresenter(@Nullable Bundle bundle, @Nullable Activity activity) {
        super(activity);
        Intrinsics.checkNotNull(activity);
        this.mModel = new WidgetListGlanceSettingModel(bundle, activity);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    public BaseWidgetSettingContract getView() {
        WidgetListGlanceSettingContract widgetListGlanceSettingContract = this.mContract;
        Intrinsics.checkNotNull(widgetListGlanceSettingContract);
        return widgetListGlanceSettingContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        WidgetListGlanceSettingContract widgetListGlanceSettingContract;
        if (requestCode != 2 || resultCode != -1) {
            WidgetLogger.m5156w(TAG, "onActivityResult# invalid");
            return;
        }
        ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST) : null;
        WidgetListGlanceSettingModel widgetListGlanceSettingModel = this.mModel;
        Intrinsics.checkNotNull(stringArrayListExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
        widgetListGlanceSettingModel.updateNoteListGlance(TypeIntrinsics.asMutableList(stringArrayListExtra));
        WidgetLogger.m5155i(TAG, "onActivityResult# " + stringArrayListExtra);
        if (this.mModel.isWidgetContentChanged() && (widgetListGlanceSettingContract = this.mContract) != null) {
            widgetListGlanceSettingContract.updateNoteListPreview();
        }
        this.mModel.updateLatestDisplayListGlance();
    }

    public final void onNotePickerClickedGlance() {
        NotesSamsungAnalytics.INSTANCE.insertLog("615", "6126");
        WidgetLogger.m5155i(TAG, "onNotePickerClickedGlance# " + this.mModel.getWidgetId());
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(getMActivity(), NoteListAccessHandler.getNotePickerClass());
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mModel.getWidgetId());
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        List<String> noteList = this.mModel.getNoteList();
        Intrinsics.checkNotNull(noteList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String?>");
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, (ArrayList) noteList);
        Activity mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.startActivityForResult(intent, 2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void saveAndFinish() {
        if (this.mModel.isWidgetContentChanged()) {
            WidgetLogger.m5154d(TAG, "saveAndFinish# widget content changed");
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            WidgetBroadcast.sendPickNoteListBroadcast(mActivity, this.mModel.getWidgetId(), this.mModel.getTransparency(), this.mModel.getBackgroundColor(), this.mModel.getDarkMode(), this.mModel.getNoteList(), this.mModel.getMatchSetting(), this.mModel.getBackgroundShape(), this.mModel.getBackgroundOnOff(), 2);
        }
        Activity mActivity2 = getMActivity();
        if (mActivity2 != null) {
            mActivity2.finishAndRemoveTask();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void setView(@NotNull BaseWidgetSettingContract value) {
        Intrinsics.checkNotNullParameter(value, "value");
        WidgetListGlanceSettingContract widgetListGlanceSettingContract = (WidgetListGlanceSettingContract) value;
        this.mContract = widgetListGlanceSettingContract;
        if (widgetListGlanceSettingContract != null) {
            widgetListGlanceSettingContract.setPresenter(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    /* JADX INFO: renamed from: getModel, reason: from getter */
    public WidgetListGlanceSettingModel getMModel() {
        return this.mModel;
    }
}
