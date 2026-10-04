package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import p001A.AbstractC0000a;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i, int i2, zzfw zzfwVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = z;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
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
            StringBuilder sbM16m = AbstractC0000a.m16m("Field ", str, " for ", name, " not found. Known fields are ");
            sbM16m.append(string);
            throw new RuntimeException(sbM16m.toString());
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        long jZzv = zzv(i) & 1048575;
        if (zzG(obj2, i)) {
            Object objZzf = zzhi.zzf(obj, jZzv);
            Object objZzf2 = zzhi.zzf(obj2, jZzv);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, jZzv, zzez.zzg(objZzf, objZzf2));
                zzD(obj, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, jZzv, objZzf2);
                zzD(obj, i);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int iZzv = zzv(i);
        int i2 = this.zzc[i];
        long j = iZzv & 1048575;
        if (zzJ(obj2, i2, i)) {
            Object objZzf = zzJ(obj, i2, i) ? zzhi.zzf(obj, j) : null;
            Object objZzf2 = zzhi.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, j, zzez.zzg(objZzf, objZzf2));
                zzE(obj, i2, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, j, objZzf2);
                zzE(obj, i2, i);
            }
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzs = zzs(i);
        long j = 1048575 & iZzs;
        if (j == 1048575) {
            return;
        }
        zzhi.zzn(obj, j, (1 << (iZzs >>> 20)) | zzhi.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhi.zzn(obj, zzs(i2) & 1048575, i);
    }

    private final boolean zzF(Object obj, Object obj2, int i) {
        return zzG(obj, i) == zzG(obj2, i);
    }

    private final boolean zzG(Object obj, int i) {
        int iZzs = zzs(i);
        long j = iZzs & 1048575;
        if (j != 1048575) {
            return (zzhi.zzc(obj, j) & (1 << (iZzs >>> 20))) != 0;
        }
        int iZzv = zzv(i);
        long j2 = iZzv & 1048575;
        switch (zzu(iZzv)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j2)) != 0;
            case 2:
                return zzhi.zzd(obj, j2) != 0;
            case 3:
                return zzhi.zzd(obj, j2) != 0;
            case 4:
                return zzhi.zzc(obj, j2) != 0;
            case 5:
                return zzhi.zzd(obj, j2) != 0;
            case 6:
                return zzhi.zzc(obj, j2) != 0;
            case 7:
                return zzhi.zzt(obj, j2);
            case 8:
                Object objZzf = zzhi.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzee) {
                    return !zzee.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j2) != null;
            case 10:
                return !zzee.zzb.equals(zzhi.zzf(obj, j2));
            case 11:
                return zzhi.zzc(obj, j2) != 0;
            case 12:
                return zzhi.zzc(obj, j2) != 0;
            case 13:
                return zzhi.zzc(obj, j2) != 0;
            case 14:
                return zzhi.zzd(obj, j2) != 0;
            case 15:
                return zzhi.zzc(obj, j2) != 0;
            case 16:
                return zzhi.zzd(obj, j2) != 0;
            case 17:
                return zzhi.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(Object obj, int i, int i2, int i4, int i5) {
        return i2 == 1048575 ? zzG(obj, i) : (i4 & i5) != 0;
    }

    private static boolean zzI(Object obj, int i, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i & 1048575));
    }

    private final boolean zzJ(Object obj, int i, int i2) {
        return zzhi.zzc(obj, (long) (zzs(i2) & 1048575)) == i;
    }

    public static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzgzVarZzc = zzgz.zzc();
        zzeuVar.zzc = zzgzVarZzc;
        return zzgzVarZzc;
    }

    public static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0371  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzfz zzk(zzgg zzggVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Field fieldZzA;
        char cCharAt9;
        int i23;
        int i24;
        Object obj;
        Field fieldZzA2;
        Object obj2;
        Field fieldZzA3;
        int i25;
        char cCharAt10;
        int i26;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        boolean z = zzggVar.zzc() == 2;
        String strZzd = zzggVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt5 = strZzd.charAt(i);
        if (iCharAt5 >= 55296) {
            int i32 = iCharAt5 & 8191;
            int i33 = 13;
            while (true) {
                i29 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i29;
            }
            iCharAt5 = i32 | (cCharAt13 << i33);
            i31 = i29;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i4 = 0;
            iCharAt4 = 0;
            i2 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt6 = strZzd.charAt(i31);
            if (iCharAt6 >= 55296) {
                int i35 = iCharAt6 & 8191;
                int i36 = 13;
                while (true) {
                    i13 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i13;
                }
                iCharAt6 = i35 | (cCharAt8 << i36);
                i34 = i13;
            }
            int i37 = i34 + 1;
            int iCharAt7 = strZzd.charAt(i34);
            if (iCharAt7 >= 55296) {
                int i38 = iCharAt7 & 8191;
                int i39 = 13;
                while (true) {
                    i12 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i12;
                }
                iCharAt7 = i38 | (cCharAt7 << i39);
                i37 = i12;
            }
            int i40 = i37 + 1;
            iCharAt = strZzd.charAt(i37);
            if (iCharAt >= 55296) {
                int i41 = iCharAt & 8191;
                int i42 = 13;
                while (true) {
                    i11 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i11;
                }
                iCharAt = i41 | (cCharAt6 << i42);
                i40 = i11;
            }
            int i43 = i40 + 1;
            iCharAt2 = strZzd.charAt(i40);
            if (iCharAt2 >= 55296) {
                int i44 = iCharAt2 & 8191;
                int i45 = 13;
                while (true) {
                    i10 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i10;
                }
                iCharAt2 = i44 | (cCharAt5 << i45);
                i43 = i10;
            }
            int i46 = i43 + 1;
            iCharAt3 = strZzd.charAt(i43);
            if (iCharAt3 >= 55296) {
                int i47 = iCharAt3 & 8191;
                int i48 = 13;
                while (true) {
                    i9 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i9;
                }
                iCharAt3 = i47 | (cCharAt4 << i48);
                i46 = i9;
            }
            int i49 = i46 + 1;
            int iCharAt8 = strZzd.charAt(i46);
            if (iCharAt8 >= 55296) {
                int i50 = iCharAt8 & 8191;
                int i51 = 13;
                while (true) {
                    i8 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i8;
                }
                iCharAt8 = i50 | (cCharAt3 << i51);
                i49 = i8;
            }
            int i52 = i49 + 1;
            int iCharAt9 = strZzd.charAt(i49);
            if (iCharAt9 >= 55296) {
                int i53 = iCharAt9 & 8191;
                int i54 = 13;
                while (true) {
                    i7 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i7;
                }
                iCharAt9 = i53 | (cCharAt2 << i54);
                i52 = i7;
            }
            int i55 = i52 + 1;
            iCharAt4 = strZzd.charAt(i52);
            if (iCharAt4 >= 55296) {
                int i56 = iCharAt4 & 8191;
                int i57 = 13;
                while (true) {
                    i6 = i55 + 1;
                    cCharAt = strZzd.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i6;
                }
                iCharAt4 = i56 | (cCharAt << i57);
                i55 = i6;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = iCharAt6 + iCharAt6 + iCharAt7;
            i4 = iCharAt8;
            iArr = iArr2;
            i5 = iCharAt6;
            i31 = i55;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzggVar.zze();
        Class<?> cls = zzggVar.zza().getClass();
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 + iCharAt3];
        int i58 = i4 + iCharAt4;
        int i59 = i58;
        int i60 = iCharAt4;
        int i61 = 0;
        int i62 = 0;
        while (i31 < length) {
            int i63 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= c) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i28 = i65 + 1;
                    cCharAt12 = strZzd.charAt(i65);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i28;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i14 = i28;
            } else {
                i14 = i63;
            }
            int i67 = i14 + 1;
            int iCharAt11 = strZzd.charAt(i14);
            if (iCharAt11 >= c) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i27 = i69 + 1;
                    cCharAt11 = strZzd.charAt(i69);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i27;
                    length = i15;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i16 = i27;
            } else {
                i15 = length;
                i16 = i67;
            }
            int i71 = iCharAt11 & 255;
            int[] iArr4 = iArr3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i61;
                i62++;
            }
            if (i71 >= 51) {
                int i72 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i25 = i74 + 1;
                        cCharAt10 = strZzd.charAt(i74);
                        i26 = i73;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i73 = i26 | ((cCharAt10 & 8191) << i75);
                        i75 += 13;
                        i74 = i25;
                    }
                    iCharAt12 = i26 | (cCharAt10 << i75);
                    i23 = i25;
                } else {
                    i23 = i72;
                }
                int i76 = iCharAt12;
                int i77 = i71 - 51;
                int i78 = i23;
                if (i77 == 9 || i77 == 17) {
                    int i79 = i61 / 3;
                    i24 = i2 + 1;
                    objArr[i79 + i79 + 1] = objArrZze[i2];
                } else {
                    if (i77 == 12 && !z) {
                        int i80 = i61 / 3;
                        i24 = i2 + 1;
                        objArr[i80 + i80 + 1] = objArrZze[i2];
                    }
                    int i81 = i76 + i76;
                    obj = objArrZze[i81];
                    if (obj instanceof Field) {
                        fieldZzA2 = zzA(cls, (String) obj);
                        objArrZze[i81] = fieldZzA2;
                    } else {
                        fieldZzA2 = (Field) obj;
                    }
                    i17 = iCharAt10;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzA2);
                    int i82 = i81 + 1;
                    obj2 = objArrZze[i82];
                    if (obj2 instanceof Field) {
                        fieldZzA3 = zzA(cls, (String) obj2);
                        objArrZze[i82] = fieldZzA3;
                    } else {
                        fieldZzA3 = (Field) obj2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                    i21 = iObjectFieldOffset3;
                    i31 = i78;
                    i20 = 0;
                }
                i2 = i24;
                int i812 = i76 + i76;
                obj = objArrZze[i812];
                if (obj instanceof Field) {
                }
                i17 = iCharAt10;
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZzA2);
                int i822 = i812 + 1;
                obj2 = objArrZze[i822];
                if (obj2 instanceof Field) {
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                i21 = iObjectFieldOffset32;
                i31 = i78;
                i20 = 0;
            } else {
                i17 = iCharAt10;
                int i83 = i2 + 1;
                Field fieldZzA4 = zzA(cls, (String) objArrZze[i2]);
                if (i71 == 9 || i71 == 17) {
                    int i84 = i61 / 3;
                    objArr[i84 + i84 + 1] = fieldZzA4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        int i85 = i61 / 3;
                        i2 += 2;
                        objArr[i85 + i85 + 1] = objArrZze[i83];
                    } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                        if (!z) {
                            int i86 = i61 / 3;
                            i2 += 2;
                            objArr[i86 + i86 + 1] = objArrZze[i83];
                        }
                    } else if (i71 == 50) {
                        int i87 = i60 + 1;
                        iArr[i60] = i61;
                        int i88 = i61 / 3;
                        int i89 = i88 + i88;
                        int i90 = i2 + 2;
                        objArr[i89] = objArrZze[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i89 + 1] = objArrZze[i90];
                            i2 += 3;
                        } else {
                            i2 = i90;
                        }
                        i60 = i87;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) == 4096 || i71 > 17) {
                        i18 = i16;
                        i19 = 0;
                    } else {
                        int i91 = i16 + 1;
                        int iCharAt13 = strZzd.charAt(i16);
                        if (iCharAt13 >= 55296) {
                            int i92 = iCharAt13 & 8191;
                            int i93 = 13;
                            while (true) {
                                i22 = i91 + 1;
                                cCharAt9 = strZzd.charAt(i91);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i92 |= (cCharAt9 & 8191) << i93;
                                i93 += 13;
                                i91 = i22;
                            }
                            iCharAt13 = i92 | (cCharAt9 << i93);
                        } else {
                            i22 = i91;
                        }
                        int i94 = (iCharAt13 / 32) + i5 + i5;
                        Object obj3 = objArrZze[i94];
                        if (obj3 instanceof Field) {
                            fieldZzA = (Field) obj3;
                        } else {
                            fieldZzA = zzA(cls, (String) obj3);
                            objArrZze[i94] = fieldZzA;
                        }
                        i19 = iCharAt13 % 32;
                        int i95 = i22;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA);
                        i18 = i95;
                    }
                    if (i71 >= 18 && i71 <= 49) {
                        iArr[i59] = iObjectFieldOffset;
                        i59++;
                    }
                    i31 = i18;
                    i20 = i19;
                    i21 = iObjectFieldOffset;
                }
                i2 = i83;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    i18 = i16;
                    i19 = 0;
                    if (i71 >= 18) {
                        iArr[i59] = iObjectFieldOffset;
                        i59++;
                    }
                    i31 = i18;
                    i20 = i19;
                    i21 = iObjectFieldOffset;
                }
            }
            int i96 = i61 + 1;
            iArr4[i61] = i17;
            int i97 = i61 + 2;
            String str = strZzd;
            iArr4[i96] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i71 << 20) | i21;
            i61 += 3;
            iArr4[i97] = (i20 << 20) | iObjectFieldOffset2;
            iArr3 = iArr4;
            length = i15;
            strZzd = str;
            c = 55296;
        }
        return new zzfz(iArr3, objArr, iCharAt, iCharAt2, zzggVar.zza(), z, false, iArr, iCharAt4, i58, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar, null);
    }

    private static int zzl(Object obj, long j) {
        return ((Integer) zzhi.zzf(obj, j)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i, int i2, int i4, long j, zzds zzdsVar) {
        Unsafe unsafe = zzb;
        Object objZzz = zzz(i4);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfq) object).zze()) {
            zzfq zzfqVarZzb = zzfq.zza().zzb();
            zzfr.zza(zzfqVarZzb, object);
            unsafe.putObject(obj, j, zzfqVarZzb);
        }
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, int i8, long j, int i9, zzds zzdsVar) throws zzfa {
        Object object;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i))));
                unsafe.putInt(obj, j2, i5);
                return i + 8;
            case 52:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i5);
                return i + 4;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                int iZzm = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzdsVar.zzb));
                unsafe.putInt(obj, j2, i5);
                return iZzm;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                int iZzj = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzdsVar.zza));
                unsafe.putInt(obj, j2, i5);
                return iZzj;
            case 56:
            case 65:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzdt.zzn(bArr, i)));
                unsafe.putInt(obj, j2, i5);
                return i + 8;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzdt.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i5);
                return i + 4;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                int iZzm2 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzdsVar.zzb != 0));
                unsafe.putInt(obj, j2, i5);
                return iZzm2;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int iZzj2 = zzdt.zzj(bArr, i, zzdsVar);
                int i10 = zzdsVar.zza;
                if (i10 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i7 & 536870912) != 0 && !zzhm.zzd(bArr, iZzj2, iZzj2 + i10)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i10, zzez.zzb));
                    iZzj2 += i10;
                }
                unsafe.putInt(obj, j2, i5);
                return iZzj2;
            case 60:
                if (i6 != 2) {
                    return i;
                }
                int iZzd = zzdt.zzd(zzy(i9), bArr, i, i2, zzdsVar);
                object = unsafe.getInt(obj, j2) == i5 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j2, i5);
                return iZzd;
            case 61:
                if (i6 != 2) {
                    return i;
                }
                int iZza = zzdt.zza(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, zzdsVar.zzc);
                unsafe.putInt(obj, j2, i5);
                return iZza;
            case 63:
                if (i6 != 0) {
                    return i;
                }
                int iZzj3 = zzdt.zzj(bArr, i, zzdsVar);
                int i11 = zzdsVar.zza;
                zzex zzexVarZzx = zzx(i9);
                if (zzexVarZzx != null && !zzexVarZzx.zza()) {
                    zzc(obj).zzf(i4, Long.valueOf(i11));
                    return iZzj3;
                }
                unsafe.putObject(obj, j, Integer.valueOf(i11));
                unsafe.putInt(obj, j2, i5);
                return iZzj3;
            case 66:
                if (i6 != 0) {
                    return i;
                }
                int iZzj4 = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                unsafe.putInt(obj, j2, i5);
                return iZzj4;
            case 67:
                if (i6 != 0) {
                    return i;
                }
                int iZzm3 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                unsafe.putInt(obj, j2, i5);
                return iZzm3;
            case 68:
                if (i6 == 3) {
                    int iZzc = zzdt.zzc(zzy(i9), bArr, i, i2, (i4 & (-8)) | 4, zzdsVar);
                    object = unsafe.getInt(obj, j2) == i5 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zzdsVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzez.zzg(object, zzdsVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i5);
                    return iZzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0080. Please report as an issue. */
    private final int zzo(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws zzfa {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        Object obj2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        zzfz<T> zzfzVar = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i14 = i2;
        zzds zzdsVar2 = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i15 = -1;
        int iZzm = i;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1048575;
        while (iZzm < i14) {
            int iZzk = iZzm + 1;
            int i20 = bArr2[iZzm];
            if (i20 < 0) {
                iZzk = zzdt.zzk(i20, bArr2, iZzk, zzdsVar2);
                i20 = zzdsVar2.zza;
            }
            int i21 = iZzk;
            int i22 = i20 >>> 3;
            int i23 = i20 & 7;
            int iZzr = i22 > i16 ? zzfzVar.zzr(i22, i17 / 3) : zzfzVar.zzq(i22);
            if (iZzr == i15) {
                unsafe = unsafe2;
                i4 = i20;
                i5 = i15;
                i6 = i22;
                i7 = 0;
                obj2 = obj3;
            } else {
                int[] iArr = zzfzVar.zzc;
                int i24 = iArr[iZzr + 1];
                int iZzu = zzu(i24);
                int i25 = i20;
                int i26 = iZzr;
                long j = i24 & 1048575;
                if (iZzu <= 17) {
                    int i27 = iArr[i26 + 2];
                    int i28 = 1 << (i27 >>> 20);
                    int i29 = i27 & 1048575;
                    if (i29 != i19) {
                        int i30 = 1048575;
                        if (i19 != 1048575) {
                            unsafe2.putInt(obj3, i19, i18);
                            i30 = 1048575;
                        }
                        if (i29 != i30) {
                            i18 = unsafe2.getInt(obj3, i29);
                        }
                        i19 = i29;
                    }
                    switch (iZzu) {
                        case 0:
                            i13 = i26;
                            if (i23 != 1) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                zzhi.zzl(obj3, j, Double.longBitsToDouble(zzdt.zzn(bArr2, i21)));
                                iZzm = i21 + 8;
                                i18 |= i28;
                                i14 = i2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 1:
                            i13 = i26;
                            if (i23 != 5) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                zzhi.zzm(obj3, j, Float.intBitsToFloat(zzdt.zzb(bArr2, i21)));
                                iZzm = i21 + 4;
                                i18 |= i28;
                                i14 = i2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            i13 = i26;
                            if (i23 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                int iZzm2 = zzdt.zzm(bArr2, i21, zzdsVar2);
                                Unsafe unsafe3 = unsafe2;
                                Object obj4 = obj3;
                                unsafe3.putLong(obj4, j, zzdsVar2.zzb);
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i18 |= i28;
                                iZzm = iZzm2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                                i14 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i13 = i26;
                            if (i23 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                int iZzj = zzdt.zzj(bArr2, i21, zzdsVar2);
                                unsafe2.putInt(obj3, j, zzdsVar2.zza);
                                i18 |= i28;
                                i14 = i2;
                                iZzm = iZzj;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i13 = i26;
                            if (i23 != 1) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                Object obj5 = obj3;
                                unsafe4.putLong(obj5, j, zzdt.zzn(bArr2, i21));
                                unsafe2 = unsafe4;
                                obj3 = obj5;
                                iZzm = i21 + 8;
                                i18 |= i28;
                                i14 = i2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            i13 = i26;
                            if (i23 != 5) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                unsafe2.putInt(obj3, j, zzdt.zzb(bArr2, i21));
                                iZzm = i21 + 4;
                                i18 |= i28;
                                i14 = i2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 7:
                            i13 = i26;
                            if (i23 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzm(bArr2, i21, zzdsVar2);
                                zzhi.zzk(obj3, j, zzdsVar2.zzb != 0);
                                i18 |= i28;
                                i14 = i2;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 8:
                            i13 = i26;
                            if (i23 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = (536870912 & i24) == 0 ? zzdt.zzg(bArr2, i21, zzdsVar2) : zzdt.zzh(bArr2, i21, zzdsVar2);
                                unsafe2.putObject(obj3, j, zzdsVar2.zzc);
                                i18 |= i28;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 9:
                            i13 = i26;
                            if (i23 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzd(zzfzVar.zzy(i13), bArr2, i21, i14, zzdsVar2);
                                Object object = unsafe2.getObject(obj3, j);
                                if (object == null) {
                                    unsafe2.putObject(obj3, j, zzdsVar2.zzc);
                                } else {
                                    unsafe2.putObject(obj3, j, zzez.zzg(object, zzdsVar2.zzc));
                                }
                                i18 |= i28;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 10:
                            i13 = i26;
                            if (i23 != 2) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zza(bArr2, i21, zzdsVar2);
                                unsafe2.putObject(obj3, j, zzdsVar2.zzc);
                                i18 |= i28;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 12:
                            i13 = i26;
                            if (i23 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzj(bArr2, i21, zzdsVar2);
                                unsafe2.putInt(obj3, j, zzdsVar2.zza);
                                i18 |= i28;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 15:
                            i13 = i26;
                            if (i23 != 0) {
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzj(bArr2, i21, zzdsVar2);
                                unsafe2.putInt(obj3, j, zzei.zzb(zzdsVar2.zza));
                                i18 |= i28;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        case 16:
                            if (i23 != 0) {
                                i13 = i26;
                                obj2 = obj3;
                                unsafe = unsafe2;
                                i6 = i22;
                                i7 = i13;
                                i5 = -1;
                                i4 = i25 == true ? 1 : 0;
                            } else {
                                int iZzm3 = zzdt.zzm(bArr2, i21, zzdsVar2);
                                Unsafe unsafe5 = unsafe2;
                                Object obj6 = obj3;
                                i13 = i26;
                                unsafe5.putLong(obj6, j, zzei.zzc(zzdsVar2.zzb));
                                unsafe2 = unsafe5;
                                obj3 = obj6;
                                i18 |= i28;
                                iZzm = iZzm3;
                                i16 = i22;
                                i17 = i13;
                                i15 = -1;
                            }
                            break;
                        default:
                            i13 = i26;
                            obj2 = obj3;
                            unsafe = unsafe2;
                            i6 = i22;
                            i7 = i13;
                            i5 = -1;
                            i4 = i25 == true ? 1 : 0;
                            break;
                    }
                } else {
                    i7 = i26;
                    if (iZzu != 27) {
                        i8 = i21;
                        Unsafe unsafe6 = unsafe2;
                        if (iZzu <= 49) {
                            i9 = i18;
                            unsafe = unsafe6;
                            i5 = -1;
                            i11 = i19;
                            int iZzp = zzfzVar.zzp(obj, bArr, i8, i2, i25 == true ? 1 : 0, i22, i23, i7, i24, iZzu, j, zzdsVar);
                            i10 = i25 == true ? 1 : 0;
                            i12 = i22;
                            if (iZzp != i8) {
                                zzfzVar = this;
                                obj3 = obj;
                                zzdsVar2 = zzdsVar;
                                iZzm = iZzp;
                                i17 = i7;
                                i16 = i12;
                                i19 = i11;
                                i15 = i5;
                                i18 = i9;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i14 = i2;
                            } else {
                                obj2 = obj;
                                i21 = iZzp;
                                i6 = i12;
                                i4 = i10;
                            }
                        } else {
                            i9 = i18;
                            unsafe = unsafe6;
                            i5 = -1;
                            i10 = i25 == true ? 1 : 0;
                            i11 = i19;
                            i12 = i22;
                            if (iZzu != 50) {
                                i6 = i12;
                                int iZzn = zzn(obj, bArr, i8, i2, i10 == true ? 1 : 0, i6, i23, i24, iZzu, j, i7, zzdsVar);
                                obj2 = obj;
                                i4 = i10 == true ? 1 : 0;
                                i7 = i7;
                                if (iZzn != i8) {
                                    zzfzVar = this;
                                    zzdsVar2 = zzdsVar;
                                    i16 = i6;
                                    iZzm = iZzn;
                                    i17 = i7;
                                    obj3 = obj2;
                                    i19 = i11;
                                    i15 = i5;
                                    i18 = i9;
                                    unsafe2 = unsafe;
                                    bArr2 = bArr;
                                    i14 = i2;
                                } else {
                                    i21 = iZzn;
                                }
                            } else if (i23 == 2) {
                                int iZzm4 = zzm(obj, bArr, i8, i2, i7, j, zzdsVar);
                                i7 = i7;
                                if (iZzm4 != i8) {
                                    zzfzVar = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    zzdsVar2 = zzdsVar;
                                    iZzm = iZzm4;
                                    i17 = i7;
                                    i16 = i12;
                                    i19 = i11;
                                    i15 = -1;
                                    i18 = i9;
                                    unsafe2 = unsafe;
                                    i14 = i2;
                                } else {
                                    obj2 = obj;
                                    i21 = iZzm4;
                                    i6 = i12;
                                    i4 = i10;
                                }
                            } else {
                                i7 = i7;
                                obj2 = obj;
                                i21 = i8;
                                i6 = i12;
                                i4 = i10;
                            }
                        }
                    } else if (i23 == 2) {
                        zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj3, j);
                        if (!zzeyVarZzd.zzc()) {
                            int size = zzeyVarZzd.size();
                            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj3, j, zzeyVarZzd);
                        }
                        int iZze = zzdt.zze(zzfzVar.zzy(i7), i25 == true ? 1 : 0, bArr2, i21, i2, zzeyVarZzd, zzdsVar2);
                        bArr2 = bArr;
                        zzdsVar2 = zzdsVar;
                        iZzm = iZze;
                        i17 = i7;
                        unsafe2 = unsafe2;
                        i16 = i22;
                        i15 = -1;
                        obj3 = obj;
                        i14 = i2;
                    } else {
                        i8 = i21;
                        i11 = i19;
                        i9 = i18;
                        unsafe = unsafe2;
                        i12 = i22;
                        i5 = -1;
                        i10 = i25 == true ? 1 : 0;
                        obj2 = obj;
                        i21 = i8;
                        i6 = i12;
                        i4 = i10;
                    }
                    i19 = i11;
                    i18 = i9;
                }
            }
            int iZzi = zzdt.zzi(i4 == true ? 1 : 0, bArr, i21, i2, zzc(obj2), zzdsVar);
            bArr2 = bArr;
            zzdsVar2 = zzdsVar;
            i16 = i6;
            i17 = i7;
            obj3 = obj2;
            i15 = i5;
            unsafe2 = unsafe;
            i14 = i2;
            iZzm = iZzi;
            zzfzVar = this;
        }
        Object obj7 = obj3;
        Unsafe unsafe7 = unsafe2;
        int i31 = i14;
        int i32 = i19;
        int i33 = i18;
        if (i32 != 1048575) {
            unsafe7.putInt(obj7, i32, i33);
        }
        if (iZzm == i31) {
            return iZzm;
        }
        throw zzfa.zzd();
    }

    private final int zzp(Object obj, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, long j, int i8, long j2, zzds zzdsVar) throws zzfa {
        int iZzl;
        Unsafe unsafe = zzb;
        zzey zzeyVarZzd = (zzey) unsafe.getObject(obj, j2);
        if (!zzeyVarZzd.zzc()) {
            int size = zzeyVarZzd.size();
            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzeyVarZzd);
        }
        zzey zzeyVar = zzeyVarZzd;
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    zzej zzejVar = (zzej) zzeyVar;
                    int iZzj = zzdt.zzj(bArr, i, zzdsVar);
                    int i9 = zzdsVar.zza + iZzj;
                    while (iZzj < i9) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj)));
                        iZzj += 8;
                    }
                    if (iZzj == i9) {
                        return iZzj;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVar;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i)));
                    int i10 = i + 8;
                    while (i10 < i2) {
                        int iZzj2 = zzdt.zzj(bArr, i10, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i10;
                        }
                        zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj2)));
                        i10 = iZzj2 + 8;
                    }
                    return i10;
                }
                return i;
            case 19:
            case 36:
                if (i6 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVar;
                    int iZzj3 = zzdt.zzj(bArr, i, zzdsVar);
                    int i11 = zzdsVar.zza + iZzj3;
                    while (iZzj3 < i11) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj3)));
                        iZzj3 += 4;
                    }
                    if (iZzj3 == i11) {
                        return iZzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVar;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i)));
                    int i12 = i + 4;
                    while (i12 < i2) {
                        int iZzj4 = zzdt.zzj(bArr, i12, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i12;
                        }
                        zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj4)));
                        i12 = iZzj4 + 4;
                    }
                    return i12;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVar;
                    int iZzj5 = zzdt.zzj(bArr, i, zzdsVar);
                    int i13 = zzdsVar.zza + iZzj5;
                    while (iZzj5 < i13) {
                        iZzj5 = zzdt.zzm(bArr, iZzj5, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (iZzj5 == i13) {
                        return iZzj5;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVar;
                    int iZzm = zzdt.zzm(bArr, i, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzdt.zzj(bArr, iZzm, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzdt.zzm(bArr, iZzj6, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return iZzm;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return zzdt.zzf(bArr, i, zzeyVar, zzdsVar);
                }
                if (i6 == 0) {
                    return zzdt.zzl(i4, bArr, i, i2, zzeyVar, zzdsVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVar;
                    int iZzj7 = zzdt.zzj(bArr, i, zzdsVar);
                    int i14 = zzdsVar.zza + iZzj7;
                    while (iZzj7 < i14) {
                        zzflVar3.zze(zzdt.zzn(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i14) {
                        return iZzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVar;
                    zzflVar4.zze(zzdt.zzn(bArr, i));
                    int i15 = i + 8;
                    while (i15 < i2) {
                        int iZzj8 = zzdt.zzj(bArr, i15, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i15;
                        }
                        zzflVar4.zze(zzdt.zzn(bArr, iZzj8));
                        i15 = iZzj8 + 8;
                    }
                    return i15;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    zzev zzevVar = (zzev) zzeyVar;
                    int iZzj9 = zzdt.zzj(bArr, i, zzdsVar);
                    int i16 = zzdsVar.zza + iZzj9;
                    while (iZzj9 < i16) {
                        zzevVar.zze(zzdt.zzb(bArr, iZzj9));
                        iZzj9 += 4;
                    }
                    if (iZzj9 == i16) {
                        return iZzj9;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVar;
                    zzevVar2.zze(zzdt.zzb(bArr, i));
                    int i17 = i + 4;
                    while (i17 < i2) {
                        int iZzj10 = zzdt.zzj(bArr, i17, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return i17;
                        }
                        zzevVar2.zze(zzdt.zzb(bArr, iZzj10));
                        i17 = iZzj10 + 4;
                    }
                    return i17;
                }
                return i;
            case 25:
            case 42:
                if (i6 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVar;
                    int iZzj11 = zzdt.zzj(bArr, i, zzdsVar);
                    int i18 = zzdsVar.zza + iZzj11;
                    while (iZzj11 < i18) {
                        iZzj11 = zzdt.zzm(bArr, iZzj11, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (iZzj11 == i18) {
                        return iZzj11;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVar;
                    int iZzm2 = zzdt.zzm(bArr, i, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj12 = zzdt.zzj(bArr, iZzm2, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzdt.zzm(bArr, iZzj12, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return i;
            case 26:
                if (i6 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj13 = zzdt.zzj(bArr, i, zzdsVar);
                        int i19 = zzdsVar.zza;
                        if (i19 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i19 == 0) {
                            zzeyVar.add("");
                        } else {
                            zzeyVar.add(new String(bArr, iZzj13, i19, zzez.zzb));
                            iZzj13 += i19;
                        }
                        while (iZzj13 < i2) {
                            int iZzj14 = zzdt.zzj(bArr, iZzj13, zzdsVar);
                            if (i4 != zzdsVar.zza) {
                                return iZzj13;
                            }
                            iZzj13 = zzdt.zzj(bArr, iZzj14, zzdsVar);
                            int i20 = zzdsVar.zza;
                            if (i20 < 0) {
                                throw zzfa.zzc();
                            }
                            if (i20 == 0) {
                                zzeyVar.add("");
                            } else {
                                zzeyVar.add(new String(bArr, iZzj13, i20, zzez.zzb));
                                iZzj13 += i20;
                            }
                        }
                        return iZzj13;
                    }
                    int iZzj15 = zzdt.zzj(bArr, i, zzdsVar);
                    int i21 = zzdsVar.zza;
                    if (i21 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i21 == 0) {
                        zzeyVar.add("");
                    } else {
                        int i22 = iZzj15 + i21;
                        if (!zzhm.zzd(bArr, iZzj15, i22)) {
                            throw zzfa.zzb();
                        }
                        zzeyVar.add(new String(bArr, iZzj15, i21, zzez.zzb));
                        iZzj15 = i22;
                    }
                    while (iZzj15 < i2) {
                        int iZzj16 = zzdt.zzj(bArr, iZzj15, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzj15;
                        }
                        iZzj15 = zzdt.zzj(bArr, iZzj16, zzdsVar);
                        int i23 = zzdsVar.zza;
                        if (i23 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i23 == 0) {
                            zzeyVar.add("");
                        } else {
                            int i24 = iZzj15 + i23;
                            if (!zzhm.zzd(bArr, iZzj15, i24)) {
                                throw zzfa.zzb();
                            }
                            zzeyVar.add(new String(bArr, iZzj15, i23, zzez.zzb));
                            iZzj15 = i24;
                        }
                    }
                    return iZzj15;
                }
                return i;
            case 27:
                if (i6 == 2) {
                    return zzdt.zze(zzy(i7), i4, bArr, i, i2, zzeyVar, zzdsVar);
                }
                return i;
            case 28:
                if (i6 == 2) {
                    int iZzj17 = zzdt.zzj(bArr, i, zzdsVar);
                    int i25 = zzdsVar.zza;
                    if (i25 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i25 > bArr.length - iZzj17) {
                        throw zzfa.zzf();
                    }
                    if (i25 == 0) {
                        zzeyVar.add(zzee.zzb);
                    } else {
                        zzeyVar.add(zzee.zzk(bArr, iZzj17, i25));
                        iZzj17 += i25;
                    }
                    while (iZzj17 < i2) {
                        int iZzj18 = zzdt.zzj(bArr, iZzj17, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzdt.zzj(bArr, iZzj18, zzdsVar);
                        int i26 = zzdsVar.zza;
                        if (i26 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i26 > bArr.length - iZzj17) {
                            throw zzfa.zzf();
                        }
                        if (i26 == 0) {
                            zzeyVar.add(zzee.zzb);
                        } else {
                            zzeyVar.add(zzee.zzk(bArr, iZzj17, i26));
                            iZzj17 += i26;
                        }
                    }
                    return iZzj17;
                }
                return i;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        iZzl = zzdt.zzl(i4, bArr, i, i2, zzeyVar, zzdsVar);
                    }
                    return i;
                }
                iZzl = zzdt.zzf(bArr, i, zzeyVar, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object objZzd = zzgj.zzd(i5, zzeyVar, zzx(i7), zzgzVar, this.zzm);
                if (objZzd == null) {
                    return iZzl;
                }
                zzeuVar.zzc = (zzgz) objZzd;
                return iZzl;
            case 33:
            case 47:
                if (i6 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVar;
                    int iZzj19 = zzdt.zzj(bArr, i, zzdsVar);
                    int i27 = zzdsVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzdt.zzj(bArr, iZzj19, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVar;
                    int iZzj20 = zzdt.zzj(bArr, i, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (iZzj20 < i2) {
                        int iZzj21 = zzdt.zzj(bArr, iZzj20, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzj20;
                        }
                        iZzj20 = zzdt.zzj(bArr, iZzj21, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return iZzj20;
                }
                return i;
            case 34:
            case 48:
                if (i6 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVar;
                    int iZzj22 = zzdt.zzj(bArr, i, zzdsVar);
                    int i28 = zzdsVar.zza + iZzj22;
                    while (iZzj22 < i28) {
                        iZzj22 = zzdt.zzm(bArr, iZzj22, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (iZzj22 == i28) {
                        return iZzj22;
                    }
                    throw zzfa.zzf();
                }
                if (i6 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVar;
                    int iZzm3 = zzdt.zzm(bArr, i, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj23 = zzdt.zzj(bArr, iZzm3, zzdsVar);
                        if (i4 != zzdsVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzdt.zzm(bArr, iZzj23, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return iZzm3;
                }
                return i;
            default:
                if (i6 == 3) {
                    zzgh zzghVarZzy = zzy(i7);
                    int i29 = (i4 & (-8)) | 4;
                    int iZzc = zzdt.zzc(zzghVarZzy, bArr, i, i2, i29, zzdsVar);
                    zzgh zzghVar = zzghVarZzy;
                    zzds zzdsVar2 = zzdsVar;
                    zzeyVar.add(zzdsVar2.zzc);
                    while (iZzc < i2) {
                        int iZzj24 = zzdt.zzj(bArr, iZzc, zzdsVar2);
                        if (i4 != zzdsVar2.zza) {
                            return iZzc;
                        }
                        zzgh zzghVar2 = zzghVar;
                        zzds zzdsVar3 = zzdsVar2;
                        iZzc = zzdt.zzc(zzghVar2, bArr, iZzj24, i2, i29, zzdsVar3);
                        zzeyVar.add(zzdsVar3.zzc);
                        zzghVar = zzghVar2;
                        zzdsVar2 = zzdsVar3;
                    }
                    return iZzc;
                }
                return i;
        }
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i4 = (length + i2) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
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

    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    private static long zzw(Object obj, long j) {
        return ((Long) zzhi.zzf(obj, j)).longValue();
    }

    private final zzex zzx(int i) {
        int i2 = i / 3;
        return (zzex) this.zzd[i2 + i2 + 1];
    }

    private final zzgh zzy(int i) {
        int i2 = i / 3;
        int i4 = i2 + i2;
        zzgh zzghVar = (zzgh) this.zzd[i4];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarZzb = zzge.zza().zzb((Class) this.zzd[i4 + 1]);
        this.zzd[i4] = zzghVarZzb;
        return zzghVarZzb;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i;
        int iZzc;
        int i2;
        int iZzc2;
        int length = this.zzc.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iZzv = zzv(i5);
            int i6 = this.zzc[i5];
            long j = 1048575 & iZzv;
            int iHashCode = 37;
            switch (zzu(iZzv)) {
                case 0:
                    i = i4 * 53;
                    iZzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j)));
                    i4 = iZzc + i;
                    break;
                case 1:
                    i = i4 * 53;
                    iZzc = Float.floatToIntBits(zzhi.zzb(obj, j));
                    i4 = iZzc + i;
                    break;
                case 2:
                    i = i4 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i4 = iZzc + i;
                    break;
                case 3:
                    i = i4 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i4 = iZzc + i;
                    break;
                case 4:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 5:
                    i = i4 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i4 = iZzc + i;
                    break;
                case 6:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 7:
                    i = i4 * 53;
                    iZzc = zzez.zza(zzhi.zzt(obj, j));
                    i4 = iZzc + i;
                    break;
                case 8:
                    i = i4 * 53;
                    iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                    i4 = iZzc + i;
                    break;
                case 9:
                    Object objZzf = zzhi.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i = i4 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i4 = iZzc + i;
                    break;
                case 11:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 12:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 13:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 14:
                    i = i4 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i4 = iZzc + i;
                    break;
                case 15:
                    i2 = i4 * 53;
                    iZzc2 = zzhi.zzc(obj, j);
                    i4 = i2 + iZzc2;
                    break;
                case 16:
                    i = i4 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i4 = iZzc + i;
                    break;
                case 17:
                    Object objZzf2 = zzhi.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
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
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i4 = iZzc + i;
                    break;
                case 50:
                    i = i4 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i4 = iZzc + i;
                    break;
                case 51:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j)).doubleValue()));
                        i4 = iZzc + i;
                    }
                    break;
                case 52:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j)).floatValue());
                        i4 = iZzc + i;
                    }
                    break;
                case 53:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i4 = iZzc + i;
                    }
                    break;
                case 54:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i4 = iZzc + i;
                    }
                    break;
                case 55:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 56:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i4 = iZzc + i;
                    }
                    break;
                case 57:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 58:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zza(((Boolean) zzhi.zzf(obj, j)).booleanValue());
                        i4 = iZzc + i;
                    }
                    break;
                case 59:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                        i4 = iZzc + i;
                    }
                    break;
                case 60:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i4 = iZzc + i;
                    }
                    break;
                case 61:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i4 = iZzc + i;
                    }
                    break;
                case 62:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 63:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 64:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 65:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i4 = iZzc + i;
                    }
                    break;
                case 66:
                    if (zzJ(obj, i6, i5)) {
                        i2 = i4 * 53;
                        iZzc2 = zzl(obj, j);
                        i4 = i2 + iZzc2;
                    }
                    break;
                case 67:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i4 = iZzc + i;
                    }
                    break;
                case 68:
                    if (zzJ(obj, i6, i5)) {
                        i = i4 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i4 = iZzc + i;
                    }
                    break;
            }
        }
        return this.zzm.zza(obj).hashCode() + (i4 * 53);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0088. Please report as an issue. */
    public final int zzb(Object obj, byte[] bArr, int i, int i2, int i4, zzds zzdsVar) throws zzfa {
        int i5;
        zzfz<T> zzfzVar;
        Unsafe unsafe;
        int i6;
        Object obj2;
        int i7;
        int i8;
        int i9;
        int i10;
        byte[] bArr2;
        int i11;
        Unsafe unsafe2;
        int i12;
        zzds zzdsVar2;
        int iZzj;
        int i13;
        int i14;
        zzds zzdsVar3;
        int i15;
        Object obj3;
        Unsafe unsafe3;
        byte[] bArr3;
        zzds zzdsVar4;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        zzfz<T> zzfzVar2 = this;
        Object obj4 = obj;
        byte[] bArr4 = bArr;
        int i21 = i2;
        zzds zzdsVar5 = zzdsVar;
        Unsafe unsafe4 = zzb;
        int i22 = -1;
        int i23 = i;
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        int iZzr = 0;
        int i27 = 1048575;
        while (true) {
            if (i23 < i21) {
                int iZzk = i23 + 1;
                int i28 = bArr4[i23];
                if (i28 < 0) {
                    iZzk = zzdt.zzk(i28, bArr4, iZzk, zzdsVar5);
                    i28 = zzdsVar5.zza;
                }
                int i29 = i28;
                int i30 = iZzk;
                int i31 = (i29 == true ? 1 : 0) >>> 3;
                int i32 = (i29 == true ? 1 : 0) & 7;
                iZzr = i31 > i24 ? zzfzVar2.zzr(i31, iZzr / 3) : zzfzVar2.zzq(i31);
                if (iZzr == i22) {
                    i5 = i4;
                    zzfzVar = zzfzVar2;
                    i7 = i30;
                    i8 = i31;
                    unsafe = unsafe4;
                    i9 = i22;
                    i25 = i29 == true ? 1 : 0;
                    iZzr = 0;
                    i6 = 1048575;
                    obj2 = obj4;
                } else {
                    int[] iArr = zzfzVar2.zzc;
                    int i33 = iArr[iZzr + 1];
                    int iZzu = zzu(i33);
                    int i34 = i29 == true ? 1 : 0;
                    long j = i33 & 1048575;
                    if (iZzu <= 17) {
                        int i35 = iArr[iZzr + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & 1048575;
                        if (i37 != i27) {
                            i10 = 1048575;
                            if (i27 != 1048575) {
                                unsafe4.putInt(obj4, i27, i26);
                            }
                            i27 = i37;
                            i26 = unsafe4.getInt(obj4, i37);
                        } else {
                            i10 = 1048575;
                        }
                        switch (iZzu) {
                            case 0:
                                bArr3 = bArr;
                                i11 = i10;
                                zzdsVar4 = zzdsVar;
                                obj3 = obj4;
                                unsafe3 = unsafe4;
                                i12 = i30;
                                i8 = i31;
                                if (i32 == 1) {
                                    zzhi.zzl(obj3, j, Double.longBitsToDouble(zzdt.zzn(bArr3, i12)));
                                    i23 = i12 + 8;
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe3;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i25 = i34 == true ? 1 : 0;
                                    i24 = i8;
                                    i22 = -1;
                                } else {
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 1:
                                bArr3 = bArr;
                                i11 = i10;
                                zzdsVar4 = zzdsVar;
                                obj3 = obj4;
                                unsafe3 = unsafe4;
                                i12 = i30;
                                i8 = i31;
                                if (i32 == 5) {
                                    zzhi.zzm(obj3, j, Float.intBitsToFloat(zzdt.zzb(bArr3, i12)));
                                    i23 = i12 + 4;
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe3;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i25 = i34 == true ? 1 : 0;
                                    i24 = i8;
                                    i22 = -1;
                                } else {
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i12 = i30;
                                i8 = i31;
                                zzdsVar4 = zzdsVar;
                                if (i32 == 0) {
                                    int iZzm = zzdt.zzm(bArr3, i12, zzdsVar4);
                                    unsafe2.putLong(obj, j, zzdsVar4.zzb);
                                    obj3 = obj;
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe2;
                                    i23 = iZzm;
                                    bArr4 = bArr3;
                                    zzdsVar5 = zzdsVar4;
                                    obj4 = obj3;
                                    i25 = i34 == true ? 1 : 0;
                                    i24 = i8;
                                    i22 = -1;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i12 = i30;
                                i8 = i31;
                                zzdsVar2 = zzdsVar;
                                if (i32 == 0) {
                                    iZzj = zzdt.zzj(bArr2, i12, zzdsVar2);
                                    unsafe2.putInt(obj4, j, zzdsVar2.zza);
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i8 = i31;
                                zzdsVar2 = zzdsVar;
                                if (i32 == 1) {
                                    Object obj5 = obj4;
                                    unsafe2.putLong(obj5, j, zzdt.zzn(bArr2, i30));
                                    unsafe2 = unsafe2;
                                    obj4 = obj5;
                                    iZzj = i30 + 8;
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    i12 = i30;
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar2 = zzdsVar;
                                if (i32 == 5) {
                                    unsafe2.putInt(obj4, j, zzdt.zzb(bArr2, i13));
                                    iZzj = i13 + 4;
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar2 = zzdsVar;
                                if (i32 == 0) {
                                    iZzj = zzdt.zzm(bArr2, i13, zzdsVar2);
                                    i34 = i34 == true ? 1 : 0;
                                    zzhi.zzk(obj4, j, zzdsVar2.zzb != 0);
                                    i26 |= i36;
                                    i21 = i2;
                                    unsafe4 = unsafe2;
                                    zzdsVar5 = zzdsVar2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    i34 = i34 == true ? 1 : 0;
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i34 == true ? 1 : 0;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar3 = zzdsVar;
                                if (i32 == 2) {
                                    iZzj = (536870912 & i33) == 0 ? zzdt.zzg(bArr2, i13, zzdsVar3) : zzdt.zzh(bArr2, i13, zzdsVar3);
                                    unsafe2.putObject(obj4, j, zzdsVar3.zzc);
                                    i26 |= i36;
                                    i21 = i2;
                                    i25 = i14 == true ? 1 : 0;
                                    zzdsVar5 = zzdsVar3;
                                    i24 = i8;
                                    i22 = -1;
                                    unsafe4 = unsafe2;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i34 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i15 = i2;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i34 == true ? 1 : 0;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar3 = zzdsVar;
                                if (i32 == 2) {
                                    iZzj = zzdt.zzd(zzfzVar2.zzy(iZzr), bArr2, i13, i15, zzdsVar3);
                                    if ((i26 & i36) == 0) {
                                        unsafe2.putObject(obj4, j, zzdsVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj4, j, zzez.zzg(unsafe2.getObject(obj4, j), zzdsVar3.zzc));
                                    }
                                    i26 |= i36;
                                    i25 = i14;
                                    i21 = i15;
                                    zzdsVar5 = zzdsVar3;
                                    i24 = i8;
                                    i22 = -1;
                                    unsafe4 = unsafe2;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i34 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i15 = i2;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i14 = i34 == true ? 1 : 0;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar3 = zzdsVar;
                                if (i32 == 2) {
                                    iZzj = zzdt.zza(bArr2, i13, zzdsVar3);
                                    unsafe2.putObject(obj4, j, zzdsVar3.zzc);
                                    i26 |= i36;
                                    i25 = i14;
                                    i21 = i15;
                                    zzdsVar5 = zzdsVar3;
                                    i24 = i8;
                                    i22 = -1;
                                    unsafe4 = unsafe2;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i34 = i14;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i15 = i2;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar3 = zzdsVar;
                                if (i32 == 0) {
                                    iZzj = zzdt.zzj(bArr2, i13, zzdsVar3);
                                    int i38 = zzdsVar3.zza;
                                    zzex zzexVarZzx = zzfzVar2.zzx(iZzr);
                                    if (zzexVarZzx == null || zzexVarZzx.zza()) {
                                        i14 = i34 == true ? 1 : 0;
                                        unsafe2.putInt(obj4, j, i38);
                                        i26 |= i36;
                                        i25 = i14;
                                        i21 = i15;
                                        zzdsVar5 = zzdsVar3;
                                        i24 = i8;
                                        i22 = -1;
                                        unsafe4 = unsafe2;
                                        i23 = iZzj;
                                        bArr4 = bArr2;
                                    } else {
                                        zzgz zzgzVarZzc = zzc(obj4);
                                        Long lValueOf = Long.valueOf(i38);
                                        i14 = i34 == true ? 1 : 0;
                                        zzgzVarZzc.zzf(i14 == true ? 1 : 0, lValueOf);
                                        i25 = i14;
                                        i21 = i15;
                                        zzdsVar5 = zzdsVar3;
                                        i24 = i8;
                                        i22 = -1;
                                        unsafe4 = unsafe2;
                                        i23 = iZzj;
                                        bArr4 = bArr2;
                                    }
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i11 = i10;
                                unsafe2 = unsafe4;
                                i13 = i30;
                                i8 = i31;
                                zzdsVar2 = zzdsVar;
                                if (i32 == 0) {
                                    iZzj = zzdt.zzj(bArr2, i13, zzdsVar2);
                                    unsafe2.putInt(obj4, j, zzei.zzb(zzdsVar2.zza));
                                    i26 |= i36;
                                    unsafe4 = unsafe2;
                                    i21 = i2;
                                    zzdsVar5 = zzdsVar2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe2;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            case 16:
                                i11 = i10;
                                i13 = i30;
                                i8 = i31;
                                if (i32 == 0) {
                                    int iZzm2 = zzdt.zzm(bArr, i13, zzdsVar);
                                    Object obj6 = obj4;
                                    Unsafe unsafe5 = unsafe4;
                                    unsafe5.putLong(obj6, j, zzei.zzc(zzdsVar.zzb));
                                    obj4 = obj6;
                                    i26 |= i36;
                                    unsafe4 = unsafe5;
                                    i23 = iZzm2;
                                    bArr4 = bArr;
                                    i21 = i2;
                                    zzdsVar5 = zzdsVar;
                                    i25 = i34 == true ? 1 : 0;
                                    i24 = i8;
                                    i22 = -1;
                                } else {
                                    obj3 = obj4;
                                    unsafe3 = unsafe4;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                            default:
                                if (i32 == 3) {
                                    i8 = i31;
                                    iZzj = zzdt.zzc(zzfzVar2.zzy(iZzr), bArr, i30, i2, (i31 << 3) | 4, zzdsVar);
                                    bArr2 = bArr;
                                    if ((i26 & i36) == 0) {
                                        unsafe4.putObject(obj4, j, zzdsVar.zzc);
                                    } else {
                                        unsafe4.putObject(obj4, j, zzez.zzg(unsafe4.getObject(obj4, j), zzdsVar.zzc));
                                    }
                                    i26 |= i36;
                                    zzdsVar5 = zzdsVar;
                                    i21 = i2;
                                    i25 = i34;
                                    i24 = i8;
                                    i22 = -1;
                                    i23 = iZzj;
                                    bArr4 = bArr2;
                                } else {
                                    i11 = i10;
                                    i13 = i30;
                                    i8 = i31;
                                    obj3 = obj4;
                                    unsafe3 = unsafe4;
                                    i12 = i13;
                                    i5 = i4;
                                    zzfzVar = zzfzVar2;
                                    i7 = i12;
                                    obj2 = obj3;
                                    i25 = i34;
                                    i6 = i11;
                                    i9 = -1;
                                    unsafe = unsafe3;
                                }
                                break;
                        }
                    } else {
                        obj3 = obj4;
                        Unsafe unsafe6 = unsafe4;
                        i8 = i31;
                        if (iZzu == 27) {
                            if (i32 == 2) {
                                zzey zzeyVarZzd = (zzey) unsafe6.getObject(obj3, j);
                                if (!zzeyVarZzd.zzc()) {
                                    int size = zzeyVarZzd.size();
                                    zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                    unsafe6.putObject(obj3, j, zzeyVarZzd);
                                }
                                unsafe4 = unsafe6;
                                int iZze = zzdt.zze(zzfzVar2.zzy(iZzr), i34 == true ? 1 : 0, bArr, i30, i2, zzeyVarZzd, zzdsVar);
                                bArr4 = bArr;
                                i21 = i2;
                                zzdsVar5 = zzdsVar;
                                i23 = iZze;
                                obj4 = obj3;
                                i25 = i34 == true ? 1 : 0;
                                i24 = i8;
                                i22 = -1;
                            } else {
                                i16 = i30;
                                i17 = i27;
                                i18 = i26;
                                i19 = iZzr;
                                i20 = i34 == true ? 1 : 0;
                                i6 = 1048575;
                                i9 = -1;
                                unsafe = unsafe6;
                            }
                        } else if (iZzu <= 49) {
                            int i39 = i27;
                            i18 = i26;
                            i6 = 1048575;
                            i9 = -1;
                            unsafe = unsafe6;
                            int iZzp = zzfzVar2.zzp(obj3, bArr, i30, i2, i34 == true ? 1 : 0, i8, i32, iZzr, i33, iZzu, j, zzdsVar);
                            i19 = iZzr;
                            if (iZzp != i30) {
                                zzfzVar2 = this;
                                obj4 = obj;
                                bArr4 = bArr;
                                i27 = i39;
                                i21 = i2;
                                i23 = iZzp;
                                i25 = i34 == true ? 1 : 0;
                                iZzr = i19;
                                i26 = i18;
                                unsafe4 = unsafe;
                                i22 = i9;
                                i24 = i8;
                                zzdsVar5 = zzdsVar;
                            } else {
                                zzfzVar = this;
                                obj2 = obj;
                                i27 = i39;
                                i7 = iZzp;
                                i25 = i34 == true ? 1 : 0;
                                iZzr = i19;
                                i26 = i18;
                                i5 = i4;
                            }
                        } else {
                            i16 = i30;
                            i17 = i27;
                            i18 = i26;
                            i19 = iZzr;
                            i6 = 1048575;
                            i9 = -1;
                            i20 = i34 == true ? 1 : 0;
                            unsafe = unsafe6;
                            if (iZzu != 50) {
                                i25 = i20 == true ? 1 : 0;
                                int iZzn = zzn(obj, bArr, i16, i2, i25 == true ? 1 : 0, i8, i32, i33, iZzu, j, i19, zzdsVar);
                                obj2 = obj;
                                zzfzVar = this;
                                if (iZzn != i16) {
                                    bArr4 = bArr;
                                    i27 = i17;
                                    i21 = i2;
                                    zzfzVar2 = zzfzVar;
                                    i23 = iZzn;
                                    obj4 = obj2;
                                    iZzr = i19;
                                    i26 = i18;
                                    unsafe4 = unsafe;
                                    i22 = i9;
                                    i24 = i8;
                                    zzdsVar5 = zzdsVar;
                                } else {
                                    i27 = i17;
                                    i7 = iZzn;
                                    iZzr = i19;
                                    i26 = i18;
                                    i5 = i4;
                                }
                            } else if (i32 == 2) {
                                int iZzm3 = zzm(obj, bArr, i16, i2, i19, j, zzdsVar);
                                if (iZzm3 != i16) {
                                    zzfzVar2 = this;
                                    obj4 = obj;
                                    bArr4 = bArr;
                                    i27 = i17;
                                    i21 = i2;
                                    zzdsVar5 = zzdsVar;
                                    i23 = iZzm3;
                                    i25 = i20 == true ? 1 : 0;
                                    iZzr = i19;
                                    i26 = i18;
                                    unsafe4 = unsafe;
                                    i22 = -1;
                                    i24 = i8;
                                } else {
                                    obj2 = obj;
                                    i27 = i17;
                                    i5 = i4;
                                    i7 = iZzm3;
                                    i25 = i20 == true ? 1 : 0;
                                    iZzr = i19;
                                    i26 = i18;
                                    zzfzVar = this;
                                }
                            }
                        }
                        zzfzVar = this;
                        obj2 = obj;
                        i27 = i17;
                        i5 = i4;
                        i7 = i16;
                        i25 = i20;
                        iZzr = i19;
                        i26 = i18;
                    }
                }
                if (i25 != i5 || i5 == 0) {
                    int i40 = i25;
                    int iZzi = zzdt.zzi(i40 == true ? 1 : 0, bArr, i7, i2, zzc(obj2), zzdsVar);
                    i25 = i40 == true ? 1 : 0;
                    zzdsVar5 = zzdsVar;
                    i21 = i2;
                    zzfzVar2 = zzfzVar;
                    obj4 = obj2;
                    unsafe4 = unsafe;
                    i22 = i9;
                    i24 = i8;
                    i23 = iZzi;
                    bArr4 = bArr;
                } else {
                    i21 = i2;
                    i23 = i7;
                }
            } else {
                i5 = i4;
                zzfzVar = zzfzVar2;
                unsafe = unsafe4;
                i6 = 1048575;
                obj2 = obj4;
            }
        }
        if (i27 != i6) {
            unsafe.putInt(obj2, i27, i26);
        }
        for (int i41 = zzfzVar.zzj; i41 < zzfzVar.zzk; i41++) {
            int i42 = zzfzVar.zzi[i41];
            int i43 = zzfzVar.zzc[i42];
            Object objZzf = zzhi.zzf(obj2, zzfzVar.zzv(i42) & i6);
            if (objZzf != null && zzfzVar.zzx(i42) != null) {
                throw null;
            }
        }
        if (i5 == 0) {
            if (i23 != i21) {
                throw zzfa.zzd();
            }
        } else if (i23 > i21 || i25 != i5) {
            throw zzfa.zzd();
        }
        return i23;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long jZzv = zzv(this.zzi[i2]) & 1048575;
            Object objZzf = zzhi.zzf(obj, jZzv);
            if (objZzf != null) {
                ((zzfq) objZzf).zzc();
                zzhi.zzp(obj, jZzv, objZzf);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(obj, this.zzi[i]);
            i++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzv = zzv(i);
            long j = 1048575 & iZzv;
            int i2 = this.zzc[i];
            switch (zzu(iZzv)) {
                case 0:
                    if (zzG(obj2, i)) {
                        zzhi.zzl(obj, j, zzhi.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzG(obj2, i)) {
                        zzhi.zzm(obj, j, zzhi.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzG(obj2, i)) {
                        zzhi.zzk(obj, j, zzhi.zzt(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j);
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
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws zzfa {
        if (this.zzh) {
            zzo(obj, bArr, i, i2, zzdsVar);
        } else {
            zzb(obj, bArr, i, i2, 0, zzdsVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzh;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzv = zzv(i);
            long j = iZzv & 1048575;
            switch (zzu(iZzv)) {
                case 0:
                    if (!zzF(obj, obj2, i) || Double.doubleToLongBits(zzhi.zza(obj, j)) != Double.doubleToLongBits(zzhi.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzF(obj, obj2, i) || Float.floatToIntBits(zzhi.zzb(obj, j)) != Float.floatToIntBits(zzhi.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzF(obj, obj2, i) || zzhi.zzt(obj, j) != zzhi.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
                    break;
                case 50:
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
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
                    long jZzs = zzs(i) & 1048575;
                    if (zzhi.zzc(obj, jZzs) != zzhi.zzc(obj2, jZzs) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzh) {
                return false;
            }
        }
        return this.zzm.zza(obj).equals(this.zzm.zza(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // com.google.android.gms.internal.auth.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.zzj) {
            int i7 = this.zzi[i5];
            int i8 = this.zzc[i7];
            int iZzv = zzv(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i6 = zzb.getInt(obj, i10);
                }
                i2 = i6;
                i = i10;
            } else {
                i = i4;
                i2 = i6;
            }
            Object obj2 = obj;
            if ((268435456 & iZzv) != 0 && !zzH(obj2, i7, i, i2, i11)) {
                return false;
            }
            int iZzu = zzu(iZzv);
            if (iZzu == 9 || iZzu == 17) {
                if (zzH(obj2, i7, i, i2, i11) && !zzI(obj2, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 27) {
                List list = (List) zzhi.zzf(obj2, iZzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgh zzghVarZzy = zzy(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zzghVarZzy.zzi(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (iZzu == 60 || iZzu == 68) {
                if (zzJ(obj2, i8, i7) && !zzI(obj2, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu != 49) {
                if (iZzu == 50 && !((zzfq) zzhi.zzf(obj2, iZzv & 1048575)).isEmpty()) {
                    throw null;
                }
            }
            i5++;
            obj = obj2;
            i4 = i;
            i6 = i2;
        }
        return true;
    }
}
