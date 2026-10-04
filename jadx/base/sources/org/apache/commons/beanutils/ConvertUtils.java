package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConvertUtils {
    @Deprecated
    public ConvertUtils() {
    }

    public static String convert(Object obj) {
        return ConvertUtilsBean.getInstance().convert(obj);
    }

    public static void deregister() {
        ConvertUtilsBean.getInstance().deregister();
    }

    @Deprecated
    public static boolean getDefaultBoolean() {
        return ConvertUtilsBean.getInstance().getDefaultBoolean();
    }

    @Deprecated
    public static byte getDefaultByte() {
        return ConvertUtilsBean.getInstance().getDefaultByte();
    }

    @Deprecated
    public static char getDefaultCharacter() {
        return ConvertUtilsBean.getInstance().getDefaultCharacter();
    }

    @Deprecated
    public static double getDefaultDouble() {
        return ConvertUtilsBean.getInstance().getDefaultDouble();
    }

    @Deprecated
    public static float getDefaultFloat() {
        return ConvertUtilsBean.getInstance().getDefaultFloat();
    }

    @Deprecated
    public static int getDefaultInteger() {
        return ConvertUtilsBean.getInstance().getDefaultInteger();
    }

    @Deprecated
    public static long getDefaultLong() {
        return ConvertUtilsBean.getInstance().getDefaultLong();
    }

    @Deprecated
    public static short getDefaultShort() {
        return ConvertUtilsBean.getInstance().getDefaultShort();
    }

    public static Converter lookup(Class<?> cls) {
        return ConvertUtilsBean.getInstance().lookup(cls);
    }

    public static <T> Class<T> primitiveToWrapper(Class<T> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : cls == Integer.TYPE ? Integer.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Boolean.TYPE ? Boolean.class : cls == Float.TYPE ? Float.class : cls == Short.TYPE ? Short.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls;
    }

    public static void register(Converter converter, Class<?> cls) {
        ConvertUtilsBean.getInstance().register(converter, cls);
    }

    @Deprecated
    public static void setDefaultBoolean(boolean z) {
        ConvertUtilsBean.getInstance().setDefaultBoolean(z);
    }

    @Deprecated
    public static void setDefaultByte(byte b) {
        ConvertUtilsBean.getInstance().setDefaultByte(b);
    }

    @Deprecated
    public static void setDefaultCharacter(char c) {
        ConvertUtilsBean.getInstance().setDefaultCharacter(c);
    }

    @Deprecated
    public static void setDefaultDouble(double d) {
        ConvertUtilsBean.getInstance().setDefaultDouble(d);
    }

    @Deprecated
    public static void setDefaultFloat(float f) {
        ConvertUtilsBean.getInstance().setDefaultFloat(f);
    }

    @Deprecated
    public static void setDefaultInteger(int i) {
        ConvertUtilsBean.getInstance().setDefaultInteger(i);
    }

    @Deprecated
    public static void setDefaultLong(long j) {
        ConvertUtilsBean.getInstance().setDefaultLong(j);
    }

    @Deprecated
    public static void setDefaultShort(short s) {
        ConvertUtilsBean.getInstance().setDefaultShort(s);
    }

    public static Object convert(Object obj, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(obj, cls);
    }

    public static void deregister(Class<?> cls) {
        ConvertUtilsBean.getInstance().deregister(cls);
    }

    public static Converter lookup(Class<?> cls, Class<?> cls2) {
        return ConvertUtilsBean.getInstance().lookup(cls, cls2);
    }

    public static Object convert(String str, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(str, cls);
    }

    public static Object convert(String[] strArr, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(strArr, cls);
    }
}
