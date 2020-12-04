package com.akaiyukiusagi.spinnersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // 選択肢
    private val spinnerItems = arrayOf("ウッディ", "バズ", "ポテトヘッド", "スリンキー", "レックス")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapterの生成
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)

        // 選択肢の各項目のレイアウト
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // AdapterをSpinnerのAdapterとして設定
        spinner.adapter = adapter

        // onItemSelectedを書いた場所を指定
        spinner.onItemSelectedListener = this

        // 何番目の値がセットされているか
        showIndex.setOnClickListener{
            Toast.makeText(this, spinner.selectedItemPosition.toString(), Toast.LENGTH_SHORT).show()
        }
        // セットされている値
        showValue.setOnClickListener{
            Toast.makeText(this, spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    // アイテムが選択された時
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        textView.text = spinnerItems[pos]
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        textView.text = "これいつ動くのか不明"
    }

}
// 出典：https://hirauchi-genta.com/kotlin-spinner/
// 公式：https://developer.android.com/guide/topics/ui/controls/spinner?hl=ja