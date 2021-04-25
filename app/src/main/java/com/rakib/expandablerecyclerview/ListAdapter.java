package com.rakib.expandablerecyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ExpandableRecyclerAdapter<ListAdapter.PeopleListItem> {
    public static final int TYPE_PERSON = 1001;

    public ListAdapter(Context context) {
        super(context);
        setItems(getSampleItems());
    }

    public static class PeopleListItem extends ExpandableRecyclerAdapter.ListItem {
        public String Text;

        public PeopleListItem(String group) {
            super(TYPE_HEADER);
            Text = group;
        }

        public PeopleListItem(String first, String last) {
            super(TYPE_PERSON);
            Text = first + " " + last;
        }
    }

    public class HeaderViewHolder extends ExpandableRecyclerAdapter.HeaderViewHolder {
        TextView name;

        public HeaderViewHolder(View view) {
            super(view, view.findViewById(R.id.img_arrow));
            name = view.findViewById(R.id.txt_header_name);
        }

        public void bind(int position) {
            super.bind(position);
            name.setText(visibleItems.get(position).Text);
        }
    }

    public class PersonViewHolder extends ExpandableRecyclerAdapter.ViewHolder {
        public PersonViewHolder(View view) {
            super(view);
        }

        public void bind(int position) {

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new HeaderViewHolder(inflate(R.layout.item_header, parent));
            case TYPE_PERSON:
            default:
                return new PersonViewHolder(inflate(R.layout.item_content, parent));
        }
    }

    @Override
    public void onBindViewHolder(ExpandableRecyclerAdapter.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((HeaderViewHolder) holder).bind(position);
                break;
            case TYPE_PERSON:
            default:
                ((PersonViewHolder) holder).bind(position);
                break;
        }
    }

    private List<PeopleListItem> getSampleItems() {
        List<PeopleListItem> items = new ArrayList<>();
        items.add(new PeopleListItem("SmartPhones"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Tablet"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Laptop"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Desktop"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Mobile"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("iPhone"));
        items.add(new PeopleListItem("", ""));
        return items;
    }
}