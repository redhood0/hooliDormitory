package com.hooli.hooli.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hooli.hooli.R;
import com.hooli.hooli.R2;
import com.hooli.hooli.controller.Givefen_check;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import butterknife.Unbinder;


public class Fragment_givefraction_choose extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.btn_startGiveMark)
    Button btn_startGiveMark;//开始打分的按钮
    @BindView(R.id.spiner_select_building)
    Spinner spinner_select_building;//选择苑
    @BindView(R.id.spiner_select_floor)
    Spinner spinner_select_floor;//选择楼ceng的
    @BindView(R.id.et_getRoomNum)
    EditText et_getRoomNum;//选择房间号
    @BindView(R.id.text_getSelect)
    TextView textView_getSlect;//数据拼接

    String building = "";
    String floor = "";
    String room = "";
    String getSlect = "";



    public String getRoom() {//获得房间号 ：301
        return room;
    }

    public String getFloor() {//获得楼层号 ：A1
        return floor;
    }

    public String getGetSlect() {
        return getSlect;
    }

    public String getBuilding() {//获得苑 :雪松苑
        return building;
    }

    @OnItemSelected({R.id.spiner_select_building, R.id.spiner_select_floor})
    void onItemSelected(int position) {
        building = spinner_select_building.getSelectedItem().toString();
        floor = spinner_select_floor.getSelectedItem().toString();
        //updata
        getSlect = "当前选择楼号:  " + building + floor + room;

        textView_getSlect.setText(getSlect);
    }

    @OnTextChanged(R.id.et_getRoomNum)
    void onTextChange(CharSequence s, int start, int before, int count) {
        room = et_getRoomNum.getText().toString();
        getSlect = "当前选择楼号:  " + building + floor + room;
        textView_getSlect.setText("");
        textView_getSlect.setText(getSlect);
    }

    //·-·-··-·-·-··-·-点击打分-------------------
    @OnClick(R2.id.btn_startGiveMark)
    void showIntent() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), Givefen_check.class);
        getActivity().startActivity(intent);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_givefen_choose, null);


        //----绑定黄油刀-------------------------------------
        unbinder = ButterKnife.bind(this, view);
        //------------------------------------------------
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //---解绑黄油刀-----------
        unbinder.unbind();
        //------·-·-·-·-··-·-·-·-·-·--·
    }
}
