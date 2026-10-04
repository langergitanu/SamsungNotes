package com.samsung.android.support.senl.addons.brush.viewmodel.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/common/IBrushVMCommand;", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String TYPE_ADAPTER_BRUSH_DONE_BUTTON_SIZE = "ad_brush_doneButtonSize";

    @NotNull
    public static final String TYPE_ADAPTER_BRUSH_IMAGE_ENABLE = "ad_brush_imageEnable";

    @NotNull
    public static final String TYPE_ADAPTER_BRUSH_IMAGE_ENABLE_WITHOUT_EN_TINT = "ad_brush_imageEnable_without_enable_tint";

    @NotNull
    public static final String TYPE_ADAPTER_BRUSH_MENU_HIDE_ANIMATION = "ad_brush_menuHideAnimation";

    @NotNull
    public static final String TYPE_ADAPTER_BRUSH_PREVIEW = "ad_brush_preview";

    @NotNull
    public static final String TYPE_ADAPTER_DESK_TOP_MODE_ENABLE = "ad_brush_desktopModeEnable";

    @NotNull
    public static final String TYPE_ADAPTER_ZOOM_MENU_POSITION = "ad_brush_zoomMenuPosition";

    @NotNull
    public static final String TYPE_ADAPTER_ZOOM_TEXT_POSITION = "ad_brush_zoomTextPosition";

    @NotNull
    public static final String TYPE_METHOD_ERASER_SELECTION = "md_brush_eraserSelection";

    @NotNull
    public static final String TYPE_METHOD_LAYOUT_VIEW_MODEL = "md_brush_layoutVM";

    @NotNull
    public static final String TYPE_METHOD_MAIN_VIEW_MODEL = "md_brush_mainVM";

    @NotNull
    public static final String TYPE_METHOD_MENU_HIDE_VIEW_MODEL = "md_brush_menuHideVM";

    @NotNull
    public static final String TYPE_METHOD_MENU_INFO = "md_brush_menuInfo";

    @NotNull
    public static final String TYPE_METHOD_PANNINGBAR_LISTENER = "md_brush_panningbarListener";

    @NotNull
    public static final String TYPE_METHOD_PENUP_LISTENER = "md_brush_penupListener";

    @NotNull
    public static final String TYPE_METHOD_PREVIEW_IMAGE_VIEW_MODEL = "md_brush_previewImageVM";

    @NotNull
    public static final String TYPE_METHOD_SETTING_POPUP_LISTENER = "md_brush_settingPopupListener";

    @NotNull
    public static final String TYPE_METHOD_SETTING_VIEW_MODEL = "md_brush_settingVM";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/common/IBrushVMCommand$Companion;", "", "<init>", "()V", "TYPE_ADAPTER_BRUSH_DONE_BUTTON_SIZE", "", "TYPE_ADAPTER_BRUSH_MENU_HIDE_ANIMATION", "TYPE_ADAPTER_BRUSH_IMAGE_ENABLE", "TYPE_ADAPTER_BRUSH_IMAGE_ENABLE_WITHOUT_EN_TINT", "TYPE_ADAPTER_BRUSH_PREVIEW", "TYPE_ADAPTER_ZOOM_TEXT_POSITION", "TYPE_ADAPTER_ZOOM_MENU_POSITION", "TYPE_ADAPTER_DESK_TOP_MODE_ENABLE", "TYPE_METHOD_MENU_HIDE_VIEW_MODEL", "TYPE_METHOD_LAYOUT_VIEW_MODEL", "TYPE_METHOD_MAIN_VIEW_MODEL", "TYPE_METHOD_SETTING_VIEW_MODEL", "TYPE_METHOD_ERASER_SELECTION", "TYPE_METHOD_MENU_INFO", "TYPE_METHOD_SETTING_POPUP_LISTENER", "TYPE_METHOD_PENUP_LISTENER", "TYPE_METHOD_PREVIEW_IMAGE_VIEW_MODEL", "TYPE_METHOD_PANNINGBAR_LISTENER", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String TYPE_ADAPTER_BRUSH_DONE_BUTTON_SIZE = "ad_brush_doneButtonSize";

        @NotNull
        public static final String TYPE_ADAPTER_BRUSH_IMAGE_ENABLE = "ad_brush_imageEnable";

        @NotNull
        public static final String TYPE_ADAPTER_BRUSH_IMAGE_ENABLE_WITHOUT_EN_TINT = "ad_brush_imageEnable_without_enable_tint";

        @NotNull
        public static final String TYPE_ADAPTER_BRUSH_MENU_HIDE_ANIMATION = "ad_brush_menuHideAnimation";

        @NotNull
        public static final String TYPE_ADAPTER_BRUSH_PREVIEW = "ad_brush_preview";

        @NotNull
        public static final String TYPE_ADAPTER_DESK_TOP_MODE_ENABLE = "ad_brush_desktopModeEnable";

        @NotNull
        public static final String TYPE_ADAPTER_ZOOM_MENU_POSITION = "ad_brush_zoomMenuPosition";

        @NotNull
        public static final String TYPE_ADAPTER_ZOOM_TEXT_POSITION = "ad_brush_zoomTextPosition";

        @NotNull
        public static final String TYPE_METHOD_ERASER_SELECTION = "md_brush_eraserSelection";

        @NotNull
        public static final String TYPE_METHOD_LAYOUT_VIEW_MODEL = "md_brush_layoutVM";

        @NotNull
        public static final String TYPE_METHOD_MAIN_VIEW_MODEL = "md_brush_mainVM";

        @NotNull
        public static final String TYPE_METHOD_MENU_HIDE_VIEW_MODEL = "md_brush_menuHideVM";

        @NotNull
        public static final String TYPE_METHOD_MENU_INFO = "md_brush_menuInfo";

        @NotNull
        public static final String TYPE_METHOD_PANNINGBAR_LISTENER = "md_brush_panningbarListener";

        @NotNull
        public static final String TYPE_METHOD_PENUP_LISTENER = "md_brush_penupListener";

        @NotNull
        public static final String TYPE_METHOD_PREVIEW_IMAGE_VIEW_MODEL = "md_brush_previewImageVM";

        @NotNull
        public static final String TYPE_METHOD_SETTING_POPUP_LISTENER = "md_brush_settingPopupListener";

        @NotNull
        public static final String TYPE_METHOD_SETTING_VIEW_MODEL = "md_brush_settingVM";

        private Companion() {
        }
    }
}
