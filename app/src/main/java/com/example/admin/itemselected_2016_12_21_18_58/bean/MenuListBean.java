package com.example.admin.itemselected_2016_12_21_18_58.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/12/23 11:05 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/12/23 11:05 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class MenuListBean implements Serializable, Parcelable{

    List<MenuList> menuList;

    protected MenuListBean(Parcel in) {
        menuList = in.createTypedArrayList(MenuList.CREATOR);
    }

    public static final Creator<MenuListBean> CREATOR = new Creator<MenuListBean>() {
        @Override
        public MenuListBean createFromParcel(Parcel in) {
            return new MenuListBean(in);
        }

        @Override
        public MenuListBean[] newArray(int size) {
            return new MenuListBean[size];
        }
    };

    public List<MenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuList> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(menuList);
    }

    @Override
    public String toString() {
        return "MenuListBean{" +
                "menuList=" + menuList +
                '}';
    }

    public static class MenuList implements Serializable, Parcelable{

        String menuName;
        List<MenuList> menuList;

        @Override
        public String toString() {
            return "MenuList{" +
                    "menuName='" + menuName + '\'' +
                    ", menuList=" + menuList +
                    '}';
        }

        protected MenuList(Parcel in) {
            menuList = in.createTypedArrayList(MenuList.CREATOR);
        }

        public MenuList(String menuName, List<MenuList> menuList) {
            this.menuName = menuName;
            this.menuList = menuList;
        }

        public static final Creator<MenuList> CREATOR = new Creator<MenuList>() {
            @Override
            public MenuList createFromParcel(Parcel in) {
                return new MenuList(in);
            }

            @Override
            public MenuList[] newArray(int size) {
                return new MenuList[size];
            }
        };

        public List<MenuList> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<MenuList> menuList) {
            this.menuList = menuList;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(menuList);
        }
    }
}
