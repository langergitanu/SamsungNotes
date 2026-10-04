package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paAction;", "", "str", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "C2PA_COLOR_ADJUSTMENTS", "C2PA_CONVERTED", "C2PA_COPIED", "C2PA_CREATED", "C2PA_CROPPED", "C2PA_DELETED", "C2PA_DRAWING", "C2PA_EDITED", "C2PA_EDITED_METADATA", "C2PA_FILTERED", "C2PA_OPENED", "C2PA_ORIENTATION", "C2PA_FORMATTED", "C2PA_VERSION_UPDATED", "C2PA_PRINTED", "C2PA_PUBLISHED", "C2PA_MANAGED", "C2PA_PRODUCED", "C2PA_RESIZED", "C2PA_SAVED", "C2PA_TRANSCODED", "C2PA_REPACKAGED", "C2PA_PLACED", "C2PA_REDACTED", "C2PA_REMOVED", "C2PA_UNKNOWN", "C2PA_WATERMARKED", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class C2paAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ C2paAction[] $VALUES;

    @NotNull
    private final String str;
    public static final C2paAction C2PA_COLOR_ADJUSTMENTS = new C2paAction("C2PA_COLOR_ADJUSTMENTS", 0, "c2pa.color_adjustments");
    public static final C2paAction C2PA_CONVERTED = new C2paAction("C2PA_CONVERTED", 1, "c2pa.converted");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_COPIED = new C2paAction("C2PA_COPIED", 2, "c2pa.copied");
    public static final C2paAction C2PA_CREATED = new C2paAction("C2PA_CREATED", 3, "c2pa.created");
    public static final C2paAction C2PA_CROPPED = new C2paAction("C2PA_CROPPED", 4, "c2pa.cropped");
    public static final C2paAction C2PA_DELETED = new C2paAction("C2PA_DELETED", 5, "c2pa.deleted");
    public static final C2paAction C2PA_DRAWING = new C2paAction("C2PA_DRAWING", 6, "c2pa.drawing");
    public static final C2paAction C2PA_EDITED = new C2paAction("C2PA_EDITED", 7, "c2pa.edited");
    public static final C2paAction C2PA_EDITED_METADATA = new C2paAction("C2PA_EDITED_METADATA", 8, "c2pa.edited.metadata");
    public static final C2paAction C2PA_FILTERED = new C2paAction("C2PA_FILTERED", 9, "c2pa.filtered");
    public static final C2paAction C2PA_OPENED = new C2paAction("C2PA_OPENED", 10, "c2pa.opened");
    public static final C2paAction C2PA_ORIENTATION = new C2paAction("C2PA_ORIENTATION", 11, "c2pa.orientation");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_FORMATTED = new C2paAction("C2PA_FORMATTED", 12, "c2pa.formatted");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_VERSION_UPDATED = new C2paAction("C2PA_VERSION_UPDATED", 13, "c2pa.version_updated");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_PRINTED = new C2paAction("C2PA_PRINTED", 14, "c2pa.printed");
    public static final C2paAction C2PA_PUBLISHED = new C2paAction("C2PA_PUBLISHED", 15, "c2pa.published");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_MANAGED = new C2paAction("C2PA_MANAGED", 16, "c2pa.managed");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_PRODUCED = new C2paAction("C2PA_PRODUCED", 17, "c2pa.produced");
    public static final C2paAction C2PA_RESIZED = new C2paAction("C2PA_RESIZED", 18, "c2pa.resized");

    @Deprecated(message = "Deprecated in C2PA 2.0")
    public static final C2paAction C2PA_SAVED = new C2paAction("C2PA_SAVED", 19, "c2pa.saved");
    public static final C2paAction C2PA_TRANSCODED = new C2paAction("C2PA_TRANSCODED", 20, "c2pa.transcoded");
    public static final C2paAction C2PA_REPACKAGED = new C2paAction("C2PA_REPACKAGED", 21, "c2pa.repackaged");
    public static final C2paAction C2PA_PLACED = new C2paAction("C2PA_PLACED", 22, "c2pa.placed");
    public static final C2paAction C2PA_REDACTED = new C2paAction("C2PA_REDACTED", 23, "c2pa.redacted");
    public static final C2paAction C2PA_REMOVED = new C2paAction("C2PA_REMOVED", 24, "c2pa.removed");
    public static final C2paAction C2PA_UNKNOWN = new C2paAction("C2PA_UNKNOWN", 25, "c2pa.unknown");
    public static final C2paAction C2PA_WATERMARKED = new C2paAction("C2PA_WATERMARKED", 26, "c2pa.watermarked");

    private static final /* synthetic */ C2paAction[] $values() {
        return new C2paAction[]{C2PA_COLOR_ADJUSTMENTS, C2PA_CONVERTED, C2PA_COPIED, C2PA_CREATED, C2PA_CROPPED, C2PA_DELETED, C2PA_DRAWING, C2PA_EDITED, C2PA_EDITED_METADATA, C2PA_FILTERED, C2PA_OPENED, C2PA_ORIENTATION, C2PA_FORMATTED, C2PA_VERSION_UPDATED, C2PA_PRINTED, C2PA_PUBLISHED, C2PA_MANAGED, C2PA_PRODUCED, C2PA_RESIZED, C2PA_SAVED, C2PA_TRANSCODED, C2PA_REPACKAGED, C2PA_PLACED, C2PA_REDACTED, C2PA_REMOVED, C2PA_UNKNOWN, C2PA_WATERMARKED};
    }

    static {
        C2paAction[] c2paActionArr$values = $values();
        $VALUES = c2paActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(c2paActionArr$values);
    }

    private C2paAction(String str, int i, String str2) {
        this.str = str2;
    }

    @NotNull
    public static EnumEntries<C2paAction> getEntries() {
        return $ENTRIES;
    }

    public static C2paAction valueOf(String str) {
        return (C2paAction) Enum.valueOf(C2paAction.class, str);
    }

    public static C2paAction[] values() {
        return (C2paAction[]) $VALUES.clone();
    }

    @NotNull
    public final String getStr() {
        return this.str;
    }
}
