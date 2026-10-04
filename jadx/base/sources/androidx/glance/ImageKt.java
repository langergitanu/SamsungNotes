package androidx.glance;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.ContentScale;
import androidx.glance.semantics.SemanticsConfiguration;
import androidx.glance.semantics.SemanticsModifier;
import androidx.glance.semantics.SemanticsModifierKt;
import androidx.glance.semantics.SemanticsProperties;
import androidx.glance.semantics.SemanticsPropertiesKt;
import androidx.glance.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m13886d2 = {"Image", "", "provider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "modifier", "Landroidx/glance/GlanceModifier;", "contentScale", "Landroidx/glance/layout/ContentScale;", "colorFilter", "Landroidx/glance/ColorFilter;", "Image-GCr5PR4", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/GlanceModifier;ILandroidx/glance/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "ImageProvider", "bitmap", "Landroid/graphics/Bitmap;", "icon", "Landroid/graphics/drawable/Icon;", "resId", "", "isDecorative", "", "Landroidx/glance/EmittableImage;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.kt\nandroidx/glance/ImageKt\n+ 2 Utils.kt\nandroidx/glance/UtilsKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,173:1\n22#2,7:174\n1116#3,6:181\n33#4:187\n34#4:198\n251#5,10:188\n*S KotlinDebug\n*F\n+ 1 Image.kt\nandroidx/glance/ImageKt\n*L\n127#1:174,7\n156#1:181,6\n163#1:187\n163#1:198\n163#1:188,10\n*E\n"})
public final class ImageKt {
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Composable
    /* JADX INFO: renamed from: Image-GCr5PR4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21259ImageGCr5PR4(@NotNull final ImageProvider provider, @Nullable final String str, @Nullable GlanceModifier glanceModifier, int i, @Nullable ColorFilter colorFilter, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        ColorFilter colorFilter2;
        final GlanceModifier glanceModifier2;
        final int iM21467getFitAe3V0ko;
        GlanceModifier glanceModifierSemantics;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerStartRestartGroup = composer.startRestartGroup(491792371);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(provider) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(glanceModifier) ? 256 : 128;
        }
        int i7 = i4 & 8;
        if (i7 != 0) {
            i5 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        int i8 = i4 & 16;
        if (i8 == 0) {
            if ((57344 & i2) == 0) {
                colorFilter2 = colorFilter;
                i5 |= composerStartRestartGroup.changed(colorFilter2) ? 16384 : 8192;
            }
            if ((46811 & i5) == 9362 || !composerStartRestartGroup.getSkipping()) {
                glanceModifier2 = i6 == 0 ? GlanceModifier.INSTANCE : glanceModifier;
                iM21467getFitAe3V0ko = i7 == 0 ? ContentScale.INSTANCE.m21467getFitAe3V0ko() : i;
                if (i8 != 0) {
                    colorFilter2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(491792371, i5, -1, "androidx.glance.Image (Image.kt:153)");
                }
                if (str == null) {
                    composerStartRestartGroup.startReplaceableGroup(-569652509);
                    boolean zChanged = composerStartRestartGroup.changed(str);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.glance.ImageKt$Image$finalModifier$1$1
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
                    glanceModifierSemantics = SemanticsModifierKt.semantics(glanceModifier2, (Function1) objRememberedValue);
                } else {
                    glanceModifierSemantics = glanceModifier2;
                }
                ImageKt$Image$1 imageKt$Image$1 = ImageKt$Image$1.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(imageKt$Image$1));
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, provider, new Function2<EmittableImage, ImageProvider, Unit>() { // from class: androidx.glance.ImageKt$Image$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ImageProvider imageProvider) {
                        invoke2(emittableImage, imageProvider);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableImage set, @NotNull ImageProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setProvider(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifierSemantics, new Function2<EmittableImage, GlanceModifier, Unit>() { // from class: androidx.glance.ImageKt$Image$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, GlanceModifier glanceModifier3) {
                        invoke2(emittableImage, glanceModifier3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableImage set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, ContentScale.m21458boximpl(iM21467getFitAe3V0ko), new Function2<EmittableImage, ContentScale, Unit>() { // from class: androidx.glance.ImageKt$Image$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ContentScale contentScale) {
                        m21260invoke5YttGEI(emittableImage, contentScale.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-5YttGEI, reason: not valid java name */
                    public final void m21260invoke5YttGEI(@NotNull EmittableImage set, int i9) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21258setContentScaleHwT0Evw(i9);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorFilter2, new Function2<EmittableImage, ColorFilter, Unit>() { // from class: androidx.glance.ImageKt$Image$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ColorFilter colorFilter3) {
                        invoke2(emittableImage, colorFilter3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableImage set, @Nullable ColorFilter colorFilter3) {
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
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                glanceModifier2 = glanceModifier;
                iM21467getFitAe3V0ko = i;
            }
            final ColorFilter colorFilter3 = colorFilter2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.ImageKt$Image$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i9) {
                        ImageKt.m21259ImageGCr5PR4(provider, str, glanceModifier2, iM21467getFitAe3V0ko, colorFilter3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                    }
                });
                return;
            }
            return;
        }
        i5 |= 24576;
        colorFilter2 = colorFilter;
        if ((46811 & i5) == 9362) {
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (str == null) {
            }
            ImageKt$Image$1 imageKt$Image$12 = ImageKt$Image$1.INSTANCE;
            if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, provider, new Function2<EmittableImage, ImageProvider, Unit>() { // from class: androidx.glance.ImageKt$Image$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ImageProvider imageProvider) {
                    invoke2(emittableImage, imageProvider);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableImage set, @NotNull ImageProvider it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setProvider(it);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifierSemantics, new Function2<EmittableImage, GlanceModifier, Unit>() { // from class: androidx.glance.ImageKt$Image$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, GlanceModifier glanceModifier3) {
                    invoke2(emittableImage, glanceModifier3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableImage set, @NotNull GlanceModifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setModifier(it);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl2, ContentScale.m21458boximpl(iM21467getFitAe3V0ko), new Function2<EmittableImage, ContentScale, Unit>() { // from class: androidx.glance.ImageKt$Image$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ContentScale contentScale) {
                    m21260invoke5YttGEI(emittableImage, contentScale.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-5YttGEI, reason: not valid java name */
                public final void m21260invoke5YttGEI(@NotNull EmittableImage set, int i9) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.m21258setContentScaleHwT0Evw(i9);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl2, colorFilter2, new Function2<EmittableImage, ColorFilter, Unit>() { // from class: androidx.glance.ImageKt$Image$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableImage emittableImage, ColorFilter colorFilter32) {
                    invoke2(emittableImage, colorFilter32);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableImage set, @Nullable ColorFilter colorFilter32) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setColorFilterParams(colorFilter32 != null ? colorFilter32.getColorFilterParams() : null);
                }
            });
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        final ColorFilter colorFilter32 = colorFilter2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @NotNull
    public static final ImageProvider ImageProvider(@DrawableRes int i) {
        return new AndroidResourceImageProvider(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isDecorative(@NotNull EmittableImage emittableImage) {
        List list;
        Intrinsics.checkNotNullParameter(emittableImage, "<this>");
        String str = null;
        SemanticsModifier semanticsModifier = (SemanticsModifier) emittableImage.getModifier().foldIn(null, new Function2<SemanticsModifier, GlanceModifier.Element, SemanticsModifier>() { // from class: androidx.glance.ImageKt$isDecorative$$inlined$findModifier$1
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

    @NotNull
    public static final ImageProvider ImageProvider(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new BitmapImageProvider(bitmap);
    }

    @RequiresApi(23)
    @NotNull
    public static final ImageProvider ImageProvider(@NotNull Icon icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new IconImageProvider(icon);
    }
}
