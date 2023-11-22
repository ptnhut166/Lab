package com.example.animation;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.os.Bundle;
import android.widget.Toast;
import android.os.Handler;





public class MainActivity extends AppCompatActivity {
    public Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode, btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml, btnZoomOutCode, btnRotateXml, btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode, btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    public ImageView ivUitLogo;
    public Animation.AnimationListener animationListener;
    public   Animation initAnimation(){
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return  animation;
    }
    private void startFadeOutAnimation() {
        final Animation fadeOutAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_out);
        ivUitLogo.startAnimation(fadeOutAnimation);
    }
    public void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int SWIPE_THRESHOLD = 100; // Ngưỡng để xác định cử chỉ swipe
        float startX = 0;
        float endX;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getX();
                float deltaX = endX - startX;

                if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
                    // Xử lý swipe từ trái sang phải
                    if (endX > startX) {
                        startFadeOutAnimation();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                                startActivity(intent);

                                overridePendingTransition(R.anim.anim_enter,R.anim.anim_leave );
                            }
                        }, 1000); // Đợi 1 giây trước khi kết thúc MainActivity
                        return true;
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void handleClickAnimationXml(Button btn, int animId)
    {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }

        });
    }
    private void handleClickAnimationCode(Button btn, final int animId) {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void startFadeInAnimation() {
        // Lấy animation từ XML
        final Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_in);

        // Sử dụng animation trên ivUitLogo (hoặc view bạn muốn áp dụng animation)
        ivUitLogo.startAnimation(fadeInAnimation);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();
        startFadeInAnimation();
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);
        handleClickAnimationCode(btnFadeInCode,R.anim.anim_fade_in);
        handleClickAnimationCode(btnFadeOutCode, R.anim.anim_fade_out);
        handleClickAnimationCode(btnBlinkCode, R.anim.anim_blink);
        handleClickAnimationCode(btnZoomInCode, R.anim.anim_zoom_in);
        handleClickAnimationCode(btnZoomOutCode, R.anim.anim_zoom_out);
        handleClickAnimationCode(btnRotateCode, R.anim.anim_rotate);
        handleClickAnimationCode(btnMoveCode, R.anim.anim_move);
        handleClickAnimationCode(btnSlideUpCode, R.anim.anim_slide_up);
        handleClickAnimationCode(btnBounceCode, R.anim.anim_bounce);
        handleClickAnimationCode(btnCombineCode, R.anim.anim_combine);



    }
}