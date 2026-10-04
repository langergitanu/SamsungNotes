package com.google.android.gms.internal.drive;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.internal.drive.zzkk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;

/* JADX INFO: loaded from: classes5.dex */
final class zzlt {
    public static String zza(zzlq zzlqVar, String str) {
        StringBuilder sbM781w = AbstractC0541b.m781w("# ", str);
        zza(zzlqVar, sbM781w, 0);
        return sbM781w.toString();
    }

    private static final String zzo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzlq zzlqVar, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzlqVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strReplaceFirst = str.replaceFirst("get", "");
            boolean zBooleanValue = true;
            if (strReplaceFirst.endsWith("List") && !strReplaceFirst.endsWith("OrBuilderList") && !strReplaceFirst.equals("List")) {
                String strValueOf = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf2 = String.valueOf(strReplaceFirst.substring(1, strReplaceFirst.length() - 4));
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zza(sb, i, zzo(strConcat), zzkk.zza(method2, zzlqVar, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String strValueOf3 = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strReplaceFirst.substring(1, strReplaceFirst.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zza(sb, i, zzo(strConcat2), zzkk.zza(method3, zzlqVar, new Object[0]));
                }
            }
            if (((Method) map2.get(strReplaceFirst.length() != 0 ? FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX.concat(strReplaceFirst) : new String(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX))) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    String strValueOf5 = String.valueOf(strReplaceFirst.substring(0, strReplaceFirst.length() - 5));
                    if (!map.containsKey(strValueOf5.length() != 0 ? "get".concat(strValueOf5) : new String("get"))) {
                    }
                }
                String strValueOf6 = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf7 = String.valueOf(strReplaceFirst.substring(1));
                String strConcat3 = strValueOf7.length() != 0 ? strValueOf6.concat(strValueOf7) : new String(strValueOf6);
                Method method4 = (Method) map.get(strReplaceFirst.length() != 0 ? "get".concat(strReplaceFirst) : new String("get"));
                Method method5 = (Method) map.get(strReplaceFirst.length() != 0 ? "has".concat(strReplaceFirst) : new String("has"));
                if (method4 != null) {
                    Object objZza = zzkk.zza(method4, zzlqVar, new Object[0]);
                    if (method5 == null) {
                        if (objZza instanceof Boolean) {
                            zEquals = !((Boolean) objZza).booleanValue();
                        } else if (objZza instanceof Integer) {
                            if (((Integer) objZza).intValue() == 0) {
                            }
                        } else if (objZza instanceof Float) {
                            if (((Float) objZza).floatValue() == 0.0f) {
                            }
                        } else if (objZza instanceof Double) {
                            if (((Double) objZza).doubleValue() == 0.0d) {
                            }
                        } else if (objZza instanceof String) {
                            zEquals = objZza.equals("");
                        } else if (objZza instanceof zzjc) {
                            zEquals = objZza.equals(zzjc.zznq);
                        } else if (!(objZza instanceof zzlq) ? !(objZza instanceof Enum) || ((Enum) objZza).ordinal() != 0 : objZza != ((zzlq) objZza).zzda()) {
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) zzkk.zza(method5, zzlqVar, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        zza(sb, i, zzo(strConcat3), objZza);
                    }
                }
            }
        }
        if (zzlqVar instanceof zzkk.zzc) {
            Iterator<Map.Entry<FieldDescriptorType, Object>> it = ((zzkk.zzc) zzlqVar).zzrw.iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        zzmy zzmyVar = ((zzkk) zzlqVar).zzrq;
        if (zzmyVar != null) {
            zzmyVar.zza(sb, i);
        }
    }

    public static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzmt.zzc(zzjc.zzk((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzjc) {
            sb.append(": \"");
            sb.append(zzmt.zzc((zzjc) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkk) {
            sb.append(" {");
            zza((zzkk) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i5 = i + 2;
            zza(sb, i5, "key", entry.getKey());
            zza(sb, i5, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }
}
