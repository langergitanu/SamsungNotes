package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDelete extends SingleThreadTask<InputValues, ResultValues> {
    private static final int DELETE_OBJECT_SIZE = 500;
    private static final String TAG = Logger.createTag("TaskDelete");
    private DeleteHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeleteHandler extends Handler {
        static final int MESSAGE_DELETE_EXECUTE = 2;
        static final int MESSAGE_POST_EXECUTE = 3;
        static final int MESSAGE_PRE_EXECUTE = 1;
        private static final String TAG = Logger.createTag("DeleteHandler");
        private Task.Callback<ResultValues> mCallback;
        private List<SpenObjectBase> mDeleteObjectList;
        private List<SpenWPage> mDeletePageList;
        private DynamicTemplateController mDynamicTemplateController;
        private ObjectManager mObjectManager;
        private int mStartObjectIndex = 0;
        private int mObjectCount = 0;

        public DeleteHandler(ObjectManager objectManager, DynamicTemplateController dynamicTemplateController, List<SpenObjectBase> list, List<SpenWPage> list2, Task.Callback<ResultValues> callback) {
            this.mObjectManager = objectManager;
            this.mDynamicTemplateController = dynamicTemplateController;
            this.mCallback = callback;
            this.mDeleteObjectList = new ArrayList(list);
            if (list2 == null) {
                this.mDeletePageList = new ArrayList(0);
            } else {
                this.mDeletePageList = new ArrayList(list2);
            }
        }

        private void deleteObjectListForFixedPage(int i) {
            HashMap map = new HashMap();
            for (int i2 = this.mStartObjectIndex; i2 < i; i2++) {
                SpenWPage spenWPage = this.mDeletePageList.get(i2);
                ArrayList arrayList = (ArrayList) map.get(spenWPage);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(spenWPage, arrayList);
                }
                arrayList.add(this.mDeleteObjectList.get(i2));
            }
            for (Map.Entry entry : map.entrySet()) {
                ArrayList<SpenObjectBase> arrayList2 = (ArrayList) entry.getValue();
                List<SpenObjectBase> dynamicTemplateObjectBaseList = getDynamicTemplateObjectBaseList(arrayList2);
                if (!dynamicTemplateObjectBaseList.isEmpty()) {
                    arrayList2.removeAll(dynamicTemplateObjectBaseList);
                    this.mDynamicTemplateController.deleteObjectList((SpenWPage) entry.getKey(), dynamicTemplateObjectBaseList);
                }
                this.mObjectManager.deleteObjectList((SpenWPage) entry.getKey(), (ArrayList) entry.getValue(), false);
            }
        }

        private void deleteObjectListForSinglePage(int i) {
            this.mObjectManager.deleteObjectList(this.mDeletePageList.get(this.mStartObjectIndex), new ArrayList<>(this.mDeleteObjectList.subList(this.mStartObjectIndex, i)), false);
        }

        private List<SpenObjectBase> getDynamicTemplateObjectBaseList(ArrayList<SpenObjectBase> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            for (SpenObjectBase spenObjectBase : arrayList) {
                if (DynamicTemplateUtil.isDynamicTemplateObject(spenObjectBase)) {
                    arrayList2.add(spenObjectBase);
                }
            }
            return arrayList2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            String str = TAG;
            AbstractC8014b.m7195A(new StringBuilder("DeleteHandler#handleMessage, what: "), str, message.what);
            int i = message.what;
            if (i == 1) {
                this.mStartObjectIndex = 0;
                this.mObjectCount = this.mDeleteObjectList.size();
                if (!this.mObjectManager.getSelectedObjectManager().isSelectedTable()) {
                    this.mObjectManager.clearSelectObject();
                }
                sendMessage(obtainMessage(2));
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                if (this.mObjectManager.getSelectedObjectManager().isSelectedTable()) {
                    this.mObjectManager.clearSelectObject();
                }
                release();
                return;
            }
            Logger.m11003i(str, "DeleteHandler#handleMessage, MESSAGE_DELETE_EXECUTE# index:" + this.mStartObjectIndex + ", count:" + this.mObjectCount + ", mDeleteObjectList:" + this.mDeleteObjectList.size() + ", mDeletePageList:" + this.mDeletePageList.size());
            if (this.mDeleteObjectList.isEmpty() || this.mDeletePageList.isEmpty()) {
                if (this.mDeleteObjectList.size() == 1) {
                    SpenObjectBase spenObjectBase = this.mDeleteObjectList.get(0);
                    if (spenObjectBase instanceof SpenObjectTable) {
                        SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase;
                        if (!this.mObjectManager.deleteCellDataInTable(spenObjectTable)) {
                            this.mObjectManager.getTableManager().deleteTable(spenObjectTable);
                        }
                    }
                }
                sendMessage(obtainMessage(3));
                return;
            }
            int i2 = this.mObjectCount;
            if (i2 > 500) {
                sendMessage(obtainMessage(2));
                i2 = 500;
            } else {
                sendMessage(obtainMessage(3));
            }
            int i4 = this.mStartObjectIndex + i2;
            if (this.mObjectManager.getNote().getPageMode() == SpenWNote.PageMode.SINGLE) {
                deleteObjectListForSinglePage(i4);
            } else {
                deleteObjectListForFixedPage(i4);
            }
            this.mStartObjectIndex += i2;
            this.mObjectCount -= i2;
        }

        public void release() {
            Logger.m10999d(TAG, "DeleteHandler#release");
            removeCallbacksAndMessages(null);
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(new ResultValues());
                this.mCallback = null;
            }
            ObjectManager objectManager = this.mObjectManager;
            if (objectManager != null) {
                objectManager.commitHistory();
                this.mObjectManager = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private List<SpenObjectBase> mDeleteObjectList;
        private List<SpenWPage> mDeletePageList;
        private DynamicTemplateController mDynamicTemplateController;
        private ObjectManager mObjectManager;

        public InputValues(ObjectManager objectManager, DynamicTemplateController dynamicTemplateController, List<SpenObjectBase> list, List<SpenWPage> list2) {
            this.mObjectManager = objectManager;
            this.mDynamicTemplateController = dynamicTemplateController;
            this.mDeleteObjectList = list;
            this.mDeletePageList = list2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        DeleteHandler deleteHandler = this.mHandler;
        if (deleteHandler != null) {
            deleteHandler.release();
            this.mHandler = null;
        }
        super.clear();
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDelete.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                Logger.m11000e(TaskDelete.TAG, "Delete fail#");
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToUpdate() {
        return (this.mHandler.hasMessages(1) || this.mHandler.hasMessages(2) || this.mHandler.hasMessages(3)) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        DeleteHandler deleteHandler = new DeleteHandler(inputValues.mObjectManager, inputValues.mDynamicTemplateController, inputValues.mDeleteObjectList, inputValues.mDeletePageList, getTaskCallback());
        this.mHandler = deleteHandler;
        deleteHandler.sendMessage(deleteHandler.obtainMessage(1));
    }
}
