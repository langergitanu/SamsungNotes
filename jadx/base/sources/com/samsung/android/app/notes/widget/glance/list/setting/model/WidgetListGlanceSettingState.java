package com.samsung.android.app.notes.widget.glance.list.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010(\u001a\u0004\u0018\u00010\u00012\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR$\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u0011\u00107\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b:\u0010\u0007R$\u0010;\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR$\u0010>\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001e¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/setting/model/WidgetListGlanceSettingState;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "<init>", "()V", "mMinWidth", "", "getMMinWidth", "()I", "setMMinWidth", "(I)V", "mMinHeight", "getMMinHeight", "setMMinHeight", "mRow", "getMRow", "setMRow", "mColumn", "getMColumn", "setMColumn", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "oldBackgroundShape", "getOldBackgroundShape", "setOldBackgroundShape", "mBackgroundOnOff", "", "getMBackgroundOnOff", "()Z", "setMBackgroundOnOff", "(Z)V", "mOldBackgroundOnOff", "getMOldBackgroundOnOff", "setMOldBackgroundOnOff", "providerName", "", "getProviderName", "()Ljava/lang/String;", "setProviderName", "(Ljava/lang/String;)V", "init", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "savedInstanceState", "Landroid/os/Bundle;", "value", "minWidth", "getMinWidth", "setMinWidth", "minHeight", "getMinHeight", "setMinHeight", "row", "getRow", "column", "getColumn", "backgroundOnOff", "getBackgroundOnOff", "setBackgroundOnOff", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceSettingState extends BaseWidgetSettingState {
    public static final int $stable = 8;
    private int backgroundShape;
    private int mColumn;
    private int mMinHeight;
    private int mMinWidth;
    private int mRow;
    private int oldBackgroundShape;
    private boolean mBackgroundOnOff = true;
    private boolean mOldBackgroundOnOff = true;

    @NotNull
    private String providerName = "WidgetListProvider";

    /* JADX INFO: renamed from: getBackgroundOnOff, reason: from getter */
    public final boolean getMBackgroundOnOff() {
        return this.mBackgroundOnOff;
    }

    public final int getBackgroundShape() {
        return this.backgroundShape;
    }

    /* JADX INFO: renamed from: getColumn, reason: from getter */
    public final int getMColumn() {
        return this.mColumn;
    }

    public final boolean getMBackgroundOnOff() {
        return this.mBackgroundOnOff;
    }

    public final int getMColumn() {
        return this.mColumn;
    }

    public final int getMMinHeight() {
        return this.mMinHeight;
    }

    public final int getMMinWidth() {
        return this.mMinWidth;
    }

    public final boolean getMOldBackgroundOnOff() {
        return this.mOldBackgroundOnOff;
    }

    public final int getMRow() {
        return this.mRow;
    }

    public final int getMinHeight() {
        return this.mMinHeight;
    }

    public final int getMinWidth() {
        return this.mMinWidth;
    }

    public final boolean getOldBackgroundOnOff() {
        return this.mOldBackgroundOnOff;
    }

    public final int getOldBackgroundShape() {
        return this.oldBackgroundShape;
    }

    @NotNull
    public final String getProviderName() {
        return this.providerName;
    }

    public final int getRow() {
        return this.mRow;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState
    @Nullable
    public BaseWidgetSettingState init(@Nullable Activity activity, @NotNull Intent intent, int appWidgetId, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (savedInstanceState != null) {
            setTransparency(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY));
            setBackgroundColor(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR));
            setOldTransparency(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY));
            setOldBackgroundColor(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR));
            setDarkMode(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_DARK_MODE));
            setOldDarkMode(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE));
            setOneUiWidgetSource(savedInstanceState.getString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE));
            this.mMinWidth = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH);
            this.mMinHeight = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT);
            setMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING));
            setOldMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING));
            this.mRow = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_ROW_SPAN);
            this.mColumn = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN);
            this.backgroundShape = savedInstanceState.getInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
            this.oldBackgroundShape = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE);
            this.mBackgroundOnOff = savedInstanceState.getBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF);
            this.mOldBackgroundOnOff = savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF);
            String string = savedInstanceState.getString(WidgetConstant.WIDGET_PROVIDER_NAME);
            if (string == null) {
                string = "WidgetListProvider";
            }
            this.providerName = string;
            initTheme(activity);
            return this;
        }
        if (intent.getAction() != null) {
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            setTransparency(companion.getTransparency(appWidgetId));
            setOldBackgroundColor(companion.getBackgroundColor(appWidgetId));
            setBackgroundColor(getOldBackgroundColor());
            setOldTransparency(getTransparency());
            setOldDarkMode(companion.getDarkMode(appWidgetId));
            setDarkMode(getOldDarkMode());
            setOneUiWidgetSource(companion.getOneUiWidgetSource(appWidgetId));
            this.mMinWidth = companion.getMinWidth(appWidgetId);
            this.mMinHeight = companion.getMinHeight(appWidgetId);
            setOldMatchSetting(companion.getWidgetMatchSetting(appWidgetId));
            setMatchSetting(getOldMatchSetting());
            this.mRow = companion.getRowSpan(appWidgetId);
            this.mColumn = companion.getColumnSpan(appWidgetId);
            int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
            this.oldBackgroundShape = widgetBackgroundShape;
            this.backgroundShape = widgetBackgroundShape;
            boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
            this.mOldBackgroundOnOff = widgetBackgroundOnOff;
            this.mBackgroundOnOff = widgetBackgroundOnOff;
            this.providerName = WidgetPreferenceManager.INSTANCE.getWidgetProviderName(appWidgetId);
            initTheme(activity);
        }
        return this;
    }

    public final void setBackgroundOnOff(boolean z) {
        this.mBackgroundOnOff = z;
    }

    public final void setBackgroundShape(int i) {
        this.backgroundShape = i;
    }

    public final void setMBackgroundOnOff(boolean z) {
        this.mBackgroundOnOff = z;
    }

    public final void setMColumn(int i) {
        this.mColumn = i;
    }

    public final void setMMinHeight(int i) {
        this.mMinHeight = i;
    }

    public final void setMMinWidth(int i) {
        this.mMinWidth = i;
    }

    public final void setMOldBackgroundOnOff(boolean z) {
        this.mOldBackgroundOnOff = z;
    }

    public final void setMRow(int i) {
        this.mRow = i;
    }

    public final void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    public final void setMinWidth(int i) {
        this.mMinWidth = i;
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.mOldBackgroundOnOff = z;
    }

    public final void setOldBackgroundShape(int i) {
        this.oldBackgroundShape = i;
    }

    public final void setProviderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.providerName = str;
    }
}
