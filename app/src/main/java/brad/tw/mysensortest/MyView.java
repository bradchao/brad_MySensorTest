package brad.tw.mysensortest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2016/10/15.
 */

public class MyView extends View {
    private float viewW, viewH, ballX, ballY, ballR;
    private boolean isInit;
    private Paint paintV, paintH, paintBall;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.BLACK);

        paintH = new Paint(); paintH.setColor(Color.RED);
        paintV = new Paint(); paintV.setColor(Color.GREEN);
        paintBall = new Paint(); paintBall.setColor(Color.YELLOW);

    }

    private void init(){
        viewW = getWidth(); viewH = getHeight();
        ballX = viewW / 2; ballY = viewH/2;
        ballR = viewW / 20;
        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawCircle(ballX,ballY,ballR,paintBall);
        canvas.drawLine(viewW/2,0,viewW/2,viewH, paintV);
        canvas.drawLine(0,viewH/2,viewW,viewH/2, paintH);
    }

    void setXY(float newx, float newy, float newz){
        ballX = newx*(viewW/19.8f) + viewW/2;
        ballY = newy*(viewH/19.8f)*-1 + viewH/2;
        ballR = (newz-9.8f)*8 + viewW/20;

        invalidate();
    }

}
