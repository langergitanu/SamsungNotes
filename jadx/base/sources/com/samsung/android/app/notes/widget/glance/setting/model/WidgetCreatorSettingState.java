package com.samsung.android.app.notes.widget.glance.setting.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorPreference;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.model.BaseWidgetSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R0\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR$\u00101\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u00104\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR$\u00107\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR$\u0010:\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR$\u0010=\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR$\u0010@\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R$\u0010C\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/model/WidgetCreatorSettingState;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/model/BaseWidgetSettingState;", "<init>", "()V", "mSelectedItems", "", "", "getMSelectedItems", "()Ljava/util/List;", "setMSelectedItems", "(Ljava/util/List;)V", "mColumn", "getMColumn", "()I", "setMColumn", "(I)V", "mWidth", "getMWidth", "setMWidth", "mHeight", "getMHeight", "setMHeight", "mBackgroundShape", "getMBackgroundShape", "setMBackgroundShape", "mOldBackgroundShape", "getMOldBackgroundShape", "setMOldBackgroundShape", "mBackgroundOnOff", "", "getMBackgroundOnOff", "()Z", "setMBackgroundOnOff", "(Z)V", "mOldBackgroundOnOff", "getMOldBackgroundOnOff", "setMOldBackgroundOnOff", "init", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "savedInstanceState", "Landroid/os/Bundle;", "value", "selectedItems", "getSelectedItems", "setSelectedItems", "column", "getColumn", "setColumn", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "backgroundShape", "getBackgroundShape", "setBackgroundShape", "oldBackgroundShape", "getOldBackgroundShape", "setOldBackgroundShape", "backgroundOnOff", "getBackgroundOnOff", "setBackgroundOnOff", "oldBackgroundOnOff", "getOldBackgroundOnOff", "setOldBackgroundOnOff", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorSettingState extends BaseWidgetSettingState {
    public static final int $stable = 8;
    private int mBackgroundShape;
    private int mColumn;
    private int mHeight;
    private int mOldBackgroundShape;

    @Nullable
    private List<Integer> mSelectedItems;
    private int mWidth;
    private boolean mBackgroundOnOff = true;
    private boolean mOldBackgroundOnOff = true;

    /* JADX INFO: renamed from: getBackgroundOnOff, reason: from getter */
    public final boolean getMBackgroundOnOff() {
        return this.mBackgroundOnOff;
    }

    /* JADX INFO: renamed from: getBackgroundShape, reason: from getter */
    public final int getMBackgroundShape() {
        return this.mBackgroundShape;
    }

    /* JADX INFO: renamed from: getColumn, reason: from getter */
    public final int getMColumn() {
        return this.mColumn;
    }

    /* JADX INFO: renamed from: getHeight, reason: from getter */
    public final int getMHeight() {
        return this.mHeight;
    }

    public final boolean getMBackgroundOnOff() {
        return this.mBackgroundOnOff;
    }

    public final int getMBackgroundShape() {
        return this.mBackgroundShape;
    }

    public final int getMColumn() {
        return this.mColumn;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final boolean getMOldBackgroundOnOff() {
        return this.mOldBackgroundOnOff;
    }

    public final int getMOldBackgroundShape() {
        return this.mOldBackgroundShape;
    }

    @Nullable
    public final List<Integer> getMSelectedItems() {
        return this.mSelectedItems;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final boolean getOldBackgroundOnOff() {
        return this.mOldBackgroundOnOff;
    }

    public final int getOldBackgroundShape() {
        return this.mOldBackgroundShape;
    }

    @NotNull
    public final List<Integer> getSelectedItems() {
        List<Integer> list = this.mSelectedItems;
        Intrinsics.checkNotNull(list);
        return list;
    }

    public final int getWidth() {
        return this.mWidth;
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
            this.mSelectedItems = savedInstanceState.getIntegerArrayList(BaseWidgetConstant.KEY_SELECTED_ITEMS);
            this.mColumn = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_COLUMN_SPAN);
            this.mWidth = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_WIDTH);
            this.mHeight = savedInstanceState.getInt(BaseWidgetConstant.WIDGET_GLANCE_MIN_HEIGHT);
            setMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_MATCH_SETTING));
            setOldMatchSetting(savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_MATCH_SETTING));
            this.mBackgroundShape = savedInstanceState.getInt(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
            this.mOldBackgroundShape = savedInstanceState.getInt(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_SHAPE);
            this.mBackgroundOnOff = savedInstanceState.getBoolean(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF);
            this.mOldBackgroundOnOff = savedInstanceState.getBoolean(BaseWidgetSettingConstant.KEY_OLD_WIDGET_BACKGROUND_ON_OFF);
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
            this.mSelectedItems = WidgetCreatorPreference.INSTANCE.getSelectedItems(appWidgetId);
            this.mColumn = companion.getColumnSpan(appWidgetId);
            this.mWidth = companion.getMinWidth(appWidgetId);
            this.mHeight = companion.getMinHeight(appWidgetId);
            setOldMatchSetting(companion.getWidgetMatchSetting(appWidgetId));
            setMatchSetting(getOldMatchSetting());
            int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
            this.mOldBackgroundShape = widgetBackgroundShape;
            this.mBackgroundShape = widgetBackgroundShape;
            boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
            this.mOldBackgroundOnOff = widgetBackgroundOnOff;
            this.mBackgroundOnOff = widgetBackgroundOnOff;
            initTheme(activity);
        }
        return this;
    }

    public final void setBackgroundOnOff(boolean z) {
        this.mBackgroundOnOff = z;
    }

    public final void setBackgroundShape(int i) {
        this.mBackgroundShape = i;
    }

    public final void setColumn(int i) {
        this.mColumn = i;
    }

    public final void setHeight(int i) {
        this.mHeight = i;
    }

    public final void setMBackgroundOnOff(boolean z) {
        this.mBackgroundOnOff = z;
    }

    public final void setMBackgroundShape(int i) {
        this.mBackgroundShape = i;
    }

    public final void setMColumn(int i) {
        this.mColumn = i;
    }

    public final void setMHeight(int i) {
        this.mHeight = i;
    }

    public final void setMOldBackgroundOnOff(boolean z) {
        this.mOldBackgroundOnOff = z;
    }

    public final void setMOldBackgroundShape(int i) {
        this.mOldBackgroundShape = i;
    }

    public final void setMSelectedItems(@Nullable List<Integer> list) {
        this.mSelectedItems = list;
    }

    public final void setMWidth(int i) {
        this.mWidth = i;
    }

    public final void setOldBackgroundOnOff(boolean z) {
        this.mOldBackgroundOnOff = z;
    }

    public final void setOldBackgroundShape(int i) {
        this.mOldBackgroundShape = i;
    }

    public final void setSelectedItems(@NotNull List<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mSelectedItems = value;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
    }
}
