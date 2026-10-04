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
public interface IToneConvertService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IToneConvertService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IToneConvertService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void toneConvertDynamicStyle(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void toneConverter(String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void toneConverterWithHeader(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void toneConverterWithHeader2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void toneConverterWithHeader3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
        public void unLoadModel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IToneConvertService {
        static final int TRANSACTION_toneConvertDynamicStyle = 6;
        static final int TRANSACTION_toneConverter = 1;
        static final int TRANSACTION_toneConverterWithHeader = 2;
        static final int TRANSACTION_toneConverterWithHeader2 = 3;
        static final int TRANSACTION_toneConverterWithHeader3 = 4;
        static final int TRANSACTION_unLoadModel = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IToneConvertService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConvertDynamicStyle$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConvertDynamicStyle$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConverterWithHeader$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConverterWithHeader2$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConverterWithHeader3$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$toneConverterWithHeader3$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IToneConvertService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void toneConvertDynamicStyle(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 19));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 20));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void toneConverter(String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void toneConverterWithHeader(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 21));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void toneConverterWithHeader2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 16));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void toneConverterWithHeader3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 17));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 18));
                    }
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IToneConvertService
            public void unLoadModel() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToneConvertService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IToneConvertService.DESCRIPTOR);
        }

        public static IToneConvertService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IToneConvertService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IToneConvertService)) ? new Proxy(iBinder) : (IToneConvertService) iInterfaceQueryLocalInterface;
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IToneConvertService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IToneConvertService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    toneConverter(parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i4 = parcel.readInt();
                    HashMap map = i4 < 0 ? null : new HashMap();
                    IntStream.range(0, i4).forEach(new C7917e(parcel, map, 16));
                    toneConverterWithHeader(map, parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i5 = parcel.readInt();
                    HashMap map2 = i5 < 0 ? null : new HashMap();
                    IntStream.range(0, i5).forEach(new C7917e(parcel, map2, 17));
                    toneConverterWithHeader2(map2, parcel.readString(), parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    HashMap map3 = null;
                    int i6 = parcel.readInt();
                    HashMap map4 = i6 < 0 ? null : new HashMap();
                    IntStream.range(0, i6).forEach(new C7917e(parcel, map4, 18));
                    String string = parcel.readString();
                    Map<String, String> map5 = map4;
                    String string2 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i7 = parcel.readInt();
                    if (i7 >= 0) {
                        map3 = new HashMap();
                    }
                    IntStream.range(0, i7).forEach(new C7917e(parcel, map3, 19));
                    toneConverterWithHeader3(map5, string, string2, iLlmServiceObserver2AsInterface, map3);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unLoadModel();
                    return true;
                case 6:
                    int i8 = parcel.readInt();
                    HashMap map6 = i8 < 0 ? null : new HashMap();
                    IntStream.range(0, i8).forEach(new C7917e(parcel, map6, 20));
                    String string3 = parcel.readString();
                    HashMap map7 = null;
                    String string4 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i9 = parcel.readInt();
                    if (i9 >= 0) {
                        map7 = new HashMap();
                    }
                    IntStream.range(0, i9).forEach(new C7917e(parcel, map7, 21));
                    toneConvertDynamicStyle(map6, string3, string4, iLlmServiceObserver2AsInterface2, map7);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void toneConvertDynamicStyle(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void toneConverter(String str, String str2, ILlmServiceObserver iLlmServiceObserver);

    void toneConverterWithHeader(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver);

    void toneConverterWithHeader2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2);

    void toneConverterWithHeader3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void unLoadModel();
}
