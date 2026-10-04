package com.samsung.android.support.senl.docscan.rectify.presenter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 C2\u00020\u0001:\u0003ABCB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0010J,\u0010'\u001a\u00020\u001b2\u0018\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010#J\u0012\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020 J$\u00101\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u00103\u001a\u00020\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0010J\u001a\u00105\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010;\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010+\u001a\u00020#H\u0002J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020#088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0013R\u0014\u0010?\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter;", "Lkotlinx/coroutines/CoroutineScope;", "mContract", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$Contract;", "<init>", "(Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$Contract;)V", "mRectifiedImageMap", "", "", "Landroid/graphics/Bitmap;", "mThumbnailImageMap", "mScanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "mUpdateRectifyImageTaskMap", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask;", "value", "", "currentPosition", "getCurrentPosition", "()I", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setScanDataModel", "", "scanDataModel", "setCurrentPosition", "position", "isPagerScroll", "", "isForceAnimation", "getDocScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "removeDocScanData", "getRectifiedImage", "clearRectifiedImage", "removeBitmapFromDataSet", "bitmapImageMap", DBSchema.DocumentThumbnail.IMAGE_PATH, "updateDocScanData", "docScanData", "getIndexFromSavePath", "savePath", "updateRectifiedImage", "updatePosition", "isBackground", "replaceRectifiedImageData", "bitmap", "loadThumbnailImage", "getThumbnailImage", "updateThumbnailImage", "thumbnailPath", "scanDataList", "", "getScanDataList", "()Ljava/util/List;", "setScanData", "removeScanData", "scanDataCount", "getScanDataCount", "isScanDataEmpty", "()Z", "Contract", "LoadImageBitmapTask", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRectifyListPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RectifyListPresenter.kt\ncom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,325:1\n1#2:326\n*E\n"})
public final class RectifyListPresenter implements CoroutineScope {

    @NotNull
    private static final String TAG = "RectifyListPresenter";
    private int currentPosition;

    @NotNull
    private CompletableJob job;

    @NotNull
    private final Contract mContract;

    @NotNull
    private final Map<String, Bitmap> mRectifiedImageMap;

    @Nullable
    private ScanDataModel mScanDataModel;

    @NotNull
    private final Map<String, Bitmap> mThumbnailImageMap;

    @Nullable
    private Map<String, LoadImageBitmapTask> mUpdateRectifyImageTaskMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0003H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$Contract;", "", "finishFragment", "", "notifyPageUpdated", "position", "", "notifyPageRemoved", "notifyThumbnailUpdated", "notifyThumbnailRemoved", "notifyThumbnailDataChanged", "notifyCurrentPositionChanged", "prevPosition", "isPagerScroll", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void finishFragment();

        void notifyCurrentPositionChanged(int position, int prevPosition, boolean isPagerScroll);

        void notifyPageRemoved();

        void notifyPageUpdated(int position);

        void notifyThumbnailDataChanged();

        void notifyThumbnailRemoved(int position);

        void notifyThumbnailUpdated(int position);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter$clearRectifiedImage$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter$clearRectifiedImage$1", m14021f = "RectifyListPresenter.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C79861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imagePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79861(String str, Continuation<? super C79861> continuation) {
            super(2, continuation);
            this.$imagePath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RectifyListPresenter.this.new C79861(this.$imagePath, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Map map = RectifyListPresenter.this.mUpdateRectifyImageTaskMap;
            Intrinsics.checkNotNull(map);
            map.get(this.$imagePath);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C79861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public RectifyListPresenter(@NotNull Contract mContract) {
        Intrinsics.checkNotNullParameter(mContract, "mContract");
        this.mContract = mContract;
        this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.mRectifiedImageMap = new LinkedHashMap();
        this.mThumbnailImageMap = new LinkedHashMap();
    }

    private final int getIndexFromSavePath(String savePath) {
        if (TextUtils.isEmpty(savePath)) {
            return -1;
        }
        List<DocScanData> scanDataList = getScanDataList();
        int size = scanDataList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(savePath, scanDataList.get(i).getPathToSave())) {
                return i;
            }
        }
        return -1;
    }

    private final int getScanDataCount() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return 0;
        }
        Intrinsics.checkNotNull(scanDataModel);
        return scanDataModel.getScanDataCount();
    }

    private final List<DocScanData> getScanDataList() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(scanDataModel);
        return scanDataModel.getScanDataList();
    }

    private final boolean isScanDataEmpty() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return false;
        }
        Intrinsics.checkNotNull(scanDataModel);
        return scanDataModel.isScanDataEmpty();
    }

    private final void removeBitmapFromDataSet(Map<String, Bitmap> bitmapImageMap, String imagePath) {
        Bitmap bitmap;
        if (bitmapImageMap == null || (bitmap = bitmapImageMap.get(imagePath)) == null) {
            return;
        }
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        bitmapImageMap.remove(imagePath);
    }

    private final void removeScanData(DocScanData docScanData) {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return;
        }
        Intrinsics.checkNotNull(scanDataModel);
        scanDataModel.removeScanData(docScanData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceRectifiedImageData(int updatePosition, String imagePath, Bitmap bitmap) {
        this.mRectifiedImageMap.remove(imagePath);
        this.mRectifiedImageMap.put(imagePath, bitmap);
        this.mContract.notifyPageUpdated(updatePosition);
    }

    private final void setScanData(int position, DocScanData docScanData) {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return;
        }
        Intrinsics.checkNotNull(scanDataModel);
        scanDataModel.setScanData(position, docScanData);
    }

    private final void updateThumbnailImage(int position, String thumbnailPath) {
        this.mThumbnailImageMap.remove(thumbnailPath);
        this.mThumbnailImageMap.put(thumbnailPath, DocScanUtils.getBitmapImageFromPath(thumbnailPath));
        this.mContract.notifyThumbnailUpdated(position);
    }

    public final void clearRectifiedImage(int position) {
        DocScanData docScanData = getDocScanData(position);
        if (docScanData == null) {
            return;
        }
        String pathToSave = docScanData.getPathToSave();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C79861(pathToSave, null), 3, null);
        Job.DefaultImpls.cancel$default((Job) this.job, (CancellationException) null, 1, (Object) null);
        Map<String, LoadImageBitmapTask> map = this.mUpdateRectifyImageTaskMap;
        Intrinsics.checkNotNull(map);
        map.remove(pathToSave);
        removeBitmapFromDataSet(this.mRectifiedImageMap, pathToSave);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.job.plus(Dispatchers.getIO());
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    @Nullable
    public final DocScanData getDocScanData(int position) {
        List<DocScanData> scanDataList = getScanDataList();
        if (position < 0 || position >= scanDataList.size()) {
            return null;
        }
        return scanDataList.get(position);
    }

    @Nullable
    public final Bitmap getRectifiedImage(int position) {
        DocScanData docScanData = getDocScanData(position);
        if (docScanData == null) {
            return null;
        }
        return this.mRectifiedImageMap.get(docScanData.getPathToSave());
    }

    @Nullable
    public final Bitmap getThumbnailImage(int position) {
        DocScanData docScanData = getDocScanData(position);
        if (docScanData == null) {
            return null;
        }
        return this.mThumbnailImageMap.get(docScanData.getThumbnailPath());
    }

    public final void loadThumbnailImage() {
        List<DocScanData> scanDataList = getScanDataList();
        if (scanDataList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DocScanData> it = scanDataList.iterator();
        while (it.hasNext()) {
            String thumbnailPath = it.next().getThumbnailPath();
            if (thumbnailPath != null) {
                arrayList.add(thumbnailPath);
            }
        }
        new LoadImageBitmapTask(new LoadImageBitmapTask.PostRunnable() { // from class: com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.loadThumbnailImage.2
            @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.LoadImageBitmapTask.PostRunnable
            public void run() {
                if (getMImageDataMap() == null) {
                    return;
                }
                Map<String, Bitmap> mImageDataMap = getMImageDataMap();
                Intrinsics.checkNotNull(mImageDataMap);
                for (Map.Entry<String, Bitmap> entry : mImageDataMap.entrySet()) {
                    String key = entry.getKey();
                    Bitmap value = entry.getValue();
                    RectifyListPresenter.this.mThumbnailImageMap.remove(key);
                    RectifyListPresenter.this.mThumbnailImageMap.put(key, value);
                }
                RectifyListPresenter.this.mContract.notifyThumbnailDataChanged();
            }
        }).execute(arrayList);
    }

    public final void removeDocScanData(int position) {
        DocScanData docScanData = getDocScanData(position);
        if (docScanData != null) {
            removeBitmapFromDataSet(this.mRectifiedImageMap, docScanData.getPathToSave());
            removeBitmapFromDataSet(this.mThumbnailImageMap, docScanData.getThumbnailPath());
            removeScanData(docScanData);
            FileUtils.deleteFile$default(String.valueOf(docScanData.getPathToSave()), false, 2, null);
            FileUtils.deleteFile$default(String.valueOf(docScanData.getEditingPath()), false, 2, null);
            FileUtils.deleteFile$default(String.valueOf(docScanData.getThumbnailPath()), false, 2, null);
        }
        if (isScanDataEmpty()) {
            this.mContract.finishFragment();
        } else {
            this.mContract.notifyPageRemoved();
            this.mContract.notifyThumbnailRemoved(position);
        }
    }

    public final void setCurrentPosition(int position, boolean isPagerScroll) {
        setCurrentPosition(position, isPagerScroll, false);
    }

    public final void setScanDataModel(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }

    public final void updateDocScanData(@Nullable DocScanData docScanData) {
        if (docScanData == null) {
            return;
        }
        int indexFromSavePath = getIndexFromSavePath(docScanData.getPathToSave());
        if (indexFromSavePath >= 0) {
            setScanData(indexFromSavePath, docScanData);
            updateRectifiedImage(indexFromSavePath, false);
            updateThumbnailImage(indexFromSavePath, docScanData.getThumbnailPath());
        } else {
            String pathToSave = docScanData.getPathToSave();
            Intrinsics.checkNotNull(pathToSave);
            Logger.m7146e(TAG, "updateDocScanData# can not find " + Logger.getEncode(pathToSave));
        }
    }

    public final void updateRectifiedImage(final int updatePosition, boolean isBackground) {
        final String pathToSave = getScanDataList().get(updatePosition).getPathToSave();
        List listListOf = CollectionsKt.listOf(pathToSave);
        Intrinsics.checkNotNull(listListOf, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
        List<String> listAsMutableList = TypeIntrinsics.asMutableList(listListOf);
        if (!isBackground) {
            replaceRectifiedImageData(updatePosition, pathToSave, DocScanUtils.getBitmapImageFromPath(pathToSave));
            return;
        }
        if (this.mUpdateRectifyImageTaskMap == null) {
            this.mUpdateRectifyImageTaskMap = new LinkedHashMap();
        }
        Map<String, LoadImageBitmapTask> map = this.mUpdateRectifyImageTaskMap;
        Intrinsics.checkNotNull(map);
        if (map.containsKey(pathToSave)) {
            return;
        }
        LoadImageBitmapTask loadImageBitmapTask = new LoadImageBitmapTask(1, new LoadImageBitmapTask.PostRunnable() { // from class: com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter$updateRectifiedImage$task$1
            @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.LoadImageBitmapTask.PostRunnable
            public void run() {
                RectifyListPresenter rectifyListPresenter = this.this$0;
                int i = updatePosition;
                String str = pathToSave;
                Map<String, Bitmap> mImageDataMap = getMImageDataMap();
                Intrinsics.checkNotNull(mImageDataMap);
                rectifyListPresenter.replaceRectifiedImageData(i, str, mImageDataMap.get(pathToSave));
                Map map2 = this.this$0.mUpdateRectifyImageTaskMap;
                Intrinsics.checkNotNull(map2);
                map2.remove(pathToSave);
            }
        });
        loadImageBitmapTask.execute(listAsMutableList);
        Map<String, LoadImageBitmapTask> map2 = this.mUpdateRectifyImageTaskMap;
        Intrinsics.checkNotNull(map2);
        map2.put(pathToSave, loadImageBitmapTask);
    }

    public final void setCurrentPosition(int position, boolean isPagerScroll, boolean isForceAnimation) {
        if (position < 0 || getScanDataCount() <= position) {
            return;
        }
        int i = this.currentPosition;
        if (isForceAnimation || i != position) {
            this.currentPosition = position;
            this.mContract.notifyCurrentPositionChanged(position, i, isPagerScroll);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0013\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\bJ+\u0010\u0011\u001a\u00020\u00122\u001e\u0010\u0013\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\"\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u001e\u0010\u0013\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\"\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask;", "Lkotlinx/coroutines/CoroutineScope;", "postRunnable", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask$PostRunnable;", "<init>", "(Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask$PostRunnable;)V", "sampleSize", "", "(ILcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask$PostRunnable;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mSampleSize", "mPostRunnable", "execute", "Lkotlinx/coroutines/Job;", "imagePathLists", "", "", "", "([Ljava/util/List;)Lkotlinx/coroutines/Job;", "doInBackground", "", "Landroid/graphics/Bitmap;", "([Ljava/util/List;)Ljava/util/Map;", "onPostExecute", "", "imageDataMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PostRunnable", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LoadImageBitmapTask implements CoroutineScope {

        @NotNull
        private static final String TAG = "LoadImageBitmapTask";

        @NotNull
        private CompletableJob job;

        @Nullable
        private final PostRunnable mPostRunnable;
        private int mSampleSize;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH$J \u0010\u000e\u001a\u00020\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005R,\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$LoadImageBitmapTask$PostRunnable;", "", "<init>", "()V", "mImageDataMap", "", "", "Landroid/graphics/Bitmap;", "getMImageDataMap", "()Ljava/util/Map;", "setMImageDataMap", "(Ljava/util/Map;)V", "run", "", "accept", "imageDataMap", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static abstract class PostRunnable {

            @Nullable
            private Map<String, Bitmap> mImageDataMap;

            public final void accept(@Nullable Map<String, Bitmap> imageDataMap) {
                this.mImageDataMap = imageDataMap;
                run();
            }

            @Nullable
            public final Map<String, Bitmap> getMImageDataMap() {
                return this.mImageDataMap;
            }

            public abstract void run();

            public final void setMImageDataMap(@Nullable Map<String, Bitmap> map) {
                this.mImageDataMap = map;
            }
        }

        public LoadImageBitmapTask(@Nullable PostRunnable postRunnable) {
            this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            this.mSampleSize = 1;
            this.mPostRunnable = postRunnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Bitmap> doInBackground(List<String>... imagePathLists) {
            List<String> list = imagePathLists[0];
            Logger.m7148i(TAG, "getImageBitmap# start: size : " + list.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && FileUtils.exists(str)) {
                    linkedHashMap.put(str, DocScanUtils.getBitmapImageFromPath(str, this.mSampleSize));
                }
            }
            Logger.m7148i(TAG, "getImageBitmap# end");
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object onPostExecute(Map<String, Bitmap> map, Continuation<? super Unit> continuation) {
            return BuildersKt.withContext(Dispatchers.getMain(), new RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2(this, map, null), continuation);
        }

        @NotNull
        public final Job execute(@NotNull List<String>... imagePathLists) {
            Intrinsics.checkNotNullParameter(imagePathLists, "imagePathLists");
            return BuildersKt__Builders_commonKt.launch$default(this, null, null, new RectifyListPresenter$LoadImageBitmapTask$execute$1(this, imagePathLists, null), 3, null);
        }

        @Override // kotlinx.coroutines.CoroutineScope
        @NotNull
        public CoroutineContext getCoroutineContext() {
            return this.job.plus(Dispatchers.getIO());
        }

        public LoadImageBitmapTask(int i, @Nullable PostRunnable postRunnable) {
            this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            this.mSampleSize = i;
            this.mPostRunnable = postRunnable;
        }
    }
}
