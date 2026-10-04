package com.google.android.gms.internal.drive;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes5.dex */
final class zzlu<T> implements zzmf<T> {
    private static final int[] zzub = new int[0];
    private static final Unsafe zzuc = zznd.zzff();
    private final int[] zzud;
    private final Object[] zzue;
    private final int zzuf;
    private final int zzug;
    private final zzlq zzuh;
    private final boolean zzui;
    private final boolean zzuj;
    private final boolean zzuk;
    private final boolean zzul;
    private final int[] zzum;
    private final int zzun;
    private final int zzuo;
    private final zzly zzup;
    private final zzla zzuq;
    private final zzmx<?, ?> zzur;
    private final zzjy<?> zzus;
    private final zzll zzut;

    private zzlu(int[] iArr, Object[] objArr, int i, int i2, zzlq zzlqVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, zzly zzlyVar, zzla zzlaVar, zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzll zzllVar) {
        this.zzud = iArr;
        this.zzue = objArr;
        this.zzuf = i;
        this.zzug = i2;
        this.zzuj = zzlqVar instanceof zzkk;
        this.zzuk = z;
        this.zzui = zzjyVar != null && zzjyVar.zze(zzlqVar);
        this.zzul = false;
        this.zzum = iArr2;
        this.zzun = i4;
        this.zzuo = i5;
        this.zzup = zzlyVar;
        this.zzuq = zzlaVar;
        this.zzur = zzmxVar;
        this.zzus = zzjyVar;
        this.zzuh = zzlqVar;
        this.zzut = zzllVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> zzlu<T> zza(Class<T> cls, zzlo zzloVar, zzly zzlyVar, zzla zzlaVar, zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzll zzllVar) {
        int i;
        int iCharAt;
        int i2;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        int i11;
        char cCharAt3;
        int i12;
        char cCharAt4;
        int i13;
        char cCharAt5;
        int i14;
        char cCharAt6;
        int i15;
        char cCharAt7;
        int i16;
        char cCharAt8;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int iObjectFieldOffset;
        int i25;
        int i26;
        Field fieldZza;
        char cCharAt9;
        int i27;
        Field fieldZza2;
        Field fieldZza3;
        int i28;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        int i32;
        char cCharAt12;
        int i33;
        char cCharAt13;
        char cCharAt14;
        if (!(zzloVar instanceof zzme)) {
            ((zzms) zzloVar).zzec();
            throw new NoSuchMethodError();
        }
        zzme zzmeVar = (zzme) zzloVar;
        int i34 = 0;
        boolean z = zzmeVar.zzec() == zzkk.zze.zzsg;
        String strZzek = zzmeVar.zzek();
        int length = strZzek.length();
        int iCharAt2 = strZzek.charAt(0);
        if (iCharAt2 >= 55296) {
            int i35 = iCharAt2 & 8191;
            int i36 = 1;
            int i37 = 13;
            while (true) {
                i = i36 + 1;
                cCharAt14 = strZzek.charAt(i36);
                if (cCharAt14 < 55296) {
                    break;
                }
                i35 |= (cCharAt14 & 8191) << i37;
                i37 += 13;
                i36 = i;
            }
            iCharAt2 = i35 | (cCharAt14 << i37);
        } else {
            i = 1;
        }
        int i38 = i + 1;
        int iCharAt3 = strZzek.charAt(i);
        if (iCharAt3 >= 55296) {
            int i39 = iCharAt3 & 8191;
            int i40 = 13;
            while (true) {
                i33 = i38 + 1;
                cCharAt13 = strZzek.charAt(i38);
                if (cCharAt13 < 55296) {
                    break;
                }
                i39 |= (cCharAt13 & 8191) << i40;
                i40 += 13;
                i38 = i33;
            }
            iCharAt3 = i39 | (cCharAt13 << i40);
            i38 = i33;
        }
        if (iCharAt3 == 0) {
            i5 = 0;
            iCharAt = 0;
            i7 = 0;
            i8 = 0;
            i4 = 0;
            iArr = zzub;
            i6 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt4 = strZzek.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i16 = i41 + 1;
                    cCharAt8 = strZzek.charAt(i41);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i16;
                }
                iCharAt4 = i42 | (cCharAt8 << i43);
                i41 = i16;
            }
            int i44 = i41 + 1;
            int iCharAt5 = strZzek.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i15 = i44 + 1;
                    cCharAt7 = strZzek.charAt(i44);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i15;
                }
                iCharAt5 = i45 | (cCharAt7 << i46);
                i44 = i15;
            }
            int i47 = i44 + 1;
            iCharAt = strZzek.charAt(i44);
            if (iCharAt >= 55296) {
                int i48 = iCharAt & 8191;
                int i49 = 13;
                while (true) {
                    i14 = i47 + 1;
                    cCharAt6 = strZzek.charAt(i47);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i14;
                }
                iCharAt = i48 | (cCharAt6 << i49);
                i47 = i14;
            }
            int i50 = i47 + 1;
            int iCharAt6 = strZzek.charAt(i47);
            if (iCharAt6 >= 55296) {
                int i51 = iCharAt6 & 8191;
                int i52 = 13;
                while (true) {
                    i13 = i50 + 1;
                    cCharAt5 = strZzek.charAt(i50);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i13;
                }
                iCharAt6 = i51 | (cCharAt5 << i52);
                i50 = i13;
            }
            int i53 = i50 + 1;
            int iCharAt7 = strZzek.charAt(i50);
            if (iCharAt7 >= 55296) {
                int i54 = iCharAt7 & 8191;
                int i55 = 13;
                while (true) {
                    i12 = i53 + 1;
                    cCharAt4 = strZzek.charAt(i53);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i12;
                }
                iCharAt7 = i54 | (cCharAt4 << i55);
                i53 = i12;
            }
            int i56 = i53 + 1;
            int iCharAt8 = strZzek.charAt(i53);
            if (iCharAt8 >= 55296) {
                int i57 = iCharAt8 & 8191;
                int i58 = 13;
                while (true) {
                    i11 = i56 + 1;
                    cCharAt3 = strZzek.charAt(i56);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i11;
                }
                iCharAt8 = i57 | (cCharAt3 << i58);
                i56 = i11;
            }
            int i59 = i56 + 1;
            int iCharAt9 = strZzek.charAt(i56);
            if (iCharAt9 >= 55296) {
                int i60 = iCharAt9 & 8191;
                int i61 = i59;
                int i62 = 13;
                while (true) {
                    i10 = i61 + 1;
                    cCharAt2 = strZzek.charAt(i61);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt2 & 8191) << i62;
                    i62 += 13;
                    i61 = i10;
                }
                iCharAt9 = i60 | (cCharAt2 << i62);
                i2 = i10;
            } else {
                i2 = i59;
            }
            int i63 = i2 + 1;
            int iCharAt10 = strZzek.charAt(i2);
            if (iCharAt10 >= 55296) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i9 = i65 + 1;
                    cCharAt = strZzek.charAt(i65);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i64 |= (cCharAt & 8191) << i66;
                    i66 += 13;
                    i65 = i9;
                }
                iCharAt10 = i64 | (cCharAt << i66);
                i63 = i9;
            }
            int[] iArr2 = new int[iCharAt10 + iCharAt8 + iCharAt9];
            i4 = (iCharAt4 << 1) + iCharAt5;
            int i67 = iCharAt7;
            iArr = iArr2;
            i5 = i67;
            i6 = iCharAt6;
            i7 = iCharAt8;
            i8 = iCharAt10;
            i34 = iCharAt4;
            i38 = i63;
        }
        int i68 = 1;
        Unsafe unsafe = zzuc;
        Object[] objArrZzel = zzmeVar.zzel();
        Class<?> cls2 = zzmeVar.zzee().getClass();
        int[] iArr3 = new int[i5 * 3];
        Object[] objArr = new Object[i5 << 1];
        int i69 = i7 + i8;
        int i70 = i69;
        int i71 = i8;
        int i72 = 0;
        int i73 = 0;
        while (i38 < length) {
            int i74 = i38 + 1;
            int iCharAt11 = strZzek.charAt(i38);
            int[] iArr4 = iArr3;
            if (iCharAt11 >= 55296) {
                int i75 = iCharAt11 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i32 = i76 + 1;
                    cCharAt12 = strZzek.charAt(i76);
                    i17 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i75 |= (cCharAt12 & 8191) << i77;
                    i77 += 13;
                    i76 = i32;
                    length = i17;
                }
                iCharAt11 = i75 | (cCharAt12 << i77);
                i18 = i32;
            } else {
                i17 = length;
                i18 = i74;
            }
            int i78 = i18 + 1;
            int iCharAt12 = strZzek.charAt(i18);
            if (iCharAt12 >= 55296) {
                int i79 = iCharAt12 & 8191;
                int i80 = i78;
                int i81 = 13;
                while (true) {
                    i30 = i80 + 1;
                    cCharAt11 = strZzek.charAt(i80);
                    i31 = i79;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i79 = i31 | ((cCharAt11 & 8191) << i81);
                    i81 += 13;
                    i80 = i30;
                }
                iCharAt12 = i31 | (cCharAt11 << i81);
                i19 = i30;
            } else {
                i19 = i78;
            }
            int i82 = i34;
            int i83 = iCharAt12 & 255;
            int i84 = iCharAt2;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i72] = i73;
                i72++;
            }
            Object[] objArr2 = objArr;
            if (i83 >= 51) {
                int i85 = i19 + 1;
                int iCharAt13 = strZzek.charAt(i19);
                char c = 55296;
                if (iCharAt13 >= 55296) {
                    int i86 = iCharAt13 & 8191;
                    int i87 = 13;
                    while (true) {
                        i29 = i85 + 1;
                        cCharAt10 = strZzek.charAt(i85);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i86 |= (cCharAt10 & 8191) << i87;
                        i87 += 13;
                        i85 = i29;
                        c = 55296;
                    }
                    iCharAt13 = i86 | (cCharAt10 << i87);
                    i85 = i29;
                }
                int i88 = i83 - 51;
                int i89 = iCharAt13;
                if (i88 == 9 || i88 == 17) {
                    objArr2[((i73 / 3) << 1) + 1] = objArrZzel[i4];
                    i4++;
                } else if (i88 == 12 && (i84 & 1) == (i28 = i68)) {
                    objArr2[((i73 / 3) << i28) + i28] = objArrZzel[i4];
                    i4++;
                }
                int i90 = i89 << 1;
                Object obj = objArrZzel[i90];
                if (obj instanceof Field) {
                    fieldZza2 = (Field) obj;
                } else {
                    fieldZza2 = zza(cls2, (String) obj);
                    objArrZzel[i90] = fieldZza2;
                }
                int i91 = i85;
                int iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza2);
                int i92 = i90 + 1;
                Object obj2 = objArrZzel[i92];
                if (obj2 instanceof Field) {
                    fieldZza3 = (Field) obj2;
                } else {
                    fieldZza3 = zza(cls2, (String) obj2);
                    objArrZzel[i92] = fieldZza3;
                }
                i25 = i4;
                i26 = iObjectFieldOffset2;
                i68 = 1;
                i21 = i6;
                i23 = i91;
                i20 = iCharAt11;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza3);
                i24 = 0;
            } else {
                int i93 = i4 + 1;
                Field fieldZza4 = zza(cls2, (String) objArrZzel[i4]);
                if (i83 == 9 || i83 == 17) {
                    i20 = iCharAt11;
                    objArr2[((i73 / 3) << 1) + 1] = fieldZza4.getType();
                } else {
                    if (i83 == 27 || i83 == 49) {
                        i20 = iCharAt11;
                        i27 = i4 + 2;
                        objArr2[((i73 / 3) << 1) + 1] = objArrZzel[i93];
                    } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                        i20 = iCharAt11;
                        if ((i84 & 1) == 1) {
                            i27 = i4 + 2;
                            objArr2[((i73 / 3) << 1) + 1] = objArrZzel[i93];
                        }
                    } else if (i83 == 50) {
                        int i94 = i71 + 1;
                        iArr[i71] = i73;
                        int i95 = (i73 / 3) << 1;
                        int i96 = i4 + 2;
                        objArr2[i95] = objArrZzel[i93];
                        if ((iCharAt12 & 2048) != 0) {
                            i22 = i4 + 3;
                            objArr2[i95 + 1] = objArrZzel[i96];
                            i20 = iCharAt11;
                            i21 = i6;
                            i71 = i94;
                        } else {
                            i21 = i6;
                            i22 = i96;
                            i71 = i94;
                            i20 = iCharAt11;
                        }
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((i84 & 1) != 1) {
                            i68 = 1;
                        } else if (i83 <= 17) {
                            int i97 = i19 + 1;
                            int iCharAt14 = strZzek.charAt(i19);
                            if (iCharAt14 >= 55296) {
                                int i98 = iCharAt14 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i23 = i97 + 1;
                                    cCharAt9 = strZzek.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i23;
                                }
                                iCharAt14 = i98 | (cCharAt9 << i99);
                            } else {
                                i23 = i97;
                            }
                            i68 = 1;
                            int i100 = (iCharAt14 / 32) + (i82 << 1);
                            Object obj3 = objArrZzel[i100];
                            if (obj3 instanceof Field) {
                                fieldZza = (Field) obj3;
                            } else {
                                fieldZza = zza(cls2, (String) obj3);
                                objArrZzel[i100] = fieldZza;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza);
                            i24 = iCharAt14 % 32;
                            if (i83 >= 18 || i83 > 49) {
                                i25 = i22;
                                i26 = iObjectFieldOffset3;
                            } else {
                                iArr[i70] = iObjectFieldOffset3;
                                i25 = i22;
                                i26 = iObjectFieldOffset3;
                                i70++;
                            }
                        } else {
                            i68 = 1;
                        }
                        i23 = i19;
                        i24 = 0;
                        iObjectFieldOffset = 0;
                        if (i83 >= 18) {
                            i25 = i22;
                            i26 = iObjectFieldOffset3;
                        }
                    } else {
                        i20 = iCharAt11;
                    }
                    i22 = i27;
                    i21 = i6;
                    int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((i84 & 1) != 1) {
                    }
                    i23 = i19;
                    i24 = 0;
                    iObjectFieldOffset = 0;
                    if (i83 >= 18) {
                    }
                }
                i21 = i6;
                i22 = i93;
                int iObjectFieldOffset322 = (int) unsafe.objectFieldOffset(fieldZza4);
                if ((i84 & 1) != 1) {
                }
                i23 = i19;
                i24 = 0;
                iObjectFieldOffset = 0;
                if (i83 >= 18) {
                }
            }
            int i101 = i73 + 1;
            iArr4[i73] = i20;
            int i102 = i73 + 2;
            String str = strZzek;
            iArr4[i101] = ((iCharAt12 & 256) != 0 ? 268435456 : 0) | ((iCharAt12 & 512) != 0 ? 536870912 : 0) | (i83 << 20) | i26;
            i73 += 3;
            iArr4[i102] = (i24 << 20) | iObjectFieldOffset;
            i6 = i21;
            i34 = i82;
            iArr3 = iArr4;
            iCharAt2 = i84;
            length = i17;
            strZzek = str;
            i38 = i23;
            i4 = i25;
            objArr = objArr2;
        }
        return new zzlu<>(iArr3, objArr, iCharAt, i6, zzmeVar.zzee(), z, false, iArr, i8, i69, zzlyVar, zzlaVar, zzmxVar, zzjyVar, zzllVar);
    }

    private final zzmf zzap(int i) {
        int i2 = (i / 3) << 1;
        zzmf zzmfVar = (zzmf) this.zzue[i2];
        if (zzmfVar != null) {
            return zzmfVar;
        }
        zzmf<T> zzmfVarZzf = zzmd.zzej().zzf((Class) this.zzue[i2 + 1]);
        this.zzue[i2] = zzmfVarZzf;
        return zzmfVarZzf;
    }

    private final Object zzaq(int i) {
        return this.zzue[(i / 3) << 1];
    }

    private final zzko zzar(int i) {
        return (zzko) this.zzue[((i / 3) << 1) + 1];
    }

    private final int zzas(int i) {
        return this.zzud[i + 1];
    }

    private final int zzat(int i) {
        return this.zzud[i + 2];
    }

    private final int zzau(int i) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, 0);
    }

    private final void zzb(T t, T t2, int i) {
        int iZzas = zzas(i);
        int i2 = this.zzud[i];
        long j = iZzas & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzo = zznd.zzo(t, j);
            Object objZzo2 = zznd.zzo(t2, j);
            if (objZzo != null && objZzo2 != null) {
                zznd.zza(t, j, zzkm.zza(objZzo, objZzo2));
                zzb(t, i2, i);
            } else if (objZzo2 != null) {
                zznd.zza(t, j, objZzo2);
                zzb(t, i2, i);
            }
        }
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zznd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zznd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zznd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zznd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zznd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zznd.zzo(t, j)).booleanValue();
    }

    private static zzmy zzo(Object obj) {
        zzkk zzkkVar = (zzkk) obj;
        zzmy zzmyVar = zzkkVar.zzrq;
        if (zzmyVar != zzmy.zzfa()) {
            return zzmyVar;
        }
        zzmy zzmyVarZzfb = zzmy.zzfb();
        zzkkVar.zzrq = zzmyVarZzfb;
        return zzmyVarZzfb;
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzud.length / 3) - 1;
        while (i2 <= length) {
            int i4 = (length + i2) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzud[i5];
            if (i == i6) {
                return i5;
            }
            if (i < i6) {
                length = i4 - 1;
            } else {
                i2 = i4 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzud.length;
        int i = 0;
        while (true) {
            boolean zZzd = true;
            if (i >= length) {
                if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
                    return false;
                }
                if (this.zzui) {
                    return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
                }
                return true;
            }
            int iZzas = zzas(i);
            long j = iZzas & 1048575;
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t, t2, i) || Double.doubleToLongBits(zznd.zzn(t, j)) != Double.doubleToLongBits(zznd.zzn(t2, j))) {
                        zZzd = false;
                    }
                    break;
                case 1:
                    if (!zzc(t, t2, i) || Float.floatToIntBits(zznd.zzm(t, j)) != Float.floatToIntBits(zznd.zzm(t2, j))) {
                    }
                    break;
                case 2:
                    if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                    }
                    break;
                case 3:
                    if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                    }
                    break;
                case 4:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 5:
                    if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                    }
                    break;
                case 6:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 7:
                    if (!zzc(t, t2, i) || zznd.zzl(t, j) != zznd.zzl(t2, j)) {
                    }
                    break;
                case 8:
                    if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                    }
                    break;
                case 9:
                    if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                    }
                    break;
                case 10:
                    if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                    }
                    break;
                case 11:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 12:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 13:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 14:
                    if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                    }
                    break;
                case 15:
                    if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                    }
                    break;
                case 16:
                    if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                    }
                    break;
                case 17:
                    if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzd = zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j));
                    break;
                case 50:
                    zZzd = zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzat = zzat(i) & 1048575;
                    if (zznd.zzj(t, jZzat) != zznd.zzj(t2, jZzat) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                    }
                    break;
            }
            if (!zZzd) {
                return false;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(T t) {
        int i;
        int iZzu;
        int i2;
        int iZzj;
        int length = this.zzud.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iZzas = zzas(i5);
            int i6 = this.zzud[i5];
            long j = 1048575 & iZzas;
            int iHashCode = 37;
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(Double.doubleToLongBits(zznd.zzn(t, j)));
                    i4 = iZzu + i;
                    break;
                case 1:
                    i = i4 * 53;
                    iZzu = Float.floatToIntBits(zznd.zzm(t, j));
                    i4 = iZzu + i;
                    break;
                case 2:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i4 = iZzu + i;
                    break;
                case 3:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i4 = iZzu + i;
                    break;
                case 4:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 5:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i4 = iZzu + i;
                    break;
                case 6:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 7:
                    i = i4 * 53;
                    iZzu = zzkm.zze(zznd.zzl(t, j));
                    i4 = iZzu + i;
                    break;
                case 8:
                    i = i4 * 53;
                    iZzu = ((String) zznd.zzo(t, j)).hashCode();
                    i4 = iZzu + i;
                    break;
                case 9:
                    Object objZzo = zznd.zzo(t, j);
                    if (objZzo != null) {
                        iHashCode = objZzo.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i = i4 * 53;
                    iZzu = zznd.zzo(t, j).hashCode();
                    i4 = iZzu + i;
                    break;
                case 11:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 12:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 13:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 14:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i4 = iZzu + i;
                    break;
                case 15:
                    i2 = i4 * 53;
                    iZzj = zznd.zzj(t, j);
                    i4 = i2 + iZzj;
                    break;
                case 16:
                    i = i4 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i4 = iZzu + i;
                    break;
                case 17:
                    Object objZzo2 = zznd.zzo(t, j);
                    if (objZzo2 != null) {
                        iHashCode = objZzo2.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    iZzu = zznd.zzo(t, j).hashCode();
                    i4 = iZzu + i;
                    break;
                case 50:
                    i = i4 * 53;
                    iZzu = zznd.zzo(t, j).hashCode();
                    i4 = iZzu + i;
                    break;
                case 51:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(Double.doubleToLongBits(zze(t, j)));
                        i4 = iZzu + i;
                    }
                    break;
                case 52:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = Float.floatToIntBits(zzf(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 53:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 54:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 55:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 56:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 57:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 58:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zze(zzi(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 59:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = ((String) zznd.zzo(t, j)).hashCode();
                        i4 = iZzu + i;
                    }
                    break;
                case 60:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i4 = iZzu + i;
                    }
                    break;
                case 61:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i4 = iZzu + i;
                    }
                    break;
                case 62:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 63:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 64:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 65:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 66:
                    if (zza(t, i6, i5)) {
                        i2 = i4 * 53;
                        iZzj = zzg(t, j);
                        i4 = i2 + iZzj;
                    }
                    break;
                case 67:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i4 = iZzu + i;
                    }
                    break;
                case 68:
                    if (zza(t, i6, i5)) {
                        i = i4 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i4 = iZzu + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.zzur.zzr(t).hashCode() + (i4 * 53);
        return this.zzui ? (iHashCode2 * 53) + this.zzus.zzb(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final T newInstance() {
        return (T) this.zzup.newInstance(this.zzuh);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzc(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzud.length; i += 3) {
            int iZzas = zzas(i);
            long j = 1048575 & iZzas;
            int i2 = this.zzud[i];
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    if (zza(t2, i)) {
                        zznd.zza(t, j, zznd.zzn(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 1:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzm(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 2:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 3:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 4:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 5:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 6:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 7:
                    if (zza(t2, i)) {
                        zznd.zza(t, j, zznd.zzl(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 8:
                    if (zza(t2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza(t2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 11:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 12:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 13:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 14:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 15:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 16:
                    if (zza(t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb(t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzuq.zza(t, t2, j);
                    break;
                case 50:
                    zzmh.zza(this.zzut, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (this.zzuk) {
            return;
        }
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.drive.zzmf
    public final int zzn(T t) {
        int i;
        int i2;
        int i4;
        boolean z;
        int iZzd;
        int iZzc;
        int iZzc2;
        int iZzk;
        int i5;
        int iZzv;
        int iZzb;
        int iZzc3;
        int i6 = 267386880;
        int i7 = 1048575;
        int i8 = 0;
        if (this.zzuk) {
            Unsafe unsafe = zzuc;
            int i9 = 0;
            int iM3192b = 0;
            while (i9 < this.zzud.length) {
                int iZzas = zzas(i9);
                int i10 = (iZzas & i6) >>> 20;
                int i11 = i6;
                int i12 = this.zzud[i9];
                long j = iZzas & 1048575;
                int i13 = (i10 < zzke.zzqh.m3243id() || i10 > zzke.zzqu.m3243id()) ? 0 : this.zzud[i9 + 2] & 1048575;
                switch (i10) {
                    case 0:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzb(i12, 0.0d);
                            iM3192b += iZzb;
                        }
                        break;
                    case 1:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzb(i12, 0.0f);
                            iM3192b += iZzb;
                        }
                        break;
                    case 2:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzd(i12, zznd.zzk(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 3:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zze(i12, zznd.zzk(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 4:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzg(i12, zznd.zzj(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 5:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzg(i12, 0L);
                            iM3192b += iZzb;
                        }
                        break;
                    case 6:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzj(i12, 0);
                            iM3192b += iZzb;
                        }
                        break;
                    case 7:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzc(i12, true);
                            iM3192b += iZzb;
                        }
                        break;
                    case 8:
                        if (zza(t, i9)) {
                            Object objZzo = zznd.zzo(t, j);
                            iZzb = objZzo instanceof zzjc ? zzjr.zzc(i12, (zzjc) objZzo) : zzjr.zzb(i12, (String) objZzo);
                            iM3192b += iZzb;
                        }
                        break;
                    case 9:
                        if (zza(t, i9)) {
                            iZzc3 = zzmh.zzc(i12, zznd.zzo(t, j), zzap(i9));
                            iM3192b += iZzc3;
                        }
                        break;
                    case 10:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzc(i12, (zzjc) zznd.zzo(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 11:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzh(i12, zznd.zzj(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 12:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzl(i12, zznd.zzj(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 13:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzk(i12, 0);
                            iM3192b += iZzb;
                        }
                        break;
                    case 14:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzh(i12, 0L);
                            iM3192b += iZzb;
                        }
                        break;
                    case 15:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzi(i12, zznd.zzj(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 16:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzf(i12, zznd.zzk(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 17:
                        if (zza(t, i9)) {
                            iZzb = zzjr.zzc(i12, (zzlq) zznd.zzo(t, j), zzap(i9));
                            iM3192b += iZzb;
                        }
                        break;
                    case 18:
                        iZzc3 = zzmh.zzw(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 19:
                        iZzc3 = zzmh.zzv(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 20:
                        iZzc3 = zzmh.zzo(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 21:
                        iZzc3 = zzmh.zzp(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 22:
                        iZzc3 = zzmh.zzs(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 23:
                        iZzc3 = zzmh.zzw(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 24:
                        iZzc3 = zzmh.zzv(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 25:
                        iZzc3 = zzmh.zzx(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 26:
                        iZzc3 = zzmh.zzc(i12, zzd(t, j));
                        iM3192b += iZzc3;
                        break;
                    case 27:
                        iZzc3 = zzmh.zzc(i12, (List<?>) zzd(t, j), zzap(i9));
                        iM3192b += iZzc3;
                        break;
                    case 28:
                        iZzc3 = zzmh.zzd(i12, (List<zzjc>) zzd(t, j));
                        iM3192b += iZzc3;
                        break;
                    case 29:
                        iZzc3 = zzmh.zzt(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 30:
                        iZzc3 = zzmh.zzr(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 31:
                        iZzc3 = zzmh.zzv(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 32:
                        iZzc3 = zzmh.zzw(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 33:
                        iZzc3 = zzmh.zzu(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 34:
                        iZzc3 = zzmh.zzq(i12, zzd(t, j), false);
                        iM3192b += iZzc3;
                        break;
                    case 35:
                        int iZzi = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzi);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzi, zzjr.zzab(i12), iZzi, iM3192b);
                        }
                        break;
                    case 36:
                        int iZzh = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzh > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzh);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzh, zzjr.zzab(i12), iZzh, iM3192b);
                        }
                        break;
                    case 37:
                        int iZza = zzmh.zza((List) unsafe.getObject(t, j));
                        if (iZza > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZza);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZza, zzjr.zzab(i12), iZza, iM3192b);
                        }
                        break;
                    case 38:
                        int iZzb2 = zzmh.zzb((List) unsafe.getObject(t, j));
                        if (iZzb2 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzb2);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzb2, zzjr.zzab(i12), iZzb2, iM3192b);
                        }
                        break;
                    case 39:
                        int iZze = zzmh.zze((List) unsafe.getObject(t, j));
                        if (iZze > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZze);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZze, zzjr.zzab(i12), iZze, iM3192b);
                        }
                        break;
                    case 40:
                        int iZzi2 = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzi2, zzjr.zzab(i12), iZzi2, iM3192b);
                        }
                        break;
                    case 41:
                        int iZzh2 = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzh2 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzh2);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzh2, zzjr.zzab(i12), iZzh2, iM3192b);
                        }
                        break;
                    case 42:
                        int iZzj = zzmh.zzj((List) unsafe.getObject(t, j));
                        if (iZzj > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzj);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzj, zzjr.zzab(i12), iZzj, iM3192b);
                        }
                        break;
                    case 43:
                        int iZzf = zzmh.zzf((List<Integer>) unsafe.getObject(t, j));
                        if (iZzf > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzf);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzf, zzjr.zzab(i12), iZzf, iM3192b);
                        }
                        break;
                    case 44:
                        int iZzd2 = zzmh.zzd((List) unsafe.getObject(t, j));
                        if (iZzd2 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzd2);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzd2, zzjr.zzab(i12), iZzd2, iM3192b);
                        }
                        break;
                    case 45:
                        int iZzh3 = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzh3 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzh3);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzh3, zzjr.zzab(i12), iZzh3, iM3192b);
                        }
                        break;
                    case 46:
                        int iZzi3 = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi3 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzi3);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzi3, zzjr.zzab(i12), iZzi3, iM3192b);
                        }
                        break;
                    case 47:
                        int iZzg = zzmh.zzg((List<Integer>) unsafe.getObject(t, j));
                        if (iZzg > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzg);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzg, zzjr.zzab(i12), iZzg, iM3192b);
                        }
                        break;
                    case 48:
                        int iZzc4 = zzmh.zzc((List) unsafe.getObject(t, j));
                        if (iZzc4 > 0) {
                            if (this.zzul) {
                                unsafe.putInt(t, i13, iZzc4);
                            }
                            iM3192b = AbstractC4539a.m3192b(iZzc4, zzjr.zzab(i12), iZzc4, iM3192b);
                        }
                        break;
                    case 49:
                        iZzc3 = zzmh.zzd(i12, zzd(t, j), zzap(i9));
                        iM3192b += iZzc3;
                        break;
                    case 50:
                        iZzc3 = this.zzut.zzb(i12, zznd.zzo(t, j), zzaq(i9));
                        iM3192b += iZzc3;
                        break;
                    case 51:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzb(i12, 0.0d);
                            iM3192b += iZzb;
                        }
                        break;
                    case 52:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzb(i12, 0.0f);
                            iM3192b += iZzb;
                        }
                        break;
                    case 53:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzd(i12, zzh(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 54:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zze(i12, zzh(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 55:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzg(i12, zzg(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 56:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzg(i12, 0L);
                            iM3192b += iZzb;
                        }
                        break;
                    case 57:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzj(i12, 0);
                            iM3192b += iZzb;
                        }
                        break;
                    case 58:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzc(i12, true);
                            iM3192b += iZzb;
                        }
                        break;
                    case 59:
                        if (zza(t, i12, i9)) {
                            Object objZzo2 = zznd.zzo(t, j);
                            iZzb = objZzo2 instanceof zzjc ? zzjr.zzc(i12, (zzjc) objZzo2) : zzjr.zzb(i12, (String) objZzo2);
                            iM3192b += iZzb;
                        }
                        break;
                    case 60:
                        if (zza(t, i12, i9)) {
                            iZzc3 = zzmh.zzc(i12, zznd.zzo(t, j), zzap(i9));
                            iM3192b += iZzc3;
                        }
                        break;
                    case 61:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzc(i12, (zzjc) zznd.zzo(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 62:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzh(i12, zzg(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 63:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzl(i12, zzg(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 64:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzk(i12, 0);
                            iM3192b += iZzb;
                        }
                        break;
                    case 65:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzh(i12, 0L);
                            iM3192b += iZzb;
                        }
                        break;
                    case 66:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzi(i12, zzg(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 67:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzf(i12, zzh(t, j));
                            iM3192b += iZzb;
                        }
                        break;
                    case 68:
                        if (zza(t, i12, i9)) {
                            iZzb = zzjr.zzc(i12, (zzlq) zznd.zzo(t, j), zzap(i9));
                            iM3192b += iZzb;
                        }
                        break;
                }
                i9 += 3;
                i6 = i11;
            }
            return iM3192b + zza(this.zzur, t);
        }
        Unsafe unsafe2 = zzuc;
        int i14 = -1;
        int i15 = 0;
        int iZzb3 = 0;
        int i16 = 0;
        while (i15 < this.zzud.length) {
            int iZzas2 = zzas(i15);
            int[] iArr = this.zzud;
            int i17 = iArr[i15];
            int i18 = i7;
            int i19 = (iZzas2 & 267386880) >>> 20;
            if (i19 <= 17) {
                i = iArr[i15 + 2];
                int i20 = i & i18;
                i2 = 1 << (i >>> 20);
                if (i20 != i14) {
                    i16 = unsafe2.getInt(t, i20);
                    i14 = i20;
                }
            } else {
                i = (!this.zzul || i19 < zzke.zzqh.m3243id() || i19 > zzke.zzqu.m3243id()) ? 0 : this.zzud[i15 + 2] & i18;
                i2 = 0;
            }
            long j2 = iZzas2 & i18;
            switch (i19) {
                case 0:
                    i4 = 0;
                    z = false;
                    if ((i16 & i2) != 0) {
                        iZzb3 += zzjr.zzb(i17, 0.0d);
                    }
                    break;
                case 1:
                    i4 = 0;
                    if ((i16 & i2) != 0) {
                        z = false;
                        iZzb3 += zzjr.zzb(i17, 0.0f);
                    } else {
                        z = false;
                    }
                    break;
                case 2:
                    i4 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzjr.zzd(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzjr.zze(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzjr.zzg(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzjr.zzg(i17, 0L);
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i16 & i2) != 0) {
                        i4 = 0;
                        iZzd = zzjr.zzj(i17, 0);
                        iZzb3 += iZzd;
                        z = false;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 7:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzc(i17, true);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 8:
                    if ((i16 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        iZzc = object instanceof zzjc ? zzjr.zzc(i17, (zzjc) object) : zzjr.zzb(i17, (String) object);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 9:
                    if ((i16 & i2) != 0) {
                        iZzc2 = zzmh.zzc(i17, unsafe2.getObject(t, j2), zzap(i15));
                        iZzb3 += iZzc2;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 10:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzc(i17, (zzjc) unsafe2.getObject(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 11:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzh(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 12:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzl(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 13:
                    if ((i16 & i2) != 0) {
                        iZzk = zzjr.zzk(i17, 0);
                        iZzb3 += iZzk;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 14:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzh(i17, 0L);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 15:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzi(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 16:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzf(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 17:
                    if ((i16 & i2) != 0) {
                        iZzc = zzjr.zzc(i17, (zzlq) unsafe2.getObject(t, j2), zzap(i15));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 18:
                    iZzc2 = zzmh.zzw(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 19:
                    i5 = 0;
                    iZzv = zzmh.zzv(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 20:
                    i5 = 0;
                    iZzv = zzmh.zzo(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 21:
                    i5 = 0;
                    iZzv = zzmh.zzp(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 22:
                    i5 = 0;
                    iZzv = zzmh.zzs(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 23:
                    i5 = 0;
                    iZzv = zzmh.zzw(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 24:
                    i5 = 0;
                    iZzv = zzmh.zzv(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 25:
                    i5 = 0;
                    iZzv = zzmh.zzx(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 26:
                    iZzc2 = zzmh.zzc(i17, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 27:
                    iZzc2 = zzmh.zzc(i17, (List<?>) unsafe2.getObject(t, j2), zzap(i15));
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 28:
                    iZzc2 = zzmh.zzd(i17, (List<zzjc>) unsafe2.getObject(t, j2));
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 29:
                    iZzc2 = zzmh.zzt(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 30:
                    i5 = 0;
                    iZzv = zzmh.zzr(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 31:
                    i5 = 0;
                    iZzv = zzmh.zzv(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 32:
                    i5 = 0;
                    iZzv = zzmh.zzw(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 33:
                    i5 = 0;
                    iZzv = zzmh.zzu(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 34:
                    i5 = 0;
                    iZzv = zzmh.zzq(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzv;
                    i4 = i5;
                    z = false;
                    break;
                case 35:
                    int iZzi4 = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi4 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi4);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzi4, zzjr.zzab(i17), iZzi4, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 36:
                    int iZzh4 = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzh4 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzh4);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzh4, zzjr.zzab(i17), iZzh4, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 37:
                    int iZza2 = zzmh.zza((List) unsafe2.getObject(t, j2));
                    if (iZza2 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZza2);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZza2, zzjr.zzab(i17), iZza2, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 38:
                    int iZzb4 = zzmh.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzb4 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzb4);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzb4, zzjr.zzab(i17), iZzb4, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 39:
                    int iZze2 = zzmh.zze((List) unsafe2.getObject(t, j2));
                    if (iZze2 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZze2);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZze2, zzjr.zzab(i17), iZze2, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 40:
                    int iZzi5 = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi5 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi5);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzi5, zzjr.zzab(i17), iZzi5, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 41:
                    int iZzh5 = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzh5 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzh5);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzh5, zzjr.zzab(i17), iZzh5, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 42:
                    int iZzj2 = zzmh.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzj2 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzj2);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzj2, zzjr.zzab(i17), iZzj2, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 43:
                    int iZzf2 = zzmh.zzf((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzf2 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzf2);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzf2, zzjr.zzab(i17), iZzf2, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 44:
                    int iZzd3 = zzmh.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzd3 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzd3);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzd3, zzjr.zzab(i17), iZzd3, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 45:
                    int iZzh6 = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzh6 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzh6);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzh6, zzjr.zzab(i17), iZzh6, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 46:
                    int iZzi6 = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi6 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi6);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzi6, zzjr.zzab(i17), iZzi6, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 47:
                    int iZzg2 = zzmh.zzg((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzg2 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzg2);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzg2, zzjr.zzab(i17), iZzg2, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 48:
                    int iZzc5 = zzmh.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzc5 > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzc5);
                        }
                        iZzb3 = AbstractC4539a.m3192b(iZzc5, zzjr.zzab(i17), iZzc5, iZzb3);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 49:
                    iZzc2 = zzmh.zzd(i17, (List) unsafe2.getObject(t, j2), zzap(i15));
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 50:
                    iZzc2 = this.zzut.zzb(i17, unsafe2.getObject(t, j2), zzaq(i15));
                    iZzb3 += iZzc2;
                    i4 = 0;
                    z = false;
                    break;
                case 51:
                    if (zza(t, i17, i15)) {
                        iZzb3 += zzjr.zzb(i17, 0.0d);
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 52:
                    if (zza(t, i17, i15)) {
                        iZzk = zzjr.zzb(i17, 0.0f);
                        iZzb3 += iZzk;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 53:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzd(i17, zzh(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 54:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zze(i17, zzh(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 55:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzg(i17, zzg(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 56:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzg(i17, 0L);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 57:
                    if (zza(t, i17, i15)) {
                        iZzk = zzjr.zzj(i17, 0);
                        iZzb3 += iZzk;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 58:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzc(i17, true);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 59:
                    if (zza(t, i17, i15)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        iZzc = object2 instanceof zzjc ? zzjr.zzc(i17, (zzjc) object2) : zzjr.zzb(i17, (String) object2);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 60:
                    if (zza(t, i17, i15)) {
                        iZzc2 = zzmh.zzc(i17, unsafe2.getObject(t, j2), zzap(i15));
                        iZzb3 += iZzc2;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 61:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzc(i17, (zzjc) unsafe2.getObject(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 62:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzh(i17, zzg(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 63:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzl(i17, zzg(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 64:
                    if (zza(t, i17, i15)) {
                        iZzk = zzjr.zzk(i17, 0);
                        iZzb3 += iZzk;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 65:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzh(i17, 0L);
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 66:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzi(i17, zzg(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 67:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzf(i17, zzh(t, j2));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                case 68:
                    if (zza(t, i17, i15)) {
                        iZzc = zzjr.zzc(i17, (zzlq) unsafe2.getObject(t, j2), zzap(i15));
                        iZzb3 += iZzc;
                    }
                    i4 = 0;
                    z = false;
                    break;
                default:
                    i4 = 0;
                    z = false;
                    break;
            }
            i15 += 3;
            i8 = i4;
            i7 = i18;
        }
        int iZzb5 = i8;
        int iZza3 = iZzb3 + zza(this.zzur, t);
        if (!this.zzui) {
            return iZza3;
        }
        zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
        for (int i21 = iZzb5; i21 < zzkbVarZzb.zzos.zzer(); i21++) {
            Map.Entry entryZzaw = zzkbVarZzb.zzos.zzaw(i21);
            iZzb5 += zzkb.zzb((zzkd<?>) entryZzaw.getKey(), entryZzaw.getValue());
        }
        for (Map.Entry entry : zzkbVarZzb.zzos.zzes()) {
            iZzb5 += zzkb.zzb((zzkd<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + iZzb5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.drive.zzmf] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.drive.zzmf] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzp(T t) {
        int i;
        int i2 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzun; i5++) {
            int i6 = this.zzum[i5];
            int i7 = this.zzud[i6];
            int iZzas = zzas(i6);
            if (this.zzuk) {
                i = 0;
            } else {
                int i8 = this.zzud[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i2) {
                    i4 = zzuc.getInt(t, i9);
                    i2 = i9;
                }
            }
            if ((268435456 & iZzas) != 0 && !zza(t, i6, i4, i)) {
                return false;
            }
            int i10 = (267386880 & iZzas) >>> 20;
            if (i10 == 9 || i10 == 17) {
                if (zza(t, i6, i4, i) && !zza(t, iZzas, zzap(i6))) {
                    return false;
                }
            } else if (i10 == 27) {
                List list = (List) zznd.zzo(t, iZzas & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zzap = zzap(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!Zzap.zzp(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (i10 == 60 || i10 == 68) {
                if (zza(t, i7, i6) && !zza(t, iZzas, zzap(i6))) {
                    return false;
                }
            } else if (i10 != 49) {
                if (i10 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzi = this.zzut.zzi(zznd.zzo(t, iZzas & 1048575));
                    if (mapZzi.isEmpty()) {
                        continue;
                    } else if (this.zzut.zzm(zzaq(i6)).zztw.zzfj() == zznr.MESSAGE) {
                        ?? Zzf = 0;
                        for (Object obj : mapZzi.values()) {
                            Zzf = Zzf;
                            if (Zzf == 0) {
                                Zzf = zzmd.zzej().zzf(obj.getClass());
                            }
                            if (!Zzf.zzp(obj)) {
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return !this.zzui || this.zzus.zzb(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzd(T t) {
        int i;
        int i2 = this.zzun;
        while (true) {
            i = this.zzuo;
            if (i2 >= i) {
                break;
            }
            long jZzas = zzas(this.zzum[i2]) & 1048575;
            Object objZzo = zznd.zzo(t, jZzas);
            if (objZzo != null) {
                zznd.zza(t, jZzas, this.zzut.zzk(objZzo));
            }
            i2++;
        }
        int length = this.zzum.length;
        while (i < length) {
            this.zzuq.zza(t, this.zzum[i]);
            i++;
        }
        this.zzur.zzd(t);
        if (this.zzui) {
            this.zzus.zzd(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzns zznsVar) {
        Iterator it;
        Map.Entry<?, ?> entry;
        boolean z;
        int i;
        boolean z2;
        if (this.zzui) {
            zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
            if (zzkbVarZzb.zzos.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzkbVarZzb.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.zzud.length;
        Unsafe unsafe = zzuc;
        int i2 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iZzas = zzas(i5);
            int[] iArr = this.zzud;
            int i6 = iArr[i5];
            int i7 = (267386880 & iZzas) >>> 20;
            if (this.zzuk || i7 > 17) {
                z = true;
                i = 0;
            } else {
                int i8 = iArr[i5 + 2];
                int i9 = i8 & 1048575;
                z = true;
                if (i9 != i2) {
                    i4 = unsafe.getInt(t, i9);
                    i2 = i9;
                }
                i = 1 << (i8 >>> 20);
            }
            while (entry != null && this.zzus.zza(entry) <= i6) {
                this.zzus.zza(zznsVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzas & 1048575;
            switch (i7) {
                case 0:
                    if ((i & i4) != 0) {
                        zznsVar.zza(i6, zznd.zzn(t, j));
                    }
                    break;
                case 1:
                    if ((i & i4) != 0) {
                        zznsVar.zza(i6, zznd.zzm(t, j));
                    }
                    break;
                case 2:
                    if ((i & i4) != 0) {
                        zznsVar.zzi(i6, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i & i4) != 0) {
                        zznsVar.zza(i6, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i & i4) != 0) {
                        zznsVar.zzc(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i & i4) != 0) {
                        zznsVar.zzc(i6, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i & i4) != 0) {
                        zznsVar.zzf(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i & i4) != 0) {
                        zznsVar.zzb(i6, zznd.zzl(t, j));
                    }
                    break;
                case 8:
                    if ((i & i4) != 0) {
                        zza(i6, unsafe.getObject(t, j), zznsVar);
                    }
                    break;
                case 9:
                    if ((i & i4) != 0) {
                        zznsVar.zza(i6, unsafe.getObject(t, j), zzap(i5));
                    }
                    break;
                case 10:
                    if ((i & i4) != 0) {
                        zznsVar.zza(i6, (zzjc) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i & i4) != 0) {
                        zznsVar.zzd(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i & i4) != 0) {
                        zznsVar.zzn(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i & i4) != 0) {
                        zznsVar.zzm(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i & i4) != 0) {
                        zznsVar.zzj(i6, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i & i4) != 0) {
                        zznsVar.zze(i6, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i & i4) != 0) {
                        zznsVar.zzb(i6, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i & i4) != 0) {
                        zznsVar.zzb(i6, unsafe.getObject(t, j), zzap(i5));
                    }
                    break;
                case 18:
                    zzmh.zza(this.zzud[i5], (List<Double>) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 19:
                    zzmh.zzb(this.zzud[i5], (List<Float>) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 20:
                    zzmh.zzc(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 21:
                    zzmh.zzd(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 22:
                    zzmh.zzh(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 23:
                    zzmh.zzf(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 24:
                    zzmh.zzk(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 25:
                    zzmh.zzn(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 26:
                    zzmh.zza(this.zzud[i5], (List<String>) unsafe.getObject(t, j), zznsVar);
                    break;
                case 27:
                    zzmh.zza(this.zzud[i5], (List<?>) unsafe.getObject(t, j), zznsVar, zzap(i5));
                    break;
                case 28:
                    zzmh.zzb(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar);
                    break;
                case 29:
                    z2 = false;
                    zzmh.zzi(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 30:
                    z2 = false;
                    zzmh.zzm(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 31:
                    z2 = false;
                    zzmh.zzl(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 32:
                    z2 = false;
                    zzmh.zzg(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 33:
                    z2 = false;
                    zzmh.zzj(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 34:
                    z2 = false;
                    zzmh.zze(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 35:
                    zzmh.zza(this.zzud[i5], (List<Double>) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 36:
                    zzmh.zzb(this.zzud[i5], (List<Float>) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 37:
                    zzmh.zzc(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 38:
                    zzmh.zzd(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 39:
                    zzmh.zzh(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 40:
                    zzmh.zzf(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 41:
                    zzmh.zzk(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 42:
                    zzmh.zzn(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 43:
                    zzmh.zzi(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 44:
                    zzmh.zzm(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 45:
                    zzmh.zzl(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 46:
                    zzmh.zzg(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 47:
                    zzmh.zzj(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 48:
                    zzmh.zze(this.zzud[i5], (List) unsafe.getObject(t, j), zznsVar, z);
                    break;
                case 49:
                    zzmh.zzb(this.zzud[i5], (List<?>) unsafe.getObject(t, j), zznsVar, zzap(i5));
                    break;
                case 50:
                    zza(zznsVar, i6, unsafe.getObject(t, j), i5);
                    break;
                case 51:
                    if (zza(t, i6, i5)) {
                        zznsVar.zza(i6, zze(t, j));
                    }
                    break;
                case 52:
                    if (zza(t, i6, i5)) {
                        zznsVar.zza(i6, zzf(t, j));
                    }
                    break;
                case 53:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzi(i6, zzh(t, j));
                    }
                    break;
                case 54:
                    if (zza(t, i6, i5)) {
                        zznsVar.zza(i6, zzh(t, j));
                    }
                    break;
                case 55:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzc(i6, zzg(t, j));
                    }
                    break;
                case 56:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzc(i6, zzh(t, j));
                    }
                    break;
                case 57:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzf(i6, zzg(t, j));
                    }
                    break;
                case 58:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzb(i6, zzi(t, j));
                    }
                    break;
                case 59:
                    if (zza(t, i6, i5)) {
                        zza(i6, unsafe.getObject(t, j), zznsVar);
                    }
                    break;
                case 60:
                    if (zza(t, i6, i5)) {
                        zznsVar.zza(i6, unsafe.getObject(t, j), zzap(i5));
                    }
                    break;
                case 61:
                    if (zza(t, i6, i5)) {
                        zznsVar.zza(i6, (zzjc) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzd(i6, zzg(t, j));
                    }
                    break;
                case 63:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzn(i6, zzg(t, j));
                    }
                    break;
                case 64:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzm(i6, zzg(t, j));
                    }
                    break;
                case 65:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzj(i6, zzh(t, j));
                    }
                    break;
                case 66:
                    if (zza(t, i6, i5)) {
                        zznsVar.zze(i6, zzg(t, j));
                    }
                    break;
                case 67:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzb(i6, zzh(t, j));
                    }
                    break;
                case 68:
                    if (zza(t, i6, i5)) {
                        zznsVar.zzb(i6, unsafe.getObject(t, j), zzap(i5));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzus.zza(zznsVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzur, t, zznsVar);
    }

    private final int zzp(int i, int i2) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, i2);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(name.length() + AbstractC4539a.m3194d(40, str), string));
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            throw new RuntimeException(AbstractC0622a.m1170p(" not found. Known fields are ", string, sb));
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzas = zzas(i) & 1048575;
        if (zza(t2, i)) {
            Object objZzo = zznd.zzo(t, jZzas);
            Object objZzo2 = zznd.zzo(t2, jZzas);
            if (objZzo != null && objZzo2 != null) {
                zznd.zza(t, jZzas, zzkm.zza(objZzo, objZzo2));
                zzb(t, i);
            } else if (objZzo2 != null) {
                zznd.zza(t, jZzas, objZzo2);
                zzb(t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzmx<UT, UB> zzmxVar, T t) {
        return zzmxVar.zzn(zzmxVar.zzr(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzns zznsVar) {
        Iterator it;
        Map.Entry<?, ?> entry;
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry2;
        if (zznsVar.zzcd() == zzkk.zze.zzsj) {
            zza(this.zzur, t, zznsVar);
            if (this.zzui) {
                zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
                if (zzkbVarZzb.zzos.isEmpty()) {
                    itDescendingIterator = null;
                    entry2 = null;
                } else {
                    itDescendingIterator = zzkbVarZzb.descendingIterator();
                    entry2 = (Map.Entry) itDescendingIterator.next();
                }
            }
            for (int length = this.zzud.length - 3; length >= 0; length -= 3) {
                int iZzas = zzas(length);
                int i = this.zzud[length];
                while (entry2 != null && this.zzus.zza(entry2) > i) {
                    this.zzus.zza(zznsVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((iZzas & 267386880) >>> 20) {
                    case 0:
                        if (zza(t, length)) {
                            zznsVar.zza(i, zznd.zzn(t, iZzas & 1048575));
                        }
                        break;
                    case 1:
                        if (zza(t, length)) {
                            zznsVar.zza(i, zznd.zzm(t, iZzas & 1048575));
                        }
                        break;
                    case 2:
                        if (zza(t, length)) {
                            zznsVar.zzi(i, zznd.zzk(t, iZzas & 1048575));
                        }
                        break;
                    case 3:
                        if (zza(t, length)) {
                            zznsVar.zza(i, zznd.zzk(t, iZzas & 1048575));
                        }
                        break;
                    case 4:
                        if (zza(t, length)) {
                            zznsVar.zzc(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 5:
                        if (zza(t, length)) {
                            zznsVar.zzc(i, zznd.zzk(t, iZzas & 1048575));
                        }
                        break;
                    case 6:
                        if (zza(t, length)) {
                            zznsVar.zzf(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 7:
                        if (zza(t, length)) {
                            zznsVar.zzb(i, zznd.zzl(t, iZzas & 1048575));
                        }
                        break;
                    case 8:
                        if (zza(t, length)) {
                            zza(i, zznd.zzo(t, iZzas & 1048575), zznsVar);
                        }
                        break;
                    case 9:
                        if (zza(t, length)) {
                            zznsVar.zza(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                        }
                        break;
                    case 10:
                        if (zza(t, length)) {
                            zznsVar.zza(i, (zzjc) zznd.zzo(t, iZzas & 1048575));
                        }
                        break;
                    case 11:
                        if (zza(t, length)) {
                            zznsVar.zzd(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 12:
                        if (zza(t, length)) {
                            zznsVar.zzn(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 13:
                        if (zza(t, length)) {
                            zznsVar.zzm(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 14:
                        if (zza(t, length)) {
                            zznsVar.zzj(i, zznd.zzk(t, iZzas & 1048575));
                        }
                        break;
                    case 15:
                        if (zza(t, length)) {
                            zznsVar.zze(i, zznd.zzj(t, iZzas & 1048575));
                        }
                        break;
                    case 16:
                        if (zza(t, length)) {
                            zznsVar.zzb(i, zznd.zzk(t, iZzas & 1048575));
                        }
                        break;
                    case 17:
                        if (zza(t, length)) {
                            zznsVar.zzb(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                        }
                        break;
                    case 18:
                        zzmh.zza(this.zzud[length], (List<Double>) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 19:
                        zzmh.zzb(this.zzud[length], (List<Float>) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 20:
                        zzmh.zzc(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 21:
                        zzmh.zzd(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 22:
                        zzmh.zzh(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 23:
                        zzmh.zzf(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 24:
                        zzmh.zzk(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 25:
                        zzmh.zzn(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 26:
                        zzmh.zza(this.zzud[length], (List<String>) zznd.zzo(t, iZzas & 1048575), zznsVar);
                        break;
                    case 27:
                        zzmh.zza(this.zzud[length], (List<?>) zznd.zzo(t, iZzas & 1048575), zznsVar, zzap(length));
                        break;
                    case 28:
                        zzmh.zzb(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar);
                        break;
                    case 29:
                        zzmh.zzi(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 30:
                        zzmh.zzm(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 31:
                        zzmh.zzl(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 32:
                        zzmh.zzg(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 33:
                        zzmh.zzj(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 34:
                        zzmh.zze(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 35:
                        zzmh.zza(this.zzud[length], (List<Double>) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 36:
                        zzmh.zzb(this.zzud[length], (List<Float>) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 37:
                        zzmh.zzc(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 38:
                        zzmh.zzd(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 39:
                        zzmh.zzh(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 40:
                        zzmh.zzf(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 41:
                        zzmh.zzk(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 42:
                        zzmh.zzn(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 43:
                        zzmh.zzi(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 44:
                        zzmh.zzm(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 45:
                        zzmh.zzl(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 46:
                        zzmh.zzg(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 47:
                        zzmh.zzj(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 48:
                        zzmh.zze(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 49:
                        zzmh.zzb(this.zzud[length], (List<?>) zznd.zzo(t, iZzas & 1048575), zznsVar, zzap(length));
                        break;
                    case 50:
                        zza(zznsVar, i, zznd.zzo(t, iZzas & 1048575), length);
                        break;
                    case 51:
                        if (zza(t, i, length)) {
                            zznsVar.zza(i, zze(t, iZzas & 1048575));
                        }
                        break;
                    case 52:
                        if (zza(t, i, length)) {
                            zznsVar.zza(i, zzf(t, iZzas & 1048575));
                        }
                        break;
                    case 53:
                        if (zza(t, i, length)) {
                            zznsVar.zzi(i, zzh(t, iZzas & 1048575));
                        }
                        break;
                    case 54:
                        if (zza(t, i, length)) {
                            zznsVar.zza(i, zzh(t, iZzas & 1048575));
                        }
                        break;
                    case 55:
                        if (zza(t, i, length)) {
                            zznsVar.zzc(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 56:
                        if (zza(t, i, length)) {
                            zznsVar.zzc(i, zzh(t, iZzas & 1048575));
                        }
                        break;
                    case 57:
                        if (zza(t, i, length)) {
                            zznsVar.zzf(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 58:
                        if (zza(t, i, length)) {
                            zznsVar.zzb(i, zzi(t, iZzas & 1048575));
                        }
                        break;
                    case 59:
                        if (zza(t, i, length)) {
                            zza(i, zznd.zzo(t, iZzas & 1048575), zznsVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i, length)) {
                            zznsVar.zza(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                        }
                        break;
                    case 61:
                        if (zza(t, i, length)) {
                            zznsVar.zza(i, (zzjc) zznd.zzo(t, iZzas & 1048575));
                        }
                        break;
                    case 62:
                        if (zza(t, i, length)) {
                            zznsVar.zzd(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 63:
                        if (zza(t, i, length)) {
                            zznsVar.zzn(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 64:
                        if (zza(t, i, length)) {
                            zznsVar.zzm(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 65:
                        if (zza(t, i, length)) {
                            zznsVar.zzj(i, zzh(t, iZzas & 1048575));
                        }
                        break;
                    case 66:
                        if (zza(t, i, length)) {
                            zznsVar.zze(i, zzg(t, iZzas & 1048575));
                        }
                        break;
                    case 67:
                        if (zza(t, i, length)) {
                            zznsVar.zzb(i, zzh(t, iZzas & 1048575));
                        }
                        break;
                    case 68:
                        if (zza(t, i, length)) {
                            zznsVar.zzb(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzus.zza(zznsVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (this.zzuk) {
            if (this.zzui) {
                zzkb<T> zzkbVarZzb2 = this.zzus.zzb(t);
                if (zzkbVarZzb2.zzos.isEmpty()) {
                    it = null;
                    entry = null;
                } else {
                    it = zzkbVarZzb2.iterator();
                    entry = (Map.Entry) it.next();
                }
            }
            int length2 = this.zzud.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzas2 = zzas(i2);
                int i4 = this.zzud[i2];
                while (entry != null && this.zzus.zza(entry) <= i4) {
                    this.zzus.zza(zznsVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                switch ((iZzas2 & 267386880) >>> 20) {
                    case 0:
                        if (zza(t, i2)) {
                            zznsVar.zza(i4, zznd.zzn(t, iZzas2 & 1048575));
                        }
                        break;
                    case 1:
                        if (zza(t, i2)) {
                            zznsVar.zza(i4, zznd.zzm(t, iZzas2 & 1048575));
                        }
                        break;
                    case 2:
                        if (zza(t, i2)) {
                            zznsVar.zzi(i4, zznd.zzk(t, iZzas2 & 1048575));
                        }
                        break;
                    case 3:
                        if (zza(t, i2)) {
                            zznsVar.zza(i4, zznd.zzk(t, iZzas2 & 1048575));
                        }
                        break;
                    case 4:
                        if (zza(t, i2)) {
                            zznsVar.zzc(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 5:
                        if (zza(t, i2)) {
                            zznsVar.zzc(i4, zznd.zzk(t, iZzas2 & 1048575));
                        }
                        break;
                    case 6:
                        if (zza(t, i2)) {
                            zznsVar.zzf(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 7:
                        if (zza(t, i2)) {
                            zznsVar.zzb(i4, zznd.zzl(t, iZzas2 & 1048575));
                        }
                        break;
                    case 8:
                        if (zza(t, i2)) {
                            zza(i4, zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        }
                        break;
                    case 9:
                        if (zza(t, i2)) {
                            zznsVar.zza(i4, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                        }
                        break;
                    case 10:
                        if (zza(t, i2)) {
                            zznsVar.zza(i4, (zzjc) zznd.zzo(t, iZzas2 & 1048575));
                        }
                        break;
                    case 11:
                        if (zza(t, i2)) {
                            zznsVar.zzd(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 12:
                        if (zza(t, i2)) {
                            zznsVar.zzn(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 13:
                        if (zza(t, i2)) {
                            zznsVar.zzm(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 14:
                        if (zza(t, i2)) {
                            zznsVar.zzj(i4, zznd.zzk(t, iZzas2 & 1048575));
                        }
                        break;
                    case 15:
                        if (zza(t, i2)) {
                            zznsVar.zze(i4, zznd.zzj(t, iZzas2 & 1048575));
                        }
                        break;
                    case 16:
                        if (zza(t, i2)) {
                            zznsVar.zzb(i4, zznd.zzk(t, iZzas2 & 1048575));
                        }
                        break;
                    case 17:
                        if (zza(t, i2)) {
                            zznsVar.zzb(i4, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                        }
                        break;
                    case 18:
                        zzmh.zza(this.zzud[i2], (List<Double>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 19:
                        zzmh.zzb(this.zzud[i2], (List<Float>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 20:
                        zzmh.zzc(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 21:
                        zzmh.zzd(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 22:
                        zzmh.zzh(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 23:
                        zzmh.zzf(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 24:
                        zzmh.zzk(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 25:
                        zzmh.zzn(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 26:
                        zzmh.zza(this.zzud[i2], (List<String>) zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        break;
                    case 27:
                        zzmh.zza(this.zzud[i2], (List<?>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, zzap(i2));
                        break;
                    case 28:
                        zzmh.zzb(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        break;
                    case 29:
                        zzmh.zzi(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 30:
                        zzmh.zzm(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 31:
                        zzmh.zzl(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 32:
                        zzmh.zzg(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 33:
                        zzmh.zzj(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 34:
                        zzmh.zze(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 35:
                        zzmh.zza(this.zzud[i2], (List<Double>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 36:
                        zzmh.zzb(this.zzud[i2], (List<Float>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 37:
                        zzmh.zzc(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 38:
                        zzmh.zzd(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 39:
                        zzmh.zzh(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 40:
                        zzmh.zzf(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 41:
                        zzmh.zzk(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 42:
                        zzmh.zzn(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 43:
                        zzmh.zzi(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 44:
                        zzmh.zzm(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 45:
                        zzmh.zzl(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 46:
                        zzmh.zzg(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 47:
                        zzmh.zzj(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 48:
                        zzmh.zze(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 49:
                        zzmh.zzb(this.zzud[i2], (List<?>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, zzap(i2));
                        break;
                    case 50:
                        zza(zznsVar, i4, zznd.zzo(t, iZzas2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza(t, i4, i2)) {
                            zznsVar.zza(i4, zze(t, iZzas2 & 1048575));
                        }
                        break;
                    case 52:
                        if (zza(t, i4, i2)) {
                            zznsVar.zza(i4, zzf(t, iZzas2 & 1048575));
                        }
                        break;
                    case 53:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzi(i4, zzh(t, iZzas2 & 1048575));
                        }
                        break;
                    case 54:
                        if (zza(t, i4, i2)) {
                            zznsVar.zza(i4, zzh(t, iZzas2 & 1048575));
                        }
                        break;
                    case 55:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzc(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 56:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzc(i4, zzh(t, iZzas2 & 1048575));
                        }
                        break;
                    case 57:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzf(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 58:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzb(i4, zzi(t, iZzas2 & 1048575));
                        }
                        break;
                    case 59:
                        if (zza(t, i4, i2)) {
                            zza(i4, zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i4, i2)) {
                            zznsVar.zza(i4, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                        }
                        break;
                    case 61:
                        if (zza(t, i4, i2)) {
                            zznsVar.zza(i4, (zzjc) zznd.zzo(t, iZzas2 & 1048575));
                        }
                        break;
                    case 62:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzd(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 63:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzn(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 64:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzm(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 65:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzj(i4, zzh(t, iZzas2 & 1048575));
                        }
                        break;
                    case 66:
                        if (zza(t, i4, i2)) {
                            zznsVar.zze(i4, zzg(t, iZzas2 & 1048575));
                        }
                        break;
                    case 67:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzb(i4, zzh(t, iZzas2 & 1048575));
                        }
                        break;
                    case 68:
                        if (zza(t, i4, i2)) {
                            zznsVar.zzb(i4, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                        }
                        break;
                }
            }
            while (entry != null) {
                this.zzus.zza(zznsVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            zza(this.zzur, t, zznsVar);
            return;
        }
        zzb(t, zznsVar);
    }

    private final void zzb(T t, int i) {
        if (this.zzuk) {
            return;
        }
        int iZzat = zzat(i);
        long j = iZzat & 1048575;
        zznd.zza((Object) t, j, zznd.zzj(t, j) | (1 << (iZzat >>> 20)));
    }

    private final void zzb(T t, int i, int i2) {
        zznd.zza((Object) t, zzat(i2) & 1048575, i);
    }

    private final <K, V> void zza(zzns zznsVar, int i, Object obj, int i2) {
        if (obj != null) {
            zznsVar.zza(i, this.zzut.zzm(zzaq(i2)), this.zzut.zzi(obj));
        }
    }

    private static <UT, UB> void zza(zzmx<UT, UB> zzmxVar, T t, zzns zznsVar) {
        zzmxVar.zza(zzmxVar.zzr(t), zznsVar);
    }

    private static int zza(byte[] bArr, int i, int i2, zznm zznmVar, Class<?> cls, zziz zzizVar) {
        switch (zzlv.zzox[zznmVar.ordinal()]) {
            case 1:
                int iZzb = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Boolean.valueOf(zzizVar.zznl != 0);
                return iZzb;
            case 2:
                return zziy.zze(bArr, i, zzizVar);
            case 3:
                zzizVar.zznm = Double.valueOf(zziy.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzizVar.zznm = Integer.valueOf(zziy.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzizVar.zznm = Long.valueOf(zziy.zzb(bArr, i));
                return i + 8;
            case 8:
                zzizVar.zznm = Float.valueOf(zziy.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zziy.zza(bArr, i, zzizVar);
                zzizVar.zznm = Integer.valueOf(zzizVar.zznk);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Long.valueOf(zzizVar.zznl);
                return iZzb2;
            case 14:
                return zziy.zza(zzmd.zzej().zzf(cls), bArr, i, i2, zzizVar);
            case 15:
                int iZza2 = zziy.zza(bArr, i, zzizVar);
                zzizVar.zznm = Integer.valueOf(zzjo.zzw(zzizVar.zznk));
                return iZza2;
            case 16:
                int iZzb3 = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Long.valueOf(zzjo.zzk(zzizVar.zznl));
                return iZzb3;
            case 17:
                return zziy.zzd(bArr, i, zzizVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, long j, int i8, long j2, zziz zzizVar) throws zzkq {
        int i9;
        int i10;
        int iZza;
        Unsafe unsafe = zzuc;
        zzkp zzkpVarZzr = (zzkp) unsafe.getObject(t, j2);
        if (!zzkpVarZzr.zzbo()) {
            int size = zzkpVarZzr.size();
            zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzkpVarZzr);
        }
        zzkp zzkpVar = zzkpVarZzr;
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    zzju zzjuVar = (zzju) zzkpVar;
                    int iZza2 = zziy.zza(bArr, i, zzizVar);
                    int i11 = zzizVar.zznk + iZza2;
                    while (iZza2 < i11) {
                        zzjuVar.zzc(zziy.zzc(bArr, iZza2));
                        iZza2 += 8;
                    }
                    if (iZza2 == i11) {
                        return iZza2;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 1) {
                    return i;
                }
                zzju zzjuVar2 = (zzju) zzkpVar;
                zzjuVar2.zzc(zziy.zzc(bArr, i));
                int i12 = i + 8;
                while (i12 < i2) {
                    int iZza3 = zziy.zza(bArr, i12, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return i12;
                    }
                    zzjuVar2.zzc(zziy.zzc(bArr, iZza3));
                    i12 = iZza3 + 8;
                }
                return i12;
            case 19:
            case 36:
                if (i6 == 2) {
                    zzkh zzkhVar = (zzkh) zzkpVar;
                    int iZza4 = zziy.zza(bArr, i, zzizVar);
                    int i13 = zzizVar.zznk + iZza4;
                    while (iZza4 < i13) {
                        zzkhVar.zzc(zziy.zzd(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i13) {
                        return iZza4;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 5) {
                    return i;
                }
                zzkh zzkhVar2 = (zzkh) zzkpVar;
                zzkhVar2.zzc(zziy.zzd(bArr, i));
                int i14 = i + 4;
                while (i14 < i2) {
                    int iZza5 = zziy.zza(bArr, i14, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return i14;
                    }
                    zzkhVar2.zzc(zziy.zzd(bArr, iZza5));
                    i14 = iZza5 + 4;
                }
                return i14;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    zzle zzleVar = (zzle) zzkpVar;
                    int iZza6 = zziy.zza(bArr, i, zzizVar);
                    int i15 = zzizVar.zznk + iZza6;
                    while (iZza6 < i15) {
                        iZza6 = zziy.zzb(bArr, iZza6, zzizVar);
                        zzleVar.zzv(zzizVar.zznl);
                    }
                    if (iZza6 == i15) {
                        return iZza6;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 0) {
                    return i;
                }
                zzle zzleVar2 = (zzle) zzkpVar;
                int iZzb = zziy.zzb(bArr, i, zzizVar);
                zzleVar2.zzv(zzizVar.zznl);
                while (iZzb < i2) {
                    int iZza7 = zziy.zza(bArr, iZzb, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return iZzb;
                    }
                    iZzb = zziy.zzb(bArr, iZza7, zzizVar);
                    zzleVar2.zzv(zzizVar.zznl);
                }
                return iZzb;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return zziy.zza(bArr, i, (zzkp<?>) zzkpVar, zzizVar);
                }
                return i6 == 0 ? zziy.zza(i4, bArr, i, i2, (zzkp<?>) zzkpVar, zzizVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    zzle zzleVar3 = (zzle) zzkpVar;
                    int iZza8 = zziy.zza(bArr, i, zzizVar);
                    int i16 = zzizVar.zznk + iZza8;
                    while (iZza8 < i16) {
                        zzleVar3.zzv(zziy.zzb(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 == i16) {
                        return iZza8;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 1) {
                    return i;
                }
                zzle zzleVar4 = (zzle) zzkpVar;
                zzleVar4.zzv(zziy.zzb(bArr, i));
                int i17 = i + 8;
                while (i17 < i2) {
                    int iZza9 = zziy.zza(bArr, i17, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return i17;
                    }
                    zzleVar4.zzv(zziy.zzb(bArr, iZza9));
                    i17 = iZza9 + 8;
                }
                return i17;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    zzkl zzklVar = (zzkl) zzkpVar;
                    int iZza10 = zziy.zza(bArr, i, zzizVar);
                    int i18 = zzizVar.zznk + iZza10;
                    while (iZza10 < i18) {
                        zzklVar.zzam(zziy.zza(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 == i18) {
                        return iZza10;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 5) {
                    return i;
                }
                zzkl zzklVar2 = (zzkl) zzkpVar;
                zzklVar2.zzam(zziy.zza(bArr, i));
                int i19 = i + 4;
                while (i19 < i2) {
                    int iZza11 = zziy.zza(bArr, i19, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return i19;
                    }
                    zzklVar2.zzam(zziy.zza(bArr, iZza11));
                    i19 = iZza11 + 4;
                }
                return i19;
            case 25:
            case 42:
                if (i6 == 2) {
                    zzja zzjaVar = (zzja) zzkpVar;
                    int iZza12 = zziy.zza(bArr, i, zzizVar);
                    int i20 = zzizVar.zznk + iZza12;
                    while (iZza12 < i20) {
                        iZza12 = zziy.zzb(bArr, iZza12, zzizVar);
                        zzjaVar.addBoolean(zzizVar.zznl != 0);
                    }
                    if (iZza12 == i20) {
                        return iZza12;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 != 0) {
                    return i;
                }
                zzja zzjaVar2 = (zzja) zzkpVar;
                int iZzb2 = zziy.zzb(bArr, i, zzizVar);
                zzjaVar2.addBoolean(zzizVar.zznl != 0);
                while (iZzb2 < i2) {
                    int iZza13 = zziy.zza(bArr, iZzb2, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return iZzb2;
                    }
                    iZzb2 = zziy.zzb(bArr, iZza13, zzizVar);
                    zzjaVar2.addBoolean(zzizVar.zznl != 0);
                }
                return iZzb2;
            case 26:
                if (i6 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    int iZza14 = zziy.zza(bArr, i, zzizVar);
                    int i21 = zzizVar.zznk;
                    if (i21 < 0) {
                        throw zzkq.zzdj();
                    }
                    if (i21 == 0) {
                        zzkpVar.add("");
                    } else {
                        zzkpVar.add(new String(bArr, iZza14, i21, zzkm.UTF_8));
                        iZza14 += i21;
                    }
                    while (iZza14 < i2) {
                        int iZza15 = zziy.zza(bArr, iZza14, zzizVar);
                        if (i4 != zzizVar.zznk) {
                            return iZza14;
                        }
                        iZza14 = zziy.zza(bArr, iZza15, zzizVar);
                        int i22 = zzizVar.zznk;
                        if (i22 < 0) {
                            throw zzkq.zzdj();
                        }
                        if (i22 == 0) {
                            zzkpVar.add("");
                        } else {
                            zzkpVar.add(new String(bArr, iZza14, i22, zzkm.UTF_8));
                            iZza14 += i22;
                        }
                    }
                    return iZza14;
                }
                int iZza16 = zziy.zza(bArr, i, zzizVar);
                int i23 = zzizVar.zznk;
                if (i23 < 0) {
                    throw zzkq.zzdj();
                }
                if (i23 == 0) {
                    zzkpVar.add("");
                } else {
                    int i24 = iZza16 + i23;
                    if (zznf.zze(bArr, iZza16, i24)) {
                        zzkpVar.add(new String(bArr, iZza16, i23, zzkm.UTF_8));
                        iZza16 = i24;
                    } else {
                        throw zzkq.zzdn();
                    }
                }
                while (iZza16 < i2) {
                    int iZza17 = zziy.zza(bArr, iZza16, zzizVar);
                    if (i4 != zzizVar.zznk) {
                        return iZza16;
                    }
                    iZza16 = zziy.zza(bArr, iZza17, zzizVar);
                    int i25 = zzizVar.zznk;
                    if (i25 < 0) {
                        throw zzkq.zzdj();
                    }
                    if (i25 == 0) {
                        zzkpVar.add("");
                    } else {
                        int i26 = iZza16 + i25;
                        if (zznf.zze(bArr, iZza16, i26)) {
                            zzkpVar.add(new String(bArr, iZza16, i25, zzkm.UTF_8));
                            iZza16 = i26;
                        } else {
                            throw zzkq.zzdn();
                        }
                    }
                }
                return iZza16;
            case 27:
                i9 = i;
                if (i6 == 2) {
                    return zziy.zza(zzap(i7), i4, bArr, i9, i2, zzkpVar, zzizVar);
                }
                return i9;
            case 28:
                i9 = i;
                if (i6 == 2) {
                    int iZza18 = zziy.zza(bArr, i9, zzizVar);
                    int i27 = zzizVar.zznk;
                    if (i27 >= 0) {
                        if (i27 > bArr.length - iZza18) {
                            throw zzkq.zzdi();
                        }
                        if (i27 == 0) {
                            zzkpVar.add(zzjc.zznq);
                        } else {
                            zzkpVar.add(zzjc.zzb(bArr, iZza18, i27));
                            iZza18 += i27;
                        }
                        while (iZza18 < i2) {
                            int iZza19 = zziy.zza(bArr, iZza18, zzizVar);
                            if (i4 != zzizVar.zznk) {
                                return iZza18;
                            }
                            iZza18 = zziy.zza(bArr, iZza19, zzizVar);
                            int i28 = zzizVar.zznk;
                            if (i28 >= 0) {
                                if (i28 > bArr.length - iZza18) {
                                    throw zzkq.zzdi();
                                }
                                if (i28 == 0) {
                                    zzkpVar.add(zzjc.zznq);
                                } else {
                                    zzkpVar.add(zzjc.zzb(bArr, iZza18, i28));
                                    iZza18 += i28;
                                }
                            } else {
                                throw zzkq.zzdj();
                            }
                        }
                        return iZza18;
                    }
                    throw zzkq.zzdj();
                }
                return i9;
            case 30:
            case 44:
                i10 = i;
                if (i6 != 2) {
                    if (i6 == 0) {
                        iZza = zziy.zza(i4, bArr, i10, i2, (zzkp<?>) zzkpVar, zzizVar);
                    }
                    return i10;
                }
                iZza = zziy.zza(bArr, i10, (zzkp<?>) zzkpVar, zzizVar);
                zzkk zzkkVar = (zzkk) t;
                zzmy zzmyVar = zzkkVar.zzrq;
                if (zzmyVar == zzmy.zzfa()) {
                    zzmyVar = null;
                }
                zzmy zzmyVar2 = (zzmy) zzmh.zza(i5, zzkpVar, zzar(i7), zzmyVar, this.zzur);
                if (zzmyVar2 != null) {
                    zzkkVar.zzrq = zzmyVar2;
                }
                return iZza;
            case 33:
            case 47:
                i10 = i;
                if (i6 == 2) {
                    zzkl zzklVar3 = (zzkl) zzkpVar;
                    int iZza20 = zziy.zza(bArr, i10, zzizVar);
                    int i29 = zzizVar.zznk + iZza20;
                    while (iZza20 < i29) {
                        iZza20 = zziy.zza(bArr, iZza20, zzizVar);
                        zzklVar3.zzam(zzjo.zzw(zzizVar.zznk));
                    }
                    if (iZza20 == i29) {
                        return iZza20;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 == 0) {
                    zzkl zzklVar4 = (zzkl) zzkpVar;
                    int iZza21 = zziy.zza(bArr, i10, zzizVar);
                    zzklVar4.zzam(zzjo.zzw(zzizVar.zznk));
                    while (iZza21 < i2) {
                        int iZza22 = zziy.zza(bArr, iZza21, zzizVar);
                        if (i4 != zzizVar.zznk) {
                            return iZza21;
                        }
                        iZza21 = zziy.zza(bArr, iZza22, zzizVar);
                        zzklVar4.zzam(zzjo.zzw(zzizVar.zznk));
                    }
                    return iZza21;
                }
                return i10;
            case 34:
            case 48:
                i10 = i;
                if (i6 == 2) {
                    zzle zzleVar5 = (zzle) zzkpVar;
                    int iZza23 = zziy.zza(bArr, i10, zzizVar);
                    int i30 = zzizVar.zznk + iZza23;
                    while (iZza23 < i30) {
                        iZza23 = zziy.zzb(bArr, iZza23, zzizVar);
                        zzleVar5.zzv(zzjo.zzk(zzizVar.zznl));
                    }
                    if (iZza23 == i30) {
                        return iZza23;
                    }
                    throw zzkq.zzdi();
                }
                if (i6 == 0) {
                    zzle zzleVar6 = (zzle) zzkpVar;
                    int iZzb3 = zziy.zzb(bArr, i10, zzizVar);
                    zzleVar6.zzv(zzjo.zzk(zzizVar.zznl));
                    while (iZzb3 < i2) {
                        int iZza24 = zziy.zza(bArr, iZzb3, zzizVar);
                        if (i4 != zzizVar.zznk) {
                            return iZzb3;
                        }
                        iZzb3 = zziy.zzb(bArr, iZza24, zzizVar);
                        zzleVar6.zzv(zzjo.zzk(zzizVar.zznl));
                    }
                    return iZzb3;
                }
                return i10;
            case 49:
                if (i6 == 3) {
                    zzmf zzmfVarZzap = zzap(i7);
                    int i31 = (i4 & (-8)) | 4;
                    int iZza25 = zziy.zza(zzmfVarZzap, bArr, i, i2, i31, zzizVar);
                    zzmf zzmfVar = zzmfVarZzap;
                    int i32 = i2;
                    zziz zzizVar2 = zzizVar;
                    zzkpVar.add(zzizVar2.zznm);
                    while (iZza25 < i32) {
                        int iZza26 = zziy.zza(bArr, iZza25, zzizVar2);
                        if (i4 != zzizVar2.zznk) {
                            return iZza25;
                        }
                        zzmf zzmfVar2 = zzmfVar;
                        int i33 = i32;
                        zziz zzizVar3 = zzizVar2;
                        iZza25 = zziy.zza(zzmfVar2, bArr, iZza26, i33, i31, zzizVar3);
                        zzkpVar.add(zzizVar3.zznm);
                        zzmfVar = zzmfVar2;
                        i32 = i33;
                        zzizVar2 = zzizVar3;
                    }
                    return iZza25;
                }
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i4, long j, zziz zzizVar) throws zzkq {
        byte[] bArr2;
        zziz zzizVar2;
        int i5;
        Unsafe unsafe = zzuc;
        Object objZzaq = zzaq(i4);
        Object object = unsafe.getObject(t, j);
        if (this.zzut.zzj(object)) {
            Object objZzl = this.zzut.zzl(objZzaq);
            this.zzut.zzb(objZzl, object);
            unsafe.putObject(t, j, objZzl);
            object = objZzl;
        }
        zzlj<?, ?> zzljVarZzm = this.zzut.zzm(objZzaq);
        Map<?, ?> mapZzh = this.zzut.zzh(object);
        int iZza = zziy.zza(bArr, i, zzizVar);
        int i6 = zzizVar.zznk;
        if (i6 >= 0 && i6 <= i2 - iZza) {
            int i7 = i6 + iZza;
            K k = zzljVarZzm.zztv;
            V v = zzljVarZzm.zztx;
            while (iZza < i7) {
                int iZza2 = iZza + 1;
                int i8 = bArr[iZza];
                if (i8 < 0) {
                    iZza2 = zziy.zza(i8, bArr, iZza2, zzizVar);
                    i8 = zzizVar.zznk;
                }
                int i9 = iZza2;
                int i10 = i8 >>> 3;
                int i11 = i8 & 7;
                if (i10 != 1) {
                    if (i10 == 2 && i11 == zzljVarZzm.zztw.zzfk()) {
                        byte[] bArr3 = bArr;
                        int i12 = i2;
                        zziz zzizVar3 = zzizVar;
                        iZza = zza(bArr3, i9, i12, zzljVarZzm.zztw, zzljVarZzm.zztx.getClass(), zzizVar3);
                        v = (V) zzizVar3.zznm;
                        i2 = i12;
                        bArr = bArr3;
                    } else {
                        bArr2 = bArr;
                        i5 = i2;
                        zzizVar2 = zzizVar;
                    }
                } else {
                    bArr2 = bArr;
                    int i13 = i2;
                    zzizVar2 = zzizVar;
                    if (i11 == zzljVarZzm.zztu.zzfk()) {
                        i5 = i13;
                        iZza = zza(bArr2, i9, i5, zzljVarZzm.zztu, (Class<?>) null, zzizVar2);
                        k = zzizVar2.zznm;
                        bArr = bArr2;
                        i2 = i5;
                        zzizVar = zzizVar2;
                    } else {
                        i5 = i13;
                    }
                }
                iZza = zziy.zza(i8, bArr2, i9, i5, zzizVar2);
                k = k;
                bArr = bArr2;
                i2 = i5;
                zzizVar = zzizVar2;
            }
            if (iZza == i7) {
                mapZzh.put(k, v);
                return i7;
            }
            throw zzkq.zzdm();
        }
        throw zzkq.zzdi();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, int i8, long j, int i9, zziz zzizVar) throws zzkq {
        int i10;
        int i11;
        int iZzb;
        Object object;
        Unsafe unsafe = zzuc;
        long j2 = this.zzud[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                i10 = i;
                if (i6 != 1) {
                    return i10;
                }
                unsafe.putObject(t, j, Double.valueOf(zziy.zzc(bArr, i)));
                iZzb = i10 + 8;
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 52:
                i11 = i;
                if (i6 != 5) {
                    return i11;
                }
                unsafe.putObject(t, j, Float.valueOf(zziy.zzd(bArr, i)));
                iZzb = i11 + 4;
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Long.valueOf(zzizVar.zznl));
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                iZzb = zziy.zza(bArr, i, zzizVar);
                unsafe.putObject(t, j, Integer.valueOf(zzizVar.zznk));
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 56:
            case 65:
                i10 = i;
                if (i6 != 1) {
                    return i10;
                }
                unsafe.putObject(t, j, Long.valueOf(zziy.zzb(bArr, i)));
                iZzb = i10 + 8;
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 57:
            case 64:
                i11 = i;
                if (i6 != 5) {
                    return i11;
                }
                unsafe.putObject(t, j, Integer.valueOf(zziy.zza(bArr, i)));
                iZzb = i11 + 4;
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzizVar.zznl != 0));
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int iZza = zziy.zza(bArr, i, zzizVar);
                int i12 = zzizVar.zznk;
                if (i12 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i7 & 536870912) != 0 && !zznf.zze(bArr, iZza, iZza + i12)) {
                        throw zzkq.zzdn();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i12, zzkm.UTF_8));
                    iZza += i12;
                }
                unsafe.putInt(t, j2, i5);
                return iZza;
            case 60:
                if (i6 != 2) {
                    return i;
                }
                int iZza2 = zziy.zza(zzap(i9), bArr, i, i2, zzizVar);
                object = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzizVar.zznm);
                } else {
                    unsafe.putObject(t, j, zzkm.zza(object, zzizVar.zznm));
                }
                unsafe.putInt(t, j2, i5);
                return iZza2;
            case 61:
                if (i6 != 2) {
                    return i;
                }
                iZzb = zziy.zze(bArr, i, zzizVar);
                unsafe.putObject(t, j, zzizVar.zznm);
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 63:
                if (i6 != 0) {
                    return i;
                }
                int iZza3 = zziy.zza(bArr, i, zzizVar);
                int i13 = zzizVar.zznk;
                zzko zzkoVarZzar = zzar(i9);
                if (zzkoVarZzar != null && !zzkoVarZzar.zzan(i13)) {
                    zzo(t).zzb(i4, Long.valueOf(i13));
                    return iZza3;
                }
                unsafe.putObject(t, j, Integer.valueOf(i13));
                iZzb = iZza3;
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 66:
                if (i6 != 0) {
                    return i;
                }
                iZzb = zziy.zza(bArr, i, zzizVar);
                unsafe.putObject(t, j, Integer.valueOf(zzjo.zzw(zzizVar.zznk)));
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 67:
                if (i6 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Long.valueOf(zzjo.zzk(zzizVar.zznl)));
                unsafe.putInt(t, j2, i5);
                return iZzb;
            case 68:
                if (i6 == 3) {
                    iZzb = zziy.zza(zzap(i9), bArr, i, i2, (i4 & (-8)) | 4, zzizVar);
                    object = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzizVar.zznm);
                    } else {
                        unsafe.putObject(t, j, zzkm.zza(object, zzizVar.zznm));
                    }
                    unsafe.putInt(t, j2, i5);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x0469, code lost:
    
        if (r10 == (-1)) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x046b, code lost:
    
        r25.putInt(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0471, code lost:
    
        r10 = r8.zzun;
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0478, code lost:
    
        if (r10 >= r8.zzuo) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x047a, code lost:
    
        r1 = r8.zzum[r10];
        r6 = r8.zzur;
        r2 = r8.zzud[r1];
        r0 = com.google.android.gms.internal.drive.zznd.zzo(r9, r8.zzas(r1) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x048f, code lost:
    
        if (r0 != null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0492, code lost:
    
        r4 = r8.zzar(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0496, code lost:
    
        if (r4 != null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0498, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x049a, code lost:
    
        r3 = r8.zzut.zzh(r0);
        r0 = r8;
        r5 = r0.zza(r1, r2, r3, r4, r5, (com.google.android.gms.internal.drive.zzmx<UT, java.lang.Object>) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x04a5, code lost:
    
        r5 = (com.google.android.gms.internal.drive.zzmy) r5;
        r10 = r10 + 1;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04ab, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x04ac, code lost:
    
        if (r5 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04ae, code lost:
    
        r0.zzur.zzf(r9, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04b3, code lost:
    
        if (r33 != 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04b5, code lost:
    
        if (r7 != r13) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x04bc, code lost:
    
        throw com.google.android.gms.internal.drive.zzkq.zzdm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04bd, code lost:
    
        if (r7 > r13) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x04bf, code lost:
    
        if (r12 != r33) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x04c1, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x04c6, code lost:
    
        throw com.google.android.gms.internal.drive.zzkq.zzdm();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(T t, byte[] bArr, int i, int i2, int i4, zziz zzizVar) throws zzkq {
        Object obj;
        int i5;
        Unsafe unsafe;
        zzlu<T> zzluVar;
        int i6;
        int iZzau;
        int i7;
        int i8;
        zziz zzizVar2;
        int i9;
        Unsafe unsafe2;
        byte[] bArr2;
        int i10;
        byte[] bArr3;
        int i11;
        int iZzb;
        byte[] bArr4;
        int i12;
        byte[] bArr5;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        zzlu<T> zzluVar2 = this;
        Object obj2 = t;
        byte[] bArr6 = bArr;
        int i18 = i2;
        zziz zzizVar3 = zzizVar;
        Unsafe unsafe3 = zzuc;
        int iZza = i;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = -1;
        while (true) {
            if (iZza < i18) {
                int iZza2 = iZza + 1;
                int i24 = bArr6[iZza];
                if (i24 < 0) {
                    iZza2 = zziy.zza(i24, bArr6, iZza2, zzizVar3);
                    i24 = zzizVar3.zznk;
                }
                int i25 = iZza2;
                int i26 = i24;
                int i27 = (i26 == true ? 1 : 0) >>> 3;
                int i28 = i19;
                int i29 = (i26 == true ? 1 : 0) & 7;
                if (i27 > i22) {
                    iZzau = zzluVar2.zzp(i27, i28 / 3);
                } else {
                    iZzau = zzluVar2.zzau(i27);
                }
                int i30 = iZzau;
                if (i30 == -1) {
                    obj = obj2;
                    i7 = i25;
                    unsafe = unsafe3;
                    i22 = i27;
                    i19 = 0;
                    zzluVar = zzluVar2;
                    i8 = i26 == true ? 1 : 0;
                } else {
                    int[] iArr = zzluVar2.zzud;
                    int i31 = iArr[i30 + 1];
                    int i32 = (i31 & 267386880) >>> 20;
                    long j = i31 & 1048575;
                    if (i32 <= 17) {
                        int i33 = iArr[i30 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i23) {
                            if (i23 != -1) {
                                unsafe3.putInt(obj2, i23, i20);
                            }
                            i23 = i35;
                            i20 = unsafe3.getInt(obj2, i35);
                        }
                        switch (i32) {
                            case 0:
                                unsafe2 = unsafe3;
                                i9 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 1) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    zznd.zza(obj2, j, zziy.zzc(bArr2, i9));
                                    iZza = i9 + 8;
                                    i20 |= i34;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 1:
                                unsafe2 = unsafe3;
                                i9 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 5) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    zznd.zza(obj2, j, zziy.zzd(bArr2, i9));
                                    iZza = i9 + 4;
                                    i20 |= i34;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe2 = unsafe3;
                                i9 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 0) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    int iZzb2 = zziy.zzb(bArr2, i9, zzizVar2);
                                    unsafe2.putLong(t, j, zzizVar2.zznl);
                                    unsafe2 = unsafe2;
                                    obj2 = t;
                                    i20 |= i34;
                                    iZza = iZzb2;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 4:
                            case 11:
                                unsafe2 = unsafe3;
                                i9 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 0) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZza = zziy.zza(bArr2, i9, zzizVar2);
                                    unsafe2.putInt(obj2, j, zzizVar2.zznk);
                                    i20 |= i34;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 5:
                            case 14:
                                unsafe2 = unsafe3;
                                i10 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 1) {
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    i9 = i10;
                                    unsafe2.putLong(t, j, zziy.zzb(bArr2, i10));
                                    unsafe2 = unsafe2;
                                    obj2 = t;
                                    iZza = i9 + 8;
                                    i20 |= i34;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 6:
                            case 13:
                                unsafe2 = unsafe3;
                                i10 = i25;
                                bArr2 = bArr;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 5) {
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    unsafe2.putInt(obj2, j, zziy.zza(bArr2, i10));
                                    iZza = i10 + 4;
                                    i20 |= i34;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                }
                                break;
                            case 7:
                                bArr3 = bArr;
                                unsafe2 = unsafe3;
                                i11 = i25;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 0) {
                                    i9 = i11;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZzb = zziy.zzb(bArr3, i11, zzizVar2);
                                    zznd.zza(obj2, j, zzizVar2.zznl != 0);
                                    i20 |= i34;
                                    byte[] bArr7 = bArr3;
                                    iZza = iZzb;
                                    bArr6 = bArr7;
                                    unsafe3 = unsafe2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    i18 = i2;
                                }
                                break;
                            case 8:
                                bArr3 = bArr;
                                unsafe2 = unsafe3;
                                i11 = i25;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 2) {
                                    i9 = i11;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    if ((536870912 & i31) == 0) {
                                        iZzb = zziy.zzc(bArr3, i11, zzizVar2);
                                    } else {
                                        iZzb = zziy.zzd(bArr3, i11, zzizVar2);
                                    }
                                    unsafe2.putObject(obj2, j, zzizVar2.zznm);
                                    i20 |= i34;
                                    byte[] bArr72 = bArr3;
                                    iZza = iZzb;
                                    bArr6 = bArr72;
                                    unsafe3 = unsafe2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    i18 = i2;
                                }
                                break;
                            case 9:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i25;
                                i12 = i2;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 2) {
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZza = zziy.zza(zzluVar2.zzap(i30), bArr4, i10, i12, zzizVar2);
                                    if ((i20 & i34) == 0) {
                                        unsafe2.putObject(obj2, j, zzizVar2.zznm);
                                    } else {
                                        unsafe2.putObject(obj2, j, zzkm.zza(unsafe2.getObject(obj2, j), zzizVar2.zznm));
                                    }
                                    i20 |= i34;
                                    int i36 = i12;
                                    unsafe3 = unsafe2;
                                    i18 = i36;
                                    bArr6 = bArr4;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                }
                                break;
                            case 10:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i25;
                                i12 = i2;
                                i21 = i26 == true ? 1 : 0;
                                zzizVar2 = zzizVar;
                                if (i29 != 2) {
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZza = zziy.zze(bArr4, i10, zzizVar2);
                                    unsafe2.putObject(obj2, j, zzizVar2.zznm);
                                    i20 |= i34;
                                    int i362 = i12;
                                    unsafe3 = unsafe2;
                                    i18 = i362;
                                    bArr6 = bArr4;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                }
                                break;
                            case 12:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i25;
                                i12 = i2;
                                zzizVar2 = zzizVar;
                                if (i29 != 0) {
                                    i21 = i26 == true ? 1 : 0;
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZza = zziy.zza(bArr4, i10, zzizVar2);
                                    int i37 = zzizVar2.zznk;
                                    zzko zzkoVarZzar = zzluVar2.zzar(i30);
                                    if (zzkoVarZzar != null && !zzkoVarZzar.zzan(i37)) {
                                        zzmy zzmyVarZzo = zzo(obj2);
                                        Long lValueOf = Long.valueOf(i37);
                                        i21 = i26 == true ? 1 : 0;
                                        zzmyVarZzo.zzb(i21 == true ? 1 : 0, lValueOf);
                                        int i3622 = i12;
                                        unsafe3 = unsafe2;
                                        i18 = i3622;
                                        bArr6 = bArr4;
                                        zzizVar3 = zzizVar2;
                                        i19 = i30;
                                        i22 = i27;
                                    } else {
                                        i21 = i26 == true ? 1 : 0;
                                        unsafe2.putInt(obj2, j, i37);
                                        i20 |= i34;
                                        int i36222 = i12;
                                        unsafe3 = unsafe2;
                                        i18 = i36222;
                                        bArr6 = bArr4;
                                        zzizVar3 = zzizVar2;
                                        i19 = i30;
                                        i22 = i27;
                                    }
                                }
                                break;
                            case 15:
                                bArr5 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i25;
                                zzizVar2 = zzizVar;
                                if (i29 != 0) {
                                    i21 = i26 == true ? 1 : 0;
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    iZza = zziy.zza(bArr5, i10, zzizVar2);
                                    unsafe2.putInt(obj2, j, zzjo.zzw(zzizVar2.zznk));
                                    i20 |= i34;
                                    unsafe3 = unsafe2;
                                    i18 = i2;
                                    bArr6 = bArr5;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i21 = i26 == true ? 1 : 0;
                                    i22 = i27;
                                }
                                break;
                            case 16:
                                bArr5 = bArr;
                                i10 = i25;
                                if (i29 != 0) {
                                    zzizVar2 = zzizVar;
                                    unsafe2 = unsafe3;
                                    i21 = i26 == true ? 1 : 0;
                                    i9 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    int iZzb3 = zziy.zzb(bArr5, i10, zzizVar);
                                    zzizVar2 = zzizVar;
                                    Object obj3 = obj2;
                                    Unsafe unsafe4 = unsafe3;
                                    unsafe4.putLong(obj3, j, zzjo.zzk(zzizVar.zznl));
                                    obj2 = obj3;
                                    i20 |= i34;
                                    unsafe3 = unsafe4;
                                    i18 = i2;
                                    iZza = iZzb3;
                                    bArr6 = bArr5;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i21 = i26 == true ? 1 : 0;
                                    i22 = i27;
                                }
                                break;
                            case 17:
                                if (i29 != 3) {
                                    zzizVar2 = zzizVar;
                                    i9 = i25;
                                    unsafe2 = unsafe3;
                                    i21 = i26 == true ? 1 : 0;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i7 = i9;
                                    i8 = i21;
                                    zzizVar3 = zzizVar2;
                                    i19 = i30;
                                    i22 = i27;
                                    obj = obj2;
                                } else {
                                    int iZza3 = zziy.zza(zzluVar2.zzap(i30), bArr, i25, i2, (i27 << 3) | 4, zzizVar);
                                    if ((i20 & i34) == 0) {
                                        unsafe3.putObject(obj2, j, zzizVar.zznm);
                                    } else {
                                        unsafe3.putObject(obj2, j, zzkm.zza(unsafe3.getObject(obj2, j), zzizVar.zznm));
                                    }
                                    i20 |= i34;
                                    i18 = i2;
                                    zzizVar3 = zzizVar;
                                    i19 = i30;
                                    i21 = i26 == true ? 1 : 0;
                                    i22 = i27;
                                    iZza = iZza3;
                                    bArr6 = bArr;
                                }
                                break;
                            default:
                                zzizVar2 = zzizVar;
                                unsafe2 = unsafe3;
                                i9 = i25;
                                i21 = i26 == true ? 1 : 0;
                                zzluVar = zzluVar2;
                                unsafe = unsafe2;
                                i7 = i9;
                                i8 = i21;
                                zzizVar3 = zzizVar2;
                                i19 = i30;
                                i22 = i27;
                                obj = obj2;
                                break;
                        }
                    } else {
                        zziz zzizVar4 = zzizVar3;
                        Unsafe unsafe5 = unsafe3;
                        i21 = i26 == true ? 1 : 0;
                        if (i32 != 27) {
                            i13 = i25;
                            if (i32 <= 49) {
                                i14 = i23;
                                unsafe = unsafe5;
                                i15 = i20;
                                int iZza4 = zzluVar2.zza(t, bArr, i13, i2, i21 == true ? 1 : 0, i27, i29, i30, i31, i32, j, zzizVar);
                                i16 = i21 == true ? 1 : 0;
                                i17 = i30;
                                if (iZza4 == i13) {
                                    zzluVar = this;
                                    obj = t;
                                    zzizVar3 = zzizVar;
                                    i7 = iZza4;
                                } else {
                                    zzluVar2 = this;
                                    obj2 = t;
                                    bArr6 = bArr;
                                    i18 = i2;
                                    zzizVar3 = zzizVar;
                                    iZza = iZza4;
                                    i19 = i17;
                                    i23 = i14;
                                    i20 = i15;
                                    i21 = i16;
                                    i22 = i27;
                                    unsafe3 = unsafe;
                                }
                            } else {
                                unsafe = unsafe5;
                                i14 = i23;
                                i15 = i20;
                                i16 = i21 == true ? 1 : 0;
                                i17 = i30;
                                if (i32 != 50) {
                                    i22 = i27;
                                    int iZza5 = zza(t, bArr, i13, i2, i16 == true ? 1 : 0, i22, i29, i31, i32, j, i17, zzizVar);
                                    zzluVar = this;
                                    obj = t;
                                    i8 = i16 == true ? 1 : 0;
                                    zzizVar3 = zzizVar;
                                    if (iZza5 == i13) {
                                        i7 = iZza5;
                                        i19 = i17;
                                        i23 = i14;
                                        i20 = i15;
                                    } else {
                                        bArr6 = bArr;
                                        i18 = i2;
                                        zzizVar3 = zzizVar;
                                        iZza = iZza5;
                                        obj2 = obj;
                                        i19 = i17;
                                        i23 = i14;
                                        i20 = i15;
                                        i21 = i8 == true ? 1 : 0;
                                        zzluVar2 = zzluVar;
                                        unsafe3 = unsafe;
                                    }
                                } else if (i29 == 2) {
                                    int iZza6 = zza(t, bArr, i13, i2, i17, j, zzizVar);
                                    if (iZza6 == i13) {
                                        zzluVar = this;
                                        obj = t;
                                        zzizVar3 = zzizVar;
                                        i7 = iZza6;
                                    } else {
                                        zzluVar2 = this;
                                        obj2 = t;
                                        bArr6 = bArr;
                                        i18 = i2;
                                        zzizVar3 = zzizVar;
                                        iZza = iZza6;
                                        i19 = i17;
                                        i23 = i14;
                                        i20 = i15;
                                        i21 = i16;
                                        i22 = i27;
                                        unsafe3 = unsafe;
                                    }
                                } else {
                                    zzluVar = this;
                                    obj = t;
                                    zzizVar3 = zzizVar;
                                    i7 = i13;
                                }
                            }
                        } else if (i29 == 2) {
                            zzkp zzkpVarZzr = (zzkp) unsafe5.getObject(obj2, j);
                            if (!zzkpVarZzr.zzbo()) {
                                int size = zzkpVarZzr.size();
                                zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
                                unsafe5.putObject(obj2, j, zzkpVarZzr);
                            }
                            unsafe3 = unsafe5;
                            int iZza7 = zziy.zza(zzluVar2.zzap(i30), i21 == true ? 1 : 0, bArr, i25, i2, zzkpVarZzr, zzizVar4);
                            bArr6 = bArr;
                            i18 = i2;
                            zzizVar3 = zzizVar;
                            iZza = iZza7;
                            i19 = i30;
                            i22 = i27;
                            obj2 = t;
                        } else {
                            i13 = i25;
                            unsafe = unsafe5;
                            i14 = i23;
                            i15 = i20;
                            i16 = i21 == true ? 1 : 0;
                            i17 = i30;
                            zzluVar = this;
                            obj = t;
                            zzizVar3 = zzizVar;
                            i7 = i13;
                        }
                        i19 = i17;
                        i23 = i14;
                        i20 = i15;
                        i8 = i16;
                        i22 = i27;
                    }
                }
                if (i8 != i4 || i4 == 0) {
                    if (zzluVar.zzui && zzizVar3.zznn != zzjx.zzci()) {
                        if (zzizVar3.zznn.zza(zzluVar.zzuh, i22) == null) {
                            int iZza8 = zziy.zza(i8, bArr, i7, i2, zzo(obj), zzizVar3);
                            i18 = i2;
                            zzizVar3 = zzizVar;
                            i21 = i8;
                            iZza = iZza8;
                            zzluVar2 = zzluVar;
                            obj2 = obj;
                            unsafe3 = unsafe;
                        } else {
                            zzkk.zzc zzcVar = (zzkk.zzc) obj;
                            zzcVar.zzdg();
                            zzkb<Object> zzkbVar = zzcVar.zzrw;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        zzizVar3 = zzizVar;
                        int iZza9 = zziy.zza(i8, bArr, i7, i2, zzo(obj), zzizVar3);
                        i21 = i8;
                        i18 = i2;
                        zzluVar2 = zzluVar;
                        obj2 = obj;
                        unsafe3 = unsafe;
                        iZza = iZza9;
                    }
                    bArr6 = bArr;
                } else {
                    i5 = i2;
                    i21 = i8;
                    i6 = i7;
                }
            } else {
                obj = obj2;
                i5 = i18;
                unsafe = unsafe3;
                zzluVar = zzluVar2;
                i6 = iZza;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x005c. Please report as an issue. */
    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zza(T t, byte[] bArr, int i, int i2, zziz zzizVar) throws zzkq {
        int iZzau;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        boolean z;
        Unsafe unsafe2;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        boolean z4;
        int iZzb;
        T t2;
        zzlu<T> zzluVar = this;
        byte[] bArr2 = bArr;
        int i11 = i2;
        zziz zzizVar2 = zzizVar;
        if (zzluVar.zzuk) {
            Unsafe unsafe3 = zzuc;
            int i12 = -1;
            int iZza = i;
            int i13 = -1;
            int i14 = 0;
            while (iZza < i11) {
                int iZza2 = iZza + 1;
                int i15 = bArr2[iZza];
                if (i15 < 0) {
                    iZza2 = zziy.zza(i15, bArr2, iZza2, zzizVar2);
                    i15 = zzizVar2.zznk;
                }
                int i16 = iZza2;
                int i17 = i15;
                int i18 = (i17 == true ? 1 : 0) >>> 3;
                int i19 = (i17 == true ? 1 : 0) & 7;
                if (i18 > i13) {
                    iZzau = zzluVar.zzp(i18, i14 / 3);
                } else {
                    iZzau = zzluVar.zzau(i18);
                }
                int i20 = iZzau;
                if (i20 == i12) {
                    unsafe = unsafe3;
                    i4 = i16;
                    i5 = i18;
                    i6 = 0;
                    z = i17 == true ? 1 : 0;
                } else {
                    int i21 = zzluVar.zzud[i20 + 1];
                    int i22 = (267386880 & i21) >>> 20;
                    long j = 1048575 & i21;
                    if (i22 <= 17) {
                        switch (i22) {
                            case 0:
                                unsafe2 = unsafe3;
                                if (i19 != 1) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    zznd.zza(t, j, zziy.zzc(bArr2, i16));
                                    iZza = i16 + 8;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 1:
                                unsafe2 = unsafe3;
                                if (i19 != 5) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    zznd.zza((Object) t, j, zziy.zzd(bArr2, i16));
                                    iZza = i16 + 4;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZzb = zziy.zzb(bArr2, i16, zzizVar2);
                                    t2 = t;
                                    unsafe3 = unsafe2;
                                    unsafe3.putLong(t2, j, zzizVar2.zznl);
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 4:
                            case 11:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzizVar2.zznk);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                unsafe2 = unsafe3;
                                if (i19 != 1) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    unsafe2.putLong(t, j, zziy.zzb(bArr2, i16));
                                    unsafe2 = unsafe2;
                                    iZza = i16 + 8;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                unsafe2 = unsafe3;
                                if (i19 != 5) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    unsafe2.putInt(t, j, zziy.zza(bArr2, i16));
                                    iZza = i16 + 4;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 7:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    int iZzb2 = zziy.zzb(bArr2, i16, zzizVar2);
                                    zznd.zza(t, j, zzizVar2.zznl != 0);
                                    iZza = iZzb2;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 8:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    if ((536870912 & i21) == 0) {
                                        iZza = zziy.zzc(bArr2, i16, zzizVar2);
                                    } else {
                                        iZza = zziy.zzd(bArr2, i16, zzizVar2);
                                    }
                                    unsafe2.putObject(t, j, zzizVar2.zznm);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 9:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZza = zziy.zza(zzluVar.zzap(i20), bArr2, i16, i11, zzizVar2);
                                    Object object = unsafe2.getObject(t, j);
                                    if (object == null) {
                                        unsafe2.putObject(t, j, zzizVar2.zznm);
                                    } else {
                                        unsafe2.putObject(t, j, zzkm.zza(object, zzizVar2.zznm));
                                    }
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 10:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZza = zziy.zze(bArr2, i16, zzizVar2);
                                    unsafe2.putObject(t, j, zzizVar2.zznm);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 12:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzizVar2.zznk);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 15:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzjo.zzw(zzizVar2.zznk));
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            case 16:
                                if (i19 != 0) {
                                    unsafe2 = unsafe3;
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    z4 = i17 == true ? 1 : 0;
                                } else {
                                    iZzb = zziy.zzb(bArr2, i16, zzizVar2);
                                    t2 = t;
                                    unsafe3.putLong(t2, j, zzjo.zzk(zzizVar2.zznl));
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                }
                                break;
                            default:
                                unsafe = unsafe3;
                                i10 = i16;
                                i9 = i18;
                                i8 = i20;
                                z4 = i17 == true ? 1 : 0;
                                break;
                        }
                    } else {
                        unsafe2 = unsafe3;
                        if (i22 != 27) {
                            unsafe = unsafe2;
                            if (i22 <= 49) {
                                int iZza3 = zzluVar.zza(t, bArr, i16, i2, i17 == true ? 1 : 0, i18, i19, i20, i21, i22, j, zzizVar);
                                z2 = i17 == true ? 1 : 0;
                                i7 = i20;
                                if (iZza3 == i16) {
                                    i4 = iZza3;
                                    i5 = i18;
                                    i6 = i7;
                                    z = z2;
                                } else {
                                    zzluVar = this;
                                    i11 = i2;
                                    zzizVar2 = zzizVar;
                                    i14 = i7;
                                    iZza = iZza3;
                                    i13 = i18;
                                }
                            } else {
                                i8 = i20;
                                i9 = i18;
                                boolean z5 = i17 == true ? 1 : 0;
                                if (i22 != 50) {
                                    i5 = i9;
                                    int iZza4 = zza(t, bArr, i16, i2, z5 ? 1 : 0, i5, i19, i21, i22, j, i8, zzizVar);
                                    z2 = z5 ? 1 : 0;
                                    i7 = i8;
                                    if (iZza4 == i16) {
                                        i4 = iZza4;
                                        i6 = i7;
                                        z = z2;
                                    } else {
                                        zzluVar = this;
                                        i11 = i2;
                                        zzizVar2 = zzizVar;
                                        i14 = i7;
                                        i13 = i5;
                                        iZza = iZza4;
                                    }
                                } else if (i19 == 2) {
                                    int iZza5 = zza(t, bArr, i16, i2, i8, j, zzizVar);
                                    if (iZza5 == i16) {
                                        i6 = i8;
                                        i4 = iZza5;
                                        z3 = z5;
                                        i5 = i9;
                                        z = z3;
                                    } else {
                                        zzluVar = this;
                                        bArr2 = bArr;
                                        i11 = i2;
                                        zzizVar2 = zzizVar;
                                        i14 = i8;
                                        iZza = iZza5;
                                        i13 = i9;
                                    }
                                } else {
                                    i10 = i16;
                                    z4 = z5;
                                }
                            }
                            unsafe3 = unsafe;
                            i12 = -1;
                            bArr2 = bArr;
                        } else if (i19 == 2) {
                            zzkp zzkpVarZzr = (zzkp) unsafe2.getObject(t, j);
                            if (!zzkpVarZzr.zzbo()) {
                                int size = zzkpVarZzr.size();
                                zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t, j, zzkpVarZzr);
                            }
                            unsafe = unsafe2;
                            iZza = zziy.zza(zzluVar.zzap(i20), i17 == true ? 1 : 0, bArr2, i16, i11, zzkpVarZzr, zzizVar2);
                            bArr2 = bArr;
                            i11 = i2;
                            zzizVar2 = zzizVar;
                            i13 = i18;
                            i14 = i20;
                        } else {
                            unsafe = unsafe2;
                            i10 = i16;
                            i9 = i18;
                            i8 = i20;
                            z4 = i17 == true ? 1 : 0;
                        }
                        unsafe3 = unsafe;
                        i12 = -1;
                    }
                    i4 = i10;
                    i6 = i8;
                    z3 = z4;
                    i5 = i9;
                    z = z3;
                }
                iZza = zziy.zza(z ? 1 : 0, bArr, i4, i2, zzo(t), zzizVar);
                zzluVar = this;
                zzizVar2 = zzizVar;
                i11 = i2;
                i13 = i5;
                i14 = i6;
                unsafe3 = unsafe;
                i12 = -1;
                bArr2 = bArr;
            }
            if (iZza != i11) {
                throw zzkq.zzdm();
            }
            return;
        }
        zza(t, bArr, i, i11, 0, zzizVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzko zzkoVar, UB ub, zzmx<UT, UB> zzmxVar) {
        zzlj<?, ?> zzljVarZzm = this.zzut.zzm(zzaq(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzkoVar.zzan(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmxVar.zzez();
                }
                zzjk zzjkVarZzu = zzjc.zzu(zzli.zza(zzljVarZzm, next.getKey(), next.getValue()));
                try {
                    zzli.zza(zzjkVarZzu.zzby(), zzljVarZzm, next.getKey(), next.getValue());
                    zzmxVar.zza(ub, i2, zzjkVarZzu.zzbx());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzmf zzmfVar) {
        return zzmfVar.zzp(zznd.zzo(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzns zznsVar) {
        if (obj instanceof String) {
            zznsVar.zza(i, (String) obj);
        } else {
            zznsVar.zza(i, (zzjc) obj);
        }
    }

    private final boolean zza(T t, int i, int i2, int i4) {
        if (this.zzuk) {
            return zza(t, i);
        }
        return (i2 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzuk) {
            int iZzas = zzas(i);
            long j = iZzas & 1048575;
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    return zznd.zzn(t, j) != 0.0d;
                case 1:
                    return zznd.zzm(t, j) != 0.0f;
                case 2:
                    return zznd.zzk(t, j) != 0;
                case 3:
                    return zznd.zzk(t, j) != 0;
                case 4:
                    return zznd.zzj(t, j) != 0;
                case 5:
                    return zznd.zzk(t, j) != 0;
                case 6:
                    return zznd.zzj(t, j) != 0;
                case 7:
                    return zznd.zzl(t, j);
                case 8:
                    Object objZzo = zznd.zzo(t, j);
                    if (objZzo instanceof String) {
                        return !((String) objZzo).isEmpty();
                    }
                    if (objZzo instanceof zzjc) {
                        return !zzjc.zznq.equals(objZzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zznd.zzo(t, j) != null;
                case 10:
                    return !zzjc.zznq.equals(zznd.zzo(t, j));
                case 11:
                    return zznd.zzj(t, j) != 0;
                case 12:
                    return zznd.zzj(t, j) != 0;
                case 13:
                    return zznd.zzj(t, j) != 0;
                case 14:
                    return zznd.zzk(t, j) != 0;
                case 15:
                    return zznd.zzj(t, j) != 0;
                case 16:
                    return zznd.zzk(t, j) != 0;
                case 17:
                    return zznd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iZzat = zzat(i);
        return (zznd.zzj(t, (long) (iZzat & 1048575)) & (1 << (iZzat >>> 20))) != 0;
    }

    private final boolean zza(T t, int i, int i2) {
        return zznd.zzj(t, (long) (zzat(i2) & 1048575)) == i;
    }
}
