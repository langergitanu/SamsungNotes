package io.opentelemetry.api.internal;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public abstract class ImmutableKeyValuePairs<K, V> {
    private final Object[] data;

    public ImmutableKeyValuePairs(Object[] objArr) {
        this.data = objArr;
    }

    private static <K> int compareToNullSafe(@Nullable K k, @Nullable K k2, Comparator<K> comparator) {
        if (k == null) {
            return k2 == null ? 0 : -1;
        }
        if (k2 == null) {
            return 1;
        }
        return comparator.compare(k, k2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K> Object[] dedupe(Object[] objArr, Comparator<K> comparator) {
        Object obj = null;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2 += 2) {
            Object obj2 = objArr[i2];
            Object obj3 = objArr[i2 + 1];
            if (obj2 != null) {
                if (obj != null && comparator.compare(obj2, obj) == 0) {
                    i -= 2;
                }
                if (obj3 == null) {
                    obj = null;
                } else {
                    int i4 = i + 1;
                    objArr[i] = obj2;
                    i += 2;
                    objArr[i4] = obj3;
                    obj = obj2;
                }
            }
        }
        if (objArr.length == i) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    private static <K> void merge(Object[] objArr, int i, int i2, int i4, Object[] objArr2, Comparator<K> comparator) {
        int i5 = i;
        int i6 = i2;
        while (i < i4) {
            if (i5 >= i2 - 1 || (i6 < i4 - 1 && compareToNullSafe(objArr[i5], objArr[i6], comparator) > 0)) {
                objArr2[i] = objArr[i6];
                objArr2[i + 1] = objArr[i6 + 1];
                i6 += 2;
            } else {
                objArr2[i] = objArr[i5];
                objArr2[i + 1] = objArr[i5 + 1];
                i5 += 2;
            }
            i += 2;
        }
    }

    private static void mergeSort(Object[] objArr, Comparator<?> comparator) {
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        splitAndMerge(objArr2, 0, objArr.length, objArr, comparator);
    }

    private static Object[] sortAndFilter(Object[] objArr, Comparator<?> comparator) {
        Utils.checkArgument(objArr.length % 2 == 0, "You must provide an even number of key/value pair arguments.");
        if (objArr.length == 0) {
            return objArr;
        }
        mergeSort(objArr, comparator);
        return dedupe(objArr, comparator);
    }

    private static void splitAndMerge(Object[] objArr, int i, int i2, Object[] objArr2, Comparator<?> comparator) {
        if (i2 - i <= 2) {
            return;
        }
        int i4 = ((i2 + i) / 4) * 2;
        splitAndMerge(objArr2, i, i4, objArr, comparator);
        splitAndMerge(objArr2, i4, i2, objArr, comparator);
        merge(objArr, i, i4, i2, objArr2, comparator);
    }

    public final Map<K, V> asMap() {
        return ReadOnlyArrayMap.wrap(data());
    }

    public final List<Object> data() {
        return Arrays.asList(this.data);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImmutableKeyValuePairs) {
            return Arrays.equals(this.data, ((ImmutableKeyValuePairs) obj).data);
        }
        return false;
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        if (biConsumer == null) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                return;
            }
            biConsumer.accept(objArr[i], objArr[i + 1]);
            i += 2;
        }
    }

    @Nullable
    public final V get(K k) {
        if (k == null) {
            return null;
        }
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                return null;
            }
            if (k.equals(objArr[i])) {
                return (V) this.data[i + 1];
            }
            i += 2;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) ^ 1000003;
    }

    public final boolean isEmpty() {
        return this.data.length == 0;
    }

    public final int size() {
        return this.data.length / 2;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                break;
            }
            Object obj = objArr[i + 1];
            if (obj instanceof String) {
                string = AbstractC1038a.m1213n('\"', (String) obj, new StringBuilder("\""));
            } else {
                string = obj.toString();
            }
            sb.append(this.data[i]);
            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            sb.append(string);
            sb.append(SQLKeyword.COMMA);
            i += 2;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }

    public ImmutableKeyValuePairs(Object[] objArr, Comparator<?> comparator) {
        this(sortAndFilter(objArr, comparator));
    }
}
