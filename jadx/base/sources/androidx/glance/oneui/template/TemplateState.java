package androidx.glance.oneui.template;

import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.oneui.common.AppWidgetConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001d"}, m13886d2 = {"Landroidx/glance/oneui/template/TemplateState;", "", "iconLabelOn", "", "widgetLabelOn", "showShadow", "hasTitleBar", "(ZZZZ)V", "allLabelOnOrOff", "getAllLabelOnOrOff", "()Z", "getHasTitleBar", "setHasTitleBar", "(Z)V", "getIconLabelOn", "getShowShadow", "getWidgetLabelOn", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class TemplateState {
    private boolean hasTitleBar;
    private final boolean iconLabelOn;
    private final boolean showShadow;
    private final boolean widgetLabelOn;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/TemplateState$Companion;", "", "()V", "get", "Landroidx/glance/oneui/template/TemplateState;", "options", "Landroid/os/Bundle;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TemplateState get(@NotNull Bundle options) {
            Intrinsics.checkNotNullParameter(options, "options");
            return new TemplateState(options.getBoolean(AppWidgetConstants.OPTION_APPWIDGET_ICON_LABEL_ON, true), options.getBoolean(AppWidgetConstants.OPTION_APPWIDGET_WIDGET_LABEL_ON, false), options.getBoolean(AppWidgetConstants.OPTION_APPWIDGET_STYLE_SHOW_SHADOW, false), false, 8, null);
        }

        private Companion() {
        }
    }

    public TemplateState() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ TemplateState copy$default(TemplateState templateState, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = templateState.iconLabelOn;
        }
        if ((i & 2) != 0) {
            z2 = templateState.widgetLabelOn;
        }
        if ((i & 4) != 0) {
            z3 = templateState.showShadow;
        }
        if ((i & 8) != 0) {
            z4 = templateState.hasTitleBar;
        }
        return templateState.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIconLabelOn() {
        return this.iconLabelOn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getWidgetLabelOn() {
        return this.widgetLabelOn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowShadow() {
        return this.showShadow;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasTitleBar() {
        return this.hasTitleBar;
    }

    @NotNull
    public final TemplateState copy(boolean iconLabelOn, boolean widgetLabelOn, boolean showShadow, boolean hasTitleBar) {
        return new TemplateState(iconLabelOn, widgetLabelOn, showShadow, hasTitleBar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateState)) {
            return false;
        }
        TemplateState templateState = (TemplateState) other;
        return this.iconLabelOn == templateState.iconLabelOn && this.widgetLabelOn == templateState.widgetLabelOn && this.showShadow == templateState.showShadow && this.hasTitleBar == templateState.hasTitleBar;
    }

    public final boolean getAllLabelOnOrOff() {
        boolean z = this.iconLabelOn;
        if (z) {
            return z && this.widgetLabelOn;
        }
        return true;
    }

    public final boolean getHasTitleBar() {
        return this.hasTitleBar;
    }

    public final boolean getIconLabelOn() {
        return this.iconLabelOn;
    }

    public final boolean getShowShadow() {
        return this.showShadow;
    }

    public final boolean getWidgetLabelOn() {
        return this.widgetLabelOn;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hasTitleBar) + AbstractC0622a.m1160f(this.showShadow, AbstractC0622a.m1160f(this.widgetLabelOn, Boolean.hashCode(this.iconLabelOn) * 31, 31), 31);
    }

    public final void setHasTitleBar(boolean z) {
        this.hasTitleBar = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.iconLabelOn;
        boolean z2 = this.widgetLabelOn;
        boolean z3 = this.showShadow;
        boolean z4 = this.hasTitleBar;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("TemplateState(iconLabelOn=", ", widgetLabelOn=", ", showShadow=", z, z2);
        sbM2230u.append(z3);
        sbM2230u.append(", hasTitleBar=");
        sbM2230u.append(z4);
        sbM2230u.append(")");
        return sbM2230u.toString();
    }

    public TemplateState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.iconLabelOn = z;
        this.widgetLabelOn = z2;
        this.showShadow = z3;
        this.hasTitleBar = z4;
    }

    public /* synthetic */ TemplateState(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
