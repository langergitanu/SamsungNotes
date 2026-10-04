package com.samsung.android.support.senl.p148nt.app.main.common.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface AdapterContract {
    void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable);

    int getCheckedFoldersCount();

    List<Common> getCommonDisplayList();

    View getInflatedView(int i);

    int getModeIndex();

    int getNoteListHeight();

    int getRecyclerViewHeight();

    List<SOMRecognizedInfo> getSOMRecognizedInfo();

    int getSearchCallerMode();

    FilterInfo.SearchEmptyType getSearchEmptyType();

    int getSearchViewTranslationY();

    Set<String> getSelectedTags();

    Drawable getSubFolderBitmap(int i, int i2);

    boolean hasHolderInfo(int... iArr);

    boolean isFilterCollapsed();

    boolean isRecentSearchRequired();

    boolean isRecentTagRequired();

    boolean isRunningAnimator();

    boolean isSOMDataChangeNotifyPendingRequired();

    boolean isSOMRecognitionStateProgressing();

    boolean isScrolling();

    boolean isUnlockConverting(String str);

    void notifyItemChanged(int i, @Nullable Object obj, String str);

    void onBindViewHolder(CommonHolderInfo commonHolderInfo);

    void onCoeditInvitationSelected(String str, String str2, boolean z);

    boolean onContextClick(CommonHolderInfo commonHolderInfo);

    void onCoverFilterSelected(@NonNull String str);

    void onFilterCollapsed(boolean z);

    void onFolderFilterChanged(boolean z);

    void onHashTagSelected(@Nullable String str);

    void onHashTagSelected(Set<String> set);

    boolean onItemLongPressed(String str);

    void onKeywordSelected(@NonNull String str);

    void onNoteSelected(String str, int i, String str2);

    void onNoteSelectedBySOMRecognizedCard(String str, int i);

    void onOldCategorySelected(String str);

    void onRestoreCorruptedNoteSelect(String str);

    void onSOMRecognizedCardAttachedToWindow();

    void onSOMRecognizedCardDetachedFromWindow();

    boolean onSpaceLongPressed(String str, String str2);

    void onSpaceSelected(String str, String str2);

    void onSubFolderSelected(String str);

    boolean onSubHeaderSelected(long j, boolean z);

    boolean onSubHeaderSelected(boolean z, int i);

    void onTimeFilterSelected(int i);

    void onTipCardBindViewHolder(CommonHolderInfo commonHolderInfo);

    void onTypeFilterSelected(int i);

    void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo);

    void registerNoteAnimation(Runnable runnable);

    void requestAllDeleteConvertedNotes();

    void setDragListener(CommonHolderInfo commonHolderInfo);

    void toggleFolderExpandCollapseState();

    void toggleSOMRecognizedCardExpandCollapseState();
}
