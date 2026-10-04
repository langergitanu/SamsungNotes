package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.java.awt.Font;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/material3/Strings;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@JvmInline
public final class Strings {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int NavigationMenu = m17301constructorimpl(0);
    private static final int CloseDrawer = m17301constructorimpl(1);
    private static final int CloseSheet = m17301constructorimpl(2);
    private static final int DefaultErrorMessage = m17301constructorimpl(3);
    private static final int ExposedDropdownMenu = m17301constructorimpl(4);
    private static final int SliderRangeStart = m17301constructorimpl(5);
    private static final int SliderRangeEnd = m17301constructorimpl(6);
    private static final int Dialog = m17301constructorimpl(7);
    private static final int MenuExpanded = m17301constructorimpl(8);
    private static final int MenuCollapsed = m17301constructorimpl(9);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/material3/Strings$Companion;", "", "()V", "CloseDrawer", "Landroidx/compose/material3/Strings;", "getCloseDrawer-adMyvUU", "()I", "I", "CloseSheet", "getCloseSheet-adMyvUU", "DefaultErrorMessage", "getDefaultErrorMessage-adMyvUU", Font.DIALOG, "getDialog-adMyvUU", "ExposedDropdownMenu", "getExposedDropdownMenu-adMyvUU", "MenuCollapsed", "getMenuCollapsed-adMyvUU", "MenuExpanded", "getMenuExpanded-adMyvUU", "NavigationMenu", "getNavigationMenu-adMyvUU", "SliderRangeEnd", "getSliderRangeEnd-adMyvUU", "SliderRangeStart", "getSliderRangeStart-adMyvUU", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getCloseDrawer-adMyvUU, reason: not valid java name */
        public final int m17307getCloseDraweradMyvUU() {
            return Strings.CloseDrawer;
        }

        /* JADX INFO: renamed from: getCloseSheet-adMyvUU, reason: not valid java name */
        public final int m17308getCloseSheetadMyvUU() {
            return Strings.CloseSheet;
        }

        /* JADX INFO: renamed from: getDefaultErrorMessage-adMyvUU, reason: not valid java name */
        public final int m17309getDefaultErrorMessageadMyvUU() {
            return Strings.DefaultErrorMessage;
        }

        /* JADX INFO: renamed from: getDialog-adMyvUU, reason: not valid java name */
        public final int m17310getDialogadMyvUU() {
            return Strings.Dialog;
        }

        /* JADX INFO: renamed from: getExposedDropdownMenu-adMyvUU, reason: not valid java name */
        public final int m17311getExposedDropdownMenuadMyvUU() {
            return Strings.ExposedDropdownMenu;
        }

        /* JADX INFO: renamed from: getMenuCollapsed-adMyvUU, reason: not valid java name */
        public final int m17312getMenuCollapsedadMyvUU() {
            return Strings.MenuCollapsed;
        }

        /* JADX INFO: renamed from: getMenuExpanded-adMyvUU, reason: not valid java name */
        public final int m17313getMenuExpandedadMyvUU() {
            return Strings.MenuExpanded;
        }

        /* JADX INFO: renamed from: getNavigationMenu-adMyvUU, reason: not valid java name */
        public final int m17314getNavigationMenuadMyvUU() {
            return Strings.NavigationMenu;
        }

        /* JADX INFO: renamed from: getSliderRangeEnd-adMyvUU, reason: not valid java name */
        public final int m17315getSliderRangeEndadMyvUU() {
            return Strings.SliderRangeEnd;
        }

        /* JADX INFO: renamed from: getSliderRangeStart-adMyvUU, reason: not valid java name */
        public final int m17316getSliderRangeStartadMyvUU() {
            return Strings.SliderRangeStart;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m17300boximpl(int i) {
        return new Strings(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m17302equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m17303equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m17304hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m17305toStringimpl(int i) {
        return AbstractC0622a.m1167m("Strings(value=", i, PropertyUtils.MAPPED_DELIM2);
    }

    public boolean equals(Object obj) {
        return m17302equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m17304hashCodeimpl(this.value);
    }

    public String toString() {
        return m17305toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m17301constructorimpl(int i) {
        return i;
    }
}
