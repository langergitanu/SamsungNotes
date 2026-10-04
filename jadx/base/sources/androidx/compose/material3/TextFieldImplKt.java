package androidx.compose.material3;

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
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aò\u0001\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*2\u0006\u0010+\u001a\u00020,2\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0011\u0010<\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001¢\u0006\u0002\u0010=\u001a<\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u0012\u0010F\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\u001a\u0012\u0010I\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0013\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0019\u001a\u00020\u001aX\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m13886d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", TokenizerME.NO_SPLIT, "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;

    @NotNull
    public static final String ContainerId = "Container";

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
    public static final String SupportingId = "Supporting";

    @NotNull
    public static final String TextFieldId = "TextField";

    @NotNull
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C2256Dp.m20968constructorimpl(16);
    private static final float HorizontalIconPadding = C2256Dp.m20968constructorimpl(12);
    private static final float SupportingTopPadding = C2256Dp.m20968constructorimpl(4);

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m15883defaultMinSizeVpY3zN4(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0430 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0173  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(@NotNull final TextFieldType type, @NotNull final String value, @NotNull final Function2<? super Composer, ? super Integer, Unit> innerTextField, @NotNull final VisualTransformation visualTransformation, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z, boolean z2, boolean z3, @NotNull final InteractionSource interactionSource, @NotNull final PaddingValues contentPadding, @NotNull final TextFieldColors colors, @NotNull final Function2<? super Composer, ? super Integer, Unit> container, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
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
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean zChanged;
        Object objRememberedValue;
        InputPhase inputPhase;
        Function3<InputPhase, Composer, Integer, Color> function3;
        long jM20486getColor0d7_KjU;
        Color.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z4;
        long jM20486getColor0d7_KjU2;
        long jM20486getColor0d7_KjU3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(container, "container");
        Composer composerStartRestartGroup = composer.startRestartGroup(4948732);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = i | (composerStartRestartGroup.changed(type) ? 4 : 2);
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        int i17 = i5;
        if ((i4 & 4) != 0) {
            i17 |= 384;
        } else if ((i & 896) == 0) {
            i17 |= composerStartRestartGroup.changed(innerTextField) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i17 |= 3072;
        } else if ((i & 7168) == 0) {
            i17 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i17 |= 24576;
        } else if ((i & 57344) == 0) {
            i17 |= composerStartRestartGroup.changed(function2) ? 16384 : 8192;
        }
        int i18 = i4 & 32;
        if (i18 != 0) {
            i17 |= 196608;
        } else if ((i & 458752) == 0) {
            i17 |= composerStartRestartGroup.changed(function22) ? 131072 : 65536;
        }
        int i19 = i4 & 64;
        if (i19 != 0) {
            i17 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i17 |= composerStartRestartGroup.changed(function23) ? 1048576 : 524288;
        }
        int i20 = i4 & 128;
        if (i20 != 0) {
            i17 |= 12582912;
        } else {
            if ((i & 29360128) == 0) {
                i6 = i20;
                i17 |= composerStartRestartGroup.changed(function24) ? 8388608 : 4194304;
            }
            i7 = i4 & 256;
            if (i7 == 0) {
                i17 |= 100663296;
            } else {
                if ((i & 234881024) == 0) {
                    i8 = i7;
                    i17 |= composerStartRestartGroup.changed(function25) ? 67108864 : 33554432;
                }
                i9 = i4 & 512;
                if (i9 == 0) {
                    if ((i & 1879048192) == 0) {
                        i10 = i9;
                        i17 |= composerStartRestartGroup.changed(z) ? 536870912 : 268435456;
                    }
                    i11 = i4 & 1024;
                    if (i11 == 0) {
                        i13 = i2 | 6;
                        i12 = i11;
                    } else if ((i2 & 14) == 0) {
                        i12 = i11;
                        i13 = i2 | (composerStartRestartGroup.changed(z2) ? 4 : 2);
                    } else {
                        i12 = i11;
                        i13 = i2;
                    }
                    i14 = i4 & 2048;
                    if (i14 == 0) {
                        i13 |= 48;
                        i15 = i14;
                    } else if ((i2 & 112) == 0) {
                        i15 = i14;
                        i13 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
                    } else {
                        i15 = i14;
                    }
                    i16 = i13;
                    if ((i4 & 4096) == 0) {
                        i16 |= 384;
                    } else if ((i2 & 896) == 0) {
                        i16 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
                    }
                    if ((i4 & 8192) == 0) {
                        i16 |= 3072;
                    } else if ((i2 & 7168) == 0) {
                        i16 |= composerStartRestartGroup.changed(contentPadding) ? 2048 : 1024;
                    }
                    if ((i4 & 16384) == 0) {
                        i16 |= 24576;
                    } else if ((i2 & 57344) == 0) {
                        i16 |= composerStartRestartGroup.changed(colors) ? 16384 : 8192;
                    }
                    if ((32768 & i4) == 0) {
                        i16 |= 196608;
                    } else if ((i2 & 458752) == 0) {
                        i16 |= composerStartRestartGroup.changed(container) ? 131072 : 65536;
                    }
                    if ((1533916891 & i17) != 306783378 && (374491 & i16) == 74898 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function212 = function22;
                        function214 = function23;
                        function213 = function24;
                        function211 = function25;
                        z7 = z;
                        z5 = z3;
                        composer2 = composerStartRestartGroup;
                        z6 = z2;
                    } else {
                        Function2<? super Composer, ? super Integer, Unit> function215 = i18 == 0 ? null : function22;
                        function26 = i19 == 0 ? null : function23;
                        function27 = i6 == 0 ? null : function24;
                        Function2<? super Composer, ? super Integer, Unit> function216 = i8 == 0 ? function25 : null;
                        boolean z8 = i10 == 0 ? false : z;
                        final Function2<? super Composer, ? super Integer, Unit> function217 = function216;
                        boolean z9 = i12 == 0 ? true : z2;
                        boolean z10 = i15 == 0 ? false : z3;
                        if (ComposerKt.isTraceInProgress()) {
                            function28 = function215;
                        } else {
                            function28 = function215;
                            ComposerKt.traceEventStart(4948732, i17, i16, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:62)");
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
                        inputPhase = !FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i16 >> 6) & 14).getValue().booleanValue() ? InputPhase.Focused : text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                        final int i21 = i16;
                        final boolean z11 = z10;
                        final boolean z12 = z9;
                        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                                return Color.m18515boximpl(m17389invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                            }

                            @Composable
                            /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                            public final long m17389invokeXeAY9LY(@NotNull InputPhase it, @Nullable Composer composer3, int i22) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                composer3.startReplaceableGroup(-379813807);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-379813807, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                                }
                                TextFieldColors textFieldColors = colors;
                                boolean z13 = z12;
                                boolean z14 = z11;
                                InteractionSource interactionSource2 = interactionSource;
                                int i23 = i21;
                                long jM18535unboximpl = textFieldColors.labelColor$material3_release(z13, z14, interactionSource2, composer3, (i23 & Event.CAPS_LOCK) | ((i23 >> 3) & 7168)).getValue().m18535unboximpl();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceableGroup();
                                return jM18535unboximpl;
                            }
                        };
                        final int i22 = i17;
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge = typography.getBodyLarge();
                        final TextStyle bodySmall = typography.getBodySmall();
                        jM20486getColor0d7_KjU = bodyLarge.m20486getColor0d7_KjU();
                        companion = Color.INSTANCE;
                        if ((Color.m18526equalsimpl0(jM20486getColor0d7_KjU, companion.m18561getUnspecified0d7_KjU()) || Color.m18526equalsimpl0(bodySmall.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU())) && (Color.m18526equalsimpl0(bodyLarge.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU()) || !Color.m18526equalsimpl0(bodySmall.m20486getColor0d7_KjU(), companion.m18561getUnspecified0d7_KjU()))) {
                            function29 = function26;
                            function210 = function27;
                            z4 = false;
                        } else {
                            function29 = function26;
                            function210 = function27;
                            z4 = true;
                        }
                        TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388305);
                        jM20486getColor0d7_KjU2 = materialTheme.getTypography(composerStartRestartGroup, 6).getBodySmall().m20486getColor0d7_KjU();
                        if (z4 && jM20486getColor0d7_KjU2 == companion.m18561getUnspecified0d7_KjU()) {
                            jM20486getColor0d7_KjU2 = function3.invoke(inputPhase, composerStartRestartGroup, 0).m18535unboximpl();
                        }
                        long j = jM20486getColor0d7_KjU2;
                        composerStartRestartGroup.endReplaceableGroup();
                        jM20486getColor0d7_KjU3 = materialTheme.getTypography(composerStartRestartGroup, 6).getBodyLarge().m20486getColor0d7_KjU();
                        if (z4 && jM20486getColor0d7_KjU3 == companion.m18561getUnspecified0d7_KjU()) {
                            jM20486getColor0d7_KjU3 = function3.invoke(inputPhase, composerStartRestartGroup, 0).m18535unboximpl();
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                        final boolean z13 = z8;
                        InputPhase inputPhase2 = inputPhase;
                        final Function2<? super Composer, ? super Integer, Unit> function219 = function28;
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope.m17398TransitionDTcfvLk(inputPhase2, j, jM20486getColor0d7_KjU3, function3, function2 != null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1915872767, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox.3

                            /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
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
                                m17387invokeRIQooxk(f.floatValue(), color.m18535unboximpl(), color2.m18535unboximpl(), f4.floatValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                            public final void m17387invokeRIQooxk(final float f, long j2, final long j3, final float f4, @Nullable Composer composer3, int i23) {
                                int i24;
                                long j5;
                                int i25;
                                final float f5;
                                ComposableLambda composableLambda;
                                ComposableLambda composableLambda2;
                                ComposableLambda composableLambda3;
                                if ((i23 & 14) == 0) {
                                    i24 = (composer3.changed(f) ? 4 : 2) | i23;
                                } else {
                                    i24 = i23;
                                }
                                if ((i23 & 112) == 0) {
                                    j5 = j2;
                                    i24 |= composer3.changed(j5) ? 32 : 16;
                                } else {
                                    j5 = j2;
                                }
                                if ((i23 & 896) == 0) {
                                    i24 |= composer3.changed(j3) ? 256 : 128;
                                }
                                if ((i23 & 7168) == 0) {
                                    i24 |= composer3.changed(f4) ? 2048 : 1024;
                                }
                                if ((46811 & i24) == 9362 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1915872767, i24, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:112)");
                                }
                                final Function2<Composer, Integer, Unit> function220 = function2;
                                if (function220 != null) {
                                    final boolean z14 = z4;
                                    final int i26 = i24;
                                    final long j6 = j5;
                                    f5 = f;
                                    i25 = i26;
                                    composableLambda = ComposableLambdaKt.composableLambda(composer3, 1199990137, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i27) {
                                            if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1199990137, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:115)");
                                            }
                                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                                            TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme2.getTypography(composer4, 6).getBodyLarge(), materialTheme2.getTypography(composer4, 6).getBodySmall(), f);
                                            boolean z15 = z14;
                                            long j7 = j6;
                                            if (z15) {
                                                textStyleLerp = TextStyle.m20465copyHL5avdY$default(textStyleLerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, 262142, null);
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(j3, textStyleLerp, function220, composer4, (i26 >> 6) & 14, 0);
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
                                if (function219 == null || text.length() != 0) {
                                    composableLambda2 = null;
                                } else {
                                    final TextFieldColors textFieldColors = colors;
                                    final boolean z15 = z12;
                                    final int i27 = i21;
                                    final Function2<Composer, Integer, Unit> function221 = function219;
                                    final int i28 = i22;
                                    composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1472145357, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
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
                                                ComposerKt.traceEventStart(1472145357, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:129)");
                                            }
                                            Modifier modifierAlpha = AlphaKt.alpha(modifier, f4);
                                            TextFieldColors textFieldColors2 = textFieldColors;
                                            boolean z16 = z15;
                                            int i31 = i27;
                                            Function2<Composer, Integer, Unit> function222 = function221;
                                            int i32 = i28;
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
                                            composer4.startReplaceableGroup(828149203);
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(textFieldColors2.placeholderColor$material3_release(z16, composer4, (i31 & 14) | ((i31 >> 9) & 112)).getValue().m18535unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function222, composer4, (i32 >> 9) & 896, 0);
                                            if (AbstractC1038a.m1225z(composer4)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17309getDefaultErrorMessageadMyvUU(), composer3, 6);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                Object objValueOf = Boolean.valueOf(z11);
                                final boolean z16 = z11;
                                composer3.startReplaceableGroup(511388516);
                                boolean zChanged2 = composer3.changed(objValueOf) | composer3.changed(strM17317getStringNWtq28);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
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
                                            if (z16) {
                                                SemanticsPropertiesKt.error(semantics, strM17317getStringNWtq28);
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue2, 1, null);
                                TextFieldColors textFieldColors2 = colors;
                                boolean z17 = z12;
                                boolean z18 = z11;
                                InteractionSource interactionSource2 = interactionSource;
                                int i29 = i21;
                                final long jM18535unboximpl = textFieldColors2.leadingIconColor$material3_release(z17, z18, interactionSource2, composer3, (i29 & Event.CAPS_LOCK) | ((i29 >> 3) & 7168)).getValue().m18535unboximpl();
                                final Function2<Composer, Integer, Unit> function222 = function218;
                                ComposableLambda composableLambda4 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 175497959, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i30) {
                                        if ((i30 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(175497959, i30, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:148)");
                                        }
                                        TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl, null, function222, composer4, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                TextFieldColors textFieldColors3 = colors;
                                boolean z19 = z12;
                                boolean z20 = z11;
                                InteractionSource interactionSource3 = interactionSource;
                                int i30 = i21;
                                final long jM18535unboximpl2 = textFieldColors3.trailingIconColor$material3_release(z19, z20, interactionSource3, composer3, ((i30 >> 3) & 7168) | (i30 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                final Function2<Composer, Integer, Unit> function223 = function210;
                                ComposableLambda composableLambda5 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -432498573, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                    @Composable
                                    public final void invoke(@Nullable Composer composer4, int i31) {
                                        if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-432498573, i31, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:155)");
                                        }
                                        TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl2, null, function223, composer4, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                TextFieldColors textFieldColors4 = colors;
                                boolean z21 = z12;
                                boolean z22 = z11;
                                InteractionSource interactionSource4 = interactionSource;
                                int i31 = i21;
                                final long jM18535unboximpl3 = textFieldColors4.supportingTextColor$material3_release(z21, z22, interactionSource4, composer3, ((i31 >> 3) & 7168) | (i31 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                final Function2<Composer, Integer, Unit> function224 = function217;
                                if (function224 != null) {
                                    final TextStyle textStyle = bodySmall;
                                    composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -1269483524, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i32) {
                                            if ((i32 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1269483524, i32, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl3, textStyle, function224, composer4, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    composableLambda3 = null;
                                }
                                int i32 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                if (i32 == 1) {
                                    ComposableLambda composableLambda6 = composableLambda2;
                                    ComposableLambda composableLambda7 = composableLambda5;
                                    ComposableLambda composableLambda8 = composableLambda4;
                                    composer3.startReplaceableGroup(404041480);
                                    final Function2<Composer, Integer, Unit> function225 = container;
                                    final int i33 = i21;
                                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composer3, 1566950173, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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
                                        public final void invoke(@Nullable Composer composer4, int i34) {
                                            if ((i34 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1566950173, i34, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:170)");
                                            }
                                            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                            Function2<Composer, Integer, Unit> function226 = function225;
                                            int i35 = i33;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierLayoutId);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer4.startReplaceableGroup(1634460887);
                                            if (AbstractC1038a.m1199D(composer4, (i35 >> 15) & 14, function226)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function226 = innerTextField;
                                    boolean z23 = z13;
                                    PaddingValues paddingValues = contentPadding;
                                    int i34 = i22;
                                    TextFieldKt.TextFieldLayout(modifierSemantics$default, function226, composableLambda, composableLambda6, composableLambda8, composableLambda7, z23, f, composableLambda9, composableLambda3, paddingValues, composer3, (3670016 & (i34 >> 9)) | ((i34 >> 3) & 112) | 100663296 | ((i25 << 21) & 29360128), (i21 >> 9) & 14);
                                    composer3.endReplaceableGroup();
                                    Unit unit = Unit.INSTANCE;
                                } else if (i32 != 2) {
                                    composer3.startReplaceableGroup(404044016);
                                    composer3.endReplaceableGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    composer3.startReplaceableGroup(404042394);
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
                                    final Function2<Composer, Integer, Unit> function227 = container;
                                    final int i35 = i21;
                                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 787383072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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
                                        public final void invoke(@Nullable Composer composer4, int i36) {
                                            if ((i36 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(787383072, i36, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:194)");
                                            }
                                            Modifier modifierM17264outlineCutout12SF9DM = OutlinedTextFieldKt.m17264outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                            Function2<Composer, Integer, Unit> function228 = function227;
                                            int i37 = i35;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                            Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM17264outlineCutout12SF9DM);
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
                                            composer4.startReplaceableGroup(1492929242);
                                            if (AbstractC1038a.m1199D(composer4, (i37 >> 15) & 14, function228)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function228 = innerTextField;
                                    ComposableLambda composableLambda11 = composableLambda2;
                                    boolean z24 = z13;
                                    Object objValueOf2 = Float.valueOf(f5);
                                    composer3.startReplaceableGroup(511388516);
                                    boolean zChanged3 = composer3.changed(objValueOf2) | composer3.changed(mutableState);
                                    Object objRememberedValue4 = composer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue4 == companion3.getEmpty()) {
                                        objRememberedValue4 = new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                m17388invokeuvyYCjk(size.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                            public final void m17388invokeuvyYCjk(long j7) {
                                                float fM18353getWidthimpl = Size.m18353getWidthimpl(j7) * f5;
                                                float fM18350getHeightimpl = Size.m18350getHeightimpl(j7) * f5;
                                                if (Size.m18353getWidthimpl(mutableState.getValue().getPackedValue()) == fM18353getWidthimpl && Size.m18350getHeightimpl(mutableState.getValue().getPackedValue()) == fM18350getHeightimpl) {
                                                    return;
                                                }
                                                mutableState.setValue(Size.m18341boximpl(androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18350getHeightimpl)));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue4);
                                    }
                                    composer3.endReplaceableGroup();
                                    ComposableLambda composableLambda12 = composableLambda4;
                                    PaddingValues paddingValues3 = contentPadding;
                                    int i36 = i22;
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function228, composableLambda11, composableLambda, composableLambda12, composableLambda5, z24, f5, (Function1) objRememberedValue4, composableLambda10, composableLambda3, paddingValues3, composer3, ((i36 >> 9) & 3670016) | ((i36 >> 3) & 112) | DriveFile.MODE_READ_WRITE | ((i25 << 21) & 29360128), (i21 >> 6) & 112);
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
                        function211 = function217;
                        function212 = function219;
                        z5 = z11;
                        z6 = z12;
                        function213 = function210;
                        z7 = z13;
                        function214 = function218;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox.4
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
                            TextFieldImplKt.CommonDecorationBox(type, value, innerTextField, visualTransformation, function2, function212, function214, function213, function211, z7, z6, z5, interactionSource, contentPadding, colors, container, composer3, i | 1, i2, i4);
                        }
                    });
                    return;
                }
                i17 |= DriveFile.MODE_READ_WRITE;
                i10 = i9;
                i11 = i4 & 1024;
                if (i11 == 0) {
                }
                i14 = i4 & 2048;
                if (i14 == 0) {
                }
                i16 = i13;
                if ((i4 & 4096) == 0) {
                }
                if ((i4 & 8192) == 0) {
                }
                if ((i4 & 16384) == 0) {
                }
                if ((32768 & i4) == 0) {
                }
                if ((1533916891 & i17) != 306783378) {
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function216;
                    if (i12 == 0) {
                    }
                    if (i15 == 0) {
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
                        if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i16 >> 6) & 14).getValue().booleanValue()) {
                        }
                        final int i212 = i16;
                        final boolean z112 = z10;
                        final boolean z122 = z9;
                        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase22, Composer composer3, Integer num) {
                                return Color.m18515boximpl(m17389invokeXeAY9LY(inputPhase22, composer3, num.intValue()));
                            }

                            @Composable
                            /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                            public final long m17389invokeXeAY9LY(@NotNull InputPhase it, @Nullable Composer composer3, int i222) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                composer3.startReplaceableGroup(-379813807);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-379813807, i222, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                                }
                                TextFieldColors textFieldColors = colors;
                                boolean z132 = z122;
                                boolean z14 = z112;
                                InteractionSource interactionSource2 = interactionSource;
                                int i23 = i212;
                                long jM18535unboximpl = textFieldColors.labelColor$material3_release(z132, z14, interactionSource2, composer3, (i23 & Event.CAPS_LOCK) | ((i23 >> 3) & 7168)).getValue().m18535unboximpl();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceableGroup();
                                return jM18535unboximpl;
                            }
                        };
                        final int i222 = i17;
                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                        Typography typography2 = materialTheme2.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge2 = typography2.getBodyLarge();
                        final TextStyle bodySmall2 = typography2.getBodySmall();
                        jM20486getColor0d7_KjU = bodyLarge2.m20486getColor0d7_KjU();
                        companion = Color.INSTANCE;
                        if (Color.m18526equalsimpl0(jM20486getColor0d7_KjU, companion.m18561getUnspecified0d7_KjU())) {
                            function29 = function26;
                            function210 = function27;
                            z4 = false;
                            TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388305);
                            jM20486getColor0d7_KjU2 = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodySmall().m20486getColor0d7_KjU();
                            if (z4) {
                                jM20486getColor0d7_KjU2 = function3.invoke(inputPhase, composerStartRestartGroup, 0).m18535unboximpl();
                            }
                            long j2 = jM20486getColor0d7_KjU2;
                            composerStartRestartGroup.endReplaceableGroup();
                            jM20486getColor0d7_KjU3 = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodyLarge().m20486getColor0d7_KjU();
                            if (z4) {
                                jM20486getColor0d7_KjU3 = function3.invoke(inputPhase, composerStartRestartGroup, 0).m18535unboximpl();
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                            final boolean z132 = z8;
                            InputPhase inputPhase22 = inputPhase;
                            final Function2<? super Composer, ? super Integer, Unit> function2192 = function28;
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope2.m17398TransitionDTcfvLk(inputPhase22, j2, jM20486getColor0d7_KjU3, function3, function2 != null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1915872767, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox.3

                                /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
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
                                    m17387invokeRIQooxk(f.floatValue(), color.m18535unboximpl(), color2.m18535unboximpl(), f4.floatValue(), composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                                public final void m17387invokeRIQooxk(final float f, long j22, final long j3, final float f4, @Nullable Composer composer3, int i23) {
                                    int i24;
                                    long j5;
                                    int i25;
                                    final float f5;
                                    ComposableLambda composableLambda;
                                    ComposableLambda composableLambda2;
                                    ComposableLambda composableLambda3;
                                    if ((i23 & 14) == 0) {
                                        i24 = (composer3.changed(f) ? 4 : 2) | i23;
                                    } else {
                                        i24 = i23;
                                    }
                                    if ((i23 & 112) == 0) {
                                        j5 = j22;
                                        i24 |= composer3.changed(j5) ? 32 : 16;
                                    } else {
                                        j5 = j22;
                                    }
                                    if ((i23 & 896) == 0) {
                                        i24 |= composer3.changed(j3) ? 256 : 128;
                                    }
                                    if ((i23 & 7168) == 0) {
                                        i24 |= composer3.changed(f4) ? 2048 : 1024;
                                    }
                                    if ((46811 & i24) == 9362 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1915872767, i24, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:112)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2;
                                    if (function220 != null) {
                                        final boolean z14 = z4;
                                        final int i26 = i24;
                                        final long j6 = j5;
                                        f5 = f;
                                        i25 = i26;
                                        composableLambda = ComposableLambdaKt.composableLambda(composer3, 1199990137, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i27) {
                                                if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1199990137, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:115)");
                                                }
                                                MaterialTheme materialTheme22 = MaterialTheme.INSTANCE;
                                                TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme22.getTypography(composer4, 6).getBodyLarge(), materialTheme22.getTypography(composer4, 6).getBodySmall(), f);
                                                boolean z15 = z14;
                                                long j7 = j6;
                                                if (z15) {
                                                    textStyleLerp = TextStyle.m20465copyHL5avdY$default(textStyleLerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, 262142, null);
                                                }
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(j3, textStyleLerp, function220, composer4, (i26 >> 6) & 14, 0);
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
                                    if (function2192 == null || text2.length() != 0) {
                                        composableLambda2 = null;
                                    } else {
                                        final TextFieldColors textFieldColors = colors;
                                        final boolean z15 = z122;
                                        final int i27 = i212;
                                        final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                        final int i28 = i222;
                                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1472145357, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
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
                                                    ComposerKt.traceEventStart(1472145357, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:129)");
                                                }
                                                Modifier modifierAlpha = AlphaKt.alpha(modifier, f4);
                                                TextFieldColors textFieldColors2 = textFieldColors;
                                                boolean z16 = z15;
                                                int i31 = i27;
                                                Function2<Composer, Integer, Unit> function222 = function221;
                                                int i32 = i28;
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
                                                composer4.startReplaceableGroup(828149203);
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(textFieldColors2.placeholderColor$material3_release(z16, composer4, (i31 & 14) | ((i31 >> 9) & 112)).getValue().m18535unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function222, composer4, (i32 >> 9) & 896, 0);
                                                if (AbstractC1038a.m1225z(composer4)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    }
                                    final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17309getDefaultErrorMessageadMyvUU(), composer3, 6);
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Object objValueOf = Boolean.valueOf(z112);
                                    final boolean z16 = z112;
                                    composer3.startReplaceableGroup(511388516);
                                    boolean zChanged2 = composer3.changed(objValueOf) | composer3.changed(strM17317getStringNWtq28);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
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
                                                if (z16) {
                                                    SemanticsPropertiesKt.error(semantics, strM17317getStringNWtq28);
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue2, 1, null);
                                    TextFieldColors textFieldColors2 = colors;
                                    boolean z17 = z122;
                                    boolean z18 = z112;
                                    InteractionSource interactionSource2 = interactionSource;
                                    int i29 = i212;
                                    final long jM18535unboximpl = textFieldColors2.leadingIconColor$material3_release(z17, z18, interactionSource2, composer3, (i29 & Event.CAPS_LOCK) | ((i29 >> 3) & 7168)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function222 = function2182;
                                    ComposableLambda composableLambda4 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 175497959, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i30) {
                                            if ((i30 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(175497959, i30, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:148)");
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl, null, function222, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    TextFieldColors textFieldColors3 = colors;
                                    boolean z19 = z122;
                                    boolean z20 = z112;
                                    InteractionSource interactionSource3 = interactionSource;
                                    int i30 = i212;
                                    final long jM18535unboximpl2 = textFieldColors3.trailingIconColor$material3_release(z19, z20, interactionSource3, composer3, ((i30 >> 3) & 7168) | (i30 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function210;
                                    ComposableLambda composableLambda5 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -432498573, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i31) {
                                            if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-432498573, i31, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:155)");
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl2, null, function223, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    TextFieldColors textFieldColors4 = colors;
                                    boolean z21 = z122;
                                    boolean z22 = z112;
                                    InteractionSource interactionSource4 = interactionSource;
                                    int i31 = i212;
                                    final long jM18535unboximpl3 = textFieldColors4.supportingTextColor$material3_release(z21, z22, interactionSource4, composer3, ((i31 >> 3) & 7168) | (i31 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function224 = function2172;
                                    if (function224 != null) {
                                        final TextStyle textStyle = bodySmall2;
                                        composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -1269483524, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i32) {
                                                if ((i32 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1269483524, i32, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                }
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl3, textStyle, function224, composer4, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        composableLambda3 = null;
                                    }
                                    int i32 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                    if (i32 == 1) {
                                        ComposableLambda composableLambda6 = composableLambda2;
                                        ComposableLambda composableLambda7 = composableLambda5;
                                        ComposableLambda composableLambda8 = composableLambda4;
                                        composer3.startReplaceableGroup(404041480);
                                        final Function2<? super Composer, ? super Integer, Unit> function225 = container;
                                        final int i33 = i212;
                                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composer3, 1566950173, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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
                                            public final void invoke(@Nullable Composer composer4, int i34) {
                                                if ((i34 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1566950173, i34, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:170)");
                                                }
                                                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                Function2<Composer, Integer, Unit> function226 = function225;
                                                int i35 = i33;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierLayoutId);
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
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                composer4.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer4.startReplaceableGroup(1634460887);
                                                if (AbstractC1038a.m1199D(composer4, (i35 >> 15) & 14, function226)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function226 = innerTextField;
                                        boolean z23 = z132;
                                        PaddingValues paddingValues = contentPadding;
                                        int i34 = i222;
                                        TextFieldKt.TextFieldLayout(modifierSemantics$default, function226, composableLambda, composableLambda6, composableLambda8, composableLambda7, z23, f, composableLambda9, composableLambda3, paddingValues, composer3, (3670016 & (i34 >> 9)) | ((i34 >> 3) & 112) | 100663296 | ((i25 << 21) & 29360128), (i212 >> 9) & 14);
                                        composer3.endReplaceableGroup();
                                        Unit unit = Unit.INSTANCE;
                                    } else if (i32 != 2) {
                                        composer3.startReplaceableGroup(404044016);
                                        composer3.endReplaceableGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                    } else {
                                        composer3.startReplaceableGroup(404042394);
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
                                        final Function2<? super Composer, ? super Integer, Unit> function227 = container;
                                        final int i35 = i212;
                                        ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 787383072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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
                                            public final void invoke(@Nullable Composer composer4, int i36) {
                                                if ((i36 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(787383072, i36, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:194)");
                                                }
                                                Modifier modifierM17264outlineCutout12SF9DM = OutlinedTextFieldKt.m17264outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                Function2<Composer, Integer, Unit> function228 = function227;
                                                int i37 = i35;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM17264outlineCutout12SF9DM);
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
                                                composer4.startReplaceableGroup(1492929242);
                                                if (AbstractC1038a.m1199D(composer4, (i37 >> 15) & 14, function228)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function228 = innerTextField;
                                        ComposableLambda composableLambda11 = composableLambda2;
                                        boolean z24 = z132;
                                        Object objValueOf2 = Float.valueOf(f5);
                                        composer3.startReplaceableGroup(511388516);
                                        boolean zChanged3 = composer3.changed(objValueOf2) | composer3.changed(mutableState);
                                        Object objRememberedValue4 = composer3.rememberedValue();
                                        if (zChanged3 || objRememberedValue4 == companion3.getEmpty()) {
                                            objRememberedValue4 = new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                    m17388invokeuvyYCjk(size.getPackedValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                public final void m17388invokeuvyYCjk(long j7) {
                                                    float fM18353getWidthimpl = Size.m18353getWidthimpl(j7) * f5;
                                                    float fM18350getHeightimpl = Size.m18350getHeightimpl(j7) * f5;
                                                    if (Size.m18353getWidthimpl(mutableState.getValue().getPackedValue()) == fM18353getWidthimpl && Size.m18350getHeightimpl(mutableState.getValue().getPackedValue()) == fM18350getHeightimpl) {
                                                        return;
                                                    }
                                                    mutableState.setValue(Size.m18341boximpl(androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18350getHeightimpl)));
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        ComposableLambda composableLambda12 = composableLambda4;
                                        PaddingValues paddingValues3 = contentPadding;
                                        int i36 = i222;
                                        OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function228, composableLambda11, composableLambda, composableLambda12, composableLambda5, z24, f5, (Function1) objRememberedValue4, composableLambda10, composableLambda3, paddingValues3, composer3, ((i36 >> 9) & 3670016) | ((i36 >> 3) & 112) | DriveFile.MODE_READ_WRITE | ((i25 << 21) & 29360128), (i212 >> 6) & 112);
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
                            function211 = function2172;
                            function212 = function2192;
                            z5 = z112;
                            z6 = z122;
                            function213 = function210;
                            z7 = z132;
                            function214 = function2182;
                        } else {
                            function29 = function26;
                            function210 = function27;
                            z4 = false;
                            TextFieldTransitionScope textFieldTransitionScope22 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388305);
                            jM20486getColor0d7_KjU2 = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodySmall().m20486getColor0d7_KjU();
                            if (z4) {
                            }
                            long j22 = jM20486getColor0d7_KjU2;
                            composerStartRestartGroup.endReplaceableGroup();
                            jM20486getColor0d7_KjU3 = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodyLarge().m20486getColor0d7_KjU();
                            if (z4) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            final boolean z1322 = z8;
                            InputPhase inputPhase222 = inputPhase;
                            final Function2<? super Composer, ? super Integer, Unit> function21922 = function28;
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope22.m17398TransitionDTcfvLk(inputPhase222, j22, jM20486getColor0d7_KjU3, function3, function2 != null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1915872767, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox.3

                                /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
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
                                    m17387invokeRIQooxk(f.floatValue(), color.m18535unboximpl(), color2.m18535unboximpl(), f4.floatValue(), composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                                public final void m17387invokeRIQooxk(final float f, long j222, final long j3, final float f4, @Nullable Composer composer3, int i23) {
                                    int i24;
                                    long j5;
                                    int i25;
                                    final float f5;
                                    ComposableLambda composableLambda;
                                    ComposableLambda composableLambda2;
                                    ComposableLambda composableLambda3;
                                    if ((i23 & 14) == 0) {
                                        i24 = (composer3.changed(f) ? 4 : 2) | i23;
                                    } else {
                                        i24 = i23;
                                    }
                                    if ((i23 & 112) == 0) {
                                        j5 = j222;
                                        i24 |= composer3.changed(j5) ? 32 : 16;
                                    } else {
                                        j5 = j222;
                                    }
                                    if ((i23 & 896) == 0) {
                                        i24 |= composer3.changed(j3) ? 256 : 128;
                                    }
                                    if ((i23 & 7168) == 0) {
                                        i24 |= composer3.changed(f4) ? 2048 : 1024;
                                    }
                                    if ((46811 & i24) == 9362 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1915872767, i24, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:112)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2;
                                    if (function220 != null) {
                                        final boolean z14 = z4;
                                        final int i26 = i24;
                                        final long j6 = j5;
                                        f5 = f;
                                        i25 = i26;
                                        composableLambda = ComposableLambdaKt.composableLambda(composer3, 1199990137, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i27) {
                                                if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1199990137, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:115)");
                                                }
                                                MaterialTheme materialTheme22 = MaterialTheme.INSTANCE;
                                                TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme22.getTypography(composer4, 6).getBodyLarge(), materialTheme22.getTypography(composer4, 6).getBodySmall(), f);
                                                boolean z15 = z14;
                                                long j7 = j6;
                                                if (z15) {
                                                    textStyleLerp = TextStyle.m20465copyHL5avdY$default(textStyleLerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, 262142, null);
                                                }
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(j3, textStyleLerp, function220, composer4, (i26 >> 6) & 14, 0);
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
                                    if (function21922 == null || text2.length() != 0) {
                                        composableLambda2 = null;
                                    } else {
                                        final TextFieldColors textFieldColors = colors;
                                        final boolean z15 = z122;
                                        final int i27 = i212;
                                        final Function2<? super Composer, ? super Integer, Unit> function221 = function21922;
                                        final int i28 = i222;
                                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1472145357, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
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
                                                    ComposerKt.traceEventStart(1472145357, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:129)");
                                                }
                                                Modifier modifierAlpha = AlphaKt.alpha(modifier, f4);
                                                TextFieldColors textFieldColors2 = textFieldColors;
                                                boolean z16 = z15;
                                                int i31 = i27;
                                                Function2<Composer, Integer, Unit> function222 = function221;
                                                int i32 = i28;
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
                                                composer4.startReplaceableGroup(828149203);
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(textFieldColors2.placeholderColor$material3_release(z16, composer4, (i31 & 14) | ((i31 >> 9) & 112)).getValue().m18535unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function222, composer4, (i32 >> 9) & 896, 0);
                                                if (AbstractC1038a.m1225z(composer4)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    }
                                    final String strM17317getStringNWtq28 = Strings_androidKt.m17317getStringNWtq28(Strings.INSTANCE.m17309getDefaultErrorMessageadMyvUU(), composer3, 6);
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Object objValueOf = Boolean.valueOf(z112);
                                    final boolean z16 = z112;
                                    composer3.startReplaceableGroup(511388516);
                                    boolean zChanged2 = composer3.changed(objValueOf) | composer3.changed(strM17317getStringNWtq28);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
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
                                                if (z16) {
                                                    SemanticsPropertiesKt.error(semantics, strM17317getStringNWtq28);
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue2, 1, null);
                                    TextFieldColors textFieldColors2 = colors;
                                    boolean z17 = z122;
                                    boolean z18 = z112;
                                    InteractionSource interactionSource2 = interactionSource;
                                    int i29 = i212;
                                    final long jM18535unboximpl = textFieldColors2.leadingIconColor$material3_release(z17, z18, interactionSource2, composer3, (i29 & Event.CAPS_LOCK) | ((i29 >> 3) & 7168)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function222 = function21822;
                                    ComposableLambda composableLambda4 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 175497959, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i30) {
                                            if ((i30 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(175497959, i30, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:148)");
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl, null, function222, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    TextFieldColors textFieldColors3 = colors;
                                    boolean z19 = z122;
                                    boolean z20 = z112;
                                    InteractionSource interactionSource3 = interactionSource;
                                    int i30 = i212;
                                    final long jM18535unboximpl2 = textFieldColors3.trailingIconColor$material3_release(z19, z20, interactionSource3, composer3, ((i30 >> 3) & 7168) | (i30 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function210;
                                    ComposableLambda composableLambda5 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -432498573, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                        @Composable
                                        public final void invoke(@Nullable Composer composer4, int i31) {
                                            if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-432498573, i31, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:155)");
                                            }
                                            TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl2, null, function223, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    TextFieldColors textFieldColors4 = colors;
                                    boolean z21 = z122;
                                    boolean z22 = z112;
                                    InteractionSource interactionSource4 = interactionSource;
                                    int i31 = i212;
                                    final long jM18535unboximpl3 = textFieldColors4.supportingTextColor$material3_release(z21, z22, interactionSource4, composer3, ((i31 >> 3) & 7168) | (i31 & Event.CAPS_LOCK)).getValue().m18535unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function224 = function2172;
                                    if (function224 != null) {
                                        final TextStyle textStyle = bodySmall2;
                                        composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -1269483524, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                            @Composable
                                            public final void invoke(@Nullable Composer composer4, int i32) {
                                                if ((i32 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1269483524, i32, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                }
                                                TextFieldImplKt.m17386DecorationKTwxG1Y(jM18535unboximpl3, textStyle, function224, composer4, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        composableLambda3 = null;
                                    }
                                    int i32 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                                    if (i32 == 1) {
                                        ComposableLambda composableLambda6 = composableLambda2;
                                        ComposableLambda composableLambda7 = composableLambda5;
                                        ComposableLambda composableLambda8 = composableLambda4;
                                        composer3.startReplaceableGroup(404041480);
                                        final Function2<? super Composer, ? super Integer, Unit> function225 = container;
                                        final int i33 = i212;
                                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composer3, 1566950173, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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
                                            public final void invoke(@Nullable Composer composer4, int i34) {
                                                if ((i34 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1566950173, i34, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:170)");
                                                }
                                                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                Function2<Composer, Integer, Unit> function226 = function225;
                                                int i35 = i33;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierLayoutId);
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
                                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                                composer4.startReplaceableGroup(-2137368960);
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                composer4.startReplaceableGroup(1634460887);
                                                if (AbstractC1038a.m1199D(composer4, (i35 >> 15) & 14, function226)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function226 = innerTextField;
                                        boolean z23 = z1322;
                                        PaddingValues paddingValues = contentPadding;
                                        int i34 = i222;
                                        TextFieldKt.TextFieldLayout(modifierSemantics$default, function226, composableLambda, composableLambda6, composableLambda8, composableLambda7, z23, f, composableLambda9, composableLambda3, paddingValues, composer3, (3670016 & (i34 >> 9)) | ((i34 >> 3) & 112) | 100663296 | ((i25 << 21) & 29360128), (i212 >> 9) & 14);
                                        composer3.endReplaceableGroup();
                                        Unit unit = Unit.INSTANCE;
                                    } else if (i32 != 2) {
                                        composer3.startReplaceableGroup(404044016);
                                        composer3.endReplaceableGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                    } else {
                                        composer3.startReplaceableGroup(404042394);
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
                                        final Function2<? super Composer, ? super Integer, Unit> function227 = container;
                                        final int i35 = i212;
                                        ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 787383072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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
                                            public final void invoke(@Nullable Composer composer4, int i36) {
                                                if ((i36 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(787383072, i36, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:194)");
                                                }
                                                Modifier modifierM17264outlineCutout12SF9DM = OutlinedTextFieldKt.m17264outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                Function2<Composer, Integer, Unit> function228 = function227;
                                                int i37 = i35;
                                                composer4.startReplaceableGroup(733328855);
                                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer4, 48, -1323940314);
                                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM17264outlineCutout12SF9DM);
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
                                                composer4.startReplaceableGroup(1492929242);
                                                if (AbstractC1038a.m1199D(composer4, (i37 >> 15) & 14, function228)) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function228 = innerTextField;
                                        ComposableLambda composableLambda11 = composableLambda2;
                                        boolean z24 = z1322;
                                        Object objValueOf2 = Float.valueOf(f5);
                                        composer3.startReplaceableGroup(511388516);
                                        boolean zChanged3 = composer3.changed(objValueOf2) | composer3.changed(mutableState);
                                        Object objRememberedValue4 = composer3.rememberedValue();
                                        if (zChanged3 || objRememberedValue4 == companion3.getEmpty()) {
                                            objRememberedValue4 = new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                    m17388invokeuvyYCjk(size.getPackedValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                public final void m17388invokeuvyYCjk(long j7) {
                                                    float fM18353getWidthimpl = Size.m18353getWidthimpl(j7) * f5;
                                                    float fM18350getHeightimpl = Size.m18350getHeightimpl(j7) * f5;
                                                    if (Size.m18353getWidthimpl(mutableState.getValue().getPackedValue()) == fM18353getWidthimpl && Size.m18350getHeightimpl(mutableState.getValue().getPackedValue()) == fM18350getHeightimpl) {
                                                        return;
                                                    }
                                                    mutableState.setValue(Size.m18341boximpl(androidx.compose.p109ui.geometry.SizeKt.Size(fM18353getWidthimpl, fM18350getHeightimpl)));
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        ComposableLambda composableLambda12 = composableLambda4;
                                        PaddingValues paddingValues3 = contentPadding;
                                        int i36 = i222;
                                        OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, function228, composableLambda11, composableLambda, composableLambda12, composableLambda5, z24, f5, (Function1) objRememberedValue4, composableLambda10, composableLambda3, paddingValues3, composer3, ((i36 >> 9) & 3670016) | ((i36 >> 3) & 112) | DriveFile.MODE_READ_WRITE | ((i25 << 21) & 29360128), (i212 >> 6) & 112);
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
                            function211 = function2172;
                            function212 = function21922;
                            z5 = z112;
                            z6 = z122;
                            function213 = function210;
                            z7 = z1322;
                            function214 = function21822;
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
            i14 = i4 & 2048;
            if (i14 == 0) {
            }
            i16 = i13;
            if ((i4 & 4096) == 0) {
            }
            if ((i4 & 8192) == 0) {
            }
            if ((i4 & 16384) == 0) {
            }
            if ((32768 & i4) == 0) {
            }
            if ((1533916891 & i17) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i6 = i20;
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
        i14 = i4 & 2048;
        if (i14 == 0) {
        }
        i16 = i13;
        if ((i4 & 4096) == 0) {
        }
        if ((i4 & 8192) == 0) {
        }
        if ((i4 & 16384) == 0) {
        }
        if ((32768 & i4) == 0) {
        }
        if ((1533916891 & i17) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    /* JADX INFO: renamed from: Decoration-KTwxG1Y, reason: not valid java name */
    public static final void m17386DecorationKTwxG1Y(final long j, @Nullable TextStyle textStyle, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1520066345);
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
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                textStyle = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i4, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:236)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1449369305, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$contentWithColor$1
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
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1449369305, i6, -1, "androidx.compose.material3.Decoration.<anonymous> (TextFieldImpl.kt:241)");
                    }
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j))}, content, composer2, ((i4 >> 3) & 112) | 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            if (textStyle != null) {
                composerStartRestartGroup.startReplaceableGroup(1830466317);
                TextKt.ProvideTextStyle(textStyle, composableLambda, composerStartRestartGroup, ((i4 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(1830466369);
                composableLambda.invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final TextStyle textStyle2 = textStyle;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$1
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

            public final void invoke(@Nullable Composer composer2, int i6) {
                TextFieldImplKt.m17386DecorationKTwxG1Y(j, textStyle2, content, composer2, i | 1, i2);
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

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
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
