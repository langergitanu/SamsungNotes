package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Utils implements XMPConst {
    static Set<String> EXTERNAL_XMPDM_PROPS = null;
    public static final int UUID_LENGTH = 36;
    public static final int UUID_SEGMENT_COUNT = 4;
    private static boolean[] xmlNameChars;
    private static boolean[] xmlNameStartChars;

    static {
        initCharTables();
        EXTERNAL_XMPDM_PROPS = new HashSet<String>() { // from class: com.adobe.internal.xmp.impl.Utils.1
            {
                add("xmpDM:album");
                add("xmpDM:altTapeName");
                add("xmpDM:altTimecode");
                add("xmpDM:artist");
                add("xmpDM:cameraAngle");
                add("xmpDM:cameraLabel");
                add("xmpDM:cameraModel");
                add("xmpDM:cameraMove");
                add("xmpDM:client");
                add("xmpDM:comment");
                add("xmpDM:composer");
                add("xmpDM:director");
                add("xmpDM:directorPhotography");
                add("xmpDM:engineer");
                add("xmpDM:genre");
                add("xmpDM:good");
                add("xmpDM:instrument");
                add("xmpDM:logComment");
                add("xmpDM:projectName");
                add("xmpDM:releaseDate");
                add("xmpDM:scene");
                add("xmpDM:shotDate");
                add("xmpDM:shotDay");
                add("xmpDM:shotLocation");
                add("xmpDM:shotName");
                add("xmpDM:shotNumber");
                add("xmpDM:shotSize");
                add("xmpDM:speakerPlacement");
                add("xmpDM:takeNumber");
                add("xmpDM:tapeName");
                add("xmpDM:trackNumber");
                add("xmpDM:videoAlphaMode");
                add("xmpDM:videoAlphaPremultipleColor");
            }
        };
    }

    private Utils() {
    }

    public static boolean checkUUIDFormat(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        boolean z = true;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                i2++;
                z = z && (i == 8 || i == 13 || i == 18 || i == 23);
            }
            i++;
        }
        return z && 4 == i2 && 36 == i;
    }

    public static String escapeXML(String str, boolean z, boolean z2) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '<' || cCharAt == '>' || cCharAt == '&' || ((z2 && (cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) || (z && cCharAt == '\"'))) {
                StringBuffer stringBuffer = new StringBuffer((str.length() * 4) / 3);
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (z2 && (cCharAt2 == '\t' || cCharAt2 == '\n' || cCharAt2 == '\r')) {
                        stringBuffer.append("&#x");
                        stringBuffer.append(Integer.toHexString(cCharAt2).toUpperCase());
                        stringBuffer.append(SQLKeyword.DELIMITER);
                    } else if (cCharAt2 == '\"') {
                        stringBuffer.append(z ? "&quot;" : "\"");
                    } else if (cCharAt2 == '&') {
                        stringBuffer.append("&amp;");
                    } else if (cCharAt2 == '<') {
                        stringBuffer.append("&lt;");
                    } else if (cCharAt2 != '>') {
                        stringBuffer.append(cCharAt2);
                    } else {
                        stringBuffer.append("&gt;");
                    }
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    private static void initCharTables() {
        xmlNameChars = new boolean[256];
        xmlNameStartChars = new boolean[256];
        char c = 0;
        while (true) {
            boolean[] zArr = xmlNameChars;
            if (c >= zArr.length) {
                return;
            }
            boolean[] zArr2 = xmlNameStartChars;
            boolean z = true;
            boolean z2 = c == ':' || ('A' <= c && c <= 'Z') || c == '_' || (('a' <= c && c <= 'z') || ((192 <= c && c <= 214) || ((216 <= c && c <= 246) || (248 <= c && c <= 255))));
            zArr2[c] = z2;
            if (!z2 && c != '-' && c != '.' && (('0' > c || c > '9') && c != 183)) {
                z = false;
            }
            zArr[c] = z;
            c = (char) (c + 1);
        }
    }

    public static boolean isControlChar(char c) {
        return ((c > 31 && c != 127) || c == '\t' || c == '\n' || c == '\r') ? false : true;
    }

    public static boolean isInternalProperty(String str, String str2) {
        if ("http://purl.org/dc/elements/1.1/".equals(str)) {
            if ("dc:format".equals(str2) || "dc:language".equals(str2)) {
                return true;
            }
        } else if (XMPConst.NS_XMP.equals(str)) {
            if ("xmp:BaseURL".equals(str2) || "xmp:CreatorTool".equals(str2) || "xmp:Format".equals(str2) || "xmp:Locale".equals(str2) || "xmp:MetadataDate".equals(str2) || "xmp:ModifyDate".equals(str2)) {
                return true;
            }
        } else if (XMPConst.NS_PDF.equals(str)) {
            if ("pdf:BaseURL".equals(str2) || "pdf:Creator".equals(str2) || "pdf:ModDate".equals(str2) || "pdf:PDFVersion".equals(str2) || "pdf:Producer".equals(str2)) {
                return true;
            }
        } else {
            if (XMPConst.NS_TIFF.equals(str)) {
                return ("tiff:ImageDescription".equals(str2) || "tiff:Artist".equals(str2) || "tiff:Copyright".equals(str2)) ? false : true;
            }
            if (XMPConst.NS_EXIF.equals(str)) {
                return !"exif:UserComment".equals(str2);
            }
            if (XMPConst.NS_EXIF_AUX.equals(str)) {
                return true;
            }
            if (XMPConst.NS_PHOTOSHOP.equals(str)) {
                if ("photoshop:ICCProfile".equals(str2) || "photoshop:TextLayers".equals(str2)) {
                    return true;
                }
            } else {
                if (XMPConst.NS_DM.equals(str)) {
                    return !EXTERNAL_XMPDM_PROPS.contains(str2);
                }
                if (XMPConst.NS_CAMERARAW.equals(str)) {
                    return true;
                }
                if (XMPConst.NS_SCRIPT.equals(str)) {
                    return ("xmpScript:action".equals(str2) || "xmpScript:character".equals(str2) || "xmpScript:dialog".equals(str2) || "xmpScript:sceneSetting".equals(str2) || "xmpScript:sceneTimeOfDay".equals(str2)) ? false : true;
                }
                if (XMPConst.NS_BWF.equals(str)) {
                    if ("bext:version".equals(str2)) {
                        return true;
                    }
                } else if (XMPConst.NS_ADOBESTOCKPHOTO.equals(str) || XMPConst.NS_XMP_MM.equals(str) || XMPConst.TYPE_TEXT.equals(str) || XMPConst.TYPE_PAGEDFILE.equals(str) || XMPConst.TYPE_GRAPHICS.equals(str) || XMPConst.TYPE_IMAGE.equals(str) || XMPConst.TYPE_FONT.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isNameChar(char c) {
        if ((c <= 255 && xmlNameChars[c]) || isNameStartChar(c)) {
            return true;
        }
        if (c < 768 || c > 879) {
            return c >= 8255 && c <= 8256;
        }
        return true;
    }

    private static boolean isNameStartChar(char c) {
        if (c <= 255 && xmlNameStartChars[c]) {
            return true;
        }
        if (c >= 256 && c <= 767) {
            return true;
        }
        if (c >= 880 && c <= 893) {
            return true;
        }
        if (c >= 895 && c <= 8191) {
            return true;
        }
        if (c >= 8204 && c <= 8205) {
            return true;
        }
        if (c >= 8304 && c <= 8591) {
            return true;
        }
        if (c >= 11264 && c <= 12271) {
            return true;
        }
        if (c >= 12289 && c <= 55295) {
            return true;
        }
        if (c >= 63744 && c <= 64975) {
            return true;
        }
        if (c < 65008 || c > 65533) {
            return c >= 0 && c <= 65535;
        }
        return true;
    }

    public static boolean isXMLName(String str) {
        if (str.length() > 0 && !isNameStartChar(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isNameChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isXMLNameNS(String str) {
        if (str.length() > 0 && (!isNameStartChar(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isNameChar(str.charAt(i)) || str.charAt(i) == ':') {
                return false;
            }
        }
        return true;
    }

    public static String normalizeLangValue(String str) {
        if (XMPConst.X_DEFAULT.equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ') {
                if (cCharAt == '-' || cCharAt == '_') {
                    stringBuffer.append('-');
                    i++;
                } else if (i != 2) {
                    stringBuffer.append(Character.toLowerCase(str.charAt(i2)));
                } else {
                    stringBuffer.append(Character.toUpperCase(str.charAt(i2)));
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String removeControlChars(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (isControlChar(stringBuffer.charAt(i))) {
                stringBuffer.setCharAt(i, ' ');
            }
        }
        return stringBuffer.toString();
    }

    public static String[] splitNameAndValue(String str) {
        int iIndexOf = str.indexOf(61);
        String strSubstring = str.substring(str.charAt(1) == '?' ? 2 : 1, iIndexOf);
        char cCharAt = str.charAt(iIndexOf + 1);
        int i = iIndexOf + 2;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - iIndexOf);
        while (i < length) {
            stringBuffer.append(str.charAt(i));
            int i2 = i + 1;
            i = str.charAt(i2) == cCharAt ? i + 2 : i2;
        }
        return new String[]{strSubstring, stringBuffer.toString()};
    }
}
