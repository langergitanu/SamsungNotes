package androidx.glance.oneui.template.component.padding;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.FuturePublicApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@FuturePublicApi
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0015\u0010\u0002\u001a\u00020\u0003H'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/PaddingVariable;", "", "toDp", "Landroidx/compose/ui/unit/Dp;", "toDp-chRvn1I", "(Landroidx/compose/runtime/Composer;I)F", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface PaddingVariable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final float STANDARD_1_ESTIMATE_VALUE = 16.0f;
    public static final float STANDARD_2_ESTIMATE_VALUE = 8.0f;
    public static final float SUB_1_ESTIMATE_VALUE = 4.0f;
    public static final float SUB_2_ESTIMATE_VALUE = 2.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/oneui/template/component/padding/PaddingVariable$Companion;", "", "()V", "None", "Landroidx/glance/oneui/template/component/padding/PaddingVariable;", "getNone", "()Landroidx/glance/oneui/template/component/padding/PaddingVariable;", "STANDARD_1_ESTIMATE_VALUE", "", "STANDARD_2_ESTIMATE_VALUE", "SUB_1_ESTIMATE_VALUE", "SUB_2_ESTIMATE_VALUE", "Standard1", "getStandard1", "Standard2", "getStandard2", "Sub1", "getSub1", "Sub2", "getSub2", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public static final float STANDARD_1_ESTIMATE_VALUE = 16.0f;
        public static final float STANDARD_2_ESTIMATE_VALUE = 8.0f;
        public static final float SUB_1_ESTIMATE_VALUE = 4.0f;
        public static final float SUB_2_ESTIMATE_VALUE = 2.0f;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final PaddingVariable None = new PaddingVariable() { // from class: androidx.glance.oneui.template.component.padding.PaddingVariable$Companion$None$1
            @Override // androidx.glance.oneui.template.component.padding.PaddingVariable
            @Composable
            /* JADX INFO: renamed from: toDp-chRvn1I */
            public final float mo21770toDpchRvn1I(@Nullable Composer composer, int i) {
                composer.startReplaceableGroup(-1352231018);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1352231018, i, -1, "androidx.glance.oneui.template.component.padding.PaddingVariable.Companion.None.<no name provided>.toDp (PaddingVariable.kt:27)");
                }
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return fM20968constructorimpl;
            }
        };

        @NotNull
        private static final PaddingVariable Standard1 = new PaddingVariable() { // from class: androidx.glance.oneui.template.component.padding.PaddingVariable$Companion$Standard1$1
            @Override // androidx.glance.oneui.template.component.padding.PaddingVariable
            @Composable
            /* JADX INFO: renamed from: toDp-chRvn1I */
            public final float mo21770toDpchRvn1I(@Nullable Composer composer, int i) {
                composer.startReplaceableGroup(-125936866);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-125936866, i, -1, "androidx.glance.oneui.template.component.padding.PaddingVariable.Companion.Standard1.<no name provided>.toDp (PaddingVariable.kt:31)");
                }
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(PaddingVariableKt.getCell1Height(composer, 0) * 0.26f);
                if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.m20968constructorimpl(0))) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(16.0f);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return fM20968constructorimpl;
            }
        };

        @NotNull
        private static final PaddingVariable Standard2 = new PaddingVariable() { // from class: androidx.glance.oneui.template.component.padding.PaddingVariable$Companion$Standard2$1
            @Override // androidx.glance.oneui.template.component.padding.PaddingVariable
            @Composable
            /* JADX INFO: renamed from: toDp-chRvn1I */
            public final float mo21770toDpchRvn1I(@Nullable Composer composer, int i) {
                composer.startReplaceableGroup(1855225213);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1855225213, i, -1, "androidx.glance.oneui.template.component.padding.PaddingVariable.Companion.Standard2.<no name provided>.toDp (PaddingVariable.kt:37)");
                }
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(PaddingVariableKt.getCell1Height(composer, 0) * 0.13f);
                if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.m20968constructorimpl(0))) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(8.0f);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return fM20968constructorimpl;
            }
        };

        @NotNull
        private static final PaddingVariable Sub1 = new PaddingVariable() { // from class: androidx.glance.oneui.template.component.padding.PaddingVariable$Companion$Sub1$1
            @Override // androidx.glance.oneui.template.component.padding.PaddingVariable
            @Composable
            /* JADX INFO: renamed from: toDp-chRvn1I */
            public final float mo21770toDpchRvn1I(@Nullable Composer composer, int i) {
                composer.startReplaceableGroup(305714237);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(305714237, i, -1, "androidx.glance.oneui.template.component.padding.PaddingVariable.Companion.Sub1.<no name provided>.toDp (PaddingVariable.kt:43)");
                }
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(PaddingVariableKt.getCell1Height(composer, 0) * 0.065f);
                if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.m20968constructorimpl(0))) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(4.0f);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return fM20968constructorimpl;
            }
        };

        @NotNull
        private static final PaddingVariable Sub2 = new PaddingVariable() { // from class: androidx.glance.oneui.template.component.padding.PaddingVariable$Companion$Sub2$1
            @Override // androidx.glance.oneui.template.component.padding.PaddingVariable
            @Composable
            /* JADX INFO: renamed from: toDp-chRvn1I */
            public final float mo21770toDpchRvn1I(@Nullable Composer composer, int i) {
                composer.startReplaceableGroup(-2008090980);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2008090980, i, -1, "androidx.glance.oneui.template.component.padding.PaddingVariable.Companion.Sub2.<no name provided>.toDp (PaddingVariable.kt:49)");
                }
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(PaddingVariableKt.getCell1Height(composer, 0) * 0.0325f);
                if (C2256Dp.m20973equalsimpl0(fM20968constructorimpl, C2256Dp.m20968constructorimpl(0))) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(2.0f);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return fM20968constructorimpl;
            }
        };

        private Companion() {
        }

        @NotNull
        public final PaddingVariable getNone() {
            return None;
        }

        @NotNull
        public final PaddingVariable getStandard1() {
            return Standard1;
        }

        @NotNull
        public final PaddingVariable getStandard2() {
            return Standard2;
        }

        @NotNull
        public final PaddingVariable getSub1() {
            return Sub1;
        }

        @NotNull
        public final PaddingVariable getSub2() {
            return Sub2;
        }
    }

    @Composable
    /* JADX INFO: renamed from: toDp-chRvn1I, reason: not valid java name */
    float mo21770toDpchRvn1I(@Nullable Composer composer, int i);
}
