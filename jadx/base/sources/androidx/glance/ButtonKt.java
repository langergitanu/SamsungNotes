package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.text.EmittableText;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\u001aQ\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0007¨\u0006\u0019"}, m13886d2 = {"Button", "", "text", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/glance/GlanceModifier;", "enabled", "", "style", "Landroidx/glance/text/TextStyle;", "colors", "Landroidx/glance/ButtonColors;", "maxLines", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLandroidx/glance/text/TextStyle;Landroidx/glance/ButtonColors;ILandroidx/compose/runtime/Composer;II)V", "key", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLandroidx/glance/text/TextStyle;Landroidx/glance/ButtonColors;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/action/Action;", "(Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLandroidx/glance/text/TextStyle;Landroidx/glance/ButtonColors;ILandroidx/compose/runtime/Composer;II)V", "ButtonElement", "toEmittableText", "Landroidx/glance/text/EmittableText;", "Landroidx/glance/EmittableButton;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Button.kt\nandroidx/glance/ButtonKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,202:1\n33#2:203\n34#2:220\n251#3,8:204\n259#3,2:218\n3737#4,6:212\n*S KotlinDebug\n*F\n+ 1 Button.kt\nandroidx/glance/ButtonKt\n*L\n118#1:203\n118#1:220\n118#1:204,8\n118#1:218,2\n126#1:212,6\n*E\n"})
public final class ButtonKt {

    /* JADX INFO: renamed from: androidx.glance.ButtonKt$ButtonElement$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28131 extends FunctionReferenceImpl implements Function0<EmittableButton> {
        public static final C28131 INSTANCE = new C28131();

        public C28131() {
            super(0, EmittableButton.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableButton invoke() {
            return new EmittableButton();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(@NotNull final String text, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable TextStyle textStyle, @Nullable ButtonColors buttonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z2;
        int i7;
        TextStyle textStyle2;
        ButtonColors buttonColors2;
        int i8;
        int i9;
        int i10;
        GlanceModifier glanceModifier3;
        Composer composer2;
        TextStyle textStyle3;
        ButtonColors buttonColors3;
        int i11;
        boolean z3;
        Composer composer3;
        final ButtonColors buttonColors4;
        final TextStyle textStyle4;
        final boolean z4;
        final GlanceModifier glanceModifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(81945084);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i12 = i4 & 4;
        if (i12 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i2) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            buttonColors2 = buttonColors;
                            int i13 = composerStartRestartGroup.changed(buttonColors2) ? 131072 : 65536;
                            i5 |= i13;
                        } else {
                            buttonColors2 = buttonColors;
                        }
                        i5 |= i13;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i8 = i4 & 64;
                    if (i8 != 0) {
                        if ((3670016 & i2) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                        }
                        i10 = i5;
                        if ((2995931 & i10) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            glanceModifier4 = glanceModifier2;
                            composer3 = composerStartRestartGroup;
                            z4 = z2;
                            textStyle4 = textStyle2;
                            buttonColors4 = buttonColors2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                glanceModifier3 = i12 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                                boolean z5 = i6 == 0 ? true : z2;
                                if (i7 != 0) {
                                    textStyle2 = null;
                                }
                                if ((i4 & 32) != 0) {
                                    i10 &= -458753;
                                    buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composerStartRestartGroup, 384, 3);
                                }
                                if (i8 == 0) {
                                    composer2 = composerStartRestartGroup;
                                    textStyle3 = textStyle2;
                                    buttonColors3 = buttonColors2;
                                    i11 = Integer.MAX_VALUE;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    textStyle3 = textStyle2;
                                    buttonColors3 = buttonColors2;
                                    i11 = i9;
                                }
                                z3 = z5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 32) != 0) {
                                    i10 &= -458753;
                                }
                                glanceModifier3 = glanceModifier2;
                                composer2 = composerStartRestartGroup;
                                z3 = z2;
                                textStyle3 = textStyle2;
                                buttonColors3 = buttonColors2;
                                i11 = i9;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(81945084, i10, -1, "androidx.glance.Button (Button.kt:48)");
                            }
                            ButtonElement(text, onClick, glanceModifier3, z3, textStyle3, buttonColors3, i11, composer2, 4194302 & i10, 0);
                            i9 = i11;
                            Composer composer4 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer4;
                            buttonColors4 = buttonColors3;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier3;
                        }
                        final int i14 = i9;
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.ButtonKt.Button.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer5, int i15) {
                                    ButtonKt.Button(text, onClick, glanceModifier4, z4, textStyle4, buttonColors4, i14, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 1572864;
                    i9 = i;
                    i10 = i5;
                    if ((2995931 & i10) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i12 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i4 & 32) != 0) {
                            }
                            if (i8 == 0) {
                            }
                            z3 = z5;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ButtonElement(text, onClick, glanceModifier3, z3, textStyle3, buttonColors3, i11, composer2, 4194302 & i10, 0);
                            i9 = i11;
                            Composer composer42 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer3 = composer42;
                            buttonColors4 = buttonColors3;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier3;
                        }
                    }
                    final int i142 = i9;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                textStyle2 = textStyle;
                if ((458752 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                }
                i9 = i;
                i10 = i5;
                if ((2995931 & i10) == 599186) {
                }
                final int i1422 = i9;
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            textStyle2 = textStyle;
            if ((458752 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i5;
            if ((2995931 & i10) == 599186) {
            }
            final int i14222 = i9;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        textStyle2 = textStyle;
        if ((458752 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i5;
        if ((2995931 & i10) == 599186) {
        }
        final int i142222 = i9;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0113  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ButtonElement(@NotNull final String text, @NotNull final Action onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable TextStyle textStyle, @Nullable ButtonColors buttonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z2;
        int i7;
        TextStyle textStyle2;
        ButtonColors buttonColors2;
        int i8;
        int i9;
        GlanceModifier glanceModifier3;
        TextStyle textStyle3;
        Composer composerM18018constructorimpl;
        ButtonKt$ButtonElement$2$6 buttonKt$ButtonElement$2$6;
        final GlanceModifier glanceModifier4;
        final TextStyle textStyle4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(507525656);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i10 = i4 & 4;
        if (i10 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i2) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            buttonColors2 = buttonColors;
                            int i11 = composerStartRestartGroup.changed(buttonColors2) ? 131072 : 65536;
                            i5 |= i11;
                        } else {
                            buttonColors2 = buttonColors;
                        }
                        i5 |= i11;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i8 = i4 & 64;
                    if (i8 != 0) {
                        if ((3670016 & i2) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                        }
                        if ((2995931 & i5) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            glanceModifier4 = glanceModifier2;
                            textStyle4 = textStyle2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                glanceModifier3 = i10 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                TextStyle textStyle5 = i7 == 0 ? null : textStyle2;
                                if ((i4 & 32) != 0) {
                                    i5 &= -458753;
                                    buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composerStartRestartGroup, 384, 3);
                                }
                                if (i8 == 0) {
                                    textStyle3 = textStyle5;
                                    i9 = Integer.MAX_VALUE;
                                } else {
                                    i9 = i;
                                    textStyle3 = textStyle5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 32) != 0) {
                                    i5 &= -458753;
                                }
                                glanceModifier3 = glanceModifier2;
                                textStyle3 = textStyle2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(507525656, i5, -1, "androidx.glance.ButtonElement (Button.kt:111)");
                            }
                            GlanceModifier glanceModifierBackground = BackgroundKt.background(!z2 ? ActionKt.clickable(glanceModifier3, onClick) : glanceModifier3, buttonColors2.getBackgroundColor());
                            if (textStyle3 != null || (textStyle = textStyle3.m22037copyfnGRNro((32766 & 1) != 0 ? textStyle3.color : buttonColors2.getContentColor(), (32766 & 2) != 0 ? textStyle3.fontSize : null, (32766 & 4) != 0 ? textStyle3.fontWeight : null, (32766 & 8) != 0 ? textStyle3.fontStyle : null, (32766 & 16) != 0 ? textStyle3.textAlign : null, (32766 & 32) != 0 ? textStyle3.textDecoration : null, (32766 & 64) != 0 ? textStyle3.fontFamily : null, (32766 & 128) != 0 ? textStyle3.textDirection : 0, (32766 & 256) != 0 ? textStyle3.hasShadow : false, (32766 & 512) != 0 ? textStyle3.textShadowStyle : null, (32766 & 1024) != 0 ? textStyle3.complexUnit : null, (32766 & 2048) != 0 ? textStyle3.textSizeDimenResource : 0, (32766 & 4096) != 0 ? textStyle3.percentData : null, (32766 & 8192) != 0 ? textStyle3.textVerticalAlign : null, (32766 & 16384) != 0 ? textStyle3.textAppearanceResource : 0)) == null) {
                                TextStyle textStyle6 = new TextStyle(buttonColors2.getContentColor(), null, null, null, null, null, null, 0, false, null, null, 0, null, null, 0, 32766, null);
                            }
                            C28131 c28131 = C28131.INSTANCE;
                            if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.useNode();
                            } else {
                                composerStartRestartGroup.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(c28131));
                            }
                            composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                            Updater.m18025setimpl(composerM18018constructorimpl, text, new Function2<EmittableButton, String, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, String str) {
                                    invoke2(emittableButton, str);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull EmittableButton set, @NotNull String it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setText(it);
                                }
                            });
                            Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierBackground, new Function2<EmittableButton, GlanceModifier, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, GlanceModifier glanceModifier5) {
                                    invoke2(emittableButton, glanceModifier5);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull EmittableButton set, @NotNull GlanceModifier it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setModifier(it);
                                }
                            });
                            Updater.m18025setimpl(composerM18018constructorimpl, textStyle6, new Function2<EmittableButton, TextStyle, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, TextStyle textStyle7) {
                                    invoke2(emittableButton, textStyle7);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull EmittableButton set, @NotNull TextStyle it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setStyle(it);
                                }
                            });
                            Updater.m18025setimpl(composerM18018constructorimpl, buttonColors2, new Function2<EmittableButton, ButtonColors, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, ButtonColors buttonColors3) {
                                    invoke2(emittableButton, buttonColors3);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull EmittableButton set, @NotNull ButtonColors it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.setColors(it);
                                }
                            });
                            Updater.m18025setimpl(composerM18018constructorimpl, Boolean.valueOf(z2), new Function2<EmittableButton, Boolean, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, Boolean bool) {
                                    invoke(emittableButton, bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@NotNull EmittableButton set, boolean z3) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setEnabled(z3);
                                }
                            });
                            buttonKt$ButtonElement$2$6 = new Function2<EmittableButton, Integer, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, Integer num) {
                                    invoke(emittableButton, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@NotNull EmittableButton set, int i12) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.setMaxLines(i12);
                                }
                            };
                            if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i9))) {
                                composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i9));
                                composerM18018constructorimpl.apply(Integer.valueOf(i9), buttonKt$ButtonElement$2$6);
                            }
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            glanceModifier4 = glanceModifier3;
                            textStyle4 = textStyle3;
                        }
                        final boolean z3 = z2;
                        final ButtonColors buttonColors3 = buttonColors2;
                        final int i12 = i9;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.ButtonKt.ButtonElement.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer2, int i13) {
                                    ButtonKt.ButtonElement(text, onClick, glanceModifier4, z3, textStyle4, buttonColors3, i12, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 1572864;
                    i9 = i;
                    if ((2995931 & i5) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i10 == 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 == 0) {
                            }
                            if ((i4 & 32) != 0) {
                            }
                            if (i8 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            GlanceModifier glanceModifierBackground2 = BackgroundKt.background(!z2 ? ActionKt.clickable(glanceModifier3, onClick) : glanceModifier3, buttonColors2.getBackgroundColor());
                            if (textStyle3 != null) {
                                TextStyle textStyle62 = new TextStyle(buttonColors2.getContentColor(), null, null, null, null, null, null, 0, false, null, null, 0, null, null, 0, 32766, null);
                                C28131 c281312 = C28131.INSTANCE;
                                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Updater.m18025setimpl(composerM18018constructorimpl, text, new Function2<EmittableButton, String, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, String str) {
                                        invoke2(emittableButton, str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull EmittableButton set, @NotNull String it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setText(it);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierBackground2, new Function2<EmittableButton, GlanceModifier, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, GlanceModifier glanceModifier5) {
                                        invoke2(emittableButton, glanceModifier5);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull EmittableButton set, @NotNull GlanceModifier it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setModifier(it);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl, textStyle62, new Function2<EmittableButton, TextStyle, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, TextStyle textStyle7) {
                                        invoke2(emittableButton, textStyle7);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull EmittableButton set, @NotNull TextStyle it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setStyle(it);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl, buttonColors2, new Function2<EmittableButton, ButtonColors, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, ButtonColors buttonColors32) {
                                        invoke2(emittableButton, buttonColors32);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull EmittableButton set, @NotNull ButtonColors it) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        set.setColors(it);
                                    }
                                });
                                Updater.m18025setimpl(composerM18018constructorimpl, Boolean.valueOf(z2), new Function2<EmittableButton, Boolean, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$5
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, Boolean bool) {
                                        invoke(emittableButton, bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull EmittableButton set, boolean z32) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setEnabled(z32);
                                    }
                                });
                                buttonKt$ButtonElement$2$6 = new Function2<EmittableButton, Integer, Unit>() { // from class: androidx.glance.ButtonKt$ButtonElement$2$6
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(EmittableButton emittableButton, Integer num) {
                                        invoke(emittableButton, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull EmittableButton set, int i122) {
                                        Intrinsics.checkNotNullParameter(set, "$this$set");
                                        set.setMaxLines(i122);
                                    }
                                };
                                if (!composerM18018constructorimpl.getInserting()) {
                                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i9));
                                    composerM18018constructorimpl.apply(Integer.valueOf(i9), buttonKt$ButtonElement$2$6);
                                    composerStartRestartGroup.endNode();
                                    composerStartRestartGroup.endReplaceableGroup();
                                    composerStartRestartGroup.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    glanceModifier4 = glanceModifier3;
                                    textStyle4 = textStyle3;
                                }
                            }
                        }
                    }
                    final boolean z32 = z2;
                    final ButtonColors buttonColors32 = buttonColors2;
                    final int i122 = i9;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                textStyle2 = textStyle;
                if ((458752 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                }
                i9 = i;
                if ((2995931 & i5) == 599186) {
                }
                final boolean z322 = z2;
                final ButtonColors buttonColors322 = buttonColors2;
                final int i1222 = i9;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            textStyle2 = textStyle;
            if ((458752 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i9 = i;
            if ((2995931 & i5) == 599186) {
            }
            final boolean z3222 = z2;
            final ButtonColors buttonColors3222 = buttonColors2;
            final int i12222 = i9;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        textStyle2 = textStyle;
        if ((458752 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i9 = i;
        if ((2995931 & i5) == 599186) {
        }
        final boolean z32222 = z2;
        final ButtonColors buttonColors32222 = buttonColors2;
        final int i122222 = i9;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final EmittableText toEmittableText(@NotNull EmittableButton emittableButton) {
        Intrinsics.checkNotNullParameter(emittableButton, "<this>");
        EmittableText emittableText = new EmittableText();
        emittableText.setModifier(emittableButton.getModifier());
        emittableText.setText(emittableButton.getText());
        emittableText.setStyle(emittableButton.getStyle());
        emittableText.setMaxLines(emittableButton.getMaxLines());
        return emittableText;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(@NotNull final String text, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable TextStyle textStyle, @Nullable ButtonColors buttonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z2;
        int i7;
        TextStyle textStyle2;
        ButtonColors buttonColors2;
        int i8;
        int i9;
        int i10;
        GlanceModifier glanceModifier3;
        String str;
        int i11;
        Composer composer2;
        TextStyle textStyle3;
        int i12;
        boolean z3;
        Composer composer3;
        final int i13;
        final TextStyle textStyle4;
        final boolean z4;
        final GlanceModifier glanceModifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-650085672);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i14 = i4 & 4;
        if (i14 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i2) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            buttonColors2 = buttonColors;
                            int i15 = composerStartRestartGroup.changed(buttonColors2) ? 131072 : 65536;
                            i5 |= i15;
                        } else {
                            buttonColors2 = buttonColors;
                        }
                        i5 |= i15;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i8 = i4 & 64;
                    if (i8 != 0) {
                        if ((3670016 & i2) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                        }
                        i10 = i5;
                        if ((2995931 & i10) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            glanceModifier4 = glanceModifier2;
                            z4 = z2;
                            composer3 = composerStartRestartGroup;
                            textStyle4 = textStyle2;
                            i13 = i9;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 32) != 0) {
                                    i10 &= -458753;
                                }
                                str = null;
                                i11 = 1;
                                glanceModifier3 = glanceModifier2;
                                z3 = z2;
                                composer2 = composerStartRestartGroup;
                                textStyle3 = textStyle2;
                                i12 = i9;
                            } else {
                                glanceModifier3 = i14 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                                boolean z5 = i6 == 0 ? true : z2;
                                if (i7 != 0) {
                                    textStyle2 = null;
                                }
                                if ((i4 & 32) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    str = null;
                                    i10 &= -458753;
                                    buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composer2, 384, 3);
                                    i11 = 1;
                                } else {
                                    str = null;
                                    i11 = 1;
                                    composer2 = composerStartRestartGroup;
                                }
                                if (i8 == 0) {
                                    i12 = Integer.MAX_VALUE;
                                    textStyle3 = textStyle2;
                                } else {
                                    textStyle3 = textStyle2;
                                    i12 = i9;
                                }
                                z3 = z5;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-650085672, i10, -1, "androidx.glance.Button (Button.kt:71)");
                            }
                            GlanceModifier glanceModifier5 = glanceModifier3;
                            Composer composer4 = composer2;
                            ButtonElement(text, LambdaActionKt.action(str, onClick, composer2, i10 & 112, i11), glanceModifier5, z3, textStyle3, buttonColors2, i12, composer4, i10 & 4194190, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer4;
                            i13 = i12;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier5;
                        }
                        final ButtonColors buttonColors3 = buttonColors2;
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.ButtonKt.Button.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer5, int i16) {
                                    ButtonKt.Button(text, onClick, glanceModifier4, z4, textStyle4, buttonColors3, i13, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 1572864;
                    i9 = i;
                    i10 = i5;
                    if ((2995931 & i10) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0) {
                            if (i14 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i4 & 32) == 0) {
                            }
                            if (i8 == 0) {
                            }
                            z3 = z5;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            GlanceModifier glanceModifier52 = glanceModifier3;
                            Composer composer42 = composer2;
                            ButtonElement(text, LambdaActionKt.action(str, onClick, composer2, i10 & 112, i11), glanceModifier52, z3, textStyle3, buttonColors2, i12, composer42, i10 & 4194190, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer3 = composer42;
                            i13 = i12;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier52;
                        }
                    }
                    final ButtonColors buttonColors32 = buttonColors2;
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                textStyle2 = textStyle;
                if ((458752 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                }
                i9 = i;
                i10 = i5;
                if ((2995931 & i10) == 599186) {
                }
                final ButtonColors buttonColors322 = buttonColors2;
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            textStyle2 = textStyle;
            if ((458752 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i5;
            if ((2995931 & i10) == 599186) {
            }
            final ButtonColors buttonColors3222 = buttonColors2;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        textStyle2 = textStyle;
        if ((458752 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i5;
        if ((2995931 & i10) == 599186) {
        }
        final ButtonColors buttonColors32222 = buttonColors2;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011b  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @ExperimentalGlanceApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(@NotNull final String text, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z, @Nullable TextStyle textStyle, @Nullable ButtonColors buttonColors, int i, @Nullable String str, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z2;
        int i7;
        TextStyle textStyle2;
        ButtonColors buttonColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2;
        int i12;
        String str3;
        GlanceModifier glanceModifier3;
        TextStyle textStyle3;
        int i13;
        int i14;
        boolean z3;
        Composer composer2;
        final int i15;
        final String str4;
        final TextStyle textStyle4;
        final boolean z4;
        final GlanceModifier glanceModifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1113587393);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i16 = i4 & 4;
        if (i16 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 896) == 0) {
                glanceModifier2 = glanceModifier;
                i5 |= composerStartRestartGroup.changed(glanceModifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 7168) == 0) {
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i2) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((458752 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            buttonColors2 = buttonColors;
                            int i17 = composerStartRestartGroup.changed(buttonColors2) ? 131072 : 65536;
                            i5 |= i17;
                        } else {
                            buttonColors2 = buttonColors;
                        }
                        i5 |= i17;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i8 = i4 & 64;
                    if (i8 != 0) {
                        if ((3670016 & i2) == 0) {
                            i9 = i;
                            i5 |= composerStartRestartGroup.changed(i9) ? 1048576 : 524288;
                        }
                        i10 = i4 & 128;
                        if (i10 != 0) {
                            i12 = i5 | 12582912;
                            i11 = i16;
                            str2 = str;
                        } else {
                            i11 = i16;
                            str2 = str;
                            if ((i2 & 29360128) == 0) {
                                i5 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
                            }
                            i12 = i5;
                        }
                        if ((i12 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            str4 = str2;
                            glanceModifier4 = glanceModifier2;
                            composer2 = composerStartRestartGroup;
                            z4 = z2;
                            textStyle4 = textStyle2;
                            i15 = i9;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 32) != 0) {
                                    i12 &= -458753;
                                }
                                str3 = str2;
                                glanceModifier3 = glanceModifier2;
                                z3 = z2;
                                textStyle3 = textStyle2;
                                i13 = i9;
                                i14 = i12;
                            } else {
                                GlanceModifier glanceModifier5 = i11 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                                boolean z5 = i6 == 0 ? true : z2;
                                if (i7 != 0) {
                                    textStyle2 = null;
                                }
                                if ((i4 & 32) != 0) {
                                    i12 &= -458753;
                                    buttonColors2 = ButtonDefaults.INSTANCE.buttonColors(null, null, composerStartRestartGroup, 384, 3);
                                }
                                if (i8 != 0) {
                                    i9 = Integer.MAX_VALUE;
                                }
                                if (i10 == 0) {
                                    glanceModifier3 = glanceModifier5;
                                    textStyle3 = textStyle2;
                                    i13 = i9;
                                    i14 = i12;
                                    z3 = z5;
                                    str3 = null;
                                } else {
                                    str3 = str;
                                    glanceModifier3 = glanceModifier5;
                                    textStyle3 = textStyle2;
                                    i13 = i9;
                                    i14 = i12;
                                    z3 = z5;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1113587393, i14, -1, "androidx.glance.Button (Button.kt:100)");
                            }
                            ButtonElement(text, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i14 >> 21) & 14) | (i14 & 112), 0), glanceModifier3, z3, textStyle3, buttonColors2, i13, composerStartRestartGroup, i14 & 4194190, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            i15 = i13;
                            str4 = str3;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier3;
                        }
                        final ButtonColors buttonColors3 = buttonColors2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.ButtonKt.Button.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i18) {
                                    ButtonKt.Button(text, onClick, glanceModifier4, z4, textStyle4, buttonColors3, i15, str4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 1572864;
                    i9 = i;
                    i10 = i4 & 128;
                    if (i10 != 0) {
                    }
                    if ((i12 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0) {
                            if (i11 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i4 & 32) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ButtonElement(text, LambdaActionKt.action(str3, onClick, composerStartRestartGroup, ((i14 >> 21) & 14) | (i14 & 112), 0), glanceModifier3, z3, textStyle3, buttonColors2, i13, composerStartRestartGroup, i14 & 4194190, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            i15 = i13;
                            str4 = str3;
                            textStyle4 = textStyle3;
                            z4 = z3;
                            glanceModifier4 = glanceModifier3;
                        }
                    }
                    final ButtonColors buttonColors32 = buttonColors2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                textStyle2 = textStyle;
                if ((458752 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                }
                i9 = i;
                i10 = i4 & 128;
                if (i10 != 0) {
                }
                if ((i12 & 23967451) == 4793490) {
                }
                final ButtonColors buttonColors322 = buttonColors2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            textStyle2 = textStyle;
            if ((458752 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i9 = i;
            i10 = i4 & 128;
            if (i10 != 0) {
            }
            if ((i12 & 23967451) == 4793490) {
            }
            final ButtonColors buttonColors3222 = buttonColors2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        textStyle2 = textStyle;
        if ((458752 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i9 = i;
        i10 = i4 & 128;
        if (i10 != 0) {
        }
        if ((i12 & 23967451) == 4793490) {
        }
        final ButtonColors buttonColors32222 = buttonColors2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
