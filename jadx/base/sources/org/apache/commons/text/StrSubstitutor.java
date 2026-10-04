package org.apache.commons.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.Validate;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher(StringSubstitutor.DEFAULT_VAR_START);
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(StringSubstitutor.DEFAULT_VAR_DEFAULT);
    private boolean disableSubstitutionInValues;
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isDisableSubstitutionInValues() {
        return this.disableSubstitutionInValues;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i, int i2) {
        StrLookup<?> variableResolver = getVariableResolver();
        if (variableResolver == null) {
            return null;
        }
        return variableResolver.lookup(str);
    }

    public void setDisableSubstitutionInValues(boolean z) {
        this.disableSubstitutionInValues = z;
    }

    public void setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
    }

    public void setEscapeChar(char c) {
        this.escapeChar = c;
    }

    public void setPreserveEscapes(boolean z) {
        this.preserveEscapes = z;
    }

    public StrSubstitutor setValueDelimiter(char c) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        Validate.isTrue(strMatcher != null, "Variable prefix matcher must not be null!", new Object[0]);
        this.prefixMatcher = strMatcher;
        return this;
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        Validate.isTrue(strMatcher != null, "Variable suffix matcher must not be null!", new Object[0]);
        this.suffixMatcher = strMatcher;
        return this;
    }

    public boolean substitute(StrBuilder strBuilder, int i, int i2) {
        return substitute(strBuilder, i, i2, null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.commons.text.StrSubstitutor] */
    private int substitute(StrBuilder strBuilder, int i, int i2, List<String> list) {
        StrMatcher strMatcher;
        char c;
        boolean z;
        boolean z2;
        int i4;
        String strSubstring;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        StrMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
        boolean zIsEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean zIsDisableSubstitutionInValues = isDisableSubstitutionInValues();
        boolean z3 = list == null;
        int i5 = i;
        int i6 = i + i2;
        int i7 = 0;
        int i8 = 0;
        char[] cArr = strBuilder.buffer;
        ?? arrayList = list;
        while (i5 < i6) {
            int iIsMatch = variablePrefixMatcher.isMatch(cArr, i5, i, i6);
            if (iIsMatch == 0) {
                i5++;
                strMatcher = variableSuffixMatcher;
                c = escapeChar;
                z = zIsEnableSubstitutionInVariables;
                z2 = zIsDisableSubstitutionInValues;
            } else {
                if (i5 > i) {
                    int i9 = i5 - 1;
                    z = zIsEnableSubstitutionInVariables;
                    if (cArr[i9] == escapeChar) {
                        if (this.preserveEscapes) {
                            i5++;
                            zIsEnableSubstitutionInVariables = z;
                        } else {
                            strBuilder.deleteCharAt(i9);
                            i7--;
                            i6--;
                            strMatcher = variableSuffixMatcher;
                            c = escapeChar;
                            cArr = strBuilder.buffer;
                            z2 = zIsDisableSubstitutionInValues;
                            i8 = 1;
                        }
                    }
                } else {
                    z = zIsEnableSubstitutionInVariables;
                }
                int i10 = i5 + iIsMatch;
                int iIsMatch2 = i10;
                int i11 = 0;
                while (true) {
                    if (iIsMatch2 >= i6) {
                        strMatcher = variableSuffixMatcher;
                        c = escapeChar;
                        z2 = zIsDisableSubstitutionInValues;
                        i5 = iIsMatch2;
                        arrayList = arrayList;
                        break;
                    }
                    if (!z || variablePrefixMatcher.isMatch(cArr, iIsMatch2, i, i6) == 0) {
                        int iIsMatch3 = variableSuffixMatcher.isMatch(cArr, iIsMatch2, i, i6);
                        if (iIsMatch3 == 0) {
                            iIsMatch2++;
                        } else if (i11 == 0) {
                            strMatcher = variableSuffixMatcher;
                            c = escapeChar;
                            String str = new String(cArr, i10, (iIsMatch2 - i5) - iIsMatch);
                            if (z) {
                                StrBuilder strBuilder2 = new StrBuilder(str);
                                substitute(strBuilder2, 0, strBuilder2.length());
                                str = strBuilder2.toString();
                            }
                            int i12 = iIsMatch2 + iIsMatch3;
                            if (valueDelimiterMatcher != null) {
                                char[] charArray = str.toCharArray();
                                z2 = zIsDisableSubstitutionInValues;
                                for (int i13 = 0; i13 < charArray.length && (z || variablePrefixMatcher.isMatch(charArray, i13, i13, charArray.length) == 0); i13++) {
                                    if (valueDelimiterMatcher.isMatch(charArray, i13) != 0) {
                                        int iIsMatch4 = valueDelimiterMatcher.isMatch(charArray, i13);
                                        i4 = 0;
                                        String strSubstring2 = str.substring(0, i13);
                                        strSubstring = str.substring(i13 + iIsMatch4);
                                        str = strSubstring2;
                                        break;
                                    }
                                }
                            } else {
                                z2 = zIsDisableSubstitutionInValues;
                            }
                            i4 = 0;
                            strSubstring = null;
                            if (arrayList == 0) {
                                arrayList = new ArrayList();
                                arrayList.add(new String(cArr, i, i2));
                            }
                            checkCyclicSubstitution(str, arrayList);
                            arrayList.add(str);
                            String strResolveVariable = resolveVariable(str, strBuilder, i5, i12);
                            if (strResolveVariable != null) {
                                strSubstring = strResolveVariable;
                            }
                            if (strSubstring != null) {
                                int length = strSubstring.length();
                                strBuilder.replace(i5, i12, strSubstring);
                                int iSubstitute = ((!z2 ? substitute(strBuilder, i5, length, arrayList) : i4) + length) - (i12 - i5);
                                i12 += iSubstitute;
                                i6 += iSubstitute;
                                i7 += iSubstitute;
                                cArr = strBuilder.buffer;
                                i8 = 1;
                            }
                            i5 = i12;
                            arrayList.remove(arrayList.size() - 1);
                            arrayList = arrayList;
                        } else {
                            i11--;
                            iIsMatch2 += iIsMatch3;
                            zIsDisableSubstitutionInValues = zIsDisableSubstitutionInValues;
                        }
                    } else {
                        i11++;
                        iIsMatch2 += variablePrefixMatcher.isMatch(cArr, iIsMatch2, i, i6);
                    }
                }
                zIsEnableSubstitutionInVariables = z;
                variableSuffixMatcher = strMatcher;
                escapeChar = c;
                zIsDisableSubstitutionInValues = z2;
            }
            arrayList = arrayList;
            zIsEnableSubstitutionInVariables = z;
            variableSuffixMatcher = strMatcher;
            escapeChar = c;
            zIsDisableSubstitutionInValues = z2;
        }
        return z3 ? i8 : i7;
    }

    public boolean replaceIn(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i, i2);
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (str != null && !str.isEmpty()) {
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        setValueDelimiterMatcher(null);
        return this;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        Validate.isTrue(str != null, "Variable prefix must not be null!", new Object[0]);
        return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
    }

    public StrSubstitutor setVariableSuffix(String str) {
        Validate.isTrue(str != null, "Variable suffix must not be null!", new Object[0]);
        return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        return replace(obj, (Map) properties.stringPropertyNames().stream().collect(Collectors.toMap(Function.identity(), new C0332a(properties, 23))));
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c);
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(strBuilderAppend, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, strBuilderAppend.toString());
        return true;
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c, str3);
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(cArr.length).append(cArr);
        substitute(strBuilderAppend, 0, cArr.length);
        return strBuilderAppend.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    public boolean replaceIn(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(sb, i, i2);
        if (!substitute(strBuilderAppend, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, strBuilderAppend.toString());
        return true;
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(cArr, i, i2);
        substitute(strBuilderAppend, 0, i2);
        return strBuilderAppend.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c, String str3) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiter(str3);
    }

    public String replace(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(charSequence, i, i2);
        substitute(strBuilderAppend, 0, i2);
        return strBuilderAppend.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder().append(obj);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c) {
        this(strLookup, strMatcher, strMatcher2, c, DEFAULT_VALUE_DELIMITER);
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c, StrMatcher strMatcher3) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(strBuilder, i, i2);
        substitute(strBuilderAppend, 0, i2);
        return strBuilderAppend.toString();
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(str, i, i2);
        if (!substitute(strBuilderAppend, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return strBuilderAppend.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i2).append(stringBuffer, i, i2);
        substitute(strBuilderAppend, 0, i2);
        return strBuilderAppend.toString();
    }
}
