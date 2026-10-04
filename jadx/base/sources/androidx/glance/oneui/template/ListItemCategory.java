package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/template/ListItemCategory;", "Landroidx/glance/oneui/template/ListItem;", "title", "Landroidx/glance/oneui/template/TextData;", "(Landroidx/glance/oneui/template/TextData;)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ListItemCategory extends ListItem {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemCategory(@NotNull TextData title) {
        super(TypedTextData.INSTANCE.m21697valueOf6zbYUVM(title, TextType.INSTANCE.m21689getBodygxbDmow()), (TypedTextData) null, (ImageWithBackgroundData) null, (String) null, (Action) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(title, "title");
    }
}
