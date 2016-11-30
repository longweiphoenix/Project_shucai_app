package com.example.first.project.utils;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 百度的倒计时工具类
 * Created by Administrator on 2016/11/0028.
 */

public class TimerUtil extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    private Button button;
    public TimerUtil(Button button,long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.button = button;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        button.setText(millisUntilFinished/1000+"秒后重新验证");
        button.setClickable(false);
    }

    @Override
    public void onFinish() {
        button.setText("重新验证");
        button.setClickable(true);
    }
}
