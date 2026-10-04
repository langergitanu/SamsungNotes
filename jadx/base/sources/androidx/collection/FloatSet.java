package androidx.collection;

import androidx.annotation.IntRange;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J:\u0010\u0011\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0019\u001a\u00020\u0012J:\u0010\u0019\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0015H\u0086\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0007J:\u0010\u001b\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0014H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0015H\u0080\b¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020\u0015H\u0086\bJ:\u0010 \u001a\u00020\u00152!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010!\u001a\u00020\"2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\"0\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010$\u001a\u00020\"2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\"0\u0014H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010&\u001a\u00020\u0004H\u0016J\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0012J:\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020,H\u0007JT\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020,2\u0014\b\u0004\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,0\u0014H\u0087\bø\u0001\u0000J\u0006\u00102\u001a\u00020\u0012J\b\u00103\u001a\u00020*H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u0011\u0010\u000f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u0082\u0001\u00014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, m13886d2 = {"Landroidx/collection/FloatSet;", "", "()V", "_capacity", "", "_size", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "getCapacity", "()I", "elements", "", "getElements$annotations", GroupContract.Group.META_DATA, "", "getMetadata$annotations", "size", "getSize", "all", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "any", "contains", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "first", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableFloatSet;", "collection"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSet\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 3 FloatSet.kt\nandroidx/collection/FloatSetKt\n*L\n1#1,925:1\n262#1,4:926\n232#1,7:930\n243#1,3:938\n246#1,2:942\n266#1,2:944\n249#1,6:946\n268#1:952\n262#1,4:953\n232#1,7:957\n243#1,3:965\n246#1,2:969\n266#1,2:971\n249#1,6:973\n268#1:979\n232#1,7:982\n243#1,3:990\n246#1,9:994\n262#1,4:1003\n232#1,7:1007\n243#1,3:1015\n246#1,2:1019\n266#1,2:1021\n249#1,6:1023\n268#1:1029\n262#1,4:1030\n232#1,7:1034\n243#1,3:1042\n246#1,2:1046\n266#1,2:1048\n249#1,6:1050\n268#1:1056\n262#1,4:1057\n232#1,7:1061\n243#1,3:1069\n246#1,2:1073\n266#1,2:1075\n249#1,6:1077\n268#1:1083\n439#1:1084\n440#1:1088\n442#1,2:1090\n444#1,3:1093\n447#1:1099\n448#1:1103\n449#1:1105\n450#1,4:1108\n456#1:1113\n457#1,8:1115\n262#1,4:1123\n232#1,7:1127\n243#1,3:1135\n246#1,2:1139\n266#1,2:1141\n249#1,6:1143\n268#1:1149\n262#1,4:1150\n232#1,7:1154\n243#1,3:1162\n246#1,2:1166\n266#1,2:1168\n249#1,6:1170\n268#1:1176\n262#1,4:1177\n232#1,7:1181\n243#1,3:1189\n246#1,2:1193\n266#1,2:1195\n249#1,6:1197\n268#1:1203\n262#1,4:1204\n232#1,7:1208\n243#1,3:1216\n246#1,2:1220\n266#1,2:1222\n249#1,6:1224\n268#1:1230\n262#1,4:1231\n232#1,7:1235\n243#1,3:1243\n246#1,2:1247\n266#1,2:1249\n249#1,6:1251\n268#1:1257\n362#1,11:1274\n262#1,4:1285\n232#1,7:1289\n243#1,3:1297\n246#1,2:1301\n266#1:1303\n373#1,10:1304\n267#1:1314\n249#1,6:1315\n268#1:1321\n383#1,2:1322\n362#1,11:1324\n262#1,4:1335\n232#1,7:1339\n243#1,3:1347\n246#1,2:1351\n266#1:1353\n373#1,10:1354\n267#1:1364\n249#1,6:1365\n268#1:1371\n383#1,2:1372\n362#1,11:1374\n262#1,4:1385\n232#1,7:1389\n243#1,3:1397\n246#1,2:1401\n266#1:1403\n373#1,10:1404\n267#1:1414\n249#1,6:1415\n268#1:1421\n383#1,2:1422\n362#1,11:1424\n262#1,4:1435\n232#1,7:1439\n243#1,3:1447\n246#1,2:1451\n266#1:1453\n373#1,10:1454\n267#1:1464\n249#1,6:1465\n268#1:1471\n383#1,2:1472\n362#1,11:1474\n262#1,4:1485\n232#1,7:1489\n243#1,3:1497\n246#1,2:1501\n266#1:1503\n373#1,10:1504\n267#1:1514\n249#1,6:1515\n268#1:1521\n383#1,2:1522\n1956#2:937\n1820#2:941\n1956#2:964\n1820#2:968\n1956#2:980\n1820#2:981\n1956#2:989\n1820#2:993\n1956#2:1014\n1820#2:1018\n1956#2:1041\n1820#2:1045\n1956#2:1068\n1820#2:1072\n1728#2:1089\n1724#2:1092\n1925#2,3:1096\n1939#2,3:1100\n1865#2:1104\n1853#2:1106\n1847#2:1107\n1860#2:1112\n1948#2:1114\n1956#2:1134\n1820#2:1138\n1956#2:1161\n1820#2:1165\n1956#2:1188\n1820#2:1192\n1956#2:1215\n1820#2:1219\n1956#2:1242\n1820#2:1246\n1728#2:1261\n1724#2:1262\n1925#2,3:1263\n1939#2,3:1266\n1865#2:1269\n1853#2:1270\n1847#2:1271\n1860#2:1272\n1948#2:1273\n1956#2:1296\n1820#2:1300\n1956#2:1346\n1820#2:1350\n1956#2:1396\n1820#2:1400\n1956#2:1446\n1820#2:1450\n1956#2:1496\n1820#2:1500\n921#3,3:1085\n921#3,3:1258\n*S KotlinDebug\n*F\n+ 1 FloatSet.kt\nandroidx/collection/FloatSet\n*L\n203#1:926,4\n203#1:930,7\n203#1:938,3\n203#1:942,2\n203#1:944,2\n203#1:946,6\n203#1:952\n222#1:953,4\n222#1:957,7\n222#1:965,3\n222#1:969,2\n222#1:971,2\n222#1:973,6\n222#1:979\n265#1:982,7\n265#1:990,3\n265#1:994,9\n277#1:1003,4\n277#1:1007,7\n277#1:1015,3\n277#1:1019,2\n277#1:1021,2\n277#1:1023,6\n277#1:1029\n290#1:1030,4\n290#1:1034,7\n290#1:1042,3\n290#1:1046,2\n290#1:1048,2\n290#1:1050,6\n290#1:1056\n308#1:1057,4\n308#1:1061,7\n308#1:1069,3\n308#1:1073,2\n308#1:1075,2\n308#1:1077,6\n308#1:1083\n319#1:1084\n319#1:1088\n319#1:1090,2\n319#1:1093,3\n319#1:1099\n319#1:1103\n319#1:1105\n319#1:1108,4\n319#1:1113\n319#1:1115,8\n339#1:1123,4\n339#1:1127,7\n339#1:1135,3\n339#1:1139,2\n339#1:1141,2\n339#1:1143,6\n339#1:1149\n372#1:1150,4\n372#1:1154,7\n372#1:1162,3\n372#1:1166,2\n372#1:1168,2\n372#1:1170,6\n372#1:1176\n372#1:1177,4\n372#1:1181,7\n372#1:1189,3\n372#1:1193,2\n372#1:1195,2\n372#1:1197,6\n372#1:1203\n393#1:1204,4\n393#1:1208,7\n393#1:1216,3\n393#1:1220,2\n393#1:1222,2\n393#1:1224,6\n393#1:1230\n419#1:1231,4\n419#1:1235,7\n419#1:1243,3\n419#1:1247,2\n419#1:1249,2\n419#1:1251,6\n419#1:1257\n-1#1:1274,11\n-1#1:1285,4\n-1#1:1289,7\n-1#1:1297,3\n-1#1:1301,2\n-1#1:1303\n-1#1:1304,10\n-1#1:1314\n-1#1:1315,6\n-1#1:1321\n-1#1:1322,2\n-1#1:1324,11\n-1#1:1335,4\n-1#1:1339,7\n-1#1:1347,3\n-1#1:1351,2\n-1#1:1353\n-1#1:1354,10\n-1#1:1364\n-1#1:1365,6\n-1#1:1371\n-1#1:1372,2\n-1#1:1374,11\n-1#1:1385,4\n-1#1:1389,7\n-1#1:1397,3\n-1#1:1401,2\n-1#1:1403\n-1#1:1404,10\n-1#1:1414\n-1#1:1415,6\n-1#1:1421\n-1#1:1422,2\n-1#1:1424,11\n-1#1:1435,4\n-1#1:1439,7\n-1#1:1447,3\n-1#1:1451,2\n-1#1:1453\n-1#1:1454,10\n-1#1:1464\n-1#1:1465,6\n-1#1:1471\n-1#1:1472,2\n-1#1:1474,11\n-1#1:1485,4\n-1#1:1489,7\n-1#1:1497,3\n-1#1:1501,2\n-1#1:1503\n-1#1:1504,10\n-1#1:1514\n-1#1:1515,6\n-1#1:1521\n-1#1:1522,2\n203#1:937\n203#1:941\n222#1:964\n222#1:968\n238#1:980\n245#1:981\n265#1:989\n265#1:993\n277#1:1014\n277#1:1018\n290#1:1041\n290#1:1045\n308#1:1068\n308#1:1072\n319#1:1089\n319#1:1092\n319#1:1096,3\n319#1:1100,3\n319#1:1104\n319#1:1106\n319#1:1107\n319#1:1112\n319#1:1114\n339#1:1134\n339#1:1138\n372#1:1161\n372#1:1165\n372#1:1188\n372#1:1192\n393#1:1215\n393#1:1219\n419#1:1242\n419#1:1246\n440#1:1261\n443#1:1262\n446#1:1263,3\n447#1:1266,3\n448#1:1269\n449#1:1270\n449#1:1271\n453#1:1272\n456#1:1273\n-1#1:1296\n-1#1:1300\n-1#1:1346\n-1#1:1350\n-1#1:1396\n-1#1:1400\n-1#1:1446\n-1#1:1450\n-1#1:1496\n-1#1:1500\n319#1:1085,3\n439#1:1258,3\n*E\n"})
public abstract class FloatSet {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public float[] elements;

    @JvmField
    @NotNull
    public long[] metadata;

    public /* synthetic */ FloatSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String joinToString$default(FloatSet floatSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = SQLKeyword.COMMA;
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return floatSet.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(@NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128 && !predicate.invoke(Float.valueOf(fArr[(i << 3) + i4])).booleanValue()) {
                        return false;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(float element) {
        int iNumberOfTrailingZeros;
        int iHashCode = Float.hashCode(element) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i4 = this._capacity;
        int i5 = (i >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.elements[iNumberOfTrailingZeros] == element) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    @IntRange(from = 0)
    /* JADX INFO: renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FloatSet)) {
            return false;
        }
        FloatSet floatSet = (FloatSet) other;
        if (floatSet._size != this._size) {
            return false;
        }
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && !floatSet.contains(fArr[(i << 3) + i4])) {
                            return false;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    public final int findElementIndex$collection(float element) {
        int iHashCode = Float.hashCode(element) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i4 = this._capacity;
        int i5 = (i >>> 7) & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.elements[iNumberOfTrailingZeros] == element) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float first() {
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            return fArr[(i << 3) + i4];
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        throw new NoSuchElementException("The FloatSet is empty");
    }

    public final void forEach(@NotNull Function1<? super Float, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        block.invoke(Float.valueOf(fArr[(i << 3) + i4]));
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @PublishedApi
    public final void forEachIndex(@NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        AbstractC0541b.m784z(i << 3, i4, block);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @IntRange(from = 0)
    /* JADX INFO: renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i2; i4++) {
                    if ((255 & j) < 128) {
                        iHashCode = Float.hashCode(fArr[(i << 3) + i4]) + iHashCode;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    @NotNull
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private FloatSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = FloatSetKt.getEmptyFloatArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean any(@NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128 && predicate.invoke(Float.valueOf(fArr[(i << 3) + i4])).booleanValue()) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    @IntRange(from = 0)
    public final int count(@NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128 && predicate.invoke(Float.valueOf(fArr[(i << 3) + i5])).booleanValue()) {
                        i2++;
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return i2;
                }
            }
            if (i == length) {
                return i2;
            }
            i++;
        }
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0 A[PHI: r11
      0x00b0: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:28:0x0069, B:42:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ String joinToString$default(FloatSet floatSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        int i4;
        if (obj == null) {
            CharSequence separator = (i2 & 1) != 0 ? SQLKeyword.COMMA : charSequence;
            CharSequence prefix = (i2 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i2 & 4) == 0 ? charSequence3 : "";
            int i5 = (i2 & 8) != 0 ? -1 : i;
            CharSequence charSequence5 = (i2 & 16) != 0 ? "..." : charSequence4;
            Intrinsics.checkNotNullParameter(separator, "separator");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(postfix, "postfix");
            StringBuilder sbM1175u = AbstractC0622a.m1175u(charSequence5, "truncated", function1, "transform", prefix);
            float[] fArr = floatSet.elements;
            long[] jArr = floatSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i6 = 0;
                int i7 = 0;
                loop0: while (true) {
                    long j = jArr[i6];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i6 - length)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j & 255) < 128) {
                                float f = fArr[(i6 << 3) + i10];
                                if (i7 == i5) {
                                    sbM1175u.append(charSequence5);
                                    break loop0;
                                }
                                if (i7 != 0) {
                                    sbM1175u.append(separator);
                                }
                                i4 = i8;
                                sbM1175u.append((CharSequence) function1.invoke(Float.valueOf(f)));
                                i7++;
                            } else {
                                i4 = i8;
                            }
                            j >>= i4;
                            i10++;
                            i8 = i4;
                        }
                        if (i9 != i8) {
                            break;
                        }
                        if (i6 == length) {
                            break;
                        }
                        i6++;
                    }
                }
                sbM1175u.append(postfix);
            } else {
                sbM1175u.append(postfix);
            }
            String string = sbM1175u.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1174t = AbstractC0622a.m1174t(postfix, "postfix", truncated, "truncated", prefix);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i2 << 3) + i7];
                            i = i5;
                            if (i4 == limit) {
                                sbM1174t.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM1174t.append(separator);
                            }
                            sbM1174t.append(f);
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
            sbM1174t.append(postfix);
        } else {
            sbM1174t.append(postfix);
        }
        String string = sbM1174t.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float first(@NotNull Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i4];
                            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                                return f;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        throw new NoSuchElementException("Could not find a match");
    }

    @PublishedApi
    public static /* synthetic */ void getElements$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @NotNull Function1<? super Float, ? extends CharSequence> transform) {
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        StringBuilder sbM1175u = AbstractC0622a.m1175u(truncated, "truncated", transform, "transform", prefix);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i2 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i2 << 3) + i7];
                            i = i5;
                            if (i4 == limit) {
                                sbM1175u.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM1175u.append(separator);
                            }
                            sbM1175u.append(transform.invoke(Float.valueOf(f)));
                            i4++;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
            sbM1175u.append(postfix);
        } else {
            sbM1175u.append(postfix);
        }
        String string = sbM1175u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, int i, @NotNull Function1<? super Float, ? extends CharSequence> function1) {
        int i2;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1175u = AbstractC0622a.m1175u(charSequence, "postfix", function1, "transform", prefix);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            loop0: while (true) {
                long j = jArr[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i4 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i4 << 3) + i8];
                            if (i5 == i) {
                                sbM1175u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i5 != 0) {
                                sbM1175u.append(separator);
                            }
                            i2 = i6;
                            sbM1175u.append(function1.invoke(Float.valueOf(f)));
                            i5++;
                        } else {
                            i2 = i6;
                        }
                        j >>= i2;
                        i8++;
                        i6 = i2;
                    }
                    if (i7 != i6) {
                        break;
                    }
                }
                if (i4 == length) {
                    break;
                }
                i4++;
            }
            sbM1175u.append(charSequence);
        } else {
            sbM1175u.append(charSequence);
        }
        String string = sbM1175u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a A[PHI: r10
      0x007a: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0039, B:18:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, @NotNull Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sbM1175u = AbstractC0622a.m1175u(charSequence, "postfix", function1, "transform", prefix);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i << 3) + i5];
                            if (i2 == -1) {
                                sbM1175u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sbM1175u.append(separator);
                            }
                            sbM1175u.append(function1.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            sbM1175u.append(charSequence);
        } else {
            sbM1175u.append(charSequence);
        }
        String string = sbM1175u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070 A[PHI: r9
      0x0070: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0031, B:18:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence charSequence, @NotNull Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder sbM1175u = AbstractC0622a.m1175u(charSequence, "prefix", function1, "transform", charSequence);
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i5];
                            if (i2 == -1) {
                                sbM1175u.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sbM1175u.append(separator);
                            }
                            sbM1175u.append(function1.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            sbM1175u.append((CharSequence) "");
        } else {
            sbM1175u.append((CharSequence) "");
        }
        String string = sbM1175u.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073 A[PHI: r10
      0x0073: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0032, B:18:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function1<? super Float, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((j & 255) < 128) {
                            float f = fArr[(i << 3) + i5];
                            if (i2 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(separator);
                            }
                            sb.append(transform.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[PHI: r9
      0x006b: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x002a, B:18:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String joinToString(@NotNull Function1<? super Float, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        float[] fArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            float f = fArr[(i << 3) + i5];
                            if (i2 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append((CharSequence) SQLKeyword.COMMA);
                            }
                            sb.append(transform.invoke(Float.valueOf(f)));
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
