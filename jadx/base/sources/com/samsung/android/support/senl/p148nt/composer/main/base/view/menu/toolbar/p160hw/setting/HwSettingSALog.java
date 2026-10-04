package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.content.Context;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingPenInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingSALog extends ComposerSA {
    public static String NONE_TYPE = "0";
    private final Context mContext;
    private final SettingPenInfoData mSettingPenInfoData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HwSettingSALogListener extends ComposerSA.SpenSettingLoggingListener {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onColorCirclePressed() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_COLOR);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onColorPickerCancel() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_CANCEL);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
        public void onColorSettingCancel() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_CANCEL);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
        public void onColorSettingDone(int i) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_SETTING_DONE, i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onColorSettingSelected() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_SELECT_COLOR_SETS_TO_SHOW);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
        public void onEyedropperHandlerTapped() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_EYEDROPPER_HANDLER);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
        public void onEyedropperSelected() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_EYEDROPPER_TOOL);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onRecentColorSelected() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_RECENTLY_USED_COLORS);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
        public void onSeekbarChanged() {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_TRANSPARENCY);
        }
    }

    public HwSettingSALog(Context context, SettingPenInfoData settingPenInfoData) {
        this.mContext = context;
        this.mSettingPenInfoData = settingPenInfoData;
    }

    public static String getSADetailPenType(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.Marker3":
            case "com.samsung.android.sdk.pen.pen.preload.Marker4":
            case "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter":
            case "com.samsung.android.sdk.pen.pen.preload.StraightMarker":
                return "5";
            case "com.samsung.android.sdk.pen.pen.preload.BrushPen":
                return "6";
            case "com.samsung.android.sdk.pen.pen.preload.InkPen2":
                return "3";
            case "com.samsung.android.sdk.pen.pen.preload.ObliquePen":
                return "2";
            case "com.samsung.android.sdk.pen.pen.preload.Pencil2":
                return "4";
            case "com.samsung.android.sdk.pen.pen.preload.FountainPen":
                return "1";
            default:
                return NONE_TYPE;
        }
    }

    public SpenSettingPenLayout.LoggingListener getHighlighterLoggingListener() {
        return new HwSettingSALogListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSALog.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.LoggingListener
            public void onClosed() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_CLOSE);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_DONE, String.valueOf(HwSettingSALog.this.mSettingPenInfoData.getSettingPenInfoSelected().color));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_PEN_COLOR_PICKER);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int i) {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_PEN_COLOR, ColorSettingUtil.getColorName(HwSettingSALog.this.mContext, i));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int i) {
                if (i == 1) {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_COLOR_SELECTION_SWIPE_LEFT);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_COLOR_SELECTION_SWIPE_RIGHT);
                }
            }
        };
    }

    public SpenSettingPenLayout.LoggingListener getPenLoggingListener(final boolean z, final boolean z2) {
        return new HwSettingSALogListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSALog.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.SpenSettingPenLayout.LoggingListener
            public void onClosed() {
                if (z) {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_CHANGE_STYLE_CLOSE);
                } else if (z2) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_CLOSE);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_SETTING_CLOSE);
                }
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_PEN_SETTINGS_OPEN_AND_CLOSE, "1");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER_DONE, String.valueOf(HwSettingSALog.this.mSettingPenInfoData.getSettingPenInfoSelected().color));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
                if (z2) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_COLOR_PICKER);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_PICKER);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int i) {
                if (z2) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_PEN_COLOR, ColorSettingUtil.getColorName(HwSettingSALog.this.mContext, i));
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_COLOR, ColorSettingUtil.getColorName(HwSettingSALog.this.mContext, i));
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.sa.ComposerSA.SpenSettingLoggingListener, com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int i) {
                if (i == 1) {
                    if (z2) {
                        ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_COLOR_SELECTION_SWIPE_LEFT);
                        return;
                    } else {
                        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_SELECTION_SWIPE_LEFT);
                        return;
                    }
                }
                if (z2) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_COLOR_SELECTION_SWIPE_RIGHT);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_COLOR_SELECTION_SWIPE_RIGHT);
                }
            }
        };
    }

    public void insertAddFavorite(boolean z, boolean z2) {
        if (z) {
            ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_ADD_FAVORITE);
        } else if (z2) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_ADD_TO_FAVORITE_PEN);
        } else {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_HW_ADD_FAVORITE);
        }
    }

    public void insertEyedropperClose() {
        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_EYEDROPPER_CLOSE);
    }

    public void insertFavoritePenSetting(boolean z) {
        if (z) {
            ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_FAVORITE_LIST);
        } else {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_HW_FAVORITE_PEN_SETTING);
        }
    }
}
