package androidx.glance.appwidget;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceModifier;
import androidx.glance.action.Action;
import androidx.glance.action.ActionModifier;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.appwidget.action.CompoundButtonAction;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u0012\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\u001aS\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, m13886d2 = {"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function0;", "modifier", "Landroidx/glance/GlanceModifier;", "text", "", "style", "Landroidx/glance/text/TextStyle;", "colors", "Landroidx/glance/appwidget/SwitchColors;", "maxLines", "", "(ZLkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;Ljava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/SwitchColors;ILandroidx/compose/runtime/Composer;II)V", "key", "(ZLkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;Ljava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/SwitchColors;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/action/Action;", "(ZLandroidx/glance/action/Action;Landroidx/glance/GlanceModifier;Ljava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/SwitchColors;ILandroidx/compose/runtime/Composer;II)V", "SwitchElement", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSwitch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Switch.kt\nandroidx/glance/appwidget/SwitchKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,268:1\n1116#2,6:269\n33#3:275\n34#3:292\n251#4,8:276\n259#4,2:290\n3737#5,6:284\n*S KotlinDebug\n*F\n+ 1 Switch.kt\nandroidx/glance/appwidget/SwitchKt\n*L\n234#1:269,6\n233#1:275\n233#1:292\n233#1:276,8\n233#1:290,2\n241#1:284,6\n*E\n"})
public final class SwitchKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void Switch(final boolean z, @Nullable final Action action, @Nullable GlanceModifier glanceModifier, @Nullable String str, @Nullable TextStyle textStyle, @Nullable SwitchColors switchColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        SwitchColors switchColorsColors;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-126332887);
        final GlanceModifier glanceModifier2 = (i4 & 4) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final String str2 = (i4 & 8) != 0 ? "" : str;
        final TextStyle textStyle2 = (i4 & 16) != 0 ? null : textStyle;
        if ((i4 & 32) != 0) {
            i5 = i2 & (-458753);
            switchColorsColors = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
        } else {
            switchColorsColors = switchColors;
            i5 = i2;
        }
        int i6 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126332887, i5, -1, "androidx.glance.appwidget.Switch (Switch.kt:75)");
        }
        SwitchElement(z, action, glanceModifier2, str2, textStyle2, switchColorsColors, i6, composerStartRestartGroup, (i5 & 14) | 64 | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final SwitchColors switchColors2 = switchColorsColors;
            final int i7 = i6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SwitchKt.Switch.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    SwitchKt.Switch(z, action, glanceModifier2, str2, textStyle2, switchColors2, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void SwitchElement(final boolean z, final Action action, GlanceModifier glanceModifier, String str, TextStyle textStyle, SwitchColors switchColors, int i, Composer composer, final int i2, final int i4) {
        final SwitchColors switchColorsColors;
        int i5;
        boolean z2;
        GlanceModifier glanceModifierThen;
        Composer composerStartRestartGroup = composer.startRestartGroup(699312129);
        final GlanceModifier glanceModifier2 = (i4 & 4) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        final String str2 = (i4 & 8) != 0 ? "" : str;
        final TextStyle textStyle2 = (i4 & 16) != 0 ? null : textStyle;
        if ((i4 & 32) != 0) {
            switchColorsColors = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
            i5 = i2 & (-458753);
        } else {
            switchColorsColors = switchColors;
            i5 = i2;
        }
        int i6 = (i4 & 64) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(699312129, i5, -1, "androidx.glance.appwidget.SwitchElement (Switch.kt:226)");
        }
        if (action != null) {
            z2 = z;
            glanceModifierThen = glanceModifier2.then(new ActionModifier(new CompoundButtonAction(action, z2), 0, false, false, 14, null));
        } else {
            z2 = z;
            glanceModifierThen = glanceModifier2;
        }
        composerStartRestartGroup.startReplaceableGroup(-1079044759);
        boolean zChanged = composerStartRestartGroup.changed(switchColorsColors);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0<EmittableSwitch>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final EmittableSwitch invoke() {
                    return new EmittableSwitch(switchColorsColors);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final Function0 function0 = (Function0) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1115894518);
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new Function0<EmittableSwitch>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$$inlined$GlanceNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableSwitch, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final EmittableSwitch invoke() {
                    return function0.invoke();
                }
            });
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, Boolean.valueOf(z2), new Function2<EmittableSwitch, Boolean, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, Boolean bool) {
                invoke(emittableSwitch, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableSwitch set, boolean z3) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setChecked(z3);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, str2, new Function2<EmittableSwitch, String, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, String str3) {
                invoke2(emittableSwitch, str3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableSwitch set, @NotNull String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setText(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierThen, new Function2<EmittableSwitch, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, GlanceModifier glanceModifier3) {
                invoke2(emittableSwitch, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableSwitch set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, textStyle2, new Function2<EmittableSwitch, TextStyle, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, TextStyle textStyle3) {
                invoke2(emittableSwitch, textStyle3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableSwitch set, @Nullable TextStyle textStyle3) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStyle(textStyle3);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, switchColorsColors, new Function2<EmittableSwitch, SwitchColors, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, SwitchColors switchColors2) {
                invoke2(emittableSwitch, switchColors2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableSwitch set, @NotNull SwitchColors it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setColors(it);
            }
        });
        SwitchKt$SwitchElement$2$6 switchKt$SwitchElement$2$6 = new Function2<EmittableSwitch, Integer, Unit>() { // from class: androidx.glance.appwidget.SwitchKt$SwitchElement$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableSwitch emittableSwitch, Integer num) {
                invoke(emittableSwitch, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableSwitch set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setMaxLines(i7);
            }
        };
        if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i6))) {
            composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i6));
            composerM18018constructorimpl.apply(Integer.valueOf(i6), switchKt$SwitchElement$2$6);
        }
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i7 = i6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SwitchKt.SwitchElement.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    SwitchKt.SwitchElement(z, action, glanceModifier2, str2, textStyle2, switchColorsColors, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, @NotNull final Function0<Unit> onCheckedChange, @Nullable GlanceModifier glanceModifier, @Nullable String str, @Nullable TextStyle textStyle, @Nullable SwitchColors switchColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        boolean z2;
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        String str2;
        int i7;
        TextStyle textStyle2;
        SwitchColors switchColorsColors;
        int i8;
        int i9;
        int i10;
        int i11;
        GlanceModifier glanceModifier3;
        TextStyle textStyle3;
        Composer composer2;
        final GlanceModifier glanceModifier4;
        final String str3;
        final TextStyle textStyle4;
        final int i12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(982465051);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i2 & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 32 : 16;
        }
        int i13 = i4 & 4;
        if (i13 != 0) {
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
                    str2 = str;
                    i5 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((i2 & 57344) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i4 & 32) == 0) {
                            switchColorsColors = switchColors;
                            int i14 = composerStartRestartGroup.changed(switchColorsColors) ? 131072 : 65536;
                            i5 |= i14;
                        } else {
                            switchColorsColors = switchColors;
                        }
                        i5 |= i14;
                    } else {
                        switchColorsColors = switchColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        i9 = 57344;
                        i10 = i;
                    } else {
                        i9 = 57344;
                        i10 = i;
                        if ((i2 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
                        }
                    }
                    if ((i5 & 2995931) != 599186 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        glanceModifier4 = glanceModifier2;
                        str3 = str2;
                        i12 = i10;
                        textStyle4 = textStyle2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 32) != 0) {
                                i5 &= -458753;
                            }
                            i11 = i10;
                            textStyle3 = textStyle2;
                            glanceModifier3 = glanceModifier2;
                        } else {
                            GlanceModifier glanceModifier5 = i13 == 0 ? GlanceModifier.INSTANCE : glanceModifier2;
                            if (i6 != 0) {
                                str2 = "";
                            }
                            if (i7 != 0) {
                                textStyle2 = null;
                            }
                            if ((i4 & 32) != 0) {
                                i5 &= -458753;
                                switchColorsColors = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i8 == 0) {
                                glanceModifier3 = glanceModifier5;
                                i11 = Integer.MAX_VALUE;
                            } else {
                                i11 = i10;
                                glanceModifier3 = glanceModifier5;
                            }
                            textStyle3 = textStyle2;
                        }
                        String str4 = str2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(982465051, i5, -1, "androidx.glance.appwidget.Switch (Switch.kt:98)");
                        }
                        TextStyle textStyle5 = textStyle3;
                        composer2 = composerStartRestartGroup;
                        SwitchElement(z2, LambdaActionKt.action(null, onCheckedChange, composerStartRestartGroup, i5 & 112, 1), glanceModifier3, str4, textStyle5, switchColorsColors, i11, composer2, (i5 & 14) | 64 | (i5 & 896) | (i5 & 7168) | (i5 & i9) | (i5 & 458752) | (i5 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        glanceModifier4 = glanceModifier3;
                        str3 = str4;
                        textStyle4 = textStyle5;
                        i12 = i11;
                    }
                    final SwitchColors switchColors2 = switchColorsColors;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SwitchKt.Switch.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer3, int i15) {
                                SwitchKt.Switch(z, onCheckedChange, glanceModifier4, str3, textStyle4, switchColors2, i12, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 24576;
                textStyle2 = textStyle;
                if ((i2 & 458752) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                if ((i5 & 2995931) != 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i13 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i4 & 32) != 0) {
                        }
                        if (i8 == 0) {
                        }
                        textStyle3 = textStyle2;
                        String str42 = str2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        TextStyle textStyle52 = textStyle3;
                        composer2 = composerStartRestartGroup;
                        SwitchElement(z2, LambdaActionKt.action(null, onCheckedChange, composerStartRestartGroup, i5 & 112, 1), glanceModifier3, str42, textStyle52, switchColorsColors, i11, composer2, (i5 & 14) | 64 | (i5 & 896) | (i5 & 7168) | (i5 & i9) | (i5 & 458752) | (i5 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        glanceModifier4 = glanceModifier3;
                        str3 = str42;
                        textStyle4 = textStyle52;
                        i12 = i11;
                    }
                }
                final SwitchColors switchColors22 = switchColorsColors;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            str2 = str;
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            textStyle2 = textStyle;
            if ((i2 & 458752) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            if ((i5 & 2995931) != 599186) {
            }
            final SwitchColors switchColors222 = switchColorsColors;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        str2 = str;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        if ((i2 & 458752) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        if ((i5 & 2995931) != 599186) {
        }
        final SwitchColors switchColors2222 = switchColorsColors;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011f  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @ExperimentalGlanceApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, @NotNull final Function0<Unit> onCheckedChange, @Nullable GlanceModifier glanceModifier, @Nullable String str, @Nullable TextStyle textStyle, @Nullable SwitchColors switchColors, int i, @Nullable String str2, @Nullable Composer composer, final int i2, final int i4) {
        boolean z2;
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        String str3;
        int i7;
        TextStyle textStyle2;
        SwitchColors switchColorsColors;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        SwitchColors switchColors2;
        String str4;
        int i13;
        String str5;
        Composer composer2;
        final String str6;
        final GlanceModifier glanceModifier3;
        final String str7;
        final TextStyle textStyle3;
        final SwitchColors switchColors3;
        final int i14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(795136650);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i2 & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 32 : 16;
        }
        int i15 = i4 & 4;
        if (i15 != 0) {
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
                    str3 = str;
                    i5 |= composerStartRestartGroup.changed(str3) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((i2 & 57344) == 0) {
                        textStyle2 = textStyle;
                        i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i4 & 32) == 0) {
                            switchColorsColors = switchColors;
                            int i16 = composerStartRestartGroup.changed(switchColorsColors) ? 131072 : 65536;
                            i5 |= i16;
                        } else {
                            switchColorsColors = switchColors;
                        }
                        i5 |= i16;
                    } else {
                        switchColorsColors = switchColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        i9 = 57344;
                        i10 = i;
                    } else {
                        i9 = 57344;
                        i10 = i;
                        if ((i2 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
                        }
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        i5 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
                    }
                    int i17 = i5;
                    if ((i5 & 23967451) != 4793490 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str6 = str2;
                        composer2 = composerStartRestartGroup;
                        glanceModifier3 = glanceModifier2;
                        str7 = str3;
                        i14 = i10;
                        textStyle3 = textStyle2;
                        switchColors3 = switchColorsColors;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 32) != 0) {
                                i12 = i17 & (-458753);
                            } else {
                                str5 = str2;
                                str4 = str3;
                                switchColors2 = switchColorsColors;
                                i13 = 3670016;
                                i12 = i17;
                                int i18 = i10;
                                TextStyle textStyle4 = textStyle2;
                                GlanceModifier glanceModifier4 = glanceModifier2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composer2 = composerStartRestartGroup;
                                SwitchElement(z2, LambdaActionKt.action(str5, onCheckedChange, composerStartRestartGroup, ((i12 >> 21) & 14) | (i12 & 112), 0), glanceModifier4, str4, textStyle4, switchColors2, i18, composer2, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168) | (i12 & i9) | (i12 & 458752) | (i12 & i13), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                str6 = str5;
                                glanceModifier3 = glanceModifier4;
                                str7 = str4;
                                textStyle3 = textStyle4;
                                switchColors3 = switchColors2;
                                i14 = i18;
                            }
                        } else {
                            if (i15 != 0) {
                                glanceModifier2 = GlanceModifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                str3 = "";
                            }
                            if (i7 != 0) {
                                textStyle2 = null;
                            }
                            if ((i4 & 32) == 0) {
                                i12 = i17 & (-458753);
                                switchColorsColors = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i12 = i17;
                            }
                            if (i8 != 0) {
                                i10 = Integer.MAX_VALUE;
                            }
                            if (i11 == 0) {
                            }
                            str4 = str3;
                            switchColors2 = switchColorsColors;
                            i13 = 3670016;
                            int i182 = i10;
                            TextStyle textStyle42 = textStyle2;
                            GlanceModifier glanceModifier42 = glanceModifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(795136650, i12, -1, "androidx.glance.appwidget.Switch (Switch.kt:135)");
                            }
                            composer2 = composerStartRestartGroup;
                            SwitchElement(z2, LambdaActionKt.action(str5, onCheckedChange, composerStartRestartGroup, ((i12 >> 21) & 14) | (i12 & 112), 0), glanceModifier42, str4, textStyle42, switchColors2, i182, composer2, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168) | (i12 & i9) | (i12 & 458752) | (i12 & i13), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str6 = str5;
                            glanceModifier3 = glanceModifier42;
                            str7 = str4;
                            textStyle3 = textStyle42;
                            switchColors3 = switchColors2;
                            i14 = i182;
                        }
                        str4 = str3;
                        switchColors2 = switchColorsColors;
                        i13 = 3670016;
                        int i1822 = i10;
                        TextStyle textStyle422 = textStyle2;
                        GlanceModifier glanceModifier422 = glanceModifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        SwitchElement(z2, LambdaActionKt.action(str5, onCheckedChange, composerStartRestartGroup, ((i12 >> 21) & 14) | (i12 & 112), 0), glanceModifier422, str4, textStyle422, switchColors2, i1822, composer2, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168) | (i12 & i9) | (i12 & 458752) | (i12 & i13), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str6 = str5;
                        glanceModifier3 = glanceModifier422;
                        str7 = str4;
                        textStyle3 = textStyle422;
                        switchColors3 = switchColors2;
                        i14 = i1822;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SwitchKt.Switch.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer3, int i19) {
                                SwitchKt.Switch(z, onCheckedChange, glanceModifier3, str7, textStyle3, switchColors3, i14, str6, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 24576;
                textStyle2 = textStyle;
                if ((i2 & 458752) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                int i172 = i5;
                if ((i5 & 23967451) != 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) == 0) {
                        if (i15 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i4 & 32) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        str5 = i11 == 0 ? str2 : null;
                        str4 = str3;
                        switchColors2 = switchColorsColors;
                        i13 = 3670016;
                        int i18222 = i10;
                        TextStyle textStyle4222 = textStyle2;
                        GlanceModifier glanceModifier4222 = glanceModifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        SwitchElement(z2, LambdaActionKt.action(str5, onCheckedChange, composerStartRestartGroup, ((i12 >> 21) & 14) | (i12 & 112), 0), glanceModifier4222, str4, textStyle4222, switchColors2, i18222, composer2, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168) | (i12 & i9) | (i12 & 458752) | (i12 & i13), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str6 = str5;
                        glanceModifier3 = glanceModifier4222;
                        str7 = str4;
                        textStyle3 = textStyle4222;
                        switchColors3 = switchColors2;
                        i14 = i18222;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            str3 = str;
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            textStyle2 = textStyle;
            if ((i2 & 458752) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            int i1722 = i5;
            if ((i5 & 23967451) != 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        str3 = str;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        if ((i2 & 458752) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        int i17222 = i5;
        if ((i5 & 23967451) != 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
