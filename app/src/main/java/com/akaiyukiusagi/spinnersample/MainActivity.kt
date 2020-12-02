package com.akaiyukiusagi.spinnersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
    }
}

// 出典：https://hirauchi-genta.com/kotlin-spinner/