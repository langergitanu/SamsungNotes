package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/appwidget/CheckBoxColorsImpl;", "Landroidx/glance/appwidget/CheckBoxColors;", "checkBox", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "(Landroidx/glance/appwidget/unit/CheckableColorProvider;)V", "getCheckBox$glance_appwidget_release", "()Landroidx/glance/appwidget/unit/CheckableColorProvider;", "component1", "component1$glance_appwidget_release", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class CheckBoxColorsImpl extends CheckBoxColors {
    public static final int $stable = 8;

    @NotNull
    private final CheckableColorProvider checkBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxColorsImpl(@NotNull CheckableColorProvider checkBox) {
        super(null);
        Intrinsics.checkNotNullParameter(checkBox, "checkBox");
        this.checkBox = checkBox;
    }

    public static /* synthetic */ CheckBoxColorsImpl copy$default(CheckBoxColorsImpl checkBoxColorsImpl, CheckableColorProvider checkableColorProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            checkableColorProvider = checkBoxColorsImpl.checkBox;
        }
        return checkBoxColorsImpl.copy(checkableColorProvider);
    }

    @NotNull
    /* JADX INFO: renamed from: component1$glance_appwidget_release, reason: from getter */
    public final CheckableColorProvider getCheckBox() {
        return this.checkBox;
    }

    @NotNull
    public final CheckBoxColorsImpl copy(@NotNull CheckableColorProvider checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "checkBox");
        return new CheckBoxColorsImpl(checkBox);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CheckBoxColorsImpl) && Intrinsics.areEqual(this.checkBox, ((CheckBoxColorsImpl) other).checkBox);
    }

    @Override // androidx.glance.appwidget.CheckBoxColors
    @NotNull
    public CheckableColorProvider getCheckBox$glance_appwidget_release() {
        return this.checkBox;
    }

    public int hashCode() {
        return this.checkBox.hashCode();
    }

    @NotNull
    public String toString() {
        return "CheckBoxColorsImpl(checkBox=" + this.checkBox + ")";
    }
}
