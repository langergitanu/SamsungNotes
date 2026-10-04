package com.samsung.android.support.senl.p148nt.base.common.constants;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/DynamicTemplateConstant;", "", "<init>", "()V", "DYNAMIC_TEMPLATE_VERSION", "", "DYNAMIC_TEMPLATE_INVALID_VERSION", "DYNAMIC_TEMPLATE_POST_FIX", "", "TemplateType", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplateConstant {
    public static final int DYNAMIC_TEMPLATE_INVALID_VERSION = -1;

    @NotNull
    public static final String DYNAMIC_TEMPLATE_POST_FIX = "_DYNAMIC_TEMPLATE";
    public static final int DYNAMIC_TEMPLATE_VERSION = 1;

    @NotNull
    public static final DynamicTemplateConstant INSTANCE = new DynamicTemplateConstant();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/DynamicTemplateConstant$TemplateType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "JOURNAL", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TemplateType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TemplateType[] $VALUES;
        public static final TemplateType NONE = new TemplateType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final TemplateType JOURNAL = new TemplateType("JOURNAL", 1);

        private static final /* synthetic */ TemplateType[] $values() {
            return new TemplateType[]{NONE, JOURNAL};
        }

        static {
            TemplateType[] templateTypeArr$values = $values();
            $VALUES = templateTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(templateTypeArr$values);
        }

        private TemplateType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TemplateType> getEntries() {
            return $ENTRIES;
        }

        public static TemplateType valueOf(String str) {
            return (TemplateType) Enum.valueOf(TemplateType.class, str);
        }

        public static TemplateType[] values() {
            return (TemplateType[]) $VALUES.clone();
        }
    }

    private DynamicTemplateConstant() {
    }
}
