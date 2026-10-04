package com.samsung.android.spr.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Spr {
    private static SparseArray<SprDrawableCache> mDrawableCache = new SparseArray<>();
    private static float mDensity = 1.0f;

    private static Drawable createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (xmlPullParser.getName() != "bitmap") {
            return null;
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
        if (!(attributeResourceValue != 0 ? isSpr(resources, attributeResourceValue) : false)) {
            return null;
        }
        SprDrawable sprDrawable = new SprDrawable();
        sprDrawable.inflate(resources, xmlPullParser, attributeSet, theme);
        return sprDrawable;
    }

    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        int iHashCode = resources.hashCode();
        float f = resources.getDisplayMetrics().density;
        synchronized (mDrawableCache) {
            try {
                if (f != mDensity) {
                    mDensity = f;
                    mDrawableCache.clear();
                    mDrawableCache = new SparseArray<>();
                }
            } finally {
            }
        }
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        String string = typedValue.string.toString();
        synchronized (mDrawableCache) {
            try {
                SprDrawableCache sprDrawableCache = mDrawableCache.get(iHashCode);
                if (sprDrawableCache == null) {
                    sprDrawableCache = new SprDrawableCache(resources);
                    mDrawableCache.put(iHashCode, sprDrawableCache);
                }
                Drawable sprDrawableCache2 = sprDrawableCache.getInstance(i);
                if (sprDrawableCache2 != null) {
                    return sprDrawableCache2;
                }
                if (string != null && !string.isEmpty() && ((string.endsWith(".bmp") || string.endsWith(".spr")) && isSpr(resources, i))) {
                    sprDrawableCache2 = SprDrawable.createFromResourceStream(resources, i);
                }
                if (sprDrawableCache2 == null) {
                    return resources.getDrawable(i, theme);
                }
                sprDrawableCache.put(i, sprDrawableCache2.getConstantState());
                return sprDrawableCache2;
            } finally {
            }
        }
    }

    public static boolean isSpr(Resources resources, int i) {
        if (i == 0) {
            return false;
        }
        byte[] bArr = new byte[3];
        try {
            InputStream inputStreamOpenRawResource = resources.openRawResource(i);
            inputStreamOpenRawResource.read(bArr, 0, 3);
            inputStreamOpenRawResource.close();
        } catch (IOException unused) {
        }
        return bArr[0] == 83 && bArr[1] == 80 && bArr[2] == 82;
    }
}
