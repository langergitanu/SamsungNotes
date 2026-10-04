package com.samsung.android.support.senl.p148nt.base.composer.common;

import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/common/ImageExtension;", "", "<init>", "()V", "IMAGE_TYPES", "", "", "getIMAGE_TYPES", "()Ljava/util/List;", "IMAGE_MIME_TYPES_NOT_EXTENSION", "getIMAGE_MIME_TYPES_NOT_EXTENSION", "isImageMimeType", "", "mimeType", "isImageType", BundleContract.EXTRA_DATA, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageExtension {

    @NotNull
    public static final ImageExtension INSTANCE = new ImageExtension();

    @NotNull
    private static final List<String> IMAGE_TYPES = CollectionsKt.mutableListOf(Constants.THUMBNAIL_PNG_EXTENSION, "jpg", "jpeg", Constants.THUMBNAIL_GIF_EXTENSION, "bmp", "wbmp", "heif", Constants.IMAGE_HEIC_EXTENSION, "webp", "nef", "dng", "cr2", "raf", "nef", "orf", "rw2", "pef", "srw", "arw", "avif");

    @NotNull
    private static final List<String> IMAGE_MIME_TYPES_NOT_EXTENSION = CollectionsKt.mutableListOf("image/x-ms-bmp", ImageUtil.MIME_TYPE_WBMP, "image/x-nikon-nef", "image/x-adobe-dng", "image/x-canon-cr2", "image/x-fuji-raf", "image/x-olympus-orf", "image/x-panasonic-rw2", "image/x-pentax-pef", "image/x-samsung-srw", "image/x-sony-arw");

    private ImageExtension() {
    }

    @NotNull
    public final List<String> getIMAGE_MIME_TYPES_NOT_EXTENSION() {
        return IMAGE_MIME_TYPES_NOT_EXTENSION;
    }

    @NotNull
    public final List<String> getIMAGE_TYPES() {
        return IMAGE_TYPES;
    }

    public final boolean isImageMimeType(@NotNull String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Iterator<String> it = IMAGE_TYPES.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(Constants.MIME_IMAGE_START + it.next(), mimeType)) {
                return true;
            }
        }
        Iterator<String> it2 = IMAGE_MIME_TYPES_NOT_EXTENSION.iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(it2.next(), mimeType)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isImageType(@NotNull String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        List<String> list = IMAGE_TYPES;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = extension.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return list.contains(lowerCase);
    }
}
