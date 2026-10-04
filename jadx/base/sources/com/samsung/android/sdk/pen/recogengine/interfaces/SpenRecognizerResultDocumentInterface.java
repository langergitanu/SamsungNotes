package com.samsung.android.sdk.pen.recogengine.interfaces;

import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J \u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultDocumentInterface;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "groupCount", "", "getGroupCount", "()I", "getGroupType", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultDocumentInterface$GroupType;", "groupID", "getGroupStroke", "", "getSubGroupCount", "getSubGroupStrokeCount", "subGroupID", "getSubGroupStroke", "isSubGroupSkewed", "", "GroupType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenRecognizerResultDocumentInterface extends SpenRecognizerResultInterface {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultDocumentInterface$GroupType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "OTHER", "SHAPE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class GroupType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GroupType[] $VALUES;
        public static final GroupType TEXT = new GroupType("TEXT", 0);
        public static final GroupType OTHER = new GroupType("OTHER", 1);
        public static final GroupType SHAPE = new GroupType("SHAPE", 2);

        private static final /* synthetic */ GroupType[] $values() {
            return new GroupType[]{TEXT, OTHER, SHAPE};
        }

        static {
            GroupType[] groupTypeArr$values = $values();
            $VALUES = groupTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(groupTypeArr$values);
        }

        private GroupType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<GroupType> getEntries() {
            return $ENTRIES;
        }

        public static GroupType valueOf(String str) {
            return (GroupType) Enum.valueOf(GroupType.class, str);
        }

        public static GroupType[] values() {
            return (GroupType[]) $VALUES.clone();
        }
    }

    int getGroupCount();

    @Nullable
    List<Integer> getGroupStroke(int groupID);

    @NotNull
    GroupType getGroupType(int groupID);

    int getSubGroupCount(int groupID);

    @Nullable
    List<Integer> getSubGroupStroke(int groupID, int subGroupID);

    int getSubGroupStrokeCount(int groupID, int subGroupID);

    boolean isSubGroupSkewed(int groupID, int subGroupID);
}
