package androidx.glance.oneui.template.component.padding;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import androidx.glance.FuturePublicApi;
import androidx.glance.oneui.template.component.padding.PaddingVariable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@FuturePublicApi
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002DEB/\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001b\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nB/\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001b\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\t\u001a\u00020\u000b¢\u0006\u0002\u0010\rBO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0016\u0010 \u001a\u00020\u0003HÀ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0016J\u0016\u0010\"\u001a\u00020\u0003HÀ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0016J\u0016\u0010$\u001a\u00020\u0003HÀ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0016J\u0016\u0010&\u001a\u00020\u0003HÀ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0016J\u000e\u0010(\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b)J\u000e\u0010*\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b+J\u000e\u0010,\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b-J\u000e\u0010.\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b/J\t\u00100\u001a\u00020\u0013HÂ\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0015\u00107\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00109J\u0015\u0010<\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u00109J\u0015\u0010>\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00109J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u000e\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u000f\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/Padding;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "horizontal", "vertical", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/glance/oneui/template/component/padding/PaddingVariable;", "(Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;)V", "(Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;)V", "startVariable", "topVariable", "endVariable", "bottomVariable", "type", "Landroidx/glance/oneui/template/component/padding/Padding$Type;", "(FFFFLandroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/Padding$Type;)V", "getBottom-D9Ej5fM$glance_oneui_template_release", "()F", TokenizerME.NO_SPLIT, "getBottomVariable$glance_oneui_template_release", "()Landroidx/glance/oneui/template/component/padding/PaddingVariable;", "getEnd-D9Ej5fM$glance_oneui_template_release", "getEndVariable$glance_oneui_template_release", "getStart-D9Ej5fM$glance_oneui_template_release", "getStartVariable$glance_oneui_template_release", "getTop-D9Ej5fM$glance_oneui_template_release", "getTopVariable$glance_oneui_template_release", "component1", "component1-D9Ej5fM$glance_oneui_template_release", "component2", "component2-D9Ej5fM$glance_oneui_template_release", "component3", "component3-D9Ej5fM$glance_oneui_template_release", "component4", "component4-D9Ej5fM$glance_oneui_template_release", "component5", "component5$glance_oneui_template_release", "component6", "component6$glance_oneui_template_release", "component7", "component7$glance_oneui_template_release", "component8", "component8$glance_oneui_template_release", "component9", "copy", "copy-5-DNhBc", "(FFFFLandroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/PaddingVariable;Landroidx/glance/oneui/template/component/padding/Padding$Type;)Landroidx/glance/oneui/template/component/padding/Padding;", "equals", "", "other", "getBottom", "getBottom-chRvn1I", "(Landroidx/compose/runtime/Composer;I)F", "getEnd", "getEnd-chRvn1I", "getStart", "getStart-chRvn1I", "getTop", "getTop-chRvn1I", "hashCode", "", "toString", "", "Companion", PackageRelationship.TYPE_ATTRIBUTE_NAME, "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPadding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Padding.kt\nandroidx/glance/oneui/template/component/padding/Padding\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,151:1\n154#2:152\n154#2:153\n154#2:154\n154#2:155\n154#2:156\n154#2:157\n154#2:158\n*S KotlinDebug\n*F\n+ 1 Padding.kt\nandroidx/glance/oneui/template/component/padding/Padding\n*L\n36#1:152\n37#1:153\n38#1:154\n39#1:155\n53#1:156\n54#1:157\n136#1:158\n*E\n"})
public final /* data */ class Padding {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Padding None;
    private final float bottom;

    @NotNull
    private final PaddingVariable bottomVariable;
    private final float end;

    @NotNull
    private final PaddingVariable endVariable;
    private final float start;

    @NotNull
    private final PaddingVariable startVariable;
    private final float top;

    @NotNull
    private final PaddingVariable topVariable;

    @NotNull
    private final Type type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/Padding$Companion;", "", "()V", "None", "Landroidx/glance/oneui/template/component/padding/Padding;", "getNone", "()Landroidx/glance/oneui/template/component/padding/Padding;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Padding getNone() {
            return Padding.None;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/Padding$Type;", "", "(Ljava/lang/String;I)V", "DP", "VARIABLE", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* JADX INFO: renamed from: DP */
        public static final Type f1606DP = new Type("DP", 0);
        public static final Type VARIABLE = new Type("VARIABLE", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{f1606DP, VARIABLE};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static {
        float f = 0;
        None = new Padding(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f), null);
    }

    public /* synthetic */ Padding(float f, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6);
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: copy-5-DNhBc$default, reason: not valid java name */
    public static /* synthetic */ Padding m21756copy5DNhBc$default(Padding padding, float f, float f4, float f5, float f6, PaddingVariable paddingVariable, PaddingVariable paddingVariable2, PaddingVariable paddingVariable3, PaddingVariable paddingVariable4, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            f = padding.start;
        }
        if ((i & 2) != 0) {
            f4 = padding.top;
        }
        if ((i & 4) != 0) {
            f5 = padding.end;
        }
        if ((i & 8) != 0) {
            f6 = padding.bottom;
        }
        if ((i & 16) != 0) {
            paddingVariable = padding.startVariable;
        }
        if ((i & 32) != 0) {
            paddingVariable2 = padding.topVariable;
        }
        if ((i & 64) != 0) {
            paddingVariable3 = padding.endVariable;
        }
        if ((i & 128) != 0) {
            paddingVariable4 = padding.bottomVariable;
        }
        if ((i & 256) != 0) {
            type = padding.type;
        }
        PaddingVariable paddingVariable5 = paddingVariable4;
        Type type2 = type;
        PaddingVariable paddingVariable6 = paddingVariable2;
        PaddingVariable paddingVariable7 = paddingVariable3;
        PaddingVariable paddingVariable8 = paddingVariable;
        float f7 = f5;
        return padding.m21761copy5DNhBc(f, f4, f7, f6, paddingVariable8, paddingVariable6, paddingVariable7, paddingVariable5, type2);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM$glance_oneui_template_release, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM$glance_oneui_template_release, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM$glance_oneui_template_release, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM$glance_oneui_template_release, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    @NotNull
    /* JADX INFO: renamed from: component5$glance_oneui_template_release, reason: from getter */
    public final PaddingVariable getStartVariable() {
        return this.startVariable;
    }

    @NotNull
    /* JADX INFO: renamed from: component6$glance_oneui_template_release, reason: from getter */
    public final PaddingVariable getTopVariable() {
        return this.topVariable;
    }

    @NotNull
    /* JADX INFO: renamed from: component7$glance_oneui_template_release, reason: from getter */
    public final PaddingVariable getEndVariable() {
        return this.endVariable;
    }

    @NotNull
    /* JADX INFO: renamed from: component8$glance_oneui_template_release, reason: from getter */
    public final PaddingVariable getBottomVariable() {
        return this.bottomVariable;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-5-DNhBc, reason: not valid java name */
    public final Padding m21761copy5DNhBc(float start, float top, float end, float bottom, @NotNull PaddingVariable startVariable, @NotNull PaddingVariable topVariable, @NotNull PaddingVariable endVariable, @NotNull PaddingVariable bottomVariable, @NotNull Type type) {
        Intrinsics.checkNotNullParameter(startVariable, "startVariable");
        Intrinsics.checkNotNullParameter(topVariable, "topVariable");
        Intrinsics.checkNotNullParameter(endVariable, "endVariable");
        Intrinsics.checkNotNullParameter(bottomVariable, "bottomVariable");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Padding(start, top, end, bottom, startVariable, topVariable, endVariable, bottomVariable, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Padding)) {
            return false;
        }
        Padding padding = (Padding) other;
        return C2256Dp.m20973equalsimpl0(this.start, padding.start) && C2256Dp.m20973equalsimpl0(this.top, padding.top) && C2256Dp.m20973equalsimpl0(this.end, padding.end) && C2256Dp.m20973equalsimpl0(this.bottom, padding.bottom) && Intrinsics.areEqual(this.startVariable, padding.startVariable) && Intrinsics.areEqual(this.topVariable, padding.topVariable) && Intrinsics.areEqual(this.endVariable, padding.endVariable) && Intrinsics.areEqual(this.bottomVariable, padding.bottomVariable) && this.type == padding.type;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$glance_oneui_template_release, reason: not valid java name */
    public final float m21762getBottomD9Ej5fM$glance_oneui_template_release() {
        return this.bottom;
    }

    @Composable
    /* JADX INFO: renamed from: getBottom-chRvn1I, reason: not valid java name */
    public final float m21763getBottomchRvn1I(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1594055072);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1594055072, i, -1, "androidx.glance.oneui.template.component.padding.Padding.getBottom (Padding.kt:126)");
        }
        float fMo21770toDpchRvn1I = this.type == Type.f1606DP ? this.bottom : this.bottomVariable.mo21770toDpchRvn1I(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fMo21770toDpchRvn1I;
    }

    @NotNull
    public final PaddingVariable getBottomVariable$glance_oneui_template_release() {
        return this.bottomVariable;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM$glance_oneui_template_release, reason: not valid java name */
    public final float m21764getEndD9Ej5fM$glance_oneui_template_release() {
        return this.end;
    }

    @Composable
    /* JADX INFO: renamed from: getEnd-chRvn1I, reason: not valid java name */
    public final float m21765getEndchRvn1I(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2136796736);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2136796736, i, -1, "androidx.glance.oneui.template.component.padding.Padding.getEnd (Padding.kt:117)");
        }
        float fMo21770toDpchRvn1I = this.type == Type.f1606DP ? this.end : this.endVariable.mo21770toDpchRvn1I(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fMo21770toDpchRvn1I;
    }

    @NotNull
    public final PaddingVariable getEndVariable$glance_oneui_template_release() {
        return this.endVariable;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM$glance_oneui_template_release, reason: not valid java name */
    public final float m21766getStartD9Ej5fM$glance_oneui_template_release() {
        return this.start;
    }

    @Composable
    /* JADX INFO: renamed from: getStart-chRvn1I, reason: not valid java name */
    public final float m21767getStartchRvn1I(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(413923545);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(413923545, i, -1, "androidx.glance.oneui.template.component.padding.Padding.getStart (Padding.kt:99)");
        }
        float fMo21770toDpchRvn1I = this.type == Type.f1606DP ? this.start : this.startVariable.mo21770toDpchRvn1I(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fMo21770toDpchRvn1I;
    }

    @NotNull
    public final PaddingVariable getStartVariable$glance_oneui_template_release() {
        return this.startVariable;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$glance_oneui_template_release, reason: not valid java name */
    public final float m21768getTopD9Ej5fM$glance_oneui_template_release() {
        return this.top;
    }

    @Composable
    /* JADX INFO: renamed from: getTop-chRvn1I, reason: not valid java name */
    public final float m21769getTopchRvn1I(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1271307398);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1271307398, i, -1, "androidx.glance.oneui.template.component.padding.Padding.getTop (Padding.kt:108)");
        }
        float fMo21770toDpchRvn1I = this.type == Type.f1606DP ? this.top : this.topVariable.mo21770toDpchRvn1I(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fMo21770toDpchRvn1I;
    }

    @NotNull
    public final PaddingVariable getTopVariable$glance_oneui_template_release() {
        return this.topVariable;
    }

    public int hashCode() {
        return this.type.hashCode() + ((this.bottomVariable.hashCode() + ((this.endVariable.hashCode() + ((this.topVariable.hashCode() + ((this.startVariable.hashCode() + AbstractC0622a.m1153C(this.bottom, AbstractC0622a.m1153C(this.end, AbstractC0622a.m1153C(this.top, C2256Dp.m20974hashCodeimpl(this.start) * 31, 31), 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        String strM20979toStringimpl = C2256Dp.m20979toStringimpl(this.start);
        String strM20979toStringimpl2 = C2256Dp.m20979toStringimpl(this.top);
        String strM20979toStringimpl3 = C2256Dp.m20979toStringimpl(this.end);
        String strM20979toStringimpl4 = C2256Dp.m20979toStringimpl(this.bottom);
        PaddingVariable paddingVariable = this.startVariable;
        PaddingVariable paddingVariable2 = this.topVariable;
        PaddingVariable paddingVariable3 = this.endVariable;
        PaddingVariable paddingVariable4 = this.bottomVariable;
        Type type = this.type;
        StringBuilder sbM16m = AbstractC0000a.m16m("Padding(start=", strM20979toStringimpl, ", top=", strM20979toStringimpl2, ", end=");
        AbstractC2821a.m2207B(sbM16m, strM20979toStringimpl3, ", bottom=", strM20979toStringimpl4, ", startVariable=");
        sbM16m.append(paddingVariable);
        sbM16m.append(", topVariable=");
        sbM16m.append(paddingVariable2);
        sbM16m.append(", endVariable=");
        sbM16m.append(paddingVariable3);
        sbM16m.append(", bottomVariable=");
        sbM16m.append(paddingVariable4);
        sbM16m.append(", type=");
        sbM16m.append(type);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    public /* synthetic */ Padding(float f, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4);
    }

    private Padding(float f, float f4, float f5, float f6, PaddingVariable paddingVariable, PaddingVariable paddingVariable2, PaddingVariable paddingVariable3, PaddingVariable paddingVariable4, Type type) {
        this.start = f;
        this.top = f4;
        this.end = f5;
        this.bottom = f6;
        this.startVariable = paddingVariable;
        this.topVariable = paddingVariable2;
        this.endVariable = paddingVariable3;
        this.bottomVariable = paddingVariable4;
        this.type = type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Padding(float f, float f4, float f5, float f6) {
        PaddingVariable.Companion companion = PaddingVariable.INSTANCE;
        this(f, f4, f5, f6, companion.getNone(), companion.getNone(), companion.getNone(), companion.getNone(), Type.f1606DP);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Padding(float f, float f4) {
        PaddingVariable.Companion companion = PaddingVariable.INSTANCE;
        this(f, f4, f, f4, companion.getNone(), companion.getNone(), companion.getNone(), companion.getNone(), Type.f1606DP);
    }

    public /* synthetic */ Padding(PaddingVariable paddingVariable, PaddingVariable paddingVariable2, PaddingVariable paddingVariable3, PaddingVariable paddingVariable4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable, (i & 2) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable2, (i & 4) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable3, (i & 8) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Padding(@NotNull PaddingVariable start, @NotNull PaddingVariable top, @NotNull PaddingVariable end, @NotNull PaddingVariable bottom) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        this(companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), start, top, end, bottom, Type.VARIABLE);
    }

    public /* synthetic */ Padding(PaddingVariable paddingVariable, PaddingVariable paddingVariable2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable, (i & 2) != 0 ? PaddingVariable.INSTANCE.getNone() : paddingVariable2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Padding(@NotNull PaddingVariable horizontal, @NotNull PaddingVariable vertical) {
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        Intrinsics.checkNotNullParameter(vertical, "vertical");
        C2256Dp.Companion companion = C2256Dp.INSTANCE;
        this(companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), companion.m20988getUnspecifiedD9Ej5fM(), horizontal, vertical, horizontal, vertical, Type.VARIABLE);
    }

    public /* synthetic */ Padding(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, (i & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f5, (i & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f6, null);
    }

    public /* synthetic */ Padding(float f, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i & 2) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, null);
    }
}
