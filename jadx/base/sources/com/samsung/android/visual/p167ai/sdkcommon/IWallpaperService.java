package com.samsung.android.visual.p167ai.sdkcommon;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IWallpaperService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.visual.ai.sdkcommon.IWallpaperService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IWallpaperService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
        public Bundle cancel(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
        public Bundle generate(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
        public void prepare() {
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
        public void release() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IWallpaperService {
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_generate = 2;
        static final int TRANSACTION_prepare = 1;
        static final int TRANSACTION_release = 4;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IWallpaperService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
            public Bundle cancel(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m12862a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
            public Bundle generate(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m12862a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IWallpaperService.DESCRIPTOR;
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
            public void prepare() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.visual.p167ai.sdkcommon.IWallpaperService
            public void release() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IWallpaperService.DESCRIPTOR);
        }

        public static IWallpaperService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWallpaperService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IWallpaperService)) ? new Proxy(iBinder) : (IWallpaperService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWallpaperService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWallpaperService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                prepare();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundleGenerate = generate((Bundle) _Parcel.m12862a(parcel));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleGenerate, 1);
                return true;
            }
            if (i != 3) {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                release();
                parcel2.writeNoException();
                return true;
            }
            Parcelable.Creator creator2 = Bundle.CREATOR;
            Bundle bundleCancel = cancel((Bundle) _Parcel.m12862a(parcel));
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, bundleCancel, 1);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m12862a(Parcel parcel) {
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

    Bundle cancel(Bundle bundle);

    Bundle generate(Bundle bundle);

    void prepare();

    void release();
}
