package com.xeroxparc.materialcomponentsdemo.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xeroxparc.materialcomponentsdemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComponentRepository {

    private List<String> componentNameList;

    //Removing the Application dependency increase complexity but allow unit testing.
    //Should we use Dagger for a small project?
    public ComponentRepository(@NonNull Application application) {
        componentNameList = Arrays.asList(application.getResources().getStringArray(R.array.component));
    }

    public LiveData<List<MaterialComponent>> getAllComponentList() {
        List<MaterialComponent> listComponent = new ArrayList<>();
        MaterialComponent component;
        for (String componentName : componentNameList) {
            component = new MaterialComponent();
            component.setName(componentName);
            listComponent.add(component);
        }
        return new MutableLiveData<>(listComponent);
    }

    public LiveData<List<MaterialComponent>> getComponentListByName(String name) {
        List<MaterialComponent> listComponent = new ArrayList<>();
        MaterialComponent component;
        for (String componentName : componentNameList) {
            if (componentName.toLowerCase().contains(name.toLowerCase())) {
                component = new MaterialComponent();
                component.setName(componentName);
                listComponent.add(component);
            }
        }
        return new MutableLiveData<>(listComponent);
    }

}
