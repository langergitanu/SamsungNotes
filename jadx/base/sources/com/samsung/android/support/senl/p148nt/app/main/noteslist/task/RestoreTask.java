package com.samsung.android.support.senl.p148nt.app.main.noteslist.task;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.handler.InternalImportHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f24\u00120\u0012.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ>\u0010\f\u001a\u00020\r24\u0010\u000e\u001a0\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0018\u00010\u0002H\u0016J\u001e\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Landroid/util/Pair;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "result", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreTask$Result;", "execute", "", "taskParams", "restoreCoeditNotes", "coeditList", "", "restoredCoeditNoteCount", "", "restoreFolder", "", "context", "Landroid/content/Context;", "uuids", "onPostExecute", "showToast", "msgRes", "getTag", "getResult", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RestoreTask extends WorkerTask<Pair<ArrayList<String>, ArrayList<String>>> {

    @NotNull
    public static final String TAG = "RestoreTask";

    @NotNull
    private final Activity activity;

    @NotNull
    private final Result result;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0005R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0005¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/task/RestoreTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "mRestoredNotesCount", "mRestoredFoldersCount", "tag", "", "getTag", "()Ljava/lang/String;", "restoredCount", "getRestoredCount", "value", "restoredNotesCount", "getRestoredNotesCount", "setRestoredNotesCount", "restoredFoldersCount", "getRestoredFoldersCount", "setRestoredFoldersCount", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private final int hashCode;
        private int mRestoredFoldersCount;
        private int mRestoredNotesCount;

        public Result(int i) {
            this.hashCode = i;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        public final int getRestoredCount() {
            return getMRestoredFoldersCount() + getMRestoredNotesCount();
        }

        /* JADX INFO: renamed from: getRestoredFoldersCount, reason: from getter */
        public final int getMRestoredFoldersCount() {
            return this.mRestoredFoldersCount;
        }

        /* JADX INFO: renamed from: getRestoredNotesCount, reason: from getter */
        public final int getMRestoredNotesCount() {
            return this.mRestoredNotesCount;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return RestoreTask.TAG;
        }

        public final void setRestoredFoldersCount(int i) {
            this.mRestoredFoldersCount = i;
        }

        public final void setRestoredNotesCount(int i) {
            this.mRestoredNotesCount = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RestoreTask(@NotNull Activity activity) {
        super(activity.hashCode(), null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.result = new Result(getHashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer execute$lambda$0(Context context, ArrayList arrayList, List list, Collection collection, RestoreTask restoreTask, int[] iArr, ArrayList arrayList2) {
        Intrinsics.checkNotNull(context);
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = (String) next;
            if (UUIDUtils.isCoeditUuid(str)) {
                list.add(str);
            } else {
                collection.add(str);
            }
        }
        if (!list.isEmpty()) {
            restoreTask.restoreCoeditNotes(list, iArr);
        }
        notesDocumentRepositoryCreateDocumentDataRepository.restoreByUuids(collection, TimeManager.INSTANCE.getCurrentTime(context));
        Intrinsics.checkNotNull(arrayList2);
        return Integer.valueOf(restoreTask.restoreFolder(context, arrayList2));
    }

    private final void restoreCoeditNotes(List<String> coeditList, int[] restoredCoeditNoteCount) {
        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
            MainLogger.m7258i(TAG, "restoreCoeditNotes fail - network is not connected");
            showToast(C8003R.string.co_edit_connect_to_wifi_or_allow_mobile_data);
            return;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            MainLogger.m7258i(TAG, "restoreCoeditNotes fail - samsung account is not logged in");
            showToast(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.need_login_first_jpn : C8003R.string.need_login_first);
        }
        new InternalImportHandler().restoreNoteToCoedit(coeditList);
        restoredCoeditNoteCount[0] = coeditList.size();
    }

    private final int restoreFolder(Context context, ArrayList<String> uuids) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = uuids.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = next;
            if (isCancelled()) {
                break;
            }
            String strRestore = FolderManager.getInstance().restore(str);
            if (strRestore != null && strRestore.length() != 0) {
                hashSet.add(strRestore);
                i++;
            }
        }
        if (context != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long currentTime = TimeManager.INSTANCE.getCurrentTime(context);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            hashSet.addAll(notesDocumentRepositoryCreateDocumentDataRepository.getCategoryUuids(uuids));
            FolderManager.getInstance().updateFolderModifiedTime(hashSet, jCurrentTimeMillis);
            FolderManager.getInstance().updateFolderServerTimestampUpward(hashSet, currentTime);
        }
        return i;
    }

    private final void showToast(@StringRes int msgRes) {
        this.activity.runOnUiThread(new RunnableC0050f(this, msgRes, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$1(RestoreTask restoreTask, int i) {
        ToastHandler.show(restoreTask.activity, i, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPostExecute() {
        super.onPostExecute();
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Pair<ArrayList<String>, ArrayList<String>> taskParams) {
        if (taskParams == null) {
            MainLogger.m7255e(TAG, "execute# ignored task params is null.");
            return;
        }
        MainLogger.m7258i(TAG, "execute# start");
        final Context applicationContext = BaseUtils.getApplicationContext();
        TaskState.Companion companion = TaskState.INSTANCE;
        companion.getInstance().setIsRunning("RESTORE_DATA", true);
        final ArrayList arrayList = new ArrayList();
        final int[] iArr = {0};
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = (ArrayList) taskParams.first;
        final ArrayList arrayList4 = (ArrayList) taskParams.second;
        Integer num = (Integer) FolderManager.getInstance().executeOperation(new Callable() { // from class: O2.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RestoreTask.execute$lambda$0(applicationContext, arrayList3, arrayList, arrayList2, this, iArr, arrayList4);
            }
        });
        companion.getInstance().setIsRunning("RESTORE_DATA", false);
        MainLogger.m7258i(TAG, "execute# end");
        int size = arrayList2.size() + iArr[0];
        DataUpdateManager.INSTANCE.getInstance().onDataUpdated(3);
        this.result.setRestoredNotesCount(size);
        Result result = this.result;
        Intrinsics.checkNotNull(num);
        result.setRestoredFoldersCount(num.intValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult, reason: from getter */
    public Result getTaskResult() {
        return this.result;
    }
}
