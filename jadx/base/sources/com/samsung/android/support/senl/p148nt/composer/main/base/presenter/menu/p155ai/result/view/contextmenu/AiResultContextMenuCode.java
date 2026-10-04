package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCode;", "", "<init>", "(Ljava/lang/String;I)V", "CONTEXT_MENU_ID_CUT", "CONTEXT_MENU_ID_COPY", "CONTEXT_MENU_ID_PASTE", "CONTEXT_MENU_ID_SELECT_ALL", "CONTEXT_MENU_ID_CLIPBOARD", "CONTEXT_MENU_ID_SHARE", "CONTEXT_MENU_ID_NONE", "getId", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultContextMenuCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AiResultContextMenuCode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_CUT = new AiResultContextMenuCode("CONTEXT_MENU_ID_CUT", 0);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_COPY = new AiResultContextMenuCode("CONTEXT_MENU_ID_COPY", 1);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_PASTE = new AiResultContextMenuCode("CONTEXT_MENU_ID_PASTE", 2);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_SELECT_ALL = new AiResultContextMenuCode("CONTEXT_MENU_ID_SELECT_ALL", 3);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_CLIPBOARD = new AiResultContextMenuCode("CONTEXT_MENU_ID_CLIPBOARD", 4);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_SHARE = new AiResultContextMenuCode("CONTEXT_MENU_ID_SHARE", 5);
    public static final AiResultContextMenuCode CONTEXT_MENU_ID_NONE = new AiResultContextMenuCode("CONTEXT_MENU_ID_NONE", 6);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCode$Companion;", "", "<init>", "()V", "get", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/contextmenu/AiResultContextMenuCode;", "id", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AiResultContextMenuCode get(int id) {
            for (AiResultContextMenuCode aiResultContextMenuCode : AiResultContextMenuCode.getEntries()) {
                if (aiResultContextMenuCode.ordinal() == id) {
                    return aiResultContextMenuCode;
                }
            }
            return AiResultContextMenuCode.CONTEXT_MENU_ID_NONE;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AiResultContextMenuCode[] $values() {
        return new AiResultContextMenuCode[]{CONTEXT_MENU_ID_CUT, CONTEXT_MENU_ID_COPY, CONTEXT_MENU_ID_PASTE, CONTEXT_MENU_ID_SELECT_ALL, CONTEXT_MENU_ID_CLIPBOARD, CONTEXT_MENU_ID_SHARE, CONTEXT_MENU_ID_NONE};
    }

    static {
        AiResultContextMenuCode[] aiResultContextMenuCodeArr$values = $values();
        $VALUES = aiResultContextMenuCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aiResultContextMenuCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private AiResultContextMenuCode(String str, int i) {
    }

    @NotNull
    public static EnumEntries<AiResultContextMenuCode> getEntries() {
        return $ENTRIES;
    }

    public static AiResultContextMenuCode valueOf(String str) {
        return (AiResultContextMenuCode) Enum.valueOf(AiResultContextMenuCode.class, str);
    }

    public static AiResultContextMenuCode[] values() {
        return (AiResultContextMenuCode[]) $VALUES.clone();
    }

    public final int getId() {
        return ordinal();
    }
}
