package com.example.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
{
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youtube);

		YouTubePlayerView playerView = findViewById(R.id.youTubePlayer);

		Intent intent = getIntent();
		url = intent.getStringExtra("Url");

		if (url.contains("?v="))
			url = url.split("\\?v=")[1];

		playerView.initialize("AIzaSyD8FCXE_YF46gveu-uj9QDDAfE481LypUk", new YouTubePlayer.OnInitializedListener()
		{
			@Override
			public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
			{
				youTubePlayer.loadVideo(url);
			}

			@Override
			public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
			{}
		});
	}
}