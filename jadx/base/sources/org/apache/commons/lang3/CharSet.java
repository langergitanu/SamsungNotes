package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    protected static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set<CharRange> set = Collections.synchronizedSet(new HashSet());

    static {
        CharSet charSet = new CharSet(null);
        EMPTY = charSet;
        CharSet charSet2 = new CharSet("a-zA-Z");
        ASCII_ALPHA = charSet2;
        CharSet charSet3 = new CharSet("a-z");
        ASCII_ALPHA_LOWER = charSet3;
        CharSet charSet4 = new CharSet("A-Z");
        ASCII_ALPHA_UPPER = charSet4;
        CharSet charSet5 = new CharSet("0-9");
        ASCII_NUMERIC = charSet5;
        Map<String, CharSet> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = mapSynchronizedMap;
        mapSynchronizedMap.put(null, charSet);
        mapSynchronizedMap.put("", charSet);
        mapSynchronizedMap.put("a-zA-Z", charSet2);
        mapSynchronizedMap.put("A-Za-z", charSet2);
        mapSynchronizedMap.put("a-z", charSet3);
        mapSynchronizedMap.put("A-Z", charSet4);
        mapSynchronizedMap.put("0-9", charSet5);
    }

    public CharSet(String... strArr) {
        Stream.of((Object[]) strArr).forEach(new C4191n(this, 26));
    }

    public static CharSet getInstance(String... strArr) {
        CharSet charSet;
        if (strArr == null) {
            return null;
        }
        return (strArr.length != 1 || (charSet = COMMON.get(strArr[0])) == null) ? new CharSet(strArr) : charSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$contains$0(char c, CharRange charRange) {
        return charRange.contains(c);
    }

    public void add(String str) {
        if (str == null) {
            return;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 >= 4 && str.charAt(i) == '^' && str.charAt(i + 2) == '-') {
                this.set.add(CharRange.isNotIn(str.charAt(i + 1), str.charAt(i + 3)));
                i += 4;
            } else if (i2 >= 3 && str.charAt(i + 1) == '-') {
                this.set.add(CharRange.isIn(str.charAt(i), str.charAt(i + 2)));
                i += 3;
            } else if (i2 < 2 || str.charAt(i) != '^') {
                this.set.add(CharRange.m14614is(str.charAt(i)));
                i++;
            } else {
                this.set.add(CharRange.isNot(str.charAt(i + 1)));
                i += 2;
            }
        }
    }

    public boolean contains(final char c) {
        boolean zAnyMatch;
        synchronized (this.set) {
            zAnyMatch = this.set.stream().anyMatch(new Predicate() { // from class: org.apache.commons.lang3.i
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CharSet.lambda$contains$0(c, (CharRange) obj);
                }
            });
        }
        return zAnyMatch;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CharSet) {
            return this.set.equals(((CharSet) obj).set);
        }
        return false;
    }

    public CharRange[] getCharRanges() {
        return (CharRange[]) this.set.toArray(CharRange.EMPTY_ARRAY);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }
}
