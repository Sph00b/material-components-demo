package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;
import com.xeroxparc.materialcomponentsdemo.databinding.ItemComponentBinding;

/**
 * Binder class.
 * Synchronize the view model and the view.
 * @author Fabio Buracchi
 *
 */
class ComponentListItemBinder {

    private final ItemComponentBinding binding;

    ComponentListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemComponentBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }

    View getRoot(){
        return binding.getRoot();
    }

    void bind(@NonNull MaterialComponent component) {
        binding.textViewName.setText(component.getName());
    }

}
