package com.samsung.android.app.notes.widget.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.setting.common.WidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u001d\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/model/WidgetSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mWidgetSettingState", "Lcom/samsung/android/app/notes/widget/setting/model/WidgetSettingState;", "widgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "uuid", "", "uUID", "getUUID", "()Ljava/lang/String;", "setUUID", "(Ljava/lang/String;)V", "isOnlyUUIDChanged", "", "()Z", "oldUUID", "getOldUUID", "isChanged", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSettingModel extends BaseWidgetSettingModel {

    @NotNull
    private static final String TAG = "WidgetSettingModel";

    @NotNull
    private final WidgetSettingState mWidgetSettingState;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingModel(@Nullable Bundle bundle, @NotNull Activity activity) {
        super(activity.getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1));
        Intrinsics.checkNotNullParameter(activity, "activity");
        WidgetSettingState widgetSettingState = new WidgetSettingState();
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        BaseWidgetSettingState baseWidgetSettingStateInit = widgetSettingState.init(activity, intent, getWidgetId(), bundle);
        Intrinsics.checkNotNull(baseWidgetSettingStateInit, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.model.WidgetSettingState");
        this.mWidgetSettingState = (WidgetSettingState) baseWidgetSettingStateInit;
    }

    @Nullable
    public final String getOldUUID() {
        return this.mWidgetSettingState.getOldUUID();
    }

    @Nullable
    public final String getUUID() {
        return this.mWidgetSettingState.getUUID();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    @NotNull
    public BaseWidgetSettingState getWidgetSettingState() {
        return this.mWidgetSettingState;
    }

    public final boolean isChanged() {
        return this.mWidgetSettingState.isChanged();
    }

    public final boolean isOnlyUUIDChanged() {
        return this.mWidgetSettingState.isOnlyUUIDChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public void onSaveInstanceState(@Nullable Bundle outState) {
        Logger.m8697d(TAG, "onSaveInstanceState# ");
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY, getTransparency());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY, getOldTransparency());
        }
        if (outState != null) {
            outState.putString("UUID", getUUID());
        }
        if (outState != null) {
            outState.putString(BaseWidgetSettingConstant.KEY_OLD_UUID, getOldUUID());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR, getBackgroundColor());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR, getOldBackgroundColor());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_DARK_MODE, getDarkMode());
        }
        if (outState != null) {
            outState.putInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE, getOldDarkMode());
        }
        if (outState != null) {
            outState.putBoolean(WidgetSettingConstant.KEY_REVERSE_COLOR, this.mWidgetSettingState.getReverseColor());
        }
        if (outState != null) {
            outState.putString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE, this.mWidgetSettingState.getOneUiWidgetSource());
        }
    }

    public final void setUUID(@Nullable String str) {
        this.mWidgetSettingState.setUUID(str);
    }
}
