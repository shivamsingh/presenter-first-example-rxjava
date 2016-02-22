package com.redpanda.pf.rx;

import rx.Observable;

public interface ContactEditorModel {
    Observable<Void> whenContactInfoChanged();

    String contactName();

    String contactEmail();

    void setContactName(String name);

    void setContactEmail(String email);

    void setCurrentContact(Contact contact);

    void save();

    Observable<Void> whenContactSaved();
}
