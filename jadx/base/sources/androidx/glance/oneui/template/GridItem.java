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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m13886d2 = {"Landroidx/glance/oneui/template/GridItem;", "", "image", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "text", "Landroidx/glance/oneui/template/TextData;", "textOnImage", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "badge", "Landroidx/glance/oneui/template/BadgeData;", "textOverlapped", "", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/oneui/template/BadgeData;Z)V", "getBadge", "()Landroidx/glance/oneui/template/BadgeData;", "getContentDescription", "()Ljava/lang/String;", "getImage", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getOnClick", "()Landroidx/glance/action/Action;", "setOnClick", "(Landroidx/glance/action/Action;)V", "getText", "()Landroidx/glance/oneui/template/TextData;", "getTextOnImage", "getTextOverlapped", "()Z", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class GridItem {
    public static final int $stable = 8;

    @Nullable
    private final BadgeData badge;

    @Nullable
    private final String contentDescription;

    @NotNull
    private final ImageWithBackgroundData image;

    @Nullable
    private Action onClick;

    @Nullable
    private final TextData text;

    @Nullable
    private final TextData textOnImage;
    private final boolean textOverlapped;

    public GridItem(@NotNull ImageWithBackgroundData image, @Nullable TextData textData, @Nullable TextData textData2, @Nullable String str, @Nullable Action action, @Nullable BadgeData badgeData, boolean z) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.text = textData;
        this.textOnImage = textData2;
        this.contentDescription = str;
        this.onClick = action;
        this.badge = badgeData;
        this.textOverlapped = z;
    }

    @Nullable
    public final BadgeData getBadge() {
        return this.badge;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @NotNull
    public final ImageWithBackgroundData getImage() {
        return this.image;
    }

    @Nullable
    public final Action getOnClick() {
        return this.onClick;
    }

    @Nullable
    public final TextData getText() {
        return this.text;
    }

    @Nullable
    public final TextData getTextOnImage() {
        return this.textOnImage;
    }

    public final boolean getTextOverlapped() {
        return this.textOverlapped;
    }

    public final void setOnClick(@Nullable Action action) {
        this.onClick = action;
    }

    public /* synthetic */ GridItem(ImageWithBackgroundData imageWithBackgroundData, TextData textData, TextData textData2, String str, Action action, BadgeData badgeData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageWithBackgroundData, (i & 2) != 0 ? null : textData, (i & 4) != 0 ? null : textData2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : action, (i & 32) != 0 ? null : badgeData, (i & 64) != 0 ? false : z);
    }
}
