package com.samsung.android.livetranslation.task;

import android.content.Context;
import android.graphics.Point;
import androidx.glance.AbstractC2821a;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.common.Dump;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.SceneText;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.OcrDataToSceneTextConverter;
import com.samsung.android.livetranslation.util.SceneTextUtil;
import com.samsung.android.livetranslation.util.SceneTextUtils;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class PostSTRTask extends LiveTranslationTask {
    private static final String TAG = "PostSTRTask";
    private final LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener;
    private final LttOcrResult lttOcrResult;

    public PostSTRTask(KeyFrame keyFrame, LiveTranslationTask.TaskStatusListener taskStatusListener, Context context, LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener, LttOcrResult lttOcrResult) {
        super(keyFrame, taskStatusListener);
        this.liveTranslationTaskManagerListener = liveTranslationTaskManagerListener;
        this.lttOcrResult = lttOcrResult;
    }

    private void changeCoordinateToPreview(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        String str = TAG;
        LTTLogger.m5581d(str, "changeCoordinateToPreview: E");
        SceneTextUtils.convertCoordiate(copyOnWriteArrayList, SceneTextUtil.generateRotationMatrix(this.mKeyFrame.getOriginalImageWidth(), this.mKeyFrame.getOriginalImageHeight(), this.mKeyFrame.getResizeRatio(), this.mKeyFrame.getRotation()), this.mKeyFrame.getRotation());
        LTTLogger.m5581d(str, "changeCoordinateToPreview: X");
    }

    private boolean convertOcrResultAndSetToKeyFrame(LttOcrResult lttOcrResult, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        LTTLogger.m5583i(TAG, "convertOcrResultAndSetToKeyFrame: E");
        if (!new OcrDataToSceneTextConverter().convert(lttOcrResult, copyOnWriteArrayList, this.mKeyFrame.getRotation())) {
            return false;
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_OCR_DUMP_ENABLE) {
            Dump.drawOCR(copyOnWriteArrayList, false, ShareApi.ORIGINAL_SIZE_IMAGE);
        }
        for (LttOcrResult.BlockInfo blockInfo : lttOcrResult.getBlockInfoList()) {
            LTTLogger.m5581d(TAG, "Original block poly: " + Arrays.toString(blockInfo.getPoly()));
        }
        SceneTextUtils.use_text_rotation = true;
        SceneTextUtils.updateSceneTextRotation(copyOnWriteArrayList, this.mKeyFrame.getRotation());
        updateGoogleBlockIdx(copyOnWriteArrayList);
        SceneTextUtils.detectVerticalLine(copyOnWriteArrayList);
        changeCoordinateToPreview(copyOnWriteArrayList);
        SceneTextUtils.updatePadding(copyOnWriteArrayList, this.mKeyFrame.getHeight(), this.mKeyFrame.getWidth());
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_OCR_DUMP_ENABLE) {
            Dump.drawOCR(copyOnWriteArrayList, false, "upscaled");
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_OCR_DUMP_ENABLE && Dump.IS_PADDED_POLY_ENABLED) {
            Dump.drawOCR(copyOnWriteArrayList, true, "padded");
        }
        this.mKeyFrame.setSceneTexts(copyOnWriteArrayList);
        LTTLogger.m5583i(TAG, "convertOcrResultAndSetToKeyFrame: X");
        return true;
    }

    private void updateGoogleBlockIdx(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        LTTLogger.m5581d(TAG, "updateGoogleBlockIdx: E");
        int googleBlockIdx = copyOnWriteArrayList.get(0).getComponents().get(0).getGoogleBlockIdx();
        Iterator<SceneText> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            for (SceneText sceneText : it.next().getComponents()) {
                LTTLogger.m5581d(TAG, "Block Update(Before) :" + sceneText.getValue() + SQLKeyword.COMMA + sceneText.getGoogleBlockIdx());
            }
        }
        Iterator<SceneText> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            googleBlockIdx = setBlockIdx(googleBlockIdx, it2.next());
            LTTLogger.m5581d(TAG, "SetBlockIdx = " + googleBlockIdx);
        }
        splitBlockIdxWithLang(copyOnWriteArrayList);
        Iterator<SceneText> it3 = copyOnWriteArrayList.iterator();
        while (it3.hasNext()) {
            for (SceneText sceneText2 : it3.next().getComponents()) {
                LTTLogger.m5581d(TAG, "Block Update(After) :" + sceneText2.getValue() + SQLKeyword.COMMA + sceneText2.getGoogleBlockIdx());
            }
        }
        LTTLogger.m5581d(TAG, "updateGoogleBlockIdx: X");
    }

    public boolean checkDigitFrequencyLastWordForEachLine(SceneText sceneText) {
        Pattern patternCompile = Pattern.compile("\\d+");
        int i = 0;
        for (SceneText sceneText2 : sceneText.getComponents()) {
            if (sceneText2.getComponents() != null && patternCompile.matcher(sceneText2.getComponents().get(sceneText2.getComponentNum() - 1).getValue()).find()) {
                i++;
            }
        }
        return i < 3;
    }

    public boolean checkWithAreaRatio(SceneText sceneText) {
        return getLineAreaInParagraph(sceneText) / getPolygonArea(sceneText.getPoly()) > 0.65d;
    }

    public boolean checkWithLineLength(SceneText sceneText) {
        Iterator<SceneText> it = sceneText.getComponents().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getComponentNum() <= 2) {
                i++;
            }
        }
        return ((double) i) <= ((double) sceneText.getComponentNum()) * 0.5d;
    }

    public boolean checkWithOrderedLines(SceneText sceneText) {
        Pattern patternCompile = Pattern.compile("^[\\dA-I]+\\.");
        Iterator<SceneText> it = sceneText.getComponents().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (patternCompile.matcher(it.next().getValue()).find()) {
                i++;
            }
        }
        return i > 2;
    }

    public boolean checkWithSentencePunctuation(SceneText sceneText) {
        Matcher matcher = Pattern.compile("[^\\d\\.]\\.($|\\n| |^\\.)").matcher(sceneText.getValue());
        Iterator<SceneText> it = sceneText.getComponents().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getComponentNum() <= 4) {
                i++;
            }
        }
        return matcher.find() && ((double) i) < ((double) sceneText.getComponentNum()) * 0.5d;
    }

    public boolean enoughForSingleBlockIdx(SceneText sceneText) {
        boolean zCheckWithSentencePunctuation = checkWithSentencePunctuation(sceneText);
        boolean zCheckWithAreaRatio = checkWithAreaRatio(sceneText);
        boolean zCheckWithLineLength = checkWithLineLength(sceneText);
        boolean zCheckWithOrderedLines = checkWithOrderedLines(sceneText);
        boolean zCheckDigitFrequencyLastWordForEachLine = checkDigitFrequencyLastWordForEachLine(sceneText);
        String str = TAG;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("Check paragraph conditions : List(", "), Punctuation(", "), Area(", zCheckWithOrderedLines, zCheckWithSentencePunctuation);
        AbstractC2821a.m2208C(sbM2230u, zCheckWithAreaRatio, "), Words(", zCheckWithLineLength, "), Digits(");
        sbM2230u.append(zCheckDigitFrequencyLastWordForEachLine);
        sbM2230u.append("), ");
        LTTLogger.m5583i(str, sbM2230u.toString());
        if (zCheckWithOrderedLines) {
            return false;
        }
        return zCheckDigitFrequencyLastWordForEachLine & (zCheckWithSentencePunctuation | (zCheckWithAreaRatio & zCheckWithLineLength));
    }

    public double getLineAreaInParagraph(SceneText sceneText) {
        Iterator<SceneText> it = sceneText.getComponents().iterator();
        double polygonArea = 0.0d;
        while (it.hasNext()) {
            polygonArea += getPolygonArea(it.next().getPoly());
        }
        return polygonArea;
    }

    public double getPolygonArea(Point[] pointArr) {
        int i;
        int i2;
        int i4;
        double d = 0.0d;
        for (int i5 = 0; i5 < pointArr.length; i5++) {
            if (i5 == 0) {
                i = pointArr[i5].x;
                i2 = pointArr[i5 + 1].y;
                i4 = pointArr[pointArr.length - 1].y;
            } else if (i5 == pointArr.length - 1) {
                i = pointArr[i5].x;
                i2 = pointArr[0].y;
                i4 = pointArr[i5 - 1].y;
            } else {
                i = pointArr[i5].x;
                i2 = pointArr[i5 + 1].y;
                i4 = pointArr[i5 - 1].y;
            }
            d += (double) ((i2 - i4) * i);
        }
        return Math.abs(d) * 0.5d;
    }

    public int setBlockIdx(int i, SceneText sceneText) {
        Iterator<SceneText> it = sceneText.getComponents().iterator();
        while (it.hasNext()) {
            it.next().setGoogleBlockIdx(i);
        }
        return i + 1;
    }

    public boolean splitBlockIdxWithLang(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        Iterator<SceneText> it = copyOnWriteArrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int googleBlockIdx = -1;
            String str = "";
            for (SceneText sceneText : it.next().getComponents()) {
                HashMap map = new HashMap();
                for (SceneText sceneText2 : sceneText.getComponents()) {
                    String str2 = sceneText2.getLanguages() != null ? sceneText2.getLanguages().get(0) : "";
                    Integer num = (Integer) map.get(str2);
                    if (num != null) {
                        map.put(str2, Integer.valueOf(num.intValue() + 1));
                    } else {
                        map.put(str2, 1);
                    }
                }
                Map.Entry entry = null;
                int iIntValue = 0;
                for (Map.Entry entry2 : map.entrySet()) {
                    if (entry == null || ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue()) > 0) {
                        entry = entry2;
                    }
                    iIntValue += ((Integer) entry2.getValue()).intValue();
                }
                String str3 = (entry == null || ((double) (((float) ((Integer) entry.getValue()).intValue()) / ((float) iIntValue))) <= 0.5d) ? "" : (String) entry.getKey();
                if ("".equals(str) && !"".equals(str3)) {
                    googleBlockIdx = sceneText.getGoogleBlockIdx();
                    str = str3;
                }
                if ("".equals(str) || "".equals(str3) || str.equals(str3) || googleBlockIdx != sceneText.getGoogleBlockIdx()) {
                    sceneText.setGoogleBlockIdx(sceneText.getGoogleBlockIdx() + i);
                } else {
                    i++;
                    sceneText.setGoogleBlockIdx(sceneText.getGoogleBlockIdx() + i);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.livetranslation.task.LiveTranslationTask, android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) {
        String str = TAG;
        LTTLogger.m5583i(str, "doInBackground()");
        if (convertOcrResultAndSetToKeyFrame(this.lttOcrResult, new CopyOnWriteArrayList<>())) {
            LTTLogger.m5583i(str, "PostSTR Success");
            return Boolean.TRUE;
        }
        LTTLogger.m5583i(str, "PostSTR Failed");
        return Boolean.FALSE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.livetranslation.task.LiveTranslationTask, android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.mStatusListener.updateStatus(LiveTranslationTaskManager.STATUS.STR_COMPLETED);
            this.liveTranslationTaskManagerListener.onSTRFinish(true, this.mKeyFrame, this.lttOcrResult, 3005);
        } else {
            this.mStatusListener.updateStatus(LiveTranslationTaskManager.STATUS.STR_FAIL);
            this.liveTranslationTaskManagerListener.onSTRFinish(false, this.mKeyFrame, null, 3003);
        }
    }
}
