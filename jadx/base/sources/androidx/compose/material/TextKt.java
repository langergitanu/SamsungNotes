package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextDirection;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00063"}, m13886d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextKt {

    @NotNull
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final TextStyle invoke() {
            return TextStyle.INSTANCE.getDefault();
        }
    });

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ProvideTextStyle(@NotNull final TextStyle value, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772272796);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(value) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:262)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) composerStartRestartGroup.consume(providableCompositionLocal)).merge(value))}, content, composerStartRestartGroup, (i2 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt.ProvideTextStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                TextKt.ProvideTextStyle(value, content, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0433 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0138  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16943Text4IGK_g(@NotNull final AnnotatedString text, @Nullable Modifier modifier, long j, long j2, @Nullable FontStyle fontStyle, @Nullable FontWeight fontWeight, @Nullable FontFamily fontFamily, long j3, @Nullable TextDecoration textDecoration, @Nullable TextAlign textAlign, long j5, int i, boolean z, int i2, @Nullable Map<String, InlineTextContent> map, @Nullable Function1<? super TextLayoutResult, Unit> function1, @Nullable TextStyle textStyle, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        long jM18561getUnspecified0d7_KjU;
        int i10;
        long jM21172getUnspecifiedXSAIIZE;
        int i11;
        FontStyle fontStyle2;
        int i12;
        FontWeight fontWeight2;
        int i13;
        FontFamily fontFamily2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int iM20906getClipgIe3tQ8;
        boolean z2;
        final int i30;
        Map<String, InlineTextContent> mapEmptyMap;
        Function1<? super TextLayoutResult, Unit> function12;
        TextAlign textAlign2;
        TextStyle textStyle2;
        TextDecoration textDecoration2;
        FontFamily fontFamily3;
        long j6;
        FontStyle fontStyle3;
        FontWeight fontWeight3;
        long j7;
        int i31;
        long j8;
        Color.Companion companion;
        long j9;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final Map<String, InlineTextContent> map2;
        final TextStyle textStyle3;
        final int i32;
        final long j10;
        final boolean z3;
        final long j11;
        final FontWeight fontWeight4;
        final FontStyle fontStyle4;
        final FontFamily fontFamily4;
        final long j12;
        final TextAlign textAlign3;
        final long j13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-422393234);
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 112) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
                i9 = i33;
                jM18561getUnspecified0d7_KjU = j;
            } else {
                i9 = i33;
                jM18561getUnspecified0d7_KjU = j;
                if ((i4 & 896) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM18561getUnspecified0d7_KjU) ? 256 : 128;
                }
            }
            i10 = i6 & 8;
            if (i10 == 0) {
                i7 |= 3072;
                jM21172getUnspecifiedXSAIIZE = j2;
            } else {
                jM21172getUnspecifiedXSAIIZE = j2;
                if ((i4 & 7168) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM21172getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i11 = i6 & 16;
            if (i11 == 0) {
                i7 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 57344) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i12 = i6 & 32;
            if (i12 == 0) {
                i7 |= 196608;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 458752) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i13 = i6 & 64;
            if (i13 == 0) {
                i7 |= 1572864;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i4 & 3670016) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                }
            }
            i14 = i6 & 128;
            if (i14 == 0) {
                i7 |= 12582912;
            } else if ((i4 & 29360128) == 0) {
                i7 |= composerStartRestartGroup.changed(j3) ? 8388608 : 4194304;
            }
            i15 = i6 & 256;
            if (i15 == 0) {
                i7 |= 100663296;
            } else {
                if ((i4 & 234881024) == 0) {
                    i7 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                }
                i16 = i6 & 512;
                if (i16 != 0) {
                    i7 |= DriveFile.MODE_READ_WRITE;
                } else {
                    if ((i4 & 1879048192) == 0) {
                        i17 = i16;
                        i7 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i18 = i6 & 1024;
                    if (i18 == 0) {
                        i20 = i5 | 6;
                        i19 = i18;
                    } else if ((i5 & 14) == 0) {
                        i19 = i18;
                        i20 = i5 | (composerStartRestartGroup.changed(j5) ? 4 : 2);
                    } else {
                        i19 = i18;
                        i20 = i5;
                    }
                    i21 = i6 & 2048;
                    if (i21 == 0) {
                        i20 |= 48;
                    } else {
                        if ((i5 & 112) == 0) {
                            i20 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                        }
                        int i34 = i20;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                            i23 = i34 | 384;
                        } else {
                            int i35 = i34;
                            if ((i5 & 896) == 0) {
                                i35 |= composerStartRestartGroup.changed(z) ? 256 : 128;
                            }
                            i23 = i35;
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                            i25 = i23 | 3072;
                        } else {
                            int i36 = i23;
                            if ((i5 & 7168) == 0) {
                                i25 = i36 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i25 = i36;
                            }
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                            i25 |= 8192;
                        }
                        i27 = i6 & 32768;
                        if (i27 != 0) {
                            i28 = i25 | 196608;
                        } else {
                            int i37 = i25;
                            if ((i5 & 458752) == 0) {
                                i28 = i37 | (composerStartRestartGroup.changed(function1) ? 131072 : 65536);
                            } else {
                                i28 = i37;
                            }
                        }
                        if ((i5 & 3670016) == 0) {
                            i28 |= ((i6 & 65536) == 0 && composerStartRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                        }
                        if (i26 == 16384) {
                            i29 = i26;
                            if ((1533916891 & i7) == 306783378 && (i28 & 2995931) == 599186 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                fontFamily4 = fontFamily2;
                                j10 = jM18561getUnspecified0d7_KjU;
                                textDecoration2 = textDecoration;
                                textAlign3 = textAlign;
                                i32 = i;
                                z3 = z;
                                i30 = i2;
                                map2 = map;
                                function13 = function1;
                                textStyle3 = textStyle;
                                composer2 = composerStartRestartGroup;
                                j11 = jM21172getUnspecifiedXSAIIZE;
                                fontStyle4 = fontStyle2;
                                fontWeight4 = fontWeight2;
                                j12 = j3;
                                j13 = j5;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            final Modifier modifier3 = modifier2;
                            final TextDecoration textDecoration3 = textDecoration2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i38) {
                                    TextKt.m16943Text4IGK_g(text, modifier3, j10, j11, fontStyle4, fontWeight4, fontFamily4, j12, textDecoration3, textAlign3, j13, i32, z3, i30, map2, function13, textStyle3, composer3, i4 | 1, i5, i6);
                                }
                            });
                            return;
                        }
                        i29 = i26;
                        composerStartRestartGroup.startDefaults();
                        if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i8 != 0) {
                                jM18561getUnspecified0d7_KjU = Color.INSTANCE.m18561getUnspecified0d7_KjU();
                            }
                            if (i10 != 0) {
                                jM21172getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
                            }
                            if (i11 != 0) {
                                fontStyle2 = null;
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            if (i13 != 0) {
                                fontFamily2 = null;
                            }
                            long jM21172getUnspecifiedXSAIIZE2 = i14 == 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
                            TextDecoration textDecoration4 = i15 == 0 ? null : textDecoration;
                            TextAlign textAlign4 = i17 == 0 ? textAlign : null;
                            long jM21172getUnspecifiedXSAIIZE3 = i19 == 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j5;
                            iM20906getClipgIe3tQ8 = i21 == 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i;
                            z2 = i22 == 0 ? true : z;
                            i30 = i24 == 0 ? Integer.MAX_VALUE : i2;
                            if (i29 == 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                                i28 &= -57345;
                            } else {
                                mapEmptyMap = map;
                            }
                            function12 = i27 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull TextLayoutResult it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            } : function1;
                            TextAlign textAlign5 = textAlign4;
                            if ((i6 & 65536) == 0) {
                                textStyle2 = (TextStyle) composerStartRestartGroup.consume(LocalTextStyle);
                                i28 &= -3670017;
                                textAlign2 = textAlign5;
                            } else {
                                textAlign2 = textAlign5;
                                textStyle2 = textStyle;
                            }
                            textDecoration2 = textDecoration4;
                            fontFamily3 = fontFamily2;
                            j6 = jM21172getUnspecifiedXSAIIZE;
                            fontStyle3 = fontStyle2;
                            fontWeight3 = fontWeight2;
                            j7 = jM21172getUnspecifiedXSAIIZE2;
                            i31 = i28;
                            j8 = jM21172getUnspecifiedXSAIIZE3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if (i29 != 0) {
                                i28 &= -57345;
                            }
                            if ((i6 & 65536) != 0) {
                                i28 &= -3670017;
                            }
                            j7 = j3;
                            textDecoration2 = textDecoration;
                            textAlign2 = textAlign;
                            j8 = j5;
                            iM20906getClipgIe3tQ8 = i;
                            z2 = z;
                            i30 = i2;
                            mapEmptyMap = map;
                            function12 = function1;
                            textStyle2 = textStyle;
                            fontFamily3 = fontFamily2;
                            j6 = jM21172getUnspecifiedXSAIIZE;
                            fontStyle3 = fontStyle2;
                            fontWeight3 = fontWeight2;
                            i31 = i28;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-422393234, i7, i31, "androidx.compose.material.Text (Text.kt:193)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        companion = Color.INSTANCE;
                        if (jM18561getUnspecified0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                            j9 = jM18561getUnspecified0d7_KjU;
                        } else {
                            long jM20486getColor0d7_KjU = textStyle2.m20486getColor0d7_KjU();
                            if (jM20486getColor0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                                jM20486getColor0d7_KjU = Color.m18524copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            j9 = jM20486getColor0d7_KjU;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i38 = (i7 & 112) | 16777216 | (i7 & 14) | ((i31 >> 6) & 7168);
                        int i39 = i31 << 9;
                        BasicTextKt.m16144BasicText4YKlhWE(text, modifier2, textStyle2.merge(new TextStyle(j9, j6, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, j7, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j8, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), function12, iM20906getClipgIe3tQ8, z2, i30, mapEmptyMap, composerStartRestartGroup, (i39 & 3670016) | i38 | (57344 & i39) | (i39 & 458752), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        Map<String, InlineTextContent> map3 = mapEmptyMap;
                        function13 = function12;
                        map2 = map3;
                        textStyle3 = textStyle2;
                        i32 = iM20906getClipgIe3tQ8;
                        j10 = jM18561getUnspecified0d7_KjU;
                        z3 = z2;
                        j11 = j6;
                        fontWeight4 = fontWeight3;
                        fontStyle4 = fontStyle3;
                        fontFamily4 = fontFamily3;
                        j12 = j7;
                        textAlign3 = textAlign2;
                        j13 = j8;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    int i342 = i20;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i27 = i6 & 32768;
                    if (i27 != 0) {
                    }
                    if ((i5 & 3670016) == 0) {
                    }
                    if (i26 == 16384) {
                    }
                    composerStartRestartGroup.startDefaults();
                    if ((i4 & 1) == 0) {
                        if (i9 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        TextAlign textAlign52 = textAlign4;
                        if ((i6 & 65536) == 0) {
                        }
                        textDecoration2 = textDecoration4;
                        fontFamily3 = fontFamily2;
                        j6 = jM21172getUnspecifiedXSAIIZE;
                        fontStyle3 = fontStyle2;
                        fontWeight3 = fontWeight2;
                        j7 = jM21172getUnspecifiedXSAIIZE2;
                        i31 = i28;
                        j8 = jM21172getUnspecifiedXSAIIZE3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceableGroup(1557618192);
                        companion = Color.INSTANCE;
                        if (jM18561getUnspecified0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i382 = (i7 & 112) | 16777216 | (i7 & 14) | ((i31 >> 6) & 7168);
                        int i392 = i31 << 9;
                        BasicTextKt.m16144BasicText4YKlhWE(text, modifier2, textStyle2.merge(new TextStyle(j9, j6, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, j7, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j8, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), function12, iM20906getClipgIe3tQ8, z2, i30, mapEmptyMap, composerStartRestartGroup, (i392 & 3670016) | i382 | (57344 & i392) | (i392 & 458752), 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Map<String, InlineTextContent> map32 = mapEmptyMap;
                        function13 = function12;
                        map2 = map32;
                        textStyle3 = textStyle2;
                        i32 = iM20906getClipgIe3tQ8;
                        j10 = jM18561getUnspecified0d7_KjU;
                        z3 = z2;
                        j11 = j6;
                        fontWeight4 = fontWeight3;
                        fontStyle4 = fontStyle3;
                        fontFamily4 = fontFamily3;
                        j12 = j7;
                        textAlign3 = textAlign2;
                        j13 = j8;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i17 = i16;
                i18 = i6 & 1024;
                if (i18 == 0) {
                }
                i21 = i6 & 2048;
                if (i21 == 0) {
                }
                int i3422 = i20;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i27 = i6 & 32768;
                if (i27 != 0) {
                }
                if ((i5 & 3670016) == 0) {
                }
                if (i26 == 16384) {
                }
                composerStartRestartGroup.startDefaults();
                if ((i4 & 1) == 0) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i16 = i6 & 512;
            if (i16 != 0) {
            }
            i17 = i16;
            i18 = i6 & 1024;
            if (i18 == 0) {
            }
            i21 = i6 & 2048;
            if (i21 == 0) {
            }
            int i34222 = i20;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i27 = i6 & 32768;
            if (i27 != 0) {
            }
            if ((i5 & 3670016) == 0) {
            }
            if (i26 == 16384) {
            }
            composerStartRestartGroup.startDefaults();
            if ((i4 & 1) == 0) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i10 = i6 & 8;
        if (i10 == 0) {
        }
        i11 = i6 & 16;
        if (i11 == 0) {
        }
        i12 = i6 & 32;
        if (i12 == 0) {
        }
        i13 = i6 & 64;
        if (i13 == 0) {
        }
        i14 = i6 & 128;
        if (i14 == 0) {
        }
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i6 & 512;
        if (i16 != 0) {
        }
        i17 = i16;
        i18 = i6 & 1024;
        if (i18 == 0) {
        }
        i21 = i6 & 2048;
        if (i21 == 0) {
        }
        int i342222 = i20;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i27 = i6 & 32768;
        if (i27 != 0) {
        }
        if ((i5 & 3670016) == 0) {
        }
        if (i26 == 16384) {
        }
        composerStartRestartGroup.startDefaults();
        if ((i4 & 1) == 0) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16944TextfLXpl1I(@NotNull final String text, @Nullable Modifier modifier, long j, long j2, @Nullable FontStyle fontStyle, @Nullable FontWeight fontWeight, @Nullable FontFamily fontFamily, long j3, @Nullable TextDecoration textDecoration, @Nullable TextAlign textAlign, long j5, int i, boolean z, int i2, @Nullable Function1<? super TextLayoutResult, Unit> function1, @Nullable TextStyle textStyle, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        long jM18561getUnspecified0d7_KjU;
        int i10;
        long jM21172getUnspecifiedXSAIIZE;
        int i11;
        final FontStyle fontStyle2;
        int i12;
        FontWeight fontWeight2;
        int i13;
        FontFamily fontFamily2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iM20906getClipgIe3tQ8;
        boolean z2;
        final int i28;
        Function1<? super TextLayoutResult, Unit> function12;
        TextAlign textAlign2;
        TextStyle textStyle2;
        TextDecoration textDecoration2;
        FontStyle fontStyle3;
        long j6;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long j7;
        int i29;
        long j8;
        Color.Companion companion;
        long j9;
        Composer composer2;
        final int i30;
        final long j10;
        final boolean z3;
        final Function1<? super TextLayoutResult, Unit> function13;
        final long j11;
        final FontWeight fontWeight4;
        final FontFamily fontFamily4;
        final long j12;
        final TextAlign textAlign3;
        final long j13;
        final TextStyle textStyle3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-366126944);
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i31 = i6 & 2;
        if (i31 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 112) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
                i9 = i31;
                jM18561getUnspecified0d7_KjU = j;
            } else {
                i9 = i31;
                jM18561getUnspecified0d7_KjU = j;
                if ((i4 & 896) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM18561getUnspecified0d7_KjU) ? 256 : 128;
                }
            }
            i10 = i6 & 8;
            if (i10 == 0) {
                i7 |= 3072;
                jM21172getUnspecifiedXSAIIZE = j2;
            } else {
                jM21172getUnspecifiedXSAIIZE = j2;
                if ((i4 & 7168) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM21172getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i11 = i6 & 16;
            if (i11 == 0) {
                i7 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 57344) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i12 = i6 & 32;
            if (i12 == 0) {
                i7 |= 196608;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 458752) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i13 = i6 & 64;
            if (i13 == 0) {
                i7 |= 1572864;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i4 & 3670016) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                }
            }
            i14 = i6 & 128;
            if (i14 == 0) {
                i7 |= 12582912;
            } else if ((i4 & 29360128) == 0) {
                i7 |= composerStartRestartGroup.changed(j3) ? 8388608 : 4194304;
            }
            i15 = i6 & 256;
            if (i15 == 0) {
                i7 |= 100663296;
            } else {
                if ((i4 & 234881024) == 0) {
                    i7 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                }
                i16 = i6 & 512;
                if (i16 != 0) {
                    i7 |= DriveFile.MODE_READ_WRITE;
                } else {
                    if ((i4 & 1879048192) == 0) {
                        i17 = i16;
                        i7 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i18 = i6 & 1024;
                    if (i18 == 0) {
                        i20 = i5 | 6;
                        i19 = i18;
                    } else if ((i5 & 14) == 0) {
                        i19 = i18;
                        i20 = i5 | (composerStartRestartGroup.changed(j5) ? 4 : 2);
                    } else {
                        i19 = i18;
                        i20 = i5;
                    }
                    i21 = i6 & 2048;
                    if (i21 == 0) {
                        i20 |= 48;
                    } else {
                        if ((i5 & 112) == 0) {
                            i20 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                        }
                        int i32 = i20;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                            i23 = i32 | 384;
                        } else {
                            int i33 = i32;
                            if ((i5 & 896) == 0) {
                                i33 |= composerStartRestartGroup.changed(z) ? 256 : 128;
                            }
                            i23 = i33;
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                            i25 = i23 | 3072;
                        } else {
                            int i34 = i23;
                            if ((i5 & 7168) == 0) {
                                i25 = i34 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i25 = i34;
                            }
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                            if ((i5 & 57344) == 0) {
                                i27 = i25 | (composerStartRestartGroup.changed(function1) ? 16384 : 8192);
                            }
                            if ((i5 & 458752) == 0) {
                                i27 |= ((i6 & 32768) == 0 && composerStartRestartGroup.changed(textStyle)) ? 131072 : 65536;
                            }
                            if ((i7 & 1533916891) != 306783378 && (i27 & 374491) == 74898 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                textDecoration2 = textDecoration;
                                textAlign3 = textAlign;
                                i30 = i;
                                z3 = z;
                                i28 = i2;
                                function13 = function1;
                                textStyle3 = textStyle;
                                composer2 = composerStartRestartGroup;
                                j10 = jM18561getUnspecified0d7_KjU;
                                j11 = jM21172getUnspecifiedXSAIIZE;
                                fontWeight4 = fontWeight2;
                                fontFamily4 = fontFamily2;
                                j12 = j3;
                                j13 = j5;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i9 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i8 != 0) {
                                        jM18561getUnspecified0d7_KjU = Color.INSTANCE.m18561getUnspecified0d7_KjU();
                                    }
                                    if (i10 != 0) {
                                        jM21172getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE();
                                    }
                                    if (i11 != 0) {
                                        fontStyle2 = null;
                                    }
                                    if (i12 != 0) {
                                        fontWeight2 = null;
                                    }
                                    if (i13 != 0) {
                                        fontFamily2 = null;
                                    }
                                    long jM21172getUnspecifiedXSAIIZE2 = i14 == 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j3;
                                    TextDecoration textDecoration3 = i15 == 0 ? null : textDecoration;
                                    TextAlign textAlign4 = i17 == 0 ? textAlign : null;
                                    long jM21172getUnspecifiedXSAIIZE3 = i19 == 0 ? TextUnit.INSTANCE.m21172getUnspecifiedXSAIIZE() : j5;
                                    iM20906getClipgIe3tQ8 = i21 == 0 ? TextOverflow.INSTANCE.m20906getClipgIe3tQ8() : i;
                                    z2 = i22 == 0 ? true : z;
                                    i28 = i24 == 0 ? Integer.MAX_VALUE : i2;
                                    function12 = i26 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull TextLayoutResult it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }
                                    } : function1;
                                    TextAlign textAlign5 = textAlign4;
                                    if ((i6 & 32768) == 0) {
                                        textStyle2 = (TextStyle) composerStartRestartGroup.consume(LocalTextStyle);
                                        i27 &= -458753;
                                        textAlign2 = textAlign5;
                                    } else {
                                        textAlign2 = textAlign5;
                                        textStyle2 = textStyle;
                                    }
                                    textDecoration2 = textDecoration3;
                                    fontStyle3 = fontStyle2;
                                    j6 = jM21172getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    j7 = jM21172getUnspecifiedXSAIIZE2;
                                    i29 = i27;
                                    j8 = jM21172getUnspecifiedXSAIIZE3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i6 & 32768) != 0) {
                                        i27 &= -458753;
                                    }
                                    j7 = j3;
                                    textDecoration2 = textDecoration;
                                    textAlign2 = textAlign;
                                    j8 = j5;
                                    iM20906getClipgIe3tQ8 = i;
                                    z2 = z;
                                    i28 = i2;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    fontStyle3 = fontStyle2;
                                    j6 = jM21172getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    i29 = i27;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-366126944, i7, i29, "androidx.compose.material.Text (Text.kt:90)");
                                }
                                composerStartRestartGroup.startReplaceableGroup(1557613088);
                                companion = Color.INSTANCE;
                                if (jM18561getUnspecified0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                                    j9 = jM18561getUnspecified0d7_KjU;
                                } else {
                                    long jM20486getColor0d7_KjU = textStyle2.m20486getColor0d7_KjU();
                                    if (jM20486getColor0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                                        jM20486getColor0d7_KjU = Color.m18524copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                    }
                                    j9 = jM20486getColor0d7_KjU;
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                int i35 = (i7 & 126) | ((i29 >> 3) & 7168);
                                int i36 = i29 << 9;
                                BasicTextKt.m16146BasicTextBpD7jsM(text, modifier2, textStyle2.merge(new TextStyle(j9, j6, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, j7, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j8, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), function12, iM20906getClipgIe3tQ8, z2, i28, composerStartRestartGroup, (i36 & 3670016) | i35 | (i36 & 57344) | (i36 & 458752), 0);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i30 = iM20906getClipgIe3tQ8;
                                j10 = jM18561getUnspecified0d7_KjU;
                                z3 = z2;
                                function13 = function12;
                                j11 = j6;
                                fontWeight4 = fontWeight3;
                                fontStyle2 = fontStyle3;
                                fontFamily4 = fontFamily3;
                                j12 = j7;
                                textAlign3 = textAlign2;
                                j13 = j8;
                                textStyle3 = textStyle2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                return;
                            }
                            final Modifier modifier3 = modifier2;
                            final TextDecoration textDecoration4 = textDecoration2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i37) {
                                    TextKt.m16944TextfLXpl1I(text, modifier3, j10, j11, fontStyle2, fontWeight4, fontFamily4, j12, textDecoration4, textAlign3, j13, i30, z3, i28, function13, textStyle3, composer3, i4 | 1, i5, i6);
                                }
                            });
                            return;
                        }
                        i25 |= 24576;
                        i27 = i25;
                        if ((i5 & 458752) == 0) {
                        }
                        if ((i7 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i4 & 1) != 0) {
                                if (i9 != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i17 == 0) {
                                }
                                if (i19 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                TextAlign textAlign52 = textAlign4;
                                if ((i6 & 32768) == 0) {
                                }
                                textDecoration2 = textDecoration3;
                                fontStyle3 = fontStyle2;
                                j6 = jM21172getUnspecifiedXSAIIZE;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                j7 = jM21172getUnspecifiedXSAIIZE2;
                                i29 = i27;
                                j8 = jM21172getUnspecifiedXSAIIZE3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.startReplaceableGroup(1557613088);
                                companion = Color.INSTANCE;
                                if (jM18561getUnspecified0d7_KjU == companion.m18561getUnspecified0d7_KjU()) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                int i352 = (i7 & 126) | ((i29 >> 3) & 7168);
                                int i362 = i29 << 9;
                                BasicTextKt.m16146BasicTextBpD7jsM(text, modifier2, textStyle2.merge(new TextStyle(j9, j6, fontWeight3, fontStyle3, (FontSynthesis) null, fontFamily3, (String) null, j7, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, j8, (TextIndent) null, 175952, (DefaultConstructorMarker) null)), function12, iM20906getClipgIe3tQ8, z2, i28, composerStartRestartGroup, (i362 & 3670016) | i352 | (i362 & 57344) | (i362 & 458752), 0);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i30 = iM20906getClipgIe3tQ8;
                                j10 = jM18561getUnspecified0d7_KjU;
                                z3 = z2;
                                function13 = function12;
                                j11 = j6;
                                fontWeight4 = fontWeight3;
                                fontStyle2 = fontStyle3;
                                fontFamily4 = fontFamily3;
                                j12 = j7;
                                textAlign3 = textAlign2;
                                j13 = j8;
                                textStyle3 = textStyle2;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    int i322 = i20;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i27 = i25;
                    if ((i5 & 458752) == 0) {
                    }
                    if ((i7 & 1533916891) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i17 = i16;
                i18 = i6 & 1024;
                if (i18 == 0) {
                }
                i21 = i6 & 2048;
                if (i21 == 0) {
                }
                int i3222 = i20;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i27 = i25;
                if ((i5 & 458752) == 0) {
                }
                if ((i7 & 1533916891) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i16 = i6 & 512;
            if (i16 != 0) {
            }
            i17 = i16;
            i18 = i6 & 1024;
            if (i18 == 0) {
            }
            i21 = i6 & 2048;
            if (i21 == 0) {
            }
            int i32222 = i20;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i27 = i25;
            if ((i5 & 458752) == 0) {
            }
            if ((i7 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i10 = i6 & 8;
        if (i10 == 0) {
        }
        i11 = i6 & 16;
        if (i11 == 0) {
        }
        i12 = i6 & 32;
        if (i12 == 0) {
        }
        i13 = i6 & 64;
        if (i13 == 0) {
        }
        i14 = i6 & 128;
        if (i14 == 0) {
        }
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i6 & 512;
        if (i16 != 0) {
        }
        i17 = i16;
        i18 = i6 & 1024;
        if (i18 == 0) {
        }
        i21 = i6 & 2048;
        if (i21 == 0) {
        }
        int i322222 = i20;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i27 = i25;
        if ((i5 & 458752) == 0) {
        }
        if ((i7 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
