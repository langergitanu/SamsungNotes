package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import com.samsung.android.sdk.scs.base.utils.Log;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ObjectDumper {
    public static final int DEFAULT_INDENT_WIDTH = 4;
    public static final int DEFAULT_MAX_DEPTH = 16;
    private static final String EMPTY = "(empty)";
    private int indentWidth = 4;
    private int maxDepth = 16;
    private final StringBuilder result;

    /* JADX INFO: renamed from: uk.ac.ed.ph.snuggletex.internal.util.ObjectDumper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144951 {
        static final /* synthetic */ int[] $SwitchMap$uk$ac$ed$ph$snuggletex$internal$util$DumpMode;

        static {
            int[] iArr = new int[DumpMode.values().length];
            $SwitchMap$uk$ac$ed$ph$snuggletex$internal$util$DumpMode = iArr;
            try {
                iArr[DumpMode.DEEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$internal$util$DumpMode[DumpMode.TO_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$uk$ac$ed$ph$snuggletex$internal$util$DumpMode[DumpMode.IGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ObjectDumper(StringBuilder sb) {
        this.result = sb;
    }

    private void appendArray(Object[] objArr, DumpMode dumpMode, int i) {
        Class<?> componentType = objArr.getClass().getComponentType();
        StringBuilder sb = this.result;
        sb.append(componentType.getName());
        sb.append("[]@");
        sb.append(Integer.toHexString(System.identityHashCode(objArr)));
        sb.append("[");
        if (objArr.length == 0) {
            this.result.append(EMPTY);
        } else {
            this.result.append("\n");
            for (int i2 = 0; i2 < objArr.length; i2++) {
                int i4 = i + 1;
                makeIndent(i4);
                StringBuilder sb2 = this.result;
                sb2.append(i2);
                sb2.append(" => ");
                Object obj = objArr[i2];
                appendObject(obj, getElementDumpMode(obj, dumpMode), i4);
                this.result.append("\n");
            }
            makeIndent(i);
        }
        this.result.append("]");
    }

    private <E> void appendCollection(Collection<E> collection, DumpMode dumpMode, int i) {
        Class<?> cls = collection.getClass();
        StringBuilder sb = this.result;
        sb.append(cls.getName());
        sb.append("[");
        if (collection.isEmpty()) {
            this.result.append(EMPTY);
        } else {
            this.result.append("\n");
            for (E e : collection) {
                int i2 = i + 1;
                makeIndent(i2);
                appendObject(e, getElementDumpMode(e, dumpMode), i2);
                this.result.append("\n");
            }
            makeIndent(i);
        }
        this.result.append("]");
    }

    private <E> void appendList(List<E> list, DumpMode dumpMode, int i) {
        Class<?> cls = list.getClass();
        StringBuilder sb = this.result;
        sb.append(cls.getName());
        sb.append("[");
        if (list.isEmpty()) {
            this.result.append(EMPTY);
        } else {
            this.result.append("\n");
            for (int i2 = 0; i2 < list.size(); i2++) {
                E e = list.get(i2);
                int i4 = i + 1;
                makeIndent(i4);
                StringBuilder sb2 = this.result;
                sb2.append(i2);
                sb2.append(" => ");
                appendObject(e, getElementDumpMode(e, dumpMode), i4);
                this.result.append("\n");
            }
            makeIndent(i);
        }
        this.result.append("]");
    }

    private <K, V> void appendMap(Map<K, V> map, DumpMode dumpMode, int i) {
        Class<?> cls = map.getClass();
        StringBuilder sb = this.result;
        sb.append(cls.getName());
        sb.append("(");
        if (map.isEmpty()) {
            this.result.append(EMPTY);
        } else {
            this.result.append("\n");
            for (Map.Entry<K, V> entry : map.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                int i2 = i + 1;
                makeIndent(i2);
                StringBuilder sb2 = this.result;
                sb2.append(key);
                sb2.append(" => ");
                appendObject(value, getElementDumpMode(value, dumpMode), i2);
                this.result.append("\n");
            }
            makeIndent(i);
        }
        this.result.append(")");
    }

    private void appendObjectDeep(Object obj, int i) {
        String strSubstring;
        boolean z;
        Class<?> cls = obj.getClass();
        StringBuilder sb = this.result;
        sb.append(cls.getName());
        sb.append(Log.TAG_SEPARATOR);
        sb.append(Integer.toHexString(obj.hashCode()));
        sb.append("(");
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i2 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (i4 < length) {
            Method method = methods[i4];
            String name = method.getName();
            if (!name.startsWith("get") || method.getParameterTypes().length != 0 || name.equals("getClass") || name.length() <= 3) {
                if (name.startsWith("is") && method.getParameterTypes().length == 0 && name.length() > 2) {
                    strSubstring = name.substring(2);
                }
                i4++;
                i2 = 0;
            } else {
                strSubstring = name.substring(3);
            }
            ObjectDumperOptions objectDumperOptions = (ObjectDumperOptions) method.getAnnotation(ObjectDumperOptions.class);
            DumpMode dumpModeValue = objectDumperOptions != null ? objectDumperOptions.value() : null;
            if (dumpModeValue != DumpMode.IGNORE) {
                if (z2) {
                    z = z2;
                } else {
                    this.result.append("\n");
                    z = true;
                }
                int i5 = i + 1;
                makeIndent(i5);
                this.result.append(Character.toLowerCase(strSubstring.charAt(i2)));
                if (name.length() > 1) {
                    this.result.append(strSubstring.substring(1));
                }
                this.result.append(" => ");
                try {
                    Object objInvoke = method.invoke(obj, null);
                    if (dumpModeValue == null) {
                        dumpModeValue = getElementDumpMode(objInvoke, DumpMode.TO_STRING);
                    }
                    appendObject(objInvoke, dumpModeValue, i5);
                    this.result.append("\n");
                } catch (Exception e) {
                    StringBuilder sb2 = this.result;
                    sb2.append("[Caused Exception ");
                    sb2.append(e);
                    sb2.append("]");
                }
                z2 = z;
            }
            i4++;
            i2 = 0;
        }
        if (z2) {
            makeIndent(i);
        }
        this.result.append(")");
    }

    private <E> void appendSet(Set<E> set, DumpMode dumpMode, int i) {
        Class<?> cls = set.getClass();
        StringBuilder sb = this.result;
        sb.append(cls.getName());
        sb.append(Parse.BRACKET_LCB);
        if (set.isEmpty()) {
            this.result.append(EMPTY);
        } else {
            this.result.append("\n");
            for (E e : set) {
                int i2 = i + 1;
                makeIndent(i2);
                appendObject(e, getElementDumpMode(e, dumpMode), i2);
                this.result.append("\n");
            }
            makeIndent(i);
        }
        this.result.append("}");
    }

    public static String dumpObject(Object obj, DumpMode dumpMode) {
        StringBuilder sb = new StringBuilder();
        new ObjectDumper(sb).appendObject(obj, dumpMode);
        return sb.toString();
    }

    private DumpMode getElementDumpMode(Object obj, DumpMode dumpMode) {
        ObjectDumperOptions objectDumperOptions;
        return (obj == null || (objectDumperOptions = (ObjectDumperOptions) obj.getClass().getAnnotation(ObjectDumperOptions.class)) == null) ? dumpMode : objectDumperOptions.value();
    }

    private void makeIndent(int i) {
        for (int i2 = 0; i2 < i * 4; i2++) {
            this.result.append(' ');
        }
    }

    public void appendObject(Object obj) {
        DumpMode elementDumpMode = DumpMode.TO_STRING;
        if (obj != null) {
            elementDumpMode = getElementDumpMode(obj, elementDumpMode);
        }
        appendObject(obj, elementDumpMode);
    }

    public int getIndentWidth() {
        return this.indentWidth;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public void setIndentWidth(int i) {
        this.indentWidth = i;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public void appendObject(Object obj, DumpMode dumpMode) {
        ConstraintUtilities.ensureNotNull(dumpMode, "dumpMode");
        appendObject(obj, dumpMode, 0);
        this.result.append("\n");
    }

    private void appendObject(Object obj, DumpMode dumpMode, int i) {
        if (obj != null && i > this.maxDepth) {
            this.result.append("[Maximum graph depth exceeded by child Object of type " + obj.getClass() + "]");
            return;
        }
        if (dumpMode == DumpMode.IGNORE) {
            return;
        }
        if (obj == null) {
            this.result.append("null");
            return;
        }
        if (obj instanceof Object[]) {
            appendArray((Object[]) obj, dumpMode, i);
            return;
        }
        if (obj instanceof List) {
            appendList((List) obj, dumpMode, i);
            return;
        }
        if (obj instanceof Set) {
            appendSet((Set) obj, dumpMode, i);
            return;
        }
        if (obj instanceof Map) {
            appendMap((Map) obj, dumpMode, i);
            return;
        }
        if (obj instanceof Collection) {
            appendCollection((Collection) obj, dumpMode, i);
            return;
        }
        int i2 = C144951.$SwitchMap$uk$ac$ed$ph$snuggletex$internal$util$DumpMode[dumpMode.ordinal()];
        if (i2 == 1) {
            appendObjectDeep(obj, i);
            return;
        }
        if (i2 == 2) {
            this.result.append(obj.toString());
        } else {
            if (i2 == 3) {
                return;
            }
            throw new IllegalStateException("Unexpected DumpMode " + dumpMode);
        }
    }
}
