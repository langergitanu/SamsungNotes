package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAddImageHandler extends Handler {
    static final int MESSAGE_ADD_OBJECT_IMAGE = 1;
    static final int MESSAGE_ADD_SPAN_IMAGE_NEXT = 2;
    static final int MESSAGE_PRE_EXECUTE = 0;
    static final int MESSAGE_RELEASE = 3;
    private static final String TAG = Logger.createTag("TaskAddImageHandler");
    private boolean mBeginHistoryGroup;
    private List<ObjectManager.ImageData> mImageDataList;
    private ObjectManager mObjectManager;
    private Runnable mReleaseCallBack;
    private SpenObjectImage mSelectObject;
    private int mStartPageIndex;

    private void addSpanImage(Message message) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object obj = message.obj;
        if (obj instanceof Integer) {
            atomicInteger.set(((Integer) obj).intValue());
        }
        String str = TAG;
        Logger.m11003i(str, "addSpanImage# MESSAGE_ADD_SPAN_IMAGE_NEXT# index - " + atomicInteger.get());
        if (this.mImageDataList.isEmpty() || this.mImageDataList.size() <= atomicInteger.get()) {
            sendMessage(obtainMessage(3));
            return;
        }
        String path = this.mImageDataList.get(atomicInteger.get()).getPath();
        if (!FileUtils.isFileExists(path)) {
            Logger.m11000e(str, "addSpanImage# The path is not exists. " + Logger.getEncode(path));
            sendMessageNext(atomicInteger.get());
            return;
        }
        if (!this.mObjectManager.getNote().isGroupingHistory()) {
            this.mObjectManager.getNote().beginHistoryGroup();
            this.mBeginHistoryGroup = true;
        }
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        spenObjectImage.setImage(path);
        ObjectManager objectManager = this.mObjectManager;
        ArrayList arrayList = new ArrayList(1);
        Object obj2 = new Object[]{spenObjectImage}[0];
        objectManager.insertImage(new ArrayList<>(AbstractC2322a.m1630t(obj2, arrayList, obj2, arrayList)), this.mStartPageIndex);
        if (this.mImageDataList.get(atomicInteger.get()).isAIImage()) {
            this.mObjectManager.addGenerativeEditExtraData(spenObjectImage);
        }
        if (!this.mObjectManager.isHwMode() || this.mSelectObject == null) {
            this.mSelectObject = spenObjectImage;
        }
        sendMessageNext(atomicInteger.get());
    }

    private String messageToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? AbstractC0000a.m11h(i, "message: ") : "MESSAGE_RELEASE" : "MESSAGE_ADD_SPAN_IMAGE_NEXT" : "MESSAGE_ADD_OBJECT_IMAGE" : "MESSAGE_PRE_EXECUTE";
    }

    private void sendMessageNext(int i) {
        sendMessage(obtainMessage(2, Integer.valueOf(i + 1)));
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        Logger.m11003i(TAG, "handleMessage, what: " + messageToString(message.what));
        int i = message.what;
        if (i == 0) {
            if (!this.mObjectManager.isObjectSpanOptionEnabled()) {
                sendMessage(obtainMessage(1));
                return;
            }
            if (this.mObjectManager.isHwMode()) {
                Collections.reverse(this.mImageDataList);
            }
            sendMessage(obtainMessage(2, 0));
            return;
        }
        if (i == 1) {
            this.mObjectManager.addImage(this.mStartPageIndex, this.mImageDataList);
            sendMessage(obtainMessage(3));
        } else if (i == 2) {
            addSpanImage(message);
        } else {
            if (i != 3) {
                return;
            }
            release();
        }
    }

    public void init(ObjectManager objectManager, int i, List<ObjectManager.ImageData> list, Runnable runnable) {
        this.mObjectManager = objectManager;
        this.mStartPageIndex = i;
        this.mImageDataList = new ArrayList(list);
        this.mReleaseCallBack = runnable;
    }

    public void release() {
        ObjectManager objectManager;
        ObjectManager objectManager2;
        Logger.m11003i(TAG, "release#");
        removeCallbacksAndMessages(null);
        if (this.mBeginHistoryGroup && (objectManager2 = this.mObjectManager) != null) {
            objectManager2.getNote().endHistoryGroup();
            this.mBeginHistoryGroup = false;
        }
        if (this.mSelectObject != null && (objectManager = this.mObjectManager) != null) {
            objectManager.getNote().selectObject(this.mSelectObject);
            this.mSelectObject = null;
        }
        Runnable runnable = this.mReleaseCallBack;
        if (runnable != null) {
            runnable.run();
            this.mReleaseCallBack = null;
        }
    }
}
