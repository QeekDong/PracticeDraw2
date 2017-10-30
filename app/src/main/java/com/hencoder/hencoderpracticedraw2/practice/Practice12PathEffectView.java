package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        PathEffect pathEffect = new CornerPathEffect(10);
        paint.setPathEffect(pathEffect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        PathEffect pathEffect1 = new DiscretePathEffect(20, 5);
        paint.setPathEffect(pathEffect1);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        PathEffect pathEffect2 = new DashPathEffect(new float[]{20,10,5,3}, 0);
        paint.setPathEffect(pathEffect2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path dashPath = new Path();
        dashPath.addRect(10, 10, 20, 20, Path.Direction.CW);
        PathEffect pathEffect3 = new PathDashPathEffect(dashPath, 40, 0, PathDashPathEffect.Style.TRANSLATE);
        paint.setPathEffect(pathEffect3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect pathEffect4 = new DashPathEffect(new float[]{10, 5}, 0);
        PathEffect pathEffect5 = new DiscretePathEffect(20, 10);
        PathEffect pathEffect6 = new SumPathEffect(pathEffect4, pathEffect5);
        paint.setPathEffect(pathEffect6);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        PathEffect pathEffect7 = new DashPathEffect(new float[]{10, 5}, 0);
        PathEffect pathEffect8 = new DiscretePathEffect(20, 10);
        PathEffect pathEffect9 = new ComposePathEffect(pathEffect7, pathEffect8);
        paint.setPathEffect(pathEffect9);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
