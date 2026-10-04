package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util;

import android.graphics.Color;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VUtilString {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int TRANSPARENT = 0;
    public static final String VHEIGHT = "height";
    public static final String VWIDTH = "width";
    public static final String VXCENTER = "xcenter";
    public static final String VYCENTER = "ycenter";
    public static final int WHITE = -1;
    public static final int YELLOW = -256;
    public static final HashMap<String, Integer> sColorNameMap;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        sColorNameMap = map;
        map.put("black", -16777216);
        map.put("darkgray", Integer.valueOf(DKGRAY));
        map.put("gray", Integer.valueOf(GRAY));
        map.put("lightgray", Integer.valueOf(LTGRAY));
        map.put("white", -1);
        map.put("red", -65536);
        map.put("green", Integer.valueOf(GREEN));
        map.put("blue", -16776961);
        map.put("yellow", -256);
        map.put("cyan", Integer.valueOf(CYAN));
        map.put("magenta", Integer.valueOf(MAGENTA));
    }

    public static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return sb.toString();
            }
            sb.append(line.concat("\n"));
        }
    }

    public static Integer getHex(String str) {
        if (str != null && str.matches(ContentUtils.HASH_SYMBOL)) {
            return Integer.valueOf(Integer.parseInt(str.substring(1), 16));
        }
        return null;
    }

    public static boolean parseBoolean(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith("t");
    }

    public static int parseColor(String str) {
        try {
        } catch (IllegalArgumentException e) {
            DocumentLogger.m7179e("HtmlToBitmapForConvert", e + " / parseColor : " + str);
        }
        if (str.charAt(0) == '#') {
            return Color.parseColor(str);
        }
        Integer num = sColorNameMap.get(str.toLowerCase(Locale.US));
        if (num != null) {
            return num.intValue();
        }
        return Color.parseColor(VDrawConst.DEFAULT_STORKE_COLOR);
    }

    public static float parseFloat(String str) {
        if (str == null || str.length() == 0) {
            return 0.0f;
        }
        if (Pattern.compile(".*[a-zA-Z%]*").matcher(str).matches()) {
            if (str.endsWith("em") || str.endsWith("ex") || str.endsWith("px")) {
                str = AbstractC2322a.m1614d(2, 0, str);
            } else if (str.endsWith("%") || str.endsWith("f")) {
                str = AbstractC2322a.m1614d(1, 0, str);
            } else if (str.endsWith("in") || str.endsWith("cm") || str.endsWith("mm") || str.endsWith(LangPackConfigConstants.LANGUAGE_CODE_PT) || str.endsWith("pc")) {
                str = AbstractC2322a.m1614d(2, 0, str);
            }
        }
        if (str.startsWith("0.")) {
            str = "1";
        }
        return Float.parseFloat(str);
    }

    public static float ptToPx(float f) {
        return f;
    }
}
