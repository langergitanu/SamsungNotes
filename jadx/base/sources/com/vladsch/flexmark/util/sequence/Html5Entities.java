package com.vladsch.flexmark.util.sequence;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Html5Entities {
    private static final String ENTITY_PATH = "/com/vladsch/flexmark/util/sequence/entities.properties";
    private static final Map<String, String> NAMED_CHARACTER_REFERENCES = readEntities();
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^&#[Xx]?");

    public static BasedSequence entityToSequence(BasedSequence basedSequence) {
        Matcher matcher = NUMERIC_PATTERN.matcher(basedSequence);
        BasedSequence basedSequenceSubSequence = basedSequence.subSequence(0, 0);
        if (!matcher.find()) {
            String str = NAMED_CHARACTER_REFERENCES.get(basedSequence.subSequence(1, basedSequence.length() - 1).toString());
            return str != null ? PrefixedSubSequence.prefixOf(str, basedSequenceSubSequence) : basedSequence;
        }
        try {
            int i = Integer.parseInt(basedSequence.subSequence(matcher.end(), basedSequence.length() - 1).toString(), matcher.end() == 2 ? 10 : 16);
            return i == 0 ? PrefixedSubSequence.prefixOf(UnicodeUtils.REPLACEMENT, basedSequenceSubSequence) : PrefixedSubSequence.prefixOf(Arrays.toString(Character.toChars(i)), basedSequenceSubSequence);
        } catch (IllegalArgumentException unused) {
            return PrefixedSubSequence.prefixOf(UnicodeUtils.REPLACEMENT, basedSequenceSubSequence);
        }
    }

    public static String entityToString(String str) {
        Matcher matcher = NUMERIC_PATTERN.matcher(str);
        if (!matcher.find()) {
            String str2 = NAMED_CHARACTER_REFERENCES.get(AbstractC2322a.m1614d(1, 1, str));
            return str2 != null ? str2 : str;
        }
        try {
            int i = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
            return i == 0 ? UnicodeUtils.REPLACEMENT : new String(Character.toChars(i));
        } catch (IllegalArgumentException unused) {
            return UnicodeUtils.REPLACEMENT;
        }
    }

    private static Map<String, String> readEntities() {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream(ENTITY_PATH), StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    map.put("NewLine", "\n");
                    return map;
                }
                if (line.length() != 0) {
                    int iIndexOf = line.indexOf(MarketingConstants.REFERRER_DELIMITER_U003D);
                    map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }
}
