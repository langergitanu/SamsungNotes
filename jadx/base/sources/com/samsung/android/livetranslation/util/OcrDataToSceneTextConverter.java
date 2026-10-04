package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.util.C7149r;
import com.samsung.android.livetranslation.common.Dump;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.LiveTranslation;
import com.samsung.android.livetranslation.text.SceneText;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
        return (List) wordInfo.getCharInfo().stream().filter(new C7173d(this, 1)).map(new C7181l(this, 0)).collect(Collectors.toList());
    }

    private List<SceneText> convertStLines(LttOcrResult.BlockInfo blockInfo, int i, ArrayList<String> arrayList) {
        return (List) blockInfo.getLineInfo().stream().filter(new C7175f(2)).map(new C7149r(this, arrayList, i, 1)).collect(Collectors.toList());
    }

    private List<SceneText> convertStWords(LttOcrResult.LineInfo lineInfo) {
        return (List) lineInfo.getWordInfo().stream().filter(new C7175f(4)).map(new C7181l(this, 1)).collect(Collectors.toList());
    }

    private boolean isInvalidCharInfo(LttOcrResult.CharInfo charInfo) {
        return charInfo.getPoly() == null || charInfo.getChar().equals(" ") || charInfo.getChar().equals("\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$convert$0(LttOcrResult.BlockInfo blockInfo) {
        return blockInfo.getPoly() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$1(int i, LttOcrResult.BlockInfo blockInfo) {
        this.isValid = false;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(blockInfo.getLangCode());
        SceneText sceneText = new SceneText();
        sceneText.setDeviceOrientation(i);
        sceneText.setType(SceneText.SceneTextType.PARAGRAPH);
        sceneText.setPoly(blockInfo.getPoly());
        sceneText.setValue(blockInfo.getString());
        if (Discriminator.isParagraph(blockInfo) || !LiveTranslation.isJarAndNativeCompatible) {
            LTTLogger.m5581d(TAG, "Rendering type is Paragraph");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.PARAGRAPH.toString());
            sceneText.setParagraphRendering(true);
        } else {
            LTTLogger.m5581d(TAG, "Rendering type is Line");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.LINE.toString());
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.RENDERING_TYPE.equalsIgnoreCase("P")) {
            LTTLogger.m5581d(TAG, "Forced paragraph rendering");
            sceneText.setTrlUnit(KeyFrame.TRL_UNIT.PARAGRAPH.toString());
            sceneText.setParagraphRendering(true);
        } else if (Dump.IS_INIT_DUMP_SUCCESS && Dump.RENDERING_TYPE.equalsIgnoreCase("L")) {
            LTTLogger.m5581d(TAG, "Forced line rendering");
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

    public boolean convert(LttOcrResult lttOcrResult, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList, int i) {
        String str = TAG;
        LTTLogger.m5581d(str, "convert : E");
        if (lttOcrResult == null || copyOnWriteArrayList == null) {
            LTTLogger.m5581d(str, "convert : X with false 1");
            return false;
        }
        this.mSrc = lttOcrResult;
        this.mTar = copyOnWriteArrayList;
        this.googleBlockIdx = 0;
        LTTLogger.m5581d(str, "convert: paragraph number: " + this.mSrc.getBlockInfoList().size());
        this.mSrc.getBlockInfoList().stream().filter(new C7175f(3)).forEach(new C7182m(this, i, 0));
        if (this.mTar.size() < 1) {
            LTTLogger.m5581d(str, "convert : X with false 2");
            return false;
        }
        LTTLogger.m5581d(str, "convert : X");
        return true;
    }
}
