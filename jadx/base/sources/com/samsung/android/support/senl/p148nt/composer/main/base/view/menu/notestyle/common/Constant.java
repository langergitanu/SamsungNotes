package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant;", "", "<init>", "()V", "KEY_GRAVITY", "", "KEY_TYPE", "KEY_IS_COEDIT_NOTE", "PreviewType", PackageRelationship.TYPE_ATTRIBUTE_NAME, "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constant {

    @NotNull
    public static final Constant INSTANCE = new Constant();

    @NotNull
    public static final String KEY_GRAVITY = "key_gravity";

    @NotNull
    public static final String KEY_IS_COEDIT_NOTE = "key_is_coedit_note";

    @NotNull
    public static final String KEY_TYPE = "key_type";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$PreviewType;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE", "COVER", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PreviewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PreviewType[] $VALUES;
        public static final PreviewType PAGE = new PreviewType("PAGE", 0);
        public static final PreviewType COVER = new PreviewType("COVER", 1);

        private static final /* synthetic */ PreviewType[] $values() {
            return new PreviewType[]{PAGE, COVER};
        }

        static {
            PreviewType[] previewTypeArr$values = $values();
            $VALUES = previewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(previewTypeArr$values);
        }

        private PreviewType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PreviewType> getEntries() {
            return $ENTRIES;
        }

        public static PreviewType valueOf(String str) {
            return (PreviewType) Enum.valueOf(PreviewType.class, str);
        }

        public static PreviewType[] values() {
            return (PreviewType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_NOTE", "STYLE_CHANGE", "COVER_EDIT", "TEMPLATE_PICKER", "SETTINGS", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type CREATE_NOTE = new Type("CREATE_NOTE", 0);
        public static final Type STYLE_CHANGE = new Type("STYLE_CHANGE", 1);
        public static final Type COVER_EDIT = new Type("COVER_EDIT", 2);
        public static final Type TEMPLATE_PICKER = new Type("TEMPLATE_PICKER", 3);
        public static final Type SETTINGS = new Type("SETTINGS", 4);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CREATE_NOTE, STYLE_CHANGE, COVER_EDIT, TEMPLATE_PICKER, SETTINGS};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    private Constant() {
    }
}
