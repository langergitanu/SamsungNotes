package com.samsung.android.visual.p167ai.sdkcommon;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.visual.p167ai.sdkcommon.IC2paEmbedCallback;
import com.samsung.android.visual.p167ai.sdkcommon.IC2paManifestsCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IDpsC2pa extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.IDpsC2pa";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IDpsC2pa {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public void clearAllManifestsFromCache() {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public boolean clearManifestsFromCache(String str) {
            return false;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public void embedManifestToFile(String str, String str2, String str3, List<String> list, IC2paEmbedCallback iC2paEmbedCallback) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public void embedManifestToPfd(Bundle bundle, IC2paEmbedCallback iC2paEmbedCallback) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public void getManifestsAsString(String str, IC2paManifestsCallback iC2paManifestsCallback) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public void getManifestsAsStringWithPfd(Bundle bundle, IC2paManifestsCallback iC2paManifestsCallback) {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public boolean isC2paInfoExist(String str) {
            return false;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public boolean isC2paInfoExistWithPfd(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public String saveManifestsToCache(String str) {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
        public String saveManifestsToCacheWithPfd(Bundle bundle) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IDpsC2pa {
        static final int TRANSACTION_clearAllManifestsFromCache = 5;
        static final int TRANSACTION_clearManifestsFromCache = 4;
        static final int TRANSACTION_embedManifestToFile = 2;
        static final int TRANSACTION_embedManifestToPfd = 8;
        static final int TRANSACTION_getManifestsAsString = 1;
        static final int TRANSACTION_getManifestsAsStringWithPfd = 7;
        static final int TRANSACTION_isC2paInfoExist = 6;
        static final int TRANSACTION_isC2paInfoExistWithPfd = 10;
        static final int TRANSACTION_saveManifestsToCache = 3;
        static final int TRANSACTION_saveManifestsToCacheWithPfd = 9;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IDpsC2pa {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public void clearAllManifestsFromCache() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public boolean clearManifestsFromCache(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public void embedManifestToFile(String str, String str2, String str3, List<String> list, IC2paEmbedCallback iC2paEmbedCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongInterface(iC2paEmbedCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public void embedManifestToPfd(Bundle bundle, IC2paEmbedCallback iC2paEmbedCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iC2paEmbedCallback);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDpsC2pa.DESCRIPTOR;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public void getManifestsAsString(String str, IC2paManifestsCallback iC2paManifestsCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iC2paManifestsCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public void getManifestsAsStringWithPfd(Bundle bundle, IC2paManifestsCallback iC2paManifestsCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iC2paManifestsCallback);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public boolean isC2paInfoExist(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public boolean isC2paInfoExistWithPfd(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public String saveManifestsToCache(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IDpsC2pa
            public String saveManifestsToCacheWithPfd(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDpsC2pa.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDpsC2pa.DESCRIPTOR);
        }

        public static IDpsC2pa asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDpsC2pa.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDpsC2pa)) ? new Proxy(iBinder) : (IDpsC2pa) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDpsC2pa.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDpsC2pa.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    getManifestsAsString(parcel.readString(), IC2paManifestsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    embedManifestToFile(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), IC2paEmbedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    String strSaveManifestsToCache = saveManifestsToCache(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strSaveManifestsToCache);
                    return true;
                case 4:
                    boolean zClearManifestsFromCache = clearManifestsFromCache(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearManifestsFromCache ? 1 : 0);
                    return true;
                case 5:
                    clearAllManifestsFromCache();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    boolean zIsC2paInfoExist = isC2paInfoExist(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsC2paInfoExist ? 1 : 0);
                    return true;
                case 7:
                    Parcelable.Creator creator = Bundle.CREATOR;
                    getManifestsAsStringWithPfd((Bundle) _Parcel.m12854a(parcel), IC2paManifestsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    Parcelable.Creator creator2 = Bundle.CREATOR;
                    embedManifestToPfd((Bundle) _Parcel.m12854a(parcel), IC2paEmbedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    Parcelable.Creator creator3 = Bundle.CREATOR;
                    String strSaveManifestsToCacheWithPfd = saveManifestsToCacheWithPfd((Bundle) _Parcel.m12854a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeString(strSaveManifestsToCacheWithPfd);
                    return true;
                case 10:
                    Parcelable.Creator creator4 = Bundle.CREATOR;
                    boolean zIsC2paInfoExistWithPfd = isC2paInfoExistWithPfd((Bundle) _Parcel.m12854a(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsC2paInfoExistWithPfd ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m12854a(Parcel parcel) {
            return readTypedObject(parcel, Bundle.CREATOR);
        }

        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void clearAllManifestsFromCache();

    boolean clearManifestsFromCache(String str);

    void embedManifestToFile(String str, String str2, String str3, List<String> list, IC2paEmbedCallback iC2paEmbedCallback);

    void embedManifestToPfd(Bundle bundle, IC2paEmbedCallback iC2paEmbedCallback);

    void getManifestsAsString(String str, IC2paManifestsCallback iC2paManifestsCallback);

    void getManifestsAsStringWithPfd(Bundle bundle, IC2paManifestsCallback iC2paManifestsCallback);

    boolean isC2paInfoExist(String str);

    boolean isC2paInfoExistWithPfd(Bundle bundle);

    String saveManifestsToCache(String str);

    String saveManifestsToCacheWithPfd(Bundle bundle);
}
