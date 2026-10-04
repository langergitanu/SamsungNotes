package com.vladsch.flexmark.util.misc;

import java.util.List;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DelimitedBuilder {
    private String delimiter;
    private Stack<String> delimiterStack;
    private int lastLen;
    private StringBuilder out;
    private boolean pending;

    public DelimitedBuilder() {
        this(",", 0);
    }

    private void doPending() {
        if (this.out == null) {
            this.out = new StringBuilder();
        }
        if (this.pending) {
            this.out.append(this.delimiter);
            this.pending = false;
        }
    }

    public DelimitedBuilder append(char c) {
        doPending();
        this.out.append(c);
        return this;
    }

    public <V> DelimitedBuilder appendAll(V[] vArr) {
        return appendAll(vArr, 0, vArr.length);
    }

    public DelimitedBuilder appendCodePoint(int i) {
        doPending();
        this.out.appendCodePoint(i);
        return this;
    }

    public DelimitedBuilder clear() {
        this.out = null;
        unmark();
        return this;
    }

    public String getAndClear() {
        Stack<String> stack = this.delimiterStack;
        if (stack != null && !stack.isEmpty()) {
            throw new IllegalStateException("Delimiter stack is not empty");
        }
        StringBuilder sb = this.out;
        String string = sb == null ? "" : sb.toString();
        clear();
        return string;
    }

    public boolean isEmpty() {
        if (this.pending) {
            return false;
        }
        StringBuilder sb = this.out;
        return sb == null || sb.length() == 0;
    }

    public DelimitedBuilder mark() {
        StringBuilder sb = this.out;
        int length = sb != null ? sb.length() : 0;
        if (this.lastLen != length) {
            this.pending = true;
        }
        this.lastLen = length;
        return this;
    }

    public DelimitedBuilder pop() {
        Stack<String> stack = this.delimiterStack;
        if (stack == null || stack.isEmpty()) {
            throw new IllegalStateException("Nothing on the delimiter stack");
        }
        this.delimiter = this.delimiterStack.pop();
        return this;
    }

    public DelimitedBuilder push() {
        return push(this.delimiter);
    }

    public String toString() {
        Stack<String> stack = this.delimiterStack;
        if (stack != null && !stack.isEmpty()) {
            throw new IllegalStateException("Delimiter stack is not empty");
        }
        StringBuilder sb = this.out;
        return sb == null ? "" : sb.toString();
    }

    public String toStringOrNull() {
        Stack<String> stack = this.delimiterStack;
        if (stack != null && !stack.isEmpty()) {
            throw new IllegalStateException("Delimiter stack is not empty");
        }
        StringBuilder sb = this.out;
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public DelimitedBuilder unmark() {
        this.pending = false;
        StringBuilder sb = this.out;
        this.lastLen = sb != null ? sb.length() : 0;
        return this;
    }

    public DelimitedBuilder(String str) {
        this(str, 0);
    }

    public <V> DelimitedBuilder appendAll(V[] vArr, int i, int i2) {
        while (i < i2) {
            append(vArr[i].toString());
            mark();
            i++;
        }
        return this;
    }

    public DelimitedBuilder push(String str) {
        unmark();
        if (this.delimiterStack == null) {
            this.delimiterStack = new Stack<>();
        }
        this.delimiterStack.push(this.delimiter);
        this.delimiter = str;
        return this;
    }

    public DelimitedBuilder(String str, int i) {
        this.pending = false;
        this.lastLen = 0;
        this.delimiterStack = null;
        this.delimiter = str;
        this.out = i != 0 ? new StringBuilder(i) : null;
    }

    public DelimitedBuilder append(int i) {
        doPending();
        this.out.append(i);
        return this;
    }

    public DelimitedBuilder append(boolean z) {
        doPending();
        this.out.append(z);
        return this;
    }

    public <V> DelimitedBuilder appendAll(String str, V[] vArr) {
        return appendAll(str, vArr, 0, vArr.length);
    }

    public <V> DelimitedBuilder appendAll(String str, V[] vArr, int i, int i2) {
        StringBuilder sb = this.out;
        int length = sb != null ? sb.length() : 0;
        push(str);
        appendAll(vArr, i, i2);
        pop();
        StringBuilder sb2 = this.out;
        if (length != (sb2 != null ? sb2.length() : 0)) {
            mark();
            return this;
        }
        unmark();
        return this;
    }

    public DelimitedBuilder append(long j) {
        doPending();
        this.out.append(j);
        return this;
    }

    public DelimitedBuilder append(float f) {
        doPending();
        this.out.append(f);
        return this;
    }

    public DelimitedBuilder append(double d) {
        doPending();
        this.out.append(d);
        return this;
    }

    public <V> DelimitedBuilder appendAll(List<? extends V> list) {
        return appendAll(list, 0, list.size());
    }

    public DelimitedBuilder append(String str) {
        if (str != null && !str.isEmpty()) {
            doPending();
            this.out.append(str);
        }
        return this;
    }

    public <V> DelimitedBuilder appendAll(List<? extends V> list, int i, int i2) {
        while (i < i2) {
            append(list.get(i).toString());
            mark();
            i++;
        }
        return this;
    }

    public DelimitedBuilder append(String str, int i, int i2) {
        if (str != null && i < i2) {
            doPending();
            this.out.append((CharSequence) str, i, i2);
        }
        return this;
    }

    public <V> DelimitedBuilder appendAll(String str, List<? extends V> list) {
        return appendAll(str, list, 0, list.size());
    }

    public <V> DelimitedBuilder appendAll(String str, List<? extends V> list, int i, int i2) {
        StringBuilder sb = this.out;
        int length = sb != null ? sb.length() : 0;
        push(str);
        appendAll(list, i, i2);
        pop();
        StringBuilder sb2 = this.out;
        if (length != (sb2 != null ? sb2.length() : 0)) {
            mark();
            return this;
        }
        unmark();
        return this;
    }

    public DelimitedBuilder append(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            doPending();
            this.out.append(charSequence);
        }
        return this;
    }

    public DelimitedBuilder append(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i < i2) {
            doPending();
            this.out.append(charSequence, i, i2);
        }
        return this;
    }

    public DelimitedBuilder append(char[] cArr) {
        if (cArr.length > 0) {
            doPending();
            this.out.append(cArr);
        }
        return this;
    }

    public DelimitedBuilder append(char[] cArr, int i, int i2) {
        if (i < i2) {
            doPending();
            this.out.append(cArr, i, i2);
        }
        return this;
    }

    public DelimitedBuilder append(Object obj) {
        return append(obj.toString());
    }
}
