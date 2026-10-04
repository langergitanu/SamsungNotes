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
public interface INotesOrganizationService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.INotesOrganizationService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements INotesOrganizationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
        public void organize(String str, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
        public void organizeWithHeader(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
        public void organizeWithType(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
        public void organizeWithType2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
        public void organizeWithType3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements INotesOrganizationService {
        static final int TRANSACTION_organize = 1;
        static final int TRANSACTION_organizeWithHeader = 2;
        static final int TRANSACTION_organizeWithType = 3;
        static final int TRANSACTION_organizeWithType2 = 4;
        static final int TRANSACTION_organizeWithType3 = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements INotesOrganizationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$organizeWithHeader$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$organizeWithType$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$organizeWithType2$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$organizeWithType3$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$organizeWithType3$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return INotesOrganizationService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
            public void organize(String str, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotesOrganizationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
            public void organizeWithHeader(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotesOrganizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 6));
                    }
                    parcelObtain.writeString(str);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
            public void organizeWithType(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotesOrganizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 7));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
            public void organizeWithType2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotesOrganizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 10));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.INotesOrganizationService
            public void organizeWithType3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INotesOrganizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 8));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7916d(parcelObtain, 9));
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
        }

        public Stub() {
            attachInterface(this, INotesOrganizationService.DESCRIPTOR);
        }

        public static INotesOrganizationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(INotesOrganizationService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INotesOrganizationService)) ? new Proxy(iBinder) : (INotesOrganizationService) iInterfaceQueryLocalInterface;
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            HashMap map;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INotesOrganizationService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INotesOrganizationService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                organize(parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                int i4 = parcel.readInt();
                map = i4 >= 0 ? new HashMap() : null;
                IntStream.range(0, i4).forEach(new C7915c(parcel, map, 6));
                organizeWithHeader(map, parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                int i5 = parcel.readInt();
                map = i5 >= 0 ? new HashMap() : null;
                IntStream.range(0, i5).forEach(new C7915c(parcel, map, 7));
                organizeWithType(map, parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                int i6 = parcel.readInt();
                map = i6 >= 0 ? new HashMap() : null;
                IntStream.range(0, i6).forEach(new C7915c(parcel, map, 8));
                organizeWithType2(map, parcel.readString(), parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int i7 = parcel.readInt();
            HashMap map2 = i7 < 0 ? null : new HashMap();
            IntStream.range(0, i7).forEach(new C7915c(parcel, map2, 9));
            String string = parcel.readString();
            String string2 = parcel.readString();
            ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
            int i8 = parcel.readInt();
            HashMap map3 = i8 >= 0 ? new HashMap() : null;
            IntStream.range(0, i8).forEach(new C7915c(parcel, map3, 10));
            organizeWithType3(map2, string, string2, iLlmServiceObserver2AsInterface, map3);
            parcel2.writeNoException();
            return true;
        }
    }

    void organize(String str, ILlmServiceObserver iLlmServiceObserver);

    void organizeWithHeader(Map<String, String> map, String str, ILlmServiceObserver iLlmServiceObserver);

    void organizeWithType(Map<String, String> map, String str, String str2, ILlmServiceObserver iLlmServiceObserver);

    void organizeWithType2(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2);

    void organizeWithType3(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);
}
