package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCode;", "", "<init>", "(Ljava/lang/String;I)V", "CONTEXT_MENU_ID_FIRST", "CONTEXT_MENU_ID_CUT", "CONTEXT_MENU_ID_COPY", "CONTEXT_MENU_ID_PASTE", "CONTEXT_MENU_ID_OBJECT_DELETE", "CONTEXT_MENU_ID_SELECT_ALL", "CONTEXT_MENU_ID_CLIPBOARD", "CONTEXT_MENU_ID_SHARE", "CONTEXT_MENU_ID_NONE", "getId", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmContextMenuCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmContextMenuCode[] $VALUES;
    public static final int CONTEXT_MENU_ID_FIRST_ITEM = 16908353;
    public static final int CONTEXT_MENU_ID_SECONDARY_ASSIST_ACTIONS_START = 100;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final SmContextMenuCode CONTEXT_MENU_ID_FIRST = new SmContextMenuCode("CONTEXT_MENU_ID_FIRST", 0);
    public static final SmContextMenuCode CONTEXT_MENU_ID_CUT = new SmContextMenuCode("CONTEXT_MENU_ID_CUT", 1);
    public static final SmContextMenuCode CONTEXT_MENU_ID_COPY = new SmContextMenuCode("CONTEXT_MENU_ID_COPY", 2);
    public static final SmContextMenuCode CONTEXT_MENU_ID_PASTE = new SmContextMenuCode("CONTEXT_MENU_ID_PASTE", 3);
    public static final SmContextMenuCode CONTEXT_MENU_ID_OBJECT_DELETE = new SmContextMenuCode("CONTEXT_MENU_ID_OBJECT_DELETE", 4);
    public static final SmContextMenuCode CONTEXT_MENU_ID_SELECT_ALL = new SmContextMenuCode("CONTEXT_MENU_ID_SELECT_ALL", 5);
    public static final SmContextMenuCode CONTEXT_MENU_ID_CLIPBOARD = new SmContextMenuCode("CONTEXT_MENU_ID_CLIPBOARD", 6);
    public static final SmContextMenuCode CONTEXT_MENU_ID_SHARE = new SmContextMenuCode("CONTEXT_MENU_ID_SHARE", 7);
    public static final SmContextMenuCode CONTEXT_MENU_ID_NONE = new SmContextMenuCode("CONTEXT_MENU_ID_NONE", 8);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCode$Companion;", "", "<init>", "()V", "CONTEXT_MENU_ID_FIRST_ITEM", "", "CONTEXT_MENU_ID_SECONDARY_ASSIST_ACTIONS_START", "get", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuCode;", "id", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SmContextMenuCode get(int id) {
            for (SmContextMenuCode smContextMenuCode : SmContextMenuCode.getEntries()) {
                if (smContextMenuCode.ordinal() == id) {
                    return smContextMenuCode;
                }
            }
            return SmContextMenuCode.CONTEXT_MENU_ID_NONE;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SmContextMenuCode[] $values() {
        return new SmContextMenuCode[]{CONTEXT_MENU_ID_FIRST, CONTEXT_MENU_ID_CUT, CONTEXT_MENU_ID_COPY, CONTEXT_MENU_ID_PASTE, CONTEXT_MENU_ID_OBJECT_DELETE, CONTEXT_MENU_ID_SELECT_ALL, CONTEXT_MENU_ID_CLIPBOARD, CONTEXT_MENU_ID_SHARE, CONTEXT_MENU_ID_NONE};
    }

    static {
        SmContextMenuCode[] smContextMenuCodeArr$values = $values();
        $VALUES = smContextMenuCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(smContextMenuCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private SmContextMenuCode(String str, int i) {
    }

    @NotNull
    public static EnumEntries<SmContextMenuCode> getEntries() {
        return $ENTRIES;
    }

    public static SmContextMenuCode valueOf(String str) {
        return (SmContextMenuCode) Enum.valueOf(SmContextMenuCode.class, str);
    }

    public static SmContextMenuCode[] values() {
        return (SmContextMenuCode[]) $VALUES.clone();
    }

    public final int getId() {
        return ordinal();
    }
}
