package jp.techacademy.youichi.okami.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import jp.techacademy.youichi.okami.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = Intent(this, SecondActivity::class.java)

        // 各ボタンの処理実装
        // 共通化できそうだが研修早めにすすめたいので一旦下記方法ですすめる
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            var editTextVal = binding.editText.text.toString().toDoubleOrNull()
            var editTextVal2 = binding.editText2.text.toString().toDoubleOrNull()

            if (editTextVal != null && editTextVal2 != null) {
                editTextVal = binding.editText.text.toString().toDouble()
                editTextVal2 = binding.editText2.text.toString().toDouble()

                Log.d("UI_PARTS", editTextVal.toString())
                Log.d("UI_PARTS", editTextVal2.toString())

                intent.putExtra("VALUE1", editTextVal.plus(editTextVal2))
                startActivity(intent)
            } else {
                this.message(view)
            }
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            var editTextVal3 = binding.editText.text.toString().toDoubleOrNull()
            var editTextVal4 = binding.editText2.text.toString().toDoubleOrNull()

            if (editTextVal3 != null && editTextVal4 != null) {
                editTextVal3 = binding.editText.text.toString().toDouble()
                editTextVal4 = binding.editText2.text.toString().toDouble()
                intent.putExtra("VALUE1", editTextVal3.minus(editTextVal4))
                startActivity(intent)
            } else {
                this.message(view)
            }
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
            var editTextVal5 = binding.editText.text.toString().toDoubleOrNull()
            var editTextVal6 = binding.editText2.text.toString().toDoubleOrNull()

            if (editTextVal5 != null && editTextVal6 != null) {
                editTextVal5 = binding.editText.text.toString().toDouble()
                editTextVal6 = binding.editText2.text.toString().toDouble()
                intent.putExtra("VALUE1", editTextVal5.times(editTextVal6))
                startActivity(intent)
            } else {
                this.message(view)
            }
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            var editTextVal7 = binding.editText.text.toString().toDoubleOrNull()
            var editTextVal8 = binding.editText2.text.toString().toDoubleOrNull()

            if (editTextVal7 != null && editTextVal8 != null) {
                editTextVal7 = binding.editText.text.toString().toDouble()
                editTextVal8 = binding.editText2.text.toString().toDouble()
                intent.putExtra("VALUE1", editTextVal7.div(editTextVal8))
                startActivity(intent)
            } else {
                this.message(view)
            }
        }
    }

    private fun message(view : View) {
        Snackbar.make(view, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
            .setAction("Action") {
                Log.d("UI_PARTS", "数字を入力してください")
            }.show()
    }

    override fun onClick(v: View?) {
    }
}