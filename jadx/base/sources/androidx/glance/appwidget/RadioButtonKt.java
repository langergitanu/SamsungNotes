package androidx.glance.appwidget;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceModifier;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aa\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001am\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0015\u001a]\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0017\u001a\n\u0010\u0019\u001a\u00020\u0002*\u00020\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, m13886d2 = {"isSelectableGroup", "", "Landroidx/glance/GlanceModifier;", "(Landroidx/glance/GlanceModifier;)Z", "RadioButton", "", "checked", "onClick", "Lkotlin/Function0;", "modifier", "enabled", "text", "", "style", "Landroidx/glance/text/TextStyle;", "colors", "Landroidx/glance/appwidget/RadioButtonColors;", "maxLines", "", "(ZLkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLjava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/RadioButtonColors;ILandroidx/compose/runtime/Composer;II)V", "key", "(ZLkotlin/jvm/functions/Function0;Landroidx/glance/GlanceModifier;ZLjava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/RadioButtonColors;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/glance/action/Action;", "(ZLandroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZLjava/lang/String;Landroidx/glance/text/TextStyle;Landroidx/glance/appwidget/RadioButtonColors;ILandroidx/compose/runtime/Composer;II)V", "RadioButtonElement", "selectableGroup", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRadioButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadioButton.kt\nandroidx/glance/appwidget/RadioButtonKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,277:1\n33#2:278\n34#2:295\n251#3,8:279\n259#3,2:293\n3737#4,6:287\n*S KotlinDebug\n*F\n+ 1 RadioButton.kt\nandroidx/glance/appwidget/RadioButtonKt\n*L\n252#1:278\n252#1:295\n252#1:279,8\n252#1:293,2\n259#1:287,6\n*E\n"})
public final class RadioButtonKt {
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void RadioButton(final boolean z, @Nullable final Action action, @Nullable GlanceModifier glanceModifier, boolean z2, @Nullable String str, @Nullable TextStyle textStyle, @Nullable RadioButtonColors radioButtonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        final RadioButtonColors radioButtonColorsColors;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1703226720);
        GlanceModifier glanceModifier2 = (i4 & 4) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z3 = (i4 & 8) != 0 ? true : z2;
        final String str2 = (i4 & 16) != 0 ? "" : str;
        final TextStyle textStyle2 = (i4 & 32) != 0 ? null : textStyle;
        if ((i4 & 64) != 0) {
            i5 = i2 & (-3670017);
            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
        } else {
            radioButtonColorsColors = radioButtonColors;
            i5 = i2;
        }
        final int i6 = (i4 & 128) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703226720, i5, -1, "androidx.glance.appwidget.RadioButton (RadioButton.kt:96)");
        }
        RadioButtonElement(z, action, glanceModifier2, z3, str2, textStyle2, radioButtonColorsColors, i6, composerStartRestartGroup, (i5 & 14) | 64 | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final boolean z4 = z3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt.RadioButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    RadioButtonKt.RadioButton(z, action, glanceModifier3, z4, str2, textStyle2, radioButtonColorsColors, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void RadioButtonElement(final boolean z, final Action action, GlanceModifier glanceModifier, boolean z2, String str, TextStyle textStyle, RadioButtonColors radioButtonColors, int i, Composer composer, final int i2, final int i4) {
        final RadioButtonColors radioButtonColorsColors;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(354884190);
        if ((i4 & 4) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final boolean z3 = (i4 & 8) != 0 ? true : z2;
        final String str2 = (i4 & 16) != 0 ? "" : str;
        final TextStyle textStyle2 = (i4 & 32) != 0 ? null : textStyle;
        if ((i4 & 64) != 0) {
            i5 = i2 & (-3670017);
            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
        } else {
            radioButtonColorsColors = radioButtonColors;
            i5 = i2;
        }
        final int i6 = (i4 & 128) != 0 ? Integer.MAX_VALUE : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(354884190, i5, -1, "androidx.glance.appwidget.RadioButtonElement (RadioButton.kt:249)");
        }
        GlanceModifier glanceModifierClickable = (!z3 || action == null) ? glanceModifier2 : ActionKt.clickable(glanceModifier2, action);
        final Function0<EmittableRadioButton> function0 = new Function0<EmittableRadioButton>() { // from class: androidx.glance.appwidget.RadioButtonKt.RadioButtonElement.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final EmittableRadioButton invoke() {
                return new EmittableRadioButton(radioButtonColorsColors);
            }
        };
        if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new Function0<EmittableRadioButton>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$$inlined$GlanceNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableRadioButton, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final EmittableRadioButton invoke() {
                    return function0.invoke();
                }
            });
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, Boolean.valueOf(z), new Function2<EmittableRadioButton, Boolean, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, Boolean bool) {
                invoke(emittableRadioButton, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableRadioButton set, boolean z4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setChecked(z4);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierClickable, new Function2<EmittableRadioButton, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, GlanceModifier glanceModifier3) {
                invoke2(emittableRadioButton, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableRadioButton set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, Boolean.valueOf(z3), new Function2<EmittableRadioButton, Boolean, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, Boolean bool) {
                invoke(emittableRadioButton, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableRadioButton set, boolean z4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setEnabled(z4);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, str2, new Function2<EmittableRadioButton, String, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, String str3) {
                invoke2(emittableRadioButton, str3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableRadioButton set, @NotNull String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setText(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, textStyle2, new Function2<EmittableRadioButton, TextStyle, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, TextStyle textStyle3) {
                invoke2(emittableRadioButton, textStyle3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableRadioButton set, @Nullable TextStyle textStyle3) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStyle(textStyle3);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, radioButtonColorsColors, new Function2<EmittableRadioButton, RadioButtonColors, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, RadioButtonColors radioButtonColors2) {
                invoke2(emittableRadioButton, radioButtonColors2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableRadioButton set, @NotNull RadioButtonColors it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setColors(it);
            }
        });
        RadioButtonKt$RadioButtonElement$2$7 radioButtonKt$RadioButtonElement$2$7 = new Function2<EmittableRadioButton, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt$RadioButtonElement$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableRadioButton emittableRadioButton, Integer num) {
                invoke(emittableRadioButton, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableRadioButton set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setMaxLines(i7);
            }
        };
        if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i6))) {
            composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i6));
            composerM18018constructorimpl.apply(Integer.valueOf(i6), radioButtonKt$RadioButtonElement$2$7);
        }
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt.RadioButtonElement.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    RadioButtonKt.RadioButtonElement(z, action, glanceModifier2, z3, str2, textStyle2, radioButtonColorsColors, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    public static final boolean isSelectableGroup(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.RadioButtonKt.isSelectableGroup.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof SelectableGroupModifier);
            }
        });
    }

    @NotNull
    public static final GlanceModifier selectableGroup(@NotNull GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        return glanceModifier.then(SelectableGroupModifier.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z2, @Nullable String str, @Nullable TextStyle textStyle, @Nullable RadioButtonColors radioButtonColors, int i, @Nullable Composer composer, final int i2, final int i4) {
        boolean z3;
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z4;
        int i7;
        String str2;
        int i8;
        int i9;
        TextStyle textStyle2;
        int i10;
        RadioButtonColors radioButtonColorsColors;
        int i11;
        int i12;
        int i13;
        GlanceModifier glanceModifier3;
        int i14;
        RadioButtonColors radioButtonColors2;
        String str3;
        int i15;
        boolean z5;
        int i16;
        int i17;
        Composer composer2;
        final GlanceModifier glanceModifier4;
        final boolean z6;
        final String str4;
        final TextStyle textStyle3;
        final RadioButtonColors radioButtonColors3;
        final int i18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-641571976);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i2 & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i19 = i4 & 4;
        if (i19 != 0) {
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
                    z4 = z2;
                    i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 57344) == 0) {
                        str2 = str;
                        i5 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                        i9 = 57344;
                        textStyle2 = textStyle;
                    } else {
                        i9 = 57344;
                        textStyle2 = textStyle;
                        if ((i2 & 458752) == 0) {
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i4 & 64) == 0) {
                            i10 = 458752;
                            radioButtonColorsColors = radioButtonColors;
                            int i20 = composerStartRestartGroup.changed(radioButtonColorsColors) ? 1048576 : 524288;
                            i5 |= i20;
                        } else {
                            i10 = 458752;
                            radioButtonColorsColors = radioButtonColors;
                        }
                        i5 |= i20;
                    } else {
                        i10 = 458752;
                        radioButtonColorsColors = radioButtonColors;
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                        if ((i2 & 29360128) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
                        }
                        i13 = i5;
                        if ((i5 & 23967451) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            i18 = i;
                            composer2 = composerStartRestartGroup;
                            glanceModifier4 = glanceModifier2;
                            z6 = z4;
                            textStyle3 = textStyle2;
                            str4 = str2;
                            radioButtonColors3 = radioButtonColorsColors;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 64) != 0) {
                                    i17 = i13 & (-3670017);
                                    String str5 = str2;
                                    glanceModifier3 = glanceModifier2;
                                    i14 = i10;
                                    radioButtonColors2 = radioButtonColorsColors;
                                    str3 = str5;
                                    i15 = i;
                                    z5 = z4;
                                    i16 = 3670016;
                                    TextStyle textStyle4 = textStyle2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer2 = composerStartRestartGroup;
                                    RadioButtonElement(z3, LambdaActionKt.action(null, onClick, composerStartRestartGroup, i17 & 112, 1), glanceModifier3, z5, str3, textStyle4, radioButtonColors2, i15, composer2, (i17 & 14) | 64 | (i17 & 896) | (i17 & 7168) | (i17 & i9) | (i14 & i17) | (i16 & i17) | (i17 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    glanceModifier4 = glanceModifier3;
                                    z6 = z5;
                                    str4 = str3;
                                    textStyle3 = textStyle4;
                                    radioButtonColors3 = radioButtonColors2;
                                    i18 = i15;
                                }
                            } else {
                                if (i19 != 0) {
                                    glanceModifier2 = GlanceModifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    z4 = true;
                                }
                                if (i7 != 0) {
                                    str2 = "";
                                }
                                if (i8 != 0) {
                                    textStyle2 = null;
                                }
                                if ((i4 & 64) != 0) {
                                    radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i13 &= -3670017;
                                }
                                if (i12 == 0) {
                                    String str6 = str2;
                                    glanceModifier3 = glanceModifier2;
                                    i14 = i10;
                                    radioButtonColors2 = radioButtonColorsColors;
                                    str3 = str6;
                                    i15 = Integer.MAX_VALUE;
                                }
                                z5 = z4;
                                i16 = 3670016;
                                i17 = i13;
                                TextStyle textStyle42 = textStyle2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-641571976, i17, -1, "androidx.glance.appwidget.RadioButton (RadioButton.kt:125)");
                                }
                                composer2 = composerStartRestartGroup;
                                RadioButtonElement(z3, LambdaActionKt.action(null, onClick, composerStartRestartGroup, i17 & 112, 1), glanceModifier3, z5, str3, textStyle42, radioButtonColors2, i15, composer2, (i17 & 14) | 64 | (i17 & 896) | (i17 & 7168) | (i17 & i9) | (i14 & i17) | (i16 & i17) | (i17 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                glanceModifier4 = glanceModifier3;
                                z6 = z5;
                                str4 = str3;
                                textStyle3 = textStyle42;
                                radioButtonColors3 = radioButtonColors2;
                                i18 = i15;
                            }
                            String str7 = str2;
                            glanceModifier3 = glanceModifier2;
                            i14 = i10;
                            radioButtonColors2 = radioButtonColorsColors;
                            str3 = str7;
                            i15 = i;
                            z5 = z4;
                            i16 = 3670016;
                            i17 = i13;
                            TextStyle textStyle422 = textStyle2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            RadioButtonElement(z3, LambdaActionKt.action(null, onClick, composerStartRestartGroup, i17 & 112, 1), glanceModifier3, z5, str3, textStyle422, radioButtonColors2, i15, composer2, (i17 & 14) | 64 | (i17 & 896) | (i17 & 7168) | (i17 & i9) | (i14 & i17) | (i16 & i17) | (i17 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            glanceModifier4 = glanceModifier3;
                            z6 = z5;
                            str4 = str3;
                            textStyle3 = textStyle422;
                            radioButtonColors3 = radioButtonColors2;
                            i18 = i15;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt.RadioButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@Nullable Composer composer3, int i21) {
                                    RadioButtonKt.RadioButton(z, onClick, glanceModifier4, z6, str4, textStyle3, radioButtonColors3, i18, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 12582912;
                    i12 = i11;
                    i13 = i5;
                    if ((i5 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0) {
                            if (i19 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if ((i4 & 64) != 0) {
                            }
                            if (i12 == 0) {
                                String str72 = str2;
                                glanceModifier3 = glanceModifier2;
                                i14 = i10;
                                radioButtonColors2 = radioButtonColorsColors;
                                str3 = str72;
                                i15 = i;
                            }
                            z5 = z4;
                            i16 = 3670016;
                            i17 = i13;
                            TextStyle textStyle4222 = textStyle2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            RadioButtonElement(z3, LambdaActionKt.action(null, onClick, composerStartRestartGroup, i17 & 112, 1), glanceModifier3, z5, str3, textStyle4222, radioButtonColors2, i15, composer2, (i17 & 14) | 64 | (i17 & 896) | (i17 & 7168) | (i17 & i9) | (i14 & i17) | (i16 & i17) | (i17 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            glanceModifier4 = glanceModifier3;
                            z6 = z5;
                            str4 = str3;
                            textStyle3 = textStyle4222;
                            radioButtonColors3 = radioButtonColors2;
                            i18 = i15;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                str2 = str;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                if ((i2 & 3670016) != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i5;
                if ((i5 & 23967451) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            str2 = str;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            if ((i2 & 3670016) != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i5;
            if ((i5 & 23967451) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z4 = z2;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        str2 = str;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        if ((i2 & 3670016) != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i5;
        if ((i5 & 23967451) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0113  */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    @ExperimentalGlanceApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable GlanceModifier glanceModifier, boolean z2, @Nullable String str, @Nullable TextStyle textStyle, @Nullable RadioButtonColors radioButtonColors, int i, @Nullable String str2, @Nullable Composer composer, final int i2, final int i4) {
        boolean z3;
        int i5;
        GlanceModifier glanceModifier2;
        int i6;
        boolean z4;
        int i7;
        String str3;
        int i8;
        int i9;
        TextStyle textStyle2;
        int i10;
        RadioButtonColors radioButtonColors2;
        int i11;
        int i12;
        int i13;
        int i14;
        RadioButtonColors radioButtonColorsColors;
        int i15;
        String str4;
        RadioButtonColors radioButtonColors3;
        GlanceModifier glanceModifier3;
        boolean z5;
        int i16;
        int i17;
        int i18;
        int i19;
        String str5;
        int i20;
        TextStyle textStyle3;
        Composer composer2;
        final String str6;
        final GlanceModifier glanceModifier4;
        final boolean z6;
        final String str7;
        final TextStyle textStyle4;
        final RadioButtonColors radioButtonColors4;
        final int i21;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1720778013);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i2 & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i22 = i4 & 4;
        if (i22 != 0) {
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
                    z4 = z2;
                    i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 57344) == 0) {
                        str3 = str;
                        i5 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                        i9 = 57344;
                        textStyle2 = textStyle;
                    } else {
                        i9 = 57344;
                        textStyle2 = textStyle;
                        if ((i2 & 458752) == 0) {
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    if ((i2 & 3670016) != 0) {
                        if ((i4 & 64) == 0) {
                            i10 = 458752;
                            radioButtonColors2 = radioButtonColors;
                            int i23 = composerStartRestartGroup.changed(radioButtonColors2) ? 1048576 : 524288;
                            i5 |= i23;
                        } else {
                            i10 = 458752;
                            radioButtonColors2 = radioButtonColors;
                        }
                        i5 |= i23;
                    } else {
                        i10 = 458752;
                        radioButtonColors2 = radioButtonColors;
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                        i5 |= 12582912;
                    } else {
                        if ((i2 & 29360128) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
                        }
                        i13 = i4 & 256;
                        if (i13 == 0) {
                            if ((i2 & 234881024) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(str2) ? 67108864 : 33554432;
                            }
                            int i24 = i5;
                            if ((i5 & 191739611) != 38347922 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                i21 = i;
                                composer2 = composerStartRestartGroup;
                                glanceModifier4 = glanceModifier2;
                                z6 = z4;
                                textStyle4 = textStyle2;
                                str7 = str3;
                                radioButtonColors4 = radioButtonColors2;
                                str6 = str2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i22 != 0) {
                                        glanceModifier2 = GlanceModifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z4 = true;
                                    }
                                    if (i7 != 0) {
                                        str3 = "";
                                    }
                                    if (i8 != 0) {
                                        textStyle2 = null;
                                    }
                                    if ((i4 & 64) == 0) {
                                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i15 = i24 & (-3670017);
                                    } else {
                                        radioButtonColorsColors = radioButtonColors2;
                                        i15 = i24;
                                    }
                                    int i25 = i12 == 0 ? Integer.MAX_VALUE : i;
                                    str4 = i14 == 0 ? str2 : null;
                                    radioButtonColors3 = radioButtonColorsColors;
                                    glanceModifier3 = glanceModifier2;
                                    z5 = z4;
                                    i16 = 3670016;
                                    i17 = 29360128;
                                    i18 = 1720778013;
                                    i19 = i25;
                                    str5 = str3;
                                    i20 = i10;
                                    textStyle3 = textStyle2;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 64) != 0) {
                                        i15 = i24 & (-3670017);
                                        str4 = str2;
                                        glanceModifier3 = glanceModifier2;
                                        radioButtonColors3 = radioButtonColors2;
                                        i16 = 3670016;
                                        i20 = i10;
                                        i17 = 29360128;
                                    } else {
                                        str4 = str2;
                                        glanceModifier3 = glanceModifier2;
                                        radioButtonColors3 = radioButtonColors2;
                                        i16 = 3670016;
                                        i20 = i10;
                                        i17 = 29360128;
                                        i15 = i24;
                                    }
                                    i19 = i;
                                    z5 = z4;
                                    textStyle3 = textStyle2;
                                    str5 = str3;
                                    i18 = 1720778013;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i18, i15, -1, "androidx.glance.appwidget.RadioButton (RadioButton.kt:169)");
                                }
                                composer2 = composerStartRestartGroup;
                                RadioButtonElement(z3, LambdaActionKt.action(str4, onClick, composerStartRestartGroup, ((i15 >> 24) & 14) | (i15 & 112), 0), glanceModifier3, z5, str5, textStyle3, radioButtonColors3, i19, composer2, (i16 & i15) | (i20 & i15) | (i15 & 14) | 64 | (i15 & 896) | (i15 & 7168) | (i15 & i9) | (i15 & i17), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str6 = str4;
                                glanceModifier4 = glanceModifier3;
                                z6 = z5;
                                str7 = str5;
                                textStyle4 = textStyle3;
                                radioButtonColors4 = radioButtonColors3;
                                i21 = i19;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.RadioButtonKt.RadioButton.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@Nullable Composer composer3, int i26) {
                                        RadioButtonKt.RadioButton(z, onClick, glanceModifier4, z6, str7, textStyle4, radioButtonColors4, i21, str6, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 100663296;
                        i14 = i13;
                        int i242 = i5;
                        if ((i5 & 191739611) != 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i22 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if ((i4 & 64) == 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i14 == 0) {
                                }
                                radioButtonColors3 = radioButtonColorsColors;
                                glanceModifier3 = glanceModifier2;
                                z5 = z4;
                                i16 = 3670016;
                                i17 = 29360128;
                                i18 = 1720778013;
                                i19 = i25;
                                str5 = str3;
                                i20 = i10;
                                textStyle3 = textStyle2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composer2 = composerStartRestartGroup;
                                RadioButtonElement(z3, LambdaActionKt.action(str4, onClick, composerStartRestartGroup, ((i15 >> 24) & 14) | (i15 & 112), 0), glanceModifier3, z5, str5, textStyle3, radioButtonColors3, i19, composer2, (i16 & i15) | (i20 & i15) | (i15 & 14) | 64 | (i15 & 896) | (i15 & 7168) | (i15 & i9) | (i15 & i17), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                str6 = str4;
                                glanceModifier4 = glanceModifier3;
                                z6 = z5;
                                str7 = str5;
                                textStyle4 = textStyle3;
                                radioButtonColors4 = radioButtonColors3;
                                i21 = i19;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 256;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    int i2422 = i5;
                    if ((i5 & 191739611) != 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                str3 = str;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                if ((i2 & 3670016) != 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 256;
                if (i13 == 0) {
                }
                i14 = i13;
                int i24222 = i5;
                if ((i5 & 191739611) != 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            str3 = str;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            if ((i2 & 3670016) != 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 256;
            if (i13 == 0) {
            }
            i14 = i13;
            int i242222 = i5;
            if ((i5 & 191739611) != 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        glanceModifier2 = glanceModifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z4 = z2;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        str3 = str;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        if ((i2 & 3670016) != 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 256;
        if (i13 == 0) {
        }
        i14 = i13;
        int i2422222 = i5;
        if ((i5 & 191739611) != 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
