package com.samsung.android.support.senl.p148nt.data.common.legacy.displaycontent;

import android.text.Editable;
import android.text.style.StrikethroughSpan;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.TaskSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskStyler {
    private final Editable mEditable;

    public TaskStyler(Editable editable) {
        this.mEditable = editable;
    }

    private void setBullet() {
        this.mEditable.setSpan(new TaskSpan(20), 0, this.mEditable.length(), 33);
    }

    private void setTaskDone() {
        this.mEditable.setSpan(new StrikethroughSpan(), 0, this.mEditable.length(), 33);
        this.mEditable.setSpan(new TaskSpan(2), 0, this.mEditable.length(), 33);
    }

    private void setTaskNone() {
        this.mEditable.setSpan(new TaskSpan(40), 0, this.mEditable.length(), 33);
    }

    private void setTaskNumber(int i) {
        TaskSpan taskSpan = new TaskSpan(10);
        taskSpan.setNumber(i);
        Editable editable = this.mEditable;
        editable.setSpan(taskSpan, 0, editable.length(), 33);
    }

    private void setTaskTodo() {
        this.mEditable.setSpan(new TaskSpan(1), 0, this.mEditable.length(), 33);
    }

    public void setTaskGroupStyle(SpenContentBase spenContentBase) {
        this.mEditable.setSpan(new TaskSpan(4), 0, this.mEditable.length(), 33);
        if (spenContentBase.getTaskStyle() == 2) {
            this.mEditable.setSpan(new StrikethroughSpan(), 0, this.mEditable.length(), 33);
            this.mEditable.setSpan(new TaskSpan(6), 0, this.mEditable.length(), 33);
        }
    }

    public void setTaskStyle(SpenContentBase spenContentBase) {
        int taskStyle = spenContentBase.getTaskStyle();
        if (taskStyle == 0) {
            setTaskNone();
            return;
        }
        if (taskStyle == 1) {
            setTaskTodo();
            return;
        }
        if (taskStyle == 2) {
            setTaskDone();
        } else if (taskStyle == 3) {
            setBullet();
        } else {
            if (taskStyle != 4) {
                return;
            }
            setTaskNumber(spenContentBase.getTaskNumber());
        }
    }
}
