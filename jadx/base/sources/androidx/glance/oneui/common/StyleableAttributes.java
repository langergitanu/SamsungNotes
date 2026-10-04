package androidx.glance.oneui.common;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\"\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-.B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\"/0123456789:;<=>?@ABCDEFGHIJKLMNOP¨\u0006Q"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes;", "", "attributeName", "", "(Ljava/lang/String;)V", "getAttributeName", "()Ljava/lang/String;", "setAttributeName", "equals", "", "other", "hashCode", "", "ConfigureCoverScreen2x2", "ConfigureHomeScreen2x2", "ConfigureLockScreen", "DimViewColor", "DimViewColorAtFullScreen", "FeaturedWidget", "InitialLayoutExtraLarge", "InitialLayoutExtraLargeLong", "InitialLayoutLarge", "InitialLayoutMedium", "InitialLayoutSmall", "InitialLayoutTiny", "InitialLayoutWideSmall", "LockWidgetSize", "MonotoneInitialLayoutMedium", "MonotoneInitialLayoutSmall", "MonotoneInitialLayoutTiny", "MonotonePreviewLayoutMedium", "MonotonePreviewLayoutSmall", "MonotonePreviewLayoutTiny", "MonotonePreviewSize", "MonotoneWidgetSize", "PreviewLayoutExtraLarge", "PreviewLayoutExtraLargeLong", "PreviewLayoutLarge", "PreviewLayoutMedium", "PreviewLayoutSmall", "PreviewLayoutTiny", "PreviewLayoutWideSmall", "PreviewSize", "TargetHost", "WidgetFeatures", "WidgetSize", "WidgetStyle", "Landroidx/glance/oneui/common/StyleableAttributes$ConfigureCoverScreen2x2;", "Landroidx/glance/oneui/common/StyleableAttributes$ConfigureHomeScreen2x2;", "Landroidx/glance/oneui/common/StyleableAttributes$ConfigureLockScreen;", "Landroidx/glance/oneui/common/StyleableAttributes$DimViewColor;", "Landroidx/glance/oneui/common/StyleableAttributes$DimViewColorAtFullScreen;", "Landroidx/glance/oneui/common/StyleableAttributes$FeaturedWidget;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutExtraLarge;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutExtraLargeLong;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutLarge;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutWideSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$LockWidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewSize;", "Landroidx/glance/oneui/common/StyleableAttributes$MonotoneWidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutExtraLarge;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutExtraLargeLong;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutLarge;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutWideSmall;", "Landroidx/glance/oneui/common/StyleableAttributes$PreviewSize;", "Landroidx/glance/oneui/common/StyleableAttributes$TargetHost;", "Landroidx/glance/oneui/common/StyleableAttributes$WidgetFeatures;", "Landroidx/glance/oneui/common/StyleableAttributes$WidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes$WidgetStyle;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class StyleableAttributes {

    @NotNull
    private String attributeName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$ConfigureCoverScreen2x2;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ConfigureCoverScreen2x2 extends StyleableAttributes {

        @NotNull
        public static final ConfigureCoverScreen2x2 INSTANCE = new ConfigureCoverScreen2x2();

        private ConfigureCoverScreen2x2() {
            super("configureCoverScreen2x2", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$ConfigureHomeScreen2x2;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ConfigureHomeScreen2x2 extends StyleableAttributes {

        @NotNull
        public static final ConfigureHomeScreen2x2 INSTANCE = new ConfigureHomeScreen2x2();

        private ConfigureHomeScreen2x2() {
            super("configureHomeScreen2x2", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$ConfigureLockScreen;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ConfigureLockScreen extends StyleableAttributes {

        @NotNull
        public static final ConfigureLockScreen INSTANCE = new ConfigureLockScreen();

        private ConfigureLockScreen() {
            super("configureLockScreen", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$DimViewColor;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class DimViewColor extends StyleableAttributes {

        @NotNull
        public static final DimViewColor INSTANCE = new DimViewColor();

        private DimViewColor() {
            super("dimViewColor", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$DimViewColorAtFullScreen;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class DimViewColorAtFullScreen extends StyleableAttributes {

        @NotNull
        public static final DimViewColorAtFullScreen INSTANCE = new DimViewColorAtFullScreen();

        private DimViewColorAtFullScreen() {
            super("dimViewColorAtFullScreen", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$FeaturedWidget;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class FeaturedWidget extends StyleableAttributes {

        @NotNull
        public static final FeaturedWidget INSTANCE = new FeaturedWidget();

        private FeaturedWidget() {
            super("featuredWidget", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutExtraLarge;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutExtraLarge extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutExtraLarge INSTANCE = new InitialLayoutExtraLarge();

        private InitialLayoutExtraLarge() {
            super("initialLayoutExtraLarge", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutExtraLargeLong;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutExtraLargeLong extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutExtraLargeLong INSTANCE = new InitialLayoutExtraLargeLong();

        private InitialLayoutExtraLargeLong() {
            super("initialLayoutExtraLargeLong", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutLarge;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutLarge extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutLarge INSTANCE = new InitialLayoutLarge();

        private InitialLayoutLarge() {
            super("initialLayoutLarge", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutMedium extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutMedium INSTANCE = new InitialLayoutMedium();

        private InitialLayoutMedium() {
            super("initialLayoutMedium", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutSmall extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutSmall INSTANCE = new InitialLayoutSmall();

        private InitialLayoutSmall() {
            super("initialLayoutSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutTiny extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutTiny INSTANCE = new InitialLayoutTiny();

        private InitialLayoutTiny() {
            super("initialLayoutTiny", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$InitialLayoutWideSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class InitialLayoutWideSmall extends StyleableAttributes {

        @NotNull
        public static final InitialLayoutWideSmall INSTANCE = new InitialLayoutWideSmall();

        private InitialLayoutWideSmall() {
            super("initialLayoutWideSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$LockWidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LockWidgetSize extends StyleableAttributes {

        @NotNull
        public static final LockWidgetSize INSTANCE = new LockWidgetSize();

        private LockWidgetSize() {
            super("lockWidgetSize", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotoneInitialLayoutMedium extends StyleableAttributes {

        @NotNull
        public static final MonotoneInitialLayoutMedium INSTANCE = new MonotoneInitialLayoutMedium();

        private MonotoneInitialLayoutMedium() {
            super("monotoneInitialLayoutMedium", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotoneInitialLayoutSmall extends StyleableAttributes {

        @NotNull
        public static final MonotoneInitialLayoutSmall INSTANCE = new MonotoneInitialLayoutSmall();

        private MonotoneInitialLayoutSmall() {
            super("monotoneInitialLayoutSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotoneInitialLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotoneInitialLayoutTiny extends StyleableAttributes {

        @NotNull
        public static final MonotoneInitialLayoutTiny INSTANCE = new MonotoneInitialLayoutTiny();

        private MonotoneInitialLayoutTiny() {
            super("monotoneInitialLayoutTiny", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotonePreviewLayoutMedium extends StyleableAttributes {

        @NotNull
        public static final MonotonePreviewLayoutMedium INSTANCE = new MonotonePreviewLayoutMedium();

        private MonotonePreviewLayoutMedium() {
            super("monotonePreviewLayoutMedium", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotonePreviewLayoutSmall extends StyleableAttributes {

        @NotNull
        public static final MonotonePreviewLayoutSmall INSTANCE = new MonotonePreviewLayoutSmall();

        private MonotonePreviewLayoutSmall() {
            super("monotonePreviewLayoutSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotonePreviewLayoutTiny extends StyleableAttributes {

        @NotNull
        public static final MonotonePreviewLayoutTiny INSTANCE = new MonotonePreviewLayoutTiny();

        private MonotonePreviewLayoutTiny() {
            super("monotonePreviewLayoutTiny", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotonePreviewSize;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotonePreviewSize extends StyleableAttributes {

        @NotNull
        public static final MonotonePreviewSize INSTANCE = new MonotonePreviewSize();

        private MonotonePreviewSize() {
            super("monotonePreviewSize", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$MonotoneWidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class MonotoneWidgetSize extends StyleableAttributes {

        @NotNull
        public static final MonotoneWidgetSize INSTANCE = new MonotoneWidgetSize();

        private MonotoneWidgetSize() {
            super("monotoneWidgetSize", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutExtraLarge;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutExtraLarge extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutExtraLarge INSTANCE = new PreviewLayoutExtraLarge();

        private PreviewLayoutExtraLarge() {
            super("previewLayoutExtraLarge", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutExtraLargeLong;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutExtraLargeLong extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutExtraLargeLong INSTANCE = new PreviewLayoutExtraLargeLong();

        private PreviewLayoutExtraLargeLong() {
            super("previewLayoutExtraLargeLong", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutLarge;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutLarge extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutLarge INSTANCE = new PreviewLayoutLarge();

        private PreviewLayoutLarge() {
            super("previewLayoutLarge", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutMedium;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutMedium extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutMedium INSTANCE = new PreviewLayoutMedium();

        private PreviewLayoutMedium() {
            super("previewLayoutMedium", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutSmall extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutSmall INSTANCE = new PreviewLayoutSmall();

        private PreviewLayoutSmall() {
            super("previewLayoutSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutTiny;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutTiny extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutTiny INSTANCE = new PreviewLayoutTiny();

        private PreviewLayoutTiny() {
            super("previewLayoutTiny", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewLayoutWideSmall;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewLayoutWideSmall extends StyleableAttributes {

        @NotNull
        public static final PreviewLayoutWideSmall INSTANCE = new PreviewLayoutWideSmall();

        private PreviewLayoutWideSmall() {
            super("previewLayoutWideSmall", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$PreviewSize;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PreviewSize extends StyleableAttributes {

        @NotNull
        public static final PreviewSize INSTANCE = new PreviewSize();

        private PreviewSize() {
            super("previewSize", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$TargetHost;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class TargetHost extends StyleableAttributes {

        @NotNull
        public static final TargetHost INSTANCE = new TargetHost();

        private TargetHost() {
            super("targetHost", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$WidgetFeatures;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class WidgetFeatures extends StyleableAttributes {

        @NotNull
        public static final WidgetFeatures INSTANCE = new WidgetFeatures();

        private WidgetFeatures() {
            super("semWidgetFeatures", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$WidgetSize;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class WidgetSize extends StyleableAttributes {

        @NotNull
        public static final WidgetSize INSTANCE = new WidgetSize();

        private WidgetSize() {
            super("widgetSize", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/oneui/common/StyleableAttributes$WidgetStyle;", "Landroidx/glance/oneui/common/StyleableAttributes;", "()V", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class WidgetStyle extends StyleableAttributes {

        @NotNull
        public static final WidgetStyle INSTANCE = new WidgetStyle();

        private WidgetStyle() {
            super("widgetStyle", null);
        }
    }

    public /* synthetic */ StyleableAttributes(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(@Nullable Object other) {
        StyleableAttributes styleableAttributes = (StyleableAttributes) other;
        return Intrinsics.areEqual(this.attributeName, styleableAttributes != null ? styleableAttributes.attributeName : null);
    }

    @NotNull
    public final String getAttributeName() {
        return this.attributeName;
    }

    public int hashCode() {
        return this.attributeName.hashCode();
    }

    public final void setAttributeName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attributeName = str;
    }

    private StyleableAttributes(String str) {
        this.attributeName = str;
    }
}
