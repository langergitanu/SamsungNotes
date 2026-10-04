package androidx.glance.oneui.template;

import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m13886d2 = {"Landroidx/glance/oneui/template/ActionIcon;", "", "imageProvider", "Landroidx/glance/ImageProvider;", "(Ljava/lang/String;ILandroidx/glance/ImageProvider;)V", "getImageProvider", "()Landroidx/glance/ImageProvider;", "Add", HttpHeaders.REFRESH, "MoreOptions", "Previous", "Next", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ActionIcon {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActionIcon[] $VALUES;

    @NotNull
    private final ImageProvider imageProvider;
    public static final ActionIcon Add = new ActionIcon("Add", 0, ImageKt.ImageProvider(C3094R.drawable.sesl_glance_ic_add));
    public static final ActionIcon Refresh = new ActionIcon(HttpHeaders.REFRESH, 1, ImageKt.ImageProvider(C3094R.drawable.sesl_glance_ic_refresh));
    public static final ActionIcon MoreOptions = new ActionIcon("MoreOptions", 2, ImageKt.ImageProvider(C3094R.drawable.sesl_glance_ic_more));
    public static final ActionIcon Previous = new ActionIcon("Previous", 3, ImageKt.ImageProvider(C3094R.drawable.sesl_glance_ic_previous));
    public static final ActionIcon Next = new ActionIcon("Next", 4, ImageKt.ImageProvider(C3094R.drawable.sesl_glance_ic_next));

    private static final /* synthetic */ ActionIcon[] $values() {
        return new ActionIcon[]{Add, Refresh, MoreOptions, Previous, Next};
    }

    static {
        ActionIcon[] actionIconArr$values = $values();
        $VALUES = actionIconArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(actionIconArr$values);
    }

    private ActionIcon(String str, int i, ImageProvider imageProvider) {
        this.imageProvider = imageProvider;
    }

    @NotNull
    public static EnumEntries<ActionIcon> getEntries() {
        return $ENTRIES;
    }

    public static ActionIcon valueOf(String str) {
        return (ActionIcon) Enum.valueOf(ActionIcon.class, str);
    }

    public static ActionIcon[] values() {
        return (ActionIcon[]) $VALUES.clone();
    }

    @NotNull
    public final ImageProvider getImageProvider() {
        return this.imageProvider;
    }
}
