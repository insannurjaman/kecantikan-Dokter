package com.example.dokterapps.mainscreen.home;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.home.patienlist.PatientListFragment;
import com.example.dokterapps.mainscreen.home.penanganan.PenangananFragment;
import com.example.dokterapps.mainscreen.home.suspendlist.SuspendListFragment;

import java.util.Random;


public class HomeFragment extends Fragment {
    ImageView imgTime;
    private View view;
    CardView cvPatient, cvSuspend;
    Random random;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgTime =  view.findViewById(R.id.img_time);
        cvPatient = view.findViewById(R.id.cv_patient);
        cvSuspend = view.findViewById(R.id.cv_suspend);
        cvPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Terklik", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Terklik", Toast.LENGTH_SHORT).show();
                FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new PatientListFragment();
                t.replace(R.id.container_home, mFrag);
                t.commit();
            }
        });

        cvSuspend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Terklik", Toast.LENGTH_SHORT).show();
                FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new SuspendListFragment();
                t.replace(R.id.container_home, mFrag);
                t.commit();

            }
        });

        RotateAnimation rotateAnimation = new RotateAnimation(
                0,360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        imgTime.startAnimation(rotateAnimation);
        final TextView counttime = view.findViewById(R.id.tv_countTime);


        new CountDownTimer(6000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                    showApakahPatientSudahHadir();
                //showRepeatCallandNextCall();
            }
        }.start();
    }

    private void showApakahPatientSudahHadir(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_kehadiraan_patient, null);
        dialog.setContentView(view);

        final CardView no = view.findViewById(R.id.cv_tidak_hadir);
        final CardView yes = view.findViewById(R.id.cv_hadir);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new PenangananFragment();
                t.replace(R.id.container_home, mFrag);
                t.commit();
                dialog.dismiss();

            }
        });

        dialog.show();


    }
    private void showRepeatCallandNextCall() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_calling_patient, null);
        dialog.setContentView(view);

        final CardView nextCall = view.findViewById(R.id.cv_nextCall);
        final CardView repeatCall = view.findViewById(R.id.cv_repeatCall);

        repeatCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new HomeFragment();
                t.replace(R.id.container_home, mFrag);
                t.commit();
                dialog.dismiss();
            }
        });

        nextCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doing next call here
                dialog.dismiss();
            }
        });



        /*exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/
        dialog.show();
    }







    }
