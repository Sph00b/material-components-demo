package com.xeroxparc.materialcomponentsdemo.ui.component.appbarbottom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityAppBarBottomBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class AppBarBottomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }
    class Holder {
        private ActivityAppBarBottomBinding binding;
        Holder(Activity activity) {
            binding = ActivityAppBarBottomBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.app_bar_bottom_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_appbarbottom);
            inflateSpanTextViewContent(binding, activity);
            binding.bottomAppBar.setNavigationOnClickListener(v -> Toast.makeText(activity, R.string.app_bar_bottom_press_more, Toast.LENGTH_LONG).show());
            binding.bottomAppBar.setOnMenuItemClickListener(v -> {
                if(v.getItemId()==R.id.more) {
                    Toast.makeText(activity, R.string.app_bar_bottom_press_more_information, Toast.LENGTH_LONG).show();
                }
                else if(v.getItemId()==R.id.search){
                    Toast.makeText(activity, R.string.app_bar_bottom_press_search, Toast.LENGTH_LONG).show();
                }
                return false;
            });
            binding.fab.setOnClickListener(l->{
                Toast.makeText(activity, R.string.app_bar_bottom_press_floating, Toast.LENGTH_LONG).show();
            });
        }
        View getRoot() {
            return binding.getRoot();
        }
    }
}

