package com.samsung.android.support.senl.document.data;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ContentData {
    public static final int TYPE_ID_DEFAULT = 1;
    public static final int TYPE_ID_TODO = 2;
    public static final int TYPE_ID_TODO_DONE = 3;
    public static final int TYPE_ID_VOICE_RECORD = 5;
    public int contentType = 0;
    public int contentId = 0;
    public int thumbnailId = 0;
    public int taskId = 0;
    public int taskState = 0;
    public String text = null;
    public ArrayList<SpanData> spans = null;
    public ArrayList<Integer> objectFileId = null;
    public RectF objectRect = null;
    public String title = null;
    public String body = null;
    public String uri = null;
    public HashMap<Integer, String> extraMap = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ContentType {
        None,
        Text,
        Image,
        HandWriting,
        Drawing,
        Web,
        Map,
        Voice;

        public static int getId(ContentType contentType) {
            return contentType.ordinal();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Key {
        public static final int ITEM_HEIGHT = 0;
        public static final int NUMBERED = 1;
        public static final int RATIO = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpanData {
        public static final int KEY_DRAWING_BOTTOM = 402;
        public static final int KEY_DRAWING_REAL_IMAGE = 403;
        public static final int KEY_DRAWING_TOP = 401;
        public static final int KEY_STROKE_SPD_PATH = 501;
        public static final int KEY_THUMB_IMAGE = 100;
        public static final int SPAN_TYPE_BOLD = 11;
        public static final int SPAN_TYPE_FOREGROUND_COLOR = 14;
        public static final int SPAN_TYPE_ITALIC = 12;
        public static final int SPAN_TYPE_UNDERLINE = 13;
        public int spanType = 0;
        public int startPosition = 0;
        public int endPosition = 0;
        public int intervalType = 0;
        public int spanVersion = 0;
        public int arg1 = 0;
        public int arg2 = 0;
        public HashMap<Integer, String> customData = null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TaskStatus {
        None,
        Todo,
        Done;

        public static int getId(TaskStatus taskStatus) {
            return taskStatus.ordinal();
        }
    }
}
