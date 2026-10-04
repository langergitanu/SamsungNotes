package com.samsung.android.support.notes.bixby.bixby2.action;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.notes.bixby.bixby2.aid.AppContextResult;
import com.samsung.android.support.notes.bixby.bixby2.aid.AppContextValue;
import com.samsung.android.support.notes.bixby.bixby2.aid.ComposerValue;
import com.samsung.android.support.notes.bixby.bixby2.aid.Concepts;
import com.samsung.android.support.notes.bixby.bixby2.aid.LlmContext;
import com.samsung.android.support.notes.bixby.bixby2.aid.MainListValue;
import com.samsung.android.support.notes.bixby.bixby2.aid.NoteInfo;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyAppContext;", "", "<init>", "()V", "makeAppContext", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextResult;", "mNoteFragment", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteFragmentBixby2;", "openedNoteInfo", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/NoteInfo;", "getOpenedNoteInfo", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/NoteInfo;", "resultScreenInfo", "", "getResultScreenInfo", "()Ljava/lang/String;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyAppContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "BixbyAppContext";

    @Nullable
    private static BixbyAppContext mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyAppContext$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyAppContext;", "getMInstance$annotations", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyAppContext;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getMInstance$annotations() {
        }

        @Nullable
        public final synchronized BixbyAppContext getInstance() {
            try {
                if (BixbyAppContext.mInstance == null) {
                    BixbyAppContext.mInstance = new BixbyAppContext();
                }
            } catch (Throwable th) {
                throw th;
            }
            return BixbyAppContext.mInstance;
        }

        private Companion() {
        }
    }

    public BixbyAppContext() {
        Logger.m8697d(TAG, TAG);
    }

    @Nullable
    public static final synchronized BixbyAppContext getInstance() {
        return INSTANCE.getInstance();
    }

    private final NoteInfo getOpenedNoteInfo() {
        CharSequence content;
        NoteInfo noteInfo = new NoteInfo();
        ComposerManager.Companion companion = ComposerManager.INSTANCE;
        if (!companion.getInstance().isRunningComposer() || BaseUtils.getApplicationContext() == null) {
            Logger.m8697d(TAG, "getOpenedNoteInfo# composer is not running!!");
            return noteInfo;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(companion.getInstance().getLatestComposerUuid());
        if (notesDocumentEntity == null) {
            Logger.m8697d(TAG, "getOpenedNoteInfo# entity is null!!");
            return noteInfo;
        }
        byte[] displayContent = notesDocumentEntity.getDisplayContent();
        CharSequence charSequence = "";
        if (displayContent != null) {
            try {
                DisplayData displayData = (DisplayData) DisplayDataHelper.unmarshall(displayContent, DisplayData.CREATOR);
                content = displayData != null ? displayData.getContent() : null;
            } catch (Exception e) {
                AbstractC4539a.m3214x("getOpenedNoteInfo# DisplayData e : ", e.getMessage(), TAG);
                content = "";
            }
            if (content != null) {
                charSequence = content;
            }
        }
        NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(notesDocumentEntity.getCategoryUuid(), false);
        Intrinsics.checkNotNullExpressionValue(notesFolder, "getNotesFolder(...)");
        String displayName = notesFolder.getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
        String uuid = notesDocumentEntity.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        noteInfo.setNoteID(uuid);
        String title = notesDocumentEntity.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        noteInfo.setNoteTitle(title);
        noteInfo.setContent(String.valueOf(charSequence));
        noteInfo.setFavorite(notesDocumentEntity.getIsFavorite() == 1);
        noteInfo.setLocked(notesDocumentEntity.getIsLock() == 5 || LockUtils.isLockedSdocType(notesDocumentEntity.getIsLock()));
        noteInfo.setCategory(displayName);
        return noteInfo;
    }

    private final String getResultScreenInfo() {
        Integer currentScreen = ComposerManager.INSTANCE.getInstance().getCurrentScreen();
        return (currentScreen != null && currentScreen.intValue() == 90011) ? Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT : (currentScreen != null && currentScreen.intValue() == 90012) ? Bixby2Constants.BIXBY_ACTION_CHANGE_NOTE_PAGE_FORMAT : (currentScreen != null && currentScreen.intValue() == 9002) ? Bixby2Constants.BIXBY_ACTION_SUMMARIZE_NOTE_PAGE : (currentScreen != null && currentScreen.intValue() == 9003) ? Bixby2Constants.BIXBY_ACTION_CORRECT_SPELLING_NOTE_PAGE : (currentScreen != null && currentScreen.intValue() == 9004) ? Bixby2Constants.BIXBY_ACTION_TRANSLATE_NOTE_PAGE : (currentScreen != null && currentScreen.intValue() == 9005) ? Bixby2Constants.BIXBY_ACTION_CHANGE_SPEECH_TO_TEXT : "none";
    }

    @NotNull
    public final AppContextResult makeAppContext(@Nullable INoteFragmentBixby2 mNoteFragment) {
        AppContextResult appContextResult = new AppContextResult();
        ComposerValue composerValue = new ComposerValue();
        if (mNoteFragment == null) {
            Logger.m8697d(TAG, "makeAppContext# mNoteFragment is null!!");
        } else if (mNoteFragment.isPdfWriterActivityResumed()) {
            Logger.m8697d(TAG, "makeAppContext# PdfWriterActivity resumed!!");
        }
        boolean zIsFocusOnComposer = ComposerManager.INSTANCE.getInstance().isFocusOnComposer();
        String resultScreenInfo = getResultScreenInfo();
        composerValue.setFocusOnNotePage(zIsFocusOnComposer);
        composerValue.setSupportS24Feature(Features.isSupportAiFunction());
        composerValue.setResultScreenInfo(resultScreenInfo);
        Logger.m8697d(TAG, "makeAppContext# " + zIsFocusOnComposer + SQLKeyword.COMMA + resultScreenInfo);
        ArrayList<NoteInfo> arrayList = new ArrayList<>();
        arrayList.add(getOpenedNoteInfo());
        composerValue.setNoteInfo(arrayList);
        ArrayList<AppContextValue> arrayList2 = new ArrayList<>();
        arrayList2.add(composerValue);
        Concepts concepts = new Concepts();
        concepts.setValues(arrayList2);
        concepts.setType(Bixby2Constants.BixbyActions.ACTION_APP_CONTEXT_RESULT);
        ArrayList<Concepts> arrayList3 = new ArrayList<>();
        arrayList3.add(concepts);
        appContextResult.setConcepts(arrayList3);
        LlmContext llmContext = new LlmContext();
        if (zIsFocusOnComposer) {
            llmContext.setType(Bixby2Constants.BIXBY_TYPE_COMPOSER_INFO);
            llmContext.setValue(composerValue);
        } else {
            llmContext.setType(Bixby2Constants.BIXBY_TYPE_MAIN_LIST_INFO);
            MainListValue mainListValue = new MainListValue();
            if (mNoteFragment != null) {
                Logger.m8697d(TAG, "makeAppContext# mNoteFragment is not null!!");
                mainListValue = mNoteFragment.getNoteListInfo();
            }
            llmContext.setValue(mainListValue);
        }
        ArrayList<LlmContext> arrayList4 = new ArrayList<>();
        arrayList4.add(llmContext);
        appContextResult.setLlmContext(arrayList4);
        appContextResult.setLlmCapsuleId(Bixby2Constants.BIXBY_LLM_CAPSULE_ID);
        return appContextResult;
    }
}
