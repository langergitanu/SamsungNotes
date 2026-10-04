package androidx.glance.text;

import androidx.annotation.StringRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
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
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m13886d2 = {Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "", "textResId", "", "modifier", "Landroidx/glance/GlanceModifier;", "style", "Landroidx/glance/text/TextStyle;", "maxLines", "maxFontScale", "", "(ILandroidx/glance/GlanceModifier;Landroidx/glance/text/TextStyle;IFLandroidx/compose/runtime/Composer;II)V", "text", "", "(Ljava/lang/String;Landroidx/glance/GlanceModifier;Landroidx/glance/text/TextStyle;IFLandroidx/compose/runtime/Composer;II)V", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Text.kt\nandroidx/glance/text/TextKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,115:1\n33#2:116\n34#2:133\n33#2:134\n34#2:157\n251#3,8:117\n259#3,2:131\n251#3,8:135\n259#3,2:155\n3737#4,6:125\n3737#4,6:143\n3737#4,6:149\n*S KotlinDebug\n*F\n+ 1 Text.kt\nandroidx/glance/text/TextKt\n*L\n49#1:116\n49#1:133\n74#1:134\n74#1:157\n49#1:117,8\n49#1:131,2\n74#1:135,8\n74#1:155,2\n55#1:125,6\n77#1:143,6\n80#1:149,6\n*E\n"})
public final class TextKt {

    /* JADX INFO: renamed from: androidx.glance.text.TextKt$Text$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C35281 extends FunctionReferenceImpl implements Function0<EmittableText> {
        public static final C35281 INSTANCE = new C35281();

        public C35281() {
            super(0, EmittableText.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableText invoke() {
            return new EmittableText();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.text.TextKt$Text$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C35304 extends FunctionReferenceImpl implements Function0<EmittableText> {
        public static final C35304 INSTANCE = new C35304();

        public C35304() {
            super(0, EmittableText.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableText invoke() {
            return new EmittableText();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0148  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Text(@NotNull final String text, @Nullable GlanceModifier glanceModifier, @Nullable TextStyle textStyle, int i, float f, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        float f4;
        final TextStyle defaultTextStyle;
        final int i6;
        Composer composerM18018constructorimpl;
        TextKt$Text$2$4 textKt$Text$2$4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-545802401);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= ((i4 & 4) == 0 && composerStartRestartGroup.changed(textStyle)) ? 256 : 128;
        }
        int i8 = i4 & 8;
        if (i8 != 0) {
            i5 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        int i9 = i4 & 16;
        if (i9 == 0) {
            if ((57344 & i2) == 0) {
                f4 = f;
                i5 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
            }
            if ((46811 & i5) == 9362 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        glanceModifier = GlanceModifier.INSTANCE;
                    }
                    if ((i4 & 4) == 0) {
                        defaultTextStyle = TextDefaults.INSTANCE.getDefaultTextStyle();
                        i5 &= -897;
                    } else {
                        defaultTextStyle = textStyle;
                    }
                    i6 = i8 == 0 ? Integer.MAX_VALUE : i;
                    if (i9 != 0) {
                        f4 = 0.0f;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                    }
                    defaultTextStyle = textStyle;
                    i6 = i;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-545802401, i5, -1, "androidx.glance.text.Text (Text.kt:47)");
                }
                C35281 c35281 = C35281.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(c35281));
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, text, new Function2<EmittableText, String, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, String str) {
                        invoke2(emittableText, str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setText(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableText, GlanceModifier, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, GlanceModifier glanceModifier2) {
                        invoke2(emittableText, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, defaultTextStyle, new Function2<EmittableText, TextStyle, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, TextStyle textStyle2) {
                        invoke2(emittableText, textStyle2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull TextStyle it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setStyle(it);
                    }
                });
                textKt$Text$2$4 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                        invoke(emittableText, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, int i10) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setMaxLines(i10);
                    }
                };
                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i6))) {
                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i6));
                    composerM18018constructorimpl.apply(Integer.valueOf(i6), textKt$Text$2$4);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f4 >= 0.0f ? f4 : 0.0f), new Function2<EmittableText, Float, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Float f5) {
                        invoke(emittableText, f5.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, float f5) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setMaxFontScale(f5);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                defaultTextStyle = textStyle;
                i6 = i;
            }
            final GlanceModifier glanceModifier2 = glanceModifier;
            final float f5 = f4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.text.TextKt.Text.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i10) {
                        TextKt.Text(text, glanceModifier2, defaultTextStyle, i6, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                    }
                });
                return;
            }
            return;
        }
        i5 |= 24576;
        f4 = f;
        if ((46811 & i5) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                }
                if ((i4 & 4) == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                C35281 c352812 = C35281.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, text, new Function2<EmittableText, String, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, String str) {
                        invoke2(emittableText, str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setText(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableText, GlanceModifier, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, GlanceModifier glanceModifier22) {
                        invoke2(emittableText, glanceModifier22);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, defaultTextStyle, new Function2<EmittableText, TextStyle, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, TextStyle textStyle2) {
                        invoke2(emittableText, textStyle2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull TextStyle it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setStyle(it);
                    }
                });
                textKt$Text$2$4 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                        invoke(emittableText, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, int i10) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setMaxLines(i10);
                    }
                };
                if (!composerM18018constructorimpl.getInserting()) {
                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i6));
                    composerM18018constructorimpl.apply(Integer.valueOf(i6), textKt$Text$2$4);
                    Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f4 >= 0.0f ? f4 : 0.0f), new Function2<EmittableText, Float, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Float f52) {
                            invoke(emittableText, f52.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull EmittableText set, float f52) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setMaxFontScale(f52);
                        }
                    });
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        }
        final GlanceModifier glanceModifier22 = glanceModifier;
        final float f52 = f4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014f  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Text(@StringRes final int i, @Nullable GlanceModifier glanceModifier, @Nullable TextStyle textStyle, int i2, float f, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        float f4;
        final TextStyle defaultTextStyle;
        final int i7;
        Composer composerM18018constructorimpl;
        TextKt$Text$5$1 textKt$Text$5$1;
        TextKt$Text$5$4 textKt$Text$5$4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2109474493);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i8 = i5 & 2;
        if (i8 != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i6 |= ((i5 & 4) == 0 && composerStartRestartGroup.changed(textStyle)) ? 256 : 128;
        }
        int i9 = i5 & 8;
        if (i9 != 0) {
            i6 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        int i10 = i5 & 16;
        if (i10 == 0) {
            if ((57344 & i4) == 0) {
                f4 = f;
                i6 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
            }
            if ((46811 & i6) != 9362 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                defaultTextStyle = textStyle;
                i7 = i2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i4 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        glanceModifier = GlanceModifier.INSTANCE;
                    }
                    if ((i5 & 4) == 0) {
                        defaultTextStyle = TextDefaults.INSTANCE.getDefaultTextStyle();
                        i6 &= -897;
                    } else {
                        defaultTextStyle = textStyle;
                    }
                    i7 = i9 == 0 ? Integer.MAX_VALUE : i2;
                    if (i10 != 0) {
                        f4 = 0.0f;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i5 & 4) != 0) {
                        i6 &= -897;
                    }
                    defaultTextStyle = textStyle;
                    i7 = i2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2109474493, i6, -1, "androidx.glance.text.Text (Text.kt:72)");
                }
                C35304 c35304 = C35304.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(c35304));
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                textKt$Text$5$1 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                        invoke(emittableText, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, int i11) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTextResId(i11);
                    }
                };
                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i))) {
                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i));
                    composerM18018constructorimpl.apply(Integer.valueOf(i), textKt$Text$5$1);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableText, GlanceModifier, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, GlanceModifier glanceModifier2) {
                        invoke2(emittableText, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, defaultTextStyle, new Function2<EmittableText, TextStyle, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, TextStyle textStyle2) {
                        invoke2(emittableText, textStyle2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableText set, @NotNull TextStyle it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setStyle(it);
                    }
                });
                textKt$Text$5$4 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                        invoke(emittableText, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, int i11) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setMaxLines(i11);
                    }
                };
                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i7))) {
                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i7));
                    composerM18018constructorimpl.apply(Integer.valueOf(i7), textKt$Text$5$4);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f4 >= 0.0f ? f4 : 0.0f), new Function2<EmittableText, Float, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Float f5) {
                        invoke(emittableText, f5.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, float f5) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setMaxFontScale(f5);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            final GlanceModifier glanceModifier2 = glanceModifier;
            final float f5 = f4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.text.TextKt.Text.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i11) {
                        TextKt.Text(i, glanceModifier2, defaultTextStyle, i7, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                    }
                });
                return;
            }
            return;
        }
        i6 |= 24576;
        f4 = f;
        if ((46811 & i6) != 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
                if (i8 != 0) {
                }
                if ((i5 & 4) == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                C35304 c353042 = C35304.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                textKt$Text$5$1 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                        invoke(emittableText, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableText set, int i11) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTextResId(i11);
                    }
                };
                if (!composerM18018constructorimpl.getInserting()) {
                    composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i));
                    composerM18018constructorimpl.apply(Integer.valueOf(i), textKt$Text$5$1);
                    Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableText, GlanceModifier, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, GlanceModifier glanceModifier22) {
                            invoke2(emittableText, glanceModifier22);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull EmittableText set, @NotNull GlanceModifier it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setModifier(it);
                        }
                    });
                    Updater.m18025setimpl(composerM18018constructorimpl, defaultTextStyle, new Function2<EmittableText, TextStyle, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, TextStyle textStyle2) {
                            invoke2(emittableText, textStyle2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull EmittableText set, @NotNull TextStyle it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setStyle(it);
                        }
                    });
                    textKt$Text$5$4 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Integer num) {
                            invoke(emittableText, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull EmittableText set, int i11) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.setMaxLines(i11);
                        }
                    };
                    if (!composerM18018constructorimpl.getInserting()) {
                        composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i7));
                        composerM18018constructorimpl.apply(Integer.valueOf(i7), textKt$Text$5$4);
                        Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f4 >= 0.0f ? f4 : 0.0f), new Function2<EmittableText, Float, Unit>() { // from class: androidx.glance.text.TextKt$Text$5$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(EmittableText emittableText, Float f52) {
                                invoke(emittableText, f52.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull EmittableText set, float f52) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.setMaxFontScale(f52);
                            }
                        });
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            }
        }
        final GlanceModifier glanceModifier22 = glanceModifier;
        final float f52 = f4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
