package com.samsung.android.app.notes.widget.glance.single.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.setting.common.WidgetSettingConstant;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u00100\u001a\u0004\u0018\u00010\u00012\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u000107H\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b8\u0010\bR\u0014\u00109\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\b¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/setting/model/WidgetSingleGlanceSettingState;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "<init>", "()V", "value", "", "reverseColor", "getReverseColor", "()Z", "uUID", "", "getUUID", "()Ljava/lang/String;", "setUUID", "(Ljava/lang/String;)V", "oldUUID", "getOldUUID", "minWidth", "", "getMinWidth", "()I", "setMinWidth", "(I)V", "minHeight", "getMinHeight", "setMinHeight", "row", "getRow", "setRow", "column", "getColumn", "setColumn", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "oldBackgroundShape", "getOldBackgroundShape", "setOldBackgroundShape", "backgroundOnOff", "getBackgroundOnOff", "setBackgroundOnOff", "(Z)V", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "providerName", "getProviderName", "setProviderName", "init", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "savedInstanceState", "Landroid/os/Bundle;", "isOnlyUUIDChanged", "isChanged", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleGlanceSettingState extends BaseWidgetSettingState {

    @NotNull
    private static final String TAG = "WidgetSettingState";
    private int backgroundShape;
    private int column;
    private int minHeight;
    private int minWidth;
    private int oldBackgroundShape;

    @Nullable
    private String oldUUID;
    private boolean reverseColor;
    private int row;

    @Nullable
    private String uUID;
    public static final int $stable = 8;
    private boolean backgroundOnOff = true;
    private boolean oldBackgroundOnOff = true;

    @NotNull
    private String providerName = BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME;

    public final boolean getBackgroundOnOff() {
        return this.backgroundOnOff;
    }

    public final int getBackgroundShape() {
        return this.backgroundShape;
    }

    public final int getColumn() {
        return this.column;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final boolean getOldBackgroundOnOff() {
        return this.oldBackgroundOnOff;
    }

    public final int getOldBackgroundShape() {
        return this.oldBackgroundShape;
    }

    @Nullable
    public final String getOldUUID() {
        return this.oldUUID;
    }

    @NotNull
    public final String getProviderName() {
        return this.providerName;
    }

    public final boolean getReverseColor() {
        return this.reverseColor;
    }

    public final int getRow() {
        return this.row;
    }

    @Nullable
    public final String getUUID() {
        return this.uUID;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState
    @Nullable
    public BaseWidgetSettingState init(@Nullable Activity activity, @NotNull Intent intent, int appWidgetId, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (savedInstanceState != null) {
            setTransparency(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY));
            setBackgroundColor(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR));
            this.uUID = savedInstanceState.getString("UUID");
            setOldTransparency(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY));
            this.oldUUID = savedInstanceState.getString(BaseWidgetSettingConstant.KEY_OLD_UUID);
            setOldBackgroundColor(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR));
            setDarkMode(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_DARK_MODE));
            setOldDarkMode(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE));
            this.reverseColor = savedInstanceState.getBoolean(WidgetSettingConstant.KEY_REVERSE_COLOR);
            setOneUiWidgetSource(savedInstanceState.getString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE));
            this.minWidth = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH);
            this.minHeight = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT);
            setMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING));
            setOldMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING));
            this.row = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN);
            this.column = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN);
            this.backgroundShape = savedInstanceState.getInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
            this.oldBackgroundShape = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE);
            this.backgroundOnOff = savedInstanceState.getBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF);
            this.oldBackgroundOnOff = savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF);
            String string = savedInstanceState.getString(WidgetConstant.WIDGET_PROVIDER_NAME);
            if (string == null) {
                string = BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME;
            }
            this.providerName = string;
        } else if (intent.getAction() != null) {
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            this.uUID = companion.getUUID(appWidgetId);
            setTransparency(companion.getTransparency(appWidgetId));
            setOldBackgroundColor(companion.getBackgroundColor(appWidgetId));
            setBackgroundColor(getOldBackgroundColor());
            this.oldUUID = this.uUID;
            setOldTransparency(getTransparency());
            this.reverseColor = companion.isReverseTransparency(appWidgetId);
            setOldDarkMode(companion.getDarkMode(appWidgetId));
            setDarkMode(getOldDarkMode());
            setOneUiWidgetSource(companion.getOneUiWidgetSource(appWidgetId));
            setOldMatchSetting(companion.getWidgetMatchSetting(appWidgetId));
            this.minWidth = companion.getMinWidth(appWidgetId);
            this.minHeight = companion.getMinHeight(appWidgetId);
            setMatchSetting(getOldMatchSetting());
            this.row = companion.getRowSpan(appWidgetId);
            this.column = companion.getColumnSpan(appWidgetId);
            int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
            this.oldBackgroundShape = widgetBackgroundShape;
            this.backgroundShape = widgetBackgroundShape;
            boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
            this.oldBackgroundOnOff = widgetBackgroundOnOff;
            this.backgroundOnOff = widgetBackgroundOnOff;
            this.providerName = WidgetPreferenceManager.INSTANCE.getWidgetProviderName(appWidgetId);
        }
        if (TextUtils.isEmpty(this.uUID)) {
            this.uUID = BaseWidgetConstant.NONE;
        }
        if (TextUtils.isEmpty(this.oldUUID)) {
            this.oldUUID = BaseWidgetConstant.NONE;
        }
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState
    public boolean isChanged() {
        return (!super.isChanged() && StringsKt.contentEquals((CharSequence) this.uUID, (CharSequence) this.oldUUID) && this.backgroundShape == this.oldBackgroundShape && this.backgroundOnOff == this.oldBackgroundOnOff) ? false : true;
    }

    public final boolean isOnlyUUIDChanged() {
        return !StringsKt.contentEquals((CharSequence) this.uUID, (CharSequence) this.oldUUID) && getOldTransparency() == getTransparency() && getBackgroundColor() == getOldBackgroundColor() && getDarkMode() == getOldDarkMode() && this.backgroundShape == this.oldBackgroundShape && this.backgroundOnOff == this.oldBackgroundOnOff;
    }

    public final void setBackgroundOnOff(boolean z) {
        this.backgroundOnOff = z;
    }

    public final void setBackgroundShape(int i) {
        this.backgroundShape = i;
    }

    public final void setColumn(int i) {
        this.column = i;
    }

    public final void setMinHeight(int i) {
        this.minHeight = i;
    }

    public final void setMinWidth(int i) {
        this.minWidth = i;
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.oldBackgroundOnOff = z;
    }

    public final void setOldBackgroundShape(int i) {
        this.oldBackgroundShape = i;
    }

    public final void setProviderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.providerName = str;
    }

    public final void setRow(int i) {
        this.row = i;
    }

    public final void setUUID(@Nullable String str) {
        this.uUID = str;
    }
}
