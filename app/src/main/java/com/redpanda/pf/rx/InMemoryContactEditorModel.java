package com.redpanda.pf.rx;

import rx.Observable;
import rx.subjects.PublishSubject;

public class InMemoryContactEditorModel implements ContactEditorModel {
    private Contact contact;
    private PublishSubject<Void> contactInfoChanged = PublishSubject.create();
    private PublishSubject<Void> contactSaved = PublishSubject.create();

    @Override
    public Observable<Void> whenContactInfoChanged() {
        return contactInfoChanged.asObservable();
    }

    @Override
    public String contactName() {
        return contact.name();
    }

    @Override
    public String contactEmail() {
        return contact.email();
    }

    @Override
    public void setContactName(String contactName) {
        contact.setName(contactName);
    }

    @Override
    public void setContactEmail(String contactEmail) {
        contact.setEmail(contactEmail);
    }

    @Override
    public void setCurrentContact(Contact contact) {
        this.contact = contact;
        contactInfoChanged.onNext(null);
    }

    @Override
    public void save() {
        contactSaved.onNext(null);
    }

    @Override
    public Observable<Void> whenContactSaved() {
        return contactSaved.asObservable();
    }
}
