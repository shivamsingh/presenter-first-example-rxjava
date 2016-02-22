package com.redpanda.pf.rx;

import rx.Observable;

public interface ContactEditorView {
    void setName(String name);

    void setEmail(String email);

    Observable<Void> whenUserSaved();

    String contactName();

    String contactEmail();
}
