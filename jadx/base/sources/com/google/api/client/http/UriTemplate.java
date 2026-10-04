package com.google.api.client.http;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class UriTemplate {
    private static final String COMPOSITE_NON_EXPLODE_JOINER = ",";
    static final Map<Character, CompositeOutput> COMPOSITE_PREFIXES = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CompositeOutput {
        PLUS('+', "", ",", false, true),
        HASH('#', ContentUtils.HASH_SYMBOL, ",", false, true),
        DOT('.', Extension.DOT, Extension.DOT, false, false),
        FORWARD_SLASH('/', "/", "/", false, false),
        SEMI_COLON(Character.valueOf(SQLKeyword.DELIMITER), ";", ";", true, false),
        QUERY('?', MsalUtils.QUERY_STRING_SYMBOL, MsalUtils.QUERY_STRING_DELIMITER, true, false),
        AMP(Character.valueOf(Typography.amp), MsalUtils.QUERY_STRING_DELIMITER, MsalUtils.QUERY_STRING_DELIMITER, true, false),
        SIMPLE(null, "", ",", false, false);

        private final String explodeJoiner;
        private final String outputPrefix;
        private final Character propertyPrefix;
        private final boolean requiresVarAssignment;
        private final boolean reservedExpansion;

        CompositeOutput(Character ch, String str, String str2, boolean z, boolean z2) {
            this.propertyPrefix = ch;
            this.outputPrefix = (String) Preconditions.checkNotNull(str);
            this.explodeJoiner = (String) Preconditions.checkNotNull(str2);
            this.requiresVarAssignment = z;
            this.reservedExpansion = z2;
            if (ch != null) {
                UriTemplate.COMPOSITE_PREFIXES.put(ch, this);
            }
        }

        public String getEncodedValue(String str) {
            return this.reservedExpansion ? CharEscapers.escapeUriPath(str) : CharEscapers.escapeUri(str);
        }

        public String getExplodeJoiner() {
            return this.explodeJoiner;
        }

        public String getOutputPrefix() {
            return this.outputPrefix;
        }

        public boolean getReservedExpansion() {
            return this.reservedExpansion;
        }

        public int getVarNameStartIndex() {
            return this.propertyPrefix == null ? 0 : 1;
        }

        public boolean requiresVarAssignment() {
            return this.requiresVarAssignment;
        }
    }

    static {
        CompositeOutput.values();
    }

    public static String expand(String str, String str2, Object obj, boolean z) {
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.setRawPath(null);
            str2 = genericUrl.build() + str2;
        } else if (!str2.startsWith(WebConstants.HTTP_PROTOCOL) && !str2.startsWith("https://")) {
            str2 = AbstractC0541b.m756B(str, str2);
        }
        return expand(str2, obj, z);
    }

    public static CompositeOutput getCompositeOutput(String str) {
        CompositeOutput compositeOutput = COMPOSITE_PREFIXES.get(Character.valueOf(str.charAt(0)));
        return compositeOutput == null ? CompositeOutput.SIMPLE : compositeOutput;
    }

    private static String getListPropertyValue(String str, Iterator<?> it, boolean z, CompositeOutput compositeOutput) {
        String explodeJoiner;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            explodeJoiner = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            }
            explodeJoiner = ",";
        }
        while (it.hasNext()) {
            if (z && compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            }
            sb.append(compositeOutput.getEncodedValue(it.next().toString()));
            if (it.hasNext()) {
                sb.append(explodeJoiner);
            }
        }
        return sb.toString();
    }

    private static Map<String, Object> getMap(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.mapOf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.isNull(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    private static String getMapPropertyValue(String str, Map<String, Object> map, boolean z, CompositeOutput compositeOutput) {
        String explodeJoiner;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = MarketingConstants.REFERRER_DELIMITER_U003D;
        if (z) {
            explodeJoiner = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            }
            str2 = ",";
            explodeJoiner = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String encodedValue = compositeOutput.getEncodedValue(next.getKey());
            String encodedValue2 = compositeOutput.getEncodedValue(next.getValue().toString());
            sb.append(encodedValue);
            sb.append(str2);
            sb.append(encodedValue2);
            if (it.hasNext()) {
                sb.append(explodeJoiner);
            }
        }
        return sb.toString();
    }

    public static String expand(String str, Object obj, boolean z) {
        Object listPropertyValue;
        Map<String, Object> map = getMap(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int iIndexOf = str.indexOf(123, i);
            if (iIndexOf != -1) {
                sb.append(str.substring(i, iIndexOf));
                int iIndexOf2 = str.indexOf(125, iIndexOf + 2);
                int i2 = iIndexOf2 + 1;
                String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
                CompositeOutput compositeOutput = getCompositeOutput(strSubstring);
                ListIterator<String> listIterator = Splitter.m4219on(',').splitToList(strSubstring).listIterator();
                boolean z2 = true;
                while (listIterator.hasNext()) {
                    String next = listIterator.next();
                    boolean zEndsWith = next.endsWith("*");
                    int varNameStartIndex = listIterator.nextIndex() == 1 ? compositeOutput.getVarNameStartIndex() : 0;
                    int length2 = next.length();
                    if (zEndsWith) {
                        length2--;
                    }
                    String strSubstring2 = next.substring(varNameStartIndex, length2);
                    Object objRemove = map.remove(strSubstring2);
                    if (objRemove != null) {
                        if (!z2) {
                            sb.append(compositeOutput.getExplodeJoiner());
                        } else {
                            sb.append(compositeOutput.getOutputPrefix());
                            z2 = false;
                        }
                        if (objRemove instanceof Iterator) {
                            listPropertyValue = getListPropertyValue(strSubstring2, (Iterator) objRemove, zEndsWith, compositeOutput);
                        } else if (!(objRemove instanceof Iterable) && !objRemove.getClass().isArray()) {
                            if (objRemove.getClass().isEnum()) {
                                if (FieldInfo.m4226of((Enum<?>) objRemove).getName() != null) {
                                    if (compositeOutput.requiresVarAssignment()) {
                                        objRemove = String.format("%s=%s", strSubstring2, objRemove);
                                    }
                                    objRemove = CharEscapers.escapeUriPath(objRemove.toString());
                                }
                                listPropertyValue = objRemove;
                            } else if (!Data.isValueOfPrimitiveType(objRemove)) {
                                listPropertyValue = getMapPropertyValue(strSubstring2, getMap(objRemove), zEndsWith, compositeOutput);
                            } else {
                                if (compositeOutput.requiresVarAssignment()) {
                                    objRemove = String.format("%s=%s", strSubstring2, objRemove);
                                }
                                if (compositeOutput.getReservedExpansion()) {
                                    listPropertyValue = CharEscapers.escapeUriPathWithoutReserved(objRemove.toString());
                                } else {
                                    listPropertyValue = CharEscapers.escapeUriPath(objRemove.toString());
                                }
                            }
                        } else {
                            listPropertyValue = getListPropertyValue(strSubstring2, Types.iterableOf(objRemove).iterator(), zEndsWith, compositeOutput);
                        }
                        sb.append(listPropertyValue);
                    }
                }
                i = i2;
            } else {
                if (i == 0 && !z) {
                    return str;
                }
                sb.append(str.substring(i));
            }
        }
        if (z) {
            GenericUrl.addQueryParams(map.entrySet(), sb);
        }
        return sb.toString();
    }
}
