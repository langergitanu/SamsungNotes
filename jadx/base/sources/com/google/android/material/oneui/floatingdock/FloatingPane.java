package com.google.android.material.oneui.floatingdock;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPane;", "", "FloatingPaneMode", "FloatingPaneState", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface FloatingPane {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "", "type", "", "constructor-impl", "(I)I", "contains", "", "other", "contains-J5JjPLc", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "plus", "plus-He5-3C8", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    public static final class FloatingPaneMode {
        private final int type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int MODE_NONE = m22080constructorimpl(0);
        private static final int MODE_BOTTOM = m22080constructorimpl(1);
        private static final int MODE_SIDE = m22080constructorimpl(2);
        private static final int MODE_FLOATING = m22080constructorimpl(4);
        private static final int MODE_ALL = m22080constructorimpl(7);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001b\u0010\b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005R\u001b\u0010\t\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\t\u0010\u0005R\u001b\u0010\n\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\n\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode$Companion;", "", "()V", "MODE_ALL", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "()I", "I", "MODE_BOTTOM", "MODE_FLOATING", "MODE_NONE", "MODE_SIDE", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmName(name = "MODE_ALL")
            public final int MODE_ALL() {
                return FloatingPaneMode.MODE_ALL;
            }

            @JvmName(name = "MODE_BOTTOM")
            public final int MODE_BOTTOM() {
                return FloatingPaneMode.MODE_BOTTOM;
            }

            @JvmName(name = "MODE_FLOATING")
            public final int MODE_FLOATING() {
                return FloatingPaneMode.MODE_FLOATING;
            }

            @JvmName(name = "MODE_NONE")
            public final int MODE_NONE() {
                return FloatingPaneMode.MODE_NONE;
            }

            @JvmName(name = "MODE_SIDE")
            public final int MODE_SIDE() {
                return FloatingPaneMode.MODE_SIDE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ FloatingPaneMode(int i) {
            this.type = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FloatingPaneMode m22079boximpl(int i) {
            return new FloatingPaneMode(i);
        }

        /* JADX INFO: renamed from: contains-J5JjPLc, reason: not valid java name */
        public static final boolean m22081containsJ5JjPLc(int i, int i2) {
            return (i & i2) != MODE_NONE;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m22082equalsimpl(int i, Object obj) {
            return (obj instanceof FloatingPaneMode) && i == ((FloatingPaneMode) obj).getType();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m22083equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m22084hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: plus-He5-3C8, reason: not valid java name */
        public static final int m22085plusHe53C8(int i, int i2) {
            return m22080constructorimpl(i + i2);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m22086toStringimpl(int i) {
            return AbstractC0622a.m1167m("FloatingPaneMode(type=", i, PropertyUtils.MAPPED_DELIM2);
        }

        public boolean equals(Object obj) {
            return m22082equalsimpl(this.type, obj);
        }

        public int hashCode() {
            return m22084hashCodeimpl(this.type);
        }

        public String toString() {
            return m22086toStringimpl(this.type);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m22080constructorimpl(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "", "state", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    public static final class FloatingPaneState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int STATE_IDLE = m22089constructorimpl(1);
        private static final int STATE_MOVE = m22089constructorimpl(2);
        private static final int STATE_RESIZE = m22089constructorimpl(3);
        private final int state;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001b\u0010\b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState$Companion;", "", "()V", "STATE_IDLE", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "()I", "I", "STATE_MOVE", "STATE_RESIZE", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmName(name = "STATE_IDLE")
            public final int STATE_IDLE() {
                return FloatingPaneState.STATE_IDLE;
            }

            @JvmName(name = "STATE_MOVE")
            public final int STATE_MOVE() {
                return FloatingPaneState.STATE_MOVE;
            }

            @JvmName(name = "STATE_RESIZE")
            public final int STATE_RESIZE() {
                return FloatingPaneState.STATE_RESIZE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ FloatingPaneState(int i) {
            this.state = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FloatingPaneState m22088boximpl(int i) {
            return new FloatingPaneState(i);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m22090equalsimpl(int i, Object obj) {
            return (obj instanceof FloatingPaneState) && i == ((FloatingPaneState) obj).getState();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m22091equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m22092hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m22093toStringimpl(int i) {
            return AbstractC0622a.m1167m("FloatingPaneState(state=", i, PropertyUtils.MAPPED_DELIM2);
        }

        public boolean equals(Object obj) {
            return m22090equalsimpl(this.state, obj);
        }

        public int hashCode() {
            return m22092hashCodeimpl(this.state);
        }

        public String toString() {
            return m22093toStringimpl(this.state);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m22089constructorimpl(int i) {
            return i;
        }
    }
}
