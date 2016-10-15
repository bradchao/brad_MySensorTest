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
    private float viewW, viewH;
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

        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawCircle(viewW/2,viewH/2,40,paintBall);
        canvas.drawLine(viewW/2,0,viewW/2,viewH, paintV);
        canvas.drawLine(0,viewH/2,viewW,viewH/2, paintH);
    }
}
