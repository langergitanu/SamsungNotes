package androidx.glance.appwidget.translators;

import android.graphics.Color;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BitmapImageProvider;
import androidx.glance.ColorFilterParams;
import androidx.glance.EmittableImage;
import androidx.glance.GlanceModifier;
import androidx.glance.IconImageProvider;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.TintColorFilterParams;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TintAndAlphaColorFilterParams;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.UriImageProvider;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.Dimension;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a \u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "applyColorFilter", "", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "rv", "Landroid/widget/RemoteViews;", "colorFilterParams", "Landroidx/glance/ColorFilterParams;", "viewDef", "Landroidx/glance/appwidget/InsertedViewInfo;", "setImageViewIcon", "viewId", "", "provider", "Landroidx/glance/IconImageProvider;", "getLayoutSelector", "Landroidx/glance/appwidget/LayoutType;", "Landroidx/glance/EmittableImage;", "setImageViewColorFilter", "notNight", "Landroidx/compose/ui/graphics/Color;", "night", "setImageViewColorFilter-0YGnOg8", "(Landroid/widget/RemoteViews;IJJ)V", "translateEmittableImage", "element", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTranslator.kt\nandroidx/glance/appwidget/translators/ImageTranslatorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Utils.kt\nandroidx/glance/UtilsKt\n*L\n1#1,211:1\n1#2:212\n22#3,7:213\n22#3,7:220\n*S KotlinDebug\n*F\n+ 1 ImageTranslator.kt\nandroidx/glance/appwidget/translators/ImageTranslatorKt\n*L\n80#1:213,7\n81#1:220,7\n*E\n"})
public final class ImageTranslatorKt {

    @NotNull
    private static final String TAG = "GWT:ImageTranslator";

    public static final void applyColorFilter(@NotNull TranslationContext translationContext, @NotNull RemoteViews rv, @NotNull ColorFilterParams colorFilterParams, @NotNull InsertedViewInfo viewDef) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(colorFilterParams, "colorFilterParams");
        Intrinsics.checkNotNullParameter(viewDef, "viewDef");
        if (colorFilterParams instanceof TintColorFilterParams) {
            ColorProvider colorProvider = ((TintColorFilterParams) colorFilterParams).getColorProvider();
            if (Build.VERSION.SDK_INT >= 31) {
                ImageTranslatorApi31Impl.INSTANCE.applyTintColorFilter(translationContext, rv, colorProvider, viewDef.getMainViewId());
                return;
            } else {
                RemoteViewsCompat.setImageViewColorFilter(rv, viewDef.getMainViewId(), ColorKt.m18579toArgb8_81llA(colorProvider.mo21422getColorvNxB06k(translationContext.getContext())));
                return;
            }
        }
        if (!(colorFilterParams instanceof TintAndAlphaColorFilterParams)) {
            throw new IllegalArgumentException("An unsupported ColorFilter was used.");
        }
        if (Build.VERSION.SDK_INT > 30) {
            GlanceLog.INSTANCE.m2300e(TAG, "There is no use case yet to support this colorFilter in S+ versions.", new Throwable());
        } else {
            int iM18579toArgb8_81llA = ColorKt.m18579toArgb8_81llA(((TintAndAlphaColorFilterParams) colorFilterParams).getColorProvider().mo21422getColorvNxB06k(translationContext.getContext()));
            RemoteViewsCompat.setImageViewColorFilter(rv, viewDef.getMainViewId(), iM18579toArgb8_81llA);
            RemoteViewsCompat.setImageViewImageAlpha(rv, viewDef.getMainViewId(), Color.alpha(iM18579toArgb8_81llA));
        }
    }

    private static final LayoutType getLayoutSelector(EmittableImage emittableImage) {
        boolean zIsDecorative = ImageKt.isDecorative(emittableImage);
        int contentScale = emittableImage.getContentScale();
        ContentScale.Companion companion = ContentScale.INSTANCE;
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21465getCropAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageCropDecorative : LayoutType.ImageCrop;
        }
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21467getFitAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageFitDecorative : LayoutType.ImageFit;
        }
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21466getFillBoundsAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageFillBoundsDecorative : LayoutType.ImageFillBounds;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unsupported ContentScale user: " + ContentScale.m21463toStringimpl(emittableImage.getContentScale()));
        return LayoutType.ImageFit;
    }

    @RequiresApi(31)
    /* JADX INFO: renamed from: setImageViewColorFilter-0YGnOg8, reason: not valid java name */
    public static final void m21399setImageViewColorFilter0YGnOg8(@NotNull RemoteViews setImageViewColorFilter, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(setImageViewColorFilter, "$this$setImageViewColorFilter");
        RemoteViewsCompat.setImageViewColorFilter(setImageViewColorFilter, i, ColorKt.m18579toArgb8_81llA(j), ColorKt.m18579toArgb8_81llA(j2));
    }

    public static final void setImageViewIcon(@NotNull RemoteViews rv, int i, @NotNull IconImageProvider provider) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(provider, "provider");
        ImageTranslatorApi23Impl.INSTANCE.setImageViewIcon(rv, i, provider.getIcon());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void translateEmittableImage(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableImage element) {
        boolean z;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, getLayoutSelector(element), element.getModifier());
        ImageProvider provider = element.getProvider();
        if (provider instanceof AndroidResourceImageProvider) {
            remoteViews.setImageViewResource(insertedViewInfoInsertView.getMainViewId(), ((AndroidResourceImageProvider) provider).getResId());
        } else if (provider instanceof BitmapImageProvider) {
            remoteViews.setImageViewBitmap(insertedViewInfoInsertView.getMainViewId(), ((BitmapImageProvider) provider).getBitmap());
        } else if (provider instanceof UriImageProvider) {
            remoteViews.setImageViewUri(insertedViewInfoInsertView.getMainViewId(), ((UriImageProvider) provider).getUri());
        } else {
            if (!(provider instanceof IconImageProvider)) {
                throw new IllegalArgumentException("An unsupported ImageProvider type was used.");
            }
            setImageViewIcon(remoteViews, insertedViewInfoInsertView.getMainViewId(), (IconImageProvider) provider);
        }
        ColorFilterParams colorFilterParams = element.getColorFilterParams();
        if (colorFilterParams != null) {
            applyColorFilter(translationContext, remoteViews, colorFilterParams, insertedViewInfoInsertView);
        }
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
        if (ContentScale.m21461equalsimpl0(element.getContentScale(), ContentScale.INSTANCE.m21467getFitAe3V0ko())) {
            WidthModifier widthModifier = (WidthModifier) element.getModifier().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final WidthModifier invoke(@Nullable WidthModifier widthModifier2, @NotNull GlanceModifier.Element cur) {
                    Intrinsics.checkNotNullParameter(cur, "cur");
                    return cur instanceof WidthModifier ? cur : widthModifier2;
                }
            });
            Dimension width = widthModifier != null ? widthModifier.getWidth() : null;
            Dimension.Wrap wrap = Dimension.Wrap.INSTANCE;
            if (!Intrinsics.areEqual(width, wrap)) {
                HeightModifier heightModifier = (HeightModifier) element.getModifier().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.translators.ImageTranslatorKt$translateEmittableImage$$inlined$findModifier$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final HeightModifier invoke(@Nullable HeightModifier heightModifier2, @NotNull GlanceModifier.Element cur) {
                        Intrinsics.checkNotNullParameter(cur, "cur");
                        return cur instanceof HeightModifier ? cur : heightModifier2;
                    }
                });
                if (!Intrinsics.areEqual(heightModifier != null ? heightModifier.getHeight() : null, wrap)) {
                    z = false;
                }
            }
            z = true;
        }
        RemoteViewsCompat.setImageViewAdjustViewBounds(remoteViews, insertedViewInfoInsertView.getMainViewId(), z);
    }
}
