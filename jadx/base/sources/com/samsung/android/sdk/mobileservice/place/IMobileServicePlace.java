package com.samsung.android.sdk.mobileservice.place;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sdk.mobileservice.place.IPlaceResultCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IMobileServicePlace extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IMobileServicePlace {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public int getCurrentCount() {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public int getMaxCount() {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public List<Bundle> getPlaceList() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public void requestPlaceCreate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public void requestPlaceDelete(String str, IPlaceResultCallback iPlaceResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public void requestPlaceUpdate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public void requestSync(IPlaceResultCallback iPlaceResultCallback) {
        }

        @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
        public List<Bundle> searchPlaces(int i) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IMobileServicePlace {
        private static final String DESCRIPTOR = "com.samsung.android.sdk.mobileservice.place.IMobileServicePlace";
        static final int TRANSACTION_getCurrentCount = 7;
        static final int TRANSACTION_getMaxCount = 8;
        static final int TRANSACTION_getPlaceList = 1;
        static final int TRANSACTION_requestPlaceCreate = 3;
        static final int TRANSACTION_requestPlaceDelete = 4;
        static final int TRANSACTION_requestPlaceUpdate = 5;
        static final int TRANSACTION_requestSync = 2;
        static final int TRANSACTION_searchPlaces = 6;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IMobileServicePlace {
            public static IMobileServicePlace sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public int getCurrentCount() {
                int currentCount;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        currentCount = parcelObtain2.readInt();
                    } else {
                        currentCount = Stub.getDefaultImpl().getCurrentCount();
                    }
                    return currentCount;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public int getMaxCount() {
                int maxCount;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        maxCount = parcelObtain2.readInt();
                    } else {
                        maxCount = Stub.getDefaultImpl().getMaxCount();
                    }
                    return maxCount;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public List<Bundle> getPlaceList() {
                List<Bundle> listCreateTypedArrayList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        listCreateTypedArrayList = parcelObtain2.createTypedArrayList(Bundle.CREATOR);
                    } else {
                        listCreateTypedArrayList = Stub.getDefaultImpl().getPlaceList();
                    }
                    return listCreateTypedArrayList;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public void requestPlaceCreate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iPlaceResultCallback != null ? iPlaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestPlaceCreate(bundle, iPlaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public void requestPlaceDelete(String str, IPlaceResultCallback iPlaceResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPlaceResultCallback != null ? iPlaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestPlaceDelete(str, iPlaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public void requestPlaceUpdate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iPlaceResultCallback != null ? iPlaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestPlaceUpdate(bundle, iPlaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public void requestSync(IPlaceResultCallback iPlaceResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPlaceResultCallback != null ? iPlaceResultCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestSync(iPlaceResultCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.place.IMobileServicePlace
            public List<Bundle> searchPlaces(int i) {
                List<Bundle> listCreateTypedArrayList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        listCreateTypedArrayList = parcelObtain2.createTypedArrayList(Bundle.CREATOR);
                    } else {
                        listCreateTypedArrayList = Stub.getDefaultImpl().searchPlaces(i);
                    }
                    return listCreateTypedArrayList;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMobileServicePlace asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMobileServicePlace)) ? new Proxy(iBinder) : (IMobileServicePlace) iInterfaceQueryLocalInterface;
        }

        public static IMobileServicePlace getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMobileServicePlace iMobileServicePlace) {
            if (Proxy.sDefaultImpl != null || iMobileServicePlace == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMobileServicePlace;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Bundle> placeList = getPlaceList();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(placeList);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestSync(IPlaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestPlaceCreate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IPlaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestPlaceDelete(parcel.readString(), IPlaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestPlaceUpdate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IPlaceResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Bundle> listSearchPlaces = searchPlaces(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listSearchPlaces);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentCount = getCurrentCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentCount);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int maxCount = getMaxCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(maxCount);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int getCurrentCount();

    int getMaxCount();

    List<Bundle> getPlaceList();

    void requestPlaceCreate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback);

    void requestPlaceDelete(String str, IPlaceResultCallback iPlaceResultCallback);

    void requestPlaceUpdate(Bundle bundle, IPlaceResultCallback iPlaceResultCallback);

    void requestSync(IPlaceResultCallback iPlaceResultCallback);

    List<Bundle> searchPlaces(int i);
}
