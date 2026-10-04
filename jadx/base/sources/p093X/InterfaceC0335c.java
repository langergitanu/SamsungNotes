package p093X;

import android.content.Context;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: X.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC0335c {
    String addTag(Context context, String str, String str2, boolean z);

    void deleteTag(Context context, String str, long j, int i, boolean z);

    void deleteTagSync(String str);

    int getDirtyCountOfNoteTag();

    int getNoteTagDeleted(String str, String str2);

    String getNoteTagExtraInfo(String str, String str2);

    long getNoteTagModifiedTime(String str, String str2);

    long getNoteTagServerTimestamp(String str);

    long getNoteTagServerTimestamp(String str, String str2);

    List getNoteTagUUIDList(String str);

    List getSDocUUIDListByTag(String str, boolean z);

    HashMap getSDocUuidAndNoteTagTimeList();

    int getTagDeleted(String str);

    String getTagExtraInfo(String str);

    long getTagLastModifiedTime(String str);

    String getTagName(String str);

    long getTagServerTimestamp(String str);

    String getTagUUID(String str, boolean z);

    List getTagUUIDList();

    List getTagUUIDListByDeleted(boolean z);

    List getTagUUIDListByDirty(int i);

    boolean isExistTag(String str);

    void recoveryTag(Context context, String str, long j, int i);

    void setNoteTag(Context context, String str, String str2, String str3);

    void setNoteTagContent(Context context, String str, String str2, int i, long j, long j2, String str3, int i2);

    int setNoteTagContentList(Context context, String str, List list, int i);

    void setNoteTagDirty(String str, int i);

    void setTagDirty(String str, int i);

    void setTagModifiedAndServerTimestampAndExtraInfo(String str, long j, long j2, String str2);

    void setTagServerTimestamp(String str, long j);

    Object synchronizeTag();

    void updateTagName(String str, String str2);
}
