package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.exception.DisplayDataException;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubHeaderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubHeaderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox.common.CheckBoxTransition;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.checkbox.common.ListTransition;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CheckBoxAnimatorController {
    private static final String TAG = "CheckBoxAnimatorController";
    private final DocumentMap mDocumentMap;
    private final NotesModel mNotesModel;
    private final NotesPenRecyclerView mRecyclerView;
    private final ObjectBuilder<RecyclerViewHelper> mRecyclerViewHelper;
    private final ViewParams mViewParams;

    public CheckBoxAnimatorController(ObjectBuilder<RecyclerViewHelper> objectBuilder, ViewParams viewParams, NotesModel notesModel, DocumentMap documentMap) {
        this.mRecyclerViewHelper = objectBuilder;
        this.mRecyclerView = objectBuilder.getInstance().getRecyclerView();
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
    }

    private int getModeIndex() {
        return this.mViewParams.getModeIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTransitionEnd() {
        if (this.mRecyclerView.isLongPressed()) {
            this.mRecyclerViewHelper.getInstance().setAutoScrollEnabled(true);
        } else {
            this.mRecyclerViewHelper.getInstance().checkAutoScroll();
        }
    }

    private void updateCheckBox(@NonNull CommonHolderInfo commonHolderInfo, int i, boolean z) {
        final CheckBox checkBox = commonHolderInfo.getCheckBox();
        if (commonHolderInfo.getHolderType() == 4096) {
            checkBox.setVisibility(i);
            return;
        }
        boolean z2 = true;
        if (commonHolderInfo.getHolderType() <= 1024 && (FolderUtils.isStaticFolder(commonHolderInfo.getUuid()) || FeatureUtils.isPickEditMode(getModeIndex()))) {
            z2 = false;
        }
        checkBox.setVisibility((z2 || i != 0) ? i : 4);
        if (z && z2) {
            if (i == 0 || !ContentUtils.isGridViewMode(FeatureUtils.getViewMode(getModeIndex()))) {
                if (i != 0) {
                    TransitionManager.beginDelayedTransition((ViewGroup) checkBox.getParent(), new CheckBoxTransition());
                    return;
                }
                checkBox.setAlpha(0.0f);
                checkBox.setScaleX(0.5f);
                checkBox.setScaleY(0.5f);
                checkBox.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        checkBox.setScaleX(1.0f);
                        checkBox.setScaleY(1.0f);
                        checkBox.setAlpha(1.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        checkBox.setScaleX(1.0f);
                        checkBox.setScaleY(1.0f);
                        checkBox.setAlpha(1.0f);
                    }
                }).start();
            }
        }
    }

    private void updateCoeditSpaceHolder(@NonNull CoeditSpaceHolder coeditSpaceHolder, int i) {
        CommonHolderInfo coeditSpaceHolderInfo = coeditSpaceHolder.getCoeditSpaceHolderInfo();
        if (coeditSpaceHolderInfo == null) {
            return;
        }
        coeditSpaceHolderInfo.setEnable(i != 0);
    }

    private void updateCountTextView(@NonNull CommonHolder commonHolder, boolean z) {
        if (commonHolder.getMHolderType() > 1024) {
            return;
        }
        for (int i = 0; i < ((SubFolderHolder) commonHolder).getSubFolderCount(); i++) {
            View viewFindViewById = commonHolder.itemView.findViewById(NotesHolderUtil.getSubFolderViewById(i));
            if (viewFindViewById != null) {
                viewFindViewById.findViewById(C8003R.id.count).setVisibility(z ? 8 : 0);
            }
        }
    }

    private void updateHolderCheckBox(@NonNull CommonHolderInfo commonHolderInfo, boolean z, int i, boolean z2) {
        if (commonHolderInfo.getIsEnable()) {
            commonHolderInfo.getCheckBox().setChecked(z);
            commonHolderInfo.getCheckBox().jumpDrawablesToCurrentState();
        }
        boolean z3 = false;
        updateContentDescription(commonHolderInfo, i == 0);
        if (z2 && commonHolderInfo.getCheckBox().getVisibility() != i) {
            z3 = true;
        }
        updateCheckBox(commonHolderInfo, i, z3);
    }

    private void updateNotesHolderCheckBox(@NonNull NotesHolder notesHolder, int i, boolean z, boolean z2) {
        NotesHolderInfo notesHolderInfo = notesHolder.getNotesHolderInfo();
        if (notesHolderInfo == null) {
            return;
        }
        updateHolderCheckBox(notesHolderInfo, z2 ? this.mNotesModel.isUuidInCheckedNotes(notesHolderInfo.getUuid()) : notesHolderInfo.getCheckBox().isChecked(), i, z);
    }

    private void updateSubFolderHoldersCheckBox(@NonNull SubFolderHolder subFolderHolder, int i, boolean z, boolean z2) {
        int subFolderCount = subFolderHolder.getSubFolderCount();
        for (int i2 = 0; i2 < subFolderCount; i2++) {
            SubFolderHolderInfo subFolderHolderInfo = subFolderHolder.getSubFolderHolderInfo(i2);
            if (subFolderHolderInfo == null) {
                return;
            }
            CheckBox checkBox = subFolderHolderInfo.getCheckBox();
            if (!FolderUtils.isStaticFolder(subFolderHolderInfo.getUuid())) {
                updateHolderCheckBox(subFolderHolderInfo, z2 ? this.mNotesModel.isUuidInCheckedFolder(subFolderHolderInfo.getUuid()) : checkBox.isChecked(), i, z);
            } else if (checkBox.getVisibility() == 0) {
                checkBox.setVisibility(4);
                checkBox.setChecked(false);
                MainLogger.m7258i(TAG, "updateSubFolderHoldersCheckBox# StaticFolder checkbox visible");
            }
        }
    }

    private void updateSubHeaderHolderCheckBox(@NonNull SubHeaderHolder subHeaderHolder, int i, boolean z, boolean z2) {
        boolean zIsChecked;
        SubHeaderHolderInfo subHeaderHolderInfo = subHeaderHolder.getSubHeaderHolderInfo();
        if (subHeaderHolderInfo == null) {
            return;
        }
        if (FeatureUtils.isNotSupportCheckingSubHeader(subHeaderHolderInfo.getId())) {
            subHeaderHolderInfo.setEnable(i != 0);
            return;
        }
        if (!z2) {
            zIsChecked = subHeaderHolderInfo.getCheckBox().isChecked();
        } else if (subHeaderHolderInfo.getId() == -15 || subHeaderHolderInfo.getId() == -14 || subHeaderHolderInfo.getId() == -16) {
            zIsChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(subHeaderHolderInfo.getId() == -15));
        } else {
            zIsChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(subHeaderHolder.getAbsoluteAdapterPosition()));
        }
        updateHolderCheckBox(subHeaderHolderInfo, zIsChecked, i, z);
    }

    public void modeChangeAnimation(final boolean z) {
        AbstractC8014b.m7210l("modeChangeAnimation# isCurrentEditMode : ", TAG, z);
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int viewMode = FeatureUtils.getViewMode(getModeIndex());
        for (int i = 0; i < layoutManager.getChildCount(); i++) {
            View childAt = layoutManager.getChildAt(i);
            if (childAt != null) {
                updateCountTextView((CommonHolder) this.mRecyclerView.getChildViewHolder(childAt), z);
            }
        }
        if (!ContentUtils.isGridViewMode(viewMode)) {
            if (viewMode == 1) {
                TransitionManager.beginDelayedTransition(this.mRecyclerView, new ListTransition().addListener((Transition.TransitionListener) new TransitionListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController.3
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(@NonNull Transition transition) {
                        super.onTransitionEnd(transition);
                        if (z) {
                            CheckBoxAnimatorController.this.onTransitionEnd();
                        }
                    }
                }));
            } else {
                TransitionManager.beginDelayedTransition(this.mRecyclerView, new ListTransition());
            }
        }
        updateCheckBox(z ? 0 : 8, true);
    }

    public void setCheck(CommonHolderInfo commonHolderInfo, boolean z, boolean z2) {
        if (commonHolderInfo == null || commonHolderInfo.getHolderType() >= 4096 || FolderUtils.isStaticFolder(commonHolderInfo.getUuid()) || !z2 || commonHolderInfo.getCheckBox() == null) {
            return;
        }
        commonHolderInfo.getCheckBox().setChecked(z);
        updateContentDescription(commonHolderInfo, true);
    }

    public void setCheckBoxState(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo == null) {
            return;
        }
        updateCheckBox(commonHolderInfo, FeatureUtils.isEditMode(getModeIndex()) ? 0 : 8, false);
    }

    public void updateCheckBoxWithSubHeader(int i, boolean z, boolean z2) {
        CommonHolder commonHolder;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        MainLogger.m7254d(TAG, "updateCheckBoxWithSubHeader# visible :" + i + ", isConverted : " + z2);
        boolean z3 = false;
        for (int i2 = 0; i2 < layoutManager.getChildCount(); i2++) {
            View childAt = layoutManager.getChildAt(i2);
            if (childAt != null && (commonHolder = (CommonHolder) this.mRecyclerView.findContainingViewHolder(childAt)) != null && commonHolder.getMHolderType() < 16384) {
                int mHolderType = commonHolder.getMHolderType();
                if (mHolderType == 2048) {
                    updateNotesHolderCheckBox((NotesHolder) commonHolder, i, z, z3);
                } else if (mHolderType == 4096) {
                    SubHeaderHolder subHeaderHolder = (SubHeaderHolder) commonHolder;
                    SubHeaderHolderInfo subHeaderHolderInfo = subHeaderHolder.getSubHeaderHolderInfo();
                    if (z3) {
                        if ((z2 && subHeaderHolderInfo.getId() == -14) || (!z2 && subHeaderHolderInfo.getId() == -15)) {
                            z3 = false;
                        }
                    } else if ((z2 && subHeaderHolderInfo.getId() == -15) || (!z2 && subHeaderHolderInfo.getId() == -14)) {
                        z3 = true;
                    }
                    updateSubHeaderHolderCheckBox(subHeaderHolder, i, z, z3);
                } else if (mHolderType != 8192) {
                    updateSubFolderHoldersCheckBox((SubFolderHolder) commonHolder, i, z, z3);
                } else {
                    updateCoeditSpaceHolder((CoeditSpaceHolder) commonHolder, i);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateContentDescription(final CommonHolderInfo commonHolderInfo, final boolean z) {
        CharSequence charSequence;
        String dateText;
        CharSequence displayName;
        if (commonHolderInfo == null || commonHolderInfo.getHolderType() >= 16384) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        CharSequence displayContentAndExtra = null;
        if (commonHolderInfo.getHolderType() != 4096) {
            if (commonHolderInfo.getHolderType() == 2048) {
                MainListDocumentData noteData = this.mDocumentMap.getNoteData(commonHolderInfo.getUuid());
                if (noteData == null) {
                    return;
                }
                CharSequence title = commonHolderInfo.getTitle();
                dateText = commonHolderInfo.getDateText();
                try {
                    if (LockUtils.isUnLockedDocType(noteData.getIsLock())) {
                        displayContentAndExtra = NotesHolderUtil.getDisplayContentAndExtra(this.mRecyclerView.getContext(), noteData);
                    }
                } catch (DisplayDataException e) {
                    MainLogger.m7255e(TAG, "updateContentDescription# uuid : " + commonHolderInfo.getUuid() + SQLKeyword.COMMA + e.getMessage());
                }
                charSequence = displayContentAndExtra;
                displayContentAndExtra = title;
            } else if (commonHolderInfo.getHolderType() <= 1024) {
                NotesFolder folderData = DataManager.getInstance().getFolderData(commonHolderInfo.getUuid());
                if (folderData == null) {
                    return;
                } else {
                    displayName = folderData.getDisplayName();
                }
            } else {
                charSequence = null;
                dateText = null;
            }
            if (displayContentAndExtra != null) {
                sb.append(displayContentAndExtra);
                sb.append(' ');
            }
            if (charSequence != null) {
                sb.append(charSequence);
                sb.append(' ');
            }
            if (dateText != null) {
                sb.append(dateText);
            }
            ViewCompat.setAccessibilityDelegate(commonHolderInfo.getRootCardView(), new AccessibilityDelegateCompat() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setCheckable(z);
                    if (z) {
                        accessibilityNodeInfoCompat.setChecked(commonHolderInfo.getCheckBox().isChecked());
                        accessibilityNodeInfoCompat.setClassName(commonHolderInfo.getCheckBox().getAccessibilityClassName());
                    }
                    accessibilityNodeInfoCompat.setContentDescription(sb);
                }
            });
        }
        displayName = commonHolderInfo.getTitle();
        dateText = null;
        displayContentAndExtra = displayName;
        charSequence = null;
        if (displayContentAndExtra != null) {
        }
        if (charSequence != null) {
        }
        if (dateText != null) {
        }
        ViewCompat.setAccessibilityDelegate(commonHolderInfo.getRootCardView(), new AccessibilityDelegateCompat() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.checkbox.CheckBoxAnimatorController.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(z);
                if (z) {
                    accessibilityNodeInfoCompat.setChecked(commonHolderInfo.getCheckBox().isChecked());
                    accessibilityNodeInfoCompat.setClassName(commonHolderInfo.getCheckBox().getAccessibilityClassName());
                }
                accessibilityNodeInfoCompat.setContentDescription(sb);
            }
        });
    }

    public void updateCheckBoxWithSubHeader(int i, boolean z, int i2) {
        CommonHolder commonHolder;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        for (int i4 = 0; i4 < layoutManager.getChildCount(); i4++) {
            View childAt = layoutManager.getChildAt(i4);
            if (childAt != null && (commonHolder = (CommonHolder) this.mRecyclerView.findContainingViewHolder(childAt)) != null && commonHolder.getMHolderType() < 16384 && commonHolder.getAbsoluteAdapterPosition() > i2) {
                if (commonHolder.getMHolderType() != 2048) {
                    return;
                } else {
                    updateNotesHolderCheckBox((NotesHolder) commonHolder, i, z, true);
                }
            }
        }
    }

    public void updateCheckBox(int i, boolean z) {
        CommonHolder commonHolder;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        AbstractC6670b.m4736A(i, "updateCheckBox# visible : ", TAG);
        for (int i2 = 0; i2 < layoutManager.getChildCount(); i2++) {
            View childAt = layoutManager.getChildAt(i2);
            if (childAt != null && (commonHolder = (CommonHolder) this.mRecyclerView.findContainingViewHolder(childAt)) != null && commonHolder.getMHolderType() < 16384) {
                int mHolderType = commonHolder.getMHolderType();
                if (mHolderType == 2048) {
                    updateNotesHolderCheckBox((NotesHolder) commonHolder, i, z, true);
                } else if (mHolderType == 4096) {
                    updateSubHeaderHolderCheckBox((SubHeaderHolder) commonHolder, i, z, true);
                } else if (mHolderType != 8192) {
                    updateSubFolderHoldersCheckBox((SubFolderHolder) commonHolder, i, z, true);
                } else {
                    updateCoeditSpaceHolder((CoeditSpaceHolder) commonHolder, i);
                }
            }
        }
    }
}
