package com.samsung.android.support.senl.p148nt.data.common.legacy;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.TaskSpan;
import com.samsung.android.support.senl.p148nt.data.common.legacy.displaycontent.TaskStyler;
import com.samsung.android.support.senl.p148nt.data.common.legacy.displaycontent.TextStyler;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveNoteContents {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DisplayContentCreator {
        protected SpenContentBase mContent;
        private final boolean mIsSameTaskGroup;
        protected String mLineEnd;

        public DisplayContentCreator(SpenContentBase spenContentBase, boolean z, boolean z2) {
            this.mContent = spenContentBase;
            this.mIsSameTaskGroup = z;
            this.mLineEnd = z2 ? "" : "\n";
        }

        public void appendLineEnd(Editable editable) {
            editable.append((CharSequence) this.mLineEnd);
        }

        public Editable create() {
            return createEditable();
        }

        public Editable createEditable() {
            return Editable.Factory.getInstance().newEditable("\u200b");
        }

        public void setTaskStyle(Editable editable) {
            if (this.mIsSameTaskGroup) {
                new TaskStyler(editable).setTaskGroupStyle(this.mContent);
            } else {
                new TaskStyler(editable).setTaskStyle(this.mContent);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageDisplayContentCreator extends DisplayContentCreator {
        public ImageDisplayContentCreator(SpenContentBase spenContentBase, boolean z, boolean z2) {
            super(spenContentBase, z, z2);
        }

        @Override // com.samsung.android.support.senl.nt.data.common.legacy.SaveNoteContents.DisplayContentCreator
        public Editable create() {
            Editable editableCreateEditable = createEditable();
            setTaskStyle(editableCreateEditable);
            appendLineEnd(editableCreateEditable);
            return editableCreateEditable;
        }

        @Override // com.samsung.android.support.senl.nt.data.common.legacy.SaveNoteContents.DisplayContentCreator
        public Editable createEditable() {
            Editable editableCreateEditable = super.createEditable();
            editableCreateEditable.setSpan(new TaskSpan(8), 0, editableCreateEditable.length(), 33);
            return editableCreateEditable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextDisplayContentCreator extends DisplayContentCreator {
        private final boolean mIsLastContent;

        public TextDisplayContentCreator(SpenContentBase spenContentBase, boolean z, boolean z2) {
            super(spenContentBase, z, z2);
            this.mIsLastContent = z2;
        }

        private void setTextStyle(Editable editable) {
            int start;
            ArrayList<SpenTextSpan> span = this.mContent.getSpan();
            if (span != null) {
                for (SpenTextSpan spenTextSpan : span) {
                    if (spenTextSpan.isPropertyEnabled() && (start = spenTextSpan.getStart()) < editable.length()) {
                        new TextStyler(editable, this.mIsLastContent).setTextStyle(spenTextSpan, start, Math.min(spenTextSpan.getEnd(), editable.length()));
                    }
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.data.common.legacy.SaveNoteContents.DisplayContentCreator
        public Editable create() {
            Editable editableCreateEditable = createEditable();
            appendLineEnd(editableCreateEditable);
            setTextStyle(editableCreateEditable);
            setTaskStyle(editableCreateEditable);
            return editableCreateEditable;
        }

        @Override // com.samsung.android.support.senl.nt.data.common.legacy.SaveNoteContents.DisplayContentCreator
        public Editable createEditable() {
            if (TextUtils.isEmpty(this.mContent.getText())) {
                return Editable.Factory.getInstance().newEditable(this.mContent.getTaskStyle() != 0 ? "\u200b" : "");
            }
            return Editable.Factory.getInstance().newEditable(this.mContent.getText());
        }
    }

    private static DisplayContentCreator createDisplayTextCreator(SpenContentBase spenContentBase, boolean z, boolean z2) {
        int type = spenContentBase.getType();
        return type != 1 ? (type == 2 || type == 4) ? new ImageDisplayContentCreator(spenContentBase, z, z2) : new DisplayContentCreator(spenContentBase, z, z2) : new TextDisplayContentCreator(spenContentBase, z, z2);
    }

    public static Pair<Integer, Integer> getContentsType(ArrayList<SpenContentBase> arrayList) {
        int size = arrayList.size();
        int firstContentType = 0;
        int secondContentType = 0;
        for (int i = 0; i < size; i++) {
            SpenContentBase spenContentBase = arrayList.get(i);
            if (!isEmptyContentText(spenContentBase)) {
                if (firstContentType == 0) {
                    firstContentType = getFirstContentType(spenContentBase.getType());
                }
                if (secondContentType == 0) {
                    secondContentType = getSecondContentType(spenContentBase.getType());
                }
                if (firstContentType != 0 && secondContentType != 0) {
                    break;
                }
            }
        }
        return new Pair<>(Integer.valueOf(firstContentType), Integer.valueOf(secondContentType));
    }

    public static CharSequence getDisplayText(SpenContentBase spenContentBase, TaskInfo taskInfo, boolean z) {
        return createDisplayTextCreator(spenContentBase, taskInfo.isSameTaskGroup(spenContentBase), z).create();
    }

    private static int getFirstContentType(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        return 0;
                    }
                }
            }
            return 2;
        }
        return i;
    }

    private static int getSecondContentType(int i) {
        if (i != 2) {
            if (i == 3) {
                return i;
            }
            if (i != 4 && i != 5) {
                return 0;
            }
        }
        return 2;
    }

    private static boolean isEmptyContentText(SpenContentBase spenContentBase) {
        return (spenContentBase instanceof SpenContentText) && TextUtils.isEmpty(spenContentBase.getText()) && spenContentBase.getTaskStyle() == 0;
    }

    @NonNull
    public static String makeStrippedContent(@Nullable String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("\n*￼\n*|\n+", "\n").replaceAll(UnicodeUtils.NBSP, " ").replaceAll("[⬛⬜\t]", "");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TaskInfo {
        private static final String TAG = DataLogger.createTag("SaveNoteResolver$TaskInfo");

        /* JADX INFO: renamed from: id */
        int f7356id;
        int number;
        int style;

        public TaskInfo() {
            this.f7356id = Integer.MIN_VALUE;
            this.number = Integer.MIN_VALUE;
            this.style = Integer.MIN_VALUE;
        }

        public boolean isSameTaskGroup(SpenContentBase spenContentBase) {
            boolean z = this.f7356id == spenContentBase.getTaskId() && spenContentBase.getTaskStyle() != 0;
            DataLogger.m12302d(TAG, "isSameTaskGroup, ret: " + z);
            return z;
        }

        @NonNull
        public String toString() {
            return "id: " + this.f7356id + ", number: " + this.number + ", style: " + this.style;
        }

        public TaskInfo(SpenContentBase spenContentBase) {
            this.f7356id = spenContentBase.getTaskId();
            this.number = spenContentBase.getTaskNumber();
            this.style = spenContentBase.getTaskStyle();
        }
    }
}
