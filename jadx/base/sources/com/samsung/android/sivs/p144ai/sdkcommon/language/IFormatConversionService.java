package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IFormatConversionService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.IFormatConversionService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements IFormatConversionService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IFormatConversionService
        public void convert(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements IFormatConversionService {
        static final int TRANSACTION_convert = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements IFormatConversionService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$convert$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$convert$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.IFormatConversionService
            public void convert(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFormatConversionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 0));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7916d(parcelObtain, 1));
                    }
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

            public String getInterfaceDescriptor() {
                return IFormatConversionService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IFormatConversionService.DESCRIPTOR);
        }

        public static IFormatConversionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFormatConversionService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFormatConversionService)) ? new Proxy(iBinder) : (IFormatConversionService) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$0(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$1(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFormatConversionService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFormatConversionService.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            int i4 = parcel.readInt();
            HashMap map = i4 < 0 ? null : new HashMap();
            IntStream.range(0, i4).forEach(new C7915c(parcel, map, 0));
            String string = parcel.readString();
            String string2 = parcel.readString();
            ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
            int i5 = parcel.readInt();
            HashMap map2 = i5 >= 0 ? new HashMap() : null;
            IntStream.range(0, i5).forEach(new C7915c(parcel, map2, 1));
            convert(map, string, string2, iLlmServiceObserver2AsInterface, map2);
            parcel2.writeNoException();
            return true;
        }
    }

    void convert(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);
}
