package com.samsung.android.app.notes.glance.setting.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetToolbarBroadCast;
import com.samsung.android.app.notes.widget.glance.setting.model.WidgetCreatorSettingModel;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingContract;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0017J\"\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/notes/glance/setting/presenter/WidgetCreatorSettingPresenter;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mModel", "Lcom/samsung/android/app/notes/widget/glance/setting/model/WidgetCreatorSettingModel;", "mContract", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingContract;", "model", "getModel", "()Lcom/samsung/android/app/notes/widget/glance/setting/model/WidgetCreatorSettingModel;", "value", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "view", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "saveAndFinish", "", "onChangeShortcutClicked", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setWidgetResult", "result", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorSettingPresenter extends BaseWidgetSettingPresenter {
    private static final int REQUEST_CODE_PICK_CONTROL = 1;

    @NotNull
    private static final String TAG = "WidgetCreatorSettingPresenter";

    @Nullable
    private WidgetCreatorSettingContract mContract;

    @NotNull
    private final WidgetCreatorSettingModel mModel;
    public static final int $stable = 8;

    public WidgetCreatorSettingPresenter(@Nullable Bundle bundle, @Nullable Activity activity) {
        super(activity);
        Intrinsics.checkNotNull(activity);
        this.mModel = new WidgetCreatorSettingModel(bundle, activity);
        checkValidWidget();
    }

    private final void setWidgetResult(int result) {
        Intent intent = new Intent();
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mModel.getWidgetId());
        Activity mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.setResult(result, intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    public BaseWidgetSettingContract getView() {
        WidgetCreatorSettingContract widgetCreatorSettingContract = this.mContract;
        Intrinsics.checkNotNull(widgetCreatorSettingContract);
        return widgetCreatorSettingContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List listEmptyList;
        WidgetCreatorSettingContract widgetCreatorSettingContract;
        ArrayList<Integer> integerArrayListExtra;
        if (requestCode == 1 && resultCode == -1) {
            if (data == null || (integerArrayListExtra = data.getIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS)) == null || (listEmptyList = CollectionsKt.toList(integerArrayListExtra)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            WidgetCreatorSettingModel widgetCreatorSettingModel = this.mModel;
            Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Int>");
            widgetCreatorSettingModel.updateSelectedItems(TypeIntrinsics.asMutableList(listEmptyList));
            if (this.mModel.isWidgetContentChanged() && (widgetCreatorSettingContract = this.mContract) != null) {
                widgetCreatorSettingContract.updateItemPreview();
            }
            setWidgetResult(resultCode);
        }
    }

    public final void onChangeShortcutClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6134");
        Intent intent = new Intent(getMActivity(), (Class<?>) WidgetCreatorRecycleViewActivity.class);
        intent.putIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS, (ArrayList) this.mModel.getSelectedItems());
        Activity mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.startActivityForResult(intent, 1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void saveAndFinish() {
        if (this.mModel.isWidgetContentChanged()) {
            WidgetToolbarBroadCast widgetToolbarBroadCast = WidgetToolbarBroadCast.INSTANCE;
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            widgetToolbarBroadCast.sendUpdateWidgetCreatorBroadcast(mActivity, this.mModel.getWidgetId(), this.mModel.getTransparency(), this.mModel.getBackgroundColor(), this.mModel.getDarkMode(), this.mModel.getSelectedItems(), this.mModel.getMatchSetting(), this.mModel.getBackgroundShape(), this.mModel.getBackgroundOnOff());
        }
        Activity mActivity2 = getMActivity();
        if (mActivity2 != null) {
            mActivity2.finishAndRemoveTask();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void setView(@NotNull BaseWidgetSettingContract value) {
        Intrinsics.checkNotNullParameter(value, "value");
        WidgetCreatorSettingContract widgetCreatorSettingContract = (WidgetCreatorSettingContract) value;
        this.mContract = widgetCreatorSettingContract;
        if (widgetCreatorSettingContract != null) {
            widgetCreatorSettingContract.setPresenter(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    /* JADX INFO: renamed from: getModel, reason: from getter */
    public WidgetCreatorSettingModel getMModel() {
        return this.mModel;
    }
}
