package org.apache.commons.collections4;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import opennlp.tools.parser.Parse;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;
import org.apache.commons.text.lookup.StringLookupFactory;
import p001A.AbstractC0000a;
import p184g4.C12014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    private static final String INDENT_STRING = "    ";

    private MapUtils() {
    }

    private static <K, R> R applyDefaultFunction(Map<? super K, ?> map, K k, BiFunction<Map<? super K, ?>, K, R> biFunction, Function<K, R> function) {
        return (R) applyDefaultFunction(map, k, biFunction, function, null);
    }

    private static <K, R> R applyDefaultValue(Map<? super K, ?> map, K k, BiFunction<Map<? super K, ?>, K, R> biFunction, R r) {
        R rApply = (map == null || biFunction == null) ? null : biFunction.apply(map, k);
        return rApply == null ? r : rApply;
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), true);
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        return FixedSizeMap.fixedSizeMap(map);
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return FixedSizeSortedMap.fixedSizeSortedMap(sortedMap);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k) {
        return Boolean.TRUE.equals(getBoolean(map, k));
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Byte ? (Byte) number : Byte.valueOf(number.byteValue());
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k) {
        return ((Number) applyDefaultValue(map, k, new C12014a(15), 0)).byteValue();
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Double ? (Double) number : Double.valueOf(number.doubleValue());
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k) {
        return ((Double) applyDefaultValue(map, k, new C12014a(13), Double.valueOf(0.0d))).doubleValue();
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Float ? (Float) number : Float.valueOf(number.floatValue());
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k) {
        return ((Float) applyDefaultValue(map, k, new C12014a(9), Float.valueOf(0.0f))).floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k) {
        return ((Integer) applyDefaultValue(map, k, new C12014a(14), 0)).intValue();
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Integer ? (Integer) number : Integer.valueOf(number.intValue());
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Long ? (Long) number : Long.valueOf(number.longValue());
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k) {
        return ((Long) applyDefaultValue(map, k, new C12014a(10), 0L)).longValue();
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(k);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static <K, V> V getObject(Map<? super K, V> map, K k) {
        if (map != null) {
            return map.get(k);
        }
        return null;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        return number instanceof Short ? (Short) number : Short.valueOf(number.shortValue());
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k) {
        return ((Number) applyDefaultValue(map, k, new C12014a(16), 0)).shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        Objects.requireNonNull(map, "map");
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
        return map2;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        Objects.requireNonNull(map, "map");
        return map instanceof IterableMap ? (IterableMap) map : new AbstractMapDecorator<K, V>(map) { // from class: org.apache.commons.collections4.MapUtils.1
        };
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        Objects.requireNonNull(sortedMap, "sortedMap");
        return sortedMap instanceof IterableSortedMap ? (IterableSortedMap) sortedMap : new AbstractSortedMapDecorator<K, V>(sortedMap) { // from class: org.apache.commons.collections4.MapUtils.2
        };
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return LazyMap.lazyMap(map, factory);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return LazySortedMap.lazySortedMap(sortedMap, factory);
    }

    @Deprecated
    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return MultiValueMap.multiValueMap(map);
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        return ListOrderedMap.listOrderedMap(map);
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e : iterable) {
            map.put(transformer.apply(e), transformer2.apply(e));
        }
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedMap.predicatedMap(map, predicate, predicate2);
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedSortedMap.predicatedSortedMap(sortedMap, predicate, predicate2);
    }

    private static void printIndent(PrintStream printStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print(INDENT_STRING);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] objArr) {
        Objects.requireNonNull(map, "map");
        if (objArr != null && objArr.length != 0) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                int length = objArr.length;
                while (i < length) {
                    Map.Entry entry = (Map.Entry) objArr[i];
                    map.put(entry.getKey(), entry.getValue());
                    i++;
                }
            } else if (obj instanceof KeyValue) {
                int length2 = objArr.length;
                while (i < length2) {
                    KeyValue keyValue = (KeyValue) objArr[i];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i++;
                }
            } else if (obj instanceof Object[]) {
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    Object[] objArr2 = (Object[]) objArr[i2];
                    if (objArr2 == null || objArr2.length < 2) {
                        throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Invalid array element: "));
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i < objArr.length - 1) {
                    int i4 = i + 1;
                    Object obj2 = objArr[i];
                    i += 2;
                    map.put(obj2, objArr[i4]);
                }
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void safeAddToMap(Map<? super K, Object> map, K k, Object obj) {
        Objects.requireNonNull(map, "map");
        if (obj == null) {
            obj = "";
        }
        map.put(k, obj);
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return Collections.synchronizedMap(map);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map<String, Object> toMap(ResourceBundle resourceBundle) {
        Objects.requireNonNull(resourceBundle, StringLookupFactory.KEY_RESOURCE_BUNDLE);
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap map = new HashMap();
        while (keys.hasMoreElements()) {
            String strNextElement = keys.nextElement();
            map.put(strNextElement, resourceBundle.getObject(strNextElement));
        }
        return map;
    }

    public static <K, V> Properties toProperties(Map<K, V> map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMap.transformingMap(map, transformer, transformer2);
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedSortedMap.transformingSortedMap(sortedMap, transformer, transformer2);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return UnmodifiableMap.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), false);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map<?, ?> map, Deque<Map<?, ?>> deque, boolean z) {
        printIndent(printStream, deque.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, deque.size());
        printStream.println(Parse.BRACKET_LCB);
        deque.addLast(map);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof Map) || deque.contains(value)) {
                printIndent(printStream, deque.size());
                printStream.print(key);
                printStream.print(" = ");
                int iIndexOf = IterableUtils.indexOf(deque, PredicateUtils.equalPredicate(value));
                if (iIndexOf == -1) {
                    printStream.print(value);
                } else if (deque.size() - 1 == iIndexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuilder sb = new StringBuilder("(ancestor[");
                    sb.append(((deque.size() - 1) - iIndexOf) - 1);
                    sb.append("] Map)");
                    printStream.print(sb.toString());
                }
                if (!z || value == null) {
                    printStream.println();
                } else {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                }
            } else {
                if (key == null) {
                    key = "null";
                }
                verbosePrintInternal(printStream, key, (Map) value, deque, z);
            }
        }
        deque.removeLast();
        printIndent(printStream, deque.size());
        printStream.println(z ? "} ".concat(map.getClass().getName()) : "}");
    }

    private static <K, R> R applyDefaultFunction(Map<? super K, ?> map, K k, BiFunction<Map<? super K, ?>, K, R> biFunction, Function<K, R> function, R r) {
        R rApply = (map == null || biFunction == null) ? null : biFunction.apply(map, k);
        if (rApply == null) {
            rApply = function != null ? function.apply(k) : null;
        }
        return rApply != null ? rApply : r;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k, boolean z) {
        return ((Boolean) applyDefaultValue(map, k, new C12014a(7), Boolean.valueOf(z))).booleanValue();
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k, byte b) {
        return ((Byte) applyDefaultValue(map, k, new C12014a(15), Byte.valueOf(b))).byteValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k, double d) {
        return ((Double) applyDefaultValue(map, k, new C12014a(13), Double.valueOf(d))).doubleValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k, float f) {
        return ((Float) applyDefaultValue(map, k, new C12014a(9), Float.valueOf(f))).floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k, Function<K, Integer> function) {
        return ((Integer) applyDefaultFunction(map, k, new C12014a(14), function, 0)).byteValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k, Function<K, Long> function) {
        return ((Long) applyDefaultFunction(map, k, new C12014a(10), function, 0L)).byteValue();
    }

    public static <K, V> V getObject(Map<K, V> map, K k, V v) {
        V v4;
        return (map == null || (v4 = map.get(k)) == null) ? v : v4;
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k, Function<K, Short> function) {
        return ((Short) applyDefaultFunction(map, k, new C12014a(16), function, (short) 0)).shortValue();
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return LazyMap.lazyMap(map, transformer);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return LazySortedMap.lazySortedMap(sortedMap, transformer);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> cls) {
        return MultiValueMap.multiValueMap(map, cls);
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k, Function<K, Boolean> function) {
        return ((Boolean) applyDefaultFunction(map, k, new C12014a(7), function, Boolean.FALSE)).booleanValue();
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k, Function<K, Byte> function) {
        return ((Byte) applyDefaultFunction(map, k, new C12014a(15), function, (byte) 0)).byteValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k, Function<K, Double> function) {
        return ((Double) applyDefaultFunction(map, k, new C12014a(13), function, Double.valueOf(0.0d))).doubleValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k, Function<K, Float> function) {
        return ((Float) applyDefaultFunction(map, k, new C12014a(9), function, Float.valueOf(0.0f))).floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k, int i) {
        return ((Integer) applyDefaultValue(map, k, new C12014a(14), Integer.valueOf(i))).intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k, long j) {
        return ((Long) applyDefaultValue(map, k, new C12014a(10), Long.valueOf(j))).longValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k, short s) {
        return ((Short) applyDefaultValue(map, k, new C12014a(16), Short.valueOf(s))).shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k, Function<K, String> function) {
        return (String) applyDefaultFunction(map, k, new C12014a(12), function);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> factory) {
        return MultiValueMap.multiValueMap(map, factory);
    }

    public static <K, V> void populateMap(Map<K, V> map, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(map, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k, Function<K, Map<?, ?>> function) {
        return (Map) applyDefaultFunction(map, k, new C12014a(11), function);
    }

    public static <K> String getString(Map<? super K, ?> map, K k, String str) {
        return (String) applyDefaultValue(map, k, new C12014a(12), str);
    }

    public static <K, V, E> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e : iterable) {
            multiMap.put(transformer.apply(e), transformer2.apply(e));
        }
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k, Byte b) {
        return (Byte) applyDefaultValue(map, k, new C12014a(15), b);
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k, Double d) {
        return (Double) applyDefaultValue(map, k, new C12014a(13), d);
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k, Float f) {
        return (Float) applyDefaultValue(map, k, new C12014a(9), f);
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k, Function<K, Integer> function) {
        return (Integer) applyDefaultFunction(map, k, new C12014a(14), function);
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k, Function<K, Long> function) {
        return (Long) applyDefaultFunction(map, k, new C12014a(10), function);
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k, Map<?, ?> map2) {
        return (Map) applyDefaultValue(map, k, new C12014a(11), map2);
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k, Function<K, Short> function) {
        return (Short) applyDefaultFunction(map, k, new C12014a(16), function);
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k, Function<K, Byte> function) {
        return (Byte) applyDefaultFunction(map, k, new C12014a(15), function);
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k, Function<K, Double> function) {
        return (Double) applyDefaultFunction(map, k, new C12014a(13), function);
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k, Function<K, Float> function) {
        return (Float) applyDefaultFunction(map, k, new C12014a(9), function);
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k, Integer num) {
        return (Integer) applyDefaultValue(map, k, new C12014a(14), num);
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k, Long l) {
        return (Long) applyDefaultValue(map, k, new C12014a(10), l);
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k, Short sh) {
        return (Short) applyDefaultValue(map, k, new C12014a(16), sh);
    }

    public static <K, V> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap((MultiMap) multiMap, (Iterable) iterable, (Transformer) transformer, TransformerUtils.nopTransformer());
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k, Function<K, Number> function) {
        return (Number) applyDefaultFunction(map, k, new C12014a(8), function);
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k, Number number) {
        return (Number) applyDefaultValue(map, k, new C12014a(8), number);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k, Boolean bool) {
        return (Boolean) applyDefaultValue(map, k, new C12014a(7), bool);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k, Function<K, Boolean> function) {
        return (Boolean) applyDefaultFunction(map, k, new C12014a(7), function);
    }
}
