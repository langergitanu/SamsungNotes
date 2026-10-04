package com.samsung.android.support.senl.addons.base.viewmodel.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand;", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IVMCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String TYPE_ACTION_CLICK = "action_click";

    @NotNull
    public static final String TYPE_ACTION_LAYOUT_CHANGE = "action_layoutChange";

    @NotNull
    public static final String TYPE_ACTION_LONG_CLICK = "action_long_click";

    @NotNull
    public static final String TYPE_ACTION_PREFIX = "action_";

    @NotNull
    public static final String TYPE_ACTION_PROGRESS = "action_onProgress";

    @NotNull
    public static final String TYPE_ACTION_TOUCH = "action_touch";

    @NotNull
    public static final String TYPE_ADAPTER_BACKGROUND_RIPPLE = "ad_base_backgroundRipple";

    @NotNull
    public static final String TYPE_ADAPTER_BGCOLOR_ALPHA = "ad_base_setBackgroundColorAlpha";

    @NotNull
    public static final String TYPE_ADAPTER_BG_COLOR = "ad_base_colorBackground";

    @NotNull
    public static final String TYPE_ADAPTER_BG_DRAWABLE = "ad_base_drawableBackground";

    @NotNull
    public static final String TYPE_ADAPTER_BITMAP_SRC = "ad_base_bitmapSrc";

    @NotNull
    public static final String TYPE_ADAPTER_CONSUME_HOVER = "ad_base_consumeHover";

    @NotNull
    public static final String TYPE_ADAPTER_FONT = "ad_base_font";

    @NotNull
    public static final String TYPE_ADAPTER_HIDE_ANIMATION_BY_TOUCH = "ad_base_hideAnimationByTouch";

    @NotNull
    public static final String TYPE_ADAPTER_HOVER_POPUP = "ad_base_hoverPopup";

    @NotNull
    public static final String TYPE_ADAPTER_PREFIX = "ad_";

    @NotNull
    public static final String TYPE_ADAPTER_ROTATION_EXTRA = "ad_base_rotationExtra";

    @NotNull
    public static final String TYPE_ADAPTER_RTL_FLIPPING = "ad_base_rtlFlipping";

    @NotNull
    public static final String TYPE_ADAPTER_SETTING_POPUP = "ad_base_settingPopup";

    @NotNull
    public static final String TYPE_ADAPTER_TRANSPARENT = "ad_base_transparent";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_ENABLED = "ad_base_viewEnabled";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_FOCUSABLE = "ad_base_viewFocusable";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_GRAVITY_BY_DIRECTION = "ad_base_viewGravityByDirection";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_HEIGHT = "ad_base_viewHeight";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_MARGIN_BOTTOM = "ad_base_viewMarginBottom";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_MARGIN_BOTTOM_RES_ID = "ad_base_viewMarginBottomResId";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_MARGIN_END = "ad_base_viewMarginEnd";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_MARGIN_START = "ad_base_viewMarginStart";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_MARGIN_TOP = "ad_base_viewMarginTop";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_PADDING_END = "ad_base_viewPaddingEnd";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_PREFIX = "ad_base_view";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_SELECTED = "ad_base_viewSelected";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_WEIGHT = "ad_base_viewWeight";

    @NotNull
    public static final String TYPE_ADAPTER_VIEW_WIDTH = "ad_base_viewWidth";

    @NotNull
    public static final String TYPE_ADAPTER_VISIBLE_GONE = "ad_base_visibleGone";

    @NotNull
    public static final String TYPE_ADAPTER_VISIBLE_GONE_WITH_ANIMATION = "ad_base_visibleGoneWithAnimation";

    @NotNull
    public static final String TYPE_ADAPTER_VISIBLE_HIDE = "ad_base_visibleHide";

    @NotNull
    public static final String TYPE_ADAPTER_ZOOM_RATIO_TEXT = "ad_base_zoomRatioText";

    @NotNull
    public static final String TYPE_DATA_BUTTON_CONTENT_DESCRIPTION = "pr_button_content";

    @NotNull
    public static final String TYPE_DATA_CLICKABLE = "pr_clickable";

    @NotNull
    public static final String TYPE_DATA_CONTENT_DESCRIPTION = "pr_content";

    @NotNull
    public static final String TYPE_DATA_PREFIX = "pr_";

    @NotNull
    public static final String TYPE_DATA_PROGRESS = "pr_progress";

    @NotNull
    public static final String TYPE_DATA_TEXT = "pr_text";

    @NotNull
    public static final String TYPE_DATA_VISIBILITY = "pr_visibility";

    @NotNull
    public static final String TYPE_METHOD_INFLATED = "md_inflated";

    @NotNull
    public static final String TYPE_METHOD_PREFIX = "md_";

    @NotNull
    public static final String TYPE_METHOD_SETTING_POPUP_DATASTORE = "md_pupupDataStore";

    @NotNull
    public static final String TYPE_METHOD_SETTING_POPUP_LISTENER = "md_settingPopupListener";

    @NotNull
    public static final String TYPE_METHOD_TRANSPARENCY = "md_transparency";

    @NotNull
    public static final String TYPE_NONE = "none";

    @NotNull
    public static final String TYPE_POSTFIX_EXECUTE_TYPE = "_pending";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b4\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IVMCommand$Companion;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_ACTION_PREFIX", "TYPE_ACTION_TOUCH", "TYPE_ACTION_CLICK", "TYPE_ACTION_LONG_CLICK", "TYPE_ACTION_LAYOUT_CHANGE", "TYPE_ACTION_PROGRESS", "TYPE_DATA_PREFIX", "TYPE_DATA_VISIBILITY", "TYPE_DATA_CONTENT_DESCRIPTION", "TYPE_DATA_BUTTON_CONTENT_DESCRIPTION", "TYPE_DATA_PROGRESS", "TYPE_DATA_CLICKABLE", "TYPE_DATA_TEXT", "TYPE_ADAPTER_PREFIX", "TYPE_ADAPTER_VIEW_PREFIX", "TYPE_ADAPTER_VIEW_WIDTH", "TYPE_ADAPTER_VIEW_HEIGHT", "TYPE_ADAPTER_VIEW_SELECTED", "TYPE_ADAPTER_VIEW_ENABLED", "TYPE_ADAPTER_VIEW_FOCUSABLE", "TYPE_ADAPTER_VIEW_WEIGHT", "TYPE_ADAPTER_VIEW_MARGIN_BOTTOM", "TYPE_ADAPTER_VIEW_MARGIN_END", "TYPE_ADAPTER_VIEW_MARGIN_START", "TYPE_ADAPTER_VIEW_MARGIN_TOP", "TYPE_ADAPTER_VIEW_PADDING_END", "TYPE_ADAPTER_VIEW_MARGIN_BOTTOM_RES_ID", "TYPE_ADAPTER_VIEW_GRAVITY_BY_DIRECTION", "TYPE_ADAPTER_VISIBLE_HIDE", "TYPE_ADAPTER_VISIBLE_GONE", "TYPE_ADAPTER_VISIBLE_GONE_WITH_ANIMATION", "TYPE_ADAPTER_BG_DRAWABLE", "TYPE_ADAPTER_BG_COLOR", "TYPE_ADAPTER_BGCOLOR_ALPHA", "TYPE_ADAPTER_BACKGROUND_RIPPLE", "TYPE_ADAPTER_TRANSPARENT", "TYPE_ADAPTER_SETTING_POPUP", "TYPE_ADAPTER_HOVER_POPUP", "TYPE_ADAPTER_RTL_FLIPPING", "TYPE_ADAPTER_HIDE_ANIMATION_BY_TOUCH", "TYPE_ADAPTER_BITMAP_SRC", "TYPE_ADAPTER_CONSUME_HOVER", "TYPE_ADAPTER_ZOOM_RATIO_TEXT", "TYPE_ADAPTER_ROTATION_EXTRA", "TYPE_ADAPTER_FONT", "TYPE_METHOD_PREFIX", "TYPE_METHOD_INFLATED", "TYPE_METHOD_TRANSPARENCY", "TYPE_METHOD_SETTING_POPUP_LISTENER", "TYPE_METHOD_SETTING_POPUP_DATASTORE", "TYPE_POSTFIX_EXECUTE_TYPE", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String TYPE_ACTION_CLICK = "action_click";

        @NotNull
        public static final String TYPE_ACTION_LAYOUT_CHANGE = "action_layoutChange";

        @NotNull
        public static final String TYPE_ACTION_LONG_CLICK = "action_long_click";

        @NotNull
        public static final String TYPE_ACTION_PREFIX = "action_";

        @NotNull
        public static final String TYPE_ACTION_PROGRESS = "action_onProgress";

        @NotNull
        public static final String TYPE_ACTION_TOUCH = "action_touch";

        @NotNull
        public static final String TYPE_ADAPTER_BACKGROUND_RIPPLE = "ad_base_backgroundRipple";

        @NotNull
        public static final String TYPE_ADAPTER_BGCOLOR_ALPHA = "ad_base_setBackgroundColorAlpha";

        @NotNull
        public static final String TYPE_ADAPTER_BG_COLOR = "ad_base_colorBackground";

        @NotNull
        public static final String TYPE_ADAPTER_BG_DRAWABLE = "ad_base_drawableBackground";

        @NotNull
        public static final String TYPE_ADAPTER_BITMAP_SRC = "ad_base_bitmapSrc";

        @NotNull
        public static final String TYPE_ADAPTER_CONSUME_HOVER = "ad_base_consumeHover";

        @NotNull
        public static final String TYPE_ADAPTER_FONT = "ad_base_font";

        @NotNull
        public static final String TYPE_ADAPTER_HIDE_ANIMATION_BY_TOUCH = "ad_base_hideAnimationByTouch";

        @NotNull
        public static final String TYPE_ADAPTER_HOVER_POPUP = "ad_base_hoverPopup";

        @NotNull
        public static final String TYPE_ADAPTER_PREFIX = "ad_";

        @NotNull
        public static final String TYPE_ADAPTER_ROTATION_EXTRA = "ad_base_rotationExtra";

        @NotNull
        public static final String TYPE_ADAPTER_RTL_FLIPPING = "ad_base_rtlFlipping";

        @NotNull
        public static final String TYPE_ADAPTER_SETTING_POPUP = "ad_base_settingPopup";

        @NotNull
        public static final String TYPE_ADAPTER_TRANSPARENT = "ad_base_transparent";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_ENABLED = "ad_base_viewEnabled";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_FOCUSABLE = "ad_base_viewFocusable";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_GRAVITY_BY_DIRECTION = "ad_base_viewGravityByDirection";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_HEIGHT = "ad_base_viewHeight";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_MARGIN_BOTTOM = "ad_base_viewMarginBottom";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_MARGIN_BOTTOM_RES_ID = "ad_base_viewMarginBottomResId";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_MARGIN_END = "ad_base_viewMarginEnd";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_MARGIN_START = "ad_base_viewMarginStart";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_MARGIN_TOP = "ad_base_viewMarginTop";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_PADDING_END = "ad_base_viewPaddingEnd";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_PREFIX = "ad_base_view";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_SELECTED = "ad_base_viewSelected";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_WEIGHT = "ad_base_viewWeight";

        @NotNull
        public static final String TYPE_ADAPTER_VIEW_WIDTH = "ad_base_viewWidth";

        @NotNull
        public static final String TYPE_ADAPTER_VISIBLE_GONE = "ad_base_visibleGone";

        @NotNull
        public static final String TYPE_ADAPTER_VISIBLE_GONE_WITH_ANIMATION = "ad_base_visibleGoneWithAnimation";

        @NotNull
        public static final String TYPE_ADAPTER_VISIBLE_HIDE = "ad_base_visibleHide";

        @NotNull
        public static final String TYPE_ADAPTER_ZOOM_RATIO_TEXT = "ad_base_zoomRatioText";

        @NotNull
        public static final String TYPE_DATA_BUTTON_CONTENT_DESCRIPTION = "pr_button_content";

        @NotNull
        public static final String TYPE_DATA_CLICKABLE = "pr_clickable";

        @NotNull
        public static final String TYPE_DATA_CONTENT_DESCRIPTION = "pr_content";

        @NotNull
        public static final String TYPE_DATA_PREFIX = "pr_";

        @NotNull
        public static final String TYPE_DATA_PROGRESS = "pr_progress";

        @NotNull
        public static final String TYPE_DATA_TEXT = "pr_text";

        @NotNull
        public static final String TYPE_DATA_VISIBILITY = "pr_visibility";

        @NotNull
        public static final String TYPE_METHOD_INFLATED = "md_inflated";

        @NotNull
        public static final String TYPE_METHOD_PREFIX = "md_";

        @NotNull
        public static final String TYPE_METHOD_SETTING_POPUP_DATASTORE = "md_pupupDataStore";

        @NotNull
        public static final String TYPE_METHOD_SETTING_POPUP_LISTENER = "md_settingPopupListener";

        @NotNull
        public static final String TYPE_METHOD_TRANSPARENCY = "md_transparency";

        @NotNull
        public static final String TYPE_NONE = "none";

        @NotNull
        public static final String TYPE_POSTFIX_EXECUTE_TYPE = "_pending";

        private Companion() {
        }
    }
}
