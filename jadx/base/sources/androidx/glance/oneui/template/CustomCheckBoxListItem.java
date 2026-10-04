package androidx.glance.oneui.template;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H'¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/oneui/template/CustomCheckBoxListItem;", "Landroidx/glance/oneui/template/ListItem;", "mainText", "Landroidx/glance/oneui/template/TypedTextData;", "subText", "checked", "", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;ZLjava/lang/String;Landroidx/glance/action/Action;)V", "CustomContent", "", "item", "(Landroidx/glance/oneui/template/CustomCheckBoxListItem;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CustomCheckBoxListItem extends ListItem {
    public static final int $stable = 0;

    public /* synthetic */ CustomCheckBoxListItem(TypedTextData typedTextData, TypedTextData typedTextData2, boolean z, String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextData, (i & 2) != 0 ? null : typedTextData2, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : action);
    }

    @Composable
    public abstract void CustomContent(@NotNull CustomCheckBoxListItem customCheckBoxListItem, @Nullable Composer composer, int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCheckBoxListItem(@NotNull TypedTextData mainText, @Nullable TypedTextData typedTextData, boolean z, @Nullable String str, @Nullable Action action) {
        super(mainText, typedTextData, z ? CheckBoxListItem.INSTANCE.getCheckedCheckBox() : CheckBoxListItem.INSTANCE.getUncheckedCheckBox(), str, action);
        Intrinsics.checkNotNullParameter(mainText, "mainText");
    }
}
