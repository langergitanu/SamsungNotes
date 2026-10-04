package com.vladsch.flexmark.util.misc;

import android.graphics.ColorSpace;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.lang.reflect.Field;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BitFieldSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    static final Enum<?>[] ZERO_LENGTH_ENUM_ARRAY = new Enum[0];
    private static final long serialVersionUID = 3411599620347842686L;
    final long[] bitMasks;
    final Class<E> elementType;
    long elements = 0;
    final int totalBits;
    final E[] universe;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EnumBitFieldIterator<E extends Enum<E>> implements Iterator<E> {
        int lastReturnedIndex = -1;
        int nextIndex = -1;

        public EnumBitFieldIterator() {
            findNext();
        }

        public void findNext() {
            int i;
            BitFieldSet bitFieldSet;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                bitFieldSet = BitFieldSet.this;
                if (i >= bitFieldSet.universe.length) {
                    return;
                }
            } while ((bitFieldSet.bitMasks[i] & bitFieldSet.elements) == 0);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < BitFieldSet.this.universe.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.lastReturnedIndex;
            if (i == -1) {
                throw new IllegalStateException();
            }
            BitFieldSet bitFieldSet = BitFieldSet.this;
            bitFieldSet.elements &= ~bitFieldSet.bitMasks[i];
            this.lastReturnedIndex = -1;
        }

        @Override // java.util.Iterator
        public E next() {
            int i = this.nextIndex;
            if (i >= BitFieldSet.this.universe.length) {
                throw new NoSuchElementException();
            }
            this.lastReturnedIndex = i;
            findNext();
            return BitFieldSet.this.universe[this.lastReturnedIndex];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EnumBitSetIterator<E extends Enum<E>> implements Iterator<E> {
        long lastReturned = 0;
        long unseen;

        public EnumBitSetIterator() {
            this.unseen = BitFieldSet.this.elements;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.unseen != 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            long j = this.lastReturned;
            if (j == 0) {
                throw new IllegalStateException();
            }
            BitFieldSet bitFieldSet = BitFieldSet.this;
            bitFieldSet.elements = (~j) & bitFieldSet.elements;
            this.lastReturned = 0L;
        }

        @Override // java.util.Iterator
        public E next() {
            long j = this.unseen;
            if (j == 0) {
                throw new NoSuchElementException();
            }
            long j2 = (-j) & j;
            this.lastReturned = j2;
            this.unseen = j - j2;
            return BitFieldSet.this.universe[Long.numberOfTrailingZeros(j2)];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializationProxy<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 362491234563181265L;
        private final long bits;
        private final Class<E> elementType;

        public SerializationProxy(BitFieldSet<E> bitFieldSet) {
            this.elementType = bitFieldSet.elementType;
            this.bits = bitFieldSet.elements;
        }

        private Object readResolve() {
            BitFieldSet bitFieldSetNoneOf = BitFieldSet.noneOf(this.elementType);
            bitFieldSetNoneOf.orMask(this.bits);
            return bitFieldSetNoneOf;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UniverseLoader {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final ConcurrentHashMap<Class, Enum[]> enumUniverseMap = new ConcurrentHashMap<>();
        static final ConcurrentHashMap<Class, long[]> enumBitMasksMap = new ConcurrentHashMap<>();

        @NotNull
        public static Enum[] getUniverseSlow(Class cls) {
            Enum<?>[] enumArr;
            Enum[] enumArr2 = enumUniverseMap.get(cls);
            if (enumArr2 != null) {
                return enumArr2;
            }
            Field[] fields = cls.getFields();
            int i = 0;
            for (Field field : fields) {
                if (field.getType().isEnum()) {
                    i++;
                }
            }
            if (i > 0) {
                enumArr = new Enum[i];
                int i2 = 0;
                for (Field field2 : fields) {
                    if (field2.getType().isEnum()) {
                        enumArr[i2] = Enum.valueOf(field2.getType(), field2.getName());
                        i2++;
                    }
                }
            } else {
                enumArr = BitFieldSet.ZERO_LENGTH_ENUM_ARRAY;
            }
            enumUniverseMap.put(cls, enumArr);
            return enumArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitFieldSet(Class<E> cls, Enum<?>[] enumArr, long[] jArr) {
        this.elementType = cls;
        this.universe = enumArr;
        this.bitMasks = jArr;
        this.totalBits = getTotalBits(jArr);
    }

    public static boolean all(long j, long j2) {
        return (j & j2) == j2;
    }

    public static <E extends Enum<E>> BitFieldSet<E> allOf(Class<E> cls) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(cls);
        bitFieldSetNoneOf.addAll();
        return bitFieldSetNoneOf;
    }

    public static long andNotMask(long j, long j2) {
        return j & (~j2);
    }

    public static boolean any(long j, long j2) {
        return (j & j2) != 0;
    }

    public static <E extends Enum<E>> BitFieldSet<E> complementOf(BitFieldSet<E> bitFieldSet) {
        BitFieldSet<E> bitFieldSetCopyOf = copyOf((BitFieldSet) bitFieldSet);
        bitFieldSetCopyOf.complement();
        return bitFieldSetCopyOf;
    }

    public static <E extends Enum<E>> BitFieldSet<E> copyOf(BitFieldSet<E> bitFieldSet) {
        return bitFieldSet.m22204clone();
    }

    public static <E extends Enum<E>> long getBitField(long j, E e) {
        return getUnsignedBitField(j, e, 64, XmlErrorCodes.LONG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends Enum<E>> long[] getBitMasks(Class<E> cls) {
        long[] jArr;
        long[] jArr2 = UniverseLoader.enumBitMasksMap.get(cls);
        if (jArr2 != null) {
            return jArr2;
        }
        Enum[] universeSlow = UniverseLoader.getUniverseSlow(cls);
        int i = 0;
        if (BitField.class.isAssignableFrom(cls)) {
            jArr = new long[universeSlow.length];
            int length = universeSlow.length;
            int i2 = 0;
            while (i < length) {
                ColorSpace.Named named = universeSlow[i];
                int bits = ((BitField) named).getBits();
                if (bits <= 0) {
                    throw new IllegalArgumentException(String.format("Enum bit field %s.%s bits must be >= 1, got: %d", cls.getSimpleName(), named.name(), Integer.valueOf(bits)));
                }
                int i4 = i2 + bits;
                if (i4 > 64) {
                    throw new IllegalArgumentException(String.format("Enum bit field %s.%s bits exceed available 64 bits by %d", cls.getSimpleName(), named.name(), Integer.valueOf(i4 - 64)));
                }
                jArr[named.ordinal()] = nextBitMask(i2, bits);
                i++;
                i2 = i4;
            }
        } else {
            if (universeSlow.length > 64) {
                throw new IllegalArgumentException("Enums with more than 64 values are not supported");
            }
            jArr = new long[universeSlow.length];
            int length2 = universeSlow.length;
            while (i < length2) {
                ColorSpace.Named named2 = universeSlow[i];
                jArr[named2.ordinal()] = 1 << named2.ordinal();
                i++;
            }
        }
        UniverseLoader.enumBitMasksMap.put(cls, jArr);
        return jArr;
    }

    public static <E extends Enum<E>> long getSignedBitField(long j, E e, int i, String str) {
        Class<E> declaringClass = e.getDeclaringClass();
        long j2 = getBitMasks(declaringClass)[e.ordinal()];
        int iBitCount = Long.bitCount(j2);
        if (iBitCount <= i) {
            return (j << Long.numberOfLeadingZeros(j2)) >> (64 - iBitCount);
        }
        throw new IllegalArgumentException(String.format("Enum field %s.%s uses %d, which is more than %d available in %s", declaringClass.getSimpleName(), e.name(), Integer.valueOf(iBitCount), Integer.valueOf(i), str));
    }

    public static int getTotalBits(long[] jArr) {
        if (jArr.length == 0) {
            return 0;
        }
        return 64 - Long.numberOfLeadingZeros(jArr[jArr.length - 1]);
    }

    public static <E extends Enum<E>> E[] getUniverse(Class<E> cls) {
        return (E[]) UniverseLoader.getUniverseSlow(cls);
    }

    public static <E extends Enum<E>> long getUnsignedBitField(long j, E e, int i, String str) {
        Class<E> declaringClass = e.getDeclaringClass();
        long j2 = getBitMasks(declaringClass)[e.ordinal()];
        int iBitCount = Long.bitCount(j2);
        if (iBitCount <= i) {
            return (j & j2) >>> Long.numberOfTrailingZeros(j2);
        }
        throw new IllegalArgumentException(String.format("Enum field %s.%s uses %d, which is more than %d available in %s", declaringClass.getSimpleName(), e.name(), Integer.valueOf(iBitCount), Integer.valueOf(i), str));
    }

    public static <E extends Enum<E>> int intMask(E e) {
        long[] bitMasks = getBitMasks(e.getDeclaringClass());
        int totalBits = getTotalBits(bitMasks);
        if (totalBits <= 32) {
            return (int) bitMasks[e.ordinal()];
        }
        throw new IllegalArgumentException(String.format("Enum fields use %d, which is more than 32 available in int", Integer.valueOf(totalBits)));
    }

    public static <E extends Enum<E>> long longMask(E e) {
        return getBitMasks(e.getDeclaringClass())[e.ordinal()];
    }

    public static long nextBitMask(int i, int i2) {
        return ((-1) >>> (-i2)) << i;
    }

    public static boolean none(long j, long j2) {
        return (j & j2) == 0;
    }

    public static <E extends Enum<E>> BitFieldSet<E> noneOf(Class<E> cls) {
        if (cls.isEnum()) {
            return new BitFieldSet<>(cls, getUniverse(cls), getBitMasks(cls));
        }
        throw new ClassCastException(cls + " not an enum");
    }

    /* JADX INFO: renamed from: of */
    public static <T extends Enum<T>> BitFieldSet<T> m13383of(@NotNull Class<T> cls, long j) {
        BitFieldSet<T> bitFieldSetNoneOf = noneOf(cls);
        bitFieldSetNoneOf.orMask(j);
        return bitFieldSetNoneOf;
    }

    public static long orMask(long j, long j2) {
        return j | j2;
    }

    public static <E extends Enum<E>> BitFieldSet<E> range(E e, E e2) {
        if (e.compareTo(e2) <= 0) {
            BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
            bitFieldSetNoneOf.addRange(e, e2);
            return bitFieldSetNoneOf;
        }
        throw new IllegalArgumentException(e + " > " + e2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    public void addAll() {
        int i = this.totalBits;
        if (i != 0) {
            this.elements = (-1) >>> (-i);
        }
    }

    public void addRange(E e, E e2) {
        this.elements = ((-1) >>> ((e.ordinal() - e2.ordinal()) - 1)) << e.ordinal();
    }

    public long allBitsMask() {
        return (-1) >>> (-this.totalBits);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.elements = 0L;
    }

    public void complement() {
        int i = this.totalBits;
        if (i != 0) {
            this.elements = (~this.elements) & ((-1) >>> (-i));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> cls = obj.getClass();
        return (cls == this.elementType || cls.getSuperclass() == this.elementType) && (this.elements & this.bitMasks[((Enum) obj).ordinal()]) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (!(collection instanceof BitFieldSet)) {
            return super.containsAll(collection);
        }
        BitFieldSet bitFieldSet = (BitFieldSet) collection;
        return bitFieldSet.elementType != this.elementType ? bitFieldSet.isEmpty() : (bitFieldSet.elements & (~this.elements)) == 0;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (!(obj instanceof BitFieldSet)) {
            return super.equals(obj);
        }
        BitFieldSet bitFieldSet = (BitFieldSet) obj;
        return bitFieldSet.elementType != this.elementType ? this.elements == 0 && bitFieldSet.elements == 0 : bitFieldSet.elements == this.elements;
    }

    public long get(E e) {
        long j = this.bitMasks[e.ordinal()];
        return (this.elements & j) >>> Long.numberOfTrailingZeros(j);
    }

    public byte getByte(E e) {
        return (byte) getSigned(e, 8, "byte");
    }

    public int getInt(E e) {
        return (int) getSigned(e, 32, XmlErrorCodes.INT);
    }

    public long getLong(E e) {
        return getSigned(e, 64, XmlErrorCodes.LONG);
    }

    public short getShort(E e) {
        return (short) getSigned(e, 16, "short");
    }

    public long getSigned(E e, int i, String str) {
        return getSignedBitField(this.elements, e, i, str);
    }

    public byte getUByte(E e) {
        return (byte) getSigned(e, 8, "byte");
    }

    public int getUInt(E e) {
        return (int) getSigned(e, 32, XmlErrorCodes.INT);
    }

    public short getUShort(E e) {
        return (short) getSigned(e, 16, "short");
    }

    public long getUnsigned(E e, int i, String str) {
        return getUnsignedBitField(this.elements, e, i, str);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.elements == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return this.bitMasks.length == this.totalBits ? new EnumBitSetIterator() : new EnumBitFieldIterator();
    }

    public long mask(E e) {
        return this.bitMasks[e.ordinal()];
    }

    public boolean remove(E e, E e2) {
        return andNotMask(mask(e, e2));
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        if (!(collection instanceof BitFieldSet)) {
            return super.removeAll(collection);
        }
        BitFieldSet bitFieldSet = (BitFieldSet) collection;
        if (bitFieldSet.elementType != this.elementType) {
            return false;
        }
        long j = this.elements;
        long j2 = (~bitFieldSet.elements) & j;
        this.elements = j2;
        return j2 != j;
    }

    @Deprecated
    public boolean replaceAll(long j) {
        return setAll(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        if (!(collection instanceof BitFieldSet)) {
            return super.retainAll(collection);
        }
        BitFieldSet bitFieldSet = (BitFieldSet) collection;
        if (bitFieldSet.elementType != this.elementType) {
            boolean z = this.elements != 0;
            this.elements = 0L;
            return z;
        }
        long j = this.elements;
        long j2 = bitFieldSet.elements & j;
        this.elements = j2;
        return j2 != j;
    }

    public boolean setAll(long j) {
        long j2 = (~((-1) >>> (-this.totalBits))) & j;
        if (j2 != 0) {
            throw new IllegalArgumentException(String.format("mask %d(0b%s) value contains elements outside the universe 0b%s", Long.valueOf(j), Long.toBinaryString(j), Long.toBinaryString(j2)));
        }
        long j3 = this.elements;
        this.elements = j;
        return j3 != j;
    }

    public void setBitField(E e, long j) {
        setSigned(e, j);
    }

    public boolean setSigned(E e, long j) {
        long j2 = this.elements;
        long signed = setSigned(this.elementType, this.bitMasks, j2, e, j);
        this.elements = signed;
        return j2 != signed;
    }

    public boolean setUnsigned(E e, long j) {
        long j2 = this.elements;
        long unsigned = setUnsigned(this.elementType, this.bitMasks, j2, e, j);
        this.elements = unsigned;
        return j2 != unsigned;
    }

    public void setUnsignedField(E e, long j) {
        setUnsigned(e, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.totalBits;
    }

    public byte toByte() {
        if (this.totalBits <= 8) {
            return (byte) this.elements;
        }
        throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 8 bits available in a byte", Integer.valueOf(this.totalBits)));
    }

    public int toInt() {
        if (this.totalBits <= 32) {
            return (int) this.elements;
        }
        throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 32 bits available in an int", Integer.valueOf(this.totalBits)));
    }

    public long toLong() {
        return this.elements;
    }

    public short toShort() {
        if (this.totalBits <= 16) {
            return (short) this.elements;
        }
        throw new IllegalArgumentException(String.format("Enum fields use %d bits, which is more than 16 bits available in a short", Integer.valueOf(this.totalBits)));
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        if (this.elements == 0) {
            return this.elementType.getSimpleName().concat(": { }");
        }
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
        delimitedBuilder.append(this.elementType.getSimpleName()).append(": { ");
        for (E e : this.universe) {
            if (any(mask(e))) {
                delimitedBuilder.append(e.name());
                if ((e instanceof BitField) && ((BitField) e).getBits() > 1) {
                    delimitedBuilder.append("(").append(getLong(e)).append(")");
                }
                delimitedBuilder.mark();
            }
        }
        delimitedBuilder.unmark().append(" }");
        return delimitedBuilder.toString();
    }

    public final void typeCheck(E e) {
        Class<?> cls = e.getClass();
        if (cls == this.elementType || cls.getSuperclass() == this.elementType) {
            return;
        }
        throw new ClassCastException(cls + " != " + this.elementType);
    }

    public Object writeReplace() {
        return new SerializationProxy(this);
    }

    public static <E extends Enum<E>> BitFieldSet<E> copyOf(Collection<E> collection) {
        if (collection instanceof BitFieldSet) {
            return ((BitFieldSet) collection).m22204clone();
        }
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }
        Iterator<E> it = collection.iterator();
        BitFieldSet<E> bitFieldSetM13385of = m13385of((Enum) it.next());
        while (it.hasNext()) {
            bitFieldSetM13385of.add((Enum) it.next());
        }
        return bitFieldSetM13385of;
    }

    public static <E extends Enum<E>> int getBitField(int i, E e) {
        return (int) getUnsignedBitField(i, e, 32, XmlErrorCodes.INT);
    }

    public boolean add(E e, E e2) {
        return orMask(mask(e, e2));
    }

    public boolean all(long j) {
        long j2 = (~((-1) >>> (-this.totalBits))) & j;
        if (j2 == 0) {
            return (this.elements & j) == j;
        }
        throw new IllegalArgumentException(String.format("mask %d(0b%s) value contains elements outside the universe 0b%s", Long.valueOf(j), Long.toBinaryString(j), Long.toBinaryString(j2)));
    }

    public boolean andNotMask(long j) {
        long j2 = this.elements;
        long j3 = (~j) & j2;
        this.elements = j3;
        return j2 != j3;
    }

    public boolean any(long j) {
        return (j & this.elements) != 0;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitFieldSet<E> m22204clone() {
        try {
            return (BitFieldSet) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public long mask(E e, E e2) {
        return this.bitMasks[e.ordinal()] | this.bitMasks[e2.ordinal()];
    }

    public boolean none(long j) {
        return (j & this.elements) == 0;
    }

    public boolean orMask(long j) {
        long j2 = (~((-1) >>> (-this.totalBits))) & j;
        if (j2 != 0) {
            throw new IllegalArgumentException(String.format("bitMask %d value contains elements outside the universe %s", Long.valueOf(j), Long.toBinaryString(j2)));
        }
        long j3 = this.elements;
        long j5 = j | j3;
        this.elements = j5;
        return j3 != j5;
    }

    public boolean remove(E e, E e2, E e3) {
        return andNotMask(mask(e, e2, e3));
    }

    public void setBitField(E e, int i) {
        setSigned(e, i);
    }

    public void setUnsignedField(E e, int i) {
        setUnsigned(e, i);
    }

    public static <E extends Enum<E>> short getBitField(short s, E e) {
        return (short) getUnsignedBitField(s, e, 16, "short");
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13385of(E e) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        return bitFieldSetNoneOf;
    }

    public static <E extends Enum<E>> long setSigned(long j, E e, long j2) {
        Class<E> declaringClass = e.getDeclaringClass();
        return setSigned(declaringClass, getBitMasks(declaringClass), j, e, j2);
    }

    public static <E extends Enum<E>> long setUnsigned(long j, E e, long j2) {
        Class<E> declaringClass = e.getDeclaringClass();
        return setUnsigned(declaringClass, getBitMasks(declaringClass), j, e, j2);
    }

    public boolean add(E e, E e2, E e3) {
        return orMask(mask(e, e2, e3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        if (!(collection instanceof BitFieldSet)) {
            return super.addAll(collection);
        }
        BitFieldSet bitFieldSet = (BitFieldSet) collection;
        if (bitFieldSet.elementType != this.elementType) {
            if (bitFieldSet.isEmpty()) {
                return false;
            }
            throw new ClassCastException(bitFieldSet.elementType + " != " + this.elementType);
        }
        long j = this.elements;
        long j2 = bitFieldSet.elements | j;
        this.elements = j2;
        return j2 != j;
    }

    public boolean any(E e) {
        return any(mask(e));
    }

    public long mask(E e, E e2, E e3) {
        return this.bitMasks[e.ordinal()] | this.bitMasks[e2.ordinal()] | this.bitMasks[e3.ordinal()];
    }

    public boolean none(E e) {
        return none(mask(e));
    }

    public boolean remove(E e, E e2, E e3, E e5) {
        return andNotMask(mask(e, e2, e3, e5));
    }

    public void setBitField(E e, short s) {
        setSigned(e, s);
    }

    public void setUnsignedField(E e, short s) {
        setUnsigned(e, s);
    }

    public static <E extends Enum<E>> byte getBitField(byte b, E e) {
        return (byte) getUnsignedBitField(b, e, 8, "byte");
    }

    public boolean add(E e, E e2, E e3, E e5) {
        return orMask(mask(e, e2, e3, e5));
    }

    public boolean any(E e, E e2) {
        return any(mask(e, e2));
    }

    public long mask(E e, E e2, E e3, E e5) {
        return this.bitMasks[e.ordinal()] | this.bitMasks[e2.ordinal()] | this.bitMasks[e3.ordinal()] | this.bitMasks[e5.ordinal()];
    }

    public boolean none(E e, E e2) {
        return none(mask(e, e2));
    }

    public boolean remove(E e, E e2, E e3, E e5, E e6) {
        return andNotMask(mask(e, e2, e3, e5, e6));
    }

    public void setBitField(E e, byte b) {
        setSigned(e, b);
    }

    public void setUnsignedField(E e, byte b) {
        setUnsigned(e, b);
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13386of(E e, E e2) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        bitFieldSetNoneOf.add((Enum) e2);
        return bitFieldSetNoneOf;
    }

    public static <E extends Enum<E>> long setBitField(long j, E e, int i) {
        return setUnsigned(j, e, i);
    }

    public boolean add(E e, E e2, E e3, E e5, E e6) {
        return orMask(mask(e, e2, e3, e5, e6));
    }

    public boolean all(E e) {
        return all(mask(e));
    }

    public boolean any(E e, E e2, E e3) {
        return any(mask(e, e2, e3));
    }

    public long mask(E e, E e2, E e3, E e5, E e6) {
        return this.bitMasks[e.ordinal()] | this.bitMasks[e2.ordinal()] | this.bitMasks[e3.ordinal()] | this.bitMasks[e5.ordinal()] | this.bitMasks[e6.ordinal()];
    }

    public boolean none(E e, E e2, E e3) {
        return none(mask(e, e2, e3));
    }

    @SafeVarargs
    public final boolean remove(E... eArr) {
        return andNotMask(mask(eArr));
    }

    public static <E extends Enum<E>> int setBitField(int i, E e, int i2) {
        return (int) setUnsigned(i, e, i2);
    }

    public static <E extends Enum<E>> long setSigned(Class<E> cls, long[] jArr, long j, E e, long j2) {
        long j3 = jArr[e.ordinal()];
        int iBitCount = Long.bitCount(j3);
        long j5 = 1 << (iBitCount - 1);
        if (iBitCount < 64) {
            long j6 = -j5;
            if (j2 < j6 || j2 > j5 - 1) {
                throw new IllegalArgumentException(String.format("Enum field %s.%s is %d bit%s, value range is [%d, %d], cannot be set to %d", cls.getSimpleName(), e.name(), Integer.valueOf(iBitCount), iBitCount > 1 ? "s" : "", Long.valueOf(j6), Long.valueOf(j5 - 1), Long.valueOf(j2)));
            }
        }
        return (j3 & ((j2 << Long.numberOfTrailingZeros(j3)) ^ j)) ^ j;
    }

    public static <E extends Enum<E>> long setUnsigned(Class<E> cls, long[] jArr, long j, E e, long j2) {
        long j3 = jArr[e.ordinal()];
        int iBitCount = Long.bitCount(j3);
        long j5 = 1 << iBitCount;
        if (iBitCount < 64 && (j2 < 0 || j2 >= j5)) {
            throw new IllegalArgumentException(String.format("Enum field %s.%s is %d bit%s, value range is [0, %d), cannot be set to %d", cls.getSimpleName(), e.name(), Integer.valueOf(iBitCount), iBitCount > 1 ? "s" : "", Long.valueOf(j5 - 1), Long.valueOf(j2)));
        }
        return (j3 & ((j2 << Long.numberOfTrailingZeros(j3)) ^ j)) ^ j;
    }

    @SafeVarargs
    public final boolean add(E... eArr) {
        return orMask(mask(eArr));
    }

    public boolean all(E e, E e2) {
        return all(mask(e, e2));
    }

    public boolean any(E e, E e2, E e3, E e5) {
        return any(mask(e, e2, e3, e5));
    }

    @SafeVarargs
    public final long mask(E... eArr) {
        long j = 0;
        for (E e : eArr) {
            j |= this.bitMasks[e.ordinal()];
        }
        return j;
    }

    public boolean none(E e, E e2, E e3, E e5) {
        return none(mask(e, e2, e3, e5));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> cls = obj.getClass();
        if (cls != this.elementType && cls.getSuperclass() != this.elementType) {
            return false;
        }
        long j = this.elements;
        long j2 = (~this.bitMasks[((Enum) obj).ordinal()]) & j;
        this.elements = j2;
        return j2 != j;
    }

    public static <E extends Enum<E>> short setBitField(short s, E e, short s2) {
        return (short) setUnsigned(s, e, s2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        typeCheck(e);
        long j = this.elements;
        long j2 = j | this.bitMasks[e.ordinal()];
        this.elements = j2;
        return j2 != j;
    }

    public boolean all(E e, E e2, E e3) {
        return all(mask(e, e2, e3));
    }

    public boolean any(E e, E e2, E e3, E e5, E e6) {
        return any(mask(e, e2, e3, e5, e6));
    }

    public boolean none(E e, E e2, E e3, E e5, E e6) {
        return none(mask(e, e2, e3, e5, e6));
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13387of(E e, E e2, E e3) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        bitFieldSetNoneOf.add((Enum) e2);
        bitFieldSetNoneOf.add((Enum) e3);
        return bitFieldSetNoneOf;
    }

    public static <E extends Enum<E>> byte setBitField(byte b, E e, byte b5) {
        return (byte) setUnsigned(b, e, b5);
    }

    public boolean all(E e, E e2, E e3, E e5) {
        return all(mask(e, e2, e3, e5));
    }

    @SafeVarargs
    public final boolean any(E... eArr) {
        return any(mask(eArr));
    }

    @SafeVarargs
    public final boolean none(E... eArr) {
        return none(mask(eArr));
    }

    public boolean all(E e, E e2, E e3, E e5, E e6) {
        return all(mask(e, e2, e3, e5, e6));
    }

    @SafeVarargs
    public final boolean all(E... eArr) {
        return all(mask(eArr));
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13388of(E e, E e2, E e3, E e5) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        bitFieldSetNoneOf.add((Enum) e2);
        bitFieldSetNoneOf.add((Enum) e3);
        bitFieldSetNoneOf.add((Enum) e5);
        return bitFieldSetNoneOf;
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13389of(E e, E e2, E e3, E e5, E e6) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        bitFieldSetNoneOf.add((Enum) e2);
        bitFieldSetNoneOf.add((Enum) e3);
        bitFieldSetNoneOf.add((Enum) e5);
        bitFieldSetNoneOf.add((Enum) e6);
        return bitFieldSetNoneOf;
    }

    @SafeVarargs
    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13390of(E e, E... eArr) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(e.getDeclaringClass());
        bitFieldSetNoneOf.add((Enum) e);
        for (E e2 : eArr) {
            bitFieldSetNoneOf.add((Enum) e2);
        }
        return bitFieldSetNoneOf;
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Enum<E>> BitFieldSet<E> m13384of(@NotNull Class<E> cls, E[] eArr) {
        BitFieldSet<E> bitFieldSetNoneOf = noneOf(cls);
        for (E e : eArr) {
            bitFieldSetNoneOf.add((Enum) e);
        }
        return bitFieldSetNoneOf;
    }
}
