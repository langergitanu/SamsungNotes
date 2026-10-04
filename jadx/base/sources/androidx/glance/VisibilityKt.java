package androidx.glance;

import androidx.annotation.IntegerRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m13886d2 = {"visibility", "Landroidx/glance/GlanceModifier;", "Landroidx/glance/Visibility;", "visibilityResId", "", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VisibilityKt {
    @NotNull
    public static final GlanceModifier visibility(@NotNull GlanceModifier glanceModifier, @NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return glanceModifier.then(new VisibilityModifier(visibility, 0, 2, null));
    }

    @NotNull
    public static final GlanceModifier visibility(@NotNull GlanceModifier glanceModifier, @IntegerRes int i) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(new VisibilityModifier(Visibility.Visible, i));
    }
}
