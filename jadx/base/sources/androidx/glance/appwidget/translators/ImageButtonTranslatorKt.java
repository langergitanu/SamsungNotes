package androidx.glance.appwidget.translators;

import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BitmapImageProvider;
import androidx.glance.ColorFilterParams;
import androidx.glance.GlanceModifier;
import androidx.glance.IconImageProvider;
import androidx.glance.ImageProvider;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableImageButton;
import androidx.glance.appwidget.ImageButtonKt;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.UriImageProvider;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.oneui.common.GlanceLog;
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
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "getLayoutSelector", "Landroidx/glance/appwidget/LayoutType;", "Landroidx/glance/appwidget/EmittableImageButton;", "translateEmittableImageButton", "", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "element", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageButtonTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButtonTranslator.kt\nandroidx/glance/appwidget/translators/ImageButtonTranslatorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Utils.kt\nandroidx/glance/UtilsKt\n*L\n1#1,102:1\n1#2:103\n22#3,7:104\n22#3,7:111\n*S KotlinDebug\n*F\n+ 1 ImageButtonTranslator.kt\nandroidx/glance/appwidget/translators/ImageButtonTranslatorKt\n*L\n66#1:104,7\n67#1:111,7\n*E\n"})
public final class ImageButtonTranslatorKt {

    @NotNull
    private static final String TAG = "GWT:ImgBtnTranslator";

    private static final LayoutType getLayoutSelector(EmittableImageButton emittableImageButton) {
        boolean zIsDecorative = ImageButtonKt.isDecorative(emittableImageButton);
        int contentScale = emittableImageButton.getContentScale();
        ContentScale.Companion companion = ContentScale.INSTANCE;
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21465getCropAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageButtonCropDecorative : LayoutType.ImageButtonCrop;
        }
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21467getFitAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageButtonFitDecorative : LayoutType.ImageButtonFit;
        }
        if (ContentScale.m21461equalsimpl0(contentScale, companion.m21466getFillBoundsAe3V0ko())) {
            return zIsDecorative ? LayoutType.ImageButtonFillBoundsDecorative : LayoutType.ImageButtonFillBounds;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unsupported ContentScale user: " + ContentScale.m21463toStringimpl(emittableImageButton.getContentScale()));
        return LayoutType.ImageButtonFit;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void translateEmittableImageButton(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableImageButton element) {
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
            ImageTranslatorKt.setImageViewIcon(remoteViews, insertedViewInfoInsertView.getMainViewId(), (IconImageProvider) provider);
        }
        ColorFilterParams colorFilterParams = element.getColorFilterParams();
        if (colorFilterParams != null) {
            ImageTranslatorKt.applyColorFilter(translationContext, remoteViews, colorFilterParams, insertedViewInfoInsertView);
        }
        ApplyModifiersKt.applyModifiers$default(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, null, 16, null);
        if (ContentScale.m21461equalsimpl0(element.getContentScale(), ContentScale.INSTANCE.m21467getFitAe3V0ko())) {
            WidthModifier widthModifier = (WidthModifier) element.getModifier().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.translators.ImageButtonTranslatorKt$translateEmittableImageButton$$inlined$findModifier$1
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
                HeightModifier heightModifier = (HeightModifier) element.getModifier().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.translators.ImageButtonTranslatorKt$translateEmittableImageButton$$inlined$findModifier$2
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
