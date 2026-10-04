package androidx.glance.oneui.template.legacy;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.template.ImageData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Deprecated(message = "It is provided only for One UI 6.x. It is not displayed normally on the device other than One UI 6.x. For a guide to template for One UI 7, refer to wiki page [One UI 7 App Widget Provider].")
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/oneui/template/legacy/SimpleTemplateItem;", "", "icon", "Landroidx/glance/oneui/template/ImageData;", "text1", "", "text2", "text3", "(Landroidx/glance/oneui/template/ImageData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Landroidx/glance/oneui/template/ImageData;", "getText1", "()Ljava/lang/String;", "getText2", "getText3", "equals", "", "other", "hashCode", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SimpleTemplateItem {
    public static final int $stable = 8;

    @Nullable
    private final ImageData icon;

    @Nullable
    private final String text1;

    @Nullable
    private final String text2;

    @Nullable
    private final String text3;

    public SimpleTemplateItem() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(SimpleTemplateItem.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.oneui.template.legacy.SimpleTemplateItem");
        SimpleTemplateItem simpleTemplateItem = (SimpleTemplateItem) other;
        return Intrinsics.areEqual(this.icon, simpleTemplateItem.icon) && Intrinsics.areEqual(this.text1, simpleTemplateItem.text1) && Intrinsics.areEqual(this.text2, simpleTemplateItem.text2) && Intrinsics.areEqual(this.text3, simpleTemplateItem.text3);
    }

    @Nullable
    public final ImageData getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getText1() {
        return this.text1;
    }

    @Nullable
    public final String getText2() {
        return this.text2;
    }

    @Nullable
    public final String getText3() {
        return this.text3;
    }

    public int hashCode() {
        ImageData imageData = this.icon;
        int iHashCode = (imageData != null ? imageData.hashCode() : 0) * 31;
        String str = this.text1;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text2;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text3;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public SimpleTemplateItem(@Nullable ImageData imageData, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.icon = imageData;
        this.text1 = str;
        this.text2 = str2;
        this.text3 = str3;
    }

    public /* synthetic */ SimpleTemplateItem(ImageData imageData, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
