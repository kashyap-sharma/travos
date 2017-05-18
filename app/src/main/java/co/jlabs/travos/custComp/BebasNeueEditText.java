package co.jlabs.travos.custComp;

/**
 * Created by JLabs on 03/14/16.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import co.jlabs.travos.R;


public class BebasNeueEditText extends EditText {


    public BebasNeueEditText(Context context) {
        super(context);
        if(isInEditMode())
        {
            return;
        }
        Typeface tf = FontCache.get("fonts/SignaLightColumn.ttf", context);
        if(tf != null) {
            this.setTypeface(tf);
        }
    }

    public BebasNeueEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.textfontstyle, 0, 0);
        String font_name = a.getString(R.styleable.textfontstyle_fontname);
        a.recycle();
        if(font_name==null)
        {
            font_name="ll";
        }
        if(font_name.equals("ll"))
        {
            tf= FontCache.get("fonts/SignaLightColumn.ttf", context);
        }
        else if(font_name.equals("lb"))
        {
            tf= FontCache.get("fonts/SignaColumnBold.ttf", context);

        }
        else
        {
            tf= FontCache.get("fonts/SignaLightColumn.ttf", context);
        }

        if(tf != null) {
            this.setTypeface(tf);
        }
    }

    public BebasNeueEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface tf = FontCache.get("fonts/SignaLightColumn.ttf", context);
        if(tf != null) {
            this.setTypeface(tf);

        }
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }

}