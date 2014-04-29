package com.moodwonder.fi;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MoodWonderHome extends TabActivity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moodwonder_home);
 
		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
				// Company tab
				Intent intentCompany = new Intent().setClass(this, MoodWonderMyCompany.class);
				TabSpec tabSpecCompany = tabHost
				  .newTabSpec("Company")
				  .setIndicator("", ressources.getDrawable(R.drawable.icon_mycompany))
				  .setContent(intentCompany);
				
				// Ranking tab
				Intent intentRanking = new Intent().setClass(this, MoodWonderMyRanking.class);
				TabSpec tabSpecRanking = tabHost
				  .newTabSpec("Ranking")
				  .setIndicator("", ressources.getDrawable(R.drawable.icon_myranking))
				  .setContent(intentRanking);
				
				// MyMood tab
				Intent intentMood = new Intent().setClass(this, MoodWonderMyMood.class);
				TabSpec tabSpecMood = tabHost
				  .newTabSpec("Ranking")
				  .setIndicator("", ressources.getDrawable(R.drawable.icon_mymood))
				  .setContent(intentMood);
				
				
				
				// add all tabs 
				tabHost.addTab(tabSpecCompany);
				tabHost.addTab(tabSpecRanking);
				tabHost.addTab(tabSpecMood);
				
				
	}		
}
