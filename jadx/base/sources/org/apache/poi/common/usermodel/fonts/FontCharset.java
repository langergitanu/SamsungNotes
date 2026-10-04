package org.apache.poi.common.usermodel.fonts;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.poi.util.POILogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum FontCharset {
    ANSI(0, "Cp1252"),
    DEFAULT(1, "Cp1252"),
    SYMBOL(2, ""),
    MAC(77, "MacRoman"),
    SHIFTJIS(128, "Shift_JIS"),
    HANGUL(129, "cp949"),
    JOHAB(130, "x-Johab"),
    GB2312(134, "GB2312"),
    CHINESEBIG5(136, "Big5"),
    GREEK(161, "Cp1253"),
    TURKISH(162, "Cp1254"),
    VIETNAMESE(163, "Cp1258"),
    HEBREW(177, "Cp1255"),
    ARABIC(178, "Cp1256"),
    BALTIC(186, "Cp1257"),
    RUSSIAN(204, "Cp1251"),
    THAI_(JPEG.DHP, "x-windows-874"),
    EASTEUROPE(JPEG.APP14, "Cp1250"),
    OEM(255, "Cp1252");

    private static FontCharset[] _table = new FontCharset[256];
    private Charset charset;
    private int nativeId;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getNativeId()] = fontCharset;
        }
    }

    FontCharset(int i, String str) {
        this.nativeId = i;
        if (str.length() > 0) {
            try {
                this.charset = Charset.forName(str);
                return;
            } catch (UnsupportedCharsetException unused) {
                POILogFactory.getLogger((Class<?>) FontCharset.class).log(5, "Unsupported charset: ".concat(str));
            }
        }
        this.charset = null;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static FontCharset valueOf(int i) {
        if (i < 0) {
            return null;
        }
        FontCharset[] fontCharsetArr = _table;
        if (i >= fontCharsetArr.length) {
            return null;
        }
        return fontCharsetArr[i];
    }
}
