package com.samsung.android.imagetranslation.util;

import android.content.Context;
import com.samsung.android.imagetranslation.common.Dump;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.jni.KeyFrame;
import com.samsung.android.imagetranslation.jni.SceneText;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OcrDataToSceneTextConverter {
    private static final String TAG = "OcrDataToSceneTextConverter";
    private int googleBlockIdx;
    private boolean isValid;
    private LttOcrResult mSrc;
    private CopyOnWriteArrayList<SceneText> mTar;

    private List<SceneText> convertStChars(LttOcrResult.WordInfo wordInfo) {
        return (List) wordInfo.getCharInfo().stream().filter(new C7139h(this, 2)).map(new C7148q(this, 0)).collect(Collectors.toList());
    }

    private List<SceneText> convertStLines(LttOcrResult.BlockInfo blockInfo, int i, ArrayList<String> arrayList) {
        return (List) blockInfo.getLineInfo().stream().filter(new C7141j(4)).map(new C7149r(this, arrayList, i, 0)).collect(Collectors.toList());
    }

    private List<SceneText> convertStWords(LttOcrResult.LineInfo lineInfo) {
        return (List) lineInfo.getWordInfo().stream().filter(new C7141j(5)).map(new C7148q(this, 1)).collect(Collectors.toList());
    }

    private boolean isInvalidCharInfo(LttOcrResult.CharInfo charInfo) {
        return charInfo.getPoly() == null || charInfo.getChar().equals(" ") || charInfo.getChar().equals("\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$convert$0(LttOcrResult.BlockInfo blockInfo) {
        return blockInfo.getPoly() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$1(int i, Context context, LttOcrResult.BlockInfo blockInfo) {
        this.isValid = false;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(blockInfo.getLangCode());
        SceneText sceneText = new SceneText();
        sceneText.setDeviceOrientation(i);
        sceneText.setType(SceneText.SceneTextType.PARAGRAPH);
        sceneText.setPoly(blockInfo.getPoly());
        sceneText.setValue(blockInfo.getString());
        if (Discriminator.isParagraph(context, blockInfo)) {
            LTTLogger.m5458d(TAG, "Rendering type is Paragraph");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.PARAGRAPH.toString());
            sceneText.setParagraphRendering(true);
        } else {
            LTTLogger.m5458d(TAG, "Rendering type is Line");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.LINE.toString());
        }
        if (blockInfo.getBlockType() == LttOcrResult.BlockInfo.BLOCK_TYPE.TABULAR.ordinal()) {
            sceneText.setBlockType(blockInfo.getBlockType());
        } else {
            sceneText.setBlockType(0);
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.RENDERING_TYPE.equalsIgnoreCase("P")) {
            LTTLogger.m5458d(TAG, "Forced paragraph rendering");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.PARAGRAPH.toString());
            sceneText.setParagraphRendering(true);
        } else if (Dump.IS_INIT_DUMP_SUCCESS && Dump.RENDERING_TYPE.equalsIgnoreCase("L")) {
            LTTLogger.m5458d(TAG, "Forced line rendering");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.LINE.toString());
            sceneText.setParagraphRendering(false);
        }
        sceneText.setLanguages(arrayList);
        sceneText.setComponents(convertStLines(blockInfo, this.googleBlockIdx, sceneText.getLanguages()));
        if (this.isValid) {
            this.mTar.add(sceneText);
            this.googleBlockIdx++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$convertStChars$6(LttOcrResult.CharInfo charInfo) {
        return !isInvalidCharInfo(charInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SceneText lambda$convertStChars$7(LttOcrResult.CharInfo charInfo) {
        SceneText sceneText = new SceneText();
        sceneText.setType(SceneText.SceneTextType.CHARACTER);
        sceneText.setValue(charInfo.getChar());
        sceneText.setPoly(charInfo.getPoly());
        this.isValid = true;
        return sceneText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$convertStLines$2(LttOcrResult.LineInfo lineInfo) {
        return lineInfo.getPoly() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SceneText lambda$convertStLines$3(ArrayList arrayList, int i, LttOcrResult.LineInfo lineInfo) {
        SceneText sceneText = new SceneText();
        sceneText.setType(SceneText.SceneTextType.LINE);
        sceneText.setPoly(lineInfo.getPoly());
        sceneText.setValue(lineInfo.getString().replace("\n", ""));
        sceneText.setLanguages(arrayList);
        sceneText.setGoogleBlockIdx(i);
        if (SceneTextUtils.containsOnlyNumbersAndSymbols(sceneText.getValue())) {
            sceneText.setOnlyNumber(true);
        }
        sceneText.setComponents(convertStWords(lineInfo));
        return sceneText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$convertStWords$4(LttOcrResult.WordInfo wordInfo) {
        return wordInfo.getPoly() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SceneText lambda$convertStWords$5(LttOcrResult.WordInfo wordInfo) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(wordInfo.getLangCode());
        SceneText sceneText = new SceneText();
        sceneText.setType(SceneText.SceneTextType.WORD);
        sceneText.setPoly(wordInfo.getPoly());
        sceneText.setValue(wordInfo.getString().replace("\n", ""));
        sceneText.setLanguages(arrayList);
        sceneText.setComponents(convertStChars(wordInfo));
        return sceneText;
    }

    public boolean convert(LttOcrResult lttOcrResult, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, final int i, final Context context) {
        String str = TAG;
        LTTLogger.m5458d(str, "convert : E");
        if (lttOcrResult == null || copyOnWriteArrayList == null) {
            LTTLogger.m5458d(str, "convert : X with false 1");
            return false;
        }
        this.mSrc = lttOcrResult;
        this.mTar = copyOnWriteArrayList;
        this.googleBlockIdx = 0;
        LTTLogger.m5458d(str, "convert: paragraph number: " + this.mSrc.getBlockInfoList().size());
        this.mSrc.getBlockInfoList().stream().filter(new C7141j(3)).forEach(new Consumer() { // from class: com.samsung.android.imagetranslation.util.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f4801a.lambda$convert$1(i, context, (LttOcrResult.BlockInfo) obj);
            }
        });
        if (this.mTar.size() < 1) {
            LTTLogger.m5458d(str, "convert : X with false 2");
            return false;
        }
        LTTLogger.m5458d(str, "convert : X");
        return true;
    }
}
