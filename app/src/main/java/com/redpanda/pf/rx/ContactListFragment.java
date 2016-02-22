package com.redpanda.pf.rx;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;

import rx.Observable;
import rx.subjects.PublishSubject;

public class ContactListFragment extends ListFragment implements ContactListView {
    PublishSubject<Void> initialized = PublishSubject.create();
    PublishSubject<Void> selectionChanged = PublishSubject.create();

    private ArrayAdapter<Contact> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        initialized.onNext(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        getListView().setItemChecked(position, true);
        selectionChanged.onNext(null);
    }

    @Override
    public Observable<Void> whenSelectionChanged() {
        return selectionChanged.asObservable();
    }

    @Override
    public void setContacts(Collection<Contact> contacts) {
        adapter.clear();
        adapter.addAll(contacts);
        refresh();
    }

    @Override
    public int selectedIndex() {
        return getListView().getCheckedItemPosition();
    }

    @Override
    public Observable<Void> whenInitialized() {
        return initialized.asObservable();
    }

    @Override
    public void refresh() {
        adapter.notifyDataSetInvalidated();
    }
}
