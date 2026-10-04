package com.samsung.android.app.notes.sync.migration.proto.datastore;

import androidx.datastore.core.DataStore;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import os_migration_data_types.p233v1.NoteMeta;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.proto.datastore.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6832n {

    /* JADX INFO: renamed from: a */
    public final DataStore f4242a;

    public C6832n(DataStore noteMeta) {
        Intrinsics.checkNotNullParameter(noteMeta, "noteMeta");
        this.f4242a = noteMeta;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4979a(long j, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1 noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1) {
            noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1 = (NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1 = new NoteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6817x94c29b4e c6817x94c29b4e = new C6817x94c29b4e(j, null);
            noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1.label = 1;
            objUpdateData = this.f4242a.updateData(c6817x94c29b4e, noteMetaDataStoreAccessor$setCreationDataMillisSinceEpoch$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return Boxing.boxLong(((NoteMeta) objUpdateData).getCreationDateMillisSinceEpoch());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4980b(String str, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setFolderPath$1 noteMetaDataStoreAccessor$setFolderPath$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setFolderPath$1) {
            noteMetaDataStoreAccessor$setFolderPath$1 = (NoteMetaDataStoreAccessor$setFolderPath$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setFolderPath$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setFolderPath$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setFolderPath$1 = new NoteMetaDataStoreAccessor$setFolderPath$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setFolderPath$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setFolderPath$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            NoteMetaDataStoreAccessor$setFolderPath$updateNoteMeta$1 noteMetaDataStoreAccessor$setFolderPath$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setFolderPath$updateNoteMeta$1(str, null);
            noteMetaDataStoreAccessor$setFolderPath$1.label = 1;
            objUpdateData = this.f4242a.updateData(noteMetaDataStoreAccessor$setFolderPath$updateNoteMeta$1, noteMetaDataStoreAccessor$setFolderPath$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((NoteMeta) objUpdateData).getFolderPath();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4981c(String str, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setId$1 noteMetaDataStoreAccessor$setId$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setId$1) {
            noteMetaDataStoreAccessor$setId$1 = (NoteMetaDataStoreAccessor$setId$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setId$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setId$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setId$1 = new NoteMetaDataStoreAccessor$setId$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setId$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setId$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            NoteMetaDataStoreAccessor$setId$updateNoteMeta$1 noteMetaDataStoreAccessor$setId$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setId$updateNoteMeta$1(str, null);
            noteMetaDataStoreAccessor$setId$1.label = 1;
            objUpdateData = this.f4242a.updateData(noteMetaDataStoreAccessor$setId$updateNoteMeta$1, noteMetaDataStoreAccessor$setId$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((NoteMeta) objUpdateData).getId();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4982d(boolean z, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setIsCloudSynced$1 noteMetaDataStoreAccessor$setIsCloudSynced$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setIsCloudSynced$1) {
            noteMetaDataStoreAccessor$setIsCloudSynced$1 = (NoteMetaDataStoreAccessor$setIsCloudSynced$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setIsCloudSynced$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setIsCloudSynced$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setIsCloudSynced$1 = new NoteMetaDataStoreAccessor$setIsCloudSynced$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setIsCloudSynced$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setIsCloudSynced$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            NoteMetaDataStoreAccessor$setIsCloudSynced$updateNoteMeta$1 noteMetaDataStoreAccessor$setIsCloudSynced$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setIsCloudSynced$updateNoteMeta$1(z, null);
            noteMetaDataStoreAccessor$setIsCloudSynced$1.label = 1;
            objUpdateData = this.f4242a.updateData(noteMetaDataStoreAccessor$setIsCloudSynced$updateNoteMeta$1, noteMetaDataStoreAccessor$setIsCloudSynced$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return Boxing.boxBoolean(((NoteMeta) objUpdateData).getIsCloudSynced());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4983e(long j, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1 noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1) {
            noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1 = (NoteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1 = new NoteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            C6818xbd2d45aa c6818xbd2d45aa = new C6818xbd2d45aa(j, null);
            noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1.label = 1;
            objUpdateData = this.f4242a.updateData(c6818xbd2d45aa, noteMetaDataStoreAccessor$setLastModifiedDateMillisSinceEpoch$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return Boxing.boxLong(((NoteMeta) objUpdateData).getLastModifiedDateMillisSinceEpoch());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4984f(List list, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setTags$1 noteMetaDataStoreAccessor$setTags$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setTags$1) {
            noteMetaDataStoreAccessor$setTags$1 = (NoteMetaDataStoreAccessor$setTags$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setTags$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setTags$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setTags$1 = new NoteMetaDataStoreAccessor$setTags$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setTags$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setTags$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            NoteMetaDataStoreAccessor$setTags$updateNoteMeta$1 noteMetaDataStoreAccessor$setTags$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setTags$updateNoteMeta$1(list, null);
            noteMetaDataStoreAccessor$setTags$1.label = 1;
            objUpdateData = this.f4242a.updateData(noteMetaDataStoreAccessor$setTags$updateNoteMeta$1, noteMetaDataStoreAccessor$setTags$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((NoteMeta) objUpdateData).getTagsList();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m4985g(String str, ContinuationImpl continuationImpl) {
        NoteMetaDataStoreAccessor$setTitle$1 noteMetaDataStoreAccessor$setTitle$1;
        if (continuationImpl instanceof NoteMetaDataStoreAccessor$setTitle$1) {
            noteMetaDataStoreAccessor$setTitle$1 = (NoteMetaDataStoreAccessor$setTitle$1) continuationImpl;
            int i = noteMetaDataStoreAccessor$setTitle$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                noteMetaDataStoreAccessor$setTitle$1.label = i - Integer.MIN_VALUE;
            } else {
                noteMetaDataStoreAccessor$setTitle$1 = new NoteMetaDataStoreAccessor$setTitle$1(this, continuationImpl);
            }
        }
        Object objUpdateData = noteMetaDataStoreAccessor$setTitle$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = noteMetaDataStoreAccessor$setTitle$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateData);
            NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1 noteMetaDataStoreAccessor$setTitle$updateNoteMeta$1 = new NoteMetaDataStoreAccessor$setTitle$updateNoteMeta$1(str, null);
            noteMetaDataStoreAccessor$setTitle$1.label = 1;
            objUpdateData = this.f4242a.updateData(noteMetaDataStoreAccessor$setTitle$updateNoteMeta$1, noteMetaDataStoreAccessor$setTitle$1);
            if (objUpdateData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateData);
        }
        return ((NoteMeta) objUpdateData).getId();
    }
}
