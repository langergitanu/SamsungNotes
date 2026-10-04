package com.vladsch.flexmark.util.sequence;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PlaceholderReplacer {
    public static <T> void replaceAll(Collection<T> collection, Function<String, String> function, char c, char c2, Function<T, String> function2, BiConsumer<T, String> biConsumer) {
        if (collection.isEmpty()) {
            return;
        }
        StringBuilder sb = null;
        for (T t : collection) {
            String strApply = function2.apply(t);
            int length = strApply.length();
            int i = 0;
            StringBuilder sb2 = null;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (sb == null) {
                    int iIndexOf = strApply.indexOf(c, i);
                    if (iIndexOf != -1) {
                        sb = new StringBuilder();
                        if (i < iIndexOf) {
                            if (sb2 == null) {
                                sb2 = new StringBuilder();
                            }
                            sb2.append(strApply.substring(i, iIndexOf));
                        }
                        i = iIndexOf + 1;
                        if (i >= length && sb2 == null) {
                            biConsumer.accept(t, "");
                        }
                    } else if (i > 0) {
                        if (sb2 != null) {
                            sb2.append(strApply.substring(i));
                        } else {
                            biConsumer.accept(t, strApply.substring(i));
                        }
                    }
                } else {
                    int iIndexOf2 = strApply.indexOf(c2, i);
                    if (iIndexOf2 == -1) {
                        sb.append(strApply.substring(i));
                        if (sb2 == null) {
                            biConsumer.accept(t, "");
                        }
                        i = length;
                    } else {
                        sb.append(strApply.substring(i, iIndexOf2));
                        int i2 = iIndexOf2 + 1;
                        String string = sb.toString();
                        String strApply2 = function.apply(string);
                        if (strApply2 == null) {
                            strApply2 = c + string + c2;
                        }
                        if (sb2 == null) {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(strApply2);
                        sb = null;
                        i = i2;
                    }
                }
            }
            if (sb2 != null) {
                biConsumer.accept(t, sb2.toString());
            }
        }
    }
}
