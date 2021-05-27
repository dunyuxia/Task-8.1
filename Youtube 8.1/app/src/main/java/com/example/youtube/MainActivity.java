package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
	private EditText url;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		url = findViewById(R.id.url);
	}

	public void onPlay(View view)
	{
		if (!url.getText().toString().isEmpty())
		{
			Intent intent = new Intent(this, YoutubeActivity.class);
			intent.putExtra("Url", url.getText().toString());
			startActivity(intent);
		}
	}
}