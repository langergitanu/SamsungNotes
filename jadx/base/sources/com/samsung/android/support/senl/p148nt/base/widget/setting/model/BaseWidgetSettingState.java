package com.samsung.android.support.senl.p148nt.base.widget.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010,\u001a\u0004\u0018\u00010\u00002\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u0002052\b\u0010-\u001a\u0004\u0018\u00010.H\u0004J\u001a\u00106\u001a\u0002052\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020$2\u0006\u0010\n\u001a\u00020$@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0014\u00107\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010&R\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010\u0007¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "", "<init>", "()V", "transparency", "", "getTransparency", "()I", "setTransparency", "(I)V", "value", "oldTransparency", "getOldTransparency", "setOldTransparency", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "oldBackgroundColor", "getOldBackgroundColor", "setOldBackgroundColor", "darkMode", "getDarkMode", "setDarkMode", "oldDarkMode", "getOldDarkMode", "setOldDarkMode", BaseWidgetConstant.WIDGET_THEME, "getTheme", "setTheme", "oneUiWidgetSource", "", "getOneUiWidgetSource", "()Ljava/lang/String;", "setOneUiWidgetSource", "(Ljava/lang/String;)V", "matchSetting", "", "getMatchSetting", "()Z", "setMatchSetting", "(Z)V", "oldMatchSetting", "getOldMatchSetting", "setOldMatchSetting", "init", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "savedInstanceState", "Landroid/os/Bundle;", "initTheme", "", "initThemeSetting", "isChanged", "reverseTransparency", "getReverseTransparency", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BaseWidgetSettingState {

    @NotNull
    private static final String TAG = "BaseWidgetSettingState";
    private int backgroundColor;
    private int darkMode;
    private int oldBackgroundColor;
    private int oldDarkMode;
    private int oldTransparency;

    @Nullable
    private String oneUiWidgetSource;
    private int theme;
    private int transparency;
    private boolean matchSetting = true;
    private boolean oldMatchSetting = true;

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getDarkMode() {
        return this.darkMode;
    }

    public final boolean getMatchSetting() {
        return this.matchSetting;
    }

    public final int getOldBackgroundColor() {
        return this.oldBackgroundColor;
    }

    public final int getOldDarkMode() {
        return this.oldDarkMode;
    }

    public final boolean getOldMatchSetting() {
        return this.oldMatchSetting;
    }

    public final int getOldTransparency() {
        return this.oldTransparency;
    }

    @Nullable
    public final String getOneUiWidgetSource() {
        return this.oneUiWidgetSource;
    }

    public final int getReverseTransparency() {
        return 100 - getTransparency();
    }

    public final int getTheme() {
        return this.theme;
    }

    public int getTransparency() {
        return this.transparency;
    }

    @Nullable
    public BaseWidgetSettingState init(@Nullable Activity activity, @NotNull Intent intent, int appWidgetId, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (savedInstanceState != null) {
            setTransparency(savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_TRANSPARENCY));
            this.backgroundColor = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_BACKGROUND_COLOR);
            this.oldTransparency = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_TRANSPARENCY);
            this.oldBackgroundColor = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_BACKGROUND_COLOR);
            this.darkMode = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_DARK_MODE);
            this.oldDarkMode = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_DARK_MODE);
            this.oneUiWidgetSource = savedInstanceState.getString(BaseWidgetSettingConstant.KEY_ONE_UI_WIDGET_SOURCE_SPACE);
            this.matchSetting = savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING);
            this.oldMatchSetting = savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING);
            initThemeSetting(activity, this.oneUiWidgetSource);
            return this;
        }
        if (intent.getAction() != null) {
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            setTransparency(companion.getTransparency(appWidgetId));
            int backgroundColor = companion.getBackgroundColor(appWidgetId);
            this.oldBackgroundColor = backgroundColor;
            this.backgroundColor = backgroundColor;
            this.oldTransparency = getTransparency();
            int darkMode = companion.getDarkMode(appWidgetId);
            this.oldDarkMode = darkMode;
            this.darkMode = darkMode;
            this.oneUiWidgetSource = companion.getOneUiWidgetSource(appWidgetId);
            boolean widgetMatchSetting = companion.getWidgetMatchSetting(appWidgetId);
            this.oldMatchSetting = widgetMatchSetting;
            this.matchSetting = widgetMatchSetting;
            initThemeSetting(activity, this.oneUiWidgetSource);
        }
        return this;
    }

    public final void initTheme(@Nullable Activity activity) {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        this.theme = companion.checkTheme(activity, getReverseTransparency(), companion.getCurrentBackgroundColor(activity, this.backgroundColor, this.darkMode));
    }

    public final void initThemeSetting(@Nullable Activity activity, @Nullable String oneUiWidgetSource) {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        this.theme = companion.checkThemeSetting(activity, getReverseTransparency(), companion.getCurrentBackgroundColor(activity, this.backgroundColor, this.darkMode), oneUiWidgetSource);
    }

    public boolean isChanged() {
        boolean z = this.oldTransparency != getTransparency();
        boolean z2 = this.backgroundColor != this.oldBackgroundColor;
        boolean z3 = this.darkMode != this.oldDarkMode;
        boolean z4 = this.oldMatchSetting != this.matchSetting;
        Logger.m8697d(TAG, "isChanged. Transparency=" + z);
        Logger.m8697d(TAG, "isChanged. BackgroundColor=" + z2);
        Logger.m8697d(TAG, "isChanged. DarkMode=" + z3);
        Logger.m8697d(TAG, "isChanged. MatchSetting=" + z4);
        return z || z2 || z3 || z4;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setDarkMode(int i) {
        this.darkMode = i;
    }

    public final void setMatchSetting(boolean z) {
        this.matchSetting = z;
    }

    public final void setOldBackgroundColor(int i) {
        this.oldBackgroundColor = i;
    }

    public final void setOldDarkMode(int i) {
        this.oldDarkMode = i;
    }

    public final void setOldMatchSetting(boolean z) {
        this.oldMatchSetting = z;
    }

    public final void setOldTransparency(int i) {
        this.oldTransparency = i;
    }

    public final void setOneUiWidgetSource(@Nullable String str) {
        this.oneUiWidgetSource = str;
    }

    public final void setTheme(int i) {
        this.theme = i;
    }

    public void setTransparency(int i) {
        this.transparency = i;
    }
}
