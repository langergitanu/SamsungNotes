package com.samsung.android.support.senl.p148nt.model.collector.recognition.data;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultSpenRecognizer {
    public List<String> resultOriginalString = new ArrayList();
    public List<String> resultOriginalLinkString = new ArrayList();
    public List<String> resultString = new ArrayList();
    public List<String> resultLinkString = new ArrayList();
    public List<String> repObjectUuid = new ArrayList();
    public List<RectF> resultRectF = new ArrayList();
    public List<RectF> resultStrokeRectF = new ArrayList();
    public List<ArrayList<Integer>> recognizedStrokeIndex = new ArrayList();
    public List<ArrayList<Integer>> linkStrokeIndex = new ArrayList();
    public List<RectF> lastCharRect = new ArrayList();
    public List<RectF> leftCharRect = new ArrayList();
    public List<Integer> linkType = new ArrayList();
    public List<Integer> resultStringColor = new ArrayList();
    public List<Integer> resultLinkStringColor = new ArrayList();
}
