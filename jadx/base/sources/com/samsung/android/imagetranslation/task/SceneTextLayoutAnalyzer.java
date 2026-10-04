package com.samsung.android.imagetranslation.task;

import android.graphics.Point;
import com.samsung.android.imagetranslation.geometry.LineDetector;
import com.samsung.android.imagetranslation.geometry.ParagraphDetector;
import com.samsung.android.imagetranslation.geometry.SmallestSurroundingRectangle;
import com.samsung.android.imagetranslation.jni.SceneText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SceneTextLayoutAnalyzer {
    private int mDeviceOrientation;
    private LineDetector mLineDetector = new LineDetector();
    private ParagraphDetector mParagraphDetector = new ParagraphDetector();

    private boolean isSameLevel(SceneText sceneText, SceneText sceneText2) {
        SceneText.SceneTextType type = sceneText2.getType();
        SceneText.SceneTextType sceneTextType = SceneText.SceneTextType.LINE;
        if (type == sceneTextType) {
            return this.mLineDetector.isSameLine(sceneText.getPoly(), sceneText2.getPoly(), sceneText.getValue().length(), sceneText2.getValue().length());
        }
        int componentNum = sceneText.getType() == sceneTextType ? 1 : sceneText.getComponentNum();
        int componentNum2 = sceneText2.getType() == sceneTextType ? 1 : sceneText2.getComponentNum();
        Pattern patternCompile = Pattern.compile("^[*●(□]");
        Pattern patternCompile2 = Pattern.compile("^[0-9]");
        if (patternCompile.matcher(sceneText.getValue()).find() && sceneText.getValue().charAt(0) == sceneText2.getValue().charAt(0)) {
            return false;
        }
        if (patternCompile2.matcher(sceneText.getValue()).find() && patternCompile2.matcher(sceneText2.getValue()).find()) {
            if (Character.getNumericValue(sceneText2.getValue().charAt(0)) - Character.getNumericValue(sceneText.getValue().charAt(0)) == 1) {
                return false;
            }
        }
        return this.mParagraphDetector.isSameParagraph(sceneText.getPoly(), sceneText2.getPoly(), componentNum, componentNum2);
    }

    private CopyOnWriteArrayList<SceneText> makeMultiParagraphs(Stack<SceneText> stack) {
        ArrayList arrayList = new ArrayList(stack);
        CopyOnWriteArrayList<SceneText> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add((SceneText) it.next());
        }
        return copyOnWriteArrayList;
    }

    private List<SceneText> makeSingleParagraph(List<SceneText> list, Stack<SceneText> stack) {
        ArrayList arrayList = new ArrayList();
        SceneText sceneText = new SceneText();
        sceneText.setType(SceneText.SceneTextType.PARAGRAPH);
        sceneText.setPoly(list.get(0).getPoly());
        sceneText.setValue(list.get(0).getValue());
        Iterator it = new ArrayList(stack).iterator();
        while (it.hasNext()) {
            sceneText.setComponent((SceneText) it.next());
        }
        arrayList.add(sceneText);
        return arrayList;
    }

    private SceneText mergeComponent(SceneText sceneText, SceneText sceneText2) {
        return sceneText2.getType() == SceneText.SceneTextType.LINE ? mergeWord(sceneText, sceneText2) : mergeLine(sceneText, sceneText2);
    }

    private Stack<SceneText> mergeComponents(List<SceneText> list, SceneText.SceneTextType sceneTextType) {
        Stack<SceneText> stack = new Stack<>();
        for (SceneText sceneText : list) {
            SceneText sceneText2 = new SceneText();
            sceneText2.setType(sceneTextType);
            sceneText2.setPoly(sceneText.getPoly());
            sceneText2.setValue(sceneText.getValue());
            sceneText2.setComponent(sceneText);
            sceneText2.setDeviceOrientation(this.mDeviceOrientation);
            if (stack.isEmpty()) {
                stack.push(sceneText2);
            } else {
                SceneText sceneTextPeek = stack.peek();
                if (isSameLevel(sceneTextPeek, sceneText2)) {
                    stack.pop();
                    stack.push(mergeComponent(sceneTextPeek, sceneText2));
                } else {
                    stack.push(sceneText2);
                }
            }
        }
        return stack;
    }

    private SceneText mergeLine(SceneText sceneText, SceneText sceneText2) {
        SceneText sceneText3 = new SceneText();
        SceneText.SceneTextType sceneTextType = SceneText.SceneTextType.PARAGRAPH;
        sceneText3.setType(sceneTextType);
        sceneText3.setValue(sceneText.getValue() + "\t" + sceneText2.getValue());
        sceneText3.setPoly(mergePoly(sceneText.getPoly(), sceneText2.getPoly()));
        sceneText3.setDeviceOrientation(this.mDeviceOrientation);
        if (sceneText.getType() == SceneText.SceneTextType.LINE) {
            sceneText3.setComponent(sceneText);
        } else if (sceneText.getType() == sceneTextType) {
            Iterator<SceneText> it = sceneText.getComponents().iterator();
            while (it.hasNext()) {
                sceneText3.setComponent(it.next());
            }
        }
        if (sceneText2.getType() == SceneText.SceneTextType.LINE) {
            sceneText3.setComponent(sceneText2);
            return sceneText3;
        }
        if (sceneText2.getType() == SceneText.SceneTextType.PARAGRAPH) {
            Iterator<SceneText> it2 = sceneText2.getComponents().iterator();
            while (it2.hasNext()) {
                sceneText3.setComponent(it2.next());
            }
        }
        return sceneText3;
    }

    private Point[] mergePoly(Point[] pointArr, Point[] pointArr2) {
        return SmallestSurroundingRectangle.computeCorners(pointArr, pointArr2);
    }

    private SceneText mergeWord(SceneText sceneText, SceneText sceneText2) {
        SceneText sceneText3 = new SceneText();
        SceneText.SceneTextType sceneTextType = SceneText.SceneTextType.LINE;
        sceneText3.setType(sceneTextType);
        sceneText3.setValue(sceneText.getValue() + " " + sceneText2.getValue());
        sceneText3.setPoly(mergePoly(sceneText.getPoly(), sceneText2.getPoly()));
        sceneText3.setDeviceOrientation(this.mDeviceOrientation);
        if (sceneText.getType() == SceneText.SceneTextType.WORD) {
            sceneText3.setComponent(sceneText);
        } else if (sceneText.getType() == sceneTextType) {
            Iterator<SceneText> it = sceneText.getComponents().iterator();
            while (it.hasNext()) {
                sceneText3.setComponent(it.next());
            }
        }
        if (sceneText2.getType() == SceneText.SceneTextType.WORD) {
            sceneText3.setComponent(sceneText2);
            return sceneText3;
        }
        if (sceneText2.getType() == SceneText.SceneTextType.LINE) {
            Iterator<SceneText> it2 = sceneText2.getComponents().iterator();
            while (it2.hasNext()) {
                sceneText3.setComponent(it2.next());
            }
        }
        return sceneText3;
    }

    private void sortSceneTextList(List<SceneText> list) {
        Collections.sort(list.get(0).getComponents(), new Comparator<SceneText>() { // from class: com.samsung.android.imagetranslation.task.SceneTextLayoutAnalyzer.1
            @Override // java.util.Comparator
            public int compare(SceneText sceneText, SceneText sceneText2) {
                return 1;
            }
        });
    }

    public CopyOnWriteArrayList<SceneText> analyze(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        this.mDeviceOrientation = copyOnWriteArrayList.get(0).getDeviceOrientation();
        return makeMultiParagraphs(mergeComponents(copyOnWriteArrayList.get(0).getComponents(), SceneText.SceneTextType.PARAGRAPH));
    }
}
