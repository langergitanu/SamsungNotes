package com.squareup.javapoet;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.lang.model.SourceVersion;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class NameAllocator implements Cloneable {
    private final Set<String> allocatedNames;
    private final Map<Object, String> tagToName;

    public NameAllocator() {
        this(new LinkedHashSet(), new LinkedHashMap());
    }

    public static String toJavaIdentifier(String str) {
        StringBuilder sb = new StringBuilder();
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCharCount == 0 && !Character.isJavaIdentifierStart(iCodePointAt) && Character.isJavaIdentifierPart(iCodePointAt)) {
                sb.append("_");
            }
            sb.appendCodePoint(Character.isJavaIdentifierPart(iCodePointAt) ? iCodePointAt : 95);
            iCharCount += Character.charCount(iCodePointAt);
        }
        return sb.toString();
    }

    public String get(Object obj) {
        String str = this.tagToName.get(obj);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "unknown tag: "));
    }

    public String newName(String str) {
        return newName(str, UUID.randomUUID().toString());
    }

    private NameAllocator(LinkedHashSet<String> linkedHashSet, LinkedHashMap<Object, String> linkedHashMap) {
        this.allocatedNames = linkedHashSet;
        this.tagToName = linkedHashMap;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NameAllocator m22202clone() {
        return new NameAllocator(new LinkedHashSet(this.allocatedNames), new LinkedHashMap(this.tagToName));
    }

    public String newName(String str, Object obj) {
        Util.checkNotNull(str, "suggestion", new Object[0]);
        Util.checkNotNull(obj, "tag", new Object[0]);
        String javaIdentifier = toJavaIdentifier(str);
        while (true) {
            if (!SourceVersion.isKeyword(javaIdentifier) && this.allocatedNames.add(javaIdentifier)) {
                break;
            }
            javaIdentifier = AbstractC0541b.m756B(javaIdentifier, "_");
        }
        String strPut = this.tagToName.put(obj, javaIdentifier);
        if (strPut == null) {
            return javaIdentifier;
        }
        this.tagToName.put(obj, strPut);
        StringBuilder sb = new StringBuilder("tag ");
        sb.append(obj);
        sb.append(" cannot be used for both '");
        sb.append(strPut);
        sb.append("' and '");
        throw new IllegalArgumentException(AbstractC0622a.m1170p(javaIdentifier, "'", sb));
    }
}
