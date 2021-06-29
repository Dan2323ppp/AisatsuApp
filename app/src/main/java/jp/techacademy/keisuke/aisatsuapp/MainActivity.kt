package jp.techacademy.keisuke.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log  // ← ここを追加
import android.view.View  // ← ここを追加
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button1に意味をもたせている
        button1.setOnClickListener(this)


    }

    override fun onClick(v: View) {    //ボタンをクリックした時
        //button1をクリックした時の動作
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }


    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")

                    //OnTimeSetListenerの引数を使うのでこの中で
                    if(hour<=9 && hour>=2) {
                        textView.text = "おはよう"
                    }else if(hour<=17 && hour>=10) {
                        textView.text = "こんにちは"
                    }else if(hour<=1 || hour>=18) {
                        textView.text = "こんばんは"
                    }
                },
                //初期値
                13, 0, true)
        timePickerDialog.show()



    }
    //もし時刻が7:00なら「おはよう」とtextviewに表示

}