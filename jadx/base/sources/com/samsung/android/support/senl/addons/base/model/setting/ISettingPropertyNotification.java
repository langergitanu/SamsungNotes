package com.samsung.android.support.senl.addons.base.model.setting;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingPropertyNotification;", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingShow;", "setPenSettingVisibility", "", "visibility", "", "getPenSettingVisibility", "setEraserSettingVisibility", "getEraserSettingVisibility", "setSelectionSettingVisibility", "getSelectionSettingVisibility", "setColorGradationVisibility", "getColorGradationVisibility", "setColorPickerVisibility", "getColorPickerVisibility", "setPaletteSettingVisibility", "getPaletteSettingVisibility", "setAttachSheetVisibility", "getAttachSheetVisibility", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISettingPropertyNotification extends ISettingShow {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_PROPERTY_ATTACH_SHEET_SHOW = 507;
    public static final int OBSV_PROPERTY_CLEAR_POPUP_VISIBILITY = 510;
    public static final int OBSV_PROPERTY_COLOR_PICKER_SHOW = 505;
    public static final int OBSV_PROPERTY_ERASER_SETTING_SHOW = 502;
    public static final int OBSV_PROPERTY_GRADATION_SHOW = 504;
    public static final int OBSV_PROPERTY_PALLET_SETTING_SHOW = 506;
    public static final int OBSV_PROPERTY_PEN_SETTING_SHOW = 501;
    public static final int OBSV_PROPERTY_POPUP_SETTING_RECREATE = 509;
    public static final int OBSV_PROPERTY_POPUP_SETTING_STORE = 508;
    public static final int OBSV_PROPERTY_SELECTION_SETTING_SHOW = 503;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingPropertyNotification$Companion;", "", "<init>", "()V", "OBSV_PROPERTY_PEN_SETTING_SHOW", "", "OBSV_PROPERTY_ERASER_SETTING_SHOW", "OBSV_PROPERTY_SELECTION_SETTING_SHOW", "OBSV_PROPERTY_GRADATION_SHOW", "OBSV_PROPERTY_COLOR_PICKER_SHOW", "OBSV_PROPERTY_PALLET_SETTING_SHOW", "OBSV_PROPERTY_ATTACH_SHEET_SHOW", "OBSV_PROPERTY_POPUP_SETTING_STORE", "OBSV_PROPERTY_POPUP_SETTING_RECREATE", "OBSV_PROPERTY_CLEAR_POPUP_VISIBILITY", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_PROPERTY_ATTACH_SHEET_SHOW = 507;
        public static final int OBSV_PROPERTY_CLEAR_POPUP_VISIBILITY = 510;
        public static final int OBSV_PROPERTY_COLOR_PICKER_SHOW = 505;
        public static final int OBSV_PROPERTY_ERASER_SETTING_SHOW = 502;
        public static final int OBSV_PROPERTY_GRADATION_SHOW = 504;
        public static final int OBSV_PROPERTY_PALLET_SETTING_SHOW = 506;
        public static final int OBSV_PROPERTY_PEN_SETTING_SHOW = 501;
        public static final int OBSV_PROPERTY_POPUP_SETTING_RECREATE = 509;
        public static final int OBSV_PROPERTY_POPUP_SETTING_STORE = 508;
        public static final int OBSV_PROPERTY_SELECTION_SETTING_SHOW = 503;

        private Companion() {
        }
    }

    boolean getAttachSheetVisibility();

    boolean getColorGradationVisibility();

    boolean getColorPickerVisibility();

    boolean getEraserSettingVisibility();

    boolean getPaletteSettingVisibility();

    boolean getPenSettingVisibility();

    boolean getSelectionSettingVisibility();

    void setAttachSheetVisibility(boolean visibility);

    void setColorGradationVisibility(boolean visibility);

    void setColorPickerVisibility(boolean visibility);

    void setEraserSettingVisibility(boolean visibility);

    void setPaletteSettingVisibility(boolean visibility);

    void setPenSettingVisibility(boolean visibility);

    void setSelectionSettingVisibility(boolean visibility);
}
