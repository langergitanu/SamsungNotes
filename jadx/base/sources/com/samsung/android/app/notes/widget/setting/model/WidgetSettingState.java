package com.samsung.android.app.notes.widget.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
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
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR$\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\bR\u0014\u0010 \u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\b¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/model/WidgetSettingState;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "<init>", "()V", "value", "", "reverseColor", "getReverseColor", "()Z", "uUID", "", "getUUID", "()Ljava/lang/String;", "setUUID", "(Ljava/lang/String;)V", "oldUUID", "getOldUUID", "init", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "savedInstanceState", "Landroid/os/Bundle;", "transparency", "getTransparency", "()I", "setTransparency", "(I)V", "isOnlyUUIDChanged", "isChanged", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSettingState extends BaseWidgetSettingState {

    @NotNull
    private static final String TAG = "WidgetSettingState";

    @Nullable
    private String oldUUID;
    private boolean reverseColor;

    @Nullable
    private String uUID;
    public static final int $stable = 8;

    @Nullable
    public final String getOldUUID() {
        return this.oldUUID;
    }

    public final boolean getReverseColor() {
        return this.reverseColor;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState
    public int getTransparency() {
        return super.getTransparency();
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
            initThemeSetting(activity, getOneUiWidgetSource());
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
            initThemeSetting(activity, getOneUiWidgetSource());
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
        return !StringsKt.contentEquals((CharSequence) this.uUID, (CharSequence) this.oldUUID) || super.isChanged();
    }

    public final boolean isOnlyUUIDChanged() {
        return !StringsKt.contentEquals((CharSequence) this.uUID, (CharSequence) this.oldUUID) && getOldTransparency() == getTransparency() && getBackgroundColor() == getOldBackgroundColor() && getDarkMode() == getOldDarkMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState
    public void setTransparency(int i) {
        super.setTransparency(i);
        this.reverseColor = true;
    }

    public final void setUUID(@Nullable String str) {
        this.uUID = str;
    }
}
