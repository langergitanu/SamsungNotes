package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.content.Context;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingPenInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingSALog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingSALog;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingSALog;", "mContext", "Landroid/content/Context;", "settingPenInfoData", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/toolbar/hw/setting/data/SettingPenInfoData;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/toolbar/hw/setting/data/SettingPenInfoData;)V", "insertEyedropperClose", "", "insertAddFavorite", "isTablet", "", "isHighlighter", "getPenLoggingListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingPenLayout$LoggingListener;", "isChangeStyle", "getHighlighterLoggingListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingSALog extends HwSettingSALog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingSALog$Companion;", "", "<init>", "()V", "getSADetailPenType", "", "name", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        public final String getSADetailPenType(@Nullable String name) {
            if (name == null) {
                return "0";
            }
            switch (name.hashCode()) {
                case -1499175198:
                    return !name.equals(SpenPenManager.SPEN_BRUSH_PEN) ? "0" : "5";
                case -610903172:
                    return !name.equals(SpenPenManager.SPEN_INK_PEN2) ? "0" : "3";
                case 202751947:
                    return !name.equals(SpenPenManager.SPEN_OBLIQUE_PEN) ? "0" : "2";
                case 1052333314:
                    return !name.equals(SpenPenManager.SPEN_PENCIL2) ? "0" : "4";
                case 1559752130:
                    return !name.equals(SpenPenManager.SPEN_FOUNTAIN_PEN) ? "0" : "1";
                default:
                    return "0";
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppSettingSALog(@NotNull Context mContext, @Nullable SettingPenInfoData settingPenInfoData) {
        super(mContext, settingPenInfoData);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingSALog
    @NotNull
    public SpenSettingPenLayout.LoggingListener getHighlighterLoggingListener() {
        return new SpenSettingPenLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingSALog.getHighlighterLoggingListener.1
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.LoggingListener
            public void onClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorCirclePressed() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_COLOR_PICKER_SELECT);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_PICKER);
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int color) {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_PEN_COLOR, ColorSettingUtil.getColorName(InAppSettingSALog.this.mContext, color));
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingDone(int count) {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSettingSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_SELECT_COLOR_SETS_TO_SHOW);
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperHandlerTapped() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onEyedropperSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int direction) {
                if (direction == 1) {
                    ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_SELECTION_SWIPE_LEFT);
                } else {
                    ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_SELECTION_SWIPE_RIGHT);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onRecentColorSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_COLOR_PICKER_RECENTLY_USED_COLORS);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onSeekbarChanged() {
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingSALog
    @NotNull
    public SpenSettingPenLayout.LoggingListener getPenLoggingListener(boolean isChangeStyle, boolean isTablet) {
        return new SpenSettingPenLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingSALog.getPenLoggingListener.1
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.LoggingListener
            public void onClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorCirclePressed() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_COLOR_PICKER_SELECT);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_PICKER);
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int color) {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_PEN_COLOR, ColorSettingUtil.getColorName(InAppSettingSALog.this.mContext, color));
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingDone(int count) {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSettingSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_SELECT_COLOR_SETS_TO_SHOW);
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperHandlerTapped() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onEyedropperSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int direction) {
                if (direction == 1) {
                    ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_SELECTION_SWIPE_LEFT);
                } else {
                    ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_COLOR_SELECTION_SWIPE_RIGHT);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onRecentColorSelected() {
                ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_COLOR_PICKER_RECENTLY_USED_COLORS);
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onSeekbarChanged() {
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingSALog
    public void insertAddFavorite(boolean isTablet, boolean isHighlighter) {
        ComposerSA.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_ADD_FAVORITE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingSALog
    public void insertEyedropperClose() {
    }
}
