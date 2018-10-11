package com.example.schne.dotsnlines;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
	TextView promptView;
	NumberPicker numberPickerView;
	Button sizeButton;
	Button startButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		promptView = findViewById(R.id.prompt_text);
		numberPickerView = findViewById(R.id.num_picker);
		sizeButton = findViewById(R.id.choose_size_button);
		startButton = findViewById(R.id.start_game_button);
		
		promptView.animate()
				.translationY(100f)
				.setDuration(500)
				.start();
		
		numberPickerView.animate()
				.translationY(-100f)
				.setDuration(500)
				.start();
		
		startButton.animate()
				.translationY(-150f)
				.setDuration(500)
				.start();
		
		numberPickerView.setMaxValue(10);
		numberPickerView.setMinValue(5);
		numberPickerView.setWrapSelectorWheel(false);
		numberPickerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				return;
			}
		});
	}
	
	public void chooseBoardSize(View view) {
		view.animate()
				.translationY(100f)
				.alpha(0f)
				.setDuration(500)
				.setListener(new Animator.AnimatorListener() {
					@Override
					public void onAnimationStart(Animator animator) {
					
					}
					
					@Override
					public void onAnimationEnd(Animator animator) {
						promptView.animate()
								.translationY(-100f)
								.setDuration(500)
								.alpha(1f)
								.start();
						
						numberPickerView.animate()
								.translationY(100f)
								.setDuration(500)
								.alpha(1f)
								.start();
						
						startButton.animate()
								.translationY(150f)
								.setDuration(500)
								.alpha(1f)
								.start();
					}
					
					@Override
					public void onAnimationCancel(Animator animator) {
					
					}
					
					@Override
					public void onAnimationRepeat(Animator animator) {
					
					}
				})
				.start();
	}
	
	public void startGame(View view) {
		int boardSize = numberPickerView.getValue();
		final Intent intent = new Intent(getApplicationContext(), GameActivity.class);
		GameActivity.setBoardSize(boardSize);
		
		promptView.animate()
				.translationY(100f)
				.setDuration(500)
				.alpha(0f)
				.start();
		
		numberPickerView.animate()
				.translationY(-100f)
				.setDuration(500)
				.alpha(0f)
				.start();
		
		startButton.animate()
				.translationY(-150f)
				.setDuration(500)
				.alpha(0f)
				.setListener(new Animator.AnimatorListener() {
					@Override
					public void onAnimationStart(Animator animator) {
					
					}
					
					@Override
					public void onAnimationEnd(Animator animator) {
						startActivity(intent);
					}
					
					@Override
					public void onAnimationCancel(Animator animator) {
					
					}
					
					@Override
					public void onAnimationRepeat(Animator animator) {
					
					}
				})
				.start();
	}
}