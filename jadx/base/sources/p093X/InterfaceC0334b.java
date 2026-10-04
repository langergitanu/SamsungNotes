package p093X;

import android.content.Context;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: X.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC0334b {
    boolean convertTo32bitEncrypt(Context context, String str);

    void deleteSDoc(Context context, String str, int i, boolean z);

    void deleteSDocSync(Context context, String str, boolean z, String str2);

    int getDirtyCountOfNoteExtraInfo(Context context);

    int getNoteDeleted(Context context, String str);

    String getNoteFilePath();

    String getNoteFilePath(Context context, String str);

    long getNoteSaveTime(Context context, String str);

    long getNoteServerTime(Context context, String str);

    int getSdocContractLockTypeNone();

    int getSdocContractLockTypeSdoc();

    int getSdocContractNo();

    int getSdocContractToRecycleBin();

    int getSdocContractYes();

    List getUUIDList(Context context);

    List getUUIDListByCategoryDirty(Context context, int i);

    List getUUIDListByDirty(Context context, int i);

    List getUUIDListByDirtyForExtraInfo(Context context, int i);

    List getUUIDListByLocked(Context context, boolean z);

    HashMap getUuidAndNoteTimeList(Context context);

    boolean isExistNote(Context context, String str);

    void recoverySDoc(Context context, String str, long j, int i);

    void recycleBinResolverUpdateTimeMoved(Context context, String str, long j);

    void restoreSDoc(Context context, String str, boolean z);

    void setNoteDirty(Context context, String str, int i);

    int setNoteFavorite(Context context, String str, boolean z, boolean z2);

    void setNoteServerTime(Context context, String str, long j);

    void setNoteServerTimeAndDirty(Context context, String str, long j, int i);
}
