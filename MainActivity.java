package com.example.abc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{
    private AdView mAdView;
    public String Input;
    public search search = new search();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

public void onBtnClick (View view)
{
        TextInputEditText tbInput = findViewById(R.id.tbInputQuote);
        TextView txtInput = findViewById(R.id.txtInput);
        Button btnFind = findViewById(R.id.btnFInd);
        btnFind.onEditorAction(EditorInfo.IME_ACTION_DONE);


        Input = tbInput.getText().toString();
        Input = search.removePunctuation(Input);
        search.setInput(Input);

        String episode1 = search.episodeContains1();
         episode1 += search.episodeContains2();
         episode1 += search.episodeContains3();
         episode1 += search.episodeContains4();
         episode1 += search.episodeContains5();
         episode1 += search.episodeContains6();
         episode1 += search.episodeContains7();
         episode1 += search.episodeContains8();
         episode1 += search.episodeContains9();
         
    if( episode1 == "")
        {
            episode1 = "Hmm... We could not find what you were looking for try again";
        }

            if (Input.length() < 2)
            {

            }
            else {
                txtInput.setText(episode1);
                txtInput.setVisibility(View.VISIBLE);
            }
    }
}
