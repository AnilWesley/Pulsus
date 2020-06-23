package com.applications.pulsus.listener;


import com.applications.pulsus.models.Categories;

public interface CatClickListener1 {

    void onAddClick(int position, Categories categories);
    void onRemoveClick(int position, Categories categories);

}
