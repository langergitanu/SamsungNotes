package com.samsung.android.livetranslation.task;

import android.util.Size;
import com.samsung.android.livetranslation.text.SceneText;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ParaBlockData {
    int blockHeight;
    int blockWidth;
    ArrayList<SceneText> linesInBlock;
    SceneText paragraph;

    public ParaBlockData(ArrayList<SceneText> arrayList, SceneText sceneText) {
        this.linesInBlock = arrayList;
        this.paragraph = sceneText;
        Size sizeCalculateBlockDimensions = sceneText.calculateBlockDimensions();
        this.blockWidth = sizeCalculateBlockDimensions.getWidth();
        this.blockHeight = sizeCalculateBlockDimensions.getHeight();
    }
}
