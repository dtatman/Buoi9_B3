package com.example.buoi9_b3
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnShowDialog: Button
    private lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        btnShowDialog = findViewById(R.id.btnShowDialog)
        tvName = findViewById(R.id.tvName)

        // Xử lý sự kiện khi nhấn nút "Nhập tên"
        btnShowDialog.setOnClickListener {
            showCustomDialog()  // Hiển thị AlertDialog tùy chỉnh
        }
    }

    // Hàm hiển thị Custom AlertDialog
    private fun showCustomDialog() {
        // Tạo một LayoutInflater để lấy layout của custom dialog
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_input_name, null)

        // Tạo EditText trong custom dialog
        val edtName = dialogView.findViewById<EditText>(R.id.edtName)
        val btnSave = dialogView.findViewById<Button>(R.id.btnSave)
        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)

        // Tạo AlertDialog với layout tùy chỉnh
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)  // Thiết lập layout tùy chỉnh cho dialog

        val dialog = dialogBuilder.create()
        dialog.show()

        // Cài đặt sự kiện cho nút "Lưu"
        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                tvName.text = "Chào bạn, $name!"
            }
            dialog.dismiss()  // Đóng dialog sau khi lưu
        }

        // Cài đặt sự kiện cho nút "Hủy"
        btnCancel.setOnClickListener {
            dialog.dismiss()  // Đóng dialog nếu nhấn Hủy
        }
    }
}
