package com.samsung.android.app.notes.widget.glance.single.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
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
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u001d\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b'\u0010!R$\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b.\u0010!R$\u0010/\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u00102R$\u00103\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u00102R\u0011\u00106\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b7\u0010\u0015¨\u00069"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/setting/model/WidgetSingleGlanceSettingModel;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "bundle", "Landroid/os/Bundle;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/os/Bundle;Landroid/app/Activity;)V", "mWidgetSingleGlanceSettingState", "Lcom/samsung/android/app/notes/widget/glance/single/setting/model/WidgetSingleGlanceSettingState;", "widgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outStateGlance", "uuid", "", "uUID", "getUUID", "()Ljava/lang/String;", "setUUID", "(Ljava/lang/String;)V", "isOnlyUUIDChanged", "", "()Z", "oldUUID", "getOldUUID", "isChanged", "minWidth", "", "getMinWidth", "()I", "minHeight", "getMinHeight", "row", "getRow", "column", "getColumn", "value", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "(I)V", "oldBackgroundShape", "getOldBackgroundShape", "backgroundOnOff", "getBackgroundOnOff", "setBackgroundOnOff", "(Z)V", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "providerName", "getProviderName", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleGlanceSettingModel extends BaseWidgetSettingModel {

    @NotNull
    private static final String TAG = "WidgetSingleGlanceSettingModel";

    @NotNull
    private final WidgetSingleGlanceSettingState mWidgetSingleGlanceSettingState;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSingleGlanceSettingModel(@Nullable Bundle bundle, @NotNull Activity activity) {
        super(activity.getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1));
        Intrinsics.checkNotNullParameter(activity, "activity");
        WidgetSingleGlanceSettingState widgetSingleGlanceSettingState = new WidgetSingleGlanceSettingState();
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        BaseWidgetSettingState baseWidgetSettingStateInit = widgetSingleGlanceSettingState.init(activity, intent, getWidgetId(), bundle);
        Intrinsics.checkNotNull(baseWidgetSettingStateInit, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.single.setting.model.WidgetSingleGlanceSettingState");
        this.mWidgetSingleGlanceSettingState = (WidgetSingleGlanceSettingState) baseWidgetSettingStateInit;
    }

    public final boolean getBackgroundOnOff() {
        return this.mWidgetSingleGlanceSettingState.getBackgroundOnOff();
    }

    public final int getBackgroundShape() {
        return this.mWidgetSingleGlanceSettingState.getBackgroundShape();
    }

    public final int getColumn() {
        return this.mWidgetSingleGlanceSettingState.getColumn();
    }

    public final int getMinHeight() {
        return this.mWidgetSingleGlanceSettingState.getMinHeight();
    }

    public final int getMinWidth() {
        return this.mWidgetSingleGlanceSettingState.getMinWidth();
    }

    public final boolean getOldBackgroundOnOff() {
        return this.mWidgetSingleGlanceSettingState.getOldBackgroundOnOff();
    }

    public final int getOldBackgroundShape() {
        return this.mWidgetSingleGlanceSettingState.getOldBackgroundShape();
    }

    @Nullable
    public final String getOldUUID() {
        return this.mWidgetSingleGlanceSettingState.getOldUUID();
    }

    @NotNull
    public final String getProviderName() {
        return this.mWidgetSingleGlanceSettingState.getProviderName();
    }

    public final int getRow() {
        return this.mWidgetSingleGlanceSettingState.getRow();
    }

    @Nullable
    public final String getUUID() {
        return this.mWidgetSingleGlanceSettingState.getUUID();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    @NotNull
    public BaseWidgetSettingState getWidgetSettingState() {
        return this.mWidgetSingleGlanceSettingState;
    }

    public final boolean isChanged() {
        return this.mWidgetSingleGlanceSettingState.isChanged();
    }

    public final boolean isOnlyUUIDChanged() {
        return this.mWidgetSingleGlanceSettingState.isOnlyUUIDChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingModel
    public void onSaveInstanceState(@Nullable Bundle outStateGlance) {
        Logger.m8697d(TAG, "onSaveInstanceState# ");
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY, getTransparency());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY, getOldTransparency());
        }
        if (outStateGlance != null) {
            outStateGlance.putString("UUID", getUUID());
        }
        if (outStateGlance != null) {
            outStateGlance.putString(BaseWidgetSettingConstant.KEY_OLD_UUID, getOldUUID());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR, getBackgroundColor());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR, getOldBackgroundColor());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_DARK_MODE, getDarkMode());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE, getOldDarkMode());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(WidgetSettingConstant.KEY_REVERSE_COLOR, this.mWidgetSingleGlanceSettingState.getReverseColor());
        }
        if (outStateGlance != null) {
            outStateGlance.putString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE, this.mWidgetSingleGlanceSettingState.getOneUiWidgetSource());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH, getMinWidth());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT, getMinHeight());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING, getMatchSetting());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING, getOldMatchSetting());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN, getRow());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN, getColumn());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, getBackgroundShape());
        }
        if (outStateGlance != null) {
            outStateGlance.putInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE, getOldBackgroundShape());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, getBackgroundOnOff());
        }
        if (outStateGlance != null) {
            outStateGlance.putBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF, getOldBackgroundOnOff());
        }
        if (outStateGlance != null) {
            outStateGlance.putString(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
        }
    }

    public final void setBackgroundOnOff(boolean z) {
        this.mWidgetSingleGlanceSettingState.setBackgroundOnOff(z);
    }

    public final void setBackgroundShape(int i) {
        this.mWidgetSingleGlanceSettingState.setBackgroundShape(i);
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.mWidgetSingleGlanceSettingState.setOldBackgroundOnOff(z);
    }

    public final void setUUID(@Nullable String str) {
        this.mWidgetSingleGlanceSettingState.setUUID(str);
    }
}
