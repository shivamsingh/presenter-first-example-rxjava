package com.redpanda.pf.rx;

public class ContactEditorPresenter {
    public ContactEditorPresenter(ContactEditorModel model, ContactEditorView view) {
        model.whenContactInfoChanged().subscribe(ignored -> {
            view.setName(model.contactName());
            view.setEmail(model.contactEmail());
        });
        view.whenUserSaved().subscribe(ignored -> {
            model.setContactName(view.contactName());
            model.setContactEmail(view.contactEmail());
            model.save();
        });
    }
}
