package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.oneui.template.color.ColorProviderUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/oneui/template/CheckBoxListItem;", "Landroidx/glance/oneui/template/ListItem;", "mainText", "Landroidx/glance/oneui/template/TypedTextData;", "subText", "checked", "", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;ZLjava/lang/String;Landroidx/glance/action/Action;)V", "getChecked", "()Z", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class CheckBoxListItem extends ListItem {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ImageWithBackgroundData checkedCheckBox;

    @NotNull
    private static final ImageWithBackgroundData uncheckedCheckBox;
    private final boolean checked;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/template/CheckBoxListItem$Companion;", "", "()V", "checkedCheckBox", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getCheckedCheckBox", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "uncheckedCheckBox", "getUncheckedCheckBox", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageWithBackgroundData getCheckedCheckBox() {
            return CheckBoxListItem.checkedCheckBox;
        }

        @NotNull
        public final ImageWithBackgroundData getUncheckedCheckBox() {
            return CheckBoxListItem.uncheckedCheckBox;
        }

        private Companion() {
        }
    }

    static {
        ImageType imageType = ImageType.Image;
        ImageProvider ImageProvider = ImageKt.ImageProvider(C3094R.drawable.sesl_glance_checkbox_checked);
        ColorProviderUtils.Companion companion = ColorProviderUtils.INSTANCE;
        checkedCheckBox = new ImageWithBackgroundData(ImageProvider, "", imageType, companion.getTransparent(), 0, null, null, false, 240, null);
        uncheckedCheckBox = new ImageWithBackgroundData(ImageKt.ImageProvider(C3094R.drawable.sesl_glance_checkbox_unchecked), "", imageType, companion.getTransparent(), 0, null, null, false, 240, null);
    }

    public /* synthetic */ CheckBoxListItem(TypedTextData typedTextData, TypedTextData typedTextData2, boolean z, String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextData, (i & 2) != 0 ? null : typedTextData2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : action);
    }

    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxListItem(@NotNull TypedTextData mainText, @Nullable TypedTextData typedTextData, boolean z, @Nullable String str, @Nullable Action action) {
        super(new LeadingContentData(z ? checkedCheckBox : uncheckedCheckBox), mainText, typedTextData, str, action);
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        this.checked = z;
    }
}
