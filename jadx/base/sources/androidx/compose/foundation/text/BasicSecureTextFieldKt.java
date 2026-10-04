package androidx.compose.foundation.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.SolidColor;
import androidx.compose.p109ui.input.key.KeyEvent;
import androidx.compose.p109ui.input.key.KeyInputModifierKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.TextToolbar;
import androidx.compose.p109ui.platform.TextToolbarStatus;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\u00052\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\b*H\u0003¢\u0006\u0002\u0010+\u001a\u001a\u0010,\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, m13886d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicSecureTextField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicSecureTextField.kt\nandroidx/compose/foundation/text/BasicSecureTextFieldKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,343:1\n1225#2,6:344\n1225#2,6:350\n1225#2,6:356\n1225#2,6:362\n1225#2,6:369\n77#3:368\n*S KotlinDebug\n*F\n+ 1 BasicSecureTextField.kt\nandroidx/compose/foundation/text/BasicSecureTextFieldKt\n*L\n133#1:344,6\n134#1:350,6\n145#1:356,6\n151#1:362,6\n313#1:369,6\n312#1:368\n*E\n"})
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_]]")
    /* JADX INFO: renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16141BasicSecureTextFieldJb9bMDk(@NotNull final TextFieldState textFieldState, @Nullable Modifier modifier, boolean z, @Nullable InputTransformation inputTransformation, @Nullable TextStyle textStyle, @Nullable KeyboardOptions keyboardOptions, @Nullable KeyboardActionHandler keyboardActionHandler, @Nullable Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Brush brush, @Nullable TextFieldDecorator textFieldDecorator, int i, char c, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z2;
        int i8;
        InputTransformation inputTransformation2;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActionHandler keyboardActionHandler2;
        int i12;
        int i13;
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
        Composer composer2;
        final Brush solidColor;
        int iM16303getRevealLastTypedvTwcZD0;
        Composer composer3;
        State stateRememberUpdatedState;
        Object objRememberedValue;
        Composer.Companion companion;
        final SecureTextFieldController secureTextFieldController;
        boolean zChangedInstance;
        Object objRememberedValue2;
        TextObfuscationMode.Companion companion2;
        final boolean zM16298equalsimpl0;
        boolean zChanged;
        Object objRememberedValue3;
        boolean z3;
        Object objRememberedValue4;
        final int i24;
        Composer composer4;
        final boolean z4;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActionHandler keyboardActionHandler3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final char c2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1399310985);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        int i25 = i5 & 2;
        if (i25 != 0) {
            i6 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    z2 = z;
                    i6 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        inputTransformation2 = inputTransformation;
                        i6 |= composerStartRestartGroup.changed(inputTransformation2) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            textStyle2 = textStyle;
                            i6 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= 196608;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i2 & 196608) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardOptions2) ? 131072 : 65536;
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                            keyboardActionHandler2 = keyboardActionHandler;
                        } else {
                            keyboardActionHandler2 = keyboardActionHandler;
                            if ((i2 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(keyboardActionHandler2) ? 1048576 : 524288;
                            }
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else {
                            if ((i2 & 12582912) == 0) {
                                i13 = i12;
                                i6 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                            }
                            i14 = i5 & 256;
                            if (i14 == 0) {
                                i6 |= 100663296;
                            } else {
                                if ((i2 & 100663296) == 0) {
                                    i15 = i14;
                                    i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                }
                                i16 = i5 & 512;
                                if (i16 == 0) {
                                    if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                                        i17 = i16;
                                        i6 |= composerStartRestartGroup.changed(brush) ? 536870912 : 268435456;
                                    }
                                    i18 = i5 & 1024;
                                    if (i18 == 0) {
                                        i19 = i4 | 6;
                                    } else if ((i4 & 6) == 0) {
                                        i19 = i4 | ((i4 & 8) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 4 : 2);
                                    } else {
                                        i19 = i4;
                                    }
                                    i20 = i5 & 2048;
                                    if (i20 == 0) {
                                        i19 |= 48;
                                        i21 = i20;
                                    } else if ((i4 & 48) == 0) {
                                        i21 = i20;
                                        i19 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                                    } else {
                                        i21 = i20;
                                    }
                                    int i26 = i19;
                                    i22 = i5 & 4096;
                                    if (i22 == 0) {
                                        i23 = i26 | 384;
                                    } else if ((i4 & 384) == 0) {
                                        i23 = i26 | (composerStartRestartGroup.changed(c) ? 256 : 128);
                                    } else {
                                        i23 = i26;
                                    }
                                    if ((i6 & 306783379) != 306783378 && (i23 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        function22 = function2;
                                        i24 = i;
                                        composer4 = composerStartRestartGroup;
                                        z4 = z2;
                                        inputTransformation3 = inputTransformation2;
                                        textStyle3 = textStyle2;
                                        keyboardActionHandler3 = keyboardActionHandler2;
                                        modifier3 = modifier2;
                                        keyboardOptions3 = keyboardOptions2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        textFieldDecorator2 = textFieldDecorator;
                                        c2 = c;
                                    } else {
                                        Modifier modifier4 = i25 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (i7 != 0) {
                                            z2 = true;
                                        }
                                        DefaultConstructorMarker defaultConstructorMarker = null;
                                        if (i8 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        if (i9 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        KeyboardOptions secureTextField$foundation_release = i10 == 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation_release() : keyboardOptions2;
                                        if (i11 != 0) {
                                            keyboardActionHandler2 = null;
                                        }
                                        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23 = i13 == 0 ? null : function2;
                                        final MutableInteractionSource mutableInteractionSource3 = i15 == 0 ? null : mutableInteractionSource;
                                        if (i17 == 0) {
                                            composer2 = composerStartRestartGroup;
                                            solidColor = new SolidColor(Color.INSTANCE.m18551getBlack0d7_KjU(), defaultConstructorMarker);
                                        } else {
                                            composer2 = composerStartRestartGroup;
                                            solidColor = brush;
                                        }
                                        final TextFieldDecorator textFieldDecorator3 = i18 == 0 ? null : textFieldDecorator;
                                        iM16303getRevealLastTypedvTwcZD0 = i21 == 0 ? TextObfuscationMode.INSTANCE.m16303getRevealLastTypedvTwcZD0() : i;
                                        char c4 = i22 == 0 ? (char) 8226 : c;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1399310985, i6, i23, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:130)");
                                        }
                                        composer3 = composer2;
                                        stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c4), composer3, (i23 >> 6) & 14);
                                        objRememberedValue = composer3.rememberedValue();
                                        companion = Composer.INSTANCE;
                                        if (objRememberedValue == companion.getEmpty()) {
                                            objRememberedValue = new SecureTextFieldController(stateRememberUpdatedState);
                                            composer3.updateRememberedValue(objRememberedValue);
                                        }
                                        secureTextFieldController = (SecureTextFieldController) objRememberedValue;
                                        zChangedInstance = composer3.changedInstance(secureTextFieldController);
                                        int i27 = i23;
                                        objRememberedValue2 = composer3.rememberedValue();
                                        if (!zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                                            objRememberedValue2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        EffectsKt.LaunchedEffect(secureTextFieldController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer3, 0);
                                        companion2 = TextObfuscationMode.INSTANCE;
                                        zM16298equalsimpl0 = TextObfuscationMode.m16298equalsimpl0(iM16303getRevealLastTypedvTwcZD0, companion2.m16303getRevealLastTypedvTwcZD0());
                                        Boolean boolValueOf = Boolean.valueOf(zM16298equalsimpl0);
                                        zChanged = composer3.changed(zM16298equalsimpl0) | composer3.changedInstance(secureTextFieldController);
                                        char c5 = c4;
                                        objRememberedValue3 = composer3.rememberedValue();
                                        if (!zChanged || objRememberedValue3 == companion.getEmpty()) {
                                            objRememberedValue3 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(zM16298equalsimpl0, secureTextFieldController, null);
                                            composer3.updateRememberedValue(objRememberedValue3);
                                        }
                                        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer3, 0);
                                        z3 = (i27 & 112) == 32;
                                        objRememberedValue4 = composer3.rememberedValue();
                                        if (!z3 || objRememberedValue4 == companion.getEmpty()) {
                                            objRememberedValue4 = !TextObfuscationMode.m16298equalsimpl0(iM16303getRevealLastTypedvTwcZD0, companion2.m16303getRevealLastTypedvTwcZD0()) ? secureTextFieldController.getCodepointTransformation() : TextObfuscationMode.m16298equalsimpl0(iM16303getRevealLastTypedvTwcZD0, companion2.m16302getHiddenvTwcZD0()) ? new C1290a(stateRememberUpdatedState, 0) : null;
                                            composer3.updateRememberedValue(objRememberedValue4);
                                        }
                                        final CodepointTransformation codepointTransformation = (CodepointTransformation) objRememberedValue4;
                                        final Modifier modifierThen = SemanticsModifierKt.semantics(modifier4, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Boolean invoke() {
                                                        return Boolean.FALSE;
                                                    }
                                                }, 1, null);
                                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    @NotNull
                                                    public final Boolean invoke() {
                                                        return Boolean.FALSE;
                                                    }
                                                }, 1, null);
                                            }
                                        }).then(!zM16298equalsimpl0 ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
                                        final boolean z5 = z2;
                                        final InputTransformation inputTransformation4 = inputTransformation2;
                                        final TextStyle textStyle4 = textStyle2;
                                        final KeyboardActionHandler keyboardActionHandler4 = keyboardActionHandler2;
                                        final KeyboardOptions keyboardOptions4 = secureTextField$foundation_release;
                                        DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(2023988909, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(@Nullable Composer composer5, int i28) {
                                                if ((i28 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2023988909, i28, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:177)");
                                                }
                                                BasicTextFieldKt.BasicTextField(textFieldState, modifierThen, z5, false, zM16298equalsimpl0 ? BasicSecureTextFieldKt.then(inputTransformation4, secureTextFieldController.getPasswordInputTransformation()) : inputTransformation4, textStyle4, keyboardOptions4, keyboardActionHandler4, TextFieldLineLimits.SingleLine.INSTANCE, function23, mutableInteractionSource3, solidColor, codepointTransformation, null, textFieldDecorator3, null, true, composer5, 100666368, 1572864, 40960);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54), composer3, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        i24 = iM16303getRevealLastTypedvTwcZD0;
                                        composer4 = composer3;
                                        z4 = z5;
                                        inputTransformation3 = inputTransformation4;
                                        textStyle3 = textStyle4;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = solidColor;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        c2 = c5;
                                        modifier3 = modifier4;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@Nullable Composer composer5, int i28) {
                                                BasicSecureTextFieldKt.m16141BasicSecureTextFieldJb9bMDk(textFieldState, modifier3, z4, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler3, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i24, c2, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i6 |= DriveFile.MODE_READ_WRITE;
                                i17 = i16;
                                i18 = i5 & 1024;
                                if (i18 == 0) {
                                }
                                i20 = i5 & 2048;
                                if (i20 == 0) {
                                }
                                int i262 = i19;
                                i22 = i5 & 4096;
                                if (i22 == 0) {
                                }
                                if ((i6 & 306783379) != 306783378) {
                                    if (i25 == 0) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    DefaultConstructorMarker defaultConstructorMarker2 = null;
                                    if (i8 != 0) {
                                    }
                                    if (i9 != 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i11 != 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i18 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if (i22 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer3 = composer2;
                                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c4), composer3, (i23 >> 6) & 14);
                                    objRememberedValue = composer3.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (objRememberedValue == companion.getEmpty()) {
                                    }
                                    secureTextFieldController = (SecureTextFieldController) objRememberedValue;
                                    zChangedInstance = composer3.changedInstance(secureTextFieldController);
                                    int i272 = i23;
                                    objRememberedValue2 = composer3.rememberedValue();
                                    if (!zChangedInstance) {
                                        objRememberedValue2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                        composer3.updateRememberedValue(objRememberedValue2);
                                        EffectsKt.LaunchedEffect(secureTextFieldController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer3, 0);
                                        companion2 = TextObfuscationMode.INSTANCE;
                                        zM16298equalsimpl0 = TextObfuscationMode.m16298equalsimpl0(iM16303getRevealLastTypedvTwcZD0, companion2.m16303getRevealLastTypedvTwcZD0());
                                        Boolean boolValueOf2 = Boolean.valueOf(zM16298equalsimpl0);
                                        zChanged = composer3.changed(zM16298equalsimpl0) | composer3.changedInstance(secureTextFieldController);
                                        char c52 = c4;
                                        objRememberedValue3 = composer3.rememberedValue();
                                        if (!zChanged) {
                                            objRememberedValue3 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(zM16298equalsimpl0, secureTextFieldController, null);
                                            composer3.updateRememberedValue(objRememberedValue3);
                                            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer3, 0);
                                            if ((i272 & 112) == 32) {
                                            }
                                            objRememberedValue4 = composer3.rememberedValue();
                                            if (!z3) {
                                                if (!TextObfuscationMode.m16298equalsimpl0(iM16303getRevealLastTypedvTwcZD0, companion2.m16303getRevealLastTypedvTwcZD0())) {
                                                }
                                                composer3.updateRememberedValue(objRememberedValue4);
                                                final CodepointTransformation codepointTransformation2 = (CodepointTransformation) objRememberedValue4;
                                                final Modifier modifierThen2 = SemanticsModifierKt.semantics(modifier4, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        invoke2(semanticsPropertyReceiver);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                return Boolean.FALSE;
                                                            }
                                                        }, 1, null);
                                                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            @NotNull
                                                            public final Boolean invoke() {
                                                                return Boolean.FALSE;
                                                            }
                                                        }, 1, null);
                                                    }
                                                }).then(!zM16298equalsimpl0 ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
                                                final boolean z52 = z2;
                                                final InputTransformation inputTransformation42 = inputTransformation2;
                                                final TextStyle textStyle42 = textStyle2;
                                                final KeyboardActionHandler keyboardActionHandler42 = keyboardActionHandler2;
                                                final KeyboardOptions keyboardOptions42 = secureTextField$foundation_release;
                                                DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(2023988909, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                                    @Composable
                                                    public final void invoke(@Nullable Composer composer5, int i28) {
                                                        if ((i28 & 3) == 2 && composer5.getSkipping()) {
                                                            composer5.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2023988909, i28, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:177)");
                                                        }
                                                        BasicTextFieldKt.BasicTextField(textFieldState, modifierThen2, z52, false, zM16298equalsimpl0 ? BasicSecureTextFieldKt.then(inputTransformation42, secureTextFieldController.getPasswordInputTransformation()) : inputTransformation42, textStyle42, keyboardOptions42, keyboardActionHandler42, TextFieldLineLimits.SingleLine.INSTANCE, function23, mutableInteractionSource3, solidColor, codepointTransformation2, null, textFieldDecorator3, null, true, composer5, 100666368, 1572864, 40960);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer3, 54), composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                i24 = iM16303getRevealLastTypedvTwcZD0;
                                                composer4 = composer3;
                                                z4 = z52;
                                                inputTransformation3 = inputTransformation42;
                                                textStyle3 = textStyle42;
                                                keyboardOptions3 = keyboardOptions42;
                                                keyboardActionHandler3 = keyboardActionHandler42;
                                                function22 = function23;
                                                mutableInteractionSource2 = mutableInteractionSource3;
                                                brush2 = solidColor;
                                                textFieldDecorator2 = textFieldDecorator3;
                                                c2 = c52;
                                                modifier3 = modifier4;
                                            }
                                        }
                                    }
                                }
                                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i15 = i14;
                            i16 = i5 & 512;
                            if (i16 == 0) {
                            }
                            i17 = i16;
                            i18 = i5 & 1024;
                            if (i18 == 0) {
                            }
                            i20 = i5 & 2048;
                            if (i20 == 0) {
                            }
                            int i2622 = i19;
                            i22 = i5 & 4096;
                            if (i22 == 0) {
                            }
                            if ((i6 & 306783379) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i13 = i12;
                        i14 = i5 & 256;
                        if (i14 == 0) {
                        }
                        i15 = i14;
                        i16 = i5 & 512;
                        if (i16 == 0) {
                        }
                        i17 = i16;
                        i18 = i5 & 1024;
                        if (i18 == 0) {
                        }
                        i20 = i5 & 2048;
                        if (i20 == 0) {
                        }
                        int i26222 = i19;
                        i22 = i5 & 4096;
                        if (i22 == 0) {
                        }
                        if ((i6 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    textStyle2 = textStyle;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i5 & 256;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 512;
                    if (i16 == 0) {
                    }
                    i17 = i16;
                    i18 = i5 & 1024;
                    if (i18 == 0) {
                    }
                    i20 = i5 & 2048;
                    if (i20 == 0) {
                    }
                    int i262222 = i19;
                    i22 = i5 & 4096;
                    if (i22 == 0) {
                    }
                    if ((i6 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                inputTransformation2 = inputTransformation;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                textStyle2 = textStyle;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i5 & 256;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i5 & 512;
                if (i16 == 0) {
                }
                i17 = i16;
                i18 = i5 & 1024;
                if (i18 == 0) {
                }
                i20 = i5 & 2048;
                if (i20 == 0) {
                }
                int i2622222 = i19;
                i22 = i5 & 4096;
                if (i22 == 0) {
                }
                if ((i6 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            inputTransformation2 = inputTransformation;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            textStyle2 = textStyle;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i5 & 256;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i5 & 512;
            if (i16 == 0) {
            }
            i17 = i16;
            i18 = i5 & 1024;
            if (i18 == 0) {
            }
            i20 = i5 & 2048;
            if (i20 == 0) {
            }
            int i26222222 = i19;
            i22 = i5 & 4096;
            if (i22 == 0) {
            }
            if ((i6 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        z2 = z;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        inputTransformation2 = inputTransformation;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        textStyle2 = textStyle;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i5 & 256;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i5 & 512;
        if (i16 == 0) {
        }
        i17 = i16;
        i18 = i5 & 1024;
        if (i18 == 0) {
        }
        i20 = i5 & 2048;
        if (i20 == 0) {
        }
        int i262222222 = i19;
        i22 = i5 & 4096;
        if (i22 == 0) {
        }
        if ((i6 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1085555050);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:310)");
            }
            final TextToolbar textToolbar = (TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            boolean zChanged = composerStartRestartGroup.changed(textToolbar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    {
                        this.$$delegate_0 = this.$currentToolbar;
                    }

                    @Override // androidx.compose.p109ui.platform.TextToolbar
                    @NotNull
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.p109ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    @Override // androidx.compose.p109ui.platform.TextToolbar
                    public void showMenu(@NotNull Rect rect, @Nullable Function0<Unit> onCopyRequested, @Nullable Function0<Unit> onPasteRequested, @Nullable Function0<Unit> onCutRequested, @Nullable Function0<Unit> onSelectAllRequested) {
                        this.$currentToolbar.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) objRememberedValue), ComposableLambdaKt.rememberComposableLambda(-1448819882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1
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

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448819882, i4, -1, "androidx.compose.foundation.text.DisableCutCopy.<anonymous> (BasicSecureTextField.kt:332)");
                    }
                    Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m16142invokeZmokQxo(keyEvent.m19573unboximpl());
                        }

                        @NotNull
                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m16142invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                            KeyCommand keyCommandMo16169mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo16169mapZmokQxo(keyEvent);
                            return Boolean.valueOf(keyCommandMo16169mapZmokQxo == KeyCommand.COPY || keyCommandMo16169mapZmokQxo == KeyCommand.CUT);
                        }
                    });
                    Function2<Composer, Integer, Unit> function22 = function2;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierOnPreviewKeyEvent);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    function22.invoke(composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.2
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
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }
}
