package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import android.content.Intent;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\fH\u0016J,\u0010\u001b\u001a\u00020\t2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001dH\u0016J\u001c\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\"\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u001c\u0010&\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010(\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J-\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\f2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/J\"\u00100\u001a\u00020\t2\u0006\u0010*\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\fH\u0016¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/impl/DummyImpl;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/impl/SearchImpl;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/impl/CoeditSpaceImpl;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/impl/GcsImpl;", "<init>", "()V", "getSearchSavedText", "", "changeViewMode", "", "onScrolled", "dy", "", "onWindowInsetUpdated", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "onWindowInsetAnimationUpdated", "notifyRecentSearchDataChanged", "updateRecentSearchContainer", "updateRecentTagContainer", "updateRecentSearchVisibility", "isRecentSearchRequired", "", "updateRecentTagVisibility", "isRecentTagRequired", "launchSocialPickerForNewStandaloneNote", "toolType", "deleteStandaloneSpace", "deleteUuids", "", "titles", "onSpaceSelected", "groupId", "spaceId", "onSpaceLongPressed", "onGroupInvitationReceived", "handleMeetJoinAction", "isEnabledStatus", "onInvitationAccepted", "groupName", "onInvitationDeclined", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onNewNote", NotesConstants.KEY_FOLDER_UUID, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DummyImpl implements SearchImpl, CoeditSpaceImpl, GcsImpl {
    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void changeViewMode() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void deleteStandaloneSpace(@Nullable List<String> deleteUuids, @Nullable List<String> titles) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    @NotNull
    public String getSearchSavedText() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void handleMeetJoinAction() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean isEnabledStatus() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void launchSocialPickerForNewStandaloneNote(int toolType) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void notifyRecentSearchDataChanged() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean onGroupInvitationReceived() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onInvitationAccepted(@Nullable String groupId, @Nullable String groupName) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onInvitationDeclined(@Nullable String groupId) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onNewNote(@Nullable String folderUuid, int toolType) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onScrolled(int dy) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public boolean onSpaceLongPressed(@Nullable String groupId, @Nullable String spaceId) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl
    public void onSpaceSelected(@Nullable String groupId, @Nullable String spaceId) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetAnimationUpdated(@NotNull WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetUpdated(@NotNull WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentSearchContainer() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentSearchVisibility(boolean isRecentSearchRequired) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentTagContainer() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentTagVisibility(boolean isRecentTagRequired) {
    }
}
