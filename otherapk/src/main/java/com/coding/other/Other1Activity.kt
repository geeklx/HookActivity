package com.coding.other


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.coding.plugin.PluginActivity
import com.lxj.xpopup.XPopup


class Other1Activity : PluginActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_other1
    }

    override fun onContinueCreate(savedInstanceState: Bundle?) {
        val btn = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            startActivity(Intent(this, Other2Activity::class.java))
        }
        btn2.setOnClickListener {
            //在中间弹出的List列表弹窗，带选中效果
            XPopup.Builder(this)
                .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                .asCenterList(
                    "请选择一项", arrayOf("条目1", "条目2", "条目3", "条目4"),
                    null, 1
                ) { position, text ->
                    Toast.makeText(this, "click $text", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}