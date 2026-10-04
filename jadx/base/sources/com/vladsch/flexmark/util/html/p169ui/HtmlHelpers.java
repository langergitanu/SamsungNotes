package com.vladsch.flexmark.util.html.p169ui;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.vladsch.flexmark.util.misc.Utils;
import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlHelpers {
    public static Color mixedColor(Color color, Color color2) {
        float[] fArrRGBtoHSB = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), new float[3]);
        float[] fArrRGBtoHSB2 = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), new float[3]);
        float[] fArr = {fArrRGBtoHSB2[0], Utils.rangeLimit(fArrRGBtoHSB[1], Utils.min(Utils.max(fArrRGBtoHSB2[1], 0.3f), 0.5f), 1.0f), Utils.rangeLimit(fArrRGBtoHSB[2], Utils.min(Utils.max(fArrRGBtoHSB2[2], 0.3f), 0.5f), 1.0f)};
        return Color.getHSBColor(fArr[0], fArr[1], fArr[2]);
    }

    public static void setRegExError(String str, JTextPane jTextPane, Font font, BackgroundColor backgroundColor, BackgroundColor backgroundColor2) {
        HtmlBuilder htmlBuilder = new HtmlBuilder();
        htmlBuilder.tag((CharSequence) "html").style("margin:2px;vertical-align:middle;").attr(backgroundColor, font).tag((CharSequence) "body");
        htmlBuilder.attr(backgroundColor2).tag((CharSequence) "div");
        htmlBuilder.append(toHtmlError(str, true));
        htmlBuilder.closeTag((CharSequence) "div");
        htmlBuilder.closeTag((CharSequence) "body");
        htmlBuilder.closeTag((CharSequence) "html");
        jTextPane.setVisible(true);
        jTextPane.setText(htmlBuilder.toFinalizedString());
        jTextPane.revalidate();
        jTextPane.getParent().revalidate();
        jTextPane.getParent().getParent().revalidate();
    }

    public static String toHtmlError(String str, boolean z) {
        String strGroup;
        if (str == null) {
            return null;
        }
        if (z) {
            Matcher matcher = Pattern.compile("(?:^|\n)(.*\n)(\\s*)\\^(\n?)$").matcher(str);
            if (matcher.find() && (strGroup = matcher.group(2)) != null && !strGroup.isEmpty()) {
                int iStart = matcher.group(1) != null ? matcher.start(1) : matcher.start(2);
                StringBuilder sbM2228s = AbstractC2821a.m2228s(str.substring(0, iStart), "<span style=\"font-family:monospaced\">", str.substring(iStart, matcher.start(2)).replace(" ", "&nbsp;"), Utils.repeat("&nbsp;", strGroup.length()), "^</span>");
                sbM2228s.append(strGroup);
                str = sbM2228s.toString();
            }
        }
        return str.replace("\n", "<br>");
    }

    public static String toHtmlString(Color color) {
        return color == null ? "#000000" : String.format("#%02x%02x%02x", Integer.valueOf(color.getRed()), Integer.valueOf(color.getGreen()), Integer.valueOf(color.getBlue()));
    }

    public static String toRgbString(Color color) {
        if (color == null) {
            return "rgb(0,0,0)";
        }
        int red = color.getRed();
        int green = color.getGreen();
        return AbstractC2821a.m2223n(AbstractC0622a.m1173s(red, green, "rgb(", ",", ","), ")", color.getBlue());
    }

    public static String withContext(String str, String str2, int i, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('\n');
        sb.append(str3);
        sb.append(str2);
        sb.append(str4);
        sb.append('\n');
        for (int i2 = 1; i2 < str3.length(); i2++) {
            sb.append(' ');
        }
        sb.append("^\n");
        return sb.toString();
    }
}
