package androidx.glance.oneui.template.preview;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.oneui.common.AppWidgetSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/PreviewGlanceState;", "", "state", "", "Landroidx/glance/oneui/common/AppWidgetSize;", "Landroidx/datastore/preferences/core/Preferences;", "(Ljava/util/Map;)V", "getState", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class PreviewGlanceState {
    public static final int $stable = 8;

    @NotNull
    private final Map<AppWidgetSize, Preferences> state;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewGlanceState(@NotNull Map<AppWidgetSize, ? extends Preferences> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewGlanceState copy$default(PreviewGlanceState previewGlanceState, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = previewGlanceState.state;
        }
        return previewGlanceState.copy(map);
    }

    @NotNull
    public final Map<AppWidgetSize, Preferences> component1() {
        return this.state;
    }

    @NotNull
    public final PreviewGlanceState copy(@NotNull Map<AppWidgetSize, ? extends Preferences> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new PreviewGlanceState(state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PreviewGlanceState) && Intrinsics.areEqual(this.state, ((PreviewGlanceState) other).state);
    }

    @NotNull
    public final Map<AppWidgetSize, Preferences> getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreviewGlanceState(state=" + this.state + ")";
    }
}
