package com.example.hossam.al_matger.HomeActivity1.ViewModel;

import com.example.hossam.al_matger.HomeActivity1.Model.FooterModel;

public class FooterViewModel {

    String name1,name2,name3,name4;

    public FooterViewModel(FooterModel footerModel) {

        name1=footerModel.getName1();
        name2=footerModel.getName2();
        name3=footerModel.getName3();
        name4=footerModel.getName4();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }
}
