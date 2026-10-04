package com.samsung.android.scs.p140ai.sdkcommon.image;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IImageService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.scs.ai.sdkcommon.image.IImageService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IImageService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.scs.p140ai.sdkcommon.image.IImageService
        public Bundle detectBoundaries(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.scs.p140ai.sdkcommon.image.IImageService
        public Bundle detectLargestBoundary(Bundle bundle) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IImageService {
        static final int TRANSACTION_detectBoundaries = 1;
        static final int TRANSACTION_detectLargestBoundary = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IImageService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.scs.p140ai.sdkcommon.image.IImageService
            public Bundle detectBoundaries(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5740a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.scs.p140ai.sdkcommon.image.IImageService
            public Bundle detectLargestBoundary(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    return (Bundle) _Parcel.m5740a(parcelObtain2);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IImageService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IImageService.DESCRIPTOR);
        }

        public static IImageService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IImageService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IImageService)) ? new Proxy(iBinder) : (IImageService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IImageService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IImageService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundleDetectBoundaries = detectBoundaries((Bundle) _Parcel.m5740a(parcel));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleDetectBoundaries, 1);
                return true;
            }
            if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            Parcelable.Creator creator2 = Bundle.CREATOR;
            Bundle bundleDetectLargestBoundary = detectLargestBoundary((Bundle) _Parcel.m5740a(parcel));
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, bundleDetectLargestBoundary, 1);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m5740a(Parcel parcel) {
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

    Bundle detectBoundaries(Bundle bundle);

    Bundle detectLargestBoundary(Bundle bundle);
}
