package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Size;
import android.util.TypedValue;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeLineSplitter;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRecognizerLatex;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRenderer;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRendererSettings;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeStrokeIndices;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskConvertToMath extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskConvertToMath");
    private InputValues mInputValues;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CTMSegmentInfo {
        public Bitmap bitmap;
        public RectF boundingRect;
        public String latexString;

        public CTMSegmentInfo(String str, Bitmap bitmap, RectF rectF) {
            this.latexString = str;
            this.bitmap = bitmap;
            this.boundingRect = rectF;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        boolean mIsComposerViewDarkTheme;
        SpenIMathManager mMathManager;
        SpenWNote mNote;
        ObjectManager mObjectManager;

        public InputValues(ObjectManager objectManager, SpenIMathManager spenIMathManager, SpenWNote spenWNote, boolean z) {
            this.mMathManager = spenIMathManager;
            this.mNote = spenWNote;
            this.mIsComposerViewDarkTheme = z;
            this.mObjectManager = objectManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        String mRecognizedFormula;
        Bitmap mResultBitmap;
        Bitmap mResultBitmapForDialog;
        RectF mTargetRect;

        public ResultValues(Bitmap bitmap, Bitmap bitmap2, String str, RectF rectF) {
            this.mResultBitmap = bitmap;
            this.mResultBitmapForDialog = bitmap2;
            this.mRecognizedFormula = str;
            this.mTargetRect = rectF;
        }

        public String getRecognizedFormula() {
            return this.mRecognizedFormula;
        }

        public Bitmap getResultBitmap() {
            return this.mResultBitmap;
        }

        public Bitmap getResultBitmapForDialog() {
            return this.mResultBitmapForDialog;
        }

        public RectF getTargetRect() {
            return this.mTargetRect;
        }
    }

    private void execute() {
        this.mExecutorService.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskConvertToMath.1
            public static ArrayList<ArrayList<PointF>> convertStrokeData(ArrayList<SpenObjectStroke> arrayList) {
                ArrayList<ArrayList<PointF>> arrayList2 = new ArrayList<>();
                for (SpenObjectStroke spenObjectStroke : arrayList) {
                    ArrayList<PointF> arrayList3 = new ArrayList<>();
                    PointF[] points = spenObjectStroke.getPoints();
                    if (points != null) {
                        for (PointF pointF : points) {
                            arrayList3.add(new PointF(pointF.x, pointF.y));
                        }
                    }
                    arrayList2.add(arrayList3);
                }
                return arrayList2;
            }

            private Bitmap getBitmap(RectF rectF, ArrayList<CTMSegmentInfo> arrayList) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rectF.width(), (int) rectF.height(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                for (CTMSegmentInfo cTMSegmentInfo : arrayList) {
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    Bitmap bitmap = cTMSegmentInfo.bitmap;
                    RectF rectF2 = cTMSegmentInfo.boundingRect;
                    canvas.drawBitmap(bitmap, rectF2.left, rectF2.top, paint);
                    cTMSegmentInfo.bitmap.recycle();
                }
                return bitmapCreateBitmap;
            }

            private String getFormula(ArrayList<CTMSegmentInfo> arrayList) {
                StringBuilder sb = new StringBuilder();
                Iterator<CTMSegmentInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().latexString);
                    sb.append("\n");
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }

            private CTMSegmentInfo makeSegmentInfo(String str, String str2, int i, int i2, int i4, RectF rectF) {
                Bitmap bitmapRender = render(str, str2, i, i2, i4);
                RectF rectF2 = new RectF(0.0f, rectF.bottom, bitmapRender.getWidth(), rectF.bottom + bitmapRender.getHeight());
                rectF.union(rectF2);
                return TaskConvertToMath.this.new CTMSegmentInfo(str, bitmapRender, rectF2);
            }

            private static Bitmap render(String str, String str2, int i, int i2, int i4) {
                Logger.m10999d(TaskConvertToMath.TAG, "render# latexContent " + Logger.getEncode(str));
                Context applicationContext = BaseUtils.getApplicationContext();
                float fApplyDimension = TypedValue.applyDimension(2, (float) i, applicationContext.getResources().getDisplayMetrics());
                SpenHmeRendererSettings spenHmeRendererSettings = new SpenHmeRendererSettings();
                spenHmeRendererSettings.setTextColor(i2);
                spenHmeRendererSettings.setBgColor(0);
                float fConvertDpToPixel = ResourceUtils.convertDpToPixel(applicationContext, 1.0f);
                spenHmeRendererSettings.setOutline(true, i4, fConvertDpToPixel);
                SpenHmeRenderer spenHmeRenderer = new SpenHmeRenderer(str2, fApplyDimension, 160.0f, spenHmeRendererSettings);
                Size sizeLayout = spenHmeRenderer.layout(str);
                Logger.m10999d(TaskConvertToMath.TAG, "render# size = " + sizeLayout + " by unitSize = " + fApplyDimension);
                int i5 = (int) (4.0f * fConvertDpToPixel);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeLayout.getWidth() + i5, sizeLayout.getHeight() + i5, Bitmap.Config.ARGB_8888);
                float f = fConvertDpToPixel * 2.0f;
                spenHmeRenderer.render(bitmapCreateBitmap, new PointF(f, f), 1.0f);
                spenHmeRenderer.close();
                return bitmapCreateBitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                RectF rectF;
                RectF rectF2;
                boolean z;
                Bitmap bitmap;
                Bitmap bitmap2;
                SpenIMathManager spenIMathManager;
                int i;
                int i2;
                RectF rectF3;
                RectF rectF4;
                int color;
                RunnableC99891 runnableC99891 = this;
                try {
                    Logger.m10999d(TaskConvertToMath.TAG, "selectedStrokeList start");
                    ArrayList<SpenObjectBase> selectedObject = TaskConvertToMath.this.mInputValues.mNote.getSelectedObject();
                    if (selectedObject != null && !selectedObject.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (SpenObjectBase spenObjectBase : selectedObject) {
                            if (spenObjectBase instanceof SpenObjectStroke) {
                                arrayList.add((SpenObjectStroke) spenObjectBase);
                            }
                        }
                        SpenIMathManager spenIMathManager2 = TaskConvertToMath.this.mInputValues.mMathManager;
                        SpenHmeLineSplitter spenHmeLineSplitter = new SpenHmeLineSplitter();
                        SpenHmeRecognizerLatex spenHmeRecognizerLatex = spenIMathManager2.getModelPath() != null ? new SpenHmeRecognizerLatex(spenIMathManager2.getModelPath()) : null;
                        ArrayList<SpenHmeStrokeIndices> arrayListSegment = spenHmeLineSplitter.segment(convertStrokeData(arrayList));
                        ArrayList<CTMSegmentInfo> arrayList2 = new ArrayList<>();
                        ArrayList<CTMSegmentInfo> arrayList3 = new ArrayList<>();
                        RectF rectF5 = new RectF();
                        RectF rectF6 = new RectF();
                        if (arrayListSegment == null || arrayListSegment.isEmpty()) {
                            rectF = rectF6;
                            rectF2 = rectF5;
                            z = true;
                            Logger.m11000e(TaskConvertToMath.TAG, "mathStrokes is null or empty");
                        } else {
                            if (spenHmeRecognizerLatex == null) {
                                Logger.m11000e(TaskConvertToMath.TAG, "recognizer is null");
                            } else {
                                int size = arrayListSegment.size();
                                int i4 = 0;
                                while (i4 < size) {
                                    SpenHmeStrokeIndices spenHmeStrokeIndices = arrayListSegment.get(i4);
                                    ArrayList arrayList4 = new ArrayList();
                                    float f = Float.MAX_VALUE;
                                    int color2 = -16777216;
                                    for (Integer num : spenHmeStrokeIndices.getIndices()) {
                                        SpenObjectStroke spenObjectStroke = (SpenObjectStroke) arrayList.get(num.intValue());
                                        float f4 = spenObjectStroke.getRect().left;
                                        if (f4 < f) {
                                            color2 = spenObjectStroke.getColor();
                                            f = f4;
                                        }
                                        arrayList4.add((SpenObjectStroke) arrayList.get(num.intValue()));
                                    }
                                    String strRecognize = spenHmeRecognizerLatex.recognize(convertStrokeData(arrayList4));
                                    Logger.m10999d(TaskConvertToMath.TAG, "recognizedText: " + strRecognize.length());
                                    if (strRecognize.isEmpty()) {
                                        spenIMathManager = spenIMathManager2;
                                        i = size;
                                        i2 = i4;
                                        rectF3 = rectF6;
                                        rectF4 = rectF5;
                                    } else {
                                        SpenColorThemeUtil spenColorThemeUtil = new SpenColorThemeUtil(BaseUtils.getApplicationContext());
                                        spenColorThemeUtil.setColorTheme(1);
                                        if (TaskConvertToMath.this.mInputValues.mIsComposerViewDarkTheme) {
                                            int i5 = color2;
                                            color2 = spenColorThemeUtil.getColor(color2);
                                            color = i5;
                                        } else {
                                            color = spenColorThemeUtil.getColor(color2);
                                        }
                                        i = size;
                                        int i6 = color2;
                                        i2 = i4;
                                        try {
                                            arrayList3.add(runnableC99891.makeSegmentInfo(strRecognize, spenIMathManager2.getFontPath(), 60, i6, color, rectF6));
                                            String fontPath = spenIMathManager2.getFontPath();
                                            runnableC99891 = this;
                                            spenIMathManager = spenIMathManager2;
                                            rectF3 = rectF6;
                                            rectF4 = rectF5;
                                            arrayList2.add(runnableC99891.makeSegmentInfo(strRecognize, fontPath, 10, i6, color, rectF4));
                                            if (i2 != i - 1) {
                                                rectF3.bottom += 50.0f;
                                                rectF4.bottom += 20.0f;
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            Logger.m11001e(TaskConvertToMath.TAG, "execute#", e);
                                            return;
                                        }
                                    }
                                    i4 = i2 + 1;
                                    rectF5 = rectF4;
                                    size = i;
                                    rectF6 = rectF3;
                                    spenIMathManager2 = spenIMathManager;
                                }
                            }
                            rectF = rectF6;
                            rectF2 = rectF5;
                            z = true;
                        }
                        String formula = "";
                        if (arrayList2.isEmpty()) {
                            bitmap = null;
                            bitmap2 = null;
                        } else {
                            bitmap2 = runnableC99891.getBitmap(rectF, arrayList3);
                            bitmap = runnableC99891.getBitmap(rectF2, arrayList2);
                            formula = runnableC99891.getFormula(arrayList3);
                        }
                        if (spenHmeRecognizerLatex != null) {
                            spenHmeRecognizerLatex.close();
                        }
                        spenHmeLineSplitter.close();
                        RectF rectSelectedObjectList = TaskConvertToMath.this.mInputValues.mObjectManager.getSelectedObjectManager().getRectSelectedObjectList();
                        Logger.m10999d(TaskConvertToMath.TAG, "selectedStrokeList end");
                        TaskConvertToMath.this.notifyCallback(bitmap2 != null ? z : false, new ResultValues(bitmap2, bitmap, formula, rectSelectedObjectList));
                        return;
                    }
                    Logger.m11000e(TaskConvertToMath.TAG, "selectedStrokeList is null or empty");
                    TaskConvertToMath.this.notifyCallback(false, new ResultValues(null, null, null, null));
                } catch (Exception e2) {
                    e = e2;
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        String str = TAG;
        Logger.m11003i(str, "executeTask#");
        this.mInputValues = inputValues;
        this.mExecutorService = AbstractC4539a.m3201k(str);
        execute();
    }
}
