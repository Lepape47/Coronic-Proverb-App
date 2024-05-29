package com.example.coranicproverb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomePage extends Activity {
    private ListView listView,catView;
    private ImageButton backButton;
    private Button moreButton;
    private LinearLayout proverbHolder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
//        backButton = findViewById(R.id.map_item_back_btn);
        listView = findViewById(R.id.proverb);
        ArrayList<Proverb> data = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            data.add(new Proverb("text"+i,"test1"+i));
//        }
        data.add(new Proverb("Sourate 15 (Al-Hijr), versets 87-88*",
                "« Nous t'avons certes donné «les sept versets que l'on répète», ainsi que le Coran sublime.\n" +
                "Ne regarde surtout pas avec envie les choses dont Nous avons donné jouissance temporaire à certains couples d'entre eux, ne t'afflige pas à leur sujet et abaisse ton aile pour les croyants."));
        
                data.add(new Proverb("Sourate 16 (Les abeilles, An-Nahl), verset 78",
"Et Allah vous a fait sortir des ventres de vos mères, dénués de tout savoir, et vous a donné l'ouïe, les yeux et les cœurs (l'intelligence), afin que vous soyez reconnaissants."));


data.add(new Proverb("Sourate 4 (Les femmes, An-Nisa), verset 32",
"Ne convoitez pas ce qu'Allah a attribué aux uns d'entre vous plus qu'aux autres ; aux hommes la part qu'ils ont acquise, et aux femmes la part qu'elles ont acquise. Demandez à Allah de Sa grâce. Car Allah, certes, est Omniscient."));


data.add(new Proverb("Sourate 2 (La vache, Al-Baqarah), verset 286",
"Allah n'impose à aucune âme une charge supérieure à sa capacité. Elle sera récompensée du bien qu'elle aura fait, punie du mal qu'elle aura fait. Seigneur, ne nous châtie pas s'il nous arrive d'oublier ou de commettre une erreur. Seigneur ! Ne nous charge pas d'un fardeau lourd comme Tu as chargé ceux qui vécurent avant nous. Seigneur ! Ne nous impose pas ce que nous ne pouvons supporter, efface nos fautes, pardonne-nous et fais nous miséricorde. Tu es Notre Maître, accorde-nous donc la victoire sur les peuples infidèles"));

data.add(new Proverb("Sourate 6 (Les bestiaux, Al-An'am), verset 160",
"Quiconque viendra avec le bien aura dix fois autant; et quiconque viendra avec le mal ne sera rétribué que par son équivalent. Et on ne leur fera aucune injustice."));


data.add(new Proverb("Sourate 17 (Le voyage nocturne, Al-Isra), versets19-20",
"Et ceux qui recherchent l'au-delà et fournissent les efforts qui y mènent, tout en étant croyants... alors l'effort de ceux-là sera reconnu. Nous accordons abondamment à tous, ceux-ci comme ceux-là, des dons de ton Seigneur. Et les dons de ton Seigneur ne sont refusés [à personne]."));
    
        proverbHolder = findViewById(R.id.proverb_holder);
        proverbHolder.setVisibility(View.GONE );

        proverbHolder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                proverbHolder.setVisibility(View.GONE );

            }
        });
        MyAdapterProverb adapter = new MyAdapterProverb(this, data);
        listView.setAdapter(adapter);
    }
    class Proverb {
        String name;
        String desc;

        public Proverb(String name,String desc ) {
            this.name = name;
            this.desc = desc;
        }
    }
    class MyAdapterProverb extends ArrayAdapter<Proverb> {
    private final Context context;
    private final ArrayList<Proverb> data;
    HashMap<Integer, Boolean> isMenuOpen = new HashMap<>();

//    private final ArrayList<openMenu> isMenuOpen = new ArrayList<>();
        class openMenu {
            int postion;
            boolean status;

            public openMenu(int postion,boolean status ) {
                this.postion = postion;
                this.status = status;
            }
        }
        //    private boolean isMenuOpen = false;
    public MyAdapterProverb(Context context, ArrayList<Proverb> data) {
        super(context, R.layout.proverb_fragment, data);
        this.context = context;
        this.data = data;
        // Initialize isMenuOpen to false initially, assuming all holders are hidden
        for (int i = 0; i < data.size(); i++) {
            isMenuOpen.put(i, false);
        }
    }

        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Inflate the item_card layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.proverb_fragment, parent, false);
            // Get the TextView and ImageView and basic items
            TextView textView = view.findViewById(R.id.proverb_name);
            textView.setText(data.get(position).name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    View viewHome = inflater.inflate(R.layout.home_fragment, parent, false);
                    TextView textView2 = findViewById(R.id.proverb_title);
                    textView2.setText(data.get(position).name);
                    TextView textView3 = findViewById(R.id.proverb_text);
                    textView3.setText(data.get(position).desc);
                    LinearLayout proverbHolder = findViewById(R.id.proverb_holder);
                    proverbHolder.setVisibility(View.VISIBLE );
                }
            });
            return view;
        }
    }

}
