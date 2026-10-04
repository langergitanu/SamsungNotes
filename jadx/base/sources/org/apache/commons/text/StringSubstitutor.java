package org.apache.commons.text;

import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.Validate;
import org.apache.commons.text.lookup.StringLookup;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StringMatcher DEFAULT_PREFIX;
    public static final StringMatcher DEFAULT_SUFFIX;
    public static final StringMatcher DEFAULT_VALUE_DELIMITER;
    public static final String DEFAULT_VAR_DEFAULT = ":-";
    public static final String DEFAULT_VAR_END = "}";
    public static final String DEFAULT_VAR_START = "${";
    private boolean disableSubstitutionInValues;
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private boolean failOnUndefinedVariable;
    private StringMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StringMatcher suffixMatcher;
    private StringMatcher valueDelimiterMatcher;
    private StringLookup variableResolver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Result {
        public final boolean altered;
        public final int lengthChange;

        public String toString() {
            StringBuilder sb = new StringBuilder("Result [altered=");
            sb.append(this.altered);
            sb.append(", lengthChange=");
            return AbstractC2821a.m2223n(sb, "]", this.lengthChange);
        }

        private Result(boolean z, int i) {
            this.altered = z;
            this.lengthChange = i;
        }
    }

    static {
        StringMatcherFactory stringMatcherFactory = StringMatcherFactory.INSTANCE;
        DEFAULT_PREFIX = stringMatcherFactory.stringMatcher(DEFAULT_VAR_START);
        DEFAULT_SUFFIX = stringMatcherFactory.stringMatcher("}");
        DEFAULT_VALUE_DELIMITER = stringMatcherFactory.stringMatcher(DEFAULT_VAR_DEFAULT);
    }

    public StringSubstitutor() {
        this((StringLookup) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            TextStringBuilder textStringBuilder = new TextStringBuilder(256);
            textStringBuilder.append("Infinite loop in property interpolation of ");
            textStringBuilder.append(list.remove(0));
            textStringBuilder.append(": ");
            textStringBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(textStringBuilder.toString());
        }
    }

    public static StringSubstitutor createInterpolator() {
        return new StringSubstitutor(StringLookupFactory.INSTANCE.interpolatorStringLookup());
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StringSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StringSubstitutor(StringLookupFactory.INSTANCE.systemPropertyStringLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StringLookup getStringLookup() {
        return this.variableResolver;
    }

    public StringMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StringMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StringMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isDisableSubstitutionInValues() {
        return this.disableSubstitutionInValues;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isEnableUndefinedVariableException() {
        return this.failOnUndefinedVariable;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, TextStringBuilder textStringBuilder, int i, int i2) {
        StringLookup stringLookup = getStringLookup();
        if (stringLookup == null) {
            return null;
        }
        return stringLookup.lookup(str);
    }

    public StringSubstitutor setDisableSubstitutionInValues(boolean z) {
        this.disableSubstitutionInValues = z;
        return this;
    }

    public StringSubstitutor setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
        return this;
    }

    public StringSubstitutor setEnableUndefinedVariableException(boolean z) {
        this.failOnUndefinedVariable = z;
        return this;
    }

    public StringSubstitutor setEscapeChar(char c) {
        this.escapeChar = c;
        return this;
    }

    public StringSubstitutor setPreserveEscapes(boolean z) {
        this.preserveEscapes = z;
        return this;
    }

    public StringSubstitutor setValueDelimiter(char c) {
        return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setValueDelimiterMatcher(StringMatcher stringMatcher) {
        this.valueDelimiterMatcher = stringMatcher;
        return this;
    }

    public StringSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setVariablePrefixMatcher(StringMatcher stringMatcher) {
        Validate.isTrue(stringMatcher != null, "Variable prefix matcher must not be null!", new Object[0]);
        this.prefixMatcher = stringMatcher;
        return this;
    }

    public StringSubstitutor setVariableResolver(StringLookup stringLookup) {
        this.variableResolver = stringLookup;
        return this;
    }

    public StringSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setVariableSuffixMatcher(StringMatcher stringMatcher) {
        Validate.isTrue(stringMatcher != null, "Variable suffix matcher must not be null!", new Object[0]);
        this.suffixMatcher = stringMatcher;
        return this;
    }

    public boolean substitute(TextStringBuilder textStringBuilder, int i, int i2) {
        return substitute(textStringBuilder, i, i2, null).altered;
    }

    public String toString() {
        return "StringSubstitutor [disableSubstitutionInValues=" + this.disableSubstitutionInValues + ", enableSubstitutionInVariables=" + this.enableSubstitutionInVariables + ", enableUndefinedVariableException=" + this.failOnUndefinedVariable + ", escapeChar=" + this.escapeChar + ", prefixMatcher=" + this.prefixMatcher + ", preserveEscapes=" + this.preserveEscapes + ", suffixMatcher=" + this.suffixMatcher + ", valueDelimiterMatcher=" + this.valueDelimiterMatcher + ", variableResolver=" + this.variableResolver + "]";
    }

    public <V> StringSubstitutor(Map<String, V> map) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StringSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0148, code lost:
    
        r15 = r5;
        r11 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.commons.text.StringSubstitutor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Result substitute(TextStringBuilder textStringBuilder, int i, int i2, List<String> list) {
        StringMatcher stringMatcher;
        StringMatcher stringMatcher2;
        boolean z;
        int i4;
        char c;
        int i5;
        int iIsMatch;
        ?? r11;
        String strSubstring;
        int i6;
        int i7 = i;
        Objects.requireNonNull(textStringBuilder, "builder");
        StringMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StringMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        StringMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
        boolean zIsEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean zIsDisableSubstitutionInValues = isDisableSubstitutionInValues();
        boolean zIsEnableUndefinedVariableException = isEnableUndefinedVariableException();
        boolean zIsPreserveEscapes = isPreserveEscapes();
        int i8 = i7;
        int i9 = i7 + i2;
        int i10 = 0;
        boolean z2 = false;
        int i11 = -1;
        ?? arrayList = list;
        while (i8 < i9) {
            int iIsMatch2 = variablePrefixMatcher.isMatch(textStringBuilder, i8, i7, i9);
            if (iIsMatch2 == 0) {
                i8++;
                stringMatcher = variablePrefixMatcher;
                stringMatcher2 = variableSuffixMatcher;
                z = zIsEnableUndefinedVariableException;
                i4 = i11;
                c = escapeChar;
                arrayList = arrayList;
            } else {
                if (i8 > i7) {
                    i5 = i8 - 1;
                    z = zIsEnableUndefinedVariableException;
                    if (textStringBuilder.charAt(i5) == escapeChar) {
                        if (!zIsPreserveEscapes) {
                            int i12 = i8 + iIsMatch2;
                            c = escapeChar;
                            iIsMatch = i12;
                            int i13 = 0;
                            while (true) {
                                if (iIsMatch < i9) {
                                    stringMatcher = variablePrefixMatcher;
                                    stringMatcher2 = variableSuffixMatcher;
                                    i4 = i5;
                                    r11 = arrayList;
                                    break;
                                }
                                if (!zIsEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(textStringBuilder, iIsMatch, i7, i9) == 0) {
                                    int iIsMatch3 = variableSuffixMatcher.isMatch(textStringBuilder, iIsMatch, i7, i9);
                                    if (iIsMatch3 == 0) {
                                        iIsMatch++;
                                    } else if (i13 != 0) {
                                        i13--;
                                        iIsMatch += iIsMatch3;
                                        i7 = i;
                                        variablePrefixMatcher = variablePrefixMatcher;
                                    } else if (i5 >= 0) {
                                        textStringBuilder.deleteCharAt(i5);
                                        i10--;
                                        i9--;
                                        i8++;
                                        escapeChar = c;
                                        zIsEnableUndefinedVariableException = z;
                                        z2 = true;
                                        i11 = -1;
                                    } else {
                                        String strMidString = textStringBuilder.midString(i12, (iIsMatch - i8) - iIsMatch2);
                                        if (zIsEnableSubstitutionInVariables) {
                                            TextStringBuilder textStringBuilder2 = new TextStringBuilder(strMidString);
                                            stringMatcher2 = variableSuffixMatcher;
                                            substitute(textStringBuilder2, 0, textStringBuilder2.length());
                                            strMidString = textStringBuilder2.toString();
                                        } else {
                                            stringMatcher2 = variableSuffixMatcher;
                                        }
                                        iIsMatch += iIsMatch3;
                                        if (valueDelimiterMatcher != null) {
                                            char[] charArray = strMidString.toCharArray();
                                            i4 = i5;
                                            int i14 = 0;
                                            while (i14 < charArray.length && (zIsEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i14, i14, charArray.length) == 0)) {
                                                stringMatcher = variablePrefixMatcher;
                                                i6 = 0;
                                                if (valueDelimiterMatcher.isMatch(charArray, i14, 0, charArray.length) != 0) {
                                                    int iIsMatch4 = valueDelimiterMatcher.isMatch(charArray, i14, 0, charArray.length);
                                                    String strSubstring2 = strMidString.substring(0, i14);
                                                    strSubstring = strMidString.substring(i14 + iIsMatch4);
                                                    strMidString = strSubstring2;
                                                    break;
                                                }
                                                i14++;
                                                variablePrefixMatcher = stringMatcher;
                                            }
                                            stringMatcher = variablePrefixMatcher;
                                        } else {
                                            stringMatcher = variablePrefixMatcher;
                                            i4 = i5;
                                        }
                                        i6 = 0;
                                        strSubstring = null;
                                        if (arrayList == 0) {
                                            arrayList = new ArrayList();
                                            arrayList.add(textStringBuilder.midString(i, i2));
                                        }
                                        checkCyclicSubstitution(strMidString, arrayList);
                                        arrayList.add(strMidString);
                                        String strResolveVariable = resolveVariable(strMidString, textStringBuilder, i8, iIsMatch);
                                        if (strResolveVariable != null) {
                                            strSubstring = strResolveVariable;
                                        }
                                        if (strSubstring != null) {
                                            int length = strSubstring.length();
                                            textStringBuilder.replace(i8, iIsMatch, strSubstring);
                                            int i15 = ((!zIsDisableSubstitutionInValues ? substitute(textStringBuilder, i8, length, arrayList).lengthChange : i6) + length) - (iIsMatch - i8);
                                            iIsMatch += i15;
                                            i9 += i15;
                                            i10 += i15;
                                            z2 = true;
                                        } else if (z) {
                                            throw new IllegalArgumentException("Cannot resolve variable '" + strMidString + "' (enableSubstitutionInVariables=" + zIsEnableSubstitutionInVariables + ").");
                                        }
                                        arrayList.remove(arrayList.size() - 1);
                                        r11 = arrayList;
                                    }
                                } else {
                                    i13++;
                                    iIsMatch += variablePrefixMatcher.isMatch(textStringBuilder, iIsMatch, i7, i9);
                                }
                            }
                        } else {
                            i8++;
                            zIsEnableUndefinedVariableException = z;
                        }
                    }
                } else {
                    z = zIsEnableUndefinedVariableException;
                }
                i5 = i11;
                int i122 = i8 + iIsMatch2;
                c = escapeChar;
                iIsMatch = i122;
                int i132 = 0;
                while (true) {
                    if (iIsMatch < i9) {
                    }
                }
            }
            i7 = i;
            escapeChar = c;
            zIsEnableUndefinedVariableException = z;
            variableSuffixMatcher = stringMatcher2;
            i11 = i4;
            variablePrefixMatcher = stringMatcher;
        }
        return new Result(z2, i10);
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(textStringBuilderAppend, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, textStringBuilderAppend.toString());
        return true;
    }

    public StringSubstitutor setValueDelimiter(String str) {
        if (str != null && !str.isEmpty()) {
            return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
        }
        setValueDelimiterMatcher(null);
        return this;
    }

    public StringSubstitutor setVariablePrefix(String str) {
        Validate.isTrue(str != null, "Variable prefix must not be null!", new Object[0]);
        return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public StringSubstitutor setVariableSuffix(String str) {
        Validate.isTrue(str != null, "Variable suffix must not be null!", new Object[0]);
        return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        return replace(obj, (Map) properties.stringPropertyNames().stream().collect(Collectors.toMap(Function.identity(), new C0332a(properties, 23))));
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, c);
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2, char c, String str3) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, c, str3);
    }

    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    public StringSubstitutor(StringLookup stringLookup) {
        this(stringLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(cArr.length).append(cArr);
        substitute(textStringBuilderAppend, 0, cArr.length);
        return textStringBuilderAppend.toString();
    }

    public boolean replaceIn(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(sb, i, i2);
        if (!substitute(textStringBuilderAppend, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, textStringBuilderAppend.toString());
        return true;
    }

    public StringSubstitutor(StringLookup stringLookup, String str, String str2, char c) {
        setVariableResolver(stringLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(cArr, i, i2);
        substitute(textStringBuilderAppend, 0, i2);
        return textStringBuilderAppend.toString();
    }

    public boolean replaceIn(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return false;
        }
        return substitute(textStringBuilder, 0, textStringBuilder.length());
    }

    public boolean replaceIn(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return false;
        }
        return substitute(textStringBuilder, i, i2);
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public StringSubstitutor(StringLookup stringLookup, String str, String str2, char c, String str3) {
        setVariableResolver(stringLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiter(str3);
    }

    public String replace(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(charSequence.toString(), i, i2);
        substitute(textStringBuilderAppend, 0, i2);
        return textStringBuilderAppend.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder().append(obj);
        substitute(textStringBuilderAppend, 0, textStringBuilderAppend.length());
        return textStringBuilderAppend.toString();
    }

    public StringSubstitutor(StringLookup stringLookup, StringMatcher stringMatcher, StringMatcher stringMatcher2, char c) {
        this(stringLookup, stringMatcher, stringMatcher2, c, DEFAULT_VALUE_DELIMITER);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder(str);
        return !substitute(textStringBuilder, 0, str.length()) ? str : textStringBuilder.toString();
    }

    public StringSubstitutor(StringLookup stringLookup, StringMatcher stringMatcher, StringMatcher stringMatcher2, char c, StringMatcher stringMatcher3) {
        setVariableResolver(stringLookup);
        setVariablePrefixMatcher(stringMatcher);
        setVariableSuffixMatcher(stringMatcher2);
        setEscapeChar(c);
        setValueDelimiterMatcher(stringMatcher3);
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(str, i, i2);
        if (!substitute(textStringBuilderAppend, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return textStringBuilderAppend.toString();
    }

    public StringSubstitutor(StringSubstitutor stringSubstitutor) {
        this.disableSubstitutionInValues = stringSubstitutor.isDisableSubstitutionInValues();
        this.enableSubstitutionInVariables = stringSubstitutor.isEnableSubstitutionInVariables();
        this.failOnUndefinedVariable = stringSubstitutor.isEnableUndefinedVariableException();
        this.escapeChar = stringSubstitutor.getEscapeChar();
        this.prefixMatcher = stringSubstitutor.getVariablePrefixMatcher();
        this.preserveEscapes = stringSubstitutor.isPreserveEscapes();
        this.suffixMatcher = stringSubstitutor.getVariableSuffixMatcher();
        this.valueDelimiterMatcher = stringSubstitutor.getValueDelimiterMatcher();
        this.variableResolver = stringSubstitutor.getStringLookup();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(textStringBuilderAppend, 0, textStringBuilderAppend.length());
        return textStringBuilderAppend.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        substitute(textStringBuilderAppend, 0, i2);
        return textStringBuilderAppend.toString();
    }

    public String replace(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(textStringBuilder.length()).append(textStringBuilder);
        substitute(textStringBuilderAppend, 0, textStringBuilderAppend.length());
        return textStringBuilderAppend.toString();
    }

    public String replace(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder textStringBuilderAppend = new TextStringBuilder(i2).append(textStringBuilder, i, i2);
        substitute(textStringBuilderAppend, 0, i2);
        return textStringBuilderAppend.toString();
    }
}
