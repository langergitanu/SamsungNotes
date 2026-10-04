package com.samsung.android.support.senl.p148nt.base.widget.setting.model;

import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0005R$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0005R$\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u0005R\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b-\u0010'R$\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010'\"\u0004\b1\u00102¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingModel;", "", "widgetId", "", "<init>", "(I)V", "getWidgetId", "()I", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "widgetSettingState", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "getWidgetSettingState", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "transparency", "getTransparency", "setTransparency", "reverseTransparency", "getReverseTransparency", "bgColor", "backgroundColor", "getBackgroundColor", "setBackgroundColor", BaseWidgetConstant.WIDGET_THEME, "getTheme", "setTheme", "darkMode", "getDarkMode", "setDarkMode", "oldTransparency", "getOldTransparency", "oldBackgroundColor", "getOldBackgroundColor", "oldDarkMode", "getOldDarkMode", "isWidgetContentChanged", "", "()Z", "oneUiWidgetSource", "", "getOneUiWidgetSource", "()Ljava/lang/String;", "oldMatchSetting", "getOldMatchSetting", "value", "matchSetting", "getMatchSetting", "setMatchSetting", "(Z)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseWidgetSettingModel {
    private final int widgetId;

    public BaseWidgetSettingModel(int i) {
        this.widgetId = i;
    }

    public final int getBackgroundColor() {
        return getWidgetSettingState().getBackgroundColor();
    }

    public final int getDarkMode() {
        return getWidgetSettingState().getDarkMode();
    }

    public final boolean getMatchSetting() {
        return getWidgetSettingState().getMatchSetting();
    }

    public final int getOldBackgroundColor() {
        return getWidgetSettingState().getOldBackgroundColor();
    }

    public final int getOldDarkMode() {
        return getWidgetSettingState().getOldDarkMode();
    }

    public final boolean getOldMatchSetting() {
        return getWidgetSettingState().getOldMatchSetting();
    }

    public final int getOldTransparency() {
        return getWidgetSettingState().getOldTransparency();
    }

    @Nullable
    public final String getOneUiWidgetSource() {
        return getWidgetSettingState().getOneUiWidgetSource();
    }

    public final int getReverseTransparency() {
        return getWidgetSettingState().getReverseTransparency();
    }

    public final int getTheme() {
        return getWidgetSettingState().getTheme();
    }

    public final int getTransparency() {
        return getWidgetSettingState().getTransparency();
    }

    public final int getWidgetId() {
        return this.widgetId;
    }

    @NotNull
    public abstract BaseWidgetSettingState getWidgetSettingState();

    public boolean isWidgetContentChanged() {
        return getWidgetSettingState().isChanged();
    }

    public abstract void onSaveInstanceState(@Nullable Bundle outState);

    public final void setBackgroundColor(int i) {
        getWidgetSettingState().setBackgroundColor(i);
    }

    public final void setDarkMode(int i) {
        getWidgetSettingState().setDarkMode(i);
    }

    public final void setMatchSetting(boolean z) {
        getWidgetSettingState().setMatchSetting(z);
    }

    public final void setTheme(int i) {
        getWidgetSettingState().setTheme(i);
    }

    public final void setTransparency(int i) {
        getWidgetSettingState().setTransparency(i);
    }
}
