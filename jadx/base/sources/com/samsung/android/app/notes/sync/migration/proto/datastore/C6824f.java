package com.samsung.android.app.notes.sync.migration.proto.datastore;

import androidx.datastore.core.DataStore;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import os_migration_data_types.p233v1.AttachmentMeta;
import os_migration_data_types.p233v1.AttachmentType;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.proto.datastore.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6824f {

    /* JADX INFO: renamed from: a */
    public final DataStore f4241a;

    public C6824f(DataStore attachmentMeta) {
        Intrinsics.checkNotNullParameter(attachmentMeta, "attachmentMeta");
        this.f4241a = attachmentMeta;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4974a(String str, ContinuationImpl continuationImpl) {
        AttachmentMetaDataStoreAccessor$setAttachmentName$1 attachmentMetaDataStoreAccessor$setAttachmentName$1;
        if (continuationImpl instanceof AttachmentMetaDataStoreAccessor$setAttachmentName$1) {
            attachmentMetaDataStoreAccessor$setAttachmentName$1 = (AttachmentMetaDataStoreAccessor$setAttachmentName$1) continuationImpl;
            int i = attachmentMetaDataStoreAccessor$setAttachmentName$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                attachmentMetaDataStoreAccessor$setAttachmentName$1.label = i - Integer.MIN_VALUE;
            } else {
                attachmentMetaDataStoreAccessor$setAttachmentName$1 = new AttachmentMetaDataStoreAccessor$setAttachmentName$1(this, continuationImpl);
            }
        }
        Object objUpdateData = attachmentMetaDataStoreAccessor$setAttachmentName$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = attachmentMetaDataStoreAccessor$setAttachmentName$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6811x27bfd640 c6811x27bfd640 = new C6811x27bfd640(str, null);
            attachmentMetaDataStoreAccessor$setAttachmentName$1.label = 1;
            objUpdateData = this.f4241a.updateData(c6811x27bfd640, attachmentMetaDataStoreAccessor$setAttachmentName$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((AttachmentMeta) objUpdateData).getAttachmentName();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4975b(AttachmentType attachmentType, ContinuationImpl continuationImpl) {
        AttachmentMetaDataStoreAccessor$setAttachmentType$1 attachmentMetaDataStoreAccessor$setAttachmentType$1;
        if (continuationImpl instanceof AttachmentMetaDataStoreAccessor$setAttachmentType$1) {
            attachmentMetaDataStoreAccessor$setAttachmentType$1 = (AttachmentMetaDataStoreAccessor$setAttachmentType$1) continuationImpl;
            int i = attachmentMetaDataStoreAccessor$setAttachmentType$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                attachmentMetaDataStoreAccessor$setAttachmentType$1.label = i - Integer.MIN_VALUE;
            } else {
                attachmentMetaDataStoreAccessor$setAttachmentType$1 = new AttachmentMetaDataStoreAccessor$setAttachmentType$1(this, continuationImpl);
            }
        }
        Object objUpdateData = attachmentMetaDataStoreAccessor$setAttachmentType$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = attachmentMetaDataStoreAccessor$setAttachmentType$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6812x3896ecb1 c6812x3896ecb1 = new C6812x3896ecb1(attachmentType, null);
            attachmentMetaDataStoreAccessor$setAttachmentType$1.label = 1;
            objUpdateData = this.f4241a.updateData(c6812x3896ecb1, attachmentMetaDataStoreAccessor$setAttachmentType$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((AttachmentMeta) objUpdateData).getAttachmentType();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4976c(String str, ContinuationImpl continuationImpl) {
        AttachmentMetaDataStoreAccessor$setAudioAttachmentId$1 attachmentMetaDataStoreAccessor$setAudioAttachmentId$1;
        if (continuationImpl instanceof AttachmentMetaDataStoreAccessor$setAudioAttachmentId$1) {
            attachmentMetaDataStoreAccessor$setAudioAttachmentId$1 = (AttachmentMetaDataStoreAccessor$setAudioAttachmentId$1) continuationImpl;
            int i = attachmentMetaDataStoreAccessor$setAudioAttachmentId$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                attachmentMetaDataStoreAccessor$setAudioAttachmentId$1.label = i - Integer.MIN_VALUE;
            } else {
                attachmentMetaDataStoreAccessor$setAudioAttachmentId$1 = new AttachmentMetaDataStoreAccessor$setAudioAttachmentId$1(this, continuationImpl);
            }
        }
        Object objUpdateData = attachmentMetaDataStoreAccessor$setAudioAttachmentId$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = attachmentMetaDataStoreAccessor$setAudioAttachmentId$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6813x4726b9e2 c6813x4726b9e2 = new C6813x4726b9e2(str, null);
            attachmentMetaDataStoreAccessor$setAudioAttachmentId$1.label = 1;
            objUpdateData = this.f4241a.updateData(c6813x4726b9e2, attachmentMetaDataStoreAccessor$setAudioAttachmentId$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((AttachmentMeta) objUpdateData).getAudioAttachmentId();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4977d(String str, ContinuationImpl continuationImpl) {
        AttachmentMetaDataStoreAccessor$setFileName$1 attachmentMetaDataStoreAccessor$setFileName$1;
        if (continuationImpl instanceof AttachmentMetaDataStoreAccessor$setFileName$1) {
            attachmentMetaDataStoreAccessor$setFileName$1 = (AttachmentMetaDataStoreAccessor$setFileName$1) continuationImpl;
            int i = attachmentMetaDataStoreAccessor$setFileName$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                attachmentMetaDataStoreAccessor$setFileName$1.label = i - Integer.MIN_VALUE;
            } else {
                attachmentMetaDataStoreAccessor$setFileName$1 = new AttachmentMetaDataStoreAccessor$setFileName$1(this, continuationImpl);
            }
        }
        Object objUpdateData = attachmentMetaDataStoreAccessor$setFileName$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = attachmentMetaDataStoreAccessor$setFileName$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6814x13e8ab47 c6814x13e8ab47 = new C6814x13e8ab47(str, null);
            attachmentMetaDataStoreAccessor$setFileName$1.label = 1;
            objUpdateData = this.f4241a.updateData(c6814x13e8ab47, attachmentMetaDataStoreAccessor$setFileName$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((AttachmentMeta) objUpdateData).getFileName();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4978e(String str, ContinuationImpl continuationImpl) {
        AttachmentMetaDataStoreAccessor$setNoteId$1 attachmentMetaDataStoreAccessor$setNoteId$1;
        if (continuationImpl instanceof AttachmentMetaDataStoreAccessor$setNoteId$1) {
            attachmentMetaDataStoreAccessor$setNoteId$1 = (AttachmentMetaDataStoreAccessor$setNoteId$1) continuationImpl;
            int i = attachmentMetaDataStoreAccessor$setNoteId$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                attachmentMetaDataStoreAccessor$setNoteId$1.label = i - Integer.MIN_VALUE;
            } else {
                attachmentMetaDataStoreAccessor$setNoteId$1 = new AttachmentMetaDataStoreAccessor$setNoteId$1(this, continuationImpl);
            }
        }
        Object objUpdateData = attachmentMetaDataStoreAccessor$setNoteId$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = attachmentMetaDataStoreAccessor$setNoteId$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            AttachmentMetaDataStoreAccessor$setNoteId$updateAttachmentMeta$1 attachmentMetaDataStoreAccessor$setNoteId$updateAttachmentMeta$1 = new AttachmentMetaDataStoreAccessor$setNoteId$updateAttachmentMeta$1(str, null);
            attachmentMetaDataStoreAccessor$setNoteId$1.label = 1;
            objUpdateData = this.f4241a.updateData(attachmentMetaDataStoreAccessor$setNoteId$updateAttachmentMeta$1, attachmentMetaDataStoreAccessor$setNoteId$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((AttachmentMeta) objUpdateData).getNoteId();
    }
}
