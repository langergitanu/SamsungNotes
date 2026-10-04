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
public interface IClassificationService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IClassificationService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IClassificationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
        public void classify(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
        public void classify2(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
        public void classify3(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IClassificationService {
        static final int TRANSACTION_classify = 1;
        static final int TRANSACTION_classify2 = 2;
        static final int TRANSACTION_classify3 = 3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IClassificationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$classify$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$classify2$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$classify3$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$classify3$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
            public void classify(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IClassificationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 1));
                    }
                    parcelObtain.writeString(str);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
            public void classify2(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IClassificationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 0));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IClassificationService
            public void classify3(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IClassificationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7914b(parcelObtain, 2));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7914b(parcelObtain, 3));
                    }
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

            public String getInterfaceDescriptor() {
                return IClassificationService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IClassificationService.DESCRIPTOR);
        }

        public static IClassificationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IClassificationService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IClassificationService)) ? new Proxy(iBinder) : (IClassificationService) iInterfaceQueryLocalInterface;
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            HashMap map;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IClassificationService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IClassificationService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i4 = parcel.readInt();
                map = i4 >= 0 ? new HashMap() : null;
                IntStream.range(0, i4).forEach(new C7913a(parcel, map, 0));
                classify(map, parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                int i5 = parcel.readInt();
                map = i5 >= 0 ? new HashMap() : null;
                IntStream.range(0, i5).forEach(new C7913a(parcel, map, 1));
                classify2(map, parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int i6 = parcel.readInt();
            HashMap map2 = i6 < 0 ? null : new HashMap();
            IntStream.range(0, i6).forEach(new C7913a(parcel, map2, 2));
            String string = parcel.readString();
            ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
            int i7 = parcel.readInt();
            map = i7 >= 0 ? new HashMap() : null;
            IntStream.range(0, i7).forEach(new C7913a(parcel, map, 3));
            classify3(map2, string, iLlmServiceObserver2AsInterface, map);
            parcel2.writeNoException();
            return true;
        }
    }

    void classify(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver);

    void classify2(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2);

    void classify3(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);
}
