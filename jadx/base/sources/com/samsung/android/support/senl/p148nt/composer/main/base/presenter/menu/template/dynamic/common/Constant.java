package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/Constant;", "", "<init>", "()V", "KEY_IS_DYNAMIC_TEMPLATE_OBJECT", "", "KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT", "KEY_OBJECT_ID", "KEY_GROUPED_OBJECT_ID", "KEY_OBJECT_ACTION", "KEY_IMAGE_MASK_TYPE", "POST_FIX_ID_IMAGE_GUIDE_TEXT", "POST_FIX_ID_IMAGE_TARGET_IMAGE", "VALUE_OBJECT_ACTION_INSERT_IMAGE", "VALUE_OBJECT_ACTION_INSERT_GENERATED_IMAGE", "VALUE_OBJECT_ACTION_SHOW_DATE_PICKER_TEXT", "KEY_DATE_TEXT_BOX_FORMAT", "KEY_DAY_OF_WEEK_TEXT_BOX_DISPLAY_TYPE", "KEY_DATE_TEXT_BOX_TIME_IN_MILLIS", "KEY_TEXT_BOX_PARAGRAPH_TYPE", "VALUE_DEFAULT_DATE_TEXT_BOX_FORMAT", "KEY_TARGET_OBJECT_ID", "KEY_TARGET_PAGE_INDEX", "KEYS_FOR_DYNAMIC_TEMPLATE_COMMON", "", "getKEYS_FOR_DYNAMIC_TEMPLATE_COMMON", "()Ljava/util/List;", "KEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID", "getKEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID", "KEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT", "getKEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT", "KEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT", "getKEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT", "ARG_DYNAMIC_TEMPLATE_INDEX", "ARG_DYNAMIC_TEMPLATE_TYPE", "BG_CACHE_PATH", "BackgroundType", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constant {

    @NotNull
    public static final String ARG_DYNAMIC_TEMPLATE_INDEX = "dynamic_template_index";

    @NotNull
    public static final String ARG_DYNAMIC_TEMPLATE_TYPE = "dynamic_template_type";

    @NotNull
    public static final String BG_CACHE_PATH = "dynamic_template_bg";

    @NotNull
    public static final String KEY_TARGET_OBJECT_ID = "key_target_object_id";

    @NotNull
    public static final String KEY_TARGET_PAGE_INDEX = "key_target_page_index";

    @NotNull
    public static final String KEY_TEXT_BOX_PARAGRAPH_TYPE = "key_text_box_paragraph_type";

    @NotNull
    public static final String POST_FIX_ID_IMAGE_GUIDE_TEXT = "post_fix_id_image_guide_text";

    @NotNull
    public static final String POST_FIX_ID_IMAGE_TARGET_IMAGE = "post_fix_id_image_target_image";

    @NotNull
    public static final String VALUE_DEFAULT_DATE_TEXT_BOX_FORMAT = "MM-dd_yyyy";

    @NotNull
    public static final String VALUE_OBJECT_ACTION_INSERT_GENERATED_IMAGE = "value_object_action_insert_generated_image";

    @NotNull
    public static final String VALUE_OBJECT_ACTION_INSERT_IMAGE = "value_object_action_insert_image";

    @NotNull
    public static final String VALUE_OBJECT_ACTION_SHOW_DATE_PICKER_TEXT = "value_object_action_show_date_picker_text";

    @NotNull
    public static final Constant INSTANCE = new Constant();

    @NotNull
    public static final String KEY_IS_DYNAMIC_TEMPLATE_OBJECT = "key_is_dynamic_template_object";

    @NotNull
    public static final String KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT = "key_is_dynamic_template_generative_object";

    @NotNull
    public static final String KEY_OBJECT_ACTION = "key_object_action";

    @NotNull
    private static final List<String> KEYS_FOR_DYNAMIC_TEMPLATE_COMMON = CollectionsKt.toList(CollectionsKt.arrayListOf(KEY_IS_DYNAMIC_TEMPLATE_OBJECT, KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT, KEY_OBJECT_ACTION));

    @NotNull
    public static final String KEY_OBJECT_ID = "key_object_id";

    @NotNull
    public static final String KEY_GROUPED_OBJECT_ID = "key_grouped_object_id";

    @NotNull
    private static final List<String> KEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID = CollectionsKt.toList(CollectionsKt.arrayListOf(KEY_OBJECT_ID, KEY_GROUPED_OBJECT_ID));

    @NotNull
    public static final String KEY_DATE_TEXT_BOX_FORMAT = "key_date_text_box_format";

    @NotNull
    public static final String KEY_DAY_OF_WEEK_TEXT_BOX_DISPLAY_TYPE = "key_day_of_week_text_box_display_type";

    @NotNull
    public static final String KEY_DATE_TEXT_BOX_TIME_IN_MILLIS = "key_date_text_box_time_in_millis";

    @NotNull
    private static final List<String> KEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT = CollectionsKt.toList(CollectionsKt.arrayListOf(KEY_DATE_TEXT_BOX_FORMAT, KEY_DAY_OF_WEEK_TEXT_BOX_DISPLAY_TYPE, KEY_DATE_TEXT_BOX_TIME_IN_MILLIS));

    @NotNull
    public static final String KEY_IMAGE_MASK_TYPE = "key_image_mask_type";

    @NotNull
    private static final List<String> KEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT = CollectionsKt.toList(CollectionsKt.arrayListOf(KEY_IMAGE_MASK_TYPE));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/Constant$BackgroundType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "IMAGE", "PDF", "COLOR", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BackgroundType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BackgroundType[] $VALUES;
        public static final BackgroundType NONE = new BackgroundType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final BackgroundType IMAGE = new BackgroundType("IMAGE", 1);
        public static final BackgroundType PDF = new BackgroundType("PDF", 2);
        public static final BackgroundType COLOR = new BackgroundType("COLOR", 3);

        private static final /* synthetic */ BackgroundType[] $values() {
            return new BackgroundType[]{NONE, IMAGE, PDF, COLOR};
        }

        static {
            BackgroundType[] backgroundTypeArr$values = $values();
            $VALUES = backgroundTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(backgroundTypeArr$values);
        }

        private BackgroundType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<BackgroundType> getEntries() {
            return $ENTRIES;
        }

        public static BackgroundType valueOf(String str) {
            return (BackgroundType) Enum.valueOf(BackgroundType.class, str);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) $VALUES.clone();
        }
    }

    private Constant() {
    }

    @NotNull
    public final List<String> getKEYS_FOR_DYNAMIC_TEMPLATE_COMMON() {
        return KEYS_FOR_DYNAMIC_TEMPLATE_COMMON;
    }

    @NotNull
    public final List<String> getKEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT() {
        return KEYS_FOR_DYNAMIC_TEMPLATE_IMAGE_OBJECT;
    }

    @NotNull
    public final List<String> getKEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID() {
        return KEYS_FOR_DYNAMIC_TEMPLATE_OBJECT_ID;
    }

    @NotNull
    public final List<String> getKEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT() {
        return KEYS_FOR_DYNAMIC_TEMPLATE_TEXT_OBJECT;
    }
}
