package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB;\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/oneui/template/ListItem;", "", "mainText", "Landroidx/glance/oneui/template/TypedTextData;", "subText", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/ImageWithBackgroundData;Ljava/lang/String;Landroidx/glance/action/Action;)V", "leadingContentData", "Landroidx/glance/oneui/template/LeadingContentData;", "(Landroidx/glance/oneui/template/LeadingContentData;Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/oneui/template/TypedTextData;Ljava/lang/String;Landroidx/glance/action/Action;)V", "getContentDescription", "()Ljava/lang/String;", "getLeadingContentData", "()Landroidx/glance/oneui/template/LeadingContentData;", "getMainText", "()Landroidx/glance/oneui/template/TypedTextData;", "getOnClick", "()Landroidx/glance/action/Action;", "getSubText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class ListItem {
    public static final int $stable = 8;

    @Nullable
    private final String contentDescription;

    @Nullable
    private final LeadingContentData leadingContentData;

    @NotNull
    private final TypedTextData mainText;

    @Nullable
    private final Action onClick;

    @Nullable
    private final TypedTextData subText;

    public ListItem(@Nullable LeadingContentData leadingContentData, @NotNull TypedTextData mainText, @Nullable TypedTextData typedTextData, @Nullable String str, @Nullable Action action) {
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        this.leadingContentData = leadingContentData;
        this.mainText = mainText;
        this.subText = typedTextData;
        this.contentDescription = str;
        this.onClick = action;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Nullable
    public final LeadingContentData getLeadingContentData() {
        return this.leadingContentData;
    }

    @NotNull
    public final TypedTextData getMainText() {
        return this.mainText;
    }

    @Nullable
    public final Action getOnClick() {
        return this.onClick;
    }

    @Nullable
    public final TypedTextData getSubText() {
        return this.subText;
    }

    public /* synthetic */ ListItem(LeadingContentData leadingContentData, TypedTextData typedTextData, TypedTextData typedTextData2, String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(leadingContentData, typedTextData, (i & 4) != 0 ? null : typedTextData2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : action);
    }

    public /* synthetic */ ListItem(TypedTextData typedTextData, TypedTextData typedTextData2, ImageWithBackgroundData imageWithBackgroundData, String str, Action action, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typedTextData, (i & 2) != 0 ? null : typedTextData2, (i & 4) != 0 ? null : imageWithBackgroundData, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : action);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListItem(@NotNull TypedTextData mainText, @Nullable TypedTextData typedTextData, @Nullable ImageWithBackgroundData imageWithBackgroundData, @Nullable String str, @Nullable Action action) {
        this(imageWithBackgroundData != null ? new LeadingContentData(imageWithBackgroundData) : null, mainText, typedTextData, str, action);
        Intrinsics.checkNotNullParameter(mainText, "mainText");
    }
}
