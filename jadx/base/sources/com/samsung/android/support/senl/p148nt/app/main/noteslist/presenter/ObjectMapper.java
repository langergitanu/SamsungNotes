package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.MeridianDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ImportMultiplePdfDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.PdfImportTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.cover.CoverHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.BackPressedHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.CoeditHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DetailsMenuHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DragAndDropHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.ExportHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.LockHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.MicrosoftHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.PdfImportHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SearchHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareDialogTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.TipCardHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import p084U0.C0312d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObjectMapper extends DataMapper {
    private static final String TAG = "ObjectMapper";
    protected final ObjectBuilder<LockHelper> mLockHelper = new ObjectBuilder<LockHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public LockHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new LockHelper(objectMapper.mViewParams, objectMapper.mNotesModel, objectMapper.mDocumentMap, objectMapper.mStateInfo, new LockHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.1.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void deleteAllConvertedNotes() {
                    ObjectMapper.this.mAdapterManager.runDeleteConvertedNotesTask();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void deleteItems() {
                    ObjectMapper.this.mDialogHelper.getInstance().deleteItems(ObjectMapper.this.mNotesModel.getCheckedNotesUUID(), ObjectMapper.this.mNotesModel.getCheckedFoldersUUID());
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void deleteSelectedConvertedNotes(List<String> list) {
                    ObjectMapper.this.mDialogHelper.getInstance().deleteItems(new ArrayList<>(list), new ArrayList<>());
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void dismissDeleteDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().dismissDeleteDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void moveToSecureFolder(int i) {
                    ObjectMapper.this.moveToSecureFolder(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent) {
                    ObjectMapper.this.mViewParams.getNotesView().onActivityResultAfterVerify(i, i2, intent);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void onNoteSelectedWidget(MainEntryParam mainEntryParam) {
                    ObjectMapper.this.mViewParams.getNotesView().onNoteSelectedWidget(mainEntryParam);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void onTaskFinished() {
                    ObjectMapper.this.onTaskFinished();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void requestImportToSpace(String str, List<String> list, boolean z) {
                    ObjectMapper.this.mCoeditHelper.getInstance().requestImport(ObjectMapper.this.mViewParams.getContext(), str, list, z);
                    ObjectMapper.this.clearCheckedData();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void requestStartConvertOldNotes(List<String> list, Intent intent) {
                    ObjectMapper.this.startConvertNotes(list, intent.getBooleanExtra(NotesConstants.KEY_IS_SKIP_CONVERTED, false), true);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.IPresenter
                public void startCoedit(boolean z) {
                    ObjectMapper.this.mCoeditHelper.getInstance().startCoedit(z);
                }
            });
        }
    };
    protected final ObjectBuilder<DialogHelper> mDialogHelper = new ObjectBuilder<DialogHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.2

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements DialogHelper.IPresenter {
            public AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ boolean lambda$requestDeleteConvertedNotes$0(List list, String str) {
                return !list.contains(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void duplicateToDevice(ArrayList<ImportDocument> arrayList) {
                ObjectMapper.this.duplicateToDevice(arrayList);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void onRestoreCorruptedNoteSelect(String str) {
                ObjectMapper.this.mAdapterManager.onRestoreCorruptedNoteSelect(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void onTaskCancel() {
                ObjectMapper.this.onTaskCancel();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void onTaskFinished() {
                ObjectMapper.this.onTaskFinished();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void requestDeleteConvertedNotes(List<String> list, boolean z) {
                List<String> oldNotesWithConvertedNotesInUse = DataManager.getInstance().getOldNotesWithConvertedNotesInUse(list);
                MainLogger.m7258i(ObjectMapper.TAG, "requestDeleteConvertedNotes, all/convert/delete: " + list.size() + "/" + ((List) list.stream().filter(new C8506l(oldNotesWithConvertedNotesInUse, 0)).collect(Collectors.toList())).size() + "/" + oldNotesWithConvertedNotesInUse.size());
                if (z) {
                    ObjectMapper.this.mLockHelper.getInstance().verifyLockedNote(119, null, (String[]) list.toArray(new String[list.size()]));
                } else {
                    ObjectMapper.this.mDialogHelper.getInstance().deleteItems(new ArrayList<>(list), new ArrayList<>());
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void requestStartConvertOldNotes(List<String> list, boolean z) {
                ObjectMapper.this.startConvertNotes(list, z, false);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void unlockForMoveToSecureFolder() {
                ObjectMapper.this.mLockHelper.getInstance().unlockForMoveToSecureFolder();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.IPresenter
            public void verifyForDelete() {
                ObjectMapper.this.mLockHelper.getInstance().verifyForDelete(107);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public DialogHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new DialogHelper(objectMapper.mViewParams, objectMapper.mNotesModel, objectMapper.mDocumentMap, objectMapper.mStateInfo, objectMapper.mDialogCreator, new AnonymousClass1());
        }
    };
    protected final ObjectBuilder<TipCardHelper> mTipCardHelper = new ObjectBuilder<TipCardHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public TipCardHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new TipCardHelper(objectMapper.mViewParams, objectMapper.mDocumentMap, objectMapper.mStateInfo, new TipCardHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.3.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void handleTipCardItemCountChange() {
                    ObjectMapper.this.mAdapterManager.handleTipCardItemCountChange();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void joinMeetingWithTipCard(LiveSharingManager.Caller caller, boolean z, LiveSharingManager.TipCardCallback tipCardCallback) {
                    ObjectMapper.this.mLiveSharingHelper.joinMeetingWithTipCard(caller, z, tipCardCallback);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void removeTipCard() {
                    ObjectMapper.this.mAdapterManager.removeTipCard();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void requestConvertAllOldNotes() {
                    ObjectMapper.this.showConvertConfirmDialog(true);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void showAppUpdateDialog(String str) {
                    ObjectMapper.this.mDialogHelper.getInstance().showAppUpdateDialog(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void showSamsungAccountLoginForMsSyncDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().showSamsungAccountLoginForMsSyncDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void showTipCard() {
                    ObjectMapper.this.mAdapterManager.showTipCard();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void startConvertNotes(List<String> list) {
                    ObjectMapper.this.startConvertNotes(list, false, false);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.IPresenter
                public void updateTipCardLayout() {
                    ObjectMapper.this.mAdapterManager.updateTipCardLayout();
                }
            });
        }
    };
    protected final ObjectBuilder<MicrosoftHelper> mMicrosoftHelper = new ObjectBuilder<MicrosoftHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public MicrosoftHelper build() {
            return new MicrosoftHelper(new MicrosoftHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.4.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.IPresenter
                public void addMicrosoftAccountLoginTipCard() {
                    ObjectMapper.this.mTipCardHelper.getInstance().addMicrosoftAccountLoginTipCard();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.IPresenter
                public AbsFragment getAbsFragment() {
                    return ObjectMapper.this.mViewParams.getAbsFragment();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.IPresenter
                public int getModeIndex() {
                    return ObjectMapper.this.mViewParams.getModeIndex();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.IPresenter
                public void showMeridianDialog(MeridianDialogFragment.DialogListener dialogListener) {
                    ObjectMapper.this.mDialogHelper.getInstance().showMeridianDialog(dialogListener);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.MicrosoftHelper.IPresenter
                public void startMeridianSettingProcess() {
                    ObjectMapper.this.openSettingsMicrosoftLogin();
                }
            });
        }
    };
    protected final ObjectBuilder<RecyclerViewHelper> mRecyclerViewHelper = new ObjectBuilder<RecyclerViewHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.5
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public RecyclerViewHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new RecyclerViewHelper(objectMapper.mViewParams, objectMapper.mNotesModel, objectMapper.mDocumentMap, objectMapper.mStateInfo, new RecyclerViewHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.5.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void dragFolderSelectState(int i, boolean z, int i2) {
                    ObjectMapper.this.mDragAndDropHelper.getInstance().dragFolderSelectState(i, z, i2);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void dragNoteSelectState(int i, boolean z) {
                    ObjectMapper.this.mDragAndDropHelper.getInstance().dragNoteSelectState(i, z);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public int getTipCardHolderCount() {
                    return ObjectMapper.this.getTipCardHolderCount();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public boolean isSOMRecognizedCardHolder(int i) {
                    return ObjectMapper.this.mSOMRecognizeHelper.getInstance().isSOMRecognizedCardHolder(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam) {
                    ObjectMapper.this.mViewParams.getNotesView().onRestoreCorruptedNoteSelect(mainEntryParam);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void selectAllNotes(boolean z) {
                    ObjectMapper.this.selectAll(z);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void startDragAndDrop(String str) {
                    ObjectMapper.this.mDragAndDropHelper.getInstance().startDragAndDrop(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.IPresenter
                public void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z) {
                    ObjectMapper.this.mCheckBoxAnimatorController.updateContentDescription(commonHolderInfo, z);
                }
            });
        }
    };
    protected final ObjectBuilder<PdfImportHelper> mPdfImportHelper = new ObjectBuilder<PdfImportHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public PdfImportHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new PdfImportHelper(objectMapper.mViewParams, objectMapper.mNotesModel, new PdfImportHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.6.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.PdfImportHelper.IPresenter
                public void restoreImportMultiPdfDialog(ImportMultiplePdfDialogFragment.Contract contract) {
                    ObjectMapper.this.mDialogHelper.getInstance().restoreImportMultiPdfDialog(contract);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.PdfImportHelper.IPresenter
                public void setToolType(int i) {
                    ObjectMapper.this.setToolType(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.PdfImportHelper.IPresenter
                public void showImportMultiPdfDialog(String str, int i, List<Uri> list, ImportMultiplePdfDialogFragment.Contract contract) {
                    ObjectMapper.this.mDialogHelper.getInstance().showImportMultiPdfDialog(str, i, list, contract);
                }
            });
        }
    };
    protected final ObjectBuilder<ExportHelper> mExportHelper = new ObjectBuilder<ExportHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public ExportHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new ExportHelper(objectMapper.mViewParams, objectMapper.mNotesModel, new ExportHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.7.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void clearCheckedData() {
                    ObjectMapper.this.clearCheckedData();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void removeCircleProgressDialog() {
                    ObjectMapper.this.removeCircleProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void removeExportPdfDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().removeExportPdfDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void removeProcessProgressDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().removeProcessProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void removeSaveAsProgressDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().removeSaveAsProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void showCircleProgressDialog() {
                    ObjectMapper.this.showCircleProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void showExportPdfDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().showExportPdfDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void showProcessProgressDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().showProcessProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void showSaveAsProgressDialog() {
                    ObjectMapper.this.mDialogHelper.getInstance().showSaveAsProgressDialog();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void updateExportPdfDialogNoteName(String str) {
                    ObjectMapper.this.mDialogHelper.getInstance().updateExportPdfDialogNoteName(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.IPresenter
                public void updateExportPdfDialogProgress(int i, int i2) {
                    ObjectMapper.this.mDialogHelper.getInstance().updateExportPdfDialogProgress(i, i2);
                }
            });
        }
    };
    protected final ObjectBuilder<CoeditHelper> mCoeditHelper = new ObjectBuilder<CoeditHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.8
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public CoeditHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new CoeditHelper(objectMapper.mViewParams, objectMapper.mStateInfo, objectMapper.mDocumentMap, objectMapper.mNotesModel, new CoeditHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.8.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.IPresenter
                public void createUnlockConfirmDialog(Context context, int i, DialogViewContract.IUnlockConfirmDialog iUnlockConfirmDialog) {
                    ObjectMapper.this.mDialogCreator.createUnlockConfirmDialog(context, new UnlockConfirmDialogHelper(context, UnlockConfirmDialogHelper.Caller.IMPORT_NOTE, i, false), iUnlockConfirmDialog).show();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.IPresenter
                public void notifyDataSetChangedWithViewPageChange(String str) {
                    ObjectMapper.this.notifyDataSetChangedWithViewPageChange(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.IPresenter
                public void onTaskFinished() {
                    ObjectMapper.this.onTaskFinished();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.IPresenter
                public void removeCoeditInvitation(String str) {
                    ObjectMapper.this.mAdapterManager.removeCoeditInvitation(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.CoeditHelper.IPresenter
                public void verifyLockedNote(int i, Intent intent, String... strArr) {
                    ObjectMapper.this.mLockHelper.getInstance().verifyLockedNote(i, intent, strArr);
                }
            });
        }
    };
    protected final ObjectBuilder<SearchHelper> mSearchHelper = new ObjectBuilder<SearchHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public SearchHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new SearchHelper(objectMapper.mViewParams, objectMapper.mStateInfo, objectMapper.mDocumentMap, objectMapper.mNotesModel, new SearchHelperContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.9.1
                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void notifyDataSetChanged(@NotNull String str) {
                    ObjectMapper.this.mAdapterManager.notifyDataSetChanged(str);
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void notifyDataSetChangedWithViewPageChange(@NonNull String str) {
                    ObjectMapper.this.mAdapterManager.notifyDataSetChangedWithViewPageChange(str);
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void notifyItemChanged(int i, @NotNull Object obj, @NotNull String str) {
                    ObjectMapper.this.mAdapterManager.notifyItemChanged(i, obj, str);
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void notifyRecentSearchDataChanged() {
                    ObjectMapper.this.mViewParams.getNotesView().getSearchImpl().notifyRecentSearchDataChanged();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void setHighlightText(HighlightText highlightText) {
                    ObjectMapper.this.mAdapterManager.setHighlightText(highlightText);
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void updateRecentSearchContainer() {
                    ObjectMapper.this.mViewParams.getNotesView().getSearchImpl().updateRecentSearchContainer();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void updateRecentSearchVisibility(boolean z) {
                    ObjectMapper.this.mViewParams.getNotesView().getSearchImpl().updateRecentSearchVisibility(z);
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void updateRecentTagContainer() {
                    ObjectMapper.this.mViewParams.getNotesView().getSearchImpl().updateRecentTagContainer();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract
                public void updateRecentTagVisibility(boolean z) {
                    ObjectMapper.this.mViewParams.getNotesView().getSearchImpl().updateRecentTagVisibility(z);
                }
            });
        }
    };
    protected final ObjectBuilder<SOMRecognizeHelper> mSOMRecognizeHelper = new ObjectBuilder<SOMRecognizeHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.10
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public SOMRecognizeHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new SOMRecognizeHelper(objectMapper.mViewParams, objectMapper.mStateInfo, objectMapper.mDocumentMap, new SOMRecognizeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.10.1
                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeListener
                public void onSOMRecognizeStateChanged() {
                    ObjectMapper.this.mAdapterManager.onSOMRecognizeStateChanged();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeListener
                public void onSOMRecognizedCardShapeChanged() {
                    ObjectMapper.this.mAdapterManager.onSOMRecognizedCardShapeChanged();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeListener
                public void onSOMRecognizedCardVisibilityChanged() {
                    ObjectMapper.this.mAdapterManager.onSOMRecognizedCardVisibilityChanged();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeListener
                public void onSOMRecognizedInfoChanged() {
                    ObjectMapper.this.mAdapterManager.onSOMRecognizedInfoChanged();
                }
            });
        }
    };
    protected final ObjectBuilder<CoverHelper> mCoverHelper = new ObjectBuilder<CoverHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.11
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public CoverHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new CoverHelper(objectMapper.mViewParams, objectMapper.mDocumentMap, objectMapper.mStateInfo, objectMapper.mNotesModel, new CoverHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.11.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.cover.CoverHelper.IPresenter
                public CommonHolder findCommonHolder(String str) {
                    return ObjectMapper.this.mRecyclerViewHelper.getInstance().findCommonHolder(str);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.cover.CoverHelper.IPresenter
                public void notifyItemChanged(int i, @Nullable Object obj, String str) {
                    ObjectMapper.this.mAdapterManager.notifyItemChanged(i, obj, str);
                }
            });
        }
    };
    protected final ObjectBuilder<DragAndDropHelper> mDragAndDropHelper = new ObjectBuilder<DragAndDropHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.12
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public DragAndDropHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new DragAndDropHelper(objectMapper.mViewParams, objectMapper.mStateInfo, objectMapper.mNotesModel, objectMapper.mDocumentMap, new DragAndDropHelper.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.12.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void endLongPressed() {
                    ObjectMapper.this.mRecyclerViewHelper.getInstance().endLongPressed();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public boolean isLongPressMoved() {
                    return ObjectMapper.this.mRecyclerViewHelper.getInstance().isLongPressMoved();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void resumeLongPressMultiSelection() {
                    ObjectMapper.this.mRecyclerViewHelper.getInstance().resumeLongPressMultiSelection();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void showDragAndDropImage(int i, View view, int i2) {
                    ObjectMapper.this.mViewParams.getNotesView().showDragAndDropImage(i, view, i2);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void showProgressCircle(int i) {
                    ObjectMapper.this.showProgressCircle(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void stopLongPressMultiSelection() {
                    ObjectMapper.this.mRecyclerViewHelper.getInstance().stopLongPressMultiSelection();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void toggleFolderExpandCollapseState() {
                    ObjectMapper.this.mStateInfo.setExpandedFolderBar(!r0.isExpandedFolderBar());
                    ObjectMapper.this.updateFolderExpandBarHolder();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DragAndDropHelper.IPresenter
                public void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z) {
                    ObjectMapper.this.mCheckBoxAnimatorController.updateContentDescription(commonHolderInfo, z);
                }
            });
        }
    };
    protected final ObjectBuilder<BackPressedHelper> mBackPressedHelper = new ObjectBuilder<BackPressedHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.13
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public BackPressedHelper build() {
            FragmentActivity fragmentActivityRequireActivity = ObjectMapper.this.mViewParams.getAbsFragment().requireActivity();
            ObjectMapper objectMapper = ObjectMapper.this;
            return new BackPressedHelper(fragmentActivityRequireActivity, objectMapper.mViewParams, objectMapper.mStateInfo);
        }
    };
    protected final ObjectBuilder<DetailsMenuHelper> mDetailsMenuHelper = new ObjectBuilder<DetailsMenuHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.14
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public DetailsMenuHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new DetailsMenuHelper(objectMapper.mViewParams, objectMapper.mDocumentMap, objectMapper.mStateInfo);
        }
    };
    protected final ObjectBuilder<SwipeRefreshHelper> mSwipeRefreshHelper = new ObjectBuilder<SwipeRefreshHelper>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.15
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder
        public SwipeRefreshHelper build() {
            ObjectMapper objectMapper = ObjectMapper.this;
            return new SwipeRefreshHelper(objectMapper.mViewParams, objectMapper.mDocumentMap, new SwipeRefreshHelper.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper.15.1
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper.Contract
                public void addSyncProgressFailTipCard(int i) {
                    ObjectMapper.this.mTipCardHelper.getInstance().addSyncProgressFailTipCard(i);
                    ObjectMapper.this.mViewParams.getNotesView().stopSwipeRefreshLayout();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper.Contract
                public void removeSyncProgressFailTipCard(int i) {
                    ObjectMapper.this.mTipCardHelper.getInstance().removeSyncProgressFailTipCard(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SwipeRefreshHelper.Contract
                public void updateSyncProgress(@NonNull String str) {
                    ObjectMapper.this.notifyDataSetChanged(str);
                }
            });
        }
    };
    protected WorkerTaskManager.Listener mWorkerTaskManagerListener = new C839616();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.ObjectMapper$16 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C839616 implements WorkerTaskManager.Listener {
        public C839616() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEnd$0() {
            ObjectMapper.this.onTaskFinished();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTaskManager.Listener
        public void onEnd(@NonNull WorkerTask.Result result) {
            String str;
            str = "onEnd# " + result.getTag();
            String tag = result.getTag();
            tag.getClass();
            int i = 1;
            switch (tag) {
                case "ShareDialogTask":
                    MainLogger.m7254d(ObjectMapper.TAG, str);
                    return;
                case "PdfImportTask":
                    ObjectMapper.this.mPdfImportHelper.getInstance().showPdfImportTaskResultToast((PdfImportTask.Result) result);
                    break;
                case "DeleteTask":
                    ObjectMapper.this.mDialogHelper.getInstance().dismissDeleteDialog();
                    ObjectMapper.this.showDeleteErrorToast((DeleteTask.Result) result);
                    break;
                case "ShareTask":
                    ShareTask.Result result2 = (ShareTask.Result) result;
                    ObjectMapper.this.mExportHelper.getInstance().showShareTaskResultToast(result2);
                    ObjectMapper.this.mNotesModel.clearSaveExportNoteList();
                    if (result2.getIsShare()) {
                        MainLogger.m7254d(ObjectMapper.TAG, str);
                        return;
                    }
                    break;
                default:
                    MainLogger.m7259w(ObjectMapper.TAG, str);
                    break;
            }
            MainLogger.m7254d(ObjectMapper.TAG, str);
            new Handler().postDelayed(new RunnableC8412d(this, i), 0L);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTaskManager.Listener
        public void onStart(@NonNull WorkerTask<?> workerTask) {
            String str = "onStart# " + workerTask.getTag();
            if (workerTask.getTag().equals(PdfImportTask.TAG)) {
                ObjectMapper.this.mTipCardHelper.getInstance().onStartPdfImportTask((PdfImportTask) workerTask);
            }
            MainLogger.m7254d(ObjectMapper.TAG, str);
        }
    }

    public void addImportDownloadingTipCard() {
        this.mTipCardHelper.getInstance().addImportDownloadingTipCard();
    }

    public void addImportSamsungNoteTipCard() {
        this.mTipCardHelper.getInstance().addImportSamsungNoteTipCard();
    }

    public boolean canCreateNewCoeditNote() {
        return this.mCoeditHelper.getInstance().canCreateNewCoeditNote();
    }

    public void checkSOMUnRecognizedCount() {
        this.mSOMRecognizeHelper.getInstance().checkSOMUnRecognizedCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper
    public void clearCheckedData() {
        super.clearCheckedData();
        updateFolderExpandBarHolder();
    }

    public void executeSaveAsTask(String str, String str2) {
        this.mExportHelper.getInstance().executeSaveAsTask(str, str2);
    }

    public void executeShareTask(ArrayList<CheckedNoteInfo> arrayList, int i) {
        this.mExportHelper.getInstance().executeShareTask(arrayList, i);
    }

    public BackPressedHelper getBackPressedHelper() {
        return this.mBackPressedHelper.getInstance();
    }

    public CoeditHelper getCoeditHelper() {
        return this.mCoeditHelper.getInstance();
    }

    public CoverHelper getCoverHelper() {
        return this.mCoverHelper.getInstance();
    }

    public DetailsMenuHelper getDetailsMenuHelper() {
        return this.mDetailsMenuHelper.getInstance();
    }

    public DialogHelper getDialogHelper() {
        return this.mDialogHelper.getInstance();
    }

    public FloatingBottomLayout getFloatingBottomLayout() {
        return this.mRecyclerViewHelper.getInstance().getFloatingBottomLayout();
    }

    public FloatingToolbarLayout getFloatingToolbarLayout() {
        return this.mRecyclerViewHelper.getInstance().getFloatingToolbarLayout();
    }

    public LockHelper getLockHelper() {
        return this.mLockHelper.getInstance();
    }

    public PdfImportHelper getPdfImportHelper() {
        return this.mPdfImportHelper.getInstance();
    }

    public SOMRecognizeHelper getSOMRecognizeHelper() {
        return this.mSOMRecognizeHelper.getInstance();
    }

    public SearchHelper getSearchHelper() {
        return this.mSearchHelper.getInstance();
    }

    public SwipeRefreshHelper getSwipeRefreshHelper() {
        return this.mSwipeRefreshHelper.getInstance();
    }

    public TipCardHelper getTipCardHelper() {
        return this.mTipCardHelper.getInstance();
    }

    public int getTipCardHolderCount() {
        return this.mTipCardHelper.getInstance().getTipCardHolderCount();
    }

    public boolean isCollapseSubFolderActionRunning() {
        return this.mRecyclerViewHelper.getInstance().isCollapseSubFolderActionRunning();
    }

    public void loadProgressingTaskForTipCard() {
        this.mTipCardHelper.getInstance().loadConvertProgressingTipCard();
        this.mTipCardHelper.getInstance().loadImportSamsungNoteProgressingTipCard();
        this.mTipCardHelper.getInstance().loadImportPDFProgressingTipCard();
    }

    public void moveToSecureFolder(int i) {
        this.mDialogHelper.getInstance().moveToSecureFolder(this.mViewParams.getContext(), i);
    }

    public boolean onActivityResultFromLockManager(int i, int i2, Intent intent) {
        return this.mLockHelper.getInstance().onActivityResultFromLockManager(i, i2, intent);
    }

    public void onConfigurationChanged() {
        this.mRecyclerViewHelper.getInstance().onConfigurationChanged();
        this.mExportHelper.getInstance().onConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDialogHelper.getInstance().onRestoreInstanceState(bundle);
        this.mPdfImportHelper.getInstance().onRestoreInstanceState();
        this.mLockHelper.getInstance().onRestoreInstanceState(bundle);
        this.mExportHelper.getInstance().onRestoreInstanceState(bundle);
        this.mCoeditHelper.getInstance().onRestoreInstanceState(bundle);
        this.mSOMRecognizeHelper.getInstance().onRestoreInstanceState(bundle);
        this.mDetailsMenuHelper.getInstance().onRestoreInstanceState(bundle);
    }

    public boolean onRestoreProgressCircle() {
        if (checkRunningTask(LockTask.TAG)) {
            MainLogger.m7254d(TAG, "onRestoreProgressCircle : LockTask");
            return true;
        }
        if (checkRunningTask(RestoreTask.TAG)) {
            MainLogger.m7254d(TAG, "onRestoreProgressCircle : RestoreTask");
            return true;
        }
        if (checkRunningTask(ShareDialogTask.TAG)) {
            MainLogger.m7254d(TAG, "onRestoreProgressCircle : ShareDialogTask");
            WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(ShareDialogTask.TAG);
            if (runningTask instanceof ShareDialogTask) {
                this.mExportHelper.getInstance().setShareDialogTaskResultListener((ShareDialogTask) runningTask);
                return true;
            }
            MainLogger.m7259w(TAG, "onRestoreProgressCircle : ShareDialogTask, can not find share dialog running task");
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mExportHelper.isValid()) {
            this.mExportHelper.getInstance().onSaveInstanceState(bundle);
        }
        if (this.mCoeditHelper.isValid()) {
            this.mCoeditHelper.getInstance().onSaveInstanceState(bundle);
        }
        if (this.mLockHelper.isValid()) {
            this.mLockHelper.getInstance().onSaveInstanceState(bundle);
        }
        C0312d c0312d = this.mImportDocumentManager;
        if (c0312d != null) {
            c0312d.m669h();
            this.mDialogHelper.getInstance().onSaveInstanceState(bundle, this.mImportDocumentManager.f797b);
            this.mDialogHelper.getInstance().dismissSaveToDeviceDialog();
            this.mImportDocumentManager = null;
        }
        if (this.mSOMRecognizeHelper.isValid()) {
            this.mSOMRecognizeHelper.getInstance().onSaveInstanceState(bundle);
        }
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        this.mDialogHelper.getInstance().onViewChangeRestoreInstanceState(bundle);
        this.mDetailsMenuHelper.getInstance().onViewChangeRestoreInstanceState(bundle);
    }

    public void onViewChangeSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mDialogHelper.getInstance().onViewChangeSaveInstanceState(bundle);
        this.mDetailsMenuHelper.getInstance().onViewChangeSaveInstanceState(bundle);
    }

    public void onWidthChangedByDrawerMove(float f) {
        this.mRecyclerViewHelper.getInstance().onWidthChangedByDrawerMove(f);
    }

    public void openSettingsMicrosoftLogin() {
        this.mTipCardHelper.getInstance().openSettingsMicrosoftLogin();
    }

    public void recalculateCheckedData() {
        ArrayList<String> checkedFoldersUUID = this.mNotesModel.getCheckedFoldersUUID();
        ArrayList<String> checkedNotesUUID = this.mNotesModel.getCheckedNotesUUID();
        boolean zHasHolderInfo = this.mDocumentMap.hasHolderInfo(12);
        boolean z = false;
        for (String str : checkedFoldersUUID) {
            if (!this.mDocumentMap.isDisplayedFolderData(str)) {
                if (!zHasHolderInfo) {
                    this.mNotesModel.removeCheckedFolder(str);
                } else if (!this.mDocumentMap.isConcealFolderData(str)) {
                    this.mNotesModel.removeCheckedFolder(str);
                }
                z = true;
            }
        }
        if (zHasHolderInfo && z) {
            updateFolderExpandBarHolder();
        }
        HashSet<String> displayNoteUuidSet = this.mDocumentMap.getDisplayNoteUuidSet();
        for (String str2 : checkedNotesUUID) {
            if (displayNoteUuidSet.contains(str2)) {
                MainListDocumentData noteData = this.mDocumentMap.getNoteData(str2);
                if (noteData != null) {
                    this.mNotesModel.addCheckedNote(noteData);
                }
            } else {
                this.mNotesModel.removeCheckedNote(str2);
            }
        }
    }

    public void removeCircleProgressDialog() {
        this.mDialogHelper.getInstance().removeCircleProgressDialog();
    }

    public void requestImportPdf(int i, List<Uri> list) {
        if (i == -1) {
            this.mPdfImportHelper.getInstance().onImportPdf(this.mStateInfo.getFolderUuid(), getToolType(), list);
        }
        this.mNotesModel.setRequestCodeForOtherApp(-1);
    }

    public void restoreLockHelperTask() {
        this.mLockHelper.getInstance().restoreLockHelperTask();
    }

    public void runPendingShareDialogTask() {
        this.mExportHelper.getInstance().runPendingShareDialogTask();
    }

    public void selectAll(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDocumentMap.getCommonDisplayList());
        arrayList.addAll(this.mDocumentMap.getConcealList());
        this.mNotesModel.selectAll(z, arrayList);
        this.mCheckBoxAnimatorController.updateCheckBox(0, false);
        updateFolderExpandBarHolder();
    }

    public void selectAllWithoutCheckBox(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDocumentMap.getCommonDisplayList());
        arrayList.addAll(this.mDocumentMap.getConcealList());
        this.mNotesModel.selectAll(z, arrayList);
        updateFolderExpandBarHolder();
    }

    public void setFastScroller(int i) {
        this.mRecyclerViewHelper.getInstance().setFastScroller(i);
    }

    public void setLayoutManager(int i) {
        this.mRecyclerViewHelper.getInstance().setLayoutManager(i);
    }

    public void setLockNotes() {
        this.mLockHelper.getInstance().setLockNotes();
    }

    public void setUnlockNotes() {
        this.mLockHelper.getInstance().setUnlockNotes();
    }

    public void shareNoteBySavedShareType(int i, ArrayList<CheckedNoteInfo> arrayList) {
        executeShareTask(arrayList, i);
        this.mNotesModel.setSaveExportType(-1);
    }

    public void showAddFolderDialog(String str) {
        this.mDialogHelper.getInstance().showAddFolderDialog(str);
    }

    public void showChangeColorDialog(ArrayList<String> arrayList) {
        this.mDialogHelper.getInstance().showChangeColorDialog(arrayList);
    }

    public void showCircleProgressDialog() {
        showCircleProgressDialog(null);
    }

    public void showConvertConfirmDialog() {
        showConvertConfirmDialog(false);
    }

    public void showDeleteCoeditNotesDialog() {
        int checkedNotesCount = this.mNotesModel.getCheckedNotesCount();
        if (checkedNotesCount <= 0) {
            return;
        }
        this.mCoeditHelper.getInstance().setNoteDeleteProgressListener();
        this.mDialogHelper.getInstance().showCoeditDeleteNotesDialog(checkedNotesCount, this.mViewParams.getModeIndex());
    }

    public void showDeleteGcsSpaceNotesDialog(int i) {
        this.mDialogHelper.getInstance().showDeleteGcsSpaceDialog(0, C8003R.plurals.plurals_permanently_delete_n_note_erased_dialog_msg, C8003R.string.action_delete, i, 0, this.mNotesModel.getCheckNotesCountInfo().getOldNotesCount(), true, this.mViewParams.getModeIndex());
    }

    public void showFolderPickerDialog() {
        if (StorageUtils.isAvailableMemoryForNewMemo()) {
            this.mDialogHelper.getInstance().showFolderPickerDialog();
        } else {
            DialogUtils.showNotEnoughStorageDialogFragment(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getChildFragmentManager());
        }
    }

    public void showFolderRenameDialog() {
        this.mDialogHelper.getInstance().showFolderRenameDialog();
    }

    public void showSaveExportRenameDialog(Intent intent, CheckedNoteInfo checkedNoteInfo) {
        if (checkedNoteInfo == null) {
            MainLogger.m7254d(TAG, "showSaveExportRenameDialog# shareNoteInfo is null");
        } else {
            this.mExportHelper.getInstance().showSaveExportRenameDialog(intent, checkedNoteInfo, this.mNotesModel.getSaveExportType());
        }
    }

    public void showShareDialog(ArrayList<CheckedNoteInfo> arrayList, boolean z) {
        this.mExportHelper.getInstance().showExportShareTypeMenu(arrayList, z);
    }

    public void showSortByDialog() {
        this.mDialogHelper.getInstance().showSortByDialog(NotesUtils.getSortType(), NotesUtils.getOrderType());
    }

    public void showViewByPopupMenu() {
        this.mDialogHelper.getInstance().showViewByPopupMenu();
    }

    public void unlockNote(int i, Intent intent, String... strArr) {
        this.mLockHelper.getInstance().unlockNote(i, intent, strArr);
    }

    public void updateFavorite(boolean z) {
        DataManager.getInstance().updateFavorites(getCheckedNotesUUID(), z);
        onTaskFinished();
    }

    public void updateFolderExpandBarHolder() {
        this.mRecyclerViewHelper.getInstance().updateFolderExpandBarHolder();
    }

    public void updateRecyclerView() {
        this.mRecyclerViewHelper.getInstance().onConfigurationChanged();
    }

    public void updateRecyclerViewLayoutMode(Runnable runnable) {
        this.mRecyclerViewHelper.getInstance().updateRecyclerViewLayoutMode(runnable);
    }

    public void verifyLockedNote(int i, Intent intent, String... strArr) {
        this.mLockHelper.getInstance().verifyLockedNote(i, intent, strArr);
    }

    public void verifyLockedNoteWithMultiAccount(int i, Intent intent, String... strArr) {
        this.mLockHelper.getInstance().verifyLockedNoteWithMultiAccount(i, intent, strArr);
    }

    public void viewModeChanged(boolean z) {
        MainLogger.m7254d(TAG, "viewModeChanged");
        releaseInflatedView();
        this.mRecyclerViewHelper.getInstance().updateRecyclerViewLayoutMode(z);
        this.mRecyclerViewHelper.getInstance().setFastScroller(this.mDocumentMap.getCommonDisplayList().size());
    }

    public void showCircleProgressDialog(DialogInterface.OnKeyListener onKeyListener) {
        this.mDialogHelper.getInstance().showCircleProgressDialog(onKeyListener);
    }

    public void showConvertConfirmDialog(boolean z) {
        Pair<List<String>, Integer> convertTargetUuids = getConvertTargetUuids(z);
        this.mDialogHelper.getInstance().showConvertConfirmDialog((List) convertTargetUuids.first, z, DataManager.getInstance().hasConvertedOldNotes((List) convertTargetUuids.first), false, ((Integer) convertTargetUuids.second).intValue());
    }
}
