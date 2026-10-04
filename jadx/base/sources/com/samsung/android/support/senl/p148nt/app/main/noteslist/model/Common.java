package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import androidx.annotation.Nullable;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SpaceEntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Common {
    public CoeditMainListEntry coeditNotes;
    public List<NotesFolder> folders;
    public GroupInvitationListResult.GroupInvitation invitation;
    public boolean isExpandableSubFolder;
    public MainListDocumentData notes;
    public Set<String> selectedTags;
    public boolean showWithExpandAnimation;
    public List<Boolean> showWithScaleAnimation;
    public SpaceEntry space;
    public final int type;
    public String uuid;

    /* JADX INFO: renamed from: id */
    public long f6179id = 0;
    public long time = 0;
    public int isFavorite = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Coedit extends Note {
        public Coedit(CoeditMainListEntry coeditMainListEntry) {
            super(coeditMainListEntry.getMainListDocumentData());
            this.coeditNotes = coeditMainListEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditInvitation extends Common {
        public CoeditInvitation(GroupInvitationListResult.GroupInvitation groupInvitation) {
            super(131072);
            this.invitation = groupInvitation;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditSpace extends Common {
        public CoeditSpace(SpaceEntry spaceEntry) {
            super(8192);
            this.space = spaceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeleteConvertedNotesMessage extends Common {
        public DeleteConvertedNotesMessage() {
            super(33554432);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExpandBar extends Common {
        public ExpandBar(long j) {
            super(4194304);
            this.f6179id = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Folder extends Common {
        public Folder(List<NotesFolder> list, int i, List<Boolean> list2) {
            super(FeatureUtils.getFolderSpanHolderType(i));
            this.folders = list;
            this.uuid = "";
            for (NotesFolder notesFolder : list) {
                if (notesFolder != null) {
                    this.uuid = this.uuid.concat(notesFolder.getUuid());
                }
            }
            this.showWithScaleAnimation = list2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HashTag extends Common {
        public HashTag(long j, Set<String> set) {
            super(65536);
            this.f6179id = j;
            this.selectedTags = new HashSet(set);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecyclebinMessage extends Common {
        public RecyclebinMessage() {
            super(16777216);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SearchFilter extends Common {
        public SearchFilter() {
            super(2097152);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SyncProgressBar extends Common {
        public int syncNoteCount;

        public SyncProgressBar(long j, int i) {
            super(524288);
            this.f6179id = j;
            this.syncNoteCount = i;
        }
    }

    public Common(int i) {
        this.type = i;
    }

    private boolean equalsCoeditNote(CoeditMainListEntry coeditMainListEntry, CoeditMainListEntry coeditMainListEntry2, MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        if (coeditMainListEntry == null || coeditMainListEntry2 == null || (Integer.valueOf(mainListDocumentData.getDisplayContent().length).equals(Integer.valueOf(mainListDocumentData2.getDisplayContent().length)) && Arrays.equals(mainListDocumentData.getDisplayContent(), mainListDocumentData2.getDisplayContent()) && coeditMainListEntry.isSnapShotUpdateRequired() == coeditMainListEntry2.isSnapShotUpdateRequired() && coeditMainListEntry.getClientSavedChangePoint() == coeditMainListEntry2.getClientSavedChangePoint() && coeditMainListEntry.getMainListDocumentData().getFirstOpenedAt() == coeditMainListEntry2.getMainListDocumentData().getFirstOpenedAt() && coeditMainListEntry.getMemberCount() == coeditMainListEntry2.getMemberCount())) {
            return equalsNote(mainListDocumentData, mainListDocumentData2);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean equalsFolders(List<NotesFolder> list, List<NotesFolder> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= list.size() || (list.get(i) == null && list2.get(i) == null)) {
                break;
            }
            if (((list.get(i) == null) ^ (list2.get(i) == null)) || !list.get(i).equals(list2.get(i))) {
                return false;
            }
            i++;
        }
    }

    private boolean equalsNote(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return mainListDocumentData.getIsDeleted() == mainListDocumentData2.getIsDeleted() && mainListDocumentData.getCorrupted() == mainListDocumentData2.getCorrupted() && mainListDocumentData.getLastModifiedAt() == mainListDocumentData2.getLastModifiedAt() && mainListDocumentData.getIsFavorite() == mainListDocumentData2.getIsFavorite() && mainListDocumentData.getIsLock() == mainListDocumentData2.getIsLock() && mainListDocumentData.getBackgroundColor() == mainListDocumentData2.getBackgroundColor() && mainListDocumentData.getBackgroundColorInverted() == mainListDocumentData2.getBackgroundColorInverted() && Objects.equals(mainListDocumentData.getUuid(), mainListDocumentData2.getUuid()) && Objects.equals(mainListDocumentData.getContentUuid(), mainListDocumentData2.getContentUuid()) && Objects.equals(mainListDocumentData.getCategoryUuid(), mainListDocumentData2.getCategoryUuid()) && Objects.equals(mainListDocumentData.getTitle(), mainListDocumentData2.getTitle()) && Objects.equals(mainListDocumentData.getVrUuid(), mainListDocumentData2.getVrUuid()) && Objects.equals(mainListDocumentData.getStrokeUuid(), mainListDocumentData2.getStrokeUuid()) && Objects.equals(mainListDocumentData.getFilePath(), mainListDocumentData2.getFilePath()) && Objects.equals(mainListDocumentData.getRecommendedTitle(), mainListDocumentData2.getRecommendedTitle()) && mainListDocumentData.getCoverState() == mainListDocumentData2.getCoverState() && mainListDocumentData.isCoverEnabled() == mainListDocumentData2.isCoverEnabled() && Objects.equals(mainListDocumentData.getCoverBackgroundColor(), mainListDocumentData2.getCoverBackgroundColor()) && Objects.equals(mainListDocumentData.getCoverTemplateUuid(), mainListDocumentData2.getCoverTemplateUuid()) && Objects.equals(mainListDocumentData.getCoverSummary(), mainListDocumentData2.getCoverSummary()) && Objects.equals(mainListDocumentData.getCoverStickerUuid(), mainListDocumentData2.getCoverStickerUuid()) && Integer.valueOf(mainListDocumentData.getHasSticky()).equals(Integer.valueOf(mainListDocumentData2.getHasSticky())) && Integer.valueOf(mainListDocumentData.getUnknownMinVersion()).equals(Integer.valueOf(mainListDocumentData2.getUnknownMinVersion())) && Integer.valueOf(mainListDocumentData.getFormatVersion()).equals(Integer.valueOf(mainListDocumentData2.getFormatVersion())) && Integer.valueOf(mainListDocumentData.getBackgroundType()).equals(Integer.valueOf(mainListDocumentData2.getBackgroundType())) && Integer.valueOf(mainListDocumentData.getLayout()).equals(Integer.valueOf(mainListDocumentData2.getLayout())) && Objects.equals(mainListDocumentData.getImagePath(), mainListDocumentData2.getImagePath()) && Objects.equals(mainListDocumentData.getPlayTime(), mainListDocumentData2.getPlayTime());
    }

    private boolean equalsSpace(SpaceEntry spaceEntry, SpaceEntry spaceEntry2) {
        return spaceEntry.getMemberCount() == spaceEntry2.getMemberCount() && spaceEntry.getUnReadCount() == spaceEntry2.getUnReadCount() && Objects.equals(spaceEntry.getGroupId(), spaceEntry2.getGroupId()) && Objects.equals(spaceEntry.getSpaceId(), spaceEntry2.getSpaceId()) && Objects.equals(spaceEntry.getTitle(), spaceEntry2.getTitle()) && Objects.equals(spaceEntry.getThumbnailIds(), spaceEntry2.getThumbnailIds());
    }

    public boolean equals(@Nullable Object obj) {
        MainListDocumentData mainListDocumentData;
        CoeditMainListEntry coeditMainListEntry;
        if (!(obj instanceof Common)) {
            return false;
        }
        Common common = (Common) obj;
        int i = this.type;
        if (i != common.type) {
            return false;
        }
        if (i == 2048) {
            MainListDocumentData mainListDocumentData2 = this.notes;
            if (mainListDocumentData2 == null || (mainListDocumentData = common.notes) == null) {
                return false;
            }
            CoeditMainListEntry coeditMainListEntry2 = this.coeditNotes;
            return (coeditMainListEntry2 == null || (coeditMainListEntry = common.coeditNotes) == null) ? equalsNote(mainListDocumentData2, mainListDocumentData) : equalsCoeditNote(coeditMainListEntry2, coeditMainListEntry, mainListDocumentData2, mainListDocumentData);
        }
        if (i == 65536) {
            Set<String> set = this.selectedTags;
            return set != null && set.equals(common.selectedTags);
        }
        if (i == 4096) {
            return this.f6179id == common.f6179id && this.time == common.time;
        }
        if (i == 8192) {
            return equalsSpace(this.space, common.space);
        }
        if (i == 131072) {
            return Objects.equals(this.invitation.getGroupId(), common.invitation.getGroupId());
        }
        if (i == 262144 || i == 524288 || i == 4194304 || i == 16777216 || i == 2097152) {
            return true;
        }
        return equalsFolders(this.folders, common.folders);
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubHeader extends Common {
        public SubHeader(long j) {
            super(4096);
            this.f6179id = j;
        }

        public SubHeader(long j, long j2) {
            super(4096);
            this.f6179id = j;
            this.time = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Note extends Common {
        public Note(MainListDocumentData mainListDocumentData) {
            super(2048);
            this.notes = mainListDocumentData;
            this.uuid = mainListDocumentData.getUuid();
        }

        public Note(MainListDocumentData mainListDocumentData, long j) {
            super(2048);
            this.notes = mainListDocumentData;
            this.uuid = mainListDocumentData.getUuid();
            this.time = j;
            this.isFavorite = mainListDocumentData.getIsFavorite();
        }
    }
}
