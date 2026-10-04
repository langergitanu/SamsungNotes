package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IConfigurationService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IConfigurationService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IConfigurationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void getConfig(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void getLlmSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void getModelInfo(Map<String, String> map, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void getOndeviceSafetyCheck(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void getTranslateSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
        public void prewarmLlm(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IConfigurationService {
        static final int TRANSACTION_getConfig = 2;
        static final int TRANSACTION_getLlmSupportLanguage = 3;
        static final int TRANSACTION_getModelInfo = 5;
        static final int TRANSACTION_getOndeviceSafetyCheck = 4;
        static final int TRANSACTION_getTranslateSupportLanguage = 1;
        static final int TRANSACTION_prewarmLlm = 6;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IConfigurationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getConfig$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getLlmSupportLanguage$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getModelInfo$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getModelInfo$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getOndeviceSafetyCheck$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getTranslateSupportLanguage$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$prewarmLlm$6(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$prewarmLlm$7(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void getConfig(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 9));
                    }
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return IConfigurationService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void getLlmSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 7));
                    }
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void getModelInfo(Map<String, String> map, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 5));
                    }
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 6));
                    }
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void getOndeviceSafetyCheck(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 4));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void getTranslateSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 8));
                    }
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IConfigurationService
            public void prewarmLlm(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IConfigurationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 10));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 11));
                    }
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, IConfigurationService.DESCRIPTOR);
        }

        public static IConfigurationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IConfigurationService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IConfigurationService)) ? new Proxy(iBinder) : (IConfigurationService) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$0(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$1(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$2(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$3(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$4(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$5(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$6(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$7(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            HashMap map;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IConfigurationService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IConfigurationService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i4 = parcel.readInt();
                    map = i4 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i4).forEach(new C7913a(parcel, map, 4));
                    getTranslateSupportLanguage(map, ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i5 = parcel.readInt();
                    map = i5 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i5).forEach(new C7913a(parcel, map, 5));
                    getConfig(map, ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i6 = parcel.readInt();
                    map = i6 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i6).forEach(new C7913a(parcel, map, 6));
                    getLlmSupportLanguage(map, ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int i7 = parcel.readInt();
                    map = i7 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i7).forEach(new C7913a(parcel, map, 7));
                    getOndeviceSafetyCheck(map, parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    int i8 = parcel.readInt();
                    HashMap map2 = i8 < 0 ? null : new HashMap();
                    IntStream.range(0, i8).forEach(new C7913a(parcel, map2, 8));
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i9 = parcel.readInt();
                    map = i9 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i9).forEach(new C7913a(parcel, map, 9));
                    getModelInfo(map2, iLlmServiceObserver2AsInterface, map);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int i10 = parcel.readInt();
                    HashMap map3 = i10 < 0 ? null : new HashMap();
                    IntStream.range(0, i10).forEach(new C7913a(parcel, map3, 10));
                    String string = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i11 = parcel.readInt();
                    map = i11 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i11).forEach(new C7913a(parcel, map, 11));
                    prewarmLlm(map3, string, iLlmServiceObserver2AsInterface2, map);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void getConfig(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver);

    void getLlmSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver);

    void getModelInfo(Map<String, String> map, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void getOndeviceSafetyCheck(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2);

    void getTranslateSupportLanguage(Map<String, String> map, ILlmServiceObserver iLlmServiceObserver);

    void prewarmLlm(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);
}
