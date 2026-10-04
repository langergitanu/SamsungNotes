package com.samsung.android.sdk.mobileservice.profile;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sdk.mobileservice.profile.IPrivacyUpdateResultCallback;
import com.samsung.android.sdk.mobileservice.profile.IProfileUpdateResultCallback;
import com.samsung.android.sdk.mobileservice.profile.ISyncResultCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IMobileServiceProfile extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IMobileServiceProfile {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public int exchangeProfileVersion(int i) {
            return 0;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public Bundle getPrivacy() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public Profile getProfile() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public String getProfileBirthdayType() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public String getProfileImageUrl() {
            return null;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public boolean requestPrivacyUpdate(Bundle bundle, IPrivacyUpdateResultCallback iPrivacyUpdateResultCallback) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public boolean requestProfileBirthdayTypeUpdate(String str, IProfileUpdateResultCallback iProfileUpdateResultCallback) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public boolean requestProfileUpdate(Profile profile, IProfileUpdateResultCallback iProfileUpdateResultCallback) {
            return false;
        }

        @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
        public void requestSync(ISyncResultCallback iSyncResultCallback) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IMobileServiceProfile {
        private static final String DESCRIPTOR = "com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile";
        static final int TRANSACTION_exchangeProfileVersion = 4;
        static final int TRANSACTION_getPrivacy = 5;
        static final int TRANSACTION_getProfile = 1;
        static final int TRANSACTION_getProfileBirthdayType = 8;
        static final int TRANSACTION_getProfileImageUrl = 7;
        static final int TRANSACTION_requestPrivacyUpdate = 6;
        static final int TRANSACTION_requestProfileBirthdayTypeUpdate = 9;
        static final int TRANSACTION_requestProfileUpdate = 3;
        static final int TRANSACTION_requestSync = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IMobileServiceProfile {
            public static IMobileServiceProfile sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public int exchangeProfileVersion(int i) {
                int iExchangeProfileVersion;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iExchangeProfileVersion = parcelObtain2.readInt();
                    } else {
                        iExchangeProfileVersion = Stub.getDefaultImpl().exchangeProfileVersion(i);
                    }
                    return iExchangeProfileVersion;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public Bundle getPrivacy() {
                Bundle privacy;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        privacy = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        privacy = Stub.getDefaultImpl().getPrivacy();
                    }
                    return privacy;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public Profile getProfile() {
                Profile profileCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        profileCreateFromParcel = parcelObtain2.readInt() != 0 ? Profile.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        profileCreateFromParcel = Stub.getDefaultImpl().getProfile();
                    }
                    return profileCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public String getProfileBirthdayType() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getProfileBirthdayType();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public String getProfileImageUrl() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getProfileImageUrl();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public boolean requestPrivacyUpdate(Bundle bundle, IPrivacyUpdateResultCallback iPrivacyUpdateResultCallback) {
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
                    parcelObtain.writeStrongBinder(iPrivacyUpdateResultCallback != null ? iPrivacyUpdateResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zRequestPrivacyUpdate = Stub.getDefaultImpl().requestPrivacyUpdate(bundle, iPrivacyUpdateResultCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zRequestPrivacyUpdate;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public boolean requestProfileBirthdayTypeUpdate(String str, IProfileUpdateResultCallback iProfileUpdateResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iProfileUpdateResultCallback != null ? iProfileUpdateResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zRequestProfileBirthdayTypeUpdate = Stub.getDefaultImpl().requestProfileBirthdayTypeUpdate(str, iProfileUpdateResultCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zRequestProfileBirthdayTypeUpdate;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public boolean requestProfileUpdate(Profile profile, IProfileUpdateResultCallback iProfileUpdateResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (profile != null) {
                        parcelObtain.writeInt(1);
                        profile.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iProfileUpdateResultCallback != null ? iProfileUpdateResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zRequestProfileUpdate = Stub.getDefaultImpl().requestProfileUpdate(profile, iProfileUpdateResultCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zRequestProfileUpdate;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sdk.mobileservice.profile.IMobileServiceProfile
            public void requestSync(ISyncResultCallback iSyncResultCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iSyncResultCallback != null ? iSyncResultCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().requestSync(iSyncResultCallback);
                    }
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IMobileServiceProfile asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMobileServiceProfile)) ? new Proxy(iBinder) : (IMobileServiceProfile) iInterfaceQueryLocalInterface;
        }

        public static IMobileServiceProfile getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMobileServiceProfile iMobileServiceProfile) {
            if (Proxy.sDefaultImpl != null || iMobileServiceProfile == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMobileServiceProfile;
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
                    Profile profile = getProfile();
                    parcel2.writeNoException();
                    if (profile != null) {
                        parcel2.writeInt(1);
                        profile.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestSync(ISyncResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestProfileUpdate = requestProfileUpdate(parcel.readInt() != 0 ? Profile.CREATOR.createFromParcel(parcel) : null, IProfileUpdateResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestProfileUpdate ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iExchangeProfileVersion = exchangeProfileVersion(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iExchangeProfileVersion);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle privacy = getPrivacy();
                    parcel2.writeNoException();
                    if (privacy != null) {
                        parcel2.writeInt(1);
                        privacy.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestPrivacyUpdate = requestPrivacyUpdate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IPrivacyUpdateResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestPrivacyUpdate ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    String profileImageUrl = getProfileImageUrl();
                    parcel2.writeNoException();
                    parcel2.writeString(profileImageUrl);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    String profileBirthdayType = getProfileBirthdayType();
                    parcel2.writeNoException();
                    parcel2.writeString(profileBirthdayType);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRequestProfileBirthdayTypeUpdate = requestProfileBirthdayTypeUpdate(parcel.readString(), IProfileUpdateResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zRequestProfileBirthdayTypeUpdate ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int exchangeProfileVersion(int i);

    Bundle getPrivacy();

    Profile getProfile();

    String getProfileBirthdayType();

    String getProfileImageUrl();

    boolean requestPrivacyUpdate(Bundle bundle, IPrivacyUpdateResultCallback iPrivacyUpdateResultCallback);

    boolean requestProfileBirthdayTypeUpdate(String str, IProfileUpdateResultCallback iProfileUpdateResultCallback);

    boolean requestProfileUpdate(Profile profile, IProfileUpdateResultCallback iProfileUpdateResultCallback);

    void requestSync(ISyncResultCallback iSyncResultCallback);
}
