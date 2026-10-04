package androidx.appsearch.util;

import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BundleUtil {
    private BundleUtil() {
    }

    public static boolean bundleValueEquals(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj != null && obj2 != null) {
            if (obj.equals(obj2)) {
                return true;
            }
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle)) {
                return deepEquals((Bundle) obj, (Bundle) obj2);
            }
            if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                return Arrays.equals((int[]) obj, (int[]) obj2);
            }
            if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                return Arrays.equals((byte[]) obj, (byte[]) obj2);
            }
            if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                return Arrays.equals((char[]) obj, (char[]) obj2);
            }
            if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                return Arrays.equals((long[]) obj, (long[]) obj2);
            }
            if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                return Arrays.equals((float[]) obj, (float[]) obj2);
            }
            if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                return Arrays.equals((short[]) obj, (short[]) obj2);
            }
            if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                return Arrays.equals((double[]) obj, (double[]) obj2);
            }
            if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
            }
            if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                Object[] objArr2 = (Object[]) obj2;
                if (objArr.length != objArr2.length) {
                    return false;
                }
                if (Arrays.equals(objArr, objArr2)) {
                    return true;
                }
                for (int i = 0; i < objArr.length; i++) {
                    if (!bundleValueEquals(objArr[i], objArr2[i])) {
                        return false;
                    }
                }
                return true;
            }
            if ((obj instanceof ArrayList) && (obj2 instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = (ArrayList) obj2;
                if (arrayList.size() != arrayList2.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (!bundleValueEquals(arrayList.get(i2), arrayList2.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
            if ((obj instanceof SparseArray) && (obj2 instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) obj;
                SparseArray sparseArray2 = (SparseArray) obj2;
                if (sparseArray.size() != sparseArray2.size()) {
                    return false;
                }
                for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                    if (sparseArray.keyAt(i4) != sparseArray2.keyAt(i4) || !bundleValueEquals(sparseArray.valueAt(i4), sparseArray2.valueAt(i4))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static Bundle deepCopy(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeBundle(bundle);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.unmarshall(bArrMarshall, 0, bArrMarshall.length);
            parcelObtain.setDataPosition(0);
            return parcelObtain.readBundle(BundleUtil.class.getClassLoader());
        } finally {
            parcelObtain.recycle();
        }
    }

    public static boolean deepEquals(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if (bundle == null || bundle2 == null || bundle.size() != bundle2.size() || !bundle.keySet().equals(bundle2.keySet())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundleValueEquals(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static int deepHashCode(Bundle bundle) {
        int i;
        int i2;
        if (bundle == null) {
            return 0;
        }
        int i4 = 1;
        int[] iArr = new int[bundle.size() + 1];
        String[] strArr = (String[]) bundle.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        iArr[0] = Arrays.hashCode(strArr);
        for (String str : strArr) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                i2 = i4 + 1;
                iArr[i4] = deepHashCode((Bundle) obj);
            } else if (obj instanceof int[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((int[]) obj);
            } else if (obj instanceof byte[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((byte[]) obj);
            } else if (obj instanceof char[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((char[]) obj);
            } else if (obj instanceof long[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((long[]) obj);
            } else if (obj instanceof float[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((float[]) obj);
            } else if (obj instanceof short[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((short[]) obj);
            } else if (obj instanceof double[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((double[]) obj);
            } else if (obj instanceof boolean[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((boolean[]) obj);
            } else if (obj instanceof String[]) {
                i2 = i4 + 1;
                iArr[i4] = Arrays.hashCode((String[]) obj);
            } else {
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    int[] iArr2 = new int[objArr.length];
                    for (int i5 = 0; i5 < objArr.length; i5++) {
                        Object obj2 = objArr[i5];
                        if (obj2 instanceof Bundle) {
                            iArr2[i5] = deepHashCode((Bundle) obj2);
                        } else if (obj2 != null) {
                            iArr2[i5] = obj2.hashCode();
                        }
                    }
                    i = i4 + 1;
                    iArr[i4] = Arrays.hashCode(iArr2);
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    int[] iArr3 = new int[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        Object obj3 = arrayList.get(i6);
                        if (obj3 instanceof Bundle) {
                            iArr3[i6] = deepHashCode((Bundle) obj3);
                        } else if (obj3 != null) {
                            iArr3[i6] = obj3.hashCode();
                        }
                    }
                    i = i4 + 1;
                    iArr[i4] = Arrays.hashCode(iArr3);
                } else if (obj instanceof SparseArray) {
                    SparseArray sparseArray = (SparseArray) obj;
                    int[] iArr4 = new int[sparseArray.size() * 2];
                    for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                        int i8 = i7 * 2;
                        iArr4[i8] = sparseArray.keyAt(i7);
                        Object objValueAt = sparseArray.valueAt(i7);
                        if (objValueAt instanceof Bundle) {
                            iArr4[i8 + 1] = deepHashCode((Bundle) objValueAt);
                        } else if (objValueAt != null) {
                            iArr4[i8 + 1] = objValueAt.hashCode();
                        }
                    }
                    i = i4 + 1;
                    iArr[i4] = Arrays.hashCode(iArr4);
                } else if (obj != null) {
                    i2 = i4 + 1;
                    iArr[i4] = obj.hashCode();
                } else {
                    i = i4 + 1;
                    iArr[i4] = 0;
                }
                i4 = i;
            }
            i4 = i2;
        }
        return Arrays.hashCode(iArr);
    }
}
