package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.samsung.android.sivs.p144ai.sdkcommon.language.ILlmServiceObserver2;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ISuggestionService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.language.ISuggestionService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements ISuggestionService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void reportGeneration(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void suggestion(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void suggestionMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void suggestionWithCategory(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void suggestionWithHeader(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void suggestionWithHeaderOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
        public void unLoadModel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements ISuggestionService {
        static final int TRANSACTION_reportGeneration = 7;
        static final int TRANSACTION_suggestion = 1;
        static final int TRANSACTION_suggestionMultiModal = 6;
        static final int TRANSACTION_suggestionWithCategory = 5;
        static final int TRANSACTION_suggestionWithHeader = 2;
        static final int TRANSACTION_suggestionWithHeaderOnDevice = 4;
        static final int TRANSACTION_unLoadModel = 3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements ISuggestionService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$reportGeneration$10(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$reportGeneration$9(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestion$0(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionMultiModal$7(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionMultiModal$8(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithCategory$5(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithCategory$6(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithHeader$1(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithHeader$2(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithHeaderOnDevice$3(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$suggestionWithHeaderOnDevice$4(Parcel parcel, String str, String str2) {
                parcel.writeString(str);
                parcel.writeString(str2);
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISuggestionService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void reportGeneration(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 3));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7916d(parcelObtain, 24));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void suggestion(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 26));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void suggestionMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 29));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 0));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void suggestionWithCategory(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7918f(parcelObtain, 1));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7918f(parcelObtain, 2));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void suggestionWithHeader(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 27));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7916d(parcelObtain, 28));
                    }
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void suggestionWithHeaderOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    if (map == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map.size());
                        map.forEach(new C7916d(parcelObtain, 23));
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongInterface(iLlmServiceObserver2);
                    if (map2 == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(map2.size());
                        map2.forEach(new C7916d(parcelObtain, 25));
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

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.language.ISuggestionService
            public void unLoadModel() {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISuggestionService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISuggestionService.DESCRIPTOR);
        }

        public static ISuggestionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISuggestionService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISuggestionService)) ? new Proxy(iBinder) : (ISuggestionService) iInterfaceQueryLocalInterface;
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
        public static /* synthetic */ void lambda$onTransact$10(Parcel parcel, Map map, int i) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onTransact$9(Parcel parcel, Map map, int i) {
            map.put(parcel.readString(), parcel.readString());
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISuggestionService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISuggestionService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i4 = parcel.readInt();
                    HashMap map = i4 < 0 ? null : new HashMap();
                    IntStream.range(0, i4).forEach(new C7915c(parcel, map, 23));
                    suggestion(map, parcel.readString(), ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    HashMap map2 = null;
                    int i5 = parcel.readInt();
                    HashMap map3 = i5 < 0 ? null : new HashMap();
                    IntStream.range(0, i5).forEach(new C7915c(parcel, map3, 26));
                    String string = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i6 = parcel.readInt();
                    if (i6 >= 0) {
                        map2 = new HashMap();
                    }
                    IntStream.range(0, i6).forEach(new C7915c(parcel, map2, 27));
                    suggestionWithHeader(map3, string, iLlmServiceObserver2AsInterface, map2);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    unLoadModel();
                    return true;
                case 4:
                    HashMap map4 = null;
                    int i7 = parcel.readInt();
                    HashMap map5 = i7 < 0 ? null : new HashMap();
                    IntStream.range(0, i7).forEach(new C7915c(parcel, map5, 28));
                    String string2 = parcel.readString();
                    Map<String, String> map6 = map5;
                    String string3 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface2 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i8 = parcel.readInt();
                    if (i8 >= 0) {
                        map4 = new HashMap();
                    }
                    IntStream.range(0, i8).forEach(new C7915c(parcel, map4, 29));
                    suggestionWithHeaderOnDevice(map6, string2, string3, iLlmServiceObserver2AsInterface2, map4);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    HashMap map7 = null;
                    int i9 = parcel.readInt();
                    HashMap map8 = i9 < 0 ? null : new HashMap();
                    IntStream.range(0, i9).forEach(new C7917e(parcel, map8, 0));
                    String string4 = parcel.readString();
                    Map<String, String> map9 = map8;
                    String string5 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface3 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i10 = parcel.readInt();
                    if (i10 >= 0) {
                        map7 = new HashMap();
                    }
                    IntStream.range(0, i10).forEach(new C7917e(parcel, map7, 1));
                    suggestionWithCategory(map9, string4, string5, iLlmServiceObserver2AsInterface3, map7);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    HashMap map10 = null;
                    int i11 = parcel.readInt();
                    HashMap map11 = i11 < 0 ? null : new HashMap();
                    IntStream.range(0, i11).forEach(new C7917e(parcel, map11, 2));
                    String string6 = parcel.readString();
                    Map<String, String> map12 = map11;
                    String string7 = parcel.readString();
                    String string8 = parcel.readString();
                    Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) _Parcel.m7002a(parcel);
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface4 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i12 = parcel.readInt();
                    if (i12 >= 0) {
                        map10 = new HashMap();
                    }
                    IntStream.range(0, i12).forEach(new C7917e(parcel, map10, 3));
                    suggestionMultiModal(map12, string6, string7, string8, parcelFileDescriptor, iLlmServiceObserver2AsInterface4, map10);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int i13 = parcel.readInt();
                    HashMap map13 = i13 < 0 ? null : new HashMap();
                    IntStream.range(0, i13).forEach(new C7915c(parcel, map13, 24));
                    String string9 = parcel.readString();
                    HashMap map14 = null;
                    String string10 = parcel.readString();
                    ILlmServiceObserver2 iLlmServiceObserver2AsInterface5 = ILlmServiceObserver2.Stub.asInterface(parcel.readStrongBinder());
                    int i14 = parcel.readInt();
                    if (i14 >= 0) {
                        map14 = new HashMap();
                    }
                    IntStream.range(0, i14).forEach(new C7915c(parcel, map14, 25));
                    reportGeneration(map13, string9, string10, iLlmServiceObserver2AsInterface5, map14);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: renamed from: a */
        public static /* bridge */ /* synthetic */ Object m7002a(Parcel parcel) {
            return readTypedObject(parcel, ParcelFileDescriptor.CREATOR);
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

    void reportGeneration(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void suggestion(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2);

    void suggestionMultiModal(Map<String, String> map, String str, String str2, String str3, ParcelFileDescriptor parcelFileDescriptor, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void suggestionWithCategory(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void suggestionWithHeader(Map<String, String> map, String str, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void suggestionWithHeaderOnDevice(Map<String, String> map, String str, String str2, ILlmServiceObserver2 iLlmServiceObserver2, Map<String, String> map2);

    void unLoadModel();
}
