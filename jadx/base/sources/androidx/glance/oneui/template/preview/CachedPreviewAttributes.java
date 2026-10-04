package androidx.glance.oneui.template.preview;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DisplayDeviceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u0016\u0010\u0015\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\fJ\u0016\u0010\u0017\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/CachedPreviewAttributes;", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "widgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "hostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "displayType", "Landroidx/glance/oneui/common/DisplayDeviceType;", "(IIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisplayType-SDhLy5M", "()I", "I", "getHostType-mn_SBp8", "getWidgetSize-rx25Pp4", "getWidgetStyle-WOdBnnM", "component1", "component1-rx25Pp4", "component2", "component2-WOdBnnM", "component3", "component3-mn_SBp8", "component4", "component4-SDhLy5M", "copy", "copy--h1ZlBg", "(IIII)Landroidx/glance/oneui/template/preview/CachedPreviewAttributes;", "equals", "", "other", "hashCode", "", "toString", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class CachedPreviewAttributes {
    public static final int $stable = 0;
    private final int displayType;
    private final int hostType;
    private final int widgetSize;
    private final int widgetStyle;

    public /* synthetic */ CachedPreviewAttributes(int i, int i2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: copy--h1ZlBg$default, reason: not valid java name */
    public static /* synthetic */ CachedPreviewAttributes m21914copyh1ZlBg$default(CachedPreviewAttributes cachedPreviewAttributes, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = cachedPreviewAttributes.widgetSize;
        }
        if ((i6 & 2) != 0) {
            i2 = cachedPreviewAttributes.widgetStyle;
        }
        if ((i6 & 4) != 0) {
            i4 = cachedPreviewAttributes.hostType;
        }
        if ((i6 & 8) != 0) {
            i5 = cachedPreviewAttributes.displayType;
        }
        return cachedPreviewAttributes.m21919copyh1ZlBg(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: component1-rx25Pp4, reason: not valid java name and from getter */
    public final int getWidgetSize() {
        return this.widgetSize;
    }

    /* JADX INFO: renamed from: component2-WOdBnnM, reason: not valid java name and from getter */
    public final int getWidgetStyle() {
        return this.widgetStyle;
    }

    /* JADX INFO: renamed from: component3-mn_SBp8, reason: not valid java name and from getter */
    public final int getHostType() {
        return this.hostType;
    }

    /* JADX INFO: renamed from: component4-SDhLy5M, reason: not valid java name and from getter */
    public final int getDisplayType() {
        return this.displayType;
    }

    @NotNull
    /* JADX INFO: renamed from: copy--h1ZlBg, reason: not valid java name */
    public final CachedPreviewAttributes m21919copyh1ZlBg(int widgetSize, int widgetStyle, int hostType, int displayType) {
        return new CachedPreviewAttributes(widgetSize, widgetStyle, hostType, displayType, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CachedPreviewAttributes)) {
            return false;
        }
        CachedPreviewAttributes cachedPreviewAttributes = (CachedPreviewAttributes) other;
        return AppWidgetSize.m21550equalsimpl0(this.widgetSize, cachedPreviewAttributes.widgetSize) && AppWidgetStyle.m21578equalsimpl0(this.widgetStyle, cachedPreviewAttributes.widgetStyle) && AppWidgetHostType.m21524equalsimpl0(this.hostType, cachedPreviewAttributes.hostType) && DisplayDeviceType.m21594equalsimpl0(this.displayType, cachedPreviewAttributes.displayType);
    }

    /* JADX INFO: renamed from: getDisplayType-SDhLy5M, reason: not valid java name */
    public final int m21920getDisplayTypeSDhLy5M() {
        return this.displayType;
    }

    /* JADX INFO: renamed from: getHostType-mn_SBp8, reason: not valid java name */
    public final int m21921getHostTypemn_SBp8() {
        return this.hostType;
    }

    /* JADX INFO: renamed from: getWidgetSize-rx25Pp4, reason: not valid java name */
    public final int m21922getWidgetSizerx25Pp4() {
        return this.widgetSize;
    }

    /* JADX INFO: renamed from: getWidgetStyle-WOdBnnM, reason: not valid java name */
    public final int m21923getWidgetStyleWOdBnnM() {
        return this.widgetStyle;
    }

    public int hashCode() {
        return DisplayDeviceType.m21595hashCodeimpl(this.displayType) + ((AppWidgetHostType.m21525hashCodeimpl(this.hostType) + ((AppWidgetStyle.m21579hashCodeimpl(this.widgetStyle) + (AppWidgetSize.m21551hashCodeimpl(this.widgetSize) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(this.widgetSize);
        String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(this.widgetStyle);
        return AbstractC0541b.m776r(AbstractC0000a.m16m("CachedPreviewAttributes(widgetSize=", strM21559toStringimpl, ", widgetStyle=", strM21583toStringimpl, ", hostType="), AppWidgetHostType.m21529toStringimpl(this.hostType), ", displayType=", DisplayDeviceType.m21599toStringimpl(this.displayType), ")");
    }

    private CachedPreviewAttributes(int i, int i2, int i4, int i5) {
        this.widgetSize = i;
        this.widgetStyle = i2;
        this.hostType = i4;
        this.displayType = i5;
    }
}
