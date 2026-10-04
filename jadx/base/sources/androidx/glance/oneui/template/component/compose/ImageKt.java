package androidx.glance.oneui.template.component.compose;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DimenRes;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.core.content.ContextCompat;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BitmapImageProvider;
import androidx.glance.IconImageProvider;
import androidx.glance.ImageProvider;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
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
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0014\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00132\b\b\u0001\u0010\r\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0015\u001aA\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"ComposeImage", "", "data", "Landroidx/glance/oneui/template/ImageData;", "modifier", "Landroidx/compose/ui/Modifier;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "hasCornerRadius", "", "(Landroidx/glance/oneui/template/ImageData;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/ContentScale;ZLandroidx/compose/runtime/Composer;II)V", "width", "Landroidx/compose/ui/unit/Dp;", "height", "ComposeImage-WMci_g0", "(Landroidx/glance/oneui/template/ImageData;FFZLandroidx/compose/runtime/Composer;I)V", "size", "ComposeImage-rAjV9yQ", "(Landroidx/glance/oneui/template/ImageData;FZLandroidx/compose/runtime/Composer;I)V", "", "(Landroidx/glance/oneui/template/ImageData;IZLandroidx/compose/runtime/Composer;I)V", "(Landroidx/glance/oneui/template/ImageData;IIZLandroidx/compose/runtime/Composer;I)V", Constants.ARG_UPDATE, "Landroid/widget/ImageView;", "drawable", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", "tintColor", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/Integer;Z)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/compose/ImageKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n154#2:186\n154#2:187\n74#3:188\n74#3:189\n1#4:190\n*S KotlinDebug\n*F\n+ 1 Image.kt\nandroidx/glance/oneui/template/component/compose/ImageKt\n*L\n37#1:186\n50#1:187\n105#1:188\n109#1:189\n*E\n"})
public final class ImageKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeImage(@NotNull final ImageData data, @DimenRes final int i, final boolean z, @Nullable Composer composer, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1103541558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1103541558, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeImage (Image.kt:59)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1172669339);
        Modifier modifierFillMaxSize$default = i == 0 ? SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null) : SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, PrimitiveResources_androidKt.dimensionResource(i, composerStartRestartGroup, (i2 >> 3) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        ComposeImage(data, modifierFillMaxSize$default, null, z, composerStartRestartGroup, ((i2 << 3) & 7168) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    ImageKt.ComposeImage(data, i, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeImage-WMci_g0, reason: not valid java name */
    public static final void m21720ComposeImageWMci_g0(@NotNull final ImageData data, final float f, final float f4, final boolean z, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(506051751);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(506051751, i, -1, "androidx.glance.oneui.template.component.compose.ComposeImage (Image.kt:46)");
        }
        float f5 = 0;
        ComposeImage(data, (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(f5)) <= 0 || C2256Dp.m20967compareTo0680j_4(f4, C2256Dp.m20968constructorimpl(f5)) <= 0) ? SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null) : SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, f), f4), null, z, composerStartRestartGroup, (i & 7168) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ImageKt.m21720ComposeImageWMci_g0(data, f, f4, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeImage-rAjV9yQ, reason: not valid java name */
    public static final void m21721ComposeImagerAjV9yQ(@NotNull final ImageData data, final float f, final boolean z, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1793934231);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1793934231, i, -1, "androidx.glance.oneui.template.component.compose.ComposeImage (Image.kt:33)");
        }
        ComposeImage(data, C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl((float) 0)) <= 0 ? SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null) : SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, f), null, z, composerStartRestartGroup, ((i << 3) & 7168) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ImageKt.m21721ComposeImagerAjV9yQ(data, f, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update(ImageView imageView, Drawable drawable, String str, ContentScale contentScale, Integer num, boolean z) {
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(str);
            ContentScale.Companion companion = ContentScale.INSTANCE;
            imageView.setScaleType(Intrinsics.areEqual(contentScale, companion.getFit()) ? ImageView.ScaleType.FIT_CENTER : Intrinsics.areEqual(contentScale, companion.getFillBounds()) ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.CENTER_CROP);
            imageView.setScaleType(imageView.getScaleType());
            CircleOutlineProvider circleOutlineProvider = null;
            imageView.setImageTintList(num != null ? ColorStateList.valueOf(num.intValue()) : null);
            if (num != null) {
                imageView.setColorFilter(num.intValue());
            }
            if (z) {
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                circleOutlineProvider = new CircleOutlineProvider(context);
            }
            imageView.setOutlineProvider(circleOutlineProvider);
            imageView.setClipToOutline(z);
        }
    }

    public static /* synthetic */ void update$default(ImageView imageView, Drawable drawable, String str, ContentScale contentScale, Integer num, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        update(imageView, drawable, str, contentScale, num, z);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeImage(@NotNull final ImageData data, @DimenRes final int i, @DimenRes final int i2, final boolean z, @Nullable Composer composer, final int i4) {
        Modifier modifierFillMaxSize$default;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1521800851);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1521800851, i4, -1, "androidx.glance.oneui.template.component.compose.ComposeImage (Image.kt:77)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1172668969);
        if (i != 0 && i2 != 0) {
            modifierFillMaxSize$default = SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, PrimitiveResources_androidKt.dimensionResource(i, composerStartRestartGroup, (i4 >> 3) & 14)), PrimitiveResources_androidKt.dimensionResource(i2, composerStartRestartGroup, (i4 >> 6) & 14));
        } else {
            modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        }
        Modifier modifier = modifierFillMaxSize$default;
        composerStartRestartGroup.endReplaceableGroup();
        ComposeImage(data, modifier, null, z, composerStartRestartGroup, (i4 & 7168) | 8, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    ImageKt.ComposeImage(data, i, i2, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeImage(@NotNull final ImageData data, @NotNull final Modifier modifier, @Nullable ContentScale contentScale, final boolean z, @Nullable Composer composer, int i, final int i2) {
        int i4;
        final ContentScale contentScale2;
        int i5;
        Drawable bitmapDrawable;
        ContentScale contentScale3;
        Composer composer2;
        ContentScale crop;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1193463807);
        if ((i2 & 4) != 0) {
            if (data.getImageType() == ImageType.Icon) {
                crop = ContentScale.INSTANCE.getFit();
            } else {
                crop = ContentScale.INSTANCE.getCrop();
            }
            i4 = i;
            i5 = i4 & (-897);
            contentScale2 = crop;
        } else {
            i4 = i;
            contentScale2 = contentScale;
            i5 = i4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1193463807, i5, -1, "androidx.glance.oneui.template.component.compose.ComposeImage (Image.kt:100)");
        }
        ImageProvider imageProvider = data.getImageProvider();
        if (imageProvider instanceof AndroidResourceImageProvider) {
            composerStartRestartGroup.startReplaceableGroup(-1172668300);
            bitmapDrawable = ContextCompat.getDrawable((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), ((AndroidResourceImageProvider) data.getImageProvider()).getResId());
            composerStartRestartGroup.endReplaceableGroup();
        } else if (imageProvider instanceof IconImageProvider) {
            composerStartRestartGroup.startReplaceableGroup(-1172668158);
            bitmapDrawable = Build.VERSION.SDK_INT >= 28 ? ((IconImageProvider) data.getImageProvider()).getIcon().loadDrawable((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())) : null;
            composerStartRestartGroup.endReplaceableGroup();
        } else if (imageProvider instanceof BitmapImageProvider) {
            composerStartRestartGroup.startReplaceableGroup(-1172667927);
            composerStartRestartGroup.endReplaceableGroup();
            bitmapDrawable = new BitmapDrawable(((BitmapImageProvider) data.getImageProvider()).getBitmap());
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1992964454);
            composerStartRestartGroup.endReplaceableGroup();
            bitmapDrawable = null;
        }
        ColorProvider imageTintColor = data.getImageTintColor();
        composerStartRestartGroup.startReplaceableGroup(-1172667777);
        final Integer numValueOf = imageTintColor != null ? Integer.valueOf(ColorKt.m18579toArgb8_81llA(ComposeUtilsKt.convert(imageTintColor, composerStartRestartGroup, 8))) : null;
        composerStartRestartGroup.endReplaceableGroup();
        if (bitmapDrawable != null) {
            final Drawable drawable = bitmapDrawable;
            contentScale3 = contentScale2;
            composer2 = composerStartRestartGroup;
            AndroidView_androidKt.AndroidView(new Function1<Context, ImageView>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final ImageView invoke(@NotNull Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    ImageView imageView = new ImageView(context);
                    ImageData imageData = data;
                    ImageKt.update(imageView, imageView.getDrawable(), imageData.getContentDescription(), contentScale2, numValueOf, z);
                    return imageView;
                }
            }, modifier, new Function1<ImageView, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                    invoke2(imageView);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ImageView view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    ImageKt.update(view, drawable, data.getContentDescription(), contentScale2, numValueOf, z);
                }
            }, composer2, i5 & 112, 0);
        } else {
            contentScale3 = contentScale2;
            composer2 = composerStartRestartGroup;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ContentScale contentScale4 = contentScale3;
            final int i6 = i4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ImageKt.ComposeImage.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i7) {
                    ImageKt.ComposeImage(data, modifier, contentScale4, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i2);
                }
            });
        }
    }
}
