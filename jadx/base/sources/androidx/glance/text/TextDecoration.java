package androidx.glance.text;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/text/TextDecoration;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "contains", "", "other", "contains-hcOHJN8", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "plus", "decoration", "plus-YG9ZKLw", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class TextDecoration {
    private final int mask;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int None = m22013constructorimpl(0);
    private static final int Underline = m22013constructorimpl(1);
    private static final int LineThrough = m22013constructorimpl(2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/text/TextDecoration$Companion;", "", "()V", "LineThrough", "Landroidx/glance/text/TextDecoration;", "getLineThrough-ObZ5V_A", "()I", "I", "None", "getNone-ObZ5V_A", "Underline", "getUnderline-ObZ5V_A", "combine", "decorations", "", "combine-6pcTslc", "(Ljava/util/List;)I", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTextDecoration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextDecoration.kt\nandroidx/glance/text/TextDecoration$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,87:1\n1789#2,3:88\n*S KotlinDebug\n*F\n+ 1 TextDecoration.kt\nandroidx/glance/text/TextDecoration$Companion\n*L\n47#1:88,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: combine-6pcTslc, reason: not valid java name */
        public final int m22021combine6pcTslc(@NotNull List<TextDecoration> decorations) {
            Intrinsics.checkNotNullParameter(decorations, "decorations");
            Iterator<T> it = decorations.iterator();
            int mask = 0;
            while (it.hasNext()) {
                mask |= ((TextDecoration) it.next()).getMask();
            }
            return TextDecoration.m22013constructorimpl(mask);
        }

        /* JADX INFO: renamed from: getLineThrough-ObZ5V_A, reason: not valid java name */
        public final int m22022getLineThroughObZ5V_A() {
            return TextDecoration.LineThrough;
        }

        /* JADX INFO: renamed from: getNone-ObZ5V_A, reason: not valid java name */
        public final int m22023getNoneObZ5V_A() {
            return TextDecoration.None;
        }

        /* JADX INFO: renamed from: getUnderline-ObZ5V_A, reason: not valid java name */
        public final int m22024getUnderlineObZ5V_A() {
            return TextDecoration.Underline;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextDecoration(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDecoration m22012boximpl(int i) {
        return new TextDecoration(i);
    }

    @Stable
    /* JADX INFO: renamed from: contains-hcOHJN8, reason: not valid java name */
    public static final boolean m22014containshcOHJN8(int i, int i2) {
        return (i2 | i) == i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m22015equalsimpl(int i, Object obj) {
        return (obj instanceof TextDecoration) && i == ((TextDecoration) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m22016equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m22017hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @Stable
    /* JADX INFO: renamed from: plus-YG9ZKLw, reason: not valid java name */
    public static final int m22018plusYG9ZKLw(int i, int i2) {
        return m22013constructorimpl(i | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m22019toStringimpl(int i) {
        if (i == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((Underline & i) != 0) {
            arrayList.add("Underline");
        }
        if ((i & LineThrough) != 0) {
            arrayList.add("LineThrough");
        }
        return arrayList.size() == 1 ? AbstractC0541b.m769k(arrayList.get(0), "TextDecoration.") : AbstractC0541b.m773o("TextDecoration[", CollectionsKt.m13955n(arrayList, SQLKeyword.COMMA, null, null, null, 62), "]");
    }

    public boolean equals(Object obj) {
        return m22015equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m22017hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m22019toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m22013constructorimpl(int i) {
        return i;
    }
}
