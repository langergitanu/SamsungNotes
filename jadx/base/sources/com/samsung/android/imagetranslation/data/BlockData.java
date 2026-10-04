package com.samsung.android.imagetranslation.data;

import android.util.Size;
import com.samsung.android.imagetranslation.jni.SceneText;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BlockData {
    int blockHeight;
    int blockWidth;
    ArrayList<SceneText> linesInBlock;
    SceneText paragraph;

    public BlockData(ArrayList<SceneText> arrayList, SceneText sceneText) {
        this.linesInBlock = arrayList;
        this.paragraph = sceneText;
        Size sizeCalculateBlockDimensions = sceneText.calculateBlockDimensions();
        this.blockWidth = sizeCalculateBlockDimensions.getWidth();
        this.blockHeight = sizeCalculateBlockDimensions.getHeight();
    }

    public int getBlockHeight() {
        return this.blockHeight;
    }

    public int getBlockWidth() {
        return this.blockWidth;
    }

    public ArrayList<SceneText> getLinesInBlock() {
        return this.linesInBlock;
    }

    public SceneText getParagraph() {
        return this.paragraph;
    }

    public void setBlockHeight(int i) {
        this.blockHeight = i;
    }

    public void setBlockWidth(int i) {
        this.blockWidth = i;
    }

    public void setLinesInBlock(ArrayList<SceneText> arrayList) {
        this.linesInBlock = arrayList;
    }

    public void setParagraph(SceneText sceneText) {
        this.paragraph = sceneText;
    }
}
