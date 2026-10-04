package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/ContentScale;", "", "(Ljava/lang/String;I)V", "Tiny", "Small", "Medium", "Large", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ContentScale {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ContentScale[] $VALUES;
    public static final ContentScale Tiny = new ContentScale("Tiny", 0);
    public static final ContentScale Small = new ContentScale("Small", 1);
    public static final ContentScale Medium = new ContentScale("Medium", 2);
    public static final ContentScale Large = new ContentScale("Large", 3);

    private static final /* synthetic */ ContentScale[] $values() {
        return new ContentScale[]{Tiny, Small, Medium, Large};
    }

    static {
        ContentScale[] contentScaleArr$values = $values();
        $VALUES = contentScaleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(contentScaleArr$values);
    }

    private ContentScale(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ContentScale> getEntries() {
        return $ENTRIES;
    }

    public static ContentScale valueOf(String str) {
        return (ContentScale) Enum.valueOf(ContentScale.class, str);
    }

    public static ContentScale[] values() {
        return (ContentScale[]) $VALUES.clone();
    }
}
