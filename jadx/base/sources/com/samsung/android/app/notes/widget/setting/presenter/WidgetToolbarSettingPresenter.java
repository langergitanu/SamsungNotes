package com.samsung.android.app.notes.widget.setting.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.WidgetToolbarBroadCast;
import com.samsung.android.app.notes.widget.setting.model.WidgetToolbarSettingModel;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/presenter/WidgetToolbarSettingPresenter;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mModel", "Lcom/samsung/android/app/notes/widget/setting/model/WidgetToolbarSettingModel;", "mContract", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "model", "getModel", "()Lcom/samsung/android/app/notes/widget/setting/model/WidgetToolbarSettingModel;", "value", "view", "getView", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "setView", "(Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;)V", "saveAndFinish", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetToolbarSettingPresenter extends BaseWidgetSettingPresenter {
    public static final int $stable = 8;

    @Nullable
    private BaseWidgetSettingContract mContract;

    @NotNull
    private final WidgetToolbarSettingModel mModel;

    public WidgetToolbarSettingPresenter(@Nullable Bundle bundle, @Nullable Activity activity) {
        super(activity);
        Intrinsics.checkNotNull(activity);
        this.mModel = new WidgetToolbarSettingModel(bundle, activity);
        checkValidWidget();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    public BaseWidgetSettingContract getView() {
        BaseWidgetSettingContract baseWidgetSettingContract = this.mContract;
        Intrinsics.checkNotNull(baseWidgetSettingContract);
        return baseWidgetSettingContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void saveAndFinish() {
        if (this.mModel.isWidgetContentChanged()) {
            WidgetToolbarBroadCast widgetToolbarBroadCast = WidgetToolbarBroadCast.INSTANCE;
            Activity mActivity = getMActivity();
            Intrinsics.checkNotNull(mActivity);
            widgetToolbarBroadCast.sendUpdateWidgetToolbarBroadcast(mActivity, this.mModel.getWidgetId(), this.mModel.getTransparency(), this.mModel.getBackgroundColor(), this.mModel.getDarkMode());
        }
        Activity mActivity2 = getMActivity();
        if (mActivity2 != null) {
            mActivity2.finishAndRemoveTask();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    public void setView(@NotNull BaseWidgetSettingContract value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mContract = value;
        if (value != null) {
            value.setPresenter(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter
    @NotNull
    /* JADX INFO: renamed from: getModel, reason: from getter */
    public WidgetToolbarSettingModel getMModel() {
        return this.mModel;
    }
}
