package com.vladsch.flexmark.util.html.p169ui;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.MotionEventCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.awt.Color;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ColorStyler extends HtmlStylerBase<Color> {
    public static final HashMap<Integer, String> colorNameMap = new HashMap<>();
    public static final HashMap<String, Integer> nameColorMap = new HashMap<>();

    static {
        addColorName(0, "black");
        addColorName(128, "navy");
        addColorName(139, "darkblue");
        addColorName(205, "mediumblue");
        addColorName(255, "blue");
        addColorName(25600, "darkgreen");
        addColorName(32768, "green");
        addColorName(32896, "teal");
        addColorName(35723, "darkcyan");
        addColorName(ErrorCodeConvertor.CLOUD_PARAM_MNC_INVALID, "deepskyblue");
        addColorName(52945, "darkturquoise");
        addColorName(64154, "mediumspringgreen");
        addColorName(MotionEventCompat.ACTION_POINTER_INDEX_MASK, "lime");
        addColorName(65407, "springgreen");
        addColorName(65535, "aqua");
        addColorName(1644912, "midnightblue");
        addColorName(2003199, "dodgerblue");
        addColorName(2142890, "lightseagreen");
        addColorName(2263842, "forestgreen");
        addColorName(3050327, "seagreen");
        addColorName(3100495, "darkslategray");
        addColorName(3100495, "darkslategrey");
        addColorName(3329330, "limegreen");
        addColorName(3978097, "mediumseagreen");
        addColorName(4251856, "turquoise");
        addColorName(4286945, "royalblue");
        addColorName(4620980, "steelblue");
        addColorName(4734347, "darkslateblue");
        addColorName(4772300, "mediumturquoise");
        addColorName(4915330, "indigo");
        addColorName(5597999, "darkolivegreen");
        addColorName(6266528, "cadetblue");
        addColorName(6591981, "cornflowerblue");
        addColorName(6697881, "rebeccapurple");
        addColorName(6737322, "mediumaquamarine");
        addColorName(6908265, "dimgray");
        addColorName(6908265, "dimgrey");
        addColorName(6970061, "slateblue");
        addColorName(7048739, "olivedrab");
        addColorName(7372944, "slategray");
        addColorName(7372944, "slategrey");
        addColorName(7833753, "lightslategray");
        addColorName(7833753, "lightslategrey");
        addColorName(8087790, "mediumslateblue");
        addColorName(8190976, "lawngreen");
        addColorName(8388352, "chartreuse");
        addColorName(8388564, "aquamarine");
        addColorName(8388608, "maroon");
        addColorName(8388736, "purple");
        addColorName(8421376, "olive");
        addColorName(8421504, "gray");
        addColorName(8421504, "grey");
        addColorName(8900331, "skyblue");
        addColorName(8900346, "lightskyblue");
        addColorName(9055202, "blueviolet");
        addColorName(9109504, "darkred");
        addColorName(9109643, "darkmagenta");
        addColorName(9127187, "saddlebrown");
        addColorName(9419919, "darkseagreen");
        addColorName(9498256, "lightgreen");
        addColorName(9662683, "mediumpurple");
        addColorName(9699539, "darkviolet");
        addColorName(10025880, "palegreen");
        addColorName(10040012, "darkorchid");
        addColorName(10145074, "yellowgreen");
        addColorName(10506797, "sienna");
        addColorName(10824234, "brown");
        addColorName(11119017, "darkgray");
        addColorName(11119017, "darkgrey");
        addColorName(11393254, "lightblue");
        addColorName(11403055, "greenyellow");
        addColorName(11529966, "paleturquoise");
        addColorName(11584734, "lightsteelblue");
        addColorName(11591910, "powderblue");
        addColorName(11674146, "firebrick");
        addColorName(12092939, "darkgoldenrod");
        addColorName(12211667, "mediumorchid");
        addColorName(12357519, "rosybrown");
        addColorName(12433259, "darkkhaki");
        addColorName(12632256, "silver");
        addColorName(13047173, "mediumvioletred");
        addColorName(13458524, "indianred");
        addColorName(13468991, "peru");
        addColorName(13789470, "chocolate");
        addColorName(13808780, VElementFormulasCmd.FTAN);
        addColorName(13882323, "lightgray");
        addColorName(13882323, "lightgrey");
        addColorName(14204888, "thistle");
        addColorName(14315734, "orchid");
        addColorName(14329120, "goldenrod");
        addColorName(14381203, "palevioletred");
        addColorName(14423100, "crimson");
        addColorName(14474460, "gainsboro");
        addColorName(14524637, "plum");
        addColorName(14596231, "burlywood");
        addColorName(14745599, "lightcyan");
        addColorName(15132410, "lavender");
        addColorName(15308410, "darksalmon");
        addColorName(15631086, "violet");
        addColorName(15657130, "palegoldenrod");
        addColorName(15761536, "lightcoral");
        addColorName(15787660, "khaki");
        addColorName(15792383, "aliceblue");
        addColorName(15794160, "honeydew");
        addColorName(15794175, "azure");
        addColorName(16032864, "sandybrown");
        addColorName(16113331, "wheat");
        addColorName(16119260, "beige");
        addColorName(16119285, "whitesmoke");
        addColorName(16121850, "mintcream");
        addColorName(16316671, "ghostwhite");
        addColorName(16416882, "salmon");
        addColorName(16444375, "antiquewhite");
        addColorName(16445670, "linen");
        addColorName(16448210, "lightgoldenrodyellow");
        addColorName(16643558, "oldlace");
        addColorName(16711680, "red");
        addColorName(16711935, "fuchsia");
        addColorName(16716947, "deeppink");
        addColorName(16729344, "orangered");
        addColorName(16737095, "tomato");
        addColorName(16738740, "hotpink");
        addColorName(16744272, "coral");
        addColorName(16747520, "darkorange");
        addColorName(16752762, "lightsalmon");
        addColorName(16753920, "orange");
        addColorName(16758465, "lightpink");
        addColorName(16761035, "pink");
        addColorName(16766720, "gold");
        addColorName(16767673, "peachpuff");
        addColorName(16768685, "navajowhite");
        addColorName(16770229, "moccasin");
        addColorName(16770244, "bisque");
        addColorName(16770273, "mistyrose");
        addColorName(16772045, "blanchedalmond");
        addColorName(16773077, "papayawhip");
        addColorName(16773365, "lavenderblush");
        addColorName(16774638, "seashell");
        addColorName(16775388, "cornsilk");
        addColorName(16775885, "lemonchiffon");
        addColorName(16775920, "floralwhite");
        addColorName(16775930, "snow");
        addColorName(16776960, "yellow");
        addColorName(16777184, "lightyellow");
        addColorName(16777200, "ivory");
        addColorName(16777215, "white");
    }

    private static void addColorName(int i, String str) {
        colorNameMap.put(Integer.valueOf(i), str);
        nameColorMap.put(str, Integer.valueOf(i));
    }

    public static String getColorName(Color color) {
        if (color != null) {
            return colorNameMap.get(Integer.valueOf(color.getRGB() & 16777215));
        }
        return null;
    }

    public static String getColorNameOrRGB(Color color) {
        if (color == null) {
            return "";
        }
        String str = colorNameMap.get(Integer.valueOf(color.getRGB() & 16777215));
        if (str != null) {
            return str;
        }
        Locale locale = Locale.US;
        int red = color.getRed();
        int green = color.getGreen();
        return AbstractC2821a.m2223n(AbstractC0622a.m1173s(red, green, "rgb(", ",", ","), ")", color.getBlue());
    }

    public static String getColorValue(Color color) {
        if (color == null) {
            return "";
        }
        if (color.getAlpha() == 255) {
            return String.format(Locale.US, "%02x%02x%02x", Integer.valueOf(color.getRed()), Integer.valueOf(color.getGreen()), Integer.valueOf(color.getBlue()));
        }
        Locale locale = Locale.US;
        int red = color.getRed();
        int green = color.getGreen();
        return AbstractC2322a.m1625o(AbstractC0622a.m1173s(red, green, "rgba(", ",", ","), color.getBlue(), color.getAlpha(), ",", ")");
    }

    public static Color getNamedColor(String str) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (!str.startsWith(ContentUtils.HASH_SYMBOL)) {
            Integer num = nameColorMap.get(str);
            if (num == null) {
                return null;
            }
            return new Color(num.intValue());
        }
        if (SequenceUtils.parseIntOrNull(str.substring(1), 16) == null) {
            return null;
        }
        String strSubstring4 = str.substring(1);
        int length = strSubstring4.length();
        String strConcat = "";
        if (length == 3) {
            strSubstring = strSubstring4.substring(0, 1);
            strSubstring2 = strSubstring4.substring(1, 2);
            strSubstring3 = strSubstring4.substring(2, 3);
        } else if (length == 4) {
            strSubstring = strSubstring4.substring(0, 1);
            strSubstring2 = strSubstring4.substring(1, 2);
            String strSubstring5 = strSubstring4.substring(2, 3);
            strConcat = strSubstring4.substring(3, 4);
            strSubstring3 = strSubstring5;
        } else if (length == 6) {
            strSubstring = strSubstring4.substring(0, 2);
            strSubstring2 = strSubstring4.substring(2, 4);
            strSubstring3 = strSubstring4.substring(4, 6);
        } else {
            if (length != 8) {
                return null;
            }
            strSubstring = strSubstring4.substring(0, 2);
            strSubstring2 = strSubstring4.substring(2, 4);
            strSubstring4.substring(4, 6);
            strSubstring3 = strSubstring4.substring(6, 8);
        }
        if (strSubstring.length() == 1) {
            strSubstring = strSubstring.concat(strSubstring);
        }
        if (strSubstring2.length() == 1) {
            strSubstring2 = strSubstring2.concat(strSubstring2);
        }
        if (strSubstring3.length() == 1) {
            strSubstring3 = strSubstring3.concat(strSubstring3);
        }
        if (strConcat.length() == 1) {
            strConcat = strConcat.concat(strConcat);
        }
        if (strConcat.isEmpty()) {
            strConcat = "ff";
        }
        return new Color(parse(strSubstring), parse(strSubstring2), parse(strSubstring3), parse(strConcat));
    }

    public static int parse(String str) {
        return Integer.parseInt(str, 16);
    }

    @Override // com.vladsch.flexmark.util.html.p169ui.HtmlStylerBase, com.vladsch.flexmark.util.html.p169ui.HtmlStyler
    public String getStyle(Color color) {
        return color instanceof BackgroundColor ? AbstractC0541b.m772n("background-color:#", getColorValue(color)) : color == null ? "" : AbstractC0541b.m772n("color:#", getColorValue(color));
    }
}
