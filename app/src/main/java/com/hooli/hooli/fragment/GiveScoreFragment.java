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
import com.hooli.hooli.activity.GiveScoreActivity;
import com.hooli.hooli.javabean.DayRecord4Transition;
import com.hooli.hooli.javabean.Dormitory4Transition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import butterknife.Unbinder;


public class GiveScoreFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.btn_startGiveMark)
    Button btn_startGiveMark;//开始打分的按钮
    @BindView(R.id.spinner_select_building)
    Spinner spinner_select_building;//选择苑
    @BindView(R.id.spinner_select_buildingNum)
    Spinner spinner_select_buildingNum;//选择楼层的
    @BindView(R.id.et_getRoomNum)
    EditText et_getRoomNum;//选择房间号
    @BindView(R.id.text_getSelect)
    TextView textView_getSlect;//数据拼接

    String building = "";
    String room = "";
    String buildingNum;
    String getSlect = "";
    Dormitory4Transition dormitory = new Dormitory4Transition();



    public String getRoom() {//获得房间号 ：301
        return room;
    }

    public String getBuildingNum() {//获得楼层号 ：A1
        return buildingNum;
    }

    public String getGetSlect() {
        return getSlect;
    }

    public String getBuilding() {//获得苑 :雪松苑
        return building;
    }


    //传出数据
    /*
     *building;
     *buildingNum;
     *dormitoryNum;
     */
    Dormitory4Transition transData(){
        dormitory.setBuilding(building);
        dormitory.setBuildingNum(buildingNum);
        dormitory.setDormitoryNum(room);
        return dormitory;
    }






    @OnItemSelected({R.id.spinner_select_building, R.id.spinner_select_buildingNum})
    void onItemSelected(int position) {
        building = spinner_select_building.getSelectedItem().toString();
        buildingNum = spinner_select_buildingNum.getSelectedItem().toString();
        //updata
        getSlect = "当前选择楼号:  " + building + buildingNum + room;
        textView_getSlect.setText(getSlect);
    }

    @OnTextChanged(R.id.et_getRoomNum)
    void onTextChange(CharSequence s, int start, int before, int count) {
        room = et_getRoomNum.getText().toString();
        getSlect = "当前选择楼号:  " + building + buildingNum + room;
        textView_getSlect.setText("");
        textView_getSlect.setText(getSlect);
    }

    //·-·-··-·-·-··-·-点击打分-------------------
    //todo 245254345354
    @OnClick(R2.id.btn_startGiveMark)
    void showIntent() {
        dormitory = transData();
        Intent intent = new Intent();
        intent.putExtra("buildData",dormitory);
        intent.setClass(getActivity(), GiveScoreActivity.class);
        getActivity().startActivity(intent);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_give_score, null);


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
