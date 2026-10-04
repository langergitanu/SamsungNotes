package com.samsung.android.livetranslation.task;

import android.content.Context;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.SceneText;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.Util;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class PostTRLTask extends LiveTranslationTask {
    private final String TAG;
    private final WeakReference<Context> contextHolder;
    private final LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener;
    private final List<String> translatedStr;

    public PostTRLTask(KeyFrame keyFrame, LiveTranslationTask.TaskStatusListener taskStatusListener, Context context, LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener, List<String> list) {
        super(keyFrame, taskStatusListener);
        this.TAG = "PostTRLTask";
        this.contextHolder = new WeakReference<>(context);
        this.liveTranslationTaskManagerListener = liveTranslationTaskManagerListener;
        this.translatedStr = list;
    }

    private void detectAndClearSameTranslatedResult(KeyFrame keyFrame) {
        for (SceneText sceneText : keyFrame.getSceneTexts()) {
            LTTLogger.m5581d(this.TAG, "Paragraph type =" + sceneText.getTrlUnit());
            if (!sceneText.isParagraphRendering()) {
                for (SceneText sceneText2 : sceneText.getComponents()) {
                    LTTLogger.m5581d(this.TAG, "Line Original =" + sceneText2.getValue());
                    LTTLogger.m5581d(this.TAG, "Line Translated =" + sceneText2.getTrsValue());
                    String trsValue = sceneText2.getTrsValue();
                    int length = trsValue.length();
                    int iCharCount = 0;
                    while (true) {
                        if (iCharCount >= length) {
                            LTTLogger.m5581d(this.TAG, "Empty mask rendering");
                            sceneText2.setTrsValue(" ");
                            break;
                        }
                        int iCodePointAt = trsValue.codePointAt(iCharCount);
                        if (Character.isWhitespace(iCodePointAt)) {
                            iCharCount += Character.charCount(iCodePointAt);
                        } else if (Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText2.getTrsValue()).trim())) {
                            LTTLogger.m5581d(this.TAG, "Rendering skipped");
                            sceneText2.setTrsValue("");
                        }
                    }
                }
            } else {
                LTTLogger.m5581d(this.TAG, "Para Original =" + sceneText.getValue());
                LTTLogger.m5581d(this.TAG, "Para Translated =" + sceneText.getTrsValue());
                LTTLogger.m5581d(this.TAG, "Para Distributed =" + sceneText.getSplitTRSLines());
                if (Util.removeMoreThanOneSpaceBetweenWords(sceneText.getValue()).trim().equalsIgnoreCase(Util.removeMoreThanOneSpaceBetweenWords(sceneText.getTrsValue()).trim())) {
                    sceneText.getSplitTRSLines().clear();
                }
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.livetranslation.task.LiveTranslationTask, android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) {
        LTTLogger.m5581d(this.TAG, "doInBackground:E" + this.translatedStr);
        TRLResultOrganizer organizer = new TRLResultManager(this.contextHolder.get(), this.mKeyFrame, this.translatedStr).getOrganizer();
        this.mKeyFrame.setTRLResultString(this.translatedStr);
        if (!organizer.setTRLResultToKeyFrame()) {
            return Boolean.FALSE;
        }
        SceneTextFormatter sceneTextFormatter = new SceneTextFormatter();
        SceneTextFormatter.setTextScaleX(false);
        detectAndClearSameTranslatedResult(this.mKeyFrame);
        sceneTextFormatter.doSceneTextFormatting(this.mKeyFrame);
        return Boolean.TRUE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.livetranslation.task.LiveTranslationTask, android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            LTTLogger.m5583i(this.TAG, "onPostExecute: TRL completed");
            this.mStatusListener.updateStatus(LiveTranslationTaskManager.STATUS.TRL_COMPLETED);
            this.liveTranslationTaskManagerListener.onTRLFinish(true, this.mKeyFrame, 3005);
        } else {
            LTTLogger.m5583i(this.TAG, "onPostExecute: TRL Failed");
            this.mStatusListener.updateStatus(LiveTranslationTaskManager.STATUS.TRL_FAIL);
            this.liveTranslationTaskManagerListener.onTRLFinish(false, this.mKeyFrame, 3003);
        }
    }
}
