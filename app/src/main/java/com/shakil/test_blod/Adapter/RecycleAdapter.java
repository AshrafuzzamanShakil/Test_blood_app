package com.shakil.test_blod.Adapter;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.shakil.test_blod.Retrofit.PostPojo;
import com.shakil.test_blod.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyView> {

    private List<PostPojo> datalist;
    private FragmentActivity context;





    public RecycleAdapter(FragmentActivity context, List<PostPojo> datalist){
        this.context=context;
        this.datalist=datalist;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View view= layoutInflater.inflate(R.layout.cardview1,viewGroup,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(MyView myView, int i) {
        myView.name.setText(datalist.get(i).getName());
        myView.blood_group.setText(datalist.get(i).getBloodgroup());
        myView.address.setText(datalist.get(i).getAddress());
        myView.phone_no.setText(datalist.get(i).getPhone());
        myView.hospital.setText(datalist.get(i).getHospital());
        myView.details.setText(datalist.get(i).getDiscription());
        try {
            if(datalist.get(i).getImage_url().toString().contentEquals("shakil"))
            {
                myView.image.setImageResource(R.drawable.image1);
            }
            else {
                Picasso.get().load(datalist.get(i).getImage_url().toString()).into(myView.image);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }


        myView.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (myView.expandable.getVisibility()==View.GONE)
                {
                    TransitionManager.beginDelayedTransition(myView.cardView,new AutoTransition());
                    myView.expandable.setVisibility(View.VISIBLE);
                }
                else
                {
                    TransitionManager.beginDelayedTransition(myView.cardView,new AutoTransition());
                    myView.expandable.setVisibility(View.GONE);
                }


            }
        });



    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MyView extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,blood_group,address,hospital,details,phone_no ;
        LinearLayout linearLayout,expandable;
        CardView cardView;

        public MyView(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.card1_imag_1_id);
            name=itemView.findViewById(R.id.card1_text1_id);
            blood_group=itemView.findViewById(R.id.card1_text2_id);
            address=itemView.findViewById(R.id.card1_text3_id);
            hospital=itemView.findViewById(R.id.card1_text4_id);
            details=itemView.findViewById(R.id.details1_id);
            phone_no=itemView.findViewById(R.id.card1_phone_1_id);
            linearLayout=itemView.findViewById(R.id.parent_layout_id);
            expandable=itemView.findViewById(R.id.expandable_layout_id);
            cardView=itemView.findViewById(R.id.card_view_id);


        }
    }
}
