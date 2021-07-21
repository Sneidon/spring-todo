package za.co.mukondle.models;

import za.co.mukondle.enums.Type;

import javax.validation.Valid;
import java.util.ArrayList;

public class TypeListViewModel {
    @Valid
    private ArrayList<String> types = new ArrayList<String>();

    public TypeListViewModel() {}

    public TypeListViewModel(ArrayList<String> types) {
        this.types = types;
    }

    public void addType(Type type) {
        types.add(type.toString());
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }
}
