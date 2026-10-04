package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutIdParentData;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.TextStyleKt;
import androidx.compose.p109ui.text.input.TransformedText;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, m13886d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", TokenizerME.NO_SPLIT, "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;

    @NotNull
    private static final Modifier IconDefaultSizeModifier;

    @NotNull
    public static final String LabelId = "Label";

    @NotNull
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;

    @NotNull
    public static final String PlaceholderId = "Hint";

    @NotNull
    public static final String TextFieldId = "TextField";

    @NotNull
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C2256Dp.m20968constructorimpl(16);
    private static final float HorizontalIconPadding = C2256Dp.m20968constructorimpl(12);

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m15883defaultMinSizeVpY3zN4(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0407 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(@NotNull final TextFieldType type, @NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, @NotNull final VisualTransformation visualTransformation, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z, boolean z2, boolean z3, @NotNull final InteractionSource interactionSource, @NotNull final PaddingValues contentPadding, @NotNull final TextFieldColors colors, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, @Nullable Composer composer, final int i, final int i2, final int i4) {
        final int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Function2<? super Composer, ? super Integer, Unit> function27;
        boolean zChanged;
        Object objRememberedValue;
        Function3<InputPhase, Composer, Integer, Color> function3;
        InputPhase inputPhase;
        long jM20486getColor0d7_KjU;
        Color.Companion companion;
        boolean z4;
        InputPhase inputPhase2;
        long jM20486getColor0d7_KjU2;
        Composer composer2;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z8 = false;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-712568069);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(type) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(innerTextField) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((i & 57344) == 0) {
            i5 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        int i17 = i4 & 32;
        if (i17 != 0) {
            i5 |= 196608;
            function26 = function22;
        } else {
            function26 = function22;
            if ((i & 458752) == 0) {
                i5 |= composerStartRestartGroup.changed(function26) ? 131072 : 65536;
            }
        }
        int i18 = i4 & 64;
        if (i18 != 0) {
            i5 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i5 |= composerStartRestartGroup.changed(function23) ? 1048576 : 524288;
        }
        int i19 = i4 & 128;
        if (i19 != 0) {
            i5 |= 12582912;
        } else {
            if ((i & 29360128) == 0) {
                i6 = i19;
                i5 |= composerStartRestartGroup.changed(function24) ? 8388608 : 4194304;
            }
            i7 = i4 & 256;
            if (i7 == 0) {
                i5 |= 100663296;
            } else {
                if ((i & 234881024) == 0) {
                    i8 = i7;
                    i5 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                }
                i9 = i4 & 512;
                if (i9 == 0) {
                    if ((i & 1879048192) == 0) {
                        i10 = i9;
                        i5 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                    }
                    i11 = i4 & 1024;
                    if (i11 == 0) {
                        i13 = i2 | 6;
                        i12 = i11;
                    } else if ((i2 & 14) == 0) {
                        i12 = i11;
                        i13 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                    } else {
                        i12 = i11;
                        i13 = i2;
                    }
                    if ((i4 & 2048) == 0) {
                        i13 |= 48;
                    } else if ((i2 & 112) == 0) {
                        i13 |= composerStartRestartGroup.changed(interactionSource) ? 32 : 16;
                    }
                    int i20 = i13;
                    if ((i4 & 4096) == 0) {
                        i20 |= 384;
                    } else if ((i2 & 896) == 0) {
                        i20 |= composerStartRestartGroup.changed(contentPadding) ? 256 : 128;
                    }
                    if ((i4 & 8192) == 0) {
                        i20 |= 3072;
                    } else if ((i2 & 7168) == 0) {
                        i20 |= composerStartRestartGroup.changed(colors) ? 2048 : 1024;
                    }
                    i14 = i4 & 16384;
                    if (i14 == 0) {
                        i16 = i20 | 24576;
                    } else {
                        if ((i2 & 57344) == 0) {
                            i15 = i20 | (composerStartRestartGroup.changed(function25) ? 16384 : 8192);
                        } else {
                            i15 = i20;
                        }
                        i16 = i15;
                    }
                    if ((i5 & 1533916891) != 306783378 && (46811 & i16) == 9362 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function28 = function23;
                        function211 = function24;
                        z7 = z3;
                        function210 = function25;
                        function29 = function26;
                        composer2 = composerStartRestartGroup;
                        z6 = z;
                        z5 = z2;
                    } else {
                        Function2<? super Composer, ? super Integer, Unit> function212 = i17 == 0 ? null : function26;
                        Function2<? super Composer, ? super Integer, Unit> function213 = i18 == 0 ? null : function23;
                        Function2<? super Composer, ? super Integer, Unit> function214 = i6 == 0 ? null : function24;
                        boolean z9 = i8 == 0 ? false : z;
                        boolean z10 = i10 == 0 ? true : z2;
                        boolean z11 = i12 == 0 ? false : z3;
                        Function2<? super Composer, ? super Integer, Unit> function215 = i14 == 0 ? function25 : null;
                        if (ComposerKt.isTraceInProgress()) {
                            function27 = function215;
                        } else {
                            function27 = function215;
                            ComposerKt.traceEventStart(-712568069, i5, i16, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final String text = ((TransformedText) objRememberedValue).getText().getText();
                        InputPhase inputPhase3 = !FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i16 >> 3) & 14).getValue().booleanValue() ? InputPhase.Focused : text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                        final boolean z12 = z11;
                        final boolean z13 = z10;
                        final int i21 = i16;
                        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase4, Composer composer3, Integer num) {
                                return Color.m18515boximpl(m16933invokeXeAY9LY(inputPhase4, composer3, num.intValue()));
                            }

                            @Composable
                            /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                            public final long m16933invokeXeAY9LY(@NotNull InputPhase it, @Nullable Composer composer3, int i22) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                composer3.startReplaceableGroup(697243846);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(697243846, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                                }
                                TextFieldColors textFieldColors = colors;
                                boolean z14 = z13;
                                boolean z15 = it == InputPhase.UnfocusedEmpty ? false : z12;
                                InteractionSource interactionSource2 = interactionSource;
                                int i23 = (i5 >> 27) & 14;
                                int i24 = i21;
                                long jM18535unboximpl = textFieldColors.labelColor(z14, z15, interactionSource2, composer3, i23 | ((i24 << 3) & 896) | (i24 & 7168)).getValue().m18535unboximpl();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceableGroup();
                                return jM18535unboximpl;
                            }
                        };
                        final Function2<? super Composer, ? super Integer, Unit> function216 = function212;
                        final int i22 = i5;
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle1 = typography.getSubtitle1();
                        TextStyle caption = typography.getCaption();
                        inputPhase = inputPhase3;
                        jM20486getColor0d7_KjU = subtitle1.m20486getColor0d7_KjU();
                        companion = Color.INSTANCE;
                        if ((Color.m18526equalsimpl0(jM20486getColor0d7_KjU, companion.m18561getUnspecified0d7_KjU()) || Color.m18526equalsimpl0(caption.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU())) && (Color.m18526equalsimpl0(subtitle1.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU()) || !Color.m18526equalsimpl0(caption.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU()))) {
                            z4 = false;
                        } else {
                            z4 = false;
                            z8 = true;
                        }
                        TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(2129141006);
                        long jM20486getColor0d7_KjU3 = materialTheme.getTypography(composerStartRestartGroup, 6).getCaption().m20486getColor0d7_KjU();
                        if (z8 && jM20486getColor0d7_KjU3 == companion.m18561getUnspecified0d7_KjU()) {
                            inputPhase2 = inputPhase;
                            jM20486getColor0d7_KjU3 = function3.invoke(inputPhase2, composerStartRestartGroup, 0).m18535unboximpl();
                        } else {
                            inputPhase2 = inputPhase;
                        }
                        long j = jM20486getColor0d7_KjU3;
                        composerStartRestartGroup.endReplaceableGroup();
                        jM20486getColor0d7_KjU2 = materialTheme.getTypography(composerStartRestartGroup, 6).getSubtitle1().m20486getColor0d7_KjU();
                        if (z8 && jM20486getColor0d7_KjU2 == companion.m18561getUnspecified0d7_KjU()) {
                            jM20486getColor0d7_KjU2 = function3.invoke(inputPhase2, composerStartRestartGroup, 0).m18535unboximpl();
                        }
                        long j2 = jM20486getColor0d7_KjU2;
                        final Function2<? super Composer, ? super Integer, Unit> function217 = function213;
                        final Function2<? super Composer, ? super Integer, Unit> function218 = function214;
                        final boolean z14 = z9;
                        final Function2<? super Composer, ? super Integer, Unit> function219 = function27;
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope.m16942TransitionDTcfvLk(inputPhase2, j, j2, function3, function2 == null ? true : z4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.3

                            /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[TextFieldType.values().length];
                                    iArr[TextFieldType.Filled.ordinal()] = 1;
                                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(6);
                            }

                            @Override // kotlin.jvm.functions.Function6
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f4, Composer composer3, Integer num) {
                                m16931invokeRIQooxk(f.floatValue(), color.m18535unboximpl(), color2.m18535unboximpl(), f4.floatValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                            public final void m16931invokeRIQooxk(final float f, long j3, final long j5, final float f4, @Nullable Composer composer3, int i23) {
                                int i24;
                                long j6;
                                int i25;
                                final float f5;
                                ComposableLambda composableLambda;
                                ComposableLambda composableLambda2;
                                final long jM18535unboximpl;
                                final long jM18535unboximpl2;
                                if ((i23 & 14) == 0) {
                                    i24 = (composer3.changed(f) ? 4 : 2) | i23;
                                } else {
                                    i24 = i23;
                                }
                                if ((i23 & 112) == 0) {
                                    j6 = j3;
                                    i24 |= composer3.changed(j6) ? 32 : 16;
                                } else {
                                    j6 = j3;
                                }
                                if ((i23 & 896) == 0) {
                                    i24 |= composer3.changed(j5) ? 256 : 128;
                                }
                                if ((i23 & 7168) == 0) {
                                    i24 |= composer3.changed(f4) ? 2048 : 1024;
                                }
                                if ((46811 & i24) == 9362 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(341865432, i24, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:118)");
                                }
                                final Function2<Composer, Integer, Unit> function220 = function2;
                                if (function220 != null) {
                                    final boolean z15 = z8;
                                    final int i26 = i24;
                                    final long j7 = j6;
                                    f5 = f;
                                    i25 = i26;
                                    composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i27) {
                                            if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(362863774, i27, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                            }
                                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                                            TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme2.getTypography(composer4, 6).getSubtitle1(), materialTheme2.getTypography(composer4, 6).getCaption(), f);
                                            boolean z16 = z15;
                                            long j8 = j7;
                                            if (z16) {
                                                textStyleLerp = TextStyle.m20465copyHL5avdY$default(textStyleLerp, j8, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, 262142, null);
                                            }
                                            TextFieldImplKt.m16930DecorationeuL9pac(j5, textStyleLerp, null, function220, composer4, ((i26 >> 6) & 14) | 384, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    i25 = i24;
                                    f5 = f;
                                    composableLambda = null;
                                }
                                if (function216 == null || text.length() != 0) {
                                    composableLambda2 = null;
                                } else {
                                    final TextFieldColors textFieldColors = colors;
                                    final boolean z16 = z13;
                                    final int i27 = i22;
                                    final int i28 = i21;
                                    final Function2<Composer, Integer, Unit> function221 = function216;
                                    composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                            invoke(modifier, composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@NotNull Modifier modifier, @Nullable Composer composer4, int i29) {
                                            int i30;
                                            Intrinsics.checkNotNullParameter(modifier, "modifier");
                                            if ((i29 & 14) == 0) {
                                                i30 = (composer4.changed(modifier) ? 4 : 2) | i29;
                                            } else {
                                                i30 = i29;
                                            }
                                            if ((i30 & 91) == 18 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1120552650, i29, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                            }
                                            Modifier modifierAlpha = AlphaKt.alpha(modifier, f4);
                                            TextFieldColors textFieldColors2 = textFieldColors;
                                            boolean z17 = z16;
                                            int i31 = i27;
                                            int i32 = i28;
                                            Function2<Composer, Integer, Unit> function222 = function221;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlpha);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            composer4.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer4.startReplaceableGroup(1188063364);
                                            TextFieldImplKt.m16930DecorationeuL9pac(textFieldColors2.placeholderColor(z17, composer4, ((i31 >> 27) & 14) | ((i32 >> 6) & 112)).getValue().m18535unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, (i31 >> 6) & 7168, 4);
                                            if (AbstractC1038a.m1225z(composer4)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16865getDefaultErrorMessageUdPEhr4(), composer3, 6);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                Object objValueOf = Boolean.valueOf(z12);
                                final boolean z17 = z12;
                                composer3.startReplaceableGroup(511388516);
                                boolean zChanged2 = composer3.changed(objValueOf) | composer3.changed(strM16870getString4foXLRw);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                            if (z17) {
                                                SemanticsPropertiesKt.error(semantics, strM16870getString4foXLRw);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue2, 1, null);
                                if (colors instanceof TextFieldColorsWithIcons) {
                                    composer3.startReplaceableGroup(-1083197894);
                                    TextFieldColorsWithIcons textFieldColorsWithIcons = (TextFieldColorsWithIcons) colors;
                                    boolean z18 = z13;
                                    boolean z19 = z12;
                                    InteractionSource interactionSource2 = interactionSource;
                                    int i29 = (i22 >> 27) & 14;
                                    int i30 = i21;
                                    jM18535unboximpl = textFieldColorsWithIcons.leadingIconColor(z18, z19, interactionSource2, composer3, ((i30 << 3) & 896) | i29 | ((i30 << 3) & 112)).getValue().m18535unboximpl();
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-1083197798);
                                    TextFieldColors textFieldColors2 = colors;
                                    boolean z20 = z13;
                                    boolean z21 = z12;
                                    int i31 = (i22 >> 27) & 14;
                                    int i32 = i21;
                                    jM18535unboximpl = textFieldColors2.leadingIconColor(z20, z21, composer3, i31 | ((i32 << 3) & 112) | ((i32 >> 3) & 896)).getValue().m18535unboximpl();
                                    composer3.endReplaceableGroup();
                                }
                                final Function2<Composer, Integer, Unit> function222 = function217;
                                ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i33) {
                                        if ((i33 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1505327088, i33, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:158)");
                                        }
                                        TextFieldImplKt.m16930DecorationeuL9pac(jM18535unboximpl, null, null, function222, composer4, 0, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                if (colors instanceof TextFieldColorsWithIcons) {
                                    composer3.startReplaceableGroup(-1083197452);
                                    TextFieldColorsWithIcons textFieldColorsWithIcons2 = (TextFieldColorsWithIcons) colors;
                                    boolean z22 = z13;
                                    boolean z23 = z12;
                                    InteractionSource interactionSource3 = interactionSource;
                                    int i33 = (i22 >> 27) & 14;
                                    int i34 = i21;
                                    jM18535unboximpl2 = textFieldColorsWithIcons2.trailingIconColor(z22, z23, interactionSource3, composer3, ((i34 << 3) & 896) | i33 | ((i34 << 3) & 112)).getValue().m18535unboximpl();
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-1083197355);
                                    TextFieldColors textFieldColors3 = colors;
                                    boolean z24 = z13;
                                    boolean z25 = z12;
                                    int i35 = (i22 >> 27) & 14;
                                    int i36 = i21;
                                    jM18535unboximpl2 = textFieldColors3.trailingIconColor(z24, z25, composer3, i35 | ((i36 << 3) & 112) | ((i36 >> 3) & 896)).getValue().m18535unboximpl();
                                    composer3.endReplaceableGroup();
                                }
                                final Function2<Composer, Integer, Unit> function223 = function218;
                                ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i37) {
                                        if ((i37 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1894727196, i37, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:169)");
                                        }
                                        TextFieldImplKt.m16930DecorationeuL9pac(jM18535unboximpl2, null, null, function223, composer4, 0, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                int i37 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                if (i37 == 1) {
                                    composer3.startReplaceableGroup(-1083197019);
                                    Function2<Composer, Integer, Unit> function224 = innerTextField;
                                    boolean z26 = z14;
                                    PaddingValues paddingValues = contentPadding;
                                    int i38 = i22;
                                    TextFieldKt.TextFieldLayout(modifierSemantics$default, function224, composableLambda, composableLambda2, composableLambda3, composableLambda4, z26, f, paddingValues, composer3, ((i21 << 18) & 234881024) | ((i38 >> 6) & 3670016) | ((i38 >> 3) & 112) | ((i25 << 21) & 29360128));
                                    composer3.endReplaceableGroup();
                                    Unit unit = Unit.INSTANCE;
                                } else if (i37 != 2) {
                                    composer3.startReplaceableGroup(-1083194976);
                                    composer3.endReplaceableGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    composer3.startReplaceableGroup(-1083196463);
                                    composer3.startReplaceableGroup(-492369756);
                                    Object objRememberedValue3 = composer3.rememberedValue();
                                    Composer.Companion companion3 = Composer.INSTANCE;
                                    if (objRememberedValue3 == companion3.getEmpty()) {
                                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m18341boximpl(Size.INSTANCE.m18362getZeroNHjbRc()), null, 2, null);
                                        composer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) objRememberedValue3;
                                    final PaddingValues paddingValues2 = contentPadding;
                                    final Function2<Composer, Integer, Unit> function225 = function219;
                                    final int i39 = i21;
                                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i40) {
                                            if ((i40 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(139886979, i40, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                            }
                                            Modifier modifierM16811outlineCutout12SF9DM = OutlinedTextFieldKt.m16811outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                            Function2<Composer, Integer, Unit> function226 = function225;
                                            int i41 = i39;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16811outlineCutout12SF9DM);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            composer4.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer4.startReplaceableGroup(1029492925);
                                            if (function226 != null) {
                                                function226.invoke(composer4, Integer.valueOf((i41 >> 12) & 14));
                                            }
                                            if (AbstractC1038a.m1225z(composer4)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function226 = innerTextField;
                                    ComposableLambda composableLambda6 = composableLambda2;
                                    boolean z27 = z14;
                                    Object objValueOf2 = Float.valueOf(f5);
                                    composer3.startReplaceableGroup(511388516);
                                    boolean zChanged3 = composer3.changed(objValueOf2) | composer3.changed(mutableState);
                                    Object objRememberedValue4 = composer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue4 == companion3.getEmpty()) {
                                        objRememberedValue4 = new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                m16932invokeuvyYCjk(size.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                            public final void m16932invokeuvyYCjk(long j8) {
                                                float fM18353getWidthimpl = Size.m18353getWidthimpl(j8) * f5;
                                                float fM18350getHeightimpl = Size.m18350getHeightimpl(j8) * f5;
                                                if (Size.m18353getWidthimpl(mutableState.getValue().getPackedValue()) == fM18353getWidthimpl && Size.m18350getHeightimpl(mutableState.getValue().getPackedValue()) == fM18350getHeightimpl) {
                                                    return;
                                                }
                                                mutableState.setValue(Size.m18341boximpl(androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18350getHeightimpl)));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue4);
                                    }
                                    composer3.endReplaceableGroup();
                                    PaddingValues paddingValues3 = contentPadding;
                                    int i40 = i22;
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function226, composableLambda6, composableLambda, composableLambda3, composableLambda4, z27, f5, (Function1) objRememberedValue4, composableLambda5, paddingValues3, composer3, (3670016 & (i40 >> 6)) | ((i40 >> 3) & 112) | DriveFile.MODE_READ_WRITE | ((i25 << 21) & 29360128), (i21 >> 6) & 14);
                                    composer3.endReplaceableGroup();
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z13;
                        function28 = function217;
                        function29 = function216;
                        function210 = function219;
                        function211 = function218;
                        z6 = z14;
                        z7 = z12;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.4
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

                        public final void invoke(@Nullable Composer composer3, int i23) {
                            TextFieldImplKt.CommonDecorationBox(type, value, innerTextField, visualTransformation, function2, function29, function28, function211, z6, z5, z7, interactionSource, contentPadding, colors, function210, composer3, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i5 |= DriveFile.MODE_READ_WRITE;
                i10 = i9;
                i11 = i4 & 1024;
                if (i11 == 0) {
                }
                if ((i4 & 2048) == 0) {
                }
                int i202 = i13;
                if ((i4 & 4096) == 0) {
                }
                if ((i4 & 8192) == 0) {
                }
                i14 = i4 & 16384;
                if (i14 == 0) {
                }
                if ((i5 & 1533916891) != 306783378) {
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceableGroup();
                        final String text2 = ((TransformedText) objRememberedValue).getText().getText();
                        if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i16 >> 3) & 14).getValue().booleanValue()) {
                        }
                        final boolean z122 = z11;
                        final boolean z132 = z10;
                        final int i212 = i16;
                        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase4, Composer composer3, Integer num) {
                                return Color.m18515boximpl(m16933invokeXeAY9LY(inputPhase4, composer3, num.intValue()));
                            }

                            @Composable
                            /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                            public final long m16933invokeXeAY9LY(@NotNull InputPhase it, @Nullable Composer composer3, int i222) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                composer3.startReplaceableGroup(697243846);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(697243846, i222, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                                }
                                TextFieldColors textFieldColors = colors;
                                boolean z142 = z132;
                                boolean z15 = it == InputPhase.UnfocusedEmpty ? false : z122;
                                InteractionSource interactionSource2 = interactionSource;
                                int i23 = (i5 >> 27) & 14;
                                int i24 = i212;
                                long jM18535unboximpl = textFieldColors.labelColor(z142, z15, interactionSource2, composer3, i23 | ((i24 << 3) & 896) | (i24 & 7168)).getValue().m18535unboximpl();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceableGroup();
                                return jM18535unboximpl;
                            }
                        };
                        final Function2<? super Composer, ? super Integer, Unit> function2162 = function212;
                        final int i222 = i5;
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        Typography typography2 = materialTheme2.getTypography(composerStartRestartGroup, 6);
                        TextStyle subtitle12 = typography2.getSubtitle1();
                        TextStyle caption2 = typography2.getCaption();
                        inputPhase = inputPhase3;
                        jM20486getColor0d7_KjU = subtitle12.m20486getColor0d7_KjU();
                        companion = Color.INSTANCE;
                        if (Color.m18526equalsimpl0(jM20486getColor0d7_KjU, companion.m18561getUnspecified0d7_KjU())) {
                            z4 = false;
                            TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(2129141006);
                            long jM20486getColor0d7_KjU32 = materialTheme2.getTypography(composerStartRestartGroup, 6).getCaption().m20486getColor0d7_KjU();
                            if (z8) {
                                inputPhase2 = inputPhase;
                                long j3 = jM20486getColor0d7_KjU32;
                                composerStartRestartGroup.endReplaceableGroup();
                                jM20486getColor0d7_KjU2 = materialTheme2.getTypography(composerStartRestartGroup, 6).getSubtitle1().m20486getColor0d7_KjU();
                                if (z8) {
                                    jM20486getColor0d7_KjU2 = function3.invoke(inputPhase2, composerStartRestartGroup, 0).m18535unboximpl();
                                }
                                long j22 = jM20486getColor0d7_KjU2;
                                final Function2<? super Composer, ? super Integer, Unit> function2172 = function213;
                                final Function2<? super Composer, ? super Integer, Unit> function2182 = function214;
                                final boolean z142 = z9;
                                final Function2<? super Composer, ? super Integer, Unit> function2192 = function27;
                                composer2 = composerStartRestartGroup;
                                textFieldTransitionScope2.m16942TransitionDTcfvLk(inputPhase2, j3, j22, function3, function2 == null ? true : z4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.3

                                    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[TextFieldType.values().length];
                                            iArr[TextFieldType.Filled.ordinal()] = 1;
                                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                                            $EnumSwitchMapping$0 = iArr;
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(6);
                                    }

                                    @Override // kotlin.jvm.functions.Function6
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f4, Composer composer3, Integer num) {
                                        m16931invokeRIQooxk(f.floatValue(), color.m18535unboximpl(), color2.m18535unboximpl(), f4.floatValue(), composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                                    public final void m16931invokeRIQooxk(final float f, long j32, final long j5, final float f4, @Nullable Composer composer3, int i23) {
                                        int i24;
                                        long j6;
                                        int i25;
                                        final float f5;
                                        ComposableLambda composableLambda;
                                        ComposableLambda composableLambda2;
                                        final long jM18535unboximpl;
                                        final long jM18535unboximpl2;
                                        if ((i23 & 14) == 0) {
                                            i24 = (composer3.changed(f) ? 4 : 2) | i23;
                                        } else {
                                            i24 = i23;
                                        }
                                        if ((i23 & 112) == 0) {
                                            j6 = j32;
                                            i24 |= composer3.changed(j6) ? 32 : 16;
                                        } else {
                                            j6 = j32;
                                        }
                                        if ((i23 & 896) == 0) {
                                            i24 |= composer3.changed(j5) ? 256 : 128;
                                        }
                                        if ((i23 & 7168) == 0) {
                                            i24 |= composer3.changed(f4) ? 2048 : 1024;
                                        }
                                        if ((46811 & i24) == 9362 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(341865432, i24, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:118)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function2;
                                        if (function220 != null) {
                                            final boolean z15 = z8;
                                            final int i26 = i24;
                                            final long j7 = j6;
                                            f5 = f;
                                            i25 = i26;
                                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer4, int i27) {
                                                    if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(362863774, i27, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                                    }
                                                    MaterialTheme materialTheme22 = MaterialTheme.INSTANCE;
                                                    TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme22.getTypography(composer4, 6).getSubtitle1(), materialTheme22.getTypography(composer4, 6).getCaption(), f);
                                                    boolean z16 = z15;
                                                    long j8 = j7;
                                                    if (z16) {
                                                        textStyleLerp = TextStyle.m20465copyHL5avdY$default(textStyleLerp, j8, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, 262142, null);
                                                    }
                                                    TextFieldImplKt.m16930DecorationeuL9pac(j5, textStyleLerp, null, function220, composer4, ((i26 >> 6) & 14) | 384, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                        } else {
                                            i25 = i24;
                                            f5 = f;
                                            composableLambda = null;
                                        }
                                        if (function2162 == null || text2.length() != 0) {
                                            composableLambda2 = null;
                                        } else {
                                            final TextFieldColors textFieldColors = colors;
                                            final boolean z16 = z132;
                                            final int i27 = i222;
                                            final int i28 = i212;
                                            final Function2<? super Composer, ? super Integer, Unit> function221 = function2162;
                                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                                    invoke(modifier, composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@NotNull Modifier modifier, @Nullable Composer composer4, int i29) {
                                                    int i30;
                                                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                                                    if ((i29 & 14) == 0) {
                                                        i30 = (composer4.changed(modifier) ? 4 : 2) | i29;
                                                    } else {
                                                        i30 = i29;
                                                    }
                                                    if ((i30 & 91) == 18 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1120552650, i29, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                    }
                                                    Modifier modifierAlpha = AlphaKt.alpha(modifier, f4);
                                                    TextFieldColors textFieldColors2 = textFieldColors;
                                                    boolean z17 = z16;
                                                    int i31 = i27;
                                                    int i32 = i28;
                                                    Function2<Composer, Integer, Unit> function222 = function221;
                                                    composer4.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer4, 0, -1323940314);
                                                    Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierAlpha);
                                                    if (composer4.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    composer4.disableReusing();
                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                    composer4.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer4.startReplaceableGroup(1188063364);
                                                    TextFieldImplKt.m16930DecorationeuL9pac(textFieldColors2.placeholderColor(z17, composer4, ((i31 >> 27) & 14) | ((i32 >> 6) & 112)).getValue().m18535unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, (i31 >> 6) & 7168, 4);
                                                    if (AbstractC1038a.m1225z(composer4)) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                        }
                                        final String strM16870getString4foXLRw = Strings_androidKt.m16870getString4foXLRw(Strings.INSTANCE.m16865getDefaultErrorMessageUdPEhr4(), composer3, 6);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        Object objValueOf = Boolean.valueOf(z122);
                                        final boolean z17 = z122;
                                        composer3.startReplaceableGroup(511388516);
                                        boolean zChanged2 = composer3.changed(objValueOf) | composer3.changed(strM16870getString4foXLRw);
                                        Object objRememberedValue2 = composer3.rememberedValue();
                                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                    if (z17) {
                                                        SemanticsPropertiesKt.error(semantics, strM16870getString4foXLRw);
                                                    }
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        composer3.endReplaceableGroup();
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue2, 1, null);
                                        if (colors instanceof TextFieldColorsWithIcons) {
                                            composer3.startReplaceableGroup(-1083197894);
                                            TextFieldColorsWithIcons textFieldColorsWithIcons = (TextFieldColorsWithIcons) colors;
                                            boolean z18 = z132;
                                            boolean z19 = z122;
                                            InteractionSource interactionSource2 = interactionSource;
                                            int i29 = (i222 >> 27) & 14;
                                            int i30 = i212;
                                            jM18535unboximpl = textFieldColorsWithIcons.leadingIconColor(z18, z19, interactionSource2, composer3, ((i30 << 3) & 896) | i29 | ((i30 << 3) & 112)).getValue().m18535unboximpl();
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-1083197798);
                                            TextFieldColors textFieldColors2 = colors;
                                            boolean z20 = z132;
                                            boolean z21 = z122;
                                            int i31 = (i222 >> 27) & 14;
                                            int i32 = i212;
                                            jM18535unboximpl = textFieldColors2.leadingIconColor(z20, z21, composer3, i31 | ((i32 << 3) & 112) | ((i32 >> 3) & 896)).getValue().m18535unboximpl();
                                            composer3.endReplaceableGroup();
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function222 = function2172;
                                        ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i33) {
                                                if ((i33 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1505327088, i33, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:158)");
                                                }
                                                TextFieldImplKt.m16930DecorationeuL9pac(jM18535unboximpl, null, null, function222, composer4, 0, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        if (colors instanceof TextFieldColorsWithIcons) {
                                            composer3.startReplaceableGroup(-1083197452);
                                            TextFieldColorsWithIcons textFieldColorsWithIcons2 = (TextFieldColorsWithIcons) colors;
                                            boolean z22 = z132;
                                            boolean z23 = z122;
                                            InteractionSource interactionSource3 = interactionSource;
                                            int i33 = (i222 >> 27) & 14;
                                            int i34 = i212;
                                            jM18535unboximpl2 = textFieldColorsWithIcons2.trailingIconColor(z22, z23, interactionSource3, composer3, ((i34 << 3) & 896) | i33 | ((i34 << 3) & 112)).getValue().m18535unboximpl();
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-1083197355);
                                            TextFieldColors textFieldColors3 = colors;
                                            boolean z24 = z132;
                                            boolean z25 = z122;
                                            int i35 = (i222 >> 27) & 14;
                                            int i36 = i212;
                                            jM18535unboximpl2 = textFieldColors3.trailingIconColor(z24, z25, composer3, i35 | ((i36 << 3) & 112) | ((i36 >> 3) & 896)).getValue().m18535unboximpl();
                                            composer3.endReplaceableGroup();
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function223 = function2182;
                                        ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i37) {
                                                if ((i37 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1894727196, i37, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:169)");
                                                }
                                                TextFieldImplKt.m16930DecorationeuL9pac(jM18535unboximpl2, null, null, function223, composer4, 0, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        int i37 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                        if (i37 == 1) {
                                            composer3.startReplaceableGroup(-1083197019);
                                            Function2<Composer, Integer, Unit> function224 = innerTextField;
                                            boolean z26 = z142;
                                            PaddingValues paddingValues = contentPadding;
                                            int i38 = i222;
                                            TextFieldKt.TextFieldLayout(modifierSemantics$default, function224, composableLambda, composableLambda2, composableLambda3, composableLambda4, z26, f, paddingValues, composer3, ((i212 << 18) & 234881024) | ((i38 >> 6) & 3670016) | ((i38 >> 3) & 112) | ((i25 << 21) & 29360128));
                                            composer3.endReplaceableGroup();
                                            Unit unit = Unit.INSTANCE;
                                        } else if (i37 != 2) {
                                            composer3.startReplaceableGroup(-1083194976);
                                            composer3.endReplaceableGroup();
                                            Unit unit2 = Unit.INSTANCE;
                                        } else {
                                            composer3.startReplaceableGroup(-1083196463);
                                            composer3.startReplaceableGroup(-492369756);
                                            Object objRememberedValue3 = composer3.rememberedValue();
                                            Composer.Companion companion3 = Composer.INSTANCE;
                                            if (objRememberedValue3 == companion3.getEmpty()) {
                                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m18341boximpl(Size.INSTANCE.m18362getZeroNHjbRc()), null, 2, null);
                                                composer3.updateRememberedValue(objRememberedValue3);
                                            }
                                            composer3.endReplaceableGroup();
                                            final MutableState<Size> mutableState = (MutableState) objRememberedValue3;
                                            final PaddingValues paddingValues2 = contentPadding;
                                            final Function2<? super Composer, ? super Integer, Unit> function225 = function2192;
                                            final int i39 = i212;
                                            ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                @Composable
                                                public final void invoke(@Nullable Composer composer4, int i40) {
                                                    if ((i40 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(139886979, i40, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                    }
                                                    Modifier modifierM16811outlineCutout12SF9DM = OutlinedTextFieldKt.m16811outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                    Function2<Composer, Integer, Unit> function226 = function225;
                                                    int i41 = i39;
                                                    composer4.startReplaceableGroup(733328855);
                                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                                    Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16811outlineCutout12SF9DM);
                                                    if (composer4.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    composer4.disableReusing();
                                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                    composer4.startReplaceableGroup(-2137368960);
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    composer4.startReplaceableGroup(1029492925);
                                                    if (function226 != null) {
                                                        function226.invoke(composer4, Integer.valueOf((i41 >> 12) & 14));
                                                    }
                                                    if (AbstractC1038a.m1225z(composer4)) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function226 = innerTextField;
                                            ComposableLambda composableLambda6 = composableLambda2;
                                            boolean z27 = z142;
                                            Object objValueOf2 = Float.valueOf(f5);
                                            composer3.startReplaceableGroup(511388516);
                                            boolean zChanged3 = composer3.changed(objValueOf2) | composer3.changed(mutableState);
                                            Object objRememberedValue4 = composer3.rememberedValue();
                                            if (zChanged3 || objRememberedValue4 == companion3.getEmpty()) {
                                                objRememberedValue4 = new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                        m16932invokeuvyYCjk(size.getPackedValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                    public final void m16932invokeuvyYCjk(long j8) {
                                                        float fM18353getWidthimpl = Size.m18353getWidthimpl(j8) * f5;
                                                        float fM18350getHeightimpl = Size.m18350getHeightimpl(j8) * f5;
                                                        if (Size.m18353getWidthimpl(mutableState.getValue().getPackedValue()) == fM18353getWidthimpl && Size.m18350getHeightimpl(mutableState.getValue().getPackedValue()) == fM18350getHeightimpl) {
                                                            return;
                                                        }
                                                        mutableState.setValue(Size.m18341boximpl(androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18350getHeightimpl)));
                                                    }
                                                };
                                                composer3.updateRememberedValue(objRememberedValue4);
                                            }
                                            composer3.endReplaceableGroup();
                                            PaddingValues paddingValues3 = contentPadding;
                                            int i40 = i222;
                                            OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function226, composableLambda6, composableLambda, composableLambda3, composableLambda4, z27, f5, (Function1) objRememberedValue4, composableLambda5, paddingValues3, composer3, (3670016 & (i40 >> 6)) | ((i40 >> 3) & 112) | DriveFile.MODE_READ_WRITE | ((i25 << 21) & 29360128), (i212 >> 6) & 14);
                                            composer3.endReplaceableGroup();
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 1769472);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z5 = z132;
                                function28 = function2172;
                                function29 = function2162;
                                function210 = function2192;
                                function211 = function2182;
                                z6 = z142;
                                z7 = z122;
                            }
                        } else {
                            z4 = false;
                            TextFieldTransitionScope textFieldTransitionScope22 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(2129141006);
                            long jM20486getColor0d7_KjU322 = materialTheme2.getTypography(composerStartRestartGroup, 6).getCaption().m20486getColor0d7_KjU();
                            if (z8) {
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i8 = i7;
            i9 = i4 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i4 & 1024;
            if (i11 == 0) {
            }
            if ((i4 & 2048) == 0) {
            }
            int i2022 = i13;
            if ((i4 & 4096) == 0) {
            }
            if ((i4 & 8192) == 0) {
            }
            i14 = i4 & 16384;
            if (i14 == 0) {
            }
            if ((i5 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i6 = i19;
        i7 = i4 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i4 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i4 & 1024;
        if (i11 == 0) {
        }
        if ((i4 & 2048) == 0) {
        }
        int i20222 = i13;
        if ((i4 & 4096) == 0) {
        }
        if ((i4 & 8192) == 0) {
        }
        i14 = i4 & 16384;
        if (i14 == 0) {
        }
        if ((i5 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @ComposableOpenTarget(index = 0)
    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m16930DecorationeuL9pac(final long j, @Nullable TextStyle textStyle, @Nullable Float f, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Float f4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-399493340);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f4 = f;
        } else {
            if (i5 != 0) {
                textStyle = null;
            }
            final Float f5 = i6 != 0 ? null : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, i4, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:231)");
            }
            final int i7 = i4;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i8) {
                    if ((i8 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(494684590, i8, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:237)");
                    }
                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j))};
                    final Float f6 = f5;
                    final Function2<Composer, Integer, Unit> function2 = content;
                    final int i9 = i7;
                    final long j2 = j;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i10) {
                            if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1132188434, i10, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:238)");
                            }
                            if (f6 != null) {
                                composer3.startReplaceableGroup(-452622131);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f6)}, function2, composer3, ((i9 >> 6) & 112) | 8);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(-452621951);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m18527getAlphaimpl(j2)))}, function2, composer3, ((i9 >> 6) & 112) | 8);
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            if (textStyle != null) {
                composerStartRestartGroup.startReplaceableGroup(-2009952864);
                TextKt.ProvideTextStyle(textStyle, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2009952812);
                composableLambda.invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f4 = f5;
        }
        final TextStyle textStyle2 = textStyle;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

            public final void invoke(@Nullable Composer composer2, int i8) {
                TextFieldImplKt.m16930DecorationeuL9pac(j, textStyle2, f4, content, composer2, i | 1, i2);
            }
        });
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    @NotNull
    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    @Nullable
    public static final Object getLayoutId(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final int widthOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
