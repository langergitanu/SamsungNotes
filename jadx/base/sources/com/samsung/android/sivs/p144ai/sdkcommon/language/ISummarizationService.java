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
public interface ISummarizationService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.ISummarizationService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISummarizationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void getTokenCount(Map<String, String> map, String str, String str2, String str3, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarize(String str, String str2, String str3, String str4, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarizeOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarizeOnDeviceWithExtraPrompt(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarizeWithHeader(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver iLlmServiceObserver) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarizeWithHeader2(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void summarizeWithHeader3(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
        public void unLoadModel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISummarizationService {
        static final int TRANSACTION_getTokenCount = 7;
        static final int TRANSACTION_summarize = 1;
        static final int TRANSACTION_summarizeOnDevice = 6;
        static final int TRANSACTION_summarizeOnDeviceWithExtraPrompt = 8;
        static final int TRANSACTION_summarizeWithHeader = 2;
        static final int TRANSACTION_summarizeWithHeader2 = 3;
        static final int TRANSACTION_summarizeWithHeader3 = 4;
        static final int TRANSACTION_unLoadModel = 5;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISummarizationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getTokenCount$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$getTokenCount$6(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeOnDevice$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeOnDeviceWithExtraPrompt$7(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeOnDeviceWithExtraPrompt$8(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeWithHeader$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeWithHeader2$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeWithHeader3$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$summarizeWithHeader3$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISummarizationService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void getTokenCount(Map<String, String> map, String str, String str2, String str3, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 10));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 11));
                    }
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarize(String str, String str2, String str3, String str4, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarizeOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 7));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarizeOnDeviceWithExtraPrompt(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 14));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 15));
                    }
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarizeWithHeader(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver iLlmServiceObserver) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 12));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarizeWithHeader2(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 13));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void summarizeWithHeader3(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 8));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 9));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISummarizationService
            public void unLoadModel() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISummarizationService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISummarizationService.DESCRIPTOR);
        }

        public static ISummarizationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISummarizationService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISummarizationService)) ? new Proxy(iBinder) : (ISummarizationService) iInterfaceQueryLocalInterface;
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$8(Parcel parcel, Map map, int i) {
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
                parcel.enforceInterface(ISummarizationService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISummarizationService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    summarize(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i4 = parcel.readInt();
                    HashMap map2 = i4 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i4).forEach(new C7917e(parcel, map2, 7));
                    summarizeWithHeader(map2, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ILlmServiceObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i5 = parcel.readInt();
                    HashMap map3 = i5 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i5).forEach(new C7917e(parcel, map3, 8));
                    summarizeWithHeader2(map3, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int i6 = parcel.readInt();
                    HashMap map4 = i6 < 0 ? null : new HashMap();
                    IntStream.range(0, i6).forEach(new C7917e(parcel, map4, 9));
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i7 = parcel.readInt();
                    map = i7 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i7).forEach(new C7917e(parcel, map, 10));
                    summarizeWithHeader3(map4, string, string2, string3, string4, string5, iLlmServiceObserver2AsInterface, map);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unLoadModel();
                    return true;
                case 6:
                    int i8 = parcel.readInt();
                    map = i8 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i8).forEach(new C7917e(parcel, map, 11));
                    summarizeOnDevice(map, parcel.readString(), parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int i9 = parcel.readInt();
                    HashMap map5 = i9 < 0 ? null : new HashMap();
                    IntStream.range(0, i9).forEach(new C7917e(parcel, map5, 12));
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    String string8 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i10 = parcel.readInt();
                    map = i10 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i10).forEach(new C7917e(parcel, map, 13));
                    getTokenCount(map5, string6, string7, string8, iLlmServiceObserver2AsInterface2, map);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    int i11 = parcel.readInt();
                    HashMap map6 = i11 < 0 ? null : new HashMap();
                    IntStream.range(0, i11).forEach(new C7917e(parcel, map6, 14));
                    String string9 = parcel.readString();
                    String string10 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface3 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i12 = parcel.readInt();
                    HashMap map7 = i12 >= 0 ? new HashMap() : null;
                    IntStream.range(0, i12).forEach(new C7917e(parcel, map7, 15));
                    summarizeOnDeviceWithExtraPrompt(map6, string9, string10, iLlmServiceObserver2AsInterface3, map7);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void getTokenCount(Map<String, String> map, String str, String str2, String str3, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void summarize(String str, String str2, String str3, String str4, ILlmServiceObserver iLlmServiceObserver);

    void summarizeOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2);

    void summarizeOnDeviceWithExtraPrompt(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void summarizeWithHeader(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver iLlmServiceObserver);

    void summarizeWithHeader2(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2);

    void summarizeWithHeader3(Map<String, String> map, String str, String str2, String str3, String str4, String str5, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void unLoadModel();
}
