package com.samsung.android.sivs.p144ai.sdkcommon.translation;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationCallback;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface INeuralTranslationService extends IInterface {
    public static final String DESCRIPTOR = "com.samsung.android.sivs.ai.sdkcommon.translation.INeuralTranslationService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Default implements INeuralTranslationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<ChunkPair> chunkText(String str, String str2, int i) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public void clear() {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public void clearWithSourceId(String str) {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public void dispose() {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public Map getLanguageDirectionStateMap() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public String getResourcePackPackageName(String str, String str2) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<String> getSourceLanguageList() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<String> getSpeechLlmSupportedSourceLanguage() {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<String> getSpeechLlmSupportedTargetLanguage(String str) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<String> getTargetLanguageList(String str) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public String identifyLanguage(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<DetectionCandidate> identifyLanguageAndGetCandidate(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public String identifyLanguagePackCode(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public List<String> identifyLanguageWithList(Bundle bundle) {
            return null;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public boolean isAvailableDirection(LanguageDirection languageDirection) {
            return false;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public boolean isTaggedTranslationSupported(String str, String str2) {
            return false;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public boolean prepareSpeechLlmTranslation(Bundle bundle) {
            return false;
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public void refresh() {
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
        public void translate(Bundle bundle, INeuralTranslationCallback iNeuralTranslationCallback) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Stub extends Binder implements INeuralTranslationService {
        static final int TRANSACTION_chunkText = 14;
        static final int TRANSACTION_clear = 3;
        static final int TRANSACTION_clearWithSourceId = 15;
        static final int TRANSACTION_dispose = 4;
        static final int TRANSACTION_getLanguageDirectionStateMap = 9;
        static final int TRANSACTION_getResourcePackPackageName = 10;
        static final int TRANSACTION_getSourceLanguageList = 5;
        static final int TRANSACTION_getSpeechLlmSupportedSourceLanguage = 17;
        static final int TRANSACTION_getSpeechLlmSupportedTargetLanguage = 18;
        static final int TRANSACTION_getTargetLanguageList = 6;
        static final int TRANSACTION_identifyLanguage = 8;
        static final int TRANSACTION_identifyLanguageAndGetCandidate = 12;
        static final int TRANSACTION_identifyLanguagePackCode = 13;
        static final int TRANSACTION_identifyLanguageWithList = 11;
        static final int TRANSACTION_isAvailableDirection = 7;
        static final int TRANSACTION_isTaggedTranslationSupported = 16;
        static final int TRANSACTION_prepareSpeechLlmTranslation = 19;
        static final int TRANSACTION_refresh = 1;
        static final int TRANSACTION_translate = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Proxy implements INeuralTranslationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<ChunkPair> chunkText(String str, String str2, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(ChunkPair.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public void clear() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public void clearWithSourceId(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public void dispose() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return INeuralTranslationService.DESCRIPTOR;
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public Map getLanguageDirectionStateMap() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public String getResourcePackPackageName(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<String> getSourceLanguageList() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<String> getSpeechLlmSupportedSourceLanguage() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<String> getSpeechLlmSupportedTargetLanguage(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<String> getTargetLanguageList(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public String identifyLanguage(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<DetectionCandidate> identifyLanguageAndGetCandidate(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DetectionCandidate.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public String identifyLanguagePackCode(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public List<String> identifyLanguageWithList(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public boolean isAvailableDirection(LanguageDirection languageDirection) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, languageDirection, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public boolean isTaggedTranslationSupported(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public boolean prepareSpeechLlmTranslation(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public void refresh() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService
            public void translate(Bundle bundle, INeuralTranslationCallback iNeuralTranslationCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(INeuralTranslationService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iNeuralTranslationCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INeuralTranslationService.DESCRIPTOR);
        }

        public static INeuralTranslationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(INeuralTranslationService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INeuralTranslationService)) ? new Proxy(iBinder) : (INeuralTranslationService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INeuralTranslationService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INeuralTranslationService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    refresh();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    translate((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), INeuralTranslationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    clear();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    dispose();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    List<String> sourceLanguageList = getSourceLanguageList();
                    parcel2.writeNoException();
                    parcel2.writeStringList(sourceLanguageList);
                    return true;
                case 6:
                    List<String> targetLanguageList = getTargetLanguageList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringList(targetLanguageList);
                    return true;
                case 7:
                    boolean zIsAvailableDirection = isAvailableDirection((LanguageDirection) _Parcel.readTypedObject(parcel, LanguageDirection.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsAvailableDirection ? 1 : 0);
                    return true;
                case 8:
                    String strIdentifyLanguage = identifyLanguage((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strIdentifyLanguage);
                    return true;
                case 9:
                    Map languageDirectionStateMap = getLanguageDirectionStateMap();
                    parcel2.writeNoException();
                    parcel2.writeMap(languageDirectionStateMap);
                    return true;
                case 10:
                    String resourcePackPackageName = getResourcePackPackageName(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(resourcePackPackageName);
                    return true;
                case 11:
                    List<String> listIdentifyLanguageWithList = identifyLanguageWithList((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeStringList(listIdentifyLanguageWithList);
                    return true;
                case 12:
                    List<DetectionCandidate> listIdentifyLanguageAndGetCandidate = identifyLanguageAndGetCandidate((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedList(parcel2, listIdentifyLanguageAndGetCandidate, 1);
                    return true;
                case 13:
                    String strIdentifyLanguagePackCode = identifyLanguagePackCode((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeString(strIdentifyLanguagePackCode);
                    return true;
                case 14:
                    List<ChunkPair> listChunkText = chunkText(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    _Parcel.writeTypedList(parcel2, listChunkText, 1);
                    return true;
                case 15:
                    clearWithSourceId(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    boolean zIsTaggedTranslationSupported = isTaggedTranslationSupported(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsTaggedTranslationSupported ? 1 : 0);
                    return true;
                case 17:
                    List<String> speechLlmSupportedSourceLanguage = getSpeechLlmSupportedSourceLanguage();
                    parcel2.writeNoException();
                    parcel2.writeStringList(speechLlmSupportedSourceLanguage);
                    return true;
                case 18:
                    List<String> speechLlmSupportedTargetLanguage = getSpeechLlmSupportedTargetLanguage(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringList(speechLlmSupportedTargetLanguage);
                    return true;
                case 19:
                    boolean zPrepareSpeechLlmTranslation = prepareSpeechLlmTranslation((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zPrepareSpeechLlmTranslation ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                writeTypedObject(parcel, list.get(i2), i);
            }
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

    List<ChunkPair> chunkText(String str, String str2, int i);

    void clear();

    void clearWithSourceId(String str);

    void dispose();

    Map getLanguageDirectionStateMap();

    String getResourcePackPackageName(String str, String str2);

    List<String> getSourceLanguageList();

    List<String> getSpeechLlmSupportedSourceLanguage();

    List<String> getSpeechLlmSupportedTargetLanguage(String str);

    List<String> getTargetLanguageList(String str);

    String identifyLanguage(Bundle bundle);

    List<DetectionCandidate> identifyLanguageAndGetCandidate(Bundle bundle);

    String identifyLanguagePackCode(Bundle bundle);

    List<String> identifyLanguageWithList(Bundle bundle);

    boolean isAvailableDirection(LanguageDirection languageDirection);

    boolean isTaggedTranslationSupported(String str, String str2);

    boolean prepareSpeechLlmTranslation(Bundle bundle);

    void refresh();

    void translate(Bundle bundle, INeuralTranslationCallback iNeuralTranslationCallback);
}
