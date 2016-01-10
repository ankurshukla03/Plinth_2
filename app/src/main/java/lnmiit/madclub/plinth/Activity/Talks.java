package lnmiit.madclub.plinth.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Adapter.GridAdapter;
import lnmiit.madclub.plinth.Adapter.TalkAdapter;
import lnmiit.madclub.plinth.Model.ModelTalks;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/10/2016.
 */
public class Talks extends AppCompatActivity {

    public static final ArrayList<ModelTalks> modelTalksArrayList = new ArrayList<>();
    public static int[] talk_image = {R.drawable.s1,R.drawable.sx,R.drawable.s3,R.drawable.s4};
    public static String[] talk_name = {"Dr. K. Kasturirangan","Ashwin Sanghi","Amisha Sethi","Dr. Sankar K. Pal"};
    public static String[] designation = {"Ex-Chairman ISRO (Padmavibhushan)","Best-Selling Author (Chanakya's Chant)","Author | CMO"
    ,"Ex-Director ISI"};
    public static String[] talks_fb = {"https://www.facebook.com/pages/Krishnaswamy-Kasturirangan/112031638816057?fref=ts",
            "https://www.facebook.com/ashwinsanghi?fref=ts",
            "",
            ""};
    public static String[] talks_twitter = {"","https://twitter.com/ashwinsanghi","",""};
    public static String[] talks_linkedin = {"","https://www.linkedin.com/in/ashwinsanghi","",""};
    public static String[] talks_wiki = {"https://en.wikipedia.org/wiki/Krishnaswamy_Kasturirangan",
            "https://en.wikipedia.org/wiki/Ashwin_Sanghi","",""};
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);


        initialize();
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // The number of Columns
        mLayoutManager = new GridLayoutManager(Talks.this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // inflating the list
        mAdapter = new TalkAdapter(modelTalksArrayList,Talks.this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void initialize()
    {
        for(int i=0;i<talk_name.length;i++){
            ModelTalks modelTalks = new ModelTalks();
            modelTalks.name = talk_name[i];
            modelTalks.designation = designation[i];
            modelTalks.image = talk_image[i];
            modelTalks.fb_link = talks_fb[i];
            modelTalks.linked_link = talks_linkedin[i];
            modelTalks.wiki_link = talks_wiki[i];
            modelTalks.twitter_link = talks_twitter[i];
            modelTalksArrayList.add(modelTalks);
        }
    }

}
