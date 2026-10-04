package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class FontAssetManager {
    private final AssetManager assetManager;

    @Nullable
    private FontAssetDelegate delegate;
    private final MutablePair<String> tempPair = new MutablePair<>();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final Map<String, Typeface> fontFamilies = new HashMap();
    private String defaultFontFileExtension = ".ttf";

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
        if (callback instanceof View) {
            this.assetManager = ((View) callback).getContext().getAssets();
        } else {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
        }
    }

    private Typeface getFontFamily(Font font) {
        Typeface typefaceCreateFromAsset;
        String family = font.getFamily();
        Typeface typeface = this.fontFamilies.get(family);
        if (typeface != null) {
            return typeface;
        }
        String style = font.getStyle();
        String name = font.getName();
        FontAssetDelegate fontAssetDelegate = this.delegate;
        if (fontAssetDelegate != null) {
            typefaceCreateFromAsset = fontAssetDelegate.fetchFont(family, style, name);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.delegate.fetchFont(family);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (fontAssetDelegate2 != null && typefaceCreateFromAsset == null) {
            String fontPath = fontAssetDelegate2.getFontPath(family, style, name);
            if (fontPath == null) {
                fontPath = this.delegate.getFontPath(family);
            }
            if (fontPath != null) {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.assetManager, fontPath);
            }
        }
        if (font.getTypeface() != null) {
            return font.getTypeface();
        }
        if (typefaceCreateFromAsset == null) {
            StringBuilder sbM12325j = AbstractC11014a.m12325j("fonts/", family);
            sbM12325j.append(this.defaultFontFileExtension);
            typefaceCreateFromAsset = Typeface.createFromAsset(this.assetManager, sbM12325j.toString());
        }
        this.fontFamilies.put(family, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public Typeface getTypeface(Font font) {
        this.tempPair.set(font.getFamily(), font.getStyle());
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceTypefaceForStyle = typefaceForStyle(getFontFamily(font), font.getStyle());
        this.fontMap.put(this.tempPair, typefaceTypefaceForStyle);
        return typefaceTypefaceForStyle;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}
