package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.semantics.SemanticsConfiguration;
import androidx.glance.semantics.SemanticsModifier;
import androidx.glance.semantics.SemanticsModifierKt;
import androidx.glance.semantics.SemanticsProperties;
import androidx.glance.semantics.SemanticsPropertiesKt;
import androidx.glance.semantics.SemanticsPropertyReceiver;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u000b*\u00020\u0013H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m13886d2 = {"ImageButton", "", "provider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "onClick", "Landroidx/glance/action/Action;", "modifier", "Landroidx/glance/GlanceModifier;", "enabled", "", "contentScale", "Landroidx/glance/layout/ContentScale;", "colorFilter", "Landroidx/glance/ColorFilter;", "ImageButton-aCxP0qg", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/action/Action;Landroidx/glance/GlanceModifier;ZILandroidx/glance/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "isDecorative", "Landroidx/glance/appwidget/EmittableImageButton;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButton.kt\nandroidx/glance/appwidget/ImageButtonKt\n+ 2 Utils.kt\nandroidx/glance/UtilsKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,93:1\n22#2,7:94\n1116#3,6:101\n33#4:107\n34#4:118\n251#5,10:108\n*S KotlinDebug\n*F\n+ 1 ImageButton.kt\nandroidx/glance/appwidget/ImageButtonKt\n*L\n42#1:94,7\n78#1:101,6\n83#1:107\n83#1:118\n83#1:108,10\n*E\n"})
public final class ImageButtonKt {
    @Composable
    /* JADX INFO: renamed from: ImageButton-aCxP0qg, reason: not valid java name */
    public static final void m21297ImageButtonaCxP0qg(@NotNull final ImageProvider provider, @Nullable final String str, @Nullable Action action, @Nullable GlanceModifier glanceModifier, boolean z, int i, @Nullable ColorFilter colorFilter, @Nullable Composer composer, final int i2, final int i4) {
        int iM21467getFitAe3V0ko;
        int i5;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerStartRestartGroup = composer.startRestartGroup(-358424584);
        Action action2 = (i4 & 4) != 0 ? null : action;
        GlanceModifier glanceModifier2 = (i4 & 8) != 0 ? GlanceModifier.INSTANCE : glanceModifier;
        boolean z2 = (i4 & 16) != 0 ? true : z;
        if ((i4 & 32) != 0) {
            iM21467getFitAe3V0ko = androidx.glance.layout.ContentScale.INSTANCE.m21467getFitAe3V0ko();
            i5 = i2 & (-458753);
        } else {
            iM21467getFitAe3V0ko = i;
            i5 = i2;
        }
        ColorFilter colorFilter2 = (i4 & 64) == 0 ? colorFilter : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-358424584, i5, -1, "androidx.glance.appwidget.ImageButton (ImageButton.kt:70)");
        }
        GlanceModifier glanceModifierEnabled = (!z2 || action2 == null) ? AppWidgetModifiersKt.enabled(glanceModifier2, false) : AppWidgetModifiersKt.enabled(ActionKt.clickable(glanceModifier2, action2), true);
        if (str != null) {
            composerStartRestartGroup.startReplaceableGroup(546403824);
            boolean zChanged = composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$1$1
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
                        SemanticsPropertiesKt.setContentDescription(semantics, str);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            glanceModifierEnabled = SemanticsModifierKt.semantics(glanceModifierEnabled, (Function1) objRememberedValue);
        }
        final ImageButtonKt$ImageButton$2 imageButtonKt$ImageButton$2 = ImageButtonKt$ImageButton$2.INSTANCE;
        if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new Function0<EmittableImageButton>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton-aCxP0qg$$inlined$GlanceNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableImageButton, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final EmittableImageButton invoke() {
                    return imageButtonKt$ImageButton$2.invoke();
                }
            });
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, provider, new Function2<EmittableImageButton, ImageProvider, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$3$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableImageButton emittableImageButton, ImageProvider imageProvider) {
                invoke2(emittableImageButton, imageProvider);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableImageButton set, @NotNull ImageProvider it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setProvider(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierEnabled, new Function2<EmittableImageButton, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$3$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableImageButton emittableImageButton, GlanceModifier glanceModifier3) {
                invoke2(emittableImageButton, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableImageButton set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, androidx.glance.layout.ContentScale.m21458boximpl(iM21467getFitAe3V0ko), new Function2<EmittableImageButton, androidx.glance.layout.ContentScale, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$3$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableImageButton emittableImageButton, androidx.glance.layout.ContentScale contentScale) {
                m21298invoke5YttGEI(emittableImageButton, contentScale.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-5YttGEI, reason: not valid java name */
            public final void m21298invoke5YttGEI(@NotNull EmittableImageButton set, int i6) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m21258setContentScaleHwT0Evw(i6);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, colorFilter2, new Function2<EmittableImageButton, ColorFilter, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$3$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableImageButton emittableImageButton, ColorFilter colorFilter3) {
                invoke2(emittableImageButton, colorFilter3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableImageButton set, @Nullable ColorFilter colorFilter3) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setColorFilterParams(colorFilter3 != null ? colorFilter3.getColorFilterParams() : null);
            }
        });
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            final ColorFilter colorFilter3 = colorFilter2;
            final Action action3 = action2;
            final GlanceModifier glanceModifier3 = glanceModifier2;
            final int i6 = iM21467getFitAe3V0ko;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.ImageButtonKt$ImageButton$4
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
                    ImageButtonKt.m21297ImageButtonaCxP0qg(provider, str, action3, glanceModifier3, z3, i6, colorFilter3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isDecorative(@NotNull EmittableImageButton emittableImageButton) {
        List list;
        Intrinsics.checkNotNullParameter(emittableImageButton, "<this>");
        String str = null;
        SemanticsModifier semanticsModifier = (SemanticsModifier) emittableImageButton.getModifier().foldIn(null, new Function2<SemanticsModifier, GlanceModifier.Element, SemanticsModifier>() { // from class: androidx.glance.appwidget.ImageButtonKt$isDecorative$$inlined$findModifier$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final SemanticsModifier invoke(@Nullable SemanticsModifier semanticsModifier2, @NotNull GlanceModifier.Element cur) {
                Intrinsics.checkNotNullParameter(cur, "cur");
                return cur instanceof SemanticsModifier ? cur : semanticsModifier2;
            }
        });
        SemanticsConfiguration configuration = semanticsModifier != null ? semanticsModifier.getConfiguration() : null;
        if (configuration != null && (list = (List) configuration.getOrNull(SemanticsProperties.INSTANCE.getContentDescription())) != null) {
            str = (String) list.get(0);
        }
        return str == null || str.length() == 0;
    }
}
