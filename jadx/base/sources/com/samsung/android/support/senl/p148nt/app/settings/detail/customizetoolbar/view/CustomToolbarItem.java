package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItem;", "", "<init>", "()V", "ItemResource", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CustomToolbarItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final LinkedHashMap<String, ItemResource> itemMap = MapsKt.linkedMapOf(TuplesKt.m13893to("QuickColor", new ItemResource(C8003R.string.setting_custom_toolbar_pen_color, C8003R.drawable.settings_toolbar_list_ic_quick_color_3)), TuplesKt.m13893to("QuickSize", new ItemResource(C8003R.string.setting_custom_toolbar_pen_size, C8003R.drawable.settings_toolbar_list_ic_quick_size_1)), TuplesKt.m13893to("EasyWritePad", new ItemResource(C8003R.string.setting_custom_toolbar_ewp, C8003R.drawable.comp_hw_toolbar_ic_input)), TuplesKt.m13893to("Style", new ItemResource(C8003R.string.setting_custom_toolbar_change_style, C8003R.drawable.setting_ic_change_style)), TuplesKt.m13893to("LockCanvas", new ItemResource(C8003R.string.setting_custom_toolbar_lock_canvas, C8003R.drawable.comp_hw_toolbar_ic_lock_canvas)), TuplesKt.m13893to("Shape", new ItemResource(C8003R.string.setting_custom_toolbar_shape, C8003R.drawable.comp_hw_toolbar_ic_shape)), TuplesKt.m13893to("Undo", new ItemResource(C8003R.string.setting_custom_toolbar_undo, C8003R.drawable.comp_common_toolbar_ic_undo)), TuplesKt.m13893to("Redo", new ItemResource(C8003R.string.setting_custom_toolbar_redo, C8003R.drawable.comp_common_toolbar_ic_redo)), TuplesKt.m13893to("DirectWrite", new ItemResource(C8003R.string.setting_custom_toolbar_direct_write, C8003R.drawable.comp_dw_toolbar_ic_direct_writing)), TuplesKt.m13893to("Assistance", new ItemResource(C8003R.string.setting_custom_toolbar_assistance, C8003R.drawable.comp_hw_toolbar_ic_assistance)), TuplesKt.m13893to("Align", new ItemResource(C8003R.string.setting_custom_toolbar_straighten, C8003R.drawable.comp_hw_toolbar_ic_clean_up_handwriting)), TuplesKt.m13893to("ConvertText", new ItemResource(C8003R.string.setting_custom_toolbar_convert_to_text, C8003R.drawable.comp_hw_toolbar_ic_convert_text)), TuplesKt.m13893to("CleanUpAndConvertText", new ItemResource(C8003R.string.hw_toolbar_item_cleanup_ctt, C8003R.drawable.ic_ai_menu_toolbar_hw_btn)), TuplesKt.m13893to("LaserPen", new ItemResource(C8003R.string.hw_toolbar_item_laser_pen, C8003R.drawable.comp_hw_toolbar_ic_laser_pen)));

    @NotNull
    private static final LinkedHashMap<String, String> itemMapForSALogging = MapsKt.linkedMapOf(TuplesKt.m13893to("QuickColor", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_QUICK_COLOR), TuplesKt.m13893to("QuickSize", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_QUICK_THICKNESS), TuplesKt.m13893to("EasyWritePad", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_EASY_WRITING_PAD), TuplesKt.m13893to("Style", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_CHANGE_STYLE), TuplesKt.m13893to("LockCanvas", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_CANVAS_LOCK), TuplesKt.m13893to("Shape", ""), TuplesKt.m13893to("Undo", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_UNDO), TuplesKt.m13893to("Redo", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_REDO), TuplesKt.m13893to("DirectWrite", ""), TuplesKt.m13893to("Assistance", ""), TuplesKt.m13893to("Align", ""), TuplesKt.m13893to("ConvertText", ""), TuplesKt.m13893to("CleanUpAndConvertText", ""), TuplesKt.m13893to("LaserPen", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_LASER_POINTER));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItem$Companion;", "", "<init>", "()V", "itemMap", "Ljava/util/LinkedHashMap;", "", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItem$ItemResource;", "Lkotlin/collections/LinkedHashMap;", "getItemMap", "()Ljava/util/LinkedHashMap;", "itemMapForSALogging", "getItemMapForSALogging", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LinkedHashMap<String, ItemResource> getItemMap() {
            return CustomToolbarItem.itemMap;
        }

        @NotNull
        public final LinkedHashMap<String, String> getItemMapForSALogging() {
            return CustomToolbarItem.itemMapForSALogging;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItem$ItemResource;", "", "nameId", "", "iconId", "<init>", "(II)V", "getNameId", "()I", "getIconId", "setIconId", "(I)V", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ItemResource {
        private int iconId;
        private final int nameId;

        public ItemResource(int i, int i2) {
            this.nameId = i;
            this.iconId = i2;
        }

        public final int getIconId() {
            return this.iconId;
        }

        public final int getNameId() {
            return this.nameId;
        }

        public final void setIconId(int i) {
            this.iconId = i;
        }
    }
}
