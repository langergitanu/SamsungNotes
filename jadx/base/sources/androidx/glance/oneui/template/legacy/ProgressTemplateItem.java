package androidx.glance.oneui.template.legacy;

import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ProgressType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/oneui/template/legacy/ProgressTemplateItem;", "", "value", "", "type", "Landroidx/glance/oneui/template/ProgressType;", "icon", "Landroidx/glance/oneui/template/ImageData;", "text", "", "(FLandroidx/glance/oneui/template/ProgressType;Landroidx/glance/oneui/template/ImageData;Ljava/lang/String;)V", "getIcon", "()Landroidx/glance/oneui/template/ImageData;", "getText", "()Ljava/lang/String;", "getType", "()Landroidx/glance/oneui/template/ProgressType;", "getValue", "()F", "equals", "", "other", "hashCode", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ProgressTemplateItem {
    public static final int $stable = 8;

    @Nullable
    private final ImageData icon;

    @Nullable
    private final String text;

    @NotNull
    private final ProgressType type;
    private final float value;

    public ProgressTemplateItem(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @NotNull ProgressType type, @Nullable ImageData imageData, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = f;
        this.type = type;
        this.icon = imageData;
        this.text = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ProgressTemplateItem.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.oneui.template.legacy.ProgressTemplateItem");
        ProgressTemplateItem progressTemplateItem = (ProgressTemplateItem) other;
        return this.type == progressTemplateItem.type && Intrinsics.areEqual(this.icon, progressTemplateItem.icon) && Intrinsics.areEqual(this.text, progressTemplateItem.text);
    }

    @Nullable
    public final ImageData getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final ProgressType getType() {
        return this.type;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        ImageData imageData = this.icon;
        int iHashCode2 = (iHashCode + (imageData != null ? imageData.hashCode() : 0)) * 31;
        String str = this.text;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public /* synthetic */ ProgressTemplateItem(float f, ProgressType progressType, ImageData imageData, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? ProgressType.Circular : progressType, (i & 4) != 0 ? null : imageData, (i & 8) != 0 ? null : str);
    }
}
