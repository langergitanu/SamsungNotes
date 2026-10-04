package com.airbnb.lottie.manager;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ImageAssetManager {
    private static final Object bitmapHashLock = new Object();

    @Nullable
    private final Context context;

    @Nullable
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private final String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        if (TextUtils.isEmpty(str) || AbstractC0000a.m4a(1, str) == '/') {
            this.imagesFolder = str;
        } else {
            this.imagesFolder = str.concat("/");
        }
        this.imageAssets = map;
        setDelegate(imageAssetDelegate);
        if (callback instanceof View) {
            this.context = ((View) callback).getContext().getApplicationContext();
        } else {
            this.context = null;
        }
    }

    private Bitmap putBitmap(String str, @Nullable Bitmap bitmap) {
        synchronized (bitmapHashLock) {
            this.imageAssets.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.delegate;
        if (imageAssetDelegate != null) {
            Bitmap bitmapFetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (bitmapFetchBitmap != null) {
                putBitmap(str, bitmapFetchBitmap);
            }
            return bitmapFetchBitmap;
        }
        Context context = this.context;
        if (context == null) {
            return null;
        }
        String fileName = lottieImageAsset.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                try {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                    if (bitmapDecodeByteArray != null) {
                        return putBitmap(str, Utils.resizeBitmapIfNeeded(bitmapDecodeByteArray, lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                    }
                    Logger.warning("Decoded image `" + str + "` is null.");
                    return null;
                } catch (IllegalArgumentException e) {
                    Logger.warning("Unable to decode image `" + str + "`.", e);
                    return null;
                }
            } catch (IllegalArgumentException e2) {
                Logger.warning("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.imagesFolder)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.imagesFolder + fileName), null, options);
                if (bitmapDecodeStream != null) {
                    return putBitmap(str, Utils.resizeBitmapIfNeeded(bitmapDecodeStream, lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                }
                Logger.warning("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e3) {
                Logger.warning("Unable to decode image `" + str + "`.", e3);
                return null;
            }
        } catch (IOException e5) {
            Logger.warning("Unable to open asset.", e5);
            return null;
        }
    }

    @Nullable
    public LottieImageAsset getImageAssetById(String str) {
        return this.imageAssets.get(str);
    }

    public boolean hasSameContext(Context context) {
        if (context == null) {
            return this.context == null;
        }
        if (this.context instanceof Application) {
            context = context.getApplicationContext();
        }
        return context == this.context;
    }

    public void setDelegate(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmap2 = this.imageAssets.get(str).getBitmap();
            putBitmap(str, bitmap);
            return bitmap2;
        }
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        Bitmap bitmap3 = lottieImageAsset.getBitmap();
        lottieImageAsset.setBitmap(null);
        return bitmap3;
    }
}
